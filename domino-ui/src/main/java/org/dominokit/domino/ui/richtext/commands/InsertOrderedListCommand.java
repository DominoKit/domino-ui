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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI command to insert an ordered list within a rich text editor.
 *
 * <p>The {@code InsertOrderedListCommand} extends {@link RichTextCommand} and provides users with
 * the ability to insert an ordered (numbered) list at the current selection position in a rich text
 * editable div element. The command is represented by a button with a numbered list icon. Clicking
 * the button will convert the current selection or the current line into an item of an ordered
 * list.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * InsertOrderedListCommand insertOrderedListCommand = InsertOrderedListCommand.create(editableDiv);
 * }</pre>
 */
public class InsertOrderedListCommand extends RichTextCommand<InsertOrderedListCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of InsertOrderedListCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of InsertOrderedListCommand.
   */
  public static InsertOrderedListCommand create(DivElement editableElement) {
    return new InsertOrderedListCommand(editableElement);
  }

  /**
   * Constructs a new InsertOrderedListCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public InsertOrderedListCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_list_numbered())
            .setTooltip(getLabels().insertOrderedList())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to insert an
   *     ordered list.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, converting the current selection or the current line into an item of an
   * ordered list within the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("insertOrderedList");
            });
  }
}
