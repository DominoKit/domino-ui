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
package org.dominokit.domino.ui.code;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.DisplayCss.dui_overflow_x_scroll;
import static org.dominokit.domino.ui.style.SpacingCss.dui_whitespace_pre;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import org.dominokit.domino.ui.elements.PreElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component to create code blocks
 *
 * <p>This component wraps a string inside a
 *
 * <pre>pre</pre>
 *
 * <p>and
 *
 * <pre>code</pre>
 *
 * <p>element
 */
public class Code {

  /**
   * Wraps a string inside
   *
   * <pre>pre</pre>
   *
   * <p>element
   */
  public static class Block extends BaseDominoElement<HTMLPreElement, Block> {
    private final PreElement element;

    private Block(HTMLPreElement element) {
      this.element = PreElement.of(element);
      init(this);
    }

    /**
     * set the code to be wrapped inside the element
     *
     * <pre>pre</pre>
     *
     * <p>and
     *
     * <pre>code</pre>
     *
     * <p>elements
     *
     * @param code String, the code string
     * @return same Block instance
     */
    public Block setCode(String code) {
      if (nonNull(element.getFirstChild())) element.removeChild(element.getFirstChild());
      element.appendChild(
          code().addCss(dui_overflow_x_scroll, dui_whitespace_pre).textContent(code));
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public HTMLPreElement element() {
      return element.element();
    }
  }

  /**
   * Wrap a single line string into a
   *
   * <pre>code</pre>
   *
   * <p>element
   */
  public static class Statement extends BaseDominoElement<HTMLElement, Statement> {
    private final DominoElement<HTMLElement> element;

    private Statement(HTMLElement element) {
      this.element = elementOf(element);
      init(this);
    }

    /** {@inheritDoc} */
    @Override
    public HTMLElement element() {
      return element.element();
    }
  }

  /**
   * Factory to create code Block
   *
   * @param codeText The code String
   * @return new Block instance
   */
  public static Block block(String codeText) {
    return new Block(
        elements
            .pre()
            .appendChild(
                elements
                    .code()
                    .addCss(dui_overflow_x_scroll, dui_whitespace_pre)
                    .textContent(codeText))
            .element());
  }

  /**
   * creates a empty code Block
   *
   * @return new empty Block instance
   */
  public static Block block() {
    return new Block(elements.pre().element());
  }

  /**
   * factory to create a single statement code block
   *
   * @param code The code string
   * @return new Statement instance
   */
  public static Statement statement(String code) {
    return new Statement(
        elements
            .code()
            .addCss(dui_overflow_x_scroll, dui_whitespace_pre)
            .textContent(code)
            .element());
  }
}
