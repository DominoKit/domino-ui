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

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.OptionElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoId;

/**
 * The {@code HasInputDataList} interface provides methods for working with data lists associated
 * with input elements.
 *
 * @param <T> The concrete type implementing this interface.
 */
public interface HasInputDataList<T extends HasInputElement<?, ?>> {

  /**
   * Gets the data list element associated with the input.
   *
   * @return The {@link DataListElement}.
   */
  DataListElement getDataListElement();

  /**
   * Gets a map of data list options.
   *
   * @return A map of data list option values to {@link OptionElement} instances.
   */
  Map<String, OptionElement> getDataListOptions();

  /**
   * Binds the data list to the component's input element.
   *
   * @param component The component to bind the data list to.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T bindDataList(T component) {
    String listId = DominoId.unique();
    getDataListElement().element().id = listId;
    component.getInputElement().setAttribute("list", listId);
    component.getInputElement().parent().appendChild(getDataListElement());
    return component;
  }

  /**
   * Unbinds the data list from the component's input element.
   *
   * @param component The component to unbind the data list from.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T unbindDataList(T component) {
    component.getInputElement().removeAttribute("list");
    getDataListElement().remove();
    return component;
  }

  /**
   * Enables or disables the data list for the component's input element.
   *
   * @param state {@code true} to enable, {@code false} to disable.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T setDataListEnabled(boolean state) {
    if (state) {
      return bindDataList((T) this);
    } else {
      return unbindDataList((T) this);
    }
  }

  /**
   * Adds a data list option.
   *
   * @param dataListOption The value of the data list option to add.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T addDataListOption(String dataListOption) {
    OptionElement optionElement = elements.option().setAttribute("value", dataListOption);
    getDataListElement().appendChild(optionElement);
    getDataListOptions().put(dataListOption, optionElement);
    return (T) this;
  }

  /**
   * Sets the data list values from a list of strings.
   *
   * @param dataListValues The list of data list values to set.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T setDataListValues(List<String> dataListValues) {
    clearDataListOptions();
    dataListValues.forEach(this::addDataListOption);
    return (T) this;
  }

  /**
   * Removes a data list value.
   *
   * @param dataListValue The data list value to remove.
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T removeDataListValue(String dataListValue) {
    if (this.getDataListOptions().containsKey(dataListValue)) {
      this.getDataListOptions().get(dataListValue).remove();
      getDataListOptions().remove(dataListValue);
    }
    return (T) this;
  }

  /**
   * Gets a collection of data list values.
   *
   * @return A collection of data list values.
   */
  default Collection<String> getDataListValues() {
    return getDataListOptions().keySet();
  }

  /**
   * Clears all data list options.
   *
   * @return The updated instance of the concrete type implementing this interface.
   */
  default T clearDataListOptions() {
    getDataListOptions().values().forEach(BaseDominoElement::remove);
    getDataListOptions().clear();
    return (T) this;
  }
}
