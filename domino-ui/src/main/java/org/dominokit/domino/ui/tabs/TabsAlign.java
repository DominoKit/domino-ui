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

/** An enum to list possible values for tabs align */
public enum TabsAlign {
  /** Tabs headers will be aligned to the left of the tab panel */
  LEFT("tabs-left"),
  /** Tabs headers will be aligned to the center of the tab panel */
  CENTER("tabs-center"),
  /** Tabs headers will be aligned to the right of the tab panel */
  RIGHT("tabs-right");

  private String align;

  /** @param align String css class name for the tab align */
  TabsAlign(String align) {
    this.align = align;
  }

  /** @return String css class name for the tab align */
  public String getAlign() {
    return align;
  }
}
