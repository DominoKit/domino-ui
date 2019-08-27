package org.dominokit.domino.ui.forms;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

public interface SuggestBoxStore<T> {

    void filter(String value, SuggestionsHandler<T> suggestionsHandler);
    void find(T searchValue, Consumer<SuggestItem<T>> handler);


    @FunctionalInterface
    interface SuggestionsHandler<T> {
        void onSuggestionsReady(List<SuggestItem<T>> suggestions);
    }
}
