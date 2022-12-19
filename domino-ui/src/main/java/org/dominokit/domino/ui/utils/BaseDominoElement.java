/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.utils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.core.JsArray;
import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.menu.AbstractMenu;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.DominoStyle;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WavesSupport;
import org.gwtproject.editor.client.Editor;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.elemento.EventType;
import org.jboss.elemento.Id;
import org.jboss.elemento.IsElement;
import org.jboss.elemento.ObserverCallback;

/**
 * This is the base implementation for all domino components.
 *
 * <p>The class provide common behaviors and functions to interact with any component
 *
 * <p>also the class can wrap any html element to treat it as a domino component
 *
 * @param <E> The type of the HTML element of the component extending from this class
 * @param <T> The type of the component extending from this class
 * @see DominoElement
 */
public abstract class BaseDominoElement<E extends HTMLElement, T extends IsElement<E>>
    implements IsElement<E>,
        IsCollapsible<T>,
        HasChildren<T>,
        HasWavesElement,
        IsReadOnly<T>,
        DominoStyle<E, T, T> {

  /** The name of the attribute that holds a unique id for the component */
  private static final String DOMINO_UUID = "domino-uuid";

  @Editor.Ignore protected T element;
  private String uuid;
  private Tooltip tooltip;
  private Collapsible collapsible;
  @Editor.Ignore private Style<E, T> style;
  private LambdaFunction styleInitializer;
  private ScreenMedia hideOn;
  private ScreenMedia showOn;
  private Elevation elevation;
  private WavesSupport wavesSupport;
  private Optional<ElementObserver> attachObserver = Optional.empty();
  private Optional<ElementObserver> detachObserver = Optional.empty();
  private Optional<ResizeObserver> resizeObserverOptional = Optional.empty();
  private LambdaFunction dominoUuidInitializer;

  /**
   * initialize the component using its root element giving it a unique id, a {@link Style} and also
   * initialize a {@link Collapsible} for the element
   *
   * @param element T component root element
   */
  @Editor.Ignore
  protected void init(T element) {
    this.element = element;

    dominoUuidInitializer =
        () -> {
          if (hasDominoId()) {
            uuid = getAttribute(DOMINO_UUID);
          } else {
            this.uuid = Id.unique();
            setAttribute(DOMINO_UUID, this.uuid);
            if (!hasId()) {
              element().id = this.uuid;
            }
          }
          dominoUuidInitializer = () -> {};
        };

    styleInitializer =
        () -> {
          this.style = Style.of(element);
          styleInitializer = () -> {};
        };
  }

  private boolean hasDominoId() {
    return hasAttribute(DOMINO_UUID)
        && nonNull(getAttribute(DOMINO_UUID))
        && !getAttribute(DOMINO_UUID).isEmpty();
  }

  private boolean hasId() {
    return hasAttribute("id") && nonNull(getAttribute("id")) && !getAttribute("id").isEmpty();
  }

  /**
   * sets the element id attribute
   *
   * @param id String custom id
   * @return same component
   */
  public T setId(String id) {
    element().id = id;
    return element;
  }

  /**
   * sets the element tabIndex attribute
   *
   * @param tabIndex int tabIndex
   * @return same component
   */
  public T setTabIndex(int tabIndex) {
    element().tabIndex = tabIndex;
    return element;
  }

  /**
   * sets the element id attribute
   *
   * @param id String custom id
   * @return same component
   */
  public T id(String id) {
    return setId(id);
  }

  /** @return String value of the element id attribute */
  @Editor.Ignore
  public String getId() {
    dominoUuidInitializer.apply();
    return element().id;
  }

  /**
   * if the component is visible hide it, else show it
   *
   * @return same component
   * @see Collapsible#toggleDisplay()
   */
  @Override
  @Editor.Ignore
  public T toggleDisplay() {
    getCollapsible().toggleDisplay();
    return element;
  }

  /**
   * @param state boolean, if true show the component otherwise hide it
   * @return same component
   * @see Collapsible#toggleDisplay(boolean)
   */
  @Override
  @Editor.Ignore
  public T toggleDisplay(boolean state) {
    getCollapsible().toggleDisplay(state);
    return element;
  }

  /**
   * Show the item if it is hidden
   *
   * @return same component
   * @see Collapsible#show()
   */
  @Override
  public T show() {
    getCollapsible().show();
    return element;
  }

  /**
   * Hides the item if it is visible
   *
   * @return same component
   * @see Collapsible#hide()
   */
  @Override
  public T hide() {
    getCollapsible().hide();
    return element;
  }

  /**
   * @return boolean, true if force hidden is enabled
   * @see Collapsible#setForceHidden(boolean)
   */
  public boolean isForceHidden() {
    return getCollapsible().isForceHidden();
  }

  /**
   * @param forceHidden boolean, true to force hiding the component
   * @return same component
   * @see Collapsible#setForceHidden(boolean)
   */
  public T setForceHidden(boolean forceHidden) {
    getCollapsible().setForceHidden(forceHidden);
    return element;
  }

  /** @return the {@link Collapsible} of the component */
  @Editor.Ignore
  public Collapsible getCollapsible() {
    if (isNull(this.collapsible)) {
      this.collapsible = Collapsible.create(getCollapsibleElement());
    }
    return collapsible;
  }

  /**
   * Change the {@link CollapseStrategy} for the element
   *
   * @param strategy the {@link CollapseStrategy}
   * @return same component
   */
  @Editor.Ignore
  public T setCollapseStrategy(CollapseStrategy strategy) {
    this.getCollapsible().setStrategy(strategy);
    return (T) this;
  }

  /**
   * removes all the component child nodes
   *
   * @return same component
   */
  @Editor.Ignore
  public T clearElement() {
    ElementUtil.clear(element());
    return element;
  }

  /**
   * @deprecated use {@link #isCollapsed()}
   * @return boolean, true if the component is not visible
   */
  @Override
  @Editor.Ignore
  @Deprecated
  public boolean isHidden() {
    return isCollapsed();
  }

  /** @return boolean, true if the component is not visible */
  @Override
  @Editor.Ignore
  public boolean isCollapsed() {
    return getCollapsible().isCollapsed();
  }

  /** @return the HTML element of type E which is the root element of the component */
  public abstract E element();

  /**
   * Adds a handler to be called when the component is attached to the DOM tree
   *
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
   *
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
   *
   * @return same component
   */
  public T removeAttachObserver() {
    attachObserver.ifPresent(ElementObserver::remove);
    return element;
  }

  /**
   * removes the detach {@link ObserverCallback}
   *
   * @return same component
   */
  public T removeDetachObserver() {
    detachObserver.ifPresent(ElementObserver::remove);
    return element;
  }

  /** @return Optional {@link ElementObserver} for attach */
  public Optional<ElementObserver> getAttachObserver() {
    return attachObserver;
  }

  /** @return Optional {@link ElementObserver} for detach */
  public Optional<ElementObserver> getDetachObserver() {
    return detachObserver;
  }

  /** @return boolean, true if the element is currently attached to the DOM tree */
  @Editor.Ignore
  public boolean isAttached() {
    dominoUuidInitializer.apply();
    return nonNull(DomGlobal.document.body.querySelector("[domino-uuid='" + uuid + "']"));
  }

  /**
   * Register a call back to listen to element size changes, the observation will only start after
   * the element is attached and will be stopped when the element is detached
   *
   * @param resizeHandler {@link ResizeHandler}
   * @return same component instance
   */
  @Editor.Ignore
  public T onResize(ResizeHandler<T> resizeHandler) {
    resizeObserverOptional.ifPresent(
        observer -> {
          observer.unobserve(element());
          observer.disconnect();
        });
    onAttached(
        mutationRecord -> {
          ResizeObserver resizeObserver =
              new ResizeObserver(
                  entries -> {
                    resizeObserverOptional.ifPresent(
                        observer -> {
                          resizeHandler.onResize((T) BaseDominoElement.this, observer, entries);
                        });
                  });
          this.resizeObserverOptional = Optional.of(resizeObserver);
          resizeObserver.observe(this.element());
        });

    onDetached(
        mutationRecord -> {
          resizeObserverOptional.ifPresent(
              observer -> {
                observer.unobserve(element());
                observer.disconnect();
              });
          resizeObserverOptional = Optional.empty();
        });
    return (T) this;
  }

  /** @return the {@link Style} of the component */
  @Editor.Ignore
  public Style<E, T> style() {
    styleInitializer.apply();
    return style;
  }
  /** Sets the CSS style of the element. */
  public T style(String style) {
    element().style.cssText = style;
    return (T) this;
  }
  /**
   * @param cssClass String css class name to add to the component
   * @return same component
   */
  @Editor.Ignore
  public T css(String cssClass) {
    addCss(cssClass);
    return element;
  }

  /**
   * @param cssClasses String args of css classes names to be added to the component
   * @return same component
   */
  @Editor.Ignore
  public T css(String... cssClasses) {
    addCss(cssClasses);
    return element;
  }

  /**
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
   * @param isElement {@link IsElement} to be appended to the component
   * @return same component
   */
  @Override
  @Editor.Ignore
  public T appendChild(IsElement<?> isElement) {
    element.element().appendChild(isElement.element());
    return element;
  }

  public T add(IsElement<?> isElement) {
    return appendChild(isElement);
  }

  public T add(Node element) {
    return appendChild(element);
  }

  /**
   * @param listener {@link EventListener} to be added to the click event of the component clickable
   *     element
   * @return same component
   */
  @Editor.Ignore
  public T addClickListener(EventListener listener) {
    getClickableElement().addEventListener(EventType.click.getName(), listener);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
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
   *
   * @param type String event type
   * @param listener {@link EventListener}
   * @param capture boolean option
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener, boolean capture) {
    element().addEventListener(type, listener, capture);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param listener {@link EventListener}
   * @param events String array of event types
   * @return same component
   */
  @Editor.Ignore
  public T addEventsListener(EventListener listener, String... events) {
    Arrays.asList(events)
        .forEach(
            eventName -> {
              element().addEventListener(eventName, listener);
            });

    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
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
   *
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
   *
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
   *
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
   *
   * @param newNode {@link Node}
   * @param otherNode {@link BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertBefore(
      Node newNode, BaseDominoElement<? extends HTMLElement, ? extends IsElement<?>> otherNode) {
    element().insertBefore(newNode, otherNode.element());
    return element;
  }

  /**
   * Insert a child node before another child node
   *
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
   *
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
   *
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
   *
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
   *
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
   *
   * @param newNode {@link BaseDominoElement}
   * @param otherNode {@link Node}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfter(BaseDominoElement<?, ?> newNode, Node otherNode) {
    element().insertBefore(newNode.element(), otherNode.nextSibling);
    return element;
  }

  /**
   * Insert a node as the first child to this component
   *
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
   *
   * @param element {@link IsElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertFirst(IsElement<?> element) {
    return insertFirst(element.element());
  }

  /**
   * Insert a node as the first child to this component
   *
   * @param newNode {@link BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertFirst(BaseDominoElement<?, ?> newNode) {
    element().insertBefore(newNode.element(), element().firstChild);
    return element;
  }

  /**
   * Sets a String attribute value on the element
   *
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
   * Sets a String attribute value on the element
   *
   * @param name String attribute name
   * @param value String
   * @return same component
   */
  @Editor.Ignore
  public T attr(String name, String value) {
    return setAttribute(name, value);
  }

  /**
   * Sets a boolean attribute value on the element
   *
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
   *
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
   * @param name String
   * @return the String value of the attribute
   */
  @Editor.Ignore
  public String getAttribute(String name) {
    return element().getAttribute(name);
  }

  /** set the readonly attribute value {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T setReadOnly(boolean readOnly) {
    if (readOnly) {
      return setAttribute("readonly", "readonly");
    } else {
      return removeAttribute("readonly");
    }
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public boolean isReadOnly() {
    return hasAttribute("readonly");
  }

  /**
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
   *
   * @param name String
   * @return boolean, true if the component has the attribute
   */
  @Editor.Ignore
  public boolean hasAttribute(String name) {
    return element().hasAttribute(name);
  }

  /**
   * Check if a provided node a child of the component
   *
   * @param node {@link DominoElement}
   * @return boolean, true if the node is a child of this component
   */
  @Editor.Ignore
  public boolean contains(DominoElement<? extends HTMLElement> node) {
    return contains(node.element());
  }

  /**
   * Check if a provided node a child of the component
   *
   * @param node {@link Node}
   * @return boolean, true if the node is a child of this component
   */
  @Editor.Ignore
  public boolean contains(Node node) {
    return element().contains(node);
  }

  /**
   * Check if a provided node a a direct child of the component
   *
   * @param node {@link Node}
   * @return boolean, true if the node is a direct child of this component
   */
  public boolean hasDirectChild(Node node) {
    Node parentNode = node.parentNode;
    if (isNull(parentNode)) {
      return false;
    }
    return parentNode.equals(element.element());
  }

  /**
   * @param text String text content
   * @return same component
   */
  @Editor.Ignore
  public T setTextContent(String text) {
    element().textContent = text;
    return element;
  }

  /**
   * @param text String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(String text) {
    element().textContent = text;
    return element;
  }

  /**
   * @param html String html text
   * @return same component
   */
  @Editor.Ignore
  public T setInnerHtml(String html) {
    element().innerHTML = new SafeHtmlBuilder().appendHtmlConstant(html).toSafeHtml().asString();
    return element;
  }

  /**
   * removes the element from the DOM tree
   *
   * @return same component
   */
  @Editor.Ignore
  public T remove() {
    element().remove();
    return element;
  }

  /**
   * Removes a child node from this component
   *
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
   *
   * @param elementToRemove {@link IsElement}
   * @return same component
   */
  @Editor.Ignore
  public T removeChild(IsElement<?> elementToRemove) {
    removeChild(elementToRemove.element());
    return element;
  }

  /** @return the {@link NodeList} of the component children nodes */
  @Editor.Ignore
  public NodeList<Node> childNodes() {
    return element().childNodes;
  }

  /** @return the first child {@link Node} of the component */
  @Editor.Ignore
  public Node firstChild() {
    return element().firstChild;
  }

  /** @return the last child {@link Node} of the component */
  @Editor.Ignore
  public Node lastChild() {
    return element().lastChild;
  }

  /** @return String text content of the component */
  @Editor.Ignore
  public String getTextContent() {
    return element().textContent;
  }

  /**
   * un-focus the component
   *
   * @return same component
   */
  @Editor.Ignore
  public T blur() {
    element().blur();
    return element;
  }

  /**
   * @param text String tooltip
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(String text) {
    return setTooltip(text, PopupPosition.TOP);
  }

  /**
   * @param text String tooltip
   * @param position {@link PopupPosition}
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(String text, PopupPosition position) {
    return setTooltip(TextNode.of(text), position);
  }

  /**
   * @param node {@link Node} tooltip content
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(Node node) {
    return setTooltip(node, PopupPosition.TOP);
  }

  /**
   * @param node {@link Node} tooltip content
   * @param position {@link PopupPosition}
   * @return same component
   * @see Tooltip
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
   *
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

  /** {@inheritDoc} by default this return the same component root element */
  @Editor.Ignore
  public HTMLElement getClickableElement() {
    return element();
  }

  /**
   * By default this return the component root element
   *
   * @return the component {@link HTMLElement} that can be shown/hidden with the {@link Collapsible}
   */
  @Editor.Ignore
  public HTMLElement getCollapsibleElement() {
    return element();
  }

  /**
   * @return the {@link HTMLElement} that will produce the {@link
   *     org.dominokit.domino.ui.style.Waves} effect
   */
  @Override
  @Editor.Ignore
  public HTMLElement getWavesElement() {
    return element();
  }

  /**
   * hides the item for the provided {@link ScreenMedia}
   *
   * @param screenMedia {@link ScreenMedia}
   * @return same component
   */
  @Editor.Ignore
  public T hideOn(ScreenMedia screenMedia) {
    removeHideOn();
    this.hideOn = screenMedia;
    addCss("hide-on-" + this.hideOn.getStyle());

    return element;
  }

  /**
   * Removes the hideOn bindings
   *
   * @return same component
   */
  @Editor.Ignore
  public T removeHideOn() {
    if (nonNull(hideOn)) {
      removeCss("hide-on-" + hideOn.getStyle());
    }

    return element;
  }

  /**
   * show the item for the provided {@link ScreenMedia}
   *
   * @param screenMedia {@link ScreenMedia}
   * @return same component
   */
  @Editor.Ignore
  public T showOn(ScreenMedia screenMedia) {
    removeShowOn();
    this.showOn = screenMedia;
    addCss("show-on-" + this.showOn.getStyle());
    return element;
  }

  /**
   * Removes the showOn bindings
   *
   * @return same component
   */
  @Editor.Ignore
  public T removeShowOn() {
    if (nonNull(showOn)) {
      removeCss("show-on-" + showOn.getStyle());
    }

    return element;
  }

  /** @return the {@link DOMRect} for the component root element */
  @Editor.Ignore
  public DOMRect getBoundingClientRect() {
    return element.element().getBoundingClientRect();
  }

  /**
   * use and instance of the component style to edit it
   *
   * @param styleEditor {@link StyleEditor}
   * @return same component
   */
  @Editor.Ignore
  public T styler(StyleEditor<E, T> styleEditor) {
    styleEditor.applyStyles(style());
    return element;
  }

  /**
   * @param cssClass String args of css classes names
   * @return same component
   */
  @Editor.Ignore
  public T addCss(String... cssClass) {
    style().addCss(cssClass);
    return element;
  }

  /**
   * @param cssClass String args css classes names
   * @return same component
   */
  @Editor.Ignore
  public T removeCss(String... cssClass) {
    style().removeCss(cssClass);
    return element;
  }

  /**
   * @param width String css width
   * @return same component
   */
  @Editor.Ignore
  public T setWidth(String width) {
    style().setWidth(width);
    return element;
  }

  /**
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
   *
   * @param node Node
   * @return boolean, true if the provided node is same as this component node
   */
  @Editor.Ignore
  public boolean isEqualNode(Node node) {
    return element().isEqualNode(node);
  }

  /**
   * Adds default {@link WavesSupport} to this component
   *
   * @return same component
   */
  @Editor.Ignore
  public T withWaves() {
    this.wavesSupport = WavesSupport.addFor(element.element());
    return element;
  }

  /**
   * Removes the {@link WavesSupport} effect for this component
   *
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
   *
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
   *
   * @param elementHandler {@link ElementHandler}
   * @return same component
   */
  @Editor.Ignore
  public T apply(ElementHandler<T> elementHandler) {
    elementHandler.handleElement(element);
    return element;
  }

  /**
   * @param element the {@link IsElement} content to replace the current content
   * @return same component
   */
  @Editor.Ignore
  public T setContent(IsElement<?> element) {
    return setContent(element.element());
  }

  /**
   * @param content the {@link Node} content to replace the current content
   * @return same component
   */
  @Editor.Ignore
  public T setContent(Node content) {
    clearElement();
    appendChild(content);
    return element;
  }

  /** @return int count of the component children */
  @Editor.Ignore
  public int getElementsCount() {
    return new Double(element().childElementCount).intValue();
  }

  /** @return boolean, true if the component has no children */
  @Editor.Ignore
  public boolean isEmptyElement() {
    return getElementsCount() == 0 && (isNull(getTextContent()) || getTextContent().isEmpty());
  }

  /** @return double count of the component children */
  @Editor.Ignore
  public double getChildElementCount() {
    return element().childElementCount;
  }

  /** @return the first {@link Node} in this component */
  @Editor.Ignore
  public Node getFirstChild() {
    return element().firstChild;
  }

  /** @return boolean, true if the component has child nodes */
  @Editor.Ignore
  public boolean hasChildNodes() {
    return element().hasChildNodes();
  }

  /** @return String, the assigned unique domino-uuid to the component */
  @Editor.Ignore
  public String getDominoId() {
    dominoUuidInitializer.apply();
    return uuid;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  public T disable() {
    setAttribute("disabled", "");
    addCss("disabled");
    return element;
  }

  /** @return boolean, true if the component is disabled */
  public boolean isDisabled() {
    return hasAttribute("disabled");
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  public T enable() {
    removeAttribute("disabled");
    removeCss("disabled");
    return element;
  }

  /**
   * Disable/Enable the component base on provided flag
   *
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
   *
   * @param level int {@link Elevation} level
   * @return same component
   */
  public T elevate(int level) {
    return elevate(Elevation.of(level));
  }

  /**
   * Adds a box-shadow to the component
   *
   * @param elevation {@link Elevation}
   * @return same component
   */
  @SuppressWarnings("unchecked")
  public T elevate(Elevation elevation) {
    if (nonNull(this.elevation)) {
      removeCss(this.elevation.getStyle());
    } else {
      Elevation.removeFrom(element());
    }

    this.elevation = elevation;
    addCss(this.elevation.getStyle());
    return (T) this;
  }

  /**
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.HideCompletedHandler}
   * @return same component
   * @see Collapsible#addHideHandler(Collapsible.HideCompletedHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addHideListener(Collapsible.HideCompletedHandler handler) {
    getCollapsible().addHideHandler(handler);
    return (T) this;
  }

  /**
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.HideCompletedHandler}
   * @return same component
   * @see Collapsible#removeHideHandler(Collapsible.HideCompletedHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeHideListener(Collapsible.HideCompletedHandler handler) {
    getCollapsible().removeHideHandler(handler);
    return (T) this;
  }

  /**
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ShowCompletedHandler}
   * @return same component
   * @see Collapsible#addShowHandler(Collapsible.ShowCompletedHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addShowListener(Collapsible.ShowCompletedHandler handler) {
    getCollapsible().addShowHandler(handler);
    return (T) this;
  }

  /**
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ShowCompletedHandler}
   * @return same component
   * @see Collapsible#removeShowHandler(Collapsible.ShowCompletedHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeShowListener(Collapsible.ShowCompletedHandler handler) {
    getCollapsible().removeShowHandler(handler);
    return (T) this;
  }

  /** @return the currently applied {@link Elevation} */
  public Elevation getElevation() {
    return elevation;
  }

  /** @return the component {@link Tooltip} */
  public Tooltip getTooltip() {
    return tooltip;
  }

  @Override
  public T setCssProperty(String name, String value) {
    style().setCssProperty(name, value);
    return (T) this;
  }

  @Override
  public T setCssProperty(String name, String value, boolean important) {
    style().setCssProperty(name, value, important);
    return (T) this;
  }

  @Override
  public T removeCssProperty(String name) {
    style().removeCssProperty(name);
    return (T) this;
  }

  @Editor.Ignore
  @Override
  public T addCss(String cssClass) {
    style().addCss(cssClass);
    return (T) this;
  }

  @Override
  public T removeCss(String cssClass) {
    style().removeCss(cssClass);
    return (T) this;
  }

  @Override
  public T replaceCss(String cssClass, String replacementClass) {
    style().replaceCss(cssClass, replacementClass);
    return (T) this;
  }

  @Override
  public T setBorder(String border) {
    style().setBorder(border);
    return (T) this;
  }

  @Override
  public T setBorderColor(String borderColor) {
    style().setBorderColor(borderColor);
    return (T) this;
  }

  @Override
  public T setWidth(String width, boolean important) {
    style().setWidth(width, important);
    return (T) this;
  }

  @Override
  public T setMinWidth(String width) {
    style().setMinWidth(width);
    return (T) this;
  }

  @Override
  public T setMinWidth(String width, boolean important) {
    style().setMinWidth(width, important);
    return (T) this;
  }

  @Override
  public T setMaxWidth(String width) {
    style().setMaxWidth(width);
    return (T) this;
  }

  @Override
  public T setMaxWidth(String width, boolean important) {
    style().setMaxWidth(width, important);
    return (T) this;
  }

  @Override
  public T setHeight(String height, boolean important) {
    style().setHeight(height, important);
    return (T) this;
  }

  @Override
  public T setMinHeight(String height) {
    style().setMinHeight(height);
    return (T) this;
  }

  @Override
  public T setMinHeight(String height, boolean important) {
    style().setMinHeight(height, important);
    return (T) this;
  }

  @Override
  public T setMaxHeight(String height) {
    style().setMaxHeight(height);
    return (T) this;
  }

  @Override
  public T setMaxHeight(String height, boolean important) {
    style().setMaxHeight(height, important);
    return (T) this;
  }

  @Override
  public T setTextAlign(String textAlign) {
    style().setTextAlign(textAlign);
    return (T) this;
  }

  @Override
  public T setTextAlign(String textAlign, boolean important) {
    style().setTextAlign(textAlign, important);
    return (T) this;
  }

  @Override
  public T setColor(String color) {
    style().setColor(color);
    return (T) this;
  }

  @Override
  public T setColor(String color, boolean important) {
    style().setColor(color, important);
    return (T) this;
  }

  @Override
  public T setBackgroundColor(String color) {
    style().setBackgroundColor(color);
    return (T) this;
  }

  @Override
  public T setBackgroundColor(String color, boolean important) {
    style().setBackgroundColor(color, important);
    return (T) this;
  }

  @Override
  public T setMargin(String margin) {
    style().setMargin(margin);
    return (T) this;
  }

  @Override
  public T setMargin(String margin, boolean important) {
    style().setMargin(margin, important);
    return (T) this;
  }

  @Override
  public T setMarginTop(String margin) {
    style().setMarginTop(margin);
    return (T) this;
  }

  @Override
  public T setMarginTop(String margin, boolean important) {
    style().setMarginTop(margin, important);
    return (T) this;
  }

  @Override
  public T setMarginBottom(String margin) {
    style().setMarginBottom(margin);
    return (T) this;
  }

  @Override
  public T setMarginBottom(String margin, boolean important) {
    style().setMarginBottom(margin, important);
    return (T) this;
  }

  @Override
  public T setMarginLeft(String margin) {
    style().setMarginLeft(margin);
    return (T) this;
  }

  @Override
  public T setMarginLeft(String margin, boolean important) {
    style().setMarginLeft(margin, important);
    return (T) this;
  }

  @Override
  public T setMarginRight(String margin) {
    style().setMarginRight(margin);
    return (T) this;
  }

  @Override
  public T setMarginRight(String margin, boolean important) {
    style().setMarginRight(margin, important);
    return (T) this;
  }

  @Override
  public T setPaddingRight(String padding) {
    style().setPaddingRight(padding);
    return (T) this;
  }

  @Override
  public T setPaddingRight(String padding, boolean important) {
    style().setPaddingRight(padding, important);
    return (T) this;
  }

  @Override
  public T setPaddingLeft(String padding) {
    style().setPaddingLeft(padding);
    return (T) this;
  }

  @Override
  public T setPaddingLeft(String padding, boolean important) {
    style().setPaddingLeft(padding, important);
    return (T) this;
  }

  @Override
  public T setPaddingBottom(String padding) {
    style().setPaddingBottom(padding);
    return (T) this;
  }

  @Override
  public T setPaddingBottom(String padding, boolean important) {
    style().setPaddingBottom(padding, important);
    return (T) this;
  }

  @Override
  public T setPaddingTop(String padding) {
    style().setPaddingTop(padding);
    return (T) this;
  }

  @Override
  public T setPaddingTop(String padding, boolean important) {
    style().setPaddingTop(padding, important);
    return (T) this;
  }

  @Override
  public T setPadding(String padding) {
    style().setPadding(padding);
    return (T) this;
  }

  @Override
  public T setPadding(String padding, boolean important) {
    style().setPadding(padding, important);
    return (T) this;
  }

  @Override
  public T setDisplay(String display) {
    style().setDisplay(display);
    return (T) this;
  }

  @Override
  public T setDisplay(String display, boolean important) {
    style().setDisplay(display, important);
    return (T) this;
  }

  @Override
  public T setFontSize(String fontSize) {
    style().setFontSize(fontSize);
    return (T) this;
  }

  @Override
  public T setFontSize(String fontSize, boolean important) {
    style().setFontSize(fontSize, important);
    return (T) this;
  }

  @Override
  public T setFloat(String cssFloat) {
    style().setFloat(cssFloat);
    return (T) this;
  }

  @Override
  public T setFloat(String cssFloat, boolean important) {
    style().setFloat(cssFloat, important);
    return (T) this;
  }

  @Override
  public T setLineHeight(String lineHeight) {
    style().setLineHeight(lineHeight);
    return (T) this;
  }

  @Override
  public T setLineHeight(String lineHeight, boolean important) {
    style().setLineHeight(lineHeight, important);
    return (T) this;
  }

  @Override
  public T setOverFlow(String overFlow) {
    style().setOverFlow(overFlow);
    return (T) this;
  }

  @Override
  public T setOverFlow(String overFlow, boolean important) {
    style().setOverFlow(overFlow, important);
    return (T) this;
  }

  @Override
  public T setCursor(String cursor) {
    style().setCursor(cursor);
    return (T) this;
  }

  @Override
  public T setCursor(String cursor, boolean important) {
    style().setCursor(cursor, important);
    return (T) this;
  }

  @Override
  public T setPosition(String position) {
    style().setPosition(position);
    return (T) this;
  }

  @Override
  public T setPosition(String position, boolean important) {
    style().setPosition(position, important);
    return (T) this;
  }

  @Override
  public T setLeft(String left) {
    style().setLeft(left);
    return (T) this;
  }

  @Override
  public T setLeft(String left, boolean important) {
    style().setLeft(left, important);
    return (T) this;
  }

  @Override
  public T setRight(String right) {
    style().setRight(right);
    return (T) this;
  }

  @Override
  public T setRight(String right, boolean important) {
    style().setRight(right, important);
    return (T) this;
  }

  @Override
  public T setTop(String top) {
    style().setTop(top);
    return (T) this;
  }

  @Override
  public T setTop(String top, boolean important) {
    style().setTop(top, important);
    return (T) this;
  }

  @Override
  public T setBottom(String bottom) {
    style().setBottom(bottom);
    return (T) this;
  }

  @Override
  public T setBottom(String bottom, boolean important) {
    style().setBottom(bottom, important);
    return (T) this;
  }

  @Override
  public T setZIndex(int zindex) {
    style().setZIndex(zindex);
    return (T) this;
  }

  @Deprecated
  @Override
  public boolean contains(String cssClass) {
    return containsCss(cssClass);
  }

  @Override
  public boolean containsCss(String cssClass) {
    return style().containsCss(cssClass);
  }

  public Optional<String> hasCssClass(String cssClass) {
    return style().containsCss(cssClass) ? Optional.of(cssClass) : Optional.empty();
  }

  @Override
  public T pullRight() {
    style().pullRight();
    return (T) this;
  }

  @Override
  public T pullLeft() {
    style().pullLeft();
    return (T) this;
  }

  @Override
  public T alignCenter() {
    style().alignCenter();
    return (T) this;
  }

  @Override
  public T alignRight() {
    style().alignRight();
    return (T) this;
  }

  @Override
  public T cssText(String cssText) {
    style().cssText(cssText);
    return (T) this;
  }

  @Override
  public int length() {
    return cssClassesCount();
  }

  @Override
  @Deprecated
  public String item(int index) {
    return style().cssClassByIndex(index);
  }

  @Override
  public int cssClassesCount() {
    return style().cssClassesCount();
  }

  @Override
  public String cssClassByIndex(int index) {
    return style().cssClassByIndex(index);
  }

  @Override
  public T setPointerEvents(String pointerEvents) {
    style().setPointerEvents(pointerEvents);
    return (T) this;
  }

  @Override
  public T setAlignItems(String alignItems) {
    style().setAlignItems(alignItems);
    return (T) this;
  }

  @Override
  public T setOverFlowY(String overflow) {
    style().setOverFlowY(overflow);
    return (T) this;
  }

  @Override
  public T setOverFlowY(String overflow, boolean important) {
    style().setOverFlowY(overflow, important);
    return (T) this;
  }

  @Override
  public T setOverFlowX(String overflow) {
    style().setOverFlowX(overflow);
    return (T) this;
  }

  @Override
  public T setOverFlowX(String overflow, boolean important) {
    style().setOverFlowX(overflow, important);
    return (T) this;
  }

  @Override
  public T setBoxShadow(String boxShadow) {
    style().setBoxShadow(boxShadow);
    return (T) this;
  }

  @Override
  public T setTransitionDuration(String transactionDuration) {
    style().setTransitionDuration(transactionDuration);
    return (T) this;
  }

  @Override
  public T setFlex(String flex) {
    style().setFlex(flex);
    return (T) this;
  }

  @Override
  public T setOpacity(double opacity) {
    style().setOpacity(opacity);
    return (T) this;
  }

  @Override
  public T setOpacity(double opacity, boolean important) {
    style().setOpacity(opacity, important);
    return (T) this;
  }

  /**
   * Set this element as the target element for the provided Drop menu
   *
   * @param dropMenu {@link org.dominokit.domino.ui.menu.AbstractMenu}
   * @return same component
   */
  public T setDropMenu(AbstractMenu<?, ?> dropMenu) {
    if (nonNull(dropMenu)) {
      dropMenu.setTargetElement(this);
    }
    return (T) this;
  }

  public DominoElement<HTMLElement> querySelector(String selectors) {
    Element element = this.element.element().querySelector(selectors);
    return DominoElement.of(Js.<HTMLElement>uncheckedCast(element));
  }

  public List<DominoElement<HTMLElement>> querySelectorAll(String selectors) {
    NodeList<Element> elements = this.element.element().querySelectorAll(selectors);
    return elements.asList().stream()
        .map(Js::<HTMLElement>uncheckedCast)
        .map(DominoElement::of)
        .collect(Collectors.toList());
  }

  protected DominoUIConfig config() {
    return DominoUIConfig.INSTANCE;
  }

  /**
   * A function to edit a component style
   *
   * @param <E> The type of the component root html element
   * @param <T> the toe of the component
   */
  @FunctionalInterface
  public interface StyleEditor<E extends HTMLElement, T extends IsElement<E>> {
    /** @param style {@link Style} for the component */
    void applyStyles(Style<E, T> style);
  }

  /** a function to add waves effect to a component */
  @FunctionalInterface
  public interface WavesStyler {
    /** @param wavesSupport {@link WavesSupport} */
    void styleWaves(WavesSupport wavesSupport);
  }

  /**
   * A function to apply generic logic to a component
   *
   * @param <T> the type of the component
   */
  @FunctionalInterface
  public interface ElementHandler<T> {
    /** @param self the T component instance */
    void handleElement(T self);
  }

  /**
   * A function to be called when element is resized
   *
   * @param <T> the type of the component
   */
  @FunctionalInterface
  public interface ResizeHandler<T> {
    /** @param element the resized element */
    /** @param observer the {@link ResizeObserver} triggering this event */
    /** @param entries a {@link JsArray} of {@link ResizeObserverEntry} */
    void onResize(T element, ResizeObserver observer, JsArray<ResizeObserverEntry> entries);
  }
}
