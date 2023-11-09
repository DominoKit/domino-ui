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
 * Represents a UI command to apply right justification formatting to the selected text or paragraph
 * within a rich text editor.
 *
 * <p>The {@code JustifyRightCommand} extends {@link RichTextCommand} and provides users the ability
 * to justify the text to the right of its container. The command is represented by a button with a
 * right alignment icon. When this button is clicked, it applies right justification to the
 * currently selected text or paragraphs.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * JustifyRightCommand justifyRightCommand = JustifyRightCommand.create(editableDiv);
 * }</pre>
 */
public class JustifyRightCommand extends RichTextCommand<JustifyRightCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of JustifyRightCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of JustifyRightCommand.
   */
  public static JustifyRightCommand create(DivElement editableElement) {
    return new JustifyRightCommand(editableElement);
  }

  /**
   * Constructs a new JustifyRightCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public JustifyRightCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_align_right())
            .setTooltip(getLabels().justifyRight())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to apply the
   *     right justification formatting.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, applying right justification formatting to the selected text or paragraph
   * in the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("justifyRight");
            });
  }
}
