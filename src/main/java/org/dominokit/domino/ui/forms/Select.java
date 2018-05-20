package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Select extends BasicFormElement<Select, String> {

    private static final String OPEN = "open";
    private static final String CLICK = "click";
    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private SelectElement selectElement = SelectElement.create();
    private HTMLLabelElement labelElement = Elements.label().css("form-label").asElement();
    private List<SelectOption> options = new LinkedList<>();
    private SelectOption selectedOption;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();
    private SelectionHandler selectionHandler;

    public Select() {
        DomGlobal.document.addEventListener(CLICK, evt -> {
            HTMLElement element = Js.cast(evt.target);
            if (!element.isEqualNode(this.selectElement.asElement()))
                hideAllMenus();
        });
        this.selectElement.getSelectButton().addEventListener(CLICK, evt -> {
            if (isEnabled()) {
                hideAllMenus();
                open();
            }
            evt.stopPropagation();
        });
        this.selectElement.getSelectButton().addEventListener("focus", evt -> {
            this.selectElement.getSelectButton().blur();
        });
        container.appendChild(labelElement);
        container.appendChild(selectElement.asElement());
    }

    public Select(String label) {
        this();
        setLabel(label);
    }

    public Select(List<SelectOption> options) {
        this("", options);
    }

    public Select(String label, List<SelectOption> options) {
        this(label);
        options.forEach(this::addOption);
    }

    private void open() {
        selectElement.asElement().classList.add(OPEN);
    }


    public static void hideAllMenus() {
        NodeList<Element> elementsByName = DomGlobal.document.body
                .getElementsByClassName("bootstrap-select");
        for (int i = 0; i < elementsByName.length; i++) {
            Element item = elementsByName.item(i);
            if (item.classList.contains(OPEN))
                close(item);
        }
    }

    private static void close(Element item) {
        item.classList.remove(OPEN);
    }

    private void close() {
        close(selectElement.asElement());
    }

    public static Select create() {
        return new Select();
    }

    public static Select create(String label) {
        return new Select(label);
    }

    public static Select create(String label, List<SelectOption> options) {
        return new Select(label, options);
    }

    public static Select create(List<SelectOption> options) {
        return new Select(options);
    }

    public Select addOption(SelectOption option) {
        options.add(option);
        option.asElement().addEventListener(CLICK, evt -> {
            if (isEnabled()) {
                select(option);
                close();
                evt.stopPropagation();
            }
        });
        appendOptionValue(option);
        return this;
    }

    private void appendOptionValue(SelectOption option) {
        selectElement.getOptionsList().appendChild(option.asElement());
        selectElement.getSelectMenu().appendChild(Elements.option().attr("value", option.getValue())
                .textContent(option.getDisplayValue())
                .asElement());
    }

    public Select selectAt(int index) {
        return selectAt(index, false);
    }

    public Select selectAt(int index, boolean silent) {
        if (index < options.size() && index >= 0)
            select(options.get(index), silent);
        return this;
    }

    public SelectOption getOptionAt(int index) {
        if (index < options.size() && index >= 0)
            return options.get(index);
        return null;
    }

    public List<SelectOption> getOptions() {
        return options;
    }

    public Select select(SelectOption option) {
        return select(option, false);
    }

    public Select select(SelectOption option, boolean silent) {
        if (selectedOption != null)
            if (!option.asElement().isEqualNode(selectedOption.asElement()))
                selectedOption.deselect();

        this.selectedOption = option;
        option.select();
        selectElement.getSelectedValueContainer().textContent = option.getDisplayValue();
        if (!silent)
            onSelection(option);
        return this;
    }

    public boolean isSelected() {
        return !isEmpty();
    }

    private void onSelection(SelectOption option) {
        for (SelectionHandler handler : selectionHandlers)
            handler.onSelection(option);
    }

    public Select addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    public SelectOption getSelectedOption() {
        return selectedOption;
    }

    @Override
    public Select enable() {
        super.enable();
        asElement().classList.remove("disabled");
        getSelectButton().classList.remove("disabled");
        return this;
    }

    @Override
    public Select disable() {
        super.disable();
        asElement().classList.add("disabled");
        getSelectButton().classList.add("disabled");
        return this;
    }

    public Select dropup() {
        asElement().classList.remove("dropup");
        asElement().classList.add("dropup");
        return this;
    }

    public Select dropdown() {
        asElement().classList.remove("dropup");
        return this;
    }

    @Override
    public void setValue(String value) {
        for (SelectOption option : getOptions()) {
            if (option.getValue().equals(value))
                select(option);
        }
    }

    public void setValue(String value, boolean silent) {
        for (SelectOption option : getOptions()) {
            if (option.getValue().equals(value))
                select(option, silent);
        }
    }

    @Override
    public String getValue() {
        return isSelected() ? getSelectedOption().getValue() : "";
    }

    @Override
    public boolean isEmpty() {
        return isNull(selectedOption);
    }

    @Override
    public Select clear() {
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        selectedOption = null;
        return this;
    }

    public Select setFormId(String formId) {
        getSelectMenu().setAttribute("form", formId);
        return this;
    }

    @Override
    public Select invalidate(String errorMessage) {
        selectElement.asElement().classList.add("fc-" + Color.RED.getStyle());
        labelElement.classList.add(Color.RED.getStyle());
        return super.invalidate(errorMessage);
    }

    @Override
    public Select clearInvalid() {
        selectElement.asElement().classList.remove("fc-" + Color.RED.getStyle());
        labelElement.classList.remove(Color.RED.getStyle());
        return super.clearInvalid();
    }

    public Select removeSelectionHandler(SelectionHandler selectionHandler) {
        if (nonNull(selectionHandler))
            selectionHandlers.remove(selectionHandler);
        return this;
    }

    @FunctionalInterface
    public interface SelectionHandler {
        void onSelection(SelectOption option);
    }

    public HTMLButtonElement getSelectButton() {
        return selectElement.getSelectButton();
    }

    public HTMLDivElement getDropDownMenu() {
        return selectElement.getDropDownMenu();
    }

    public HTMLUListElement getOptionsList() {
        return selectElement.getOptionsList();
    }

    public HTMLSelectElement getSelectMenu() {
        return selectElement.getSelectMenu();
    }

    public HTMLElement getSelectedValueContainer() {
        return selectElement.getSelectedValueContainer();
    }

    @Override
    public HTMLElement getInputElement() {
        return selectElement.selectMenu;
    }

    @Override
    public HTMLElement getLabelElement() {
        return labelElement;
    }

    @Override
    protected HTMLElement getContainer() {
        return container;
    }

    @Templated
    public static abstract class SelectElement implements IsElement<HTMLDivElement> {


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

        public static SelectElement create() {
            return new Templated_Select_SelectElement();
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
