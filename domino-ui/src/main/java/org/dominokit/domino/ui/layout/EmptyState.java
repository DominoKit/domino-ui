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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.*;

/**
 * A component that indicate that other components or parts of the page has no content currently to
 * display
 *
 * <pre>
 * EmptyState.create(Icons.cloud_question())
 *                 .setTitle("Could not find records")
 *                 .setIconColor(Color.GREY)
 *                 .setTitleColor(Color.GREY)
 * </pre>
 */
public class EmptyState extends BaseDominoElement<HTMLDivElement, EmptyState>
    implements EmptyStateStyles {

  private DivElement element;
  private LazyChild<HeadingElement> title;
  private LazyChild<SmallElement> description;

  private LazyChild<Icon<?>> icon = NullLazyChild.of();

  public EmptyState() {
    element = div().addCss(dui_empty_state);
    title = LazyChild.of(h(4).addCss(dui_empty_state_title), element);
    description = LazyChild.of(small().addCss(dui_empty_state_description), element);
    init(this);
  }

  public EmptyState(String title) {
    this();
    setTitle(title);
  }

  public EmptyState(String title, String description) {
    this(title);
    setDescription(description);
  }

  public EmptyState(String title, Icon<?> icon) {
    this(title);
    setIcon(icon);
  }

  public EmptyState(String title, String description, Icon<?> icon) {
    this(title, description);
    setIcon(icon);
  }

  /** @param icon {@link Icon} to indicate empty data */
  public EmptyState(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  public static EmptyState create() {
    return new EmptyState();
  }

  public static EmptyState create(String title) {
    return new EmptyState(title);
  }

  public static EmptyState create(String title, String description) {
    return new EmptyState(title, description);
  }

  public static EmptyState create(String title, Icon<?> icon) {
    return new EmptyState(title, icon);
  }

  public static EmptyState create(String title, String description, Icon<?> icon) {
    return new EmptyState(title, description, icon);
  }

  /**
   * @param icon {@link Icon} to indicate empty data
   * @return new EmptyState instance
   */
  public static EmptyState create(Icon<?> icon) {
    return new EmptyState(icon);
  }

  /**
   * @param title String to be shown under the icon
   * @return same EmptyState instance
   */
  public EmptyState setTitle(String title) {
    this.title.get().setTextContent(title);
    return this;
  }

  /**
   * @param description String to be shown under the title with smaller font
   * @return same EmptyState instance
   */
  public EmptyState setDescription(String description) {
    this.description.get().setTextContent(description);
    return this;
  }

  public EmptyState setIcon(Icon<?> icon) {
    this.icon.remove();
    this.icon = LazyChild.of(icon.addCss(dui_empty_state_icon), element);
    this.icon.get();
    return this;
  }

  public HeadingElement getTitle() {
    return title.get();
  }

  public SmallElement getDescription() {
    return description.get();
  }

  public Icon<?> getIcon() {
    return icon.get();
  }

  public EmptyState withTitle(ChildHandler<EmptyState, HeadingElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  public EmptyState withDescription(ChildHandler<EmptyState, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

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
