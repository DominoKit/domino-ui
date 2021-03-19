package org.dominokit.domino.ui.tag.store;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toMap;

/**
 * A store implementation that accepts a list of items
 *
 * @param <V> the type of the value
 */
public class LocalTagsStore<V> implements TagsStore<V> {

    private final Map<String, V> items = new TreeMap<>();

    /**
     * @param <V> the type of the object
     * @return new instance
     */
    public static <V> LocalTagsStore<V> create() {
        return new LocalTagsStore<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTagsStore<V> addItem(String displayValue, V item) {
        items.put(displayValue, item);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTagsStore<V> removeItem(V item) {
        items.values().remove(item);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTagsStore<V> clear() {
        items.clear();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTagsStore<V> addItems(Map<String, V> items) {
        this.items.putAll(items);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, V> getItems() {
        return items;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V getItemByDisplayValue(String displayValue) {
        return items.get(displayValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, V> filter(String searchValue) {
        return items.entrySet().stream()
                .filter(entry -> entry.getKey().contains(searchValue))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayValue(V value) {
        return items.entrySet().stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Entry::getKey)
                .findFirst().orElse(null);
    }
}
