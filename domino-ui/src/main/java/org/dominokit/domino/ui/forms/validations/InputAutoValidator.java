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
package org.dominokit.domino.ui.forms.validations;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.ValueBox;
import org.jboss.elemento.EventType;

/**
 * this class attach an {@link org.dominokit.domino.ui.forms.ValueBox.AutoValidate} to a component
 * and bind the validation the {@link EventType#blur}
 *
 * @param <E> the type of the HTMLElement
 */
@Deprecated
public class InputAutoValidator<E extends HTMLElement> extends ValueBox.AutoValidator {

  /** @param autoValidate {@link org.dominokit.domino.ui.forms.ValueBox.AutoValidate} */
  public InputAutoValidator(ValueBox.AutoValidate autoValidate) {
    super(autoValidate);
  }

  /** {@inheritDoc} */
  @Override
  public void attach() {}

  /** {@inheritDoc} */
  @Override
  public void remove() {}
}
