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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.*;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.events.EventType;
import org.gwtproject.i18n.shared.cldr.LocaleInfo;
import org.gwtproject.i18n.shared.cldr.NumberConstants;

/** A utility class for working with HTML elements and events in the DOM. */
public class ElementUtil {

  /** Locale-specific number constants used for formatting numbers and currency. */
  static final NumberConstants numberConstants = LocaleInfo.getCurrentLocale().getNumberConstants();

  /** Custom event name for triggering a scroll to the top of the page. */
  public static final String DUI_EVENT_SCROLL_TOP = "dui-event-scroll-top";

  /**
   * Clears all child elements from the specified HTML element.
   *
   * @param element The HTML element to clear.
   */
  public static void clear(Element element) {
    if (nonNull(element)) {
      while (nonNull(element.firstChild)) {
        element.removeChild(element.firstChild);
      }
    }
  }

  /**
   * Clears all child elements from the specified IsElement.
   *
   * @param element The IsElement to clear.
   */
  public static void clear(IsElement<?> element) {
    clear(element.element());
  }

  /**
   * Checks if the given key code matches the key in the provided KeyboardEvent.
   *
   * @param keyCode The key code to compare.
   * @param keyboardEvent The KeyboardEvent to check against.
   * @return {@code true} if the key code matches, {@code false} otherwise.
   */
  public static boolean isKeyOf(String keyCode, KeyboardEvent keyboardEvent) {
    return keyCode.equalsIgnoreCase(keyboardEvent.key);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Enter key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Enter, {@code false} otherwise.
   */
  public static boolean isEnterKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("enter", keyboardEvent);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Space key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Space, {@code false} otherwise.
   */
  public static boolean isSpaceKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("space", keyboardEvent);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Arrow Down key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Arrow Down, {@code false} otherwise.
   */
  public static boolean isArrowDown(KeyboardEvent keyboardEvent) {
    return isKeyOf("ArrowDown", keyboardEvent);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Arrow Up key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Arrow Up, {@code false} otherwise.
   */
  public static boolean isArrowUp(KeyboardEvent keyboardEvent) {
    return isKeyOf("ArrowUp", keyboardEvent);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Tab key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Tab, {@code false} otherwise.
   */
  public static boolean isTabKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("tab", keyboardEvent);
  }

  /**
   * Checks if the key in the provided KeyboardEvent is the Escape key.
   *
   * @param keyboardEvent The KeyboardEvent to check.
   * @return {@code true} if the key is Escape, {@code false} otherwise.
   */
  public static boolean isEscapeKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("escape", keyboardEvent);
  }

  /**
   * Registers an observer to be notified when an HTML element is attached to the DOM.
   *
   * @param element The HTMLElement to observe.
   * @param callback The callback to be invoked when the element is attached.
   * @return An {@link Optional} containing the {@link ElementObserver}, or empty if the element is
   *     null.
   */
  public static Optional<ElementObserver> onAttach(
      HTMLElement element, MutationObserverCallback callback) {
    if (element != null) {
      elements.elementOf(element).onAttached(callback);
    }
    return Optional.empty();
  }

  /**
   * Pauses the body observer to prevent it from triggering unnecessary events.
   *
   * @param handler The runnable to be executed while the observer is paused.
   */
  public static void withBodyObserverPaused(Runnable handler) {
    BodyObserver.pauseFor(handler);
  }

  /**
   * Pauses the body observer to prevent it from triggering unnecessary events.
   *
   * @param handler The runnable to be executed while the observer is paused.
   */
  public static void withAttributesObserverPaused(Runnable handler) {
    AttributesObserver.pauseFor(handler);
  }

  /**
   * Registers an observer to be notified when an IsElement is attached to the DOM.
   *
   * @param element The IsElement to observe.
   * @param callback The callback to be invoked when the element is attached.
   * @return An {@link Optional} containing the {@link ElementObserver}, or empty if the element is
   *     null.
   */
  public static Optional<ElementObserver> onAttach(
      IsElement<?> element, MutationObserverCallback callback) {
    if (element != null) {
      elements.elementOf(element).onAttached(callback);
    }
    return Optional.empty();
  }

  /** Starts observing the body for attach and detach events. */
  public static void startObserving() {
    BodyObserver.startObserving();
  }

  /** Starts observing the body for elements attributes changes events. */
  public static void startObservingAttributes() {
    AttributesObserver.startObserving();
  }

  /** Starts observing the body for elements attributes changes events. */
  public static void startObservingTextContent() {
    CharacterDataObserver.startObserving();
  }

  /**
   * Registers an observer to be notified when an HTMLElement is detached from the DOM.
   *
   * @param element The HTMLElement to observe.
   * @param callback The callback to be invoked when the element is detached.
   * @return An {@link Optional} containing the {@link ElementObserver}, or empty if the element is
   *     null.
   */
  public static Optional<ElementObserver> onDetach(
      HTMLElement element, MutationObserverCallback callback) {
    if (element != null) {
      elements.elementOf(element).onDetached(callback);
    }
    return Optional.empty();
  }

  /**
   * Registers an observer to be notified when an IsElement is detached from the DOM.
   *
   * @param element The IsElement to observe.
   * @param callback The callback to be invoked when the element is detached.
   * @return An {@link Optional} containing the {@link ElementObserver}, or empty if the element is
   *     null.
   */
  public static Optional<ElementObserver> onDetach(
      IsElement<?> element, MutationObserverCallback callback) {
    if (element != null) {
      elements.elementOf(element).onDetached(callback);
    }
    return Optional.empty();
  }

  /**
   * Checks if the provided key is the minus sign key according to the current locale.
   *
   * @param key The key to check.
   * @return {@code true} if the key matches the minus sign, {@code false} otherwise.
   */
  private static boolean isMinusKey(String key) {
    return numberConstants.minusSign().equals(key);
  }

  /** Scrolls the page to the top. */
  public static void scrollTop() {
    DomGlobal.document.body.scrollTop = 0;
    DomGlobal.document.documentElement.scrollTop = 0;
    CustomEventInit initOptions = CustomEventInit.create();
    initOptions.setBubbles(true);
    CustomEvent scrollTopEvent = new CustomEvent<>(DUI_EVENT_SCROLL_TOP, initOptions);
    DomGlobal.document.dispatchEvent(scrollTopEvent);
  }

  /**
   * Scrolls to the specified IsElement.
   *
   * @param isElement The IsElement to scroll to.
   */
  public static void scrollToElement(IsElement<?> isElement) {
    scrollToElement(isElement.element());
  }

  /**
   * Scrolls to the specified HTML element.
   *
   * @param element The HTML element to scroll to.
   */
  public static void scrollToElement(Element element) {
    element.scrollIntoView();
  }

  /**
   * Creates an HTML anchor element that opens a link in a new tab when clicked.
   *
   * @param text The text content of the anchor.
   * @param targetUrl The URL to open in a new tab.
   * @return An {@link HTMLAnchorElement} with the specified text and click behavior.
   */
  public static HTMLAnchorElement openInNewTabLink(String text, String targetUrl) {
    return elements
        .a()
        .textContent(text)
        .addEventListener(EventType.click, event -> DomGlobal.window.open(targetUrl, "_blank"))
        .element();
  }

  /**
   * Scrolls the parent element to bring a child element into view.
   *
   * @param child The child element.
   * @param parent The parent element to scroll.
   */
  public static void scrollIntoParent(Element child, Element parent) {

    DOMRect parentRect = parent.getBoundingClientRect();
    int parentHeight = parent.clientHeight;

    DOMRect childRect = child.getBoundingClientRect();
    boolean isViewable =
        ((childRect.top + childRect.height) >= parentRect.top)
            && ((childRect.top + childRect.height) <= parentRect.top + parentHeight);
    if (!isViewable) {
      parent.scrollTop = (childRect.top + parent.scrollTop) - parentRect.top;
    }
  }

  public static boolean getBooleanAttribute(Element element, String attributeName) {
    if (!element.hasAttribute(attributeName)) {
      return false;
    }
    String raw = element.getAttribute(attributeName);
    if (raw == null || raw.isEmpty()) {
      // presence with empty value => true (standard HTML boolean attribute)
      return true;
    }
    String v = raw.trim().toLowerCase();
    if ("false".equals(v) || "0".equals(v) || "no".equals(v) || "off".equals(v)) {
      return false;
    }
    if ("true".equals(v) || "1".equals(v) || "yes".equals(v) || "on".equals(v)) {
      return true;
    }
    // Any other non-empty value with presence => treat as true
    return true;
  }
}
