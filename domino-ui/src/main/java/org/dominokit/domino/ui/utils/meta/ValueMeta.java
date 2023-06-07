package org.dominokit.domino.ui.utils.meta;

import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

import java.util.Optional;

public class ValueMeta<T> implements ComponentMeta {

    public static final String VALUE_META = "dui-value-meta";
    private final T value;

    public static <T> ValueMeta<T> of(T value){
        return new ValueMeta<>(value);
    }

    public ValueMeta(T value) {
        this.value = value;
    }

    public static <T> Optional<ValueMeta<T>> get(HasMeta<?> component) {
        return component.getMeta(VALUE_META);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String getKey() {
        return VALUE_META;
    }
}
