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

import static org.dominokit.domino.ui.layout.NavBarStyles.dui_nav_bar;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Node;

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
 * @see BaseNavBar
 */
public class NavBar extends BaseNavBar<NavBar> {

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
    return new NavBar(text(title));
  }

  /**
   * Creates a new {@code NavBar} instance with the specified title.
   *
   * @param title The title to display in the navigation bar.
   * @return A new {@code NavBar} instance with the specified title.
   */
  public static NavBar create(Node title) {
    return new NavBar(title);
  }

  /** Creates a new {@code NavBar} instance with default settings. */
  public NavBar() {
    super();
    addCss(dui_nav_bar);
  }

  /**
   * Creates a new {@code NavBar} instance with the specified title.
   *
   * @param title The title to display in the navigation bar.
   */
  public NavBar(Node title) {
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
    this(text(title));
    setDescription(description);
  }
}
