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

import org.dominokit.domino.ui.IsElement;

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
 * An implementation of {@link SuggestionsStore} that provides Suggestion from a local List
 *
 * @param <T> The type of the SuggestBox value
 */
public class OrderedSuggestionsStore<T, E extends IsElement<?>, O extends Option<T, E, O>> implements SuggestionsStore<T, E, O> {

    private final Map<String, O> suggestions = new TreeMap<>();
    private SuggestionFilter<T, E, O> suggestionFilter =
            (searchValue, suggestItem) -> suggestItem.getMenuItem().onSearch(searchValue, false);
    private MissingSuggestProvider<T, E, O> missingValueProvider;
    private MissingEntryProvider<T, E, O> missingEntryProvider;

    private Function<T, Optional<O>> optionMapper;

    /**
     * Creates a store initialized with an empty List
     */
    public OrderedSuggestionsStore() {
        this(new ArrayList<>());
    }

    /**
     * Creates a store initialized with a List of Suggestions
     *
     * @param suggestions List of {@link Option}
     */
    public OrderedSuggestionsStore(Collection<O> suggestions) {
        suggestions.forEach(s -> this.suggestions.put(s.getKey(), s));
    }

    /**
     * Creates a store initialized with an empty List
     *
     * @param <T> the type of the SuggestBox value
     * @return new store instance
     */
    public static <T, E extends IsElement<?>, O extends Option<T, E, O>> OrderedSuggestionsStore<T, E, O> create() {
        return new OrderedSuggestionsStore<>();
    }

    /**
     * Creates a store initialized with a List of suggestions
     *
     * @param suggestions List of {@link Option}
     * @param <T>         the type of the SuggestBox value
     * @return new store instance
     */
    public static <T, E extends IsElement<?>, O extends Option<T, E, O>> OrderedSuggestionsStore<T, E, O> create(List<O> suggestions) {
        return new OrderedSuggestionsStore<>(suggestions);
    }

    public static <T, E extends IsElement<?>, O extends Option<T, E, O>> OrderedSuggestionsStore<T, E, O> create(
            Function<T, Optional<O>> optionMapper, Collection<T> items) {
        OrderedSuggestionsStore<T, E, O> store = create(optionMapper);
        store.addItem(items);
        return store;
    }

    public static <T, E extends IsElement<?>, O extends Option<T, E, O>> OrderedSuggestionsStore<T, E, O> create(
            Function<T, Optional<O>> optionMapper, T... items) {
        return create(optionMapper, Arrays.asList(items));
    }

    public static <T, E extends IsElement<?>, O extends Option<T, E, O>> OrderedSuggestionsStore<T, E, O> create(
            Function<T, Optional<O>> optionMapper) {
        OrderedSuggestionsStore<T, E, O> store = new OrderedSuggestionsStore<>();
        store.setOptionMapper(optionMapper);
        return store;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestion {@link Option}
     * @return same store instance
     */
    public OrderedSuggestionsStore<T, E, O> addSuggestion(O suggestion) {
        suggestions.put(suggestion.getKey(), suggestion);
        return this;
    }

    /**
     * Adds a suggestion the suggestions List
     *
     * @param suggestions {@link Option}
     * @return same store instance
     */
    public OrderedSuggestionsStore<T, E, O> addSuggestions(Collection<O> suggestions) {
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
    public final OrderedSuggestionsStore<T, E, O> addSuggestions(O... suggestions) {
        if (nonNull(suggestions)) {
            addSuggestions(Arrays.asList(suggestions));
        }
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> removeOption(O option) {
        findOption(option).ifPresent(found -> suggestions.remove(found.getKey()));
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> removeOptions(Collection<O> options) {
        options.forEach(this::removeOption);
        return this;
    }

    @SafeVarargs
    public final OrderedSuggestionsStore<T, E, O> removeOptions(O... options) {
        Arrays.asList(options).forEach(this::removeOption);
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> removeAllOptions() {
        suggestions.values().forEach(this::removeOption);
        return this;
    }

    public Optional<O> findOption(O option) {
        return Optional.ofNullable(option)
                .flatMap(o -> Optional.ofNullable(suggestions.get(o.getKey())));
    }

    public Optional<O> findOptionByKey(String key) {
        return Optional.ofNullable(suggestions.get(key));
    }

    public Optional<O> findOptionByValue(T value) {
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
    public OrderedSuggestionsStore<T, E, O> setSuggestions(Collection<O> suggestions) {
        this.suggestions.clear();
       addSuggestions(suggestions);
        return this;
    }

    /**
     * @return Map of {@link Option} in this store
     */
    public Map<String, O> getSuggestions() {
        return suggestions;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public boolean filterItem(String searchValue, O suggestItem) {
        return suggestionFilter.filter(searchValue, suggestItem);
    }

    /**
     * @return the {@link SuggestionFilter} used by this store
     */
    public SuggestionFilter<T, E, O> getSuggestionFilter() {
        return suggestionFilter;
    }

    /**
     * Set the logic of matching a SuggestItem with the search text
     *
     * @param suggestionFilter {@link SuggestionFilter}
     * @return same store instance
     */
    public OrderedSuggestionsStore<T, E, O> setSuggestionFilter(SuggestionFilter<T, E, O> suggestionFilter) {
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
    public OrderedSuggestionsStore<T, E, O> setMissingValueProvider(
            MissingSuggestProvider<T, E, O> missingValueProvider) {
        this.missingValueProvider = missingValueProvider;
        return this;
    }

    /**
     * Sets the missing entry provider to be used by this store
     *
     * @param missingEntryProvider {@link MissingEntryProvider}
     * @return same store instance
     */
    public OrderedSuggestionsStore<T, E, O> setMissingEntryProvider(
            MissingEntryProvider<T, E, O> missingEntryProvider) {
        this.missingEntryProvider = missingEntryProvider;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingSuggestProvider<T, E, O> getMessingSuggestionProvider() {
        if (isNull(missingValueProvider)) {
            return missingValue -> Optional.empty();
        }
        return missingValueProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MissingEntryProvider<T, E, O> getMessingEntryProvider() {
        if (isNull(missingEntryProvider)) {
            return inputValue -> Optional.empty();
        }
        return missingEntryProvider;
    }

    public OrderedSuggestionsStore<T, E, O> setOptionMapper(Function<T, Optional<O>> optionMapper) {
        this.optionMapper = optionMapper;
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> addItem(T item) {
        if (isNull(optionMapper)) {
            throw new IllegalArgumentException(
                    "Option mapper is not initialized, consider setting an option mapper for the store");
        }
        optionMapper.apply(item).ifPresent(this::addSuggestion);
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> addItem(Collection<T> items) {
        items.forEach(this::addItem);
        return this;
    }

    public OrderedSuggestionsStore<T, E, O> addItem(T... items) {
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
    public OrderedSuggestionsStore<T, E, O> setMissingHandlers(
            MissingSuggestProvider<T, E, O> missingSuggestProvider,
            MissingEntryProvider<T, E, O> missingEntryProvider) {
        this.missingValueProvider = missingSuggestProvider;
        this.missingEntryProvider = missingEntryProvider;

        return this;
    }
}
