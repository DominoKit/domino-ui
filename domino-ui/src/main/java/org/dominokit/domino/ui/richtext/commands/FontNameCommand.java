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
import org.dominokit.domino.ui.richtext.FontPicker;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * Represents a UI component for setting the font name of the selected text within a rich text
 * editor.
 *
 * <p>The FontNameCommand extends {@link RichTextCommand} and provides a mechanism to change the
 * font name of the selected text within a rich text editable div element. It integrates with {@link
 * FontPicker} to present the user with available font options and then applies the chosen font to
 * the selected text.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DivElement editableDiv = DivElement.create();
 * FontNameCommand fontNameCommand = FontNameCommand.create(editableDiv);
 * }</pre>
 */
public class FontNameCommand extends RichTextCommand<FontNameCommand> {

  private String fontName;
  private FontPicker fontPicker;

  /**
   * Factory method to create a new instance of FontNameCommand.
   *
   * @param editableElement The div element where the rich text is edited.
   * @return A new instance of FontNameCommand.
   */
  public static FontNameCommand create(DivElement editableElement) {
    return new FontNameCommand(editableElement);
  }

  /**
   * Constructs a new FontNameCommand instance for the specified editable element.
   *
   * @param editableElement The div element where the rich text is edited.
   */
  public FontNameCommand(DivElement editableElement) {
    super(editableElement);
    this.fontPicker =
        FontPicker.create()
            .setTooltip(getLabels().fontFamily())
            .withMenu(
                (parent, menu) ->
                    menu.addSelectionListener(
                        (source, selection) -> {
                          this.fontName = selection.get(0).getValue();
                          execute();
                        }))
            .addClickListener(evt -> execute());
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this command, which is the font picker element.
   * @return The HTMLElement of the font picker.
   */
  @Override
  public HTMLElement element() {
    return fontPicker.element();
  }

  /**
   * Executes the command, setting the font name for the currently selected text within the editable
   * div element.
   */
  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("fontName", false, fontName);
            });
  }
}
