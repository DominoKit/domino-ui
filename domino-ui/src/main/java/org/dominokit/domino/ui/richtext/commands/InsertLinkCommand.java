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

import elemental2.dom.DocumentFragment;
import elemental2.dom.HTMLElement;
import elemental2.dom.Range;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.ConfirmationDialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;

public class InsertLinkCommand extends RichTextCommand<InsertLinkCommand> {

  private final ConfirmationDialog dialog;
  private TextBox linkBox;
  private Button button;
  private Range range;

  public static InsertLinkCommand create(DivElement editableElement) {
    return new InsertLinkCommand(editableElement);
  }

  public InsertLinkCommand(DivElement editableElement) {
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

  @Override
  public HTMLElement element() {
    return button.element();
  }

  @Override
  protected void execute() {
    if (nonNull(range)) {
      DocumentFragment documentFragment = range.extractContents();
      range.insertNode(a(linkBox.getValue()).appendChild(documentFragment).element());
      this.range = null;
    }
  }
}
