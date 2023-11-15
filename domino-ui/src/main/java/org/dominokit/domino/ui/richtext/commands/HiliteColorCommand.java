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
import org.dominokit.domino.ui.richtext.HiliteColorPicker;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI component for setting the highlight color of the selected text within a rich text
 * editor.
 *
 * <p>The HiliteColorCommand extends {@link RichTextCommand} and provides a mechanism to set the
 * highlight (background) color of the selected text within a rich text editable div element. The
 * command presents a color picker to the user, allowing them to select the desired highlight color.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * HiliteColorCommand hiliteColorCommand = HiliteColorCommand.create(editableDiv);
 * }</pre>
 */
public class HiliteColorCommand extends RichTextCommand<HiliteColorCommand> {

  private ColorPickerButton foregroundColorPicker;

  /**
   * Factory method to create a new instance of HiliteColorCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of HiliteColorCommand.
   */
  public static HiliteColorCommand create(DivElement editableElement) {
    return new HiliteColorCommand(editableElement);
  }

  /**
   * Constructs a new HiliteColorCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public HiliteColorCommand(DivElement editableElement) {
    super(editableElement);
    this.foregroundColorPicker =
        HiliteColorPicker.create()
            .setTooltip(getLabels().highlightColor())
            .withColorPicker(
                (parent, picker) -> picker.addChangeListener((oldValue, newValue) -> execute()))
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the highlight color picker
   *     button.
   * @return The HTMLElement of the highlight color picker button.
   */
  @Override
  public HTMLElement element() {
    return foregroundColorPicker.element();
  }

  /**
   * Executes the command, setting the highlight color for the currently selected text within the
   * editable div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand(
                  "hiliteColor", false, foregroundColorPicker.getColorPicker().getValue().getHex());
            });
  }
}
