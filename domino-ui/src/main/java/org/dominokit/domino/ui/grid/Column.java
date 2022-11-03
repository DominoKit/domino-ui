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
import static org.dominokit.domino.ui.grid.Column.Offset.*;
import static org.dominokit.domino.ui.grid.Column.Span.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.PostfixCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

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
public class Column extends BaseDominoElement<HTMLElement, Column> implements Cloneable, GridStyles {

    private final DominoElement<? extends HTMLElement> column;
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
        this.column = DominoElement.div().addCss(dui_grid_col);
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
     * @param large  the size of the column when the screen is large
     * @param medium the size of the column when the screen is medium
     * @param small  the size of the column when the screen is small
     * @param xsmall the size of the column when the screen is X small
     * @return new instance
     */
    public static Column span(Span xLarge, Span large, Span medium, Span small, Span xsmall) {
        return span()
                .onXLarge(xLarge)
                .onLarge(large)
                .onMedium(medium)
                .onSmall(small)
                .onXSmall(xsmall);
    }

    /**
     * Creates new column with providing sizes for different screens sizes
     *
     * @param large  the size of the column when the screen is large
     * @param medium the size of the column when the screen is medium
     * @param small  the size of the column when the screen is small
     * @param xsmall the size of the column when the screen is X small
     * @return new instance
     */
    public static Column span(Span large, Span medium, Span small, Span xsmall) {
        return span(large, large, medium, small, xsmall);
    }

