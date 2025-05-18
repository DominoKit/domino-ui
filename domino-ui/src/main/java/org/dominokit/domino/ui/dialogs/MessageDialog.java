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

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.*;

/**
 * A dialog component for displaying messages to the user. It provides a convenient way to present
 * information or prompt the user for a confirmation.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * MessageDialog.create("Title", "This is the message")
 *     .onConfirm(dialog -> {
 *         // handle confirmation
 *     })
 *     .open();
 * </pre>
 */
public class MessageDialog extends AbstractDialog<MessageDialog> {

  private Button confirmButton;

  private MessageHandler confirmHandler = (dialog) -> {};

  private LazyChild<SpanElement> messageElement;
  private LazyChild<NavBar> navHeader;

  /**
   * Factory method for creating a new instance of {@link MessageDialog} without a title and
   * message.
   *
   * @return A new instance of {@link MessageDialog}
   */
  public static MessageDialog create() {
    return new MessageDialog();
  }

  /**
   * Factory method for creating a new instance of {@link MessageDialog} with a title.
   *
   * @param title The title of the dialog
   * @return A new instance of {@link MessageDialog}
   */
  public static MessageDialog create(String title) {
    return new MessageDialog(title);
  }

  /**
   * Factory method for creating a new instance of {@link MessageDialog} with a title and message.
   *
   * @param title The title of the dialog
   * @param message The message to display in the dialog
   * @return A new instance of {@link MessageDialog}
   */
  public static MessageDialog create(String title, String message) {
    return new MessageDialog(title, message);
  }

  /**
   * Default constructor for creating a new instance of {@link MessageDialog} without title and
   * message.
   */
  public MessageDialog() {
    messageElement = LazyChild.of(span(), contentElement);
    navHeader = LazyChild.of(NavBar.create().addCss(dui_dialog_nav), headerElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.SMALL);
    setAutoClose(false);
  }

  /**
   * Constructs a new instance of {@link MessageDialog} with a title.
   *
   * @param title The title of the dialog
   */
  public MessageDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /**
   * Constructs a new instance of {@link MessageDialog} with a title and message.
   *
   * @param title The title of the dialog
   * @param message The message to display in the dialog
   */
  public MessageDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  /**
   * Sets the title for the {@link MessageDialog}.
   *
   * @param title The title of the dialog
   * @return Current instance for chaining
   */
  public MessageDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  /**
   * Sets the message for the {@link MessageDialog}.
   *
   * @param message The message to display in the dialog
   * @return Current instance for chaining
   */
  public MessageDialog setMessage(String message) {
    messageElement.get().setTextContent(message);
    return this;
  }

  private void appendButtons() {
    confirmButton =
        Button.create(labels.dialogOk())
            .addCss(dui_min_w_32)
            .addClickListener(
                evt -> {
                  if (nonNull(confirmHandler)) {
                    confirmHandler.onConfirm(MessageDialog.this);
                  }
                });

    appendChild(FooterContent.of(confirmButton));

    withContentFooter((parent, self) -> self.addCss(dui_text_center));
  }

  /**
   * Set a handler to be called when the dialog is confirmed.
   *
   * @param handler The {@link MessageHandler} to handle the confirmation event
   * @return Current instance for chaining
   */
  public MessageDialog onConfirm(MessageHandler handler) {
    this.confirmHandler = handler;
    return this;
  }

  /**
   * Returns the confirm button of the dialog.
   *
   * @return The {@link Button} used for confirming the dialog
   */
  public Button getConfirmButton() {
    return confirmButton;
  }

  /**
   * Apply custom modifications to the confirm button of the dialog.
   *
   * @param handler The handler to modify the confirm button
   * @return Current instance for chaining
   */
  public MessageDialog withConfirmButton(ChildHandler<MessageDialog, Button> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /**
   * Apply custom modifications to the navigation header of the dialog.
   *
   * @param handler The handler to modify the navigation header
   * @return Current instance for chaining
   */
  public MessageDialog withNavHeader(ChildHandler<MessageDialog, NavBar> handler) {
    handler.apply(this, navHeader.get());
    return this;
  }

  /** Functional interface to handle confirmation events on the {@link MessageDialog}. */
  @FunctionalInterface
  public interface MessageHandler {
    /**
     * Called when the {@link MessageDialog} is confirmed.
     *
     * @param dialog The {@link MessageDialog} that was confirmed
     */
    void onConfirm(MessageDialog dialog);
  }
}
