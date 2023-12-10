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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.utils.*;

/**
 * The {@code NavBar} class represents a navigation bar UI component that typically contains a
 * title, description, and a body.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Create a NavBar with a title
 * NavBar navBar = NavBar.create("My Navigation Bar");
 *
 * // Set a description for the NavBar
 * navBar.setDescription("This is a sample navigation bar.");
 *
 * // Customize the title element
 * navBar.withTitle((nav, titleElement) -> {
 *     titleElement.addCss("custom-title");
 *     titleElement.setTextContent("Custom Title");
 * });
 *
 * // Customize the body element
 * navBar.withBody((nav, bodyElement) -> {
 *     bodyElement.addCss("custom-body");
 *     bodyElement.appendChild(TextNode.of("Custom Body Content"));
 * });
 * </pre>
 *
 * @see BaseDominoElement
 */
public class NavBar extends BaseDominoElement<HTMLElement, NavBar> {
  private NavElement root;
  private HeadingElement title;
  private LazyChild<SmallElement> description;
  private DivElement body;

  /**
   * Creates a new {@code NavBar} instance with default settings.
   *
   * @return A new {@code NavBar} instance.
   */
  public static NavBar create() {
    return new NavBar();
  }

  /**
   * Creates a new {@code NavBar} instance with the specified title.
   *
   * @param title The title to display in the navigation bar.
   * @return A new {@code NavBar} instance with the specified title.
   */
  public static NavBar create(String title) {
    return new NavBar(title);
  }

  /** Creates a new {@code NavBar} instance with default settings. */
  public NavBar() {
    root =
        nav()
            .addCss(dui_nav_bar)
            .appendChild(title = h(4).addCss(dui_nav_title))
            .appendChild(body = div().addCss(dui_nav_body));
    description = LazyChild.of(small().addCss(dui_nav_description), title);
    init(this);
  }

  /**
   * Creates a new {@code NavBar} instance with the specified title.
   *
   * @param title The title to display in the navigation bar.
   */
  public NavBar(String title) {
    this();
    setTitle(title);
  }

  /**
   * Constructs a {@code NavBar} with the specified title and description.
   *
   * @param title The title to be displayed in the navigation bar.
   * @param description The description to be displayed in the navigation bar.
   */
  public NavBar(String title, String description) {
    this(title);
    setDescription(description);
  }

  /**
   * Sets the title to display in the navigation bar.
   *
   * @param title The title to set.
   * @return This {@code NavBar} instance.
   */
  public NavBar setTitle(String title) {
    this.title.setTextContent(title);
    return this;
  }

  /**
   * Sets the description to display in the navigation bar.
   *
   * @param description The description to set.
   * @return This {@code NavBar} instance.
   */
  public NavBar setDescription(String description) {
    if (isNull(description) || description.isEmpty()) {
      this.description.remove();
    } else {
      this.description.get().setTextContent(description);
    }
    return this;
  }

  /**
   * Allows customization of the title element.
   *
   * @param handler The handler for customizing the title element.
   * @return This {@code NavBar} instance.
   */
  public NavBar withTitle(ChildHandler<NavBar, HeadingElement> handler) {
    handler.apply(this, title);
    return this;
  }

  /**
   * Allows customization of the description element.
   *
   * @param handler The handler for customizing the description element.
   * @return This {@code NavBar} instance.
   */
  public NavBar withDescription(ChildHandler<NavBar, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

  /**
   * Gets the title element.
   *
   * @return The title element.
   */
  public HeadingElement getTitleElement() {
    return title;
  }

  /**
   * Gets the description element.
   *
   * @return The description element.
   */
  public SmallElement getDescriptionElement() {
    return description.get();
  }

  /**
   * Gets the text of the title displayed in the navigation bar.
   *
   * @return The title text.
   */
  public String getTitle() {
    return title.getTextContent();
  }

  /**
   * Gets the text of the description displayed in the navigation bar.
   *
   * @return The description text.
   */
  public String getDescription() {
    return description.get().getTextContent();
  }

  /**
   * Allows customization of the body element.
   *
   * @param handler The handler for customizing the body element.
   * @return This {@code NavBar} instance.
   */
  public NavBar withBody(ChildHandler<NavBar, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Gets the body element.
   *
   * @return The body element.
   */
  public DivElement getBody() {
    return body;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return root.element();
  }
}
