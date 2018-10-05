package org.dominokit.domino.ui.modals;

import elemental2.dom.Node;
import org.dominokit.domino.ui.style.ColorScheme;

public class ModalDialog extends BaseModal<ModalDialog>{

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

    public static ModalDialog createPickerModal(String title, ColorScheme colorScheme, Node content) {
        ModalDialog modal = ModalDialog.create(title)
                .styler(style -> style.setMinWidth("275px"))
                .small()
                .setAutoClose(true)
                .appendChild(content);
        modal.getHeaderContainerElement().style().setDisplay("none");
        modal.getBodyElement().style().setPadding("0px", true);
        modal.getContentElement().style().setWidth("275px");
        modal.getDialogElement().style().setWidth("275px");
        modal.getFooterElement().style().setPadding("0px", true);

        return modal;
    }

}
