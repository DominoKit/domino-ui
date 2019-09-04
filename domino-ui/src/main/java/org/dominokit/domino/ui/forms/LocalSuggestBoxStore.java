package org.dominokit.domino.ui.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

public class LocalSuggestBoxStore<T> implements SuggestBoxStore<T> {

    private List<SuggestItem<T>> suggestions;

    public LocalSuggestBoxStore() {
        this(new ArrayList<>());
    }

    public LocalSuggestBoxStore(List<SuggestItem<T>> suggestions) {
        this.suggestions = suggestions;
    }

    public static <T> LocalSuggestBoxStore<T> create() {
        return new LocalSuggestBoxStore<>();
    }

    public static <T> LocalSuggestBoxStore<T> create(List<SuggestItem<T>> suggestions) {
        return new LocalSuggestBoxStore<>(suggestions);
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
            if (suggestion.getDisplayValue().toLowerCase().contains(searchValue.toLowerCase())) {
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
}
