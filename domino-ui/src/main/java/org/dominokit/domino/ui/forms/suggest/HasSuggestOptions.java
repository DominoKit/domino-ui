package org.dominokit.domino.ui.forms.suggest;

import org.dominokit.domino.ui.IsElement;

public interface HasSuggestOptions<T, E extends IsElement<?>, O extends Option<T, E, O>> {
    void onOptionSelected(O suggestion);

    void onOptionDeselected(O suggestion);
}
