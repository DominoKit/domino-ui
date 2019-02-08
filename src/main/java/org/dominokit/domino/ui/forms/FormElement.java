package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.user.client.TakesValue;
import org.dominokit.domino.ui.utils.*;

public interface FormElement<T, V> extends HasName<T>, HasValue<T, V>,
        HasHelperText<T>, HasLabel<T>, TakesValue<V>, IsEditor<TakesValueEditor<V>>, HasGrouping<T> , HasEditorErrors<V> {

}
