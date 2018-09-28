package org.dominokit.domino.ui.utils;

import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.ObserverCallback;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class BaseDominoElement<E extends HTMLElement, T extends IsElement<E>> implements IsElement<E>, IsCollapsible<T>, HasChildren<T>, HasWavesElement {

    protected T element;
    private String uuid;
    private Tooltip tooltip;
    private Collapsible collapsible;
    protected Style<E, T> style;

    private ScreenMedia hideOn;
    private ScreenMedia showOn;

    public void init(T element) {
        this.element = element;
        this.uuid = Elements.createDocumentUniqueId();
        setAttribute("domino-uuid", this.uuid);
        this.collapsible = Collapsible.create(getCollapsibleElement());
        this.style = Style.of(element);
    }

    public T setId(String id) {
        asElement().id = id;
        return element;
    }

    public String getId() {
        return asElement().id;
    }

    @Override
    public T collapse() {
        collapsible.collapse();
        return element;
    }

    @Override
    public T expand() {
        collapsible.expand();
        return element;
    }

    @Override
    public T toggleDisplay() {
        collapsible.toggleDisplay();
        return element;
    }

    public T clearElement() {
        ElementUtil.clear(asElement());
        return element;
    }

    @Override
    public boolean isCollapsed() {
        if (isNull(collapsible)) {
            return false;
        }
        return collapsible.isCollapsed();
    }

    public T onAttached(ObserverCallback observerCallback) {
        if (!isAttached()) {
            ElementUtil.onAttach(element, observerCallback);
        }
        return element;
    }

    public T onDetached(ObserverCallback observerCallback) {
        ElementUtil.onDetach(element, observerCallback);
        return element;
    }

    public boolean isAttached() {
        return nonNull(DomGlobal.document.body.querySelector("[domino-uuid='" + uuid + "']"));
    }

    public Style<E, T> style() {
        return style;
    }

    public HtmlComponentBuilder<E, T> builder() {
        return ElementUtil.componentBuilder(element);
    }

    @Override
    public T appendChild(Node node) {
        element.asElement().appendChild(node);
        return element;
    }

    @Override
    public T appendChild(IsElement isElement) {
        element.asElement().appendChild(isElement.asElement());
        return element;
    }

    public T addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return element;
    }

    public T addEventListener(String type, EventListener listener) {
        asElement().addEventListener(type, listener);
        return element;
    }

    public T addEventListener(EventType type, EventListener listener) {
        asElement().addEventListener(type.getName(), listener);
        return element;
    }

    public T removeEventListener(EventType type, EventListener listener) {
        asElement().removeEventListener(type.getName(), listener);
        return element;
    }

    public T removeEventListener(String type, EventListener listener) {
        asElement().removeEventListener(type, listener);
        return element;
    }

    public T insertBefore(Node newNode, Node oldNode) {
        asElement().insertBefore(newNode, oldNode);
        return (T) this;
    }

    public T insertBefore(Node newNode, BaseDominoElement oldNode) {
        asElement().insertBefore(newNode, oldNode.asElement());
        return element;
    }

    public T insertBefore(BaseDominoElement newNode, BaseDominoElement oldNode) {
        asElement().insertBefore(newNode.asElement(), oldNode.asElement());
        return element;
    }

    public T insertBefore(BaseDominoElement newNode, Node oldNode) {
        asElement().insertBefore(newNode.asElement(), oldNode);
        return element;
    }

    public T insertFirst(Node newNode) {
        asElement().insertBefore(newNode, asElement().firstChild);
        return element;
    }

    public T insertFirst(IsElement element) {
        return insertFirst(element.asElement());
    }

    public T insertFirst(BaseDominoElement newNode) {
        asElement().insertBefore(newNode.asElement(), asElement().firstChild);
        return element;
    }

    public T setAttribute(String name, String value) {
        asElement().setAttribute(name, value);
        return element;
    }

    public T setAttribute(String name, boolean value) {
        asElement().setAttribute(name, value);
        return element;
    }

    public T setAttribute(String name, double value) {
        asElement().setAttribute(name, value);
        return element;
    }

    public T setReadonly(boolean readonly) {
        if (readonly) {
            return setAttribute("readonly", "readonly");
        } else {
            return removeAttribute("readonly");
        }
    }

    public String getAttribute(String name) {
        return asElement().getAttribute(name);
    }

    public T removeAttribute(String name) {
        asElement().removeAttribute(name);
        return element;
    }

    public boolean hasAttribute(String name) {
        return asElement().hasAttribute(name);
    }

    public boolean contains(DominoElement<? extends HTMLElement> node) {
        return contains(node.asElement());
    }

    public boolean contains(Node node) {
        return asElement().contains(node);
    }

    public T setTextContent(String text) {
        asElement().textContent = text;
        return element;
    }

    public T remove() {
        asElement().remove();
        return element;
    }

    public T removeChild(Node node) {
        asElement().removeChild(node);
        return element;
    }

    public T removeChild(IsElement<HTMLElement> elementToRemove) {
        removeChild(elementToRemove.asElement());
        return element;
    }

    public NodeList<Node> childNodes(Node node) {
        return asElement().childNodes;
    }

    public Node firstChild() {
        return asElement().firstChild;
    }

    public Node lastChild() {
        return asElement().lastChild;
    }

    public String getTextContent() {
        return asElement().textContent;
    }

    public T blur() {
        asElement().blur();
        return element;
    }

    public T setTooltip(String text) {
        return setTooltip(text, PopupPosition.TOP);
    }

    public T setTooltip(String text, PopupPosition position) {
        return setTooltip(TextNode.of(text), position);
    }

    public T setTooltip(Node node) {
        return setTooltip(node, PopupPosition.TOP);
    }

    public T setTooltip(Node node, PopupPosition position) {
        if (isNull(tooltip)) {
            tooltip = Tooltip.create(asElement(), node);
        } else {
            tooltip.setContent(node);
        }
        tooltip.position(position);
        return element;
    }

    public HTMLElement getClickableElement() {
        return asElement();
    }

    public HTMLElement getCollapsibleElement() {
        return asElement();
    }

    @Override
    public HTMLElement getWavesElement() {
        return asElement();
    }

    public T hideOn(ScreenMedia screenMedia) {
        if (nonNull(hideOn)) {
            style.remove("hide-on-" + hideOn.getStyle());
        }
        this.hideOn = screenMedia;
        style.add("hide-on-" + this.hideOn.getStyle());

        return element;
    }

    public T showOn(ScreenMedia screenMedia) {
        if (nonNull(showOn)) {
            style.remove("show-on-" + showOn.getStyle());
        }
        this.showOn = screenMedia;
        style.add("show-on-" + this.showOn.getStyle());

        return element;
    }

    public ClientRect getBoundingClientRect() {
        return element.asElement().getBoundingClientRect();
    }

    public T styler(StyleEditor<E, T> styleEditor) {
        styleEditor.applyStyles(style());
        return element;
    }

    public T addCss(String cssClass) {
        style().add(cssClass);
        return element;
    }

    public T addCss(String... cssClass) {
        style().add(cssClass);
        return element;
    }

    public T setWidth(String width) {
        style().setWidth(width);
        return element;
    }

    public T setHeight(String height) {
        style().setHeight(height);
        return element;
    }

    public boolean isEqualNode(Node node) {
        return asElement().isEqualNode(node);
    }

    public int getElementsCount() {
        return new Double(asElement().childElementCount).intValue();
    }

    public boolean isEmptyElement() {
        return getElementsCount() == 0;
    }

    public double getChildElementCount() {
        return asElement().childElementCount;
    }

    public Node getFirstChild() {
        return asElement().firstChild;
    }

    public boolean hasChildNodes() {
        return asElement().hasChildNodes();
    }

    @FunctionalInterface
    public interface StyleEditor<E extends HTMLElement, T extends IsElement<E>> {
        void applyStyles(Style<E, T> style);
    }

}
