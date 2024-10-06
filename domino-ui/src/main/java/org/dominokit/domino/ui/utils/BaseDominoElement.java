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
import static org.dominokit.domino.ui.utils.Domino.dui_hidden;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.core.JsArray;
import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.CustomEvent;
import elemental2.dom.DOMRect;
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
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.CssClass;
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
 * This abstract class represents the base for all DOM elements in the Domino UI framework. It
 * provides common functionality and features for DOM elements.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Create a new Button element
 * Button button = Button.create("Click me");
 *
 * // Add a click event listener
 * button.addClickListener(evt -> {
 *     Window.alert("Button clicked!");
 * });
 *
 * // Append the button to the document body
 * document.body.appendChild(button.element());
 * </pre>
 */
public abstract class BaseDominoElement<E extends Element, T extends IsElement<E>>
    implements IsElement<E>,
        IsCollapsible<T>,
        HasChildren<T>,
        HasWavesElement,
        AcceptReadOnly<T>,
        DominoStyle<E, T>,
        HasKeyboardEvents<T>,
        HasCollapseListeners<T>,
        HasAttributes<T>,
        HasMeta<T> {

  static {
    DominoThemeManager.INSTANCE.applyUserThemes();
  }

  public static final Logger LOGGER = LoggerFactory.getLogger(BaseDominoElement.class);

  private static final String DOMINO_UUID = "domino-uuid";

  public static String ATTACH_UID_KEY = "dui-on-attach-uid";
  public static String DETACH_UID_KEY = "dui-on-detach-uid";

  @Editor.Ignore protected T element;
  /** A unique identifier for this DOM element. */
  private String uuid;

  /** A tooltip associated with this DOM element. */
  private Tooltip tooltip;

  /** The collapsible state of this DOM element. */
  private Collapsible collapsible;
  /** The style of this DOM element. */
  @Editor.Ignore private Style<Element> style;

  private LambdaFunction styleInitializer;
  /** The screen media for hiding this DOM element. */
  private ScreenMedia hideOn;

  /** The screen media for showing this DOM element. */
  private ScreenMedia showOn;

  /** The elevation level of this DOM element. */
  private Elevation elevation;

  /** The Waves support for this DOM element. */
  protected WavesSupport wavesSupport;

  /** A list of attach observers for this DOM element. */
  private List<AttachDetachCallback> attachObservers = new ArrayList<>();

  /** A list of detach observers for this DOM element. */
  private List<AttachDetachCallback> detachObservers = new ArrayList<>();

  /** Optional ResizeObserver for this DOM element. */
  private Optional<ResizeObserver> resizeObserverOptional = Optional.empty();

  private LambdaFunction resizeInitializer;
  private List<ResizeHandler<T>> resizeHandlers = new ArrayList<>();

  /** The keyboard events for this DOM element. */
  private KeyboardEvents<E> keyboardEvents;

  /** A lazy initializer for keyboard events. */
  private LazyInitializer keyEventsInitializer;

  /** Flag to pause collapse listeners. */
  private boolean closeListenersPaused = false;

  /** Set of collapse listeners for this DOM element. */
  protected Set<CloseListener<? super T>> closeListeners = new LinkedHashSet<>();

  /** Set of expand listeners for this DOM element. */
  protected Set<OpenListener<? super T>> openListeners = new LinkedHashSet<>();

  private LambdaFunction dominoUuidInitializer;

  private EventListener attachEventListener;
  private EventListener detachEventListener;
  private final List<Consumer<T>> onBeforeRemoveHandlers = new ArrayList<>();
  private final List<Consumer<T>> onRemoveHandlers = new ArrayList<>();
  private final Map<String, ComponentMeta> metaObjects = new HashMap<>();

  private TransitionListeners<E, T> transitionListeners;

  /**
   * Initializes the DOM element with common functionality.
   *
   * @param element The DOM element to be initialized.
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

    resizeInitializer =
        () -> {
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
                                for (int index = 0; index < resizeHandlers.size(); index++) {
                                  resizeHandlers
                                      .get(index)
                                      .onResize((T) BaseDominoElement.this, observer, entries);
                                }
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
          resizeInitializer = () -> {};
        };
  }

  /**
   * Checks if the DOM element has a "domino UUID" attribute.
   *
   * @return {@code true} if the element has a "domino UUID" attribute, {@code false} otherwise.
   */
  private boolean hasDominoId() {
    return hasAttribute(DOMINO_UUID)
        && nonNull(getAttribute(DOMINO_UUID))
        && !getAttribute(DOMINO_UUID).isEmpty();
  }

  /**
   * Checks if the DOM element has an "id" attribute.
   *
   * @return {@code true} if the element has an "id" attribute, {@code false} otherwise.
   */
  private boolean hasId() {
    return hasAttribute("id") && nonNull(getAttribute("id")) && !getAttribute("id").isEmpty();
  }

  /**
   * Sets the "id" attribute of the DOM element.
   *
   * @param id The value to set as the "id" attribute.
   * @return The modified DOM element.
   */
  public T setId(String id) {
    element().id = id;
    return element;
  }

  /**
   * Gets the "z-index" property of the DOM element.
   *
   * @return The "z-index" property value if present, or -1 if not set.
   */
  public int getZIndex() {
    if (hasAttribute("dui-z-index")) {
      return Integer.parseInt(getAttribute("dui-z-index"));
    }
    return -1;
  }

  /**
   * Sets the "z-index" property of the DOM element.
   *
   * @param zindex The value to set as the "z-index" property.
   * @return The modified DOM element.
   */
  @Override
  public T setZIndex(int zindex) {
    this.setAttribute("dui-z-index", zindex);
    style().setZIndex(zindex);
    setCssProperty("--dui-element-z-index", String.valueOf(zindex));
    return (T) this;
  }

  /**
   * Sets the "tabindex" attribute of the DOM element.
   *
   * @param tabIndex The value to set as the "tabindex" attribute.
   * @return The modified DOM element.
   */
  public T setTabIndex(int tabIndex) {
    Js.<DominoElementAdapter>uncheckedCast(element()).tabIndex = tabIndex;
    return element;
  }

  /**
   * Alias for the {@link #setId(String)} method. Sets the "id" attribute of the DOM element.
   *
   * @param id The value to set as the "id" attribute.
   * @return The modified DOM element.
   */
  public T id(String id) {
    return setId(id);
  }

  /**
   * Gets the "id" attribute of the DOM element.
   *
   * @return The value of the "id" attribute.
   */
  @Editor.Ignore
  public String getId() {
    return element().id;
  }

  /**
   * Toggles the collapsible state of this element.
   *
   * @return The modified DOM element.
   */
  @Override
  @Editor.Ignore
  public T toggleCollapse() {
    getCollapsible().toggleCollapse();
    return element;
  }

  /**
   * Toggles the collapsible state of this element.
   *
   * @param state {@code true} to expand, {@code false} to collapse.
   * @return The modified DOM element.
   */
  @Override
  @Editor.Ignore
  public T toggleCollapse(boolean state) {
    getCollapsible().toggleCollapse(state);
    return element;
  }

  /**
   * Toggles the display state of this element based on its current visibility.
   *
   * @return The modified DOM element.
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
   * Toggles the display state of this element based on the specified state.
   *
   * @param state {@code true} to show, {@code false} to hide.
   * @return The modified DOM element.
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
   * Expands the collapsible element.
   *
   * @return The modified DOM element.
   */
  @Override
  public T expand() {
    getCollapsible().expand();
    return element;
  }

  /**
   * Collapses the collapsible element.
   *
   * @return The modified DOM element.
   */
  @Override
  public T collapse() {
    getCollapsible().collapse();
    return element;
  }

  /**
   * Shows the element by removing the "hidden" CSS class.
   *
   * @return The modified DOM element.
   */
  public T show() {
    dui_hidden.remove(this);
    return (T) this;
  }

  /**
   * Hides the element by adding the "hidden" CSS class.
   *
   * @return The modified DOM element.
   */
  public T hide() {
    addCss(dui_hidden);
    return (T) this;
  }

  /**
   * Checks if the element is hidden.
   *
   * @return {@code true} if the element is hidden, {@code false} otherwise.
   */
  public boolean isHidden() {
    return dui_hidden.isAppliedTo(this);
  }

  /**
   * Checks if the element is visible.
   *
   * @return {@code true} if the element is visible, {@code false} if hidden.
   */
  public boolean isVisible() {
    return !isHidden();
  }

  /**
   * Checks if the collapsible element is force-collapsed.
   *
   * @return {@code true} if force-collapsed, {@code false} otherwise.
   */
  public boolean isForceCollapsed() {
    return getCollapsible().isForceCollapsed();
  }

  /**
   * Sets whether the collapsible element should be force-collapsed.
   *
   * @param forceCollapsed {@code true} to force-collapse, {@code false} otherwise.
   * @return The modified DOM element.
   */
  public T setForceCollapsed(boolean forceCollapsed) {
    getCollapsible().setForceCollapsed(forceCollapsed);
    return element;
  }

  /**
   * Gets the {@link Collapsible} instance associated with this element.
   *
   * @return The {@link Collapsible} instance.
   */
  @Editor.Ignore
  public Collapsible getCollapsible() {
    if (isNull(this.collapsible)) {
      this.collapsible = Collapsible.create(getCollapsibleElement());
    }
    return collapsible;
  }

  /**
   * Sets the collapse strategy for the collapsible element.
   *
   * @param strategy The {@link CollapseStrategy} to set.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setCollapseStrategy(CollapseStrategy strategy) {
    this.getCollapsible().setStrategy(strategy);
    return (T) this;
  }

  /**
   * Pauses the collapse listeners for this element.
   *
   * @return The modified DOM element.
   */
  @Override
  public T pauseCloseListeners() {
    this.closeListenersPaused = true;
    return (T) this;
  }

  /**
   * Resumes the close listeners for this element.
   *
   * @return The modified DOM element.
   */
  @Override
  public T resumeCloseListeners() {
    this.closeListenersPaused = false;
    return (T) this;
  }

  /**
   * Toggles whether the close listeners for this element are paused.
   *
   * @param toggle {@code true} to pause, {@code false} to resume.
   * @return The modified DOM element.
   */
  @Override
  public T togglePauseCloseListeners(boolean toggle) {
    this.closeListenersPaused = toggle;
    return (T) this;
  }

  /**
   * Retrieves the set of {@link CloseListener}s registered for this element.
   *
   * @return A set of {@link CloseListener} instances.
   */
  @Override
  public Set<CloseListener<? super T>> getCloseListeners() {
    return closeListeners;
  }

  /**
   * Retrieves the set of {@link OpenListener}s registered for this element.
   *
   * @return A set of {@link OpenListener} instances.
   */
  @Override
  public Set<OpenListener<? super T>> getOpenListeners() {
    return openListeners;
  }

  /**
   * Checks if the close listeners are currently paused.
   *
   * @return {@code true} if close listeners are paused, {@code false} otherwise.
   */
  @Override
  public boolean isCloseListenersPaused() {
    return this.closeListenersPaused;
  }

  /**
   * Triggers close listeners for this element.
   *
   * @param component The component that triggered the event.
   * @return The modified DOM element.
   */
  @Override
  public T triggerCloseListeners(T component) {
    if (!this.closeListenersPaused) {
      getCloseListeners().forEach(closeListener -> closeListener.onClosed((T) this));
    }
    return (T) this;
  }

  /**
   * Triggers open listeners for this element.
   *
   * @param component The component that triggered the event.
   * @return The modified DOM element.
   */
  @Override
  public T triggerOpenListeners(T component) {
    if (!this.closeListenersPaused) {
      getOpenListeners().forEach(openListener -> openListener.onOpened((T) this));
    }
    return (T) this;
  }

  /**
   * Clears the content of the element returned by {@link #getAppendTarget()}.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T clearElement() {
    ElementUtil.clear(getAppendTarget());
    return element;
  }

  /**
   * Clears the content of the element itself.
   *
   * @return The modified DOM element.
   */
  public T clearSelf() {
    ElementUtil.clear(element());
    return element;
  }

  /**
   * Checks if the element is collapsed.
   *
   * @return {@code true} if the element is collapsed, {@code false} otherwise.
   */
  @Override
  @Editor.Ignore
  public boolean isCollapsed() {
    return getCollapsible().isCollapsed();
  }

  /**
   * Gets the underlying DOM element represented by this class.
   *
   * @return The underlying DOM element.
   */
  public abstract E element();

  /**
   * Applies the provided function on the raw element of the component
   *
   * @param handler the {@link ChildHandler} to be applied
   * @return same component instance
   */
  public T withElement(ChildHandler<T, E> handler) {
    handler.apply((T) this, element());
    return (T) this;
  }

  /**
   * Creates a popover and associate it with this component, then apply the specified handler
   *
   * @param handler The handler to be applied to the newly created popover
   * @return same component instance.
   */
  public T withPopover(ChildHandler<T, Popover> handler) {
    handler.apply((T) this, Popover.create(Js.<HTMLElement>uncheckedCast(element())));
    return (T) this;
  }

  /**
   * Registers an observer to be notified when this element is attached to the DOM.
   *
   * @param attachDetachCallback The observer to be registered.
   * @return The modified DOM element.
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
   * Registers an observer to be notified when this element is detached from the DOM.
   *
   * @param callback The observer to be registered.
   * @return The modified DOM element.
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
   * Removes an observer that was previously registered to be notified when this element is attached
   * to the DOM.
   *
   * @param callback The observer to be removed.
   * @return The modified DOM element.
   */
  public T removeAttachObserver(AttachDetachCallback callback) {
    attachObservers.remove(callback);
    return element;
  }

  /**
   * Removes an observer that was previously registered to be notified when this element is detached
   * from the DOM.
   *
   * @param callback The observer to be removed.
   * @return The modified DOM element.
   */
  public T removeDetachObserver(AttachDetachCallback callback) {
    detachObservers.remove(callback);
    return element;
  }

  /**
   * Checks if the element is currently attached to the DOM.
   *
   * @return {@code true} if the element is attached, {@code false} otherwise.
   */
  @Editor.Ignore
  public boolean isAttached() {
    dominoUuidInitializer.apply();
    return element().isConnected;
  }

  /**
   * Executes a given handler either immediately if the element is already attached to the DOM or
   * when it gets attached.
   *
   * @param handler The handler to execute.
   * @return The modified DOM element.
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
   * Executes a given handler either immediately if the element is already detached from the DOM or
   * when it gets detached.
   *
   * @param handler The handler to execute.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T nowOrWhenDetached(Runnable handler) {
    if (isAttached()) {
      onDetached(mutationRecord -> handler.run());
    } else {
      handler.run();
    }
    dominoUuidInitializer.apply();
    return (T) this;
  }

  /**
   * Executes a given handler when the element is attached to the DOM. If the element is already
   * attached, the handler is executed immediately.
   *
   * @param handler The handler to execute.
   * @return The modified DOM element.
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
   * Executes a given handler when the element is detached from the DOM. If the element is already
   * detached, the handler is executed immediately.
   *
   * @param handler The handler to execute.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T nowAndWhenDetached(Runnable handler) {
    if (!isAttached()) {
      handler.run();
    }
    onDetached(mutationRecord -> handler.run());
    dominoUuidInitializer.apply();
    return (T) this;
  }

  /**
   * Registers a resize handler to be notified when the size of this element changes.
   *
   * @param resizeHandler The resize handler to be registered.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T onResize(ResizeHandler<T> resizeHandler) {
    resizeInitializer.apply();
    resizeHandlers.add(resizeHandler);
    return (T) this;
  }

  /**
   * Registers a resize handler to be notified when the size of this element changes. And allow the
   * user to pass a record where the handler will be registered for removal
   *
   * @param resizeHandler The resize handler to be registered.
   * @param record The HandlerRecord that can be used to register a handler remove method.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T onResize(ResizeHandler<T> resizeHandler, HandlerRecord record) {
    if (nonNull(record)) {
      record.setRemover(() -> resizeHandlers.remove(resizeHandler));
    }
    return onResize(resizeHandler);
  }

  /**
   * Retrieves the style object for this element, allowing manipulation of its styles.
   *
   * @return The style object for this element.
   */
  @Editor.Ignore
  public Style<Element> style() {
    styleInitializer.apply();
    return style;
  }

  /**
   * Sets the CSS styles for this element.
   *
   * @param style The CSS styles to apply.
   * @return The modified DOM element.
   */
  public T style(String style) {
    Js.<DominoElementAdapter>uncheckedCast(element()).style.cssText = style;
    return (T) this;
  }

  /**
   * Retrieves the CSS style declaration for this element.
   *
   * @return The CSS style declaration for this element.
   */
  public CSSStyleDeclaration elementStyle() {
    return Js.<DominoElementAdapter>uncheckedCast(element()).style;
  }

  /**
   * Adds one or more CSS classes to this element.
   *
   * @param cssClass The CSS class or classes to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T css(String cssClass) {
    addCss(cssClass);
    return element;
  }

  /**
   * Adds one or more CSS classes to this element.
   *
   * @param cssClasses The array of CSS classes to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T css(String... cssClasses) {
    addCss(cssClasses);
    return element;
  }

  /**
   * Appends a child node to this element.
   *
   * @param node The child node to append.
   * @return The modified DOM element.
   */
  @Override
  @Editor.Ignore
  public T appendChild(Node node) {
    getAppendTarget().appendChild(node);
    return element;
  }

  /**
   * Appends child nodes to this element.
   *
   * @param nodes The child nodes to append.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T appendChild(Node... nodes) {
    Arrays.asList(nodes).forEach(this::appendChild);
    return element;
  }

  /**
   * Appends a text string as a child node to this element.
   *
   * @param text The text string to append.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T appendChild(String text) {
    getAppendTarget().appendChild(text(text));
    return element;
  }

  /**
   * Appends an element represented by an {@code IsElement} interface to this element.
   *
   * @param isElement The element to append.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T appendChild(IsElement<?> isElement) {
    getAppendTarget().appendChild(isElement.element());
    return element;
  }

  /**
   * Appends an element represented by an {@code IsElement} interface to this element.
   *
   * @param elements The element to append.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T appendChild(IsElement<?>... elements) {
    Arrays.stream(elements).forEach(this::appendChild);
    return element;
  }

  public T appendChild(PrefixAddOn<?> prefix) {
    getPrefixElement().appendChild(prefix);
    return (T) this;
  }

  public T appendChild(PrefixAddOn<?>... prefixes) {
    Arrays.asList(prefixes).forEach(this::appendChild);
    return (T) this;
  }

  public T appendChild(PostfixAddOn<?> postfix) {
    getPostfixElement().appendChild(postfix);
    return (T) this;
  }

  public T appendChild(PostfixAddOn<?>... postfixes) {
    Arrays.asList(postfixes).forEach(this::appendChild);
    return (T) this;
  }

  public T appendChild(PrimaryAddOn<?> addon) {
    getPrimaryAddonsElement().appendChild(addon);
    return (T) this;
  }

  public T appendChild(PrimaryAddOn<?>... addons) {
    Arrays.asList(addons).forEach(this::appendChild);
    return (T) this;
  }

  /**
   * Prepends a child node to this element.
   *
   * @param node The child node to prepend.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T prependChild(Node node) {
    return insertFirst(node);
  }

  /**
   * Prepends a text string as a child node to this element.
   *
   * @param text The text string to prepend.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T prependChild(String text) {
    return insertFirst(text(text));
  }

  /**
   * Prepends an element represented by an {@code IsElement} interface to this element.
   *
   * @param isElement The element to prepend.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T prependChild(IsElement<?> isElement) {
    return insertFirst(isElement);
  }

  /**
   * Retrieves the target element to which child elements should be appended.
   *
   * @return The target element for appending child elements.
   */
  public Element getAppendTarget() {
    return element.element();
  }

  /**
   * Retrieves the target element to which styles should be applied.
   *
   * @return The target element for applying styles.
   */
  protected Element getStyleTarget() {
    return element.element();
  }

  /**
   * Dispatches an event to this element.
   *
   * @param evt The event to dispatch.
   * @return The modified DOM element.
   */
  public T dispatchEvent(Event evt) {
    element().dispatchEvent(evt);
    return (T) this;
  }

  /**
   * Adds a click event listener to this element.
   *
   * @param listener The click event listener to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addClickListener(EventListener listener) {
    getClickableElement().addEventListener(EventType.click.getName(), listener);
    return element;
  }

  /**
   * Adds a click event listener to this element with the option to capture the event.
   *
   * @param listener The click event listener to add.
   * @param capture Specifies whether to capture the event during the capturing phase.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addClickListener(EventListener listener, boolean capture) {
    getClickableElement().addEventListener(EventType.click.getName(), listener, capture);
    return element;
  }

  /**
   * Adds a generic event listener to this element.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener) {
    element().addEventListener(type, listener);
    return element;
  }

  /**
   * Adds a generic event listener to this element with additional options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The options for configuring the event listener.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener, boolean options) {
    element().addEventListener(type, listener, options);
    return element;
  }

  /**
   * Adds multiple event listeners to this element for the specified events.
   *
   * @param listener The event listener to add.
   * @param events The array of event names to listen for.
   * @return The modified DOM element.
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
   * Adds a generic event listener to this element with event options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The event options.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(String type, EventListener listener, EventOptions options) {
    element().addEventListener(type, listener, options.get());
    return element;
  }

  /**
   * Adds a generic event listener to this element with event options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The event options union type.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(
      String type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options) {
    element().addEventListener(type, listener, options);
    return element;
  }

  /**
   * Adds multiple event listeners to this element for the specified events with event options.
   *
   * @param listener The event listener to add.
   * @param options Specifies whether to capture the event during the capturing phase.
   * @param events The array of event names to listen for.
   * @return The modified DOM element.
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
   * Adds a generic event listener to this element for a specific event type.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener) {
    element().addEventListener(type.getName(), listener);
    return element;
  }

  /**
   * Adds a generic event listener to this element for a specific event type with additional
   * options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The options for configuring the event listener.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener, boolean options) {
    element().addEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Adds a generic event listener to this element for a specific event type with options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The event options.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(
      EventType type, EventListener listener, AddEventListenerOptions options) {
    element().addEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Adds a generic event listener to this element for a specific event type with options union
   * type.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The event options union type.
   * @return The modified DOM element.
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
   * Adds a generic event listener to this element for a specific event type with event options.
   *
   * @param type The type of event to listen for.
   * @param listener The event listener to add.
   * @param options The event options.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addEventListener(EventType type, EventListener listener, EventOptions options) {
    element().addEventListener(type.getName(), listener, options.get());
    return element;
  }

  /**
   * Removes a specific event listener from this element for a specific event type.
   *
   * @param type The type of event for which to remove the listener.
   * @param listener The event listener to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeEventListener(EventType type, EventListener listener) {
    element().removeEventListener(type.getName(), listener);
    return element;
  }

  /**
   * Removes a specific event listener from this element for a specific event type.
   *
   * @param type The type of event for which to remove the listener.
   * @param listener The event listener to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeEventListener(String type, EventListener listener) {
    element().removeEventListener(type, listener);
    return element;
  }

  /**
   * Removes a specific event listener from this element for a specific event type with additional
   * options.
   *
   * @param type The type of event for which to remove the listener.
   * @param listener The event listener to remove.
   * @param options The options for removing the event listener.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeEventListener(
      EventType type, EventListener listener, AddEventListenerOptions options) {
    element().removeEventListener(type.getName(), listener, options);
    return element;
  }

  /**
   * Removes a specific event listener from this element for a specific event type with options
   * union type.
   *
   * @param type The type of event for which to remove the listener.
   * @param listener The event listener to remove.
   * @param options The options for removing the event listener as a union type.
   * @return The modified DOM element.
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
   * Removes a specific event listener from this element for a specific event type with event
   * options.
   *
   * @param type The type of event for which to remove the listener.
   * @param listener The event listener to remove.
   * @param options The event options for removing the listener.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeEventListener(EventType type, EventListener listener, EventOptions options) {
    element().removeEventListener(type.getName(), listener, options.get());
    return element;
  }

  /**
   * Inserts the specified new node before the specified reference node in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The node before which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T insertBefore(Node newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode);
    return (T) this;
  }

  /**
   * Inserts the specified new node before the specified reference element in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The element before which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBefore(
      Node newNode, BaseDominoElement<? extends HTMLElement, ? extends IsElement<?>> otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.element());
    return element;
  }

  /**
   * Inserts an element into this element using the specified position.
   *
   * @param where The position where the element should be inserted ("beforebegin", "afterbegin",
   *     "beforeend", or "afterend").
   * @param otherNode The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAdjacentElement(String where, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement(where, otherNode.element());
    return element;
  }

  /**
   * Inserts an element into this element using the specified position.
   *
   * @param where The position where the element should be inserted ("beforebegin", "afterbegin",
   *     "beforeend", or "afterend").
   * @param e The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAdjacentElement(String where, Element e) {
    getAppendTarget().insertAdjacentElement(where, e);
    return element;
  }

  /**
   * Inserts an element before the beginning of this element.
   *
   * @param otherNode The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBeforeBegin(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("beforebegin", otherNode.element());
    return element;
  }

  /**
   * Inserts an element before the beginning of this element.
   *
   * @param e The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBeforeBegin(Element e) {
    getAppendTarget().insertAdjacentElement("beforebegin", e);
    return element;
  }

  /**
   * Inserts an element after the beginning of this element.
   *
   * @param otherNode The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfterBegin(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("afterbegin", otherNode.element());
    return element;
  }

  /**
   * Inserts an element after the beginning of this element.
   *
   * @param e The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfterBegin(Element e) {
    getAppendTarget().insertAdjacentElement("afterbegin", e);
    return element;
  }

  /**
   * Inserts an element before the end of this element.
   *
   * @param otherNode The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBeforeEnd(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("beforeend", otherNode.element());
    return element;
  }

  /**
   * Inserts an element before the end of this element.
   *
   * @param e The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBeforeEnd(Element e) {
    getAppendTarget().insertAdjacentElement("beforeend", e);
    return element;
  }

  /**
   * Inserts an element after the end of this element.
   *
   * @param otherNode The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfterEnd(BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertAdjacentElement("afterend", otherNode.element());
    return element;
  }

  /**
   * Inserts an element after the end of this element.
   *
   * @param e The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfterEnd(Element e) {
    getAppendTarget().insertAdjacentElement("afterend", e);
    return element;
  }

  /**
   * Inserts the specified new node before the specified reference element in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The element before which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBefore(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.element());
    return element;
  }

  /**
   * Inserts the specified new node before the specified reference node in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The node before which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertBefore(BaseDominoElement<?, ?> newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode);
    return element;
  }

  /**
   * Inserts the specified new node after the specified reference node in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The node after which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T insertAfter(Node newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.nextSibling);
    return (T) this;
  }

  /**
   * Inserts the specified new node after the specified reference node in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The node after which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfter(Node newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode, otherNode.element().nextSibling);
    return element;
  }

  /**
   * Inserts the specified new node after the specified reference element in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The element after which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfter(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.element().nextSibling);
    return element;
  }

  /**
   * Inserts the specified new node after the specified reference element in this element.
   *
   * @param newNode The node to insert.
   * @param otherNode The element after which the new node will be inserted.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertAfter(BaseDominoElement<?, ?> newNode, Node otherNode) {
    getAppendTarget().insertBefore(newNode.element(), otherNode.nextSibling);
    return element;
  }

  /**
   * Inserts the specified node as the first child of this element.
   *
   * @param newNode The node to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertFirst(Node newNode) {
    getAppendTarget().insertBefore(newNode, element().firstChild);
    return element;
  }

  /**
   * Inserts the specified element as the first child of this element.
   *
   * @param element The element to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertFirst(IsElement<?> element) {
    return insertFirst(element.element());
  }

  /**
   * Inserts the specified new node as the first child of this element.
   *
   * @param newNode The node to insert.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T insertFirst(BaseDominoElement<?, ?> newNode) {
    getAppendTarget().insertBefore(newNode.element(), element().firstChild);
    return element;
  }

  /**
   * Sets the specified attribute to the given value on this element.
   *
   * @param name The name of the attribute to set.
   * @param value The value to set for the attribute.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setAttribute(String name, String value) {
    element().setAttribute(name, value);
    return element;
  }

  /**
   * Sets the specified attribute to the given boolean value on this element.
   *
   * @param name The name of the attribute to set.
   * @param value The boolean value to set for the attribute.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setAttribute(String name, boolean value) {
    element().setAttribute(name, value);
    return element;
  }

  /**
   * Sets the specified attribute to the given double value on this element.
   *
   * @param name The name of the attribute to set.
   * @param value The double value to set for the attribute.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setAttribute(String name, double value) {
    element().setAttribute(name, value);
    return element;
  }

  /**
   * Gets the value of the specified attribute on this element.
   *
   * @param name The name of the attribute to retrieve.
   * @return The value of the specified attribute, or an empty string if the attribute is not
   *     present.
   */
  @Editor.Ignore
  public String getAttribute(String name) {
    return element().getAttribute(name);
  }

  /**
   * Gets the value of the specified attribute on this element, or returns the specified default
   * value if the attribute is not present.
   *
   * @param name The name of the attribute to retrieve.
   * @param orElseValue The default value to return if the attribute is not present.
   * @return The value of the specified attribute, or the default value if the attribute is not
   *     present.
   */
  @Editor.Ignore
  public String getAttribute(String name, String orElseValue) {
    if (hasAttribute(name)) {
      return element().getAttribute(name);
    }
    return orElseValue;
  }

  /**
   * Sets the "readonly" attribute of this element to make it read-only.
   *
   * @param readOnly Whether the element should be read-only.
   * @return The modified DOM element.
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
   * Checks if the element has the "readonly" attribute set, making it read-only.
   *
   * @return True if the element is read-only, otherwise false.
   */
  @Editor.Ignore
  @Override
  public boolean isReadOnly() {
    return hasAttribute("readonly");
  }

  /**
   * Removes the specified attribute from this element.
   *
   * @param name The name of the attribute to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeAttribute(String name) {
    element().removeAttribute(name);
    return element;
  }

  /**
   * Checks if the element has the specified attribute.
   *
   * @param name The name of the attribute to check.
   * @return True if the element has the specified attribute, otherwise false.
   */
  @Editor.Ignore
  public boolean hasAttribute(String name) {
    return element().hasAttribute(name);
  }

  /**
   * Checks if this element contains the specified child element.
   *
   * @param node The child element to check for containment.
   * @return True if this element contains the child element, otherwise false.
   */
  @Editor.Ignore
  public boolean contains(IsElement<? extends Element> node) {
    return contains(node.element());
  }

  /**
   * Checks if this element contains the specified child node.
   *
   * @param node The child node to check for containment.
   * @return True if this element contains the child node, otherwise false.
   */
  @Editor.Ignore
  public boolean contains(Node node) {
    return element().contains(node);
  }

  /**
   * Checks if this element is the direct parent of the specified child node.
   *
   * @param node The child node to check for direct parentage.
   * @return True if this element is the direct parent of the child node, otherwise false.
   */
  public boolean hasDirectChild(Node node) {
    Node parentNode = node.parentNode;
    if (isNull(parentNode)) {
      return false;
    }
    return parentNode.equals(element.element());
  }

  /**
   * Sets the text content of this element to the specified string.
   *
   * @param text The text content to set.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setTextContent(String text) {
    element().textContent = text;
    return element;
  }

  /**
   * Sets the text content of this element to the specified string.
   *
   * @param text The text content to set.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(String text) {
    element().textContent = text;
    return element;
  }

  /**
   * Sets the text content of this element to the specified integer number.
   *
   * @param number The integer number to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(int number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * Sets the text content of this element to the specified number.
   *
   * @param number The number to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(Number number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * Sets the text content of this element to the specified floating-point number.
   *
   * @param number The floating-point number to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(float number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * Sets the text content of this element to the specified short number.
   *
   * @param number The short number to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(short number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * Sets the text content of this element to the specified double number.
   *
   * @param number The double number to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(double number) {
    element().textContent = String.valueOf(number);
    return element;
  }

  /**
   * Sets the text content of this element to the specified boolean value.
   *
   * @param bool The boolean value to set as text content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T textContent(boolean bool) {
    element().textContent = String.valueOf(bool);
    return element;
  }

  /**
   * Sets the inner HTML of this element to the specified HTML string.
   *
   * @param html The HTML string to set as the inner HTML of the element.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setInnerHtml(String html) {
    element().innerHTML = new SafeHtmlBuilder().appendHtmlConstant(html).toSafeHtml().asString();
    return element;
  }

  /**
   * Sets the inner HTML of this element to the specified SafeHtml object.
   *
   * @param html The SafeHtml object to set as the inner HTML of the element.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setInnerHtml(SafeHtml html) {
    return setInnerHtml(html.asString());
  }

  /**
   * Removes this element from its parent in the DOM.
   *
   * @return The removed DOM element.
   */
  @Editor.Ignore
  public T remove() {
    onBeforeRemoveHandlers.forEach(h -> h.accept((T) this));
    element().remove();
    onRemoveHandlers.forEach(h -> h.accept((T) this));
    return element;
  }

  /**
   * Adds an "onBeforeRemove" listener to this element. The listener will be invoked before the
   * element is removed.
   *
   * @param handler The listener to add.
   * @return The modified DOM element.
   */
  public T addOnBeforeRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onBeforeRemoveHandlers.add(handler);
    }
    return (T) this;
  }

  /**
   * Removes an "onBeforeRemove" listener from this element.
   *
   * @param handler The listener to remove.
   * @return The modified DOM element.
   */
  public T removeOnBeforeRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onBeforeRemoveHandlers.remove(handler);
    }
    return (T) this;
  }

  /**
   * Adds an "onRemove" listener to this element. The listener will be invoked after the element is
   * removed.
   *
   * @param handler The listener to add.
   * @return The modified DOM element.
   */
  public T addOnRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onRemoveHandlers.add(handler);
    }
    return (T) this;
  }

  /**
   * Removes an "onRemove" listener from this element.
   *
   * @param handler The listener to remove.
   * @return The modified DOM element.
   */
  public T removeOnRemoveListener(Consumer<T> handler) {
    if (nonNull(handler)) {
      this.onRemoveHandlers.remove(handler);
    }
    return (T) this;
  }

  /**
   * Removes the specified child node from this element's list of child nodes.
   *
   * @param node The child node to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeChild(Node node) {
    element().removeChild(node);
    return element;
  }

  /**
   * Removes the specified child element from this element's list of child nodes.
   *
   * @param elementToRemove The child element to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeChild(IsElement<?> elementToRemove) {
    removeChild(elementToRemove.element());
    return element;
  }

  /**
   * Gets a list of child nodes of this element.
   *
   * @return A NodeList containing the child nodes of this element.
   */
  @Editor.Ignore
  public NodeList<Node> childNodes() {
    return element().childNodes;
  }

  /**
   * Gets a list of child elements of this element.
   *
   * @return A list of child elements of this element.
   */
  @Editor.Ignore
  public List<DominoElement<Element>> childElements() {
    NodeList<Node> childNodes = element().childNodes;
    return childNodes.asList().stream()
        .filter(node -> node instanceof Element)
        .map(node -> elementOf(Js.<Element>uncheckedCast(node)))
        .collect(Collectors.toList());
  }

  /**
   * Gets the parent node of this element.
   *
   * @return The parent node of this element.
   */
  @Editor.Ignore
  public Node parentNode() {
    return element().parentNode;
  }

  /**
   * Gets the first child node of this element.
   *
   * @return The first child node of this element.
   */
  @Editor.Ignore
  public Node firstChild() {
    return element().firstChild;
  }

  /**
   * Gets the last child node of this element.
   *
   * @return The last child node of this element.
   */
  @Editor.Ignore
  public Node lastChild() {
    return element().lastChild;
  }

  /**
   * Gets the parent element of this element as a {@code DominoElement}.
   *
   * @return The parent element of this element as a {@code DominoElement}.
   */
  @Editor.Ignore
  public DominoElement<HTMLElement> parent() {
    return elementOf(Js.<HTMLElement>uncheckedCast(element().parentElement));
  }

  /**
   * Gets the text content of this element.
   *
   * @return The text content of this element.
   */
  @Editor.Ignore
  public String getTextContent() {
    return element().textContent;
  }

  /**
   * Removes the focus from this element.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T blur() {
    element().blur();
    return element;
  }

  /**
   * Sets a tooltip for this element with the specified text and default position (top-middle).
   *
   * @param text The text to display in the tooltip.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setTooltip(String text) {
    return setTooltip(text, DropDirection.BEST_SIDE_UP_DOWN);
  }

  /**
   * Sets a tooltip for this element with the specified text and position.
   *
   * @param text The text to display in the tooltip.
   * @param position The position of the tooltip relative to the element.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setTooltip(String text, DropDirection position) {
    return setTooltip(text(text), position);
  }

  /**
   * Sets a tooltip for this element with the specified content node and default position
   * (top-middle).
   *
   * @param node The content node to display in the tooltip.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setTooltip(Node node) {
    return setTooltip(node, DropDirection.BEST_SIDE_UP_DOWN);
  }

  /**
   * Sets a tooltip for this element with the specified content node and position.
   *
   * @param node The content node to display in the tooltip.
   * @param position The position of the tooltip relative to the element.
   * @return The modified DOM element.
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
   * Removes the tooltip from this element.
   *
   * @return The modified DOM element.
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
   * Gets the clickable element associated with this element.
   *
   * @return The clickable element associated with this element.
   */
  @Editor.Ignore
  public Element getClickableElement() {
    return element();
  }

  /**
   * Gets the element hosting the component Postfix add-ons.
   *
   * @return Element.
   */
  @Editor.Ignore
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(getAppendTarget());
  }

  /**
   * Gets the element hosting the component Prefix add-ons.
   *
   * @return Element.
   */
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(getAppendTarget());
  }

  /**
   * Gets the element hosting the component Primary add-ons.
   *
   * @return Element.
   */
  public PrimaryAddOnElement getPrimaryAddonsElement() {
    return PrimaryAddOnElement.of(getAppendTarget());
  }

  public T withPrefixElement(ChildHandler<T, PrefixElement> handler) {
    handler.apply((T) this, getPrefixElement());
    return (T) this;
  }

  public T withPostfixElement(ChildHandler<T, PostfixElement> handler) {
    handler.apply((T) this, getPostfixElement());
    return (T) this;
  }

  /**
   * Gets the collapsible element associated with this element.
   *
   * @return The collapsible element associated with this element.
   */
  @Editor.Ignore
  public Element getCollapsibleElement() {
    return element();
  }

  /**
   * Gets the waves element associated with this element.
   *
   * @return The waves element associated with this element.
   */
  @Override
  @Editor.Ignore
  public Element getWavesElement() {
    return element();
  }

  /**
   * Hides the element on the specified screen media.
   *
   * @param screenMedia The screen media on which to hide the element.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T hideOn(ScreenMedia screenMedia) {
    removeHideOn();
    this.hideOn = screenMedia;
    addCss("dui-hide-on-" + this.hideOn.getStyle());

    return element;
  }

  /**
   * Removes the hide-on screen media styling from the element.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeHideOn() {
    if (nonNull(hideOn)) {
      removeCss("dui-hide-on-" + hideOn.getStyle());
    }

    return element;
  }

  /**
   * Shows the element on the specified screen media.
   *
   * @param screenMedia The screen media on which to show the element.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T showOn(ScreenMedia screenMedia) {
    removeShowOn();
    this.showOn = screenMedia;
    addCss("dui-show-on-" + this.showOn.getStyle());
    return element;
  }

  /**
   * Removes the show-on screen media styling from the element.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeShowOn() {
    if (nonNull(showOn)) {
      removeCss("dui-show-on-" + showOn.getStyle());
    }

    return element;
  }

  /**
   * Gets the bounding client rectangle of this element.
   *
   * @return The bounding client rectangle of this element.
   */
  @Editor.Ignore
  public DOMRect getBoundingClientRect() {
    return element.element().getBoundingClientRect();
  }

  /**
   * Applies styles to the element using the provided style editor.
   *
   * @param styleEditor The style editor to apply styles.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T styler(StyleEditor<Element> styleEditor) {
    styleEditor.applyStyles(style());
    return element;
  }

  /**
   * Adds CSS classes to the element.
   *
   * @param cssClass The CSS classes to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T addCss(String... cssClass) {
    style().addCss(cssClass);
    return element;
  }

  /**
   * Removes CSS classes from the element.
   *
   * @param cssClass The CSS classes to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeCss(String... cssClass) {
    style().removeCss(cssClass);
    return element;
  }

  /**
   * Removes CSS classes from the element.
   *
   * @param cssClass The CSS classes to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeCss(CssClass... cssClass) {
    style().removeCss(cssClass);
    return element;
  }

  /**
   * Sets the width of the element.
   *
   * @param width The width to set.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setWidth(String width) {
    style().setWidth(width);
    return element;
  }

  /**
   * Sets the height of the element.
   *
   * @param height The height to set.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setHeight(String height) {
    style().setHeight(height);
    return element;
  }

  /**
   * Checks if this element is equal to another node.
   *
   * @param node The node to compare.
   * @return {@code true} if the elements are equal, {@code false} otherwise.
   */
  @Editor.Ignore
  public boolean isEqualNode(Node node) {
    return element().isEqualNode(node);
  }

  /**
   * Enables Waves effect for this element.
   *
   * @return The modified DOM element.
   */
  public T withWaves() {
    if (isNull(wavesSupport)) {
      this.wavesSupport = WavesSupport.addFor(getWavesElement());
    }
    return element;
  }

  /**
   * Enables Waves effect for this element and applies additional settings using the provided
   * handler.
   *
   * @param handler The handler to apply Waves settings.
   * @return The modified DOM element.
   */
  public T withWaves(ChildHandler<T, WavesSupport> handler) {
    withWaves();
    handler.apply((T) this, wavesSupport);
    return (T) this;
  }

  /**
   * Removes Waves effect from this element.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T removeWaves() {
    if (nonNull(this.wavesSupport)) {
      this.wavesSupport.removeWaves();
    }
    return element;
  }

  /**
   * Enables Waves effect for this element and applies styles using the provided WavesStyler.
   *
   * @param wavesStyler The WavesStyler to apply Waves styles.
   * @return The modified DOM element.
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
   * Sets the wave style for this element's Waves effect.
   *
   * @param waveStyle The wave style to set.
   * @return The modified DOM element.
   */
  public T setWaveStyle(WaveStyle waveStyle) {
    wavesSupport.setWaveStyle(waveStyle);
    return element;
  }

  /**
   * Applies the given element handler to this element.
   *
   * @param elementHandler The element handler to apply.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T apply(ElementHandler<T> elementHandler) {
    elementHandler.handleElement(element);
    return element;
  }

  /**
   * Applies the given element handler to this element if the specified condition is met.
   *
   * @param condition The condition to check before applying the element handler.
   * @param elementHandler The element handler to apply.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T applyIf(Predicate<T> condition, ElementHandler<T> elementHandler) {
    if (condition.test((T) this)) {
      elementHandler.handleElement(element);
    }
    return element;
  }

  /**
   * Sets the content of this element using another IsElement.
   *
   * @param element The IsElement containing the content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setContent(IsElement<?> element) {
    return setContent(element.element());
  }

  /**
   * Sets the content of this element to the provided Node, clearing existing content.
   *
   * @param content The Node to set as the content.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T setContent(Node content) {
    clearElement();
    appendChild(content);
    return element;
  }

  /**
   * Gets the number of child elements within this element.
   *
   * @return The number of child elements.
   */
  @Editor.Ignore
  public int getElementsCount() {
    return new Double(element().childElementCount).intValue();
  }

  /**
   * Checks if this element is empty, i.e., it has no child elements and no text content.
   *
   * @return {@code true} if the element is empty, {@code false} otherwise.
   */
  @Editor.Ignore
  public boolean isEmptyElement() {
    return getElementsCount() == 0 && (isNull(getTextContent()) || getTextContent().isEmpty());
  }

  /**
   * Gets the number of child elements within this element as a double.
   *
   * @return The number of child elements as a double.
   */
  @Editor.Ignore
  public double getChildElementCount() {
    return element().childElementCount;
  }

  /**
   * Gets the first child Node of this element.
   *
   * @return The first child Node.
   */
  @Editor.Ignore
  public Node getFirstChild() {
    return element().firstChild;
  }

  /**
   * Checks if this element has child nodes.
   *
   * @return {@code true} if the element has child nodes, {@code false} otherwise.
   */
  @Editor.Ignore
  public boolean hasChildNodes() {
    return element().hasChildNodes();
  }

  /**
   * Gets the Domino ID of this element.
   *
   * @return The Domino ID of this element.
   */
  @Editor.Ignore
  public String getDominoId() {
    dominoUuidInitializer.apply();
    return uuid;
  }

  /**
   * Disables this element by setting the "disabled" attribute.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T disable() {
    return setDisabled(true);
  }

  /**
   * Checks if this element is disabled.
   *
   * @return {@code true} if the element is disabled, {@code false} otherwise.
   */
  public boolean isDisabled() {
    return hasAttribute("disabled");
  }

  /**
   * Enables this element by removing the "disabled" attribute.
   *
   * @return The modified DOM element.
   */
  @Editor.Ignore
  public T enable() {
    return setDisabled(false);
  }

  /**
   * Checks if this element is enabled.
   *
   * @return {@code true} if the element is enabled, {@code false} otherwise.
   */
  public boolean isEnabled() {
    return !isDisabled();
  }

  /**
   * Sets the disabled state of this element.
   *
   * @param disabled {@code true} to disable the element, {@code false} to enable it.
   * @return The modified DOM element.
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
   * Elevates this element to the specified elevation level.
   *
   * @param level The elevation level to apply.
   * @return The modified DOM element.
   */
  public T elevate(int level) {
    return elevate(Elevation.of(level));
  }

  /**
   * Elevates this element using the specified elevation style.
   *
   * @param elevation The elevation style to apply.
   * @return The modified DOM element.
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
   * Adds a collapse listener to this element.
   *
   * @param handler The collapse handler to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().addCollapseHandler(handler);
    return (T) this;
  }

  /**
   * Adds a before-collapse listener to this element.
   *
   * @param handler The before-collapse handler to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addBeforeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().addBeforeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * Removes a collapse listener from this element.
   *
   * @param handler The collapse handler to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().removeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * Removes a before-collapse listener from this element.
   *
   * @param handler The before-collapse handler to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeBeforeCollapseListener(Collapsible.CollapseHandler handler) {
    getCollapsible().removeBeforeCollapseHandler(handler);
    return (T) this;
  }

  /**
   * Adds an expand listener to this element.
   *
   * @param handler The expand handler to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().addExpandHandler(handler);
    return (T) this;
  }

  /**
   * Adds a before-expand listener to this element.
   *
   * @param handler The before-expand handler to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T addBeforeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().addBeforeExpandHandler(handler);
    return (T) this;
  }

  /**
   * Removes an expand listener from this element.
   *
   * @param handler The expand handler to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().removeExpandHandler(handler);
    return (T) this;
  }

  /**
   * Removes a before-expand listener from this element.
   *
   * @param handler The before-expand handler to remove.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @SuppressWarnings("unchecked")
  public T removeBeforeExpandListener(Collapsible.ExpandHandler handler) {
    getCollapsible().removeBeforeExpandHandler(handler);
    return (T) this;
  }

  /**
   * Adds a transition start listener to this element.
   *
   * @param listener The transition listener to add.
   * @return The modified DOM element.
   */
  public T onTransitionStart(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionStart(listener);
    return (T) this;
  }

  /**
   * Removes a transition start listener from this element.
   *
   * @param listener The transition listener to remove.
   * @return The modified DOM element.
   */
  public T removeTransitionStartListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionStartListener(listener);
    return (T) this;
  }

  /**
   * Adds a transition cancel listener to this element.
   *
   * @param listener The transition listener to add.
   * @return The modified DOM element.
   */
  public T onTransitionCancel(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionCancel(listener);
    return (T) this;
  }

  /**
   * Removes a transition cancel listener from this element.
   *
   * @param listener The transition listener to remove.
   * @return The modified DOM element.
   */
  public T removeTransitionCancelListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionCancelListener(listener);
    return (T) this;
  }

  /**
   * Adds a transition end listener to this element.
   *
   * @param listener The transition listener to add.
   * @return The modified DOM element.
   */
  public T onTransitionEnd(TransitionListener<? super T> listener) {
    transitionListeners.onTransitionEnd(listener);
    return (T) this;
  }

  /**
   * Removes a transition end listener from this element.
   *
   * @param listener The transition listener to remove.
   * @return The modified DOM element.
   */
  public T removeTransitionEndListener(TransitionListener<? super T> listener) {
    transitionListeners.removeTransitionEndListener(listener);
    return (T) this;
  }

  /**
   * Gets the elevation style applied to this element.
   *
   * @return The elevation style.
   */
  public Elevation getElevation() {
    return elevation;
  }

  /**
   * Gets the tooltip associated with this element.
   *
   * @return The tooltip element.
   */
  public Tooltip getTooltip() {
    return tooltip;
  }

  /**
   * Sets a CSS property with a string value.
   *
   * @param name The name of the CSS property.
   * @param value The string value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, String value) {
    style().setCssProperty(name, value);
    return (T) this;
  }

  /**
   * Sets a CSS property with a numeric value.
   *
   * @param name The name of the CSS property.
   * @param value The numeric value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, Number value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with an integer value.
   *
   * @param name The name of the CSS property.
   * @param value The integer value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, int value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with a double value.
   *
   * @param name The name of the CSS property.
   * @param value The double value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, double value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with a short value.
   *
   * @param name The name of the CSS property.
   * @param value The short value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, short value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with a float value.
   *
   * @param name The name of the CSS property.
   * @param value The float value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, float value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with a boolean value.
   *
   * @param name The name of the CSS property.
   * @param value The boolean value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, boolean value) {
    style().setCssProperty(name, String.valueOf(value));
    return (T) this;
  }

  /**
   * Sets a CSS property with a string value and optional !important flag.
   *
   * @param name The name of the CSS property.
   * @param value The string value to set.
   * @param important Whether to add the !important flag.
   * @return The modified DOM element.
   */
  @Override
  public T setCssProperty(String name, String value, boolean important) {
    style().setCssProperty(name, value, important);
    return (T) this;
  }

  /**
   * Sets or removes a CSS property based on a predicate.
   *
   * @param name The name of the CSS property.
   * @param value The string value to set.
   * @param predicate The predicate to determine whether to set or remove the property.
   * @return The modified DOM element.
   */
  @Override
  public T setOrRemoveCssProperty(String name, String value, Predicate<T> predicate) {
    if (predicate.test((T) this)) {
      setCssProperty(name, value);
    } else {
      removeCssProperty(name);
    }
    return (T) this;
  }

  /**
   * Removes a CSS property.
   *
   * @param name The name of the CSS property to remove.
   * @return The modified DOM element.
   */
  @Override
  public T removeCssProperty(String name) {
    style().removeCssProperty(name);
    return (T) this;
  }

  /**
   * Adds one or more CSS classes to the element.
   *
   * @param cssClass One or more CSS classes to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @Override
  public T addCss(String cssClass) {
    style().addCss(cssClass);
    return (T) this;
  }

  /**
   * Adds a CSS class to the element.
   *
   * @param cssClass The CSS class to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @Override
  public T addCss(CssClass cssClass) {
    style().addCss(cssClass);
    return (T) this;
  }

  /**
   * Adds CSS classes from an object that implements the HasCssClass interface.
   *
   * @param hasCssClass An object that implements the HasCssClass interface.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @Override
  public T addCss(HasCssClass hasCssClass) {
    addCss(hasCssClass.getCssClass());
    return (T) this;
  }

  /**
   * Adds one or more CSS classes to the element.
   *
   * @param cssClasses One or more CSS classes to add.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @Override
  public T addCss(CssClass... cssClasses) {
    style().addCss(cssClasses);
    return (T) this;
  }

  /**
   * Adds CSS classes from an object that implements the HasCssClasses interface.
   *
   * @param hasCssClasses An object that implements the HasCssClasses interface.
   * @return The modified DOM element.
   */
  @Editor.Ignore
  @Override
  public T addCss(HasCssClasses hasCssClasses) {
    addCss(hasCssClasses.getCssClasses());
    return (T) this;
  }

  /**
   * Removes one or more CSS classes from the element.
   *
   * @param cssClass One or more CSS classes to remove.
   * @return The modified DOM element.
   */
  @Override
  public T removeCss(String cssClass) {
    style().removeCss(cssClass);
    return (T) this;
  }

  /**
   * Removes a CSS class from the element.
   *
   * @param cssClass The CSS class to remove.
   * @return The modified DOM element.
   */
  @Override
  public T removeCss(CssClass cssClass) {
    style().removeCss(cssClass);
    return (T) this;
  }

  /**
   * Removes CSS classes from an object that implements the HasCssClass interface.
   *
   * @param hasCssClass An object that implements the HasCssClass interface.
   * @return The modified DOM element.
   */
  @Override
  public T removeCss(HasCssClass hasCssClass) {
    style().removeCss(hasCssClass);
    return (T) this;
  }

  /**
   * Replaces one CSS class with another in the element's class attribute.
   *
   * @param cssClass The CSS class to replace.
   * @param replacementClass The CSS class to replace it with.
   * @return The modified DOM element.
   */
  @Override
  public T replaceCss(String cssClass, String replacementClass) {
    style().replaceCss(cssClass, replacementClass);
    return (T) this;
  }

  /**
   * Sets the CSS border property for the element.
   *
   * @param border The CSS border property to set.
   * @return The modified DOM element.
   */
  @Override
  public T setBorder(String border) {
    style().setBorder(border);
    return (T) this;
  }

  /**
   * Sets the CSS border color property for the element.
   *
   * @param borderColor The CSS border color property to set.
   * @return The modified DOM element.
   */
  @Override
  public T setBorderColor(String borderColor) {
    style().setBorderColor(borderColor);
    return (T) this;
  }

  /**
   * Sets the width of the element using a CSS style.
   *
   * @param width The width value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setWidth(String width, boolean important) {
    style().setWidth(width, important);
    return (T) this;
  }

  /**
   * Sets the minimum width of the element using a CSS style.
   *
   * @param width The minimum width value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMinWidth(String width) {
    style().setMinWidth(width);
    return (T) this;
  }

  /**
   * Sets the minimum width of the element using a CSS style.
   *
   * @param width The minimum width value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMinWidth(String width, boolean important) {
    style().setMinWidth(width, important);
    return (T) this;
  }

  /**
   * Sets the maximum width of the element using a CSS style.
   *
   * @param width The maximum width value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMaxWidth(String width) {
    style().setMaxWidth(width);
    return (T) this;
  }

  /**
   * Sets the maximum width of the element using a CSS style.
   *
   * @param width The maximum width value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMaxWidth(String width, boolean important) {
    style().setMaxWidth(width, important);
    return (T) this;
  }

  /**
   * Sets the height of the element using a CSS style.
   *
   * @param height The height value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setHeight(String height, boolean important) {
    style().setHeight(height, important);
    return (T) this;
  }

  /**
   * Sets the minimum height of the element using a CSS style.
   *
   * @param height The minimum height value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMinHeight(String height) {
    style().setMinHeight(height);
    return (T) this;
  }

  /**
   * Sets the minimum height of the element using a CSS style.
   *
   * @param height The minimum height value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMinHeight(String height, boolean important) {
    style().setMinHeight(height, important);
    return (T) this;
  }

  /**
   * Sets the maximum height of the element using a CSS style.
   *
   * @param height The maximum height value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMaxHeight(String height) {
    style().setMaxHeight(height);
    return (T) this;
  }

  /**
   * Sets the maximum height of the element using a CSS style.
   *
   * @param height The maximum height value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMaxHeight(String height, boolean important) {
    style().setMaxHeight(height, important);
    return (T) this;
  }

  /**
   * Sets the text alignment of the element using a CSS style.
   *
   * @param textAlign The text alignment value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setTextAlign(String textAlign) {
    style().setTextAlign(textAlign);
    return (T) this;
  }

  /**
   * Sets the text alignment of the element using a CSS style.
   *
   * @param textAlign The text alignment value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setTextAlign(String textAlign, boolean important) {
    style().setTextAlign(textAlign, important);
    return (T) this;
  }

  /**
   * Sets the text color of the element using a CSS style.
   *
   * @param color The text color value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setColor(String color) {
    style().setColor(color);
    return (T) this;
  }

  /**
   * Sets the text color of the element using a CSS style.
   *
   * @param color The text color value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setColor(String color, boolean important) {
    style().setColor(color, important);
    return (T) this;
  }

  /**
   * Sets the background color of the element using a CSS style.
   *
   * @param color The background color value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setBackgroundColor(String color) {
    style().setBackgroundColor(color);
    return (T) this;
  }

  /**
   * Sets the background color of the element using a CSS style.
   *
   * @param color The background color value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setBackgroundColor(String color, boolean important) {
    style().setBackgroundColor(color, important);
    return (T) this;
  }

  /**
   * Sets the margin of the element using a CSS style.
   *
   * @param margin The margin value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMargin(String margin) {
    style().setMargin(margin);
    return (T) this;
  }

  /**
   * Sets the margin of the element using a CSS style.
   *
   * @param margin The margin value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMargin(String margin, boolean important) {
    style().setMargin(margin, important);
    return (T) this;
  }

  /**
   * Sets the top margin of the element using a CSS style.
   *
   * @param margin The top margin value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginTop(String margin) {
    style().setMarginTop(margin);
    return (T) this;
  }

  /**
   * Sets the top margin of the element using a CSS style.
   *
   * @param margin The top margin value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginTop(String margin, boolean important) {
    style().setMarginTop(margin, important);
    return (T) this;
  }

  /**
   * Sets the bottom margin of the element using a CSS style.
   *
   * @param margin The bottom margin value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginBottom(String margin) {
    style().setMarginBottom(margin);
    return (T) this;
  }

  /**
   * Sets the bottom margin of the element using a CSS style.
   *
   * @param margin The bottom margin value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginBottom(String margin, boolean important) {
    style().setMarginBottom(margin, important);
    return (T) this;
  }

  /**
   * Sets the left margin of the element using a CSS style.
   *
   * @param margin The left margin value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginLeft(String margin) {
    style().setMarginLeft(margin);
    return (T) this;
  }

  /**
   * Sets the left margin of the element using a CSS style.
   *
   * @param margin The left margin value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginLeft(String margin, boolean important) {
    style().setMarginLeft(margin, important);
    return (T) this;
  }

  /**
   * Sets the right margin of the element using a CSS style.
   *
   * @param margin The right margin value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginRight(String margin) {
    style().setMarginRight(margin);
    return (T) this;
  }

  /**
   * Sets the right margin of the element using a CSS style.
   *
   * @param margin The right margin value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setMarginRight(String margin, boolean important) {
    style().setMarginRight(margin, important);
    return (T) this;
  }

  /**
   * Sets the right padding of the element using a CSS style.
   *
   * @param padding The right padding value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingRight(String padding) {
    style().setPaddingRight(padding);
    return (T) this;
  }

  /**
   * Sets the right padding of the element using a CSS style.
   *
   * @param padding The right padding value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingRight(String padding, boolean important) {
    style().setPaddingRight(padding, important);
    return (T) this;
  }

  /**
   * Sets the left padding of the element using a CSS style.
   *
   * @param padding The left padding value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingLeft(String padding) {
    style().setPaddingLeft(padding);
    return (T) this;
  }

  /**
   * Sets the left padding of the element using a CSS style.
   *
   * @param padding The left padding value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingLeft(String padding, boolean important) {
    style().setPaddingLeft(padding, important);
    return (T) this;
  }

  /**
   * Sets the bottom padding of the element using a CSS style.
   *
   * @param padding The bottom padding value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingBottom(String padding) {
    style().setPaddingBottom(padding);
    return (T) this;
  }

  /**
   * Sets the bottom padding of the element using a CSS style.
   *
   * @param padding The bottom padding value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingBottom(String padding, boolean important) {
    style().setPaddingBottom(padding, important);
    return (T) this;
  }

  /**
   * Sets the top padding of the element using a CSS style.
   *
   * @param padding The top padding value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingTop(String padding) {
    style().setPaddingTop(padding);
    return (T) this;
  }

  /**
   * Sets the top padding of the element using a CSS style.
   *
   * @param padding The top padding value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPaddingTop(String padding, boolean important) {
    style().setPaddingTop(padding, important);
    return (T) this;
  }

  /**
   * Sets the padding of the element using a CSS style.
   *
   * @param padding The padding value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPadding(String padding) {
    style().setPadding(padding);
    return (T) this;
  }

  /**
   * Sets the padding of the element using a CSS style.
   *
   * @param padding The padding value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPadding(String padding, boolean important) {
    style().setPadding(padding, important);
    return (T) this;
  }

  /**
   * Sets the CSS `display` property for the element.
   *
   * @param display The display property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setDisplay(String display) {
    style().setDisplay(display);
    return (T) this;
  }

  /**
   * Sets the CSS `display` property for the element.
   *
   * @param display The display property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setDisplay(String display, boolean important) {
    style().setDisplay(display, important);
    return (T) this;
  }

  /**
   * Sets the font size of the element using a CSS style.
   *
   * @param fontSize The font size value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setFontSize(String fontSize) {
    style().setFontSize(fontSize);
    return (T) this;
  }

  /**
   * Sets the font size of the element using a CSS style.
   *
   * @param fontSize The font size value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setFontSize(String fontSize, boolean important) {
    style().setFontSize(fontSize, important);
    return (T) this;
  }

  /**
   * Sets the CSS `float` property for the element.
   *
   * @param cssFloat The float property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setFloat(String cssFloat) {
    style().setFloat(cssFloat);
    return (T) this;
  }

  /**
   * Sets the CSS `float` property for the element.
   *
   * @param cssFloat The float property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setFloat(String cssFloat, boolean important) {
    style().setFloat(cssFloat, important);
    return (T) this;
  }

  /**
   * Sets the line height of the element using a CSS style.
   *
   * @param lineHeight The line height value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setLineHeight(String lineHeight) {
    style().setLineHeight(lineHeight);
    return (T) this;
  }

  /**
   * Sets the line height of the element using a CSS style.
   *
   * @param lineHeight The line height value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setLineHeight(String lineHeight, boolean important) {
    style().setLineHeight(lineHeight, important);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow` property for the element.
   *
   * @param overFlow The overflow property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlow(String overFlow) {
    style().setOverFlow(overFlow);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow` property for the element.
   *
   * @param overFlow The overflow property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlow(String overFlow, boolean important) {
    style().setOverFlow(overFlow, important);
    return (T) this;
  }

  /**
   * Sets the CSS `cursor` property for the element.
   *
   * @param cursor The cursor property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setCursor(String cursor) {
    style().setCursor(cursor);
    return (T) this;
  }

  /**
   * Sets the CSS `cursor` property for the element.
   *
   * @param cursor The cursor property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setCursor(String cursor, boolean important) {
    style().setCursor(cursor, important);
    return (T) this;
  }

  /**
   * Sets the CSS `position` property for the element.
   *
   * @param position The position property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPosition(String position) {
    style().setPosition(position);
    return (T) this;
  }

  /**
   * Sets the CSS `position` property for the element.
   *
   * @param position The position property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setPosition(String position, boolean important) {
    style().setPosition(position, important);
    return (T) this;
  }

  /**
   * Sets the CSS `left` property for the element.
   *
   * @param left The left property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setLeft(String left) {
    style().setLeft(left);
    return (T) this;
  }

  /**
   * Sets the CSS `left` property for the element.
   *
   * @param left The left property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setLeft(String left, boolean important) {
    style().setLeft(left, important);
    return (T) this;
  }

  /**
   * Sets the CSS `right` property for the element.
   *
   * @param right The right property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setRight(String right) {
    style().setRight(right);
    return (T) this;
  }

  /**
   * Sets the CSS `right` property for the element.
   *
   * @param right The right property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setRight(String right, boolean important) {
    style().setRight(right, important);
    return (T) this;
  }

  /**
   * Sets the CSS `top` property for the element.
   *
   * @param top The top property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setTop(String top) {
    style().setTop(top);
    return (T) this;
  }

  /**
   * Sets the CSS `top` property for the element.
   *
   * @param top The top property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setTop(String top, boolean important) {
    style().setTop(top, important);
    return (T) this;
  }

  /**
   * Sets the CSS `bottom` property for the element.
   *
   * @param bottom The bottom property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setBottom(String bottom) {
    style().setBottom(bottom);
    return (T) this;
  }

  /**
   * Sets the CSS `bottom` property for the element.
   *
   * @param bottom The bottom property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setBottom(String bottom, boolean important) {
    style().setBottom(bottom, important);
    return (T) this;
  }

  /**
   * Checks if the element contains a CSS class.
   *
   * @param cssClass The CSS class name to check.
   * @return True if the class is found, false otherwise.
   */
  @Override
  public boolean containsCss(String cssClass) {
    return style().containsCss(cssClass);
  }

  /**
   * Checks if the element has a specific CSS class.
   *
   * @param cssClass The CSS class name to check.
   * @return An optional containing the CSS class name if found, empty otherwise.
   */
  public Optional<String> hasCssClass(String cssClass) {
    return style().containsCss(cssClass) ? Optional.of(cssClass) : Optional.empty();
  }

  /**
   * Aligns the element's content to the center horizontally.
   *
   * @return The modified DOM element.
   */
  @Override
  public T alignCenter() {
    style().alignCenter();
    return (T) this;
  }

  /**
   * Aligns the element's content to the right horizontally.
   *
   * @return The modified DOM element.
   */
  @Override
  public T alignRight() {
    style().alignRight();
    return (T) this;
  }

  /**
   * Sets the CSS text for the element's style.
   *
   * @param cssText The CSS text to set.
   * @return The modified DOM element.
   */
  @Override
  public T cssText(String cssText) {
    style().cssText(cssText);
    return (T) this;
  }

  /**
   * Returns the count of CSS classes applied to the element.
   *
   * @return The count of CSS classes.
   */
  @Override
  public int cssClassesCount() {
    return style().cssClassesCount();
  }

  /**
   * Returns the CSS class name at the specified index.
   *
   * @param index The index of the CSS class to retrieve.
   * @return The CSS class name.
   */
  @Override
  public String cssClassByIndex(int index) {
    return style().cssClassByIndex(index);
  }

  /**
   * Sets the CSS `pointer-events` property for the element.
   *
   * @param pointerEvents The pointer-events property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setPointerEvents(String pointerEvents) {
    style().setPointerEvents(pointerEvents);
    return (T) this;
  }

  /**
   * Sets the CSS `align-items` property for the element.
   *
   * @param alignItems The align-items property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setAlignItems(String alignItems) {
    style().setAlignItems(alignItems);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow-y` property for the element.
   *
   * @param overflow The overflow-y property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlowY(String overflow) {
    style().setOverFlowY(overflow);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow-y` property for the element.
   *
   * @param overflow The overflow-y property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlowY(String overflow, boolean important) {
    style().setOverFlowY(overflow, important);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow-x` property for the element.
   *
   * @param overflow The overflow-x property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlowX(String overflow) {
    style().setOverFlowX(overflow);
    return (T) this;
  }

  /**
   * Sets the CSS `overflow-x` property for the element.
   *
   * @param overflow The overflow-x property value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setOverFlowX(String overflow, boolean important) {
    style().setOverFlowX(overflow, important);
    return (T) this;
  }

  /**
   * Sets the CSS `box-shadow` property for the element.
   *
   * @param boxShadow The box-shadow property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setBoxShadow(String boxShadow) {
    style().setBoxShadow(boxShadow);
    return (T) this;
  }

  /**
   * Sets the CSS `transition-duration` property for the element.
   *
   * @param transactionDuration The transition-duration property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setTransitionDuration(String transactionDuration) {
    style().setTransitionDuration(transactionDuration);
    return (T) this;
  }

  /**
   * Sets the CSS `flex` property for the element.
   *
   * @param flex The flex property value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setFlex(String flex) {
    style().setFlex(flex);
    return (T) this;
  }

  /**
   * Sets the opacity of the element using a CSS style.
   *
   * @param opacity The opacity value to set.
   * @return The modified DOM element.
   */
  @Override
  public T setOpacity(double opacity) {
    style().setOpacity(opacity);
    return (T) this;
  }

  /**
   * Sets the opacity of the element using a CSS style.
   *
   * @param opacity The opacity value to set.
   * @param important Whether the style should be marked as !important.
   * @return The modified DOM element.
   */
  @Override
  public T setOpacity(double opacity, boolean important) {
    style().setOpacity(opacity, important);
    return (T) this;
  }

  /**
   * Sets the drop-down menu associated with this element.
   *
   * @param dropMenu The drop-down menu to set.
   * @return The modified DOM element.
   */
  public T setDropMenu(Menu<?> dropMenu) {
    if (nonNull(dropMenu)) {
      dropMenu.setTargetElement(this);
    }
    return (T) this;
  }

  /**
   * Retrieves the computed CSS style of the element.
   *
   * @return The computed CSS style declaration.
   */
  public CSSStyleDeclaration getComputedStyle() {
    return DominoDom.window.getComputedStyle(element());
  }

  /**
   * Applies a handler function to the computed CSS style of the element.
   *
   * @param handler The handler function to apply.
   * @return The modified DOM element.
   */
  public T withComputedStyle(ChildHandler<T, CSSStyleDeclaration> handler) {
    handler.apply((T) this, getComputedStyle());
    return (T) this;
  }

  /**
   * Finds and returns the first DOM element matching the specified CSS selector.
   *
   * @param selectors The CSS selector to search for.
   * @return The first matching DOM element, or null if none is found.
   */
  public DominoElement<HTMLElement> querySelector(String selectors) {
    Element element = this.element.element().querySelector(selectors);
    if (nonNull(element)) {
      return elementOf(Js.<HTMLElement>uncheckedCast(element));
    }
    return null;
  }

  /**
   * Finds and returns all DOM elements matching the specified CSS selector.
   *
   * @param selectors The CSS selector to search for.
   * @return A list of all matching DOM elements.
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
   * Retrieves the configuration settings for Domino UI.
   *
   * @return The Domino UI configuration.
   */
  protected DominoUIConfig config() {
    return DominoUIConfig.CONFIG;
  }

  /**
   * Retrieves the UI configuration settings for Domino UI.
   *
   * @return The UI configuration.
   */
  protected UIConfig uiconfig() {
    return DominoUIConfig.CONFIG.getUIConfig();
  }

  /**
   * Gets the map of meta objects associated with this element.
   *
   * @return The map of meta objects.
   */
  @Override
  public Map<String, ComponentMeta> getMetaObjects() {
    return metaObjects;
  }

  /**
   * Registers an event handler to be executed when a key is pressed down.
   *
   * @param onKeyDown The event handler for key down events.
   * @return The modified DOM element.
   */
  @Override
  public T onKeyDown(KeyEventsConsumer onKeyDown) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyDown(onKeyDown);
    return (T) this;
  }

  /**
   * Stops listening to key down events.
   *
   * @return The modified DOM element.
   */
  @Override
  public T stopOnKeyDown() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyDown();
    return (T) this;
  }

  /**
   * Registers an event handler to be executed when a key is released.
   *
   * @param onKeyUp The event handler for key up events.
   * @return The modified DOM element.
   */
  @Override
  public T onKeyUp(KeyEventsConsumer onKeyUp) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyUp(onKeyUp);
    return (T) this;
  }

  /**
   * Stops listening to key up events.
   *
   * @return The modified DOM element.
   */
  @Override
  public T stopOnKeyUp() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyUp();
    return (T) this;
  }

  /**
   * Registers an event handler to be executed when a key is pressed and released.
   *
   * @param onKeyPress The event handler for key press events.
   * @return The modified DOM element.
   */
  @Override
  public T onKeyPress(KeyEventsConsumer onKeyPress) {
    keyEventsInitializer.apply();
    keyboardEvents.listenOnKeyPress(onKeyPress);
    return (T) this;
  }

  /**
   * Stops listening to key press events.
   *
   * @return The modified DOM element.
   */
  @Override
  public T stopOnKeyPress() {
    keyEventsInitializer.apply();
    keyboardEvents.stopListenOnKeyPress();
    return (T) this;
  }

  /**
   * Retrieves the options for keyboard events.
   *
   * @return The keyboard event options.
   */
  @Override
  public KeyboardEventOptions getKeyboardEventsOptions() {
    keyEventsInitializer.apply();
    return keyboardEvents.getOptions();
  }

  /**
   * Sets the default options for keyboard events.
   *
   * @param defaultOptions The default keyboard event options to set.
   * @return The modified DOM element.
   */
  @Override
  public T setDefaultOptions(KeyboardEventOptions defaultOptions) {
    keyEventsInitializer.apply();
    keyboardEvents.setDefaultOptions(defaultOptions);
    return (T) this;
  }

  /**
   * Retrieves the Waves support associated with this element.
   *
   * @return The Waves support.
   */
  public WavesSupport getWavesSupport() {
    return wavesSupport;
  }

  /**
   * Functional interface for applying styles to an element.
   *
   * @param <E> The type of the element.
   */
  @FunctionalInterface
  public interface StyleEditor<E extends Element> {

    /**
     * Applies styles to the given element's style.
     *
     * @param style The style to apply.
     */
    void applyStyles(Style<E> style);
  }

  /** Functional interface for styling Waves effects. */
  @FunctionalInterface
  public interface WavesStyler {

    /**
     * Styles the Waves effect using the provided WavesSupport instance.
     *
     * @param wavesSupport The WavesSupport instance to style Waves.
     */
    void styleWaves(WavesSupport wavesSupport);
  }

  /**
   * Functional interface for handling element resizing.
   *
   * @param <T> The type of the element.
   */
  @FunctionalInterface
  public interface ResizeHandler<T> {

    /**
     * Handles element resizing.
     *
     * @param element The element being resized.
     * @param observer The ResizeObserver instance.
     * @param entries The ResizeObserver entries.
     */
    void onResize(T element, ResizeObserver observer, JsArray<ResizeObserverEntry> entries);
  }

  public static class HandlerRecord {
    private Runnable remover;

    public void setRemover(Runnable remover) {
      this.remover = remover;
    }

    public void remove() {
      remover.run();
    }
  }
}
