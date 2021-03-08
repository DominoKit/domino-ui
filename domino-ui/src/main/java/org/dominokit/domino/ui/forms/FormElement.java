package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.HasEditorErrors;
import org.gwtproject.editor.client.LeafValueEditor;
import org.gwtproject.editor.client.TakesValue;
import org.dominokit.domino.ui.utils.HasHelperText;
import org.dominokit.domino.ui.utils.HasLabel;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.HasValue;

/**
 * Components that needs to be form elements and required to to support editors frameworks should implement this interface
 * @param <T> The type of the component implementing this interface
 * @param <V> The type of the component value
 */
public interface FormElement<T, V> extends HasName<T>, HasValue<T, V>,
        HasHelperText<T>, HasLabel<T>, TakesValue<V>, LeafValueEditor<V>, HasGrouping<T> , HasEditorErrors<V> {

}
