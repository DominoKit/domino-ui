package org.dominokit.domino.ui.column;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Column implements IsElement<HTMLDivElement>, Cloneable {

    public static final String ALIGN_CENTER = "align-center";
    private HTMLDivElement column;
    private OnLarge onLargeStyle;
    private OnMedium onMediumStyle;
    private OnSmall onSmallStyle;
    private OnXSmall onXSmallStyle;
    private List<String> cssClasses = new ArrayList<>();

    private Column(HTMLDivElement htmlDivElement) {
        this.column = htmlDivElement;
    }

    public static Column create() {
        return new Column(div().asElement());
    }

    public static Column create(int large, int medium, int small, int xsmall) {
        return create()
                .onLarge(OnLarge.of(large))
                .onMedium(OnMedium.of(medium))
                .onSmall(OnSmall.of(small))
                .onXSmall(OnXSmall.of(xsmall));
    }

    public static Column create(int columnsOnAllScreens) {
        return create()
                .onLarge(OnLarge.of(columnsOnAllScreens))
                .onMedium(OnMedium.of(columnsOnAllScreens))
                .onSmall(OnSmall.of(columnsOnAllScreens))
                .onXSmall(OnXSmall.of(columnsOnAllScreens));
    }

    public static Column columns2() {
        return create(6, 6, 12, 12);
    }

    public static Column columns3() {
        return create(4, 4, 12, 12);
    }

    public static Column columns4() {
        return create(3, 3, 12, 12);
    }

    public static Column columns6() {
        return create(2, 2, 12, 12);
    }

    public Column copy() {
        Column column = Column.create();
        if (nonNull(this.onLargeStyle))
            column.onLarge(this.onLargeStyle);
        if (nonNull(this.onMediumStyle))
            column.onMedium(this.onMediumStyle);
        if (nonNull(this.onSmallStyle))
            column.onSmall(this.onSmallStyle);
        if (nonNull(this.onXSmallStyle))
            column.onXSmall(this.onXSmallStyle);
        if (this.asElement().classList.contains(ALIGN_CENTER))
            column.centerContent();

        for (int i = 0; i < cssClasses.size(); i++) {
            column.addCssClass(cssClasses.get(i));
        }

        return column;
    }

    public Column addElement(Node element) {
        this.asElement().appendChild(element);
        return this;
    }

    public Column addElement(IsElement<? extends HTMLElement> element) {
        this.asElement().appendChild(element.asElement());
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
        asElement().classList.add(ALIGN_CENTER);
        return this;
    }

    public Column deCenterContent() {
        asElement().classList.remove(ALIGN_CENTER);
        return this;
    }

    public Column addCssClass(String cssClass) {
        this.asElement().classList.add(cssClass);
        this.cssClasses.add(cssClass);
        return this;
    }

    public Column removeCssClass(String cssClass) {
        this.asElement().classList.remove(cssClass);
        this.cssClasses.remove(cssClass);
        return this;
    }

    public Column condenced() {
        return Style.of(this).setMarginBottom("0px").get();
    }

    @Override
    public HTMLDivElement asElement() {
        return column;
    }

    public enum OnLarge {
        one("col-lg-1"),
        two("col-lg-2"),
        three("col-lg-3"),
        four("col-lg-4"),
        five("col-lg-5"),
        six("col-lg-6"),
        seven("col-lg-7"),
        eight("col-lg-8"),
        nine("col-lg-9"),
        ten("col-lg-10"),
        eleven("col-lg-11"),
        twelve("col-lg-12");

        private String style;

        OnLarge(String style) {
            this.style = style;
        }

        public static OnLarge of(int large) {
            return OnLarge.valueOf(asNumberString(large));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnMedium {
        one("col-md-1"),
        two("col-md-2"),
        three("col-md-3"),
        four("col-md-4"),
        five("col-md-5"),
        six("col-md-6"),
        seven("col-md-7"),
        eight("col-md-8"),
        nine("col-md-9"),
        ten("col-md-10"),
        eleven("col-md-11"),
        twelve("col-md-12");

        private String style;

        OnMedium(String style) {
            this.style = style;
        }

        public static OnMedium of(int medium) {
            return OnMedium.valueOf(asNumberString(medium));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnSmall {
        one("col-sm-1"),
        two("col-sm-2"),
        three("col-sm-3"),
        four("col-sm-4"),
        five("col-sm-5"),
        six("col-sm-6"),
        seven("col-sm-7"),
        eight("col-sm-8"),
        nine("col-sm-9"),
        ten("col-sm-10"),
        eleven("col-sm-11"),
        twelve("col-sm-12");

        private String style;

        OnSmall(String style) {
            this.style = style;
        }

        public static OnSmall of(int small) {
            return OnSmall.valueOf(asNumberString(small));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnXSmall {
        one("col-xs-1"),
        two("col-xs-2"),
        three("col-xs-3"),
        four("col-xs-4"),
        five("col-xs-5"),
        six("col-xs-6"),
        seven("col-xs-7"),
        eight("col-xs-8"),
        nine("col-xs-9"),
        ten("col-xs-10"),
        eleven("col-xs-11"),
        twelve("col-xs-12");

        private String style;

        OnXSmall(String style) {
            this.style = style;
        }

        public static OnXSmall of(int xsmall) {
            return OnXSmall.valueOf(asNumberString(xsmall));
        }

        public String getStyle() {
            return style;
        }
    }

    private static String asNumberString(int size) {
        switch (size) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            default:
                return "twelve";
        }
    }

}
