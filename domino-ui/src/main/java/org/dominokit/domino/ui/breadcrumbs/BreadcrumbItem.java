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
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasClickableElement;

/**
 * A component for {@link org.dominokit.domino.ui.breadcrumbs.Breadcrumb} location.
 *
 * <p>This component provides basic styles of a location and functionalities that allows switching
 * between location statuses
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * BreadcrumbStyles}
 *
 * @see Breadcrumb
 * @see BaseDominoElement
 * @see HasClickableElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class BreadcrumbItem extends BaseDominoElement<HTMLLIElement, BreadcrumbItem>
    implements HasClickableElement {

  private final LIElement element;
  private final AnchorElement anchorElement;
  private Text textElement;
  private Icon<?> icon;

  /**
   * Constructor for BreadcrumbItem.
   *
   * @param text a {@link java.lang.String} object
   */
  protected BreadcrumbItem(String text) {
    element = li();
    init(this);
    anchorElement = a().removeHref();
    this.textElement = text(text);
    this.anchorElement.appendChild(textElement);
    element.appendChild(anchorElement);
  }

  /**
   * Constructor for BreadcrumbItem.
   *
   * @param text a {@link java.lang.String} object
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  protected BreadcrumbItem(String text, Icon<?> icon) {
    this(text);
    this.icon = icon;
    this.anchorElement.insertFirst(icon);
  }

  /**
   * Creates location with text content
   *
   * @param text the content of the item
   * @return new instance
   */
  public static BreadcrumbItem create(String text) {
    return new BreadcrumbItem(text);
  }

  /**
   * Creates item with text content and icon
   *
   * @param icon the {@link org.dominokit.domino.ui.icons.Icon} of the item
   * @param text the content of the item
   * @return new instance
   */
  public static BreadcrumbItem create(Icon<?> icon, String text) {
    return new BreadcrumbItem(text, icon);
  }

  /**
   * Sets item as active, customizing the active style can be done by overwriting {@link
   * GenericCss#dui_active} CSS class
   *
   * @return same instance
   */
  BreadcrumbItem activate() {
    element.addCss(dui_active);
    return this;
  }

  /**
   * Sets item as inactive
   *
   * @return same instance
   */
  BreadcrumbItem deActivate() {
    element.removeCss(dui_active);
    return this;
  }

  /**
   * If true, sets the status to active, otherwise sets the status to inactive
   *
   * @param active the boolean to set the status
   * @return same instance
   * @deprecated This method should be no longer used directly. Use {@link
   *     Breadcrumb#setActiveItem(BreadcrumbItem)} instead
   */
  @Deprecated
  public BreadcrumbItem setActive(boolean active) {
    addCss(BooleanCssClass.of(dui_active, active));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /** @return the {@link Text} content */
  /**
   * Getter for the field <code>textElement</code>.
   *
   * @return a {@link elemental2.dom.Text} object
   */
  public Text getTextElement() {
    return textElement;
  }

  /** @return the {@link Icon} */
  /**
   * Getter for the field <code>icon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getIcon() {
    return icon;
  }

  /** @return true if the item is active, false otherwise */
  /**
   * isActive.
   *
   * @return a boolean
   */
  public boolean isActive() {
    return dui_active.isAppliedTo(this);
  }

  public BreadcrumbItem withAnchor(ChildHandler<BreadcrumbItem, AnchorElement> handler) {
    handler.apply(this, anchorElement);
    return this;
  }
}
