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
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.IsRichTextEditor;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI command to increase the indentation within a rich text editor.
 *
 * <p>The IndentCommand extends {@link RichTextCommand} and provides the ability to increment the
 * indentation of the selected text or block in a rich text editable div element. The command is
 * represented by a button with an icon indicating increasing indentation.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * IndentCommand indentCommand = IndentCommand.create(editableDiv);
 * }</pre>
 */
public class IndentCommand extends RichTextCommand<IndentCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of IndentCommand.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   * @return A new instance of IndentCommand.
   */
  public static IndentCommand create(IsRichTextEditor isRichTextEditor) {
    return new IndentCommand(isRichTextEditor);
  }

  /**
   * Constructs a new IndentCommand instance for the specified editable div element.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   */
  public IndentCommand(IsRichTextEditor isRichTextEditor) {
    super(isRichTextEditor);
    this.button =
        Button.create(Icons.format_indent_increase())
            .setTooltip(getLabels().increaseIndent())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to increase the
   *     indentation.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, increasing the indentation of the selected text or block within the
   * editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("indent");
            });
  }
}
