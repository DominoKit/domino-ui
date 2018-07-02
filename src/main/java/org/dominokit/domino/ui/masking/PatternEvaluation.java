package org.dominokit.domino.ui.masking;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class PatternEvaluation {
    private final Map<Character, PatternDefinition> definitions = new HashMap<>();
    private Deque<Character> patternDeque;
    private DisplayValue displayValue = new DisplayValue();
    private List<ValueChangeHandler> valueChangeHandlers = new ArrayList<>();


    public PatternEvaluation(String pattern) {
        this(pattern, new ArrayList<>());
    }

    public PatternEvaluation(String pattern, List<PatternDefinition> patternDefinitions) {
        patternDeque = asDescendingDeque(pattern);
        initDefinitions(patternDefinitions);
        initDisplayValue();
    }

    private void initDefinitions(List<PatternDefinition> patternDefinitions) {
        addPredefinedDefinitions();
        for (PatternDefinition definition : patternDefinitions) {
            definitions.put(definition.keyChar(), definition);
        }
    }

    public static Builder pattern(String pattern) {
        return new Builder(pattern);
    }

    private void initDisplayValue() {
        DisplayCharType type;
        boolean optional = false;
        boolean shouldBeAppended = false;
        for (Character c : patternDeque) {
            if (c == '[' || c == ']') {
                optional = !optional;
                continue;
            }
            if (c == '{' || c == '}') {
                shouldBeAppended = !shouldBeAppended;
                continue;
            }
            if (c == '`')
                type = DisplayCharType.HIDDEN;
            else if (optional)
                type = DisplayCharType.OPTIONAL;
            else if (shouldBeAppended)
                type = DisplayCharType.INCLUDE_IN_VALUE;
            else if (hasDefinition(c))
                type = DisplayCharType.REQUIRED;
            else
                type = DisplayCharType.FIXED;
            displayValue.addChar(c, type);
        }
    }

    private Deque<Character> asDescendingDeque(String value) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = value.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--)
            deque.push(chars[i]);
        return deque;
    }

    private void addPredefinedDefinitions() {
        addDefinition(PatternDefinition.ALPHABETICAL);
        addDefinition(PatternDefinition.ALPHANUMERIC);
        addDefinition(PatternDefinition.NUMERICAL);
    }

    public String getDisplayValue() {
        return displayValue.toString();
    }

    private boolean hasDefinition(char c) {
        return definitions.containsKey(c);
    }

    public List<PatternDefinition> getPatternDefinitions() {
        return new ArrayList<>(definitions.values());
    }

    public PatternEvaluation inputAt(String input, int startIndex) {
        displayValue.insertInputAt(input, startIndex);
        callChangeHandlers();
        return this;
    }

    public PatternEvaluation input(char c, int startIndex) {
        return inputAt(String.valueOf(c), startIndex);
    }

    public PatternEvaluation input(String input) {
        displayValue.insertInputAt(input);
        callChangeHandlers();
        return this;
    }

    public PatternEvaluation input(char c) {
        return input(String.valueOf(c));
    }

    private PatternDefinition getDefinition(char c) {
        return definitions.get(c);
    }

    public String getUnMaskedValue() {
        return displayValue.getUnMaskedValue();
    }

    public PatternEvaluation backspace() {
        return deleteAt(displayValue.getLastUndeletedInputIndex());
    }

    public PatternEvaluation deleteAt(int index) {
        displayValue.deleteAt(index);
        callChangeHandlers();
        return this;
    }

    public PatternEvaluation addValueChangeListener(ValueChangeHandler valueChangeHandler) {
        valueChangeHandlers.add(valueChangeHandler);
        return this;
    }

    private void callChangeHandlers() {
        valueChangeHandlers.forEach(ValueChangeHandler::onValueChanged);
    }

    public PatternEvaluation setPlaceholderChar(char placeholderChar) {
        displayValue.setPlaceholderChar(placeholderChar);
        return this;
    }

    public void addDefinition(PatternDefinition definition) {
        definitions.put(definition.keyChar(), definition);
    }

    public final static class Builder {
        private String pattern;
        private List<PatternDefinition> patternDefinitions = new ArrayList<>();

        public Builder(String pattern) {
            this.pattern = pattern;
        }

        public Builder addDefinition(PatternDefinition definition) {
            patternDefinitions.add(definition);
            return this;
        }

        public PatternEvaluation build() {
            return new PatternEvaluation(pattern, patternDefinitions);
        }
    }

    private class DisplayValue {
        private List<DisplayChar> displayChars = new LinkedList<>();
        private SortedMap<Integer, InputChar> inputChars = new TreeMap<>(Integer::compareTo);
        private char placeholderChar = '_';

        private void addChar(char c, DisplayCharType type) {
            displayChars.add(new DisplayChar(c, type));
            if (DisplayCharType.INCLUDE_IN_VALUE.equals(type)) {
                inputChars.put(displayChars.size() - 1, new InputChar(c, displayChars.size() - 1));
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < displayChars.size(); i++) {
                DisplayChar displayChar = displayChars.get(i);
                if (displayChar.isFixed())
                    stringBuilder.append(displayChar.c);
                else {
                    if (!displayChar.isHidden()) {
                        if (displayChar.isOptional() && !hasDefinition(displayChar.c)) {
                            stringBuilder.append(displayChar.c);
                        } else if (inputChars.containsKey(i) && !inputChars.get(i).isDeleted())
                            stringBuilder.append(inputChars.get(i).c);
                        else if (displayChar.isRequired()) {
                            stringBuilder.append(placeholderChar);
                        }
                    }
                }
            }
            return stringBuilder.toString();
        }

        public void deleteAt(int index) {
            if (index >= 0 && index < displayChars.size()) {
                if (inputChars.containsKey(index)) {
                    inputChars.remove(index);
                    shiftInputTo(index);
                }
            }
        }

        private void shiftInputTo(int index) {
            Map.Entry<Integer, InputChar> entry = nextInputCharEntry(index);
            if (entry != null) {
                DisplayChar displayChar = displayChars.get(index);
                if (displayChars.get(entry.getKey() - 1).c != '`' && getDefinition(displayChar.c).isMatch(entry.getValue().c)) {
                    int newIndex = entry.getKey();
                    entry.getValue().index = index;
                    inputChars.put(index, entry.getValue());
                    inputChars.remove(newIndex);
                    shiftInputTo(newIndex);
                }
            }
        }

        private Map.Entry<Integer, InputChar> nextInputCharEntry(int index) {
            for (Map.Entry<Integer, InputChar> entry : inputChars.entrySet()) {
                if (entry.getKey() > index)
                    return entry;
            }
            return null;
        }

        public boolean insertInputAt(char c, int index) {
            if (index >= 0 && index < displayChars.size()) {
                DisplayChar displayChar = displayChars.get(index);
                if (!displayChar.isFixed() && !displayChar.isHidden() && !inputChars.containsKey(index)) {
                    if (hasDefinition(displayChar.c) && getDefinition(displayChar.c).isMatch(c)) {
                        inputChars.put(index, new InputChar(c, index));
                        return true;
                    } else {
                        return displayChar.isRequired();
                    }
                }
            }
            return false;
        }

        public void insertInputAt(String input, int index) {
            char[] chars = input.toCharArray();
            for (char c : chars) {
                while (!insertInputAt(c, index) && index >= 0 && index < displayChars.size()) {
                    Map.Entry<Integer, InputChar> nextEntry = nextInputCharEntry(index);
                    if (nextEntry != null)
                        index = nextEntry.getKey();
                    else
                        index++;
                }
                index = getLastInputIndex(index);
            }
        }

        public void insertInputAt(String input) {
            Integer index = inputChars.keySet().stream().max(Integer::compareTo).orElse(0);
            insertInputAt(input, getLastInputIndex(index));
        }

        public int getLastInputIndex(int index) {
            if (index >= 0) {
                for (int i = index; i < displayChars.size(); i++) {
                    DisplayChar displayChar = displayChars.get(i);
                    if (displayChar.isHidden())
                        continue;
                    if (displayChar.isOptional() && !hasDefinition(displayChar.c)) {
                        continue;
                    }
                    if (!displayChar.isFixed() && !inputChars.containsKey(i)) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public String getUnMaskedValue() {
            return inputChars.values().stream()
                    .filter(inputChar -> !inputChar.isDeleted())
                    .map(inputChar -> inputChar.c)
                    .map(String::valueOf)
                    .collect(joining());
        }

        private int getLastUndeletedInputIndex() {
            return inputChars.entrySet().stream()
                    .filter(entry -> !entry.getValue().isDeleted())
                    .map(Map.Entry::getKey)
                    .max(Integer::compareTo)
                    .orElse(-1);
        }

        public void setPlaceholderChar(char placeholderChar) {
            this.placeholderChar = placeholderChar;
        }
    }

    private class DisplayChar {
        private DisplayCharType type;
        private char c;

        public DisplayChar(char c, DisplayCharType type) {
            this.c = c;
            this.type = type;
        }

        private boolean isOptional() {
            return DisplayCharType.OPTIONAL.equals(type);
        }

        public boolean isFixed() {
            return DisplayCharType.FIXED.equals(type);
        }

        public boolean isRequired() {
            return DisplayCharType.REQUIRED.equals(type);
        }

        @Override
        public String toString() {
            return "DisplayChar{" +
                    "type=" + type +
                    ", c=" + c +
                    '}';
        }

        public boolean isHidden() {
            return DisplayCharType.HIDDEN.equals(type);
        }
    }

    private class InputChar {
        private char c;
        private int index;
        private boolean deleted;

        public InputChar(char c, int index) {
            this.c = c;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InputChar inputChar = (InputChar) o;
            return c == inputChar.c &&
                    index == inputChar.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, index);
        }

        @Override
        public String toString() {
            return "InputChar{" +
                    "c=" + c +
                    ", index=" + index +
                    '}';
        }

        public boolean isDeleted() {
            return deleted;
        }
    }

    private enum DisplayCharType {
        FIXED, OPTIONAL, INCLUDE_IN_VALUE, HIDDEN, REQUIRED
    }

    @FunctionalInterface
    public interface ValueChangeHandler {
        void onValueChanged();
    }
}
