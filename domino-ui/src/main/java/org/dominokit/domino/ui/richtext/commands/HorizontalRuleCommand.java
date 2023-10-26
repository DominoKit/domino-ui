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
 * Represents a UI command to insert a horizontal rule within a rich text editor.
 *
 * <p>The HorizontalRuleCommand extends {@link RichTextCommand} and provides the ability to insert a
 * horizontal rule (line) into the content of a rich text editable div element. The command is
 * represented by a button with a minus icon.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * HorizontalRuleCommand ruleCommand = HorizontalRuleCommand.create(editableDiv);
 * }</pre>
 */
public class HorizontalRuleCommand extends RichTextCommand<HorizontalRuleCommand> {

  private Button button;

  /**
   * Factory method to create a new instance of HorizontalRuleCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of HorizontalRuleCommand.
   */
  public static HorizontalRuleCommand create(DivElement editableElement) {
    return new HorizontalRuleCommand(editableElement);
  }

  /**
   * Constructs a new HorizontalRuleCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public HorizontalRuleCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.minus())
            .setTooltip(getLabels().insertHorizontalRule())
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the button used to insert the
   *     horizontal rule.
   * @return The HTMLElement of the button.
   */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /**
   * Executes the command, inserting a horizontal rule at the current position within the editable
   * div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("insertHorizontalRule");
            });
  }
}
