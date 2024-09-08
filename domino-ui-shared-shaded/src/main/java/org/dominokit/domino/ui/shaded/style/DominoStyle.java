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
package org.dominokit.domino.ui.shaded.style;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public interface DominoStyle<E extends HTMLElement, T extends IsElement<E>, R> {
  @Deprecated
  default R setProperty(String name, String value) {
    return setCssProperty(name, value);
  }

  R setCssProperty(String name, String value);

  @Deprecated
  default R setProperty(String name, String value, boolean important) {
    return setCssProperty(name, value, important);
  }

  R setCssProperty(String name, String value, boolean important);

  @Deprecated
  default R removeProperty(String name) {
    return removeCssProperty(name);
  }

  R removeCssProperty(String name);

  @Deprecated
  default R add(String cssClass) {
    return addCss(cssClass);
  }

  R addCss(String cssClass);

  @Deprecated
  default R add(String... cssClasses) {
    return addCss(cssClasses);
  }

  R addCss(String... cssClasses);

  @Deprecated
  default R remove(String cssClass) {
    return removeCss(cssClass);
  }

  R removeCss(String cssClass);

  @Deprecated
  default R remove(String... cssClasses) {
    return removeCss(cssClasses);
  }

  R removeCss(String... cssClasses);

  R replaceCss(String cssClass, String replacementClass);

  @Deprecated
  default R replace(String cssClass, String replacementClass) {
    return removeCss(cssClass, replacementClass);
  }

  R setBorder(String border);

  R setBorderColor(String borderColor);

  R setWidth(String width);

  R setWidth(String width, boolean important);

  R setMinWidth(String width);

  R setMinWidth(String width, boolean important);

  R setMaxWidth(String width);

  R setMaxWidth(String width, boolean important);

  R setHeight(String height);

  R setHeight(String height, boolean important);

  R setMinHeight(String height);

  R setMinHeight(String height, boolean important);

  R setMaxHeight(String height);

  R setMaxHeight(String height, boolean important);

  R setTextAlign(String textAlign);

  R setTextAlign(String textAlign, boolean important);

  R setColor(String color);

  R setColor(String color, boolean important);

  R setBackgroundColor(String color);

  R setBackgroundColor(String color, boolean important);

  R setMargin(String margin);

  R setMargin(String margin, boolean important);

  R setMarginTop(String margin);

  R setMarginTop(String margin, boolean important);

  R setMarginBottom(String margin);

  R setMarginBottom(String margin, boolean important);

  R setMarginLeft(String margin);

  R setMarginLeft(String margin, boolean important);

  R setMarginRight(String margin);

  R setMarginRight(String margin, boolean important);

  R setPaddingRight(String padding);

  R setPaddingRight(String padding, boolean important);

  R setPaddingLeft(String padding);

  R setPaddingLeft(String padding, boolean important);

  R setPaddingBottom(String padding);

  R setPaddingBottom(String padding, boolean important);

  R setPaddingTop(String padding);

  R setPaddingTop(String padding, boolean important);

  R setPadding(String padding);

  R setPadding(String padding, boolean important);

  R setDisplay(String display);

  R setDisplay(String display, boolean important);

  R setFontSize(String fontSize);

  R setFontSize(String fontSize, boolean important);

  R setFloat(String cssFloat);

  R setFloat(String cssFloat, boolean important);

  R setLineHeight(String lineHeight);

  R setLineHeight(String lineHeight, boolean important);

  R setOverFlow(String overFlow);

  R setOverFlow(String overFlow, boolean important);

  R setCursor(String cursor);

  R setCursor(String cursor, boolean important);

  R setPosition(String position);

  R setPosition(String position, boolean important);

  R setLeft(String left);

  R setLeft(String left, boolean important);

  R setRight(String right);

  R setRight(String right, boolean important);

  R setTop(String top);

  R setTop(String top, boolean important);

  R setBottom(String bottom);

  R setBottom(String bottom, boolean important);

  R setZIndex(int zindex);

  R setOpacity(double opacity);

  R setOpacity(double opacity, boolean important);

  @Deprecated
  default boolean contains(String cssClass) {
    return containsCss(cssClass);
  }

  boolean containsCss(String cssClass);

  R pullRight();

  R pullLeft();

  R alignCenter();

  R alignRight();

  R cssText(String cssText);

  /**
   * @return the count of applied css classes
   * @deprecated use {@link #cssClassesCount()}
   */
  @Deprecated
  int length();

  int cssClassesCount();

  /**
   * @param index of css class
   * @return name of the css class at that index
   * @deprecated use {@link #cssClassByIndex(int)}
   */
  @Deprecated
  default String item(int index) {
    return cssClassByIndex(index);
  }

  String cssClassByIndex(int index);

  R setPointerEvents(String pointerEvents);

  R setAlignItems(String alignItems);

  R setOverFlowY(String overflow);

  R setOverFlowY(String overflow, boolean important);

  R setOverFlowX(String overflow);

  R setOverFlowX(String overflow, boolean important);

  R setBoxShadow(String boxShadow);

  R setTransitionDuration(String transactionDuration);

  R setFlex(String flex);
}
