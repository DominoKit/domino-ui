package org.dominokit.domino.ui.modals;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

public interface IsModalDialog<T> {
    /**
     * @deprecated use {@link #appendChild(Node)}
     * @param content
     * @return
     */
    @Deprecated
    T appendContent(Node content);

    T appendChild(Node content);

    T appendChild(IsElement content);

    /**
     * @deprecated use {@link #appendFooterChild(Node)}
     * @param content
     * @return
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

    DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getDialogElement();

    DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getContentElement();

    DominoElement<HTMLHeadingElement, IsElement<HTMLHeadingElement>> getHeaderElement();

    DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getHeaderContainerElement();

    DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getBodyElement();

    DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getFooterElement();

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

    @FunctionalInterface
    interface OpenHandler {
        void onOpen();
    }

    interface CloseHandler {
        void onClose();
    }
}
