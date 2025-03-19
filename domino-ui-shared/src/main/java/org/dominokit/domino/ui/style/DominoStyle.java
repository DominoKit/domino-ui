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

/**
 * Interface to represent the various CSS styles that can be applied to a DOM {@link Element}. It
 * provides a fluent API for applying and manipulating the styles of elements.
 *
 * @param <E> The type of DOM element this style applies to.
 * @param <R> The return type after applying a style, typically an instance of the element's type or
 *     a subclass.
 */
public interface DominoStyle<E extends Element, R> {

  /**
   * Sets a CSS property with the given name and string value.
   *
   * @param property {@link CssProperty}
   * @return The updated style.
   */
  R setCssProperty(CssProperty property);

  /**
   * Sets a CSS property with the given name and string value.
   *
   * @param name The name of the CSS property.
   * @param value The string value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, String value);

  /**
   * Sets a CSS property with the given name and {@link Number} value.
   *
   * @param name The name of the CSS property.
   * @param value The {@link Number} value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, Number value);

  /**
   * Sets a CSS property with the given name and integer value.
   *
   * @param name The name of the CSS property.
   * @param value The integer value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, int value);

  /**
   * Sets a CSS property with the given name and double value.
   *
   * @param name The name of the CSS property.
   * @param value The double value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, double value);

  /**
   * Sets a CSS property with the given name and short value.
   *
   * @param name The name of the CSS property.
   * @param value The short value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, short value);

  /**
   * Sets a CSS property with the given name and float value.
   *
   * @param name The name of the CSS property.
   * @param value The float value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, float value);

  /**
   * Sets a CSS property with the given name and boolean value.
   *
   * @param name The name of the CSS property.
   * @param value The boolean value for the CSS property.
   * @return The updated style.
   */
  R setCssProperty(String name, boolean value);

  /**
   * Sets a CSS property with the given name and value. Additionally, allows to mark the property as
   * important.
   *
   * @param name The name of the CSS property.
   * @param value The string value for the CSS property.
   * @param important If true, the property will be marked as important in the style.
   * @return The updated style.
   */
  R setCssProperty(String name, String value, boolean important);

  /**
   * Sets or removes a CSS property based on the result of the provided predicate.
   *
   * @param name The name of the CSS property.
   * @param value The string value for the CSS property.
   * @param predicate A predicate to determine if the property should be set or removed.
   * @return The updated style if the predicate returns true; otherwise, the original style without
   *     the property.
   */
  R setOrRemoveCssProperty(String name, String value, Predicate<R> predicate);

  /**
   * Removes the CSS property with the given name.
   *
   * @param name The name of the CSS property to be removed.
   * @return The updated style without the specified property.
   */
  R removeCssProperty(String name);

  /**
   * Adds a CSS class to the element.
   *
   * @param cssClass The CSS class to add.
   * @return The updated style.
   */
  R addCss(String cssClass);

  /**
   * Adds one or more CSS classes to the style.
   *
   * @param cssClasses The array of CSS class names to be added.
   * @return The updated style with the added CSS classes.
   */
  R addCss(String... cssClasses);

  /**
   * Adds a CSS class to the style using a {@code CssClass} object.
   *
   * @param cssClass The {@link CssClass} object representing the CSS class to be added.
   * @return The updated style with the added CSS class.
   */
  R addCss(CssClass cssClass);

  /**
   * Adds a CSS class to the style using an object that implements the {@code HasCssClass}
   * interface.
   *
   * @param hasCssClass The {@link HasCssClass} object providing the CSS class to be added.
   * @return The updated style with the added CSS class.
   */
  R addCss(HasCssClass hasCssClass);

  /**
   * Adds multiple CSS classes to the style using an array of {@code CssClass} objects.
   *
   * @param cssClasses An array of {@link CssClass} objects representing the CSS classes to be
   *     added.
   * @return The updated style with the added CSS classes.
   */
  R addCss(CssClass... cssClasses);

  /**
   * Adds multiple CSS classes to the style using an object that implements the {@code
   * HasCssClasses} interface.
   *
   * @param hasCssClasses The {@link HasCssClasses} object providing the collection of CSS classes
   *     to be added.
   * @return The updated style with the added CSS classes.
   */
  R addCss(HasCssClasses hasCssClasses);

  /**
   * Removes a CSS class from the element.
   *
   * @param cssClass The CSS class to remove.
   * @return The updated style.
   */
  R removeCss(String cssClass);

