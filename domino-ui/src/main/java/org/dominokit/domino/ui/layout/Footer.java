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

import static org.jboss.elemento.Elements.footer;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** a Component that represent the footer in the {@link Layout} */
public class Footer extends BaseDominoElement<HTMLElement, Footer> {

  private DominoElement<HTMLElement> element = DominoElement.of(footer().css("footer"));
  private boolean autoUnFixForSmallScreens = true;
  private boolean fixed = false;

  /** @return new Footer instance */
  public static Footer create() {
    return new Footer();
  }

  /** */
  public Footer() {
    init(this);
    hide();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /**
   * Make the footer fixed at the bottom of the visible area of the browser while the content scroll
   * behind it so it is always visible
   *
   * @return same Footer instance
   */
  public Footer fixed() {
    element.addCss("fixed");
    this.fixed = true;
    return this;
  }

  /**
   * Make the footer move down when the content exceeds the visible browser area and the user need
   * to scroll to the bottom to see the footer
   *
   * @return same Footer instance
   */
  public Footer unfixed() {
    element.removeCss("fixed");
    this.fixed = false;
    return this;
  }

  /** @return boolean, true if autoUnFixForSmallScreens is enabled */
  public boolean isAutoUnFixForSmallScreens() {
    return autoUnFixForSmallScreens;
  }

  /**
   * @param autoUnFixForSmallScreens boolean, if true a fixed footer will be automatically unfixed
   *     for small screens
   * @return same Footer instance
   */
  public Footer setAutoUnFixForSmallScreens(boolean autoUnFixForSmallScreens) {
    this.autoUnFixForSmallScreens = autoUnFixForSmallScreens;
    return this;
  }

  /** @return boolean, true if the footer fixed is enabled */
  public boolean isFixed() {
    return fixed;
  }
}
