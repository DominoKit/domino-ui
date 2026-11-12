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

/** Inline SVG icon from the complete Lucide catalog. */
public final class LucideIcon extends AbstractSvgIcon<LucideIcon> {
  private final LucideIconDefinition definition;
  private final String catalogName;
  private final String variant;

  private LucideIcon(LucideIconDefinition definition) {
    super("lucide", definition.catalogName());
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
      throw new IllegalArgumentException("Unknown Lucide icon: " + catalogName);
    }
    icon.appendChild(svgElement);
  }

  public static LucideIcon create(LucideIconDefinition definition) {
    return new LucideIcon(definition);
  }

  public String getCatalogName() {
    return catalogName;
  }

  public String getVariant() {
    return variant;
  }

  @Override
  public LucideIcon copy() {
    LucideIcon copy = create(definition);
    return copyPresentationTo(copy);
  }
}
