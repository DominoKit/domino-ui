package org.dominokit.domino.ui.utils;

import com.google.gwt.editor.client.Editor;
import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WavesSupport;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.ObserverCallback;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class BaseDominoElement<E extends HTMLElement, T extends IsElement<E>> implements IsElement<E>, IsCollapsible<T>, HasChildren<T>, HasWavesElement, IsReadOnly<T> {

    @Editor.Ignore
    protected T element;
    private String uuid;
    private Tooltip tooltip;
    private Collapsible collapsible;
    @Editor.Ignore
    protected Style<E, T> style;

    private ScreenMedia hideOn;
    private ScreenMedia showOn;
    private Elevation elevation;
    private WavesSupport wavesSupport;

    @Editor.Ignore
    protected void init(T element) {
        this.element = element;

        if (hasDominoId()) {
            uuid = getAttribute("domino-uuid");
        } else {
            this.uuid = Elements.createDocumentUniqueId();
            setAttribute("domino-uuid", this.uuid);
        }
        this.collapsible = Collapsible.create(getCollapsibleElement());
        this.style = Style.of(element);
    }

    private boolean hasDominoId() {
        return hasAttribute("domino-uuid") && nonNull(getAttribute("domino-uuid")) && !getAttribute("domino-uuid").isEmpty();
    }

    public T setId(String id) {
        asElement().id = id;
        return element;
    }

    @Editor.Ignore
    public String getId() {
        return asElement().id;
    }


    @Override
    @Editor.Ignore
    public T toggleDisplay() {
        collapsible.toggleDisplay();
        return element;
    }

    @Override
    @Editor.Ignore
    public T toggleDisplay(boolean state) {
        collapsible.toggleDisplay(state);
        return element;
    }

    @Override
    public T show() {
        collapsible.show();
        return element;
    }

    @Override
    public T hide() {
        collapsible.hide();
        return element;
    }

    @Editor.Ignore
    public Collapsible getCollapsible() {
        return collapsible;
    }

    @Editor.Ignore
    public T clearElement() {
        ElementUtil.clear(asElement());
        return element;
    }

    @Override
    @Editor.Ignore
    public boolean isHidden() {
        if (isNull(collapsible)) {
            return false;
        }
        return collapsible.isHidden();
    }

    @Override
    public E asElement() {
        return null;
    }

    @Editor.Ignore
    public T onAttached(ObserverCallback observerCallback) {
        if (!isAttached()) {
            ElementUtil.onAttach(element, observerCallback);
        }
        return element;
    }

    @Editor.Ignore
    public T onDetached(ObserverCallback observerCallback) {
        ElementUtil.onDetach(element, observerCallback);
        return element;
    }

    @Editor.Ignore
    public boolean isAttached() {
        return nonNull(DomGlobal.document.body.querySelector("[domino-uuid='" + uuid + "']"));
    }

    @Editor.Ignore
    public Style<E, T> style() {
        return style;
    }

    @Editor.Ignore
    public T css(String cssClass) {
        style.add(cssClass);
        return element;
    }

    @Editor.Ignore
    public T css(String... cssClasses) {
        style.add(cssClasses);
        return element;
    }

    @Editor.Ignore
    public HtmlComponentBuilder<E, T> builder() {
        return ElementUtil.componentBuilder(element);
    }

    @Override
    @Editor.Ignore
    public T appendChild(Node node) {
        element.asElement().appendChild(node);
        return element;
    }

    @Override
    @Editor.Ignore
    public T appendChild(IsElement isElement) {
        element.asElement().appendChild(isElement.asElement());
        return element;
    }

    @Editor.Ignore
    public T addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return element;
    }

    @Editor.Ignore
    public T addEventListener(String type, EventListener listener) {
        asElement().addEventListener(type, listener);
        return element;
    }

    @Editor.Ignore
    public T addEventListener(EventType type, EventListener listener) {
        asElement().addEventListener(type.getName(), listener);
        return element;
    }

    @Editor.Ignore
    public T removeEventListener(EventType type, EventListener listener) {
        asElement().removeEventListener(type.getName(), listener);
        return element;
    }

    @Editor.Ignore
    public T removeEventListener(String type, EventListener listener) {
        asElement().removeEventListener(type, listener);
        return element;
    }

    @Editor.Ignore
    public T insertBefore(Node newNode, Node oldNode) {
        asElement().insertBefore(newNode, oldNode);
        return (T) this;
    }

    @Editor.Ignore
    public T insertBefore(Node newNode, BaseDominoElement oldNode) {
        asElement().insertBefore(newNode, oldNode.asElement());
        return element;
    }

    @Editor.Ignore
    public T insertBefore(BaseDominoElement newNode, BaseDominoElement oldNode) {
        asElement().insertBefore(newNode.asElement(), oldNode.asElement());
        return element;
    }

    @Editor.Ignore
    public T insertBefore(BaseDominoElement newNode, Node oldNode) {
        asElement().insertBefore(newNode.asElement(), oldNode);
        return element;
    }

    @Editor.Ignore
    public T insertFirst(Node newNode) {
        asElement().insertBefore(newNode, asElement().firstChild);
        return element;
    }

    @Editor.Ignore
    public T insertFirst(IsElement element) {
        return insertFirst(element.asElement());
    }

    @Editor.Ignore
    public T insertFirst(BaseDominoElement newNode) {
        asElement().insertBefore(newNode.asElement(), asElement().firstChild);
        return element;
    }

    @Editor.Ignore
    public T setAttribute(String name, String value) {
        asElement().setAttribute(name, value);
        return element;
    }

    @Editor.Ignore
    public T setAttribute(String name, boolean value) {
        asElement().setAttribute(name, value);
        return element;
    }

    @Editor.Ignore
    public T setAttribute(String name, double value) {
        asElement().setAttribute(name, value);
        return element;
    }

    @Editor.Ignore
    public String getAttribute(String name) {
        return asElement().getAttribute(name);
    }

    @Editor.Ignore
    @Override
    public T setReadOnly(boolean readOnly) {
        if (readOnly) {
            return setAttribute("readonly", "readonly");
        } else {
            return removeAttribute("readonly");
        }
    }

    @Editor.Ignore
    @Override
    public boolean isReadOnly() {
        return hasAttribute("readonly");
    }

    @Editor.Ignore
    public T removeAttribute(String name) {
        asElement().removeAttribute(name);
        return element;
    }

    @Editor.Ignore
    public boolean hasAttribute(String name) {
        return asElement().hasAttribute(name);
    }

    @Editor.Ignore
    public boolean contains(DominoElement<? extends HTMLElement> node) {
        return contains(node.asElement());
    }

    @Editor.Ignore
    public boolean contains(Node node) {
        return asElement().contains(node);
    }

    @Editor.Ignore
    public T setTextContent(String text) {
        asElement().textContent = text;
        return element;
    }

    @Editor.Ignore
    public T setInnerHtml(String html) {
        asElement().innerHTML = new SafeHtmlBuilder().appendHtmlConstant(html)
                .toSafeHtml().asString();
        return element;
    }

    @Editor.Ignore
    public T remove() {
        asElement().remove();
        return element;
    }

    @Editor.Ignore
    public T removeChild(Node node) {
        asElement().removeChild(node);
        return element;
    }

    @Editor.Ignore
    public T removeChild(IsElement<HTMLElement> elementToRemove) {
        removeChild(elementToRemove.asElement());
        return element;
    }

    @Editor.Ignore
    public NodeList<Node> childNodes() {
        return asElement().childNodes;
    }

    @Editor.Ignore
    public Node firstChild() {
        return asElement().firstChild;
    }

    @Editor.Ignore
    public Node lastChild() {
        return asElement().lastChild;
    }

    @Editor.Ignore
    public String getTextContent() {
        return asElement().textContent;
    }

    @Editor.Ignore
    public T blur() {
        asElement().blur();
        return element;
    }

    @Editor.Ignore
    public T setTooltip(String text) {
        return setTooltip(text, PopupPosition.TOP);
    }

    @Editor.Ignore
    public T setTooltip(String text, PopupPosition position) {
        return setTooltip(TextNode.of(text), position);
    }

    @Editor.Ignore
    public T setTooltip(Node node) {
        return setTooltip(node, PopupPosition.TOP);
    }

    @Editor.Ignore
    public T setTooltip(Node node, PopupPosition position) {
        if (isNull(tooltip)) {
            tooltip = Tooltip.create(asElement(), node);
        } else {
            tooltip.setContent(node);
        }
        tooltip.position(position);
        return element;
    }

    @Editor.Ignore
    public HTMLElement getClickableElement() {
        return asElement();
    }

    @Editor.Ignore
    public HTMLElement getCollapsibleElement() {
        return asElement();
    }

    @Override
    @Editor.Ignore
    public HTMLElement getWavesElement() {
        return asElement();
    }

    @Editor.Ignore
    public T hideOn(ScreenMedia screenMedia) {
        removeHideOn();
        this.hideOn = screenMedia;
        style.add("hide-on-" + this.hideOn.getStyle());

        return element;
    }

    @Editor.Ignore
    public T removeHideOn() {
        if (nonNull(hideOn)) {
            style.remove("hide-on-" + hideOn.getStyle());
        }

        return element;
    }

    @Editor.Ignore
    public T showOn(ScreenMedia screenMedia) {
        removeShowOn();
        this.showOn = screenMedia;
        style.add("show-on-" + this.showOn.getStyle());

        return element;
    }

    @Editor.Ignore
    public T removeShowOn() {
        if (nonNull(showOn)) {
            style.remove("show-on-" + showOn.getStyle());
        }

        return element;
    }


    @Editor.Ignore
    public ClientRect getBoundingClientRect() {
        return element.asElement().getBoundingClientRect();
    }

    @Editor.Ignore
    public T styler(StyleEditor<E, T> styleEditor) {
        styleEditor.applyStyles(style());
        return element;
    }

    @Editor.Ignore
    public T addCss(String cssClass) {
        style().add(cssClass);
        return element;
    }

    @Editor.Ignore
    public T addCss(String... cssClass) {
        style().add(cssClass);
        return element;
    }

    @Editor.Ignore
    public T removeCss(String cssClass) {
        style().remove(cssClass);
        return element;
    }

    @Editor.Ignore
    public T removeCss(String... cssClass) {
        style().remove(cssClass);
        return element;
    }

    @Editor.Ignore
    public T setWidth(String width) {
        style().setWidth(width);
        return element;
    }

    @Editor.Ignore
    public T setHeight(String height) {
        style().setHeight(height);
        return element;
    }

    @Editor.Ignore
    public boolean isEqualNode(Node node) {
        return asElement().isEqualNode(node);
    }

    @Editor.Ignore
    public T withWaves() {
        this.wavesSupport = WavesSupport.addFor(element.asElement());
        return element;
    }

    @Editor.Ignore
    public T removeWaves() {
        if(nonNull(this.wavesSupport)) {
            this.wavesSupport.removeWaves();
        }
        return element;
    }

    @Editor.Ignore
    public T withWaves(WavesStyler wavesStyler) {
        wavesStyler.styleWaves(WavesSupport.addFor(element.asElement()));
        return element;
    }

    @Editor.Ignore
    public T apply(ElementHandler<T> elementHandler) {
        elementHandler.handleElement(element);
        return element;
    }


    @Editor.Ignore
    public T setContent(IsElement element) {
        return setContent(element.asElement());
    }

    @Editor.Ignore
    public T setContent(Node content) {
        clearElement();
        appendChild(content);
        return element;
    }

    @Editor.Ignore
    public int getElementsCount() {
        return new Double(asElement().childElementCount).intValue();
    }

    @Editor.Ignore
    public boolean isEmptyElement() {
        return getElementsCount() == 0;
    }

    @Editor.Ignore
    public double getChildElementCount() {
        return asElement().childElementCount;
    }

    @Editor.Ignore
    public Node getFirstChild() {
        return asElement().firstChild;
    }

    @Editor.Ignore
    public boolean hasChildNodes() {
        return asElement().hasChildNodes();
    }

    @Editor.Ignore
    public String getDominoId() {
        return uuid;
    }

    @Editor.Ignore
    public T disable() {
        setAttribute("disabled", "");
        style().add("disabled");
        return element;
    }

    @Editor.Ignore
    public T enable() {
        removeAttribute("disabled");
        style().remove("disabled");
        return element;
    }

    @Editor.Ignore
    public void setDisabled(boolean disabled) {
        if (disabled) {
            disable();
        } else {
            enable();
        }
    }

    public T elevate(int level){
        return elevate(Elevation.of(level));
    }

    public T elevate(Elevation elevation){
        if(nonNull(this.elevation)){
            style.remove(this.elevation.getStyle());
        }else{
            Elevation.removeFrom(asElement());
        }

        this.elevation = elevation;
        style.add(this.elevation.getStyle());
        return (T) this;
    }

    @Editor.Ignore
    public T addHideHandler(Collapsible.HideCompletedHandler handler) {
        collapsible.addHideHandler(handler);
        return (T) this;
    }

    @Editor.Ignore
    public T removeHideHandler(Collapsible.HideCompletedHandler handler) {
        collapsible.removeHideHandler(handler);
        return (T) this;
    }

    @Editor.Ignore
    public T addShowHandler(Collapsible.ShowCompletedHandler handler) {
        collapsible.addShowHandler(handler);
        return (T) this;
    }

    @Editor.Ignore
    public T removeShowHandler(Collapsible.ShowCompletedHandler handler) {
        collapsible.removeShowHandler(handler);
        return (T) this;
    }

    public Elevation getElevation() {
        return elevation;
    }

    @FunctionalInterface
    public interface StyleEditor<E extends HTMLElement, T extends IsElement<E>> {
        void applyStyles(Style<E, T> style);
    }

    @FunctionalInterface
    public interface WavesStyler {
        void styleWaves(WavesSupport wavesSupport);
    }

    @FunctionalInterface
    public interface ElementHandler<T> {
        void handleElement(T self);
    }

}
