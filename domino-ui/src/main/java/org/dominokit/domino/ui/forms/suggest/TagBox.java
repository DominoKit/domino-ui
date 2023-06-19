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

public class TagBox<V> extends AbstractSuggestBox<V, List<V>, Chip, TagOption<V>, TagBox<V>> {

  private List<TagOption<V>> selectedOptions = new ArrayList<>();
  private boolean removable;

  public static <V> TagBox<V> create(SuggestionsStore<V, Chip, TagOption<V>> store) {
    return new TagBox<>(store);
  }

  public static <V> TagBox<V> create(Function<String, V> inputMapper) {
    return new TagBox<V>(createDefaultStore(inputMapper));
  }

  public static <V> TagBox<V> create(String label, Function<String, V> inputMapper) {
    return new TagBox<V>(label, createDefaultStore(inputMapper));
  }

  public static <V> TagBox<V> create(String label, SuggestionsStore<V, Chip, TagOption<V>> store) {
    return new TagBox<>(label, store);
  }

  private static <V> LocalSuggestionsStore<V, Chip, TagOption<V>> createDefaultStore(
      Function<String, V> inputMapper) {
    return new LocalSuggestionsStore<V, Chip, TagOption<V>>()
        .setMissingHandlers(
            missingValue -> Optional.of(TagOption.create(missingValue)),
            inputValue ->
                Optional.ofNullable(inputMapper.apply(inputValue)).map(TagOption::create));
  }

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

  public TagBox(String label, SuggestionsStore<V, Chip, TagOption<V>> store) {
    this(store);
    setLabel(label);
  }

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

  public TagBox<V> setRemovable(boolean removable) {
    this.selectedOptions.forEach(option -> option.setRemovable(removable));
    this.removable = removable;
    return this;
  }

  public boolean isRemovable() {
    return removable;
  }

  @Override
  public List<V> getValue() {
    return selectedOptions.stream().map(TagOption::getValue).collect(Collectors.toList());
  }

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

  protected void doSetOption(TagOption<V> option) {
    if (isNull(this.selectedOptions)) {
      this.selectedOptions = new ArrayList<>();
    }
    this.selectedOptions.add(option);
  }

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

  @Override
  protected void onBackspace() {
    if (!selectedOptions.isEmpty()) {
      onOptionDeselected(selectedOptions.get(selectedOptions.size() - 1));
    }
  }

  @Override
  protected void onBeforeApplyMissingOption(TagOption<V> option) {
    option.setRemovable(isRemovable());
  }

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

  @Override
  public TagBox<V> setReadOnly(boolean readOnly) {
    this.getInputElement().setReadOnly(true);
    getSelectedOptions()
        .forEach(
            option -> {
              option.getComponent().setRemovable(!readOnly && isRemovable());
              option.getComponent().setReadOnly(true);
            });
    return super.setReadOnly(readOnly);
  }

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

  public List<TagOption<V>> getSelectedOptions() {
    return new ArrayList<>(selectedOptions);
  }

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
