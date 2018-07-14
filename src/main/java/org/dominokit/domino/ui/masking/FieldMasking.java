package org.dominokit.domino.ui.masking;

import org.dominokit.domino.ui.forms.TextBox;

public class FieldMasking {

    private TextBox textBox;

    public FieldMasking(TextBox textBox) {
        this.textBox = textBox;
    }

    public static FieldMasking mask(TextBox textBox) {
        return new FieldMasking(textBox);
    }

    public RegExpMasking regex(String regex) {
        return new RegExpMasking(textBox, regex);
    }

    public PatternMasking pattern(String pattern) {
        return new PatternMasking(textBox, pattern);
    }
}
