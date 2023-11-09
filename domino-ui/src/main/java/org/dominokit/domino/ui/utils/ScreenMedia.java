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

package org.dominokit.domino.ui.utils;

/**
 * The {@code ScreenMedia} enum represents different screen media query states that can be used for
 * responsive web design. These media query states are typically used in conjunction with CSS to
 * apply styles based on the screen size.
 *
 * <p>This enum provides constants for various screen media query states, making it easier to work
 * with responsive design in the Domino UI framework.
 *
 * <p>The available screen media query states are:
 *
 * <ul>
 *   <li>{@link #XSMALL_ONLY}: For extra-small screens only.
 *   <li>{@link #XSMALL_AND_UP}: For extra-small screens and larger.
 *   <li>{@link #SMALL_ONLY}: For small screens only.
 *   <li>{@link #SMALL_AND_DOWN}: For small screens and smaller.
 *   <li>{@link #SMALL_AND_UP}: For small screens and larger.
 *   <li>{@link #MEDIUM_ONLY}: For medium screens only.
 *   <li>{@link #MEDIUM_AND_DOWN}: For medium screens and smaller.
 *   <li>{@link #MEDIUM_AND_UP}: For medium screens and larger.
 *   <li>{@link #LARGE_ONLY}: For large screens only.
 *   <li>{@link #LARGE_AND_DOWN}: For large screens and smaller.
 *   <li>{@link #LARGE_AND_UP}: For large screens and larger.
 *   <li>{@link #XLARGE_ONLY}: For extra-large screens only.
 *   <li>{@link #XLARGE_AND_DOWN}: For extra-large screens and smaller.
 *   <li>{@link #XLARGE_AND_UP}: For extra-large screens and larger.
 * </ul>
 *
 * <p>Each enum constant corresponds to a specific screen media query state and provides a {@code
 * style} that can be used in CSS classes or styles to apply responsive design.
 *
 * <p>For more information about responsive design and media queries, refer to the <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries" target="_blank">MDN
 * documentation</a>.
 */
public enum ScreenMedia {

  /** For extra-small screens only. */
  XSMALL_ONLY("xsmall-only"),

  /** For extra-small screens and larger. */
  XSMALL_AND_UP("xsmall-and-up"),

  /** For small screens only. */
  SMALL_ONLY("small-only"),

  /** For small screens and smaller. */
  SMALL_AND_DOWN("small-and-down"),

  /** For small screens and larger. */
  SMALL_AND_UP("small-and-up"),

  /** For medium screens only. */
  MEDIUM_ONLY("medium-only"),

  /** For medium screens and smaller. */
  MEDIUM_AND_DOWN("medium-and-down"),

  /** For medium screens and larger. */
  MEDIUM_AND_UP("medium-and-up"),

  /** For large screens only. */
  LARGE_ONLY("large-only"),

  /** For large screens and smaller. */
  LARGE_AND_DOWN("large-and-down"),

  /** For large screens and larger. */
  LARGE_AND_UP("large-and-up"),

  /** For extra-large screens only. */
  XLARGE_ONLY("xlarge-only"),

  /** For extra-large screens and smaller. */
  XLARGE_AND_DOWN("xlarge-and-down"),

  /** For extra-large screens and larger. */
  XLARGE_AND_UP("xlarge-and-up");

  private String style;

  /**
   * Creates a new {@code ScreenMedia} enum constant with the specified CSS style class.
   *
   * @param style The CSS style class representing the screen media query state.
   */
  ScreenMedia(String style) {
    this.style = style;
  }

  /**
   * Retrieves the CSS style class associated with this screen media query state.
   *
   * @return The CSS style class representing the screen media query state.
   */
  public String getStyle() {
    return style;
  }
}
