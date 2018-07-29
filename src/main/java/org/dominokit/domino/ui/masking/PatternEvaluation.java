package org.dominokit.domino.ui.masking;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class PatternEvaluation {
    private static final char START_OPTIONAL_CHAR = '[';
    private static final char END_OPTIONAL_PART = ']';
    private static final char START_INCLUDED_PART = '{';
    private static final char END_INCLUDED_PART = '}';
    private static final char PREVENT_SHIFT = '`';

    private final Map<Character, PatternDefinition> definitions = new HashMap<>();
    private final String pattern;
    private final List<DisplayChar> displayChars = new LinkedList<>();
    private final SortedMap<Integer, InputChar> inputChars = new TreeMap<>(Integer::compareTo);
    private char placeholderChar = '_';
    private final List<ValueChangeHandler> valueChangeHandlers = new ArrayList<>();
    private int numberOfRightMoves;
    private int numberOfLeftMoves;

    private int corspondingInputIndex;


    public static Builder pattern(String pattern) {
        return new Builder(pattern);
    }

    public PatternEvaluation(String pattern) {
        this(pattern, new ArrayList<>());
    }

    public PatternEvaluation(String pattern, List<PatternDefinition> patternDefinitions) {
        this.pattern = pattern;
        initDefinitions(patternDefinitions);
        initDisplayValue();
    }

    private void initDefinitions(List<PatternDefinition> patternDefinitions) {
        addPredefinedDefinitions();
        for (PatternDefinition definition : patternDefinitions) {
            definitions.put(definition.keyChar(), definition);
        }
    }

    private void initDisplayValue() {
        DisplayCharType type;
        boolean optional = false;
        boolean shouldBeAppended = false;
        for (Character c : pattern.toCharArray()) {
            if (c == START_OPTIONAL_CHAR || c == END_OPTIONAL_PART) {
                optional = !optional;
                continue;
            }
            if (c == START_INCLUDED_PART || c == END_INCLUDED_PART) {
                shouldBeAppended = !shouldBeAppended;
                continue;
            }
            if (c == PREVENT_SHIFT)
                type = DisplayCharType.HIDDEN;
            else if (optional)
                type = DisplayCharType.OPTIONAL;
            else if (shouldBeAppended)
                type = DisplayCharType.INCLUDE_IN_VALUE;
            else if (hasDefinition(c))
                type = DisplayCharType.REQUIRED;
            else
                type = DisplayCharType.FIXED;
            displayChars.add(new DisplayChar(c, type));
            if (DisplayCharType.INCLUDE_IN_VALUE.equals(type)) {
                inputChars.put(displayChars.size() - 1, new InputChar(c, displayChars.size() - 1, InputCharType.INCLUDE_IN_VALUE));
            }
        }
    }

    private void addPredefinedDefinitions() {
        addDefinition(PatternDefinition.ALPHABETICAL);
        addDefinition(PatternDefinition.ALPHANUMERIC);
        addDefinition(PatternDefinition.NUMERICAL);
    }

    public String getDisplayValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < displayChars.size(); i++) {
            DisplayChar displayChar = displayChars.get(i);
            if (displayChar.isFixed())
                stringBuilder.append(displayChar.c);
            else {
                if (!displayChar.isHidden()) {
                    if (displayChar.isOptional() && !hasDefinition(displayChar.c)) {
                        stringBuilder.append(displayChar.c);
                    } else if (inputChars.containsKey(i))
                        stringBuilder.append(inputChars.get(i).c);
                    else if (displayChar.isRequired()) {
                        stringBuilder.append(placeholderChar);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private boolean hasDefinition(char c) {
        return definitions.containsKey(c);
    }

    public List<PatternDefinition> getPatternDefinitions() {
        return new ArrayList<>(definitions.values());
    }

    public PatternEvaluation input(char c) {
        return input(String.valueOf(c));
    }

    public PatternEvaluation input(String input) {
        insertInputAt(input, corspondingInputIndex);
        resetMoves();
        callChangeHandlers();
        return this;
    }

    public PatternEvaluation input(char c, int startIndex) {
        return input(String.valueOf(c), startIndex);
    }

    public PatternEvaluation input(String input, int startIndex) {
        insertInputAt(input, startIndex);
        resetMoves();
        callChangeHandlers();
        return this;
    }

    private void resetMoves() {
        numberOfRightMoves = 0;
        numberOfLeftMoves = 0;
    }

    private void insertInputAt(String input, int index) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            while (isInRange(index) && !insertCharAt(c, index)) {
                Map.Entry<Integer, InputChar> nextEntry = nextInputCharEntry(index);
                if (nextEntry != null)
                    index = nextEntry.getKey();
                else
                    index++;
            }
            index = nextDisplayIndex(index);
        }
        corspondingInputIndex = index;
    }

    private boolean insertCharAt(char c, int index) {
        DisplayChar displayChar = displayChars.get(index);
        if (!displayChar.isFixed() && !displayChar.isHidden() && !inputChars.containsKey(index)) {
            if (hasDefinition(displayChar.c) && getDefinition(displayChar.c).isMatch(c)) {
                inputChars.put(index, new InputChar(c, index));
                displayChar.setFilled(true);
                return true;
            } else {
                return displayChar.isRequired();
            }
        }
        return false;
    }

    private int nextDisplayIndex(int index) {
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

    private Map.Entry<Integer, InputChar> nextInputCharEntry(int index) {
        for (Map.Entry<Integer, InputChar> entry : inputChars.entrySet()) {
            if (entry.getKey() > index)
                return entry;
        }
        return null;
    }

    private PatternDefinition getDefinition(char c) {
        return definitions.get(c);
    }

    public String getUnMaskedValue() {
        return inputChars.values().stream()
                .map(inputChar -> inputChar.c)
                .map(String::valueOf)
                .collect(joining());
    }

    public PatternEvaluation backspace() {
        return deleteAt(getLastUndeletedInputIndex());
    }

    public PatternEvaluation deleteAt(int index) {
        if (isInRange(index)) {
            if (inputChars.containsKey(index)) {
                displayChars.get(index).setFilled(false);
                inputChars.remove(index);
                shiftInputTo(index);
                corspondingInputIndex = index;
            }
        }
        resetMoves();
        callChangeHandlers();
        return this;
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

    public PatternEvaluation addValueChangeListener(ValueChangeHandler valueChangeHandler) {
        valueChangeHandlers.add(valueChangeHandler);
        return this;
    }

    private void callChangeHandlers() {
        valueChangeHandlers.forEach(valueChangeHandler -> {
            int nextInt = nextDisplayIndex(0);
            boolean optional = isOptional(nextInt);
            valueChangeHandler.onValueChanged(new PatternEvaluationContext(nextInt, optional));
        });
    }

    public PatternEvaluation setPlaceholderChar(char placeholderChar) {
        this.placeholderChar = placeholderChar;
        return this;
    }

    public void addDefinition(PatternDefinition definition) {
        definitions.put(definition.keyChar(), definition);
    }

    public int getNextInputIndex(int index) {
        return nextDisplayIndex(index);
    }

    public int getLastUndeletedInputIndex() {
        return inputChars.entrySet().stream()
                .filter(entry -> !entry.getValue().isIncluded())
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(-1);
    }

    public int getCurrentDisplayIndex() {
        int index = 0;
        for (int i = 0; i < displayChars.size(); i++) {
            DisplayChar displayChar = displayChars.get(i);
            if (displayChar.isHidden())
                continue;
            if (displayChar.isOptional() && !displayChar.isFilled()) {
                if (isInputFilledAfter(i)) {
                    continue;
                } else {
                    break;
                }
            }
            if (displayChar.isRequired() && !displayChar.isFilled()) {
                if (!isInputFilledAfter(i)) {
                    break;
                }
            }
            index++;
        }
        index += numberOfRightMoves;
        if (index == 0)
            return index;
        return index - numberOfLeftMoves;
    }

    private boolean isInputFilledAfter(int index) {
        return displayChars.stream().skip(index).anyMatch(DisplayChar::isFilled);
    }

    public PatternEvaluation moveRight() {
        return moveRight(1);
    }

    public PatternEvaluation moveRight(int numberOfSteps) {
        boolean skipOptional = false;
        if (pattern.isEmpty())
            return this;

        boolean canMoveRight = true;
        if (isOptional(corspondingInputIndex)) {
            boolean allOptional = displayChars.stream().skip(corspondingInputIndex)
                    .allMatch(DisplayChar::isOptional);
            canMoveRight = !allOptional;
        }
        if (!canMoveRight)
            return this;
        for (int i = 0; i < numberOfSteps; i++) {
            if (corspondingInputIndex != displayChars.size() - 1 && isOptional(corspondingInputIndex)) {
                int test = corspondingInputIndex;
                do {
                    if (isFixed(test)) {
                        numberOfRightMoves++;
                    }
                    test++;
                    corspondingInputIndex++;
                } while (test != displayChars.size() - 1 && !isRequired(test));
                skipOptional = true;
            } else if (isRequired(corspondingInputIndex)) {
                numberOfRightMoves++;
                corspondingInputIndex++;
                if (isFixed(corspondingInputIndex) || isOptional(corspondingInputIndex) && !skipOptional) {
                    numberOfRightMoves++;
                    corspondingInputIndex++;
                }
            } else if (isFixed(corspondingInputIndex)) {
                numberOfRightMoves++;
                corspondingInputIndex++;
            }


        }
        return this;
    }

    public PatternEvaluation moveLeft() {
        return moveLeft(1);
    }

    public PatternEvaluation moveLeft(int numberOfSteps) {
        if (pattern.isEmpty())
            return this;
        corspondingInputIndex -= numberOfSteps;
        numberOfLeftMoves += numberOfSteps;
        if (isRequired(corspondingInputIndex))
            return this;
        else if (isFixed(corspondingInputIndex)) {
            corspondingInputIndex--;
            numberOfLeftMoves++;
        } else if (isOptional(corspondingInputIndex)) {
            int test = corspondingInputIndex;
            do {
                test--;
            } while (test > 0 && !isRequired(test));
            test++;
            corspondingInputIndex -= test;
        }
        return this;
    }

    private boolean isRequired(int index) {
        return isInRange(index) && displayChars.get(index).isRequired();
    }

    private boolean isOptional(int index) {
        return isInRange(index) && displayChars.get(index).isOptional();
    }

    private boolean isFixed(int index) {
        return isInRange(index) && displayChars.get(index).isFixed();
    }

    private boolean isInRange(int index) {
        return index >= 0 && index < displayChars.size();
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

    private class DisplayChar {
        private DisplayCharType type;
        private char c;
        private boolean filled;

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

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public boolean isFilled() {
            return filled;
        }
    }

    private class InputChar {
        private char c;
        private int index;
        private InputCharType type;

        public InputChar(char c, int index) {
            this(c, index, InputCharType.TYPED);
        }

        public InputChar(char c, int index, InputCharType type) {
            this.c = c;
            this.index = index;
            this.type = type;
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

        public boolean isIncluded() {
            return InputCharType.INCLUDE_IN_VALUE.equals(type);
        }
    }

    private enum DisplayCharType {
        FIXED, OPTIONAL, INCLUDE_IN_VALUE, HIDDEN, REQUIRED
    }

    private enum InputCharType {
        INCLUDE_IN_VALUE, TYPED
    }

    @FunctionalInterface
    public interface ValueChangeHandler {
        void onValueChanged(PatternEvaluationContext context);
    }

    public static final class PatternEvaluationContext {
        private final int nextInt;
        private final boolean optional;

        public PatternEvaluationContext(int nextInt, boolean optional) {
            this.nextInt = nextInt;
            this.optional = optional;
        }

        public int getNextInt() {
            return nextInt;
        }

        public boolean isOptional() {
            return optional;
        }
    }
}