  /**
   * Removes a specific CSS class from the style using a {@code CssClass} object.
   *
   * @param cssClass The {@link CssClass} object representing the CSS class to be removed.
   * @return The updated style with the removed CSS class.
   */
  R removeCss(CssClass cssClass);

  /**
   * Removes a specific CSS class from the style using an object that implements the {@code
   * HasCssClass} interface.
   *
   * @param cssClass The {@link HasCssClass} object providing the CSS class to be removed.
   * @return The updated style with the removed CSS class.
   */
  R removeCss(HasCssClass cssClass);

  /**
   * Removes multiple CSS classes from the style using an array of class names.
   *
   * @param cssClasses An array of strings representing the CSS classes to be removed.
   * @return The updated style with the removed CSS classes.
   */
  R removeCss(String... cssClasses);

  /**
   * Removes multiple CSS classes from the style using an array of {@code CssClass} objects.
   *
   * @param cssClasses An array of {@link CssClass} objects representing the CSS classes to be
   *     removed.
   * @return The updated style with the removed CSS classes.
   */
  R removeCss(CssClass... cssClasses);

  /**
   * Replaces a CSS class with another one.
   *
   * @param cssClass The CSS class to be replaced.
   * @param replacementClass The CSS class that will replace the old one.
   * @return The updated style.
   */
  R replaceCss(String cssClass, String replacementClass);

  /**
   * Sets the border style of the element.
   *
   * @param border The border style.
   * @return The updated style.
   */
  R setBorder(String border);

  /**
   * Sets the border color of the element.
   *
   * @param borderColor The color value for the border.
   * @return The updated style with the set border color.
   */
  R setBorderColor(String borderColor);

  /**
   * Sets the width of the element.
   *
   * @param width The width value.
   * @return The updated style with the set width.
   */
  R setWidth(String width);

  /**
   * Sets the width of the element with the option to make it important.
   *
   * @param width The width value.
   * @param important If true, the width is set as "!important".
   * @return The updated style with the set width.
   */
  R setWidth(String width, boolean important);

  /**
   * Sets the minimum width of the element.
   *
   * @param width The minimum width value.
   * @return The updated style with the set minimum width.
   */
  R setMinWidth(String width);

  /**
   * Sets the minimum width of the element with the option to make it important.
   *
   * @param width The minimum width value.
   * @param important If true, the minimum width is set as "!important".
   * @return The updated style with the set minimum width.
   */
  R setMinWidth(String width, boolean important);

  /**
   * Sets the maximum width of the element.
   *
   * @param width The maximum width value.
   * @return The updated style with the set maximum width.
   */
  R setMaxWidth(String width);

  /**
   * Sets the maximum width of the element with the option to make it important.
   *
   * @param width The maximum width value.
   * @param important If true, the maximum width is set as "!important".
   * @return The updated style with the set maximum width.
   */
  R setMaxWidth(String width, boolean important);

  /**
   * Sets the height of the element.
   *
   * @param height The height value.
   * @return The updated style with the set height.
   */
  R setHeight(String height);

  /**
   * Sets the height of the element with the option to make it important.
   *
   * @param height The height value.
   * @param important If true, the height is set as "!important".
   * @return The updated style with the set height.
   */
  R setHeight(String height, boolean important);

  /**
   * Sets the minimum height of the element.
   *
   * @param height The minimum height value.
   * @return The updated style with the set minimum height.
   */
  R setMinHeight(String height);

  /**
   * Sets the minimum height of the element with the option to make it important.
   *
   * @param height The minimum height value.
   * @param important If true, the minimum height is set as "!important".
   * @return The updated style with the set minimum height.
   */
  R setMinHeight(String height, boolean important);

  /**
   * Sets the maximum height of the element.
   *
   * @param height The maximum height value.
   * @return The updated style with the set maximum height.
   */
  R setMaxHeight(String height);

  /**
   * Sets the maximum height of the element with the option to make it important.
   *
   * @param height The maximum height value.
   * @param important If true, the maximum height is set as "!important".
   * @return The updated style with the set maximum height.
   */
  R setMaxHeight(String height, boolean important);

  /**
   * Sets the text alignment of the element.
   *
   * @param textAlign The text alignment value.
   * @return The updated style with the set text alignment.
   */
  R setTextAlign(String textAlign);

  /**
   * Sets the text alignment of the element with the option to make it important.
   *
   * @param textAlign The text alignment value.
   * @param important If true, the text alignment is set as "!important".
   * @return The updated style with the set text alignment.
   */
  R setTextAlign(String textAlign, boolean important);

  /**
   * Sets the text color of the element.
   *
   * @param color The text color value.
   * @return The updated style with the set text color.
   */
  R setColor(String color);

