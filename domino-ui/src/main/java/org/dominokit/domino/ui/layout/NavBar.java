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

import static org.dominokit.domino.ui.layout.NavBarStyles.NAV_BAR;
import static org.dominokit.domino.ui.layout.NavBarStyles.TITLE;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

public class NavBar extends BaseDominoElement<HTMLElement, NavBar> {
  private DominoElement<HTMLElement> root;
  private LazyChild<DominoElement<HTMLHeadingElement>> lazyTitle;

  public static NavBar create() {
    return new NavBar();
  }

  public static NavBar create(String title) {
    return new NavBar(title);
  }

  public NavBar() {
    root = DominoElement.nav().addCss(NAV_BAR);
    lazyTitle = LazyChild.of(DominoElement.h4().addCss(TITLE), root);
    init(this);
  }

  public NavBar(String title) {
    this();
    setTitle(title);
  }

  public NavBar setTitle(String title) {
    lazyTitle.get().setTextContent(title);
    return this;
  }

  public NavBar withTitle(ChildHandler<NavBar, DominoElement<HTMLHeadingElement>> handler) {
    handler.apply(this, lazyTitle.get());
    return this;
  }

  public DominoElement<HTMLHeadingElement> getTitleElement() {
    return lazyTitle.get();
  }

  public String getTitle() {
    return lazyTitle.get().getTextContent();
  }

  @Override
  public HTMLElement element() {
    return root.element();
  }
}
