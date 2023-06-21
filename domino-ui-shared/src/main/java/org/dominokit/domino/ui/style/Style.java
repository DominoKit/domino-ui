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
package org.dominokit.domino.ui.style;

import static java.util.Objects.nonNull;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.Element;
import java.util.Arrays;
import java.util.function.Predicate;
import jsinterop.base.Js;
import org.dominokit.domino.ui.DominoElementAdapter;
import org.dominokit.domino.ui.IsElement;

/**
 * Style class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Style<E extends Element> implements DominoStyle<E, Style<E>> {

  public final CSSStyleDeclaration style;
  private E element;

  /**
   * Constructor for Style.
   *
   * @param element a E object.
   */
  public Style(E element) {
    this.element = element;
    this.style = Js.<DominoElementAdapter>uncheckedCast(element).style;
  }

  /**
   * of.
   *
   * @param element a E object.
   * @param <E> a E object.
   * @return a {@link org.dominokit.domino.ui.style.Style} object.
   */
  public static <E extends Element> Style<E> of(E element) {
    return new Style<>(element);
  }

  /**
   * of.
   *
   * @param isElement a T object.
   * @param <E> a E object.
   * @param <T> a T object.
   * @return a {@link org.dominokit.domino.ui.style.Style} object.
   */
  public static <E extends Element, T extends IsElement<E>> Style<E> of(T isElement) {
    return new Style<>(isElement.element());
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, String value) {
    style.setProperty(name, value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, Number value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, int value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, double value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, short value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, float value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, boolean value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCssProperty(String name, String value, boolean important) {
    if (important) {
      style.setProperty(name, value, "important");
    } else {
      style.setProperty(name, value);
    }
    return this;
  }

  /** {@inheritDoc} */
  public Style<E> setOrRemoveCssProperty(String name, String value, Predicate<Style<E>> predicate) {
    if (predicate.test(this)) {
      setCssProperty(name, value);
    } else {
      removeCssProperty(name);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> removeCssProperty(String name) {
    style.removeProperty(name);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) {
      element.classList.add(cssClass);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(String... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      element.classList.add(cssClasses);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(CssClass cssClasses) {
    cssClasses.apply(element);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(HasCssClass hasCssClass) {
    addCss(hasCssClass.getCssClass());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(CssClass... cssClasses) {
    Arrays.asList(cssClasses).forEach(this::addCss);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> addCss(HasCssClasses hasCssClasses) {
    addCss(hasCssClasses.getCssClasses());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> removeCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) element.classList.remove(cssClass);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> removeCss(CssClass cssClass) {
    cssClass.remove(element);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> removeCss(HasCssClass hasCssClass) {
    hasCssClass.getCssClass().remove(element);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> removeCss(String... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      // remove(String... arr) is not supported in IE11, so looping over the array solving the
      // problem
      for (String cssClass : cssClasses) {
        removeCss(cssClass);
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> replaceCss(String cssClass, String replacementClass) {
    if (containsCss(cssClass)) {
      removeCss(cssClass);
      addCss(replacementClass);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBorder(String border) {
    setCssProperty("border", border);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBorderColor(String borderColor) {
    setCssProperty("border-color", borderColor);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setWidth(String width) {
    setWidth(width, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setWidth(String width, boolean important) {
    setCssProperty("width", width, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMinWidth(String width) {
    setMinWidth(width, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMinWidth(String width, boolean important) {
    setCssProperty("min-width", width, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMaxWidth(String width) {
    setMaxWidth(width, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMaxWidth(String width, boolean important) {
    setCssProperty("max-width", width, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setHeight(String height) {
    setHeight(height, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setHeight(String height, boolean important) {
    setCssProperty("height", height, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMinHeight(String height) {
    setMinHeight(height, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMinHeight(String height, boolean important) {
    setCssProperty("min-height", height, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMaxHeight(String height) {
    setMaxHeight(height, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMaxHeight(String height, boolean important) {
    setCssProperty("max-height", height, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setTextAlign(String textAlign) {
    setTextAlign(textAlign, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setTextAlign(String textAlign, boolean important) {
    setCssProperty("text-align", textAlign, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setColor(String color) {
    setColor(color, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setColor(String color, boolean important) {
    setCssProperty("color", color, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBackgroundColor(String color) {
    setBackgroundColor(color, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBackgroundColor(String color, boolean important) {
    setCssProperty("background-color", color, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMargin(String margin) {
    setMargin(margin, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMargin(String margin, boolean important) {
    setCssProperty("margin", margin, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginTop(String margin) {
    setMarginTop(margin, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginTop(String margin, boolean important) {
    setCssProperty("margin-top", margin, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginBottom(String margin) {
    setMarginBottom(margin, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginBottom(String margin, boolean important) {
    setCssProperty("margin-bottom", margin, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginLeft(String margin) {
    setMarginLeft(margin, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginLeft(String margin, boolean important) {
    setCssProperty("margin-left", margin, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginRight(String margin) {
    setMarginRight(margin, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setMarginRight(String margin, boolean important) {
    setCssProperty("margin-right", margin, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingRight(String padding) {
    setPaddingRight(padding, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingRight(String padding, boolean important) {
    setCssProperty("padding-right", padding, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingLeft(String padding) {
    setPaddingLeft(padding, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingLeft(String padding, boolean important) {
    setCssProperty("padding-left", padding, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingBottom(String padding) {
    setPaddingBottom(padding, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingBottom(String padding, boolean important) {
    setCssProperty("padding-bottom", padding, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingTop(String padding) {
    setPaddingTop(padding, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPaddingTop(String padding, boolean important) {
    setCssProperty("padding-top", padding, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPadding(String padding) {
    setPadding(padding, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPadding(String padding, boolean important) {
    setCssProperty("padding", padding, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setDisplay(String display) {
    setDisplay(display, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setDisplay(String display, boolean important) {
    setCssProperty("display", display, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setFontSize(String fontSize) {
    setFontSize(fontSize, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setFontSize(String fontSize, boolean important) {
    setCssProperty("font-size", fontSize, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setFloat(String cssFloat) {
    setFloat(cssFloat, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setFloat(String cssFloat, boolean important) {
    setCssProperty("float", cssFloat, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setLineHeight(String lineHeight) {
    setLineHeight(lineHeight, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setLineHeight(String lineHeight, boolean important) {
    setCssProperty("line-height", lineHeight, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlow(String overFlow) {
    setOverFlow(overFlow, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlow(String overFlow, boolean important) {
    setCssProperty("overflow", overFlow, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCursor(String cursor) {
    setCursor(cursor, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setCursor(String cursor, boolean important) {
    setCssProperty("cursor", cursor, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPosition(String position) {
    setPosition(position, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPosition(String position, boolean important) {
    setCssProperty("position", position, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setLeft(String left) {
    setLeft(left, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setLeft(String left, boolean important) {
    setCssProperty("left", left, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setRight(String right) {
    setRight(right, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setRight(String right, boolean important) {
    setCssProperty("right", right, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setTop(String top) {
    setTop(top, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setTop(String top, boolean important) {
    setCssProperty("top", top, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBottom(String bottom) {
    setBottom(bottom, false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBottom(String bottom, boolean important) {
    setCssProperty("bottom", bottom, important);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setZIndex(int zindex) {
    setCssProperty("z-index", zindex + "");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean containsCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) {
      return element.classList.contains(cssClass);
    }
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> alignCenter() {
    addCss(SpacingCss.dui_text_center);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> alignRight() {
    addCss(SpacingCss.dui_text_right);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> cssText(String cssText) {
    style.cssText = cssText;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public int cssClassesCount() {
    return element.classList.length;
  }

  /** {@inheritDoc} */
  @Override
  public String cssClassByIndex(int index) {
    return element.classList.item(index);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setPointerEvents(String pointerEvents) {
    return setCssProperty("pointer-events", pointerEvents);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setAlignItems(String alignItems) {
    return setCssProperty("align-items", alignItems);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlowY(String overflow) {
    return setCssProperty("overflow-y", overflow);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlowY(String overflow, boolean important) {
    return setCssProperty("overflow-y", overflow, important);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlowX(String overflow) {
    return setCssProperty("overflow-x", overflow);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOverFlowX(String overflow, boolean important) {
    return setCssProperty("overflow-x", overflow, important);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setBoxShadow(String boxShadow) {
    return setCssProperty("box-shadow", boxShadow);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setTransitionDuration(String transactionDuration) {
    return setCssProperty("transaction-duration", transactionDuration);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setFlex(String flex) {
    return setCssProperty("flex", flex);
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOpacity(double opacity) {
    return setCssProperty("opacity", opacity + "");
  }

  /** {@inheritDoc} */
  @Override
  public Style<E> setOpacity(double opacity, boolean important) {
    return setCssProperty("opacity", opacity + "", important);
  }
}
