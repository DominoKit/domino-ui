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
import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.CustomEvent;
import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.EventTarget;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.DominoElementAdapter;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.TransitionListener;
import org.dominokit.domino.ui.animations.TransitionListeners;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.config.UIConfig;
import org.dominokit.domino.ui.events.EventOptions;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.keyboard.HasKeyboardEvents;
import org.dominokit.domino.ui.keyboard.KeyEventsConsumer;
import org.dominokit.domino.ui.keyboard.KeyboardEventOptions;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.style.DominoStyle;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.HasCssClass;
import org.dominokit.domino.ui.style.HasCssClasses;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesSupport;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.gwtproject.editor.client.Editor;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public abstract class BaseDominoElement<E extends Element, T extends IsElement<E>>
    implements IsElement<E>,
        IsCollapsible<T>,
        HasChildren<T>,
        HasWavesElement,
        AcceptReadOnly<T>,
        DominoStyle<E, T>,
        DominoCss,
        HasKeyboardEvents<T>,
        HasCollapseListeners<T>,
        HasAttributes<T>,
        ElementsFactory,
        HasMeta<T> {

  static {
    DominoThemeManager.INSTANCE.applyUserThemes();
  }

  public static final Logger LOGGER = LoggerFactory.getLogger(BaseDominoElement.class);

  /** The name of the attribute that holds a unique id for the component */
  private static final String DOMINO_UUID = "domino-uuid";

  /** Constant <code>ATTACH_UID_KEY="dui-on-attach-uid"</code> */
  public static String ATTACH_UID_KEY = "dui-on-attach-uid";
  /** Constant <code>DETACH_UID_KEY="dui-on-detach-uid"</code> */
  public static String DETACH_UID_KEY = "dui-on-detach-uid";

  @Editor.Ignore protected T element;
  private String uuid;
  private Tooltip tooltip;
  private Collapsible collapsible;
  @Editor.Ignore private Style<Element> style;
  private LambdaFunction styleInitializer;
  private ScreenMedia hideOn;
  private ScreenMedia showOn;
  private Elevation elevation;
  protected WavesSupport wavesSupport;
  private List<AttachDetachCallback> attachObservers = new ArrayList<>();
  private List<AttachDetachCallback> detachObservers = new ArrayList<>();
  private Optional<ResizeObserver> resizeObserverOptional = Optional.empty();
  private KeyboardEvents<E> keyboardEvents;
  private LazyInitializer keyEventsInitializer;
  private boolean collapseListenersPaused = false;

  protected Set<CollapseListener<? super T>> collapseListeners = new LinkedHashSet<>();
  protected Set<ExpandListener<? super T>> expandListeners = new LinkedHashSet<>();

  private LambdaFunction dominoUuidInitializer;

  private EventListener attachEventListener;
  private EventListener detachEventListener;
  private final List<Consumer<T>> onBeforeRemoveHandlers = new ArrayList<>();
  private final List<Consumer<T>> onRemoveHandlers = new ArrayList<>();
  private final Map<String, ComponentMeta> metaObjects = new HashMap<>();

  private TransitionListeners<E, T> transitionListeners;

  /**
   * initialize the component using its root element giving it a unique id, a {@link
   * org.dominokit.domino.ui.style.Style} and also initialize a {@link
   * org.dominokit.domino.ui.collapsible.Collapsible} for the element
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
            this.uuid = DominoId.unique();
            setAttribute(DOMINO_UUID, this.uuid);
            if (!hasId()) {
              element().id = this.uuid;
            }
          }
          dominoUuidInitializer = () -> {};
        };

    styleInitializer =
        () -> {
          this.style = Style.of(getStyleTarget());
          styleInitializer = () -> {};
        };
    keyEventsInitializer =
        new LazyInitializer(() -> keyboardEvents = new KeyboardEvents<>(this.element()));
    transitionListeners = TransitionListeners.of(element);
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
   * getZIndex.
   *
   * @return a int
   */
  public int getZIndex() {
    if (hasAttribute("dui-z-index")) {
      return Integer.parseInt(getAttribute("dui-z-index"));
    }
    return -1;
  }

  /** {@inheritDoc} */
  @Override
  public T setZIndex(int zindex) {
    this.setAttribute("dui-z-index", zindex);
    style().setZIndex(zindex);
    setCssProperty("--dui-element-z-index", String.valueOf(zindex));
    return (T) this;
  }

  /**
   * sets the element tabIndex attribute
   *
   * @param tabIndex int tabIndex
   * @return same component
   */
  public T setTabIndex(int tabIndex) {
    Js.<DominoElementAdapter>uncheckedCast(element()).tabIndex = tabIndex;
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
  /**
   * getId.
   *
   * @return a {@link java.lang.String} object
   */
  @Editor.Ignore
  public String getId() {
    return element().id;
  }

  /**
   * {@inheritDoc}
   *
   * <p>if the component is visible hide it, else show it
   *
   * @see Collapsible#toggleCollapse()
   */
  @Override
  @Editor.Ignore
  public T toggleCollapse() {
    getCollapsible().toggleCollapse();
    return element;
  }

  /** {@inheritDoc} */
  @Override
  @Editor.Ignore
  public T toggleCollapse(boolean state) {
    getCollapsible().toggleCollapse(state);
    return element;
  }

  /**
   * if the component is visible hide it, else show it
   *
   * @return same component
   * @see Collapsible#toggleCollapse()
   */
  @Editor.Ignore
  public T toggleDisplay() {
    if (isHidden()) {
      show();
    } else {
      hide();
    }
    return element;
  }

  /**
   * toggleDisplay.
   *
   * @param state boolean, if true show the component otherwise hide it
   * @return same component
   * @see Collapsible#toggleCollapse(boolean)
   */
  @Editor.Ignore
  public T toggleDisplay(boolean state) {
    if (state) {
      show();
    } else {
      hide();
    }
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Show the item if it is hidden
   *
   * @see Collapsible#expand()
   */
  @Override
  public T expand() {
    getCollapsible().expand();
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Hides the item if it is visible
   *
   * @see Collapsible#collapse()
   */
  @Override
  public T collapse() {
    getCollapsible().collapse();
    return element;
  }

  /**
   * show.
   *
   * @return a T object
   */
  public T show() {
    dui_hidden.remove(this);
    return (T) this;
  }

  /**
   * hide.
   *
   * @return a T object
   */
  public T hide() {
    addCss(dui_hidden);
    return (T) this;
  }

  /**
   * isHidden.
   *
   * @return a boolean
   */
  public boolean isHidden() {
    return dui_hidden.isAppliedTo(this);
  }

  /**
   * isVisible.
   *
   * @return a boolean
   */
  public boolean isVisible() {
    return !isHidden();
  }

  /**
   * isForceCollapsed.
   *
   * @return boolean, true if force hidden is enabled
   * @see Collapsible#setForceCollapsed(boolean)
   */
  public boolean isForceCollapsed() {
    return getCollapsible().isForceCollapsed();
  }

  /**
   * setForceCollapsed.
   *
   * @param forceCollapsed boolean, true to force hiding the component
   * @return same component
   * @see Collapsible#setForceCollapsed(boolean)
   */
  public T setForceCollapsed(boolean forceCollapsed) {
    getCollapsible().setForceCollapsed(forceCollapsed);
    return element;
  }

  /** @return the {@link Collapsible} of the component */
  /**
   * Getter for the field <code>collapsible</code>.
   *
   * @return a {@link org.dominokit.domino.ui.collapsible.Collapsible} object
   */
  @Editor.Ignore
  public Collapsible getCollapsible() {
    if (isNull(this.collapsible)) {
      this.collapsible = Collapsible.create(getCollapsibleElement());
    }
    return collapsible;
  }

  /**
   * Change the {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} for the element
   *
   * @param strategy the {@link org.dominokit.domino.ui.collapsible.CollapseStrategy}
   * @return same component
   */
  @Editor.Ignore
  public T setCollapseStrategy(CollapseStrategy strategy) {
    this.getCollapsible().setStrategy(strategy);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T pauseCollapseListeners() {
    this.collapseListenersPaused = true;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T resumeCollapseListeners() {
    this.collapseListenersPaused = false;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T togglePauseCollapseListeners(boolean toggle) {
    this.collapseListenersPaused = toggle;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<CollapseListener<? super T>> getCollapseListeners() {
    return collapseListeners;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ExpandListener<? super T>> getExpandListeners() {
    return expandListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isCollapseListenersPaused() {
    return this.collapseListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public T triggerCollapseListeners(T component) {
    if (!this.collapseListenersPaused) {
      getCollapseListeners().forEach(collapseListener -> collapseListener.onCollapsed((T) this));
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T triggerExpandListeners(T component) {
    if (!this.collapseListenersPaused) {
      getExpandListeners().forEach(expandListener -> expandListener.onExpanded((T) this));
    }
    return (T) this;
  }

  /**
   * removes all the component child nodes
   *
   * @return same component
   */
  @Editor.Ignore
  public T clearElement() {
    ElementUtil.clear(getAppendTarget());
    return element;
  }

  /**
   * clearSelf.
   *
   * @return a T object
   */
  public T clearSelf() {
    ElementUtil.clear(element());
    return element;
  }

  /** @return boolean, true if the component is not visible */
  /** {@inheritDoc} */
  @Override
  @Editor.Ignore
  public boolean isCollapsed() {
    return getCollapsible().isCollapsed();
  }

  /** @return the HTML element of type E which is the root element of the component */
  /**
   * element.
   *
   * @return a E object
   */
  public abstract E element();

  /**
   * Adds a handler to be called when the component is attached to the DOM tree
   *
   * @param attachDetachCallback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return same component
   */
  @Editor.Ignore
  public T onAttached(AttachDetachCallback attachDetachCallback) {
    if (isNull(this.attachEventListener)) {
      if (!hasAttribute(ATTACH_UID_KEY)) {
        setAttribute(ATTACH_UID_KEY, DominoId.unique());
      }
      this.attachEventListener =
          evt -> {
            CustomEvent cevent = Js.uncheckedCast(evt);
            attachObservers.forEach(
                callback -> callback.onObserved(Js.uncheckedCast(cevent.detail)));
          };
      this.element
          .element()
          .addEventListener(AttachDetachEventType.attachedType(this), this.attachEventListener);
    }
    attachObservers.add(attachDetachCallback);
    ElementUtil.startObserving();
    return element;
  }

  /**
   * Adds a handler to be called when the component is removed from the DOM tree
   *
   * @param callback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return same component
   */
  @Editor.Ignore
  public T onDetached(AttachDetachCallback callback) {
    if (isNull(this.detachEventListener)) {
      if (!hasAttribute(DETACH_UID_KEY)) {
        setAttribute(DETACH_UID_KEY, DominoId.unique());
      }
      this.detachEventListener =
          evt -> {
            CustomEvent cevent = Js.uncheckedCast(evt);
            detachObservers.forEach(
                observer -> observer.onObserved(Js.uncheckedCast(cevent.detail)));
          };
      this.element
          .element()
          .addEventListener(AttachDetachEventType.detachedType(this), this.detachEventListener);
    }
    detachObservers.add(callback);
    ElementUtil.startObserving();
    return element;
  }

  /**
   * removes the attach {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   *
   * @return same component
   * @param callback a {@link org.dominokit.domino.ui.utils.AttachDetachCallback} object
   */
  public T removeAttachObserver(AttachDetachCallback callback) {
    attachObservers.remove(callback);
    return element;
  }

  /**
   * removes the detach {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   *
   * @return same component
   * @param callback a {@link org.dominokit.domino.ui.utils.AttachDetachCallback} object
   */
  public T removeDetachObserver(AttachDetachCallback callback) {
    detachObservers.remove(callback);
    return element;
  }

  /** @return boolean, true if the element is currently attached to the DOM tree */
  /**
   * isAttached.
   *
   * @return a boolean
   */
  @Editor.Ignore
  public boolean isAttached() {
    dominoUuidInitializer.apply();
    return nonNull(DomGlobal.document.body.querySelector("[domino-uuid='" + uuid + "']"));
  }

  /**
   * Execute the handler only once if the component is already attached to the dom, if not execute
   * it every time the component is attached.
   *
   * @param handler {@link java.lang.Runnable} to be executed
   * @return same component instance
   */
  @Editor.Ignore
  public T nowOrWhenAttached(Runnable handler) {
    if (isAttached()) {
      handler.run();
    } else {
      onAttached(mutationRecord -> handler.run());
    }
    dominoUuidInitializer.apply();
    return (T) this;
  }

  /**
   * Execute the handler if the component is already attached to the dom, then execute it everytime
   * it is attached again to the dom.
   *
   * @param handler {@link java.lang.Runnable} to be executed
   * @return same component instance
   */
  @Editor.Ignore
  public T nowAndWhenAttached(Runnable handler) {
    if (isAttached()) {
      handler.run();
    }
    onAttached(mutationRecord -> handler.run());
    dominoUuidInitializer.apply();
    return (T) this;
  }

  /**
   * Register a call back to listen to element size changes, the observation will only start after
   * the element is attached and will be stopped when the element is detached
   *
   * @param resizeHandler {@link org.dominokit.domino.ui.utils.BaseDominoElement.ResizeHandler}
   * @return same component instance
   */
  @Editor.Ignore
  public T onResize(ResizeHandler<T> resizeHandler) {
    resizeObserverOptional.ifPresent(
        observer -> {
          observer.unobserve(element());
          observer.disconnect();
        });
    nowAndWhenAttached(
        () -> {
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
  /**
   * style.
   *
   * @return a {@link org.dominokit.domino.ui.style.Style} object
   */
  @Editor.Ignore
  public Style<Element> style() {
    styleInitializer.apply();
    return style;
  }

  /**
   * Sets the CSS style of the element.
   *
   * @param style a {@link java.lang.String} object
   * @return a T object
   */
  public T style(String style) {
    Js.<DominoElementAdapter>uncheckedCast(element()).style.cssText = style;
    return (T) this;
  }

  /**
   * Sets the CSS style of the element.
   *
   * @return a {@link elemental2.dom.CSSStyleDeclaration} object
   */
  public CSSStyleDeclaration elementStyle() {
    return Js.<DominoElementAdapter>uncheckedCast(element()).style;
  }

  /**
   * css.
   *
   * @param cssClass String css class name to add to the component
   * @return same component
   */
  @Editor.Ignore
  public T css(String cssClass) {
    addCss(cssClass);
    return element;
  }

  /**
   * css.
   *
   * @param cssClasses String args of css classes names to be added to the component
   * @return same component
   */
  @Editor.Ignore
  public T css(String... cssClasses) {
    addCss(cssClasses);
    return element;
  }

  /** {@inheritDoc} */
  @Override
  @Editor.Ignore
  public T appendChild(Node node) {
    getAppendTarget().appendChild(node);
    return element;
  }

  /**
   * appendChild.
   *
   * @param text string to be appended to the component
   * @return same component
   */
  @Editor.Ignore
  public T appendChild(String text) {
    getAppendTarget().appendChild(text(text));
    return element;
  }

  /**
   * appendChild.
   *
   * @param isElement {@link org.dominokit.domino.ui.IsElement} to be appended to the component
   * @return same component
   */
  @Editor.Ignore
  public T appendChild(IsElement<?> isElement) {
    getAppendTarget().appendChild(isElement.element());
    return element;
  }

  /**
   * prependChild.
   *
   * @param node {@link elemental2.dom.Node} to be appended to the component
   * @return same component
   */
  @Editor.Ignore
  public T prependChild(Node node) {
    return insertFirst(node);
  }

  /**
   * prependChild.
   *
   * @param text string to be appended to the component
   * @return same component
   */
  @Editor.Ignore
  public T prependChild(String text) {
    return insertFirst(text(text));
  }

  /**
   * prependChild.
   *
   * @param isElement {@link org.dominokit.domino.ui.IsElement} to be appended to the component
   * @return same component
   */
  @Editor.Ignore
  public T prependChild(IsElement<?> isElement) {
    return insertFirst(isElement);
  }

  /**
   * getAppendTarget.
   *
   * @return a {@link elemental2.dom.Element} object
   */
  public Element getAppendTarget() {
    return element.element();
  }

  /**
   * getStyleTarget.
   *
   * @return a {@link elemental2.dom.Element} object
   */
  protected Element getStyleTarget() {
    return element.element();
  }

  /**
   * dispatchEvent.
   *
   * @param evt a {@link elemental2.dom.Event} object
   * @return a T object
   */
  public T dispatchEvent(Event evt) {
    element().dispatchEvent(evt);
    return (T) this;
  }

  /**
   * addClickListener.
   *
   * @param listener {@link elemental2.dom.EventListener} to be added to the click event of the
   *     component clickable element
   * @return same component
   */
  @Editor.Ignore
  public T addClickListener(EventListener listener) {
    getClickableElement().addEventListener(EventType.click.getName(), listener);
    return element;
  }

  /**
   * addClickListener.
   *
   * @param listener {@link elemental2.dom.EventListener} to be added to the click event of the
   *     component clickable element
   * @return same component
   * @param capture a boolean
   */
  @Editor.Ignore
  public T addClickListener(EventListener listener, boolean capture) {
    getClickableElement().addEventListener(EventType.click.getName(), listener, capture);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type String event type
   * @param listener {@link elemental2.dom.EventListener}
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
   * @param listener {@link elemental2.dom.EventListener}
   * @return same component
   * @param options a boolean
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener, boolean options) {
    element().addEventListener(type, listener, options);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param listener {@link elemental2.dom.EventListener}
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
   * @param type String event type
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link org.dominokit.domino.ui.events.EventOptions}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener, EventOptions options) {
    element().addEventListener(type, listener, options.get());
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type String event type
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.EventTarget.AddEventListenerOptionsUnionType}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(
      String type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options) {
    element().addEventListener(type, listener, options);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param listener {@link elemental2.dom.EventListener}
   * @param events String array of event types
   * @return same component
   * @param options a boolean
   */
  @Editor.Ignore
  public T addEventsListener(EventListener listener, boolean options, String... events) {
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
   * @param type {@link org.dominokit.domino.ui.events.EventType}
   * @param listener {@link elemental2.dom.EventListener}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener) {
    element().addEventListener(type.getName(), listener);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type {@link org.dominokit.domino.ui.events.EventType}
   * @param listener {@link elemental2.dom.EventListener}
   * @return same component
   * @param options a boolean
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener, boolean options) {
    element().addEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type {@link org.dominokit.domino.ui.events.EventType}
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.AddEventListenerOptions}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(
      EventType type, EventListener listener, AddEventListenerOptions options) {
    element().addEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type {@link org.dominokit.domino.ui.events.EventType}
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.EventTarget.AddEventListenerOptionsUnionType}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(
      EventType type,
      EventListener listener,
      EventTarget.AddEventListenerOptionsUnionType options) {
    element().addEventListener(type.getName(), listener, options.asAddEventListenerOptions());
    return element;
  }

  /**
   * Adds a listener for the provided event type
   *
   * @param type {@link org.dominokit.domino.ui.events.EventType}
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.AddEventListenerOptions}
   * @return same component
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener, EventOptions options) {
    element().addEventListener(type.getName(), listener, options.get());
    return element;
  }

  /**
   * Removes a listener for the provided event type
   *
   * @param type EventType
   * @param listener {@link elemental2.dom.EventListener}
   * @return same component
   */
  @Editor.Ignore
  public T removeEventListener(EventType type, EventListener listener) {
    element().removeEventListener(type.getName(), listener);
    return element;
  }

  /**
   * Removes a listener for the provided event type
   *
   * @param type String event type
   * @param listener {@link elemental2.dom.EventListener}
   * @return same component
   */
  @Editor.Ignore
  public T removeEventListener(String type, EventListener listener) {
    element().removeEventListener(type, listener);
    return element;
  }

  /**
   * Removes a listener for the provided event type
   *
   * @param type EventType
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.AddEventListenerOptions}
   * @return same component
   */
  @Editor.Ignore
  public T removeEventListener(
      EventType type, EventListener listener, AddEventListenerOptions options) {
    element().removeEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Removes a listener for the provided event type
   *
   * @param type EventType
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link elemental2.dom.EventTarget.AddEventListenerOptionsUnionType}
   * @return same component
   */
  @Editor.Ignore
  public T removeEventListener(
      EventType type,
      EventListener listener,
      EventTarget.AddEventListenerOptionsUnionType options) {
    element().removeEventListener(type.getName(), listener, options.asAddEventListenerOptions());
    return element;
  }

  /**
   * Removes a listener for the provided event type
   *
   * @param type EventType
   * @param listener {@link elemental2.dom.EventListener}
   * @param options {@link org.dominokit.domino.ui.events.EventOptions}
   * @return same component
   */
  @Editor.Ignore
  public T removeEventListener(EventType type, EventListener listener, EventOptions options) {
    element().removeEventListener(type.getName(), listener, options.get());
    return element;
  }

  /**
   * Insert a child node before another child node
   *
   * @param newNode {@link elemental2.dom.Node}
   * @param otherNode {@link elemental2.dom.Node}
   * @return same component
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T insertBefore(Node newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode);
    return (T) this;
  }

  /**
   * Insert a child node before another child node
   *
   * @param newNode {@link elemental2.dom.Node}
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertBefore(
      Node newNode, BaseDominoElement<? extends HTMLElement, ? extends IsElement<?>> otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.element());
    return element;
  }

  /**
   * Insert a child in the specified position in the target element
   *
   * @param where String position, one of [beforebegin|afterbegin|beforeend|afterend]
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertAdjacentElement(String where, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement(where, otherNode.element());
    return element;
  }

  /**
   * Insert a child in the specified position in the target element
   *
   * @param where String position, one of [beforebegin|afterbegin|beforeend|afterend]
   * @param e {@link elemental2.dom.Element}
   * @return same component
   */
  @Editor.Ignore
  public T insertAdjacentElement(String where, Element e) {
    getAppendTarget().insertAdjacentElement(where, e);
    return element;
  }

  /**
   * Insert a child right before the begin tag of an element
   *
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertBeforeBegin(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("beforebegin", otherNode.element());
    return element;
  }

  /**
   * Insert a child right before the begin tag of an element
   *
   * @param e {@link elemental2.dom.Element}
   * @return same component
   */
  @Editor.Ignore
  public T insertBeforeBegin(Element e) {
    getAppendTarget().insertAdjacentElement("beforebegin", e);
    return element;
  }

  /**
   * Insert a child right after the begin tag of an element
   *
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfterBegin(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("afterbegin", otherNode.element());
    return element;
  }

  /**
   * Insert a child right after the begin tag of an element
   *
   * @param e {@link elemental2.dom.Element}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfterBegin(Element e) {
    getAppendTarget().insertAdjacentElement("afterbegin", e);
    return element;
  }

  /**
   * Insert a child right before the end tag of an element
   *
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertBeforeEnd(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("beforeend", otherNode.element());
    return element;
  }

  /**
   * Insert a child right before the end tag of an element
   *
   * @param e {@link elemental2.dom.Element}
   * @return same component
   */
  @Editor.Ignore
  public T insertBeforeEnd(Element e) {
    getAppendTarget().insertAdjacentElement("beforeend", e);
    return element;
  }

  /**
   * Insert a child right after the end tag of an element
   *
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfterEnd(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("afterend", otherNode.element());
    return element;
  }

  /**
   * Insert a child right after the end tag of an element
   *
   * @param e {@link elemental2.dom.Element}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfterEnd(Element e) {
    getAppendTarget().insertAdjacentElement("afterend", e);
    return element;
  }

  /**
   * Insert a child node before another child node
   *
   * @param newNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertBefore(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.element());
    return element;
  }

  /**
   * Insert a child node before another child node
   *
   * @param newNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @param otherNode {@link elemental2.dom.Node}
   * @return same component
   */
  @Editor.Ignore
  public T insertBefore(BaseDominoElement<?, ?> newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode);
    return element;
  }

  /**
   * Insert a child node after another child node
   *
   * @param newNode {@link elemental2.dom.Node}
   * @param otherNode {@link elemental2.dom.Node}
   * @return same component
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T insertAfter(Node newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.nextSibling);
    return (T) this;
  }

  /**
   * Insert a child node after another child node
   *
   * @param newNode {@link elemental2.dom.Node}
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfter(Node newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.element().nextSibling);
    return element;
  }

  /**
   * Insert a child node after another child node
   *
   * @param newNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @param otherNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfter(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.element().nextSibling);
    return element;
  }

  /**
   * Insert a child node after another child node
   *
   * @param newNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @param otherNode {@link elemental2.dom.Node}
   * @return same component
   */
  @Editor.Ignore
  public T insertAfter(BaseDominoElement<?, ?> newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.nextSibling);
    return element;
  }

  /**
   * Insert a node as the first child to this component
   *
   * @param newNode {@link elemental2.dom.Node}
   * @return same component
   */
  @Editor.Ignore
  public T insertFirst(Node newNode) {
    getAppendTarget().insertBefore(newNode, element().firstChild);
    return element;
  }

  /**
   * Insert a node as the first child to this component
   *
   * @param element {@link org.dominokit.domino.ui.IsElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertFirst(IsElement<?> element) {
    return insertFirst(element.element());
  }

  /**
   * Insert a node as the first child to this component
   *
   * @param newNode {@link org.dominokit.domino.ui.utils.BaseDominoElement}
   * @return same component
   */
  @Editor.Ignore
  public T insertFirst(BaseDominoElement<?, ?> newNode) {
    getAppendTarget().insertBefore(newNode.element(), element().firstChild);
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Sets a String attribute value on the element
   */
  @Editor.Ignore
  public T setAttribute(String name, String value) {
    element().setAttribute(name, value);
    return element;
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

  /** {@inheritDoc} */
  @Editor.Ignore
  public String getAttribute(String name) {
    return element().getAttribute(name);
  }

  /**
   * getAttribute.
   *
   * @param name String
   * @return the String value of the attribute
   * @param orElseValue a {@link java.lang.String} object
   */
  @Editor.Ignore
  public String getAttribute(String name, String orElseValue) {
    if (hasAttribute(name)) {
      return element().getAttribute(name);
    }
    return orElseValue;
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
   * removeAttribute.
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
   * @param node {@link org.dominokit.domino.ui.utils.DominoElement}
   * @return boolean, true if the node is a child of this component
   */
  @Editor.Ignore
  public boolean contains(IsElement<? extends Element> node) {
    return contains(node.element());
  }

  /**
   * Check if a provided node a child of the component
   *
   * @param node {@link elemental2.dom.Node}
   * @return boolean, true if the node is a child of this component
   */
  @Editor.Ignore
  public boolean contains(Node node) {
    return element().contains(node);
  }

  /**
   * Check if a provided node a direct child of the component
   *
   * @param node {@link elemental2.dom.Node}
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
   * setTextContent.
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
   * textContent.
   *
   * @param text String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(String text) {
    element().textContent = text;
    return element;
  }

  /**
   * textContent.
   *
   * @param number String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(int number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * textContent.
   *
   * @param number String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(Number number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * textContent.
   *
   * @param number String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(float number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * textContent.
   *
   * @param number String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(short number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * textContent.
   *
   * @param number String text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(double number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * textContent.
   *
   * @param bool boolean text content
   * @return same component
   */
  @Editor.Ignore
  public T textContent(boolean bool) {
    element().textContent = String.valueOf(bool);
    return element;
  }

  /**
   * setInnerHtml.
   *
   * @param html String html text
   * @return same component
   */
  @Editor.Ignore
  public T setInnerHtml(String html) {
    element().innerHTML = new SafeHtmlBuilder().appendHtmlConstant(html).toSafeHtml().asString();
    return element;
  }

  /**
   * setInnerHtml.
   *
   * @param html String html text
   * @return same component
   */
  @Editor.Ignore
  public T setInnerHtml(SafeHtml html) {
    return setInnerHtml(html.asString());
  }

  /**
   * removes the element from the DOM tree
   *
   * @return same component
   */
  @Editor.Ignore
  public T remove() {
    onBeforeRemoveHandlers.forEach(h -> h.accept((T) this));
    element().remove();
    onRemoveHandlers.forEach(h -> h.accept((T) this));
    return element;
  }

  /**
   * addOnBeforeRemoveListener.
   *
   * @param handler a {@link java.util.function.Consumer} object
   * @return a T object
   */
  public T addOnBeforeRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onBeforeRemoveHandlers.add(handler);
    }
    return (T) this;
  }

  /**
   * removeOnBeforeRemoveListener.
   *
   * @param handler a {@link java.util.function.Consumer} object
   * @return a T object
   */
  public T removeOnBeforeRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onBeforeRemoveHandlers.remove(handler);
    }
    return (T) this;
  }

  /**
   * addOnRemoveListener.
   *
   * @param handler a {@link java.util.function.Consumer} object
   * @return a T object
   */
  public T addOnRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onRemoveHandlers.add(handler);
    }
    return (T) this;
  }

  /**
   * removeOnRemoveListener.
   *
   * @param handler a {@link java.util.function.Consumer} object
   * @return a T object
   */
  public T removeOnRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onRemoveHandlers.remove(handler);
    }
    return (T) this;
  }

  /**
   * Removes a child node from this component
   *
   * @param node {@link elemental2.dom.Node}
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
   * @param elementToRemove {@link org.dominokit.domino.ui.IsElement}
   * @return same component
   */
  @Editor.Ignore
  public T removeChild(IsElement<?> elementToRemove) {
    removeChild(elementToRemove.element());
    return element;
  }

  /** @return the {@link NodeList} of the component children nodes */
  /**
   * childNodes.
   *
   * @return a {@link elemental2.dom.NodeList} object
   */
  @Editor.Ignore
  public NodeList<Node> childNodes() {
    return element().childNodes;
  }

  /** @return the {@link NodeList} of the component children nodes */
  /**
   * childElements.
   *
   * @return a {@link java.util.List} object
   */
  @Editor.Ignore
  public List<DominoElement<Element>> childElements() {
    NodeList<Node> childNodes = element().childNodes;
    return childNodes.asList().stream()
        .filter(node -> node instanceof Element)
        .map(node -> elements.elementOf(Js.<Element>uncheckedCast(node)))
        .collect(Collectors.toList());
  }

  /** @return the {@link NodeList} of the component children nodes */
  /**
   * parentNode.
   *
   * @return a {@link elemental2.dom.Node} object
   */
  @Editor.Ignore
  public Node parentNode() {
    return element().parentNode;
  }

  /** @return the first child {@link Node} of the component */
  /**
   * firstChild.
   *
   * @return a {@link elemental2.dom.Node} object
   */
  @Editor.Ignore
  public Node firstChild() {
    return element().firstChild;
  }

  /** @return the last child {@link Node} of the component */
  /**
   * lastChild.
   *
   * @return a {@link elemental2.dom.Node} object
   */
  @Editor.Ignore
  public Node lastChild() {
    return element().lastChild;
  }

  /** @return the parent element of the component */
  /**
   * parent.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  @Editor.Ignore
  public DominoElement<HTMLElement> parent() {
    return elementOf(Js.<HTMLElement>uncheckedCast(element().parentElement));
  }

  /** @return String text content of the component */
  /**
   * getTextContent.
   *
   * @return a {@link java.lang.String} object
   */
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
   * Setter for the field <code>tooltip</code>.
   *
   * @param text String tooltip
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(String text) {
    return setTooltip(text, DropDirection.TOP_MIDDLE);
  }

  /**
   * Setter for the field <code>tooltip</code>.
   *
   * @param text String tooltip
   * @param position {@link DropDirection}
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(String text, DropDirection position) {
    return setTooltip(text(text), position);
  }

  /**
   * Setter for the field <code>tooltip</code>.
   *
   * @param node {@link elemental2.dom.Node} tooltip content
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(Node node) {
    return setTooltip(node, DropDirection.TOP_MIDDLE);
  }

  /**
   * Setter for the field <code>tooltip</code>.
   *
   * @param node {@link elemental2.dom.Node} tooltip content
   * @param position {@link DropDirection}
   * @return same component
   * @see Tooltip
   */
  @Editor.Ignore
  public T setTooltip(Node node, DropDirection position) {
    if (isNull(tooltip)) {
      tooltip = Tooltip.create(element(), node);
    } else {
      tooltip.setContent(node);
    }
    tooltip.setPosition(position);
    return element;
  }

  /**
   * removes the component {@link org.dominokit.domino.ui.popover.Tooltip}
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

  /**
   * {@inheritDoc} by default this return the same component root element
   *
   * @return a {@link elemental2.dom.Element} object
   */
  @Editor.Ignore
  public Element getClickableElement() {
    return element();
  }

  /**
   * By default this return the component root element
   *
   * @return the component {@link elemental2.dom.HTMLElement} that can be shown/hidden with the
   *     {@link org.dominokit.domino.ui.collapsible.Collapsible}
   */
  @Editor.Ignore
  public Element getCollapsibleElement() {
    return element();
  }

  /** {@inheritDoc} */
  @Override
  @Editor.Ignore
  public Element getWavesElement() {
    return element();
  }

  /**
   * hides the item for the provided {@link org.dominokit.domino.ui.utils.ScreenMedia}
   *
   * @param screenMedia {@link org.dominokit.domino.ui.utils.ScreenMedia}
   * @return same component
   */
  @Editor.Ignore
  public T hideOn(ScreenMedia screenMedia) {
    removeHideOn();
    this.hideOn = screenMedia;
    addCss("dui-hide-on-" + this.hideOn.getStyle());

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
      removeCss("dui-hide-on-" + hideOn.getStyle());
    }

    return element;
  }

  /**
   * show the item for the provided {@link org.dominokit.domino.ui.utils.ScreenMedia}
   *
   * @param screenMedia {@link org.dominokit.domino.ui.utils.ScreenMedia}
   * @return same component
   */
  @Editor.Ignore
  public T showOn(ScreenMedia screenMedia) {
    removeShowOn();
    this.showOn = screenMedia;
    addCss("dui-show-on-" + this.showOn.getStyle());
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
      removeCss("dui-show-on-" + showOn.getStyle());
    }

    return element;
  }

  /** @return the {@link DOMRect} for the component root element */
  /**
   * getBoundingClientRect.
   *
   * @return a {@link elemental2.dom.DOMRect} object
   */
  @Editor.Ignore
  public DOMRect getBoundingClientRect() {
    return element.element().getBoundingClientRect();
  }

  /**
   * use and instance of the component style to edit it
   *
   * @param styleEditor {@link org.dominokit.domino.ui.utils.BaseDominoElement.StyleEditor}
   * @return same component
   */
  @Editor.Ignore
  public T styler(StyleEditor<Element> styleEditor) {
    styleEditor.applyStyles(style());
    return element;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  public T addCss(String... cssClass) {
    style().addCss(cssClass);
    return element;
  }

  /**
   * removeCss.
   *
   * @param cssClass String args css classes names
   * @return same component
   */
  @Editor.Ignore
  public T removeCss(String... cssClass) {
    style().removeCss(cssClass);
    return element;
  }

  /**
   * removeCss.
   *
   * @param cssClass String args css classes names
   * @return same component
   */
  @Editor.Ignore
  public T removeCss(CssClass... cssClass) {
    style().removeCss(cssClass);
    return element;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  public T setWidth(String width) {
    style().setWidth(width);
    return element;
  }

  /** {@inheritDoc} */
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
   * Adds default {@link org.dominokit.domino.ui.style.WavesSupport} to this component
   *
   * @return same component
   */
  @Editor.Ignore
  public T withWaves() {
    if (isNull(wavesSupport)) {
      this.wavesSupport = WavesSupport.addFor(getWavesElement());
    }
    return element;
  }

  /**
   * withWaves.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withWaves(ChildHandler<T, WavesSupport> handler) {
    withWaves();
    handler.apply((T) this, wavesSupport);
    return (T) this;
  }

  /**
   * Removes the {@link org.dominokit.domino.ui.style.WavesSupport} effect for this component
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
   * Adds {@link org.dominokit.domino.ui.style.WavesSupport} to this component with a custom
   * WaveStyler
   *
   * @param wavesStyler {@link org.dominokit.domino.ui.utils.BaseDominoElement.WavesStyler}
   * @return same component
   */
  @Editor.Ignore
  public T withWaves(WavesStyler wavesStyler) {
    if (isNull(this.wavesSupport)) {
      this.wavesSupport = WavesSupport.addFor(getWavesElement());
    }
    wavesStyler.styleWaves(this.wavesSupport);
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * @param waveStyle a {@link org.dominokit.domino.ui.style.WaveStyle} object
   * @return a T object
   */
  public T setWaveStyle(WaveStyle waveStyle) {
    wavesSupport.setWaveStyle(waveStyle);
    return element;
  }

  /**
   * Applies a function on this component
   *
   * @param elementHandler {@link org.dominokit.domino.ui.utils.ElementHandler}
   * @return same component
   */
  @Editor.Ignore
  public T apply(ElementHandler<T> elementHandler) {
    elementHandler.handleElement(element);
    return element;
  }

  /**
   * Applies a function to the component only if the condition returns true.
   *
   * @param elementHandler {@link org.dominokit.domino.ui.utils.ElementHandler}
   * @param condition a Predicate to test for the apply condition.
   * @return same component
   */
  @Editor.Ignore
  public T applyIf(Predicate<T> condition, ElementHandler<T> elementHandler) {
    if (condition.test((T) this)) {
      elementHandler.handleElement(element);
    }
    return element;
  }

  /**
   * setContent.
   *
   * @param element the {@link org.dominokit.domino.ui.IsElement} content to replace the current
   *     content
   * @return same component
   */
  @Editor.Ignore
  public T setContent(IsElement<?> element) {
    return setContent(element.element());
  }

  /**
   * setContent.
   *
   * @param content the {@link elemental2.dom.Node} content to replace the current content
   * @return same component
   */
  @Editor.Ignore
  public T setContent(Node content) {
    clearElement();
    appendChild(content);
    return element;
  }

  /** @return int count of the component children */
  /**
   * getElementsCount.
   *
   * @return a int
   */
  @Editor.Ignore
  public int getElementsCount() {
    return new Double(element().childElementCount).intValue();
  }

  /** @return boolean, true if the component has no children */
  /**
   * isEmptyElement.
   *
   * @return a boolean
   */
  @Editor.Ignore
  public boolean isEmptyElement() {
    return getElementsCount() == 0 && (isNull(getTextContent()) || getTextContent().isEmpty());
  }

  /** @return double count of the component children */
  /**
   * getChildElementCount.
   *
   * @return a double
   */
  @Editor.Ignore
  public double getChildElementCount() {
    return element().childElementCount;
  }

  /** @return the first {@link Node} in this component */
  /**
   * getFirstChild.
   *
   * @return a {@link elemental2.dom.Node} object
   */
  @Editor.Ignore
  public Node getFirstChild() {
    return element().firstChild;
  }

  /** @return boolean, true if the component has child nodes */
  /**
   * hasChildNodes.
   *
   * @return a boolean
   */
  @Editor.Ignore
  public boolean hasChildNodes() {
    return element().hasChildNodes();
  }

  /** @return String, the assigned unique domino-uuid to the component */
  /**
   * getDominoId.
   *
   * @return a {@link java.lang.String} object
   */
  @Editor.Ignore
  public String getDominoId() {
    dominoUuidInitializer.apply();
    return uuid;
  }

  /**
   * {@inheritDoc}
   *
   * @return a T object
   */
  @Editor.Ignore
  public T disable() {
    return setDisabled(true);
  }

  /** @return boolean, true if the component is disabled */
  /**
   * isDisabled.
   *
   * @return a boolean
   */
  public boolean isDisabled() {
    return hasAttribute("disabled");
  }

  /**
   * {@inheritDoc}
   *
   * @return a T object
   */
  @Editor.Ignore
  public T enable() {
    return setDisabled(false);
  }

  /** @return boolean, true if the component is disabled */
  /**
   * isEnabled.
   *
   * @return a boolean
   */
  public boolean isEnabled() {
    return !isDisabled();
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
      DisableUtil.disable(this);
      elementOf(getClickableElement()).setCssProperty("pointer-events", "none");
      return element;
    } else {
      DisableUtil.enable(this);
      elementOf(getClickableElement()).removeCssProperty("pointer-events");
      return element;
    }
  }

  /**
   * Adds a box-shadow to the component
   *
   * @param level int {@link org.dominokit.domino.ui.style.Elevation} level
   * @return same component
   */
  public T elevate(int level) {
    return elevate(Elevation.of(level));
  }

  /**
   * Adds a box-shadow to the component
   *
   * @param elevation {@link org.dominokit.domino.ui.style.Elevation}
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
   * addCollapseListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same component
   * @see Collapsible#addCollapseHandler(Collapsible.CollapseHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().addCollapseHandler(handler);
    return (T) this;
  }

  /**
   * addBeforeCollapseListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same component
   * @see Collapsible#addBeforeCollapseHandler(Collapsible.CollapseHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addBeforeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().addBeforeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * removeCollapseListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same component
   * @see Collapsible#removeCollapseHandler(Collapsible.CollapseHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().removeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * removeBeforeCollapseListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same component
   * @see Collapsible#removeBeforeCollapseHandler(Collapsible.CollapseHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeBeforeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().removeBeforeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * addExpandListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same component
   * @see Collapsible#addExpandHandler(Collapsible.ExpandHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().addExpandHandler(handler);
    return (T) this;
  }

  /**
   * addBeforeExpandListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same component
   * @see Collapsible#addBeforeExpandHandler(Collapsible.ExpandHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addBeforeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().addBeforeExpandHandler(handler);
    return (T) this;
  }

  /**
   * removeExpandListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same component
   * @see Collapsible#removeExpandHandler(Collapsible.ExpandHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().removeExpandHandler(handler);
    return (T) this;
  }

  /**
   * removeBeforeExpandListener.
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same component
   * @see Collapsible#removeBeforeExpandHandler(Collapsible.ExpandHandler)
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeBeforeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().removeBeforeExpandHandler(handler);
    return (T) this;
  }

  public T onTransitionStart(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionStart(listener);
    return (T) this;
  }

  public T removeTransitionStartListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionStartListener(listener);
    return (T) this;
  }

  public T onTransitionCancel(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionCancel(listener);
    return (T) this;
  }

  public T removeTransitionCancelListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionCancelListener(listener);
    return (T) this;
  }

  public T onTransitionEnd(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionEnd(listener);
    return (T) this;
  }

  public T removeTransitionEndListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionEndListener(listener);
    return (T) this;
  }

  /** @return the currently applied {@link Elevation} */
  /**
   * Getter for the field <code>elevation</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.Elevation} object
   */
  public Elevation getElevation() {
    return elevation;
  }

  /** @return the component {@link Tooltip} */
  /**
   * Getter for the field <code>tooltip</code>.
   *
   * @return a {@link org.dominokit.domino.ui.popover.Tooltip} object
   */
  public Tooltip getTooltip() {
    return tooltip;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, String value) {
    style().setCssProperty(name, value);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, Number value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, int value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, double value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, short value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, float value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, boolean value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCssProperty(String name, String value, boolean important) {
    style().setCssProperty(name, value, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOrRemoveCssProperty(String name, String value, Predicate<T> predicate) {
    if (predicate.test((T) this)) {
      setCssProperty(name, value);
    } else {
      removeCssProperty(name);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeCssProperty(String name) {
    style().removeCssProperty(name);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T addCss(String cssClass) {
    style().addCss(cssClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T addCss(CssClass cssClass) {
    style().addCss(cssClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T addCss(HasCssClass hasCssClass) {
    addCss(hasCssClass.getCssClass());
    return (T) this;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T addCss(CssClass... cssClasses) {
    style().addCss(cssClasses);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Editor.Ignore
  @Override
  public T addCss(HasCssClasses hasCssClasses) {
    addCss(hasCssClasses.getCssClasses());
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeCss(String cssClass) {
    style().removeCss(cssClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeCss(CssClass cssClass) {
    style().removeCss(cssClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeCss(HasCssClass hasCssClass) {
    style().removeCss(hasCssClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T replaceCss(String cssClass, String replacementClass) {
    style().replaceCss(cssClass, replacementClass);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBorder(String border) {
    style().setBorder(border);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBorderColor(String borderColor) {
    style().setBorderColor(borderColor);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setWidth(String width, boolean important) {
    style().setWidth(width, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMinWidth(String width) {
    style().setMinWidth(width);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMinWidth(String width, boolean important) {
    style().setMinWidth(width, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMaxWidth(String width) {
    style().setMaxWidth(width);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMaxWidth(String width, boolean important) {
    style().setMaxWidth(width, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setHeight(String height, boolean important) {
    style().setHeight(height, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMinHeight(String height) {
    style().setMinHeight(height);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMinHeight(String height, boolean important) {
    style().setMinHeight(height, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMaxHeight(String height) {
    style().setMaxHeight(height);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMaxHeight(String height, boolean important) {
    style().setMaxHeight(height, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTextAlign(String textAlign) {
    style().setTextAlign(textAlign);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTextAlign(String textAlign, boolean important) {
    style().setTextAlign(textAlign, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setColor(String color) {
    style().setColor(color);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setColor(String color, boolean important) {
    style().setColor(color, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBackgroundColor(String color) {
    style().setBackgroundColor(color);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBackgroundColor(String color, boolean important) {
    style().setBackgroundColor(color, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMargin(String margin) {
    style().setMargin(margin);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMargin(String margin, boolean important) {
    style().setMargin(margin, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginTop(String margin) {
    style().setMarginTop(margin);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginTop(String margin, boolean important) {
    style().setMarginTop(margin, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginBottom(String margin) {
    style().setMarginBottom(margin);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginBottom(String margin, boolean important) {
    style().setMarginBottom(margin, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginLeft(String margin) {
    style().setMarginLeft(margin);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginLeft(String margin, boolean important) {
    style().setMarginLeft(margin, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginRight(String margin) {
    style().setMarginRight(margin);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setMarginRight(String margin, boolean important) {
    style().setMarginRight(margin, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingRight(String padding) {
    style().setPaddingRight(padding);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingRight(String padding, boolean important) {
    style().setPaddingRight(padding, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingLeft(String padding) {
    style().setPaddingLeft(padding);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingLeft(String padding, boolean important) {
    style().setPaddingLeft(padding, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingBottom(String padding) {
    style().setPaddingBottom(padding);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingBottom(String padding, boolean important) {
    style().setPaddingBottom(padding, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingTop(String padding) {
    style().setPaddingTop(padding);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPaddingTop(String padding, boolean important) {
    style().setPaddingTop(padding, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPadding(String padding) {
    style().setPadding(padding);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPadding(String padding, boolean important) {
    style().setPadding(padding, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setDisplay(String display) {
    style().setDisplay(display);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setDisplay(String display, boolean important) {
    style().setDisplay(display, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setFontSize(String fontSize) {
    style().setFontSize(fontSize);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setFontSize(String fontSize, boolean important) {
    style().setFontSize(fontSize, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setFloat(String cssFloat) {
    style().setFloat(cssFloat);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setFloat(String cssFloat, boolean important) {
    style().setFloat(cssFloat, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLineHeight(String lineHeight) {
    style().setLineHeight(lineHeight);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLineHeight(String lineHeight, boolean important) {
    style().setLineHeight(lineHeight, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlow(String overFlow) {
    style().setOverFlow(overFlow);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlow(String overFlow, boolean important) {
    style().setOverFlow(overFlow, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCursor(String cursor) {
    style().setCursor(cursor);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setCursor(String cursor, boolean important) {
    style().setCursor(cursor, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPosition(String position) {
    style().setPosition(position);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPosition(String position, boolean important) {
    style().setPosition(position, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLeft(String left) {
    style().setLeft(left);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLeft(String left, boolean important) {
    style().setLeft(left, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setRight(String right) {
    style().setRight(right);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setRight(String right, boolean important) {
    style().setRight(right, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTop(String top) {
    style().setTop(top);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTop(String top, boolean important) {
    style().setTop(top, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBottom(String bottom) {
    style().setBottom(bottom);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBottom(String bottom, boolean important) {
    style().setBottom(bottom, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean containsCss(String cssClass) {
    return style().containsCss(cssClass);
  }

  /**
   * hasCssClass.
   *
   * @param cssClass a {@link java.lang.String} object
   * @return a {@link java.util.Optional} object
   */
  public Optional<String> hasCssClass(String cssClass) {
    return style().containsCss(cssClass) ? Optional.of(cssClass) : Optional.empty();
  }

  /** {@inheritDoc} */
  @Override
  public T alignCenter() {
    style().alignCenter();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T alignRight() {
    style().alignRight();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T cssText(String cssText) {
    style().cssText(cssText);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public int cssClassesCount() {
    return style().cssClassesCount();
  }

  /** {@inheritDoc} */
  @Override
  public String cssClassByIndex(int index) {
    return style().cssClassByIndex(index);
  }

  /** {@inheritDoc} */
  @Override
  public T setPointerEvents(String pointerEvents) {
    style().setPointerEvents(pointerEvents);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setAlignItems(String alignItems) {
    style().setAlignItems(alignItems);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlowY(String overflow) {
    style().setOverFlowY(overflow);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlowY(String overflow, boolean important) {
    style().setOverFlowY(overflow, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlowX(String overflow) {
    style().setOverFlowX(overflow);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOverFlowX(String overflow, boolean important) {
    style().setOverFlowX(overflow, important);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setBoxShadow(String boxShadow) {
    style().setBoxShadow(boxShadow);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTransitionDuration(String transactionDuration) {
    style().setTransitionDuration(transactionDuration);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setFlex(String flex) {
    style().setFlex(flex);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOpacity(double opacity) {
    style().setOpacity(opacity);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setOpacity(double opacity, boolean important) {
    style().setOpacity(opacity, important);
    return (T) this;
  }

  /**
   * Set this element as the target element for the provided Drop menu
   *
   * @param dropMenu {@link org.dominokit.domino.ui.menu.Menu}
   * @return same component
   */
  public T setDropMenu(Menu<?> dropMenu) {
    if (nonNull(dropMenu)) {
      dropMenu.setTargetElement(this);
    }
    return (T) this;
  }

  /**
   * getComputedStyle.
   *
   * @return a {@link elemental2.dom.CSSStyleDeclaration} object
   */
  public CSSStyleDeclaration getComputedStyle() {
    return DominoDom.window.getComputedStyle(element());
  }

  /**
   * withComputedStyle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withComputedStyle(ChildHandler<T, CSSStyleDeclaration> handler) {
    handler.apply((T) this, getComputedStyle());
    return (T) this;
  }

  /**
   * querySelector.
   *
   * @param selectors a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public DominoElement<HTMLElement> querySelector(String selectors) {
    Element element = this.element.element().querySelector(selectors);
    if (nonNull(element)) {
      return elementOf(Js.<HTMLElement>uncheckedCast(element));
    }
    return null;
  }

  /**
   * querySelectorAll.
   *
   * @param selectors a {@link java.lang.String} object
   * @return a {@link java.util.List} object
   */
  public List<DominoElement<Element>> querySelectorAll(String selectors) {
    NodeList<Element> elements = this.element.element().querySelectorAll(selectors);
    List<DominoElement<Element>> list = new ArrayList<>();
    for (int i = 0; i < elements.length; i++) {
      Element uncheckedCast = Js.uncheckedCast(elements.item(i));
      DominoElement<Element> elementOf = ElementsFactory.elements.elementOf(uncheckedCast);
      list.add(elementOf);
    }
    return list;
  }

  /**
   * config.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoUIConfig} object
   */
  protected DominoUIConfig config() {
    return DominoUIConfig.CONFIG;
  }

  /**
   * uiconfig.
   *
   * @return a {@link org.dominokit.domino.ui.config.UIConfig} object
   */
  protected UIConfig uiconfig() {
    return DominoUIConfig.CONFIG.getUIConfig();
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, ComponentMeta> getMetaObjects() {
    return metaObjects;
  }

  /** {@inheritDoc} */
  @Override
  public T onKeyDown(KeyEventsConsumer onKeyDown) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyDown(onKeyDown);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T stopOnKeyDown() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyDown();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T onKeyUp(KeyEventsConsumer onKeyUp) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyUp(onKeyUp);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T stopOnKeyUp() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyUp();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T onKeyPress(KeyEventsConsumer onKeyPress) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyPress(onKeyPress);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T stopOnKeyPress() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyPress();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public KeyboardEventOptions getKeyboardEventsOptions() {
    keyEventsInitializer.apply();
    return keyboardEvents.getOptions();
  }

  /** {@inheritDoc} */
  @Override
  public T setDefaultOptions(KeyboardEventOptions defaultOptions) {
    keyEventsInitializer.apply();
    keyboardEvents.setDefaultOptions(defaultOptions);
    return (T) this;
  }

  /**
   * Getter for the field <code>wavesSupport</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.WavesSupport} object
   */
  public WavesSupport getWavesSupport() {
    return wavesSupport;
  }

  /**
   * A function to edit a component style
   *
   * @param <E> The type of the component root html element
   */
  @FunctionalInterface
  public interface StyleEditor<E extends Element> {
    /** @param style {@link Style} for the component */
    void applyStyles(Style<E> style);
  }

  /** a function to add waves effect to a component */
  @FunctionalInterface
  public interface WavesStyler {
    /** @param wavesSupport {@link WavesSupport} */
    void styleWaves(WavesSupport wavesSupport);
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
