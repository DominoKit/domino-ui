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
package org.dominokit.domino.ui.grid.flex;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.style.IsCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component which provides an abstract level of the CSS flex layout which will inherit the styles
 * for the CSS flex by default
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/flex">MDN official documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link FlexStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     FlexLayout.create()
 *               .appendChild(FlexItem.create())
 *               .appendChild(FlexItem.create());
 * </pre>
 *
 * @see BaseDominoElement
 */
public class FlexLayout extends BaseDominoElement<HTMLDivElement, FlexLayout> {

  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(FlexStyles.FLEX_LAYOUT);
  private final List<FlexItem<?>> flexItems = new ArrayList<>();
  private FlexDirection flexDirection;
  private FlexWrap flexWrap;
  private FlexJustifyContent flexJustifyContent;
  private FlexAlign flexAlign;

  public FlexLayout() {
    init(this);
  }

  /**
   * Creates a new layout
   *
   * @return new instance
   */
  public static FlexLayout create() {
    return new FlexLayout();
  }

  /**
   * Sets the direction of the flex items inside the layout
   *
   * @param direction the new {@link FlexDirection}
   * @return same instance
   */
  public FlexLayout setDirection(FlexDirection direction) {
    replaceCssClass(flexDirection, direction);
    this.flexDirection = direction;
    return this;
  }

  /**
   * Sets the type of wrap of the elements inside this layout
   *
   * @param wrap the {@link FlexWrap}
   * @return same instance
   */
  public FlexLayout setWrap(FlexWrap wrap) {
    replaceCssClass(flexWrap, wrap);
    flexWrap = wrap;
    return this;
  }

  /**
   * Sets the direction and the wrap in this layout
   *
   * @param direction the {@link FlexDirection}
   * @param wrap the {@link FlexWrap}
   * @return same instance
   */
  public FlexLayout setFlow(FlexDirection direction, FlexWrap wrap) {
    setDirection(direction);
    setWrap(wrap);
    return this;
  }

  /**
   * Sets the type of spaces between the items inside this layout
   *
   * @param justifyContent the {@link FlexJustifyContent}
   * @return same instance
   */
  public FlexLayout setJustifyContent(FlexJustifyContent justifyContent) {
    replaceCssClass(flexJustifyContent, justifyContent);
    flexJustifyContent = justifyContent;
    return this;
  }

  /**
   * Sets the alignment of the items inside this layout
   *
   * @param alignItems the {@link FlexAlign}
   * @return same instance
   */
  public FlexLayout setAlignItems(FlexAlign alignItems) {
    replaceCssClass(flexAlign, alignItems);
    flexAlign = alignItems;
    return this;
  }

  /**
   * Adds new flex item
   *
   * @param flexItem the new {@link FlexItem} to add
   * @return same instance
   */
  public FlexLayout appendChild(FlexItem<?> flexItem) {
    flexItems.add(flexItem);
    appendChild(flexItem.element());
    return this;
  }

  /**
   * Inserts a new flex item at the beginning of this layout
   *
   * @param flexItem the new {@link FlexItem} to add
   * @return same instance
   */
  public FlexLayout insertFirst(FlexItem<?> flexItem) {
    if (!flexItems.isEmpty()) {
      return appendChildBefore(flexItem, flexItems.get(0));
    }
    return appendChild(flexItem);
  }

  /**
   * Adds a new flex item before an {@code existingItem}
   *
   * @param flexItem the new {@link FlexItem} to add
   * @param existingItem the existing {@link FlexItem}
   * @return same instance
   */
  public FlexLayout appendChildBefore(FlexItem<?> flexItem, FlexItem<?> existingItem) {
    if (flexItems.contains(existingItem)) {
      flexItems.add(flexItem);
      insertBefore(flexItem, existingItem);
    }
    return this;
  }

  /**
   * Adds a gap between all flex items of this flex layout
   *
   * @param gap String css value to be used as a gap between the flex items
   * @return same instance
   */
  public FlexLayout setGap(String gap) {
    if (isNull(gap) || gap.isEmpty()) {
      return removeGap();
    }
    setCssProperty("gap", gap);
    return this;
  }

  /**
   * removes the gap between the flex items of this flex layout
   *
   * @return same instance
   */
  public FlexLayout removeGap() {
    removeCssProperty("gap");
    return this;
  }

  private void replaceCssClass(IsCssClass original, IsCssClass replacement) {
    if (nonNull(original)) {
      element.removeCss(original.getStyle());
    }
    element.addCss(replacement.getStyle());
  }

  /** @return All the flex items */
  public List<FlexItem<?>> getFlexItems() {
    return flexItems;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
