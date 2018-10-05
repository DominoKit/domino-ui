package org.dominokit.domino.ui.modals;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

public interface IsModalDialog<T> {
    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    T appendContent(Node content);

    T appendChild(Node content);

    T appendChild(IsElement content);

    /**
     * @deprecated use {@link #appendFooterChild(Node)}
     */
    @Deprecated
    T appendFooterContent(Node content);

    T appendFooterChild(Node content);

    T appendFooterChild(IsElement content);

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

    DominoElement<HTMLDivElement> getDialogElement();

    DominoElement<HTMLDivElement> getContentElement();

    DominoElement<HTMLHeadingElement> getHeaderElement();

    DominoElement<HTMLDivElement> getHeaderContainerElement();

    DominoElement<HTMLDivElement> getBodyElement();

    DominoElement<HTMLDivElement> getFooterElement();

    T onOpen(OpenHandler openHandler);

    T onClose(CloseHandler closeHandler);

    T removeOpenHandler(OpenHandler openHandler);

    T removeCloseHandler(CloseHandler closeHandler);

    T setAutoAppendAndRemove(boolean autoAppendAndRemove);

    boolean getAutoAppendAndRemove();

    T centerVertically();

    T deCenterVertically();

    enum ModalSize {
        LARGE("modal-lg"),
        ALERT("modal-alert"),
        SMALL("modal-sm");

        String style;

        ModalSize(String style) {
            this.style = style;
        }
    }

    enum ModalType {
        BOTTOM_SHEET("bottom-sheet"),
        TOP_SHEET("top-sheet"),
        LEFT_SHEET("left-sheet"),
        RIGHT_SHEET("right-sheet");

        String style;

        ModalType(String style) {
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
