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
package org.dominokit.domino.ui.notifications;

import elemental2.dom.HTMLElement;

/** Display notification in top center */
public class TopCenterPosition extends NotificationPosition {

  protected TopCenterPosition() {
    super("top-center", "top");
  }

  @Override
  protected void onBeforePosition(HTMLElement element) {
    element.style.setProperty("top", "20px");
    element.style.setProperty("right", "0px");
    element.style.setProperty("left", "50%");
    element.style.setProperty("transform", "translate(-50%)");
  }

  @Override
  protected int getOffsetPosition(HTMLElement element) {
    return element.offsetTop;
  }
}
