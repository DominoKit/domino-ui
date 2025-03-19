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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLDivElement;
import java.util.*;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.AcceptDisable;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionListeners;

/**
 * This component groups a set of {@link org.dominokit.domino.ui.chips.Chip}s and controls the
 * selection behavior of grouped chips
 *
 * @see HasSelectionListeners
 * @see BaseDominoElement
 */
public class ChipsGroup extends BaseDominoElement<HTMLDivElement, ChipsGroup>
    implements AcceptDisable<ChipsGroup>, HasSelectionListeners<ChipsGroup, Chip, List<Chip>> {

  private final DivElement root;
  private final List<Chip> chips = new ArrayList<>();
  private final List<Chip> selectedChips = new ArrayList<>();

  private boolean multiSelect = false;
  private boolean removable = false;
  private Set<SelectionListener<? super Chip, ? super List<Chip>>> selectionListeners =
      new HashSet<>();
  private Set<SelectionListener<? super Chip, ? super List<Chip>>> deselectionListeners =
      new HashSet<>();
  private boolean selectionListenersPaused = false;

  /** Creates and empty chips group */
  public ChipsGroup() {
    root = div();
    init(this);
  }

  /**
   * Factory method to create an empty chips group
   *
   * @return new ChipsGroup instance
   */
  public static ChipsGroup create() {
    return new ChipsGroup();
  }

  /**
   * Adds a {@link org.dominokit.domino.ui.chips.Chip} to this chips group
   *
   * <p>This will automatically set the chip as selectable and adds selection/deselection handler to
   * handle the switching between all the chips.
   *
   * @param chip the {@link org.dominokit.domino.ui.chips.Chip} to be added to the group
   * @return same ChipsGroup instance
   */
  public ChipsGroup appendChild(Chip chip) {
    chip.setSelectable(true);
    chip.setRemovable(removable || chip.isRemovable());
    chip.onDetached(
        (target, mutationRecord) -> {
          if (chip.isSelected()) {
            chip.deselect();
          }
        });
    chip.addSelectionListener(
        (source, selection) -> {
          if (!this.selectedChips.isEmpty() && !multiSelect) {
            this.selectedChips.forEach(
                selectedChip ->
                    selectedChip.withPauseSelectionListenersToggle(true, Chip::deselect));
            this.selectedChips.clear();
          }
          source.ifPresent(this.selectedChips::add);
          if (!isSelectionListenersPaused()) {
            triggerSelectionListeners(source.get(), this.selectedChips);
            if (!multiSelect) {
              triggerDeselectionListeners(source.get(), this.selectedChips);
            }
          }
        });

    chip.addDeselectionListener(
        (source, selection) -> {
          source.ifPresent(this.selectedChips::remove);
          if (!isSelectionListenersPaused()) {
            triggerDeselectionListeners(source.get(), this.selectedChips);
          }
        });

    chips.add(chip);
    root.appendChild(chip);
    return this;
  }

  public ChipsGroup appendChild(Chip... chips) {
    Arrays.asList(chips).forEach(this::appendChild);
    return this;
  }

  /** Enables chips selection */
  @Override
  public ChipsGroup enable() {
    chips.forEach(Chip::enable);
    return this;
  }

  /** Disables chips selection */
  @Override
  public ChipsGroup disable() {
    chips.forEach(Chip::disable);
    return this;
  }

  /**
   * Use to check if this group chips selection is enabled
   *
   * @return boolean, <b>true</b> if selection is enabled, <b>false</b> if selection is not enabled
   */
  @Override
  public boolean isEnabled() {
    return chips.stream().allMatch(Chip::isEnabled);
  }

  /** @return a {@link java.util.List} of currently selected chips in this group */
  public List<Chip> getSelectedChips() {
    return selectedChips;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Selects a chip at provided index {@code index} only if the index within the acceptable range,
   * otherwise ignore.
   *
   * @param index the index of the chip to select
   * @return same instance
   */
  public ChipsGroup selectAt(int index) {
    if (index >= 0 && index < chips.size()) {
      chips.get(index).select();
    }
    return this;
  }

  /** @return a {@link java.util.List} of all chips in this group. */
  public List<Chip> getChips() {
    return chips;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public ChipsGroup pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public ChipsGroup resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public ChipsGroup togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** {@dominokit-site-ignore @inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super List<Chip>>> getSelectionListeners() {
    return selectionListeners;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super Chip, ? super List<Chip>>> getDeselectionListeners() {
    return deselectionListeners;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public ChipsGroup triggerSelectionListeners(Chip source, List<Chip> selection) {
    selectionListeners.forEach(
        selectionListener ->
            selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public ChipsGroup triggerDeselectionListeners(Chip source, List<Chip> selection) {
    deselectionListeners.forEach(
        selectionListener ->
            selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public List<Chip> getSelection() {
    return selectedChips;
  }

  /**
   * Use to check if this group allows the selection of multiple chips at the same time.
   *
   * @return a boolean, <b>true</b> multi-select is enabled, <b>false</b> multi-select is disabled
   */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Enable/Disable multi-selection based on the provided flag.
   *
   * @param multiSelect a boolean, <b>true</b> enables multi-selection, <b>false</b> disable
   *     multi-selection
   * @return same ChipsGroup instance
   */
  public ChipsGroup setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    if (!multiSelect && this.selectedChips.size() > 1) {
      Chip chip = selectedChips.get(0);
      chip.select();
    }
    return this;
  }

  /**
   * Check if the chips in this group are removable or not.
   *
   * @return a boolean, <b>true</b> the chips in this group are removable, <b>false</b> the chips in
   *     this group are not removable
   */
  public boolean isRemovable() {
    return removable;
  }

  /**
   * Set all chips in this group to removable or not based on the provided flag.
   *
   * @param removable a boolean, <b>true</b> set all chips in this group to be removable,
   *     <b>false</b> set all chips in this group to be not removable.
   * @return same ChipsGroup instance
   */
  public ChipsGroup setRemovable(boolean removable) {
    this.removable = removable;
    chips.forEach(chip -> chip.setRemovable(removable));
    return this;
  }
}
