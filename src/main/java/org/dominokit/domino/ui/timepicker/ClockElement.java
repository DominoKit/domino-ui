package org.dominokit.domino.ui.timepicker;

import elemental2.dom.HTMLDivElement;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGLineElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;

import static org.dominokit.domino.ui.timepicker.ClockStyle._24;
import static org.jboss.gwt.elemento.core.Elements.div;

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

    private ClockElement(int value, String text, double angle, double drawRadius, ColorScheme colorScheme, boolean isMinute) {
        this.value = value;
        double circleRadius = radius;
        Color innerColor = colorScheme.lighten_4();
        String elementStyle = "hour";
        if (isMinute) {
            if (value % 5 != 0) {
                circleRadius = 10;
                elementStyle = "small-hour";
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
        this.element = div()
                .css(elementStyle)
                .style("position: absolute; left:" + left + "px; top:" + top + "px; color: " + Color.BLUE_GREY_DARKEN_1.getHex() + ";")
                .textContent(text).asElement();
    }


    public static ClockElement createHour(int hour, ClockStyle clockStyle, ColorScheme colorScheme) {
        double angle = (3 * Math.PI / 2) + (hour * 5 * (Math.PI / 30));
        double drawRadius = (_24.equals(clockStyle) && hour <= 12 && hour > 0) ? innerRadius : outerRadius;
        return new ClockElement(hour, hour + "", angle, drawRadius, colorScheme, false);
    }

    public static ClockElement createMinute(int minute, ColorScheme colorScheme) {
        String text = minute % 5 == 0 ? minute + "" : "";
        double angle = (3 * Math.PI / 2) + (minute * (Math.PI / 30));
        return new ClockElement(minute, text, angle, outerRadius, colorScheme, true);
    }

    public int getValue() {
        return value;
    }

    public SVGCircleElement getCircle() {
        return circle;
    }

    public SVGCircleElement getInnerCircle() {
        return innerCircle;
    }

    public SVGLineElement getLine() {
        return line;
    }

    public HTMLDivElement getElement() {
        return element;
    }
}
