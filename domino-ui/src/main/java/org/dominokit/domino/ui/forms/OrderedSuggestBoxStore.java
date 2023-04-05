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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * An implementation of {@link SuggestBoxStore} that provides Suggestion from a local List
 *
 * @param <T> The type of the SuggestBox value
 */
public class OrderedSuggestBoxStore<T, S extends Option<T>> implements SuggestBoxStore<T, S> {

    private final Map<String, S> suggestions = new TreeMap<>();
    private SuggestionFilter<T, S> suggestionFilter =
            (searchValue, suggestItem) -> suggestItem.onSearch(searchValue, false);
    private MissingSuggestProvider<T, S> missingValueProvider;
    private MissingEntryProvider<T, S> missingEntryProvider;

    private Function<T, Optional<S>> optionMapper;

    /**
     * Creates a store initialized with an empty List
     */
    public OrderedSuggestBoxStore() {
        this(new ArrayList<>());
    }

    /**
     * Creates a store initialized with a List of Suggestions
     *
     * @param suggestions List of {@link Option}
     */
    public OrderedSuggestBoxStore(Collection<S> suggestions) {
        suggestions.forEach(s -> this.suggestions.put(s.getKey(), s));
    }

    /**
     * Creates a store initialized with an empty List
     *
     * @param <T> the type of the SuggestBox value
     * @return new store instance
     */
    public static <T, S extends Option<T>> OrderedSuggestBoxStore<T, S> create() {
        return new OrderedSuggestBoxStore<>();
    }

    /**
     * Creates a store initialized with a List of suggestions
     *
     * @param suggestions List of {@link Option}
     * @param <T>         the type of the SuggestBox value
     * @return new store instance
     */
    public static <T, S extends Option<T>> OrderedSuggestBoxStore<T, S> create(List<S> suggestions) {
        return new OrderedSuggestBoxStore<>(suggestions);
    }

    public static <T, S extends Option<T>> OrderedSuggestBoxStore<T, S> create(
            Function<T, Optional<S>> optionMapper, Collection<T> items) {
        OrderedSuggestBoxStore<T, S> store = create(optionMapper);
        store.addItem(items);
        return store;
    }

    public static <T, S extends Option<T>> OrderedSuggestBoxStore<T, S> create(
            Function<T, Optional<S>> optionMapper, T... items) {
        return create(optionMapper, Arrays.asList(items));
    }

