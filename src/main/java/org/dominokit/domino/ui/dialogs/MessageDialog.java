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
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;


public class MessageDialog extends BaseModal<MessageDialog> {

    private DominoElement<HTMLElement> successIcon;
    private DominoElement<HTMLElement> errorIcon;
    private DominoElement<HTMLElement> warningIcon;

    private DominoElement<HTMLDivElement> iconContainer = DominoElement.of(div());

    private Color successColor = Color.LIGHT_GREEN;
    private Color errorColor = Color.RED;
    private Color warningColor = Color.ORANGE;

    public MessageDialog() {
        init(this);
    }

    private static DominoElement<HTMLElement> createMessageIcon(HTMLElement element) {
        return DominoElement.of(element)
                .style()
                .add(Styles.m_b_15)
                .setProperty("font-size", "72px")
                .setProperty("border-radius", "50%")
                .setHeight("78px")
                .setWidth("78px")
                .get();
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
        messageDialog.modal.getModalHeader().insertBefore(messageDialog.iconContainer, messageDialog.modal.getModalHeader().firstChild());
        messageDialog.hideHeader();
        messageDialog.setAutoClose(true);
        messageDialog.onClose(closeHandler::onClose);
        messageDialog.appendChild(content);
        Button okButton = Button.create("OK").linkify();
        okButton.asElement().style.setProperty("min-width", "120px");
        messageDialog.appendFooterChild(okButton);
        okButton.getClickableElement().addEventListener(EventType.click.getName(), evt -> messageDialog.close());

        return messageDialog;
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
        this.successIcon = MessageDialog.createMessageIcon(icon.asElement());
        appendIcon(successIcon, successColor, Color.ORANGE, Transition.PULSE);
        return this;
    }

    public MessageDialog success() {
        return success(Icons.ALL.done());
    }

    public MessageDialog error(BaseIcon<?> icon) {
        this.errorIcon = MessageDialog.createMessageIcon(icon.asElement());
        appendIcon(errorIcon, errorColor, Color.GREY, Transition.TADA);
        return this;
    }

    public MessageDialog error() {
        return error(Icons.ALL.error());
    }

    public MessageDialog warning(BaseIcon<?> icon) {
        this.warningIcon = MessageDialog.createMessageIcon(icon.asElement());
        appendIcon(warningIcon, warningColor, Color.GREY, Transition.RUBBER_BAND);
        return this;
    }

    private void appendIcon(DominoElement<HTMLElement> icon, Color iconColor, Color color, Transition rubberBand) {
        iconContainer.clearElement();
        iconContainer.appendChild(icon);

        onOpen(() -> {
            icon.style().remove(iconColor.getStyle())
                    .add(color.getStyle())
                    .setBorder("3px solid " + color.getHex());
            Animation.create(icon)
                    .transition(Transition.ROTATE_IN)
                    .duration(400)
                    .callback(element -> {
                        Style.of(element)
                                .remove(color.getStyle())
                                .add(iconColor.getStyle())
                                .setBorder("3px solid " + iconColor.getHex());
                        Animation.create(icon)
                                .transition(rubberBand)
                                .animate();
                    }).animate();
        });
    }

    public MessageDialog warning() {
        return warning(Icons.ALL.clear());
    }

    public MessageDialog setIconColor(Color color) {
        this.successColor = color;
        this.warningColor = color;
        this.errorColor = color;

        return this;
    }

    /**
     * @deprecated use {@link #appendHeaderChild(Node)}
     */
    @Deprecated
    public MessageDialog appendHeaderContent(Node content) {
        return appendHeaderChild(content);
    }

    public MessageDialog appendHeaderChild(Node content) {
        if (nonNull(successIcon)) {
            successIcon.remove();
        }

        if (nonNull(errorIcon)) {
            errorIcon.remove();
        }

        if (nonNull(warningIcon)) {
            warningIcon.remove();
        }

        modal.getModalHeader().insertBefore(content, modal.getModalTitle());
        return this;
    }

    public MessageDialog appendHeaderChild(IsElement content) {
        return appendHeaderChild(content.asElement());
    }
}
