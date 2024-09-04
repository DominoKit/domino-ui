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
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component which provides an abstract level of the CSS grid column which will inherit the styles
 * for the CSS grid column by default
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/grid-column">MDN official
 * documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link GridStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Column.span1();
 *     Column.offset1();
 * </pre>
 *
 * @see BaseDominoElement
 * @see Cloneable
 */
public class Column extends BaseDominoElement<HTMLDivElement, Column> implements Cloneable {

  private static final int FULL_SPAN = -1;
  private static final int NO_OFFSET = -1;
  private final DominoElement<HTMLDivElement> column;
  private OnXLarge onXLargeStyle;
  private OnLarge onLargeStyle;
  private OnMedium onMediumStyle;
  private OnSmall onSmallStyle;
  private OnXSmall onXSmallStyle;
  private OnMediumOffset onMediumOffsetStyle;
  private OnXSmallOffset onXSmallOffsetStyle;
  private OnXLargeOffset onXLargeOffsetStyle;
  private OnLargeOffset onLargeOffsetStyle;
  private OnSmallOffset onSmallOffsetStyle;

  private Column() {
    this.column = DominoElement.of(div()).css(GridStyles.GRID_COL);
    init(this);
  }

  /**
   * Creates new column with default size
   *
   * @return new instance
   */
  public static Column span() {
    return new Column();
  }

  /**
   * Creates new column with providing sizes for different screens sizes
   *
   * @param xLarge the size of the column when the screen is X large
   * @param large the size of the column when the screen is large
   * @param medium the size of the column when the screen is medium
   * @param small the size of the column when the screen is small
   * @param xsmall the size of the column when the screen is X small
   * @return new instance
   */
  public static Column span(int xLarge, int large, int medium, int small, int xsmall) {
    return span()
        .onXLarge(OnXLarge.of(xLarge))
        .onLarge(OnLarge.of(large))
        .onMedium(OnMedium.of(medium))
        .onSmall(OnSmall.of(small))
        .onXSmall(OnXSmall.of(xsmall));
  }

  /**
   * Creates new column with providing sizes for different screens sizes
   *
   * @param large the size of the column when the screen is large
   * @param medium the size of the column when the screen is medium
   * @param small the size of the column when the screen is small
   * @param xsmall the size of the column when the screen is X small
   * @return new instance
   */
  public static Column span(int large, int medium, int small, int xsmall) {
    return span(large, large, medium, small, xsmall);
  }

