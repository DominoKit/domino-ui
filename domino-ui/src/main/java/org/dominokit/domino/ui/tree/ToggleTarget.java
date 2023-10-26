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

/**
 * An enumeration representing the toggle target for a tree item in a UI tree.
 *
 * <p>The toggle target specifies where a tree item can be clicked to toggle its state.
 *
 * @see TreeItem
 */
public enum ToggleTarget {

  /**
   * Represents the "Any" toggle target style. Clicking anywhere on the tree item can toggle its
   * state.
   */
  ANY("tgl-any"),

  /**
   * Represents the "Icon" toggle target style. Clicking the icon of the tree item can toggle its
   * state.
   */
  ICON("tgl-icon");

  private final String style;

  /**
   * Creates a new ToggleTarget instance with the specified style.
   *
   * @param style The style associated with this toggle target.
   */
  ToggleTarget(String style) {
    this.style = style;
  }

  /**
   * Gets the style associated with this toggle target.
   *
   * @return The style string representing this toggle target.
   */
  public String getStyle() {
    return style;
  }
}
