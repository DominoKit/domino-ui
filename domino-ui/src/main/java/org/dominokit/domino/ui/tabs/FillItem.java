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
package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.tabs.TabStyles.dui_tab_item;

/** A component that adds a space between {@link Tab}s in the {@link TabsPanel} */
public class FillItem extends BaseDominoElement<HTMLLIElement, FillItem> {

  private LIElement element;

  public FillItem() {
    this.element = li().addCss(dui_tab_item, dui_grow_1);
    init(this);
  }

  /** @return new instance */
  public static FillItem create() {
    return new FillItem();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }
}
