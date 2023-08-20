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

/** HasInputDataList interface. */
public interface HasInputDataList<T extends HasInputElement<?, ?>> {

  /**
   * getDataListElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DataListElement} object
   */
  DataListElement getDataListElement();

  /**
   * getDataListOptions.
   *
   * @return a {@link java.util.Map} object
   */
  Map<String, OptionElement> getDataListOptions();

  /**
   * bindDataList.
   *
   * @param component a T object
   * @return a T object
   */
  default T bindDataList(T component) {
    String listId = DominoId.unique();
    getDataListElement().element().id = listId;
    component.getInputElement().setAttribute("list", listId);
    component.getInputElement().parent().appendChild(getDataListElement());
    return component;
  }

  /**
   * unbindDataList.
   *
   * @param component a T object
   * @return a T object
   */
  default T unbindDataList(T component) {
    component.getInputElement().removeAttribute("list");
    getDataListElement().remove();
    return component;
  }

  /**
   * setDataListEnabled.
   *
   * @param state a boolean
   * @return a T object
   */
  default T setDataListEnabled(boolean state) {
    if (state) {
      return bindDataList((T) this);
    } else {
      return unbindDataList((T) this);
    }
  }

  /**
   * Adds a String value as a suggested value {@link org.dominokit.domino.ui.elements.OptionElement}
   * for this input
   *
   * @param dataListOption a {@link java.lang.String} object
   * @return same implementing component instance
   */
  default T addDataListOption(String dataListOption) {
    OptionElement optionElement = elements.option().setAttribute("value", dataListOption);
    getDataListElement().appendChild(optionElement);
    getDataListOptions().put(dataListOption, optionElement);
    return (T) this;
  }

  /**
   * Adds a List of String values as a suggested values {@link elemental2.dom.HTMLOptionElement} for
   * this input
   *
   * @param dataListValues List of String
   * @return same implementing component instance
   */
  default T setDataListValues(List<String> dataListValues) {
    clearDataListOptions();
    dataListValues.forEach(this::addDataListOption);
    return (T) this;
  }

  /**
   * Removes a suggested value {@link org.dominokit.domino.ui.elements.OptionElement} from this
   * input
   *
   * @param dataListValue String
   * @return same implementing component instance
   */
  default T removeDataListValue(String dataListValue) {
    if (this.getDataListOptions().containsKey(dataListValue)) {
      this.getDataListOptions().get(dataListValue).remove();
      getDataListOptions().remove(dataListValue);
    }
    return (T) this;
  }

  /** @return a List of all suggested values of this component */
  /**
   * getDataListValues.
   *
   * @return a {@link java.util.Collection} object
   */
  default Collection<String> getDataListValues() {
    return getDataListOptions().keySet();
  }

  /**
   * removes all suggested values
   *
   * @return same implementing component
   */
  default T clearDataListOptions() {
    getDataListOptions().values().forEach(BaseDominoElement::remove);
    getDataListOptions().clear();
    return (T) this;
  }
}
