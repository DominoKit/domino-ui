package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.BaseModal;

import static java.util.Objects.nonNull;

/**
 * A special dialog component that introduce a confirm/reject actions
 */
public class ConfirmationDialog extends BaseModal<ConfirmationDialog> {
    private Button confirmButton;
    private Button rejectButton;

    private ConfirmHandler confirmHandler = (dialog) -> {
    };
    private RejectHandler rejectHandler = BaseModal::close;

    /**
     *
     * @return new instance with empty title
     */
    public static ConfirmationDialog create(){
        return new ConfirmationDialog();
    }

    /**
     *
     * @param title String
     * @return new instance with custom title
     */
    public static ConfirmationDialog create(String title){
        return new ConfirmationDialog(title);
    }

    /**
     *
     * creates new instance with empty title
     */
    public ConfirmationDialog() {
        init(this);
        appendButtons();
    }

    /**
     *
     * @param title String
     * creates new instance with custom title
     */
    public ConfirmationDialog(String title) {
        super(title);
        init(this);
        appendButtons();
    }

    private void appendButtons() {
        rejectButton = Button.create(Icons.ALL.clear())
                .linkify()
                .setContent("No")
                .styler(style -> style.setMinWidth("120px"))
                .addClickListener(evt -> {
                    if (nonNull(rejectHandler)) {
                        rejectHandler.onReject(ConfirmationDialog.this);
                    }
                });

        confirmButton = Button.create(Icons.ALL.check())
                .linkify()
                .setContent("Yes")
                .styler(style -> style.setMinWidth("120px"))
                .addClickListener(evt -> {
                    if (nonNull(confirmHandler)) {
                        confirmHandler.onConfirm(ConfirmationDialog.this);
                    }
                });


        appendFooterChild(rejectButton);
        appendFooterChild(confirmButton);
    }

    /**
     * Sets the handler for the confirm action
     * @param confirmHandler {@link ConfirmHandler}
     * @return same ConfirmationDialog instance
     */
    public ConfirmationDialog onConfirm(ConfirmHandler confirmHandler){
        this.confirmHandler = confirmHandler;
        return this;
    }

    /**
     * Sets the handler for the reject action
     * @param rejectHandler {@link RejectHandler}
     * @return same ConfirmationDialog instance
     */
    public ConfirmationDialog onReject(RejectHandler rejectHandler){
        this.rejectHandler = rejectHandler;
        return this;
    }

    /**
     *
     * @return the confirmation {@link Button}
     */
    public Button getConfirmButton() {
        return confirmButton;
    }

    /**
     *
     * @return the reject {@link Button}
     */
    public Button getRejectButton() {
        return rejectButton;
    }

    /**
     * An interface to implement Confirm action handlers
     */
    @FunctionalInterface
    public interface ConfirmHandler {
        /**
         * called when the confirm button is clicked
         * @param dialog the {@link ConfirmationDialog} from which the action is triggered
         */
        void onConfirm(ConfirmationDialog dialog);
    }

    /**
     * An interface to implement Reject action handlers
     */
    @FunctionalInterface
    public interface RejectHandler {
        /**
         * called when the reject button is clicked
         * @param dialog the {@link ConfirmationDialog} from which the action is triggered
         */
        void onReject(ConfirmationDialog dialog);
    }
}
