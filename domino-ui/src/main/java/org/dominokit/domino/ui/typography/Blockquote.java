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

/**
 * The `Blockquote` class represents a blockquote element with an optional footer and paragraph
 * content. It is used to display quoted content with optional attribution and additional
 * information.
 *
 * @see BaseDominoElement
 */
public class Blockquote extends BaseDominoElement<HTMLElement, Blockquote> {

  private final BlockquoteElement element;
  private final ParagraphElement paragraph;
  private LazyChild<FooterElement> footer;

  /** Constructs a new `Blockquote` instance without any text content. */
  public Blockquote() {
    element = blockquote().appendChild(paragraph = p());
    footer = LazyChild.of(footer(), element);

    init(this);
  }

  /**
   * Constructs a new `Blockquote` instance with the specified text content.
   *
   * @param text The text content to be displayed in the blockquote.
   */
  public Blockquote(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a new empty `Blockquote` instance.
   *
   * @return A new `Blockquote` instance without any text content.
   */
  public static Blockquote create() {
    return new Blockquote();
  }

  /**
   * Creates a new `Blockquote` instance with the specified text content.
   *
   * @param text The text content to be displayed in the blockquote.
   * @return A new `Blockquote` instance with the specified text content.
   */
  public static Blockquote create(String text) {
    return new Blockquote(text);
  }

  /**
   * Sets the text content of the blockquote.
   *
   * @param text The text content to be displayed in the blockquote.
   * @return The current `Blockquote` instance.
   */
  public Blockquote setText(String text) {
    paragraph.setTextContent(text);
    return this;
  }

  /**
   * Adds a footer element to the blockquote.
   *
   * @return The current `Blockquote` instance with a footer element.
   */
  public Blockquote withFooter() {
    footer.get();
    return this;
  }

  /**
   * Adds a footer element to the blockquote and provides a handler to configure the footer.
   *
   * @param handler The handler for configuring the footer element.
   * @return The current `Blockquote` instance with a configured footer element.
   */
  public Blockquote withFooter(ChildHandler<Blockquote, FooterElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * Appends a footer content element to the blockquote.
   *
   * @param footerContent The footer content element to be appended.
   * @return The current `Blockquote` instance with the appended footer content.
   */
  public Blockquote appendChild(FooterContent<?> footerContent) {
    footer.get().appendChild(footerContent);
    return this;
  }

  /**
   * Gets the footer element of the blockquote.
   *
   * @return The footer element of the blockquote.
   */
  public FooterElement getFooter() {
    return this.footer.get();
  }

  /**
   * Configures the blockquote with a paragraph element and provides a handler to configure the
   * paragraph content.
   *
   * @param handler The handler for configuring the paragraph content.
   * @return The current `Blockquote` instance with the configured paragraph content.
   */
  public Blockquote withParagraph(ChildHandler<Blockquote, ParagraphElement> handler) {
    handler.apply(this, paragraph);
    return this;
  }

  /**
   * Gets the paragraph element of the blockquote.
   *
   * @return The paragraph element of the blockquote.
   */
  public ParagraphElement getParagraph() {
    return paragraph;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
