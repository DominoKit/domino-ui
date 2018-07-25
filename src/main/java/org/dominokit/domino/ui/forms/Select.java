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

public class Select<T> extends BasicFormElement<Select<T>, T> implements Focusable<Select<T>> {

    private static final String OPEN = "open";
    private static final String CLICK = "click";
    private static final String KEYDOWN = "keydown";
    private static final String FOCUSED = "focused";

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private SelectElement selectElement = SelectElement.create();
    private HTMLElement leftAddonContainer = Elements.div().css("input-addon-container").asElement();
    private HTMLElement rightAddonContainer = Elements.div().css("input-addon-container").asElement();
    private List<SelectOption<T>> options = new LinkedList<>();
    private SelectOption<T> selectedOption;
    private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();
    private SelectionHandler<T> autoValidationHandler;
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
            if (!element.isEqualNode(this.selectElement.getFormControl()))
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

    public Select(List<SelectOption<T>> options) {
        this("", options);
    }

    public Select(String label, List<SelectOption<T>> options) {
        this(label);
        options.forEach(this::addOption);
    }

    public void open() {
        selectElement.getFormControl().classList.add(OPEN);
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
        close(selectElement.getFormControl());
        selectElement.getSelectMenu().focus();
    }

    private boolean isOpened() {
        return selectElement.asElement().classList.contains(OPEN);
    }

    public static <T> Select<T> create() {
        return new Select<>();
    }

    public static <T> Select<T> create(String label) {
        return new Select<>(label);
    }

    public static <T> Select<T> create(String label, List<SelectOption<T>> options) {
        return new Select<>(label, options);
    }

    public static <T> Select create(List<SelectOption<T>> options) {
        return new Select<>(options);
    }

    public Select<T> addOption(SelectOption<T> option) {
        options.add(option);
        option.asElement().addEventListener(CLICK, evt -> {
            doSelectOption(option);
            evt.stopPropagation();
        });
        appendOptionValue(option);
        return this;
    }

    private void doSelectOption(SelectOption<T> option) {
        if (isEnabled()) {
            select(option);
            close();
        }
    }

    private void appendOptionValue(SelectOption<T> option) {
        selectElement.getOptionsList().appendChild(option.asElement());
        selectElement.getSelectMenu().appendChild(Elements.option().attr("value", option.getKey())
                .textContent(option.getDisplayValue())
                .asElement());
    }

    public Select<T> selectAt(int index) {
        return selectAt(index, false);
    }

    public Select<T> selectAt(int index, boolean silent) {
        if (index < options.size() && index >= 0)
            select(options.get(index), silent);
        return this;
    }

    public SelectOption<T> getOptionAt(int index) {
        if (index < options.size() && index >= 0)
            return options.get(index);
        return null;
    }

    public List<SelectOption<T>> getOptions() {
        return options;
    }

    public Select<T> select(SelectOption<T> option) {
        return select(option, false);
    }

    public Select<T> select(SelectOption<T> option, boolean silent) {
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

    private void onSelection(SelectOption<T> option) {
        for (SelectionHandler<T> handler : selectionHandlers)
            handler.onSelection(option);
    }

    public Select<T> addSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    public SelectOption<T> getSelectedOption() {
        return selectedOption;
    }

    @Override
    public Select<T> enable() {
        super.enable();
        selectElement.getFormControl().classList.remove("disabled");
        getSelectButton().classList.remove("disabled");
        getSelectMenu().classList.remove("disabled");
        Style.of(getLabelElement()).removeProperty("cursor");
        return this;
    }

    @Override
    public Select<T> disable() {
        super.disable();
        selectElement.getFormControl().classList.add("disabled");
        getSelectButton().classList.add("disabled");
        getSelectMenu().classList.add("disabled");
        Style.of(getLabelElement()).setProperty("cursor", "not-allowed");
        return this;
    }

    public Select<T> dropup() {
        selectElement.getFormControl().classList.remove("dropup");
        selectElement.getFormControl().classList.add("dropup");
        return this;
    }

    public Select<T> dropdown() {
        selectElement.getFormControl().classList.remove("dropup");
        return this;
    }

    @Override
    public Select<T> setValue(T value) {
        return setValue(value, false);
    }

    public Select<T> setValue(T value, boolean silent) {
        for (SelectOption<T> option : getOptions()) {
            if (Objects.equals(option.getValue(), value)) {
                select(option, silent);
            }
        }
        return this;
    }

    @Override
    public T getValue() {
        return isSelected() ? getSelectedOption().getValue() : null;
    }

    @Override
    public boolean isEmpty() {
        return isNull(selectedOption);
    }

    @Override
    public Select<T> clear() {
        selectElement.getSelectLabel().classList.remove(FOCUSED);
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        selectedOption = null;
        selectElement.getSelectedValueContainer().textContent = "";
        if (isAutoValidation())
            validate();
        return this;
    }

    public Select<T> setFormId(String formId) {
        getSelectMenu().setAttribute("form", formId);
        return this;
    }

    @Override
    public Select<T> invalidate(String errorMessage) {
        selectElement.getFormControl().classList.add("fc-" + Color.RED.getStyle());
        selectElement.getSelectLabel().classList.add(Color.RED.getStyle());
        removeLeftAddonColor(focusColor);
        setLeftAddonColor(Color.RED);
        return super.invalidate(errorMessage);
    }

    @Override
    public Select<T> clearInvalid() {
        selectElement.getFormControl().classList.remove("fc-" + Color.RED.getStyle());
        selectElement.getSelectLabel().classList.remove(Color.RED.getStyle());
        removeLeftAddonColor(Color.RED);
        return super.clearInvalid();
    }

    public Select<T> removeSelectionHandler(SelectionHandler selectionHandler) {
        if (nonNull(selectionHandler))
            selectionHandlers.remove(selectionHandler);
        return this;
    }

    @Override
    public Select<T> focus() {
        if (isEnabled() && !isReadOnly()) {
            selectElement.getSelectMenu().classList.add(FOCUSED);
            selectElement.getSelectLabel().classList.add(focusColor.getStyle());
            selectElement.getFormControl().classList.add("fc-" + focusColor.getStyle());
            setLeftAddonColor(focusColor);
            selectElement.getSelectMenu().focus();
        }
        return this;
    }

    @Override
    public Select<T> unfocus() {
        selectElement.getSelectMenu().classList.remove(FOCUSED);
        selectElement.getSelectLabel().classList.remove(focusColor.getStyle());
        selectElement.getFormControl().classList.remove("fc-" + focusColor.getStyle());
        removeLeftAddonColor(focusColor);
        return this;
    }

    private void setLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.classList.add(focusColor.getStyle());
    }

