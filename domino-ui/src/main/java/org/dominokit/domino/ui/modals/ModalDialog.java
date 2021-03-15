package org.dominokit.domino.ui.modals;

import elemental2.dom.Node;

/**
 * a component to show a pop-up with the ability to block the content behind it.
 *
 */
public class ModalDialog extends BaseModal<ModalDialog> {

    public ModalDialog(String title) {
        super(title);
        init(this);
    }

    public ModalDialog() {
        init(this);
    }

    public static ModalDialog create(String title) {
        return new ModalDialog(title);
    }

    public static ModalDialog create() {
        return new ModalDialog();
    }

    public static ModalDialog createPickerModal(String title, Node content) {
        ModalDialog modal = ModalDialog.create(title)
                .styler(style -> style
                        .add(ModalStyles.PICKER_MODAL))
                .small()
                .setAutoClose(true)
                .appendChild(content);
        return modal;
    }

}
