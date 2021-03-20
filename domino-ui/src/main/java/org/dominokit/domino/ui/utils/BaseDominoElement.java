package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;
import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WavesSupport;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.elemento.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * This is the base implementation for all domino components.
 * <p>The class provide common behaviors and functions to interact with any component</p>
 * <p>also the class can wrap any html element to treat it as a domino component</p>
 *
 * @see DominoElement
 * @param <E> The type of the HTML element of the component extending from this class
 * @param <T> The type of the component extending from this class
 */
public abstract class BaseDominoElement<E extends HTMLElement, T extends IsElement<E>> implements IsElement<E>, IsCollapsible<T>, HasChildren<T>, HasWavesElement, IsReadOnly<T> {

    /**
     * The name of the attribute that holds a unique id for the component
     */
    public static final String DOMINO_UUID = "domino-uuid";
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
    private Optional<ElementObserver> attachObserver = Optional.empty();
    private Optional<ElementObserver> detachObserver = Optional.empty();
    private boolean collapsed = false;
    private boolean forceHidden = false;

    /**
     * initialize the component using its root element giving it a unique id, a {@link Style} and also initialize a {@link Collapsible} for the element
     * @param element T component root element
     */
    @Editor.Ignore
    protected void init(T element) {
        this.element = element;

        if (hasDominoId()) {
            uuid = getAttribute(DOMINO_UUID);
        } else {
            this.uuid = Id.unique();
            setAttribute(DOMINO_UUID, this.uuid);
        }
        this.collapsible = Collapsible.create(getCollapsibleElement());
        this.style = Style.of(element);
    }

    private boolean hasDominoId() {
        return hasAttribute(DOMINO_UUID) && nonNull(getAttribute(DOMINO_UUID)) && !getAttribute(DOMINO_UUID).isEmpty();
    }

    /**
     * sets the element id attribute
     * @param id String custom id
     * @return same component
     */
    public T setId(String id) {
        element().id = id;
        return element;
    }

    /**
     *
     * @return String value of the element id attribute
     */
    @Editor.Ignore
    public String getId() {
        return element().id;
    }

    /**
     * if the component is visible hide it, else show it
     * @see Collapsible#toggleDisplay()
     * @return same component
     */
    @Override
    @Editor.Ignore
    public T toggleDisplay() {
        collapsible.toggleDisplay();
        return element;
    }

    /**
     *
     * @see Collapsible#toggleDisplay(boolean)
     * @param state boolean, if true show the component otherwise hide it
     * @return same component
     */
    @Override
    @Editor.Ignore
    public T toggleDisplay(boolean state) {
        collapsible.toggleDisplay(state);
        return element;
    }

    /**
     * Show the item if it is hidden
     * @see Collapsible#show()
     * @return same component
     */
    @Override
    public T show() {
        collapsible.show();
        return element;
    }

    /**
     * Hides the item if it is visible
     * @see Collapsible#hide()
     * @return same component
     */
    @Override
    public T hide() {
        collapsible.hide();
        return element;
    }

    /**
     * @see Collapsible#setForceHidden(boolean)
     * @return boolean,true if force hidden is enabled
     */
    public boolean isForceHidden() {
        return collapsible.isForceHidden();
    }

    /**
     * @see Collapsible#setForceHidden(boolean)
     * @param forceHidden boolean, true to force hiding the component
     * @return same component
     */
    public T setForceHidden(boolean forceHidden) {
        collapsible.setForceHidden(forceHidden);
        return element;
    }

    /**
     *
     * @return the {@link Collapsible} of the component
     */
    @Editor.Ignore
    public Collapsible getCollapsible() {
        return collapsible;
    }

    /**
     * removes all the component child nodes
     * @return same component
     */
    @Editor.Ignore
    public T clearElement() {
        ElementUtil.clear(element());
        return element;
    }

    /**
     *
     * @return boolean, true if the component is not visible
     */
    @Override
    @Editor.Ignore
    public boolean isHidden() {
        if (isNull(collapsible)) {
            return false;
        }
        return collapsible.isHidden();
    }

