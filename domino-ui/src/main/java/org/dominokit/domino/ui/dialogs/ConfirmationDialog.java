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

/** A special dialog component that introduce a confirm/reject actions */
public class ConfirmationDialog extends AbstractDialog<ConfirmationDialog> {
  private Button confirmButton;
  private Button rejectButton;

  private ConfirmHandler confirmHandler = (dialog) -> {};
  private RejectHandler rejectHandler = AbstractDialog::close;
  private LazyChild<SpanElement> messageElement;
  private LazyChild<NavBar> navHeader;

  /** @return new instance with empty title */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
   */
  public static ConfirmationDialog create() {
    return new ConfirmationDialog();
  }

  /**
   * create.
   *
   * @param title String
   * @return new instance with custom title
   */
  public static ConfirmationDialog create(String title) {
    return new ConfirmationDialog(title);
  }

  /**
   * create.
   *
   * @param title String
   * @return new instance with custom title
   * @param message a {@link java.lang.String} object
   */
  public static ConfirmationDialog create(String title, String message) {
    return new ConfirmationDialog(title, message);
  }

  /** creates new instance with empty title */
  public ConfirmationDialog() {
    messageElement = LazyChild.of(span(), contentElement);
    navHeader = LazyChild.of(NavBar.create().addCss(dui_dialog_nav), headerElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.VERY_SMALL);
    setAutoClose(false);
  }

  /** @param title String creates new instance with custom title */
  /**
   * Constructor for ConfirmationDialog.
   *
   * @param title a {@link java.lang.String} object
   */
  public ConfirmationDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /** @param title String creates new instance with custom title */
  /**
   * Constructor for ConfirmationDialog.
   *
   * @param title a {@link java.lang.String} object
   * @param message a {@link java.lang.String} object
   */
  public ConfirmationDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  /**
   * setTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
   */
  public ConfirmationDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  /**
   * setMessage.
   *
   * @param message a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
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
   * Sets the handler for the confirm action
   *
   * @param confirmHandler {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog.ConfirmHandler}
   * @return same ConfirmationDialog instance
   */
  public ConfirmationDialog onConfirm(ConfirmHandler confirmHandler) {
    this.confirmHandler = confirmHandler;
    return this;
  }

  /**
   * Sets the handler for the reject action
   *
   * @param rejectHandler {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog.RejectHandler}
   * @return same ConfirmationDialog instance
   */
  public ConfirmationDialog onReject(RejectHandler rejectHandler) {
    this.rejectHandler = rejectHandler;
    return this;
  }

  /** @return the confirmation {@link Button} */
  /**
   * Getter for the field <code>confirmButton</code>.
   *
   * @return a {@link org.dominokit.domino.ui.button.Button} object
   */
  public Button getConfirmButton() {
    return confirmButton;
  }

  /** @return the reject {@link Button} */
  /**
   * Getter for the field <code>rejectButton</code>.
   *
   * @return a {@link org.dominokit.domino.ui.button.Button} object
   */
  public Button getRejectButton() {
    return rejectButton;
  }

  /** @return the confirmation {@link Button} */
  /**
   * withConfirmButton.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
   */
  public ConfirmationDialog withConfirmButton(ChildHandler<ConfirmationDialog, Button> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /** @return the reject {@link Button} */
  /**
   * withRejectButton.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
   */
  public ConfirmationDialog withRejectButton(ChildHandler<ConfirmationDialog, Button> handler) {
    handler.apply(this, rejectButton);
    return this;
  }

  /**
   * withNavHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.dialogs.ConfirmationDialog} object
   */
  public ConfirmationDialog withNavHeader(ChildHandler<ConfirmationDialog, NavBar> handler) {
    handler.apply(this, navHeader.get());
    return this;
  }

  /** An interface to implement Confirm action handlers */
  @FunctionalInterface
  public interface ConfirmHandler {
    /**
     * called when the confirm button is clicked
     *
     * @param dialog the {@link ConfirmationDialog} from which the action is triggered
     */
    void onConfirm(ConfirmationDialog dialog);
  }

  /** An interface to implement Reject action handlers */
  @FunctionalInterface
  public interface RejectHandler {
    /**
     * called when the reject button is clicked
     *
     * @param dialog the {@link ConfirmationDialog} from which the action is triggered
     */
    void onReject(ConfirmationDialog dialog);
  }
}