    public static <T, S extends Option<T>> OrderedSuggestBoxStore<T, S> create(
            Function<T, Optional<S>> optionMapper) {
        OrderedSuggestBoxStore<T, S> store = new OrderedSuggestBoxStore<>();
        store.setOptionMapper(optionMapper);
        return store;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestion {@link Option}
     * @return same store instance
     */
    public OrderedSuggestBoxStore<T, S> addSuggestion(S suggestion) {
        suggestions.put(suggestion.getKey(), suggestion);
        return this;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestions {@link Option}
     * @return same store instance
     */
    public OrderedSuggestBoxStore<T, S> addSuggestions(Collection<S> suggestions) {
        if (nonNull(suggestions)) {
            suggestions.forEach(this::addSuggestion);
        }
        return this;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestions {@link Option}
     * @return same store instance
     */
    @SafeVarargs
    public final OrderedSuggestBoxStore<T, S> addSuggestions(S... suggestions) {
        if (nonNull(suggestions)) {
            addSuggestions(Arrays.asList(suggestions));
        }
        return this;
    }

    public OrderedSuggestBoxStore<T, S> removeOption(S option) {
        findOption(option).ifPresent(found -> suggestions.remove(found.getKey()));
        return this;
    }

    public OrderedSuggestBoxStore<T, S> removeOptions(Collection<S> options) {
        options.forEach(this::removeOption);
        return this;
    }

    @SafeVarargs
    public final OrderedSuggestBoxStore<T, S> removeOptions(S... options) {
        Arrays.asList(options).forEach(this::removeOption);
        return this;
    }

    public OrderedSuggestBoxStore<T, S> removeAllOptions() {
        suggestions.values().forEach(this::removeOption);
        return this;
    }

    public Optional<S> findOption(S option) {
        return Optional.ofNullable(option)
                .flatMap(o -> Optional.ofNullable(suggestions.get(o.getKey())));
    }

    public Optional<S> findOptionByKey(String key) {
        return Optional.ofNullable(suggestions.get(key));
    }

    public Optional<S> findOptionByValue(T value) {
        return suggestions.values()
                .stream()
                .filter(option -> Objects.equals(value, option.getValue()))
                .findFirst();
    }

    public boolean containsKey(String key) {
        return this.suggestions.containsKey(key);
    }

    public boolean containsValue(T value) {
        return findOptionByValue(value).isPresent();
    }

    /**
     * replace the store suggestions with the provided List
     *
     * @param suggestions List of new {@link Option}
     * @return same store instance
     */
    public OrderedSuggestBoxStore<T, S> setSuggestions(Collection<S> suggestions) {
        this.suggestions.clear();
       addSuggestions(suggestions);
        return this;
    }

    /**
     * @return Map of {@link Option} in this store
     */
    public Map<String, S> getSuggestions() {
        return suggestions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void filter(String searchValue, SuggestionsHandler<T, S> suggestionsHandler) {
        List<S> filteredSuggestions = new ArrayList<>();
        for (S suggestion : suggestions.values()) {
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
    public void find(T searchValue, Consumer<S> handler) {
        if (isNull(searchValue)) {
            handler.accept(null);
        }
        for (S suggestion : suggestions.values()) {
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
    public boolean filterItem(String searchValue, S suggestItem) {
        return suggestionFilter.filter(searchValue, suggestItem);
    }

    /**
     * @return the {@link SuggestionFilter} used by this store
     */
    public SuggestionFilter<T, S> getSuggestionFilter() {
        return suggestionFilter;
    }

    /**
     * Set the logic of matching a SuggestItem with the search text
     *
     * @param suggestionFilter {@link SuggestionFilter}
     * @return same store instance
     */
    public OrderedSuggestBoxStore<T, S> setSuggestionFilter(SuggestionFilter<T, S> suggestionFilter) {
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
    public OrderedSuggestBoxStore<T, S> setMissingValueProvider(
            MissingSuggestProvider<T, S> missingValueProvider) {
        this.missingValueProvider = missingValueProvider;
        return this;
    }

    /**
     * Sets the missing entry provider to be used by this store
     *
     * @param missingEntryProvider {@link MissingEntryProvider}
     * @return same store instance
     */
    public OrderedSuggestBoxStore<T, S> setMissingEntryProvider(
            MissingEntryProvider<T, S> missingEntryProvider) {
        this.missingEntryProvider = missingEntryProvider;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingSuggestProvider<T, S> getMessingSuggestionProvider() {
        if (isNull(missingValueProvider)) {
            return missingValue -> Optional.empty();
        }
        return missingValueProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingEntryProvider<T, S> getMessingEntryProvider() {
        if (isNull(missingEntryProvider)) {
            return inputValue -> Optional.empty();
        }
        return missingEntryProvider;
    }

    public OrderedSuggestBoxStore<T, S> setOptionMapper(Function<T, Optional<S>> optionMapper) {
        this.optionMapper = optionMapper;
        return this;
    }

    public OrderedSuggestBoxStore<T, S> addItem(T item) {
        if (isNull(optionMapper)) {
            throw new IllegalArgumentException(
                    "Option mapper is not initialized, consider setting an option mapper for the store");
        }
        optionMapper.apply(item).ifPresent(this::addSuggestion);
        return this;
    }

    public OrderedSuggestBoxStore<T, S> addItem(Collection<T> items) {
        items.forEach(this::addItem);
        return this;
    }

    public OrderedSuggestBoxStore<T, S> addItem(T... items) {
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
    public OrderedSuggestBoxStore<T, S> setMissingHandlers(
            MissingSuggestProvider<T, S> missingSuggestProvider,
            MissingEntryProvider<T, S> missingEntryProvider) {
        this.missingValueProvider = missingSuggestProvider;
        this.missingEntryProvider = missingEntryProvider;

        return this;
    }
}
