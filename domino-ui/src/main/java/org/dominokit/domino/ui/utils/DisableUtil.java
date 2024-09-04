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

import elemental2.dom.HTMLElement;
import java.util.Optional;
import org.jboss.elemento.IsElement;

@Deprecated
public class DisableUtil {

  public static final String FOCUSABLE_ELEMENTS =
      "a[href], button, embed, iframe, label, audio[controls], video[controls], img[usemap], object[usemap], input, textarea, select, details, [tabindex]";

  public static <E extends HTMLElement> void disable(IsElement<E> element) {
    Optional.ofNullable(element).ifPresent(e -> disable(e.element()));
  }

  public static void disable(HTMLElement element) {

    Optional.ofNullable(element)
        .ifPresent(
            e -> {
              DominoElement<HTMLElement> dominoElement = DominoElement.of(e);
              if (!isDisabled(dominoElement)) {
                disableElement(dominoElement);
                DominoElement.of(element)
                    .querySelectorAll(FOCUSABLE_ELEMENTS)
                    .forEach(child -> disableChild(DominoElement.of(child)));
              }
            });
  }

  private static <E extends HTMLElement> void disableChild(DominoElement<E> element) {
    if (element.isDisabled()) {
      element.setAttribute("dui-disabled", "true");
    } else {
      disableElement(element);
    }
  }

  private static <E extends HTMLElement> void disableElement(DominoElement<E> element) {
    element.removeAttribute("dui-disabled");
    element.setAttribute("disabled", "");
    element.addCss("disabled");

    if (element.hasAttribute("tabindex")) {
      String original = element.getAttribute("tabindex");
      element.setAttribute("dui-tabindex", original);
    }
    element.setTabIndex(-1);
  }

  private static <E extends HTMLElement> boolean isDisabled(DominoElement<E> element) {
    return element.hasAttribute("disabled");
  }

  public static <E extends HTMLElement> void enable(IsElement<E> element) {
    Optional.ofNullable(element).ifPresent(e -> enable(e.element()));
  }

  public static void enable(HTMLElement element) {
    Optional.ofNullable(element)
        .ifPresent(
            e -> {
              DominoElement<HTMLElement> dominoElement = DominoElement.of(e);
              if (isDisabled(dominoElement)) {
                enableElement(dominoElement);
                DominoElement.of(element)
                    .querySelectorAll(FOCUSABLE_ELEMENTS)
                    .forEach(child -> enableChild(DominoElement.of(child)));
              }
            });
  }

  private static <E extends HTMLElement> void enableChild(DominoElement<E> element) {
    if (element.hasAttribute("dui-disabled")) {
      element.removeAttribute("dui-disabled");
    } else {
      enableElement(element);
    }
  }

  private static <E extends HTMLElement> void enableElement(DominoElement<E> element) {
    element.removeAttribute("dui-disabled");
    element.removeAttribute("disabled");
    element.removeCss("disabled");
    if (element.hasAttribute("dui-tabindex")) {
      String original = element.getAttribute("dui-tabindex");
      element.setTabIndex(Integer.parseInt(original));
    } else {
      element.removeAttribute("tabindex");
    }
  }
}
