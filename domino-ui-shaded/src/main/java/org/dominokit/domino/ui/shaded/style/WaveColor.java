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
package org.dominokit.domino.ui.shaded.style;

/** An enum representing the waves colors supported */
public enum WaveColor {
  RED("waves-red"),
  PINK("waves-pink"),
  PURPLE("waves-purple"),
  DEEP_PURPLE("waves-deep-purple"),
  INDIGO("waves-indigo"),
  BLUE("waves-blue"),
  LIGHT_BLUE("waves-light-blue"),
  CYAN("waves-cyan"),
  TEAL("waves-teal"),
  GREEN("waves-green"),
  LIGHT_GREEN("waves-light-green"),
  LIME("waves-lime"),
  YELLOW("waves-yellow"),
  AMBER("waves-amber"),
  ORANGE("waves-orange"),
  DEEP_ORANGE("waves-deep-orange"),
  BROWN("waves-brown"),
  GREY("waves-grey"),
  BLUE_GREY("waves-blue-grey"),
  BLACK("waves-black"),
  WHITE("waves-white"),
  LIGHT("waves-light"),
  THEME("waves-theme");

  private final String style;

  WaveColor(String style) {
    this.style = style;
  }

  /** @return the style of the color */
  public String getStyle() {
    return style;
  }
}
