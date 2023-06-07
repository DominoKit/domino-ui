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

import elemental2.dom.HTMLDivElement;
import elemental2.svg.SVGCircleElement;
import org.dominokit.domino.ui.elements.CircleElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LineElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Unit.px;
import static org.dominokit.domino.ui.timepicker.ClockStyle._24;

/**
 * The class is responsible for rendering a clock as svg elements
 */
class ClockElement extends BaseDominoElement<HTMLDivElement, ClockElement> {

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

    private CircleElement circle;
    private CircleElement innerCircle;
    private LineElement line;
    private DivElement element;

    private ClockElement(
            int value,
            String text,
            double angle,
            double drawRadius,
            boolean isMinute) {
        this.value = value;
        double circleRadius = radius;
        CssClass elementStyle = TimePickerStyles.dui_hour;
        if (isMinute) {
            if (value % 5 != 0) {
                circleRadius = 10;
                elementStyle = TimePickerStyles.dui_small_hour;
            }
        }

        this.x = centerX + drawRadius * Math.cos(angle);
        this.y = centerY + drawRadius * Math.sin(angle);

        this.left = x - circleRadius;
        this.top = y - circleRadius;

        this.circle = circle(x, y, circleRadius);
        this.innerCircle = circle(x, y, 2);
        this.line = line(centerX, centerY, x, y);
        this.element =
                div()
                        .addCss(elementStyle, dui_absolute)
                        .setLeft(px.of(left))
                        .setTop(px.of(top))
                        .textContent(text);
        init(this);
    }

    /**
     * Draws an hour number element on the clock
     *
     * @param hour        int
     * @param clockStyle  {@link ClockStyle}
     * @return new ClockElement instance
     */
    public static ClockElement createHour(int hour, ClockStyle clockStyle) {
        double angle = (3 * Math.PI / 2) + (hour * 5 * (Math.PI / 30));
        double drawRadius =
                (_24.equals(clockStyle) && hour <= 12 && hour > 0) ? innerRadius : outerRadius;
        return new ClockElement(hour, hour + "", angle, drawRadius,  false);
    }

    /**
     * Draws a minute number element on the clock
     *
     * @param minute      int
     * @return new ClockElement instance
     */
    public static ClockElement createMinute(int minute) {
        String text = minute % 5 == 0 ? minute + "" : "";
        double angle = (3 * Math.PI / 2) + (minute * (Math.PI / 30));
        return new ClockElement(minute, text, angle, outerRadius,  true);
    }

    /**
     * Draws a second number element on the clock
     *
     * @param second      int
     * @return new ClockElement instance
     */
    public static ClockElement createSecond(int second) {
        String text = second % 5 == 0 ? second + "" : "";
        double angle = (3 * Math.PI / 2) + (second * (Math.PI / 30));
        return new ClockElement(second, text, angle, outerRadius,  true);
    }

    /**
     * @return the int value of the element drawn on this clock element
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the {@link SVGCircleElement} outer circle
     */
    public CircleElement getCircle() {
        return circle;
    }

    /**
     * @return the {@link SVGCircleElement} inner circle
     */
    public CircleElement getInnerCircle() {
        return innerCircle;
    }

    /**
     * @return the {@link SVGCircleElement} line
     */
    public LineElement getLine() {
        return line;
    }

    /**
     * @return the {@link HTMLDivElement} that contains the SVG element
     */
    public HTMLDivElement element() {
        return element.element();
    }
}
