package org.dominokit.domino.ui.utils.meta;

import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

import java.util.Optional;

public class AttributeMeta<T> implements ComponentMeta {

    private String key;
    private final T value;

    public static <T> AttributeMeta<T> of(String key, T value){
        return new AttributeMeta<>(key, value);
    }

    public AttributeMeta(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> Optional<AttributeMeta<T>> get(String key, HasMeta<?> component) {
        return component.getMeta(key);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String getKey() {
        return key;
    }
}
