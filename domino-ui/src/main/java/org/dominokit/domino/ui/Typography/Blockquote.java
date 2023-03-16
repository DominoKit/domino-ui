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
package org.dominokit.domino.ui.Typography;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLQuoteElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

/** A wrapper component for <strong>blockquote</strong> HTML tag */
public class Blockquote extends BaseDominoElement<HTMLElement, Blockquote> {

  private final DominoElement<HTMLQuoteElement> element =
      blockquote().css(m_b_25);
  private Paragraph paragraph = Paragraph.create();
  private DominoElement<HTMLElement> footer;

  public Blockquote() {
    element.appendChild(paragraph);
    init(this);
  }

  public Blockquote(String text) {
    this.paragraph.setText(text);
    element.appendChild(paragraph);
    init(this);
  }

  public Blockquote(Paragraph paragraph) {
    this.paragraph = paragraph;
    element.appendChild(paragraph);
    init(this);
  }

  /** @return new instance with empty text */
  public static Blockquote create() {
    return new Blockquote();
  }

  /**
   * @param text the value
   * @return new instance with text
   */
  public static Blockquote create(String text) {
    return new Blockquote(text);
  }

  /**
   * @param paragraph the {@link Paragraph} child
   * @return new instance with empty text
   */
  public static Blockquote create(Paragraph paragraph) {
    return new Blockquote(paragraph);
  }

  /**
   * Sets the text value
   *
   * @param text the text value
   * @return same instance
   */
  public Blockquote setText(String text) {
    paragraph.setText(text);
    return this;
  }

  /**
   * Sets the footer content
   *
   * @param content the {@link Node} content
   * @return same instance
   */
  public Blockquote setFooterContent(Node content) {
    if (nonNull(footer)) footer.remove();

    footer = footer().add(content);
    element.appendChild(footer);
    return this;
  }

  /**
   * Sets the footer text
   *
   * @param text the footer text
   * @return same instance
   */
  public Blockquote setFooterText(String text) {
    return setFooterContent(TextNode.of(text));
  }

  /**
   * Swap the sizes between the content and the footer
   *
   * @return same instance
   */
  public Blockquote reverse() {
    element.removeCss(blockquote_reverse);
    element.addCss(blockquote_reverse);
    return this;
  }

  /** @deprecated use {@link #appendFooterChild(Node)} */
  @Deprecated
  public Blockquote appendFooterContent(Node content) {
    return appendFooterChild(content);
  }

  /**
   * Adds a new content to the footer
   *
   * @param content the {@link Node} to add
   * @return same instance
   */
  public Blockquote appendFooterChild(Node content) {
    if (isNull(footer)) setFooterContent(content);
    else footer.appendChild(content);

    return this;
  }

  /**
   * Adds a new content to the footer
   *
   * @param content the {@link IsElement} to add
   * @return same instance
   */
  public Blockquote appendFooterChild(IsElement<?> content) {
    return appendFooterChild(content.element());
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
