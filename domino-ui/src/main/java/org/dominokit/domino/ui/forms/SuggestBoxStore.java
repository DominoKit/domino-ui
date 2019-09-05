package org.dominokit.domino.ui.forms;

import java.util.List;
import java.util.function.Consumer;

public interface SuggestBoxStore<T> {

    void filter(String value, SuggestionsHandler<T> suggestionsHandler);
    void find(T searchValue, Consumer<SuggestItem<T>> handler);
    default boolean filterItem(String searchValue, SuggestItem<T> suggestItem){
        return suggestItem.getDisplayValue().toLowerCase().contains(searchValue.toLowerCase());
    }

    @FunctionalInterface
    interface SuggestionsHandler<T> {
        void onSuggestionsReady(List<SuggestItem<T>> suggestions);
    }

    @FunctionalInterface
    interface SuggestionFilter<T>{
        boolean filter(String searchValue, SuggestItem<T> suggestItem);
    }
}
