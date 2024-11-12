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
import static org.dominokit.domino.ui.utils.BaseDominoElement.ATTACH_UID_KEY;
import static org.dominokit.domino.ui.utils.BaseDominoElement.DETACH_UID_KEY;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.core.JsArray;
import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import elemental2.dom.MutationObserver;
import elemental2.dom.MutationObserverInit;
import elemental2.dom.MutationRecord;
import elemental2.dom.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jsinterop.base.Js;

/**
 * The {@code BodyObserver} class is responsible for observing mutations in the document's body. It
 * tracks the addition and removal of elements with specific attributes and dispatches events
 * accordingly.
 */
final class BodyObserver {

  private static boolean ready = false;
  private static boolean paused = false;
  private static MutationObserver mutationObserver;

  private BodyObserver() {}

  /**
   * Pauses the observer for a specified action and resumes it afterward.
   *
   * @param handler The action to perform while the observer is paused.
   */
  static void pauseFor(Runnable handler) {
    mutationObserver.disconnect();
    try {
      handler.run();
    } finally {
      observe();
    }
  }

  /** Starts observing mutations in the document's body. */
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
    Set<String> processed = new HashSet<>();
    for (int i = 0; i < nodes.size(); i++) {
      Node elementNode = Js.uncheckedCast(nodes.get(i));
      if (Node.ELEMENT_NODE == elementNode.nodeType) {
        HTMLElement element = Js.uncheckedCast(elementNode);
        List<DominoElement<Element>> childElements =
            elements.elementOf(element).querySelectorAll("[" + ATTACH_UID_KEY + "]");
        if (element.hasAttribute(ATTACH_UID_KEY)) {
          String type = ObserverEventType.attachedType(elements.elementOf(element));
          if (!processed.contains(type)) {
            processed.add(type);
            element.dispatchEvent(new CustomEvent<>(type));
          }
        }

        childElements.forEach(
            child -> {
              CustomEventInit<MutationRecord> ceinit = CustomEventInit.create();
              ceinit.setDetail(record);
              String type = ObserverEventType.attachedType(elements.elementOf(child));
              if (!processed.contains(type)) {
                processed.add(type);
                CustomEvent<MutationRecord> event = new CustomEvent<>(type, ceinit);
                child.element().dispatchEvent(event);
              }
            });
      }
    }
  }

  private static void onElementsRemoved(MutationRecord record) {
    List<Node> nodes = record.removedNodes.asList();
    Set<String> processed = new HashSet<>();
    for (int i = 0; i < nodes.size(); i++) {
      Node elementNode = Js.uncheckedCast(nodes.get(i));
      if (Node.ELEMENT_NODE == elementNode.nodeType) {
        HTMLElement element = Js.uncheckedCast(elementNode);
        List<DominoElement<Element>> childElements =
            elements.elementOf(element).querySelectorAll("[" + DETACH_UID_KEY + "]");
        if (element.hasAttribute(DETACH_UID_KEY)) {
          String type = ObserverEventType.detachedType(elements.elementOf(element));
          if (!processed.contains(type)) {
            processed.add(type);
            element.dispatchEvent(new Event(type));
          }
        }

        childElements.forEach(
            child -> {
              String type = ObserverEventType.detachedType(elements.elementOf(child));
              if (!processed.contains(type)) {
                processed.add(type);
                CustomEventInit<MutationRecord> ceinit = CustomEventInit.create();
                ceinit.setDetail(record);
                CustomEvent<MutationRecord> event = new CustomEvent<>(type, ceinit);
                child.element().dispatchEvent(event);
              }
            });
      }
    }
  }
}
