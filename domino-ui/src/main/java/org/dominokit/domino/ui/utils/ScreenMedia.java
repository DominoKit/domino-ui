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
 * an enum that lists a set css classes that controls the visibility of the element based on screen
 * media
 */
public enum ScreenMedia {
  /**
   * The component will be visible for very small screens only
   *
   * <pre>max-width: 768px</pre>
   */
  XSMALL_ONLY("xsmall-only"),
  /**
   * The component will be visible for very small screens and larger screens, in short all screens
   */
  XSMALL_AND_UP("xsmall-and-up"),
  /**
   * The component will be visible for small screens only
   *
   * <pre>width between 768px and 992px</pre>
   */
  SMALL_ONLY("small-only"),
  /**
   * The component will be visible for small and very small screens only
   *
   * <pre>max-width: 992px</pre>
   */
  SMALL_AND_DOWN("small-and-down"),
  /**
   * The component will be visible for all screen except very small screens
   *
   * <pre>min-width: 768px</pre>
   */
  SMALL_AND_UP("small-and-up"),

  /**
   * The component will be visible for small and medium size screens only
   *
   * <pre>width between 992px and 1200px</pre>
   */
  MEDIUM_ONLY("medium-only"),

  /**
   * The component will be visible for medium, small and very small screens only
   *
   * <pre>max width 1200px</pre>
   */
  MEDIUM_AND_DOWN("medium-and-down"),

  /**
   * The component will be visible for medium and larger screens only
   *
   * <pre>min width 992px</pre>
   */
  MEDIUM_AND_UP("medium-and-up"),

  /**
   * The component will be visible for large screens only
   *
   * <pre>width between 1200px and 1800px</pre>
   */
  LARGE_ONLY("large-only"),

  /**
   * The component will be visible for large, medium, small and x-small screens only
   *
   * <pre>max width 1800px</pre>
   */
  LARGE_AND_DOWN("large-and-down"),

  /**
   * The component will be visible for large and larger screens only
   *
   * <pre>min width 1200px</pre>
   */
  LARGE_AND_UP("large-and-up"),

  /**
   * The component will be visible for x-large screens only
   *
   * <pre>min width 1800px</pre>
   */
  XLARGE_ONLY("xlarge-only"),

  /**
   * The component will be visible for x-large and smaller screens only
   *
   * <pre>max width 1800px</pre>
   */
  XLARGE_AND_DOWN("xlarge-and-down"),

  /**
   * The component will be visible for x-large or larger screens
   *
   * <pre>min width 1800px</pre>
   */
  XLARGE_AND_UP("xlarge-and-up");

  private String style;

  /** @param style String css class name for the screen media */
  ScreenMedia(String style) {
    this.style = style;
  }

  /** @return String css class name for the screen media */
  /**
   * Getter for the field <code>style</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getStyle() {
    return style;
  }
}
