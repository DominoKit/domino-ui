package org.dominokit.domino.ui.tag.store;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toMap;

public class LocalTagsStore<V> implements TagsStore<V> {

    private Map<String, V> items = new TreeMap<>();

    public static <V> LocalTagsStore<V> create() {
        return new LocalTagsStore<>();
    }

    @Override
    public LocalTagsStore<V> addItem(String displayValue, V item) {
        items.put(displayValue, item);
        return this;
    }

    @Override
    public LocalTagsStore<V> removeItem(V item) {
        items.values().remove(item);
        return this;
    }

    @Override
    public LocalTagsStore<V> clear() {
        items.clear();
        return this;
    }

    @Override
    public LocalTagsStore<V> addItems(Map<String, V> items) {
        this.items.putAll(items);
        return this;
    }

    @Override
    public Map<String, V> getItems() {
        return items;
    }

    @Override
    public V getItemByDisplayValue(String displayValue) {
        return items.get(displayValue);
    }

    @Override
    public Map<String, V> filter(String searchValue) {
        return items.entrySet().stream()
                .filter(entry -> entry.getKey().contains(searchValue))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    @Override
    public String getDisplayValue(V value) {
        return items.entrySet().stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Entry::getKey)
                .findFirst().orElse(null);
    }
}
