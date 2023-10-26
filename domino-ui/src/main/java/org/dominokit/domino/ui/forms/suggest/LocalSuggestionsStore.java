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

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import org.dominokit.domino.ui.IsElement;

/**
 * A local suggestions store that can be used for managing and filtering suggestion options.
 *
 * @param <T> The type of data associated with the suggestion options.
 * @param <E> The type of UI element that represents the suggestion options.
 * @param <O> The type of suggestion options.
 */
public class LocalSuggestionsStore<T, E extends IsElement<?>, O extends Option<T, E, O>>
    implements SuggestionsStore<T, E, O> {

  private List<O> suggestions;
  private SuggestionFilter<T, E, O> suggestionFilter =
      (searchValue, suggestItem) -> suggestItem.getMenuItem().onSearch(searchValue, false);
  private MissingSuggestProvider<T, E, O> missingValueProvider;
  private MissingEntryProvider<T, E, O> missingEntryProvider;

  private Function<T, Optional<O>> optionMapper;

  /** Creates an empty {@code LocalSuggestionsStore}. */
  public LocalSuggestionsStore() {
    this(new ArrayList<>());
  }

  /**
   * Creates a {@code LocalSuggestionsStore} with the provided initial suggestions.
   *
   * @param suggestions The initial list of suggestions.
   */
  public LocalSuggestionsStore(List<O> suggestions) {
    this.suggestions = suggestions;
  }

  /**
   * Creates a new empty {@code LocalSuggestionsStore}.
   *
   * @param <T> The type of data associated with the suggestion options.
   * @param <E> The type of UI element that represents the suggestion options.
   * @param <O> The type of suggestion options.
   * @return A new empty {@code LocalSuggestionsStore}.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      LocalSuggestionsStore<T, E, O> create() {
    return new LocalSuggestionsStore<>();
  }

  /**
   * Creates a new {@code LocalSuggestionsStore} with the provided initial suggestions.
   *
   * @param <T> The type of data associated with the suggestion options.
   * @param <E> The type of UI element that represents the suggestion options.
   * @param <O> The type of suggestion options.
   * @param suggestions The initial list of suggestions.
   * @return A new {@code LocalSuggestionsStore} with the provided initial suggestions.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      LocalSuggestionsStore<T, E, O> create(List<O> suggestions) {
    return new LocalSuggestionsStore<>(suggestions);
  }

  /**
   * Creates a new {@code LocalSuggestionsStore} with the provided option mapper function and
   * initial items.
   *
   * @param <T> The type of data associated with the suggestion options.
   * @param <E> The type of UI element that represents the suggestion options.
   * @param <O> The type of suggestion options.
   * @param optionMapper The function to map items to options.
   * @param items The initial items.
   * @return A new {@code LocalSuggestionsStore} with the provided option mapper and initial items.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      LocalSuggestionsStore<T, E, O> create(
          Function<T, Optional<O>> optionMapper, Collection<T> items) {
    LocalSuggestionsStore<T, E, O> store = create(optionMapper);
    store.addItem(items);
    return store;
  }

  /**
   * Creates a new {@code LocalSuggestionsStore} with the provided option mapper function and items.
   *
   * @param <T> The type of data associated with the suggestion options.
   * @param <E> The type of UI element that represents the suggestion options.
   * @param <O> The type of suggestion options.
   * @param optionMapper The function to map items to options.
   * @param items The initial items.
   * @return A new {@code LocalSuggestionsStore} with the provided option mapper and items.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      LocalSuggestionsStore<T, E, O> create(Function<T, Optional<O>> optionMapper, T... items) {
    return create(optionMapper, Arrays.asList(items));
  }

  /**
   * Creates a new {@code LocalSuggestionsStore} with the provided option mapper function.
   *
   * @param <T> The type of data associated with the suggestion options.
   * @param <E> The type of UI element that represents the suggestion options.
   * @param <O> The type of suggestion options.
   * @param optionMapper The function to map items to options.
   * @return A new {@code LocalSuggestionsStore} with the provided option mapper.
   */
  public static <T, E extends IsElement<?>, O extends Option<T, E, O>>
      LocalSuggestionsStore<T, E, O> create(Function<T, Optional<O>> optionMapper) {
    LocalSuggestionsStore<T, E, O> store = new LocalSuggestionsStore<>();
    store.setOptionMapper(optionMapper);
    return store;
  }

  /**
   * Adds a suggestion option to the store.
   *
   * @param suggestion The suggestion option to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addSuggestion(O suggestion) {
    suggestions.add(suggestion);
    return this;
  }

  /**
   * Adds a collection of suggestion options to the store.
   *
   * @param suggestions The collection of suggestion options to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addSuggestions(Collection<O> suggestions) {
    if (nonNull(suggestions)) {
      suggestions.forEach(this::addSuggestion);
    }
    return this;
  }

  /**
   * Adds an array of suggestion options to the store.
   *
   * @param suggestions The array of suggestion options to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addSuggestions(O... suggestions) {
    if (nonNull(suggestions)) {
      addSuggestions(Arrays.asList(suggestions));
    }
    return this;
  }

  /**
   * Adds a list of suggestion options to the store.
   *
   * @param suggestions The list of suggestion options to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addSuggestions(List<O> suggestions) {
    this.suggestions.addAll(suggestions);
    return this;
  }

  /**
   * Removes a suggestion option from the store.
   *
   * @param option The suggestion option to remove.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> removeOption(O option) {
    findOption(option).ifPresent(found -> suggestions.remove(found));
    return this;
  }

  /**
   * Removes a collection of suggestion options from the store.
   *
   * @param options The collection of suggestion options to remove.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> removeOptions(Collection<O> options) {
    options.forEach(this::removeOption);
    return this;
  }

  /**
   * Removes an array of suggestion options from the store.
   *
   * @param options The array of suggestion options to remove.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> removeOptions(O... options) {
    Arrays.asList(options).forEach(this::removeOption);
    return this;
  }

  /**
   * Removes all suggestion options from the store.
   *
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> removeAllOptions() {
    suggestions.forEach(this::removeOption);
    return this;
  }

  /**
   * Finds and returns an optional suggestion option that matches the provided option based on their
   * keys.
   *
   * @param option The suggestion option to find.
   * @return An {@link Optional} containing the found suggestion option if it exists, or an empty
   *     {@link Optional} if not found.
   */
  public Optional<O> findOption(O option) {
    return Optional.ofNullable(option)
        .flatMap(
            vSelectionOption ->
                suggestions.stream()
                    .filter(menuItem -> Objects.equals(option.getKey(), menuItem.getKey()))
                    .findFirst());
  }

  /**
   * Finds a suggestion option by its key.
   *
   * @param key The key to search for.
   * @return An optional containing the suggestion option if found, otherwise an empty optional.
   */
  public Optional<O> findOptionByKey(String key) {
    return suggestions.stream()
        .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
        .findFirst();
  }

  /**
   * Finds a suggestion option by its value.
   *
   * @param value The value to search for.
   * @return An optional containing the suggestion option if found, otherwise an empty optional.
   */
  public Optional<O> findOptionByValue(T value) {
    return suggestions.stream()
        .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
        .findFirst();
  }

  /**
   * Finds a suggestion option by its index.
   *
   * @param index The index to search for.
   * @return An optional containing the suggestion option if found, otherwise an empty optional.
   */
  public Optional<O> findOptionByIndex(int index) {
    if (index < suggestions.size() && index >= 0) {
      return Optional.of(suggestions.get(index));
    }
    return Optional.empty();
  }

  /**
   * Checks if the store contains a suggestion option with the specified key.
   *
   * @param key The key to check.
   * @return {@code true} if the store contains a suggestion option with the key, otherwise {@code
   *     false}.
   */
  public boolean containsKey(String key) {
    return findOptionByKey(key).isPresent();
  }

  /**
   * Checks if the store contains a suggestion option with the specified value.
   *
   * @param value The value to check.
   * @return {@code true} if the store contains a suggestion option with the value, otherwise {@code
   *     false}.
   */
  public boolean containsValue(T value) {
    return findOptionByValue(value).isPresent();
  }

  /**
   * Sets the suggestions for this store.
   *
   * @param suggestions The list of suggestions to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setSuggestions(List<O> suggestions) {
    this.suggestions = new ArrayList<>(suggestions);
    return this;
  }

  /**
   * Gets the list of suggestions in this store.
   *
   * @return The list of suggestions.
   */
  public List<O> getSuggestions() {
    return suggestions;
  }

  /**
   * Filters the suggestions based on the given search value and invokes the provided {@link
   * SuggestionsHandler} with the filtered suggestions.
   *
   * @param searchValue The search value to filter the suggestions.
   * @param suggestionsHandler The handler to invoke with the filtered suggestions.
   */
  @Override
  public void filter(String searchValue, SuggestionsHandler<T, E, O> suggestionsHandler) {
    List<O> filteredSuggestions = new ArrayList<>();
    for (O suggestion : suggestions) {
      if (filterItem(searchValue, suggestion)) {
        filteredSuggestions.add(suggestion);
      }
    }
    suggestionsHandler.onSuggestionsReady(filteredSuggestions);
  }

  /**
   * Finds a suggestion option by the provided search value and invokes the given handler with the
   * result.
   *
   * @param searchValue The search value to find.
   * @param handler The handler to invoke with the result.
   */
  @Override
  public void find(T searchValue, Consumer<O> handler) {
    if (isNull(searchValue)) {
      handler.accept(null);
    }
    for (O suggestion : suggestions) {
      if (Objects.equals(suggestion.getValue(), searchValue)) {
        handler.accept(suggestion);
        return;
      }
    }
    handler.accept(null);
  }

  /**
   * Filters a suggestion option based on the provided search value.
   *
   * @param searchValue The search value to filter the suggestion option.
   * @param suggestItem The suggestion option to filter.
   * @return {@code true} if the suggestion option should be included in the filtered suggestions,
   *     otherwise {@code false}.
   */
  @Override
  public boolean filterItem(String searchValue, O suggestItem) {
    return suggestionFilter.filter(searchValue, suggestItem);
  }

  /**
   * Gets the suggestion filter used to filter suggestion options.
   *
   * @return The suggestion filter.
   */
  public SuggestionFilter<T, E, O> getSuggestionFilter() {
    return suggestionFilter;
  }

  /**
   * Sets the suggestion filter used to filter suggestion options.
   *
   * @param suggestionFilter The suggestion filter to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setSuggestionFilter(
      SuggestionFilter<T, E, O> suggestionFilter) {
    if (nonNull(suggestionFilter)) {
      this.suggestionFilter = suggestionFilter;
    }
    return this;
  }

  /**
   * Sets the missing suggestion provider for this store.
   *
   * @param missingValueProvider The missing suggestion provider to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setMissingValueProvider(
      MissingSuggestProvider<T, E, O> missingValueProvider) {
    this.missingValueProvider = missingValueProvider;
    return this;
  }

  /**
   * Sets the missing entry provider for this store.
   *
   * @param missingEntryProvider The missing entry provider to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setMissingEntryProvider(
      MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingEntryProvider = missingEntryProvider;
    return this;
  }

  /**
   * Gets the missing suggestion provider for this store. If not set, a default provider that
   * returns an empty optional will be used.
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
   * Gets the missing entry provider for this store. If not set, a default provider that returns an
   * empty optional will be used.
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
   * Sets the option mapper function used to map items to suggestion options.
   *
   * @param optionMapper The option mapper function to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setOptionMapper(Function<T, Optional<O>> optionMapper) {
    this.optionMapper = optionMapper;
    return this;
  }

  /**
   * Adds an item to the store by mapping it to a suggestion option using the option mapper
   * function.
   *
   * @param item The item to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   * @throws IllegalArgumentException If the option mapper is not initialized.
   */
  public LocalSuggestionsStore<T, E, O> addItem(T item) {
    if (isNull(optionMapper)) {
      throw new IllegalArgumentException(
          "Option mapper is not initialized, consider setting an option mapper for the store");
    }
    optionMapper.apply(item).ifPresent(this::addSuggestion);
    return this;
  }

  /**
   * Adds a collection of items to the store by mapping them to suggestion options using the option
   * mapper function.
   *
   * @param items The collection of items to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addItem(Collection<T> items) {
    items.forEach(this::addItem);
    return this;
  }

  /**
   * Adds an array of items to the store by mapping them to suggestion options using the option
   * mapper function.
   *
   * @param items The array of items to add.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> addItem(T... items) {
    addItem(Arrays.asList(items));
    return this;
  }

  /**
   * Sets both the missing suggestion and missing entry providers for this store.
   *
   * @param missingSuggestProvider The missing suggestion provider to set.
   * @param missingEntryProvider The missing entry provider to set.
   * @return This {@code LocalSuggestionsStore} for method chaining.
   */
  public LocalSuggestionsStore<T, E, O> setMissingHandlers(
      MissingSuggestProvider<T, E, O> missingSuggestProvider,
      MissingEntryProvider<T, E, O> missingEntryProvider) {
    this.missingValueProvider = missingSuggestProvider;
    this.missingEntryProvider = missingEntryProvider;

    return this;
  }
}
