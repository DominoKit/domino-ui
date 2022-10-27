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
package org.dominokit.domino.ui.Typography;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.p;

import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** A wrapper component for <strong>p</strong> HTML tag */
public class Paragraph extends BaseDominoElement<HTMLParagraphElement, Paragraph> {

  private final DominoElement<HTMLParagraphElement> element = DominoElement.of(p());
  private Color colorStyle;
  private String alignment = align_left;

  public Paragraph() {
    this(null);
  }

  public Paragraph(String text) {
    if (nonNull(text)) {
      setText(text);
    }
    init(this);
  }

  /** @return new instance with empty text */
  public static Paragraph create() {
    return new Paragraph();
  }

  /**
   * @param text the value of the paragraph
   * @return new instance with empty text
   */
  public static Paragraph create(String text) {
    return new Paragraph(text);
  }

  /**
   * Sets the value of the paragraph
   *
   * @param text the value of the paragraph
   * @return same instnace
   */
  public Paragraph setText(String text) {
    element.setTextContent(text);
    return this;
  }

  /**
   * Sets the paragraph to have larger fonts on big screens.
   *
   * @return same instance
   */
  public Paragraph lead() {
    element.addCss(GenericCss.lead);
    return this;
  }

  /**
   * Sets the font color
   *
   * @param color the {@link Color}
   * @return same instance
   */
  public Paragraph setColor(Color color) {
    if (nonNull(colorStyle)) element.removeCss(color.getStyle());

    this.colorStyle = color;
    element.addCss(colorStyle.getStyle());
    return this;
  }

  /** @deprecated use {@link #appendChild(Node)} */
  @Deprecated
  public Paragraph appendContent(Node content) {
    element.appendChild(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLParagraphElement element() {
    return element.element();
  }

  /**
   * Sets the font to bold
   *
   * @return same instance
   */
  public Paragraph bold() {
    element.removeCss(GenericCss.font_bold);
    element.addCss(GenericCss.font_bold);
    return this;
  }

  /**
   * Sets the font to italic
   *
   * @return same instance
   */
  public Paragraph italic() {
    element.removeCss(GenericCss.font_italic);
    element.addCss(GenericCss.font_italic);
    return this;
  }

  /**
   * Sets the font to underline
   *
   * @return same instance
   */
  public Paragraph underLine() {
    element.removeCss(GenericCss.font_under_line);
    element.addCss(GenericCss.font_under_line);
    return this;
  }

  /**
   * Sets the font to overline
   *
   * @return same instance
   */
  public Paragraph overLine() {
    element.removeCss(GenericCss.font_over_line);
    element.addCss(GenericCss.font_over_line);
    return this;
  }

  /**
   * Sets the font to line through
   *
   * @return same instance
   */
  public Paragraph lineThrough() {
    element.removeCss(GenericCss.font_line_through);
    element.addCss(GenericCss.font_line_through);
    return this;
  }

  /**
   * Aligns the text to the left
   *
   * @return same instance
   */
  public Paragraph alignLeft() {
    return align(GenericCss.align_left);
  }

  /**
   * Aligns the text to the right
   *
   * @return same instance
   */
  public Paragraph alignRight() {
    return align(GenericCss.align_right);
  }

  /**
   * Aligns the text to the center
   *
   * @return same instance
   */
  public Paragraph alignCenter() {
    return align(GenericCss.align_center);
  }

  /**
   * Aligns the text to justify
   *
   * @return same instance
   */
  public Paragraph alignJustify() {
    return align(GenericCss.align_justify);
  }

  private Paragraph align(String alignment) {
    element.removeCss(this.alignment);
    element.addCss(alignment);
    this.alignment = alignment;
    return this;
  }
}
