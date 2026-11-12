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

/** Shared styling controls for icon packs rendered as SVG paths. */
public abstract class AbstractSvgIcon<T extends AbstractSvgIcon<T>> extends AbstractIcon<T> {

  protected AbstractSvgIcon(String pack, String catalogName) {
    super(pack, catalogName);
  }

  @Override
  public T setColor(String color) {
    setIconColorProperties(color);
    return super.setColor(color);
  }

  @Override
  public T setColor(String color, boolean important) {
    setIconColorProperties(color);
    return super.setColor(color, important);
  }

  /** Sets the fill color used by filled SVG variants. */
  public T setFillColor(String color) {
    return setIconProperty("--dui-icon-fill-color", color);
  }

  /** Sets the stroke color used by outline SVG variants. */
  public T setStrokeColor(String color) {
    return setIconProperty("--dui-icon-stroke-color", color);
  }

  /** Sets the stroke color used by filled SVG variants. */
  public T setFilledStrokeColor(String color) {
    return setIconProperty("--dui-icon-filled-stroke-color", color);
  }

  /** Sets the SVG stroke width. */
  public T setStrokeWidth(double width) {
    return setIconProperty("--dui-icon-stroke-width", String.valueOf(width));
  }

  /** Sets the SVG stroke line cap. */
  public T setStrokeLineCap(String lineCap) {
    return setIconProperty("--dui-icon-stroke-linecap", lineCap);
  }

  /** Sets the SVG stroke line join. */
  public T setStrokeLineJoin(String lineJoin) {
    return setIconProperty("--dui-icon-stroke-linejoin", lineJoin);
  }

  /** Switches between the pack's outline and filled SVG styling. */
  public T setFilled(boolean filled) {
    if (filled) {
      root.classList.remove("dui-icon-outline");
      root.classList.add("dui-icon-filled");
    } else {
      root.classList.remove("dui-icon-filled");
      root.classList.add("dui-icon-outline");
    }
    return (T) this;
  }

  private void setIconColorProperties(String color) {
    root.style.setProperty("--dui-icon-color", color);
    root.style.setProperty("--dui-icon-fill-color", color);
    root.style.setProperty("--dui-icon-stroke-color", color);
  }

  private T setIconProperty(String property, String value) {
    if (value == null || value.isEmpty()) {
      root.style.removeProperty(property);
    } else {
      root.style.setProperty(property, value);
    }
    return (T) this;
  }
}
