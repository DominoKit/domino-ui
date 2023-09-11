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

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;

public class DominoThemeDark implements IsDominoTheme, ElementsFactory, DominoCss {
  public static final IsDominoTheme INSTANCE = new DominoThemeDark();
  private CssClass dui_theme_dark = () -> "dui-colors-dark";

  @Override
  public String getName() {
    return "dui-theme-dark";
  }

  @Override
  public String getCategory() {
    return "dui-dark-mode";
  }

  @Override
  public void apply(Element element) {
    elementOf(element).addCss(dui_theme_dark);
  }

  @Override
  public void cleanup(Element element) {
    elementOf(element).removeCss(dui_theme_dark);
  }

  @Override
  public boolean isApplied(Element element) {
    return dui_theme_dark.isAppliedTo(element);
  }
}
