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
package org.dominokit.domino.ui.richtext.commands;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DocumentFragment;
import elemental2.dom.HTMLElement;
import elemental2.dom.Range;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.ConfirmationDialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.IsRichTextEditor;
import org.dominokit.domino.ui.richtext.RichTextCommand;

/**
 * Represents a UI command to insert a hyperlink within a rich text editor.
 *
 * <p>The {@code InsertLinkCommand} extends {@link RichTextCommand} and provides users the ability
 * to insert a hyperlink at the current selection position in a rich text editable div element. The
 * command is represented by a button with a link icon. When the button is clicked, a confirmation
 * dialog opens containing a textbox for users to input the desired URL. Confirming the dialog will
 * then wrap the current selection with the hyperlink pointing to the entered URL.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertLinkCommand insertLinkCommand = InsertLinkCommand.create(editableDiv);
 * }</pre>
 */
public class InsertLinkCommand extends RichTextCommand<InsertLinkCommand> {

  private final ConfirmationDialog dialog;
  private TextBox linkBox;
  private Button button;
  private Range range;

  /**
   * Factory method to create a new instance of InsertLinkCommand.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   * @return A new instance of InsertLinkCommand.
   */
  public static InsertLinkCommand create(IsRichTextEditor isRichTextEditor) {
    return new InsertLinkCommand(isRichTextEditor);
  }

  /**
   * Constructs a new InsertLinkCommand instance for the specified editable div element.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   */
  public InsertLinkCommand(IsRichTextEditor isRichTextEditor) {
    super(isRichTextEditor);
    this.dialog =
        ConfirmationDialog.create()
            .setStretchWidth(DialogSize.MEDIUM)
            .setStretchHeight(DialogSize.VERY_SMALL)
            .withConfirmButton(
                (parent, confirmButton) -> confirmButton.setText(getLabels().insert()))
            .withRejectButton(
                (parent, rejectbutton) ->
                    rejectbutton
                        .setText(getLabels().close())
                        .addCss(dui_dominant)
                        .setIcon(Icons.close()))
            .appendChild(linkBox = TextBox.create(getLabels().url()))
            .onConfirm(
                dialog -> {
                  dialog.close();
                  execute();
                });

    this.button =
        Button.create(Icons.link())
            .setTooltip(getLabels().insertLink())
            .addClickListener(
                evt -> {
                  getSelectedRange()
                      .ifPresent(
                          range1 -> {
                            range = range1;
                          });
                  dialog.open();
                });

    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to open the
   *     hyperlink insertion dialog.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, wrapping the current selection within the editable div element with a
   * hyperlink pointing to the entered URL.
   */
  @Override
  protected void execute() {
    if (nonNull(range)) {
      DocumentFragment documentFragment = range.extractContents();
      range.insertNode(a(linkBox.getValue()).appendChild(documentFragment).element());
      this.range = null;
    }
  }
}
