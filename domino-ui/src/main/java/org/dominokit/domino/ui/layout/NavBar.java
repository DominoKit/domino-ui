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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.layout.NavBarStyles.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.utils.*;

public class NavBar extends BaseDominoElement<HTMLElement, NavBar> {
  private NavElement root;
  private HeadingElement title;
  private LazyChild<SmallElement> description;

  public static NavBar create() {
    return new NavBar();
  }

  public static NavBar create(String title) {
    return new NavBar(title);
  }

  public NavBar() {
    root = nav().addCss(dui_nav_bar).appendChild(title = h(4).addCss(dui_nav_title));
    description = LazyChild.of(small().addCss(dui_nav_description), title);
    init(this);
  }

  public NavBar(String title) {
    this();
    setTitle(title);
  }

  public NavBar(String title, String description) {
    this(title);
    setDescription(description);
  }

  public NavBar setTitle(String title) {
    this.title.setTextContent(title);
    return this;
  }

  public NavBar setDescription(String description) {
    if (isNull(description) || description.isEmpty()) {
      this.description.remove();
    } else {
      this.description.get().setTextContent(description);
    }
    return this;
  }

  public NavBar withTitle(ChildHandler<NavBar, HeadingElement> handler) {
    handler.apply(this, title);
    return this;
  }

  public NavBar withDescription(ChildHandler<NavBar, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

  public HeadingElement getTitleElement() {
    return title;
  }

  public SmallElement getDescriptionElement() {
    return description.get();
  }

  public String getTitle() {
    return title.getTextContent();
  }

  public String getDescription() {
    return description.get().getTextContent();
  }

  @Override
  public HTMLElement element() {
    return root.element();
  }
}
