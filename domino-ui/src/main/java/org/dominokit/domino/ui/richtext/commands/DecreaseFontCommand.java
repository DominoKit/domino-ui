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
import org.dominokit.domino.ui.utils.Counter;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI component for decreasing the font size of the selected text within a rich text
 * editor.
 *
 * <p>The DecreaseFontCommand extends {@link RichTextCommand} and provides a mechanism to decrease
 * the font size of the selected text within a rich text editable div element. It utilizes a {@link
 * Counter} to keep track of the current font size and decrease it upon command execution.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * Counter fontSizeCounter = Counter.create(3);
 * DecreaseFontCommand decreaseFontCommand = DecreaseFontCommand.create(editableDiv, fontSizeCounter);
 * }</pre>
 */
public class DecreaseFontCommand extends RichTextCommand<DecreaseFontCommand> {

  private final Counter fontSize;
  private Button button;

  /**
   * Factory method to create a new instance of DecreaseFontCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @param fontSize The counter to keep track of the font size.
   * @return A new instance of DecreaseFontCommand.
   */
  public static DecreaseFontCommand create(DivElement editableElement, Counter fontSize) {
    return new DecreaseFontCommand(editableElement, fontSize);
  }

  /**
   * Constructs a new DecreaseFontCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   * @param fontSize The counter to keep track of the font size.
   */
  public DecreaseFontCommand(DivElement editableElement, Counter fontSize) {
    super(editableElement);
    this.fontSize = fontSize;
    this.button =
        Button.create(Icons.format_font_size_decrease())
            .setTooltip(getLabels().decreaseFontSize())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button for decreasing the
   *     font size.
   * @return The HTMLElement of the decrease font size button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, decreasing the font size of the currently selected text within the
   * editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand(
                  "fontSize", false, String.valueOf(fontSize.decrement().get()));
            });
  }
}
