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

import elemental2.dom.ScrollIntoViewOptions;
import jsinterop.base.Js;

/**
 * The {@code ScrollOptions} class provides a fluent API for configuring scroll behavior. This class
 * includes enumerations and methods to specify scroll behavior, block alignment, and inline
 * alignment while scrolling an element into view.
 */
public class ScrollOptions {

  public enum ScrollBehavior {
    AUTO("auto"),
    SMOOTH("smooth"),
    INSTANT("instant");

    private final String value;

    ScrollBehavior(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum ScrollBlock {
    START("start"),
    CENTER("center"),
    END("end"),
    NEAREST("nearest");

    private final String value;

    ScrollBlock(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum ScrollInline {
    START("start"),
    CENTER("center"),
    END("end"),
    NEAREST("nearest");

    private final String value;

    ScrollInline(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  private ScrollBehavior behavior;
  private ScrollBlock block;
  private ScrollInline inline;

  private ScrollOptions() {}

  public static ScrollOptions create() {
    return new ScrollOptions();
  }

  public ScrollOptions setBehavior(ScrollBehavior behavior) {
    this.behavior = behavior;
    return this;
  }

  public ScrollOptions setBlock(ScrollBlock block) {
    this.block = block;
    return this;
  }

  public ScrollOptions setInline(ScrollInline inline) {
    this.inline = inline;
    return this;
  }

  public ScrollIntoViewOptions build() {
    ScrollIntoViewOptions options = Js.uncheckedCast(new Object());
    if (behavior != null) {
      options.setBehavior(behavior.getValue());
    }
    if (block != null) {
      options.setBlock(block.getValue());
    }
    if (inline != null) {
      options.setInline(inline.getValue());
    }
    return options;
  }
}
