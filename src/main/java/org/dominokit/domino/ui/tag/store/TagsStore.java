package org.dominokit.domino.ui.tag.store;

import java.util.Map;

public interface TagsStore<V> {
    TagsStore<V> addItem(String displayValue, V item);

    TagsStore<V> removeItem(V item);

    TagsStore<V> clear();

    TagsStore<V> addItems(Map<String, V> items);

    Map<String, V> getItems();

    V getItemByDisplayValue(String displayValue);

    Map<String, V> filter(String searchValue);

    String getDisplayValue(V value);
}
