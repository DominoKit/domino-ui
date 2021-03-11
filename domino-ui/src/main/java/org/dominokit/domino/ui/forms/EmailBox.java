package org.dominokit.domino.ui.forms;

/**
 * A component that has an input to take/provide Email(s) value
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email">Email input on MDN</a>
 */
public class EmailBox extends InputValueBox<EmailBox> {

    /**
     * Creates a new instance with a label
     * @param label String
     */
    public EmailBox(String label) {
        super("email", label);
    }

    /**
     *
     * @return a new instance without a label
     */
    public static EmailBox create() {
        return create("");
    }

    /**
     *
     * @return a new instance with a label
     */
    public static EmailBox create(String label) {
        return new EmailBox(label);
    }

    /**
     *
     * @param multiple boolean, Whether or not to allow multiple, comma-separated, e-mail addresses to be entered
     * @return Same EmailBox instance
     */
    public EmailBox setMultiple(boolean multiple) {
        if (multiple) {
            getInputElement().setAttribute("multiple", multiple);
        } else {
            getInputElement().removeAttribute("multiple");
        }
        return this;
    }
}