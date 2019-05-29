package org.dominokit.domino.ui.timepicker;

import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGLineElement;

import static elemental2.dom.DomGlobal.document;

public class SVGUtil {

    public static final String SVGNS = "http://www.w3.org/2000/svg";

    public static SVGCircleElement createCircle(double x, double y, double r, String color) {
        SVGCircleElement circle = (SVGCircleElement) document.createElementNS(SVGNS, "circle");
        circle.setAttributeNS(null, "cx", x);
        circle.setAttributeNS(null, "cy", y);
        circle.setAttributeNS(null, "r", r);
        circle.setAttributeNS(null, "style", "stroke: none; fill: " + color + ";");
        return circle;
    }

    public static SVGLineElement createLine(double centerX, double centerY, double x, double y, String color) {
        SVGLineElement line = (SVGLineElement) document.createElementNS(SVGNS, "line");
        line.setAttributeNS(null, "x1", centerX);
        line.setAttributeNS(null, "y1", centerY);
        line.setAttributeNS(null, "x2", x);
        line.setAttributeNS(null, "y2", y);
        line.setAttributeNS(null, "style", "stroke: " + color + ";");
        return line;
    }
}
