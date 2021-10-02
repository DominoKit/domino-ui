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
import static org.dominokit.domino.ui.style.Styles.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public class Style<E extends HTMLElement, T extends IsElement<E>>
    implements IsElement<E>, DominoStyle<E, T, Style<E, T>> {

  private E element;
  private T wrapperElement;

  public Style(T element) {
    this.element = element.element();
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

  /**
   * @deprecated use {@link #setCssProperty(String, String)}
   * @param name css property name
   * @param value css property value
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> setProperty(String name, String value) {
    return setCssProperty(name, value);
  }

  /**
   * @param name css property name
   * @param value css property value
   * @return same style instance
   */
  @Override
  public Style<E, T> setCssProperty(String name, String value) {
    element.style.setProperty(name, value);
    return this;
  }

  /**
   * @deprecated use {@link #setCssProperty(String, String, boolean)}
   * @param name css property name
   * @param value css property value
   * @param important if true adds !important
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> setProperty(String name, String value, boolean important) {
    return setCssProperty(name, value, important);
  }

  /**
   * @param name css property name
   * @param value css property value
   * @param important if true adds !important
   * @return same style instance
   */
  @Override
  public Style<E, T> setCssProperty(String name, String value, boolean important) {
    if (important) {
      element.style.setProperty(name, value, "important");
    } else {
      element.style.setProperty(name, value);
    }
    return this;
  }

  /**
   * @deprecated use {@link #removeCssProperty(String)}
   * @param name css property name
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> removeProperty(String name) {
    return removeCssProperty(name);
  }

  /**
   * @param name css property name
   * @return same style instance
   */
  @Override
  public Style<E, T> removeCssProperty(String name) {
    element.style.removeProperty(name);
    return this;
  }

  /**
   * @deprecated use {@link #addCss(String)}
   * @param cssClass css class name
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> add(String cssClass) {
    return addCss(cssClass);
  }

  /**
   * @param cssClass css class name
   * @return same style instance
   */
  @Override
  public Style<E, T> addCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) element.classList.add(cssClass);
    return this;
  }

  /**
   * @deprecated use {@link #addCss(String...)}
   * @param cssClasses css classes names
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> add(String... cssClasses) {
    return addCss(cssClasses);
  }

  /**
   * @param cssClasses css classes names
   * @return same style instance
   */
  @Override
  public Style<E, T> addCss(String... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      // add(String... arr) is not supported in IE11, so looping over the array solving the problem
      for (String cssClass : cssClasses) {
        addCss(cssClass);
      }
    }
    return this;
  }

  /**
   * @deprecated use {@link #removeCss(String)}
   * @param cssClass css class name
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> remove(String cssClass) {
    return removeCss(cssClass);
  }
  /**
   * @param cssClass css class name
   * @return same style instance
   */
  @Override
  public Style<E, T> removeCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) element.classList.remove(cssClass);
    return this;
  }

  /**
   * @deprecated use {@link #removeCss(String...)}
   * @param cssClasses css classes names
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> remove(String... cssClasses) {
    return removeCss(cssClasses);
  }

  /**
   * @param cssClasses css classes names
   * @return same style instance
   */
  @Override
  public Style<E, T> removeCss(String... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      // remove(String... arr) is not supported in IE11, so looping over the array solving the
      // problem
      for (String cssClass : cssClasses) {
        removeCss(cssClass);
      }
    }
    return this;
  }

  /**
   * @param cssClass css class name to be removed
   * @param replacementClass cdd class name to be added
   * @return same style instance
   */
  @Override
  public Style<E, T> replaceCss(String cssClass, String replacementClass) {
    if (contains(cssClass)) {
      removeCss(cssClass);
      addCss(replacementClass);
    }
    return this;
  }

  /**
   * @deprecated use {@link #replaceCss(String, String)}
   * @param cssClass css class name to be removed
   * @param replacementClass cdd class name to be added
   * @return same style instance
   */
  @Deprecated
  @Override
  public Style<E, T> replace(String cssClass, String replacementClass) {
    return replaceCss(cssClass, replacementClass);
  }

  @Override
  public Style<E, T> setBorder(String border) {
    setCssProperty("border", border);
    return this;
  }

  @Override
  public Style<E, T> setBorderColor(String borderColor) {
    setCssProperty("border-color", borderColor);
    return this;
  }

  @Override
  public Style<E, T> setWidth(String width) {
    setWidth(width, false);
    return this;
  }

  @Override
  public Style<E, T> setWidth(String width, boolean important) {
    setCssProperty("width", width, important);
    return this;
  }

  @Override
  public Style<E, T> setMinWidth(String width) {
    setMinWidth(width, false);
    return this;
  }

  @Override
  public Style<E, T> setMinWidth(String width, boolean important) {
    setCssProperty("min-width", width, important);
    return this;
  }

  @Override
  public Style<E, T> setMaxWidth(String width) {
    setMaxWidth(width, false);
    return this;
  }

  @Override
  public Style<E, T> setMaxWidth(String width, boolean important) {
    setCssProperty("max-width", width, important);
    return this;
  }

  @Override
  public Style<E, T> setHeight(String height) {
    setHeight(height, false);
    return this;
  }

  @Override
  public Style<E, T> setHeight(String height, boolean important) {
    setCssProperty("height", height, important);
    return this;
  }

  @Override
  public Style<E, T> setMinHeight(String height) {
    setMinHeight(height, false);
    return this;
  }

  @Override
  public Style<E, T> setMinHeight(String height, boolean important) {
    setCssProperty("min-height", height, important);
    return this;
  }

  @Override
  public Style<E, T> setMaxHeight(String height) {
    setMaxHeight(height, false);
    return this;
  }

  @Override
  public Style<E, T> setMaxHeight(String height, boolean important) {
    setCssProperty("max-height", height, important);
    return this;
  }

  @Override
  public Style<E, T> setTextAlign(String textAlign) {
    setTextAlign(textAlign, false);
    return this;
  }

  @Override
  public Style<E, T> setTextAlign(String textAlign, boolean important) {
    setCssProperty("text-align", textAlign, important);
    return this;
  }

  @Override
  public Style<E, T> setColor(String color) {
    setColor(color, false);
    return this;
  }

  @Override
  public Style<E, T> setColor(String color, boolean important) {
    setCssProperty("color", color, important);
    return this;
  }

  @Override
  public Style<E, T> setBackgroundColor(String color) {
    setBackgroundColor(color, false);
    return this;
  }

  @Override
  public Style<E, T> setBackgroundColor(String color, boolean important) {
    setCssProperty("background-color", color, important);
    return this;
  }

  @Override
  public Style<E, T> setMargin(String margin) {
    setMargin(margin, false);
    return this;
  }

  @Override
  public Style<E, T> setMargin(String margin, boolean important) {
    setCssProperty("margin", margin, important);
    return this;
  }

  @Override
  public Style<E, T> setMarginTop(String margin) {
    setMarginTop(margin, false);
    return this;
  }

  @Override
  public Style<E, T> setMarginTop(String margin, boolean important) {
    setCssProperty("margin-top", margin, important);
    return this;
  }

  @Override
  public Style<E, T> setMarginBottom(String margin) {
    setMarginBottom(margin, false);
    return this;
  }

  @Override
  public Style<E, T> setMarginBottom(String margin, boolean important) {
    setCssProperty("margin-bottom", margin, important);
    return this;
  }

  @Override
  public Style<E, T> setMarginLeft(String margin) {
    setMarginLeft(margin, false);
    return this;
  }

  @Override
  public Style<E, T> setMarginLeft(String margin, boolean important) {
    setCssProperty("margin-left", margin, important);
    return this;
  }

  @Override
  public Style<E, T> setMarginRight(String margin) {
    setMarginRight(margin, false);
    return this;
  }

  @Override
  public Style<E, T> setMarginRight(String margin, boolean important) {
    setCssProperty("margin-right", margin, important);
    return this;
  }

  @Override
  public Style<E, T> setPaddingRight(String padding) {
    setPaddingRight(padding, false);
    return this;
  }

  @Override
  public Style<E, T> setPaddingRight(String padding, boolean important) {
    setCssProperty("padding-right", padding, important);
    return this;
  }

  @Override
  public Style<E, T> setPaddingLeft(String padding) {
    setPaddingLeft(padding, false);
    return this;
  }

  @Override
  public Style<E, T> setPaddingLeft(String padding, boolean important) {
    setCssProperty("padding-left", padding, important);
    return this;
  }

  @Override
  public Style<E, T> setPaddingBottom(String padding) {
    setPaddingBottom(padding, false);
    return this;
  }

  @Override
  public Style<E, T> setPaddingBottom(String padding, boolean important) {
    setCssProperty("padding-bottom", padding, important);
    return this;
  }

  @Override
  public Style<E, T> setPaddingTop(String padding) {
    setPaddingTop(padding, false);
    return this;
  }

  @Override
  public Style<E, T> setPaddingTop(String padding, boolean important) {
    setCssProperty("padding-top", padding, important);
    return this;
  }

  @Override
  public Style<E, T> setPadding(String padding) {
    setPadding(padding, false);
    return this;
  }

  @Override
  public Style<E, T> setPadding(String padding, boolean important) {
    setCssProperty("padding", padding, important);
    return this;
  }

  @Override
  public Style<E, T> setDisplay(String display) {
    setDisplay(display, false);
    return this;
  }

  @Override
  public Style<E, T> setDisplay(String display, boolean important) {
    setCssProperty("display", display, important);
    return this;
  }

  @Override
  public Style<E, T> setFontSize(String fontSize) {
    setFontSize(fontSize, false);
    return this;
  }

  @Override
  public Style<E, T> setFontSize(String fontSize, boolean important) {
    setCssProperty("font-size", fontSize, important);
    return this;
  }

  @Override
  public Style<E, T> setFloat(String cssFloat) {
    setFloat(cssFloat, false);
    return this;
  }

  @Override
  public Style<E, T> setFloat(String cssFloat, boolean important) {
    setCssProperty("float", cssFloat, important);
    return this;
  }

  @Override
  public Style<E, T> setLineHeight(String lineHeight) {
    setLineHeight(lineHeight, false);
    return this;
  }

  @Override
  public Style<E, T> setLineHeight(String lineHeight, boolean important) {
    setCssProperty("line-height", lineHeight, important);
    return this;
  }

  @Override
  public Style<E, T> setOverFlow(String overFlow) {
    setOverFlow(overFlow, false);
    return this;
  }

  @Override
  public Style<E, T> setOverFlow(String overFlow, boolean important) {
    setCssProperty("overflow", overFlow, important);
    return this;
  }

  @Override
  public Style<E, T> setCursor(String cursor) {
    setCursor(cursor, false);
    return this;
  }

  @Override
  public Style<E, T> setCursor(String cursor, boolean important) {
    setCssProperty("cursor", cursor, important);
    return this;
  }

  @Override
  public Style<E, T> setPosition(String position) {
    setPosition(position, false);
    return this;
  }

  @Override
  public Style<E, T> setPosition(String position, boolean important) {
    setCssProperty("position", position, important);
    return this;
  }

  @Override
  public Style<E, T> setLeft(String left) {
    setLeft(left, false);
    return this;
  }

  @Override
  public Style<E, T> setLeft(String left, boolean important) {
    setCssProperty("left", left, important);
    return this;
  }

  @Override
  public Style<E, T> setRight(String right) {
    setRight(right, false);
    return this;
  }

  @Override
  public Style<E, T> setRight(String right, boolean important) {
    setCssProperty("right", right, important);
    return this;
  }

  @Override
  public Style<E, T> setTop(String top) {
    setTop(top, false);
    return this;
  }

  @Override
  public Style<E, T> setTop(String top, boolean important) {
    setCssProperty("top", top, important);
    return this;
  }

  @Override
  public Style<E, T> setBottom(String bottom) {
    setBottom(bottom, false);
    return this;
  }

  @Override
  public Style<E, T> setBottom(String bottom, boolean important) {
    setCssProperty("bottom", bottom, important);
    return this;
  }

  @Override
  public Style<E, T> setZIndex(int zindex) {
    setCssProperty("z-index", zindex + "");
    return this;
  }

  @Override
  public boolean contains(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) {
      return element.classList.contains(cssClass);
    }
    return false;
  }

  @Override
  public Style<E, T> pullRight() {
    if (!contains(pull_right)) {
      addCss(pull_right);
    }

    return this;
  }

  @Override
  public Style<E, T> pullLeft() {
    if (!contains(pull_left)) {
      addCss(pull_left);
    }

    return this;
  }

  @Override
  public Style<E, T> alignCenter() {
    if (contains(align_center)) {
      removeCss(align_center);
    }
    addCss(align_center);
    return this;
  }

  @Override
  public Style<E, T> alignRight() {
    if (contains(align_right)) {
      removeCss(align_right);
    }
    addCss(align_right);
    return this;
  }

  @Override
  public Style<E, T> cssText(String cssText) {
    element.style.cssText = cssText;
    return this;
  }

  @Override
  public E element() {
    return element;
  }

  public T get() {
    return wrapperElement;
  }

  /** {@inheritDoc} */
  @Override
  @Deprecated
  public int length() {
    return cssClassesCount();
  }

  @Override
  public int cssClassesCount() {
    return element.classList.length;
  }

  /** {@inheritDoc} */
  @Override
  @Deprecated
  public String item(int index) {
    return cssClassByIndex(index);
  }

  @Override
  public String cssClassByIndex(int index) {
    return element.classList.item(index);
  }

  @Override
  public Style<E, T> setPointerEvents(String pointerEvents) {
    return setCssProperty("pointer-events", pointerEvents);
  }

  @Override
  public Style<E, T> setAlignItems(String alignItems) {
    return setCssProperty("align-items", alignItems);
  }

  @Override
  public Style<E, T> setOverFlowY(String overflow) {
    return setCssProperty("overflow-y", overflow);
  }

  @Override
  public Style<E, T> setBoxShadow(String boxShadow) {
    return setCssProperty("box-shadow", boxShadow);
  }

  @Override
  public Style<E, T> setTransitionDuration(String transactionDuration) {
    return setCssProperty("transaction-duration", transactionDuration);
  }

  @Override
  public Style<E, T> setFlex(String flex) {
    return setCssProperty("flex", flex);
  }

  @Override
  public Style<E, T> setOpacity(double opacity) {
    return setCssProperty("opacity", opacity + "");
  }

  @Override
  public Style<E, T> setOpacity(double opacity, boolean important) {
    return setCssProperty("opacity", opacity + "", important);
  }
}
