package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.user.client.TakesValue;
import org.dominokit.domino.ui.utils.*;

public interface FormElement<T, V> extends HasName<T>, HasValue<T, V>, Switchable<T>,
        HasHelperText<T>, HasLabel<T>, HasValidation<T>, HasAutoValidation<T>, IsRequired<T>, TakesValue<V>, IsEditor<TakesValueEditor<V>> {

    boolean isEmpty();

    T clear();

    T groupBy(FieldsGrouping fieldsGrouping);
}
