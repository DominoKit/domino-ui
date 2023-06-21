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

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;
import org.dominokit.domino.ui.events.EventType;

/**
 * A utility class that close all opened popus based on a selector
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class PopupsCloser {

  /** Constant <code>DOMINO_UI_AUTO_CLOSABLE="domino-ui-auto-closable"</code> */
  public static final String DOMINO_UI_AUTO_CLOSABLE = "domino-ui-auto-closable";

  private static boolean touchMoved;

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

  /** close. */
  public static void close() {
    close(DOMINO_UI_AUTO_CLOSABLE);
  }

  /**
   * Close all popups that matches the provided selector
   *
   * @param selector a {@link java.lang.String} object
   */
  public static void close(String selector) {
    NodeList<Element> elementsByName = document.body.querySelectorAll("[" + selector + "]");
    for (int i = 0; i < elementsByName.length; i++) {
      HTMLElement element = Js.uncheckedCast(elementsByName.item(i));
      element.remove();
    }
  }
}
