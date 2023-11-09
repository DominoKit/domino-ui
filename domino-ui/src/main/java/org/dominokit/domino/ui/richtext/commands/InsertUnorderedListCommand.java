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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI command to insert an unordered list (bulleted list) within a rich text editor.
 *
 * <p>The {@code InsertUnorderedListCommand} extends {@link RichTextCommand} and provides users with
 * the ability to insert an unordered list at the current selection position in a rich text editable
 * div element. The command is represented by a button with a bulleted list icon. Clicking the
 * button will convert the current selection or the current line into a list item within an
 * unordered list.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertUnorderedListCommand insertUnorderedListCommand = InsertUnorderedListCommand.create(editableDiv);
 * }</pre>
 */
public class InsertUnorderedListCommand extends RichTextCommand<InsertUnorderedListCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of InsertUnorderedListCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of InsertUnorderedListCommand.
   */
  public static InsertUnorderedListCommand create(DivElement editableElement) {
    return new InsertUnorderedListCommand(editableElement);
  }

  /**
   * Constructs a new InsertUnorderedListCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public InsertUnorderedListCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_list_bulleted())
            .setTooltip(getLabels().insertUnorderedList())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to insert an
   *     unordered list.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, converting the current selection or the current line into a list item
   * within an unordered list in the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("insertUnorderedList");
            });
  }
}
