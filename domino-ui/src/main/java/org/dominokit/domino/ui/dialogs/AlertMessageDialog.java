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
package org.dominokit.domino.ui.dialogs;

import static java.util.Objects.nonNull;

import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;

/**
 * AlertMessageDialog class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class AlertMessageDialog extends AbstractDialog<AlertMessageDialog> {

  private Button confirmButton;

  private MessageHandler confirmHandler = (dialog) -> {};

  private LazyChild<SpanElement> messageElement;

  private Transition iconStartTransition = Transition.ZOOM_IN;
  private Transition iconEndTransition = Transition.TADA;

  private int iconAnimationDuration = 1000;

  private LazyChild<Icon<?>> alertIcon = NullLazyChild.of();
  private LazyChild<NavBar> navHeader;

  /** @return new instance with empty title */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public static AlertMessageDialog create() {
    return new AlertMessageDialog();
  }

  /**
   * create.
   *
   * @param title String
   * @return new instance with custom title
   */
  public static AlertMessageDialog create(String title) {
    return new AlertMessageDialog(title);
  }

  /**
   * create.
   *
   * @param title String
   * @return new instance with custom title
   * @param message a {@link java.lang.String} object
   */
  public static AlertMessageDialog create(String title, String message) {
    return new AlertMessageDialog(title, message);
  }

  /** creates new instance with empty title */
  public AlertMessageDialog() {
    messageElement = LazyChild.of(span(), contentElement);
    navHeader = LazyChild.of(NavBar.create().addCss(dui_dialog_nav), headerElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.VERY_SMALL);
    setAutoClose(false);
    contentHeader.get().addCss(dui_justify_around);
    addExpandListener(
        (component) -> {
          if (alertIcon.isInitialized()) {
            Animation.create(getAlertIcon())
                .transition(iconStartTransition)
                .duration(iconAnimationDuration)
                .callback(
                    iconElement ->
                        Animation.create(getAlertIcon())
                            .transition(iconEndTransition)
                            .duration(iconAnimationDuration)
                            .animate())
                .animate();
          }
        });
  }

  /** @param title String creates new instance with custom title */
  /**
   * Constructor for AlertMessageDialog.
   *
   * @param title a {@link java.lang.String} object
   */
  public AlertMessageDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /** @param title String creates new instance with custom title */
  /**
   * Constructor for AlertMessageDialog.
   *
   * @param title a {@link java.lang.String} object
   * @param message a {@link java.lang.String} object
   */
  public AlertMessageDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  /**
   * setTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  /**
   * setMessage.
   *
   * @param message a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setMessage(String message) {
    messageElement.remove();
    appendChild(messageElement.get().setTextContent(message));
    return this;
  }

  private void appendButtons() {
    confirmButton =
        Button.create(labels.dialogOk())
            .addCss(dui_min_w_32)
            .addClickListener(
                evt -> {
                  if (nonNull(confirmHandler)) {
                    confirmHandler.onConfirm(AlertMessageDialog.this);
                  }
                });

    appendChild(FooterContent.of(confirmButton));

    withContentFooter((parent, self) -> self.addCss(dui_text_center));
  }

  /**
   * Sets the handler for the confirm action
   *
   * @param handler {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog.MessageHandler}
   * @return same ConfirmationDialog instance
   */
  public AlertMessageDialog onConfirm(MessageHandler handler) {
    this.confirmHandler = handler;
    return this;
  }

  /** @return the confirmation {@link Button} */
  /**
   * Getter for the field <code>confirmButton</code>.
   *
   * @return a {@link org.dominokit.domino.ui.button.LinkButton} object
   */
  public Button getConfirmButton() {
    return confirmButton;
  }

  /** @return the confirmation {@link Button} */
  /**
   * withConfirmButton.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog withConfirmButton(ChildHandler<AlertMessageDialog, Button> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /**
   * Getter for the field <code>iconStartTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getIconStartTransition() {
    return iconStartTransition;
  }

  /**
   * Setter for the field <code>iconStartTransition</code>.
   *
   * @param transition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setIconStartTransition(Transition transition) {
    this.iconStartTransition = transition;
    return this;
  }

  /**
   * Getter for the field <code>iconEndTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getIconEndTransition() {
    return iconEndTransition;
  }

  /**
   * Setter for the field <code>iconEndTransition</code>.
   *
   * @param transition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setIconEndTransition(Transition transition) {
    this.iconEndTransition = transition;
    return this;
  }

  /**
   * Getter for the field <code>iconAnimationDuration</code>.
   *
   * @return a int
   */
  public int getIconAnimationDuration() {
    return iconAnimationDuration;
  }

  /**
   * Setter for the field <code>iconAnimationDuration</code>.
   *
   * @param duration a int
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setIconAnimationDuration(int duration) {
    this.iconAnimationDuration = duration;
    return this;
  }

  /**
   * Getter for the field <code>alertIcon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getAlertIcon() {
    return alertIcon.get();
  }

  /**
   * Setter for the field <code>alertIcon</code>.
   *
   * @param alertIcon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog setAlertIcon(Icon<?> alertIcon) {
    if (nonNull(alertIcon)) {
      this.alertIcon.remove();
    }
    this.alertIcon = LazyChild.of(alertIcon, contentHeader);
    this.alertIcon.get();
    return this;
  }

  /**
   * withNavHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.dialogs.AlertMessageDialog} object
   */
  public AlertMessageDialog withNavHeader(ChildHandler<AlertMessageDialog, NavBar> handler) {
    handler.apply(this, navHeader.get());
    return this;
  }

  /** An interface to implement Confirm action handlers */
  @FunctionalInterface
  public interface MessageHandler {
    void onConfirm(AlertMessageDialog dialog);
  }
}
