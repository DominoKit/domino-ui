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
package org.dominokit.domino.ui.tree;

/** An enum representing what toggles the tree item */
public enum ToggleTarget {
  /** any element inside the item */
  ANY("tgl-any"),
  /** the icon of the item */
  ICON("tgl-icon");

  private final String style;

  ToggleTarget(String style) {
    this.style = style;
  }

  /** @return the CSS style */
  public String getStyle() {
    return style;
  }
}
