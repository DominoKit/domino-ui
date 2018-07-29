package org.dominokit.domino.ui.masking;

import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;

import static org.dominokit.domino.ui.masking.Regex.*;

public class RegExpMasking implements Masking {

    private final TextBox textBox;
    private String regex;

    public RegExpMasking(TextBox textBox, String regex) {
        this.textBox = textBox;
        this.regex = regex;
    }

    public static RegExpMasking numbersOnly(TextBox textBox) {
        return new RegExpMasking(textBox, NUMBERS_ONLY_REGEX);
    }

    public static RegExpMasking alphabeticalOnly(TextBox textBox) {
        return new RegExpMasking(textBox, ALPHABETICAL_ONLY_REGEX);
    }

    public static RegExpMasking alphanumericOnly(TextBox textBox) {
        return new RegExpMasking(textBox, ALPHANUMERIC_ONLY_REGEX);
    }

    @Override
    public void mask() {
        textBox.getInputElement().addEventListener("keypress", evt -> {
            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);

            if (!isMatchRegex(textBox.getValue() + keyboardEvent.key, regex)) {
                evt.preventDefault();
            }
        });
    }

    private boolean isMatchRegex(String value, String regex) {
        return new JsString(value).search(new JsRegExp(regex)) >= 0;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
