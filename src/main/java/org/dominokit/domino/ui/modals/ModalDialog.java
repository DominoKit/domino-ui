package org.dominokit.domino.ui.modals;

import elemental2.dom.Node;
import org.dominokit.domino.ui.style.ColorScheme;

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

    public static ModalDialog createPickerModal(String title, ColorScheme colorScheme, Node content) {
        ModalDialog modal = ModalDialog.create(title)
                .small()
                .setAutoClose(true)
                .appendContent(content);
        modal.getHeaderContainerElement().style.display="none";
        modal.getBodyElement().style.setProperty("padding", "0px", "important");
        modal.getContentElement().style.setProperty("width","275px");
        modal.getDialogElement().style.setProperty("width","275px");
        modal.getFooterElement().style.setProperty("padding", "0px", "important");

        return modal;
    }

}
