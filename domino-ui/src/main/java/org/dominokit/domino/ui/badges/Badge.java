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

import static org.dominokit.domino.ui.badges.BadgeStyles.dui_badge;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.*;

/**
 * Displays small label with color.
 *
 * <p>This component provides a small label that has background color and a text. Customize the
 * component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.badges.BadgeStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Badge.create("label")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @author vegegoku
 * @version $Id: $Id
 */
public class Badge extends BaseDominoElement<HTMLElement, Badge> {
  private final Text textNode = ElementsFactory.elements.text();

  private boolean removable = false;
  private final SpanElement element;
  private LazyChild<RemoveButton> removeButton;

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

  /** Constructor for Badge. */
  public Badge() {
    element = span().addCss(dui_badge);
    removeButton = LazyChild.of(RemoveButton.create().addClickListener(evt -> remove()), element);
    init(this);
    appendChild(textNode);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /**
   * Passing true means that the alert will be closable and a close button will be added to the
   * element to hide it
   *
   * @param removable true to set it as closable, false otherwise
   * @return same instance
   */
  public Badge setRemovable(boolean removable) {
    if (removable) {
      return removable();
    } else {
      return unRemovable();
    }
  }

  /**
   * Sets the alert to closable and a close button will be added to the element to hide it
   *
   * @return same instance
   */
  public Badge removable() {
    removable = true;
    removeButton.get();
    return this;
  }

  /**
   * Sets the alert to not closable and the close button will be removed if exist, the alert can be
   * hidden programmatically using {@link org.dominokit.domino.ui.alerts.Alert#remove()}
   *
   * @return same instance
   */
  public Badge unRemovable() {
    removable = false;
    removeButton.remove();
    return this;
  }

  /** @return true if the alert is closable, false otherwise */
  /**
   * isRemovable.
   *
   * @return a boolean
   */
  public boolean isRemovable() {
    return removable;
  }

  /**
   * Returns the close button for customization
   *
   * @return the close button element
   */
  public RemoveButton getCloseButton() {
    return removeButton.get();
  }

  /**
   * withCloseButton.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.badges.Badge} object
   */
  public Badge withCloseButton(ChildHandler<Badge, RemoveButton> handler) {
    handler.apply(this, removeButton.get());
    return this;
  }

  /**
   * withCloseButton.
   *
   * @return a {@link org.dominokit.domino.ui.badges.Badge} object
   */
  public Badge withCloseButton() {
    removeButton.get();
    return this;
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
}
