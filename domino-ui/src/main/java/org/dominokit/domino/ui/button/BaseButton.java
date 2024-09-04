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
package org.dominokit.domino.ui.button;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.button;

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.grid.flex.FlexStyles;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.HasContent;
import org.dominokit.domino.ui.utils.Sizable;
import org.dominokit.domino.ui.utils.Switchable;

/**
 * A base component to implement buttons
 *
 * <p>this class provides commons functionality and methods used in different implementations of a
 * button
 *
 * @param <B> The button subclass being wrapped
 */
public abstract class BaseButton<B extends BaseButton<?>> extends WavesElement<HTMLElement, B>
    implements HasClickableElement, Sizable<B>, HasBackground<B>, HasContent<B>, Switchable<B> {

  private static final String DISABLED = "disabled";

  private StyleType type;
  private Color background;
  private Color color;
  private ButtonSize size;
  protected String content;
  private BaseIcon<?> icon;
  private Elevation beforeLinkifyElevation = Elevation.LEVEL_1;

  protected FlexLayout contentLayout;

  /** The default element that represent the button HTMLElement. */
  protected final DominoElement<HTMLButtonElement> buttonElement =
      DominoElement.of(button()).css(ButtonStyles.BUTTON);

  private FlexItem<HTMLDivElement> textContainer;
  private FlexItem<HTMLDivElement> iconContainer;

  /** creates a button with default size {@link ButtonSize#MEDIUM} */
  protected BaseButton() {
    textContainer =
        FlexItem.create()
            .addCss("dui-btn-text", FlexStyles.FLEX_LAYOUT)
            .setFlexGrow(1)
            .setOrder(20);

    iconContainer = FlexItem.create().setOrder(10);
    contentLayout =
        FlexLayout.create()
            .setJustifyContent(FlexJustifyContent.CENTER)
            .appendChild(textContainer)
            .appendChild(iconContainer);

    buttonElement.appendChild(contentLayout);

    setSize(ButtonSize.MEDIUM);
  }

  /**
   * creates a button with text and default size {@link ButtonSize#MEDIUM}
   *
   * @param content String text
   */
  protected BaseButton(String content) {
    this();
    setContent(content);
  }

  /**
   * creates a button with an icon and default size {@link ButtonSize#MEDIUM}
   *
   * @param icon {@link BaseIcon}
   */
  protected BaseButton(BaseIcon icon) {
    this();
    setIcon(icon);
  }

  /**
   * creates a button with an icon and default size {@link ButtonSize#MEDIUM} and apply a predefined
   * {@link StyleType}
   *
   * @param content String text
   * @param type {@link StyleType}
   */
  protected BaseButton(String content, StyleType type) {
    this(content);
    setButtonType(type);
  }

  /**
   * creates a button with an icon and default size {@link ButtonSize#MEDIUM} and apply a predefined
   * {@link StyleType}
   *
   * @param icon {@link BaseIcon}
   * @param type {@link StyleType}
   */
  protected BaseButton(BaseIcon icon, StyleType type) {
    this(icon);
    setButtonType(type);
  }

  /**
   * creates a button with a text and default size {@link ButtonSize#MEDIUM} and apply a custom
   * background {@link Color}
   *
   * @param content String text
   * @param background {@link Color} the background color
   */
  public BaseButton(String content, Color background) {
    this(content);
    setBackground(background);
  }

  /**
   * replaces the current text of the button
   *
   * @param content String, the new text
   * @return same instance
   */
  @Override
  public B setContent(String content) {
    this.content = content;
    textContainer.textContent(content);
    return (B) this;
  }

  /**
   * same as {@link #setContent(String)}
   *
   * @param text String, the new text
   * @return same instance
   */
  @Override
  public B setTextContent(String text) {
    setContent(text);
    return (B) this;
  }

  /**
   * change the size of the button
   *
   * @param size {@link ButtonSize}
   * @return same instance
   */
  public B setSize(ButtonSize size) {
    if (nonNull(size)) {
      if (nonNull(this.size)) {
        buttonElement.style().removeCss(this.size.getStyle());
      }
      buttonElement.addCss(size.getStyle());
      this.size = size;
    }
    return (B) this;
  }

  /**
   * sets or remove the {@link ButtonStyles#BUTTON_BLOCK}
   *
   * @param block boolean if true add the style otherwise remove it
   * @return same instance
   */
  public B setBlock(boolean block) {
    if (block) buttonElement.addCss(ButtonStyles.BUTTON_BLOCK);
    else buttonElement.removeCss(ButtonStyles.BUTTON_BLOCK);
    return (B) this;
  }

  /**
   * change the button background color
   *
   * @param background the {@link Color} of the new background
   * @return same instance
   */
  @Override
  public B setBackground(Color background) {
    if (nonNull(background)) {
      if (nonNull(this.type)) buttonElement.removeCss(this.type.getStyle());
      if (nonNull(this.background)) buttonElement.removeCss(this.background.getBackground());
      buttonElement.addCss(background.getBackground());
      this.background = background;
    }
    return (B) this;
  }

  /**
   * Changes the text color of a button
   *
   * @param color the new {@link Color}
   * @return same instance
   */
  public B setColor(Color color) {
    if (nonNull(this.color)) removeCss(this.color.getStyle());
    this.color = color;
    addCss(this.color.getStyle());
    return (B) this;
  }

  /**
   * changes the button style type
   *
   * @param type the new {@link StyleType}
   * @return same instance
   */
  public B setButtonType(StyleType type) {
    if (nonNull(this.type)) buttonElement.removeCss(this.type.getStyle());
    buttonElement.addCss(type.getStyle());
    this.type = type;
    return (B) this;
  }

  /**
   * delegate to {@link #disable()} or {@link #enable()} based on the flag
   *
   * @param enabled boolean, if true call {@link #enable()} else call {@link #disable()}
   * @return same instance
   */
  public B setEnabled(boolean enabled) {
    return enabled ? enable() : disable();
  }

  /**
   * check if the button is enabled or not
   *
   * @return boolean, true if the button is enabled else return false
   */
  @Override
  public boolean isEnabled() {
    return !buttonElement.hasAttribute(DISABLED);
  }

  /**
   * return the clickable {@link HTMLElement} of this component, which the component button element.
   *
   * @return {@link HTMLElement} of this button instance
   */
  @Override
  public HTMLElement getClickableElement() {
    return element();
  }

  /**
   * change the button size to {@link ButtonSize#LARGE}
   *
   * @return same instance
   */
  @Override
  public B large() {
    setSize(ButtonSize.LARGE);
    return (B) this;
  }

  /**
   * change the button size to {@link ButtonSize#MEDIUM}
   *
   * @return same instance
   */
  @Override
  public B medium() {
    setSize(ButtonSize.MEDIUM);
    return (B) this;
  }

  /**
   * change the button size to {@link ButtonSize#SMALL}
   *
   * @return same instance
   */
  @Override
  public B small() {
    setSize(ButtonSize.SMALL);
    return (B) this;
  }

  /**
   * change the button size to {@link ButtonSize#XSMALL}
   *
   * @return same instance
   */
  @Override
  public B xSmall() {
    setSize(ButtonSize.XSMALL);
    return (B) this;
  }

  /**
   * delegate to {@link #setBlock(boolean)} with true
   *
   * @return same instance
   */
  public B block() {
    setBlock(true);
    return (B) this;
  }

  /**
   * changes the button to look like a link by applying {@link ButtonStyles#BUTTON_LINK} and remove
   * the {@link Elevation}
   *
   * @return same instance
   */
  public B linkify() {
    buttonElement.addCss(ButtonStyles.BUTTON_LINK);
    beforeLinkifyElevation =
        nonNull(buttonElement.getElevation()) ? buttonElement.getElevation() : Elevation.LEVEL_1;
    buttonElement.elevate(Elevation.NONE);
    return (B) this;
  }

  /**
   * Revert a linkify(ed) button to look like a button by removing {@link ButtonStyles#BUTTON_LINK}
   * and restore the previous {@link Elevation}
   *
   * @return same instance
   */
  public B deLinkify() {
    buttonElement.removeCss(ButtonStyles.BUTTON_LINK);
    buttonElement.elevate(beforeLinkifyElevation);
    return (B) this;
  }

  /**
   * adds a border to the button by applying the {@link ButtonStyles#BUTTON_BORDERED} and removes
   * the {@link Elevation}
   *
   * @return same instance
   */
  public B bordered() {
    buttonElement.addCss(ButtonStyles.BUTTON_BORDERED);
    beforeLinkifyElevation =
        nonNull(buttonElement.getElevation()) ? buttonElement.getElevation() : Elevation.LEVEL_1;
    buttonElement.elevate(Elevation.NONE);
    return (B) this;
  }

  /**
   * sets the border color for a bordered button
   *
   * @param borderColor the {@link Color} of the border
   * @return same instance
   */
  public B bordered(Color borderColor) {
    bordered();
    buttonElement.style().setBorderColor(borderColor.getHex());
    return (B) this;
  }

  /**
   * removes the button border applied by {@link #bordered()} and restore previous {@link Elevation}
   *
   * @return same instance
   */
  public B nonBordered() {
    buttonElement.removeCss(ButtonStyles.BUTTON_BORDERED);
    buttonElement.elevate(beforeLinkifyElevation);
    return (B) this;
  }

  /**
   * changes the button to a circle button by applying {@link ButtonStyles#BUTTON_CIRCLE}
   *
   * @return same instance
   */
  public B circle() {
    buttonElement.addCss(ButtonStyles.BUTTON_CIRCLE);
    applyCircleWaves();
    return (B) this;
  }

  /**
   * sets the button icon replacing the current icon.
   *
   * @param icon the new {@link BaseIcon}
   * @return same instance
   */
  public B setIcon(BaseIcon<?> icon) {
    if (nonNull(this.icon)) {
      this.icon.remove();
    }
    if (nonNull(icon)) {
      iconContainer.appendChild(icon);
      this.icon = icon;
      this.icon.addCss("btn-icon");
    }
    return (B) this;
  }

  /** @return the current applied {@link ButtonSize} */
  public ButtonSize getSize() {
    return size;
  }

  public Color getBackground() {
    return background;
  }

  /** @return {@link DominoElement} of {@link HTMLElement} that wrap the button text */
  public DominoElement<HTMLElement> getTextSpan() {
    return DominoElement.of(Js.<HTMLElement>uncheckedCast(textContainer.element()));
  }

  public B setIconPosition(IconPosition position) {
    if (nonNull(position)) {
      iconContainer.setOrder(position.getIconOrder());
    }
    return (B) this;
  }

  public B setJustifyText(FlexJustifyContent justifyContent) {
    if (nonNull(justifyContent)) {
      textContainer.addCss(justifyContent.getStyle());
    }
    return (B) this;
  }

  private void applyCircleWaves() {
    applyWaveStyle(WaveStyle.CIRCLE);
    applyWaveStyle(WaveStyle.FLOAT);
  }

  @Deprecated
  public enum IconPosition {
    LEFT(10),
    RIGHT(30);

    private final int iconOrder;

    IconPosition(int iconOrder) {
      this.iconOrder = iconOrder;
    }

    public int getIconOrder() {
      return iconOrder;
    }
  }
}
