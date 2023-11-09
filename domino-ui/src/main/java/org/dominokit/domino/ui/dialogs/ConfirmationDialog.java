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

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A dialog for displaying confirmation messages and getting user confirmation.
 *
 * <p>This dialog allows you to display a confirmation message to the user and get their response
 * (either confirmation or rejection). It provides buttons for confirming and rejecting the action
 * and can be customized with a title and message.
 *
 * <p>Usage example:
 *
 * <pre>
 * ConfirmationDialog.create("Delete Item", "Are you sure you want to delete this item?")
 *   .onConfirm(dialog -&gt; {
 *     // Handle the confirmation logic here
 *     dialog.close();
 *   })
 *   .onReject(dialog -&gt; dialog.close())
 *   .open();
 * </pre>
 */
public class ConfirmationDialog extends AbstractDialog<ConfirmationDialog> {
  private Button confirmButton;
  private Button rejectButton;

  private ConfirmHandler confirmHandler = (dialog) -> {};
  private RejectHandler rejectHandler = AbstractDialog::close;
  private LazyChild<SpanElement> messageElement;
  private LazyChild<NavBar> navHeader;

  /** Creates a new confirmation dialog with default settings. */
  public static ConfirmationDialog create() {
    return new ConfirmationDialog();
  }

  /**
   * Creates a new confirmation dialog with a specified title.
   *
   * @param title The title of the confirmation dialog.
   */
  public static ConfirmationDialog create(String title) {
    return new ConfirmationDialog(title);
  }

  /**
   * Creates a new confirmation dialog with a specified title and message.
   *
   * @param title The title of the confirmation dialog.
   * @param message The message to display in the dialog.
   */
  public static ConfirmationDialog create(String title, String message) {
    return new ConfirmationDialog(title, message);
  }

  /** Creates a new empty {@code ConfirmationDialog} instance. */
  public ConfirmationDialog() {
    messageElement = LazyChild.of(span(), contentElement);
    navHeader = LazyChild.of(NavBar.create().addCss(dui_dialog_nav), headerElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.VERY_SMALL);
    setAutoClose(false);
  }

  /**
   * Creates a new {@code ConfirmationDialog} instance with the specified title.
   *
   * @param title The title to set for the dialog.
   */
  public ConfirmationDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /**
   * Creates a new {@code ConfirmationDialog} instance with the specified title and message.
   *
   * @param title The title to set for the dialog.
   * @param message The message to display in the dialog.
   */
  public ConfirmationDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  /**
   * Sets the title of the dialog.
   *
   * @param title The title to set for the dialog.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  /**
   * Sets the message to be displayed in the dialog.
   *
   * @param message The message to display in the dialog.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog setMessage(String message) {
    messageElement.remove();
    appendChild(messageElement.get().setTextContent(message));
    return this;
  }

  private void appendButtons() {
    rejectButton =
        Button.create(Icons.cancel(), labels.dialogConfirmationReject())
            .addCss(dui_min_w_32, dui_error, dui_m_r_0_5)
            .addClickListener(
                evt -> {
                  if (nonNull(rejectHandler)) {
                    rejectHandler.onReject(ConfirmationDialog.this);
                  }
                });

    confirmButton =
        Button.create(Icons.check(), labels.dialogConfirmationAccept())
            .addCss(dui_min_w_32, dui_success, dui_m_l_0_5)
            .addClickListener(
                evt -> {
                  if (nonNull(confirmHandler)) {
                    confirmHandler.onConfirm(ConfirmationDialog.this);
                  }
                });

    appendChild(FooterContent.of(rejectButton));
    appendChild(FooterContent.of(confirmButton));

    withContentFooter((parent, self) -> self.addCss(dui_text_center));
  }

  /**
   * Sets the action to be performed when the confirm button is clicked.
   *
   * @param confirmHandler The action to be executed on confirmation.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog onConfirm(ConfirmHandler confirmHandler) {
    this.confirmHandler = confirmHandler;
    return this;
  }

  /**
   * Sets the action to be performed when the reject button is clicked.
   *
   * @param rejectHandler The action to be executed on rejection.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog onReject(RejectHandler rejectHandler) {
    this.rejectHandler = rejectHandler;
    return this;
  }

  /**
   * Retrieves the confirm button of the dialog.
   *
   * @return The confirm button.
   */
  public Button getConfirmButton() {
    return confirmButton;
  }

  /**
   * Retrieves the reject button of the dialog.
   *
   * @return The reject button.
   */
  public Button getRejectButton() {
    return rejectButton;
  }

  /**
   * Configures the confirm button of the dialog using a handler for customization.
   *
   * @param handler The handler to customize the confirm button.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog withConfirmButton(ChildHandler<ConfirmationDialog, Button> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /**
   * Configures the reject button of the dialog using a handler for customization.
   *
   * @param handler The handler to customize the reject button.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog withRejectButton(ChildHandler<ConfirmationDialog, Button> handler) {
    handler.apply(this, rejectButton);
    return this;
  }

  /**
   * Configures the header of the dialog using a handler for customization.
   *
   * @param handler The handler to customize the dialog header.
   * @return This {@code ConfirmationDialog} instance for method chaining.
   */
  public ConfirmationDialog withNavHeader(ChildHandler<ConfirmationDialog, NavBar> handler) {
    handler.apply(this, navHeader.get());
    return this;
  }

  /** Functional interface for handling confirmation actions in the {@code ConfirmationDialog}. */
  @FunctionalInterface
  public interface ConfirmHandler {
    /**
     * Called when the confirmation action is performed.
     *
     * @param dialog The {@code ConfirmationDialog} instance.
     */
    void onConfirm(ConfirmationDialog dialog);
  }

  /** Functional interface for handling rejection actions in the {@code ConfirmationDialog}. */
  @FunctionalInterface
  public interface RejectHandler {
    /**
     * Called when the reject action is performed.
     *
     * @param dialog The {@code ConfirmationDialog} instance.
     */
    void onReject(ConfirmationDialog dialog);
  }
}
