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

/** Google Material Symbols rendered as font ligatures with variable font axes. */
public final class MaterialSymbolsIcon extends AbstractIcon<MaterialSymbolsIcon> {
  private final String ligature;
  private double fill = 0;
  private double weight = 400;
  private double grade = 0;
  private double opticalSize = 24;

  private MaterialSymbolsIcon(String ligature) {
    super("material-symbols", ligature);
    this.ligature = ligature;
    root.textContent = ligature;
    root.setAttribute("aria-label", ligature.replace('_', ' '));
    root.setAttribute("role", "img");
    applyAxes();
  }

  /** Creates an icon from a Google Material Symbols ligature name. */
  public static MaterialSymbolsIcon create(String ligature) {
    return new MaterialSymbolsIcon(ligature);
  }

  public String getLigature() {
    return ligature;
  }

  public MaterialSymbolsIcon setFill(double fill) {
    this.fill = clamp(fill, 0, 1);
    return applyAxes();
  }

  public MaterialSymbolsIcon setWeight(double weight) {
    this.weight = clamp(weight, 100, 700);
    return applyAxes();
  }

  public MaterialSymbolsIcon setGrade(double grade) {
    this.grade = clamp(grade, -50, 200);
    return applyAxes();
  }

  public MaterialSymbolsIcon setOpticalSize(double opticalSize) {
    this.opticalSize = clamp(opticalSize, 20, 48);
    return applyAxes();
  }

  private MaterialSymbolsIcon applyAxes() {
    root.style.setProperty("--dui-symbol-fill", String.valueOf(fill));
    root.style.setProperty("--dui-symbol-weight", String.valueOf(weight));
    root.style.setProperty("--dui-symbol-grade", String.valueOf(grade));
    root.style.setProperty("--dui-symbol-optical-size", String.valueOf(opticalSize));
    return this;
  }

  private double clamp(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }

  @Override
  public MaterialSymbolsIcon copy() {
    MaterialSymbolsIcon copy = create(ligature);
    copy.fill = fill;
    copy.weight = weight;
    copy.grade = grade;
    copy.opticalSize = opticalSize;
    copy.applyAxes();
    return copyPresentationTo(copy);
  }
}
