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
package org.dominokit.domino.ui.datatable;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.THElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Represents the header of a column in a data table. This component allows for customization of the
 * header's title and body content.
 *
 * @see BaseDominoElement
 */
public class ColumnHeader extends BaseDominoElement<HTMLTableCellElement, ColumnHeader>
    implements DataTableStyles {

  private final THElement element;
  private final DivElement body;
  private SpanElement titleEelement;

  /**
   * Creates a {@link ColumnHeader} with a string title.
   *
   * @param title The text title for the header.
   * @return The created {@link ColumnHeader} instance.
   */
  public static ColumnHeader create(String title) {
    return new ColumnHeader(title);
  }

  /**
   * Creates a {@link ColumnHeader} with a node title.
   *
   * @param title The node representation for the title.
   * @return The created {@link ColumnHeader} instance.
   */
  public static ColumnHeader create(Node title) {
    return new ColumnHeader(title);
  }

  /**
   * Creates an empty {@link ColumnHeader}.
   *
   * @return The created empty {@link ColumnHeader} instance.
   */
  public static ColumnHeader create() {
    return new ColumnHeader();
  }

  /** Default constructor initializing the header's DOM structure. */
  public ColumnHeader() {
    this.element =
        th().addCss(dui_datatable_th)
            .appendChild(
                body =
                    div()
                        .addCss(dui_datatable_th_body)
                        .appendChild(titleEelement = span().addCss(dui_datatable_th_title)));
    init(this);
  }

  /**
   * Constructor initializing the header with a string title.
   *
   * @param title The text title for the header.
   */
  public ColumnHeader(String title) {
    this();
    if (nonNull(title) && !title.isEmpty()) {
      setTitle(title);
    }
  }

  /**
   * Constructor initializing the header with a node title.
   *
   * @param title The node representation for the title.
   */
  public ColumnHeader(Node title) {
    this();
    if (nonNull(title)) {
      setTitle(title);
    }
  }

  /**
   * Sets the title of the column header using a string.
   *
   * @param title The text title to set.
   * @return The current {@link ColumnHeader} instance.
   */
  public ColumnHeader setTitle(String title) {
    return setTitle(text(title));
  }

  /**
   * Sets the title of the column header using a node.
   *
   * @param title The node representation of the title to set.
   * @return The current {@link ColumnHeader} instance.
   */
  public ColumnHeader setTitle(Node title) {
    this.titleEelement.clearElement().appendChild(title);
    return this;
  }

  /**
   * Provides a way to customize the body of the header.
   *
   * @param handler A handler for the body customization.
   * @return The current {@link ColumnHeader} instance.
   */
  public ColumnHeader withBody(ChildHandler<ColumnHeader, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Provides a way to customize the title of the header.
   *
   * @param handler A handler for the title customization.
   * @return The current {@link ColumnHeader} instance.
   */
  public ColumnHeader withTitle(ChildHandler<ColumnHeader, SpanElement> handler) {
    handler.apply(this, titleEelement);
    return this;
  }

  /**
   * Retrieves the DOM element to which child components are appended.
   *
   * @return The DOM element target.
   */
  @Override
  public Element getAppendTarget() {
    return body.element();
  }

  /**
   * Retrieves the primary DOM element representing the column header.
   *
   * @return The {@link HTMLTableCellElement} representation of the header.
   */
  @Override
  public HTMLTableCellElement element() {
    return element.element();
  }
}
