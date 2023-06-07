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
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.*;

public class MessageDialog extends AbstractDialog<MessageDialog> {

  private LinkButton confirmButton;

  private MessageHandler confirmHandler = (dialog) -> {};

  private LazyChild<SpanElement> messageElement;
  private LazyChild<NavBar> navHeader;

  /** @return new instance with empty title */
  public static MessageDialog create() {
    return new MessageDialog();
  }

  /**
   * @param title String
   * @return new instance with custom title
   */
  public static MessageDialog create(String title) {
    return new MessageDialog(title);
  }

  /**
   * @param title String
   * @return new instance with custom title
   */
  public static MessageDialog create(String title, String message) {
    return new MessageDialog(title, message);
  }

  /** creates new instance with empty title */
  public MessageDialog() {
    messageElement = LazyChild.of(span(), contentElement);
    navHeader = LazyChild.of(NavBar.create().addCss(dui_dialog_nav), headerElement);
    bodyElement.addCss(dui_text_center);
    appendButtons();
    setStretchWidth(DialogSize.SMALL);
    setStretchHeight(DialogSize.SMALL);
    setAutoClose(false);
  }

  /** @param title String creates new instance with custom title */
  public MessageDialog(String title) {
    this();
    navHeader.get().setTitle(title);
  }

  /** @param title String creates new instance with custom title */
  public MessageDialog(String title, String message) {
    this(title);
    setMessage(message);
  }

  public MessageDialog setTitle(String title) {
    navHeader.get().setTitle(title);
    return this;
  }

  public MessageDialog setMessage(String message) {
    messageElement.remove();
    appendChild(messageElement.get().setTextContent(message));
    return this;
  }

  private void appendButtons() {
    confirmButton =
        LinkButton.create(labels.dialogOk())
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
   * Sets the handler for the confirm action
   *
   * @param handler {@link MessageHandler}
   * @return same ConfirmationDialog instance
   */
  public MessageDialog onConfirm(MessageHandler handler) {
    this.confirmHandler = handler;
    return this;
  }

  /** @return the confirmation {@link Button} */
  public LinkButton getConfirmButton() {
    return confirmButton;
  }

  /** @return the confirmation {@link Button} */
  public MessageDialog withConfirmButton(ChildHandler<MessageDialog, LinkButton> handler) {
    handler.apply(this, confirmButton);
    return this;
  }

  public MessageDialog withNavHeader(ChildHandler<MessageDialog, NavBar> handler){
    handler.apply(this, navHeader.get());
    return this;
  }

  /** An interface to implement Confirm action handlers */
  @FunctionalInterface
  public interface MessageHandler {
    void onConfirm(MessageDialog dialog);
  }
}
