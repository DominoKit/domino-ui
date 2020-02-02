package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.HasEditorErrors;
import org.gwtproject.editor.client.LeafValueEditor;
import com.google.gwt.user.client.TakesValue;
import org.dominokit.domino.ui.utils.HasHelperText;
import org.dominokit.domino.ui.utils.HasLabel;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.HasValue;

public interface FormElement<T, V> extends HasName<T>, HasValue<T, V>,
        HasHelperText<T>, HasLabel<T>, TakesValue<V>, LeafValueEditor<V>, HasGrouping<T> , HasEditorErrors<V> {

}
