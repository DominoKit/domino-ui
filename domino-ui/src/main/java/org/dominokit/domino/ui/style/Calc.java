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
 * A utility class for creating {@code calc} CSS property
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Calc {

  /**
   * Creates calc by subtracting left from right
   *
   * @param left the left value
   * @param right the right value
   * @return the string CSS property
   */
  public static String sub(String left, String right) {
    return "calc(" + left + " - " + right + ")";
  }

  /**
   * Creates calc by summation left from right
   *
   * @param left the left value
   * @param right the right value
   * @return the string CSS property
   */
  public static String sum(String left, String right) {
    return "calc(" + left + " + " + right + ")";
  }

  /**
   * Creates calc with a size
   *
   * @param size the formulate string value
   * @return the string CSS property
   */
  public static String of(String size) {
    return "calc(" + size + ")";
  }
}
