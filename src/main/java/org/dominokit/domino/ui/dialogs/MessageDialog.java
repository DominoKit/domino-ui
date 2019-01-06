package org.dominokit.domino.ui.dialogs;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
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
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class MessageDialog extends BaseModal<MessageDialog> {

    private DominoElement<HTMLDivElement> iconContainer = DominoElement.of(div());

    private DominoElement<HTMLElement> icon;
    private Color iconColorStart;
    private Color iconColorEnd;
    private Transition iconStartTransition;
    private Transition iconEndTransition;
    private static Button okButton;


    public MessageDialog() {
        init(this);
    }

    public static MessageDialog createMessage(Node content) {
        return createMessage(content, () -> {
        });
    }

    public static MessageDialog createMessage(String title, Node content) {
        return createMessage(title, content, () -> {
        });
    }

    public static MessageDialog createMessage(String title, Node content, CloseHandler closeHandler) {
        MessageDialog modalDialog = createMessage(content, closeHandler);
        modalDialog.setTitle(title);
        return modalDialog;
    }

    public static MessageDialog createMessage(Node content, CloseHandler closeHandler) {
        MessageDialog messageDialog = new MessageDialog();

        messageDialog.setSize(ModalSize.ALERT);
        messageDialog.modal.getModalContent().style().setTextAlign("center");
        messageDialog.modal.getModalFooter().style().setTextAlign("center");
        messageDialog.modal.getModalHeader()
                .insertBefore(messageDialog.iconContainer, messageDialog.modal.getModalHeader().firstChild());
        messageDialog.hideHeader();
        messageDialog.setAutoClose(true);
        messageDialog.onClose(closeHandler::onClose);
        messageDialog.appendChild(content);
        okButton = Button.create("OK").linkify();
        okButton.asElement().style.setProperty("min-width", "120px");
        messageDialog.appendFooterChild(okButton);
        okButton.getClickableElement().addEventListener(EventType.click.getName(), evt -> messageDialog.close());

        return messageDialog;
    }

    public MessageDialog setOkButtonText(String text){
        okButton.setContent(text);
        return this;
    }


    public static MessageDialog createMessage(String message) {
        return createMessage(message, () -> {
        });
    }

    public static MessageDialog createMessage(String title, String message) {
        return createMessage(title, message, () -> {
        });
    }

    public static MessageDialog createMessage(String title, String message, CloseHandler closeHandler) {
        MessageDialog modalDialog = createMessage(message, closeHandler);
        modalDialog.setTitle(title);
        return modalDialog;
    }

    public static MessageDialog createMessage(String message, CloseHandler closeHandler) {
        return createMessage(Paragraph.create(message).asElement(), closeHandler);
    }

    public MessageDialog success(BaseIcon<?> icon) {
        this.icon = MessageDialog.createMessageIcon(icon.asElement());
        this.iconColorStart = Color.ORANGE;
        this.iconColorEnd = Color.LIGHT_GREEN;
        this.iconStartTransition = Transition.ROTATE_IN;
        this.iconEndTransition = Transition.PULSE;
        initIcon();
        return this;
    }

    public MessageDialog success() {
        return success(Icons.ALL.done());
    }

    public MessageDialog error(BaseIcon<?> icon) {
        this.icon = MessageDialog.createMessageIcon(icon.asElement());
        this.iconColorStart = Color.GREY;
        this.iconColorEnd = Color.RED;
        this.iconStartTransition = Transition.ROTATE_IN;
        this.iconEndTransition = Transition.TADA;
        initIcon();
        return this;
    }

    public MessageDialog error() {
        return error(Icons.ALL.error());
    }

    public MessageDialog warning(BaseIcon<?> icon) {
        this.icon = MessageDialog.createMessageIcon(icon.asElement());
        this.iconColorStart = Color.GREY;
        this.iconColorEnd = Color.ORANGE;
        this.iconStartTransition = Transition.ROTATE_IN;
        this.iconEndTransition = Transition.RUBBER_BAND;
        initIcon();
        return this;
    }

    public MessageDialog warning() {
        return warning(Icons.ALL.clear());
    }

    private static DominoElement<HTMLElement> createMessageIcon(HTMLElement element) {
        return DominoElement.of(element)
                .styler(style -> style.add("message-icon"));
    }

    private void initIcon() {
        iconContainer.clearElement();
        iconContainer.appendChild(icon);

        onOpen(() -> {
            icon.style()
                    .remove(iconColorEnd.getStyle())
                    .add(iconColorStart.getStyle())
                    .setBorder("3px solid " + iconColorStart.getHex());
            Animation.create(icon)
                    .transition(iconStartTransition)
                    .duration(400)
                    .callback(element -> {
                        Style.of(element)
                                .remove(iconColorStart.getStyle())
                                .add(iconColorEnd.getStyle())
                                .setBorder("3px solid " + iconColorEnd.getHex());
                        Animation.create(icon)
                                .transition(iconEndTransition)
                                .animate();
                    }).animate();
        });
    }

    public MessageDialog setIconColor(Color iconColorStart, Color iconColorEnd) {
        this.iconColorStart = iconColorStart;
        this.iconColorEnd = iconColorEnd;

        return this;
    }

    public MessageDialog appendHeaderChild(Node content) {
        if (nonNull(icon)) {
            icon.remove();
        }
        modal.getModalHeader().insertBefore(content, modal.getModalTitle());
        return this;
    }

    public MessageDialog appendHeaderChild(IsElement content) {
        return appendHeaderChild(content.asElement());
    }
}
