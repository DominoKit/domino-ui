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
package org.dominokit.domino.ui.themes;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;

public interface IsDominoTheme extends ElementsFactory, DominoCss {

  String getName();

  String getCategory();

  default void apply(IsElement<? extends Element> target) {
    apply(target.element());
  }

  default void cleanup(IsElement<? extends Element> target) {
    cleanup(target.element());
  }

  default boolean isApplied(IsElement<? extends Element> target) {
    return isApplied(target.element());
  }

  default void apply() {
    apply(body().element());
  };

  default void cleanup() {
    cleanup(body().element());
  }

  default boolean isApplied() {
    return isApplied(body().element());
  }

  void apply(Element target);

  void cleanup(Element target);

  boolean isApplied(Element target);
}
