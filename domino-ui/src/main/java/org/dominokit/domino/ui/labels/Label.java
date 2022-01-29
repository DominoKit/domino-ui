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
package org.dominokit.domino.ui.labels;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;

/**
 * A component for showing headings in different sizes and colors
 *
 * <p>For example:
 *
 * <pre>
 *     Label.createDefault("DEFAULT");
 *     Label.createPrimary("PRIMARY");
 *     Label.createSuccess("SUCCESS")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @see HasContent
 */
public class Label extends BaseDominoElement<HTMLElement, Label>
    implements HasContent<Label>, HasBackground<Label> {

  private final DominoElement<HTMLElement> span = DominoElement.of(span()).css("label");
  private Color background;

  private Label(String content) {
    setContent(content);
    init(this);
  }

  private Label(String content, StyleType type) {
    this(content);
    setType(type);
  }

  private void setType(StyleType type) {
    span.addCss("label-" + type.getStyle());
  }

  /**
   * Creates with content and no type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label create(String content) {
    return new Label(content);
  }

  /**
   * Creates with content and a type
   *
   * @param content the text content
   * @param type the {@link StyleType}
   * @return new instance
   */
  public static Label create(String content, StyleType type) {
    return new Label(content, type);
  }

  /**
   * Creates with content and {@link StyleType#DEFAULT} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createDefault(String content) {
    return create(content, StyleType.DEFAULT);
  }

  /**
   * Creates with content and {@link StyleType#PRIMARY} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createPrimary(String content) {
    return create(content, StyleType.PRIMARY);
  }

  /**
   * Creates with content and {@link StyleType#SUCCESS} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createSuccess(String content) {
    return create(content, StyleType.SUCCESS);
  }

  /**
   * Creates with content and {@link StyleType#INFO} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createInfo(String content) {
    return create(content, StyleType.INFO);
  }

  /**
   * Creates with content and {@link StyleType#WARNING} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createWarning(String content) {
    return create(content, StyleType.WARNING);
  }

  /**
   * Creates with content and {@link StyleType#DANGER} type
   *
   * @param content the text content
   * @return new instance
   */
  public static Label createDanger(String content) {
    return create(content, StyleType.DANGER);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return span.element();
  }

  /** {@inheritDoc} */
  @Override
  public Label setContent(String content) {
    span.setTextContent(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Label setBackground(Color background) {
    if (nonNull(this.background)) span.removeCss(this.background.getBackground());
    span.addCss(background.getBackground());
    this.background = background;
    return this;
  }
}