    /**
     *
     * @return the HTML element of type E which is the root element of the component
     */
    public abstract E element();

    /**
     * Adds a handler to be called when the component is attached to the DOM tree
     * @param observerCallback {@link ObserverCallback}
     * @return same component
     */
    @Editor.Ignore
    public T onAttached(ObserverCallback observerCallback) {
        if (!isAttached()) {
            attachObserver = ElementUtil.onAttach(element, observerCallback);
        }
        return element;
    }

    /**
     * Adds a handler to be called when the component is removed from the DOM tree
     * @param observerCallback {@link ObserverCallback}
     * @return same component
     */
    @Editor.Ignore
    public T onDetached(ObserverCallback observerCallback) {
        detachObserver = ElementUtil.onDetach(element, observerCallback);
        return element;
    }

    /**
     * removes the attach {@link ObserverCallback}
     * @return same component
     */
    public T removeAttachObserver(){
        attachObserver.ifPresent(ElementObserver::remove);
        return element;
    }

    /**
     * removes the detach {@link ObserverCallback}
     * @return same component
     */
    public T removeDetachObserver(){
        detachObserver.ifPresent(ElementObserver::remove);
        return element;
    }

    /**
     *
     * @return Optional {@link ElementObserver} for attach
     */
    public Optional<ElementObserver> getAttachObserver() {
        return attachObserver;
    }

    /**
     *
     * @return Optional {@link ElementObserver} for detach
     */
    public Optional<ElementObserver> getDetachObserver() {
        return detachObserver;
    }

    /**
     *
     * @return boolean, true if the element is currently attached to the DOM tree
     */
    @Editor.Ignore
    public boolean isAttached() {
        return nonNull(DomGlobal.document.body.querySelector("[domino-uuid='" + uuid + "']"));
    }

    /**
     *
     * @return the {@link Style} of the component
     */
    @Editor.Ignore
    public Style<E, T> style() {
        return style;
    }

    /**
     *
     * @param cssClass String css class name to add to the compponent
     * @return same component
     */
    @Editor.Ignore
    public T css(String cssClass) {
        style.add(cssClass);
        return element;
    }

    /**
     *
     * @param cssClasses String args of css classes names to be added to the component
     * @return same component
     */
    @Editor.Ignore
    public T css(String... cssClasses) {
        style.add(cssClasses);
        return element;
    }

    /**
     *
     * @return the {@link HtmlComponentBuilder}
     */
    @Editor.Ignore
    public HtmlComponentBuilder<E, T> builder() {
        return ElementUtil.componentBuilder(element);
    }

    /**
     *
     * @param node {@link Node} to be appended to the component
     * @return same component
     */
    @Override
    @Editor.Ignore
    public T appendChild(Node node) {
        element.element().appendChild(node);
        return element;
    }

    /**
     *
     * @param isElement {@link IsElement} to be appended to the component
     * @return same component
     */
    @Override
    @Editor.Ignore
    public T appendChild(IsElement<?> isElement) {
        element.element().appendChild(isElement.element());
        return element;
    }

