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
package org.dominokit.domino.ui.forms.suggest;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.forms.FormsStyles;

/**
 * A versatile input field that allows users to select multiple tags from a list of suggestions.
 *
 * @param <V> The type of data associated with the selected tags.
 */
public class TagBox<V> extends AbstractSuggestBox<V, List<V>, Chip, TagOption<V>, TagBox<V>> {

  private List<TagOption<V>> selectedOptions = new ArrayList<>();
  private boolean removable;

  /**
   * Creates a new instance of TagBox with the provided SuggestionsStore.
   *
   * @param store The SuggestionsStore that provides suggestions for this TagBox.
   * @return A new instance of TagBox.
   */
  public static <V> TagBox<V> create(SuggestionsStore<V, Chip, TagOption<V>> store) {
    return new TagBox<>(store);
  }

  /**
   * Creates a new instance of TagBox with a default input mapper.
   *
   * @param inputMapper A function to map input strings to tag values.
   * @return A new instance of TagBox.
   */
  public static <V> TagBox<V> create(Function<String, V> inputMapper) {
    return new TagBox<V>(createDefaultStore(inputMapper));
  }

  /**
   * Creates a new instance of TagBox with a label and a default input mapper.
   *
   * @param label The label to display for the TagBox.
   * @param inputMapper A function to map input strings to tag values.
   * @return A new instance of TagBox.
   */
  public static <V> TagBox<V> create(String label, Function<String, V> inputMapper) {
    return new TagBox<V>(label, createDefaultStore(inputMapper));
  }

  /**
   * Creates a new instance of TagBox with a label and the provided SuggestionsStore.
   *
   * @param label The label to display for the TagBox.
   * @param store The SuggestionsStore that provides suggestions for this TagBox.
   * @return A new instance of TagBox.
   */
  public static <V> TagBox<V> create(String label, SuggestionsStore<V, Chip, TagOption<V>> store) {
    return new TagBox<>(label, store);
  }

  /**
   * Creates a default SuggestionsStore for TagBox using the provided input mapper.
   *
   * @param inputMapper A function to map input strings to tag values.
   * @return A default SuggestionsStore for TagBox.
   */
  private static <V> LocalSuggestionsStore<V, Chip, TagOption<V>> createDefaultStore(
      Function<String, V> inputMapper) {
    return new LocalSuggestionsStore<V, Chip, TagOption<V>>()
        .setMissingHandlers(
            missingValue -> Optional.of(TagOption.create(missingValue)),
            inputValue ->
                Optional.ofNullable(inputMapper.apply(inputValue)).map(TagOption::create));
  }

  /**
   * Creates a new instance of TagBox with the provided SuggestionsStore.
   *
   * @param store The SuggestionsStore that provides suggestions for this TagBox.
   */
  public TagBox(SuggestionsStore<V, Chip, TagOption<V>> store) {
    super(store);
    optionsMenu.addOnAddItemHandler(
        (menu, menuItem) -> {
          OptionMeta.<V, Chip, TagOption<V>>get(menuItem)
              .ifPresent(
                  meta -> {
                    meta.getComponent().setRemovable(this.isRemovable()).setSelectable(false);
                  });
        });
    fieldInput.addCss(FormsStyles.dui_form_tags_input);
  }

  /**
   * Creates a new instance of TagBox with a label and the provided SuggestionsStore.
   *
   * @param label The label to display for the TagBox.
   * @param store The SuggestionsStore that provides suggestions for this TagBox.
   */
  public TagBox(String label, SuggestionsStore<V, Chip, TagOption<V>> store) {
    this(store);
    setLabel(label);
  }

  /**
   * Sets the value of the TagBox using a list of values.
   *
   * @param values The list of tag values to set as selected options.
   */
  @Override
  protected void doSetValue(List<V> values) {
    clearValue(false);
    values.forEach(
        value -> {
          store.find(
              value,
              option -> {
                if (isNull(option)) {
                  store
                      .getMessingSuggestionProvider()
                      .getMessingSuggestion(value)
                      .ifPresent(
                          o -> {
                            o.getComponent().setRemovable(isRemovable());
                            applyOptionValue(o);
                          });
                } else {
                  option.getComponent().setRemovable(isRemovable());
                  applyOptionValue(option);
                }
              });
        });
  }

  /**
   * Sets whether the tags are removable.
   *
   * @param removable true to allow removing tags, false otherwise.
   * @return The updated TagBox instance.
   */
  public TagBox<V> setRemovable(boolean removable) {
    this.selectedOptions.forEach(option -> option.setRemovable(removable));
    this.removable = removable;
    return this;
  }

  /**
   * Checks if tags are removable.
   *
   * @return true if tags are removable, false otherwise.
   */
  public boolean isRemovable() {
    return removable;
  }

