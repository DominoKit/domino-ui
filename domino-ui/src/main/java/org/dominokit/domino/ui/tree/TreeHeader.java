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
package org.dominokit.domino.ui.tree;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;

/**
 * A component representing the header of a tree item in a UI tree.
 *
 * <p>The {@code TreeHeader} class allows you to create and customize the header of a tree item in a
 * UI tree. You can set the title and icon for the header, as well as add additional content.
 *
 * @see TreeItem
 * @see Icon
 * @see PostfixAddOn
 * @see BaseDominoElement
 */
public class TreeHeader extends BaseDominoElement<HTMLDivElement, TreeHeader>
    implements TreeStyles {

  private final DivElement element;
  private final DivElement content;
  private LazyChild<Icon<?>> headerIcon;
  private final LazyChild<SpanElement> textElement;

  /**
   * Creates a new {@code TreeHeader} instance with default settings.
   *
   * <p>This factory method creates a tree header without an icon or title.
   *
   * @return A new {@code TreeHeader} instance.
   */
  public static TreeHeader create() {
    return new TreeHeader();
  }

  /**
   * Creates a new {@code TreeHeader} instance with the specified icon.
   *
   * @param icon The icon to be displayed in the tree header.
   * @return A new {@code TreeHeader} instance with the specified icon.
   */
  public static TreeHeader create(Icon<?> icon) {
    return new TreeHeader(icon);
  }

  /**
   * Creates a new {@code TreeHeader} instance with the specified title.
   *
   * @param title The title to be displayed in the tree header.
   * @return A new {@code TreeHeader} instance with the specified title.
   */
  public static TreeHeader create(String title) {
    return new TreeHeader(title);
  }

  /**
   * Creates a new {@code TreeHeader} instance with the specified icon and title.
   *
   * @param icon The icon to be displayed in the tree header.
   * @param title The title to be displayed in the tree header.
   * @return A new {@code TreeHeader} instance with the specified icon and title.
   */
  public static TreeHeader create(Icon<?> icon, String title) {
    return new TreeHeader(icon, title);
  }

  /**
   * Creates a new {@code TreeHeader} instance with default settings.
   *
   * <p>This constructor creates a tree header without an icon or title.
   */
  public TreeHeader() {
    element =
        div()
            .addCss(dui_tree_header)
            .appendChild(
                content =
                    div()
                        .addCss(dui_tree_item_content)
                        .appendChild(div().addCss(dui_tree_item_filler)));
    textElement = LazyChild.of(span().addCss(dui_tree_header_item, dui_tree_item_text), content);
    init(this);
  }

  /**
   * Creates a new {@code TreeHeader} instance with an icon.
   *
   * @param icon The icon to be displayed in the tree header.
   */
  public TreeHeader(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Creates a new {@code TreeHeader} instance with a title.
   *
   * @param title The title to be displayed in the tree header.
   */
  public TreeHeader(String title) {
    this();
    setTitle(title);
  }

  /**
   * Creates a new {@code TreeHeader} instance with an icon and a title.
   *
   * @param icon The icon to be displayed in the tree header.
   * @param title The title to be displayed in the tree header.
   */
  public TreeHeader(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  /**
   * Sets the title for the tree header.
   *
   * @param title The title to be displayed in the tree header.
   * @return This {@code TreeHeader} instance for method chaining.
   */
  public TreeHeader setTitle(String title) {
    textElement.get().setTextContent(title);
    return this;
  }

  /**
   * Sets the icon for the tree header.
   *
   * @param icon The icon to be displayed in the tree header.
   * @return This {@code TreeHeader} instance for method chaining.
   */
  public TreeHeader setIcon(Icon<?> icon) {
    if (nonNull(headerIcon) && headerIcon.isInitialized()) {
      headerIcon.remove();
    }

    headerIcon = LazyChild.of(icon.addCss(dui_tree_header_item, dui_tree_item_icon), content);
    headerIcon.get();
    return this;
  }

  /**
   * Appends a postfix add-on to the tree header.
   *
   * @param postfixAddOn The postfix add-on to append.
   * @return This {@code TreeHeader} instance for method chaining.
   */
  public TreeHeader appendChild(PostfixAddOn<?> postfixAddOn) {
    if (nonNull(postfixAddOn)) {
      postfixAddOn.addCss(dui_tree_header_item);
      content.appendChild(postfixAddOn);
    }
    return this;
  }

  /**
   * Allows customizing the content of the tree header.
   *
   * @param handler A {@link ChildHandler} that provides access to the tree header and its content.
   * @return This {@code TreeHeader} instance for method chaining.
   */
  public TreeHeader withContent(ChildHandler<TreeHeader, DivElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /**
   * Retrieves the content element of the tree header.
   *
   * @return The content element of the tree header.
   */
  public DivElement getContent() {
    return content;
  }

  /**
   * Allows customizing the title element of the tree header.
   *
   * @param handler A {@link ChildHandler} that provides access to the tree header and its title
   *     element.
   * @return This {@code TreeHeader} instance for method chaining.
   */
  public TreeHeader withTitle(ChildHandler<TreeHeader, SpanElement> handler) {
    handler.apply(this, textElement.get());
    return this;
  }

  /**
   * Specifies that the tree header should include a title.
   *
   * <p>This method is used to indicate that the tree header should have a title element.
   *
   * @return This {@code TreeHeader} instance to allow method chaining.
   */
  public TreeHeader withTitle() {
    textElement.get();
    return this;
  }

  /**
   * Retrieves the title element of the tree header.
   *
   * @return The title element of the tree header.
   */
  public SpanElement getTitle() {
    return textElement.get();
  }

  /**
   * Gets the target element to which child elements should be appended.
   *
   * @return The target element for appending child elements.
   */
  @Override
  public HTMLElement getAppendTarget() {
    return content.element();
  }

  /**
   * Retrieves the underlying HTML element for this tree header.
   *
   * @return The HTML element representing this tree header.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
