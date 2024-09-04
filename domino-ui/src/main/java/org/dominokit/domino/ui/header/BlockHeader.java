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
package org.dominokit.domino.ui.header;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

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
@Deprecated
public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader> {

  private final HTMLDivElement element =
      DominoElement.of(div()).css(BlockHeaderStyles.BLOCK_HEADER).element();
  private final HTMLHeadingElement headerElement = DominoElement.of(h(2)).element();
  private HTMLElement descriptionElement;
  private final Text headerText = TextNode.empty();
  private final Text descriptionText = TextNode.empty();

  private BlockHeader(String header) {
    this(header, null);
  }

  private BlockHeader(String header, String description) {
    headerText.textContent = header;
    headerElement.appendChild(headerText);
    element.appendChild(headerElement);

    if (nonNull(description)) {
      createDescriptionElement(description);
    }
    init(this);
  }

  private void createDescriptionElement(String description) {
    descriptionText.textContent = description;
    descriptionElement = small().add(descriptionText).element();
    headerElement.appendChild(descriptionElement);
  }

  /**
   * Creates a header with a description
   *
   * @param header the header text
   * @param description the description text
   * @return new instance
   */
  public static BlockHeader create(String header, String description) {
    return new BlockHeader(header, description);
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

  /** {@inheritDoc} */
  @Override
  public BlockHeader appendChild(Node content) {
    if (isNull(descriptionElement)) createDescriptionElement("");
    descriptionElement.appendChild(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public BlockHeader appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /**
   * Change the positions of the header and description elements by setting the header under the
   * description
   *
   * @return same instance
   */
  public BlockHeader invert() {
    if (nonNull(descriptionElement)) {
      descriptionElement.remove();
      element.insertBefore(descriptionElement, headerElement);
    }

    return this;
  }

  /**
   * Adds text as a child to this component
   *
   * @param text the text
   * @return same instance
   */
  public BlockHeader appendText(String text) {
    return appendChild(DomGlobal.document.createTextNode(text));
  }

  /**
   * Sets the header text
   *
   * @param header the new text
   * @return same instance
   */
  public BlockHeader setHeader(String header) {
    headerText.textContent = header;
    return this;
  }

  /** @return The header element */
  public DominoElement<HTMLHeadingElement> getHeaderElement() {
    return DominoElement.of(headerElement);
  }

  /** @return The description element */
  public DominoElement<HTMLElement> getDescriptionElement() {
    return DominoElement.of(descriptionElement);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }
}
