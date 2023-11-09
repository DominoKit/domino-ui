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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import org.dominokit.domino.ui.IsElement;

/**
 * A suggestions store implementation that maintains ordered suggestions using a map structure. This
 * class allows you to manage and filter suggestions based on search criteria.
 *
 * @param <T> The type of values associated with the suggestions.
 * @param <E> The element type used for suggestions.
 * @param <O> The type of the option element within the store.
 */
public class OrderedSuggestionsStore<T, E extends IsElement<?>, O extends Option<T, E, O>>
    implements SuggestionsStore<T, E, O> {

  private final Map<String, O> suggestions = new TreeMap<>();
  private SuggestionFilter<T, E, O> suggestionFilter =
      (searchValue, suggestItem) -> suggestItem.getMenuItem().onSearch(searchValue, false);
  private MissingSuggestProvider<T, E, O> missingValueProvider;
  private MissingEntryProvider<T, E, O> missingEntryProvider;

  private Function<T, Optional<O>> optionMapper;

  /** Creates an empty OrderedSuggestionsStore. */
  public OrderedSuggestionsStore() {
    this(new ArrayList<>());
  }

  /**
   * Creates an OrderedSuggestionsStore with the specified initial suggestions.
   *
   * @param suggestions The initial collection of suggestions to add to the store.
   */
  public OrderedSuggestionsStore(Collection<O> suggestions) {
    suggestions.forEach(s -> this.suggestions.put(s.getKey(), s));
  }

  /**
   * Creates a new OrderedSuggestionsStore instance.
   *
   * @return A new OrderedSuggestionsStore instance.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      OrderedSuggestionsStore<T, E, O> create() {
    return new OrderedSuggestionsStore<>();
  }

  /**
   * Creates a new OrderedSuggestionsStore instance with the specified suggestions.
   *
   * @param suggestions The initial collection of suggestions to add to the store.
   * @return A new OrderedSuggestionsStore instance with the provided suggestions.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      OrderedSuggestionsStore<T, E, O> create(List<O> suggestions) {
    return new OrderedSuggestionsStore<>(suggestions);
  }

  /**
   * Creates a new OrderedSuggestionsStore instance with an option mapper and a collection of items.
   *
   * @param optionMapper A function to map items to options.
   * @param items The collection of items to add to the store.
   * @return A new OrderedSuggestionsStore instance with the provided option mapper and items.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      OrderedSuggestionsStore<T, E, O> create(
          Function<T, Optional<O>> optionMapper, Collection<T> items) {
    OrderedSuggestionsStore<T, E, O> store = create(optionMapper);
    store.addItem(items);
    return store;
  }

  /**
   * Creates a new OrderedSuggestionsStore instance with an option mapper and an array of items.
   *
   * @param optionMapper A function to map items to options.
   * @param items The array of items to add to the store.
   * @return A new OrderedSuggestionsStore instance with the provided option mapper and items.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      OrderedSuggestionsStore<T, E, O> create(Function<T, Optional<O>> optionMapper, T... items) {
    return create(optionMapper, Arrays.asList(items));
  }

  /**
   * Creates a new OrderedSuggestionsStore instance with an option mapper.
   *
   * @param optionMapper A function to map items to options.
   * @return A new OrderedSuggestionsStore instance with the provided option mapper.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      OrderedSuggestionsStore<T, E, O> create(Function<T, Optional<O>> optionMapper) {
    OrderedSuggestionsStore<T, E, O> store = new OrderedSuggestionsStore<>();
    store.setOptionMapper(optionMapper);
    return store;
  }

  /**
   * Adds a single suggestion to the store. The suggestion is associated with a unique key.
   *
   * @param suggestion The suggestion to add.
   * @return This OrderedSuggestionsStore instance with the added suggestion.
   */
  public OrderedSuggestionsStore<T, E, O> addSuggestion(O suggestion) {
    suggestions.put(suggestion.getKey(), suggestion);
    return this;
  }

  /**
   * Adds a collection of suggestions to the store. Each suggestion in the collection is associated
   * with a unique key.
   *
   * @param suggestions The collection of suggestions to add.
   * @return This OrderedSuggestionsStore instance with the added suggestions.
   */
  public OrderedSuggestionsStore<T, E, O> addSuggestions(Collection<O> suggestions) {
    if (nonNull(suggestions)) {
      suggestions.forEach(this::addSuggestion);
    }
    return this;
  }

  /**
   * Adds an array of suggestions to the store. Each suggestion in the array is associated with a
   * unique key.
   *
   * @param suggestions The array of suggestions to add.
   * @return This OrderedSuggestionsStore instance with the added suggestions.
   */
  @SafeVarargs
  public final OrderedSuggestionsStore<T, E, O> addSuggestions(O... suggestions) {
    if (nonNull(suggestions)) {
      addSuggestions(Arrays.asList(suggestions));
    }
    return this;
  }

  /**
   * Removes a specific option from the store based on its unique key.
   *
   * @param option The option to remove.
   * @return This OrderedSuggestionsStore instance with the specified option removed.
   */
  public OrderedSuggestionsStore<T, E, O> removeOption(O option) {
    findOption(option).ifPresent(found -> suggestions.remove(found.getKey()));
    return this;
  }

  /**
   * Removes a collection of options from the store based on their unique keys.
   *
   * @param options The collection of options to remove.
   * @return This OrderedSuggestionsStore instance with the specified options removed.
   */
  public OrderedSuggestionsStore<T, E, O> removeOptions(Collection<O> options) {
    options.forEach(this::removeOption);
    return this;
  }

  /**
   * Removes an array of options from the store based on their unique keys.
   *
   * @param options The array of options to remove.
   * @return This OrderedSuggestionsStore instance with the specified options removed.
   */
  @SafeVarargs
  public final OrderedSuggestionsStore<T, E, O> removeOptions(O... options) {
    Arrays.asList(options).forEach(this::removeOption);
    return this;
  }

  /**
   * Removes all options from the store.
   *
   * @return This OrderedSuggestionsStore instance with all options removed.
   */
  public OrderedSuggestionsStore<T, E, O> removeAllOptions() {
    suggestions.values().forEach(this::removeOption);
    return this;
  }

  /**
   * Finds an option in the store that matches the provided option by comparing their keys.
   *
   * @param option The option to search for.
   * @return An Optional containing the found option, or empty if not found.
   */
  public Optional<O> findOption(O option) {
    return Optional.ofNullable(option)
        .flatMap(o -> Optional.ofNullable(suggestions.get(o.getKey())));
  }

  /**
   * Finds an option in the store by its unique key.
   *
   * @param key The unique key of the option to find.
   * @return An Optional containing the found option, or empty if not found.
   */
  public Optional<O> findOptionByKey(String key) {
    return Optional.ofNullable(suggestions.get(key));
  }

  /**
   * Finds an option in the store by its associated value.
   *
   * @param value The value to search for.
   * @return An Optional containing the found option, or empty if not found.
   */
  public Optional<O> findOptionByValue(T value) {
    return suggestions.values().stream()
        .filter(option -> Objects.equals(value, option.getValue()))
        .findFirst();
  }

  /**
   * Checks if the store contains an option with the specified key.
   *
   * @param key The unique key to check for.
   * @return `true` if the key exists in the store, `false` otherwise.
   */
  public boolean containsKey(String key) {
    return this.suggestions.containsKey(key);
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
   * Sets the suggestions in the store to the provided collection of suggestions. This operation
   * replaces all existing suggestions in the store.
   *
   * @param suggestions The collection of suggestions to set.
   * @return This OrderedSuggestionsStore instance with the updated suggestions.
   */
  public OrderedSuggestionsStore<T, E, O> setSuggestions(Collection<O> suggestions) {
    this.suggestions.clear();
    addSuggestions(suggestions);
    return this;
  }

  /**
   * Retrieves a map containing all the suggestions in the store, where each suggestion is
   * associated with its unique key.
   *
   * @return A map of suggestions with their keys.
   */
  public Map<String, O> getSuggestions() {
    return suggestions;
  }

  /**
   * Filters the suggestions in the store based on the provided search value and invokes the
   * provided suggestions handler with the filtered suggestions.
   *
   * @param searchValue The search value used for filtering.
   * @param suggestionsHandler The handler to receive the filtered suggestions.
   */
  @Override
  public void filter(String searchValue, SuggestionsHandler<T, E, O> suggestionsHandler) {
    List<O> filteredSuggestions = new ArrayList<>();
    for (O suggestion : suggestions.values()) {
      if (filterItem(searchValue, suggestion)) {
        filteredSuggestions.add(suggestion);
      }
    }
    suggestionsHandler.onSuggestionsReady(filteredSuggestions);
  }

  /**
   * Searches for a suggestion in the store that matches the provided search value and invokes the
   * provided handler with the found suggestion.
   *
   * @param searchValue The search value used for searching.
   * @param handler The handler to receive the found suggestion.
   */
  @Override
  public void find(T searchValue, Consumer<O> handler) {
    if (isNull(searchValue)) {
      handler.accept(null);
    }
    for (O suggestion : suggestions.values()) {
      if (Objects.equals(suggestion.getValue(), searchValue)) {
        handler.accept(suggestion);
        return;
      }
    }
    handler.accept(null);
  }

  /**
   * Filters a single suggestion based on the provided search value using the configured suggestion
   * filter.
   *
   * @param searchValue The search value used for filtering.
   * @param suggestItem The suggestion item to filter.
   * @return `true` if the suggestion passes the filter, `false` otherwise.
   */
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
   * @return This OrderedSuggestionsStore instance with the updated suggestion filter.
   */
  public OrderedSuggestionsStore<T, E, O> setSuggestionFilter(
      SuggestionFilter<T, E, O> suggestionFilter) {
    if (nonNull(suggestionFilter)) {
      this.suggestionFilter = suggestionFilter;
    }
    return this;
  }

  /**
   * Sets the missing value provider for handling missing suggestions.
   *
   * @param missingValueProvider The missing value provider to set.
   * @return This OrderedSuggestionsStore instance with the updated missing value provider.
   */
  public OrderedSuggestionsStore<T, E, O> setMissingValueProvider(
      MissingSuggestProvider<T, E, O> missingValueProvider) {
    this.missingValueProvider = missingValueProvider;
    return this;
  }

  /**
   * Sets the missing entry provider for handling missing entries.
   *
   * @param missingEntryProvider The missing entry provider to set.
   * @return This OrderedSuggestionsStore instance with the updated missing entry provider.
   */
  public OrderedSuggestionsStore<T, E, O> setMissingEntryProvider(
      MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingEntryProvider = missingEntryProvider;
    return this;
  }

  /**
   * Gets the missing suggestion provider, which provides missing suggestions based on missing
   * values.
   *
   * @return The missing suggestion provider.
   */
  @Override
  public MissingSuggestProvider<T, E, O> getMessingSuggestionProvider() {
    if (isNull(missingValueProvider)) {
      return missingValue -> Optional.empty();
    }
    return missingValueProvider;
  }

  /**
   * Gets the missing entry provider, which provides missing entries based on input values.
   *
   * @return The missing entry provider.
   */
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
   * @return This OrderedSuggestionsStore instance with the updated option mapper.
   */
  public OrderedSuggestionsStore<T, E, O> setOptionMapper(Function<T, Optional<O>> optionMapper) {
    this.optionMapper = optionMapper;
    return this;
  }

  /**
   * Adds a single item to the store by applying the option mapper function to it. If the option
   * mapper is not initialized, an IllegalArgumentException is thrown.
   *
   * @param item The item to add.
   * @return This OrderedSuggestionsStore instance with the added suggestion if the mapping was
   *     successful.
   * @throws IllegalArgumentException If the option mapper is not initialized.
   */
  public OrderedSuggestionsStore<T, E, O> addItem(T item) {
    if (isNull(optionMapper)) {
      throw new IllegalArgumentException(
          "Option mapper is not initialized, consider setting an option mapper for the store");
    }
    optionMapper.apply(item).ifPresent(this::addSuggestion);
    return this;
  }

  /**
   * Adds a collection of items to the store by applying the option mapper function to each item.
   *
   * @param items The collection of items to add.
   * @return This OrderedSuggestionsStore instance with the added suggestions if the mapping was
   *     successful for any item.
   */
  public OrderedSuggestionsStore<T, E, O> addItem(Collection<T> items) {
    items.forEach(this::addItem);
    return this;
  }

  /**
   * Adds an array of items to the store by applying the option mapper function to each item.
   *
   * @param items The array of items to add.
   * @return This OrderedSuggestionsStore instance with the added suggestions if the mapping was
   *     successful for any item.
   */
  public OrderedSuggestionsStore<T, E, O> addItem(T... items) {
    addItem(Arrays.asList(items));
    return this;
  }

  /**
   * Sets the missing suggestion and missing entry providers for handling missing suggestions and
   * entries.
   *
   * @param missingSuggestProvider The missing suggestion provider to set.
   * @param missingEntryProvider The missing entry provider to set.
   * @return This OrderedSuggestionsStore instance with the updated missing providers.
   */
  public OrderedSuggestionsStore<T, E, O> setMissingHandlers(
      MissingSuggestProvider<T, E, O> missingSuggestProvider,
      MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingValueProvider = missingSuggestProvider;
    this.missingEntryProvider = missingEntryProvider;

    return this;
  }
}
