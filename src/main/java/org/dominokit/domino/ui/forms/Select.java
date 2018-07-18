package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import elemental2.dom.EventListener;
import elemental2.svg.SVGElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Focusable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.*;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementUtil.*;

public class Select extends BasicFormElement<Select, String> implements Focusable<Select> {

    private static final String OPEN = "open";
    private static final String CLICK = "click";
    private static final String KEYDOWN = "keydown";
    private static final String FOCUSED = "focused";

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private SelectElement selectElement = SelectElement.create();
    private HTMLElement leftAddonContainer = Elements.div().css("input-addon-container").asElement();
    private HTMLElement rightAddonContainer = Elements.div().css("input-addon-container").asElement();
    private List<SelectOption> options = new LinkedList<>();
    private SelectOption selectedOption;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();
    private SelectionHandler autoValidationHandler;
    private Color focusColor = Color.BLUE;
    private Element leftAddon;
    private Element rightAddon;

    public Select() {
        initListeners();
        container.appendChild(leftAddonContainer);
        container.appendChild(selectElement.asElement());
        container.appendChild(rightAddonContainer);
    }

    private void initListeners() {
        document.addEventListener(CLICK, evt -> {
            HTMLElement element = Js.uncheckedCast(evt.target);
            if (!element.isEqualNode(this.selectElement.asElement()))
                hideAllMenus();
        });

        document.body.addEventListener(KEYDOWN, new NavigateOptionsKeyListener());

        EventListener clickListener = evt -> {
            doOpen();
            evt.stopPropagation();
        };
        selectElement.getSelectButton().addEventListener(CLICK, clickListener);
        selectElement.getSelectMenu().addEventListener("focusin", evt -> focus());
        selectElement.getSelectMenu().addEventListener("focusout", evt -> unfocus());
        selectElement.getSelectButton().addEventListener("focus", evt -> selectElement.getSelectButton().blur());
        selectElement.getSelectMenu().addEventListener(KEYDOWN, evt -> {
            KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
            if (isSpaceKey(keyboardEvent) || isEnterKey(keyboardEvent)) {
                doOpen();
                evt.preventDefault();
            }
        });
    }

