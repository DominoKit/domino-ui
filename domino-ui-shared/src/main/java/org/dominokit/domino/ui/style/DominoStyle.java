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

import elemental2.dom.Element;
import java.util.function.Predicate;

/** DominoStyle interface. */
public interface DominoStyle<E extends Element, R> {
  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a {@link java.lang.String} object.
   * @return a R object.
   */
  R setCssProperty(String name, String value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a {@link java.lang.Number} object.
   * @return a R object.
   */
  R setCssProperty(String name, Number value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a int.
   * @return a R object.
   */
  R setCssProperty(String name, int value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a double.
   * @return a R object.
   */
  R setCssProperty(String name, double value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a short.
   * @return a R object.
   */
  R setCssProperty(String name, short value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a float.
   * @return a R object.
   */
  R setCssProperty(String name, float value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a boolean.
   * @return a R object.
   */
  R setCssProperty(String name, boolean value);

  /**
   * setCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setCssProperty(String name, String value, boolean important);

  /**
   * setOrRemoveCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a {@link java.lang.String} object.
   * @param predicate a {@link java.util.function.Predicate} object.
   * @return a R object.
   */
  R setOrRemoveCssProperty(String name, String value, Predicate<R> predicate);

  /**
   * removeCssProperty.
   *
   * @param name a {@link java.lang.String} object.
   * @return a R object.
   */
  R removeCssProperty(String name);

  /**
   * addCss.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a R object.
   */
  R addCss(String cssClass);

  /**
   * addCss.
   *
   * @param cssClasses a {@link java.lang.String} object.
   * @return a R object.
   */
  R addCss(String... cssClasses);

  /**
   * addCss.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a R object.
   */
  R addCss(CssClass cssClass);

  /**
   * addCss.
   *
   * @param hasCssClass a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a R object.
   */
  R addCss(HasCssClass hasCssClass);

  /**
   * addCss.
   *
   * @param cssClasses a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a R object.
   */
  R addCss(CssClass... cssClasses);

  /**
   * addCss.
   *
   * @param hasCssClasses a {@link org.dominokit.domino.ui.style.HasCssClasses} object.
   * @return a R object.
   */
  R addCss(HasCssClasses hasCssClasses);

  /**
   * removeCss.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a R object.
   */
  R removeCss(String cssClass);

  /**
   * removeCss.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a R object.
   */
  R removeCss(CssClass cssClass);

  /**
   * removeCss.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a R object.
   */
  R removeCss(HasCssClass cssClass);

  /**
   * removeCss.
   *
   * @param cssClasses a {@link java.lang.String} object.
   * @return a R object.
   */
  R removeCss(String... cssClasses);

  /**
   * removeCss.
   *
   * @param cssClasses a {@link java.lang.String} object.
   * @return a R object.
   */
  R removeCss(CssClass... cssClasses);

  /**
   * replaceCss.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @param replacementClass a {@link java.lang.String} object.
   * @return a R object.
   */
  R replaceCss(String cssClass, String replacementClass);

  /**
   * setBorder.
   *
   * @param border a {@link java.lang.String} object.
   * @return a R object.
   */
  R setBorder(String border);

  /**
   * setBorderColor.
   *
   * @param borderColor a {@link java.lang.String} object.
   * @return a R object.
   */
  R setBorderColor(String borderColor);

  /**
   * setWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @return a R object.
   */
  R setWidth(String width);

  /**
   * setWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setWidth(String width, boolean important);

  /**
   * setMinWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMinWidth(String width);

  /**
   * setMinWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMinWidth(String width, boolean important);

  /**
   * setMaxWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMaxWidth(String width);

  /**
   * setMaxWidth.
   *
   * @param width a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMaxWidth(String width, boolean important);

  /**
   * setHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @return a R object.
   */
  R setHeight(String height);

  /**
   * setHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setHeight(String height, boolean important);

  /**
   * setMinHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMinHeight(String height);

  /**
   * setMinHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMinHeight(String height, boolean important);

  /**
   * setMaxHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMaxHeight(String height);

  /**
   * setMaxHeight.
   *
   * @param height a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMaxHeight(String height, boolean important);

  /**
   * setTextAlign.
   *
   * @param textAlign a {@link java.lang.String} object.
   * @return a R object.
   */
  R setTextAlign(String textAlign);

  /**
   * setTextAlign.
   *
   * @param textAlign a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setTextAlign(String textAlign, boolean important);

  /**
   * setColor.
   *
   * @param color a {@link java.lang.String} object.
   * @return a R object.
   */
  R setColor(String color);

  /**
   * setColor.
   *
   * @param color a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setColor(String color, boolean important);

  /**
   * setBackgroundColor.
   *
   * @param color a {@link java.lang.String} object.
   * @return a R object.
   */
  R setBackgroundColor(String color);

  /**
   * setBackgroundColor.
   *
   * @param color a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setBackgroundColor(String color, boolean important);

  /**
   * setMargin.
   *
   * @param margin a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMargin(String margin);

  /**
   * setMargin.
   *
   * @param margin a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMargin(String margin, boolean important);

  /**
   * setMarginTop.
   *
   * @param margin a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMarginTop(String margin);

  /**
   * setMarginTop.
   *
   * @param margin a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMarginTop(String margin, boolean important);

  /**
   * setMarginBottom.
   *
   * @param margin a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMarginBottom(String margin);

  /**
   * setMarginBottom.
   *
   * @param margin a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMarginBottom(String margin, boolean important);

  /**
   * setMarginLeft.
   *
   * @param margin a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMarginLeft(String margin);

  /**
   * setMarginLeft.
   *
   * @param margin a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMarginLeft(String margin, boolean important);

  /**
   * setMarginRight.
   *
   * @param margin a {@link java.lang.String} object.
   * @return a R object.
   */
  R setMarginRight(String margin);

  /**
   * setMarginRight.
   *
   * @param margin a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setMarginRight(String margin, boolean important);

  /**
   * setPaddingRight.
   *
   * @param padding a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPaddingRight(String padding);

  /**
   * setPaddingRight.
   *
   * @param padding a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPaddingRight(String padding, boolean important);

  /**
   * setPaddingLeft.
   *
   * @param padding a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPaddingLeft(String padding);

  /**
   * setPaddingLeft.
   *
   * @param padding a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPaddingLeft(String padding, boolean important);

  /**
   * setPaddingBottom.
   *
   * @param padding a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPaddingBottom(String padding);

  /**
   * setPaddingBottom.
   *
   * @param padding a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPaddingBottom(String padding, boolean important);

  /**
   * setPaddingTop.
   *
   * @param padding a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPaddingTop(String padding);

  /**
   * setPaddingTop.
   *
   * @param padding a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPaddingTop(String padding, boolean important);

  /**
   * setPadding.
   *
   * @param padding a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPadding(String padding);

  /**
   * setPadding.
   *
   * @param padding a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPadding(String padding, boolean important);

  /**
   * setDisplay.
   *
   * @param display a {@link java.lang.String} object.
   * @return a R object.
   */
  R setDisplay(String display);

  /**
   * setDisplay.
   *
   * @param display a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setDisplay(String display, boolean important);

  /**
   * setFontSize.
   *
   * @param fontSize a {@link java.lang.String} object.
   * @return a R object.
   */
  R setFontSize(String fontSize);

  /**
   * setFontSize.
   *
   * @param fontSize a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setFontSize(String fontSize, boolean important);

  /**
   * setFloat.
   *
   * @param cssFloat a {@link java.lang.String} object.
   * @return a R object.
   */
  R setFloat(String cssFloat);

  /**
   * setFloat.
   *
   * @param cssFloat a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setFloat(String cssFloat, boolean important);

  /**
   * setLineHeight.
   *
   * @param lineHeight a {@link java.lang.String} object.
   * @return a R object.
   */
  R setLineHeight(String lineHeight);

  /**
   * setLineHeight.
   *
   * @param lineHeight a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setLineHeight(String lineHeight, boolean important);

  /**
   * setOverFlow.
   *
   * @param overFlow a {@link java.lang.String} object.
   * @return a R object.
   */
  R setOverFlow(String overFlow);

  /**
   * setOverFlow.
   *
   * @param overFlow a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setOverFlow(String overFlow, boolean important);

  /**
   * setCursor.
   *
   * @param cursor a {@link java.lang.String} object.
   * @return a R object.
   */
  R setCursor(String cursor);

  /**
   * setCursor.
   *
   * @param cursor a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setCursor(String cursor, boolean important);

  /**
   * setPosition.
   *
   * @param position a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPosition(String position);

  /**
   * setPosition.
   *
   * @param position a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setPosition(String position, boolean important);

  /**
   * setLeft.
   *
   * @param left a {@link java.lang.String} object.
   * @return a R object.
   */
  R setLeft(String left);

  /**
   * setLeft.
   *
   * @param left a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setLeft(String left, boolean important);

  /**
   * setRight.
   *
   * @param right a {@link java.lang.String} object.
   * @return a R object.
   */
  R setRight(String right);

  /**
   * setRight.
   *
   * @param right a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setRight(String right, boolean important);

  /**
   * setTop.
   *
   * @param top a {@link java.lang.String} object.
   * @return a R object.
   */
  R setTop(String top);

  /**
   * setTop.
   *
   * @param top a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setTop(String top, boolean important);

  /**
   * setBottom.
   *
   * @param bottom a {@link java.lang.String} object.
   * @return a R object.
   */
  R setBottom(String bottom);

  /**
   * setBottom.
   *
   * @param bottom a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setBottom(String bottom, boolean important);

  /**
   * setZIndex.
   *
   * @param zindex a int.
   * @return a R object.
   */
  R setZIndex(int zindex);

  /**
   * setOpacity.
   *
   * @param opacity a double.
   * @return a R object.
   */
  R setOpacity(double opacity);

  /**
   * setOpacity.
   *
   * @param opacity a double.
   * @param important a boolean.
   * @return a R object.
   */
  R setOpacity(double opacity, boolean important);

  /**
   * containsCss.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a boolean.
   */
  boolean containsCss(String cssClass);

  /**
   * alignCenter.
   *
   * @return a R object.
   */
  R alignCenter();

  /**
   * alignRight.
   *
   * @return a R object.
   */
  R alignRight();

  /**
   * cssText.
   *
   * @param cssText a {@link java.lang.String} object.
   * @return a R object.
   */
  R cssText(String cssText);

  /**
   * cssClassesCount.
   *
   * @return a int.
   */
  int cssClassesCount();

  /**
   * cssClassByIndex.
   *
   * @param index a int.
   * @return a {@link java.lang.String} object.
   */
  String cssClassByIndex(int index);

  /**
   * setPointerEvents.
   *
   * @param pointerEvents a {@link java.lang.String} object.
   * @return a R object.
   */
  R setPointerEvents(String pointerEvents);

  /**
   * setAlignItems.
   *
   * @param alignItems a {@link java.lang.String} object.
   * @return a R object.
   */
  R setAlignItems(String alignItems);

  /**
   * setOverFlowY.
   *
   * @param overflow a {@link java.lang.String} object.
   * @return a R object.
   */
  R setOverFlowY(String overflow);

  /**
   * setOverFlowY.
   *
   * @param overflow a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setOverFlowY(String overflow, boolean important);

  /**
   * setOverFlowX.
   *
   * @param overflow a {@link java.lang.String} object.
   * @return a R object.
   */
  R setOverFlowX(String overflow);

  /**
   * setOverFlowX.
   *
   * @param overflow a {@link java.lang.String} object.
   * @param important a boolean.
   * @return a R object.
   */
  R setOverFlowX(String overflow, boolean important);

  /**
   * setBoxShadow.
   *
   * @param boxShadow a {@link java.lang.String} object.
   * @return a R object.
   */
  R setBoxShadow(String boxShadow);

  /**
   * setTransitionDuration.
   *
   * @param transactionDuration a {@link java.lang.String} object.
   * @return a R object.
   */
  R setTransitionDuration(String transactionDuration);

  /**
   * setFlex.
   *
   * @param flex a {@link java.lang.String} object.
   * @return a R object.
   */
  R setFlex(String flex);
}
