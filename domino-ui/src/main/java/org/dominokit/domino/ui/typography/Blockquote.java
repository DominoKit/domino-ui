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
package org.dominokit.domino.ui.typography;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.BlockquoteElement;
import org.dominokit.domino.ui.elements.FooterElement;
import org.dominokit.domino.ui.elements.ParagraphElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.LazyChild;

/** A wrapper component for <strong>blockquote</strong> HTML tag */
public class Blockquote extends BaseDominoElement<HTMLElement, Blockquote> {

  private final BlockquoteElement element;
  private final ParagraphElement paragraph;
  private LazyChild<FooterElement> footer;

  public Blockquote() {
    element = blockquote().appendChild(paragraph = p());
    footer = LazyChild.of(footer(), element);

    init(this);
  }

  public Blockquote(String text) {
    this();
    setText(text);
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
   * Sets the text value
   *
   * @param text the text value
   * @return same instance
   */
  public Blockquote setText(String text) {
    paragraph.setTextContent(text);
    return this;
  }

  public Blockquote withFooter() {
    footer.get();
    return this;
  }

  public Blockquote withFooter(ChildHandler<Blockquote, FooterElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  public Blockquote appendChild(FooterContent<?> footerContent) {
    footer.get().appendChild(footerContent);
    return this;
  }

  public FooterElement getFooter() {
    return this.footer.get();
  }

  public Blockquote withParagraph(ChildHandler<Blockquote, ParagraphElement> handler) {
    handler.apply(this, paragraph);
    return this;
  }

  public ParagraphElement getParagraph() {
    return paragraph;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
