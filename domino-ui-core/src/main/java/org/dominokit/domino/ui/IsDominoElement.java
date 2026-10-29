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
package org.dominokit.domino.ui;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.EventTarget;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import elemental2.dom.ScrollIntoViewOptions;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.dominokit.domino.ui.animations.TransitionListener;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.events.EventOptions;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.keyboard.HasKeyboardEvents;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.IsPopover;
import org.dominokit.domino.ui.popover.IsTooltip;
import org.dominokit.domino.ui.style.DominoStyle;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.HasWaveEffect;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WavesSupport;
import org.dominokit.domino.ui.utils.AcceptReadOnly;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementHandler;
import org.dominokit.domino.ui.utils.HandlerRecord;
import org.dominokit.domino.ui.utils.HasAttributes;
import org.dominokit.domino.ui.utils.HasChildren;
import org.dominokit.domino.ui.utils.HasMeta;
import org.dominokit.domino.ui.utils.HasOpenCloseListeners;
import org.dominokit.domino.ui.utils.HasWavesElement;
import org.dominokit.domino.ui.utils.HasZIndexLayer;
import org.dominokit.domino.ui.utils.IsAttribute;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.dominokit.domino.ui.utils.MutationObserverCallback;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.dominokit.domino.ui.utils.PrimaryAddOn;
import org.dominokit.domino.ui.utils.PrimaryAddOnElement;
import org.dominokit.domino.ui.utils.Register;
import org.dominokit.domino.ui.utils.ResizeHandler;
import org.dominokit.domino.ui.utils.ScreenMedia;
import org.dominokit.domino.ui.utils.ScrollOptions;
import org.gwtproject.safehtml.shared.SafeHtml;

