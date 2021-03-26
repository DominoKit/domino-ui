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
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import java.util.function.Supplier;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.BaseModal;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * A component to show message dialogs to the user with ability to make him take actions from those
 * dialogs
 *
 * <pre>
 *     MessageDialog.createMessage(
 *         "Here\'s a message!", () -> Notification.create("Dialog closed").show();
 * </pre>
 */
public class MessageDialog extends BaseModal<MessageDialog> {

  private DominoElement<HTMLDivElement> iconContainer = DominoElement.of(div());

  private DominoElement<HTMLElement> icon;
  private Color iconColorStart;
  private Color iconColorEnd;
  private Transition iconStartTransition;
  private Transition iconEndTransition;
  private Button okButton;

  /** Creates a new instance */
  public MessageDialog() {
    init(this);
  }

  /**
   * Creates an instance and initialize it with custom content
   *
   * @param content {@link Node}
   * @return new instance
   */
  public static MessageDialog createMessage(Node content) {
    return createMessage(content, () -> {});
  }

  /**
   * Creates an instance and initialize it with custom content and an Ok action button
   *
   * @param content {@link Node}
   * @param okButtonProvider {@link Supplier} of {@link Button} for the ok action
   * @return new instance
   */
  public static MessageDialog createMessage(Node content, Supplier<Button> okButtonProvider) {
    return createMessage(content, () -> {}, okButtonProvider);
  }

  /**
   * Creates an instance and initialize it with a title and custom content
   *
   * @param title String
   * @param content {@link Node}
   * @return new instance
   */
  public static MessageDialog createMessage(String title, Node content) {
    return createMessage(title, content, () -> {});
  }

  /**
   * Creates an instance and initialize it with a title and custom content and an ok action button
   *
   * @param title String
   * @param content {@link Node}
   * @param okButtonProvider {@link Supplier} of {@link Button} for the ok action
   * @return new instance
   */
  public static MessageDialog createMessage(
      String title, Node content, Supplier<Button> okButtonProvider) {
    return createMessage(title, content, () -> {}, okButtonProvider);
  }

  /**
   * Creates an instance and initialize it with a title and custom content and a close handler
   *
   * @param title String
   * @param content {@link Node}
   * @param closeHandler {@link CloseHandler}
   * @return new instance
   */
  public static MessageDialog createMessage(String title, Node content, CloseHandler closeHandler) {
    MessageDialog modalDialog = createMessage(content, closeHandler);
    modalDialog.setTitle(title);
    return modalDialog;
  }

  /**
   * Creates an instance and initialize it with a title and custom content a close handler and an ok
   * action button
   *
   * @param title String
   * @param content {@link Node}
   * @param closeHandler {@link CloseHandler}
   * @param okButtonProvider {@link Supplier} of {@link Button}
   * @return new instance
   */
  public static MessageDialog createMessage(
      String title, Node content, CloseHandler closeHandler, Supplier<Button> okButtonProvider) {
    MessageDialog modalDialog = createMessage(content, closeHandler, okButtonProvider);
    modalDialog.setTitle(title);
    return modalDialog;
  }

  /**
   * Creates an instance and initialize it with custom content a close handler
   *
   * @param content {@link Node}
   * @param closeHandler {@link CloseHandler}
   * @return new instance
   */
  public static MessageDialog createMessage(Node content, CloseHandler closeHandler) {
    return createMessage(
        content,
        closeHandler,
        () ->
            Button.create("OK")
                .styler(style -> style.add(MessageDialogStyles.DIALOG_BUTTON))
                .linkify());
  }

  /**
   * Creates an instance and initialize it with custom content a close handler and an ok action
   * button
   *
   * @param content {@link Node}
   * @param closeHandler {@link CloseHandler}
   * @param okButtonProvider {@link Supplier} of {@link Button}
   * @return new instance
   */
  public static MessageDialog createMessage(
      Node content, CloseHandler closeHandler, Supplier<Button> okButtonProvider) {
    MessageDialog messageDialog = new MessageDialog();
    messageDialog.style.add(MessageDialogStyles.MESSAGE_DIALOG);

    messageDialog.setSize(ModalSize.ALERT);
    messageDialog
        .modalElement
        .getModalHeader()
        .insertBefore(
            messageDialog.iconContainer, messageDialog.modalElement.getModalHeader().firstChild());
    messageDialog.hideHeader();
    messageDialog.setAutoClose(true);
    messageDialog.addCloseListener(closeHandler);
    messageDialog.appendChild(content);
    messageDialog.okButton = okButtonProvider.get();
    messageDialog.appendFooterChild(messageDialog.okButton);
    messageDialog
        .okButton
        .getClickableElement()
        .addEventListener(EventType.click.getName(), evt -> messageDialog.close());

    return messageDialog;
  }

  /**
   * Change the ok button text
   *
   * @param text String button text
   * @return same MessageDialog instance
   */
  public MessageDialog setOkButtonText(String text) {
    okButton.setContent(text);
    return this;
  }

  /**
   * Creates an instance and initialize it with a text message
   *
   * @param message String
   * @return new instance
   */
  public static MessageDialog createMessage(String message) {
    return createMessage(message, () -> {});
  }

  /**
   * Creates an instance and initialize it with a title and a text message
   *
   * @param title String
   * @param message String
   * @return new instance
   */
  public static MessageDialog createMessage(String title, String message) {
    return createMessage(title, message, () -> {});
  }

  /**
   * Creates an instance and initialize it with a title and a text message and a close handler
   *
   * @param title String
   * @param message String
   * @param closeHandler {@link CloseHandler}
   * @return new instance
   */
  public static MessageDialog createMessage(
      String title, String message, CloseHandler closeHandler) {
    MessageDialog modalDialog = createMessage(message, closeHandler);
    modalDialog.setTitle(title);
    return modalDialog;
  }

  /**
   * Creates an instance and initialize it with a text message and a close handler
   *
   * @param message String
   * @param closeHandler {@link CloseHandler}
   * @return new instance
   */
  public static MessageDialog createMessage(String message, CloseHandler closeHandler) {
    return createMessage(Paragraph.create(message).element(), closeHandler);
  }

  /**
   * Creates an instance and initialize it with a text message and a close handler and an ok action
   * button
   *
   * @param message String
   * @param closeHandler {@link CloseHandler}
   * @param okButtonProvider {@link Supplier} of {@link Button}
   * @return new instance
   */
  public static MessageDialog createMessage(
      String message, CloseHandler closeHandler, Supplier<Button> okButtonProvider) {
    return createMessage(Paragraph.create(message).element(), closeHandler, okButtonProvider);
  }

  /**
   * Set the icon as the dialog content with an animation transition to indicate a success operation
   *
   * @param icon {@link BaseIcon}
   * @return same MessageDialog instance
   */
  public MessageDialog success(BaseIcon<?> icon) {
    this.icon = MessageDialog.createMessageIcon(icon.element());
    this.iconColorStart = Color.ORANGE;
    this.iconColorEnd = Color.LIGHT_GREEN;
    this.iconStartTransition = Transition.ROTATE_IN;
    this.iconEndTransition = Transition.PULSE;
    showHeader();
    initIcon();
    return this;
  }

  /**
   * Set a default {@link Icons#ALL#done()} icon as the dialog content with an animation transition
   * to indicate a success operation
   *
   * @return same MessageDialog instance
   */
  public MessageDialog success() {
    return success(Icons.ALL.done());
  }

  /**
   * Set the icon as the dialog content with an animation transition to indicate a failed operation
   *
   * @param icon {@link BaseIcon}
   * @return same MessageDialog instance
   */
  public MessageDialog error(BaseIcon<?> icon) {
    this.icon = MessageDialog.createMessageIcon(icon.element());
    this.iconColorStart = Color.GREY;
    this.iconColorEnd = Color.RED;
    this.iconStartTransition = Transition.ROTATE_IN;
    this.iconEndTransition = Transition.TADA;
    showHeader();
    initIcon();
    return this;
  }

  /**
   * Set a default {@link Icons#ALL#error()} icon as the dialog content with an animation transition
   * to indicate a failed operation
   *
   * @return same MessageDialog instance
   */
  public MessageDialog error() {
    return error(Icons.ALL.error());
  }

  /**
   * Set the icon as the dialog content with an animation transition to indicate a warning operation
   *
   * @param icon {@link BaseIcon}
   * @return same MessageDialog instance
   */
  public MessageDialog warning(BaseIcon<?> icon) {
    this.icon = MessageDialog.createMessageIcon(icon.element());
    this.iconColorStart = Color.GREY;
    this.iconColorEnd = Color.ORANGE;
    this.iconStartTransition = Transition.ROTATE_IN;
    this.iconEndTransition = Transition.RUBBER_BAND;
    showHeader();
    initIcon();
    return this;
  }

  /**
   * Set a default {@link Icons#ALL#clear()} icon as the dialog content with an animation transition
   * to indicate a warning operation
   *
   * @return same MessageDialog instance
   */
  public MessageDialog warning() {
    return warning(Icons.ALL.clear());
  }

  private static DominoElement<HTMLElement> createMessageIcon(HTMLElement element) {
    return DominoElement.of(element).styler(style -> style.add(MessageDialogStyles.MESSAGE_ICON));
  }

  private void initIcon() {
    iconContainer.clearElement();
    iconContainer.appendChild(icon);

    addOpenListener(
        () -> {
          icon.style()
              .remove(iconColorEnd.getStyle())
              .add(iconColorStart.getStyle())
              .setBorder("3px solid " + iconColorStart.getHex());
          Animation.create(icon)
              .transition(iconStartTransition)
              .duration(400)
              .callback(
                  element -> {
                    Style.of(element)
                        .remove(iconColorStart.getStyle())
                        .add(iconColorEnd.getStyle())
                        .setBorder("3px solid " + iconColorEnd.getHex());
                    Animation.create(icon).transition(iconEndTransition).animate();
                  })
              .animate();
        });
  }

  /**
   * Change the dialog icon colors transitions
   *
   * @param iconColorStart {@link Color} at the start of the animation transition
   * @param iconColorEnd {@link Color} at the end of the animation transition
   * @return same MessageDialog instance
   */
  public MessageDialog setIconColor(Color iconColorStart, Color iconColorEnd) {
    this.iconColorStart = iconColorStart;
    this.iconColorEnd = iconColorEnd;

    return this;
  }

  /**
   * @param content {@link Node} to be appended to the dialog body
   * @return same MessageDialog instance
   */
  public MessageDialog appendHeaderChild(Node content) {
    if (nonNull(icon)) {
      icon.remove();
    }
    modalElement.getModalHeader().insertBefore(content, modalElement.getModalTitle());
    return this;
  }

  /** @return the ok {@link Button} if exists or null */
  public Button getOkButton() {
    return okButton;
  }

  /**
   * @param content {@link IsElement} to be appended to the dialog header
   * @return same MessageDialog instance
   */
  public MessageDialog appendHeaderChild(IsElement<?> content) {
    return appendHeaderChild(content.element());
  }
}
