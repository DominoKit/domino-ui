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
 * This interface is used to implement data stores to provide a {@link
 * org.dominokit.domino.ui.forms.suggest.SuggestBox} with its suggestion
 *
 * <p>The interface can be used to provide suggestions locally or remotely
 *
 * @param <T> the type of the SuggestBox value
 * @see LocalSuggestionsStore
 * @author vegegoku
 * @version $Id: $Id
 */
public interface SuggestionsStore<T, E extends IsElement<?>, O extends Option<T, E, O>> {

  /**
   * Takes the current typed text in the SuggestBox and provide a List of matching suggestion
   *
   * @param value String text in the SuggestBox
   * @param suggestionsHandler {@link
   *     org.dominokit.domino.ui.forms.suggest.SuggestionsStore.SuggestionsHandler}
   */
  void filter(String value, SuggestionsHandler<T, E, O> suggestionsHandler);

  /**
   * Takes a value of T and find the matching SuggestItem for this value, this is used when we
   * directly set the value to the SuggestBox to check if it is actually still matching an existing
   * suggestion
   *
   * @param searchValue T
   * @param handler Consumer of {@link org.dominokit.domino.ui.forms.suggest.Option}
   */
  void find(T searchValue, Consumer<O> handler);

  /**
   * Defines how to check a single SuggestItem against the search text, default to SuggestItem
   * lowercase display text contains the search text
   *
   * @param searchValue String
   * @param suggestItem {@link org.dominokit.domino.ui.forms.suggest.Option}
   * @return boolean, true if the {@link org.dominokit.domino.ui.forms.suggest.Option} match the
   *     search text
   */
  default boolean filterItem(String searchValue, O suggestItem) {
    return suggestItem.getMenuItem().onSearch(searchValue, false);
  }

  /**
   * getMessingSuggestionProvider.
   *
   * @return the {@link
   *     org.dominokit.domino.ui.forms.suggest.SuggestionsStore.MissingSuggestProvider} to handle
   *     missing suggestions for a value this is default to Optional.empty()
   */
  default MissingSuggestProvider<T, E, O> getMessingSuggestionProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * getMessingEntryProvider.
   *
   * @return the {@link org.dominokit.domino.ui.forms.suggest.SuggestionsStore.MissingEntryProvider}
   *     to handle missing suggestions for a text typed in the SuggestBox this is default to
   *     Optional.empty()
   */
  default MissingEntryProvider<T, E, O> getMessingEntryProvider() {
    return missingValue -> Optional.empty();
  }

  /**
   * A function to provide a List of {@link Option} to the {@link SuggestionsStore#filter(String,
   * SuggestionsHandler)}
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface SuggestionsHandler<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * This should be called once the suggestions are ready to be fed to the SuggestBox
     *
     * @param suggestions List of {@link Option}
     */
    void onSuggestionsReady(List<O> suggestions);
  }

  /** @param <T> The type of the suggest box records */
  @FunctionalInterface
  interface SuggestionFilter<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    boolean filter(String searchValue, O suggestItem);
  }

  /**
   * A function to provide a SuggestItem in case we try to set a value to the suggestBox that does
   * not match any of the possible suggestions
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface MissingSuggestProvider<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * @param missingValue T the value that does not match any suggestion
     * @return Optional of {@link Option}, this could be an inline created suggestion or
     *     Optional.empty(), consider invalidating the field in this case
     */
    Optional<O> getMessingSuggestion(T missingValue);
  }

  /**
   * This method is used to implement the logic to handle the case when the user types in the
   * suggest something that does not match any of the available suggestions
   *
   * @param <T> the type of the SuggestBox value
   */
  @FunctionalInterface
  interface MissingEntryProvider<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    /**
     * @param inputValue String value represent what is typed in the SuggestBox
     * @return Optional SuggestItem, this could an inline created item or an Optional of empty which
     *     in this case will be considered as a null value. also consider invalidating the
     *     SuggestBox if it should return Optional.empty()
     */
    Optional<O> getMessingSuggestion(String inputValue);
  }
}
