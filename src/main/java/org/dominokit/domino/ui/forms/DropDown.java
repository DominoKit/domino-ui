package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.CanDisable;
import org.dominokit.domino.ui.utils.CanEnable;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.HasValue;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DropDown implements IsElement<HTMLDivElement>,
        HasValue<String>, CanEnable<DropDown>, CanDisable<DropDown>, HasName<DropDown> {

    private static final String OPEN = "open";
    private static final String CLICK = "click";
    private DropDownElement dropDownElement;
    private List<DropDownOption> options = new LinkedList<>();
    private DropDownOption selectedOption;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();
    private boolean disabled;

    public DropDown() {
        dropDownElement = DropDownElement.create();
        DomGlobal.document.addEventListener(CLICK, evt -> {
            HTMLElement element = Js.cast(evt.target);
            if (!element.isEqualNode(dropDownElement.asElement()))
                hideAllMenus();
        });
        dropDownElement.asElement().addEventListener(CLICK, evt -> {
            if (!isDisabled()) {
                hideAllMenus();
                open();
            }
            evt.stopPropagation();
        });
        dropDownElement.getSelectButton().addEventListener("focus", evt -> {
            dropDownElement.getSelectButton().blur();
        });
    }

    public boolean isDisabled() {
        return disabled;
    }

    private void open() {
        dropDownElement.asElement().classList.add(OPEN);
    }

    public DropDown(List<DropDownOption> options) {
        this();
        options.forEach(this::addOption);
    }


    private void hideAllMenus() {
        NodeList<Element> elementsByName = DomGlobal.document.body
                .getElementsByClassName(asElement().className);
        for (int i = 0; i < elementsByName.length; i++) {
            Element item = elementsByName.item(i);
            if (item.classList.contains(OPEN))
                close(item);
        }
    }

    private void close(Element item) {
        item.classList.remove(OPEN);
    }

    private void close() {
        close(asElement());
    }

    public static DropDown create() {
        return new DropDown();
    }

    public static DropDown create(List<DropDownOption> options) {
        return new DropDown(options);
    }

    public DropDown addOption(DropDownOption option) {
        options.add(option);
        option.asElement().addEventListener(CLICK, evt -> {
            if (!isDisabled()) {
                select(option);
                close();
                evt.stopPropagation();
            }
        });
        appendOptionValue(option);
        return this;
    }

    private void appendOptionValue(DropDownOption option) {
        dropDownElement.getOptionsList().appendChild(option.asElement());
        dropDownElement.getSelectMenu().appendChild(Elements.option().attr("value", option.getValue())
                .textContent(option.getDisplayValue())
                .asElement());
    }

    public DropDown selectAt(int index) {
        return selectAt(index, false);
    }

    public DropDown selectAt(int index, boolean silent) {
        if (index < options.size() && index >= 0)
            select(options.get(index), silent);

        return this;
    }

    public DropDownOption getOptionAt(int index) {
        if (index < options.size() && index >= 0)
            return options.get(index);
        return null;
    }

    public List<DropDownOption> getOptions() {
        return options;
    }

    public DropDown select(DropDownOption option) {
        return select(option, false);
    }

    private DropDown select(DropDownOption option, boolean silent) {
        if (selectedOption != null)
            if (!option.asElement().isEqualNode(selectedOption.asElement()))
                selectedOption.deselect();

        this.selectedOption = option;
        option.select();
        dropDownElement.getSelectedValueContainer().textContent = option.getDisplayValue();
        if(!silent)
            onSelection(option);
        return this;
    }

    private void onSelection(DropDownOption option) {
        for (SelectionHandler handler : selectionHandlers)
            handler.onSelection(option);
    }

    public DropDown addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    public DropDownOption getSelectedOption() {
        return selectedOption;
    }

    @Override
    public DropDown enable() {
        asElement().classList.remove("disabled");
        getSelectButton().classList.remove("disabled");
        getSelectMenu().disabled = false;
        this.disabled = false;
        return this;
    }

    @Override
    public DropDown disable() {
        asElement().classList.add("disabled");
        getSelectButton().classList.add("disabled");
        getSelectMenu().disabled = true;
        this.disabled = true;
        return this;
    }

    public DropDown dropup() {
        asElement().classList.remove("dropup");
        asElement().classList.add("dropup");
        return this;
    }

    public DropDown dropdown() {
        asElement().classList.remove("dropup");
        return this;
    }

    @Override
    public void setValue(String value) {
        for (DropDownOption option : getOptions()) {
            if (option.getValue().equals(value))
                select(option);
        }
    }

    public void setValue(String value, boolean silent) {
        for (DropDownOption option : getOptions()) {
            if (option.getValue().equals(value))
                select(option, silent);
        }
    }

    @Override
    public String getValue() {
        return getSelectedOption() != null ? getSelectedOption().getValue() : "";
    }

    @Override
    public String getName() {
        return getSelectMenu().name;
    }

    @Override
    public DropDown setName(String name) {
        getSelectMenu().name = name;
        return this;
    }

    public DropDown setFormId(String formId) {
        getSelectMenu().setAttribute("form", formId);
        return this;
    }

    @FunctionalInterface
    public interface SelectionHandler {
        void onSelection(DropDownOption option);
    }

    @Override
    public HTMLDivElement asElement() {
        return dropDownElement.asElement();
    }

    public HTMLButtonElement getSelectButton() {
        return dropDownElement.getSelectButton();
    }

    public HTMLDivElement getDropDownMenu() {
        return dropDownElement.getDropDownMenu();
    }

    public HTMLUListElement getOptionsList() {
        return dropDownElement.getOptionsList();
    }

    public HTMLSelectElement getSelectMenu() {
        return dropDownElement.getSelectMenu();
    }

    public HTMLElement getSelectedValueContainer() {
        return dropDownElement.getSelectedValueContainer();
    }

    @Templated
    public static abstract class DropDownElement implements IsElement<HTMLDivElement> {

        @DataElement
        HTMLButtonElement selectButton;

        @DataElement
        HTMLDivElement dropDownMenu;

        @DataElement
        HTMLUListElement optionsList;

        @DataElement
        HTMLSelectElement selectMenu;

        @DataElement
        HTMLElement selectedValueContainer;

        public static DropDownElement create() {
            return new Templated_DropDown_DropDownElement();
        }

        public HTMLButtonElement getSelectButton() {
            return selectButton;
        }

        public HTMLDivElement getDropDownMenu() {
            return dropDownMenu;
        }

        public HTMLUListElement getOptionsList() {
            return optionsList;
        }

        public HTMLSelectElement getSelectMenu() {
            return selectMenu;
        }

        public HTMLElement getSelectedValueContainer() {
            return selectedValueContainer;
        }
    }
}