/** Aggregate contract implemented by {@link BaseDominoElement}. */
public interface IsDominoElement<E extends Element, T extends IsElement<E>>
    extends IsElement<E>,
        HasAttributes<T>,
        HasZIndexLayer<T>,
        IsCollapsible<T>,
        HasOpenCloseListeners<T>,
        HasKeyboardEvents<T>,
        HasMeta<T>,
        HasWavesElement,
        HasWaveEffect<T>,
        DominoStyle<E, T>,
        AcceptReadOnly<T>,
        HasChildren<T> {

  /** Functional contract used to customize the element's inline style. */
  @FunctionalInterface
  interface StyleEditor<E extends Element> extends BaseDominoElement.StyleEditor<E> {}

  /** Functional contract used to customize the element's wave effect. */
  @FunctionalInterface
  interface WavesStyler extends BaseDominoElement.WavesStyler {}

  // Public API provided by BaseDominoElement.
  String ATTACH_UID_KEY = "dui-on-attach-uid";
  String DETACH_UID_KEY = "dui-on-detach-uid";
  String ATTRIBUTE_CHANGE_UID_KEY = "dui-on-attribute-change-uid";
  String CHARACTER_DATA_CHANGE_UID_KEY = "dui-on-character-data-change-uid";

  Style<Element> style();

  Element getStyleTarget();

  T setId(String id);

  int getZIndex();

  T clearElement();

  T clearSelf();

  T withElement(ChildHandler<T, E> handler);

  Element getAppendTarget();

  T appendChild(Node node);

  T appendChild(Node... nodes);

  T appendChild(String text);

  T appendChild(IsElement<?> child);

  T appendChild(IsElement<?>... children);

  T appendChild(PrefixAddOn<?> prefix);

  T appendChild(PrefixAddOn<?>... prefixes);

  T appendChild(PostfixAddOn<?> postfix);

  T appendChild(PostfixAddOn<?>... postfixes);

  T appendChild(PrimaryAddOn<?> addon);

  T appendChild(PrimaryAddOn<?>... addons);

  T prependChild(Node node);

  T prependChild(String text);

  T prependChild(IsElement<?> element);

  PostfixElement getPostfixElement();

  PrefixElement getPrefixElement();

  PrimaryAddOnElement getPrimaryAddonsElement();

  T withPrefixElement(ChildHandler<T, PrefixElement> handler);

  T withPostfixElement(ChildHandler<T, PostfixElement> handler);

  List<DominoElement<Element>> childElements();

  DominoElement<HTMLElement> parent();

  DominoElement<HTMLElement> querySelector(String selectors);

  List<DominoElement<Element>> querySelectorAll(String selectors);

  T withPopover(ChildHandler<T, IsPopover<?, ?>> handler);

  T setTooltip(String text);

  T setTooltip(String text, DropDirection position);

  T setTooltip(Node content);

  T setTooltip(IsElement<?> content);

  T setTooltip(IsElement<?> content, DropDirection position);

  T withToolTip(ChildHandler<T, Optional<IsTooltip<?, ?>>> handler);

  T setTooltip(Node content, DropDirection position);

  T removeTooltip();

  IsTooltip<?, ?> getTooltip();

  T setRole(String role);

  T setAriaLabel(String label);

  T setAriaLabelledBy(String id);

  T setAriaDescribedBy(String ids);

  T setAriaControls(String id);

  T setAriaExpanded(boolean expanded);

  T setAriaSelected(boolean selected);

  T setAriaPressed(boolean pressed);

  T setAriaChecked(boolean checked);

  T setAriaCurrent(String current);

  T setAriaHidden(boolean hidden);

  T setAriaDisabled(boolean disabled);

  T setAriaRequired(boolean required);

  T setAriaInvalid(boolean invalid);

  T setAriaLive(String politeness);

  T setAriaHasPopup(boolean hasPopup);

  T setAriaHasPopup(String popupType);

  T setAriaAutocomplete(String autocomplete);

  T setAriaMultiline(boolean multiline);

  T setAriaValueMin(double value);

  T setAriaValueMax(double value);

  T setAriaValueNow(double value);

  T id(String id);

  String getId();

  T setAttribute(IsAttribute<?> attribute);

  T setAttribute(IsAttribute<?>... attributes);

  String getAttribute(String name, String orElseValue);

  boolean hasAttribute(String name);

  T insertBefore(Node newNode, Node otherNode);

  T insertAdjacentElement(String where, Element e);

  T insertBeforeBegin(Element e);

  T insertAfterBegin(Element e);

  T insertBeforeEnd(Element e);

  T insertAfterEnd(Element e);

  T insertAfter(Node newNode, Node otherNode);

  T insertFirst(Node newNode);

  T insertFirst(IsElement<?> element);

  T insertBefore(
      Node newNode, BaseDominoElement<? extends HTMLElement, ? extends IsElement<?>> otherNode);

  T insertAdjacentElement(String where, BaseDominoElement<?, ?> otherNode);

  T insertBeforeBegin(BaseDominoElement<?, ?> otherNode);

  T insertAfterBegin(BaseDominoElement<?, ?> otherNode);

  T insertBeforeEnd(BaseDominoElement<?, ?> otherNode);

  T insertAfterEnd(BaseDominoElement<?, ?> otherNode);

  T insertBefore(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode);

  T insertBefore(BaseDominoElement<?, ?> newNode, Node otherNode);

  T insertAfter(Node newNode, BaseDominoElement<?, ?> otherNode);

  T insertAfter(BaseDominoElement<?, ?> newNode, BaseDominoElement<?, ?> otherNode);

  T insertAfter(BaseDominoElement<?, ?> newNode, Node otherNode);

  T insertFirst(BaseDominoElement<?, ?> newNode);

  boolean contains(IsElement<? extends Element> node);

  boolean contains(Node node);

  boolean hasDirectChild(Node node);

  NodeList<Node> childNodes();

  Node parentNode();

  Node firstChild();

  Node lastChild();

  T blur();

  T remove();

  T addOnBeforeRemoveListener(Consumer<T> handler);

  T removeOnBeforeRemoveListener(Consumer<T> handler);

  T addOnRemoveListener(Consumer<T> handler);

  T removeOnRemoveListener(Consumer<T> handler);

  T removeChild(Node node);

  T removeChild(IsElement<?> elementToRemove);

  boolean isEqualNode(Node node);

  T apply(ElementHandler<T> elementHandler);

  T with(ElementHandler<T> elementHandler);

  T applyIf(Predicate<T> condition, ElementHandler<T> elementHandler);

  T setContent(IsElement<?> element);

  T setContent(Node content);

  int getElementsCount();

  boolean isEmptyElement();

  double getChildElementCount();

  Node getFirstChild();

  boolean hasChildNodes();

  String getDominoId();

  T disable();

  boolean isDisabled();

  T enable();

  boolean isEnabled();

  T setDisabled(boolean disabled);

  T setEnabled(boolean enabled);

  T setTabIndex(int tabIndex);

  T toggleDisplay();

  T toggleDisplay(boolean state);

  T show();

  T hide();

  boolean isHidden();

  boolean isVisible();

  T withWaves();

  T withWaves(ChildHandler<T, WavesSupport> handler);

  T withWaves(BaseDominoElement.WavesStyler wavesStyler);

  WavesSupport getWavesSupport();

  boolean isOverFlowing();

  boolean isPartialVisible();

  boolean isFullyVisible();

  double getVisibleWidth();

  double getVisibleHeight();

  T scrollIntoView();

  T scrollIntoView(ScrollOptions options);

  T scrollIntoView(ScrollIntoViewOptions options);

  boolean isForceCollapsed();

  T setForceCollapsed(boolean forceCollapsed);

  Collapsible getCollapsible();

  T setCollapseStrategy(CollapseStrategy strategy);

  Element getCollapsibleElement();

  T hideOn(ScreenMedia screenMedia);

  T removeHideOn();

  T showOn(ScreenMedia screenMedia);

  T removeShowOn();

  T addCollapseListener(Collapsible.CollapseHandler handler);

  T addBeforeCollapseListener(Collapsible.CollapseHandler handler);

  T removeCollapseListener(Collapsible.CollapseHandler handler);

  T removeBeforeCollapseListener(Collapsible.CollapseHandler handler);

  T addExpandListener(Collapsible.ExpandHandler handler);

  T addBeforeExpandListener(Collapsible.ExpandHandler handler);

  T removeExpandListener(Collapsible.ExpandHandler handler);

  T removeBeforeExpandListener(Collapsible.ExpandHandler handler);

  T dispatchEvent(Event evt);

  T addClickListener(EventListener listener);

  T addClickListener(EventListener listener, boolean capture);

  T removeClickListener(EventListener listener);

  T removeClickListener(EventListener listener, boolean capture);

  T addEventListener(String type, EventListener listener);

  T addEventListener(String type, EventListener listener, boolean options);

  T addEventsListener(EventListener listener, String... events);

  T addEventListener(String type, EventListener listener, EventOptions options);

  T addEventListener(
      String type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options);

  T addEventsListener(EventListener listener, boolean options, String... events);

  T addEventListener(EventType type, EventListener listener);

  T addEventListener(EventType type, EventListener listener, boolean options);

  T addEventListener(EventType type, EventListener listener, AddEventListenerOptions options);

  T addEventListener(
      EventType type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options);

  T addEventListener(EventType type, EventListener listener, EventOptions options);

  T removeEventListener(EventType type, EventListener listener);

  T removeEventListener(String type, EventListener listener);

  T removeEventListener(EventType type, EventListener listener, AddEventListenerOptions options);

  T removeEventListener(
      EventType type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options);

  T removeEventListener(EventType type, EventListener listener, EventOptions options);

  Element getClickableElement();

  T onTransitionStart(TransitionListener<? super T> listener);

  T removeTransitionStartListener(TransitionListener<? super T> listener);

  T onTransitionCancel(TransitionListener<? super T> listener);

  T removeTransitionCancelListener(TransitionListener<? super T> listener);

  T onTransitionEnd(TransitionListener<? super T> listener);

  T removeTransitionEndListener(TransitionListener<? super T> listener);

  T onResize(ResizeHandler<T> resizeHandler);

  T onResize(ResizeHandler<T> resizeHandler, HandlerRecord record);

  T setMetaObject(ComponentMeta meta);

  T onAttachedDetached(MutationObserverCallback observerCallback);

  T onAttached(MutationObserverCallback observerCallback);

  Register registerOnAttached(MutationObserverCallback observerCallback);

  T onDetached(MutationObserverCallback callback);

  Register registerOnDetached(MutationObserverCallback callback);

  T removeAttachObserver(MutationObserverCallback callback);

  T removeDetachObserver(MutationObserverCallback callback);

  boolean isAttached();

  T nowOrWhenAttached(Runnable handler);

  Register registerNowOrWhenAttached(Runnable handler);

  T nowOrWhenDetached(Runnable handler);

  Register registerNowOrWhenDetached(Runnable handler);

  T nowAndWhenAttached(Runnable handler);

  Register registerNowAndWhenAttached(Runnable handler);

  T nowAndWhenDetached(Runnable handler);

  Register registerNowAndWhenDetached(Runnable handler);

  T onAttributeChange(MutationObserverCallback observerCallback);

  T onAttributeChange(String attribute, MutationObserverCallback observerCallback);

  T withAttributeObserverPaused(Runnable runnable);

  T onTextContentChange(MutationObserverCallback observerCallback);

  T withTextContentObserverPaused(Runnable runnable);

  T style(String style);

  CSSStyleDeclaration elementStyle();

  T css(String cssClass);

  T css(String... cssClasses);

  DOMRect getBoundingClientRect();

  T styler(BaseDominoElement.StyleEditor<Element> styleEditor);

  T setTextContent(String text);

  T textContent(String text);

  T textContent(int number);

  T textContent(Number number);

  T textContent(float number);

  T textContent(short number);

  T textContent(double number);

  T textContent(boolean bool);

  String getTextContent();

  T setInnerHtml(String html);

  T setInnerHtml(SafeHtml html);

  Optional<String> hasCssClass(String cssClass);

  CSSStyleDeclaration getComputedStyle();

  T withComputedStyle(ChildHandler<T, CSSStyleDeclaration> handler);

  Elevation getElevation();
}
