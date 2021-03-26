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
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.core.JsArray;
import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import jsinterop.base.Js;
import org.jboss.elemento.Id;
import org.jboss.elemento.ObserverCallback;

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

  private static String ATTACH_UID_KEY = "on-attach-uid";
  private static String DETACH_UID_KEY = "on-detach-uid";

  private static List<ElementObserver> detachObservers = new ArrayList<>();
  private static List<ElementObserver> attachObservers = new ArrayList<>();
  private static boolean ready = false;

  private BodyObserver() {}

  private static void startObserving() {
    MutationObserver mutationObserver =
        new MutationObserver(
            (JsArray<MutationRecord> records, MutationObserver observer) -> {
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
              return null;
            });

    MutationObserverInit mutationObserverInit = MutationObserverInit.create();
    mutationObserverInit.setChildList(true);
    mutationObserverInit.setSubtree(true);
    mutationObserver.observe(document.body, mutationObserverInit);
    ready = true;
  }

  private static void onElementsAppended(MutationRecord record) {
    List<Node> nodes = record.addedNodes.asList();
    List<ElementObserver> observed = new ArrayList<>();
    for (ElementObserver elementObserver : attachObservers) {
      if (isNull(elementObserver.observedElement())) {
        observed.add(elementObserver);
      } else {
        if (nodes.contains(elementObserver.observedElement())
            || isChildOfAddedNode(record, elementObserver.attachId())) {
          elementObserver.callback().onObserved(record);
          observed.add(elementObserver);
        }
      }
    }

    attachObservers.removeAll(observed);
  }

  private static boolean isChildOfAddedNode(MutationRecord record, String attachId) {
    return isChildOfObservedNode(attachId, record.addedNodes.asList(), ATTACH_UID_KEY);
  }

  private static void onElementsRemoved(MutationRecord record) {
    List<Node> nodes = record.removedNodes.asList();
    List<ElementObserver> observed = new ArrayList<>();
    for (ElementObserver elementObserver : detachObservers) {
      if (isNull(elementObserver.observedElement())) {
        observed.add(elementObserver);
      } else {
        if (nodes.contains(elementObserver.observedElement())
            || isChildOfRemovedNode(record, elementObserver.attachId())) {
          elementObserver.callback().onObserved(record);
          observed.add(elementObserver);
        }
      }
    }
    detachObservers.removeAll(observed);
  }

  private static boolean isChildOfRemovedNode(MutationRecord record, final String detachId) {
    return isChildOfObservedNode(detachId, record.removedNodes.asList(), DETACH_UID_KEY);
  }

  private static boolean isChildOfObservedNode(
      String attachId, List<Node> nodes, String attachUidKey) {

    for (int i = 0; i < nodes.size(); i++) {
      Node elementNode = Js.uncheckedCast(nodes.get(i));
      if (Node.ELEMENT_NODE == elementNode.nodeType) {
        if (nonNull(elementNode.querySelector("[" + attachUidKey + "='" + attachId + "']"))) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Check if the observer is already started, if not it will start it, then register and callback
   * for when the element is attached to the dom.
   *
   * @param element the {@link HTMLElement} we want to know when it get attached to the DOM
   * @param callback {@link ObserverCallback} to be called when the element is attached to the DOM
   * @return the {@link ElementObserver} that has attach information of the element and also can be
   *     used to remove the listener
   */
  static ElementObserver addAttachObserver(HTMLElement element, ObserverCallback callback) {
    if (!ready) {
      startObserving();
    }
    ElementObserver observer =
        createObserver(
            element,
            callback,
            ATTACH_UID_KEY,
            elementObserver -> attachObservers.remove(elementObserver));
    attachObservers.add(observer);
    return observer;
  }

  /**
   * Check if the observer is already started, if not it will start it, then register and callback
   * for when the element is removed from the dom.
   *
   * @param element the {@link HTMLElement} we want to know when it get detached from the DOM
   * @param callback {@link ObserverCallback} to be called when the element is detached from the DOM
   * @return the {@link ElementObserver} that has detach information of the element and also can be
   *     used to remove the listener
   */
  static ElementObserver addDetachObserver(HTMLElement element, ObserverCallback callback) {
    if (!ready) {
      startObserving();
    }
    ElementObserver observer =
        createObserver(
            element,
            callback,
            DETACH_UID_KEY,
            elementObserver -> detachObservers.remove(elementObserver));
    detachObservers.add(observer);

    return observer;
  }

  private static ElementObserver createObserver(
      HTMLElement element,
      ObserverCallback callback,
      String idAttributeName,
      Consumer<ElementObserver> onRemoveHandler) {
    String elementId = element.getAttribute(idAttributeName);
    if (elementId == null) {
      element.setAttribute(idAttributeName, Id.unique());
    }

    return new ElementObserver() {
      @Override
      public String attachId() {
        return element.getAttribute(idAttributeName);
      }

      @Override
      public HTMLElement observedElement() {
        return element;
      }

      @Override
      public ObserverCallback callback() {
        return callback;
      }

      @Override
      public void remove() {
        onRemoveHandler.accept(this);
      }
    };
  }
}
