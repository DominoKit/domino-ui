package org.dominokit.domino.ui.masking;

import elemental2.dom.ClipboardEvent;
import elemental2.dom.Event;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.utils.ElementUtil;

public class PatternMasking implements Masking {

    private TextBox textBox;
    private final PatternEvaluation patternEvaluation;

    public PatternMasking(TextBox textBox, String pattern) {
        this.textBox = textBox;
        patternEvaluation = PatternEvaluation.pattern(pattern).build();
        patternEvaluation.addValueChangeListener(() -> {
            textBox.setValue(patternEvaluation.getDisplayValue());
            textBox.setHelperText(patternEvaluation.getUnMaskedValue());
            updateTextCursorPosition();
        });
    }

    public void mask() {
        textBox.getInputElement().addEventListener("keypress", evt -> {
            KeyboardEvent keyboardEvent = asKeyboardEvent(evt);
            int startIndex = selectionStart();
            char c = keyboardEvent.key.charAt(0);
            patternEvaluation.input(c, startIndex);
            evt.preventDefault();
        });

        textBox.getInputElement().addEventListener("keydown", evt -> {
            KeyboardEvent keyboardEvent = asKeyboardEvent(evt);
            if (ElementUtil.isKeyOf("backspace", keyboardEvent)) {
                if (selectionEnd() == textBox.getValue().length()) {
                    patternEvaluation.backspace();
                } else {
                    patternEvaluation.deleteAt(selectionEnd() - 1);
                }
                evt.preventDefault();
            } else if (ElementUtil.isKeyOf("delete", keyboardEvent)) {
                int index = selectionEnd();
                patternEvaluation.deleteAt(index);
                setSelection(index);
                evt.preventDefault();
            }
        });

        textBox.getInputElement().addEventListener("mouseup", evt -> updateTextCursorPosition());

        textBox.getInputElement().addEventListener("paste", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
            ClipboardEvent clipboardEvent = asClipboardEvent(evt);
            String data = clipboardEvent.clipboardData.getData("text");
            patternEvaluation.inputAt(data, selectionStart());
        });

        textBox.setValue(patternEvaluation.getDisplayValue());

    }

    private void updateTextCursorPosition() {
        setSelection(getFirstEmptyCharIndex());
    }

    private int getFirstEmptyCharIndex() {
        return patternEvaluation.getDisplayValue().indexOf('_');
    }

    private KeyboardEvent asKeyboardEvent(Event evt) {
        return Js.uncheckedCast(evt);
    }

    private ClipboardEvent asClipboardEvent(Event evt) {
        return Js.uncheckedCast(evt);
    }

    private int selectionStart() {
        HTMLInputElementWithSelection selection = Js.uncheckedCast(textBox.getInputElement());
        return selection.selectionStart;
    }

    private int selectionEnd() {
        HTMLInputElementWithSelection selection = Js.uncheckedCast(textBox.getInputElement());
        return selection.selectionEnd;
    }

    private void setSelectionStart(int selectionStart) {
        HTMLInputElementWithSelection selection = Js.uncheckedCast(textBox.getInputElement());
        selection.selectionStart = selectionStart;
    }

    private void setSelectionEnd(int selectionEnd) {
        HTMLInputElementWithSelection selection = Js.uncheckedCast(textBox.getInputElement());
        selection.selectionEnd = selectionEnd;
    }

    private void setSelection(int selection) {
        setSelectionStart(selection);
        setSelectionEnd(selection);
    }

    public PatternMasking addDefinition(PatternDefinition definition) {
        patternEvaluation.addDefinition(definition);
        return this;
    }
}
