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

/** A general purpose utility class */
public class ElementUtil {

  /** The default {@link NumberConstants} to format numbers */
  static final NumberConstants numberConstants = LocaleInfo.getCurrentLocale().getNumberConstants();

  /** Constant <code>DUI_EVENT_SCROLL_TOP="dui-event-scroll-top"</code> */
  public static final String DUI_EVENT_SCROLL_TOP = "dui-event-scroll-top";

  /**
   * Removes all the children of the element
   *
   * @param element {@link elemental2.dom.Element}
   */
  public static void clear(Element element) {
    if (nonNull(element)) {
      while (nonNull(element.firstChild)) {
        element.removeChild(element.firstChild);
      }
    }
  }

  /**
   * Removes all the children of the element
   *
   * @param element {@link org.dominokit.domino.ui.IsElement}
   */
  public static void clear(IsElement<?> element) {
    clear(element.element());
  }

  /**
   * isKeyOf.
   *
   * @param keyCode String keyboard key code
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the KeyCode is same as the key of the KeyboradEvent
   */
  public static boolean isKeyOf(String keyCode, KeyboardEvent keyboardEvent) {
    return keyCode.equalsIgnoreCase(keyboardEvent.key);
  }

  /**
   * isEnterKey.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Enter key
   */
  public static boolean isEnterKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("enter", keyboardEvent);
  }

  /**
   * isSpaceKey.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Space key
   */
  public static boolean isSpaceKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("space", keyboardEvent);
  }

  /**
   * isArrowDown.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Arrow down key
   */
  public static boolean isArrowDown(KeyboardEvent keyboardEvent) {
    return isKeyOf("ArrowDown", keyboardEvent);
  }

  /**
   * isArrowUp.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Arrow up key
   */
  public static boolean isArrowUp(KeyboardEvent keyboardEvent) {
    return isKeyOf("ArrowUp", keyboardEvent);
  }

  /**
   * isTabKey.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Tab key
   */
  public static boolean isTabKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("tab", keyboardEvent);
  }

  /**
   * isEscapeKey.
   *
   * @param keyboardEvent {@link elemental2.dom.KeyboardEvent}
   * @return boolean, true if the Key pressed is Escape key
   */
  public static boolean isEscapeKey(KeyboardEvent keyboardEvent) {
    return isKeyOf("escape", keyboardEvent);
  }

  /**
   * Registers a callback when an element is appended to the document body. Note that the callback
   * will be called only once, if the element is appended more than once a new callback should be
   * registered.
   *
   * @param element the {@link elemental2.dom.HTMLElement} which is going to be added to the body
   * @param callback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return an Optional {@link org.dominokit.domino.ui.utils.ElementObserver}
   */
  public static Optional<ElementObserver> onAttach(
      HTMLElement element, AttachDetachCallback callback) {
    if (element != null) {
      elements.elementOf(element).onAttached(callback);
    }
    return Optional.empty();
  }

  /**
   * withBodyObserverPaused.
   *
   * @param handler a {@link java.lang.Runnable} object
   */
  public static void withBodyObserverPaused(Runnable handler) {
    BodyObserver.pauseFor(handler);
  }

  /**
   * {@link #onAttach(HTMLElement, AttachDetachCallback)}
   *
   * @param element the {@link org.dominokit.domino.ui.IsElement} which is going to be added to the
   *     body
   * @param callback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return an Optional {@link org.dominokit.domino.ui.utils.ElementObserver}
   */
  public static Optional<ElementObserver> onAttach(
      IsElement<?> element, AttachDetachCallback callback) {
    if (element != null) {
      elements.elementOf(element).onAttached(callback);
    }
    return Optional.empty();
  }

  /** startObserving. */
  public static void startObserving() {
    BodyObserver.startObserving();
  }

  /**
   * Registers a callback when an element is removed from the document body. Note that the callback
   * will be called only once, if the element is removed and re-appended a new callback should be
   * registered.
   *
   * @param element the {@link elemental2.dom.HTMLElement} which is going to be removed from the
   *     body
   * @param callback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return an Optional {@link org.dominokit.domino.ui.utils.ElementObserver}
   */
  public static Optional<ElementObserver> onDetach(
      HTMLElement element, AttachDetachCallback callback) {
    if (element != null) {
      elements.elementOf(element).onDetached(callback);
    }
    return Optional.empty();
  }

  /**
   * {@link #onDetach(HTMLElement, AttachDetachCallback)}
   *
   * @param element the {@link elemental2.dom.HTMLElement} which is going to be removed from the
   *     body
   * @param callback {@link org.dominokit.domino.ui.utils.AttachDetachCallback}
   * @return an Optional {@link org.dominokit.domino.ui.utils.ElementObserver}
   */
  public static Optional<ElementObserver> onDetach(
      IsElement<?> element, AttachDetachCallback callback) {
    if (element != null) {
      elements.elementOf(element).onDetached(callback);
    }
    return Optional.empty();
  }

  //
  //  /**
  //   * Force an input component to accept only numbers inputs
  //   *
  //   * @param hasInputElement {@link HasInputElement}
  //   * @param <T> The type of the component that extends from {@link HasInputElement}
  //   * @return same component
  //   */
  //  public static <T extends HasInputElement> T numbersOnly(T hasInputElement) {
  //    hasInputElement
  //        .getInputElement()
  //            .get()
  //        .addEventListener(
  //            "keypress",
  //            evt -> {
  //              KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
  //              if (!(isMinusKey(keyboardEvent.key) || keyboardEvent.key.matches("^\\d+$"))) {
  //                evt.preventDefault();
  //              }
  //            });
  //    hasInputElement
  //        .getInputElement()
  //            .get()
  //        .addEventListener(
  //            "paste",
  //            evt -> {
  //              ClipboardEvent clipboardEvent = Js.uncheckedCast(evt);
  //              String text = clipboardEvent.clipboardData.getData("text");
  //              text = text.replace("-", "");
  //              if (!text.matches("^\\d+$")) {
  //                evt.preventDefault();
  //              }
  //            });
  //    return hasInputElement;
  //  }
  //
  //  /**
  //   * Force an input component to accept only numbers input with decimal characters
  //   *
  //   * @param hasInputElement {@link HasInputElement}
  //   * @param <T> The type of the component that extends from {@link HasInputElement}
  //   * @return same component
  //   */
  //  public static <T extends HasInputElement> T decimalOnly(T hasInputElement) {
  //    hasInputElement
  //        .getInputElement()
  //            .get()
  //        .addEventListener(
  //            "keypress",
  //            evt -> {
  //              KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
  //              String key = keyboardEvent.key;
  //              if (!(isMinusKey(keyboardEvent.key)
  //                  || key.equals(numberConstants.decimalSeparator())
  //                  || keyboardEvent.key.matches("^\\d+$"))) {
  //                evt.preventDefault();
  //              }
  //            });
  //    hasInputElement
  //        .getInputElement()
  //            .get()
  //        .addEventListener(
  //            "paste",
  //            evt -> {
  //              ClipboardEvent clipboardEvent = Js.uncheckedCast(evt);
  //              try {
  //
  // NumberFormat.getDecimalFormat().parse(clipboardEvent.clipboardData.getData("text"));
  //              } catch (Exception ex) {
  //                evt.preventDefault();
  //              }
  //            });
  //    return hasInputElement;
  //  }

  private static boolean isMinusKey(String key) {
    return numberConstants.minusSign().equals(key);
  }

  /** Scroll the document body to the top of the page */
  public static void scrollTop() {
    DomGlobal.document.body.scrollTop = 0;
    DomGlobal.document.documentElement.scrollTop = 0;
    CustomEventInit initOptions = CustomEventInit.create();
    initOptions.setBubbles(true);
    CustomEvent scrollTopEvent = new CustomEvent<>(DUI_EVENT_SCROLL_TOP, initOptions);
    DomGlobal.document.dispatchEvent(scrollTopEvent);
  }

  /**
   * Scrolls the document to the specified element, making the element visible on the screen
   *
   * @param isElement {@link org.dominokit.domino.ui.IsElement}
   */
  public static void scrollToElement(IsElement<?> isElement) {
    scrollToElement(isElement.element());
  }

  /**
   * Scrolls the document to the specified element, making the element visible on the screen
   *
   * @param element {@link elemental2.dom.HTMLElement}
   */
  public static void scrollToElement(Element element) {
    element.scrollIntoView();
  }

  /**
   * Creates an {@link elemental2.dom.HTMLAnchorElement} that opens it target link in a new browser
   * tab
   *
   * @param text String link text
   * @param targetUrl String link target url
   * @return new {@link elemental2.dom.HTMLAnchorElement} instance
   */
  public static HTMLAnchorElement openInNewTabLink(String text, String targetUrl) {
    return elements
        .a()
        .textContent(text)
        .addEventListener(EventType.click, event -> DomGlobal.window.open(targetUrl, "_blank"))
        .element();
  }

  /**
   * Scrolls a parent to make child visible in the browser window
   *
   * @param child {@link elemental2.dom.Element}
   * @param parent {@link elemental2.dom.Element}
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
}
