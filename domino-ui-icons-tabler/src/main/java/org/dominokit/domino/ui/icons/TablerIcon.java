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
public final class TablerIcon extends AbstractIcon<TablerIcon> {
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

  public static TablerIcon create(IconName role) {
    return TablerIconProvider.INSTANCE.icon(role);
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

  public TablerIcon setStrokeWidth(double width) {
    root.style.setProperty("--dui-icon-stroke-width", String.valueOf(width));
    return this;
  }

  @Override
  public TablerIcon copy() {
    TablerIcon copy = create(definition);
    String strokeWidth = root.style.getPropertyValue("--dui-icon-stroke-width");
    if (!strokeWidth.isEmpty()) copy.root.style.setProperty("--dui-icon-stroke-width", strokeWidth);
    return copyPresentationTo(copy);
  }
}
