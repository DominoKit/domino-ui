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
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;

import java.util.*;

import org.dominokit.domino.ui.utils.*;

/**
 * This component provides a group of {@link Chip} which handles the selection behaviour between
 * them.
 *
 * <p>This component will handle the switching between all the chips configured, so that one chip
 * will be select at one time
 *
 * <p>For example:
 *
 * <pre>
 *     ChipsGroup.create()
 *             .appendChild(Chip.create("Extra small"))
 *             .appendChild(Chip.create("Small"))
 *             .appendChild(Chip.create("Medium"))
 *             .appendChild(Chip.create("Large"))
 *             .appendChild(Chip.create("Extra large"))
 *             .setColorScheme(ColorScheme.TEAL)
 *             .addSelectionHandler(value -> Notification.createInfo("Chip [ " + chipsGroup.getSelectedChip().getValue() + " ] is selected").show())
 * </pre>
 *
 * @see BaseDominoElement
 * @see Chip
 * @see HasSelectionHandler
 * @see HasDeselectionHandler
 * @see AcceptDisable
 */
public class ChipsGroup extends BaseDominoElement<HTMLDivElement, ChipsGroup>
    implements AcceptDisable<ChipsGroup>,
        HasSelectionListeners<ChipsGroup, Chip, List<Chip>> {

  private final DominoElement<HTMLDivElement> root;
  private final List<Chip> chips = new ArrayList<>();
  private final List<Chip> selectedChips = new ArrayList<>();

  private boolean multiSelect = false;
  private boolean removable= false;
  private Set<SelectionListener<? super Chip, ? super List<Chip>>> selectionListeners = new HashSet<>();
  private Set<SelectionListener<? super Chip, ? super List<Chip>>> deselectionListeners = new HashSet<>();
  private boolean selectionListenersPaused = false;


  public ChipsGroup() {
    root = DominoElement.div();
    init(this);
  }

  /** @return new instance */
  public static ChipsGroup create() {
    return new ChipsGroup();
  }

  /**
   * Adds new {@link Chip}
   *
   * <p>This will set the chip as selectable and adds selection/deselection handler to handle the
   * switching between all the chips.
   *
   * @param chip the new {@link Chip} to add
   * @return same instance
   */
  public ChipsGroup appendChild(Chip chip) {
    chip.setSelectable(true);
    chip.setRemovable(removable || chip.isRemovable());
    chip.onDetached(mutationRecord -> {
      if(chip.isSelected()){
        chip.deselect();
      }
    });
    chip.addSelectionListener((source, selection) -> {
      if(!this.selectedChips.isEmpty() && !multiSelect){
        this.selectedChips.forEach(selectedChip-> selectedChip.withPauseSelectionListenersToggle(true, Chip::deselect));
        this.selectedChips.clear();
      }
      source.ifPresent(this.selectedChips::add);
      if(!isSelectionListenersPaused()) {
        triggerSelectionListeners(source.get(), this.selectedChips);
        if(!multiSelect) {
          triggerDeselectionListeners(source.get(), this.selectedChips);
        }
      }
    });

    chip.addDeselectionListener((source, selection) -> {
      source.ifPresent(this.selectedChips::remove);
      if(!isSelectionListenersPaused()) {
        triggerDeselectionListeners(source.get(), this.selectedChips);
      }
    });

    chips.add(chip);
    root.appendChild(chip);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public ChipsGroup enable() {
    chips.forEach(Chip::enable);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public ChipsGroup disable() {
    chips.forEach(Chip::disable);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return chips.stream().allMatch(Chip::isEnabled);
  }

  /** @return The current selected chip */
  public List<Chip> getSelectedChips() {
    return selectedChips;
  }


  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Selects a chip at an {@code index}
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

  /** @return All the chips added to this group */
  public List<Chip> getChips() {
    return chips;
  }

  @Override
  public ChipsGroup pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  @Override
  public ChipsGroup resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  @Override
  public ChipsGroup togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<SelectionListener<? super Chip, ? super List<Chip>>> getSelectionListeners() {
    return selectionListeners;
  }

  @Override
  public Set<SelectionListener<? super Chip, ? super List<Chip>>> getDeselectionListeners() {
    return deselectionListeners;
  }

  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  @Override
  public ChipsGroup triggerSelectionListeners(Chip source, List<Chip> selection) {
    selectionListeners.forEach(selectionListener -> selectionListener.onSelectionSelection(Optional.ofNullable(source), selection));
    return this;
  }

  @Override
  public ChipsGroup triggerDeselectionListeners(Chip source, List<Chip> selection) {
    deselectionListeners.forEach(selectionListener -> selectionListener.onSelectionSelection(Optional.ofNullable(source), selection));
    return this;
  }

  @Override
  public List<Chip> getSelection() {
    return selectedChips;
  }

  public boolean isMultiSelect() {
    return multiSelect;
  }

  public ChipsGroup setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    if(!multiSelect && this.selectedChips.size() > 1){
      Chip chip = selectedChips.get(0);
      chip.select();
    }
    return this;
  }

  public boolean isRemovable() {
    return removable;
  }

  public ChipsGroup setRemovable(boolean removable) {
    this.removable = removable;
    chips.forEach(chip -> chip.setRemovable(removable));
    return this;
  }
}
