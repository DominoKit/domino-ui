package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.BaseModal;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.ElementUtil;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;


public class MessageDialog extends BaseModal<MessageDialog> {

    private HTMLElement successIcon;
    private HTMLElement errorIcon;
    private HTMLElement warningIcon;

    private HTMLDivElement iconContainer=div().asElement();

    private Color successColor=Color.LIGHT_GREEN;
    private Color errorColor=Color.RED;
    private Color warningColor=Color.ORANGE;

    private static HTMLElement createMessageIcon(HTMLElement element) {
        element.classList.add(Styles.m_b_15);
        element.style.setProperty("font-size", "72px");
        element.style.setProperty("border-radius", "50%");

        return element;
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
        messageDialog.modal.getModalContent().style.textAlign = "center";
        messageDialog.modal.getModalFooter().style.textAlign = "center";
        messageDialog.modal.getModalHeader().insertBefore(messageDialog.iconContainer, messageDialog.modal.getModalHeader().firstChild);
        messageDialog.hideHeader();
        messageDialog.setAutoClose(true);
        messageDialog.onClose(closeHandler::onClose);
        messageDialog.appendContent(content);
        Button okButton = Button.create("OK").linkify();
        okButton.asElement().style.setProperty("min-width", "120px");
        messageDialog.appendFooterContent(okButton.asElement());
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

    public MessageDialog success(Icon icon) {
        this.successIcon=MessageDialog.createMessageIcon(icon.asElement());
        ElementUtil.clear(iconContainer);
        iconContainer.appendChild(successIcon);

        onOpen(() -> {
            successIcon.classList.remove(successColor.getStyle());
            successIcon.classList.add(Color.ORANGE.getStyle());
            successIcon.style.setProperty("border", "3px solid " + Color.ORANGE.getHex());
            Animation.create(successIcon)
                    .transition(Transition.ROTATE_IN)
                    .duration(400)
                    .callback(element -> {
                        element.classList.remove(Color.ORANGE.getStyle());
                        element.classList.add(successColor.getStyle());
                        element.style.setProperty("border", "3px solid " + successColor.getHex());
                        Animation.create(successIcon)
                                .transition(Transition.PULSE)
                                .animate();
                    }).animate();
        });
        return this;
    }

    public MessageDialog success() {
        return success(Icons.ALL.done());
    }

    public MessageDialog error(Icon icon){
        this.errorIcon=MessageDialog.createMessageIcon(icon.asElement());
        ElementUtil.clear(iconContainer);
        iconContainer.appendChild(errorIcon);

        onOpen(() -> {
            errorIcon.classList.remove(errorColor.getStyle());
            errorIcon.classList.add(Color.GREY.getStyle());
            errorIcon.style.setProperty("border", "3px solid " + Color.GREY.getHex());
            Animation.create(errorIcon)
                    .transition(Transition.ROTATE_IN)
                    .duration(400)
                    .callback(element -> {
                        element.classList.remove(Color.GREY.getStyle());
                        element.classList.add(errorColor.getStyle());
                        element.style.setProperty("border", "3px solid " + errorColor.getHex());
                        Animation.create(errorIcon)
                                .transition(Transition.TADA)
                                .animate();
                    }).animate();
        });
        return this;
    }

    public MessageDialog error(){
        return error(Icons.ALL.error());
    }

    public MessageDialog warning(Icon icon){
        this.warningIcon=MessageDialog.createMessageIcon(icon.asElement());
        ElementUtil.clear(iconContainer);
        iconContainer.appendChild(warningIcon);

        onOpen(() -> {
            warningIcon.classList.remove(warningColor.getStyle());
            warningIcon.classList.add(Color.GREY.getStyle());
            warningIcon.style.setProperty("border", "3px solid " + Color.GREY.getHex());
            Animation.create(warningIcon)
                    .transition(Transition.ROTATE_IN)
                    .duration(400)
                    .callback(element -> {
                        element.classList.remove(Color.GREY.getStyle());
                        element.classList.add(warningColor.getStyle());
                        element.style.setProperty("border", "3px solid " + warningColor.getHex());
                        Animation.create(warningIcon)
                                .transition(Transition.RUBBER_BAND)
                                .animate();
                    }).animate();
        });
        return this;
    }

    public MessageDialog warning(){
        return warning(Icons.ALL.clear());
    }

    public MessageDialog setIconColor(Color color){
        this.successColor=color;
        this.warningColor=color;
        this.errorColor=color;

        return this;
    }

    public MessageDialog appendHeaderContent(Node content){
        if(nonNull(successIcon)){
            successIcon.remove();
        }

        if(nonNull(errorIcon)){
            errorIcon.remove();
        }

        if(nonNull(warningIcon)){
            warningIcon.remove();
        }

        modal.getModalHeader().insertBefore(content, modal.getModalTitle());
        return this;
    }
}
