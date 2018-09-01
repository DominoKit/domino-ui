package org.dominokit.domino.ui.modals;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.MyDom;
import org.dominokit.domino.ui.utils.Switchable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public abstract class BaseModal<T extends IsElement<HTMLDivElement>> extends DominoElement<HTMLDivElement, T> implements IsElement<HTMLDivElement>, IsModalDialog<T>, Switchable<T> {
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

        public DominoElement<HTMLHeadingElement, IsElement<HTMLHeadingElement>> getModalTitle() {
            return DominoElement.of(modalTitle);
        }

        public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getModalBody() {
            return DominoElement.of(modalBody);
        }

        public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getModalDialog() {
            return DominoElement.of(modalDialog);
        }

        public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getModalContent() {
            return DominoElement.of(modalContent);
        }

        public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getModalFooter() {
            return DominoElement.of(modalFooter);
        }

        public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getModalHeader() {
            return DominoElement.of(modalHeader);
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
    private boolean open=false;
    private boolean disabled=false;
    private boolean autoAppendAndRemove=true;

    public BaseModal() {
        modal = Modal.create();
        modal.getModalTitle().style().setDisplay("none");
        modal.getModalTitle().appendChild(headerText);
        modal.getModalDialog().addEventListener("click", Event::stopPropagation);
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

    /**
     * @deprecated use {@link #appendChild(Node)}
     * @param content
     * @return
     */
    @Deprecated
    @Override
    public T appendContent(Node content) {
        modal.modalBody.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendChild(Node content) {
        modal.modalBody.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendChild(IsElement content) {
        return appendChild(content.asElement());
    }

    @Override
    public T appendFooterChild(Node content) {
        modal.modalFooter.appendChild(content);
        return (T) this;
    }

    @Override
    public T appendFooterChild(IsElement content) {
        return appendFooterChild(content.asElement());
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     * @param content
     * @return
     */
    @Deprecated
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
        if (nonNull(modalSize)) {
            modal.getModalDialog().style().remove(modalSize.style);
        }
        modal.getModalDialog().style().add(size.style);
        this.modalSize = size;
        return (T) this;
    }

    @Override
    public T setModalColor(Color color) {
        if (nonNull(this.color)) {
            modal.getModalContent().style().remove(this.color.getStyle());
        }
        modal.getModalContent().style().add(color.getStyle());
        this.color = color;
        return (T) this;
    }

    @Override
    public T setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        if (autoClose) {
            MODAL_BACKDROP.addEventListener(EventType.keypress.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
                close();
            });

            MODAL_BACKDROP.addEventListener(EventType.mousedown.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
                close();
            });
        }else{
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

        if(isEnabled()) {

            if(autoAppendAndRemove){
                asElement().remove();
                document.body.appendChild(asElement());
            }

            initFocusElements();

            activeElementBeforeOpen = MyDom.document.activeElement;
            MODAL_BACKDROP.remove();
            document.body.appendChild(MODAL_BACKDROP);
            style().add("in");
            style().setDisplay("block");
            if (nonNull(firstFocusElement)) {
                firstFocusElement.focus();
                if(!Objects.equals(MyDom.document.activeElement, firstFocusElement)){
                   if(nonNull(lastFocusElement)){
                       lastFocusElement.focus();
                   }
                }
            }

            for (int i = 0; i < openHandlers.size(); i++)
                openHandlers.get(i).onOpen();

            this.open = true;
        }
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

        for(int i=0;i<closeHandlers.size();i++) {
            closeHandlers.get(i).onClose();
        }

        if(autoAppendAndRemove){
            asElement().remove();
            MODAL_BACKDROP.remove();
        }

        this.open=false;
        return (T) this;
    }

    @Override
    public T hideFooter() {
        modal.getModalFooter().style().setDisplay("none");
        return (T) this;
    }

    @Override
    public T showFooter() {
        modal.getModalFooter().style().setDisplay("block");
        return (T) this;
    }

    @Override
    public T hideHeader() {
        modal.getModalTitle().style().setDisplay("none");
        return (T) this;
    }

    @Override
    public T showHeader() {
        modal.getModalTitle().style().setDisplay("block");
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
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getDialogElement() {
        return DominoElement.of(modal.modalDialog);
    }

    @Override
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getContentElement() {
        return DominoElement.of(modal.modalContent);
    }

    @Override
    public DominoElement<HTMLHeadingElement, IsElement<HTMLHeadingElement>> getHeaderElement() {
        return DominoElement.of(modal.modalTitle);
    }

    @Override
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getHeaderContainerElement() {
        return DominoElement.of(modal.modalHeader);
    }

    @Override
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getBodyElement() {
        return DominoElement.of(modal.modalBody);
    }

    @Override
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getFooterElement() {
        return DominoElement.of(modal.modalFooter);
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

    public boolean isOpen() {
        return open;
    }

    @Override
    public T enable() {
        this.disabled=false;
        return (T) this;
    }

    @Override
    public T disable() {
        this.disabled=true;
        return (T) this;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    @Override
    public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
        this.autoAppendAndRemove=autoAppendAndRemove;
        return (T) this;
    }

    @Override
    public T centerVertically(){
        Style.of(modal.modalDialog).add(Styles.vertical_center);
        return (T) this;
    }

    @Override
    public T deCenterVertically(){
        Style.of(modal.modalDialog).remove(Styles.vertical_center);
        return (T) this;
    }

    @Override
    public boolean getAutoAppendAndRemove() {
        return this.autoAppendAndRemove;
    }
}
