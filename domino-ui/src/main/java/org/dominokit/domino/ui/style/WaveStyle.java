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

/** An enum representing the wave styles supported */
public enum WaveStyle implements HasCssClass {
  FLOAT(() -> "dui-waves-float"),
  CIRCLE(() -> "dui-waves-circle"),
  RIPPLE(() -> "dui-waves-ripple"),
  BLOCK(() -> "dui-waves-block");

  private final CssClass style;

  WaveStyle(CssClass style) {
    this.style = style;
  }

  /** @return the css style of the wave style */
  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
