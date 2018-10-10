package org.dominokit.domino.ui.forms;

public class TelephoneBox extends InputValueBox<TelephoneBox> {

    public TelephoneBox(String label) {
        super("tel", label);
    }

    public static TelephoneBox create() {
        return create("");
    }

    public static TelephoneBox create(String label) {
        return new TelephoneBox(label);
    }
}
