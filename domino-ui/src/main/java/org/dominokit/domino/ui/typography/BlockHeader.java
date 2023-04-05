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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component provides a header text with a description in a predefined style
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * BlockHeaderStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     BlockHeader.create("Header", "Description");
 * </pre>
 *
 * @see BaseDominoElement
 */
public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader>
    implements BlockHeaderStyles {

  private final DivElement element;
  private final HeadingElement headerElement;
  private LazyChild<SmallElement> descriptionElement;

  private BlockHeader(String title) {
    element =
        div()
            .addCss(dui_block_header)
            .appendChild(
                headerElement =
                    h(2).addCss(dui_block_header_title).textContent(title));
    descriptionElement =
        LazyChild.of(small().addCss(dui_block_header_description), element);
    init(this);
  }

  private BlockHeader(String title, String description) {
    this(title);
    setDescription(description);
  }

  public BlockHeader setDescription(String description) {
    descriptionElement.get().setTextContent(description);
    return this;
  }

  /**
   * Creates a header with a description
   *
   * @param title the header text
   * @param description the description text
   * @return new instance
   */
  public static BlockHeader create(String title, String description) {
    return new BlockHeader(title, description);
  }

  /**
   * Creates a header
   *
   * @param header the header text
   * @return new instance
   */
  public static BlockHeader create(String header) {
    return new BlockHeader(header);
  }

  public BlockHeader setReversed(boolean reversed) {
    addCss(BooleanCssClass.of(dui_block_header_reversed, reversed));
    return this;
  }

  /**
   * Sets the header text
   *
   * @param header the new text
   * @return same instance
   */
  public BlockHeader setHeader(String header) {
    headerElement.setTextContent(header);
    return this;
  }

  /**
   * @return The header element
   */
  public HeadingElement getHeaderElement() {
    return headerElement;
  }

  public BlockHeader withHeaderElement(
      ChildHandler<BlockHeader, HeadingElement> handler) {
    handler.apply(this, headerElement);
    return this;
  }

  /**
   * @return The description element
   */
  public SmallElement getDescriptionElement() {
    return descriptionElement.get();
  }

  /** @return The description element */
  public BlockHeader withDescriptionElement() {
    descriptionElement.get();
    return this;
  }

  /** @return The description element */
  public BlockHeader withDescriptionElement(
      ChildHandler<BlockHeader, SmallElement> handler) {
    handler.apply(this, descriptionElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
