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

import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip;
import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip_addon;
import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip_has_addon;
import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip_remove;
import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip_selected;
import static org.dominokit.domino.ui.chips.ChipStyles.dui_chip_value;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLImageElement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.AcceptDisable;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Selectable;

/**
 * A component for a Tag that can have a text and icon or image and can be set to be removable.
 *
 * @see BaseDominoElement
 */
public class Chip extends BaseDominoElement<HTMLDivElement, Chip>
    implements HasSelectionListeners<Chip, Chip, Chip>, Selectable<Chip>, AcceptDisable<Chip> {

  private DivElement root;
  private SpanElement textElement;
  private LazyChild<DivElement> addon;
  private LazyChild<RemoveButton> removeButton;
  private Set<SelectionListener<? super Chip, ? super Chip>> selectionListeners = new HashSet<>();
  private Set<SelectionListener<? super Chip, ? super Chip>> deselectionListeners = new HashSet<>();
  private boolean selectionListenersPaused = false;
  private boolean selected = false;
  private boolean selectable = true;
  private boolean removable = false;

  /**
   * factory methiod to create a Chip with the provided text.
   *
   * @param text The chip text
   * @return new Chip instance
   */
  public static Chip create(String text) {
    return new Chip(text);
  }

  /**
   * Creates a chip with the provided text
   *
   * @param text The chip text
   */
  public Chip(String text) {
    root =
        div()
            .addCss(dui_chip)
            .setAttribute("tabindex", "0")
            .appendChild(textElement = span().addCss(dui_chip_value).setTextContent(text));
    init(this);

    removeButton =
        LazyChild.of(RemoveButton.create().addCss(dui_chip_remove), root)
            .whenInitialized(
                () ->
                    removeButton
                        .element()
                        .addClickListener(
                            evt -> {
                              evt.stopPropagation();
                              evt.preventDefault();
                              remove();
                            }));

    addon =
        LazyChild.of(div().addCss(dui_chip_addon), root)
            .whenInitialized(() -> root.addCss(dui_chip_has_addon))
            .onReset(() -> root.removeCss(dui_chip_has_addon));

    root.onKeyDown(
        keyEvents ->
            keyEvents
                .onEnter(
                    evt -> {
                      evt.stopPropagation();
                      if (isSelectable()) {
                        toggleSelect();
                      }
                    })
                .onDelete(
                    evt -> {
                      evt.stopPropagation();
                      if (isRemovable()) {
                        remove();
                      }
                    }));
    root.addClickListener(
        evt -> {
          evt.stopPropagation();
          if (isSelectable()) {
            toggleSelect();
          }
        });
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super Chip>> getSelectionListeners() {
    return selectionListeners;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super Chip>> getDeselectionListeners() {
    return deselectionListeners;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip triggerSelectionListeners(Chip source, Chip selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip triggerDeselectionListeners(Chip source, Chip selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Chip getSelection() {
    if (isSelected()) {
      return this;
    }
    return null;
  }

  /**
   * Selects the chip and trigger the selection listeners if not paused
   *
   * @return same chip instance
   */
  @Override
  public Chip select() {
    return select(isSelectionListenersPaused());
  }

  /**
   * Deselects the chip and trigger the deselection listeners if not paused
   *
   * @return same chip instance
   */
  @Override
  public Chip deselect() {
    return deselect(isSelectionListenersPaused());
  }

  /**
   * Selects the chip and trigger the selection listeners if the silent flag not true.
   *
   * @param silent boolean, <b>true</b> to ignore selection listeners, <b>false</b> to trigger
   *     selection listeners
   * @return same chip instance
   */
  @Override
  public Chip select(boolean silent) {
    if (!isDisabled() && isSelectable()) {
      doSetSelected(true);
      if (!silent) {
        triggerSelectionListeners(this, this);
      }
    }
    return this;
  }

  /**
   * Deselects the chip and trigger the deselection listeners if the silent flag not true.
   *
   * @param silent boolean, <b>true</b> to ignore deselection listeners, <b>false</b> to trigger
   *     deselection listeners
   * @return same chip instance
   */
  @Override
  public Chip deselect(boolean silent) {
    if (!isDisabled() && isSelectable()) {
      doSetSelected(false);
      if (!silent) {
        triggerDeselectionListeners(this, this);
      }
    }
    return this;
  }

  /**
   * Change the chip selection state based on the provided flag.
   *
   * @param selected boolean, <b>true</b> selects the chip, <b>false</b> deselect the chip
   * @return same chip instance
   */
  public Chip setSelected(boolean selected) {
    return setSelected(selected, isSelectionListenersPaused());
  }

  /**
   * Change the chip selection state based on the provided flag and trigger the selection listeners
   * based on the silent flag.
   *
   * @param selected boolean, <b>true</b> selects the chip, <b>false</b> deselect the chip
   * @param silent boolean, <b>true</b> ignore the selection/deselection listener, <b>false</b>
   *     trigger the selection/deselection listener
   * @return same chip instance
   */
  @Override
  public Chip setSelected(boolean selected, boolean silent) {
    if (!isReadOnly() && !isDisabled()) {
      if (selected) {
        select(silent);
      } else {
        deselect(silent);
      }
    }
    return this;
  }

  private void doSetSelected(boolean selected) {
    addCss(BooleanCssClass.of(dui_chip_selected, selected));
    this.selected = selected;
  }

  /**
   * @return boolean, <b>true</b> if the chip is selectable and currently selected, otherwise
   *     <b>false</b>
   */
  @Override
  public boolean isSelected() {
    return selected && isSelectable();
  }

  /** @return boolean, <b>true</b> if the chip is selectable otherwise <b>false</b> */
  @Override
  public boolean isSelectable() {
    return selectable;
  }

  /**
   * Sets this chip to be selectable or not.
   *
   * @param selectable boolean, <b>true</b> to make the chip selectable, <b>false</b> to make it not
   *     selectable
   * @return same chip instance
   */
  @Override
  public Chip setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  /**
   * Use to check if this chip is removable or not.
   *
   * @return a boolean, <b>true</b> if the chip is removable otherwise <b>false</b>
   */
  public boolean isRemovable() {
    return removable;
  }

  /**
   * Toggle the chip removable state based on the provided flag
   *
   * @param removable a boolean, <b>true</b> to make the chip removable, <b>false</b> to make it not
   *     removable.
   * @return same chip instance
   */
  public Chip setRemovable(boolean removable) {
    this.removable = removable;
    if (isRemovable()) {
      removeButton.get();
    } else {
      removeButton.remove();
    }
    return this;
  }

  /**
   * Set the chip text
   *
   * @param text the chip text string
   * @return same chip instance
   */
  public Chip setText(String text) {
    textElement.setTextContent(text);
    return this;
  }

  /**
   * Use to apply customization to the chip text element without breaking the fluent api chain
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations
   * @return same chip instance
   */
  public Chip withTextElement(ChildHandler<Chip, SpanElement> handler) {
    handler.apply(this, textElement);
    return this;
  }

  /** @return The {@link org.dominokit.domino.ui.elements.SpanElement} of this chip text. */
  public SpanElement getTextElement() {
    return textElement;
  }

  /**
   * Appends a element to the left side of the chip
   *
   * @param prefixAddOn The {@link org.dominokit.domino.ui.utils.PrefixAddOn} wrapping another
   *     element
   * @return same chip instance
   */
  public Chip appendChild(PrefixAddOn<?> prefixAddOn) {
    this.addon.get().appendChild(prefixAddOn);
    return this;
  }

  /**
   * Appends a text as prefix to the chip
   *
   * @param text The text to be appended as a prefix.
   * @return same chip instance
   */
  public Chip setLetters(String text) {
    return appendChild(PrefixAddOn.of(span().textContent(text)));
  }

  /**
   * Appends an image as a prefix to this chip
   *
   * @param img The {@link elemental2.dom.HTMLImageElement} to be appended as prefix
   * @return same chip instance
   */
  public Chip setImage(HTMLImageElement img) {
    return appendChild(PrefixAddOn.of(img));
  }

  /**
   * Sets the prefix with the provided image.
   *
   * @param img The {@link ImageElement} to be appended as prefix
   * @return same chip instance
   */
  public Chip setImage(ImageElement img) {
    return appendChild(PrefixAddOn.of(img));
  }

  /**
   * Removes all elements appended as prefix to this chi[
   *
   * @return same chip instance
   */
  public Chip clearAddOn() {
    addon.remove();
    return this;
  }

  /**
   * Use to apply customization to the element containing prefixes appended to this chip without
   * breaking the fluent api chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customization
   * @return same chip instance
   */
  public Chip withAddon(ChildHandler<Chip, DivElement> handler) {
    handler.apply(this, addon.get());
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
