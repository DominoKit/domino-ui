package org.dominokit.domino.ui.forms;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface SuggestBoxStore<T> {

    void filter(String value, SuggestionsHandler<T> suggestionsHandler);

    void find(T searchValue, Consumer<SuggestItem<T>> handler);

    default boolean filterItem(String searchValue, SuggestItem<T> suggestItem) {
        return suggestItem.getDisplayValue().toLowerCase().contains(searchValue.toLowerCase());
    }

    default MissingSuggestProvider<T> getMessingSuggestionProvider() {
        return missingValue -> Optional.empty();
    }

    @FunctionalInterface
    interface SuggestionsHandler<T> {
        void onSuggestionsReady(List<SuggestItem<T>> suggestions);
    }

    @FunctionalInterface
    interface SuggestionFilter<T> {
        boolean filter(String searchValue, SuggestItem<T> suggestItem);
    }

    @FunctionalInterface
    interface MissingSuggestProvider<T>{
        Optional<SuggestItem<T>> getMessingSuggestion(T missingValue);
    }
}
