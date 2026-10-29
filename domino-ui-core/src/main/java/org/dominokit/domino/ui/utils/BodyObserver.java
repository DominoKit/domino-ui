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

import elemental2.core.JsArray;
import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.MutationObserver;
import elemental2.dom.MutationObserverInit;
import elemental2.dom.MutationRecord;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jsinterop.base.Js;

/**
 * The {@code BodyObserver} class is responsible for observing mutations in the document's body. It
 * tracks the addition and removal of elements with specific attributes and dispatches events
 * accordingly.
 */
public final class BodyObserver {

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
    for (Node node : nodes) {
      if (Node.ELEMENT_NODE == node.nodeType) {
        Element element = Js.uncheckedCast(node);
        dispatchForElement(element, ATTACH_UID_KEY, record, processed, true);
        dispatchForDescendants(element, ATTACH_UID_KEY, record, processed, true);
      }
    }
  }

  private static void onElementsRemoved(MutationRecord record) {
    List<Node> nodes = record.removedNodes.asList();
    Set<String> processed = new HashSet<>();
    for (Node node : nodes) {
      if (Node.ELEMENT_NODE == node.nodeType) {
        Element element = Js.uncheckedCast(node);
        dispatchForElement(element, DETACH_UID_KEY, record, processed, false);
        dispatchForDescendants(element, DETACH_UID_KEY, record, processed, false);
      }
    }
  }

  private static void dispatchForElement(
      Element element,
      String observerAttribute,
      MutationRecord record,
      Set<String> processed,
      boolean attached) {
    if (element.hasAttribute(observerAttribute)) {
      String type =
          attached
              ? ObserverEventType.attachedType(element)
              : ObserverEventType.detachedType(element);
      dispatch(element, type, record, processed);
    }
  }

  private static void dispatchForDescendants(
      Element element,
      String observerAttribute,
      MutationRecord record,
      Set<String> processed,
      boolean attached) {
    NodeList<Element> children = element.querySelectorAll("[" + observerAttribute + "]");
    for (int index = 0; index < children.length; index++) {
      Element child = children.item(index);
      String type =
          attached ? ObserverEventType.attachedType(child) : ObserverEventType.detachedType(child);
      dispatch(child, type, record, processed);
    }
  }

  private static void dispatch(
      Element element, String type, MutationRecord record, Set<String> processed) {
    if (processed.add(type)) {
      CustomEventInit<MutationRecord> eventInit = CustomEventInit.create();
      eventInit.setDetail(record);
      element.dispatchEvent(new CustomEvent<>(type, eventInit));
    }
  }
}
