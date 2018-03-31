package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.LinkedList;
import java.util.List;

public class DropDown implements IsElement<HTMLDivElement> {


    private static final String OPEN = "open";
    private boolean disabled;

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

    private DropDownElement dropDownElement;
    private List<DropDownOption> options = new LinkedList<>();
    private DropDownOption selectedOption;
    private SelectionHandler selectionHandler = option -> {
    };

    public DropDown() {
        dropDownElement = DropDownElement.create();
        DomGlobal.document.addEventListener("click", evt -> {
            HTMLElement element = Js.cast(evt.target);
            if (!element.isEqualNode(dropDownElement.asElement()))
                hideAllMenus();
        });
        dropDownElement.asElement().addEventListener("click", evt -> {
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
        option.asElement().addEventListener("click", evt -> {
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
                .textContent(option.getValue())
                .asElement());
    }

    public DropDown selectAt(int index) {
        if (index < options.size() && index >= 0)
            select(options.get(index));

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
        if (selectedOption != null)
            if (!option.asElement().isEqualNode(selectedOption.asElement()))
                selectedOption.deselect();

        this.selectedOption = option;
        option.select();
        dropDownElement.getSelectedValueContainer().textContent = option.getValue();
        selectionHandler.onSelection(option);
        return this;
    }

    public DropDown setSelectionHandler(SelectionHandler selectionHandler) {
        this.selectionHandler = selectionHandler;
        return this;
    }

    public DropDownOption getSelectedOption() {
        return selectedOption;
    }

    public DropDown enable() {
        asElement().classList.remove("disabled");
        getSelectButton().classList.remove("disabled");
        this.disabled = false;
        return this;
    }

    public DropDown disable() {
        asElement().classList.add("disabled");
        getSelectButton().classList.add("disabled");
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
}
