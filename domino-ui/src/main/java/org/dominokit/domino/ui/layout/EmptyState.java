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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.*;

/**
 * The {@code EmptyState} class represents a UI component for displaying an empty state with a
 * title, description, and icon.
 *
 * @see BaseDominoElement
 */
public class EmptyState extends BaseDominoElement<HTMLDivElement, EmptyState>
    implements EmptyStateStyles {

  private DivElement element;
  private LazyChild<HeadingElement> title;
  private LazyChild<SmallElement> description;

  private LazyChild<Icon<?>> icon = NullLazyChild.of();

  /** Creates a new {@code EmptyState} instance with default settings. */
  public EmptyState() {
    element = div().addCss(dui_empty_state);
    title = LazyChild.of(h(4).addCss(dui_empty_state_title), element);
    description = LazyChild.of(small().addCss(dui_empty_state_description), element);
    init(this);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title.
   *
   * @param title The title to display in the empty state.
   */
  public EmptyState(String title) {
    this();
    setTitle(title);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title and description.
   *
   * @param title The title to display in the empty state.
   * @param description The description to display in the empty state.
   */
  public EmptyState(String title, String description) {
    this(title);
    setDescription(description);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title and icon.
   *
   * @param title The title to display in the empty state.
   * @param icon The icon to display in the empty state.
   */
  public EmptyState(String title, Icon<?> icon) {
    this(title);
    setIcon(icon);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title, description, and icon.
   *
   * @param title The title to display in the empty state.
   * @param description The description to display in the empty state.
   * @param icon The icon to display in the empty state.
   */
  public EmptyState(String title, String description, Icon<?> icon) {
    this(title, description);
    setIcon(icon);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified icon.
   *
   * @param icon The icon to display in the empty state.
   */
  public EmptyState(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Creates a new {@code EmptyState} instance with default settings.
   *
   * @return A new {@code EmptyState} instance.
   */
  public static EmptyState create() {
    return new EmptyState();
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title.
   *
   * @param title The title to display in the empty state.
   * @return A new {@code EmptyState} instance with the specified title.
   */
  public static EmptyState create(String title) {
    return new EmptyState(title);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title and description.
   *
   * @param title The title to display in the empty state.
   * @param description The description to display in the empty state.
   * @return A new {@code EmptyState} instance with the specified title and description.
   */
  public static EmptyState create(String title, String description) {
    return new EmptyState(title, description);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title and icon.
   *
   * @param title The title to display in the empty state.
   * @param icon The icon to display in the empty state.
   * @return A new {@code EmptyState} instance with the specified title and icon.
   */
  public static EmptyState create(String title, Icon<?> icon) {
    return new EmptyState(title, icon);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified title, description, and icon.
   *
   * @param title The title to display in the empty state.
   * @param description The description to display in the empty state.
   * @param icon The icon to display in the empty state.
   * @return A new {@code EmptyState} instance with the specified title, description, and icon.
   */
  public static EmptyState create(String title, String description, Icon<?> icon) {
    return new EmptyState(title, description, icon);
  }

  /**
   * Creates a new {@code EmptyState} instance with the specified icon.
   *
   * @param icon The icon to display in the empty state.
   * @return A new {@code EmptyState} instance with the specified icon.
   */
  public static EmptyState create(Icon<?> icon) {
    return new EmptyState(icon);
  }

  /**
   * Sets the title to display in the empty state.
   *
   * @param title The title to set.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState setTitle(String title) {
    this.title.get().setTextContent(title);
    return this;
  }

  /**
   * Sets the description to display in the empty state.
   *
   * @param description The description to set.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState setDescription(String description) {
    this.description.get().setTextContent(description);
    return this;
  }

  /**
   * Sets the icon to display in the empty state.
   *
   * @param icon The icon to set.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState setIcon(Icon<?> icon) {
    this.icon.remove();
    this.icon = LazyChild.of(icon.addCss(dui_empty_state_icon), element);
    this.icon.get();
    return this;
  }

  /**
   * Gets the title element.
   *
   * @return The title element.
   */
  public HeadingElement getTitle() {
    return title.get();
  }

  /**
   * Gets the description element.
   *
   * @return The description element.
   */
  public SmallElement getDescription() {
    return description.get();
  }

  /**
   * Gets the icon element.
   *
   * @return The icon element.
   */
  public Icon<?> getIcon() {
    return icon.get();
  }

  /**
   * Allows customization of the title element.
   *
   * @param handler The handler for customizing the title element.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState withTitle(ChildHandler<EmptyState, HeadingElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  /**
   * Allows customization of the description element.
   *
   * @param handler The handler for customizing the description element.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState withDescription(ChildHandler<EmptyState, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

  /**
   * Allows customization of the icon element.
   *
   * @param handler The handler for customizing the icon element.
   * @return This {@code EmptyState} instance.
   */
  public EmptyState withIcon(ChildHandler<EmptyState, Icon<?>> handler) {
    handler.apply(this, icon.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
