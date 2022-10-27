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

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * This interface is used to implement data stores to provide a {@link SuggestBox} with its
 * suggestion
 *
 * <p>The interface can be used to provide suggestions locally or remotely
 *
 * @param <T> the type of the SuggestBox value
 * @see LocalSuggestBoxStore
 */
public interface SuggestBoxStore<T, S extends Option<T>> {

  /**
   * Takes the current typed text in the SuggestBox and provide a List of matching suggestion
   *
   * @param value String text in the SuggestBox
   * @param suggestionsHandler {@link SuggestionsHandler}
   */
  void filter(String value, SuggestionsHandler<T, S> suggestionsHandler);

  /**
   * Takes a value of T and find the matching SuggestItem for this value, this is used when we
   * directly set the value to the SuggestBox to check if it is actually still matching an existing
   * suggestion
   *
   * @param searchValue T
   * @param handler Consumer of {@link Option}
   */
  void find(T searchValue, Consumer<S> handler);

  /**
   * Defines how to check a single SuggestItem against the search text, default to SuggestItem
   * lowercase display text contains the search text
   *
   * @param searchValue String
   * @param suggestItem {@link Option}
   * @return boolean, true if the {@link Option} match the search text
   */
  default boolean filterItem(String searchValue, S suggestItem) {
    return suggestItem.onSearch(searchValue, false);
  }

  /**
   * @return the {@link MissingSuggestProvider} to handle missing suggestions for a value this is
   *     default to Optional.empty()
   */
  default MissingSuggestProvider<T, S> getMessingSuggestionProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * @return the {@link MissingEntryProvider} to handle missing suggestions for a text typed in the
   *     SuggestBox this is default to Optional.empty()
   */
  default MissingEntryProvider<T, S> getMessingEntryProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * A function to provide a List of {@link Option} to the {@link
   * SuggestBoxStore#filter(String, SuggestionsHandler)}
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface SuggestionsHandler<T, S extends Option<T>> {
    /**
     * This should be called once the suggestions are ready to be fed to the SuggestBox
     *
     * @param suggestions List of {@link Option}
     */
    void onSuggestionsReady(List<S> suggestions);
  }

  /** @param <T> The type of the suggest box records */
  @FunctionalInterface
  interface SuggestionFilter<T, S extends Option<T>> {
    boolean filter(String searchValue, S suggestItem);
  }

  /**
   * A function to provide a SuggestItem in case we try to set a value to the suggestBox that does
   * not match any of the possible suggestions
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface MissingSuggestProvider<T, S extends Option<T>> {
    /**
     * @param missingValue T the value that does not match any suggestion
     * @return Optional of {@link Option}, this could be an inline created suggestion or
     *     Optional.empty(), consider invalidating the field in this case
     */
    Optional<S> getMessingSuggestion(T missingValue);
  }

  /**
   * This method is used to implement the logic to handle the case when the user types in the
   * suggest something that does not match any of the available suggestions
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface MissingEntryProvider<T, S extends Option<T>> {
    /**
     * @param inputValue String value represent what is typed in the SuggestBox
     * @return Optional SuggestItem, this could an inline created item or an Optional of empty which
     *     in this case will be considered as a null value. also consider invalidating the
     *     SuggestBox if it should return Optional.empty()
     */
    Optional<S> getMessingSuggestion(String inputValue);
  }
}
