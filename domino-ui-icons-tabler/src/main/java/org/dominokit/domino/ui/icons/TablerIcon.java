/*
 * Copyright © 2026 Dominokit
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
package org.dominokit.domino.ui.icons;

import static org.dominokit.domino.ui.utils.Domino.svg;

import org.dominokit.domino.ui.elements.SvgElement;

/** Inline SVG icon from the complete Tabler catalog. */
public final class TablerIcon extends AbstractSvgIcon<TablerIcon> {
  private final TablerIconDefinition definition;
  private final String catalogName;
  private final String variant;

  private TablerIcon(TablerIconDefinition definition) {
    super("tabler", definition.catalogName());
    this.definition = definition;
    this.catalogName = definition.catalogName();
    this.variant = definition.variant();
    root.classList.add("filled".equals(variant) ? "dui-icon-filled" : "dui-icon-outline");
    SvgElement svgElement = svg();
    svgElement.setAttribute("viewBox", definition.viewBox());
    svgElement.setAttribute("focusable", "false");
    svgElement.setAttribute("aria-hidden", "true");
    svgElement.element().innerHTML = definition.svg();
    if (svgElement.element().innerHTML == null || svgElement.element().innerHTML.isEmpty()) {
      throw new IllegalArgumentException("Unknown Tabler icon: " + catalogName);
    }
    icon.appendChild(svgElement);
  }

  public static TablerIcon create(TablerIconDefinition definition) {
    return new TablerIcon(definition);
  }

  public String getCatalogName() {
    return catalogName;
  }

  public String getVariant() {
    return variant;
  }

  @Override
  public TablerIcon setColor(String color) {
    return super.setColor(color);
  }

  @Override
  public TablerIcon setColor(String color, boolean important) {
    return super.setColor(color, important);
  }

  @Override
  public TablerIcon setFillColor(String color) {
    return super.setFillColor(color);
  }

  @Override
  public TablerIcon setStrokeColor(String color) {
    return super.setStrokeColor(color);
  }

  @Override
  public TablerIcon setFilledStrokeColor(String color) {
    return super.setFilledStrokeColor(color);
  }

  @Override
  public TablerIcon setStrokeWidth(double width) {
    return super.setStrokeWidth(width);
  }

  @Override
  public TablerIcon setStrokeLineCap(String lineCap) {
    return super.setStrokeLineCap(lineCap);
  }

  @Override
  public TablerIcon setStrokeLineJoin(String lineJoin) {
    return super.setStrokeLineJoin(lineJoin);
  }

  @Override
  public TablerIcon setFilled(boolean filled) {
    return super.setFilled(filled);
  }

  @Override
  public TablerIcon copy() {
    TablerIcon copy = create(definition);
    return copyPresentationTo(copy);
  }
}
