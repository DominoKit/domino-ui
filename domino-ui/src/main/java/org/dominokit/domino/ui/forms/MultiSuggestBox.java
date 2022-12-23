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
package org.dominokit.domino.ui.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.menu.AbstractMenuItem;

public class MultiSuggestBox<V>
    extends AbstractSuggestBox<V, List<V>, Option<V>, MultiSuggestBox<V>> {

  private List<Option<V>> selectedOptions = new ArrayList<>();

  public static <V> MultiSuggestBox<V> create(SuggestBoxStore<V, Option<V>> store) {
    return new MultiSuggestBox<>(store);
  }

  public static <V> MultiSuggestBox<V> create(String label, SuggestBoxStore<V, Option<V>> store) {
    return new MultiSuggestBox<>(label, store);
  }

  public MultiSuggestBox(SuggestBoxStore<V, Option<V>> store) {
    super(store);
  }

  public MultiSuggestBox(String label, SuggestBoxStore<V, Option<V>> store) {
    super(store);
    setLabel(label);
  }

  @Override
  protected void doSetValue(List<V> values) {
    clearValue(false);
    values.forEach(
        v -> {
          store.find(v, this::applyOptionValue);
        });
  }

  @Override
  public List<V> getValue() {
    return selectedOptions.stream().map(AbstractMenuItem::getValue).collect(Collectors.toList());
  }

  @Override
  protected void onOptionSelected(Option<V> suggestion) {
    selectedOptions.add(suggestion);
  }

  @Override
  protected void onBackspace() {
    if (!selectedOptions.isEmpty()) {
      Option<V> option = selectedOptions.get(selectedOptions.size() - 1);
      option.deselect();
      selectedOptions.remove(option);
    }
  }

  @Override
  public void onApplyMissingOption(Option<V> option) {
    selectedOptions.add(option);
  }

  @Override
  protected MultiSuggestBox<V> clearValue(boolean silent) {
    if (!selectedOptions.isEmpty()) {
      List<V> oldValue = getValue();
      optionsMenu.withPauseSelectionListenersToggle(
          true,
          field -> {
            new ArrayList<>(selectedOptions).forEach(AbstractMenuItem::deselect);
          });

      if (!silent) {
        triggerClearListeners(oldValue);
      }

      if (isAutoValidation()) {
        autoValidate();
      }
    }

    return this;
  }
}
