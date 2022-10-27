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
package org.dominokit.domino.ui.grid;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A layout which is a 12 columns grid based with a required content section and 4 other optional
 * sections Header, Footer, Left and Right.
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Grids">MDN official
 * documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link GridStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     GridLayout gridLayout = GridLayout.create()
 *                 .style()
 *                 .setHeight("500px").get();
 *
 *     // changing a section size
 *     gridLayout.setHeaderSpan(SectionSpan._2);
 *     gridLayout.setLeftSpan(SectionSpan._3);
 *     gridLayout.setRightSpan(SectionSpan._4);
 *     gridLayout.setFooterSpan(SectionSpan._2);
 *
 *     // hiding sections
 *     gridLayout.hideHeader();
 *     gridLayout.hideLeft();
 *     gridLayout.hideRight();
 *     gridLayout.hideFooter();
 *
 *     // Adding elements
 *     gridLayout.getContentElement().appendChild(otherElement);
 *     gridLayout.getHeaderElement().appendChild(otherElement);
 *     gridLayout.getLeftElement().appendChild(otherElement);
 *     gridLayout.getRightElement().appendChild(otherElement);
 *     gridLayout.getFooterElement().appendChild(otherElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class GridLayout extends BaseDominoElement<HTMLDivElement, GridLayout> implements GridStyles{

  private final DominoElement<HTMLDivElement> element;
  private final DominoElement<HTMLDivElement> contentElement;
  private final LazyChild<DominoElement<HTMLDivElement>> headerElement;
  private final LazyChild<DominoElement<HTMLDivElement>> footerElement;
  private final LazyChild<DominoElement<HTMLDivElement>> leftElement;
  private final LazyChild<DominoElement<HTMLDivElement>> rightElement;
  private final GridLayoutEditor editor = new GridLayoutEditor();

  public GridLayout() {
    element =  DominoElement.div().addCss(dui_layout_grid)
            .appendChild(contentElement = DominoElement.div().addCss(dui_grid_content));
    headerElement = LazyChild.of(DominoElement.div().addCss(dui_grid_header), element);
    footerElement = LazyChild.of(DominoElement.div().addCss(dui_grid_footer), element);
    leftElement = LazyChild.of(DominoElement.div().addCss(dui_grid_left), element);
    rightElement = LazyChild.of(DominoElement.div().addCss(dui_grid_right), element);
    init(this);
    updateGridLayout();
  }

  private void updateGridLayout() {
    setCssProperty("grid-template-areas", editor.gridAreasAsString());
  }

  /**
   * Creates a new layout
   *
   * @return new instance
   */
  public static GridLayout create() {
    return new GridLayout();
  }

  /**
   * Sets the spaces between the sections
   *
   * <p>For example:
   *
   * <pre>
   *     GridLayout.create()
   *               .setGap("1px 2px")
   * </pre>
   *
   * @param gap the string value of the space in <a
   *     href="https://developer.mozilla.org/en-US/docs/Web/CSS/gap">CSS gap format</a>
   * @return same instance
   */
  public GridLayout setGap(String gap) {
    setCssProperty("grid-gap", gap);
    return this;
  }

  /**
   * Change the size of the header section, changing the header can be to cover up to 6 rows
   *
   * @param sectionSpan the number of rows to cover
   * @return same instance
   */
  public GridLayout setHeaderSpan(SectionSpan sectionSpan) {
    editor.addHeader(sectionSpan);
    headerElement.get();
    updateGridLayout();
    return this;
  }

  /**
   * Hides the header section
   *
   * @return same instance
   */
  public GridLayout hideHeader() {
    editor.removeHeader();
    headerElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Change the size of the right section, changing the right section can be to cover up to 6
   * columns
   *
   * @param sectionSpan the number of columns to cover
   * @param spanUp true to make the right section sized to the top of the layout even if the header
   *     exists, false to position it based on the header
   * @param spanDown true to make the right section sized to the bottom of the layout even if the
   *     footer exists, false to position it based on the footer
   * @return same instance
   */
  public GridLayout setRightSpan(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
    editor.addRight(sectionSpan, spanUp, spanDown);
    rightElement.get();
    updateGridLayout();
    return this;
  }

  private boolean hasFooter() {
    return footerElement.element().isAttached();
  }

  /**
   * Hides the right section
   *
   * @return same instance
   */
  public GridLayout hideRight() {
    editor.removeRight();
    rightElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Change the size of the left section, changing the left section can be to cover up to 6 columns
   *
   * @param sectionSpan the number of columns to cover
   * @param spanUp true to make the left section sized to the top of the layout even if the header
   *     exists, false to position it based on the header
   * @param spanDown true to make the left section sized to the bottom of the layout even if the
   *     footer exists, false to position it based on the footer
   * @return same instance
   */
  public GridLayout setLeftSpan(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
    editor.addLeft(sectionSpan, spanUp, spanDown);
    leftElement.get();
    updateGridLayout();
    return this;
  }

  /**
   * Hides the left section
   *
   * @return same instance
   */
  public GridLayout hideLeft() {
    editor.removeLeft();
    leftElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Change the size of the footer section, changing the footer section can be to cover up to 6 rows
   *
   * @param sectionSpan the number of rows to cover
   * @return same instance
   */
  public GridLayout setFooterSpan(SectionSpan sectionSpan) {
    editor.addFooter(sectionSpan);
    footerElement.get();
    updateGridLayout();

    return this;
  }

  /**
   * Hides the footer section
   *
   * @return same instance
   */
  public GridLayout hideFooter() {
    editor.removeFooter();
    footerElement.remove();
    updateGridLayout();
    return this;
  }

  private boolean hasHeader() {
    return headerElement.element().isAttached();
  }

  private boolean hasLeft() {
    return leftElement.element().isAttached();
  }

  private boolean hasRight() {
    return rightElement.element().isAttached();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return The content section */
  public DominoElement<HTMLDivElement> getContentElement() {
    return contentElement;
  }

  /** @return The header section */
  public DominoElement<HTMLDivElement> getHeaderElement() {
    return headerElement.get();
  }

  /** @return The footer section */
  public DominoElement<HTMLDivElement> getFooterElement() {
    return footerElement.get();
  }

  /** @return The left section */
  public DominoElement<HTMLDivElement> getLeftElement() {
    return leftElement.get();
  }

  /** @return The right section */
  public DominoElement<HTMLDivElement> getRightElement() {
    return rightElement.get();
  }

}
