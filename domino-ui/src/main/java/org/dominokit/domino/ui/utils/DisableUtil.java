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

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;

/** DisableUtil class. */
public class DisableUtil {

  /** Constant <code>FOCUSABLE_ELEMENTS="a, button, embed, iframe, label, audio["{trunked}</code> */
  public static final String FOCUSABLE_ELEMENTS =
      "a, button, embed, iframe, label, audio[controls], video[controls], img[usemap], object[usemap], input, textarea, select, details, [tabindex]";

  /**
   * disable.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   * @param <E> a E class
   */
  public static <E extends Element> void disable(IsElement<E> element) {
    Optional.ofNullable(element).ifPresent(e -> disable(e.element()));
  }

  /**
   * disable.
   *
   * @param element a {@link elemental2.dom.Element} object
   */
  public static void disable(Element element) {
    Optional.ofNullable(element)
        .ifPresent(
            e -> {
              DominoElement<Element> dominoElement = elements.elementOf(e);
              if (!isDisabled(dominoElement)) {
                disableElement(dominoElement);
                elements
                    .elementOf(element)
                    .querySelectorAll(FOCUSABLE_ELEMENTS)
                    .forEach(child -> disableChild(elements.elementOf(child)));
              }
            });
  }

  private static <E extends Element> void disableChild(DominoElement<E> element) {
    if (element.isDisabled()) {
      element.setAttribute("dui-disabled", "true");
    } else {
      disableElement(element);
    }
  }

  private static <E extends Element> void disableElement(DominoElement<E> element) {
    element.removeAttribute("dui-disabled");
    element.setAttribute("disabled", "");

    if (element.hasAttribute("tabindex")) {
      String original = element.getAttribute("tabindex");
      element.setAttribute("dui-tabindex", original);
    }
    element.setTabIndex(-1);
  }

  private static <E extends Element> boolean isDisabled(DominoElement<E> element) {
    return element.hasAttribute("disabled");
  }

  /**
   * enable.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   * @param <E> a E class
   */
  public static <E extends Element> void enable(IsElement<E> element) {
    Optional.ofNullable(element).ifPresent(e -> enable(e.element()));
  }

  /**
   * enable.
   *
   * @param element a {@link elemental2.dom.Element} object
   */
  public static void enable(Element element) {
    Optional.ofNullable(element)
        .ifPresent(
            e -> {
              DominoElement<Element> dominoElement = elements.elementOf(e);
              if (isDisabled(dominoElement)) {
                enableElement(dominoElement);
                elements
                    .elementOf(element)
                    .querySelectorAll(FOCUSABLE_ELEMENTS)
                    .forEach(child -> enableChild(elements.elementOf(child)));
              }
            });
  }

  private static <E extends Element> void enableChild(DominoElement<E> element) {
    if (element.hasAttribute("dui-disabled")) {
      element.removeAttribute("dui-disabled");
    } else {
      enableElement(element);
    }
  }

  private static <E extends Element> void enableElement(DominoElement<E> element) {
    element.removeAttribute("dui-disabled");
    element.removeAttribute("disabled");
    if (element.hasAttribute("dui-tabindex")) {
      String original = element.getAttribute("dui-tabindex");
      element.setTabIndex(Integer.parseInt(original));
    } else {
      element.removeAttribute("tabindex");
    }
  }
}
