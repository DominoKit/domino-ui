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
package org.dominokit.domino.ui.infoboxes;

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * The InfoBlock class represents a customizable information block in Domino UI. This class extends
 * BaseDominoElement and provides a flexible way to create a block with optional header, body, and
 * footer sections.
 */
public class InfoBlock extends BaseDominoElement<HTMLDivElement, InfoBlock>
    implements InfoBlockStyles {

  private final DivElement root;
  private final LazyChild<NavBar> header;
  private final LazyChild<NavBar> footer;
  private final DivElement body;

  /**
   * Creates a new instance of InfoBlock.
   *
   * @return a new InfoBlock instance.
   */
  public static InfoBlock create() {
    return new InfoBlock();
  }

  /**
   * Constructor for InfoBlock. Initializes the root, header, footer, and body elements with default
   * styles.
   */
  public InfoBlock() {
    this.root = div().addCss(dui_info_block).appendChild(body = div().addCss(dui_info_block_body));

    header = LazyChild.of(NavBar.create().addCss(dui_info_block_header), this.root);
    footer = LazyChild.of(NavBar.create().addCss(dui_info_block_footer), this.root);

    init(this);
  }

  /**
   * Returns the element to which child elements will be appended.
   *
   * @return the body element of the InfoBlock.
   */
  @Override
  public Element getAppendTarget() {
    return this.body.element();
  }

  /**
   * Retrieves the header component of the InfoBlock.
   *
   * @return the NavBar instance used as the header.
   */
  public NavBar getHeader() {
    return header.get();
  }

  /**
   * Retrieves the footer component of the InfoBlock.
   *
   * @return the NavBar instance used as the footer.
   */
  public NavBar getFooter() {
    return footer.get();
  }

  /**
   * Retrieves the body component of the InfoBlock.
   *
   * @return the DivElement used as the body.
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * Ensures the header is initialized and returns the current instance for chaining.
   *
   * @return the current InfoBlock instance.
   */
  public InfoBlock withHeader() {
    this.header.get();
    return this;
  }

  /**
   * Applies a custom handler to the header and returns the current instance for chaining.
   *
   * @param handler the handler to customize the header.
   * @return the current InfoBlock instance.
   */
  public InfoBlock withHeader(ChildHandler<InfoBlock, NavBar> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * Applies a custom handler to the body and returns the current instance for chaining.
   *
   * @param handler the handler to customize the body.
   * @return the current InfoBlock instance.
   */
  public InfoBlock withBody(ChildHandler<InfoBlock, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Ensures the footer is initialized and returns the current instance for chaining.
   *
   * @return the current InfoBlock instance.
   */
  public InfoBlock withFooter() {
    this.footer.get();
    return this;
  }

  /**
   * Applies a custom handler to the footer and returns the current instance for chaining.
   *
   * @param handler the handler to customize the footer.
   * @return the current InfoBlock instance.
   */
  public InfoBlock withFooter(ChildHandler<InfoBlock, NavBar> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * Returns the root HTMLDivElement of the InfoBlock.
   *
   * @return the root HTMLDivElement.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
