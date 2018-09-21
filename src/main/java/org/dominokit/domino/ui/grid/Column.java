package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Column extends BaseDominoElement<HTMLDivElement, Column> implements Cloneable {

    private static final int FULL_SPAN = -1;
    private static final int NO_OFFSET = -1;
    private HTMLDivElement column;
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
        this.column = div().css("grid-col").asElement();
        init(this);
    }

    public static Column span() {
        return new Column();
    }

    public static Column span(int xLarge, int large, int medium, int small, int xsmall) {
        return span()
                .onXLarge(OnXLarge.of(xLarge))
                .onLarge(OnLarge.of(large))
                .onMedium(OnMedium.of(medium))
                .onSmall(OnSmall.of(small))
                .onXSmall(OnXSmall.of(xsmall));
    }

    public static Column span(int large, int medium, int small, int xsmall) {
        return span(large, large, medium, small, xsmall);
    }

    public static Column span(int mediumAnUp, int smallAndDown) {
        return span(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
    }

    public static Column span(int columnsOnAllScreens) {
        return span()
                .onXLarge(OnXLarge.of(columnsOnAllScreens))
                .onLarge(OnLarge.of(columnsOnAllScreens))
                .onMedium(OnMedium.of(columnsOnAllScreens))
                .onSmall(OnSmall.of(columnsOnAllScreens))
                .onXSmall(OnXSmall.of(columnsOnAllScreens));
    }

    public static Column span1() {
        return span(1, FULL_SPAN);
    }

    public static Column span2() {
        return span(2, FULL_SPAN);
    }

    public static Column span3() {
        return span(3, FULL_SPAN);
    }

    public static Column span4() {
        return span(4, FULL_SPAN);
    }

    public static Column span5() {
        return span(5, FULL_SPAN);
    }

    public static Column span6() {
        return span(6, FULL_SPAN);
    }

    public static Column span7() {
        return span(7, FULL_SPAN);
    }

    public static Column span8() {
        return span(8, FULL_SPAN);
    }

    public static Column span9() {
        return span(9, FULL_SPAN);
    }

    public static Column span10() {
        return span(10, FULL_SPAN);
    }

    public static Column span11() {
        return span(11, FULL_SPAN);
    }

    public static Column span12() {
        return span(12, FULL_SPAN);
    }

    public static Column span13() {
        return span(13, FULL_SPAN);
    }

    public static Column span14() {
        return span(14, FULL_SPAN);
    }

    public static Column span15() {
        return span(15, FULL_SPAN);
    }

    public static Column span16() {
        return span(16, FULL_SPAN);
    }

    public static Column span17() {
        return span(17, FULL_SPAN);
    }

    public static Column span18() {
        return span(18, FULL_SPAN);
    }

    public static Column span19() {
        return span(19, FULL_SPAN);
    }

    public static Column span20() {
        return span(20, FULL_SPAN);
    }

    public static Column span21() {
        return span(21, FULL_SPAN);
    }

    public static Column span22() {
        return span(22, FULL_SPAN);
    }

    public static Column span23() {
        return span(23, FULL_SPAN);
    }

    public static Column span24() {
        return span(24, FULL_SPAN);
    }

    public static Column span25() {
        return span(25, FULL_SPAN);
    }

    public static Column span26() {
        return span(26, FULL_SPAN);
    }

    public static Column span27() {
        return span(27, FULL_SPAN);
    }

    public static Column span28() {
        return span(28, FULL_SPAN);
    }

    public static Column span29() {
        return span(29, FULL_SPAN);
    }

    public static Column span30() {
        return span(30, FULL_SPAN);
    }

    public static Column span31() {
        return span(31, FULL_SPAN);
    }

    public static Column span32() {
        return span(32, FULL_SPAN);
    }

    public Column offset0() {
        return offset(0, FULL_SPAN);
    }

    public Column offset1() {
        return offset(1, FULL_SPAN);
    }

    public Column offset2() {
        return offset(2, NO_OFFSET);
    }

    public Column offset3() {
        return offset(3, NO_OFFSET);
    }

    public Column offset4() {
        return offset(4, NO_OFFSET);
    }

    public Column offset5() {
        return offset(5, NO_OFFSET);
    }

    public Column offset6() {
        return offset(6, NO_OFFSET);
    }

    public Column offset7() {
        return offset(7, NO_OFFSET);
    }

    public Column offset8() {
        return offset(8, NO_OFFSET);
    }

    public Column offset9() {
        return offset(9, NO_OFFSET);
    }

    public Column offset10() {
        return offset(10, NO_OFFSET);
    }

    public Column offset11() {
        return offset(11, NO_OFFSET);
    }

    public Column offset12() {
        return offset(12, NO_OFFSET);
    }

    public Column offset13() {
        return offset(13, NO_OFFSET);
    }

    public Column offset14() {
        return offset(14, NO_OFFSET);
    }

    public Column offset15() {
        return offset(15, NO_OFFSET);
    }

    public Column offset16() {
        return offset(16, NO_OFFSET);
    }

    public Column offset17() {
        return offset(17, NO_OFFSET);
    }

    public Column offset18() {
        return offset(18, NO_OFFSET);
    }

    public Column offset19() {
        return offset(19, NO_OFFSET);
    }

    public Column offset20() {
        return offset(20, NO_OFFSET);
    }

    public Column offset21() {
        return offset(21, NO_OFFSET);
    }

    public Column offset22() {
        return offset(22, NO_OFFSET);
    }

    public Column offset23() {
        return offset(23, NO_OFFSET);
    }

    public Column offset24() {
        return offset(24, NO_OFFSET);
    }

    public Column offset25() {
        return offset(25, NO_OFFSET);
    }

    public Column offset26() {
        return offset(26, NO_OFFSET);
    }

    public Column offset27() {
        return offset(27, NO_OFFSET);
    }

    public Column offset28() {
        return offset(28, NO_OFFSET);
    }

    public Column offset29() {
        return offset(29, NO_OFFSET);
    }

    public Column offset30() {
        return offset(30, NO_OFFSET);
    }

    public Column offset31() {
        return offset(31, NO_OFFSET);
    }


    public Column offset(int xLarge, int large, int medium, int small, int xsmall) {
        return onXLargeOffset(OnXLargeOffset.of(xLarge))
                .onLargeOffset(OnLargeOffset.of(large))
                .onMediumOffset(OnMediumOffset.of(medium))
                .onSmallOffset(OnSmallOffset.of(small))
                .onXSmallOffset(OnXSmallOffset.of(xsmall));
    }

    public Column offset(int large, int medium, int small, int xsmall) {
        return offset(large, large, medium, small, xsmall);
    }

    public Column offset(int mediumAnUp, int smallAndDown) {
        return offset(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
    }

    public Column offset(int columnsOnAllScreens) {
        return onXLargeOffset(OnXLargeOffset.of(columnsOnAllScreens))
                .onLargeOffset(OnLargeOffset.of(columnsOnAllScreens))
                .onMediumOffset(OnMediumOffset.of(columnsOnAllScreens))
                .onSmallOffset(OnSmallOffset.of(columnsOnAllScreens))
                .onXSmallOffset(OnXSmallOffset.of(columnsOnAllScreens));
    }

    public Column copy() {
        Column column = Column.span();
        if (nonNull(this.onXLargeStyle))
            column.onXLarge(this.onXLargeStyle);
        if (nonNull(this.onLargeStyle))
            column.onLarge(this.onLargeStyle);
        if (nonNull(this.onMediumStyle))
            column.onMedium(this.onMediumStyle);
        if (nonNull(this.onSmallStyle))
            column.onSmall(this.onSmallStyle);
        if (nonNull(this.onXSmallStyle))
            column.onXSmall(this.onXSmallStyle);

        if (nonNull(this.onXLargeOffsetStyle))
            column.onXLargeOffset(this.onXLargeOffsetStyle);
        if (nonNull(this.onLargeOffsetStyle))
            column.onLargeOffset(this.onLargeOffsetStyle);
        if (nonNull(this.onMediumOffsetStyle))
            column.onMediumOffset(this.onMediumOffsetStyle);
        if (nonNull(this.onSmallOffsetStyle))
            column.onSmallOffset(this.onSmallOffsetStyle);
        if (nonNull(this.onXSmallOffsetStyle))
            column.onXSmallOffset(this.onXSmallOffsetStyle);

        if (style.contains(Styles.align_center))
            column.centerContent();

        return column;
    }

    /**
     * @deprecated use{@link #appendChild(Node)}
     */
    @Deprecated
    public Column addElement(Node element) {
        this.asElement().appendChild(element);
        return this;
    }

    public Column appendChild(Node element) {
        this.asElement().appendChild(element);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(IsElement)}
     */
    @Deprecated
    public Column addElement(IsElement<? extends HTMLElement> element) {
        this.asElement().appendChild(element.asElement());
        return this;
    }

    public Column appendChild(IsElement element) {
        this.asElement().appendChild(element.asElement());
        return this;
    }

    public Column onXLarge(OnXLarge onXLarge) {
        if (nonNull(this.onXLargeStyle)) {
            style.remove(this.onXLargeStyle.getStyle());
        }
        this.onXLargeStyle = onXLarge;
        style.add(this.onXLargeStyle.getStyle());
        return this;
    }

    public Column onLarge(OnLarge onLarge) {
        if (nonNull(this.onLargeStyle)) {
            style.remove(this.onLargeStyle.getStyle());
        }
        this.onLargeStyle = onLarge;
        style.add(this.onLargeStyle.getStyle());
        return this;
    }

    public Column onMedium(OnMedium onMedium) {
        if (nonNull(this.onMediumStyle)) {
            style.remove(this.onMediumStyle.getStyle());
        }
        this.onMediumStyle = onMedium;
        style.add(this.onMediumStyle.getStyle());
        return this;
    }

    public Column onSmall(OnSmall onSmall) {
        if (nonNull(this.onSmallStyle)) {
            style.remove(this.onSmallStyle.getStyle());
        }
        this.onSmallStyle = onSmall;
        style.add(this.onSmallStyle.getStyle());
        return this;
    }

    public Column onXSmall(OnXSmall onXSmall) {
        if (nonNull(this.onXSmallStyle)) {
            style.remove(this.onXSmallStyle.getStyle());
        }
        this.onXSmallStyle = onXSmall;
        style.add(this.onXSmallStyle.getStyle());
        return this;
    }

    //----------------
    public Column onXLargeOffset(OnXLargeOffset onXLarge) {
        if (nonNull(this.onXLargeOffsetStyle)) {
            style.remove(this.onXLargeOffsetStyle.getStyle());
        }
        this.onXLargeOffsetStyle = onXLarge;
        style.add(this.onXLargeOffsetStyle.getStyle());
        return this;
    }

    public Column onLargeOffset(OnLargeOffset onLarge) {
        if (nonNull(this.onLargeOffsetStyle)) {
            style.remove(this.onLargeOffsetStyle.getStyle());
        }
        this.onLargeOffsetStyle = onLarge;
        style.add(this.onLargeOffsetStyle.getStyle());
        return this;
    }

    public Column onMediumOffset(OnMediumOffset onMedium) {
        if (nonNull(this.onMediumOffsetStyle)) {
            style.remove(this.onMediumOffsetStyle.getStyle());
        }
        this.onMediumOffsetStyle = onMedium;
        style.add(this.onMediumOffsetStyle.getStyle());
        return this;
    }

    public Column onSmallOffset(OnSmallOffset onSmall) {
        if (nonNull(this.onSmallOffsetStyle)) {
            style.remove(this.onSmallOffsetStyle.getStyle());
        }
        this.onSmallOffsetStyle = onSmall;
        style.add(this.onSmallOffsetStyle.getStyle());
        return this;
    }

    public Column onXSmallOffset(OnXSmallOffset onXSmall) {
        if (nonNull(this.onXSmallOffsetStyle)) {
            style.remove(this.onXSmallOffsetStyle.getStyle());
        }
        this.onXSmallOffsetStyle = onXSmall;
        style.add(this.onXSmallOffsetStyle.getStyle());
        return this;
    }

    public Column centerContent() {
        asElement().classList.add(Styles.align_center);
        return this;
    }

    public Column deCenterContent() {
        asElement().classList.remove(Styles.align_center);
        return this;
    }

    public Column condenced() {
        style.remove("condense")
                .add("condense");
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return column;
    }

    public static class OnXLarge {
        private Span span;

        OnXLarge(Span span) {
            this.span = span;
        }

        static OnXLarge span(Span span) {
            return new OnXLarge(span);
        }

        public static OnXLarge of(int xlarge) {
            return new OnXLarge(Span.of(xlarge));
        }

        public String getStyle() {
            return "span-xl" + span.postfix;
        }
    }

    public static class OnLarge {
        private Span span;

        OnLarge(Span span) {
            this.span = span;
        }

        static OnLarge span(Span span) {
            return new OnLarge(span);
        }

        public static OnLarge of(int large) {
            return new OnLarge(Span.of(large));
        }

        public String getStyle() {
            return "span-l" + span.postfix;
        }
    }

    public static class OnMedium {
        private Span span;

        OnMedium(Span span) {
            this.span = span;
        }

        static OnMedium span(Span span) {
            return new OnMedium(span);
        }

        public static OnMedium of(int medium) {
            return new OnMedium(Span.of(medium));
        }

        public String getStyle() {
            return "span-m" + span.postfix;
        }
    }

    public static class OnSmall {
        private Span span;

        OnSmall(Span span) {
            this.span = span;
        }

        static OnSmall span(Span span) {
            return new OnSmall(span);
        }

        public static OnSmall of(int small) {
            return new OnSmall(Span.of(small));
        }

        public String getStyle() {
            return "span-s" + span.postfix;
        }
    }

    public static class OnXSmall {

        private Span span;

        OnXSmall(Span span) {
            this.span = span;
        }

        static OnXSmall span(Span span) {
            return new OnXSmall(span);
        }

        public static OnXSmall of(int xsmall) {
            return new OnXSmall(Span.of(xsmall));
        }

        public String getStyle() {
            return "span-xs" + span.postfix;
        }
    }


    //--------------

    public static class OnXLargeOffset {
        private Offset offset;

        OnXLargeOffset(Offset offset) {
            this.offset = offset;
        }

        static OnXLargeOffset offset(Offset offset) {
            return new OnXLargeOffset(offset);
        }

        public static OnXLargeOffset of(int xlarge) {
            return new OnXLargeOffset(Offset.of(xlarge));
        }

        public String getStyle() {
            return "offset-xl" + offset.postfix;
        }
    }

    public static class OnLargeOffset {
        private Offset offset;

        OnLargeOffset(Offset offset) {
            this.offset = offset;
        }

        static OnLargeOffset offset(Offset offset) {
            return new OnLargeOffset(offset);
        }

        public static OnLargeOffset of(int large) {
            return new OnLargeOffset(Offset.of(large));
        }

        public String getStyle() {
            return "offset-l" + offset.postfix;
        }
    }

    public static class OnMediumOffset {
        private Offset offset;

        OnMediumOffset(Offset offset) {
            this.offset = offset;
        }

        static OnMediumOffset offset(Offset offset) {
            return new OnMediumOffset(offset);
        }

        public static OnMediumOffset of(int medium) {
            return new OnMediumOffset(Offset.of(medium));
        }

        public String getStyle() {
            return "offset-m" + offset.postfix;
        }
    }

    public static class OnSmallOffset {
        private Offset offset;

        OnSmallOffset(Offset offset) {
            this.offset = offset;
        }

        static OnSmallOffset offset(Offset offset) {
            return new OnSmallOffset(offset);
        }

        public static OnSmallOffset of(int small) {
            return new OnSmallOffset(Offset.of(small));
        }

        public String getStyle() {
            return "offset-s" + offset.postfix;
        }
    }

    public static class OnXSmallOffset {

        private Offset offset;

        OnXSmallOffset(Offset offset) {
            this.offset = offset;
        }

        static OnXSmallOffset offset(Offset offset) {
            return new OnXSmallOffset(offset);
        }

        public static OnXSmallOffset of(int xsmall) {
            return new OnXSmallOffset(Offset.of(xsmall));
        }

        public String getStyle() {
            return "offset-xs" + offset.postfix;
        }
    }

    public enum Span {
        _1("-1"),
        _2("-2"),
        _3("-3"),
        _4("-4"),
        _5("-5"),
        _6("-6"),
        _7("-7"),
        _8("-8"),
        _9("-9"),
        _10("-10"),
        _11("-11"),
        _12("-12"),
        _13("-13"),
        _14("-14"),
        _15("-15"),
        _16("-16"),
        _17("-17"),
        _18("-18"),
        _19("-19"),
        _20("-20"),
        _21("-21"),
        _22("-22"),
        _23("-23"),
        _24("-24"),
        _25("-25"),
        _26("-26"),
        _27("-27"),
        _28("-28"),
        _29("-29"),
        _30("-30"),
        _31("-31"),
        _32("-32"),
        _full("-full");

        private String postfix;

        Span(String postfix) {
            this.postfix = postfix;
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

    public enum Offset {
        _0("-0"),
        _1("-1"),
        _2("-2"),
        _3("-3"),
        _4("-4"),
        _5("-5"),
        _6("-6"),
        _7("-7"),
        _8("-8"),
        _9("-9"),
        _10("-10"),
        _11("-11"),
        _12("-12"),
        _13("-13"),
        _14("-14"),
        _15("-15"),
        _16("-16"),
        _17("-17"),
        _18("-18"),
        _19("-19"),
        _20("-20"),
        _21("-21"),
        _22("-22"),
        _23("-23"),
        _24("-24"),
        _25("-25"),
        _26("-26"),
        _27("-27"),
        _28("-28"),
        _29("-29"),
        _30("-30"),
        _31("-31"),
        _none("-none");

        private String postfix;

        Offset(String postfix) {
            this.postfix = postfix;
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
