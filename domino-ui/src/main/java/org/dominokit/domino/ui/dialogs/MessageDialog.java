package org.dominokit.domino.ui.dialogs;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.utils.*;

import static java.util.Objects.nonNull;

public class MessageDialog extends AbstractDialog<MessageDialog>{

    private LinkButton confirmButton;

    private MessageHandler confirmHandler = (dialog) -> {
    };

    private LazyChild<DominoElement<HTMLElement>> messageElement;

    /**
     * @return new instance with empty title
     */
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

    /**
     * creates new instance with empty title
     */
    public MessageDialog() {
        messageElement = LazyChild.of(DominoElement.span(), contentElement);
        bodyElement.addCss(dui_text_center);
        appendButtons();
        setStretchWidth(DialogSize.SMALL);
        setAutoClose(false);
    }

    /**
     * @param title String creates new instance with custom title
     */
    public MessageDialog(String title) {
        this();
        setTitle(title);

    }

    /**
     * @param title String creates new instance with custom title
     */
    public MessageDialog(String title, String message) {
        this(title);
        setMessage(message);
    }

    public MessageDialog setMessage(String message){
        messageElement.remove();
        appendChild(messageElement.get().setTextContent(message));
        return this;
    }

    private void appendButtons() {

        confirmButton =
                LinkButton.create(labels.dialogOk())
                        .addCss(dui_min_w_32, dui_primary)
                        .addClickListener(
                                evt -> {
                                    if (nonNull(confirmHandler)) {
                                        confirmHandler.onConfirm(MessageDialog.this);
                                    }
                                });

        appendChild(FooterElement.of(confirmButton));

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


    /**
     * @return the confirmation {@link Button}
     */
    public LinkButton getConfirmButton() {
        return confirmButton;
    }

    /**
     * @return the confirmation {@link Button}
     */
    public MessageDialog withConfirmButton(ChildHandler<MessageDialog, LinkButton> handler) {
        handler.apply(this, confirmButton);
        return this;
    }

    /**
     * An interface to implement Confirm action handlers
     */
    @FunctionalInterface
    public interface MessageHandler {
        void onConfirm(MessageDialog dialog);
    }

}