    /**
     * Creates new column with providing sizes for different screens sizes as a range
     *
     * @param mediumAnUp   the size of the column when the screen is larger or equal medium size
     * @param smallAndDown the size of the column when the screen is smaller or equal small size
     * @return new instance
     */
    public static Column span(Span mediumAnUp, Span smallAndDown) {
        return span(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
    }

    /**
     * Creates new column with providing the same size for all different screens sizes
     *
     * @param span the size of the column for all screens
     * @return new instance
     */
    public static Column span(Span span) {
        return span()
                .onXLarge(span)
                .onLarge(span)
                .onMedium(span)
                .onSmall(span)
                .onXSmall(span);
    }

    /**
     * Creates new column with size of 1 column for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span1() {
        return span(_1, _full);
    }

    /**
     * Creates new column with size of 1 column for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span1(IsElement<?> content) {
        return span1().appendChild(content);
    }

    /**
     * Creates new column with size of 2 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span2() {
        return span(_2, _full);
    }
    public static Column span2(IsElement<?> content) {
        return span2().appendChild(content);
    }

    /**
     * Creates new column with size of 3 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span3() {
        return span(Span._3, _full);
    }

    public static Column span3(IsElement<?> content) {
        return span3().appendChild(content);
    }

    /**
     * Creates new column with size of 4 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span4() {
        return span(_4, _full);
    }


    public static Column span4(IsElement<?> content) {
        return span4().appendChild(content);
    }
    /**
     * Creates new column with size of 5 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span5() {
        return span(_5, _full);
    }

    public static Column span5(IsElement<?> content) {
        return span5().appendChild(content);
    }

    /**
     * Creates new column with size of 6 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span6() {
        return span(_6, _full);
    }

    public static Column span6(IsElement<?> content) {
        return span6().appendChild(content);
    }
    /**
     * Creates new column with size of 7 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span7() {
        return span(_7, _full);
    }

    public static Column span7(IsElement<?> content) {
        return span7().appendChild(content);
    }
    /**
     * Creates new column with size of 8 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span8() {
        return span(_8, _full);
    }

    public static Column span8(IsElement<?> content) {
        return span8().appendChild(content);
    }
    /**
     * Creates new column with size of 9 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span9() {
        return span(_9, _full);
    }

    public static Column span9(IsElement<?> content) {
        return span9().appendChild(content);
    }
    /**
     * Creates new column with size of 10 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span10() {
        return span(_10, _full);
    }

    public static Column span10(IsElement<?> content) {
        return span10().appendChild(content);
    }
    /**
     * Creates new column with size of 11 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span11() {
        return span(_11, _full);
    }

    public static Column span11(IsElement<?> content) {
        return span11().appendChild(content);
    }
    /**
     * Creates new column with size of 12 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span12() {
        return span(_12, _full);
    }

    public static Column span12(IsElement<?> content) {
        return span12().appendChild(content);
    }
    /**
     * Creates new column with size of 13 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span13() {
        return span(_13, _full);
    }

    public static Column span13(IsElement<?> content) {
        return span13().appendChild(content);
    }
    /**
     * Creates new column with size of 14 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span14() {
        return span(_14, _full);
    }

    public static Column span14(IsElement<?> content) {
        return span14().appendChild(content);
    }
    /**
     * Creates new column with size of 15 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span15() {
        return span(_15, _full);
    }

    public static Column span15(IsElement<?> content) {
        return span15().appendChild(content);
    }
    /**
     * Creates new column with size of 16 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span16() {
        return span(_16, _full);
    }

    public static Column span16(IsElement<?> content) {
        return span16().appendChild(content);
    }

    /**
     * Creates new column with size of 17 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span17() {
        return span(_17, _full);
    }

    public static Column span17(IsElement<?> content) {
        return span17().appendChild(content);
    }

    /**
     * Creates new column with size of 18 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span18() {
        return span(_18, _full);
    }

    public static Column span18(IsElement<?> content) {
        return span18().appendChild(content);
    }
    /**
     * Creates new column with size of 19 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span19() {
        return span(_19, _full);
    }

    public static Column span19(IsElement<?> content) {
        return span19().appendChild(content);
    }
    /**
     * Creates new column with size of 20 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span20() {
        return span(_20, _full);
    }

    public static Column span20(IsElement<?> content) {
        return span20().appendChild(content);
    }
    /**
     * Creates new column with size of 21 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span21() {
        return span(_21, _full);
    }

    public static Column span21(IsElement<?> content) {
        return span21().appendChild(content);
    }
    /**
     * Creates new column with size of 22 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span22() {
        return span(_22, _full);
    }

    public static Column span22(IsElement<?> content) {
        return span22().appendChild(content);
    }
    /**
     * Creates new column with size of 23 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span23() {
        return span(_23, _full);
    }

    public static Column span23(IsElement<?> content) {
        return span23().appendChild(content);
    }
    /**
     * Creates new column with size of 24 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span24() {
        return span(_24, _full);
    }

    public static Column span24(IsElement<?> content) {
        return span24().appendChild(content);
    }
    /**
     * Creates new column with size of 25 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span25() {
        return span(_25, _full);
    }

    public static Column span25(IsElement<?> content) {
        return span25().appendChild(content);
    }
    /**
     * Creates new column with size of 26 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span26() {
        return span(_26, _full);
    }

    public static Column span26(IsElement<?> content) {
        return span26().appendChild(content);
    }
    /**
     * Creates new column with size of 27 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span27() {
        return span(_27, _full);
    }

    public static Column span27(IsElement<?> content) {
        return span27().appendChild(content);
    }
    /**
     * Creates new column with size of 28 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span28() {
        return span(_28, _full);
    }

    public static Column span28(IsElement<?> content) {
        return span28().appendChild(content);
    }
    /**
     * Creates new column with size of 29 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span29() {
        return span(_29, _full);
    }

    public static Column span29(IsElement<?> content) {
        return span29().appendChild(content);
    }
    /**
     * Creates new column with size of 30 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span30() {
        return span(_30, _full);
    }

    public static Column span30(IsElement<?> content) {
        return span30().appendChild(content);
    }
    /**
     * Creates new column with size of 31 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span31() {
        return span(_31, _full);
    }

    public static Column span31(IsElement<?> content) {
        return span31().appendChild(content);
    }
    /**
     * Creates new column with size of 32 columns for screens that are larger or equal medium and size
     * of full row for screens that are smaller and equal small
     *
     * @return new instance
     */
    public static Column span32() {
        return span(_32, _full);
    }

    public static Column span32(IsElement<?> content) {
        return span32().appendChild(content);
    }
    /**
     * Creates new column with 0 column distance from the start
     *
     * @return new instance
     */
    public Column offset0() {
        return offset(_0_, _none);
    }

    /**
     * Creates new column with 1 column distance from the start
     *
     * @return new instance
     */
    public Column offset1() {
        return offset(_1_, _none);
    }

    /**
     * Creates new column with 2 columns distance from the start
     *
     * @return new instance
     */
    public Column offset2() {
        return offset(_2_, _none);
    }

    /**
     * Creates new column with 3 columns distance from the start
     *
     * @return new instance
     */
    public Column offset3() {
        return offset(_3_, _none);
    }

    /**
     * Creates new column with 4 columns distance from the start
     *
     * @return new instance
     */
    public Column offset4() {
        return offset(_4_, _none);
    }

    /**
     * Creates new column with 5 columns distance from the start
     *
     * @return new instance
     */
    public Column offset5() {
        return offset(_5_, _none);
    }

    /**
     * Creates new column with 6 columns distance from the start
     *
     * @return new instance
     */
    public Column offset6() {
        return offset(_6_, _none);
    }

    /**
     * Creates new column with 7 columns distance from the start
     *
     * @return new instance
     */
    public Column offset7() {
        return offset(_7_, _none);
    }

    /**
     * Creates new column with 8 columns distance from the start
     *
     * @return new instance
     */
    public Column offset8() {
        return offset(_8_, _none);
    }

    /**
     * Creates new column with 9 columns distance from the start
     *
     * @return new instance
     */
    public Column offset9() {
        return offset(_9_, _none);
    }

    /**
     * Creates new column with 10 columns distance from the start
     *
     * @return new instance
     */
    public Column offset10() {
        return offset(_10_, _none);
    }

    /**
     * Creates new column with 11 columns distance from the start
     *
     * @return new instance
     */
    public Column offset11() {
        return offset(_11_, _none);
    }

    /**
     * Creates new column with 12 columns distance from the start
     *
     * @return new instance
     */
    public Column offset12() {
        return offset(_12_, _none);
    }

    /**
     * Creates new column with 13 columns distance from the start
     *
     * @return new instance
     */
    public Column offset13() {
        return offset(_13_, _none);
    }

    /**
     * Creates new column with 14 columns distance from the start
     *
     * @return new instance
     */
    public Column offset14() {
        return offset(_14_, _none);
    }

    /**
     * Creates new column with 15 columns distance from the start
     *
     * @return new instance
     */
    public Column offset15() {
        return offset(_15_, _none);
    }

    /**
     * Creates new column with 16 columns distance from the start
     *
     * @return new instance
     */
    public Column offset16() {
        return offset(_16_, _none);
    }

    /**
     * Creates new column with 17 columns distance from the start
     *
     * @return new instance
     */
    public Column offset17() {
        return offset(_17_, _none);
    }

    /**
     * Creates new column with 18 columns distance from the start
     *
     * @return new instance
     */
    public Column offset18() {
        return offset(_18_, _none);
    }

    /**
     * Creates new column with 19 columns distance from the start
     *
     * @return new instance
     */
    public Column offset19() {
        return offset(_19_, _none);
    }

    /**
     * Creates new column with 20 columns distance from the start
     *
     * @return new instance
     */
    public Column offset20() {
        return offset(_20_, _none);
    }

    /**
     * Creates new column with 21 columns distance from the start
     *
     * @return new instance
     */
    public Column offset21() {
        return offset(_21_, _none);
    }

    /**
     * Creates new column with 22 columns distance from the start
     *
     * @return new instance
     */
    public Column offset22() {
        return offset(_22_, _none);
    }

    /**
     * Creates new column with 23 columns distance from the start
     *
     * @return new instance
     */
    public Column offset23() {
        return offset(_23_, _none);
    }

    /**
     * Creates new column with 24 columns distance from the start
     *
     * @return new instance
     */
    public Column offset24() {
        return offset(_24_, _none);
    }

    /**
     * Creates new column with 25 columns distance from the start
     *
     * @return new instance
     */
    public Column offset25() {
        return offset(_25_, _none);
    }

    /**
     * Creates new column with 26 columns distance from the start
     *
     * @return new instance
     */
    public Column offset26() {
        return offset(_26_, _none);
    }

    /**
     * Creates new column with 27 columns distance from the start
     *
     * @return new instance
     */
    public Column offset27() {
        return offset(_27_, _none);
    }

    /**
     * Creates new column with 28 columns distance from the start
     *
     * @return new instance
     */
    public Column offset28() {
        return offset(_28_, _none);
    }

    /**
     * Creates new column with 29 columns distance from the start
     *
     * @return new instance
     */
    public Column offset29() {
        return offset(_29_, _none);
    }

    /**
     * Creates new column with 30 columns distance from the start
     *
     * @return new instance
     */
    public Column offset30() {
        return offset(_30_, _none);
    }

    /**
     * Creates new column with 31 columns distance from the start
     *
     * @return new instance
     */
    public Column offset31() {
        return offset(_31_, _none);
    }

    /**
     * Creates new column with providing offsets on all different screens sizes
     *
     * @param xLarge the offset of the column when the screen is X large
     * @param large  the offset of the column when the screen is large
     * @param medium the offset of the column when the screen is medium
     * @param small  the offset of the column when the screen is small
     * @param xsmall the offset of the column when the screen is X small
     * @return new instance
     */
    public Column offset(Offset xLarge, Offset large, Offset medium, Offset small, Offset xsmall) {
        return onXLargeOffset(xLarge)
                .onLargeOffset(large)
                .onMediumOffset(medium)
                .onSmallOffset(small)
                .onXSmallOffset(xsmall);
    }

    /**
     * Creates new column with providing offsets on all different screens sizes
     *
     * @param large  the offset of the column when the screen is large
     * @param medium the offset of the column when the screen is medium
     * @param small  the offset of the column when the screen is small
     * @param xsmall the offset of the column when the screen is X small
     * @return new instance
     */
    public Column offset(Offset large, Offset medium, Offset small, Offset xsmall) {
        return offset(large, large, medium, small, xsmall);
    }

    /**
     * Creates new column with providing offsets for different screens sizes as a range
     *
     * @param mediumAnUp   the offset of the column when the screen is larger or equal medium size
     * @param smallAndDown the offset of the column when the screen is smaller or equal small size
     * @return new instance
     */
    public Column offset(Offset mediumAnUp, Offset smallAndDown) {
        return offset(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
    }

    /**
     * Creates new column with providing the same offset for all different screens sizes
     *
     * @param offset the offset of the column for all screens
     * @return new instance
     */
    public Column offset(Offset offset) {
        return onXLargeOffset(offset)
                .onLargeOffset(offset)
                .onMediumOffset(offset)
                .onSmallOffset(offset)
                .onXSmallOffset(offset);
    }

    /**
     * Sets the size of the column when the screen is X large
     *
     * @param span the new {@link Span} size
     * @return same instance
     */
    public Column onXLarge(Span span) {
        addCss(this.onXLargeStyle.postfix(span.postfix));
        return this;
    }

    /**
     * Sets the size of the column when the screen is large
     *
     * @param span the new {@link Span} size
     * @return same instance
     */
    public Column onLarge(Span span) {
        addCss(this.onLargeStyle.postfix(span.postfix));
        return this;
    }

    /**
     * Sets the size of the column when the screen is medium
     *
     * @param span the new {@link Span} size
     * @return same instance
     */
    public Column onMedium(Span span) {
        addCss(this.onMediumStyle.postfix(span.postfix));
        return this;
    }

    /**
     * Sets the size of the column when the screen is small
     *
     * @param span the new {@link Span} size
     * @return same instance
     */
    public Column onSmall(Span span) {
        addCss(this.onSmallStyle.postfix(span.postfix));
        return this;
    }

    /**
     * Sets the size of the column when the screen is X small
     *
     * @param span the new {@link Span} size
     * @return same instance
     */
    public Column onXSmall(Span span) {
        addCss(this.onXSmallStyle.postfix(span.postfix));
        return this;
    }

    /**
     * Sets the offset of the column when the screen is X large
     *
     * @param offset the new {@link Offset} offset
     * @return same instance
     */
    public Column onXLargeOffset(Offset offset) {
        addCss(this.onXLargeOffsetStyle.postfix(offset.postfix));
        return this;
    }

    /**
     * Sets the offset of the column when the screen is large
     *
     * @param offset the new {@link Offset} offset
     * @return same instance
     */
    public Column onLargeOffset(Offset offset) {
        addCss(this.onLargeOffsetStyle.postfix(offset.postfix));
        return this;
    }

    /**
     * Sets the offset of the column when the screen is medium
     *
     * @param offset the new {@link Offset} offset
     * @return same instance
     */
    public Column onMediumOffset(Offset offset) {
        addCss(this.onMediumOffsetStyle.postfix(offset.postfix));
        return this;
    }

    /**
     * Sets the offset of the column when the screen is small
     *
     * @param offset the new {@link Offset} offset
     * @return same instance
     */
    public Column onSmallOffset(Offset offset) {
        addCss(this.onSmallOffsetStyle.postfix(offset.postfix));
        return this;
    }

    /**
     * Sets the offset of the column when the screen is X small
     *
     * @param offset the new {@link Offset} offset
     * @return same instance
     */
    public Column onXSmallOffset(Offset offset) {
        addCss(this.onXSmallOffsetStyle.postfix(offset.postfix));
        return this;
    }

    /**
     * @return The {@link PostfixCssClass} size
     */
    public PostfixCssClass getOnXLargeStyle() {
        return onXLargeStyle;
    }

    /**
     * @return The {@link PostfixCssClass} size
     */
    public PostfixCssClass getOnLargeStyle() {
        return onLargeStyle;
    }

    /**
     * @return The {@link PostfixCssClass} size
     */
    public PostfixCssClass getOnMediumStyle() {
        return onMediumStyle;
    }

    /**
     * @return The {@link PostfixCssClass} size
     */
    public PostfixCssClass getOnSmallStyle() {
        return onSmallStyle;
    }

    /**
     * @return The {@link PostfixCssClass} size
     */
    public PostfixCssClass getOnXSmallStyle() {
        return onXSmallStyle;
    }

    /**
     * @return The {@link PostfixCssClass} offset
     */
    public PostfixCssClass getOnMediumOffsetStyle() {
        return onMediumOffsetStyle;
    }

    /**
     * @return The {@link PostfixCssClass} offset
     */
    public PostfixCssClass getOnXSmallOffsetStyle() {
        return onXSmallOffsetStyle;
    }

    /**
     * @return The {@link PostfixCssClass} offset
     */
    public PostfixCssClass getOnXLargeOffsetStyle() {
        return onXLargeOffsetStyle;
    }

    /**
     * @return The {@link PostfixCssClass} offset
     */
    public PostfixCssClass getOnLargeOffsetStyle() {
        return onLargeOffsetStyle;
    }

    /**
     * @return The {@link PostfixCssClass} offset
     */
    public PostfixCssClass getOnSmallOffsetStyle() {
        return onSmallOffsetStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return column.element();
    }

    /**
     * An enum representing the size of a column can have
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

        private String postfix;

        Span(String postfix) {
            this.postfix = postfix;
        }

    }

    /**
     * An enum representing the offset that a column can have
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

        private String postfix;

        Offset(String postfix) {
            this.postfix = postfix;
        }

    }
}
