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
import org.dominokit.domino.ui.richtext.ColorPickerButton;
import org.dominokit.domino.ui.richtext.ForegroundColorPicker;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI component for setting the foreground color (text color) of the selected text
 * within a rich text editor.
 *
 * <p>The ForeColorCommand extends {@link RichTextCommand} and provides a mechanism to change the
 * text color of the selected text within a rich text editable div element. It integrates with
 * {@link ForegroundColorPicker} to allow the user to select a color and then applies the chosen
 * color to the selected text.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * ForeColorCommand foreColorCommand = ForeColorCommand.create(editableDiv);
 * }</pre>
 */
public class ForeColorCommand extends RichTextCommand<ForeColorCommand> {

  private ColorPickerButton foregroundColorPicker;

  /**
   * Factory method to create a new instance of ForeColorCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of ForeColorCommand.
   */
  public static ForeColorCommand create(DivElement editableElement) {
    return new ForeColorCommand(editableElement);
  }

  /**
   * Constructs a new ForeColorCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public ForeColorCommand(DivElement editableElement) {
    super(editableElement);
    this.foregroundColorPicker =
        ForegroundColorPicker.create()
            .setTooltip(getLabels().foreColor())
            .withColorPicker(
                (parent, picker) -> picker.addChangeListener((oldValue, newValue) -> execute()))
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the foreground color picker
   *     element.
   * @return The HTMLElement of the foreground color picker.
   */
  @Override
  public HTMLElement element() {
    return foregroundColorPicker.element();
  }

  /**
   * Executes the command, setting the foreground color (text color) for the currently selected text
   * within the editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand(
                  "foreColor", false, foregroundColorPicker.getColorPicker().getValue().getHex());
            });
  }
}
