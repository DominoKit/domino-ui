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

import elemental2.dom.HTMLElement;
import elemental2.dom.Range;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.ConfirmationDialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;

/**
 * Represents a UI command to insert an image from a link within a rich text editor.
 *
 * <p>The {@code InsertImageLinkCommand} extends {@link RichTextCommand} and allows users to insert
 * an image from a link at the current selection position in a rich text editable div element. The
 * command is represented by a button combined with image and link icons. Clicking on this button
 * opens a confirmation dialog that contains a textbox to input the image link. Confirming the
 * dialog inserts the image from the provided link at the current selection.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertImageLinkCommand insertImageLinkCommand = InsertImageLinkCommand.create(editableDiv);
 * }</pre>
 */
public class InsertImageLinkCommand extends RichTextCommand<InsertImageLinkCommand> {

  private final ConfirmationDialog dialog;
  private TextBox linkBox;
  private Button button;
  private Range range;

  /**
   * Factory method to create a new instance of InsertImageLinkCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of InsertImageLinkCommand.
   */
  public static InsertImageLinkCommand create(DivElement editableElement) {
    return new InsertImageLinkCommand(editableElement);
  }

  /**
   * Constructs a new InsertImageLinkCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public InsertImageLinkCommand(DivElement editableElement) {
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
            .appendChild(linkBox = TextBox.create(getLabels().imageLink()))
            .onConfirm(
                dialog -> {
                  dialog.close();
                  execute();
                });

    this.button =
        Button.create(
                Icons.image()
                    .appendChild(
                        Icons.link()
                            .addCss(dui_font_size_4, dui_absolute, dui_top_1_5)
                            .setCssProperty("right", "15px")
                            .setCssProperty("color", "var(--dui-btn-bg)")))
            .setTooltip(getLabels().linkImage())
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
   *     link insertion dialog.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, inserting the image from the provided link at the current selection
   * position within the editable div element.
   */
  @Override
  protected void execute() {
    if (nonNull(range)) {
      getSelectedRange()
          .ifPresent(
              range -> {
                range.deleteContents();
                range.insertNode(img(linkBox.getValue()).element());
              });
      this.range = null;
    }
  }
}
