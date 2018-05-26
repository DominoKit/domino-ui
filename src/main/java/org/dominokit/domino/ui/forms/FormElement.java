package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.*;

public interface FormElement<T, V> extends HasName<T>, HasValue<V>, Switchable<T>,
        HasHelperText<T>, HasLabel<T>, HasValidation<T>, HasAutoValidation<T>, IsRequired<T> {

    boolean isEmpty();

    T clear();
}
