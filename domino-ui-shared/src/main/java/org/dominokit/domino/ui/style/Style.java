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
 * A utility class for manipulating the CSS styles of an HTML element.
 *
 * @param <E> The type of the HTML element.
 */
public class Style<E extends Element> implements DominoStyle<E, Style<E>> {

  public final CSSStyleDeclaration style;
  private E element;

  /**
   * Constructs a new Style instance for the given HTML element.
   *
   * @param element The HTML element to apply styles to.
   */
  public Style(E element) {
    this.element = element;
    this.style = Js.<DominoElementAdapter>uncheckedCast(element).style;
  }

  /**
   * Creates a new Style instance for the given HTML element.
   *
   * @param <E> The type of the HTML element.
   * @param element The HTML element to apply styles to.
   * @return A new Style instance.
   */
  public static <E extends Element> Style<E> of(E element) {
    return new Style<>(element);
  }

  /**
   * Creates a new Style instance for the given IsElement.
   *
   * @param <E> The type of the HTML element.
   * @param <T> The type of the component
   * @param isElement The IsElement interface representing the HTML element.
   * @return A new Style instance.
   */
  public static <E extends Element, T extends IsElement<E>> Style<E> of(T isElement) {
    return new Style<>(isElement.element());
  }

  /**
   * Sets a CSS property with the specified name and value.
   *
   * @param name The name of the CSS property.
   * @param value The value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, String value) {
    style.setProperty(name, value);
    return this;
  }

  /**
   * Sets a CSS property with the specified name and numeric value.
   *
   * @param name The name of the CSS property.
   * @param value The numeric value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, Number value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and integer value.
   *
   * @param name The name of the CSS property.
   * @param value The integer value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, int value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and double value.
   *
   * @param name The name of the CSS property.
   * @param value The double value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, double value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and short value.
   *
   * @param name The name of the CSS property.
   * @param value The short value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, short value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and float value.
   *
   * @param name The name of the CSS property.
   * @param value The float value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, float value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and boolean value.
   *
   * @param name The name of the CSS property.
   * @param value The boolean value to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, boolean value) {
    style.setProperty(name, String.valueOf(value));
    return this;
  }

  /**
   * Sets a CSS property with the specified name and value, with optional importance.
   *
   * @param name The name of the CSS property.
   * @param value The value to set.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCssProperty(String name, String value, boolean important) {
    if (important) {
      style.setProperty(name, value, "important");
    } else {
      style.setProperty(name, value);
    }
    return this;
  }

  /**
   * Sets or removes a CSS property based on a predicate.
   *
   * @param name The name of the CSS property.
   * @param value The value to set.
   * @param predicate The predicate that determines whether to set or remove the property.
   * @return This Style instance for method chaining.
   */
  public Style<E> setOrRemoveCssProperty(String name, String value, Predicate<Style<E>> predicate) {
    if (predicate.test(this)) {
      setCssProperty(name, value);
    } else {
      removeCssProperty(name);
    }
    return this;
  }

  /**
   * Removes a CSS property with the specified name.
   *
   * @param name The name of the CSS property to remove.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> removeCssProperty(String name) {
    style.removeProperty(name);
    return this;
  }

  /**
   * Adds one or more CSS classes to the HTML element.
   *
   * @param cssClass The CSS class(es) to add.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) {
      element.classList.add(cssClass);
    }
    return this;
  }

  /**
   * Adds one or more CSS classes to the HTML element.
   *
   * @param cssClasses The CSS classes to add.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(String... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      element.classList.add(cssClasses);
    }
    return this;
  }

  /**
   * Adds a CSS class to the HTML element.
   *
   * @param cssClasses The CSS class to add.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(CssClass cssClasses) {
    cssClasses.apply(element);
    return this;
  }

  /**
   * Adds a CSS class to the HTML element.
   *
   * @param hasCssClass An object implementing HasCssClass.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(HasCssClass hasCssClass) {
    addCss(hasCssClass.getCssClass());
    return this;
  }

  /**
   * Adds one or more CSS classes to the HTML element.
   *
   * @param cssClasses An array of CSS classes to add.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(CssClass... cssClasses) {
    Arrays.asList(cssClasses).forEach(this::addCss);
    return this;
  }

  /**
   * Adds CSS classes from an object that implements the HasCssClasses interface.
   *
   * @param hasCssClasses An object that implements HasCssClasses interface.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> addCss(HasCssClasses hasCssClasses) {
    addCss(hasCssClasses.getCssClasses());
    return this;
  }

  /**
   * Removes a CSS class from the HTML element.
   *
   * @param cssClass The CSS class to remove.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> removeCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) element.classList.remove(cssClass);
    return this;
  }

  /**
   * Removes a CSS class represented by a CssClass instance from the HTML element.
   *
   * @param cssClass The CssClass instance to remove.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> removeCss(CssClass cssClass) {
    cssClass.remove(element);
    return this;
  }

  /**
   * Removes CSS classes from an object that implements the HasCssClass interface.
   *
   * @param hasCssClass An object that implements HasCssClass interface.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> removeCss(HasCssClass hasCssClass) {
    hasCssClass.getCssClass().remove(element);
    return this;
  }

  /**
   * Removes one or more CSS classes from the HTML element.
   *
   * @param cssClasses An array of CSS classes to remove.
   * @return This Style instance for method chaining.
   */
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

