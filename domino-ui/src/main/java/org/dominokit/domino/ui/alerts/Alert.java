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

import static org.dominokit.domino.ui.alerts.AlertStyles.dui_alert;
import static org.dominokit.domino.ui.alerts.AlertStyles.dui_alert_body;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;

/**
 * Displays messages on the screen.
 *
 * <p>This component provides four basic types of severity:
 *
 * <ul>
 *   <li>Success
 *   <li>Info
 *   <li>Warning
 *   <li>Error
 * </ul>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link AlertStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Alert.success()
 *          .appendChild("Well done! ")
 *          .appendChild("You successfully read this important alert message.")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @see Color
 */
public class Alert extends BaseDominoElement<HTMLDivElement, Alert> {

  private boolean dismissible = false;
  private final DominoElement<HTMLDivElement> element;
  private final DominoElement<HTMLDivElement> bodyElement;
  private LazyChild<RemoveButton> removeButton;

  public Alert() {
    element =
        DominoElement.div()
            .addCss(dui_alert)
            .appendChild(bodyElement = DominoElement.div().addCss(dui_alert_body));
    removeButton = LazyChild.of(RemoveButton.create().addClickListener(evt -> remove()), element);

    init(this);
  }

  /**
   * Creates alert with default style
   *
   * @return new alert instance
   */
  public static Alert create() {
    return new Alert();
  }

  /**
   * Creates alert with primary context
   *
   * @return new alert instance
   */
  public static Alert primary() {
    return create().addCss(dui_primary);
  }

  /**
   * Creates alert with secondary context
   *
   * @return new alert instance
   */
  public static Alert secondary() {
    return create().addCss(dui_secondary);
  }

  /**
   * Creates alert with dominant context
   *
   * @return new alert instance
   */
  public static Alert dominant() {
    return create().addCss(dui_dominant);
  }

  /**
   * Creates alert with success context
   *
   * @return new alert instance
   */
  public static Alert success() {
    return create().addCss(dui_success);
  }

  /**
   * Creates alert with info context
   *
   * @return new alert instance
   */
  public static Alert info() {
    return create().addCss(dui_info);
  }

  /**
   * Creates alert with warning context
   *
   * @return new alert instance
   */
  public static Alert warning() {
    return create().addCss(dui_warning);
  }

  /**
   * Creates alert with error context
   *
   * @return new alert instance
   */
  public static Alert error() {
    return create().addCss(dui_error);
  }

  /**
   * Adds text as a child, the {@code text} will be added in {@link TextNode}
   *
   * @param text the content
   * @return same instance
   */
  public Alert appendChild(String text) {
    bodyElement.appendChild(TextNode.of(text));
    return this;
  }

  /**
   * Passing true means that the alert will be closable and a close button will be added to the
   * element to hide it
   *
   * @param dismissible true to set it as closable, false otherwise
   * @return same instance
   */
  public Alert setDismissible(boolean dismissible) {
    if (dismissible) {
      return dismissible();
    } else {
      return unDismissible();
    }
  }

  /**
   * Sets the alert to closable and a close button will be added to the element to hide it
   *
   * @return same instance
   */
  public Alert dismissible() {
    dismissible = true;
    removeButton.get();
    return this;
  }

  /**
   * Sets the alert to not closable and the close button will be removed if exist, the alert can be
   * hidden programmatically using {@link Alert#remove()}
   *
   * @return same instance
   */
  public Alert unDismissible() {
    dismissible = false;
    removeButton.remove();
    return this;
  }

  /** @return true if the alert is closable, false otherwise */
  public boolean isDismissible() {
    return dismissible;
  }

  /**
   * Returns the close button for customization
   *
   * @return the close button element
   */
  public RemoveButton getCloseButton() {
    return removeButton.get();
  }

  public Alert withCloseButton(ChildHandler<Alert, RemoveButton> handler) {
    handler.apply(this, removeButton.get());
    return this;
  }

  public Alert withCloseButton() {
    removeButton.get();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
