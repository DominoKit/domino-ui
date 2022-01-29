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
package org.dominokit.domino.ui.timepicker;

import static org.dominokit.domino.ui.timepicker.ClockStyle._24;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGLineElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.DominoElement;

/** The class is responsible of rendering a clock as svg elements */
class ClockElement {

  private static final double outerRadius = 92;
  private static final double innerRadius = 62;

  private final double centerX = 135;
  private final double centerY = 127;
  private final double radius = 20;

  private final double x;
  private final double y;
  private final double left;
  private final double top;

  private final int value;

  private SVGCircleElement circle;
  private SVGCircleElement innerCircle;
  private SVGLineElement line;
  private HTMLDivElement element;

  private ClockElement(
      int value,
      String text,
      double angle,
      double drawRadius,
      ColorScheme colorScheme,
      boolean isMinute) {
    this.value = value;
    double circleRadius = radius;
    Color innerColor = colorScheme.lighten_4();
    String elementStyle = TimePickerStyles.HOUR;
    if (isMinute) {
      if (value % 5 != 0) {
        circleRadius = 10;
        elementStyle = TimePickerStyles.SMALL_HOUR;
        innerColor = colorScheme.darker_2();
      }
    }

    this.x = centerX + drawRadius * Math.cos(angle);
    this.y = centerY + drawRadius * Math.sin(angle);

    this.left = x - circleRadius;
    this.top = y - circleRadius;

    this.circle = SVGUtil.createCircle(x, y, circleRadius, colorScheme.lighten_4().getHex());
    this.innerCircle = SVGUtil.createCircle(x, y, 2, innerColor.getHex());
    this.line = SVGUtil.createLine(centerX, centerY, x, y, colorScheme.lighten_4().getHex());
    this.element =
        DominoElement.of(div())
            .css(elementStyle)
            .style(
                "position: absolute; left:"
                    + left
                    + "px; top:"
                    + top
                    + "px; color: "
                    + Color.BLUE_GREY_DARKEN_1.getHex()
                    + ";")
            .textContent(text)
            .element();
  }

  /**
   * Draws an hour number element on the clock
   *
   * @param hour int
   * @param clockStyle {@link ClockStyle}
   * @param colorScheme The {@link ColorScheme} used to define different clock elements colors
   * @return new ClockElement instance
   */
  public static ClockElement createHour(int hour, ClockStyle clockStyle, ColorScheme colorScheme) {
    double angle = (3 * Math.PI / 2) + (hour * 5 * (Math.PI / 30));
    double drawRadius =
        (_24.equals(clockStyle) && hour <= 12 && hour > 0) ? innerRadius : outerRadius;
    return new ClockElement(hour, hour + "", angle, drawRadius, colorScheme, false);
  }

  /**
   * Draws a minute number element on the clock
   *
   * @param minute int
   * @param colorScheme The {@link ColorScheme} used to define different clock elements colors
   * @return new ClockElement instance
   */
  public static ClockElement createMinute(int minute, ColorScheme colorScheme) {
    String text = minute % 5 == 0 ? minute + "" : "";
    double angle = (3 * Math.PI / 2) + (minute * (Math.PI / 30));
    return new ClockElement(minute, text, angle, outerRadius, colorScheme, true);
  }

  /**
   * Draws a second number element on the clock
   *
   * @param second int
   * @param colorScheme The {@link ColorScheme} used to define different clock elements colors
   * @return new ClockElement instance
   */
  public static ClockElement createSecond(int second, ColorScheme colorScheme) {
    String text = second % 5 == 0 ? second + "" : "";
    double angle = (3 * Math.PI / 2) + (second * (Math.PI / 30));
    return new ClockElement(second, text, angle, outerRadius, colorScheme, true);
  }

  /** @return the int value of the element drawn bu this clock element */
  public int getValue() {
    return value;
  }

  /** @return the {@link SVGCircleElement} outer circle */
  public SVGCircleElement getCircle() {
    return circle;
  }
  /** @return the {@link SVGCircleElement} inner circle */
  public SVGCircleElement getInnerCircle() {
    return innerCircle;
  }

  /** @return the {@link SVGCircleElement} line */
  public SVGLineElement getLine() {
    return line;
  }

  /** @return the {@link HTMLDivElement} that contains the SVG element */
  public HTMLDivElement getElement() {
    return element;
  }
}
