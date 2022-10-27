package org.dominokit.domino.ui.dialogs;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.FooterElement;
import org.dominokit.domino.ui.utils.LazyChild;

import static java.util.Objects.nonNull;

public class AlertMessageDialog extends AbstractDialog<AlertMessageDialog> {

    private LinkButton confirmButton;

    private MessageHandler confirmHandler = (dialog) -> {
    };

    private LazyChild<DominoElement<HTMLElement>> messageElement;

    private Transition iconStartTransition = Transition.ZOOM_IN;
    private Transition iconEndTransition = Transition.TADA;

    private int iconAnimationDuration = 1000;

    private BaseIcon<?> alertIcon = Icons.ALL.alert_mdi()
            .size48();

    /**
     * @return new instance with empty title
     */
    public static AlertMessageDialog create() {
        return new AlertMessageDialog();
    }

    /**
     * @param title String
     * @return new instance with custom title
     */
    public static AlertMessageDialog create(String title) {
        return new AlertMessageDialog(title);
    }

    /**
     * @param title String
     * @return new instance with custom title
     */
    public static AlertMessageDialog create(String title, String message) {
        return new AlertMessageDialog(title, message);
    }

    /**
     * creates new instance with empty title
     */
    public AlertMessageDialog() {
        messageElement = LazyChild.of(DominoElement.span(), contentElement);
        bodyElement.addCss(dui_text_center);
        appendButtons();
        setStretchWidth(DialogSize.SMALL);
        setStretchHeight(DialogSize.VERY_SMALL);
        setAutoClose(false);
        contentHeader.get().addCss(dui_justify_around).appendChild(alertIcon);
        addOpenListener(() -> {
           Animation.create(getAlertIcon())
                   .transition(iconStartTransition)
                   .duration(iconAnimationDuration)
                   .callback(iconElement -> Animation.create(getAlertIcon())
                           .transition(iconEndTransition)
                           .duration(iconAnimationDuration)
                           .animate()
                   ).animate();
        });
    }

    /**
     * @param title String creates new instance with custom title
     */
    public AlertMessageDialog(String title) {
        this();
        setTitle(title);
    }

    /**
     * @param title String creates new instance with custom title
     */
    public AlertMessageDialog(String title, String message) {
        this(title);
        setMessage(message);
    }

    public AlertMessageDialog setMessage(String message) {
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
                                        confirmHandler.onConfirm(AlertMessageDialog.this);
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
    public AlertMessageDialog onConfirm(MessageHandler handler) {
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
    public AlertMessageDialog withConfirmButton(ChildHandler<AlertMessageDialog, LinkButton> handler) {
        handler.apply(this, confirmButton);
        return this;
    }

    public Transition getIconStartTransition() {
        return iconStartTransition;
    }

    public AlertMessageDialog setIconStartTransition(Transition transition) {
        this.iconStartTransition = transition;
        return this;
    }

    public Transition getIconEndTransition() {
        return iconEndTransition;
    }

    public AlertMessageDialog setIconEndTransition(Transition transition) {
        this.iconEndTransition = transition;
        return this;
    }

    public int getIconAnimationDuration() {
        return iconAnimationDuration;
    }

    public AlertMessageDialog setIconAnimationDuration(int duration) {
        this.iconAnimationDuration = duration;
        return this;
    }

    public BaseIcon<?> getAlertIcon() {
        return alertIcon;
    }

    public AlertMessageDialog setAlertIcon(BaseIcon<?> alertIcon) {
        if(nonNull(alertIcon)){
            this.alertIcon.remove();
        }
        this.alertIcon = alertIcon;
        return this;
    }

    /**
     * An interface to implement Confirm action handlers
     */
    @FunctionalInterface
    public interface MessageHandler {
        void onConfirm(AlertMessageDialog dialog);
    }

}
