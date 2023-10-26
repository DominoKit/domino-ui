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
package org.dominokit.domino.ui.style;

/**
 * Enum representing various styles for the Waves (ripple) effect.
 *
 * <p>This enumeration allows easy definition and use of different visual styles for the Waves
 * effect in the UI.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * element.addCss(WaveStyle.CIRCLE);
 * </pre>
 */
public enum WaveStyle implements HasCssClass {

  /** Represents a floating wave effect. */
  FLOAT(() -> "dui-waves-float"),

  /** Represents a circular wave effect. */
  CIRCLE(() -> "dui-waves-circle"),

  /** Represents a ripple wave effect. */
  RIPPLE(() -> "dui-waves-ripple"),

  /** Represents a block wave effect. */
  BLOCK(() -> "dui-waves-block");

  private final CssClass style;

  /**
   * Private constructor for defining a specific wave style.
   *
   * @param style the CSS class associated with the wave style.
   */
  WaveStyle(CssClass style) {
    this.style = style;
  }

  /**
   * Retrieves the CSS class associated with the specific wave style.
   *
   * @return the {@link CssClass} representing the wave style.
   */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
