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

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.CustomEvent;
import org.dominokit.domino.ui.events.CustomEvents;
import org.dominokit.domino.ui.events.EventType;

/**
 * The {@code PopupsCloser} class provides a utility for closing popups and elements that are marked
 * as auto-closable. It listens for click and touch events and automatically closes elements marked
 * as auto-closable.
 */
public class PopupsCloser {

  /** The CSS class name used to mark elements as auto-closable. */
  public static final String DOMINO_UI_AUTO_CLOSABLE = "domino-ui-auto-closable";

  public static final String DUI_AUTO_CLOSE = "dui-auto-close";

  private static boolean touchMoved;

  /** Initializes the PopupsCloser by adding event listeners for click and touch events. */
  static {
    document.addEventListener(EventType.click.getName(), evt -> close());
    document.addEventListener(EventType.touchmove.getName(), evt -> touchMoved = true);
    document.addEventListener(
        EventType.touchend.getName(),
        evt -> {
          if (!touchMoved) {
            close();
          }
          touchMoved = false;
        });
  }

  /** Closes all auto-closable elements marked with the default CSS class name. */
  public static void close() {
    close(DOMINO_UI_AUTO_CLOSABLE);
  }

  /**
   * Closes all auto-closable elements marked with the specified CSS class name.
   *
   * @param selector The CSS class name used to select auto-closable elements.
   */
  public static void close(String selector) {
    CustomEvent<String> closeEvent = CustomEvents.create(DUI_AUTO_CLOSE, selector);
    document.dispatchEvent(closeEvent);
  }
}
