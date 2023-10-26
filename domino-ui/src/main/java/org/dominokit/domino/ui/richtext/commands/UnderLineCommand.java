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
 * Represents a UI command to apply underline formatting to the selected text in the rich text
 * editor.
 *
 * <p>The {@code UnderLineCommand} extends {@link RichTextCommand} and provides users with the
 * ability to apply an underline style to the selected text in the rich text editor. The command is
 * visually represented by a button with an underline icon.
 *
 * <p>Once clicked, the button will toggle the underline style on the selected text, allowing users
 * to either apply or remove the underline formatting.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * UnderLineCommand underLineCommand = UnderLineCommand.create(editableDiv);
 * }</pre>
 */
public class UnderLineCommand extends RichTextCommand<UnderLineCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of UnderLineCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of UnderLineCommand.
   */
  public static UnderLineCommand create(DivElement editableElement) {
    return new UnderLineCommand(editableElement);
  }

  /**
   * Constructs a new UnderLineCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public UnderLineCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_underline())
            .setTooltip(getLabels().underline())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to trigger the
   *     underline action.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the underline command, toggling the underline style on the selected text in the rich
   * text editor.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("underline");
            });
  }
}
