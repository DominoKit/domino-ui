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
 * Represents a UI command to apply superscript formatting to the selected text in the rich text
 * editor.
 *
 * <p>The {@code SuperscriptCommand} extends {@link RichTextCommand} and provides users with the
 * ability to apply a superscript style to the selected text in the rich text editor. The command is
 * visually represented by a button with a superscript icon.
 *
 * <p>Once clicked, the button will toggle the superscript style on the selected text, allowing
 * users to either apply or remove the superscript formatting.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * SuperscriptCommand superscriptCommand = SuperscriptCommand.create(editableDiv);
 * }</pre>
 */
public class SuperscriptCommand extends RichTextCommand<SuperscriptCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of SuperscriptCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of SuperscriptCommand.
   */
  public static SuperscriptCommand create(DivElement editableElement) {
    return new SuperscriptCommand(editableElement);
  }

  /**
   * Constructs a new SuperscriptCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public SuperscriptCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.format_superscript())
            .setTooltip(getLabels().superscript())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to trigger the
   *     superscript action.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the superscript command, toggling the superscript style on the selected text in the
   * rich text editor.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("superscript");
            });
  }
}
