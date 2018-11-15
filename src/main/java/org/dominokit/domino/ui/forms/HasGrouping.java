package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.HasAutoValidation;
import org.dominokit.domino.ui.utils.HasValidation;
import org.dominokit.domino.ui.utils.IsRequired;
import org.dominokit.domino.ui.utils.Switchable;
import org.gwtproject.editor.client.Editor;

public interface HasGrouping<T> extends Switchable<T>, IsRequired<T>, HasValidation<T>, HasAutoValidation<T> {

    @Editor.Ignore
    T groupBy(FieldsGrouping fieldsGrouping);

    @Editor.Ignore
    boolean isEmpty();

    @Editor.Ignore
    T clear();
}
