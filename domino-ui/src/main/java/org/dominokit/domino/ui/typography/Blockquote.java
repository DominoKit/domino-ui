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

  /** Constructor for Blockquote. */
  public Blockquote() {
    element = blockquote().appendChild(paragraph = p());
    footer = LazyChild.of(footer(), element);

    init(this);
  }

  /**
   * Constructor for Blockquote.
   *
   * @param text a {@link java.lang.String} object
   */
  public Blockquote(String text) {
    this();
    setText(text);
  }

  /** @return new instance with empty text */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.typography.Blockquote} object
   */
  public static Blockquote create() {
    return new Blockquote();
  }

  /**
   * create.
   *
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

  /**
   * withFooter.
   *
   * @return a {@link org.dominokit.domino.ui.typography.Blockquote} object
   */
  public Blockquote withFooter() {
    footer.get();
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.typography.Blockquote} object
   */
  public Blockquote withFooter(ChildHandler<Blockquote, FooterElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * appendChild.
   *
   * @param footerContent a {@link org.dominokit.domino.ui.utils.FooterContent} object
   * @return a {@link org.dominokit.domino.ui.typography.Blockquote} object
   */
  public Blockquote appendChild(FooterContent<?> footerContent) {
    footer.get().appendChild(footerContent);
    return this;
  }

  /**
   * Getter for the field <code>footer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FooterElement} object
   */
  public FooterElement getFooter() {
    return this.footer.get();
  }

  /**
   * withParagraph.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.typography.Blockquote} object
   */
  public Blockquote withParagraph(ChildHandler<Blockquote, ParagraphElement> handler) {
    handler.apply(this, paragraph);
    return this;
  }

  /**
   * Getter for the field <code>paragraph</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ParagraphElement} object
   */
  public ParagraphElement getParagraph() {
    return paragraph;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
