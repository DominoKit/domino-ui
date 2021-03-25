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

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component that indicate that other components or parts of the page has no content currently to
 * display
 *
 * <pre>
 * EmptyState.create(Icons.ALL.cloud_question_mdi())
 *                 .setTitle("Could not find records")
 *                 .setIconColor(Color.GREY)
 *                 .setTitleColor(Color.GREY)
 * </pre>
 */
public class EmptyState extends BaseDominoElement<HTMLDivElement, EmptyState> {

  private HTMLDivElement element =
      div().css("empty-state", Styles.align_center, Styles.vertical_center).element();
  private HTMLDivElement iconContainer = div().element();
  private HTMLHeadingElement titleContainer = h(4).element();
  private HTMLParagraphElement descriptionContainer = p().element();
  private Color iconColor;
  private Color titleColor;
  private Color descriptionColor;

  /** @param icon {@link BaseIcon} to indicate empty data */
  public EmptyState(BaseIcon<?> icon) {
    iconContainer.appendChild(icon.element());
    element.appendChild(iconContainer);
    element.appendChild(titleContainer);
    element.appendChild(descriptionContainer);
    init(this);
  }

  /**
   * @param icon {@link BaseIcon} to indicate empty data
   * @return new EmptyState instance
   */
  public static EmptyState create(BaseIcon<?> icon) {
    return new EmptyState(icon);
  }

  /**
   * @param title String to be shown under the icon
   * @return same EmptyState instance
   */
  public EmptyState setTitle(String title) {
    titleContainer.textContent = title;
    return this;
  }

  /**
   * @param description String to be show under the title with smaller font
   * @return same EmptyState instance
   */
  public EmptyState setDescription(String description) {
    descriptionContainer.textContent = description;
    return this;
  }

  /**
   * @param iconColor {@link Color}
   * @return same EmptyState instance
   */
  public EmptyState setIconColor(Color iconColor) {
    if (nonNull(this.iconColor)) {
      Style.of(iconContainer).remove(this.iconColor.getStyle());
    }
    this.iconColor = iconColor;
    Style.of(iconContainer).add(iconColor.getStyle());
    return this;
  }

  /**
   * @param titleColor {@link Color}
   * @return same EmptyState instance
   */
  public EmptyState setTitleColor(Color titleColor) {
    if (nonNull(this.titleColor)) {
      Style.of(titleContainer).remove(this.titleColor.getStyle());
    }
    this.titleColor = titleColor;
    Style.of(titleContainer).add(titleColor.getStyle());
    return this;
  }

  /**
   * @param descriptionColor {@link Color}
   * @return same EmptyState instance
   */
  public EmptyState setDescriptionColor(Color descriptionColor) {
    if (nonNull(this.descriptionColor)) {
      Style.of(descriptionContainer).remove(this.descriptionColor.getStyle());
    }
    this.descriptionColor = descriptionColor;
    Style.of(descriptionContainer).add(descriptionColor.getStyle());
    return this;
  }

  /**
   * @return the {@link HTMLDivElement} that contains the icon wrapped as a {@link DominoElement}
   */
  public DominoElement<HTMLDivElement> getIconContainer() {
    return DominoElement.of(iconContainer);
  }

  /**
   * @return the {@link HTMLHeadingElement} that contains the title wrapped as a {@link
   *     DominoElement}
   */
  public DominoElement<HTMLHeadingElement> getTitleContainer() {
    return DominoElement.of(titleContainer);
  }

  /**
   * @return the {@link HTMLParagraphElement} that contains the description wrapped as a {@link
   *     DominoElement}
   */
  public DominoElement<HTMLParagraphElement> getDescriptionContainer() {
    return DominoElement.of(descriptionContainer);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }
}
