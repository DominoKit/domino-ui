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

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;

/**
 * An interface representing a store for managing and filtering suggestions for a suggest box or
 * similar component.
 *
 * @param <T> The type of the suggestion value.
 * @param <E> The type of the suggestion element, typically a DOM element.
 * @param <O> The type of the option representing a suggestion.
 */
public interface SuggestionsStore<T, E extends IsElement<?>, O extends Option<T, E, O>> {

  /**
   * Filters the suggestions based on the provided search value and calls the suggestions handler
   * with the filtered suggestions.
   *
   * @param value The search value to filter the suggestions.
   * @param suggestionsHandler The handler to be called with the filtered suggestions.
   */
  void filter(String value, SuggestionsHandler<T, E, O> suggestionsHandler);

  /**
   * Finds a suggestion based on the provided search value and calls the handler with the found
   * suggestion.
   *
   * @param searchValue The value to search for in the suggestions.
   * @param handler The handler to be called with the found suggestion, if any.
   */
  void find(T searchValue, Consumer<O> handler);

  /**
   * Default method that filters a single suggestion item based on the provided search value.
   *
   * @param searchValue The value to search for.
   * @param suggestItem The suggestion item to filter.
   * @return {@code true} if the suggestion item matches the search value, {@code false} otherwise.
   */
  default boolean filterItem(String searchValue, O suggestItem) {
    return suggestItem.getMenuItem().onSearch(searchValue, false);
  }

  /**
   * Default method to provide a missing suggestion based on the missing value.
   *
   * @return An optional containing the missing suggestion, if available.
   */
  default MissingSuggestProvider<T, E, O> getMessingSuggestionProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * Default method to provide a missing suggestion based on the input value.
   *
   * @return An optional containing the missing suggestion, if available.
   */
  default MissingEntryProvider<T, E, O> getMessingEntryProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * A functional interface for handling suggestions.
   *
   * @param <T> The type of the suggestion value.
   * @param <E> The type of the suggestion element, typically a DOM element.
   * @param <O> The type of the option representing a suggestion.
   */
  @FunctionalInterface
  interface SuggestionsHandler<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * Called when suggestions are ready to be processed.
     *
     * @param suggestions The list of suggestions to be handled.
     */
    void onSuggestionsReady(List<O> suggestions);
  }

  /**
   * A functional interface for filtering suggestions.
   *
   * @param <T> The type of the suggestion value.
   * @param <E> The type of the suggestion element, typically a DOM element.
   * @param <O> The type of the option representing a suggestion.
   */
  @FunctionalInterface
  interface SuggestionFilter<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * Filters a suggestion based on the provided search value.
     *
     * @param searchValue The search value to filter the suggestion.
     * @param suggestItem The suggestion item to be filtered.
     * @return {@code true} if the suggestion item matches the search value, {@code false}
     *     otherwise.
     */
    boolean filter(String searchValue, O suggestItem);
  }

  /**
   * A functional interface for providing a missing suggestion based on a missing value.
   *
   * @param <T> The type of the missing suggestion value.
   * @param <E> The type of the suggestion element, typically a DOM element.
   * @param <O> The type of the option representing a suggestion.
   */
  @FunctionalInterface
  interface MissingSuggestProvider<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * Provides a missing suggestion based on the missing value.
     *
     * @param missingValue The missing value for which to provide a suggestion.
     * @return An optional containing the missing suggestion, if available.
     */
    Optional<O> getMessingSuggestion(T missingValue);
  }

  /**
   * A functional interface for providing a missing suggestion based on an input value.
   *
   * @param <T> The type of the missing suggestion value.
   * @param <E> The type of the suggestion element, typically a DOM element.
   * @param <O> The type of the option representing a suggestion.
   */
  @FunctionalInterface
  interface MissingEntryProvider<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * Provides a missing suggestion based on the input value.
     *
     * @param inputValue The input value for which to provide a suggestion.
     * @return An optional containing the missing suggestion, if available.
     */
    Optional<O> getMessingSuggestion(String inputValue);
  }
}
