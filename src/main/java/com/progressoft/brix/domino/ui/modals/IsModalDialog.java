package com.progressoft.brix.domino.ui.modals;

import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;

public interface IsModalDialog<T> {
    T appendContent(Node content);

    T appendFooterContent(Node content);

    T large();

    T small();

    T setModalColor(Color color);

    T setAutoClose(boolean autoClose);

    T open();

    T close();

    T hideFooter();

    T showFooter();

    T hideHeader();

    T showHeader();

    T setTitle(String title);

    HTMLDivElement getDialogElement();

    HTMLDivElement getContentElement();

    HTMLHeadingElement getHeaderElement();

    HTMLDivElement getBodyElement();

    HTMLDivElement getFooterElement();

    T onOpen(OpenHandler openHandler);

    T onClose(CloseHandler closeHandler);

    enum ModalSize {
        LARGE("modal-lg"),
        ALERT("modal-alert"),
        SMALL("modal-sm");

        String style;

        ModalSize(String style) {
            this.style = style;
        }
    }

    @FunctionalInterface
    interface OpenHandler {
        void onOpen();
    }

    interface CloseHandler {
        void onClose();
    }
}
