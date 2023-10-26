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
 * Displays a label that fits within other components and elements.
 *
 * <p>The component will auto-fit within other elements and will float to the right by default, and
 * will show at the top right if appended to icons.
 *
 * <p>Example:
 *
 * <pre>
 *     Badge.create("label")
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Badge extends BaseDominoElement<HTMLElement, Badge> {
  private final Text textNode = ElementsFactory.elements.text();
  private final SpanElement element;
  private final LazyChild<RemoveButton> removeButton;

  /**
   * factory method to create a badge with a text {@code content}
   *
   * @param content the text to be added to the badge
   * @return new badge instance
   */
  public static Badge create(String content) {
    Badge badge = new Badge();
    badge.setText(content);
    return badge;
  }

  /** Creates an empty badge instance. */
  public Badge() {
    element = span().addCss(dui_badge);
    removeButton = LazyChild.of(RemoveButton.create().addClickListener(evt -> remove()), element);
    init(this);
    appendChild(textNode);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /**
   * Sets the badge as removable or not, removable badges will have a close button, clicking the
   * close button will remove the badge from the dom.
   *
   * @param removable <b>true</b> to set it as removable and show the close button, <b>false</b> the
   *     badge is not removable and close button will be removed.
   * @return Same badge instance
   */
  public Badge setRemovable(boolean removable) {
    if (removable) {
      return removable();
    } else {
      return unRemovable();
    }
  }

  /**
   * Shortcut method for <b>setRemovable(true)</b> Sets the alert to closable and a close button
   * will be added.
   *
   * @return Same badge instance
   */
  public Badge removable() {
    removeButton.get();
    return this;
  }

  /**
   * Sets the alert to not closable and the close button will be removed if exists, the alert can be
   * removed programmatically using {@link org.dominokit.domino.ui.alerts.Alert#remove()}
   *
   * @return Same badge instance
   */
  public Badge unRemovable() {
    removeButton.remove();
    return this;
  }

  /**
   * Use to check if the badge is removable or not
   *
   * @return a boolean, <b>true</b> if removable and <b>false</b> otherwise.
   */
  public boolean isRemovable() {
    return removeButton.isInitialized();
  }

  /**
   * Use to get a reference to the close button, calling this will assume the badge should be
   * removable and will add the remove button to the badge
   *
   * @return the close button element
   */
  public RemoveButton getCloseButton() {
    return removeButton.get();
  }

  /**
   * Use to customize the close button without breaking the fluent API chain. using this method will
   * produce the same behavior as the <b>getCloseButton</b> method, it will add the remove button to
   * the badge
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} to applied on the remove
   *     button
   * @return same badge instance
   */
  public Badge withCloseButton(ChildHandler<Badge, RemoveButton> handler) {
    handler.apply(this, removeButton.get());
    return this;
  }

  /**
   * Adds the remove button to the badge.
   *
   * @return same badge instance
   */
  public Badge withCloseButton() {
    removeButton.get();
    return this;
  }

  /**
   * Sets the html textContent of the badge element.
   *
   * @param text the new content
   * @return same badge instance
   */
  public Badge setText(String text) {
    textNode.textContent = text;
    return this;
  }
}
