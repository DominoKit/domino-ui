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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An implementation of {@link SuggestBoxStore} that provides Suggestion from a local List
 *
 * @param <T> The type of the SuggestBox value
 */
public class LocalSuggestBoxStore<T> implements SuggestBoxStore<T> {

  private List<SuggestItem<T>> suggestions;
  private SuggestionFilter<T> suggestionFilter =
      (searchValue, suggestItem) ->
          suggestItem.getDisplayValue().toLowerCase().contains(searchValue.toLowerCase());
  private MissingSuggestProvider<T> missingValueProvider;
  private MissingEntryProvider<T> missingEntryProvider;

  /** Creates a store initialized with an empty List */
  public LocalSuggestBoxStore() {
    this(new ArrayList<>());
  }

  /**
   * Creates a store initialized with a List of Suggestions
   *
   * @param suggestions List of {@link SuggestItem}
   */
  public LocalSuggestBoxStore(List<SuggestItem<T>> suggestions) {
    this.suggestions = suggestions;
  }

  /**
   * Creates a store initialized with an empty List
   *
   * @param <T> the type of the SuggestBox value
   * @return new store instance
   */
  public static <T> LocalSuggestBoxStore<T> create() {
    return new LocalSuggestBoxStore<>();
  }

  /**
   * Creates a store initialized with a List of suggestions
   *
   * @param suggestions List of {@link SuggestItem}
   * @param <T> the type of the SuggestBox value
   * @return new store instance
   */
  public static <T> LocalSuggestBoxStore<T> create(List<SuggestItem<T>> suggestions) {
    return new LocalSuggestBoxStore<>(suggestions);
  }

  /**
   * Adds a suggestion the suggestions List
   *
   * @param suggestion {@link SuggestItem}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> addSuggestion(SuggestItem<T> suggestion) {
    suggestions.add(suggestion);
    return this;
  }

  /**
   * Adds a List of suggestions to the store suggestions
   *
   * @param suggestions List of {@link SuggestItem}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> addSuggestions(List<SuggestItem<T>> suggestions) {
    this.suggestions.addAll(suggestions);
    return this;
  }

  /**
   * replace the store suggestions with the provided List
   *
   * @param suggestions List of new {@link SuggestItem}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> setSuggestions(List<SuggestItem<T>> suggestions) {
    this.suggestions = new ArrayList<>(suggestions);
    return this;
  }

  /** @return List of {@link SuggestItem} in this store */
  public List<SuggestItem<T>> getSuggestions() {
    return suggestions;
  }

  /** {@inheritDoc} */
  @Override
  public void filter(String searchValue, SuggestionsHandler<T> suggestionsHandler) {
    List<SuggestItem<T>> filteredSuggestions = new ArrayList<>();
    for (SuggestItem<T> suggestion : suggestions) {
      if (filterItem(searchValue, suggestion)) {
        filteredSuggestions.add(suggestion);
      }
    }
    suggestionsHandler.onSuggestionsReady(filteredSuggestions);
  }

  /** {@inheritDoc} */
  @Override
  public void find(T searchValue, Consumer<SuggestItem<T>> handler) {
    if (isNull(searchValue)) {
      handler.accept(null);
    }
    for (SuggestItem<T> suggestion : suggestions) {
      if (suggestion.getValue().equals(searchValue)) {
        handler.accept(suggestion);
        return;
      }
    }
    handler.accept(null);
  }

  /** {@inheritDoc} */
  @Override
  public boolean filterItem(String searchValue, SuggestItem<T> suggestItem) {
    return suggestionFilter.filter(searchValue, suggestItem);
  }

  /** @return the {@link SuggestionFilter} used by this store */
  public SuggestionFilter<T> getSuggestionFilter() {
    return suggestionFilter;
  }

  /**
   * Set the logic of matching a SuggestItem with the search text
   *
   * @param suggestionFilter {@link SuggestionFilter}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> setSuggestionFilter(SuggestionFilter<T> suggestionFilter) {
    if (nonNull(suggestionFilter)) {
      this.suggestionFilter = suggestionFilter;
    }
    return this;
  }

  /**
   * sets the missing suggestion provider for this store
   *
   * @param missingValueProvider {@link MissingSuggestProvider}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> setMissingValueProvider(
      MissingSuggestProvider<T> missingValueProvider) {
    this.missingValueProvider = missingValueProvider;
    return this;
  }

  /**
   * Sets the missing entry provider to be used by this store
   *
   * @param missingEntryProvider {@link MissingEntryProvider}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> setMissingEntryProvider(
      MissingEntryProvider<T> missingEntryProvider) {
    this.missingEntryProvider = missingEntryProvider;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public MissingSuggestProvider<T> getMessingSuggestionProvider() {
    if (isNull(missingEntryProvider)) {
      return missingValue -> Optional.empty();
    }
    return missingValueProvider;
  }

  /** {@inheritDoc} */
  @Override
  public MissingEntryProvider<T> getMessingEntryProvider() {
    if (isNull(missingEntryProvider)) {
      return inputValue -> Optional.empty();
    }
    return missingEntryProvider;
  }

  /**
   * A shortcut method to set bot the MissingSuggestProvider and MissingEntryProvider
   *
   * @param missingSuggestProvider {@link MissingSuggestProvider}
   * @param missingEntryProvider {@link MissingEntryProvider}
   * @return same store instance
   */
  public LocalSuggestBoxStore<T> setMissingHandlers(
      MissingSuggestProvider<T> missingSuggestProvider,
      MissingEntryProvider<T> missingEntryProvider) {
    this.missingValueProvider = missingSuggestProvider;
    this.missingEntryProvider = missingEntryProvider;

    return this;
  }
}
