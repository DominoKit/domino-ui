package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.Editor;
import org.dominokit.domino.ui.utils.HasAutoValidation;
import org.dominokit.domino.ui.utils.HasValidation;
import org.dominokit.domino.ui.utils.IsRequired;
import org.dominokit.domino.ui.utils.Switchable;

/**
 * Components that can be grouped by a {@link FieldsGrouping} should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface HasGrouping<T> extends Switchable<T>, IsRequired<T>, HasValidation<T>, HasAutoValidation<T> {

    /**
     * Adds the component to the specified fields group
     * @param fieldsGrouping {@link FieldsGrouping}
     * @return same implementing component instance
     */
    @Editor.Ignore
    T groupBy(FieldsGrouping fieldsGrouping);

    /**
     * remove the component from the specified fields group
     * @param fieldsGrouping {@link FieldsGrouping}
     * @return same implementing component instance
     */
    @Editor.Ignore
    T ungroup(FieldsGrouping fieldsGrouping);

    /**
     *
     * @return boolean, true if the component value is empty
     */
    @Editor.Ignore
    boolean isEmpty();

    /**
     *
     * @return same implementing component instance
     */
    @Editor.Ignore
    T clear();
}
