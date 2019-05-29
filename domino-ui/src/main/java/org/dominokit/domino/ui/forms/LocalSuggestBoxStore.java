package org.dominokit.domino.ui.forms;

import java.util.ArrayList;
import java.util.List;

public class LocalSuggestBoxStore implements SuggestBoxStore {

    private List<SuggestItem> suggestions;

    public LocalSuggestBoxStore() {
        this(new ArrayList<>());
    }

    public LocalSuggestBoxStore(List<SuggestItem> suggestions) {
        this.suggestions = suggestions;
    }

    public static LocalSuggestBoxStore create() {
        return new LocalSuggestBoxStore();
    }

    public static LocalSuggestBoxStore create(List<SuggestItem> suggestions) {
        return new LocalSuggestBoxStore(suggestions);
    }

    public LocalSuggestBoxStore addSuggestion(SuggestItem suggestion) {
        suggestions.add(suggestion);
        return this;
    }

    public LocalSuggestBoxStore addSuggestions(List<SuggestItem> suggestions) {
        this.suggestions.addAll(suggestions);
        return this;
    }

    public LocalSuggestBoxStore setSuggestions(List<SuggestItem> suggestions) {
        this.suggestions = new ArrayList<>(suggestions);
        return this;
    }

    public List<SuggestItem> getSuggestions() {
        return suggestions;
    }

    @Override
    public void filter(String searchValue, SuggestionsHandler suggestionsHandler) {
        List<SuggestItem> filteredSuggestions = new ArrayList<>();
        for (SuggestItem suggestion : suggestions) {
            if (suggestion.getValue().toLowerCase().contains(searchValue.toLowerCase())) {
                filteredSuggestions.add(suggestion);
            }
        }
        suggestionsHandler.onSuggestionsReady(filteredSuggestions);
    }
}
