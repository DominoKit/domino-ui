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
package org.dominokit.domino.ui.menu.direction;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import java.util.List;
import org.dominokit.domino.ui.style.CssProperty;
import org.dominokit.domino.ui.utils.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceChecker {

  public static final String MAX_HEIGHT = "--dui-drop-down-menu-max-height";
  public static final String MAX_WIDTH = "--dui-drop-down-menu-max-width";

  private static final Logger LOGGER = LoggerFactory.getLogger(SpaceChecker.class);

  private final int innerWidth;
  private final int innerHeight;
  private final double sourceWidth;
  private final double sourceHeight;
  private final double leftSpace;
  private final double rightSpace;
  private final double topSpace;
  private final double bottomSpace;
  private final double targetWidth;
  private final double targetHeight;
  private final double targetTop;
  private final double targetBottom;
  private final double targetLeft;
  private final double targetRight;
  private final double sourceLeft;
  private final double sourceRight;
  private final double sourceTop;
  private final double sourceBottom;
  private final DOMRect targetRect;
  private final DOMRect sourceRect;

  public static SpaceChecker of(DropDirectionContext context) {
    return new SpaceChecker(context);
  }

  public SpaceChecker(DropDirectionContext context) {

    innerWidth = window.innerWidth;
    innerHeight = window.innerHeight;

    targetRect = context.getTarget().getBoundingClientRect();
    if (context.isFitToTargetWidth()) {
      elements.elementOf(context.getSource()).setWidth(Unit.px.of(targetRect.width));
    }
    sourceRect = context.getSource().getBoundingClientRect();

    sourceWidth = sourceRect.width;
    sourceHeight = sourceRect.height;
    sourceLeft = sourceRect.left;
    sourceRight = sourceRect.right;
    sourceTop = sourceRect.top;
    sourceBottom = sourceRect.bottom;

    targetWidth = targetRect.width;
    targetHeight = targetRect.height;
    targetTop = targetRect.top;
    targetBottom = targetRect.bottom;
    targetLeft = targetRect.left;
    targetRight = targetRect.right;

    leftSpace = targetRect.left;
    topSpace = targetRect.top - window.pageYOffset;
    rightSpace = innerWidth - targetRect.right - window.pageXOffset;
    bottomSpace = innerHeight - targetRect.bottom;
  }

  public boolean hasSpaceOnLeft() {
    return (leftSpace - getThresholdSideSpace("dui-reserve-left-space")) > sourceWidth;
  }

  public double getAvailableSpaceOnLeft() {
    return Math.max(
        0, leftSpace - window.pageXOffset - getThresholdSideSpace("dui-reserve-left-space"));
  }

  public double getAvailableSpaceOnRight() {
    return Math.max(0, rightSpace - getThresholdSideSpace("dui-reserve-right-space"));
  }

  public double getAvailableSpaceOnTop() {
    return Math.max(0, topSpace - getThresholdHeightSpace("dui-reserve-top-space"));
  }

  public double getAvailableSpaceOnBottom() {
    return Math.max(0, bottomSpace - getThresholdHeightSpace("dui-reserve-bottom-space"));
  }

  public boolean hasSpaceBelow() {
    return (bottomSpace - getThresholdHeightSpace("dui-reserve-bottom-space")) > sourceHeight;
  }

  public boolean hasSpaceOnRight() {
    return (rightSpace - getThresholdSideSpace("dui-reserve-right-space")) > sourceWidth;
  }

  public boolean hasSpaceAbove() {
    return (topSpace - getThresholdHeightSpace("dui-reserve-top-space")) > sourceHeight;
  }

  public double getThresholdSideSpace(String attribute) {
    List<Element> footerElements =
        DomGlobal.document.querySelectorAll("[" + attribute + "]").asList();
    return footerElements.stream()
        .filter(element -> Boolean.parseBoolean(element.getAttribute(attribute)))
        .mapToDouble(this::getVisibleWidth)
        .sum();
  }

  private double getVisibleWidth(Element element) {
    return elements.elementOf(element).getVisibleWidth();
  }

  public double getThresholdTopSpace() {
    return getThresholdHeightSpace("dui-reserve-top-space");
  }

  public double getThresholdHeightSpace(String attribute) {
    List<Element> footerElements =
        DomGlobal.document.querySelectorAll("[" + attribute + "]").asList();
    return footerElements.stream()
        .filter(element -> Boolean.parseBoolean(element.getAttribute(attribute)))
        .mapToDouble(this::getVisibleHeight)
        .sum();
  }

  private double getVisibleHeight(Element element) {
    return elements.elementOf(element).getVisibleHeight();
  }

  public int getInnerWidth() {
    return innerWidth;
  }

  public int getInnerHeight() {
    return innerHeight;
  }

  public double getSourceWidth() {
    return sourceWidth;
  }

  public double getSourceHeight() {
    return sourceHeight;
  }

  public double getLeftSpace() {
    return leftSpace;
  }

  public double getRightSpace() {
    return rightSpace;
  }

  public double getTopSpace() {
    return topSpace;
  }

  public double getBottomSpace() {
    return bottomSpace;
  }

  public double getTargetWidth() {
    return targetWidth;
  }

  public double getTargetHeight() {
    return targetHeight;
  }

  public double getTargetTop() {
    return targetTop;
  }

  public double getTargetBottom() {
    return targetBottom;
  }

  public double getTargetLeft() {
    return targetLeft;
  }

  public double getTargetRight() {
    return targetRight;
  }

  public double getSourceLeft() {
    return sourceLeft;
  }

  public double getSourceRight() {
    return sourceRight;
  }

  public double getSourceTop() {
    return sourceTop;
  }

  public double getSourceBottom() {
    return sourceBottom;
  }

  public double getMaximumSideSpace() {
    return Math.min(sourceWidth, Math.max(getAvailableSpaceOnLeft(), getAvailableSpaceOnRight()));
  }

  public double getMaximumVerticalSpace() {
    return Math.min(sourceHeight, Math.max(getAvailableSpaceOnTop(), getAvailableSpaceOnBottom()));
  }

  public CssProperty getMaximumSideSpaceProperty() {
    return CssProperty.of(MAX_WIDTH, Unit.px.of(getMaximumSideSpace()));
  }

  public CssProperty getMaximumVerticalSpaceProperty() {
    return CssProperty.of(MAX_HEIGHT, Unit.px.of(getMaximumVerticalSpace()));
  }
}