    /**
     *
     * @param listener {@link EventListener} to be added to the click event of the component clickable element
     * @return same component
     */
    @Editor.Ignore
    public T addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return element;
    }

    /**
     * Adds a listener for the provided event type
     * @param type String event type
     * @param listener {@link EventListener}
     * @return same component
     */
    @Editor.Ignore
    public T addEventListener(String type, EventListener listener) {
        element().addEventListener(type, listener);
        return element;
    }

    /**
     * Adds a listener for the provided event type
     * @param type {@link EventType}
     * @param listener {@link EventListener}
     * @return same component
     */
    @Editor.Ignore
    public T addEventListener(EventType<?, ?> type, EventListener listener) {
        element().addEventListener(type.getName(), listener);
        return element;
    }

    /**
     * Removes a listener for the provided event type
     * @param type EventType
     * @param listener {@link EventListener}
     * @return same component
     */
    @Editor.Ignore
    public T removeEventListener(EventType<?, ?> type, EventListener listener) {
        element().removeEventListener(type.getName(), listener);
        return element;
    }

    /**
     * Removes a listener for the provided event type
     * @param type String event type
     * @param listener {@link EventListener}
     * @return same component
     */
    @Editor.Ignore
    public T removeEventListener(String type, EventListener listener) {
        element().removeEventListener(type, listener);
        return element;
    }

    /**
     * Insert a child node before another child node
     * @param newNode {@link Node}
     * @param otherNode {@link Node}
     * @return same component
     */
	@Editor.Ignore
    @SuppressWarnings("unchecked")
    public T insertBefore(Node newNode, Node otherNode) {
        element().insertBefore(newNode, otherNode);
        return (T) this;
    }

    /**
     * Insert a child node before another child node
     * @param newNode {@link Node}
     * @param otherNode {@link BaseDominoElement}
     * @return same component
     */
    @Editor.Ignore
    public T insertBefore(Node newNode, BaseDominoElement<? extends HTMLElement, ? extends IsElement<?>> otherNode) {
        element().insertBefore(newNode, otherNode.element());
        return element;
    }

    /**
     * Insert a child node before another child node
     * @param newNode {@link BaseDominoElement}
     * @param otherNode {@link BaseDominoElement}
     * @return same component
     */
    @Editor.Ignore
    public T insertBefore(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
        element().insertBefore(newNode.element(), otherNode.element());
        return element;
    }

    /**
     * Insert a child node before another child node
     * @param newNode {@link BaseDominoElement}
     * @param otherNode {@link Node}
     * @return same component
     */
    @Editor.Ignore
    public T insertBefore(BaseDominoElement<?, ?> newNode, Node otherNode) {
        element().insertBefore(newNode.element(), otherNode);
        return element;
    }

    /**
     * Insert a child node after another child node
     * @param newNode {@link Node}
     * @param otherNode {@link Node}
     * @return same component
     */
	@Editor.Ignore
    @SuppressWarnings("unchecked")
    public T insertAfter(Node newNode, Node otherNode) {
        element().insertBefore(newNode, otherNode.nextSibling);
        return (T) this;
    }

    /**
     * Insert a child node after another child node
     * @param newNode {@link Node}
     * @param otherNode {@link BaseDominoElement}
     * @return same component
     */
    @Editor.Ignore
    public T insertAfter(Node newNode, BaseDominoElement<?, ?> otherNode) {
        element().insertBefore(newNode, otherNode.element().nextSibling);
        return element;
    }

    /**
     * Insert a child node after another child node
     * @param newNode {@link BaseDominoElement}
     * @param otherNode {@link BaseDominoElement}
     * @return same component
     */
    @Editor.Ignore
    public T insertAfter(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
        element().insertBefore(newNode.element(), otherNode.element().nextSibling);
        return element;
    }

    /**
     * Insert a child node after another child node
     * @param newNode {@link BaseDominoElement}
     * @param otherNode {@link Node}
     * @return same component
     */
    @Editor.Ignore
    public T insertAfter(BaseDominoElement<?,?> newNode, Node otherNode) {
        element().insertBefore(newNode.element(), otherNode.nextSibling);
        return element;
    }

    /**
     * Insert a node as the first child to this component
     * @param newNode {@link Node}
     * @return same component
     */
    @Editor.Ignore
    public T insertFirst(Node newNode) {
        element().insertBefore(newNode, element().firstChild);
        return element;
    }

    /**
     * Insert a node as the first child to this component
     * @param element {@link IsElement}
     * @return same component
     */
    @Editor.Ignore
    public T insertFirst(IsElement<?> element) {
        return insertFirst(element.element());
    }

    /**
     * Insert a node as the first child to this component
     * @param newNode {@link BaseDominoElement}
     * @return same component
     */
    @Editor.Ignore
    public  T insertFirst(BaseDominoElement<?, ?> newNode) {
        element().insertBefore(newNode.element(), element().firstChild);
        return element;
    }

    /**
     * Sets a String attribute value on the element
     * @param name String attribute name
     * @param value String
     * @return same component
     */
    @Editor.Ignore
    public T setAttribute(String name, String value) {
        element().setAttribute(name, value);
        return element;
    }

    /**
     * Sets a boolean attribute value on the element
     * @param name String attribute name
     * @param value boolean
     * @return same component
     */
    @Editor.Ignore
    public T setAttribute(String name, boolean value) {
        element().setAttribute(name, value);
        return element;
    }
    /**
     * Sets a double attribute value on the element
     * @param name String attribute name
     * @param value double
     * @return same component
     */
    @Editor.Ignore
    public T setAttribute(String name, double value) {
        element().setAttribute(name, value);
        return element;
    }

    /**
     *
     * @param name String
     * @return the String value of the attribute
     */
    @Editor.Ignore
    public String getAttribute(String name) {
        return element().getAttribute(name);
    }

    /**
     * set the readonly attribute value
     * {@inheritDoc}
     */
    @Editor.Ignore
    @Override
    public T setReadOnly(boolean readOnly) {
        if (readOnly) {
            return setAttribute("readonly", "readonly");
        } else {
            return removeAttribute("readonly");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Editor.Ignore
    @Override
    public boolean isReadOnly() {
        return hasAttribute("readonly");
    }

    /**
     *
     * @param name String name of the attribute to be removed
     * @return same component
     */
    @Editor.Ignore
    public T removeAttribute(String name) {
        element().removeAttribute(name);
        return element;
    }

    /**
     * Check of the component has the provided attribute
     * @param name String
     * @return boolean, true if the component has the attribute
     */
    @Editor.Ignore
    public boolean hasAttribute(String name) {
        return element().hasAttribute(name);
    }

    /**
     * Check if a provided node a child of the component
     * @param node {@link DominoElement}
     * @return boolean, true if the node is a child of this component
     */
    @Editor.Ignore
    public boolean contains(DominoElement<? extends HTMLElement> node) {
        return contains(node.element());
    }

    /**
     * Check if a provided node a child of the component
     * @param node {@link Node}
     * @return boolean, true if the node is a child of this component
     */
    @Editor.Ignore
    public boolean contains(Node node) {
        return element().contains(node);
    }

    /**
     * Check if a provided node a a direct child of the component
     * @param node {@link Node}
     * @return boolean, true if the node is a direct child of this component
     */
    public boolean hasDirectChild(Node node) {
        Node parentNode = node.parentNode;
        if(isNull(parentNode)){
            return false;
        }
        return parentNode.equals(element.element());
    }

    /**
     *
     * @param text String text content
     * @return same component
     */
    @Editor.Ignore
    public T setTextContent(String text) {
        element().textContent = text;
        return element;
    }

    /**
     *
     * @param html String html text
     * @return same component
     */
    @Editor.Ignore
    public T setInnerHtml(String html) {
        element().innerHTML = new SafeHtmlBuilder().appendHtmlConstant(html)
                .toSafeHtml().asString();
        return element;
    }

    /**
     * removes the element from the DOM tree
     * @return same component
     */
    @Editor.Ignore
    public T remove() {
        element().remove();
        return element;
    }

    /**
     * Removes a child node from this component
     * @param node {@link Node}
     * @return same component
     */
    @Editor.Ignore
    public T removeChild(Node node) {
        element().removeChild(node);
        return element;
    }

    /**
     * Removes a child node from this component
     * @param elementToRemove {@link IsElement}
     * @return same component
     */
    @Editor.Ignore
    public T removeChild(IsElement<HTMLElement> elementToRemove) {
        removeChild(elementToRemove.element());
        return element;
    }

    /**
     *
     * @return the {@link NodeList} of the component children nodes
     */
    @Editor.Ignore
    public NodeList<Node> childNodes() {
        return element().childNodes;
    }

    /**
     *
     * @return the first child {@link Node} of the component
     */
    @Editor.Ignore
    public Node firstChild() {
        return element().firstChild;
    }

    /**
     *
     * @return the last child {@link Node} of the component
     */
    @Editor.Ignore
    public Node lastChild() {
        return element().lastChild;
    }

    /**
     *
     * @return String text content of the component
     */
    @Editor.Ignore
    public String getTextContent() {
        return element().textContent;
    }

    /**
     * un-focus the component
     * @return same component
     */
    @Editor.Ignore
    public T blur() {
        element().blur();
        return element;
    }

    /**
     * @see Tooltip
     * @param text String tooltip
     * @return same component
     */
    @Editor.Ignore
    public T setTooltip(String text) {
        return setTooltip(text, PopupPosition.TOP);
    }

    /**
     * @see Tooltip
     * @param text String tooltip
     * @param position {@link PopupPosition}
     * @return same component
     */
    @Editor.Ignore
    public T setTooltip(String text, PopupPosition position) {
        return setTooltip(TextNode.of(text), position);
    }
    /**
     * @see Tooltip
     * @param node {@link Node} tooltip content
     * @return same component
     */
    @Editor.Ignore
    public T setTooltip(Node node) {
        return setTooltip(node, PopupPosition.TOP);
    }

    /**
     * @see Tooltip
     * @param node {@link Node} tooltip content
     * @param position {@link PopupPosition}
     * @return same component
     */
    @Editor.Ignore
    public T setTooltip(Node node, PopupPosition position) {
        if (isNull(tooltip)) {
            tooltip = Tooltip.create(element(), node);
        } else {
            tooltip.setContent(node);
        }
        tooltip.position(position);
        return element;
    }

    /**
     * removes the component {@link Tooltip}
     * @return same component
     */
    @Editor.Ignore
    public T removeTooltip() {
        if (nonNull(tooltip)) {
        	tooltip.detach();
        	tooltip = null;
        }
        return element;
    }

    /**
     * {@inheritDoc}
     * by default this return the same component root element
     */
    @Editor.Ignore
    public HTMLElement getClickableElement() {
        return element();
    }

    /**
     * By default this return the component root element
     * @return the component {@link HTMLElement} that can be shown/hidden with the {@link Collapsible}
     *
     */
    @Editor.Ignore
    public HTMLElement getCollapsibleElement() {
        return element();
    }

    /**
     *
     * @return the {@link HTMLElement} that will produce the {@link org.dominokit.domino.ui.style.Waves} effect
     */
    @Override
    @Editor.Ignore
    public HTMLElement getWavesElement() {
        return element();
    }

    /**
     * hides the item for the provided {@link ScreenMedia}
     * @param screenMedia {@link ScreenMedia}
     * @return same component
     */
    @Editor.Ignore
    public T hideOn(ScreenMedia screenMedia) {
        removeHideOn();
        this.hideOn = screenMedia;
        style.add("hide-on-" + this.hideOn.getStyle());

        return element;
    }

    /**
     * Removes the hideOn bindings
     * @return same component
     */
    @Editor.Ignore
    public T removeHideOn() {
        if (nonNull(hideOn)) {
            style.remove("hide-on-" + hideOn.getStyle());
        }

        return element;
    }

    /**
     * show the item for the provided {@link ScreenMedia}
     * @param screenMedia {@link ScreenMedia}
     * @return same component
     */
    @Editor.Ignore
    public T showOn(ScreenMedia screenMedia) {
        removeShowOn();
        this.showOn = screenMedia;
        style.add("show-on-" + this.showOn.getStyle());

        return element;
    }

    /**
     * Removes the showOn bindings
     * @return same component
     */
    @Editor.Ignore
    public T removeShowOn() {
        if (nonNull(showOn)) {
            style.remove("show-on-" + showOn.getStyle());
        }

        return element;
    }

    /**
     *
     * @return the {@link DOMRect} for the component root element
     */
    @Editor.Ignore
    public DOMRect getBoundingClientRect() {
        return element.element().getBoundingClientRect();
    }

    /**
     * use and instance of the component style to edit it
     * @param styleEditor {@link StyleEditor}
     * @return same component
     */
    @Editor.Ignore
    public T styler(StyleEditor<E, T> styleEditor) {
        styleEditor.applyStyles(style());
        return element;
    }

    /**
     *
     * @param cssClass String css class name
     * @return same component
     */
    @Editor.Ignore
    public T addCss(String cssClass) {
        style().add(cssClass);
        return element;
    }

    /**
     *
     * @param cssClass String args of css classes names
     * @return same component
     */
    @Editor.Ignore
    public T addCss(String... cssClass) {
        style().add(cssClass);
        return element;
    }

    /**
     *
     * @param cssClass String css class name
     * @return same component
     */
    @Editor.Ignore
    public T removeCss(String cssClass) {
        style().remove(cssClass);
        return element;
    }

    /**
     *
     * @param cssClass String args css classes names
     * @return same component
     */
    @Editor.Ignore
    public T removeCss(String... cssClass) {
        style().remove(cssClass);
        return element;
    }

    /**
     *
     * @param width String css width
     * @return same component
     */
    @Editor.Ignore
    public T setWidth(String width) {
        style().setWidth(width);
        return element;
    }

    /**
     *
     * @param height String css height
     * @return same component
     */
    @Editor.Ignore
    public T setHeight(String height) {
        style().setHeight(height);
        return element;
    }

    /**
     * Check if the element is same provided node
     * @param node Node
     * @return boolean, true if the provided node is same as this component node
     */
    @Editor.Ignore
    public boolean isEqualNode(Node node) {
        return element().isEqualNode(node);
    }

    /**
     * Adds default {@link WavesSupport} to this component
     * @return same component
     */
    @Editor.Ignore
    public T withWaves() {
        this.wavesSupport = WavesSupport.addFor(element.element());
        return element;
    }

    /**
     * Removes the {@link WavesSupport} effect for this component
     * @return same component
     */
    @Editor.Ignore
    public T removeWaves() {
        if (nonNull(this.wavesSupport)) {
            this.wavesSupport.removeWaves();
        }
        return element;
    }

    /**
     * Adds {@link WavesSupport} to this component with a custom WaveStyler
     * @param wavesStyler {@link WavesStyler}
     * @return same component
     */
    @Editor.Ignore
    public T withWaves(WavesStyler wavesStyler) {
        wavesStyler.styleWaves(WavesSupport.addFor(element.element()));
        return element;
    }

    /**
     * Applies a function on this component
     * @param elementHandler {@link ElementHandler}
     * @return same component
     */
    @Editor.Ignore
    public T apply(ElementHandler<T> elementHandler) {
        elementHandler.handleElement(element);
        return element;
    }

    /**
     *
     * @param element the {@link IsElement} content to replace the current content
     * @return same component
     */
    @Editor.Ignore
    public T setContent(IsElement<?> element) {
        return setContent(element.element());
    }

    /**
     *
     * @param content the {@link Node} content to replace the current content
     * @return same component
     */
    @Editor.Ignore
    public T setContent(Node content) {
        clearElement();
        appendChild(content);
        return element;
    }

    /**
     *
     * @return int count of the component children
     */
    @Editor.Ignore
    public int getElementsCount() {
        return new Double(element().childElementCount).intValue();
    }

    /**
     *
     * @return boolean, true if the component has no children
     */
    @Editor.Ignore
    public boolean isEmptyElement() {
        return getElementsCount() == 0;
    }

    /**
     *
     * @return double count of the component children
     */
    @Editor.Ignore
    public double getChildElementCount() {
        return element().childElementCount;
    }

    /**
     *
     * @return the first {@link Node} in this component
     */
    @Editor.Ignore
    public Node getFirstChild() {
        return element().firstChild;
    }

    /**
     *
     * @return boolean, true if the component has child nodes
     */
    @Editor.Ignore
    public boolean hasChildNodes() {
        return element().hasChildNodes();
    }

    /**
     *
     * @return String, the assigned unique domino-uuid to the component
     */
    @Editor.Ignore
    public String getDominoId() {
        return uuid;
    }

    /**
     * {@inheritDoc}
     */
    @Editor.Ignore
    public T disable() {
        setAttribute("disabled", "");
        style().add("disabled");
        return element;
    }

    /**
     *
     * @return boolean, true if the component is disabled
     */
    public boolean isDisabled() {
        return hasAttribute("disabled");
    }

    /**
     * {@inheritDoc}
     */
    @Editor.Ignore
    public T enable() {
        removeAttribute("disabled");
        style().remove("disabled");
        return element;
    }

    /**
     * Disable/Enable the component base on provided flag
     * @param disabled boolean, true to disable the component, false to enable it
     * @return same component
     */
    @Editor.Ignore
    public T setDisabled(boolean disabled) {
        if (disabled) {
            return disable();
        } else {
            return enable();
        }
    }

    /**
     * Adds a box-shadow to the component
     * @param level int {@link Elevation} level
     * @return same component
     */
    public T elevate(int level) {
        return elevate(Elevation.of(level));
    }
    /**
     * Adds a box-shadow to the component
     * @param elevation {@link Elevation}
     * @return same component
     */
    @SuppressWarnings("unchecked")
    public T elevate(Elevation elevation) {
        if (nonNull(this.elevation)) {
            style.remove(this.elevation.getStyle());
        } else {
            Elevation.removeFrom(element());
        }

        this.elevation = elevation;
        style.add(this.elevation.getStyle());
        return (T) this;
    }

    /**
     * @see Collapsible#addHideHandler(Collapsible.HideCompletedHandler)
     * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.HideCompletedHandler}
     * @return same component
     */
    @Editor.Ignore
    @SuppressWarnings("unchecked")
    public T addHideListener(Collapsible.HideCompletedHandler handler) {
        collapsible.addHideHandler(handler);
        return (T) this;
    }

    /**
     * @see Collapsible#removeHideHandler(Collapsible.HideCompletedHandler)
     * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.HideCompletedHandler}
     * @return same component
     */
    @Editor.Ignore
    @SuppressWarnings("unchecked")
    public T removeHideListener(Collapsible.HideCompletedHandler handler) {
        collapsible.removeHideHandler(handler);
        return (T) this;
    }

    /**
     * @see Collapsible#addShowHandler(Collapsible.ShowCompletedHandler)
     * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ShowCompletedHandler}
     * @return same component
     */
    @Editor.Ignore
    @SuppressWarnings("unchecked")
    public T addShowListener(Collapsible.ShowCompletedHandler handler) {
        collapsible.addShowHandler(handler);
        return (T) this;
    }

    /**
     * @see Collapsible#removeShowHandler(Collapsible.ShowCompletedHandler)
     * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ShowCompletedHandler}
     * @return same component
     */
    @Editor.Ignore
    @SuppressWarnings("unchecked")
    public T removeShowListener(Collapsible.ShowCompletedHandler handler) {
        collapsible.removeShowHandler(handler);
        return (T) this;
    }

    /**
     *
     * @return the currently applied {@link Elevation}
     */
    public Elevation getElevation() {
        return elevation;
    }

    /**
     *
     * @return the component {@link Tooltip}
     */
    public Tooltip getTooltip() {
        return tooltip;
    }

    /**
     * A function to edit a component style
     * @param <E> The type of the component root html element
     * @param <T> the toe of the component
     */
    @FunctionalInterface
    public interface StyleEditor<E extends HTMLElement, T extends IsElement<E>> {
        /**
         *
         * @param style {@link Style} for the component
         */
        void applyStyles(Style<E, T> style);
    }

    /**
     * a function to add waves effect to a component
     */
    @FunctionalInterface
    public interface WavesStyler {
        /**
         *
         * @param wavesSupport {@link WavesSupport}
         */
        void styleWaves(WavesSupport wavesSupport);
    }

    /**
     * A function to apply generic logic to a component
     * @param <T> the type of the component
     */
    @FunctionalInterface
    public interface ElementHandler<T> {
        /**
         *
         * @param self the T component instance
         */
        void handleElement(T self);
    }

}
