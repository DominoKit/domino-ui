package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.BaseModal;

import static java.util.Objects.nonNull;

public class ConfirmationDialog extends BaseModal<ConfirmationDialog> {
    private Button confirmButton;
    private Button rejectButton;

    private ConfirmHandler confirmHandler = (dialog) -> {
    };
    private RejectHandler rejectHandler = BaseModal::close;

    public static ConfirmationDialog create(){
        return new ConfirmationDialog();
    }
    public static ConfirmationDialog create(String title){
        return new ConfirmationDialog(title);
    }

    public ConfirmationDialog() {
        init(this);
        appendButtons();
    }

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

    public ConfirmationDialog onConfirm(ConfirmHandler confirmHandler){
        this.confirmHandler = confirmHandler;
        return this;
    }

    public ConfirmationDialog onReject(RejectHandler rejectHandler){
        this.rejectHandler = rejectHandler;
        return this;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public Button getRejectButton() {
        return rejectButton;
    }

    @FunctionalInterface
    public interface ConfirmHandler {
        void onConfirm(ConfirmationDialog dialog);
    }

    @FunctionalInterface
    public interface RejectHandler {
        void onReject(ConfirmationDialog dialog);
    }
}
