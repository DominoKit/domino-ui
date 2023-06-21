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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A layout which is a 12 columns grid based with a required content section and 4 other optional
 * sections Header, Footer, Left and Right.
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Grids">MDN official
 * documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.grid.GridStyles}
 *
 * @see BaseDominoElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class GridLayout extends BaseDominoElement<HTMLDivElement, GridLayout>
    implements GridStyles {

  private final DivElement element;
  private final DivElement contentElement;
  private final LazyChild<DivElement> headerElement;
  private final LazyChild<DivElement> footerElement;
  private final LazyChild<DivElement> leftElement;
  private final LazyChild<DivElement> rightElement;
  private final GridLayoutEditor editor = new GridLayoutEditor();

  /** Constructor for GridLayout. */
  public GridLayout() {
    element =
        div().addCss(dui_layout_grid).appendChild(contentElement = div().addCss(dui_grid_content));
    headerElement = LazyChild.of(div().addCss(dui_grid_header), element);
    footerElement = LazyChild.of(div().addCss(dui_grid_footer), element);
    leftElement = LazyChild.of(div().addCss(dui_grid_left), element);
    rightElement = LazyChild.of(div().addCss(dui_grid_right), element);
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
    sectionSpan.ifSpanOrElse(
        () -> {
          editor.addHeader(sectionSpan);
          headerElement.get();
          updateGridLayout();
        },
        this::hideHeader);

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
    sectionSpan.ifSpanOrElse(
        () -> {
          editor.addRight(sectionSpan, spanUp, spanDown);
          rightElement.get();
          updateGridLayout();
        },
        this::hideRight);
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
    sectionSpan.ifSpanOrElse(
        () -> {
          editor.addLeft(sectionSpan, spanUp, spanDown);
          leftElement.get();
          updateGridLayout();
        },
        this::hideLeft);
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
    sectionSpan.ifSpanOrElse(
        () -> {
          editor.addFooter(sectionSpan);
          footerElement.get();
          updateGridLayout();
        },
        this::hideFooter);

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
  /**
   * Getter for the field <code>contentElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentElement() {
    return contentElement;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.grid.GridLayout} object
   */
  public GridLayout withContent(ChildHandler<GridLayout, DivElement> handler) {
    handler.apply(this, contentElement);
    return this;
  }

  /** @return The header section */
  /**
   * Getter for the field <code>headerElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getHeaderElement() {
    return headerElement.get();
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.grid.GridLayout} object
   */
  public GridLayout withHeader(ChildHandler<GridLayout, DivElement> handler) {
    DivElement header = headerElement.get();
    setHeaderSpan(editor.headerSectionSpan);
    handler.apply(this, header);
    return this;
  }

  /** @return The footer section */
  /**
   * Getter for the field <code>footerElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getFooterElement() {
    return footerElement.get();
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.grid.GridLayout} object
   */
  public GridLayout withFooter(ChildHandler<GridLayout, DivElement> handler) {
    DivElement footer = footerElement.get();
    setFooterSpan(editor.footerSectionSpan);
    handler.apply(this, footer);
    return this;
  }

  /** @return The left section */
  /**
   * Getter for the field <code>leftElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getLeftElement() {
    return leftElement.get();
  }

  /**
   * withLeftPanel.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.grid.GridLayout} object
   */
  public GridLayout withLeftPanel(ChildHandler<GridLayout, DivElement> handler) {
    DivElement left = leftElement.get();
    setLeftSpan(editor.leftSectionSpan, editor.leftSpanUp, editor.leftSpanDown);
    handler.apply(this, left);
    return this;
  }

  /** @return The right section */
  /**
   * Getter for the field <code>rightElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getRightElement() {
    return rightElement.get();
  }

  /**
   * withRightPanel.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.grid.GridLayout} object
   */
  public GridLayout withRightPanel(ChildHandler<GridLayout, DivElement> handler) {
    DivElement right = rightElement.get();
    setRightSpan(editor.rightSectionSpan, editor.rightSpanUp, editor.rightSpanDown);
    handler.apply(this, right);
    return this;
  }
}
