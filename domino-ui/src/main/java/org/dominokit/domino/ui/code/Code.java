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
import static org.jboss.elemento.Elements.code;
import static org.jboss.elemento.Elements.pre;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import org.jboss.elemento.IsElement;

/**
 * A component to create code blocks
 *
 * <p>This component wraps a string inside a
 *
 * <pre>pre</pre>
 *
 * and
 *
 * <pre>code</pre>
 *
 * element
 */
public class Code {

  private static final String CODE_STYLE = "overflow-x: scroll; white-space: pre;";

  /**
   * Wraps a string inside
   *
   * <pre>pre</pre>
   *
   * element
   */
  public static class Block implements IsElement<HTMLPreElement> {
    private final HTMLPreElement element;

    private Block(HTMLPreElement element) {
      this.element = element;
    }

    /**
     * set the code to be wrapped inside the the
     *
     * <pre>pre</pre>
     *
     * and
     *
     * <pre>code</pre>
     *
     * elements
     *
     * @param code String, the code string
     * @return same Block instance
     */
    public Block setCode(String code) {
      if (nonNull(element.firstChild)) element.removeChild(element.firstChild);
      element.appendChild(code().style(CODE_STYLE).textContent(code).element());
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public HTMLPreElement element() {
      return element;
    }
  }

  /**
   * Wrap a single line string into a
   *
   * <pre>code</pre>
   *
   * element
   */
  public static class Statement implements IsElement<HTMLElement> {
    private final HTMLElement element;

    private Statement(HTMLElement element) {
      this.element = element;
    }

    /** {@inheritDoc} */
    @Override
    public HTMLElement element() {
      return element;
    }
  }

  /**
   * Factory to create code Block
   *
   * @param code The code String
   * @return new Block instance
   */
  public static Block block(String code) {
    return new Block(pre().add(code().style(CODE_STYLE).textContent(code)).element());
  }

  /**
   * creates a empty code Block
   *
   * @return new empty Block instance
   */
  public static Block block() {
    return new Block(pre().element());
  }

  /**
   * factory to create a single statement code block
   *
   * @param code The code string
   * @return new Statement instance
   */
  public static Statement statement(String code) {
    return new Statement(code().style(CODE_STYLE).textContent(code).element());
  }
}
