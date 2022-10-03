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

import org.checkerframework.checker.units.qual.C;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An implementation of {@link SuggestBoxStore} that provides Suggestion from a local List
 *
 * @param <T> The type of the SuggestBox value
 */
public class LocalSuggestBoxStore<S, T> implements SuggestBoxStore<T> {

    private List<SelectOption<T>> suggestions;
    private SuggestionFilter<T> suggestionFilter =
            (searchValue, suggestItem) ->
                    suggestItem.onSearch(searchValue, false);
    private MissingSuggestProvider<T> missingValueProvider;
    private MissingEntryProvider<T> missingEntryProvider;

    private Function<S, Optional<SelectOption<T>>> optionMapper;

    /**
     * Creates a store initialized with an empty List
     */
    public LocalSuggestBoxStore() {
        this(new ArrayList<>());
    }

    /**
     * Creates a store initialized with a List of Suggestions
     *
     * @param suggestions List of {@link SelectOption}
     */
    public LocalSuggestBoxStore(List<SelectOption<T>> suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * Creates a store initialized with an empty List
     *
     * @param <T> the type of the SuggestBox value
     * @return new store instance
     */
    public static <S, T> LocalSuggestBoxStore<S,T> create() {
        return new LocalSuggestBoxStore<>();
    }

    /**
     * Creates a store initialized with a List of suggestions
     *
     * @param suggestions List of {@link SelectOption}
     * @param <T>         the type of the SuggestBox value
     * @return new store instance
     */
    public static <S, T> LocalSuggestBoxStore<S, T> create(List<SelectOption<T>> suggestions) {
        return new LocalSuggestBoxStore<>(suggestions);
    }

    public static <S, T> LocalSuggestBoxStore<S, T> create(Function<S, Optional<SelectOption<T>>> optionMapper, Collection<S> items) {
        LocalSuggestBoxStore<S, T> store =create(optionMapper);
        store.addItem(items);
        return store;
    }

    public static <S, T> LocalSuggestBoxStore<S, T> create(Function<S, Optional<SelectOption<T>>> optionMapper, S... items) {
        return create(optionMapper, Arrays.asList(items));
    }

    public static <S, T> LocalSuggestBoxStore<S, T> create(Function<S, Optional<SelectOption<T>>> optionMapper) {
        LocalSuggestBoxStore<S, T> store = new LocalSuggestBoxStore<>();
        store.setOptionMapper(optionMapper);
        return store;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestion {@link SelectOption}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> addSuggestion(SelectOption<T> suggestion) {
        suggestions.add(suggestion);
        return this;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestions {@link SelectOption}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> addSuggestions(Collection<SelectOption<T>> suggestions) {
        if(nonNull(suggestions)) {
            suggestions.forEach(this::addSuggestion);
        }
        return this;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestions {@link SelectOption}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> addSuggestions(SelectOption<T>... suggestions) {
        if(nonNull(suggestions)) {
            addSuggestions(Arrays.asList(suggestions));
        }
        return this;
    }

    /**
     * Adds a List of suggestions to the store suggestions
     *
     * @param suggestions List of {@link SelectOption}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> addSuggestions(List<SelectOption<T>> suggestions) {
        this.suggestions.addAll(suggestions);
        return this;
    }

    public LocalSuggestBoxStore<S, T> removeOption(SelectOption<T> option){
        findOption(option).ifPresent(found -> suggestions.remove(found));
        return this;
    }

    public LocalSuggestBoxStore<S, T> removeOptions(Collection<SelectOption<T>> options){
        options.forEach(this::removeOption);
        return this;
    }

    public LocalSuggestBoxStore<S, T> removeOptions(SelectOption<T>... options){
        Arrays.asList(options).forEach(this::removeOption);
        return this;
    }

    public LocalSuggestBoxStore<S, T> removeAllOptions(){
        suggestions.forEach(this::removeOption);
        return this;
    }


    public Optional<SelectOption<T>> findOption(SelectOption<T> option) {
        return Optional.ofNullable(option)
                .flatMap(vSelectionOption -> suggestions
                        .stream()
                        .filter(menuItem -> Objects.equals(option.getKey(), menuItem.getKey()))
                        .findFirst()
                );
    }

    public Optional<SelectOption<T>> findOptionByKey(String key) {
        return suggestions
                .stream()
                .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
                .map(menuItem -> menuItem)
                .findFirst();
    }

    public Optional<SelectOption<T>> findOptionByValue(T value) {
        return suggestions
                .stream()
                .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
                .map(menuItem -> menuItem)
                .findFirst();
    }

    public Optional<SelectOption<T>> findOptionByIndex(int index) {
        if (index < suggestions.size() && index >= 0){
            return Optional.of(suggestions.get(index));
        }
        return Optional.empty();
    }

    public boolean containsKey(String key){
        return findOptionByKey(key).isPresent();
    }

    public boolean containsValue(T value){
        return findOptionByValue(value).isPresent();
    }


    /**
     * replace the store suggestions with the provided List
     *
     * @param suggestions List of new {@link SelectOption}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> setSuggestions(List<SelectOption<T>> suggestions) {
        this.suggestions = new ArrayList<>(suggestions);
        return this;
    }

    /**
     * @return List of {@link SelectOption} in this store
     */
    public List<SelectOption<T>> getSuggestions() {
        return suggestions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void filter(String searchValue, SuggestionsHandler<T> suggestionsHandler) {
        List<SelectOption<T>> filteredSuggestions = new ArrayList<>();
        for (SelectOption<T> suggestion : suggestions) {
            if (filterItem(searchValue, suggestion)) {
                filteredSuggestions.add(suggestion);
            }
        }
        suggestionsHandler.onSuggestionsReady(filteredSuggestions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void find(T searchValue, Consumer<SelectOption<T>> handler) {
        if (isNull(searchValue)) {
            handler.accept(null);
        }
        for (SelectOption<T> suggestion : suggestions) {
            if (Objects.equals(suggestion.getValue(), searchValue)) {
                handler.accept(suggestion);
                return;
            }
        }
        handler.accept(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean filterItem(String searchValue, SelectOption<T> suggestItem) {
        return suggestionFilter.filter(searchValue, suggestItem);
    }

    /**
     * @return the {@link SuggestionFilter} used by this store
     */
    public SuggestionFilter<T> getSuggestionFilter() {
        return suggestionFilter;
    }

    /**
     * Set the logic of matching a SuggestItem with the search text
     *
     * @param suggestionFilter {@link SuggestionFilter}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> setSuggestionFilter(SuggestionFilter<T> suggestionFilter) {
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
    public LocalSuggestBoxStore<S, T> setMissingValueProvider(
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
    public LocalSuggestBoxStore<S, T> setMissingEntryProvider(
            MissingEntryProvider<T> missingEntryProvider) {
        this.missingEntryProvider = missingEntryProvider;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingSuggestProvider<T> getMessingSuggestionProvider() {
        if (isNull(missingValueProvider)) {
            return missingValue -> Optional.empty();
        }
        return missingValueProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingEntryProvider<T> getMessingEntryProvider() {
        if (isNull(missingEntryProvider)) {
            return inputValue -> Optional.empty();
        }
        return missingEntryProvider;
    }

    public LocalSuggestBoxStore<S, T> setOptionMapper(Function<S, Optional<SelectOption<T>>> optionMapper){
        this.optionMapper = optionMapper;
        return this;
    }

    public LocalSuggestBoxStore<S, T> addItem(S item){
        if(isNull(optionMapper)){
            throw new IllegalArgumentException("Option mapper is not initialized, consider setting an option mapper for the store");
        }
        optionMapper.apply(item).ifPresent(this::addSuggestion);
        return this;
    }

    public LocalSuggestBoxStore<S, T> addItem(Collection<S> items){
        items.forEach(this::addItem);
        return this;
    }

    public LocalSuggestBoxStore<S, T> addItem(S... items){
        addItem(Arrays.asList(items));
        return this;
    }

    /**
     * A shortcut method to set bot the MissingSuggestProvider and MissingEntryProvider
     *
     * @param missingSuggestProvider {@link MissingSuggestProvider}
     * @param missingEntryProvider   {@link MissingEntryProvider}
     * @return same store instance
     */
    public LocalSuggestBoxStore<S, T> setMissingHandlers(
            MissingSuggestProvider<T> missingSuggestProvider,
            MissingEntryProvider<T> missingEntryProvider) {
        this.missingValueProvider = missingSuggestProvider;
        this.missingEntryProvider = missingEntryProvider;

        return this;
    }
}
