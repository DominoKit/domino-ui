package org.dominokit.domino.ui.forms;

/**
 * A component to input phone numbers
 */
public class TelephoneBox extends InputValueBox<TelephoneBox> {

    /**
     *
     * @param label String
     */
    public TelephoneBox(String label) {
        super("tel", label);
    }

    /**
     *
     * @return new TelephoneBox instance
     */
    public static TelephoneBox create() {
        return create("");
    }

    /**
     * @param label String
     * @return new TelephoneBox instance
     */
    public static TelephoneBox create(String label) {
        return new TelephoneBox(label);
    }
}
