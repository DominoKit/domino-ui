package org.dominokit.domino.ui.modals;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

public interface IsModalDialog<T> {

    T appendChild(Node content);

    T appendChild(IsElement<?> content);

    T appendFooterChild(Node content);

    T appendFooterChild(IsElement<?> content);

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

    T hideTitle();

    T showTitle();

    T setTitle(String title);

    DominoElement<HTMLDivElement> getDialogElement();

    DominoElement<HTMLDivElement> getContentElement();

    DominoElement<HTMLHeadingElement> getHeaderElement();

    DominoElement<HTMLDivElement> getHeaderContainerElement();

    DominoElement<HTMLDivElement> getBodyElement();

    DominoElement<HTMLDivElement> getFooterElement();

    /**
     * use {@link #addOpenListener(OpenHandler)}
     */
    @Deprecated
    T onOpen(OpenHandler openHandler);

    T addOpenListener(OpenHandler openHandler);

    /**
     * use {@link #addCloseListener(CloseHandler)}
     */
    @Deprecated
    T onClose(CloseHandler closeHandler);

    T addCloseListener(CloseHandler closeHandler);

    T removeOpenHandler(OpenHandler openHandler);

    T removeCloseHandler(CloseHandler closeHandler);

    T setAutoAppendAndRemove(boolean autoAppendAndRemove);

    boolean getAutoAppendAndRemove();

    T centerVertically();

    T deCenterVertically();

    enum ModalSize {
        LARGE(ModalStyles.MODAL_LG),
        ALERT(ModalStyles.MODAL_ALERT),
        SMALL(ModalStyles.MODAL_SM);

        String style;

        ModalSize(String style) {
            this.style = style;
        }
    }

    enum ModalType {
        BOTTOM_SHEET(ModalStyles.BOTTOM_SHEET),
        TOP_SHEET(ModalStyles.TOP_SHEET),
        LEFT_SHEET(ModalStyles.LEFT_SHEET),
        RIGHT_SHEET(ModalStyles.RIGHT_SHEET);

        String style;

        ModalType(String style) {
            this.style = style;
        }
    }

    @FunctionalInterface
    interface OpenHandler {
        void onOpen();
    }

    /**
     * An interface to implement handlers for closing a dialog
     */
    @FunctionalInterface
    interface CloseHandler {
        /**
         * Will be called when the dialog is closed
         */
        void onClose();
    }
}
