package org.dominokit.domino.ui.forms;

import java.util.List;

public interface SuggestBoxStore {

    void filter(String searchValue, SuggestionsHandler suggestionsHandler);

    interface SuggestionsHandler {
        void onSuggestionsReady(List<SuggestItem> suggestions);
    }
}
