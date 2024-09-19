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
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.IsRichTextEditor;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * A UI component for applying the bold text formatting command to a selected range within a rich
 * text editor.
 *
 * <p>The BoldCommand extends {@link RichTextCommand} to provide the capability to bolden the
 * selected text in a rich text editable element. It incorporates a button with a bold icon to
 * represent and execute the bold command.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * BoldCommand boldCommand = BoldCommand.create(editableDiv);
 * }</pre>
 */
public class BoldCommand extends RichTextCommand<BoldCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of BoldCommand.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   * @return A new instance of BoldCommand.
   */
  public static BoldCommand create(IsRichTextEditor isRichTextEditor) {
    return new BoldCommand(isRichTextEditor);
  }

  /**
   * Constructs a new BoldCommand instance for the specified editable element.
   *
   * @param isRichTextEditor The div element where the rich text is edited.
   */
  public BoldCommand(IsRichTextEditor isRichTextEditor) {
    super(isRichTextEditor);
    this.button =
        Button.create(Icons.format_bold())
            .setTooltip(getLabels().bold())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button for boldening the
   *     text.
   * @return The HTMLElement of the bold button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, applying bold text formatting to the currently selected text within the
   * editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("bold");
            });
  }
}
