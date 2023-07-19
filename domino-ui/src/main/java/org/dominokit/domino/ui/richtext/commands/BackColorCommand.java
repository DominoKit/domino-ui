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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.richtext.BackgroundColorPicker;
import org.dominokit.domino.ui.richtext.ColorPickerButton;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

public class BackColorCommand extends RichTextCommand<BackColorCommand> {

  private ColorPickerButton backgroundColorPicker;

  public static BackColorCommand create(DivElement editableElement) {
    return new BackColorCommand(editableElement);
  }

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

  @Override
  public HTMLElement element() {
    return backgroundColorPicker.element();
  }

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
