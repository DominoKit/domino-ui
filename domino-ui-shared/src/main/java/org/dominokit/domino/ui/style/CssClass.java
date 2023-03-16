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
package org.dominokit.domino.ui.style;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public interface CssClass {

  CssClass NONE = new NoneCss();

  String getCssClass();

  default void apply(IsElement<?> element){
    apply(element.element());
  }

  default void apply(HTMLElement element) {
    if (!element.classList.contains(getCssClass())) {
      element.classList.add(getCssClass());
    }
  }

  default boolean isAppliedTo(HTMLElement element) {
    if (nonNull(element)) {
      return element.classList.contains(getCssClass());
    }
    return false;
  }

  default boolean isAppliedTo(IsElement<?> element) {
    if (nonNull(element)) {
      return isAppliedTo(element.element());
    }
    return false;
  }

  default void remove(HTMLElement element) {
    element.classList.remove(getCssClass());
  }

  default void remove(IsElement<?> element) {
    remove(element.element());
  }
}
