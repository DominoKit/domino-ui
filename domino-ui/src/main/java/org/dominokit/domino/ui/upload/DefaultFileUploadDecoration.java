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
package org.dominokit.domino.ui.upload;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * Represents the decoration for a default file upload component.
 *
 * <p>This decoration includes an icon, title, and description to provide additional context for the
 * file upload component.
 *
 * @see BaseDominoElement
 */
public class DefaultFileUploadDecoration
    extends BaseDominoElement<HTMLDivElement, DefaultFileUploadDecoration>
    implements FileUploadStyles {

  /** The root element that holds the decoration elements. */
  private final DivElement root;

  /** LazyChild element for the icon. */
  private LazyChild<Icon<?>> iconElement;

  /** LazyChild element for the title. */
  private LazyChild<HeadingElement> titleElement;

  /** LazyChild element for the description. */
  private LazyChild<SmallElement> descriptionElement;

  /**
   * Creates a new {@code DefaultFileUploadDecoration} instance with default settings.
   *
   * @return A new {@code DefaultFileUploadDecoration} instance.
   */
  public static DefaultFileUploadDecoration create() {
    return new DefaultFileUploadDecoration();
  }

  /** Constructs a new {@code DefaultFileUploadDecoration} with default settings. */
  public DefaultFileUploadDecoration() {
    root = div().addCss(dui_flex, dui_flex_col, dui_text_center, dui_items_center);
    init(this);
  }

  /**
   * Constructs a new {@code DefaultFileUploadDecoration} with the specified icon.
   *
   * @param icon The icon to set.
   */
  public DefaultFileUploadDecoration(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Constructs a new {@code DefaultFileUploadDecoration} with the specified icon and title.
   *
   * @param icon The icon to set.
   * @param title The title to set.
   */
  public DefaultFileUploadDecoration(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  /**
   * Constructs a new {@code DefaultFileUploadDecoration} with the specified icon, title, and
   * description.
   *
   * @param icon The icon to set.
   * @param title The title to set.
   * @param description The description to set.
   */
  public DefaultFileUploadDecoration(Icon<?> icon, String title, String description) {
    this();
    setIcon(icon);
    setTitle(title);
    setDescription(description);
  }

  /**
   * Sets the icon for the decoration.
   *
   * @param icon The icon to set.
   * @return This {@code DefaultFileUploadDecoration} instance for method chaining.
   */
  public DefaultFileUploadDecoration setIcon(Icon<?> icon) {
    if (nonNull(iconElement) && iconElement.isInitialized()) {
      iconElement.remove();
    }
    if (nonNull(icon)) {
      iconElement = LazyChild.of(icon.addCss(dui_order_10), root);
      iconElement.get();
    }

    return this;
  }

  /**
   * Sets the title for the decoration.
   *
   * @param title The title to set.
   * @return This {@code DefaultFileUploadDecoration} instance for method chaining.
   */
  public DefaultFileUploadDecoration setTitle(String title) {
    if (nonNull(titleElement) && titleElement.isInitialized()) {
      titleElement.remove();
    }
    if (nonNull(title) && !title.isEmpty()) {
      titleElement = LazyChild.of(h(3).textContent(title).addCss(dui_order_20), root);
      titleElement.get();
    }

    return this;
  }

  /**
   * Sets the description for the decoration.
   *
   * @param description The description to set.
   * @return This {@code DefaultFileUploadDecoration} instance for method chaining.
   */
  public DefaultFileUploadDecoration setDescription(String description) {
    if (nonNull(descriptionElement) && descriptionElement.isInitialized()) {
      descriptionElement.remove();
    }
    if (nonNull(description) && !description.isEmpty()) {
      descriptionElement =
          LazyChild.of(small().textContent(description).addCss(dui_order_30), root);
      descriptionElement.get();
    }

    return this;
  }

  /**
   * Retrieves the HTML element of this decoration.
   *
   * @return The {@link HTMLDivElement} representing this decoration.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
