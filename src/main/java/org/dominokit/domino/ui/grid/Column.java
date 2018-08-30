package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Column extends DominoElement<Column> implements IsElement<HTMLDivElement>, Cloneable {

    private HTMLDivElement column;
    private OnXLarge onXLargeStyle;
    private OnLarge onLargeStyle;
    private OnMedium onMediumStyle;
    private OnSmall onSmallStyle;
    private OnXSmall onXSmallStyle;
    private List<String> cssClasses = new ArrayList<>();

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
        return span(1,12);
    }
    public static Column span2() {
        return span(2,12);
    }
    public static Column span3() {
        return span(3,12);
    }
    public static Column span4() {
        return span(4,12);
    }
    public static Column span5() {
        return span(5,12);
    }
    public static Column span6() {
        return span(6,12);
    }
    public static Column span7() {
        return span(7,12);
    }
    public static Column span8() {
        return span(8,12);
    }
    public static Column span9() {
        return span(9,12);
    }
    public static Column span10() {
        return span(10,12);
    }
    public static Column span11() {
        return span(11,12);
    }
    public static Column span12() {
        return span(12,12);
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
        if (this.asElement().classList.contains(Styles.align_center))
            column.centerContent();

        for (int i = 0; i < cssClasses.size(); i++) {
            style().css(cssClasses.get(i));
        }

        return column;
    }

    /**
     * @deprecated use{@link #appendChild(Node)}
     * @param element
     * @return
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
     * @param element
     * @return
     */
    @Deprecated
    public Column addElement(IsElement<? extends HTMLElement> element) {
        this.asElement().appendChild(element.asElement());
        return this;
    }

    public Column appendChild(IsElement<? extends HTMLElement> element) {
        this.asElement().appendChild(element.asElement());
        return this;
    }

    public Column onXLarge(OnXLarge onXLarge) {
        if (nonNull(this.onXLargeStyle))
            column.classList.remove(this.onXLargeStyle.getStyle());
        this.onXLargeStyle = onXLarge;
        column.classList.add(this.onXLargeStyle.getStyle());
        return this;
    }

    public Column onLarge(OnLarge onLarge) {
        if (nonNull(this.onLargeStyle))
            column.classList.remove(this.onLargeStyle.getStyle());
        this.onLargeStyle = onLarge;
        column.classList.add(this.onLargeStyle.getStyle());
        return this;
    }

    public Column onMedium(OnMedium onMedium) {
        if (nonNull(this.onMediumStyle))
            column.classList.remove(this.onMediumStyle.getStyle());
        this.onMediumStyle = onMedium;
        column.classList.add(this.onMediumStyle.getStyle());
        return this;
    }

    public Column onSmall(OnSmall onSmall) {
        if (nonNull(this.onSmallStyle))
            column.classList.remove(this.onSmallStyle.getStyle());
        this.onSmallStyle = onSmall;
        column.classList.add(this.onSmallStyle.getStyle());
        return this;
    }

    public Column onXSmall(OnXSmall onXSmall) {
        if (nonNull(this.onXSmallStyle))
            column.classList.remove(this.onXSmallStyle.getStyle());
        this.onXSmallStyle = onXSmall;
        column.classList.add(this.onXSmallStyle.getStyle());
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

    public Style<HTMLDivElement, Column> style() {
        return Style.of(this);
    }

    public Column condenced() {
        return Style.of(this).setMarginBottom("0px").get();
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

        static OnXLarge span(Span span){
            return new OnXLarge(span);
        }

        public static OnXLarge of(int xlarge) {
            return new OnXLarge(Span.of(xlarge));
        }

        public String getStyle() {
            return "span-xl" +span.postfix;
        }
    }

    public static class OnLarge {
        private Span span;

        OnLarge(Span span) {
            this.span = span;
        }

        static OnLarge span(Span span){
            return new OnLarge(span);
        }

        public static OnLarge of(int large) {
            return new OnLarge(Span.of(large));
        }

        public String getStyle() {
            return "span-l" +span.postfix;
        }
    }

    public static class OnMedium {
        private Span span;

        OnMedium(Span span) {
            this.span = span;
        }

        static OnMedium span(Span span){
            return new OnMedium(span);
        }

        public static OnMedium of(int medium) {
            return new OnMedium(Span.of(medium));
        }

        public String getStyle() {
            return "span-m" +span.postfix;
        }
    }

    public static class OnSmall {
        private Span span;

        OnSmall(Span span) {
            this.span = span;
        }

        static OnSmall span(Span span){
            return new OnSmall(span);
        }

        public static OnSmall of(int small) {
            return new OnSmall(Span.of(small));
        }

        public String getStyle() {
            return "span-s" +span.postfix;
        }
    }

    public static class OnXSmall {

        private Span span;

        OnXSmall(Span span) {
            this.span = span;
        }

        static OnXSmall span(Span span){
            return new OnXSmall(span);
        }

        public static OnXSmall of(int xsmall) {
            return new OnXSmall(Span.of(xsmall));
        }

        public String getStyle() {
            return "span-xs" +span.postfix;
        }
    }

    public enum Span{
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
        _32("-32");

        private String postfix;

        Span(String postfix) {
            this.postfix = postfix;
        }

        static Span of(int columns){
            switch (columns){
                case 1: return _1;
                case 2: return _2;
                case 3: return _3;
                case 4: return _4;
                case 5: return _5;
                case 6: return _6;
                case 7: return _7;
                case 8: return _8;
                case 9: return _9;
                case 10: return _10;
                case 11: return _11;
                case 12: return _12;
                case 13: return _13;
                case 14: return _14;
                case 15: return _15;
                case 16: return _16;
                case 17: return _17;
                case 18: return _18;
                case 19: return _19;
                case 20: return _20;
                case 21: return _21;
                case 22: return _22;
                case 23: return _23;
                case 24: return _24;
                case 25: return _25;
                case 26: return _26;
                case 27: return _27;
                case 28: return _28;
                case 29: return _29;
                case 30: return _30;
                case 31: return _31;
                case 32: return _32;
                default:
                    return _12;
            }
        }
    }
}
