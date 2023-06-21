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
 * Enum that lists different predefined informative styles
 *
 * <p>Each enum value represent a different css class to style the element
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public enum StyleType {
  /** a default style that indicate no special information */
  DEFAULT("default"),
  /** marks an element as a primary. */
  PRIMARY("primary"),
  /** indicates a success operation */
  SUCCESS("success"),
  /** mark an element as one that has some information */
  INFO("info"),
  /** mark an element as one that requires user attention */
  WARNING("warning"),
  /** indicates an error or something went wrong */
  DANGER("danger");

  private final String style;

  /** @param style String css class name */
  StyleType(String style) {
    this.style = style;
  }

  /** @return the css class name that represent the informative style. */
  /**
   * Getter for the field <code>style</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getStyle() {
    return style;
  }
}
