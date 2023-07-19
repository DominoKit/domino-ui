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

import static org.dominokit.domino.ui.forms.FormsStyles.dui_form_field;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.List;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.FormsFieldsConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.ui.utils.HasCounter;
import org.dominokit.domino.ui.utils.HasMinMaxLength;

/**
 * InputFieldInitializer class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class InputFieldInitializer<T extends FormElement<T, V>, V, E extends HTMLElement>
    implements HasComponentConfig<FormsFieldsConfig> {

  private final T formElement;
  private V oldValue;

  /**
   * create.
   *
   * @param formElement a T object
   * @param <T> a T class
   * @param <V> a V class
   * @param <E> a E class
   * @return a {@link org.dominokit.domino.ui.forms.InputFieldInitializer} object
   */
  public static <T extends FormElement<T, V>, V, E extends HTMLElement>
      InputFieldInitializer<T, V, E> create(T formElement) {
    return new InputFieldInitializer<>(formElement);
  }

  /**
   * Constructor for InputFieldInitializer.
   *
   * @param formElement a T object
   */
  public InputFieldInitializer(T formElement) {
    this.formElement = formElement;
    this.oldValue = formElement.getValue();
  }

  /**
   * init.
   *
   * @param hasInput a {@link org.dominokit.domino.ui.forms.HasInputElement} object
   * @return a {@link org.dominokit.domino.ui.forms.InputFieldInitializer} object
   */
  public InputFieldInitializer<T, V, E> init(HasInputElement<T, E> hasInput) {
    DominoElement<E> inputElement = hasInput.getInputElement();
    inputElement.addEventListener(
        "change",
        evt -> {
          if (hasInput.onChange().isPresent()) {
            hasInput.onChange().get().accept(evt);
          } else {
            if (formElement.isEnabled() && !formElement.isReadOnly()) {
              formElement.triggerChangeListeners(oldValue, formElement.getValue());
              this.oldValue = formElement.getValue();
            }
          }
        });
    inputElement.addEventListener(
        "focusout",
        evt -> {
          if (formElement.isAutoValidation() && !formElement.isFocusValidationsPaused()) {
            formElement.validate();
          }
        });
    if (formElement instanceof HasCounter && formElement instanceof HasMinMaxLength) {
      HasCounter<T> countableElement = (HasCounter<T>) formElement;
      HasMinMaxLength<T> hasLength = (HasMinMaxLength<T>) formElement;
      inputElement.addEventListener(
          "input",
          evt ->
              countableElement.updateCounter(
                  hasLength.getLength(), countableElement.getMaxCount()));
    }
    inputElement.onKeyPress(
        keyEvents -> {
          keyEvents.onEnter(
              evt -> {
                if (getConfig().isFocusNextFieldOnEnter()) {
                  inputElement.blur();
                  List<Element> elements =
                      ElementsFactory.elements
                          .body()
                          .element()
                          .querySelectorAll("." + dui_form_field.getCssClass())
                          .asList();
                  int i = elements.indexOf(formElement);
                  if (i < elements.size() - 1) {
                    Element element = elements.get(i + 1);
                    Element input = element.querySelector(".dui-field-input");
                    Js.<HTMLInputElement>uncheckedCast(input).focus();
                  }
                }
              });
        });

    return this;
  }
}
