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
package org.dominokit.domino.ui.collapsible;

public enum CollapseDuration {
  _100ms("height-collapsed-trans-100", 100),
  _200ms("height-collapsed-trans-200", 200),
  _300ms("height-collapsed-trans-300", 300),
  _400ms("height-collapsed-trans-400", 400),
  _500ms("height-collapsed-trans-500", 500),
  _600ms("height-collapsed-trans-600", 600),
  _700ms("height-collapsed-trans-700", 700),
  _800ms("height-collapsed-trans-800", 800),
  _900ms("height-collapsed-trans-900", 900),
  _1000ms("height-collapsed-trans-1000", 1000);

  private final String style;
  private final int duration;

  CollapseDuration(String style, int duration) {
    this.style = style;
    this.duration = duration;
  }

  public String getStyle() {
    return style;
  }

  public int getDuration() {
    return duration;
  }
}
