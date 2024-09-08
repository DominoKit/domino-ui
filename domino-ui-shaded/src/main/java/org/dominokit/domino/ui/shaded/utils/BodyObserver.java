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
package org.dominokit.domino.ui.shaded.utils;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.shaded.utils.BaseDominoElement.ATTACH_UID_KEY;
import static org.dominokit.domino.ui.shaded.utils.BaseDominoElement.DETACH_UID_KEY;

import elemental2.core.JsArray;
import elemental2.dom.*;
import java.util.List;
import jsinterop.base.Js;

/**
 * This class allows us to listen to the elements attach/detach life cycle
 *
 * <p>the class will register a {@link MutationObserver} on the document body element only and uses
 * query selectors to get attached/detached elements from the dom
 *
 * <p>When we register an attach/detach listener on an element we assign it a special id attribute
 * <b>on-attach-uid</b>/<b>on-detach-uid</b> to help locating elements from the {@link
 * MutationRecord}s
 */
final class BodyObserver {

  private static boolean ready = false;
  private static boolean paused = false;
  private static MutationObserver mutationObserver;

  private BodyObserver() {}

  static void pauseFor(Runnable handler) {
    mutationObserver.disconnect();
    try {
      handler.run();
    } finally {
      observe();
    }
  }

  static void startObserving() {
    if (!ready) {
      mutationObserver =
          new MutationObserver(
              (JsArray<MutationRecord> records, MutationObserver observer) -> {
                if (!paused) {
                  MutationRecord[] recordsArray =
                      Js.uncheckedCast(records.asArray(new MutationRecord[records.length]));
                  for (MutationRecord record : recordsArray) {
                    if (!record.removedNodes.asList().isEmpty()) {
                      onElementsRemoved(record);
                    }

                    if (!record.addedNodes.asList().isEmpty()) {
                      onElementsAppended(record);
                    }
                  }
                }
                return null;
              });

      observe();
      ready = true;
    }
  }

  private static void observe() {
    MutationObserverInit mutationObserverInit = MutationObserverInit.create();
    mutationObserverInit.setChildList(true);
    mutationObserverInit.setSubtree(true);
    mutationObserver.observe(document.body, mutationObserverInit);
  }

  private static void onElementsAppended(MutationRecord record) {
    List<Node> nodes = record.addedNodes.asList();
    for (int i = 0; i < nodes.size(); i++) {
      Node elementNode = Js.uncheckedCast(nodes.get(i));
      if (Node.ELEMENT_NODE == elementNode.nodeType) {
        HTMLElement element = Js.uncheckedCast(elementNode);
        if (element.hasAttribute(ATTACH_UID_KEY)) {
          element.dispatchEvent(
              new Event(AttachDetachEventType.attachedType(DominoElement.of(element))));
        }
        DominoElement.of(element)
            .querySelectorAll("[" + ATTACH_UID_KEY + "]")
            .forEach(
                child -> {
                  CustomEventInit<MutationRecord> ceinit = CustomEventInit.create();
                  ceinit.setDetail(record);
                  CustomEvent<MutationRecord> event =
                      new CustomEvent<>(
                          AttachDetachEventType.attachedType(DominoElement.of(child)), ceinit);
                  child.element().dispatchEvent(event);
                });
      }
    }
  }

  private static void onElementsRemoved(MutationRecord record) {
    List<Node> nodes = record.removedNodes.asList();
    for (int i = 0; i < nodes.size(); i++) {
      Node elementNode = Js.uncheckedCast(nodes.get(i));
      if (Node.ELEMENT_NODE == elementNode.nodeType) {
        HTMLElement element = Js.uncheckedCast(elementNode);
        if (element.hasAttribute(DETACH_UID_KEY)) {
          element.dispatchEvent(
              new Event(AttachDetachEventType.detachedType(DominoElement.of(element))));
        }
        DominoElement.of(element)
            .querySelectorAll("[" + DETACH_UID_KEY + "]")
            .forEach(
                child -> {
                  CustomEventInit<MutationRecord> ceinit = CustomEventInit.create();
                  ceinit.setDetail(record);
                  CustomEvent<MutationRecord> event =
                      new CustomEvent<>(
                          AttachDetachEventType.detachedType(DominoElement.of(child)), ceinit);
                  child.element().dispatchEvent(event);
                });
      }
    }
  }
}
