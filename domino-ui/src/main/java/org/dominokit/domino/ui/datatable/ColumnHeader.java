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

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.THElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * ColumnHeader class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ColumnHeader extends BaseDominoElement<HTMLTableCellElement, ColumnHeader>
    implements DataTableStyles {

  private final THElement element;
  private final DivElement body;
  private SpanElement titleEelement;

  /**
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public static ColumnHeader create(String title) {
    return new ColumnHeader(title);
  }

  /**
   * create.
   *
   * @param title a {@link elemental2.dom.Node} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public static ColumnHeader create(Node title) {
    return new ColumnHeader(title);
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public static ColumnHeader create() {
    return new ColumnHeader();
  }

  /** Constructor for ColumnHeader. */
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
   * Constructor for ColumnHeader.
   *
   * @param title a {@link java.lang.String} object
   */
  public ColumnHeader(String title) {
    this();
    if (nonNull(title) && !title.isEmpty()) {
      setTitle(title);
    }
  }

  /**
   * Constructor for ColumnHeader.
   *
   * @param title a {@link elemental2.dom.Node} object
   */
  public ColumnHeader(Node title) {
    this();
    if (nonNull(title)) {
      setTitle(title);
    }
  }

  /**
   * setTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public ColumnHeader setTitle(String title) {
    return setTitle(text(title));
  }

  /**
   * setTitle.
   *
   * @param title a {@link elemental2.dom.Node} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public ColumnHeader setTitle(Node title) {
    this.titleEelement.clearElement().appendChild(title);
    return this;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public ColumnHeader withBody(ChildHandler<ColumnHeader, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   */
  public ColumnHeader withTitle(ChildHandler<ColumnHeader, SpanElement> handler) {
    handler.apply(this, titleEelement);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return body.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLTableCellElement element() {
    return element.element();
  }
}
