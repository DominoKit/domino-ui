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
package org.dominokit.domino.ui.alerts;

import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * Base class for alerts to allow easy inheritance similar to BaseCard. Provides the structure, body
 * container and close button handling.
 */
public abstract class BaseAlert<A extends BaseAlert<A>> extends BaseDominoElement<HTMLDivElement, A>
    implements AlertStyles {

  protected final DivElement element;
  protected final DivElement bodyElement;
  protected LazyChild<RemoveButton> removeButton;

  /** Creates an alert without specific context. */
  protected BaseAlert() {
    element =
        div()
            .addCss(dui_alert)
            .setAttribute("role", "alert")
            .appendChild(bodyElement = div().addCss(dui_alert_body));
    removeButton = LazyChild.of(RemoveButton.create().addClickListener(evt -> remove()), element);
    init((A) this);
  }

  /** Show or hide the close button. Clicking the close button removes the alert from the DOM. */
  public A setDismissible(boolean dismissible) {
    if (dismissible) {
      return dismissible();
    } else {
      return unDismissible();
    }
  }

  /** Shortcut for setDismissible(true). */
  public A dismissible() {
    removeButton.get();
    return (A) this;
  }

  /** Shortcut for setDismissible(false). */
  public A unDismissible() {
    removeButton.remove();
    return (A) this;
  }

  /**
   * @return true if dismissible.
   */
  public boolean isDismissible() {
    return removeButton.isInitialized();
  }

  /** Access the close button; marks the alert as dismissible. */
  public RemoveButton getCloseButton() {
    return removeButton.get();
  }

  /** Apply customization to the close button while keeping fluent chain. */
  public A withCloseButton(ChildHandler<A, RemoveButton> handler) {
    handler.apply((A) this, removeButton.get());
    return (A) this;
  }

  /** Same as setDismissible(true). */
  public A withCloseButton() {
    removeButton.get();
    return (A) this;
  }

  @Override
  public Element getAppendTarget() {
    return bodyElement.element();
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
