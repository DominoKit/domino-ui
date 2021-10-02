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
package org.dominokit.domino.ui.chips;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.chips.ChipStyles.*;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

/**
 * A removable container which can have image, text, icon, letters and a customizable remove icon.
 *
 * <p>This component provides a clickable container that allows adding text and an image along with
 * a remove icon to remove the container.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link ChipStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Chip.create()
 *         .setValue("Yay! I\'ll be there")
 *         .setColorScheme(ColorScheme.RED)
 *
 *     Chip.create()
 *         .setRemovable(true)
 *         .setColorScheme(ColorScheme.GREY)
 *         .setValue("Restaurants")
 *
 *     Chip.create()
 *         .setValue("Schroeder Coleman")
 *         .setColorScheme(ColorScheme.TRANSPARENT)
 *         .setBorderColor(Color.INDIGO)
 *         .setLeftImg(img("https://randomuser.me/api/portraits/med/men/0.jpg"))
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasSelectionHandler
 * @see HasDeselectionHandler
 * @see Switchable
 * @see HasRemoveHandler
 */
public class Chip extends BaseDominoElement<HTMLDivElement, Chip>
    implements HasSelectionHandler<Chip, String>,
        HasDeselectionHandler<Chip>,
        Switchable<Chip>,
        HasRemoveHandler<Chip> {

  private final DominoElement<HTMLDivElement> element = DominoElement.of(div().css(CHIP));
  private final HTMLDivElement textContainer = div().css(CHIP_VALUE).element();
  private final HTMLDivElement leftAddonContainer = div().css(CHIP_ADDON).element();
  private final HTMLDivElement removeIconContainer = div().css(CHIP_REMOVE).element();
  private ColorScheme colorScheme = ColorScheme.INDIGO;
  private Color color = Color.INDIGO;
  private DominoElement<HTMLElement> removeIcon = DominoElement.of(Icons.ALL.close().element());
  private final List<SelectionHandler<String>> selectionHandlers = new ArrayList<>();
  private final List<DeselectionHandler> deselectionHandlers = new ArrayList<>();
  private final List<RemoveHandler> removeHandlers = new ArrayList<>();
  private boolean selected;
  private boolean enabled;
  private HTMLElement leftAddon;
  private boolean selectable;
  private boolean removable;
  private Color leftBackground;
  private final Theme.ThemeChangeHandler themeListener =
      (oldTheme, newTheme) -> style.setBorderColor(newTheme.getScheme().color().getHex());

  public Chip(String value) {
    element.appendChild(leftAddonContainer);
    element.appendChild(textContainer);
    element.appendChild(removeIconContainer);
    element.setAttribute("tabindex", "0");
    setColorScheme(colorScheme);
    setRemoveIcon(removeIcon);
    setRemovable(false);
    setBorderColor(Color.INDIGO);
    setValue(value);
    KeyboardEvents.listenOnKeyDown(element)
        .onEnter(
            evt -> {
              if (selectable) {
                toggleSelect();
              }
              evt.stopPropagation();
            })
        .onDelete(
            evt -> {
              if (removable) {
                remove();
              }
              evt.stopPropagation();
            });
    element.addEventListener(
        "click",
        evt -> {
          if (selectable) {
            toggleSelect();
          }
          evt.stopPropagation();
        });
    init(this);
  }

  /** @return new instance with empty text */
  public static Chip create() {
    return create("");
  }

  /** @return new instance with {@code value} text */
  public static Chip create(String value) {
    return new Chip(value);
  }

  /**
   * Marks the chip as selected.
   *
   * <p>Selecting the chip will trigger all the {@link SelectionHandler} added to it. Also, it will
   * change the background based on the {@link ColorScheme} configured
   *
   * @return same instance
   */
  public Chip select() {
    this.selected = true;
    element.replaceCss(getBackgroundStyle(), getDarkerColor());
    removeIcon.addCss(getDarkerColor());
    selectionHandlers.forEach(selectionHandler -> selectionHandler.onSelection(getValue()));
    return this;
  }

  /**
   * Marks the chip as deselected.
   *
   * <p>Deselecting the chip will trigger all the {@link DeselectionHandler} added to it. Also, it
   * will change the background based on the {@link ColorScheme} configured
   *
   * @return same instance
   */
  public Chip deselect() {
    this.selected = false;
    element.replaceCss(getDarkerColor(), getBackgroundStyle());
    removeIcon.removeCss(getDarkerColor());
    deselectionHandlers.forEach(DeselectionHandler::onDeselection);
    return this;
  }

  /**
   * Selects/Deselects the chip based on its current status (i.e. if selected, then deselect)
   *
   * @return same instance
   * @see Chip#select()
   * @see Chip#deselect()
   */
  public Chip toggleSelect() {
    if (selected) {
      deselect();
    } else {
      select();
    }
    return this;
  }

  /**
   * Sets the remove icon element. This will add click {@link elemental2.dom.EventListener} to the
   * {@code removeIcon} that removes the chip
   *
   * @param removeIcon the new remove {@link HTMLElement}
   * @return same instance
   */
  public Chip setRemoveIcon(HTMLElement removeIcon) {
    this.removeIcon = DominoElement.of(removeIcon);
    ElementUtil.clear(removeIconContainer);
    removeIconContainer.appendChild(removeIcon);
    removeIcon.addEventListener(
        "click",
        evt -> {
          remove();
          evt.stopPropagation();
        });
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip remove() {
    return remove(false);
  }

  /**
   * Removes the chip.
   *
   * <p>Accepts {@code silent} flag to call all the {@link RemoveHandler} added to it.
   *
   * @param silent if true, then this will call all the {@link RemoveHandler}
   * @return same instance
   */
  public Chip remove(boolean silent) {
    element.remove();
    if (!silent) removeHandlers.forEach(RemoveHandler::onRemove);
    return this;
  }

  /**
   * Same as {@link Chip#setRemoveIcon(HTMLElement)} but accepts a wrapper {@link IsElement}
   *
   * @param removeIcon the new remove icon {@link IsElement} to set
   * @return same instance
   */
  public Chip setRemoveIcon(IsElement<?> removeIcon) {
    return setRemoveIcon(removeIcon.element());
  }

  /**
   * Sets the color scheme for this component.
   *
   * <p>The color scheme will be used for changing the color based on the chip status if it is
   * selected or not.
   *
   * @param colorScheme the new {@link ColorScheme} to set
   * @return same instance
   */
  public Chip setColorScheme(ColorScheme colorScheme) {
    removeCurrentBackground();

    this.colorScheme = colorScheme;
    this.color = colorScheme.color();
    applyColor();
    return this;
  }

  private void applyColor() {
    element.addCss(this.color.getBackground());
    removeIcon.addCss(this.color.getBackground());
    setBorderColor(this.color);
  }

  private void removeCurrentBackground() {
    if (nonNull(this.colorScheme)) {
      element.removeCss(getBackgroundStyle());
      removeIcon.removeCss(getBackgroundStyle());
    }

    if (nonNull(this.color)) {
      element.removeCss(color.getBackground());
      removeIcon.removeCss(color.getBackground());
    }
  }

  /**
   * Sets the color.
   *
   * <p>The color is used to get the background color to be set to this chip, if not set then the
   * color will be configured using the {@link ColorScheme} set.
   *
   * @param color the new {@link Color} to set
   * @return same instance
   */
  public Chip setColor(Color color) {
    if (nonNull(this.colorScheme)) {
      element.removeCss(getBackgroundStyle());
      removeIcon.removeCss(getBackgroundStyle());
    }

    if (nonNull(this.color)) {
      element.removeCss(color.getBackground());
      removeIcon.removeCss(color.getBackground());
    }
    this.color = color;
    applyColor();
    return this;
  }

  private boolean hasColor() {
    return nonNull(this.colorScheme) || nonNull(color);
  }

  private String getDarkerColor() {
    return colorScheme.darker_4().getBackground();
  }

  private String getBackgroundStyle() {
    return this.color.getBackground();
  }

  /**
   * Sets if this chip can be removed or not.
   *
   * <p>Setting this to removable will add the remove icon configured for this component
   *
   * @param removable true if the chip can be removed
   * @return same instance
   */
  public Chip setRemovable(boolean removable) {
    this.removable = removable;
    if (removable) {
      Style.of(removeIconContainer).setDisplay("block");
    } else {
      Style.of(removeIconContainer).setDisplay("none");
    }
    return this;
  }

  /**
   * Sets the text of the chip.
   *
   * @param value the new text
   * @return same instance
   */
  public Chip setValue(String value) {
    textContainer.textContent = value;
    return this;
  }

  /**
   * Sets the left icon of the chip
   *
   * @param icon the new {@link BaseIcon}
   * @return same instance
   */
  public Chip setLeftIcon(BaseIcon<?> icon) {
    setLeftAddon(icon.element());
    return this;
  }

  /**
   * Sets the left image of the chip.
   *
   * @param imageElement the new {@link HTMLImageElement}
   * @return same instance
   */
  public Chip setLeftImg(HTMLImageElement imageElement) {
    setLeftAddon(imageElement);
    return this;
  }

  /**
   * Same as {@link Chip#setLeftImg(HTMLImageElement)} but with a wrapper {@link
   * IsElement<HTMLImageElement>}
   *
   * @param imageElement the new {@link IsElement<HTMLImageElement>}
   * @return same instance
   */
  public Chip setLeftImg(IsElement<HTMLImageElement> imageElement) {
    return setLeftImg(imageElement.element());
  }

  /**
   * Sets the left element as a letter.
   *
   * @param text the letter to set
   * @return same instance
   */
  public Chip setLeftLetter(String text) {
    setLeftAddon(span().textContent(text).element());
    return this;
  }

  private void setLeftAddon(HTMLElement leftAddon) {
    this.leftAddon = leftAddon;
    ElementUtil.clear(leftAddonContainer);
    leftAddonContainer.appendChild(leftAddon);
    updateLeftAddonBackground();
  }

  /**
   * Sets the left container background
   *
   * @param leftBackground the {@link Color}
   * @return same instance
   */
  public Chip setLeftBackground(Color leftBackground) {
    this.leftBackground = leftBackground;
    updateLeftAddonBackground();
    return this;
  }

  private void updateLeftAddonBackground() {
    if (nonNull(leftAddon) && nonNull(leftBackground)) {
      Style.of(leftAddon).addCss(leftBackground.getBackground());
    }
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** {@inheritDoc} */
  @Override
  public Chip addSelectionHandler(SelectionHandler<String> selectionHandler) {
    selectionHandlers.add(selectionHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip addDeselectionHandler(DeselectionHandler deselectionHandler) {
    deselectionHandlers.add(deselectionHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip removeSelectionHandler(SelectionHandler<String> selectionHandler) {
    selectionHandlers.remove(selectionHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip enable() {
    this.enabled = true;
    element.removeAttribute("disabled");
    removeIconContainer.removeAttribute("disabled");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip disable() {
    this.enabled = false;
    element.setAttribute("disabled", "disabled");
    removeIconContainer.setAttribute("disabled", "disabled");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return enabled;
  }

  /** {@inheritDoc} */
  @Override
  public Chip addRemoveHandler(RemoveHandler removeHandler) {
    removeHandlers.add(removeHandler);
    return this;
  }

  /**
   * Sets if the chip can be selected or not.
   *
   * @param selectable true if the chip can be selected
   * @return same instance
   */
  public Chip setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  /**
   * Sets the border {@link Color}
   *
   * @param borderColor the {@link Color} to set
   * @return same instance
   */
  public Chip setBorderColor(Color borderColor) {
    if (Color.THEME.equals(color)) {
      Theme.addThemeChangeHandler(themeListener);
    } else {
      Theme.removeThemeChangeHandler(themeListener);
    }

    Style.of(element).setBorderColor(borderColor.getHex());
    return this;
  }

  /**
   * Removes the left element.
   *
   * @return same instance
   */
  public Chip removeLeftAddon() {
    ElementUtil.clear(leftAddonContainer);
    return this;
  }

  /** @return The text of the chip */
  public String getValue() {
    return textContainer.textContent;
  }

  /** @return The text container */
  public DominoElement<HTMLDivElement> getTextContainer() {
    return DominoElement.of(textContainer);
  }

  /** @return The left element container */
  public DominoElement<HTMLDivElement> getLeftAddonContainer() {
    return DominoElement.of(leftAddonContainer);
  }

  /** @return The remove element container */
  public DominoElement<HTMLDivElement> getRemoveIconContainer() {
    return DominoElement.of(removeIconContainer);
  }

  /** @return The remove element */
  public DominoElement<HTMLElement> getRemoveIcon() {
    return DominoElement.of(removeIcon);
  }

  /** @return The left element */
  public DominoElement<HTMLElement> getLeftAddon() {
    return DominoElement.of(leftAddon);
  }
}
