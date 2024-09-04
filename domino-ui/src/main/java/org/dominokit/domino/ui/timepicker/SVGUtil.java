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

import static elemental2.dom.DomGlobal.document;

import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGLineElement;

/** A utility class to help with drawing SVG elements */
@Deprecated
public class SVGUtil {

  /** SVG namespace */
  public static final String SVGNS = "http://www.w3.org/2000/svg";

  /**
   * Draws an SVG circle
   *
   * @param x int center x
   * @param y int center y
   * @param r int radius
   * @param color String fill color
   * @return new SVGCircleElement
   */
  public static SVGCircleElement createCircle(double x, double y, double r, String color) {
    SVGCircleElement circle = (SVGCircleElement) document.createElementNS(SVGNS, "circle");
    circle.setAttributeNS(null, "cx", x);
    circle.setAttributeNS(null, "cy", y);
    circle.setAttributeNS(null, "r", r);
    circle.setAttributeNS(null, "style", "stroke: none; fill: " + color + ";");
    return circle;
  }

  /**
   * Draws an SVG line
   *
   * @param centerX int first point x
   * @param centerY int first point y
   * @param x int second point x
   * @param y int second point y
   * @param color String stroke color
   * @return new SVGLineElement
   */
  public static SVGLineElement createLine(
      double centerX, double centerY, double x, double y, String color) {
    SVGLineElement line = (SVGLineElement) document.createElementNS(SVGNS, "line");
    line.setAttributeNS(null, "x1", centerX);
    line.setAttributeNS(null, "y1", centerY);
    line.setAttributeNS(null, "x2", x);
    line.setAttributeNS(null, "y2", y);
    line.setAttributeNS(null, "style", "stroke: " + color + ";");
    return line;
  }
}
