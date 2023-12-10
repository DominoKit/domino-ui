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
 * Represents a UI command to redo the last undone action in the rich text editor.
 *
 * <p>The {@code RedoCommand} extends {@link RichTextCommand} and provides users with the ability to
 * redo the most recent undo action in the rich text editor. The command is visually represented by
 * a button with a redo icon.
 *
 * <p>Upon clicking the redo button, if there are any actions that were undone recently, the editor
 * will redo the last action, restoring the state of the editor.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * RedoCommand redoCommand = RedoCommand.create(editableDiv);
 * }</pre>
 */
public class RedoCommand extends RichTextCommand<RedoCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of RedoCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of RedoCommand.
   */
  public static RedoCommand create(DivElement editableElement) {
    return new RedoCommand(editableElement);
  }

  /**
   * Constructs a new RedoCommand instance for the specified editable div element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public RedoCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.redo())
            .setTooltip(getLabels().redo())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to trigger the
   *     redo action.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /** Executes the redo command, redoing the most recent undo action in the rich text editor. */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("redo");
            });
  }
}
