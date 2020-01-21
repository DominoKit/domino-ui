package org.dominokit.domino.ui.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LocalSuggestBoxStore<T> implements SuggestBoxStore<T> {

    private List<SuggestItem<T>> suggestions;
    private SuggestionFilter<T> suggestionFilter = (searchValue, suggestItem) -> suggestItem.getDisplayValue().toLowerCase().contains(searchValue.toLowerCase());
    private MissingSuggestProvider<T> missingProvider;

    public LocalSuggestBoxStore() {
        this(new ArrayList<>());
    }

    public LocalSuggestBoxStore(MissingSuggestProvider<T> missingProvider) {
        this(new ArrayList<>(), missingProvider);
    }

    public LocalSuggestBoxStore(List<SuggestItem<T>> suggestions) {
        this.suggestions = suggestions;
    }

    public LocalSuggestBoxStore(List<SuggestItem<T>> suggestions, MissingSuggestProvider<T> missingProvider) {
        this.suggestions = suggestions;
        this.missingProvider = missingProvider;
    }

    public static <T> LocalSuggestBoxStore<T> create() {
        return new LocalSuggestBoxStore<>();
    }

    public static <T> LocalSuggestBoxStore<T> create(List<SuggestItem<T>> suggestions) {
        return new LocalSuggestBoxStore<>(suggestions);
    }

    public static <T> LocalSuggestBoxStore<T> create(MissingSuggestProvider<T> missingProvider) {
        return new LocalSuggestBoxStore<T>(missingProvider);
    }

    public static <T> LocalSuggestBoxStore<T> create(List<SuggestItem<T>> suggestions, MissingSuggestProvider<T> missingProvider) {
        return new LocalSuggestBoxStore<>(suggestions, missingProvider);
    }

    public LocalSuggestBoxStore<T> addSuggestion(SuggestItem<T> suggestion) {
        suggestions.add(suggestion);
        return this;
    }

    public LocalSuggestBoxStore<T> addSuggestions(List<SuggestItem<T>> suggestions) {
        this.suggestions.addAll(suggestions);
        return this;
    }

    public LocalSuggestBoxStore<T> setSuggestions(List<SuggestItem<T>> suggestions) {
        this.suggestions = new ArrayList<>(suggestions);
        return this;
    }

    public List<SuggestItem<T>> getSuggestions() {
        return suggestions;
    }

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

    @Override
    public void find(T searchValue, Consumer<SuggestItem<T>> handler) {
        if (isNull(searchValue)) {
            handler.accept(null);
        }
        for (SuggestItem<T> suggestion : suggestions) {
            if (suggestion.getValue().equals(searchValue)) {
                handler.accept(suggestion);
            }
        }
    }

    @Override
    public boolean filterItem(String searchValue, SuggestItem<T> suggestItem) {
        return suggestionFilter.filter(searchValue, suggestItem);
    }

    public SuggestionFilter<T> getSuggestionFilter() {
        return suggestionFilter;
    }

    public LocalSuggestBoxStore<T> setSuggestionFilter(SuggestionFilter<T> suggestionFilter) {
        if (nonNull(suggestionFilter)) {
            this.suggestionFilter = suggestionFilter;
        }
        return this;
    }

    @Override
    public MissingSuggestProvider<T> getMessingSuggestionProvider() {
        return missingProvider;
    }
}
