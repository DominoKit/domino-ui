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
package org.dominokit.domino.ui.badges;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;

/**
 * Displays small label with color.
 *
 * <p>This component provides a small label that has background color and a text. Customize the
 * component can be done by overwriting classes provided by {@link BadgeStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Badge.create("label")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 */
@Deprecated
public class Badge extends BaseDominoElement<HTMLElement, Badge> implements HasBackground<Badge> {

  private final DominoElement<HTMLElement> badgeElement =
      DominoElement.of(span()).css(BadgeStyles.BADGE).elevate(Elevation.LEVEL_1);
  private final Text textNode = TextNode.empty();
  private Color badgeBackground;

  public Badge() {
    init(this);
    appendChild(textNode);
  }

  /**
   * Creates badge with {@code content}
   *
   * @param content the text to be added to the badge
   * @return new badge instance
   */
  public static Badge create(String content) {
    Badge badge = new Badge();
    badge.setText(content);
    return badge;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return badgeElement.element();
  }

  /**
   * Sets the text content of the badge
   *
   * @param text the new content
   * @return same instance
   */
  public Badge setText(String text) {
    textNode.textContent = text;
    return this;
  }

  /**
   * Position the element to the right of its parent
   *
   * @return same instance
   */
  public Badge pullRight() {
    style().pullRight();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Badge setBackground(Color badgeBackground) {
    if (nonNull(badgeBackground)) {
      if (nonNull(this.badgeBackground)) {
        badgeElement.removeCss(this.badgeBackground.getBackground());
      }

      this.badgeBackground = badgeBackground;
      badgeElement.addCss(this.badgeBackground.getBackground());
    }
    return this;
  }
}
