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
 * A UI component for executing the copy command on a selected range within a rich text editor.
 *
 * <p>The CopyCommand extends {@link RichTextCommand} to provide the capability to copy the selected
 * text from a rich text editable element. It incorporates a button with a copy icon to represent
 * and execute the copy command.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * CopyCommand copyCommand = CopyCommand.create(editableDiv);
 * }</pre>
 */
public class CopyCommand extends RichTextCommand<CopyCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of CopyCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of CopyCommand.
   */
  public static CopyCommand create(DivElement editableElement) {
    return new CopyCommand(editableElement);
  }

  /**
   * Constructs a new CopyCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public CopyCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.content_copy())
            .setTooltip(getLabels().copy())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button for copying the text.
   * @return The HTMLElement of the copy button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, copying the currently selected text within the editable div element to
   * the system clipboard.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("copy");
            });
  }
}