    private void removeLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.classList.remove(focusColor.getStyle());
    }

    @Override
    public boolean isFocused() {
        return selectElement.getSelectMenu().classList.contains(FOCUSED);
    }

    @Override
    public Select<T> setFocusColor(Color focusColor) {
        unfocus();
        this.focusColor = focusColor;
        if (isFocused())
            focus();
        return this;
    }

    public Select<T> removeOption(SelectOption<T> option) {
        if (nonNull(option) && getOptions().contains(option)) {
            option.deselect(true);
            options.remove(option);
            option.asElement().remove();
        }
        return this;
    }

    public Select<T> removeOptions(Collection<SelectOption<T>> options) {
        if (nonNull(options) && !options.isEmpty() && !this.options.isEmpty()) {
            options.forEach(this::removeOption);
        }
        return this;
    }

    public Select<T> removeAllOptions() {
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
    public interface SelectionHandler<T> {
        void onSelection(SelectOption<T> option);
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
    public Select<T> setAutoValidation(boolean autoValidation) {
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


    public Select<T> setLeftAddon(IsElement leftAddon) {
        return setLeftAddon(leftAddon.asElement());
    }

    public Select<T> setLeftAddon(Element leftAddon) {
        setAddon(leftAddonContainer, this.leftAddon, leftAddon);
        this.leftAddon = leftAddon;
        return this;
    }

    public Select<T> setRightAddon(IsElement rightAddon) {
        return setRightAddon(rightAddon.asElement());
    }

    public Select<T> setRightAddon(Element rightAddon) {
        setAddon(rightAddonContainer, this.rightAddon, rightAddon);
        this.rightAddon = rightAddon;
        return this;
    }

    public Select<T> removeRightAddon() {
        if (nonNull(rightAddon)) {
            rightAddonContainer.removeChild(rightAddon);
        }
        return this;
    }

    public Select<T> removeLeftAddon() {
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
    protected HTMLElement getFieldContainer() {
        return selectElement.asElement();
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }

    @Templated
    public static abstract class SelectElement implements IsElement<HTMLDivElement> {

        @DataElement
        HTMLDivElement formControl;

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

        public HTMLDivElement getFormControl() {
            return formControl;
        }
    }

    private final class NavigateOptionsKeyListener implements EventListener {

        @Override
        public void handleEvent(Event evt) {
            KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
            HTMLElement element = Js.uncheckedCast(keyboardEvent.target);
            for (SelectOption<T> option : options) {
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

        private void focusNext(SelectOption<T> option) {
            int i = options.indexOf(option);
            if (i == options.size() - 1) {
                options.get(0).focus();
            } else {
                options.get(i + 1).focus();
            }
        }

        private void focusPrev(SelectOption<T> option) {
            int i = options.indexOf(option);
            if (i == 0) {
                options.get(options.size() - 1).focus();
            } else {
                options.get(i - 1).focus();
            }
        }
    }
}
