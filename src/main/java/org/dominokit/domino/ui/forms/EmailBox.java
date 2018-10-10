package org.dominokit.domino.ui.forms;

public class EmailBox extends InputValueBox<EmailBox> {

    public EmailBox(String label) {
        super("email", label);
    }

    public static EmailBox create() {
        return create("");
    }

    public static EmailBox create(String label) {
        return new EmailBox(label);
    }

    public EmailBox setMultiple(boolean multiple) {
        if (multiple) {
            getInputElement().setAttribute("multiple", multiple);
        } else {
            getInputElement().removeAttribute("multiple");
        }
        return this;
    }
}
