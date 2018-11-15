package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.HasHelperText;
import org.dominokit.domino.ui.utils.HasLabel;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.editor.client.LeafValueEditor;

public interface FormElement<T, V> extends HasName<T>, HasValue<T, V>,
        HasHelperText<T>, HasLabel<T>, LeafValueEditor<V>, HasGrouping<T> {

}
