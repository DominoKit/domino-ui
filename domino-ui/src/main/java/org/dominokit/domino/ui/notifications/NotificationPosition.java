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

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import java.util.List;
import jsinterop.base.Js;

/** Abstract class for placing the notification in a specific position */
public abstract class NotificationPosition implements Notification.Position {

  public static final String DATA_POSITION = "data-position";

  private final String selector;
  private final String positionProperty;

  protected NotificationPosition(String selector, String positionProperty) {
    this.selector = selector;
    this.positionProperty = positionProperty;
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAttach(HTMLElement element) {
    element.setAttribute(DATA_POSITION, "20");
    element.setAttribute("data-notify-position", selector);
    onBeforePosition(element);
  }

  protected abstract void onBeforePosition(HTMLElement element);

  /** {@inheritDoc} */
  @Override
  public void onNewElement(HTMLElement element) {
    List<Element> elements = getElements();
    elements.forEach(
        e -> {
          HTMLElement htmlElement = Js.cast(e);
          int position = getDataPosition(htmlElement);
          if (htmlElement != element) {
            int newPosition = position + (element.offsetHeight + getOffsetPosition(element));
            htmlElement.setAttribute(DATA_POSITION, newPosition);
            htmlElement.style.setProperty(positionProperty, newPosition + "px");
          }
        });
  }

  protected abstract int getOffsetPosition(HTMLElement element);

  private int getDataPosition(HTMLElement htmlElement) {
    return Integer.parseInt(htmlElement.getAttribute(DATA_POSITION));
  }

  private List<Element> getElements() {
    return document.querySelectorAll("div[data-notify-position=" + selector + "]").asList();
  }

  /** {@inheritDoc} */
  @Override
  public void onRemoveElement(int dataPosition, int height) {
    List<Element> elements = getElements();
    elements.forEach(
        e -> {
          HTMLElement htmlElement = Js.cast(e);
          int position = getDataPosition(htmlElement);
          if (position > dataPosition) {
            int newPosition = position - height - 20;
            e.setAttribute(DATA_POSITION, newPosition);
            htmlElement.style.setProperty(positionProperty, newPosition + "px");
          }
        });
  }
}
