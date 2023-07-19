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

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.ConfirmationDialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DOMParser;

public class InsertHtmlCommand extends RichTextCommand<InsertHtmlCommand> {

  private final ConfirmationDialog dialog;
  private final DivElement editableElement;
  private TextAreaBox htmlText;
  private Button button;
  private Range range;

  public static InsertHtmlCommand create(DivElement editableElement) {
    return new InsertHtmlCommand(editableElement);
  }

  public InsertHtmlCommand(DivElement editableElement) {
    super(editableElement);
    this.editableElement = editableElement;

    this.dialog =
        ConfirmationDialog.create()
            .setStretchWidth(DialogSize.MEDIUM)
            .setStretchHeight(DialogSize.SMALL)
            .withConfirmButton(
                (parent, confirmButton) -> confirmButton.setText(getLabels().insert()))
            .withRejectButton(
                (parent, rejectbutton) ->
                    rejectbutton
                        .setText(getLabels().close())
                        .addCss(dui_dominant)
                        .setIcon(Icons.close()))
            .appendChild(htmlText = TextAreaBox.create("HTML"))
            .onConfirm(
                dialog -> {
                  dialog.close();
                  execute();
                });

    this.button =
        Button.create(Icons.code_tags())
            .setTooltip(getLabels().insertHtml())
            .addClickListener(
                evt -> {
                  Selection sel;
                  if (nonNull(DomGlobal.window.getSelection())) {
                    sel = DomGlobal.window.getSelection();
                    if (sel.rangeCount > -1) {
                      range = sel.getRangeAt(0).cloneRange();
                    }
                  }
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
    getSelectedRange()
        .ifPresent(
            range -> {
              range.deleteContents();
              DocumentFragment documentFragment = new DocumentFragment();
              HTMLDocument document =
                  Js.uncheckedCast(
                      new DOMParser().parseFromString(htmlText.getValue(), "text/html"));
              document.body.childNodes.forEach(
                  (currentValue, currentIndex, listObj) -> {
                    documentFragment.append(currentValue);
                    return null;
                  });

              range.insertNode(documentFragment);
            });
  }
}
