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

import static java.util.Objects.nonNull;

import elemental2.dom.DocumentFragment;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.NodeList;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.richtext.RichTextCommand;

public class RemoveLinkCommand extends RichTextCommand<RemoveLinkCommand> {

  private Button button;

  public static RemoveLinkCommand create(DivElement editableElement) {
    return new RemoveLinkCommand(editableElement);
  }

  public RemoveLinkCommand(DivElement editableElement) {
    super(editableElement);

    this.button =
        Button.create(Icons.link_off())
            .setTooltip(getLabels().removeLinks())
            .addClickListener(
                evt -> {
                  execute();
                });

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
              DocumentFragment documentFragment = range.extractContents();
              NodeList<Element> anchors = documentFragment.querySelectorAll("a");
              anchors.forEach(
                  (currentValue, currentIndex, listObj) -> {
                    unwrap(currentValue, documentFragment);
                    return null;
                  });
              range.deleteContents();
              range.insertNode(documentFragment);
            });
  }

  private void unwrap(Element el, DocumentFragment documentFragment) {
    if (nonNull(el)) {
      while (nonNull(el.firstChild)) {
        if (nonNull(el.parentNode)) {
          el.parentNode.insertBefore(el.firstChild, el);
        } else {
          documentFragment.insertBefore(el.firstChild, el);
        }
      }
      el.remove();
    }
  }
}
