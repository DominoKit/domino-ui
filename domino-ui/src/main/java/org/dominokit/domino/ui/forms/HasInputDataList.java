package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLOptionElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.OptionElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoId;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

public interface HasInputDataList<T extends HasInputElement<?, ?>> {

    DataListElement getDataListElement();
    Map<String, OptionElement> getDataListOptions();

    default T bindDataList(T component){
        String listId = DominoId.unique();
        getDataListElement().element().id = listId;
        component.getInputElement().setAttribute("list", listId);
        component.getInputElement().parent().appendChild(getDataListElement());
        return component;
    }

    default T unbindDataList(T component){
        component.getInputElement().removeAttribute("list");
        getDataListElement().remove();
        return component;
    }

    default T setDataListEnabled(boolean state){
        if(state){
            return bindDataList((T) this);
        }else {
            return unbindDataList((T) this);
        }
    }

    /**
     * Adds a String value as a suggested value {@link OptionElement} for this input
     *
     * @param dataListOption
     * @return same implementing component instance
     */
    default T addDataListOption(String dataListOption) {
        OptionElement optionElement = elements.option().setAttribute("value", dataListOption);
        getDataListElement().appendChild(optionElement);
        getDataListOptions().put(dataListOption, optionElement);
        return (T) this;
    }

    /**
     * Adds a List of String values as a suggested values {@link HTMLOptionElement} for this input
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
     * Removes a suggested value {@link OptionElement} from this input
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
