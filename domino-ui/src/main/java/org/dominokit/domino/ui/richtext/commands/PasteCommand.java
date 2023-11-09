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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoNavigator;

/**
 * Represents a UI command to paste the content from the clipboard into the rich text editor.
 *
 * <p>The {@code PasteCommand} extends {@link RichTextCommand} and provides users with the ability
 * to paste the content from the system clipboard directly into the rich text editor. The command is
 * represented by a button with a paste icon.
 *
 * <p>This command utilizes the browser's Clipboard API to read the text content from the system
 * clipboard and then inserts it at the current caret position or replaces the selected content in
 * the rich text editor.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * PasteCommand pasteCommand = PasteCommand.create(editableDiv);
 * }</pre>
 */
public class PasteCommand extends RichTextCommand<PasteCommand> {

  private String content;
  private Button button;

  /**
   * Factory method to create a new instance of PasteCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of PasteCommand.
   */
  public static PasteCommand create(DivElement editableElement) {
    return new PasteCommand(editableElement);
  }

  /**
   * Constructs a new PasteCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public PasteCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.content_paste())
            .setTooltip(getLabels().paste())
            .addClickListener(
                evt -> {
                  editableElement.element().focus();
                  Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator)
                      .clipboard
                      .readText()
                      .then(
                          content -> {
                            LOGGER.info(content);
                            this.content = content;
                            execute();
                            return null;
                          });
                  execute();
                });
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to trigger the
   *     paste action.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the paste command, inserting the content from the clipboard into the editable div
   * element at the current caret position or replacing the selected content.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              range.deleteContents();
              range.insertNode(text(content));
            });
  }
}
