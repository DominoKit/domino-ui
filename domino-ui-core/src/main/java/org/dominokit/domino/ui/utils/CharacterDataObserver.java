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

import elemental2.core.JsArray;
import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.MutationObserver;
import elemental2.dom.MutationObserverInit;
import elemental2.dom.MutationRecord;
import elemental2.dom.Node;
import jsinterop.base.Js;

/**
 * The {@code BodyObserver} class is responsible for observing mutations in the document's body. It
 * tracks the addition and removal of elements with specific attributes and dispatches events
 * accordingly.
 */
public final class CharacterDataObserver {

  private static boolean ready = false;
  private static boolean paused = false;
  private static MutationObserver mutationObserver;

  private CharacterDataObserver() {}

  /**
   * Pauses the observer for a specified action and resumes it afterward.
   *
   * @param handler The action to perform while the observer is paused.
   */
  public static void pauseFor(Runnable handler) {
    paused = true;
    try {
      handler.run();
    } finally {
      DomGlobal.setTimeout(p0 -> paused = false, 0);
    }
  }

  /** Starts observing mutations in the document's body. */
  public static void startObserving() {
    if (!ready) {
      mutationObserver =
          new MutationObserver(
              (JsArray<MutationRecord> records, MutationObserver observer) -> {
                if (!paused) {
                  MutationRecord[] recordsArray =
                      Js.uncheckedCast(records.asArray(new MutationRecord[records.length]));
                  for (MutationRecord record : recordsArray) {
                    if ("characterData".equalsIgnoreCase(record.type)) {
                      onElementTextChanged(record);
                    }
                  }
                }
                return null;
              });

      observe();
      ready = true;
    }
  }

  private static void onElementTextChanged(MutationRecord record) {
    CustomEventInit<MutationRecord> ceinit = CustomEventInit.create();
    ceinit.setDetail(record);
    Node target = Js.uncheckedCast(record.target);
    Element parentElement = target.parentElement;
    String type = ObserverEventType.characterDataType(parentElement);

    CustomEvent<MutationRecord> event = new CustomEvent<>(type, ceinit);
    parentElement.dispatchEvent(event);
  }

  private static void observe() {
    MutationObserverInit mutationObserverInit = MutationObserverInit.create();
    mutationObserverInit.setSubtree(true);
    mutationObserverInit.setCharacterData(true);
    mutationObserverInit.setCharacterDataOldValue(true);
    mutationObserver.observe(document.body, mutationObserverInit);
  }
}