  /**
   * Retrieves the list of selected tag values.
   *
   * @return The list of selected tag values.
   */
  @Override
  public List<V> getValue() {
    return selectedOptions.stream().map(TagOption::getValue).collect(Collectors.toList());
  }

  /**
   * Handles the selection of a tag option.
   *
   * @param option The tag option that was selected.
   */
  @Override
  public void onOptionSelected(TagOption<V> option) {
    if (nonNull(this.selectedOptions) && this.selectedOptions.contains(option)) {
      return;
    }
    List<V> oldValue = getValue();
    if (isNull(oldValue) || !oldValue.contains(option.getValue())) {
      doSetOption(option);
      fieldInput.appendChild(option);
      if (!isChangeListenersPaused()) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    option.bindTo(this);
  }

  /**
   * Adds a tag option to the TagBox.
   *
   * @param option The tag option to add.
   * @return The updated TagBox instance.
   */
  protected void doSetOption(TagOption<V> option) {
    if (isNull(this.selectedOptions)) {
      this.selectedOptions = new ArrayList<>();
    }
    this.selectedOptions.add(option);
  }

  /**
   * Handles the deselection of a tag option.
   *
   * @param option The tag option that was deselected.
   */
  @Override
  public void onOptionDeselected(TagOption<V> option) {
    List<V> oldValue = getValue();
    if (nonNull(oldValue) && oldValue.contains(option.getValue())) {
      option.remove();
      this.selectedOptions.remove(option);
      this.optionsMenu.withPauseSelectionListenersToggle(
          true,
          field -> {
            option.getMenuItem().deselect(true);
          });
      if (!isChangeListenersPaused()) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    option.unbindTarget();
  }

  /** Handles the "Backspace" key event. */
  @Override
  protected void onBackspace() {
    if (!selectedOptions.isEmpty()) {
      onOptionDeselected(selectedOptions.get(selectedOptions.size() - 1));
    }
  }

  /**
   * Sets the behavior of a tag option before applying a missing option.
   *
   * @param option The tag option before applying a missing option.
   */
  @Override
  protected void onBeforeApplyMissingOption(TagOption<V> option) {
    option.setRemovable(isRemovable());
  }

  /**
   * Clears the value of the TagBox.
   *
   * @param silent Whether to clear the value silently.
   * @return The updated TagBox instance.
   */
  @Override
  protected TagBox<V> clearValue(boolean silent) {
    if (!selectedOptions.isEmpty()) {
      List<V> oldValue = getValue();
      optionsMenu.withPauseSelectionListenersToggle(
          true,
          field ->
              withPauseValidationsToggle(
                  true, box -> new ArrayList<>(selectedOptions).forEach(this::onOptionDeselected)));

      if (!silent) {
        triggerClearListeners(oldValue);
        triggerChangeListeners(oldValue, getValue());
      }

      if (isAutoValidation()) {
        autoValidate();
      }
    }

    return this;
  }

  /**
   * Sets the read-only state of the TagBox.
   *
   * @param readOnly true` to set the TagBox as read-only, `false` otherwise.
   * @return The updated TagBox instance.
   */
  @Override
  public TagBox<V> setReadOnly(boolean readOnly) {
    this.getInputElement().setReadOnly(readOnly);
    getSelectedOptions()
        .forEach(
            option -> {
              option.getComponent().setRemovable(!readOnly && isRemovable());
              option.getComponent().setReadOnly(readOnly);
            });
    return super.setReadOnly(readOnly);
  }

  /**
   * Sets the disabled state of the TagBox.
   *
   * @param disabled `true` to set the TagBox as disabled, `false` otherwise.
   * @return The updated TagBox instance.
   */
  @Override
  public TagBox<V> setDisabled(boolean disabled) {
    this.getInputElement().setDisabled(disabled);
    this.getSelectedOptions()
        .forEach(
            option -> {
              option.getComponent().setRemovable(!disabled && isRemovable());
              option.getComponent().setDisabled(disabled);
            });
    return super.setDisabled(disabled);
  }

  /**
   * Retrieves a list of selected tag options.
   *
   * @return The list of selected tag options.
   */
  public List<TagOption<V>> getSelectedOptions() {
    return new ArrayList<>(selectedOptions);
  }

  /**
   * Retrieves the string representation of the selected tag values.
   *
   * @return The string representation of the selected tag values.
   */
  @Override
  public String getStringValue() {
    if (nonNull(this.selectedOptions) && !this.selectedOptions.isEmpty()) {
      return this.selectedOptions.stream()
          .map(o -> String.valueOf(o.getValue()))
          .collect(Collectors.joining(","));
    }
    return null;
  }
}
