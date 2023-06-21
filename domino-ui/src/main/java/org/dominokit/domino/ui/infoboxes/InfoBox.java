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
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;

/**
 * Container for displaying information with icons
 *
 * <p>This component provides a container which allows showing information with icons and effects
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.infoboxes.InfoBoxStyles} </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @author vegegoku
 * @version $Id: $Id
 */
public class InfoBox extends BaseDominoElement<HTMLDivElement, InfoBox> implements InfoBoxStyles {

  private final DivElement root;
  private final LazyChild<DivElement> contentElement;
  private final LazyChild<DivElement> titleElement;
  private final LazyChild<DivElement> infoElement;

  private LazyChild<DivElement> iconContainer;

  private SwapCssClass hoverEffect = SwapCssClass.of(HoverEffect.NONE.effectStyle);

  /** Constructor for InfoBox. */
  public InfoBox() {
    root = div().addCss(dui_info_box, hoverEffect);
    iconContainer = LazyChild.of(div().addCss(dui_info_icon), root);
    contentElement = LazyChild.of(div().addCss(dui_info_content), root);
    titleElement = LazyChild.of(div().addCss(dui_info_title), contentElement);
    infoElement = LazyChild.of(div().addCss(dui_info_value), contentElement);
    init(this);
  }

  /**
   * Constructor for InfoBox.
   *
   * @param icon a {@link org.dominokit.domino.ui.IsElement} object
   */
  public InfoBox(IsElement<HTMLElement> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Constructor for InfoBox.
   *
   * @param icon a {@link org.dominokit.domino.ui.IsElement} object
   * @param title a {@link java.lang.String} object
   */
  public InfoBox(IsElement<HTMLElement> icon, String title) {
    this(icon);
    setTitle(title);
  }

  /**
   * Constructor for InfoBox.
   *
   * @param icon a {@link org.dominokit.domino.ui.IsElement} object
   * @param title a {@link java.lang.String} object
   * @param value a {@link java.lang.String} object
   */
  public InfoBox(IsElement<HTMLElement> icon, String title, String value) {
    this(icon, title);
    setInfo(value);
  }

  /**
   * Creates info box with icon, title and value
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon}
   * @param title the title
   * @param value the value
   * @return new instance
   */
  public static InfoBox create(Icon<?> icon, String title, String value) {
    return new InfoBox(icon, title, value);
  }

  /**
   * Creates info box with icon, title and value
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon}
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
   * @param icon The {@link elemental2.dom.HTMLElement} icon
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
   * @param icon The {@link elemental2.dom.HTMLElement} icon
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(HTMLElement icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link elemental2.dom.HTMLElement} icon
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(IsElement<HTMLElement> icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon}
   * @param title the title
   * @return new instance
   */
  public static InfoBox create(Icon<?> icon, String title) {
    return new InfoBox(icon, title);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon}
   * @return new instance
   */
  public static InfoBox create(Icon<?> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link org.dominokit.domino.ui.IsElement}
   * @return new instance
   */
  public static InfoBox create(IsElement<HTMLElement> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates info box with icon and title
   *
   * @param icon The {@link elemental2.dom.HTMLElement}
   * @return new instance
   */
  public static InfoBox create(HTMLElement icon) {
    return new InfoBox(elements.elementOf(icon));
  }

  /**
   * Sets the hover effect
   *
   * @param effect the {@link org.dominokit.domino.ui.infoboxes.InfoBox.HoverEffect}
   * @return same instance
   */
  public InfoBox setHoverEffect(HoverEffect effect) {
    addCss(hoverEffect.replaceWith(effect.effectStyle));
    return this;
  }

  /**
   * setFlipped.
   *
   * @param flipped a boolean
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox setFlipped(boolean flipped) {
    addCss(BooleanCssClass.of(dui_info_flipped, flipped));
    return this;
  }

  /**
   * Sets the icon
   *
   * @param element the {@link elemental2.dom.HTMLElement} icon
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
  public InfoBox setInfo(String value) {
    infoElement.get().setTextContent(value);
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
  /**
   * getIcon.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getIcon() {
    return (DivElement) iconContainer.get();
  }

  /** @return The icon element */
  /**
   * withIcon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withIcon(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, iconContainer.get());
    return this;
  }

  /** @return The title element */
  /**
   * getTitle.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getTitle() {
    return titleElement.get();
  }

  /** @return The title element */
  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withTitle(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, titleElement.get());
    return this;
  }

  /** @return The title element */
  /**
   * withTitle.
   *
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withTitle() {
    titleElement.get();
    return this;
  }

  /** @return The value element */
  /**
   * getInfo.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getInfo() {
    return infoElement.get();
  }

  /** @return The value element */
  /**
   * withInfo.
   *
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withInfo() {
    infoElement.get();
    return this;
  }

  /** @return The value element */
  /**
   * withInfo.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withInfo(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, infoElement.get());
    return this;
  }

  /**
   * getContent.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContent() {
    return contentElement.get();
  }

  /**
   * withContent.
   *
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withContent() {
    contentElement.get();
    return this;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.infoboxes.InfoBox} object
   */
  public InfoBox withContent(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, contentElement.get());
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
