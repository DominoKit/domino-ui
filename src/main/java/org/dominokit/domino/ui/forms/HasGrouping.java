package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.HasAutoValidation;
import org.dominokit.domino.ui.utils.HasValidation;
import org.dominokit.domino.ui.utils.IsRequired;
import org.dominokit.domino.ui.utils.Switchable;

public interface HasGrouping<T> extends Switchable<T>, IsRequired<T>, HasValidation<T>, HasAutoValidation<T> {
    T groupBy(FieldsGrouping fieldsGrouping);

    boolean isEmpty();

    T clear();
}
