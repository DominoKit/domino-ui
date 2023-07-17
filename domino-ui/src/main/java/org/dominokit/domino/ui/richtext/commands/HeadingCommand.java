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
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.richtext.RichTextCommand;
import org.dominokit.domino.ui.utils.DominoDom;

public class HeadingCommand extends RichTextCommand<HeadingCommand> {

  private Button mainButton;
  private String heading = "<h1>";
  private ButtonsGroup button;

  public static HeadingCommand create(DivElement editableElement) {
    return new HeadingCommand(editableElement);
  }

  public HeadingCommand(DivElement editableElement) {
    super(editableElement);
    this.button =
        ButtonsGroup.create(
                mainButton =
                    Button.create(Icons.format_header_1()).addClickListener(evt -> execute()),
                DropdownButton.create(
                    Button.create(Icons.chevron_down()),
                    Menu.<String>create()
                        .setDropDirection(DropDirection.BOTTOM_LEFT)
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(1).textContent(getLabels().heading1()))
                                .withValue("<h1>"))
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(2).textContent(getLabels().heading2()))
                                .withValue("<h2>"))
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(3).textContent(getLabels().heading3()))
                                .withValue("<h3>"))
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(4).textContent(getLabels().heading4()))
                                .withValue("<h4>"))
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(5).textContent(getLabels().heading5()))
                                .withValue("<h5>"))
                        .appendChild(
                            CustomMenuItem.<String>create()
                                .appendChild(h(6).textContent(getLabels().heading6()))
                                .withValue("<h6>"))
                        .addSelectionListener(
                            (source, selection) -> {
                              this.heading = selection.get(0).getValue();
                              switch (heading) {
                                case "<h1>":
                                  mainButton.setIcon(Icons.format_header_1());
                                  break;
                                case "<h2>":
                                  mainButton.setIcon(Icons.format_header_2());
                                  break;
                                case "<h3>":
                                  mainButton.setIcon(Icons.format_header_3());
                                  break;
                                case "<h4>":
                                  mainButton.setIcon(Icons.format_header_4());
                                  break;
                                case "<h5>":
                                  mainButton.setIcon(Icons.format_header_5());
                                  break;
                                case "<h6>":
                                  mainButton.setIcon(Icons.format_header_6());
                                  break;
                              }
                              execute();
                            })))
            .setTooltip(getLabels().heading());
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
              DominoDom.document.execCommand("formatBlock", false, heading);
            });
  }
}
