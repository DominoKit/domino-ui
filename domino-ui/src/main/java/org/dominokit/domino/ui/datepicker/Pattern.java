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

package org.dominokit.domino.ui.datepicker;

/**
 * Enumerates the different date patterns used for formatting and parsing dates.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * Pattern pattern = Pattern.FULL;
 * </pre>
 */
public enum Pattern {

  /** Represents a full pattern, usually the most verbose format. */
  FULL,

  /** Represents a long pattern, a detailed format excluding the most verbose elements. */
  LONG,

  /** Represents a medium pattern, less detailed than LONG but more than SHORT. */
  MEDIUM,

  /** Represents a short pattern, the least verbose format. */
  SHORT
}
