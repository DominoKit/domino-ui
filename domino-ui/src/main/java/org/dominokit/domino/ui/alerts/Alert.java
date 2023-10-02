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

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.*;

/**
 * Displays a none floating message anywhere in the page, the message can be permanent or
 * dismissible
 *
 * <p>This component can be themed based on context, for example:
 *
 * <ul>
 *   <li>Success
 *   <li>Info
 *   <li>Warning
 *   <li>Error
 * </ul>
 *
 * <p>Example:
 *
 * <pre>
 *     Alert.success()
 *          .appendChild("Well done! ")
 *          .appendChild("You successfully read this important alert message.")
 * </pre>
 */
public class Alert extends BaseDominoElement<HTMLDivElement, Alert> {

  private final DivElement element;
  private final DivElement bodyElement;
  private LazyChild<RemoveButton> removeButton;

  /**
   * Creates an Alert message without assuming a specific context, context can be applied by adding
   * a context css class like <b>dui_success, dui_error, dui_info, .. etc</b>
   */
  public Alert() {
    element = div().addCss(dui_alert).appendChild(bodyElement = div().addCss(dui_alert_body));
    removeButton = LazyChild.of(RemoveButton.create().addClickListener(evt -> remove()), element);

    init(this);
  }

  /**
   * Factory method to create an Alert message without assuming a specific context, context can be
   * applied by adding a context css class like <b>dui_success, dui_error, dui_info, .. etc</b>
   *
   * @return new Alert instance
   */
  public static Alert create() {
    return new Alert();
  }

  /**
   * Factory method to create an Alert with primary context, primary context will set the message
   * background to the theme primary context color
   *
   * @return new Alert instance
   */
  public static Alert primary() {
    return create().addCss(dui_primary);
  }

  /**
   * Factory method to create an Alert with secondary context, primary context will set the message
   * background to the theme secondary context color
   *
   * @return new Alert instance
   */
  public static Alert secondary() {
    return create().addCss(dui_secondary);
  }

  /**
   * Factory method to create an Alert with dominant context, primary context will set the message
   * background to the theme dominant context color
   *
   * @return new Alert instance
   */
  public static Alert dominant() {
    return create().addCss(dui_dominant);
  }

  /**
   * Factory method to create an Alert with success context, primary context will set the message
   * background to the theme success context color
   *
   * @return new Alert instance
   */
  public static Alert success() {
    return create().addCss(dui_success);
  }

  /**
   * Factory method to create an Alert with info context, primary context will set the message
   * background to the theme info context color
   *
   * @return new Alert instance
   */
  public static Alert info() {
    return create().addCss(dui_info);
  }

  /**
   * Factory method to create an Alert with warning context, primary context will set the message
   * background to the theme warning context color
   *
   * @return new Alert instance
   */
  public static Alert warning() {
    return create().addCss(dui_warning);
  }

  /**
   * Factory method to create an Alert with error context, primary context will set the message
   * background to the theme error context color
   *
   * @return new Alert instance
   */
  public static Alert error() {
    return create().addCss(dui_error);
  }

  /**
   * Use to show or hide the Alert message close button, clicking the close button will remove the
   * Alert message from the dom.
   *
   * @param dismissible <b>true</b> to show the close button, <b>false</b> to hide the close button
   * @return same Alert instance
   */
  public Alert setDismissible(boolean dismissible) {
    if (dismissible) {
      return dismissible();
    } else {
      return unDismissible();
    }
  }

  /**
   * A shortcut method for <b>setDismissible(true)</b>
   *
   * @return same Alert instance
   */
  public Alert dismissible() {
    removeButton.get();
    return this;
  }

  /**
   * Shortcut method for <b>setDismissible(false)</b>
   *
   * @return same Alert instance
   */
  public Alert unDismissible() {
    removeButton.remove();
    return this;
  }

  /**
   * Use to check if the Alert instance is dismissible or not.
   *
   * @return true if the alert is dismissible, false otherwise
   */
  public boolean isDismissible() {
    return removeButton.isInitialized();
  }

  /**
   * When this method is called, it is assumed the button will be customized for a dismissible alert
   * and so the alert will be marked as dismissible.
   *
   * @return the close button element
   */
  public RemoveButton getCloseButton() {
    return removeButton.get();
  }

  /**
   * Applies customization on the close button without breaking the fluent API chain, this will have
   * the same effect as <b>getCloseButton()</b>
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return same Alert instance.
   */
  public Alert withCloseButton(ChildHandler<Alert, RemoveButton> handler) {
    handler.apply(this, removeButton.get());
    return this;
  }

  /**
   * This will be effectively same as <b>setDismissible(true)</b>
   *
   * @return a Alert object
   */
  public Alert withCloseButton() {
    removeButton.get();
    return this;
  }

  /** @hidden {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return bodyElement.element();
  }

  /** @hidden {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
