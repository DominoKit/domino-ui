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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;

/**
 * Shared implementation for components that expose a title, description, and body in a nav-like
 * layout.
 *
 * @param <C> the concrete component type
 */
public abstract class BaseNavBar<C extends BaseNavBar<C>>
    extends BaseDominoElement<HTMLElement, C> {
  private final NavElement root;
  private final DivElement prefixAddons;
  private final HeadingElement title;
  private final SpanElement titleTextElement;
  private final LazyChild<SmallElement> description;
  private final DivElement body;
  private final DivElement postfixAddons;

  protected BaseNavBar() {
    root =
        nav()
            .addCss(dui_nav_bar_base)
            .appendChild(prefixAddons = div().addCss(dui_nav_prefix_addons))
            .appendChild(
                title =
                    h(4).appendChild(titleTextElement = span().addCss(dui_nav_title_text))
                        .addCss(dui_nav_title))
            .appendChild(body = div().addCss(dui_nav_body))
            .appendChild(postfixAddons = div().addCss(dui_nav_postfix_addons));
    description = LazyChild.of(small().addCss(dui_nav_description), title);
    init((C) this);
  }

  /** Sets the title. */
  public C setTitle(String title) {
    return setTitle(text(title));
  }

  /** Sets the title node. */
  public C setTitle(Node title) {
    this.titleTextElement.clearElement().appendChild(title);
    return (C) this;
  }

  /**
   * Enables or disables the stacked responsive layout for small screens. When enabled, prefix
   * add-ons and the title remain on the first row, body content uses its own row, and postfix
   * add-ons move to a row below them. The default is disabled, preserving the existing layout.
   *
   * @param responsive whether to use the stacked small-screen layout
   * @return this navbar
   */
  public C setResponsiveLayout(boolean responsive) {
    if (responsive) {
      addCss(dui_nav_bar_responsive);
    } else {
      removeCss(dui_nav_bar_responsive);
    }
    return (C) this;
  }

  /** Sets or removes the description. */
  public C setDescription(String description) {
    if (isNull(description) || description.isEmpty()) {
      this.description.remove();
    } else {
      this.description.get().setTextContent(description);
    }
    return (C) this;
  }

  /** Customizes the title element. */
  public C withTitle(ChildHandler<C, HeadingElement> handler) {
    handler.apply((C) this, title);
    return (C) this;
  }

  /** Customizes the description element. */
  public C withDescription(ChildHandler<C, SmallElement> handler) {
    handler.apply((C) this, description.get());
    return (C) this;
  }

  /** Customizes the title text element. */
  public C withTitleTextElement(ChildHandler<C, SpanElement> handler) {
    handler.apply((C) this, titleTextElement);
    return (C) this;
  }

  /** Returns the title element. */
  public HeadingElement getTitleElement() {
    return title;
  }

  /** Returns the description element, initializing it if necessary. */
  public SmallElement getDescriptionElement() {
    return description.get();
  }

  /** Returns the title text. */
  public String getTitle() {
    return title.getTextContent();
  }

  /** Returns the title text element. */
  public SpanElement getTitleTextElement() {
    return titleTextElement;
  }

  /** Returns the description text. */
  public String getDescription() {
    return description.get().getTextContent();
  }

  /** Customizes the body element. */
  public C withBody(ChildHandler<C, DivElement> handler) {
    handler.apply((C) this, body);
    return (C) this;
  }

  /** Returns the body element. */
  public DivElement getBody() {
    return body;
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(prefixAddons);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(postfixAddons);
  }

  @Override
  public HTMLElement element() {
    return root.element();
  }
}
