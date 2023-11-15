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

import elemental2.dom.*;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.ConfirmationDialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.UploadBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.URL;

/**
 * Represents a UI command to insert an image within a rich text editor.
 *
 * <p>The {@code InsertImageCommand} extends {@link RichTextCommand} and provides the ability to
 * insert an image at the current selection position in a rich text editable div element. The
 * command is represented by a button with an appropriate icon. Clicking on this button opens a
 * confirmation dialog that contains an upload box. Users can select an image through this upload
 * box. Confirming the dialog inserts the selected image at the current position.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertImageCommand insertImageCommand = InsertImageCommand.create(editableDiv);
 * }</pre>
 */
public class InsertImageCommand extends RichTextCommand<InsertImageCommand> {

  private final ConfirmationDialog dialog;
  private UploadBox uploadBox;
  private Button button;
  private Range range;
  private String url;

  /**
   * Factory method to create a new instance of InsertImageCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of InsertImageCommand.
   */
  public static InsertImageCommand create(DivElement editableElement) {
    return new InsertImageCommand(editableElement);
  }

  /**
   * Constructs a new InsertImageCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public InsertImageCommand(DivElement editableElement) {
    super(editableElement);
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
            .appendChild(
                uploadBox =
                    UploadBox.create(getLabels().chooseImage())
                        .withInputElement(
                            (parent, input) -> {
                              input.addEventListener(
                                  "change",
                                  evt -> {
                                    FileList files = uploadBox.getInputElement().element().files;
                                    if (files.length > 0) {
                                      File item = files.item(0);
                                      this.url = URL.createObjectURL(item);
                                    } else {
                                      this.url = null;
                                    }
                                  });
                            }))
            .onConfirm(
                dialog -> {
                  dialog.close();
                  execute();
                });

    this.button =
        Button.create(Icons.image())
            .setTooltip(getLabels().insertImage())
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
   *     <p>Returns the main HTMLElement of this command, which is the button used to open the image
   *     insertion dialog.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, inserting the selected image at the current selection position within the
   * editable div element.
   */
  @Override
  protected void execute() {
    if (nonNull(range)) {
      if (nonNull(this.url)) {
        getSelectedRange()
            .ifPresent(
                range -> {
                  range.deleteContents();
                  range.insertNode(img(this.url).element());
                });
      }
      this.range = null;
    }
  }
}
