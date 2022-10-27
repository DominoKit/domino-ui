package org.dominokit.domino.ui.dialogs;

public class Dialog extends AbstractDialog<Dialog> {
    public Dialog() {
    }

    public Dialog(String title) {
        super(title);
    }

    public static Dialog create() {
        return new Dialog();
    }

    public static Dialog create(String title) {
        return new Dialog(title);
    }
}
