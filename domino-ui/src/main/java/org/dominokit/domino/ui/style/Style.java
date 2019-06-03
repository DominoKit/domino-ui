package org.dominokit.domino.ui.style;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Styles.*;

public class Style<E extends HTMLElement, T extends IsElement<E>> implements IsElement<E> {

    private E element;
    private T wrapperElement;

    public Style(T element) {
        this.element = element.asElement();
        this.wrapperElement = element;

    }

    public static <E extends HTMLElement, T extends IsElement<E>> Style<E, T> of(E htmlElement) {
        return new Style<>((T) (IsElement<E>) () -> htmlElement);
    }

    public static <E extends HTMLElement, T extends IsElement<E>> Style<E, T> of(T htmlElement) {
        return new Style<>(htmlElement);
    }

    public static Style<HTMLBodyElement, IsElement<HTMLBodyElement>> bodyStyle() {
        return Style.of(DomGlobal.document.body);
    }

    public Style<E, T> setProperty(String name, String value) {
        element.style.setProperty(name, value);
        return this;
    }

    public Style<E, T> setProperty(String name, String value, boolean important) {
        if (important) {
            element.style.setProperty(name, value, "important");
        } else {
            element.style.setProperty(name, value);
        }
        return this;
    }

    public Style<E, T> removeProperty(String name) {
        element.style.removeProperty(name);
        return this;
    }

    /**
     * @deprecated use {@link #add(String)}
     */
    @Deprecated
    public Style<E, T> css(String cssClass) {
        return add(cssClass);
    }

    /**
     * @deprecated use {@link #add(String...)}
     */
    public Style<E, T> css(String... cssClasses) {
        return add(cssClasses);
    }

    public Style<E, T> add(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.add(cssClass);
        return this;
    }

    public Style<E, T> add(String... cssClasses) {
        if (nonNull(cssClasses) && cssClasses.length > 0) {
            // add(String... arr) is not supported in IE11, so looping over the array solving the problem
            for (String cssClass : cssClasses) {
                add(cssClass);
            }
        }
        return this;
    }

    /**
     * @deprecated use {@link #remove(String)}
     */
    @Deprecated
    public Style<E, T> removeClass(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.remove(cssClass);
        return this;
    }

    /**
     * @deprecated use {@link #remove(String...)}
     */
    @Deprecated
    public Style<E, T> removeClass(String... cssClasses) {
        if (nonNull(cssClasses) && cssClasses.length > 0)
            element.classList.remove(cssClasses);
        return this;
    }

    /**
     * @deprecated use {@link #replace(String, String)}
     */
    @Deprecated
    public Style<E, T> replaceClass(String cssClass, String replacementClass) {
        if (hasClass(cssClass)) {
            removeClass(cssClass);
            css(replacementClass);
        }
        return this;
    }

    /**
     * @deprecated use {@link #remove(String)}
     */
    @Deprecated
    public Style<E, T> removeCss(String cssClass) {
        return remove(cssClass);
    }

    /**
     * @deprecated use {@link #remove(String...)}
     */
    @Deprecated
    public Style<E, T> removeCss(String... cssClasses) {
        return remove(cssClasses);
    }

    public Style<E, T> remove(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.remove(cssClass);
        return this;
    }

    public Style<E, T> remove(String... cssClasses) {
        if (nonNull(cssClasses) && cssClasses.length > 0) {
            // remove(String... arr) is not supported in IE11, so looping over the array solving the problem
            for (String cssClass : cssClasses) {
                remove(cssClass);
            }
        }
        return this;
    }

    public Style<E, T> replaceCss(String cssClass, String replacementClass) {
        return replace(cssClass, replacementClass);
    }

    public Style<E, T> replace(String cssClass, String replacementClass) {
        if (contains(cssClass)) {
            remove(cssClass);
            add(replacementClass);
        }
        return this;
    }


    public Style<E, T> setBorder(String border) {
        setProperty("border", border);
        return this;
    }

    public Style<E, T> setBorderColor(String borderColor) {
        setProperty("border-color", borderColor);
        return this;
    }

    public Style<E, T> setWidth(String width) {
        setWidth(width, false);
        return this;
    }

    public Style<E, T> setWidth(String width, boolean important) {
        setProperty("width", width, important);
        return this;
    }

    public Style<E, T> setMinWidth(String width) {
        setMinWidth(width, false);
        return this;
    }

    public Style<E, T> setMinWidth(String width, boolean important) {
        setProperty("min-width", width, important);
        return this;
    }

