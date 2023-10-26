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
package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasClickableElement;

/**
 * A component used within {@link Breadcrumb} and represent a navigation path taken to reach a
 * specific page and view.
 *
 * <p>Clicking a BreadcrumbItem would trigger change listeners defined on the Breadcrumb, the
 * library user can use them to navigate the user to different views or pages.
 *
 * @see BaseDominoElement
 */
public class BreadcrumbItem extends BaseDominoElement<HTMLLIElement, BreadcrumbItem>
    implements HasClickableElement {

  private final LIElement element;
  private final AnchorElement anchorElement;
  private Text textElement;
  private Icon<?> icon;

  /**
   * Creates a BreadcrumbItem with a text
   *
   * @param text The label text for the BreadcrumbItem
   */
  public BreadcrumbItem(String text) {
    element = li();
    init(this);
    anchorElement = a().removeHref();
    this.textElement = text(text);
    this.anchorElement.appendChild(textElement);
    element.appendChild(anchorElement);
  }

  /**
   * Creates a BreadcrumbItem with a text and icon
   *
   * @param text The label text for the BreadcrumbItem
   * @param icon An {@link org.dominokit.domino.ui.icons.Icon} that prefix the BreadcrumbItem labels
   */
  public BreadcrumbItem(String text, Icon<?> icon) {
    this(text);
    this.icon = icon;
    this.anchorElement.insertFirst(icon);
  }

  /**
   * Creates a BreadcrumbItem with a text and icon
   *
   * @param icon An {@link org.dominokit.domino.ui.icons.Icon} that prefix the BreadcrumbItem labels
   * @param text The label text for the BreadcrumbItem
   */
  public BreadcrumbItem(Icon<?> icon, String text) {
    this(text);
    this.icon = icon;
    this.anchorElement.insertFirst(icon);
  }

  /**
   * Factory method to create a BreadcrumbItem with a text
   *
   * @param text The label text for the BreadcrumbItem
   * @return new BreadcrumbItem instance
   */
  public static BreadcrumbItem create(String text) {
    return new BreadcrumbItem(text);
  }

  /**
   * Factory method to create a BreadcrumbItem with a text and icon
   *
   * @param icon An {@link org.dominokit.domino.ui.icons.Icon} that prefix the BreadcrumbItem labels
   * @param text The label text for the BreadcrumbItem
   * @return new BreadcrumbItem instance
   */
  public static BreadcrumbItem create(Icon<?> icon, String text) {
    return new BreadcrumbItem(text, icon);
  }

  /**
   * Apply the active style to this BreadcrumbItem instance
   *
   * @return same instance
   */
  BreadcrumbItem activate() {
    element.addCss(dui_active);
    return this;
  }

  /**
   * Remove the active style from this BreadcrumbItem instance
   *
   * @return same instance
   */
  BreadcrumbItem deActivate() {
    element.removeCss(dui_active);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /**
   * @return the element instance within this component that would receive the clicks when we
   *     register a click event listener directly to the BreadcrumbItem
   */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /** @return a {@link elemental2.dom.Text} node for this BreadcrumbItem label text */
  public Text getTextElement() {
    return textElement;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.icons.Icon} of this BreadcrumbItem instance if
   *     present or null.
   */
  public Icon<?> getIcon() {
    return icon;
  }

  /** @return <b>true</b> if the item is active, <b>false</b> otherwise. */
  public boolean isActive() {
    return dui_active.isAppliedTo(this);
  }

  /**
   * Use to customize the AnchorElement of this BreadcrumbItem instance without breaking the fluent
   * API chain.
   *
   * @param handler A {@link ChildHandler} that will apply the desired customization, holds a
   *     reference to both the BreadcrumbItem and the AnchorElement
   * @return same BreadcrumbItem instance
   */
  public BreadcrumbItem withAnchor(ChildHandler<BreadcrumbItem, AnchorElement> handler) {
    handler.apply(this, anchorElement);
    return this;
  }
}
