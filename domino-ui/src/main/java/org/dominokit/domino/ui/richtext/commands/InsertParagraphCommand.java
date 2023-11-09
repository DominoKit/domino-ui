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

import elemental2.dom.DocumentFragment;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;

/**
 * Represents a UI command to insert a paragraph within a rich text editor.
 *
 * <p>The {@code InsertParagraphCommand} extends {@link RichTextCommand} and provides users with the
 * ability to insert a paragraph at the current selection position in a rich text editable div
 * element. The command is represented by a button with a paragraph icon. Clicking the button will
 * wrap the current selection or the current line within a paragraph tag.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertParagraphCommand insertParagraphCommand = InsertParagraphCommand.create(editableDiv);
 * }</pre>
 */
public class InsertParagraphCommand extends RichTextCommand<InsertParagraphCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of InsertParagraphCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of InsertParagraphCommand.
   */
  public static InsertParagraphCommand create(DivElement editableElement) {
    return new InsertParagraphCommand(editableElement);
  }

  /**
   * Constructs a new InsertParagraphCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public InsertParagraphCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_paragraph())
            .setTooltip(getLabels().insertParagraph())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to insert a
   *     paragraph.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, wrapping the current selection or the current line within a paragraph tag
   * in the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DocumentFragment documentFragment = range.extractContents();
              range.deleteContents();
              range.insertNode(p().appendChild(documentFragment).element());
            });
  }
}