  /**
   * Sets the text color of the element with the option to make it important.
   *
   * @param color The text color value.
   * @param important If true, the text color is set as "!important".
   * @return The updated style with the set text color.
   */
  R setColor(String color, boolean important);

  /**
   * Sets the background color of the element.
   *
   * @param color The background color value.
   * @return The updated style with the set background color.
   */
  R setBackgroundColor(String color);

  /**
   * Sets the background color of the element with the option to make it important.
   *
   * @param color The background color value.
   * @param important If true, the background color is set as "!important".
   * @return The updated style with the set background color.
   */
  R setBackgroundColor(String color, boolean important);

  /**
   * Sets the margin of the element.
   *
   * @param margin The margin value.
   * @return The updated style with the set margin.
   */
  R setMargin(String margin);

  /**
   * Sets the margin value for all sides of the element with the option to make it important.
   *
   * @param margin The margin value to set for all sides.
   * @param important If true, the margin value is set as "!important" for all sides.
   * @return The updated style with the set margin value for all sides.
   */
  R setMargin(String margin, boolean important);

  /**
   * Sets the top margin value of the element.
   *
   * @param margin The top margin value to set.
   * @return The updated style with the set top margin value.
   */
  R setMarginTop(String margin);

  /**
   * Sets the top margin value of the element with the option to make it important.
   *
   * @param margin The top margin value to set.
   * @param important If true, the top margin value is set as "!important".
   * @return The updated style with the set top margin value.
   */
  R setMarginTop(String margin, boolean important);

  /**
   * Sets the bottom margin value of the element.
   *
   * @param margin The bottom margin value to set.
   * @return The updated style with the set bottom margin value.
   */
  R setMarginBottom(String margin);

  /**
   * Sets the bottom margin value of the element with the option to make it important.
   *
   * @param margin The bottom margin value to set.
   * @param important If true, the bottom margin value is set as "!important".
   * @return The updated style with the set bottom margin value.
   */
  R setMarginBottom(String margin, boolean important);

  /**
   * Sets the left margin value of the element.
   *
   * @param margin The left margin value to set.
   * @return The updated style with the set left margin value.
   */
  R setMarginLeft(String margin);

  /**
   * Sets the left margin value of the element with the option to make it important.
   *
   * @param margin The left margin value to set.
   * @param important If true, the left margin value is set as "!important".
   * @return The updated style with the set left margin value.
   */
  R setMarginLeft(String margin, boolean important);

  /**
   * Sets the right margin value of the element.
   *
   * @param margin The right margin value to set.
   * @return The updated style with the set right margin value.
   */
  R setMarginRight(String margin);

  /**
   * Sets the right margin value of the element with the option to make it important.
   *
   * @param margin The right margin value to set.
   * @param important If true, the right margin value is set as "!important".
   * @return The updated style with the set right margin value.
   */
  R setMarginRight(String margin, boolean important);

  /**
   * Sets the right padding of the element.
   *
   * @param padding The padding value for the right side.
   * @return The updated style with the set right padding.
   */
  R setPaddingRight(String padding);

  /**
   * Sets the right padding of the element with the option to make it important.
   *
   * @param padding The padding value for the right side.
   * @param important If true, the right padding is set as "!important".
   * @return The updated style with the set right padding.
   */
  R setPaddingRight(String padding, boolean important);

  /**
   * Sets the left padding value of the element.
   *
   * @param padding The left padding value to set.
   * @return The updated style with the set left padding value.
   */
  R setPaddingLeft(String padding);

  /**
   * Sets the left padding value of the element with the option to make it important.
   *
   * @param padding The left padding value to set.
   * @param important If true, the left padding value is set as "!important".
   * @return The updated style with the set left padding value.
   */
  R setPaddingLeft(String padding, boolean important);

  /**
   * Sets the bottom padding value of the element.
   *
   * @param padding The bottom padding value to set.
   * @return The updated style with the set bottom padding value.
   */
  R setPaddingBottom(String padding);

  /**
   * Sets the bottom padding value of the element with the option to make it important.
   *
   * @param padding The bottom padding value to set.
   * @param important If true, the bottom padding value is set as "!important".
   * @return The updated style with the set bottom padding value.
   */
  R setPaddingBottom(String padding, boolean important);

  /**
   * Sets the top padding value of the element.
   *
   * @param padding The top padding value to set.
   * @return The updated style with the set top padding value.
   */
  R setPaddingTop(String padding);

