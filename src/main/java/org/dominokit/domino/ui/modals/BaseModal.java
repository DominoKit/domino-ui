package org.dominokit.domino.ui.modals;

import org.dominokit.domino.ui.style.Color;
import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.MyDom;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public abstract class BaseModal<T> implements IsElement<HTMLDivElement>, IsModalDialog<T> {
    private static HTMLDivElement MODAL_BACKDROP = Elements.div().css("modal-backdrop fade in").asElement();
    private List<OpenHandler> openHandlers = new ArrayList<>();
    private List<CloseHandler> closeHandlers = new ArrayList<>();

    @Templated
    public static abstract class Modal implements IsElement<HTMLDivElement> {

        @DataElement
        HTMLDivElement modalHeader;

        @DataElement
        HTMLHeadingElement modalTitle;

        @DataElement
        HTMLDivElement modalBody;

        @DataElement
        HTMLDivElement modalDialog;

        @DataElement
        HTMLDivElement modalContent;

        @DataElement
        HTMLDivElement modalFooter;

        public static Modal create() {
            return new Templated_BaseModal_Modal();
        }

        public HTMLHeadingElement getModalTitle() {
            return modalTitle;
        }

        public HTMLDivElement getModalBody() {
            return modalBody;
        }

        public HTMLDivElement getModalDialog() {
            return modalDialog;
        }

        public HTMLDivElement getModalContent() {
            return modalContent;
        }

        public HTMLDivElement getModalFooter() {
            return modalFooter;
        }

        public HTMLDivElement getModalHeader() {
            return modalHeader;
        }
    }

    protected Modal modal;

    private boolean autoClose = true;

    private ModalSize modalSize;

    private Color color;

    private Element firstFocusElement;
    private Element lastFocusElement;
    private Element activeElementBeforeOpen;
    private List<Element> focusElements = new ArrayList<>();
    private Text headerText=new Text();

    public BaseModal() {
        modal = Modal.create();
        modal.modalTitle.style.display = "none";
        modal.modalTitle.appendChild(headerText);
        modal.modalDialog.addEventListener("click", Event::stopPropagation);
        addCloseHandler();

        addTabIndexHandler();
    }

    public BaseModal(String title) {
        this();
        showHeader();
        modal.modalTitle.textContent = title;
    }

    void addCloseHandler() {
        asElement().addEventListener("click", event -> {
            if (autoClose)
                close();
        });
    }

    void addTabIndexHandler() {
        asElement().addEventListener(EventType.keydown.getName(), evt -> {
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
                    close();
                    break;
                default:
                    break;
            }

            if (!focusElements.contains(MyDom.document.activeElement)) {
                firstFocusElement.focus();
            }
        });
    }

    private void handleBackwardTab(Event evt) {
        if (MyDom.document.activeElement.equals(firstFocusElement)) {
            evt.preventDefault();
            lastFocusElement.focus();
        }
    }

    private void handleForwardTab(Event evt) {
        if (MyDom.document.activeElement.equals(lastFocusElement)) {
            evt.preventDefault();
            firstFocusElement.focus();
        }
    }

    @Override
    public T appendContent(Node content) {
        modal.modalBody.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendFooterContent(Node content) {
        modal.modalFooter.appendChild(content);
        return (T) this;
    }

    @Override
    public T large() {
        return setSize(ModalSize.LARGE);
    }

    @Override
    public T small() {
        return setSize(ModalSize.SMALL);
    }

    public T setSize(ModalSize size){
        if (nonNull(modalSize))
            modal.modalDialog.classList.remove(modalSize.style);
        modal.modalDialog.classList.add(size.style);
        this.modalSize = size;
        return (T) this;
    }

    @Override
    public T setModalColor(Color color) {
        if (nonNull(this.color))
            modal.modalContent.classList.remove("modal-" + this.color.getStyle());
        modal.modalContent.classList.add("modal-" + color.getStyle());
        this.color = color;
        return (T) this;
    }

    @Override
    public T setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        if (!autoClose) {
            MODAL_BACKDROP.addEventListener(EventType.keypress.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
            });

            MODAL_BACKDROP.addEventListener(EventType.mousedown.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
            });
        }
        return (T) this;
    }

    @Override
    public T open() {

        initFocusElements();

        activeElementBeforeOpen = MyDom.document.activeElement;
        MODAL_BACKDROP.remove();
        document.body.appendChild(MODAL_BACKDROP);
        asElement().classList.add("in");
        asElement().style.display = "block";
        if (nonNull(firstFocusElement))
            firstFocusElement.focus();

        for(int i=0;i<openHandlers.size();i++)
            openHandlers.get(i).onOpen();


        return (T) this;
    }

    private void initFocusElements() {
        NodeList<Element> elementNodeList = asElement().querySelectorAll("a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), [tabindex=\"0\"]");
        List<Element> elements = elementNodeList.asList();

        if (elements.size() > 0) {
            focusElements = elements;
            firstFocusElement = focusElements.get(0);
            lastFocusElement = elements.get(elements.size() - 1);
        } else {
            lastFocusElement = modal.modalContent;
        }
    }

    @Override
    public T close() {
        MODAL_BACKDROP.remove();
        asElement().classList.remove("in");
        asElement().style.display = "none";
        if (nonNull(activeElementBeforeOpen))
            activeElementBeforeOpen.focus();

        for(int i=0;i<closeHandlers.size();i++)
            closeHandlers.get(i).onClose();

        return (T) this;
    }

    @Override
    public T hideFooter() {
        modal.modalFooter.style.display = "none";
        return (T) this;
    }

    @Override
    public T showFooter() {
        modal.modalFooter.style.display = "block";
        return (T) this;
    }

    @Override
    public T hideHeader() {
        modal.modalTitle.style.display = "none";
        return (T) this;
    }

    @Override
    public T showHeader() {
        modal.modalTitle.style.display = "block";
        return (T) this;
    }

    @Override
    public T setTitle(String title) {
        showHeader();
        headerText.textContent = title;
        return (T) this;
    }

    @Override
    public HTMLDivElement getDialogElement() {
        return modal.modalDialog;
    }

    @Override
    public HTMLDivElement getContentElement() {
        return modal.modalContent;
    }

    @Override
    public HTMLHeadingElement getHeaderElement() {
        return modal.modalTitle;
    }

    @Override
    public HTMLDivElement getBodyElement() {
        return modal.modalBody;
    }

    @Override
    public HTMLDivElement getFooterElement() {
        return modal.modalFooter;
    }

    @Override
    public HTMLDivElement asElement() {
        return modal.asElement();
    }

    @Override
    public T onOpen(OpenHandler openHandler) {
        this.openHandlers.add(openHandler);
        return (T) this;
    }

    @Override
    public T onClose(CloseHandler closeHandler) {
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
}
