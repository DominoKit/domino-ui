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
package org.dominokit.domino.ui.layout;

import static org.jboss.elemento.Elements.aside;
import static org.jboss.elemento.Elements.section;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** The component that contains the left pabel and right panel of the {@link Layout} */
public class Section extends BaseDominoElement<HTMLElement, Section> {

  HTMLElement section;
  HTMLElement leftSide;
  HTMLElement rightSide;

  /** */
  public Section() {
    leftSide = DominoElement.of(aside()).id("leftsidebar").css(LayoutStyles.SIDEBAR).element();

    rightSide =
        DominoElement.of(aside())
            .id("rightsidebar")
            .css(LayoutStyles.RIGHT_SIDEBAR)
            .css(LayoutStyles.OVERLAY_OPEN)
            .style("height: calc(100vh - 70px); overflow-y: scroll;")
            .element();

    section = DominoElement.of(section()).add(leftSide).add(rightSide).element();

    init(this);
  }

  /** @return new Section component */
  public static Section create() {
    return new Section();
  }

  /** @return the left panel {@link HTMLElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLElement> getLeftSide() {
    return DominoElement.of(leftSide);
  }

  /** @return the right panel {@link HTMLElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLElement> getRightSide() {
    return DominoElement.of(rightSide);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return section;
  }
}
