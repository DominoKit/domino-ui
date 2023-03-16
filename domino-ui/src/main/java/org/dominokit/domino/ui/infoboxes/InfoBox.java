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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

/**
 * Container for displaying information with icons
 *
 * <p>This component provides a container which allows showing information with icons and effects
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link InfoBoxStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "125");
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 */
public class InfoBox extends BaseDominoElement<HTMLDivElement, InfoBox> implements InfoBoxStyles {

  private final DominoElement<HTMLDivElement> root;
  private final LazyChild<DominoElement<HTMLDivElement>> contentElement;
  private final LazyChild<DominoElement<HTMLDivElement>> titleElement;
  private final LazyChild<DominoElement<HTMLDivElement>> valueElement;

  private LazyChild<DominoElement<HTMLDivElement>> iconContainer;

  private SwapCssClass hoverEffect = SwapCssClass.of(HoverEffect.ZOOM.effectStyle);

  public InfoBox() {
    root = div().addCss(dui_info_box, hoverEffect);
    iconContainer = LazyChild.of(div().addCss(dui_info_icon), root);
    contentElement = LazyChild.of(div().addCss(dui_info_content), root);
    titleElement = LazyChild.of(div().addCss(dui_info_title), contentElement);
    valueElement = LazyChild.of(div().addCss(dui_info_value), contentElement);
    init(this);
  }

  public InfoBox(IsElement<HTMLElement> icon) {
    this();
    setIcon(icon);
  }

  public InfoBox(IsElement<HTMLElement> icon, String title) {
    this(icon);
    setTitle(title);
  }

  public InfoBox(IsElement<HTMLElement> icon, String title, String value) {
    this(icon, title);
    setValue(value);
  }

  /**
   * Creates info box with icon, title and value
   *
   * @param icon The {@link BaseIcon}
   * @param title the title
   * @param value the value
   * @return new instance
   */
  public static InfoBox create(BaseIcon<?> icon, String title, String value) {
    return new InfoBox(icon, title, value);
  }

  /**
   * Creates info box with icon, title and value
   *
   * @param icon The {@link BaseIcon}
   * @param title the title
   * @param value the value
   * @return new instance
   */
  public static InfoBox create(IsElement<HTMLElement> icon, String title, String value) {
    return new InfoBox(icon, title, value);
  }

  /**
   * Creates info box with icon element, title and value
   *
   * @param icon The {@link HTMLElement} icon
   * @param title the title
   * @param value the value
   * @return new instance
   */
  public static InfoBox create(HTMLElement icon, String title, String value) {
    return new InfoBox(elements.elementOf(icon), title, value);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link HTMLElement} icon
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(HTMLElement icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link HTMLElement} icon
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(IsElement<HTMLElement> icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link BaseIcon}
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(BaseIcon<?> icon, String title) {
    return new InfoBox(icon, title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link BaseIcon}
   * @return new instance
   */
  public static InfoBox create(BaseIcon<?> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link IsElement}
   * @return new instance
   */
  public static InfoBox create(IsElement<HTMLElement> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link HTMLElement}
   * @return new instance
   */
  public static InfoBox create(HTMLElement icon) {
    return new InfoBox(elements.elementOf(icon));
  }

  /**
   * Sets the hover effect
   *
   * @param effect the {@link HoverEffect}
   * @return same instance
   */
  public InfoBox setHoverEffect(HoverEffect effect) {
    addCss(hoverEffect.replaceWith(effect.effectStyle));
    return this;
  }

  public InfoBox setFlipped(boolean flipped) {
    addCss(BooleanCssClass.of(dui_info_flipped, flipped));
    return this;
  }

  /**
   * Sets the icon
   *
   * @param element the {@link HTMLElement} icon
   * @return same instance
   */
  public InfoBox setIcon(IsElement<HTMLElement> element) {
    iconContainer.get().clearElement().appendChild(element);
    return this;
  }

  /**
   * Sets the value
   *
   * @param value the new value
   * @return same instance
   */
  public InfoBox setValue(String value) {
    valueElement.get().setTextContent(value);
    return this;
  }

  /**
   * Sets the title
   *
   * @param title the new title
   * @return same instance
   */
  public InfoBox setTitle(String title) {
    titleElement.get().setTextContent(title);
    return this;
  }

  /** @return The icon element */
  public DominoElement<HTMLDivElement> getIconElement() {
    return (DominoElement<HTMLDivElement>) iconContainer.get();
  }

  /** @return The icon element */
  public InfoBox withIconElement(ChildHandler<InfoBox, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, iconContainer.get());
    return this;
  }

  /** @return The title element */
  public DominoElement<HTMLDivElement> getTitleElement() {
    return titleElement.get();
  }

  /** @return The title element */
  public InfoBox withTitleElement(ChildHandler<InfoBox, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, titleElement.get());
    return this;
  }

  /** @return The title element */
  public InfoBox withTitleElement() {
    titleElement.get();
    return this;
  }

  /** @return The value element */
  public DominoElement<HTMLDivElement> getValueElement() {
    return valueElement.get();
  }

  /** @return The value element */
  public InfoBox withValueElement() {
    valueElement.get();
    return this;
  }

  /** @return The value element */
  public InfoBox withValueElement(ChildHandler<InfoBox, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, valueElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** An enum representing the hover effect */
  public enum HoverEffect {
    ZOOM(dui_info_hover_zoom),
    EXPAND(dui_info_hover_expand),
    NONE(CssClass.NONE);

    private final CssClass effectStyle;

    HoverEffect(CssClass effectStyle) {
      this.effectStyle = effectStyle;
    }
  }
}
