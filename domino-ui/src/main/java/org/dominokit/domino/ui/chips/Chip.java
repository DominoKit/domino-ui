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

/** Chip class. */
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
   * create.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public static Chip create(String text) {
    return new Chip(text);
  }

  /**
   * Constructor for Chip.
   *
   * @param text a {@link java.lang.String} object
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

  /** {@inheritDoc} */
  @Override
  public Chip pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super Chip>> getSelectionListeners() {
    return selectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super Chip>> getDeselectionListeners() {
    return deselectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public Chip triggerSelectionListeners(Chip source, Chip selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip triggerDeselectionListeners(Chip source, Chip selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Chip getSelection() {
    if (isSelected()) {
      return this;
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public Chip select() {
    return select(isSelectionListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public Chip deselect() {
    return deselect(isSelectionListenersPaused());
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  public Chip setSelected(boolean selected) {
    return setSelected(selected, isSelectionListenersPaused());
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public boolean isSelected() {
    return selected && isSelectable();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectable() {
    return selectable;
  }

  /** {@inheritDoc} */
  @Override
  public Chip setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  /**
   * isRemovable.
   *
   * @return a boolean
   */
  public boolean isRemovable() {
    return removable;
  }

  /**
   * Setter for the field <code>removable</code>.
   *
   * @param removable a boolean
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
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
   * setText.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip setText(String text) {
    textElement.setTextContent(text);
    return this;
  }

  /**
   * withTextElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip withTextElement(ChildHandler<Chip, SpanElement> handler) {
    handler.apply(this, textElement);
    return this;
  }

  /**
   * Getter for the field <code>textElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} object
   */
  public SpanElement getTextElement() {
    return textElement;
  }

  /**
   * appendChild.
   *
   * @param prefixAddOn a {@link org.dominokit.domino.ui.utils.PrefixAddOn} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip appendChild(PrefixAddOn<?> prefixAddOn) {
    this.addon.get().appendChild(prefixAddOn);
    return this;
  }

  /**
   * setLetters.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip setLetters(String text) {
    return appendChild(PrefixAddOn.of(span().textContent(text)));
  }

  /**
   * setImage.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip setImage(HTMLImageElement img) {
    return appendChild(PrefixAddOn.of(img));
  }

  /**
   * setImage.
   *
   * @param img a {@link org.dominokit.domino.ui.elements.ImageElement} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip setImage(ImageElement img) {
    return appendChild(PrefixAddOn.of(img));
  }

  /**
   * clearAddOn.
   *
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip clearAddOn() {
    addon.remove();
    return this;
  }

  /**
   * withAddon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.chips.Chip} object
   */
  public Chip withAddon(ChildHandler<Chip, DivElement> handler) {
    handler.apply(this, addon.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
