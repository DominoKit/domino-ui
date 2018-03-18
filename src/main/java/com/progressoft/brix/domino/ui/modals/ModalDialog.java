package com.progressoft.brix.domino.ui.modals;

public class ModalDialog extends BaseModal<ModalDialog>{

    public ModalDialog(String title) {
        super(title);
    }

    public ModalDialog() {

    }

    public static ModalDialog create(String title) {
        return new ModalDialog(title);
    }

    public static ModalDialog create() {
        return new ModalDialog();
    }

}
