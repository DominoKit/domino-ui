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
 * Represents a UI component for executing the cut command on a selected range within a rich text
 * editor.
 *
 * <p>The CutCommand extends {@link RichTextCommand} to offer the capability to cut the selected
 * text from a rich text editable element. It features a button with a cut icon to represent and
 * trigger the cut action.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * CutCommand cutCommand = CutCommand.create(editableDiv);
 * }</pre>
 */
public class CutCommand extends RichTextCommand<CutCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of CutCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of CutCommand.
   */
  public static CutCommand create(DivElement editableElement) {
    return new CutCommand(editableElement);
  }

  /**
   * Constructs a new CutCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public CutCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.content_cut())
            .setTooltip(getLabels().cut())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button for cutting the text.
   * @return The HTMLElement of the cut button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, cutting the currently selected text within the editable div element,
   * removing it from the document and moving it to the system clipboard.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("cut");
            });
  }
}
