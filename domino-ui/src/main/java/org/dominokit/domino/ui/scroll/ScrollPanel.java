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
package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** A component that wraps the {@link HTMLDivElement} to make it scrollable by default */
public class ScrollPanel extends BaseDominoElement<HTMLDivElement, ScrollPanel> {

  private DominoElement<HTMLDivElement> root;

  /** @return new AutoHScrollPanel instance */
  public static ScrollPanel create() {
    return new ScrollPanel();
  }

  public ScrollPanel() {
    root = div().addCss(dui_overflow_scroll);
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
