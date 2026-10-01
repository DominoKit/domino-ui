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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.dominokit.domino.ui.IsElement;

/**
 * An abstract base class for suggestion stores that provides common functionality for managing and
 * filtering suggestions.
 *
 * @param <T> The type of values associated with the suggestions.
 * @param <E> The element type used for suggestions.
 * @param <O> The type of the option element within the store.
 * @param <S> The type of the store itself, used for method chaining.
 */
public abstract class AbstractSuggestionsStore<
        T,
        E extends IsElement<?>,
        O extends Option<T, E, O>,
        S extends AbstractSuggestionsStore<T, E, O, S>>
    implements SuggestionsStore<T, E, O> {

  protected SuggestionFilter<T, E, O> suggestionFilter =
      (searchValue, suggestItem) -> suggestItem.getMenuItem().onSearch(searchValue, false);
  protected MissingSuggestProvider<T, E, O> missingValueProvider;
  protected MissingEntryProvider<T, E, O> missingEntryProvider;

  protected Function<T, Optional<O>> optionMapper;

  /**
   * @return This store instance.
   */
  protected abstract S getThis();

  /**
   * @return A collection of all suggestions currently in the store.
   */
  protected abstract Collection<O> getSuggestionsCollection();

  /** {@inheritDoc} */
  @Override
  public void filter(String searchValue, SuggestionsHandler<T, E, O> suggestionsHandler) {
    List<O> filteredSuggestions = new ArrayList<>();
    for (O suggestion : getSuggestionsCollection()) {
      if (filterItem(searchValue, suggestion)) {
        filteredSuggestions.add(suggestion);
      }
    }
    suggestionsHandler.onSuggestionsReady(filteredSuggestions);
  }

  /** {@inheritDoc} */
  @Override
  public void find(T searchValue, Consumer<O> handler) {
    if (isNull(searchValue)) {
      handler.accept(null);
      return;
    }
    for (O suggestion : getSuggestionsCollection()) {
      if (Objects.equals(suggestion.getValue(), searchValue)) {
        handler.accept(suggestion);
        return;
      }
    }
    handler.accept(null);
  }

  /** {@inheritDoc} */
  @Override
  public boolean filterItem(String searchValue, O suggestItem) {
    return suggestionFilter.filter(searchValue, suggestItem);
  }

  /**
   * Gets the current suggestion filter used for filtering suggestions in the store.
   *
   * @return The current suggestion filter.
   */
  public SuggestionFilter<T, E, O> getSuggestionFilter() {
    return suggestionFilter;
  }

  /**
   * Sets the suggestion filter used for filtering suggestions in the store. If the provided
   * suggestion filter is not null, it will replace the current filter.
   *
   * @param suggestionFilter The suggestion filter to set.
   * @return This store instance.
   */
  public S setSuggestionFilter(SuggestionFilter<T, E, O> suggestionFilter) {
    if (nonNull(suggestionFilter)) {
      this.suggestionFilter = suggestionFilter;
    }
    return getThis();
  }

  /**
   * Sets the missing value provider for handling missing suggestions.
   *
   * @param missingValueProvider The missing value provider to set.
   * @return This store instance.
   */
  public S setMissingValueProvider(MissingSuggestProvider<T, E, O> missingValueProvider) {
    this.missingValueProvider = missingValueProvider;
    return getThis();
  }

  /**
   * Sets the missing entry provider for handling missing entries.
   *
   * @param missingEntryProvider The missing entry provider to set.
   * @return This store instance.
   */
  public S setMissingEntryProvider(MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingEntryProvider = missingEntryProvider;
    return getThis();
  }

  /** {@inheritDoc} */
  @Override
  public MissingSuggestProvider<T, E, O> getMessingSuggestionProvider() {
    if (isNull(missingValueProvider)) {
      return missingValue -> Optional.empty();
    }
    return missingValueProvider;
  }

  /** {@inheritDoc} */
  @Override
  public MissingEntryProvider<T, E, O> getMessingEntryProvider() {
    if (isNull(missingEntryProvider)) {
      return inputValue -> Optional.empty();
    }
    return missingEntryProvider;
  }

  /**
   * Sets the option mapper function used for mapping input items to suggestion options.
   *
   * @param optionMapper The option mapper function to set.
   * @return This store instance.
   */
  public S setOptionMapper(Function<T, Optional<O>> optionMapper) {
    this.optionMapper = optionMapper;
    return getThis();
  }

  /**
   * Adds a single suggestion to the store.
   *
   * @param suggestion The suggestion to add.
   * @return This store instance.
   */
  public abstract S addSuggestion(O suggestion);

  /**
   * Adds a collection of suggestions to the store.
   *
   * @param suggestions The collection of suggestions to add.
   * @return This store instance.
   */
  public S addSuggestions(Collection<O> suggestions) {
    if (nonNull(suggestions)) {
      new ArrayList<>(suggestions).forEach(this::addSuggestion);
    }
    return getThis();
  }

  /**
   * Adds an array of suggestions to the store.
   *
   * @param suggestions The array of suggestions to add.
   * @return This store instance.
   */
  @SafeVarargs
  public final S addSuggestions(O... suggestions) {
    if (nonNull(suggestions)) {
      addSuggestions(Arrays.asList(suggestions));
    }
    return getThis();
  }

  /**
   * Removes a specific option from the store.
   *
   * @param option The option to remove.
   * @return This store instance.
   */
  public abstract S removeOption(O option);

  /**
   * Removes a collection of options from the store.
   *
   * @param options The collection of options to remove.
   * @return This store instance.
   */
  public S removeOptions(Collection<O> options) {
    new ArrayList<>(options).forEach(this::removeOption);
    return getThis();
  }

  /**
   * Removes an array of options from the store.
   *
   * @param options The array of options to remove.
   * @return This store instance.
   */
  @SafeVarargs
  public final S removeOptions(O... options) {
    Arrays.asList(options).forEach(this::removeOption);
    return getThis();
  }

  /**
   * Removes all options from the store.
   *
   * @return This store instance.
   */
  public S removeAllOptions() {
    new ArrayList<>(getSuggestionsCollection()).forEach(this::removeOption);
    return getThis();
  }

  /**
   * Finds an option in the store by its unique key.
   *
   * @param key The unique key of the option to find.
   * @return An Optional containing the found option, or empty if not found.
   */
  public abstract Optional<O> findOptionByKey(String key);

  /**
   * Finds an option in the store that matches the provided option by comparing their keys.
   *
   * @param option The option to search for.
   * @return An Optional containing the found option, or empty if not found.
   */
  public Optional<O> findOption(O option) {
    return Optional.ofNullable(option).flatMap(o -> findOptionByKey(o.getKey()));
  }

  /**
   * Finds an option in the store by its associated value.
   *
   * @param value The value to search for.
   * @return An Optional containing the found option, or empty if not found.
   */
  public Optional<O> findOptionByValue(T value) {
    return getSuggestionsCollection().stream()
        .filter(option -> Objects.equals(value, option.getValue()))
        .findFirst();
  }

  /**
   * Checks if the store contains an option with the specified key.
   *
   * @param key The unique key to check for.
   * @return true if the key exists in the store, false otherwise.
   */
  public boolean containsKey(String key) {
    return findOptionByKey(key).isPresent();
  }

  /**
   * Checks if the store contains an option with the specified value.
   *
   * @param value The value to check for.
   * @return `true` if the value exists in the store, `false` otherwise.
   */
  public boolean containsValue(T value) {
    return findOptionByValue(value).isPresent();
  }

  /**
   * Adds a single item to the store by applying the option mapper function to it. If the option
   * mapper is not initialized, an IllegalArgumentException is thrown.
   *
   * @param item The item to add.
   * @return This store instance.
   * @throws IllegalArgumentException If the option mapper is not initialized.
   */
  public S addItem(T item) {
    if (isNull(optionMapper)) {
      throw new IllegalArgumentException(
          "Option mapper is not initialized, consider setting an option mapper for the store");
    }
    optionMapper.apply(item).ifPresent(this::addSuggestion);
    return getThis();
  }

  /**
   * Adds a collection of items to the store by applying the option mapper function to each item.
   *
   * @param items The collection of items to add.
   * @return This store instance.
   */
  public S addItem(Collection<T> items) {
    items.forEach(this::addItem);
    return getThis();
  }

  /**
   * Adds an array of items to the store by applying the option mapper function to each item.
   *
   * @param items The array of items to add.
   * @return This store instance.
   */
  @SafeVarargs
  public final S addItem(T... items) {
    addItem(Arrays.asList(items));
    return getThis();
  }

  /**
   * Sets the missing suggestion and missing entry providers for handling missing suggestions and
   * entries.
   *
   * @param missingSuggestProvider The missing suggestion provider to set.
   * @param missingEntryProvider The missing entry provider to set.
   * @return This store instance.
   */
  public S setMissingHandlers(
      MissingSuggestProvider<T, E, O> missingSuggestProvider,
      MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingValueProvider = missingSuggestProvider;
    this.missingEntryProvider = missingEntryProvider;

    return getThis();
  }
}
