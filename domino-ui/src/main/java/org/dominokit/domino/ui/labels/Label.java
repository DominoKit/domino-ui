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
package org.dominokit.domino.ui.labels;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;

/**
 * A component for showing headings in different sizes and colors
 *
 * <p>For example:
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @see HasContent
 */
public class Label extends BaseDominoElement<HTMLElement, Label> {

  public static CssClass dui_label = () -> "dui-label";

  private final DominoElement<HTMLElement> element;

  private Label() {
    element = span().addCss(dui_label);
    init(this);
  }

  public Label(String text) {
    this();
    element.setTextContent(text);
  }

  /**
   * Creates with content and no type
   *
   * @param text the text content
   * @return new instance
   */
  public static Label create(String text) {
    return new Label(text);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /** {@inheritDoc} */
  public Label setText(String text) {
    element.setTextContent(text);
    return this;
  }
}
