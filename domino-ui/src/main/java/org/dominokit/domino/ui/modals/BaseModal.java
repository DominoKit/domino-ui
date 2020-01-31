package org.dominokit.domino.ui.modals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import elemental2.dom.Text;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Switchable;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.setVisible;

public abstract class BaseModal<T extends IsElement<HTMLDivElement>> extends BaseDominoElement<HTMLDivElement, T>
        implements IsModalDialog<T>, Switchable<T> {

    private List<OpenHandler> openHandlers = new ArrayList<>();
    private List<CloseHandler> closeHandlers = new ArrayList<>();
    static int Z_INDEX = 1040;

    public static class Modal implements IsElement<HTMLDivElement> {

        private final HTMLDivElement root;
        private final HTMLDivElement modalDialog;
        private final HTMLDivElement modalHeader;
        private final HTMLHeadingElement modalTitle;
        private final HTMLDivElement modalBody;
        private final HTMLDivElement modalContent;
        private final HTMLDivElement modalFooter;

        public Modal() {
            this.root = div().css("model", "fade")
                    .apply(e -> e.tabIndex = -1)
                    .attr("role", "dialog")
                    .add(modalDialog = div().css("modal-dialog")
                            .apply(e -> e.tabIndex = -1)
                            .attr("role", "document")
                            .add(modalContent = div().css("modal-content")
                                    .add(modalHeader = div().css("modal-header")
                                            .add(modalTitle = h(4).css("modal-title").element())
                                            .element())
                                    .add(modalBody = div().css("modal-body").element())
                                    .add(modalFooter = div().css("modal-footer").element())
                                    .element())
                            .element())
                    .element();
            setVisible(root, false);
        }

        @Override
        public HTMLDivElement element() {
            return root;
        }

        public DominoElement<HTMLHeadingElement> getModalTitle() {
            return DominoElement.of(modalTitle);
        }

        public DominoElement<HTMLDivElement> getModalBody() {
            return DominoElement.of(modalBody);
        }

        public DominoElement<HTMLDivElement> getModalDialog() {
            return DominoElement.of(modalDialog);
        }

        public DominoElement<HTMLDivElement> getModalContent() {
            return DominoElement.of(modalContent);
        }

        public DominoElement<HTMLDivElement> getModalFooter() {
            return DominoElement.of(modalFooter);
        }

        public DominoElement<HTMLDivElement> getModalHeader() {
            return DominoElement.of(modalHeader);
        }
    }

    protected Modal modalElement;

    private boolean autoClose = true;

    private ModalSize modalSize;
    private ModalType modalType;

    private Color color;

    private Element firstFocusElement;
    private Element lastFocusElement;
    private Element activeElementBeforeOpen;
    private List<Element> focusElements = new ArrayList<>();
    private Text headerText = DomGlobal.document.createTextNode("");
    private boolean open = false;
    private boolean disabled = false;
    private boolean autoAppendAndRemove = true;
    private boolean modal = true;

    public BaseModal() {
        modalElement = new Modal();
        modalElement.getModalHeader().hide();
        modalElement.getModalTitle().appendChild(headerText);

        addTabIndexHandler();
    }

    public BaseModal(String title) {
        this();
        showHeader();
        modalElement.modalTitle.textContent = title;
    }

    void addTabIndexHandler() {
        element().addEventListener(EventType.keydown.getName(), evt -> {
            initFocusElements();
            KeyboardEvent keyboardEvent = Js.cast(evt);
            switch (keyboardEvent.code) {
                case "Tab":
                    if (focusElements.size() <= 1) {
                        evt.preventDefault();
                        break;
                    }
                    if (keyboardEvent.shiftKey) {
                        handleBackwardTab(evt);
                    } else {
                        handleForwardTab(evt);
                    }
                    break;
                case "Escape":
                    if (isAutoClose()) {
                        close();
                    }
                    break;
                default:
                    break;
            }

            if (!focusElements.contains(DominoDom.document.activeElement) && nonNull(firstFocusElement)) {
                firstFocusElement.focus();
            }
        });
    }

    private void handleBackwardTab(Event evt) {
        if (DominoDom.document.activeElement.equals(firstFocusElement)) {
            evt.preventDefault();
            lastFocusElement.focus();
        }
    }

    private void handleForwardTab(Event evt) {
        if (DominoDom.document.activeElement.equals(lastFocusElement)) {
            evt.preventDefault();
            firstFocusElement.focus();
        }
    }

    @Override
    public T appendChild(Node content) {
        modalElement.modalBody.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendChild(IsElement content) {
        return appendChild(content.element());
    }

    @Override
    public T appendFooterChild(Node content) {
        modalElement.modalFooter.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendFooterChild(IsElement content) {
        return appendFooterChild(content.element());
    }

    @Override
    public T large() {
        return setSize(ModalSize.LARGE);
    }

    @Override
    public T small() {
        return setSize(ModalSize.SMALL);
    }

    public T setSize(ModalSize size) {
        DominoElement<HTMLDivElement> modalElement = DominoElement.of(this.modalElement);
        if (nonNull(modalSize)) {
            modalElement.style().remove(modalSize.style);
        }
        modalElement.style().add(size.style);
        this.modalSize = size;
        return (T) this;
    }

    public T setType(ModalType type) {
        DominoElement<HTMLDivElement> modalElement = DominoElement.of(this.modalElement);
        if (nonNull(modalType)) {
            modalElement.style().remove(modalType.style);
        }
        modalElement.style().add(type.style);
        this.modalType = type;
        return (T) this;
    }

    @Override
    public T setModalColor(Color color) {
        if (nonNull(this.color)) {
            modalElement.getModalContent().style().remove(this.color.getStyle());
        }
        modalElement.getModalContent().style().add(color.getStyle());
        this.color = color;
        return (T) this;
    }

    @Override
    public T setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        return (T) this;
    }

    @Override
    public T open() {

        if (isEnabled()) {
            style().removeProperty("z-index");
            if (autoAppendAndRemove) {
                element().remove();
                document.body.appendChild(element());
            }

            initFocusElements();

            activeElementBeforeOpen = DominoDom.document.activeElement;
            addBackdrop();
            style().add(ModalStyles.IN);
            style().setDisplay("block");
            if (nonNull(firstFocusElement)) {
                firstFocusElement.focus();
                if (!Objects.equals(DominoDom.document.activeElement, firstFocusElement)) {
                    if (nonNull(lastFocusElement)) {
                        lastFocusElement.focus();
                    }
                }
            }

            for (int i = 0; i < openHandlers.size(); i++) { openHandlers.get(i).onOpen(); }

            this.open = true;
            ModalBackDrop.push(this);
        }
        return (T) this;
    }

    public void addBackdrop() {
        if (modal) {
            if (ModalBackDrop.openedModalsCount() <= 0) {
                document.body.appendChild(ModalBackDrop.INSTANCE);
                DominoElement.of(document.body).style().add(ModalStyles.MODAL_OPEN);
            } else {
                Z_INDEX = Z_INDEX + 10;
                ModalBackDrop.INSTANCE.style.setProperty("z-index", Z_INDEX + "");
                element().style.setProperty("z-index", (Z_INDEX + 10) + "");
            }
        }
    }

    public void removeBackDrop() {
        if (modal) {
            if (ModalBackDrop.openedModalsCount() <= 1) {
                ModalBackDrop.INSTANCE.remove();
                DominoElement.of(document.body).style().remove(ModalStyles.MODAL_OPEN);
            } else {
                Z_INDEX = Z_INDEX - 10;
                ModalBackDrop.INSTANCE.style.setProperty("z-index", Z_INDEX + "");
                element().style.setProperty("z-index", (Z_INDEX + 10) + "");
            }
        }
    }

    private void initFocusElements() {
        NodeList<Element> elementNodeList = element().querySelectorAll(
                "a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), [tabindex=\"0\"]");
        List<Element> elements = elementNodeList.asList();

        if (elements.size() > 0) {
            focusElements = elements;
            firstFocusElement = focusElements.get(0);
            lastFocusElement = elements.get(elements.size() - 1);
        } else {
            lastFocusElement = modalElement.modalContent;
        }
    }

    @Override
    public T close() {

        element().classList.remove(ModalStyles.IN);
        element().style.display = "none";
        if (nonNull(activeElementBeforeOpen)) { activeElementBeforeOpen.focus(); }


        if (autoAppendAndRemove) {
            element().remove();
        }

        this.open = false;
        removeBackDrop();
        if (ModalBackDrop.contains(this)) {
            ModalBackDrop.popModal(this);
        }

        for (int i = 0; i < closeHandlers.size(); i++) {
            closeHandlers.get(i).onClose();
        }

        return (T) this;
    }

    public boolean isAutoClose() {
        return autoClose;
    }


    @Override
    public T hideFooter() {
        modalElement.getModalFooter().style().setDisplay("none");
        return (T) this;
    }

    @Override
    public T showFooter() {
        modalElement.getModalFooter().style().setDisplay("block");
        return (T) this;
    }

    @Override
    public T hideHeader() {
        modalElement.getModalHeader().hide();
        return (T) this;
    }

    @Override
    public T showHeader() {
        modalElement.getModalHeader().show();
        return (T) this;
    }

    @Override
    public T hideTitle() {
        modalElement.getModalTitle().hide();
        return (T) this;
    }

    @Override
    public T showTitle() {
        modalElement.getModalTitle().show();
        return (T) this;
    }


    @Override
    public T setTitle(String title) {
        showHeader();
        headerText.textContent = title;
        getHeaderElement().clearElement();
        getHeaderElement().appendChild(headerText);
        return (T) this;
    }

    @Override
    public DominoElement<HTMLDivElement> getDialogElement() {
        return DominoElement.of(modalElement.modalDialog);
    }

    @Override
    public DominoElement<HTMLDivElement> getContentElement() {
        return DominoElement.of(modalElement.modalContent);
    }

    @Override
    public DominoElement<HTMLHeadingElement> getHeaderElement() {
        return DominoElement.of(modalElement.modalTitle);
    }

    @Override
    public DominoElement<HTMLDivElement> getHeaderContainerElement() {
        return DominoElement.of(modalElement.modalHeader);
    }

    @Override
    public DominoElement<HTMLDivElement> getBodyElement() {
        return DominoElement.of(modalElement.modalBody);
    }

    @Override
    public DominoElement<HTMLDivElement> getFooterElement() {
        return DominoElement.of(modalElement.modalFooter);
    }

    @Override
    public HTMLDivElement element() {
        return modalElement.element();
    }

    /**
     * use {@link #addOpenListener(OpenHandler)}
     */
    @Override
    @Deprecated
    public T onOpen(OpenHandler openHandler) {
        return addOpenListener(openHandler);
    }

    @Override
    public T addOpenListener(OpenHandler openHandler) {
        this.openHandlers.add(openHandler);
        return (T) this;
    }

    /**
     * use {@link #addCloseListener(CloseHandler)}
     */
    @Override
    @Deprecated
    public T onClose(CloseHandler closeHandler) {
        return addCloseListener(closeHandler);
    }

    @Override
    public T addCloseListener(CloseHandler closeHandler) {
        this.closeHandlers.add(closeHandler);
        return (T) this;
    }

    @Override
    public T removeOpenHandler(OpenHandler openHandler) {
        this.openHandlers.remove(openHandler);
        return (T) this;
    }

    @Override
    public T removeCloseHandler(CloseHandler closeHandler) {
        this.closeHandlers.remove(closeHandler);
        return (T) this;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public T enable() {
        this.disabled = false;
        return (T) this;
    }

    @Override
    public T disable() {
        this.disabled = true;
        return (T) this;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    @Override
    public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
        this.autoAppendAndRemove = autoAppendAndRemove;
        return (T) this;
    }

    @Override
    public T centerVertically() {
        Style.of(modalElement.modalDialog).add(Styles.vertical_center);
        return (T) this;
    }

    @Override
    public T deCenterVertically() {
        Style.of(modalElement.modalDialog).remove(Styles.vertical_center);
        return (T) this;
    }

    @Override
    public boolean getAutoAppendAndRemove() {
        return this.autoAppendAndRemove;
    }

    public boolean isModal() {
        return modal;
    }

    public T setModal(boolean modal) {
        this.modal = modal;
        return (T) this;
    }
}
