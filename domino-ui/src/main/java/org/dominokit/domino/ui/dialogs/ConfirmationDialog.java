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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.FooterElement;
import org.dominokit.domino.ui.utils.LazyChild;

/** A special dialog component that introduce a confirm/reject actions */
public class ConfirmationDialog extends AbstractDialog<ConfirmationDialog> {
  private LinkButton confirmButton;
  private LinkButton rejectButton;

  private ConfirmHandler confirmHandler = (dialog) -> {};
  private RejectHandler rejectHandler = AbstractDialog::close;
  private LazyChild<DominoElement<HTMLElement>> messageElement;

  /** @return new instance with empty title */
  public static ConfirmationDialog create() {
    return new ConfirmationDialog();
  }

  /**
   * @param title String
   * @return new instance with custom title
   */
  public static ConfirmationDialog create(String title) {
    return new ConfirmationDialog(title);
  }

  /**
   * @param title String
   * @return new instance with custom title
   */
  public static ConfirmationDialog create(String title, String message) {
    return new ConfirmationDialog(title, message);
  }

  /** creates new instance with empty title */
  public ConfirmationDialog() {
    messageElement = LazyChild.of(DominoElement.span(), contentElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.VERY_SMALL);
    setAutoClose(false);
  }

  /** @param title String creates new instance with custom title */
  public ConfirmationDialog(String title) {
    this();
    setTitle(title);
  }

  /** @param title String creates new instance with custom title */
  public ConfirmationDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  public ConfirmationDialog setMessage(String message) {
    messageElement.remove();
    appendChild(messageElement.get().setTextContent(message));
    return this;
  }

  private void appendButtons() {
    rejectButton =
        LinkButton.create(labels.dialogConfirmationReject(), Icons.ALL.cancel_mdi())
            .addCss(dui_min_w_32, dui_error, dui_m_r_0_5)
            .addClickListener(
                evt -> {
                  if (nonNull(rejectHandler)) {
                    rejectHandler.onReject(ConfirmationDialog.this);
                  }
                });

    confirmButton =
        LinkButton.create(labels.dialogConfirmationAccept(), Icons.ALL.check_mdi())
            .addCss(dui_min_w_32, dui_success, dui_m_l_0_5)
            .addClickListener(
                evt -> {
                  if (nonNull(confirmHandler)) {
                    confirmHandler.onConfirm(ConfirmationDialog.this);
                  }
                });

    appendChild(FooterElement.of(rejectButton));
    appendChild(FooterElement.of(confirmButton));

    withContentFooter((parent, self) -> self.addCss(dui_text_center));
  }

  /**
   * Sets the handler for the confirm action
   *
   * @param confirmHandler {@link ConfirmHandler}
   * @return same ConfirmationDialog instance
   */
  public ConfirmationDialog onConfirm(ConfirmHandler confirmHandler) {
    this.confirmHandler = confirmHandler;
    return this;
  }

  /**
   * Sets the handler for the reject action
   *
   * @param rejectHandler {@link RejectHandler}
   * @return same ConfirmationDialog instance
   */
  public ConfirmationDialog onReject(RejectHandler rejectHandler) {
    this.rejectHandler = rejectHandler;
    return this;
  }

  /** @return the confirmation {@link Button} */
  public LinkButton getConfirmButton() {
    return confirmButton;
  }

  /** @return the reject {@link Button} */
  public LinkButton getRejectButton() {
    return rejectButton;
  }

  /** @return the confirmation {@link Button} */
  public ConfirmationDialog withConfirmButton(
      ChildHandler<ConfirmationDialog, LinkButton> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  /** @return the reject {@link Button} */
  public ConfirmationDialog withRejectButton(ChildHandler<ConfirmationDialog, LinkButton> handler) {
    handler.apply(this, rejectButton);
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
