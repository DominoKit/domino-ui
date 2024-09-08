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
package org.dominokit.domino.ui.shaded.button;

/**
 * An enum that lists all predefined button sizes. each enum value represent one css class that
 * changes the button height.
 */
public enum ButtonSize {
  /** Large height */
  LARGE("lg"),
  /** Medium height */
  MEDIUM("md"),
  /** Small height */
  SMALL("sm"),
  /** Extra small height */
  XSMALL("xs");

  private String style;

  /** @param style String css class name */
  ButtonSize(String style) {
    this.style = style;
  }

  /** @return String css class name for a button size */
  public String getStyle() {
    return style;
  }
}
