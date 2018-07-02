package org.dominokit.domino.ui.masking;

import org.dominokit.domino.ui.forms.TextBox;

public class ElementMasking {

    private TextBox textBox;

    public ElementMasking(TextBox textBox) {
        this.textBox = textBox;
    }

    public static ElementMasking mask(TextBox textBox) {
        return new ElementMasking(textBox);
    }

    public RegExpMasking regex(String regex) {
        return new RegExpMasking(textBox, regex);
    }

    public PatternMasking pattern(String pattern) {
        return new PatternMasking(textBox, pattern);
    }
}
