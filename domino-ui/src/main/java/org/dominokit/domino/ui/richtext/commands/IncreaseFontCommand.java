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
import org.dominokit.domino.ui.utils.Counter;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI command to increase the font size within a rich text editor.
 *
 * <p>The IncreaseFontCommand extends {@link RichTextCommand} and provides the ability to increment
 * the font size of the selected text in a rich text editable div element. The command is
 * represented by a button with an icon indicating increasing font size.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * Counter fontSizeCounter = Counter.create();
 * IncreaseFontCommand fontIncreaseCommand = IncreaseFontCommand.create(editableDiv, fontSizeCounter);
 * }</pre>
 */
public class IncreaseFontCommand extends RichTextCommand<IncreaseFontCommand> {

  private final Counter fontSize;
  private Button button;

  /**
   * Factory method to create a new instance of IncreaseFontCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @param fontSize A counter to manage the font size incrementally.
   * @return A new instance of IncreaseFontCommand.
   */
  public static IncreaseFontCommand create(DivElement editableElement, Counter fontSize) {
    return new IncreaseFontCommand(editableElement, fontSize);
  }

  /**
   * Constructs a new IncreaseFontCommand instance for the specified editable element and font size
   * counter.
   *
   * @param editableElement The div element where the rich text is edited.
   * @param fontSize A counter to manage the font size incrementally.
   */
  public IncreaseFontCommand(DivElement editableElement, Counter fontSize) {
    super(editableElement);
    this.fontSize = fontSize;
    this.button =
        Button.create(Icons.format_font_size_increase())
            .setTooltip(getLabels().increaseFontSize())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to increase the
   *     font size.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, increasing the font size of the selected text within the editable div
   * element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand(
                  "fontSize", false, String.valueOf(fontSize.increment().get()));
            });
  }
}