    public Style<E, T> setMaxWidth(String width) {
        setMaxWidth(width, false);
        return this;
    }

    public Style<E, T> setMaxWidth(String width, boolean important) {
        setProperty("max-width", width, important);
        return this;
    }


    public Style<E, T> setHeight(String height) {
        setHeight(height, false);
        return this;
    }

    public Style<E, T> setHeight(String height, boolean important) {
        setProperty("height", height, important);
        return this;
    }

    public Style<E, T> setMinHeight(String height) {
        setMinHeight(height, false);
        return this;
    }

    public Style<E, T> setMinHeight(String height, boolean important) {
        setProperty("min-height", height, important);
        return this;
    }

    public Style<E, T> setMaxHeight(String height) {
        setMaxHeight(height, false);
        return this;
    }

    public Style<E, T> setMaxHeight(String height, boolean important) {
        setProperty("max-height", height, important);
        return this;
    }

    public Style<E, T> setTextAlign(String textAlign) {
        setTextAlign(textAlign, false);
        return this;
    }

    public Style<E, T> setTextAlign(String textAlign, boolean important) {
        setProperty("text-align", textAlign, important);
        return this;
    }

    public Style<E, T> setColor(String color) {
        setColor(color, false);
        return this;
    }

    public Style<E, T> setColor(String color, boolean important) {
        setProperty("color", color, important);
        return this;
    }


    public Style<E, T> setBackgroundColor(String color) {
        setBackgroundColor(color, false);
        return this;
    }

    public Style<E, T> setBackgroundColor(String color, boolean important) {
        setProperty("background-color", color, important);
        return this;
    }

    public Style<E, T> setMargin(String margin) {
        setMargin(margin, false);
        return this;
    }

    public Style<E, T> setMargin(String margin, boolean important) {
        setProperty("margin", margin, important);
        return this;
    }

    public Style<E, T> setMarginTop(String margin) {
        setMarginTop(margin, false);
        return this;
    }

    public Style<E, T> setMarginTop(String margin, boolean important) {
        setProperty("margin-top", margin, important);
        return this;
    }

    public Style<E, T> setMarginBottom(String margin) {
        setMarginBottom(margin, false);
        return this;
    }

    public Style<E, T> setMarginBottom(String margin, boolean important) {
        setProperty("margin-bottom", margin, important);
        return this;
    }

    public Style<E, T> setMarginLeft(String margin) {
        setMarginLeft(margin, false);
        return this;
    }

    public Style<E, T> setMarginLeft(String margin, boolean important) {
        setProperty("margin-left", margin, important);
        return this;
    }

    public Style<E, T> setMarginRight(String margin) {
        setMarginRight(margin, false);
        return this;
    }

    public Style<E, T> setMarginRight(String margin, boolean important) {
        setProperty("margin-right", margin, important);
        return this;
    }

    public Style<E, T> setPaddingRight(String padding) {
        setPaddingRight(padding, false);
        return this;
    }

    public Style<E, T> setPaddingRight(String padding, boolean important) {
        setProperty("padding-right", padding, important);
        return this;
    }

    public Style<E, T> setPaddingLeft(String padding) {
        setPaddingLeft(padding, false);
        return this;
    }

    public Style<E, T> setPaddingLeft(String padding, boolean important) {
        setProperty("padding-left", padding, important);
        return this;
    }


    public Style<E, T> setPaddingBottom(String padding) {
        setPaddingBottom(padding, false);
        return this;
    }

    public Style<E, T> setPaddingBottom(String padding, boolean important) {
        setProperty("padding-bottom", padding, important);
        return this;
    }

    public Style<E, T> setPaddingTop(String padding) {
        setPaddingTop(padding, false);
        return this;
    }

    public Style<E, T> setPaddingTop(String padding, boolean important) {
        setProperty("padding-top", padding, important);
        return this;
    }

    public Style<E, T> setPadding(String padding) {
        setPadding(padding, false);
        return this;
    }

    public Style<E, T> setPadding(String padding, boolean important) {
        setProperty("padding", padding, important);
        return this;
    }

    public Style<E, T> setDisplay(String display) {
        setDisplay(display, false);
        return this;
    }

    public Style<E, T> setDisplay(String display, boolean important) {
        setProperty("display", display, important);
        return this;
    }

    public Style<E, T> setFontSize(String fontSize) {
        setFontSize(fontSize, false);
        return this;
    }

    public Style<E, T> setFontSize(String fontSize, boolean important) {
        setProperty("font-size", fontSize, important);
        return this;
    }

