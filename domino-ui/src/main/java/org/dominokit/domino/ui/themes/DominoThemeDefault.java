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
package org.dominokit.domino.ui.themes;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;

public class DominoThemeDefault implements IsDominoTheme, ElementsFactory, DominoCss {

  public static final IsDominoTheme INSTANCE = new DominoThemeDefault();

  private CssClass dui_theme_default = () -> "dui-theme-default";

  @Override
  public String getName() {
    return "dui-default";
  }

  @Override
  public String getCategory() {
    return "dui-main-theme";
  }

  @Override
  public void apply() {
    body().addCss(dui, dui_theme_default);
  }

  @Override
  public void cleanup() {
    body().removeCss(dui, dui_theme_default);
  }

  @Override
  public boolean isApplied() {
    return dui_theme_default.isAppliedTo(body());
  }
}