  /**
   * Creates new column with providing sizes for different screens sizes as a range
   *
   * @param mediumAnUp the size of the column when the screen is larger or equal medium size
   * @param smallAndDown the size of the column when the screen is smaller or equal small size
   * @return new instance
   */
  public static Column span(int mediumAnUp, int smallAndDown) {
    return span(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
  }

  /**
   * Creates new column with providing the same size for all different screens sizes
   *
   * @param columnsOnAllScreens the size of the column for all screens
   * @return new instance
   */
  public static Column span(int columnsOnAllScreens) {
    return span()
        .onXLarge(OnXLarge.of(columnsOnAllScreens))
        .onLarge(OnLarge.of(columnsOnAllScreens))
        .onMedium(OnMedium.of(columnsOnAllScreens))
        .onSmall(OnSmall.of(columnsOnAllScreens))
        .onXSmall(OnXSmall.of(columnsOnAllScreens));
  }

  /**
   * Creates new column with size of 1 column for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span1() {
    return span(1, FULL_SPAN);
  }

  /**
   * Creates new column with size of 2 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span2() {
    return span(2, FULL_SPAN);
  }

  /**
   * Creates new column with size of 3 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span3() {
    return span(3, FULL_SPAN);
  }

  /**
   * Creates new column with size of 4 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span4() {
    return span(4, FULL_SPAN);
  }

  /**
   * Creates new column with size of 5 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span5() {
    return span(5, FULL_SPAN);
  }

  /**
   * Creates new column with size of 6 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span6() {
    return span(6, FULL_SPAN);
  }

  /**
   * Creates new column with size of 7 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span7() {
    return span(7, FULL_SPAN);
  }

  /**
   * Creates new column with size of 8 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span8() {
    return span(8, FULL_SPAN);
  }

  /**
   * Creates new column with size of 9 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span9() {
    return span(9, FULL_SPAN);
  }

  /**
   * Creates new column with size of 10 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span10() {
    return span(10, FULL_SPAN);
  }

  /**
   * Creates new column with size of 11 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span11() {
    return span(11, FULL_SPAN);
  }

  /**
   * Creates new column with size of 12 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span12() {
    return span(12, FULL_SPAN);
  }

  /**
   * Creates new column with size of 13 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span13() {
    return span(13, FULL_SPAN);
  }

  /**
   * Creates new column with size of 14 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span14() {
    return span(14, FULL_SPAN);
  }

  /**
   * Creates new column with size of 15 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span15() {
    return span(15, FULL_SPAN);
  }

  /**
   * Creates new column with size of 16 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span16() {
    return span(16, FULL_SPAN);
  }

  /**
   * Creates new column with size of 17 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span17() {
    return span(17, FULL_SPAN);
  }

  /**
   * Creates new column with size of 18 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span18() {
    return span(18, FULL_SPAN);
  }

  /**
   * Creates new column with size of 19 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span19() {
    return span(19, FULL_SPAN);
  }

  /**
   * Creates new column with size of 20 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span20() {
    return span(20, FULL_SPAN);
  }

  /**
   * Creates new column with size of 21 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span21() {
    return span(21, FULL_SPAN);
  }

  /**
   * Creates new column with size of 22 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span22() {
    return span(22, FULL_SPAN);
  }

  /**
   * Creates new column with size of 23 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span23() {
    return span(23, FULL_SPAN);
  }

  /**
   * Creates new column with size of 24 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span24() {
    return span(24, FULL_SPAN);
  }

  /**
   * Creates new column with size of 25 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span25() {
    return span(25, FULL_SPAN);
  }

  /**
   * Creates new column with size of 26 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span26() {
    return span(26, FULL_SPAN);
  }

  /**
   * Creates new column with size of 27 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span27() {
    return span(27, FULL_SPAN);
  }

  /**
   * Creates new column with size of 28 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span28() {
    return span(28, FULL_SPAN);
  }

  /**
   * Creates new column with size of 29 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span29() {
    return span(29, FULL_SPAN);
  }

  /**
   * Creates new column with size of 30 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span30() {
    return span(30, FULL_SPAN);
  }

  /**
   * Creates new column with size of 31 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span31() {
    return span(31, FULL_SPAN);
  }

  /**
   * Creates new column with size of 32 columns for screens that are larger or equal medium and size
   * of full row for screens that are smaller and equal small
   *
   * @return new instance
   */
  public static Column span32() {
    return span(32, FULL_SPAN);
  }

  /**
   * Creates new column with 0 column distance from the start
   *
   * @return new instance
   */
  public Column offset0() {
    return offset(0, FULL_SPAN);
  }

  /**
   * Creates new column with 1 column distance from the start
   *
   * @return new instance
   */
  public Column offset1() {
    return offset(1, FULL_SPAN);
  }

  /**
   * Creates new column with 2 columns distance from the start
   *
   * @return new instance
   */
  public Column offset2() {
    return offset(2, NO_OFFSET);
  }

  /**
   * Creates new column with 3 columns distance from the start
   *
   * @return new instance
   */
  public Column offset3() {
    return offset(3, NO_OFFSET);
  }

  /**
   * Creates new column with 4 columns distance from the start
   *
   * @return new instance
   */
  public Column offset4() {
    return offset(4, NO_OFFSET);
  }

  /**
   * Creates new column with 5 columns distance from the start
   *
   * @return new instance
   */
  public Column offset5() {
    return offset(5, NO_OFFSET);
  }

  /**
   * Creates new column with 6 columns distance from the start
   *
   * @return new instance
   */
  public Column offset6() {
    return offset(6, NO_OFFSET);
  }

  /**
   * Creates new column with 7 columns distance from the start
   *
   * @return new instance
   */
  public Column offset7() {
    return offset(7, NO_OFFSET);
  }

  /**
   * Creates new column with 8 columns distance from the start
   *
   * @return new instance
   */
  public Column offset8() {
    return offset(8, NO_OFFSET);
  }

  /**
   * Creates new column with 9 columns distance from the start
   *
   * @return new instance
   */
  public Column offset9() {
    return offset(9, NO_OFFSET);
  }

  /**
   * Creates new column with 10 columns distance from the start
   *
   * @return new instance
   */
  public Column offset10() {
    return offset(10, NO_OFFSET);
  }

  /**
   * Creates new column with 11 columns distance from the start
   *
   * @return new instance
   */
  public Column offset11() {
    return offset(11, NO_OFFSET);
  }

  /**
   * Creates new column with 12 columns distance from the start
   *
   * @return new instance
   */
  public Column offset12() {
    return offset(12, NO_OFFSET);
  }

  /**
   * Creates new column with 13 columns distance from the start
   *
   * @return new instance
   */
  public Column offset13() {
    return offset(13, NO_OFFSET);
  }

  /**
   * Creates new column with 14 columns distance from the start
   *
   * @return new instance
   */
  public Column offset14() {
    return offset(14, NO_OFFSET);
  }

  /**
   * Creates new column with 15 columns distance from the start
   *
   * @return new instance
   */
  public Column offset15() {
    return offset(15, NO_OFFSET);
  }

  /**
   * Creates new column with 16 columns distance from the start
   *
   * @return new instance
   */
  public Column offset16() {
    return offset(16, NO_OFFSET);
  }

  /**
   * Creates new column with 17 columns distance from the start
   *
   * @return new instance
   */
  public Column offset17() {
    return offset(17, NO_OFFSET);
  }

  /**
   * Creates new column with 18 columns distance from the start
   *
   * @return new instance
   */
  public Column offset18() {
    return offset(18, NO_OFFSET);
  }

  /**
   * Creates new column with 19 columns distance from the start
   *
   * @return new instance
   */
  public Column offset19() {
    return offset(19, NO_OFFSET);
  }

  /**
   * Creates new column with 20 columns distance from the start
   *
   * @return new instance
   */
  public Column offset20() {
    return offset(20, NO_OFFSET);
  }

  /**
   * Creates new column with 21 columns distance from the start
   *
   * @return new instance
   */
  public Column offset21() {
    return offset(21, NO_OFFSET);
  }

  /**
   * Creates new column with 22 columns distance from the start
   *
   * @return new instance
   */
  public Column offset22() {
    return offset(22, NO_OFFSET);
  }

  /**
   * Creates new column with 23 columns distance from the start
   *
   * @return new instance
   */
  public Column offset23() {
    return offset(23, NO_OFFSET);
  }

  /**
   * Creates new column with 24 columns distance from the start
   *
   * @return new instance
   */
  public Column offset24() {
    return offset(24, NO_OFFSET);
  }

  /**
   * Creates new column with 25 columns distance from the start
   *
   * @return new instance
   */
  public Column offset25() {
    return offset(25, NO_OFFSET);
  }

  /**
   * Creates new column with 26 columns distance from the start
   *
   * @return new instance
   */
  public Column offset26() {
    return offset(26, NO_OFFSET);
  }

  /**
   * Creates new column with 27 columns distance from the start
   *
   * @return new instance
   */
  public Column offset27() {
    return offset(27, NO_OFFSET);
  }

  /**
   * Creates new column with 28 columns distance from the start
   *
   * @return new instance
   */
  public Column offset28() {
    return offset(28, NO_OFFSET);
  }

  /**
   * Creates new column with 29 columns distance from the start
   *
   * @return new instance
   */
  public Column offset29() {
    return offset(29, NO_OFFSET);
  }

  /**
   * Creates new column with 30 columns distance from the start
   *
   * @return new instance
   */
  public Column offset30() {
    return offset(30, NO_OFFSET);
  }

  /**
   * Creates new column with 31 columns distance from the start
   *
   * @return new instance
   */
  public Column offset31() {
    return offset(31, NO_OFFSET);
  }

  /**
   * Creates new column with providing offsets on all different screens sizes
   *
   * @param xLarge the offset of the column when the screen is X large
   * @param large the offset of the column when the screen is large
   * @param medium the offset of the column when the screen is medium
   * @param small the offset of the column when the screen is small
   * @param xsmall the offset of the column when the screen is X small
   * @return new instance
   */
  public Column offset(int xLarge, int large, int medium, int small, int xsmall) {
    return onXLargeOffset(OnXLargeOffset.of(xLarge))
        .onLargeOffset(OnLargeOffset.of(large))
        .onMediumOffset(OnMediumOffset.of(medium))
        .onSmallOffset(OnSmallOffset.of(small))
        .onXSmallOffset(OnXSmallOffset.of(xsmall));
  }

  /**
   * Creates new column with providing offsets on all different screens sizes
   *
   * @param large the offset of the column when the screen is large
   * @param medium the offset of the column when the screen is medium
   * @param small the offset of the column when the screen is small
   * @param xsmall the offset of the column when the screen is X small
   * @return new instance
   */
  public Column offset(int large, int medium, int small, int xsmall) {
    return offset(large, large, medium, small, xsmall);
  }

  /**
   * Creates new column with providing offsets for different screens sizes as a range
   *
   * @param mediumAnUp the offset of the column when the screen is larger or equal medium size
   * @param smallAndDown the offset of the column when the screen is smaller or equal small size
   * @return new instance
   */
  public Column offset(int mediumAnUp, int smallAndDown) {
    return offset(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
  }

  /**
   * Creates new column with providing the same offset for all different screens sizes
   *
   * @param columnsOnAllScreens the offset of the column for all screens
   * @return new instance
   */
  public Column offset(int columnsOnAllScreens) {
    return onXLargeOffset(OnXLargeOffset.of(columnsOnAllScreens))
        .onLargeOffset(OnLargeOffset.of(columnsOnAllScreens))
        .onMediumOffset(OnMediumOffset.of(columnsOnAllScreens))
        .onSmallOffset(OnSmallOffset.of(columnsOnAllScreens))
        .onXSmallOffset(OnXSmallOffset.of(columnsOnAllScreens));
  }

  /**
   * Copy this instance
   *
   * @return a new instance same as {@code this}
   */
  public Column copy() {
    Column column = Column.span();
    if (nonNull(this.onXLargeStyle)) column.onXLarge(this.onXLargeStyle);
    if (nonNull(this.onLargeStyle)) column.onLarge(this.onLargeStyle);
    if (nonNull(this.onMediumStyle)) column.onMedium(this.onMediumStyle);
    if (nonNull(this.onSmallStyle)) column.onSmall(this.onSmallStyle);
    if (nonNull(this.onXSmallStyle)) column.onXSmall(this.onXSmallStyle);

    if (nonNull(this.onXLargeOffsetStyle)) column.onXLargeOffset(this.onXLargeOffsetStyle);
    if (nonNull(this.onLargeOffsetStyle)) column.onLargeOffset(this.onLargeOffsetStyle);
    if (nonNull(this.onMediumOffsetStyle)) column.onMediumOffset(this.onMediumOffsetStyle);
    if (nonNull(this.onSmallOffsetStyle)) column.onSmallOffset(this.onSmallOffsetStyle);
    if (nonNull(this.onXSmallOffsetStyle)) column.onXSmallOffset(this.onXSmallOffsetStyle);

    if (style().containsCss(Styles.align_center)) column.centerContent();

    return column;
  }

  /**
   * Sets the size of the column when the screen is X large
   *
   * @param onXLarge the new {@link OnXLarge} size
   * @return same instance
   */
  public Column onXLarge(OnXLarge onXLarge) {
    if (nonNull(this.onXLargeStyle)) {
      removeCss(this.onXLargeStyle.getStyle());
    }
    this.onXLargeStyle = onXLarge;
    addCss(this.onXLargeStyle.getStyle());
    return this;
  }

  /**
   * Sets the size of the column when the screen is large
   *
   * @param onLarge the new {@link OnLarge} size
   * @return same instance
   */
  public Column onLarge(OnLarge onLarge) {
    if (nonNull(this.onLargeStyle)) {
      removeCss(this.onLargeStyle.getStyle());
    }
    this.onLargeStyle = onLarge;
    addCss(this.onLargeStyle.getStyle());
    return this;
  }

  /**
   * Sets the size of the column when the screen is medium
   *
   * @param onMedium the new {@link OnMedium} size
   * @return same instance
   */
  public Column onMedium(OnMedium onMedium) {
    if (nonNull(this.onMediumStyle)) {
      removeCss(this.onMediumStyle.getStyle());
    }
    this.onMediumStyle = onMedium;
    addCss(this.onMediumStyle.getStyle());
    return this;
  }

  /**
   * Sets the size of the column when the screen is small
   *
   * @param onSmall the new {@link OnSmall} size
   * @return same instance
   */
  public Column onSmall(OnSmall onSmall) {
    if (nonNull(this.onSmallStyle)) {
      removeCss(this.onSmallStyle.getStyle());
    }
    this.onSmallStyle = onSmall;
    addCss(this.onSmallStyle.getStyle());
    return this;
  }

  /**
   * Sets the size of the column when the screen is X small
   *
   * @param onXSmall the new {@link OnXSmall} size
   * @return same instance
   */
  public Column onXSmall(OnXSmall onXSmall) {
    if (nonNull(this.onXSmallStyle)) {
      removeCss(this.onXSmallStyle.getStyle());
    }
    this.onXSmallStyle = onXSmall;
    addCss(this.onXSmallStyle.getStyle());
    return this;
  }

  /**
   * Sets the offset of the column when the screen is X large
   *
   * @param onXLarge the new {@link OnXLargeOffset} offset
   * @return same instance
   */
  public Column onXLargeOffset(OnXLargeOffset onXLarge) {
    if (nonNull(this.onXLargeOffsetStyle)) {
      removeCss(this.onXLargeOffsetStyle.getStyle());
    }
    this.onXLargeOffsetStyle = onXLarge;
    addCss(this.onXLargeOffsetStyle.getStyle());
    return this;
  }

  /**
   * Sets the offset of the column when the screen is large
   *
   * @param onLarge the new {@link OnLargeOffset} offset
   * @return same instance
   */
  public Column onLargeOffset(OnLargeOffset onLarge) {
    if (nonNull(this.onLargeOffsetStyle)) {
      removeCss(this.onLargeOffsetStyle.getStyle());
    }
    this.onLargeOffsetStyle = onLarge;
    addCss(this.onLargeOffsetStyle.getStyle());
    return this;
  }

  /**
   * Sets the offset of the column when the screen is medium
   *
   * @param onMedium the new {@link OnMediumOffset} offset
   * @return same instance
   */
  public Column onMediumOffset(OnMediumOffset onMedium) {
    if (nonNull(this.onMediumOffsetStyle)) {
      removeCss(this.onMediumOffsetStyle.getStyle());
    }
    this.onMediumOffsetStyle = onMedium;
    addCss(this.onMediumOffsetStyle.getStyle());
    return this;
  }

  /**
   * Sets the offset of the column when the screen is small
   *
   * @param onSmall the new {@link OnSmallOffset} offset
   * @return same instance
   */
  public Column onSmallOffset(OnSmallOffset onSmall) {
    if (nonNull(this.onSmallOffsetStyle)) {
      removeCss(this.onSmallOffsetStyle.getStyle());
    }
    this.onSmallOffsetStyle = onSmall;
    addCss(this.onSmallOffsetStyle.getStyle());
    return this;
  }

  /**
   * Sets the offset of the column when the screen is X small
   *
   * @param onXSmall the new {@link OnXSmallOffset} offset
   * @return same instance
   */
  public Column onXSmallOffset(OnXSmallOffset onXSmall) {
    if (nonNull(this.onXSmallOffsetStyle)) {
      removeCss(this.onXSmallOffsetStyle.getStyle());
    }
    this.onXSmallOffsetStyle = onXSmall;
    addCss(this.onXSmallOffsetStyle.getStyle());
    return this;
  }

  /**
   * Centers the content of the column
   *
   * @return same instance
   */
  public Column centerContent() {
    addCss(Styles.align_center);
    return this;
  }

  /**
   * De-centers the content of the column, the content will take place based on the default
   * container
   *
   * @return same instance
   */
  public Column deCenterContent() {
    removeCss(Styles.align_center);
    return this;
  }

  /**
   * Removes margins for the column
   *
   * @return same instance
   * @deprecated use {@link #condensed()}
   */
  @Deprecated
  public Column condensed() {
    removeCss(GridStyles.CONDENSE).addCss(GridStyles.CONDENSE);
    return this;
  }

  /**
   * Removes margins for the column
   *
   * @return same instance
   */
  public Column condense() {
    removeCss(GridStyles.CONDENSE).addCss(GridStyles.CONDENSE);
    return this;
  }

  /** @return The {@link OnXLarge} size */
  public OnXLarge getOnXLargeStyle() {
    return onXLargeStyle;
  }

  /** @return The {@link OnLarge} size */
  public OnLarge getOnLargeStyle() {
    return onLargeStyle;
  }

  /** @return The {@link OnMedium} size */
  public OnMedium getOnMediumStyle() {
    return onMediumStyle;
  }

  /** @return The {@link OnSmall} size */
  public OnSmall getOnSmallStyle() {
    return onSmallStyle;
  }

  /** @return The {@link OnXSmall} size */
  public OnXSmall getOnXSmallStyle() {
    return onXSmallStyle;
  }

  /** @return The {@link OnMediumOffset} offset */
  public OnMediumOffset getOnMediumOffsetStyle() {
    return onMediumOffsetStyle;
  }

  /** @return The {@link OnXSmallOffset} offset */
  public OnXSmallOffset getOnXSmallOffsetStyle() {
    return onXSmallOffsetStyle;
  }

  /** @return The {@link OnXLargeOffset} offset */
  public OnXLargeOffset getOnXLargeOffsetStyle() {
    return onXLargeOffsetStyle;
  }

  /** @return The {@link OnLargeOffset} offset */
  public OnLargeOffset getOnLargeOffsetStyle() {
    return onLargeOffsetStyle;
  }

  /** @return The {@link OnSmallOffset} offset */
  public OnSmallOffset getOnSmallOffsetStyle() {
    return onSmallOffsetStyle;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return column.element();
  }

  /** This class represents the size of the column when the screen is X large */
  public static class OnXLarge {
    private final Span span;

    OnXLarge(Span span) {
      this.span = span;
    }

    static OnXLarge span(Span span) {
      return new OnXLarge(span);
    }

    /**
     * Creates the size based on integer value from 1 to 32
     *
     * @param xlarge the integer value representing the size
     * @return new instance
     */
    public static OnXLarge of(int xlarge) {
      return new OnXLarge(Span.of(xlarge));
    }

    /** @return The CSS style of this size */
    public String getStyle() {
      return GridStyles.SPAN_XL + span.postfix;
    }

    /** @return The {@link Span} size */
    public Span getSpan() {
      return span;
    }
  }

  /** This class represents the size of the column when the screen is large */
  public static class OnLarge {
    private final Span span;

    OnLarge(Span span) {
      this.span = span;
    }

    static OnLarge span(Span span) {
      return new OnLarge(span);
    }

    /**
     * Creates the size based on integer value from 1 to 32
     *
     * @param large the integer value representing the size
     * @return new instance
     */
    public static OnLarge of(int large) {
      return new OnLarge(Span.of(large));
    }

    /** @return The CSS style of this size */
    public String getStyle() {
      return GridStyles.SPAN_L + span.postfix;
    }

    /** @return The {@link Span} size */
    public Span getSpan() {
      return span;
    }
  }

  /** This class represents the size of the column when the screen is medium */
  public static class OnMedium {
    private final Span span;

    OnMedium(Span span) {
      this.span = span;
    }

    static OnMedium span(Span span) {
      return new OnMedium(span);
    }

    /**
     * Creates the size based on integer value from 1 to 32
     *
     * @param medium the integer value representing the size
     * @return new instance
     */
    public static OnMedium of(int medium) {
      return new OnMedium(Span.of(medium));
    }

    /** @return The CSS style of this size */
    public String getStyle() {
      return GridStyles.SPAN_M + span.postfix;
    }

    /** @return The {@link Span} size */
    public Span getSpan() {
      return span;
    }
  }

  /** This class represents the size of the column when the screen is small */
  public static class OnSmall {
    private final Span span;

    OnSmall(Span span) {
      this.span = span;
    }

    static OnSmall span(Span span) {
      return new OnSmall(span);
    }

    /**
     * Creates the size based on integer value from 1 to 32
     *
     * @param small the integer value representing the size
     * @return new instance
     */
    public static OnSmall of(int small) {
      return new OnSmall(Span.of(small));
    }

    /** @return The CSS style of this size */
    public String getStyle() {
      return GridStyles.SPAN_S + span.postfix;
    }

    /** @return The {@link Span} size */
    public Span getSpan() {
      return span;
    }
  }

  /** This class represents the size of the column when the screen is X small */
  public static class OnXSmall {

    private final Span span;

    OnXSmall(Span span) {
      this.span = span;
    }

    static OnXSmall span(Span span) {
      return new OnXSmall(span);
    }

    /**
     * Creates the size based on integer value from 1 to 32
     *
     * @param xsmall the integer value representing the size
     * @return new instance
     */
    public static OnXSmall of(int xsmall) {
      return new OnXSmall(Span.of(xsmall));
    }

    /** @return The CSS style of this size */
    public String getStyle() {
      return GridStyles.SPAN_XS + span.postfix;
    }

    /** @return The {@link Span} size */
    public Span getSpan() {
      return span;
    }
  }

  /** This class represents the offset of the column when the screen is X large */
  public static class OnXLargeOffset {
    private final Offset offset;

    OnXLargeOffset(Offset offset) {
      this.offset = offset;
    }

    static OnXLargeOffset offset(Offset offset) {
      return new OnXLargeOffset(offset);
    }

    /**
     * Creates the offset based on integer value from 0 to 31
     *
     * @param xlarge the integer value representing the offset
     * @return new instance
     */
    public static OnXLargeOffset of(int xlarge) {
      return new OnXLargeOffset(Offset.of(xlarge));
    }

    /** @return The CSS style of this offset */
    public String getStyle() {
      return GridStyles.OFFSET_XL + offset.postfix;
    }

    /** @return The {@link Offset} size */
    public Offset getOffset() {
      return offset;
    }
  }

  /** This class represents the offset of the column when the screen is large */
  public static class OnLargeOffset {
    private final Offset offset;

    OnLargeOffset(Offset offset) {
      this.offset = offset;
    }

    static OnLargeOffset offset(Offset offset) {
      return new OnLargeOffset(offset);
    }

    /**
     * Creates the offset based on integer value from 0 to 31
     *
     * @param large the integer value representing the offset
     * @return new instance
     */
    public static OnLargeOffset of(int large) {
      return new OnLargeOffset(Offset.of(large));
    }

    /** @return The CSS style of this offset */
    public String getStyle() {
      return GridStyles.OFFSET_L + offset.postfix;
    }

    /** @return The {@link Offset} size */
    public Offset getOffset() {
      return offset;
    }
  }

  /** This class represents the offset of the column when the screen is medium */
  public static class OnMediumOffset {
    private final Offset offset;

    OnMediumOffset(Offset offset) {
      this.offset = offset;
    }

    static OnMediumOffset offset(Offset offset) {
      return new OnMediumOffset(offset);
    }

    /**
     * Creates the offset based on integer value from 0 to 31
     *
     * @param medium the integer value representing the offset
     * @return new instance
     */
    public static OnMediumOffset of(int medium) {
      return new OnMediumOffset(Offset.of(medium));
    }

    /** @return The CSS style of this offset */
    public String getStyle() {
      return GridStyles.OFFSET_M + offset.postfix;
    }

    /** @return The {@link Offset} size */
    public Offset getOffset() {
      return offset;
    }
  }

  /** This class represents the offset of the column when the screen is small */
  public static class OnSmallOffset {
    private final Offset offset;

    OnSmallOffset(Offset offset) {
      this.offset = offset;
    }

    static OnSmallOffset offset(Offset offset) {
      return new OnSmallOffset(offset);
    }

    /**
     * Creates the offset based on integer value from 0 to 31
     *
     * @param small the integer value representing the offset
     * @return new instance
     */
    public static OnSmallOffset of(int small) {
      return new OnSmallOffset(Offset.of(small));
    }

    /** @return The CSS style of this offset */
    public String getStyle() {
      return GridStyles.OFFSET_S + offset.postfix;
    }

    /** @return The {@link Offset} size */
    public Offset getOffset() {
      return offset;
    }
  }

  /** This class represents the offset of the column when the screen is X small */
  public static class OnXSmallOffset {

    private final Offset offset;

    OnXSmallOffset(Offset offset) {
      this.offset = offset;
    }

    static OnXSmallOffset offset(Offset offset) {
      return new OnXSmallOffset(offset);
    }

    /**
     * Creates the offset based on integer value from 0 to 31
     *
     * @param xsmall the integer value representing the offset
     * @return new instance
     */
    public static OnXSmallOffset of(int xsmall) {
      return new OnXSmallOffset(Offset.of(xsmall));
    }

    /** @return The CSS style of this offset */
    public String getStyle() {
      return GridStyles.OFFSET_XS + offset.postfix;
    }

    /** @return The {@link Offset} size */
    public Offset getOffset() {
      return offset;
    }
  }

  /** An enum representing the size of a column can have */
  public enum Span {
    _1("-1", 1),
    _2("-2", 2),
    _3("-3", 3),
    _4("-4", 4),
    _5("-5", 5),
    _6("-6", 6),
    _7("-7", 7),
    _8("-8", 8),
    _9("-9", 9),
    _10("-10", 10),
    _11("-11", 11),
    _12("-12", 12),
    _13("-13", 13),
    _14("-14", 14),
    _15("-15", 15),
    _16("-16", 16),
    _17("-17", 17),
    _18("-18", 18),
    _19("-19", 19),
    _20("-20", 20),
    _21("-21", 21),
    _22("-22", 22),
    _23("-23", 23),
    _24("-24", 24),
    _25("-25", 25),
    _26("-26", 26),
    _27("-27", 27),
    _28("-28", 28),
    _29("-29", 29),
    _30("-30", 30),
    _31("-31", 31),
    _32("-32", 32),
    _full("-full", 0);

    private String postfix;
    private int value;

    Span(String postfix, int value) {
      this.postfix = postfix;
      this.value = value;
    }

    /** @return The size as integer value */
    public int getValue() {
      return value;
    }

    static Span of(int columns) {
      switch (columns) {
        case 1:
          return _1;
        case 2:
          return _2;
        case 3:
          return _3;
        case 4:
          return _4;
        case 5:
          return _5;
        case 6:
          return _6;
        case 7:
          return _7;
        case 8:
          return _8;
        case 9:
          return _9;
        case 10:
          return _10;
        case 11:
          return _11;
        case 12:
          return _12;
        case 13:
          return _13;
        case 14:
          return _14;
        case 15:
          return _15;
        case 16:
          return _16;
        case 17:
          return _17;
        case 18:
          return _18;
        case 19:
          return _19;
        case 20:
          return _20;
        case 21:
          return _21;
        case 22:
          return _22;
        case 23:
          return _23;
        case 24:
          return _24;
        case 25:
          return _25;
        case 26:
          return _26;
        case 27:
          return _27;
        case 28:
          return _28;
        case 29:
          return _29;
        case 30:
          return _30;
        case 31:
          return _31;
        case 32:
          return _32;
        default:
          return _full;
      }
    }
  }

  /** An enum representing the offset that a column can have */
  public enum Offset {
    _0("-0", 0),
    _1("-1", 1),
    _2("-2", 2),
    _3("-3", 3),
    _4("-4", 4),
    _5("-5", 5),
    _6("-6", 6),
    _7("-7", 7),
    _8("-8", 8),
    _9("-9", 9),
    _10("-10", 10),
    _11("-11", 11),
    _12("-12", 12),
    _13("-13", 13),
    _14("-14", 14),
    _15("-15", 15),
    _16("-16", 16),
    _17("-17", 17),
    _18("-18", 18),
    _19("-19", 19),
    _20("-20", 20),
    _21("-21", 21),
    _22("-22", 22),
    _23("-23", 23),
    _24("-24", 24),
    _25("-25", 25),
    _26("-26", 26),
    _27("-27", 27),
    _28("-28", 28),
    _29("-29", 29),
    _30("-30", 30),
    _31("-31", 31),
    _none("-none", -1);

    private String postfix;
    private int value;

    Offset(String postfix, int value) {
      this.postfix = postfix;
      this.value = value;
    }

    /** @return The offset integer value */
    public int getValue() {
      return value;
    }

    static Offset of(int offset) {
      switch (offset) {
        case 0:
          return _0;
        case 1:
          return _1;
        case 2:
          return _2;
        case 3:
          return _3;
        case 4:
          return _4;
        case 5:
          return _5;
        case 6:
          return _6;
        case 7:
          return _7;
        case 8:
          return _8;
        case 9:
          return _9;
        case 10:
          return _10;
        case 11:
          return _11;
        case 12:
          return _12;
        case 13:
          return _13;
        case 14:
          return _14;
        case 15:
          return _15;
        case 16:
          return _16;
        case 17:
          return _17;
        case 18:
          return _18;
        case 19:
          return _19;
        case 20:
          return _20;
        case 21:
          return _21;
        case 22:
          return _22;
        case 23:
          return _23;
        case 24:
          return _24;
        case 25:
          return _25;
        case 26:
          return _26;
        case 27:
          return _27;
        case 28:
          return _28;
        case 29:
          return _29;
        case 30:
          return _30;
        case 31:
          return _31;
        default:
          return _none;
      }
    }
  }
}