  /**
   * Removes one or more CSS classes represented by CssClass instances from the HTML element.
   *
   * @param cssClasses An array of CssClass instances to remove.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> removeCss(CssClass... cssClasses) {
    if (nonNull(cssClasses) && cssClasses.length > 0) {
      // remove(String... arr) is not supported in IE11, so looping over the array solving the
      // problem
      for (CssClass cssClass : cssClasses) {
        removeCss(cssClass);
      }
    }
    return this;
  }

  /**
   * Replaces one CSS class with another in the HTML element's class list.
   *
   * @param cssClass The CSS class to be replaced.
   * @param replacementClass The CSS class to replace it with.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> replaceCss(String cssClass, String replacementClass) {
    if (containsCss(cssClass)) {
      removeCss(cssClass);
      addCss(replacementClass);
    }
    return this;
  }

  /**
   * Sets the CSS <b>border</b> property of the HTML element.
   *
   * @param border The value to set for the <b>border</b> property.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBorder(String border) {
    setCssProperty("border", border);
    return this;
  }

  /**
   * Sets the CSS border-color property of the HTML element.
   *
   * @param borderColor The value to set for the border-color property.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBorderColor(String borderColor) {
    setCssProperty("border-color", borderColor);
    return this;
  }

  /**
   * Sets the width of the HTML element.
   *
   * @param width The width value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setWidth(String width) {
    setWidth(width, false);
    return this;
  }

  /**
   * Sets the width of the HTML element with optional importance.
   *
   * @param width The width value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setWidth(String width, boolean important) {
    setCssProperty("width", width, important);
    return this;
  }

  /**
   * Sets the minimum width of the HTML element.
   *
   * @param width The minimum width value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMinWidth(String width) {
    setMinWidth(width, false);
    return this;
  }

  /**
   * Sets the minimum width of the HTML element with optional importance.
   *
   * @param width The minimum width value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMinWidth(String width, boolean important) {
    setCssProperty("min-width", width, important);
    return this;
  }

  /**
   * Sets the maximum width of the HTML element.
   *
   * @param width The maximum width value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMaxWidth(String width) {
    setMaxWidth(width, false);
    return this;
  }

  /**
   * Sets the maximum width of the HTML element with optional importance.
   *
   * @param width The maximum width value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMaxWidth(String width, boolean important) {
    setCssProperty("max-width", width, important);
    return this;
  }

  /**
   * Sets the CSS height property of the HTML element.
   *
   * @param height The height value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setHeight(String height) {
    setHeight(height, false);
    return this;
  }

  /**
   * Sets the CSS height property of the HTML element with optional importance.
   *
   * @param height The height value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setHeight(String height, boolean important) {
    setCssProperty("height", height, important);
    return this;
  }

  /**
   * Sets the CSS min-height property of the HTML element.
   *
   * @param height The minimum height value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMinHeight(String height) {
    setMinHeight(height, false);
    return this;
  }

  /**
   * Sets the CSS min-height` property of the HTML element with optional importance.
   *
   * @param height The minimum height value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMinHeight(String height, boolean important) {
    setCssProperty("min-height", height, important);
    return this;
  }

  /**
   * Sets the CSS `max-height` property of the HTML element.
   *
   * @param height The maximum height value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMaxHeight(String height) {
    setMaxHeight(height, false);
    return this;
  }

  /**
   * Sets the CSS `max-height` property of the HTML element with optional importance.
   *
   * @param height The maximum height value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMaxHeight(String height, boolean important) {
    setCssProperty("max-height", height, important);
    return this;
  }

  /**
   * Sets the CSS `text-align` property of the HTML element.
   *
   * @param textAlign The text alignment value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setTextAlign(String textAlign) {
    setTextAlign(textAlign, false);
    return this;
  }

  /**
   * Sets the CSS `text-align` property of the HTML element with optional importance.
   *
   * @param textAlign The text alignment value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setTextAlign(String textAlign, boolean important) {
    setCssProperty("text-align", textAlign, important);
    return this;
  }

  /**
   * Sets the CSS `color` property of the HTML element.
   *
   * @param color The color value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setColor(String color) {
    setColor(color, false);
    return this;
  }

  /**
   * Sets the CSS `color` property of the HTML element with optional importance.
   *
   * @param color The color value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setColor(String color, boolean important) {
    setCssProperty("color", color, important);
    return this;
  }

  /**
   * Sets the CSS `background-color` property of the HTML element.
   *
   * @param color The background color value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBackgroundColor(String color) {
    setBackgroundColor(color, false);
    return this;
  }

  /**
   * Sets the CSS `background-color` property of the HTML element with optional importance.
   *
   * @param color The background color value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBackgroundColor(String color, boolean important) {
    setCssProperty("background-color", color, important);
    return this;
  }

  /**
   * Sets the CSS `margin` property of the HTML element.
   *
   * @param margin The margin value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMargin(String margin) {
    setMargin(margin, false);
    return this;
  }

  /**
   * Sets the CSS `margin` property of the HTML element with optional importance.
   *
   * @param margin The margin value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMargin(String margin, boolean important) {
    setCssProperty("margin", margin, important);
    return this;
  }

  /**
   * Sets the CSS `margin-top` property of the HTML element.
   *
   * @param margin The margin value for the top.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginTop(String margin) {
    setMarginTop(margin, false);
    return this;
  }

  /**
   * Sets the CSS `margin-top` property of the HTML element with optional importance.
   *
   * @param margin The margin value for the top.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginTop(String margin, boolean important) {
    setCssProperty("margin-top", margin, important);
    return this;
  }

  /**
   * Sets the CSS `margin-bottom` property of the HTML element.
   *
   * @param margin The margin value for the bottom.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginBottom(String margin) {
    setMarginBottom(margin, false);
    return this;
  }

  /**
   * Sets the CSS `margin-bottom` property of the HTML element with optional importance.
   *
   * @param margin The margin value for the bottom.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginBottom(String margin, boolean important) {
    setCssProperty("margin-bottom", margin, important);
    return this;
  }

  /**
   * Sets the CSS `margin-left` property of the HTML element.
   *
   * @param margin The margin value for the left.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginLeft(String margin) {
    setMarginLeft(margin, false);
    return this;
  }

  /**
   * Sets the CSS `margin-left` property of the HTML element with optional importance.
   *
   * @param margin The margin value for the left.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginLeft(String margin, boolean important) {
    setCssProperty("margin-left", margin, important);
    return this;
  }

  /**
   * Sets the CSS `margin-right` property of the HTML element.
   *
   * @param margin The margin value for the right.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginRight(String margin) {
    setMarginRight(margin, false);
    return this;
  }

  /**
   * Sets the CSS `margin-right` property of the HTML element with optional importance.
   *
   * @param margin The margin value for the right.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setMarginRight(String margin, boolean important) {
    setCssProperty("margin-right", margin, important);
    return this;
  }

  /**
   * Sets the CSS `padding-right` property of the HTML element.
   *
   * @param padding The padding value for the right.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingRight(String padding) {
    setPaddingRight(padding, false);
    return this;
  }

  /**
   * Sets the CSS `padding-right` property of the HTML element.
   *
   * @param padding The padding value for the right.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingRight(String padding, boolean important) {
    setCssProperty("padding-right", padding, important);
    return this;
  }

  /**
   * Sets the CSS `padding-left` property of the HTML element.
   *
   * @param padding The padding value for the left.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingLeft(String padding) {
    setPaddingLeft(padding, false);
    return this;
  }

  /**
   * Sets the CSS `padding-left` property of the HTML element with optional importance.
   *
   * @param padding The padding value for the left.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingLeft(String padding, boolean important) {
    setCssProperty("padding-left", padding, important);
    return this;
  }

  /**
   * Sets the CSS `padding-bottom` property of the HTML element.
   *
   * @param padding The padding value for the bottom.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingBottom(String padding) {
    setPaddingBottom(padding, false);
    return this;
  }

  /**
   * Sets the CSS `padding-bottom` property of the HTML element with optional importance.
   *
   * @param padding The padding value for the bottom.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingBottom(String padding, boolean important) {
    setCssProperty("padding-bottom", padding, important);
    return this;
  }

  /**
   * Sets the CSS `padding-top` property of the HTML element.
   *
   * @param padding The padding value for the top.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingTop(String padding) {
    setPaddingTop(padding, false);
    return this;
  }

  /**
   * Sets the CSS `padding-top` property of the HTML element with optional importance.
   *
   * @param padding The padding value for the top.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPaddingTop(String padding, boolean important) {
    setCssProperty("padding-top", padding, important);
    return this;
  }

  /**
   * Sets the CSS `padding` property of the HTML element.
   *
   * @param padding The padding value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPadding(String padding) {
    setPadding(padding, false);
    return this;
  }

  /**
   * Sets the CSS `padding` property of the HTML element with optional importance.
   *
   * @param padding The padding value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPadding(String padding, boolean important) {
    setCssProperty("padding", padding, important);
    return this;
  }

  /**
   * Sets the CSS `display` property of the HTML element.
   *
   * @param display The display value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setDisplay(String display) {
    setDisplay(display, false);
    return this;
  }

  /**
   * Sets the CSS `display` property of the HTML element with optional importance.
   *
   * @param display The display value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setDisplay(String display, boolean important) {
    setCssProperty("display", display, important);
    return this;
  }

  /**
   * Sets the CSS `font-size` property of the HTML element.
   *
   * @param fontSize The font size value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setFontSize(String fontSize) {
    setFontSize(fontSize, false);
    return this;
  }

  /**
   * Sets the CSS `font-size` property of the HTML element with optional importance.
   *
   * @param fontSize The font size value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setFontSize(String fontSize, boolean important) {
    setCssProperty("font-size", fontSize, important);
    return this;
  }

  /**
   * Sets the CSS `float` property of the HTML element.
   *
   * @param cssFloat The float value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setFloat(String cssFloat) {
    setFloat(cssFloat, false);
    return this;
  }

  /**
   * Sets the CSS `float` property of the HTML element with optional importance.
   *
   * @param cssFloat The float value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setFloat(String cssFloat, boolean important) {
    setCssProperty("float", cssFloat, important);
    return this;
  }

  /**
   * Sets the CSS `line-height` property of the HTML element.
   *
   * @param lineHeight The line-height value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setLineHeight(String lineHeight) {
    setLineHeight(lineHeight, false);
    return this;
  }

  /**
   * Sets the CSS `line-height` property of the HTML element with optional importance.
   *
   * @param lineHeight The line-height value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setLineHeight(String lineHeight, boolean important) {
    setCssProperty("line-height", lineHeight, important);
    return this;
  }

  /**
   * Sets the CSS `overflow` property of the HTML element.
   *
   * @param overFlow The overflow value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlow(String overFlow) {
    setOverFlow(overFlow, false);
    return this;
  }

  /**
   * Sets the CSS `overflow` property of the HTML element with optional importance.
   *
   * @param overFlow The overflow value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlow(String overFlow, boolean important) {
    setCssProperty("overflow", overFlow, important);
    return this;
  }

  /**
   * Sets the CSS `cursor` property of the HTML element.
   *
   * @param cursor The cursor value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCursor(String cursor) {
    setCursor(cursor, false);
    return this;
  }

  /**
   * Sets the CSS `cursor` property of the HTML element with optional importance.
   *
   * @param cursor The cursor value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setCursor(String cursor, boolean important) {
    setCssProperty("cursor", cursor, important);
    return this;
  }

  /**
   * Sets the CSS `position` property of the HTML element.
   *
   * @param position The position value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPosition(String position) {
    setPosition(position, false);
    return this;
  }

  /**
   * Sets the CSS `position` property of the HTML element with optional importance.
   *
   * @param position The position value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPosition(String position, boolean important) {
    setCssProperty("position", position, important);
    return this;
  }

  /**
   * Sets the CSS `left` property of the HTML element.
   *
   * @param left The left value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setLeft(String left) {
    setLeft(left, false);
    return this;
  }

  /**
   * Sets the CSS `left` property of the HTML element with optional importance.
   *
   * @param left The left value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setLeft(String left, boolean important) {
    setCssProperty("left", left, important);
    return this;
  }

  /**
   * Sets the CSS `right` property of the HTML element.
   *
   * @param right The right value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setRight(String right) {
    setRight(right, false);
    return this;
  }

  /**
   * Sets the CSS `right` property of the HTML element with optional importance.
   *
   * @param right The right value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setRight(String right, boolean important) {
    setCssProperty("right", right, important);
    return this;
  }

  /**
   * Sets the CSS `top` property of the HTML element.
   *
   * @param top The top value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setTop(String top) {
    setTop(top, false);
    return this;
  }

  /**
   * Sets the CSS `top` property of the HTML element with optional importance.
   *
   * @param top The top value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setTop(String top, boolean important) {
    setCssProperty("top", top, important);
    return this;
  }

  /**
   * Sets the CSS `bottom` property of the HTML element.
   *
   * @param bottom The bottom value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBottom(String bottom) {
    setBottom(bottom, false);
    return this;
  }

  /**
   * Sets the CSS `bottom` property of the HTML element with optional importance.
   *
   * @param bottom The bottom value.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBottom(String bottom, boolean important) {
    setCssProperty("bottom", bottom, important);
    return this;
  }

  /**
   * Sets the CSS `z-index` property of the HTML element.
   *
   * @param zindex The z-index value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setZIndex(int zindex) {
    setCssProperty("z-index", zindex + "");
    return this;
  }

  /**
   * Checks if the HTML element contains the specified CSS class.
   *
   * @param cssClass The CSS class to check.
   * @return True if the class is present; otherwise, false.
   */
  @Override
  public boolean containsCss(String cssClass) {
    if (nonNull(cssClass) && !cssClass.isEmpty()) {
      return element.classList.contains(cssClass);
    }
    return false;
  }

