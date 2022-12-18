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
package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.jboss.elemento.IsElement;

/**
 * The implementation of this interface are used to change the behavior used in {@link Collapsible}
 * to show and hide the element.
 */
public interface CollapseStrategy {

  /**
   * Implement this method to provide any initialization required for the collapse strategy
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   */
  default void init(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {}

  /**
   * Implement this method to show a collapsible element
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   * @param onCompleted the {@link Runnable} to be executed when the show operation is completed
   */
  void show(
      HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style, Runnable onCompleted);
  /**
   * Implement this method to show a collapsible element
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   */
  default void show(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    show(element, style, () -> {});
  }

  /**
   * Implement this method to hide a collapsible element
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   * @param onCompleted the {@link Runnable} to be executed when the hide operation is completed
   */
  void hide(
      HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style, Runnable onCompleted);

  /**
   * Implement this method to hide a collapsible element
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   */
  default void hide(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    hide(element, style, () -> {});
  }

  /**
   * Implement this method to clean up any attributes or styles added the strategy when we switch to
   * a different one.
   *
   * @param element The collapsible {@link HTMLElement}
   * @param style the {@link Style} of the element
   */
  default void cleanup(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {};
}
