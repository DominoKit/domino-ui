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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.richtext.BackgroundColorPicker;
import org.dominokit.domino.ui.richtext.ColorPickerButton;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * A UI component for applying a background color command to a selected range within a rich text
 * editor.
 *
 * <p>The BackColorCommand extends {@link RichTextCommand} to provide the capability to change the
 * background color of the selected text in a rich text editable element. It incorporates a {@link
 * BackgroundColorPicker} to allow users to choose a desired background color.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * BackColorCommand backColorCommand = BackColorCommand.create(editableDiv);
 * }</pre>
 */
public class BackColorCommand extends RichTextCommand<BackColorCommand> {

  private ColorPickerButton backgroundColorPicker;

  /**
   * Factory method to create a new instance of BackColorCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of BackColorCommand.
   */
  public static BackColorCommand create(DivElement editableElement) {
    return new BackColorCommand(editableElement);
  }

  /**
   * Constructs a new BackColorCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public BackColorCommand(DivElement editableElement) {
    super(editableElement);
    this.backgroundColorPicker =
        BackgroundColorPicker.create()
            .setTooltip(getLabels().backgroundColor())
            .withColorPicker(
                (parent, picker) -> picker.addChangeListener((oldValue, newValue) -> execute()))
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the background color picker.
   * @return The HTMLElement of the background color picker.
   */
  @Override
  public HTMLElement element() {
    return backgroundColorPicker.element();
  }

  /**
   * Executes the command, applying the selected background color to the currently selected text
   * within the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand(
                  "backColor", false, backgroundColorPicker.getColorPicker().getValue().getHex());
            });
  }
}