  /**
   * Sets the top padding value of the element with the option to make it important.
   *
   * @param padding The top padding value to set.
   * @param important If true, the top padding value is set as "!important".
   * @return The updated style with the set top padding value.
   */
  R setPaddingTop(String padding, boolean important);

  /**
   * Sets the padding value for all sides of the element.
   *
   * @param padding The padding value to set for all sides.
   * @return The updated style with the set padding value.
   */
  R setPadding(String padding);

  /**
   * Sets the padding value for all sides of the element with the option to make it important.
   *
   * @param padding The padding value to set for all sides.
   * @param important If true, the padding value is set as "!important".
   * @return The updated style with the set padding value.
   */
  R setPadding(String padding, boolean important);

  /**
   * Sets the display property of the element.
   *
   * @param display The value for the display property.
   * @return The updated style with the set display property.
   */
  R setDisplay(String display);

  /**
   * Sets the display property of the element with the option to make it important.
   *
   * @param display The value for the display property.
   * @param important If true, the display property is set as "!important".
   * @return The updated style with the set display property.
   */
  R setDisplay(String display, boolean important);

  /**
   * Sets the font size property of the element.
   *
   * @param fontSize The value for the font size property.
   * @return The updated style with the set font size property.
   */
  R setFontSize(String fontSize);

  /**
   * Sets the font size property of the element with the option to make it important.
   *
   * @param fontSize The value for the font size property.
   * @param important If true, the font size property is set as "!important".
   * @return The updated style with the set font size property.
   */
  R setFontSize(String fontSize, boolean important);

  /**
   * Sets the CSS float property of the element.
   *
   * @param cssFloat The value for the CSS float property.
   * @return The updated style with the set CSS float property.
   */
  R setFloat(String cssFloat);

  /**
   * Sets the CSS float property of the element with the option to make it important.
   *
   * @param cssFloat The value for the CSS float property.
   * @param important If true, the CSS float property is set as "!important".
   * @return The updated style with the set CSS float property.
   */
  R setFloat(String cssFloat, boolean important);

  /**
   * Sets the line height property of the element.
   *
   * @param lineHeight The value for the line height property.
   * @return The updated style with the set line height property.
   */
  R setLineHeight(String lineHeight);

  /**
   * Sets the line height property of the element with the option to make it important.
   *
   * @param lineHeight The value for the line height property.
   * @param important If true, the line height property is set as "!important".
   * @return The updated style with the set line height property.
   */
  R setLineHeight(String lineHeight, boolean important);

  /**
   * Sets the overflow property of the element.
   *
   * @param overFlow The value for the overflow property.
   * @return The updated style with the set overflow property.
   */
  R setOverFlow(String overFlow);

  /**
   * Sets the overflow property of the element with the option to make it important.
   *
   * @param overFlow The value for the overflow property.
   * @param important If true, the overflow property is set as "!important".
   * @return The updated style with the set overflow property.
   */
  R setOverFlow(String overFlow, boolean important);

  /**
   * Sets the cursor property of the element.
   *
   * @param cursor The value for the cursor property.
   * @return The updated style with the set cursor property.
   */
  R setCursor(String cursor);

  /**
   * Sets the cursor property of the element with the option to make it important.
   *
   * @param cursor The value for the cursor property.
   * @param important If true, the cursor property is set as "!important".
   * @return The updated style with the set cursor property.
   */
  R setCursor(String cursor, boolean important);

  /**
   * Sets the position property of the element.
   *
   * @param position The value for the position property.
   * @return The updated style with the set position property.
   */
  R setPosition(String position);

  /**
   * Sets the position property of the element with the option to make it important.
   *
   * @param position The value for the position property.
   * @param important If true, the position property is set as "!important".
   * @return The updated style with the set position property.
   */
  R setPosition(String position, boolean important);

  /**
   * Sets the left property of the element.
   *
   * @param left The value for the left property.
   * @return The updated style with the set left property.
   */
  R setLeft(String left);

  /**
   * Sets the left property of the element with the option to make it important.
   *
   * @param left The value for the left property.
   * @param important If true, the left property is set as "!important".
   * @return The updated style with the set left property.
   */
  R setLeft(String left, boolean important);

  /**
   * Sets the right property of the element.
   *
   * @param right The value for the right property.
   * @return The updated style with the set right property.
   */
  R setRight(String right);

  /**
   * Sets the right property of the element with the option to make it important.
   *
   * @param right The value for the right property.
   * @param important If true, the right property is set as "!important".
   * @return The updated style with the set right property.
   */
  R setRight(String right, boolean important);

