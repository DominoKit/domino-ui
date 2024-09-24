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

package org.dominokit.domino.ui.tabs;

import static org.dominokit.domino.ui.style.GenericCss.dui_vertical;
import static org.dominokit.domino.ui.style.SpacingCss.dui_flex_wrap;
import static org.dominokit.domino.ui.style.SpacingCss.dui_max_h_full;
import static org.dominokit.domino.ui.style.SpacingCss.dui_shrink_0;
import static org.dominokit.domino.ui.style.SpacingCss.dui_w_max;

public class TabsWrapHandler implements TabsOverflowHandler {
  @Override
  public void apply(TabsPanel tabsPanel) {
    update(tabsPanel);
  }

  @Override
  public void update(TabsPanel tabsPanel) {
    tabsPanel.withTabsNav(
        (parent, nav) -> {
          nav.addCss(dui_flex_wrap);
          if (dui_vertical.isAppliedTo(tabsPanel)) {
            nav.addCss(dui_max_h_full, dui_shrink_0, dui_w_max);
          } else {
            dui_max_h_full.remove(nav);
            dui_shrink_0.remove(nav);
            dui_w_max.remove(nav);
          }
        });
  }

  @Override
  public void cleanUp(TabsPanel tabsPanel) {
    tabsPanel.withTabsNav(
        (parent, nav) -> {
          dui_flex_wrap.remove(nav);
          dui_max_h_full.remove(nav);
          dui_shrink_0.remove(nav);
          dui_w_max.remove(nav);
        });
  }
}
