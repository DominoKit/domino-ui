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

import static org.dominokit.domino.ui.grid.Column.Offset.*;
import static org.dominokit.domino.ui.grid.Column.Span.*;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.PostfixCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a column in a grid layout.
 *
 * <p>This class provides methods for configuring the size and offset of the column within the grid.
 * You can set the column size for different screen sizes using the {@code onXLarge}, {@code
 * onLarge}, {@code onMedium}, {@code onSmall}, and {@code onXSmall} methods. You can also set the
 * offset for different screen sizes using the {@code onXLargeOffset}, {@code onLargeOffset}, {@code
 * onMediumOffset}, {@code onSmallOffset}, and {@code onXSmallOffset} methods.
 *
 * <p>Usage example:
 *
 * <pre>
 * Column column = Column.colspan(Span._6, Span._12);
 * column.onLarge(Span._4)
 *       .onMedium(Span._3)
 *       .onSmall(Span._2)
 *       .onXSmall(Span._1);
 * column.onLargeOffset(Offset._3)
 *       .onMediumOffset(Offset._2)
 *       .onSmallOffset(Offset._1)
 *       .onXSmallOffset(Offset._0_);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Column extends BaseDominoElement<HTMLElement, Column>
    implements Cloneable, GridStyles {

  private final DivElement column;
  private PostfixCssClass onXLargeStyle = PostfixCssClass.of("dui-span-xl");
  private PostfixCssClass onLargeStyle = PostfixCssClass.of("dui-span-l");
  private PostfixCssClass onMediumStyle = PostfixCssClass.of("dui-span-m");
  private PostfixCssClass onSmallStyle = PostfixCssClass.of("dui-span-s");
  private PostfixCssClass onXSmallStyle = PostfixCssClass.of("dui-span-xs");
  private PostfixCssClass onXLargeOffsetStyle = PostfixCssClass.of("dui-offset-xl");
  private PostfixCssClass onLargeOffsetStyle = PostfixCssClass.of("dui-offset-l");
  private PostfixCssClass onMediumOffsetStyle = PostfixCssClass.of("dui-offset-m");
  private PostfixCssClass onSmallOffsetStyle = PostfixCssClass.of("dui-offset-s");
  private PostfixCssClass onXSmallOffsetStyle = PostfixCssClass.of("dui-offset-xs");

  private Column() {
    this.column = div().addCss(dui_grid_col);
    init(this);
  }

  /**
   * Creates a new column with default settings.
   *
   * @return a new Column instance.
   */
  public static Column colspan() {
    return new Column();
  }

  /**
   * Creates a new column with custom sizes for extra-large, large, medium, small, and extra-small
   * screens.
   *
   * @param xLarge The size of the column for extra-large screens (>=1200px).
   * @param large The size of the column for large screens (>=992px).
   * @param medium The size of the column for medium screens (>=768px).
   * @param small The size of the column for small screens (>=576px).
   * @param xsmall The size of the column for extra-small screens (<576px).
   * @return This Column instance with the specified sizes.
   */
  public static Column colspan(Span xLarge, Span large, Span medium, Span small, Span xsmall) {
    return colspan()
        .onXLarge(xLarge)
        .onLarge(large)
        .onMedium(medium)
        .onSmall(small)
        .onXSmall(xsmall);
  }

  /**
   * Creates a new column with custom sizes for large, medium, small, and extra-small screens.
   *
   * @param large The size of the column for large screens (>=992px).
   * @param medium The size of the column for medium screens (>=768px).
   * @param small The size of the column for small screens (>=576px).
   * @param xsmall The size of the column for extra-small screens (<576px).
   * @return This Column instance with the specified sizes.
   */
  public static Column colspan(Span large, Span medium, Span small, Span xsmall) {
    return colspan(large, large, medium, small, xsmall);
  }

  /**
   * Creates a new column with custom sizes for medium and small screens, using the same size for
   * both.
   *
   * @param mediumAnUp The size of the column for medium screens and up (>=768px).
   * @param smallAndDown The size of the column for small screens and down (<=576px).
   * @return This Column instance with the specified sizes.
   */
  public static Column colspan(Span mediumAnUp, Span smallAndDown) {
    return colspan(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
  }

  /**
   * Creates a new column with the same custom size for all screen sizes.
   *
   * @param span The size of the column for all screen sizes.
   * @return This Column instance with the specified size for all screen sizes.
   */
  public static Column colspan(Span span) {
    return colspan().onXLarge(span).onLarge(span).onMedium(span).onSmall(span).onXSmall(span);
  }

  /**
   * Creates a new column with a size of 1 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 1 and full width.
   */
  public static Column span1() {
    return colspan(_1, _full);
  }

  /**
   * Creates a new column with a size of 1 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 1, full width, and the appended content.
   */
  public static Column span1(IsElement<?> content) {
    return span1().appendChild(content);
  }

  /**
   * Creates a new column with a size of 2 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 2 and full width.
   */
  public static Column span2() {
    return colspan(_2, _full);
  }

  /**
   * Creates a new column with a size of 2 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 2, full width, and the appended content.
   */
  public static Column span2(IsElement<?> content) {
    return span2().appendChild(content);
  }

  /**
   * Creates a new column with a size of 3 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 3 and full width.
   */
  public static Column span3() {
    return colspan(Span._3, _full);
  }

  /**
   * Creates a new column with a size of 3 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 3, full width, and the appended content.
   */
  public static Column span3(IsElement<?> content) {
    return span3().appendChild(content);
  }

  /**
   * Creates a new column with a size of 4 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 4 and full width.
   */
  public static Column span4() {
    return colspan(_4, _full);
  }

  /**
   * Creates a new column with a size of 4 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 4, full width, and the appended content.
   */
  public static Column span4(IsElement<?> content) {
    return span4().appendChild(content);
  }

  /**
   * Creates a new column with a size of 5 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 5 and full width.
   */
  public static Column span5() {
    return colspan(_5, _full);
  }

  /**
   * Creates a new column with a size of 5 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 5, full width, and the appended content.
   */
  public static Column span5(IsElement<?> content) {
    return span5().appendChild(content);
  }

  /**
   * Creates a new column with a size of 6 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 6 and full width.
   */
  public static Column span6() {
    return colspan(_6, _full);
  }

  /**
   * Creates a new column with a size of 6 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 6, full width, and the appended content.
   */
  public static Column span6(IsElement<?> content) {
    return span6().appendChild(content);
  }

  /**
   * Creates a new column with a size of 7 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 7 and full width.
   */
  public static Column span7() {
    return colspan(_7, _full);
  }

  /**
   * Creates a new column with a size of 7 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 7, full width, and the appended content.
   */
  public static Column span7(IsElement<?> content) {
    return span7().appendChild(content);
  }

  /**
   * Creates a new column with a size of 8 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 8 and full width.
   */
  public static Column span8() {
    return colspan(_8, _full);
  }

  /**
   * Creates a new column with a size of 8 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 8, full width, and the appended content.
   */
  public static Column span8(IsElement<?> content) {
    return span8().appendChild(content);
  }

  /**
   * Creates a new column with a size of 9 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 9 and full width.
   */
  public static Column span9() {
    return colspan(_9, _full);
  }

  /**
   * Creates a new column with a size of 9 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 9, full width, and the appended content.
   */
  public static Column span9(IsElement<?> content) {
    return span9().appendChild(content);
  }

  /**
   * Creates a new column with a size of 10 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 10 and full width.
   */
  public static Column span10() {
    return colspan(_10, _full);
  }

  /**
   * Creates a new column with a size of 10 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 10, full width, and the appended content.
   */
  public static Column span10(IsElement<?> content) {
    return span10().appendChild(content);
  }
  /**
   * Creates a new column with a size of 11 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 11 and full width.
   */
  public static Column span11() {
    return colspan(_11, _full);
  }

  /**
   * Creates a new column with a size of 11 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 11, full width, and the appended content.
   */
  public static Column span11(IsElement<?> content) {
    return span11().appendChild(content);
  }

  /**
   * Creates a new column with a size of 12 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 12 and full width.
   */
  public static Column span12() {
    return colspan(_12, _full);
  }

  /**
   * Creates a new column with a size of 12 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 12, full width, and the appended content.
   */
  public static Column span12(IsElement<?> content) {
    return span12().appendChild(content);
  }

  /**
   * Creates a new column with a size of 13 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 13 and full width.
   */
  public static Column span13() {
    return colspan(_13, _full);
  }

  /**
   * Creates a new column with a size of 13 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 13, full width, and the appended content.
   */
  public static Column span13(IsElement<?> content) {
    return span13().appendChild(content);
  }

  /**
   * Creates a new column with a size of 14 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 14 and full width.
   */
  public static Column span14() {
    return colspan(_14, _full);
  }

  /**
   * Creates a new column with a size of 14 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 14, full width, and the appended content.
   */
  public static Column span14(IsElement<?> content) {
    return span14().appendChild(content);
  }

  /**
   * Creates a new column with a size of 15 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 15 and full width.
   */
  public static Column span15() {
    return colspan(_15, _full);
  }

  /**
   * Creates a new column with a size of 15 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 15, full width, and the appended content.
   */
  public static Column span15(IsElement<?> content) {
    return span15().appendChild(content);
  }

  /**
   * Creates a new column with a size of 16 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 16 and full width.
   */
  public static Column span16() {
    return colspan(_16, _full);
  }

  /**
   * Creates a new column with a size of 16 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 16, full width, and the appended content.
   */
  public static Column span16(IsElement<?> content) {
    return span16().appendChild(content);
  }

  /**
   * Creates a new column with a size of 17 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 17 and full width.
   */
  public static Column span17() {
    return colspan(_17, _full);
  }

  /**
   * Creates a new column with a size of 17 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 17, full width, and the appended content.
   */
  public static Column span17(IsElement<?> content) {
    return span17().appendChild(content);
  }

  /**
   * Creates a new column with a size of 18 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 18 and full width.
   */
  public static Column span18() {
    return colspan(_18, _full);
  }

  /**
   * Creates a new column with a size of 18 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 18, full width, and the appended content.
   */
  public static Column span18(IsElement<?> content) {
    return span18().appendChild(content);
  }

  /**
   * Creates a new column with a size of 19 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 19 and full width.
   */
  public static Column span19() {
    return colspan(_19, _full);
  }

  /**
   * Creates a new column with a size of 19 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 19, full width, and the appended content.
   */
  public static Column span19(IsElement<?> content) {
    return span19().appendChild(content);
  }

  /**
   * Creates a new column with a size of 20 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 20 and full width.
   */
  public static Column span20() {
    return colspan(_20, _full);
  }

  /**
   * Creates a new column with a size of 20 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 20, full width, and the appended content.
   */
  public static Column span20(IsElement<?> content) {
    return span20().appendChild(content);
  }

  /**
   * Creates a new column with a size of 21 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 21 and full width.
   */
  public static Column span21() {
    return colspan(_21, _full);
  }

  /**
   * Creates a new column with a size of 21 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 21, full width, and the appended content.
   */
  public static Column span21(IsElement<?> content) {
    return span21().appendChild(content);
  }

  /**
   * Creates a new column with a size of 22 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 22 and full width.
   */
  public static Column span22() {
    return colspan(_22, _full);
  }

  /**
   * Creates a new column with a size of 22 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 22, full width, and the appended content.
   */
  public static Column span22(IsElement<?> content) {
    return span22().appendChild(content);
  }

  /**
   * Creates a new column with a size of 23 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 23 and full width.
   */
  public static Column span23() {
    return colspan(_23, _full);
  }

  /**
   * Creates a new column with a size of 23 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 23, full width, and the appended content.
   */
  public static Column span23(IsElement<?> content) {
    return span23().appendChild(content);
  }

  /**
   * Creates a new column with a size of 24 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 24 and full width.
   */
  public static Column span24() {
    return colspan(_24, _full);
  }

  /**
   * Creates a new column with a size of 24 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 24, full width, and the appended content.
   */
  public static Column span24(IsElement<?> content) {
    return span24().appendChild(content);
  }

  /**
   * Creates a new column with a size of 25 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 25 and full width.
   */
  public static Column span25() {
    return colspan(_25, _full);
  }

  /**
   * Creates a new column with a size of 25 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 25, full width, and the appended content.
   */
  public static Column span25(IsElement<?> content) {
    return span25().appendChild(content);
  }

  /**
   * Creates a new column with a size of 26 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 26 and full width.
   */
  public static Column span26() {
    return colspan(_26, _full);
  }

  /**
   * Creates a new column with a size of 26 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 26, full width, and the appended content.
   */
  public static Column span26(IsElement<?> content) {
    return span26().appendChild(content);
  }

  /**
   * Creates a new column with a size of 27 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 27 and full width.
   */
  public static Column span27() {
    return colspan(_27, _full);
  }

  /**
   * Creates a new column with a size of 27 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 27, full width, and the appended content.
   */
  public static Column span27(IsElement<?> content) {
    return span27().appendChild(content);
  }

  /**
   * Creates a new column with a size of 28 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 28 and full width.
   */
  public static Column span28() {
    return colspan(_28, _full);
  }

  /**
   * Creates a new column with a size of 28 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 28, full width, and the appended content.
   */
  public static Column span28(IsElement<?> content) {
    return span28().appendChild(content);
  }

  /**
   * Creates a new column with a size of 29 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 29 and full width.
   */
  public static Column span29() {
    return colspan(_29, _full);
  }

  /**
   * Creates a new column with a size of 29 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 29, full width, and the appended content.
   */
  public static Column span29(IsElement<?> content) {
    return span29().appendChild(content);
  }

  /**
   * Creates a new column with a size of 30 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 30 and full width.
   */
  public static Column span30() {
    return colspan(_30, _full);
  }

  /**
   * Creates a new column with a size of 30 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 30, full width, and the appended content.
   */
  public static Column span30(IsElement<?> content) {
    return span30().appendChild(content);
  }

  /**
   * Creates a new column with a size of 31 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 31 and full width.
   */
  public static Column span31() {
    return colspan(_31, _full);
  }

  /**
   * Creates a new column with a size of 31 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 31, full width, and the appended content.
   */
  public static Column span31(IsElement<?> content) {
    return span31().appendChild(content);
  }

  /**
   * Creates a new column with a size of 32 for extra-large screens (>=1200px) and full width.
   *
   * @return This Column instance with a size of 32 and full width.
   */
  public static Column span32() {
    return colspan(_32, _full);
  }

  /**
   * Creates a new column with a size of 32 for extra-large screens (>=1200px), full width, and
   * appends the specified content.
   *
   * @param content The content to append to the column.
   * @return This Column instance with a size of 32, full width, and the appended content.
   */
  public static Column span32(IsElement<?> content) {
    return span32().appendChild(content);
  }

  /**
   * Creates a new column with an offset of 0.
   *
   * @return This Column instance with an offset of 0.
   */
  public Column offset0() {
    return offset(_0_, _none);
  }

  /**
   * Creates a new column with an offset of 1.
   *
   * @return This Column instance with an offset of 1.
   */
  public Column offset1() {
    return offset(_1_, _none);
  }

  /**
   * Creates a new column with an offset of 2.
   *
   * @return This Column instance with an offset of 2.
   */
  public Column offset2() {
    return offset(_2_, _none);
  }

  /**
   * Creates a new column with an offset of 3.
   *
   * @return This Column instance with an offset of 3.
   */
  public Column offset3() {
    return offset(_3_, _none);
  }

  /**
   * Creates a new column with an offset of 4.
   *
   * @return This Column instance with an offset of 4.
   */
  public Column offset4() {
    return offset(_4_, _none);
  }

  /**
   * Creates a new column with an offset of 5.
   *
   * @return This Column instance with an offset of 5.
   */
  public Column offset5() {
    return offset(_5_, _none);
  }

  /**
   * Creates a new column with an offset of 6.
   *
   * @return This Column instance with an offset of 6.
   */
  public Column offset6() {
    return offset(_6_, _none);
  }

  /**
   * Creates a new column with an offset of 7.
   *
   * @return This Column instance with an offset of 7.
   */
  public Column offset7() {
    return offset(_7_, _none);
  }

  /**
   * Creates a new column with an offset of 8.
   *
   * @return This Column instance with an offset of 8.
   */
  public Column offset8() {
    return offset(_8_, _none);
  }

  /**
   * Creates a new column with an offset of 9.
   *
   * @return This Column instance with an offset of 9.
   */
  public Column offset9() {
    return offset(_9_, _none);
  }

  /**
   * Creates a new column with an offset of 10.
   *
   * @return This Column instance with an offset of 10.
   */
  public Column offset10() {
    return offset(_10_, _none);
  }

  /**
   * Creates a new column with an offset of 11.
   *
   * @return This Column instance with an offset of 11.
   */
  public Column offset11() {
    return offset(_11_, _none);
  }

  /**
   * Creates a new column with an offset of 12.
   *
   * @return This Column instance with an offset of 12.
   */
  public Column offset12() {
    return offset(_12_, _none);
  }

  /**
   * Creates a new column with an offset of 13.
   *
   * @return This Column instance with an offset of 13.
   */
  public Column offset13() {
    return offset(_13_, _none);
  }

  /**
   * Creates a new column with an offset of 14.
   *
   * @return This Column instance with an offset of 14.
   */
  public Column offset14() {
    return offset(_14_, _none);
  }

  /**
   * Creates a new column with an offset of 15.
   *
   * @return This Column instance with an offset of 15.
   */
  public Column offset15() {
    return offset(_15_, _none);
  }

  /**
   * Creates a new column with an offset of 16.
   *
   * @return This Column instance with an offset of 16.
   */
  public Column offset16() {
    return offset(_16_, _none);
  }

  /**
   * Creates a new column with an offset of 17.
   *
   * @return This Column instance with an offset of 17.
   */
  public Column offset17() {
    return offset(_17_, _none);
  }

  /**
   * Creates a new column with an offset of 18.
   *
   * @return This Column instance with an offset of 18.
   */
  public Column offset18() {
    return offset(_18_, _none);
  }

  /**
   * Creates a new column with an offset of 19.
   *
   * @return This Column instance with an offset of 19.
   */
  public Column offset19() {
    return offset(_19_, _none);
  }

  /**
   * Creates a new column with an offset of 20.
   *
   * @return This Column instance with an offset of 20.
   */
  public Column offset20() {
    return offset(_20_, _none);
  }

  /**
   * Creates a new column with an offset of 21.
   *
   * @return This Column instance with an offset of 21.
   */
  public Column offset21() {
    return offset(_21_, _none);
  }

  /**
   * Creates a new column with an offset of 22.
   *
   * @return This Column instance with an offset of 22.
   */
  public Column offset22() {
    return offset(_22_, _none);
  }

  /**
   * Creates a new column with an offset of 23.
   *
   * @return This Column instance with an offset of 23.
   */
  public Column offset23() {
    return offset(_23_, _none);
  }

  /**
   * Creates a new column with an offset of 24.
   *
   * @return This Column instance with an offset of 24.
   */
  public Column offset24() {
    return offset(_24_, _none);
  }

  /**
   * Creates a new column with an offset of 25.
   *
   * @return This Column instance with an offset of 25.
   */
  public Column offset25() {
    return offset(_25_, _none);
  }

  /**
   * Creates a new column with an offset of 26.
   *
   * @return This Column instance with an offset of 26.
   */
  public Column offset26() {
    return offset(_26_, _none);
  }

  /**
   * Creates a new column with an offset of 27.
   *
   * @return This Column instance with an offset of 27.
   */
  public Column offset27() {
    return offset(_27_, _none);
  }

  /**
   * Creates a new column with an offset of 28.
   *
   * @return This Column instance with an offset of 28.
   */
  public Column offset28() {
    return offset(_28_, _none);
  }

  /**
   * Creates a new column with an offset of 29.
   *
   * @return This Column instance with an offset of 29.
   */
  public Column offset29() {
    return offset(_29_, _none);
  }

  /**
   * Creates a new column with an offset of 30.
   *
   * @return This Column instance with an offset of 30.
   */
  public Column offset30() {
    return offset(_30_, _none);
  }

  /**
   * Creates a new column with an offset of 31.
   *
   * @return This Column instance with an offset of 31.
   */
  public Column offset31() {
    return offset(_31_, _none);
  }

  /**
   * Creates a new column with custom offsets for different screen sizes.
   *
   * @param xLarge Offset for extra-large screens (>=1200px).
   * @param large Offset for large screens (>=992px).
   * @param medium Offset for medium screens (>=768px).
   * @param small Offset for small screens (>=576px).
   * @param xsmall Offset for extra-small screens (<576px).
   * @return This Column instance with custom offsets.
   */
  public Column offset(Offset xLarge, Offset large, Offset medium, Offset small, Offset xsmall) {
    return onXLargeOffset(xLarge)
        .onLargeOffset(large)
        .onMediumOffset(medium)
        .onSmallOffset(small)
        .onXSmallOffset(xsmall);
  }

  /**
   * Creates a new column with uniform offsets for different screen sizes.
   *
   * @param large Offset for large screens (>=992px).
   * @param medium Offset for medium screens (>=768px).
   * @param small Offset for small screens (>=576px).
   * @param xsmall Offset for extra-small screens (<576px).
   * @return This Column instance with uniform offsets.
   */
  public Column offset(Offset large, Offset medium, Offset small, Offset xsmall) {
    return offset(large, large, medium, small, xsmall);
  }

  /**
   * Creates a new column with uniform offsets for medium and larger screens and a different offset
   * for small screens and below.
   *
   * @param offset Offset for medium and larger screens.
   * @param smallAndDown Offset for small screens and below.
   * @return This Column instance with uniform and small screen offsets.
   */
  public Column offset(Offset offset, Offset smallAndDown) {
    return offset(offset, offset, offset, smallAndDown, smallAndDown);
  }

  /**
   * Creates a new column with a uniform offset for all screen sizes.
   *
   * @param offset Offset for all screen sizes.
   * @return This Column instance with a uniform offset.
   */
  public Column offset(Offset offset) {
    return onXLargeOffset(offset)
        .onLargeOffset(offset)
        .onMediumOffset(offset)
        .onSmallOffset(offset)
        .onXSmallOffset(offset);
  }

  /**
   * Sets the column size for extra-large screens (>=1200px).
   *
   * @param span The column span for extra-large screens.
   * @return This Column instance with the specified span for extra-large screens.
   */
  public Column onXLarge(Span span) {
    addCss(this.onXLargeStyle.postfix(span.postfix));
    return this;
  }

  /**
   * Sets the column size for large screens (>=992px).
   *
   * @param span The column span for large screens.
   * @return This Column instance with the specified span for large screens.
   */
  public Column onLarge(Span span) {
    addCss(this.onLargeStyle.postfix(span.postfix));
    return this;
  }

  /**
   * Sets the column size for medium screens (>=768px).
   *
   * @param span The column span for medium screens.
   * @return This Column instance with the specified span for medium screens.
   */
  public Column onMedium(Span span) {
    addCss(this.onMediumStyle.postfix(span.postfix));
    return this;
  }

  /**
   * Sets the column size for small screens (>=576px).
   *
   * @param span The column span for small screens.
   * @return This Column instance with the specified span for small screens.
   */
  public Column onSmall(Span span) {
    addCss(this.onSmallStyle.postfix(span.postfix));
    return this;
  }

  /**
   * Sets the column size for extra-small screens (<576px).
   *
   * @param span The column span for extra-small screens.
   * @return This Column instance with the specified span for extra-small screens.
   */
  public Column onXSmall(Span span) {
    addCss(this.onXSmallStyle.postfix(span.postfix));
    return this;
  }

  /**
   * Sets the column offset for extra-large screens (>=1200px).
   *
   * @param offset The column offset for extra-large screens.
   * @return This Column instance with the specified offset for extra-large screens.
   */
  public Column onXLargeOffset(Offset offset) {
    addCss(this.onXLargeOffsetStyle.postfix(offset.postfix));
    return this;
  }

  /**
   * Sets the column offset for large screens (>=992px).
   *
   * @param offset The column offset for large screens.
   * @return This Column instance with the specified offset for large screens.
   */
  public Column onLargeOffset(Offset offset) {
    addCss(this.onLargeOffsetStyle.postfix(offset.postfix));
    return this;
  }

  /**
   * Sets the column offset for medium screens (>=768px).
   *
   * @param offset The column offset for medium screens.
   * @return This Column instance with the specified offset for medium screens.
   */
  public Column onMediumOffset(Offset offset) {
    addCss(this.onMediumOffsetStyle.postfix(offset.postfix));
    return this;
  }

  /**
   * Sets the column offset for small screens (>=576px).
   *
   * @param offset The column offset for small screens.
   * @return This Column instance with the specified offset for small screens.
   */
  public Column onSmallOffset(Offset offset) {
    addCss(this.onSmallOffsetStyle.postfix(offset.postfix));
    return this;
  }

  /**
   * Sets the column offset for extra-small screens (<576px).
   *
   * @param offset The column offset for extra-small screens.
   * @return This Column instance with the specified offset for extra-small screens.
   */
  public Column onXSmallOffset(Offset offset) {
    addCss(this.onXSmallOffsetStyle.postfix(offset.postfix));
    return this;
  }

  /**
   * Gets the PostfixCssClass for the column style on extra-large screens (>=1200px).
   *
   * @return The PostfixCssClass for the column style on extra-large screens.
   */
  public PostfixCssClass getOnXLargeStyle() {
    return onXLargeStyle;
  }

  /**
   * Gets the PostfixCssClass for the column style on large screens (>=992px).
   *
   * @return The PostfixCssClass for the column style on large screens.
   */
  public PostfixCssClass getOnLargeStyle() {
    return onLargeStyle;
  }

  /**
   * Gets the PostfixCssClass for the column style on medium screens (>=768px).
   *
   * @return The PostfixCssClass for the column style on medium screens.
   */
  public PostfixCssClass getOnMediumStyle() {
    return onMediumStyle;
  }

  /**
   * Gets the PostfixCssClass for the column style on small screens (>=576px).
   *
   * @return The PostfixCssClass for the column style on small screens.
   */
  public PostfixCssClass getOnSmallStyle() {
    return onSmallStyle;
  }

  /**
   * Gets the PostfixCssClass for the column style on extra-small screens (<576px).
   *
   * @return The PostfixCssClass for the column style on extra-small screens.
   */
  public PostfixCssClass getOnXSmallStyle() {
    return onXSmallStyle;
  }

  /**
   * Gets the PostfixCssClass for the column offset style on medium screens (>=768px).
   *
   * @return The PostfixCssClass for the column offset style on medium screens.
   */
  public PostfixCssClass getOnMediumOffsetStyle() {
    return onMediumOffsetStyle;
  }

  /**
   * Gets the PostfixCssClass for the column offset style on extra-small screens (<576px).
   *
   * @return The PostfixCssClass for the column offset style on extra-small screens.
   */
  public PostfixCssClass getOnXSmallOffsetStyle() {
    return onXSmallOffsetStyle;
  }

  /**
   * Gets the PostfixCssClass for the column offset style on extra-large screens (>=1200px).
   *
   * @return The PostfixCssClass for the column offset style on extra-large screens.
   */
  public PostfixCssClass getOnXLargeOffsetStyle() {
    return onXLargeOffsetStyle;
  }

  /**
   * Gets the PostfixCssClass for the column offset style on large screens (>=992px).
   *
   * @return The PostfixCssClass for the column offset style on large screens.
   */
  public PostfixCssClass getOnLargeOffsetStyle() {
    return onLargeOffsetStyle;
  }

  /**
   * Gets the PostfixCssClass for the column offset style on small screens (>=576px).
   *
   * @return The PostfixCssClass for the column offset style on small screens.
   */
  public PostfixCssClass getOnSmallOffsetStyle() {
    return onSmallOffsetStyle;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the HTML element associated with this column.
   * @return The HTML element representing this column.
   */
  @Override
  public HTMLElement element() {
    return column.element();
  }

  /**
   * Enumeration representing possible span values for columns.
   *
   * <p>Use this enum to define the span of columns for layout components.
   *
   * <p>Example usage:
   *
   * <pre>{@code
   * // Creating a column with a span of 3 columns
   * Column column = Column.colspan(Span._3, Column._full);
   * }</pre>
   */
  public enum Span {
    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _10("10"),
    _11("11"),
    _12("12"),
    _13("13"),
    _14("14"),
    _15("15"),
    _16("16"),
    _17("17"),
    _18("18"),
    _19("19"),
    _20("20"),
    _21("21"),
    _22("22"),
    _23("23"),
    _24("24"),
    _25("25"),
    _26("26"),
    _27("27"),
    _28("28"),
    _29("29"),
    _30("30"),
    _31("31"),
    _32("32"),
    _full("full");

    /** The postfix string associated with the span value. */
    private String postfix;

    /**
     * Constructor for the Span enum.
     *
     * @param postfix The postfix string associated with the span value.
     */
    Span(String postfix) {
      this.postfix = postfix;
    }
  }

  /**
   * Enumeration representing possible offset values for columns.
   *
   * <p>Use this enum to define the offset of columns for layout components.
   *
   * <p>Example usage:
   *
   * <pre>{@code
   * // Creating a column with a span of 4 columns and an offset of 2 columns
   * Column column = Column.colspan(Span._4, Column._full).offset(Offset._2_, Offset._none);
   * }</pre>
   */
  public enum Offset {
    _0_("0"),
    _1_("1"),
    _2_("2"),
    _3_("3"),
    _4_("4"),
    _5_("5"),
    _6_("6"),
    _7_("7"),
    _8_("8"),
    _9_("9"),
    _10_("10"),
    _11_("11"),
    _12_("12"),
    _13_("13"),
    _14_("14"),
    _15_("15"),
    _16_("16"),
    _17_("17"),
    _18_("18"),
    _19_("19"),
    _20_("20"),
    _21_("21"),
    _22_("22"),
    _23_("23"),
    _24_("24"),
    _25_("25"),
    _26_("26"),
    _27_("27"),
    _28_("28"),
    _29_("29"),
    _30_("30"),
    _31_("31"),
    _none("none");

    /** The postfix string associated with the offset value. */
    private String postfix;

    /**
     * Constructor for the Offset enum.
     *
     * @param postfix The postfix string associated with the offset value.
     */
    Offset(String postfix) {
      this.postfix = postfix;
    }
  }
}