    public Style<E, T> setFloat(String cssFloat) {
        setFloat(cssFloat, false);
        return this;
    }

    public Style<E, T> setFloat(String cssFloat, boolean important) {
        setProperty("float", cssFloat, important);
        return this;
    }

    public Style<E, T> setLineHeight(String lineHeight) {
        setLineHeight(lineHeight, false);
        return this;
    }

    public Style<E, T> setLineHeight(String lineHeight, boolean important) {
        setProperty("line-height", lineHeight, important);
        return this;
    }

    public Style<E, T> setOverFlow(String overFlow) {
        setOverFlow(overFlow, false);
        return this;
    }

    public Style<E, T> setOverFlow(String overFlow, boolean important) {
        setProperty("overflow", overFlow, important);
        return this;
    }

    public Style<E, T> setCursor(String cursor) {
        setCursor(cursor, false);
        return this;
    }

    public Style<E, T> setCursor(String cursor, boolean important) {
        setProperty("cursor", cursor, important);
        return this;
    }

    public Style<E, T> setPosition(String position) {
        setPosition(position, false);
        return this;
    }

    public Style<E, T> setPosition(String position, boolean important) {
        setProperty("position", position, important);
        return this;
    }

    public Style<E, T> setLeft(String left) {
        setLeft(left, false);
        return this;
    }

    public Style<E, T> setLeft(String left, boolean important) {
        setProperty("left", left, important);
        return this;
    }

    public Style<E, T> setRight(String right) {
        setRight(right, false);
        return this;
    }

    public Style<E, T> setRight(String right, boolean important) {
        setProperty("right", right, important);
        return this;
    }

    public Style<E, T> setTop(String top) {
        setTop(top, false);
        return this;
    }

    public Style<E, T> setTop(String top, boolean important) {
        setProperty("top", top, important);
        return this;
    }

    public Style<E, T> setBottom(String bottom) {
        setBottom(bottom, false);
        return this;
    }

    public Style<E, T> setBottom(String bottom, boolean important) {
        setProperty("bottom", bottom, important);
        return this;
    }

    public Style<E, T> setZIndex(int zindex) {
        setProperty("z-index", zindex+"");
        return this;
    }

    /**
     * @deprecated use {@link #contains(String)}
     */
    @Deprecated
    public boolean hasClass(String cssClass) {
        return contains(cssClass);
    }


    public boolean contains(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty()) {
            return element.classList.contains(cssClass);
        }
        return false;
    }

    @Deprecated
    public Style<E, T> removeShadow(boolean important) {
        setProperty("box-shadow", "none", important);
        setProperty("-webkit-box-shadow", "none", important);
        remove(default_shadow);
        return this;
    }

    @Deprecated
    public Style<E, T> removeShadow() {
        setProperty("box-shadow", "none");
        setProperty("-webkit-box-shadow", "none");
        remove(default_shadow);
        return this;
    }

    @Deprecated
    public Style<E, T> addDefaultShadow() {
        add(default_shadow);
        return this;
    }


    public Style<E, T> pullRight() {
        if (!contains(pull_right)) {
            add(pull_right);
        }

        return this;
    }

    public Style<E, T> pullLeft() {
        if (!contains(pull_left)) {
            add(pull_left);
        }

        return this;
    }

    public Style<E, T> alignCenter() {
        if (contains(align_center)) {
            remove(align_center);
        }
        add(align_center);
        return this;
    }

    public Style<E, T> alignRight() {
        if (contains(align_right)) {
            remove(align_right);
        }
        add(align_right);
        return this;
    }

    public Style<E, T> cssText(String cssText) {
        element.style.cssText = cssText;
        return this;
    }

    @Override
    public E asElement() {
        return element;
    }

    public T get() {
        return wrapperElement;
    }


    public int length() {
        return element.classList.length;
    }

    public String item(int index) {
        return element.classList.item(index);
    }

    public Style<E, T> setPointerEvents(String pointerEvents) {
        return setProperty("pointer-events", pointerEvents);
    }

    public Style<E, T> setAlignItems(String alignItems) {
        return setProperty("align-items", alignItems);
    }

    public Style<E, T> setOverFlowY(String overflow) {
        return setProperty("overflow-y", overflow);
    }

    public Style<E, T> setBoxShadow(String boxShadow) {
        return setProperty("box-shadow", boxShadow);
    }

    public Style<E, T> setTransitionDuration(String transactionDuration) {
        return setProperty("transaction-duration", transactionDuration);
    }

    public Style<E, T> setFlex(String flex) {
        return setProperty("flex", flex);
    }
}
