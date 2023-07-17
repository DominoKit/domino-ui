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

public class RedoCommand extends RichTextCommand<RedoCommand> {

  private Button button;

  public static RedoCommand create(DivElement editableElement) {
    return new RedoCommand(editableElement);
  }

  public RedoCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        Button.create(Icons.redo())
            .setTooltip(getLabels().redo())
            .addClickListener(evt -> execute());
    init(this);
  }

  @Override
  public HTMLElement element() {
    return button.element();
  }

  @Override
  protected void execute() {
    getSelectedRange()
        .ifPresent(
            range -> {
              DominoDom.document.execCommand("redo");
            });
  }
}
