/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.HasEditorErrors;
import org.gwtproject.editor.client.LeafValueEditor;
import org.gwtproject.editor.client.TakesValue;

/**
 * The {@code FormElement} interface represents a form element with various attributes and
 * behaviors.
 *
 * @param <T> The concrete type implementing this interface.
 * @param <V> The value type associated with the form element.
 */
public interface FormElement<T, V>
    extends HasName<T>,
        HasType,
        HasValue<T, V>,
        HasHelperText<T>,
        HasLabel<T>,
        TakesValue<V>,
        LeafValueEditor<V>,
        HasGrouping<T>,
        HasEditorErrors<V>,
        HasAddOns<T>,
        HasChangeListeners<T, V>,
        HasClearListeners<T, V>,
        AcceptDisable<T>,
        AcceptReadOnly<T>,
        HasDefaultValue<T, V> {}