  /**
   * Adds CSS classes to align the HTML element center.
   *
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> alignCenter() {
    addCss(SpacingCss.dui_text_center);
    return this;
  }

  /**
   * Adds CSS classes to align the HTML element right.
   *
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> alignRight() {
    addCss(SpacingCss.dui_text_right);
    return this;
  }

  /**
   * Sets the CSS `style.cssText` property of the HTML element.
   *
   * @param cssText The CSS text to set.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> cssText(String cssText) {
    style.cssText = cssText;
    return this;
  }

  /**
   * Gets the count of CSS classes applied to the HTML element.
   *
   * @return The count of CSS classes.
   */
  @Override
  public int cssClassesCount() {
    return element.classList.length;
  }

  /**
   * Gets a CSS class by its index.
   *
   * @param index The index of the CSS class.
   * @return The CSS class at the specified index.
   */
  @Override
  public String cssClassByIndex(int index) {
    return element.classList.item(index);
  }

  /**
   * Sets the CSS `pointer-events` property of the HTML element.
   *
   * @param pointerEvents The pointer-events value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setPointerEvents(String pointerEvents) {
    return setCssProperty("pointer-events", pointerEvents);
  }

  /**
   * Sets the CSS `align-items` property of the HTML element.
   *
   * @param alignItems The align-items value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setAlignItems(String alignItems) {
    return setCssProperty("align-items", alignItems);
  }

  /**
   * Sets the CSS `overflow-y` property of the HTML element.
   *
   * @param overflow The overflow value for the Y-axis.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlowY(String overflow) {
    return setCssProperty("overflow-y", overflow);
  }

  /**
   * Sets the CSS `overflow-y` property of the HTML element with optional importance.
   *
   * @param overflow The overflow value for the Y-axis.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlowY(String overflow, boolean important) {
    return setCssProperty("overflow-y", overflow, important);
  }

  /**
   * Sets the CSS `overflow-x` property of the HTML element.
   *
   * @param overflow The overflow value for the X-axis.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlowX(String overflow) {
    return setCssProperty("overflow-x", overflow);
  }

  /**
   * Sets the CSS `overflow-x` property of the HTML element with optional importance.
   *
   * @param overflow The overflow value for the X-axis.
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOverFlowX(String overflow, boolean important) {
    return setCssProperty("overflow-x", overflow, important);
  }

  /**
   * Sets the CSS `box-shadow` property of the HTML element.
   *
   * @param boxShadow The box-shadow value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setBoxShadow(String boxShadow) {
    return setCssProperty("box-shadow", boxShadow);
  }

  /**
   * Sets the CSS `transition-duration` property of the HTML element.
   *
   * @param transactionDuration The transition-duration value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setTransitionDuration(String transactionDuration) {
    return setCssProperty("transaction-duration", transactionDuration);
  }

  /**
   * Sets the CSS `flex` property of the HTML element.
   *
   * @param flex The flex value.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setFlex(String flex) {
    return setCssProperty("flex", flex);
  }

  /**
   * Sets the CSS `opacity` property of the HTML element.
   *
   * @param opacity The opacity value (0.0 to 1.0).
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOpacity(double opacity) {
    return setCssProperty("opacity", opacity + "");
  }

  /**
   * Sets the CSS `opacity` property of the HTML element with optional importance.
   *
   * @param opacity The opacity value (0.0 to 1.0).
   * @param important If true, the property is marked as important.
   * @return This Style instance for method chaining.
   */
  @Override
  public Style<E> setOpacity(double opacity, boolean important) {
    return setCssProperty("opacity", opacity + "", important);
  }
}