  /**
   * Sets the top property of the element.
   *
   * @param top The value for the top property.
   * @return The updated style with the set top property.
   */
  R setTop(String top);

  /**
   * Sets the top property of the element with the option to make it important.
   *
   * @param top The value for the top property.
   * @param important If true, the top property is set as "!important".
   * @return The updated style with the set top property.
   */
  R setTop(String top, boolean important);

  /**
   * Sets the bottom property of the element.
   *
   * @param bottom The value for the bottom property.
   * @return The updated style with the set bottom property.
   */
  R setBottom(String bottom);

  /**
   * Sets the bottom property of the element with the option to make it important.
   *
   * @param bottom The value for the bottom property.
   * @param important If true, the bottom property is set as "!important".
   * @return The updated style with the set bottom property.
   */
  R setBottom(String bottom, boolean important);

  /**
   * Sets the z-index property of the element.
   *
   * @param zindex The value for the z-index property.
   * @return The updated style with the set z-index property.
   */
  R setZIndex(int zindex);

  /**
   * Sets the opacity property of the element.
   *
   * @param opacity The value for the opacity property (a double between 0.0 and 1.0).
   * @return The updated style with the set opacity property.
   */
  R setOpacity(double opacity);

  /**
   * Sets the opacity property of the element with the option to make it important.
   *
   * @param opacity The value for the opacity property (a double between 0.0 and 1.0).
   * @param important If true, the opacity property is set as "!important".
   * @return The updated style with the set opacity property.
   */
  R setOpacity(double opacity, boolean important);

  /**
   * Checks if the element contains a given CSS class.
   *
   * @param cssClass The CSS class to check for.
   * @return true if the element contains the given CSS class, false otherwise.
   */
  boolean containsCss(String cssClass);

  /**
   * Aligns the element's content to the center.
   *
   * @return The updated style with content aligned to the center.
   */
  R alignCenter();

  /**
   * Aligns the element's content to the right.
   *
   * @return The updated style with content aligned to the right.
   */
  R alignRight();

  /**
   * Sets the CSS text for the element.
   *
   * @param cssText The CSS text to set for the element.
   * @return The updated style with the specified CSS text.
   */
  R cssText(String cssText);

  /**
   * Returns the count of CSS classes applied to the element.
   *
   * @return The count of CSS classes applied.
   */
  int cssClassesCount();

  /**
   * Returns the CSS class at the specified index applied to the element.
   *
   * @param index The index of the CSS class to retrieve.
   * @return The CSS class at the specified index.
   */
  String cssClassByIndex(int index);

  /**
   * Sets the pointer-events property for the element.
   *
   * @param pointerEvents The value for the pointer-events property.
   * @return The updated style with the set pointer-events property.
   */
  R setPointerEvents(String pointerEvents);

  /**
   * Sets the align-items property for the element.
   *
   * @param alignItems The value for the align-items property.
   * @return The updated style with the set align-items property.
   */
  R setAlignItems(String alignItems);

  /**
   * Sets the overflow-y property for the element.
   *
   * @param overflow The value for the overflow-y property.
   * @return The updated style with the set overflow-y property.
   */
  R setOverFlowY(String overflow);

  /**
   * Sets the overflow-y property for the element with the option to make it important.
   *
   * @param overflow The value for the overflow-y property.
   * @param important If true, the overflow-y property is set as "!important".
   * @return The updated style with the set overflow-y property.
   */
  R setOverFlowY(String overflow, boolean important);

  /**
   * Sets the overflow-x property for the element.
   *
   * @param overflow The value for the overflow-x property.
   * @return The updated style with the set overflow-x property.
   */
  R setOverFlowX(String overflow);

  /**
   * Sets the overflow-x property for the element with the option to make it important.
   *
   * @param overflow The value for the overflow-x property.
   * @param important If true, the overflow-x property is set as "!important".
   * @return The updated style with the set overflow-x property.
   */
  R setOverFlowX(String overflow, boolean important);

  /**
   * Sets the box-shadow property for the element.
   *
   * @param boxShadow The value for the box-shadow property.
   * @return The updated style with the set box-shadow property.
   */
  R setBoxShadow(String boxShadow);

  /**
   * Sets the transition-duration property for the element.
   *
   * @param transactionDuration The value for the transition-duration property.
   * @return The updated style with the set transition-duration property.
   */
  R setTransitionDuration(String transactionDuration);

  /**
   * Sets the flex property for the element.
   *
   * @param flex The value for the flex property.
   * @return The updated style with the set flex property.
   */
  R setFlex(String flex);
}