    private void doOpen() {
        if (isEnabled() && !isReadOnly()) {
            hideAllMenus();
            open();
            if (nonNull(getSelectedOption()))
                getSelectedOption().focus();
            else if (!options.isEmpty())
                options.get(0).focus();
        }
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

    public void open() {
        selectElement.asElement().classList.add(OPEN);
    }


    public void hideAllMenus() {
        NodeList<Element> elementsByName = document.body
                .getElementsByClassName("bootstrap-select");
        for (int i = 0; i < elementsByName.length; i++) {
            Element item = elementsByName.item(i);
            if (item.classList.contains(OPEN))
                close(item);
        }
    }

    private void close(Element item) {
        item.classList.remove(OPEN);
        item.classList.remove("fc-" + focusColor.getStyle());
        item.querySelector(".form-control").classList.remove(FOCUSED);
        item.querySelector(".form-label").classList.remove(focusColor.getStyle());
    }

    public void close() {
        close(selectElement.asElement());
        selectElement.getSelectMenu().focus();
    }

    private boolean isOpened() {
        return selectElement.asElement().classList.contains(OPEN);
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
            doSelectOption(option);
            evt.stopPropagation();
        });
        appendOptionValue(option);
        return this;
    }

    private void doSelectOption(SelectOption option) {
        if (isEnabled()) {
            select(option);
            close();
        }
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
        selectElement.getSelectLabel().classList.add(FOCUSED);
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
        getSelectMenu().classList.remove("disabled");
        Style.of(getLabelElement()).removeProperty("cursor");
        return this;
    }

    @Override
    public Select disable() {
        super.disable();
        asElement().classList.add("disabled");
        getSelectButton().classList.add("disabled");
        getSelectMenu().classList.add("disabled");
        Style.of(getLabelElement()).setProperty("cursor", "not-allowed");
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
    public Select setValue(String value) {
        return setValue(value, false);
    }

    public Select setValue(String value, boolean silent) {
        for (SelectOption option : getOptions()) {
            if (Objects.equals(option.getValue(), value)) {
                select(option, silent);
            }
        }
        return this;
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
        selectElement.getSelectLabel().classList.remove(FOCUSED);
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        selectedOption = null;
        selectElement.getSelectedValueContainer().textContent = "";
        if (isAutoValidation())
            validate();
        return this;
    }

    public Select setFormId(String formId) {
        getSelectMenu().setAttribute("form", formId);
        return this;
    }

    @Override
    public Select invalidate(String errorMessage) {
        selectElement.asElement().classList.add("fc-" + Color.RED.getStyle());
        selectElement.getSelectLabel().classList.add(Color.RED.getStyle());
        return super.invalidate(errorMessage);
    }

    @Override
    public Select clearInvalid() {
        selectElement.asElement().classList.remove("fc-" + Color.RED.getStyle());
        selectElement.getSelectLabel().classList.remove(Color.RED.getStyle());
        return super.clearInvalid();
    }

    public Select removeSelectionHandler(SelectionHandler selectionHandler) {
        if (nonNull(selectionHandler))
            selectionHandlers.remove(selectionHandler);
        return this;
    }

    @Override
    public Select focus() {
        if (isEnabled() && !isReadOnly()) {
            selectElement.getSelectMenu().classList.add(FOCUSED);
            selectElement.getSelectLabel().classList.add(focusColor.getStyle());
            selectElement.asElement().classList.add("fc-" + focusColor.getStyle());
            selectElement.getSelectMenu().focus();
        }
        return this;
    }

    @Override
    public Select unfocus() {
        selectElement.getSelectMenu().classList.remove(FOCUSED);
        selectElement.getSelectLabel().classList.remove(focusColor.getStyle());
        selectElement.asElement().classList.remove("fc-" + focusColor.getStyle());
        return this;
    }

    @Override
    public boolean isFocused() {
        return selectElement.getSelectMenu().classList.contains(FOCUSED);
    }

    @Override
    public Select setFocusColor(Color focusColor) {
        unfocus();
        this.focusColor = focusColor;
        if (isFocused())
            focus();
        return this;
    }

    public Select removeOption(SelectOption option) {
        if (nonNull(option) && getOptions().contains(option)) {
            option.deselect(true);
            options.remove(option);
            option.asElement().remove();
        }
        return this;
    }

    public Select removeOptions(Collection<SelectOption> options) {
        if (nonNull(options) && !options.isEmpty() && !this.options.isEmpty()) {
            options.forEach(this::removeOption);
        }
        return this;
    }

    public Select removeAllOptions() {
        if (nonNull(options) && !options.isEmpty()) {
            options.forEach(this::removeOption);
        }
        clear();
        return this;
    }

    public SelectElement getSelectElement() {
        return selectElement;
    }

    @Override
    protected void doSetReadOnly(boolean readOnly) {
        if (readOnly) {
            selectElement.asElement().classList.add("readonly");
            selectElement.getSelectMenu().setAttribute("disabled", true);
            selectElement.getSelectMenu().setAttribute("readonly", true);
            selectElement.getSelectArrow().setAttributeNS(null, "style", "display: none;");
        } else {
            selectElement.asElement().classList.remove("readonly");
            if (!asElement().classList.contains("disabled")) {
                selectElement.getSelectMenu().removeAttribute("disabled");
            }
            selectElement.getSelectMenu().removeAttribute("readonly");
            selectElement.getSelectArrow().removeAttributeNS(null, "style");
        }
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
    public Select setAutoValidation(boolean autoValidation) {
        if (autoValidation) {
            if (isNull(autoValidationHandler)) {
                autoValidationHandler = option -> validate();
                addSelectionHandler(autoValidationHandler);
            }
        } else {
            removeSelectionHandler(autoValidationHandler);
            autoValidationHandler = null;
        }
        return this;
    }

    @Override
    public boolean isAutoValidation() {
        return nonNull(autoValidationHandler);
    }


    public Select setLeftAddon(IsElement leftAddon) {
        return setLeftAddon(leftAddon.asElement());
    }

    public Select setLeftAddon(Element leftAddon) {
        setAddon(leftAddonContainer, this.leftAddon, leftAddon);
        this.leftAddon = leftAddon;
        return this;
    }

    public Select setRightAddon(IsElement rightAddon) {
        return setRightAddon(rightAddon.asElement());
    }

    public Select setRightAddon(Element rightAddon) {
        setAddon(rightAddonContainer, this.rightAddon, rightAddon);
        this.rightAddon = rightAddon;
        return this;
    }

    public Select removeRightAddon() {
        if (nonNull(rightAddon)) {
            rightAddonContainer.removeChild(rightAddon);
        }
        return this;
    }

    public Select removeLeftAddon() {
        if (nonNull(leftAddon)) {
            leftAddonContainer.removeChild(leftAddon);
        }
        return this;
    }

    private void setAddon(HTMLElement container, Element oldAddon, Element addon) {
        if (nonNull(oldAddon)) {
            container.removeChild(oldAddon);
        }
        if (nonNull(addon)) {
            List<String> oldClasses = new ArrayList<>(addon.classList.asList());
            for (String oldClass : oldClasses) {
                addon.classList.remove(oldClass);
            }
            oldClasses.add(0, "input-addon");
            for (String oldClass : oldClasses) {
                addon.classList.add(oldClass);
            }
            container.appendChild(addon);
        }
    }

    @Override
    public HTMLElement getInputElement() {
        return selectElement.selectMenu;
    }

    @Override
    public HTMLElement getLabelElement() {
        return selectElement.getSelectLabel();
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

        @DataElement
        HTMLLabelElement selectLabel;

        @DataElement
        SVGElement selectArrow;

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

        public HTMLLabelElement getSelectLabel() {
            return selectLabel;
        }

        public SVGElement getSelectArrow() {
            return selectArrow;
        }
    }

    private final class NavigateOptionsKeyListener implements EventListener {

        @Override
        public void handleEvent(Event evt) {
            KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
            HTMLElement element = Js.uncheckedCast(keyboardEvent.target);
            for (SelectOption option : options) {
                if (option.asElement().contains(element)) {
                    if (isKeyOf("ArrowUp", keyboardEvent)) {
                        focusPrev(option);
                        evt.preventDefault();
                    } else if (isKeyOf("ArrowDown", keyboardEvent)) {
                        focusNext(option);
                        evt.preventDefault();
                    }

                    if (isEnterKey(keyboardEvent) ||
                            isSpaceKey(keyboardEvent)
                            || isKeyOf("tab", keyboardEvent)) {
                        doSelectOption(option);
                        evt.preventDefault();
                    }
                }
            }
        }

        private void focusNext(SelectOption option) {
            int i = options.indexOf(option);
            if (i == options.size() - 1) {
                options.get(0).focus();
            } else {
                options.get(i + 1).focus();
            }
        }

        private void focusPrev(SelectOption option) {
            int i = options.indexOf(option);
            if (i == 0) {
                options.get(options.size() - 1).focus();
            } else {
                options.get(i - 1).focus();
            }
        }
    }
}
