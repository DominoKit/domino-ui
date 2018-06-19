package org.dominokit.domino.ui.timepicker;

import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
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

    public static SVGElement createSelectCaret(){

        SVGElement svg=(SVGElement)document.createElementNS(SVGNS, "svg");
        svg.classList.add("caret");
        svg.setAttributeNS(null, "height", "24");
        svg.setAttributeNS(null, "viewBox", "0 0 24 24");
        svg.setAttributeNS(null, "width", "24");

        SVGElement path1=(SVGElement)document.createElementNS(SVGNS, "path");
        path1.setAttributeNS(null, "d", "M7 10l5 5 5-5z");

        SVGElement path2=(SVGElement)document.createElementNS(SVGNS, "path");
        path2.setAttributeNS(null, "d", "M0 0h24v24H0z");
        path2.setAttributeNS(null, "fill", "none");

        svg.appendChild(path1);
        svg.appendChild(path2);


        return svg;
    }
}
