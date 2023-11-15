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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A flexible grid layout container that allows arranging content in a grid-like fashion. <br>
 * You can define sections within the grid and set spans for headers, footers, left panels, and
 * right panels.
 *
 * <p>Example Usage:
 *
 * <pre>
 * GridLayout gridLayout = GridLayout.create()
 *     .setGap("10px")
 *     .setHeaderSpan(SectionSpan.of(1, 3))
 *     .setLeftSpan(SectionSpan.of(2, 1, 1), true, true)
 *     .withContent(contentElement -> {
 *         // Add content to the main content area
 *     });
 * RootPanel.get().appendChild(gridLayout);
 * </pre>
 *
 * @see BaseDominoElement
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

  /**
   * Creates a new instance of the GridLayout with default settings. <br>
   * The grid layout is initialized with an empty content area and no sections. You can further
   * configure the layout by adding sections and setting spans.
   */
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
   * Creates a new instance of the GridLayout with default settings. <br>
   * The grid layout is initialized with an empty content area and no sections. You can further
   * configure the layout by adding sections and setting spans.
   *
   * @return A new instance of the GridLayout.
   */
  public static GridLayout create() {
    return new GridLayout();
  }

  /**
   * Sets the gap between grid items.
   *
   * @param gap The gap between grid items, e.g., "10px".
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout setGap(String gap) {
    setCssProperty("grid-gap", gap);
    return this;
  }

  /**
   * Sets the span for the header section within the grid layout. Use {@link SectionSpan} to specify
   * the span.
   *
   * @param sectionSpan The span for the header section.
   * @return This GridLayout instance for method chaining.
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
   * Hides the header section within the grid layout.
   *
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout hideHeader() {
    editor.removeHeader();
    headerElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Sets the span for the right section within the grid layout. Use {@link SectionSpan} to specify
   * the span.
   *
   * @param sectionSpan The span for the right section.
   * @param spanUp Whether to span up.
   * @param spanDown Whether to span down.
   * @return This GridLayout instance for method chaining.
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

  /**
   * Checks if the footer section is attached to the grid layout.
   *
   * @return {@code true} if the footer section is attached, {@code false} otherwise.
   */
  private boolean hasFooter() {
    return footerElement.element().isAttached();
  }

  /**
   * Hides the right section within the grid layout.
   *
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout hideRight() {
    editor.removeRight();
    rightElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Sets the span for the left section within the grid layout. Use {@link SectionSpan} to specify
   * the span.
   *
   * @param sectionSpan The span for the left section.
   * @param spanUp Whether to span up.
   * @param spanDown Whether to span down.
   * @return This GridLayout instance for method chaining.
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
   * Hides the left section within the grid layout.
   *
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout hideLeft() {
    editor.removeLeft();
    leftElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Sets the span for the footer section within the grid layout. Use {@link SectionSpan} to specify
   * the span.
   *
   * @param sectionSpan The span for the footer section.
   * @return This GridLayout instance for method chaining.
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
   * Hides the footer section within the grid layout.
   *
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout hideFooter() {
    editor.removeFooter();
    footerElement.remove();
    updateGridLayout();
    return this;
  }

  /**
   * Checks if the header section is attached to the grid layout.
   *
   * @return {@code true} if the header section is attached, {@code false} otherwise.
   */
  private boolean hasHeader() {
    return headerElement.element().isAttached();
  }

  /**
   * Checks if the left section is attached to the grid layout.
   *
   * @return {@code true} if the left section is attached, {@code false} otherwise.
   */
  private boolean hasLeft() {
    return leftElement.element().isAttached();
  }

  /**
   * Checks if the right section is attached to the grid layout.
   *
   * @return {@code true} if the right section is attached, {@code false} otherwise.
   */
  private boolean hasRight() {
    return rightElement.element().isAttached();
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * Gets the content element within the grid layout.
   *
   * @return The content element.
   */
  public DivElement getContentElement() {
    return contentElement;
  }

  /**
   * Allows customization of the content element within the grid layout.
   *
   * @param handler The child handler for the content element.
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout withContent(ChildHandler<GridLayout, DivElement> handler) {
    handler.apply(this, contentElement);
    return this;
  }

  /**
   * Gets the header element within the grid layout.
   *
   * @return The header element.
   */
  public DivElement getHeaderElement() {
    return headerElement.get();
  }

  /**
   * Allows customization of the header element within the grid layout.
   *
   * @param handler The child handler for the header element.
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout withHeader(ChildHandler<GridLayout, DivElement> handler) {
    DivElement header = headerElement.get();
    setHeaderSpan(editor.headerSectionSpan);
    handler.apply(this, header);
    return this;
  }

  /**
   * Gets the footer element within the grid layout.
   *
   * @return The footer element.
   */
  public DivElement getFooterElement() {
    return footerElement.get();
  }

  /**
   * Allows customization of the footer element within the grid layout.
   *
   * @param handler The child handler for the footer element.
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout withFooter(ChildHandler<GridLayout, DivElement> handler) {
    DivElement footer = footerElement.get();
    setFooterSpan(editor.footerSectionSpan);
    handler.apply(this, footer);
    return this;
  }

  /**
   * Gets the left panel element within the grid layout.
   *
   * @return The left panel element.
   */
  public DivElement getLeftElement() {
    return leftElement.get();
  }

  /**
   * Allows customization of the left panel element within the grid layout.
   *
   * @param handler The child handler for the left panel element.
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout withLeftPanel(ChildHandler<GridLayout, DivElement> handler) {
    DivElement left = leftElement.get();
    setLeftSpan(editor.leftSectionSpan, editor.leftSpanUp, editor.leftSpanDown);
    handler.apply(this, left);
    return this;
  }

  /**
   * Gets the right panel element within the grid layout.
   *
   * @return The right panel element.
   */
  public DivElement getRightElement() {
    return rightElement.get();
  }

  /**
   * Allows customization of the right panel element within the grid layout.
   *
   * @param handler The child handler for the right panel element.
   * @return This GridLayout instance for method chaining.
   */
  public GridLayout withRightPanel(ChildHandler<GridLayout, DivElement> handler) {
    DivElement right = rightElement.get();
    setRightSpan(editor.rightSectionSpan, editor.rightSpanUp, editor.rightSpanDown);
    handler.apply(this, right);
    return this;
  }
}
