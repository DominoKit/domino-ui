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
import static org.dominokit.domino.ui.utils.Domino.*;

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
 * The AlertMessageDialog class provides an alert message dialog that can display messages with a
 * confirmation button.
 *
 * <p>Sample usage:
 *
 * <pre>
 *  AlertMessageDialog dialog = AlertMessageDialog.create("Confirmation", "Are you sure you want to proceed?")
 *    .onConfirm(alert -> {
 *      // Handle the confirmation logic here
 *    })
 *    .open();
 * </pre>
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

  /**
   * Creates a new instance of {@link AlertMessageDialog}.
   *
   * @return A new {@link AlertMessageDialog} instance with no title or message.
   */
  public static AlertMessageDialog create() {
    return new AlertMessageDialog();
  }

  /**
   * Creates a new instance of {@link AlertMessageDialog} with the specified title.
   *
   * @param title The title for the dialog.
   * @return A new {@link AlertMessageDialog} instance with the specified title and no message.
   */
  public static AlertMessageDialog create(String title) {
    return new AlertMessageDialog(title);
  }

  /**
   * Creates a new instance of {@link AlertMessageDialog} with the specified title and message.
   *
   * @param title The title for the dialog.
   * @param message The message to display in the dialog.
   * @return A new {@link AlertMessageDialog} instance with the specified title and message.
   */
  public static AlertMessageDialog create(String title, String message) {
    return new AlertMessageDialog(title, message);
  }

  /** Creates an empty AlertMessageDialog. */
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

  /**
   * Creates an AlertMessageDialog with a specified title.
   *
   * @param title The title of the dialog.
   */
  public AlertMessageDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /**
   * Creates an AlertMessageDialog with a specified title and message.
   *
   * @param title The title of the dialog.
   * @param message The message to display in the dialog.
   */
  public AlertMessageDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  /**
   * Sets the title of the AlertMessageDialog.
   *
   * @param title The title to set.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  /**
   * Sets the message to be displayed in the AlertMessageDialog.
   *
   * @param message The message to set.
   * @return This AlertMessageDialog instance.
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
   * Sets the handler for the confirmation button click event.
   *
   * @param handler The handler to be invoked when the confirmation button is clicked.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog onConfirm(MessageHandler handler) {
    this.confirmHandler = handler;
    return this;
  }

  /**
   * Gets the confirmation button of the AlertMessageDialog.
   *
   * @return The confirmation Button.
   */
  public Button getConfirmButton() {
    return confirmButton;
  }

  /**
   * Allows customization of the confirmation button using a handler.
   *
   * @param handler The handler for customizing the confirmation button.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog withConfirmButton(ChildHandler<AlertMessageDialog, Button> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /**
   * Gets the transition used for starting the icon animation.
   *
   * @return The start Transition.
   */
  public Transition getIconStartTransition() {
    return iconStartTransition;
  }

  /**
   * Sets the transition used for starting the icon animation.
   *
   * @param transition The start Transition to set.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog setIconStartTransition(Transition transition) {
    this.iconStartTransition = transition;
    return this;
  }

  /**
   * Gets the transition used for ending the icon animation.
   *
   * @return The end Transition.
   */
  public Transition getIconEndTransition() {
    return iconEndTransition;
  }

  /**
   * Sets the transition used for ending the icon animation.
   *
   * @param transition The end Transition to set.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog setIconEndTransition(Transition transition) {
    this.iconEndTransition = transition;
    return this;
  }

  /**
   * Gets the duration of the icon animation.
   *
   * @return The animation duration in milliseconds.
   */
  public int getIconAnimationDuration() {
    return iconAnimationDuration;
  }

  /**
   * Sets the duration of the icon animation.
   *
   * @param duration The animation duration to set in milliseconds.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog setIconAnimationDuration(int duration) {
    this.iconAnimationDuration = duration;
    return this;
  }

  /**
   * Gets the alert icon displayed in the dialog.
   *
   * @return The alert Icon.
   */
  public Icon<?> getAlertIcon() {
    return alertIcon.get();
  }

  /**
   * Sets the alert icon to be displayed in the dialog.
   *
   * @param alertIcon The alert Icon to set.
   * @return This AlertMessageDialog instance.
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
   * Allows customization of the navigation header using a handler.
   *
   * @param handler The handler for customizing the navigation header.
   * @return This AlertMessageDialog instance.
   */
  public AlertMessageDialog withNavHeader(ChildHandler<AlertMessageDialog, NavBar> handler) {
    handler.apply(this, navHeader.get());
    return this;
  }

  /** A functional interface for handling confirmation events. */
  @FunctionalInterface
  public interface MessageHandler {
    /**
     * Called when the confirmation button is clicked.
     *
     * @param dialog The AlertMessageDialog instance.
     */
    void onConfirm(AlertMessageDialog dialog);
  }
}
