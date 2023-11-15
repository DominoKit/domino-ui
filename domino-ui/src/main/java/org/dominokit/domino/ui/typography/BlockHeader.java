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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * The `BlockHeader` class represents a block header element with an optional description. It is
 * used to display a title and an optional description in a block-style header.
 *
 * @see BaseDominoElement
 */
public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader>
    implements BlockHeaderStyles {

  private final DivElement element;
  private final HeadingElement headerElement;
  private LazyChild<SmallElement> descriptionElement;

  /**
   * Constructs a new `BlockHeader` instance with the specified title.
   *
   * @param title The title to be displayed in the block header.
   */
  private BlockHeader(String title) {
    element =
        div()
            .addCss(dui_block_header)
            .appendChild(headerElement = h(2).addCss(dui_block_header_title).textContent(title));
    descriptionElement = LazyChild.of(small().addCss(dui_block_header_description), element);
    init(this);
  }

  /**
   * Constructs a new `BlockHeader` instance with the specified title and description.
   *
   * @param title The title to be displayed in the block header.
   * @param description The description to be displayed in the block header.
   */
  private BlockHeader(String title, String description) {
    this(title);
    setDescription(description);
  }

  /**
   * Creates a new `BlockHeader` instance with the specified title and description.
   *
   * @param title The title to be displayed in the block header.
   * @param description The description to be displayed in the block header.
   * @return A new `BlockHeader` instance with the specified title and description.
   */
  public static BlockHeader create(String title, String description) {
    return new BlockHeader(title, description);
  }

  /**
   * Creates a new `BlockHeader` instance with the specified title.
   *
   * @param header The title to be displayed in the block header.
   * @return A new `BlockHeader` instance with the specified title.
   */
  public static BlockHeader create(String header) {
    return new BlockHeader(header);
  }

  /**
   * Sets the description for the block header.
   *
   * @param description The description to be displayed in the block header.
   * @return The current `BlockHeader` instance.
   */
  public BlockHeader setDescription(String description) {
    descriptionElement.get().setTextContent(description);
    return this;
  }

  /**
   * Sets whether the block header is reversed.
   *
   * @param reversed True to reverse the block header, false otherwise.
   * @return The current `BlockHeader` instance.
   */
  public BlockHeader setReversed(boolean reversed) {
    addCss(BooleanCssClass.of(dui_block_header_reversed, reversed));
    return this;
  }

  /**
   * Sets the title of the block header.
   *
   * @param header The title to be displayed in the block header.
   * @return The current `BlockHeader` instance.
   */
  public BlockHeader setHeader(String header) {
    headerElement.setTextContent(header);
    return this;
  }

  /**
   * Gets the header element of the block header.
   *
   * @return The header element of the block header.
   */
  public HeadingElement getHeaderElement() {
    return headerElement;
  }

  /**
   * Configures the block header with a header element and provides a handler to configure it.
   *
   * @param handler The handler for configuring the header element.
   * @return The current `BlockHeader` instance with the configured header element.
   */
  public BlockHeader withHeaderElement(ChildHandler<BlockHeader, HeadingElement> handler) {
    handler.apply(this, headerElement);
    return this;
  }

  /**
   * Gets the description element of the block header.
   *
   * @return The description element of the block header.
   */
  public SmallElement getDescriptionElement() {
    return descriptionElement.get();
  }

  /**
   * Configures the block header with a description element.
   *
   * @return The current `BlockHeader` instance with the description element.
   */
  public BlockHeader withDescriptionElement() {
    descriptionElement.get();
    return this;
  }

  /**
   * Configures the block header with a description element and provides a handler to configure it.
   *
   * @param handler The handler for configuring the description element.
   * @return The current `BlockHeader` instance with the configured description element.
   */
  public BlockHeader withDescriptionElement(ChildHandler<BlockHeader, SmallElement> handler) {
    handler.apply(this, descriptionElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
