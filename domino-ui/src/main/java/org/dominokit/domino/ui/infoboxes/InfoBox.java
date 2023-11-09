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
 * Represents an informational box component that displays icon, title, and value information.
 *
 * <p>This class allows you to create and customize information boxes for displaying various types
 * of information. You can set an icon, title, and value to be displayed within the box.
 * Additionally, you can customize the hover effect and flip the box if needed.
 *
 * <p>Example usage:
 *
 * <pre>
 * // Create an InfoBox with an icon, title, and value
 * InfoBox infoBox = InfoBox.create(icon, "Title", "Value");
 *
 * // Customize the hover effect
 * infoBox.setHoverEffect(InfoBox.HoverEffect.EXPAND);
 *
 * // Flip the InfoBox
 * infoBox.setFlipped(true);
 *
 * // Add the InfoBox to a parent element
 * Document.get().getBody().appendChild(infoBox.element());
 * </pre>
 *
 * @see BaseDominoElement
 */
public class InfoBox extends BaseDominoElement<HTMLDivElement, InfoBox> implements InfoBoxStyles {

  private final DivElement root;
  private final LazyChild<DivElement> contentElement;
  private final LazyChild<DivElement> titleElement;
  private final LazyChild<DivElement> infoElement;

  private LazyChild<DivElement> iconContainer;

  private SwapCssClass hoverEffect = SwapCssClass.of(HoverEffect.NONE.effectStyle);

  /** Creates a new InfoBox with default settings. */
  public InfoBox() {
    root = div().addCss(dui_info_box, hoverEffect);
    iconContainer = LazyChild.of(div().addCss(dui_info_icon), root);
    contentElement = LazyChild.of(div().addCss(dui_info_content), root);
    titleElement = LazyChild.of(div().addCss(dui_info_title), contentElement);
    infoElement = LazyChild.of(div().addCss(dui_info_value), contentElement);
    init(this);
  }

  /**
   * Creates a new InfoBox with the provided icon.
   *
   * @param icon The icon element to be displayed.
   */
  public InfoBox(IsElement<HTMLElement> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Creates a new InfoBox with the provided icon and title.
   *
   * @param icon The icon element to be displayed.
   * @param title The title to be displayed in the InfoBox.
   */
  public InfoBox(IsElement<HTMLElement> icon, String title) {
    this(icon);
    setTitle(title);
  }

  /**
   * Creates a new InfoBox with the provided icon, title, and value.
   *
   * @param icon The icon element to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @param value The value to be displayed in the InfoBox.
   */
  public InfoBox(IsElement<HTMLElement> icon, String title, String value) {
    this(icon, title);
    setInfo(value);
  }

  /**
   * Creates a new InfoBox with an icon, title, and value.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @param value The value to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(Icon<?> icon, String title, String value) {
    return new InfoBox(icon, title, value);
  }

  /**
   * Creates a new InfoBox with the provided icon, title, and value.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @param value The value to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(IsElement<HTMLElement> icon, String title, String value) {
    return new InfoBox(icon, title, value);
  }

  /**
   * Creates a new InfoBox with the provided icon, title, and value.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @param value The value to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(HTMLElement icon, String title, String value) {
    return new InfoBox(elements.elementOf(icon), title, value);
  }

  /**
   * Creates a new InfoBox with the provided icon and title.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(HTMLElement icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates a new InfoBox with the provided icon and title.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(IsElement<HTMLElement> icon, String title) {
    return new InfoBox(elements.elementOf(icon), title);
  }

  /**
   * Creates a new InfoBox with the provided icon and title.
   *
   * @param icon The icon to be displayed.
   * @param title The title to be displayed in the InfoBox.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(Icon<?> icon, String title) {
    return new InfoBox(icon, title);
  }

  /**
   * Creates a new InfoBox with the provided icon.
   *
   * @param icon The icon to be displayed.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(Icon<?> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates a new InfoBox with the provided icon.
   *
   * @param icon The icon to be displayed.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(IsElement<HTMLElement> icon) {
    return new InfoBox(icon);
  }

  /**
   * Creates a new InfoBox with the provided icon.
   *
   * @param icon The icon to be displayed.
   * @return A new InfoBox instance.
   */
  public static InfoBox create(HTMLElement icon) {
    return new InfoBox(elements.elementOf(icon));
  }

  /**
   * Sets the hover effect style for the InfoBox.
   *
   * @param effect The hover effect style to apply.
   * @return This InfoBox instance.
   */
  public InfoBox setHoverEffect(HoverEffect effect) {
    addCss(hoverEffect.replaceWith(effect.effectStyle));
    return this;
  }

  /**
   * Sets whether the InfoBox is flipped.
   *
   * @param flipped {@code true} to flip the InfoBox, {@code false} otherwise.
   * @return This InfoBox instance.
   */
  public InfoBox setFlipped(boolean flipped) {
    addCss(BooleanCssClass.of(dui_info_flipped, flipped));
    return this;
  }

  /**
   * Sets the icon for the InfoBox.
   *
   * @param element The icon element to be displayed.
   * @return This InfoBox instance.
   */
  public InfoBox setIcon(IsElement<HTMLElement> element) {
    iconContainer.get().clearElement().appendChild(element);
    return this;
  }

  /**
   * Sets the informational value for the InfoBox.
   *
   * @param value The value to be displayed in the InfoBox.
   * @return This InfoBox instance.
   */
  public InfoBox setInfo(String value) {
    infoElement.get().setTextContent(value);
    return this;
  }

  /**
   * Sets the title for the InfoBox.
   *
   * @param title The title to be displayed in the InfoBox.
   * @return This InfoBox instance.
   */
  public InfoBox setTitle(String title) {
    titleElement.get().setTextContent(title);
    return this;
  }

  /**
   * Gets the icon element in the InfoBox.
   *
   * @return The icon element.
   */
  public DivElement getIcon() {
    return (DivElement) iconContainer.get();
  }

  /**
   * Configures the InfoBox with an icon using a handler.
   *
   * @param handler The handler to configure the icon.
   * @return This InfoBox instance.
   */
  public InfoBox withIcon(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, iconContainer.get());
    return this;
  }

