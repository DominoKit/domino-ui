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

import static java.util.Objects.nonNull;

public class SuggestBox<V> extends AbstractSuggestBox<V, V, Option<V>, SuggestBox<V>> {

  private Option<V> selectedOption;

  public static <V> SuggestBox<V> create(SuggestBoxStore<V, Option<V>> store) {
    return new SuggestBox<>(store);
  }

  public static <V> SuggestBox<V> create(String label, SuggestBoxStore<V, Option<V>> store) {
    return new SuggestBox<>(label, store);
  }

  public SuggestBox(SuggestBoxStore<V, Option<V>> store) {
    super(store);
  }

  public SuggestBox(String label, SuggestBoxStore<V, Option<V>> store) {
    super(store);
    setLabel(label);
  }

  protected void doSetValue(V value) {
    store.find(value, this::applyOptionValue);
  }

  @Override
  public V getValue() {
    if (nonNull(selectedOption)) {
      return selectedOption.getValue();
    }
    return null;
  }

  @Override
  protected void onBackspace() {
    if (nonNull(selectedOption)) {
      selectedOption.deselect();
      selectedOption = null;
    }
  }

  @Override
  protected void onOptionSelected(Option<V> option) {
    if (nonNull(this.selectedOption)) {
      this.selectedOption.deselect(false);
    }
    this.selectedOption = option;
  }

  @Override
  public void onApplyMissingOption(Option<V> option) {
    if (nonNull(this.selectedOption)) {
      this.selectedOption.deselect(false);
    }
    this.selectedOption = option;
  }

  @Override
  protected SuggestBox<V> clearValue(boolean silent) {
    if (nonNull(selectedOption)) {
      V oldValue = getValue();
      withPauseChangeListenersToggle(
          true,
          (field, handler) -> {
            selectedOption.deselect();
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
