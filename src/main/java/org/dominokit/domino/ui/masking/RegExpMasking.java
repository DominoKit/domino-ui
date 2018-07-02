package org.dominokit.domino.ui.masking;

import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;

public class RegExpMasking implements Masking {

    private final TextBox textBox;
    private final String regex;

    public RegExpMasking(TextBox textBox, String regex) {
        this.textBox = textBox;
        this.regex = regex;
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
}