  /**
   * Gets the title element in the InfoBox.
   *
   * @return The title element.
   */
  public DivElement getTitle() {
    return titleElement.get();
  }

  /**
   * Configures the InfoBox with a title using a handler.
   *
   * @param handler The handler to configure the title.
   * @return This InfoBox instance.
   */
  public InfoBox withTitle(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, titleElement.get());
    return this;
  }

  /**
   * Configures the InfoBox with a title.
   *
   * @return This InfoBox instance.
   */
  public InfoBox withTitle() {
    titleElement.get();
    return this;
  }

  /**
   * Gets the informational value element in the InfoBox.
   *
   * @return The value element.
   */
  public DivElement getInfo() {
    return infoElement.get();
  }

  /**
   * Configures the InfoBox with an informational value.
   *
   * @return This InfoBox instance.
   */
  public InfoBox withInfo() {
    infoElement.get();
    return this;
  }

  /**
   * Configures the InfoBox with an informational value using a handler.
   *
   * @param handler The handler to configure the informational value.
   * @return This InfoBox instance.
   */
  public InfoBox withInfo(ChildHandler<InfoBox, DivElement> handler) {
    handler.apply(this, infoElement.get());
    return this;
  }

  /**
   * Gets the content element of the InfoBox.
   *
   * @return The content element.
   */
  public DivElement getContent() {
    return contentElement.get();
  }

  /**
   * Configures the InfoBox with content.
   *
   * @return This InfoBox instance.
   */
  public InfoBox withContent() {
    contentElement.get();
    return this;
  }

  /**
   * Configures the InfoBox with content using a handler.
   *
   * @param handler The handler to configure the content.
   * @return This InfoBox instance.
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

  /** Enumeration of hover effect styles for the InfoBox. */
  public enum HoverEffect {
    /** The InfoBox zooms in on hover. */
    ZOOM(dui_info_hover_zoom),

    /** The InfoBox expands on hover. */
    EXPAND(dui_info_hover_expand),

    /** No hover effect is applied to the InfoBox. */
    NONE(CssClass.NONE);

    private final CssClass effectStyle;

    HoverEffect(CssClass effectStyle) {
      this.effectStyle = effectStyle;
    }
  }
}
