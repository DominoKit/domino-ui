package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.*;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.dropdown.DropdownActionsGroup;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Focusable;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.dominokit.domino.ui.utils.IsReadOnly;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Select<T> extends BasicFormElement<Select<T>, T> implements Focusable<Select<T>>, IsReadOnly<Select<T>>, HasChangeHandlers<Select<T>, T> {

    private static final String CLICK_EVENT = "click";
    private static final String FOCUSED = "focused";

    private DominoElement<HTMLDivElement> container = DominoElement.of(div().css("form-group"));
    private DominoElement<HTMLDivElement> formLine = DominoElement.of(div().css("form-line"));
    private DominoElement<HTMLDivElement> formControl = DominoElement.of(div().css("form-control"));
    private DominoElement<HTMLDivElement> leftAddonContainer = DominoElement.of(div().css("input-addon-container"));
    private DominoElement<HTMLDivElement> rightAddonContainer = DominoElement.of(div().css("input-addon-container"));
    private DominoElement<HTMLElement> leftAddon;
    private DominoElement<HTMLElement> rightAddon;

    private DominoElement<HTMLButtonElement> buttonElement = DominoElement.of(button().attr("type", "button").css("select-button"));
    private DominoElement<HTMLElement> buttonValueContainer = DominoElement.of(span().css("select-value", Styles.ellipsis_text));
    private DominoElement<HTMLDivElement> iconContainer = DominoElement.of(div().css(Styles.pull_right));
    private DropDownMenu optionsMenu = DropDownMenu.create(buttonElement).styler(style1 -> style1.add("select-option-menu"));
    private DominoElement<HTMLLabelElement> labelElement = DominoElement.of(label().css("form-label", "select-label"));


    private LinkedList<SelectOption<T>> options = new LinkedList<>();
    private SelectOption<T> selectedOption;
    private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();
    private SelectionHandler<T> autoValidationHandler;

    private List<ChangeHandler<? super T>> changeHandlers = new ArrayList<>();

    private Color focusColor = Color.BLUE;
    private boolean readOnly;
    private boolean searchable;
    private boolean valid = true;
    private boolean focused;

    public static <T> Select<T> create() {
        return new Select<>();
    }

    public static <T> Select<T> create(String label) {
        return new Select<>(label);
    }

    public static <T> Select<T> create(String label, List<SelectOption<T>> options) {
        return new Select<>(label, options);
    }

    public static <T> Select<T> create(List<SelectOption<T>> options) {
        return new Select<>(options);
    }

    public static <T extends Enum<T>> Select<T> ofEnum(String label, T[] values) {
        Select<T> select = create(label);
        for (T value : values) {
            select.appendChild(SelectOption.create(value, value.name(), value.toString()));
        }
        return select;
    }

    public Select() {
        initListeners();
        buttonElement
                .appendChild(buttonValueContainer)
                .appendChild(iconContainer);
        formControl
                .appendChild(buttonElement)
                .appendChild(labelElement);
        formLine.appendChild(formControl);
        container.appendChild(leftAddonContainer);
        container.appendChild(formLine.asElement());
        container.appendChild(rightAddonContainer);
        init(this);

        dropdown();

        setSearchable(true);
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
        options.forEach(this::appendChild);
    }

    private void initListeners() {
        EventListener clickListener = evt -> {
            open();
            evt.stopPropagation();
        };
        buttonElement.addEventListener(CLICK_EVENT, clickListener);
        labelElement.addEventListener(CLICK_EVENT, clickListener);
        buttonElement.addEventListener("focus", evt -> doFocus());
        buttonElement.addEventListener("blur", evt -> doUnfocus());
        optionsMenu.addCloseHandler(this::doFocus);
    }

    public Select<T> open() {
        if (isEnabled() && !isReadOnly()) {
            optionsMenu.closeAllMenus();
            doOpen();
        }
        return this;
    }

    private void doOpen() {
        optionsMenu.open();
        optionsMenu.styler(style -> style.setWidth(formControl.getBoundingClientRect().width + "px"));
    }

    public void close() {
        optionsMenu.close();
    }

    public Select<T> divider() {
        optionsMenu.separator();
        return this;
    }

    public Select<T> addGroup(SelectOptionGroup<T> group) {
        DropdownActionsGroup dropdownActionsGroup = DropdownActionsGroup.create(group.getTitleElement());
        for (SelectOption<T> option : group.getOptions()) {
            addOptionToGroup(dropdownActionsGroup, option);
        }
        group.setAddOptionConsumer(selectOption -> {
            addOptionToGroup(dropdownActionsGroup, selectOption);
        });

        optionsMenu.addGroup(dropdownActionsGroup);
        return this;
    }

    private void addOptionToGroup(DropdownActionsGroup dropdownActionsGroup, SelectOption<T> option) {
        dropdownActionsGroup.appendChild(asDropDownAction(option));
        options.add(option);
    }

    public Select<T> addOptions(List<SelectOption<T>> options) {
        options.forEach(this::appendChild);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(SelectOption)}
     */
    @Deprecated
    public Select<T> addOption(SelectOption<T> option) {
        return appendChild(option);
    }

    public Select<T> appendChild(SelectOption<T> option) {
        options.add(option);
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
        optionsMenu.appendChild(asDropDownAction(option));
    }

    private DropdownAction asDropDownAction(SelectOption<T> option) {
        return DropdownAction.create(option.getDisplayValue(), option.asElement())
                .addSelectionHandler(value -> doSelectOption(option));
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
            if (!option.isEqualNode(selectedOption.asElement()))
                selectedOption.deselect();
        labelElement.style().add(FOCUSED);
        this.selectedOption = option;
        option.select();
        buttonValueContainer.setTextContent(option.getDisplayValue());
        if (!silent)
            onSelection(option);
        return this;
    }

    public boolean isSelected() {
        return !isEmpty();
    }

    private void onSelection(SelectOption<T> option) {
        for (SelectionHandler<T> handler : selectionHandlers) {
            handler.onSelection(option);
        }

        for (ChangeHandler<? super T> c : changeHandlers) {
            c.onValueChanged(option.getValue());
        }
    }

    public Select<T> addSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public Select<T> addChangeHandler(ChangeHandler<? super T> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public Select<T> removeChangeHandler(ChangeHandler<? super T> changeHandler) {
        changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super T> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    public SelectOption<T> getSelectedOption() {
        return selectedOption;
    }

    @Override
    public Select<T> enable() {
        super.enable();
        buttonElement.enable();
        labelElement.enable();
        return this;
    }

    @Override
    public Select<T> disable() {
        super.disable();
        buttonElement.disable();
        labelElement.disable();
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !buttonElement.hasAttribute("disabled");
    }

    public Select<T> dropup() {
        optionsMenu.setPosition(DropDownPosition.TOP);
        iconContainer.clearElement()
                .appendChild(getDropupIcon());
        return this;
    }

    public Select<T> dropdown() {
        optionsMenu.setPosition(DropDownPosition.BOTTOM);
        iconContainer.clearElement().appendChild(getDropdownIcon());
        return this;
    }

    private MdiIcon getDropdownIcon() {
        return Icons.ALL.menu_down_mdi();
    }

    private MdiIcon getDropupIcon() {
        return Icons.ALL.menu_up_mdi();
    }

    @Override
    public Select<T> value(T value) {
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

    public Select<T> setKey(String key) {
        return setKey(key, false);
    }

    public Select<T> setKey(String key, boolean silent) {
        for (SelectOption<T> option : getOptions()) {
            if (option.getKey().equals(key)) {
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
        labelElement.style().remove(FOCUSED);
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        selectedOption = null;
        buttonValueContainer.setTextContent("");
        if (isAutoValidation())
            validate();
        return this;
    }

    @Override
    public Select<T> invalidate(String errorMessage) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessage);
    }

    @Override
    public Select<T> invalidate(List<String> errorMessages) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessages);
    }

    private void updateValidationStyles() {
        formControl.style().remove("fc-" + focusColor.getStyle());
        labelElement.style().remove(focusColor.getStyle());
        formControl.style().add("fc-" + Color.RED.getStyle());
        labelElement.style().add(Color.RED.getStyle());
        removeLeftAddonColor(focusColor);
        setLeftAddonColor(Color.RED);
    }

    @Override
    public Select<T> clearInvalid() {
        this.valid = true;
        formControl.style().remove("fc-" + Color.RED.getStyle());
        labelElement.style().remove(Color.RED.getStyle());
        if (isFocused()) {
            formControl.style().add("fc-" + focusColor.getStyle());
            labelElement.style().add(focusColor.getStyle());
        }

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
            if (!isAttached()) {
                onAttached(mutationRecord -> buttonElement.asElement().focus());
            } else {
                buttonElement.asElement().focus();
            }
        }
        return this;
    }

    @Override
    public Select<T> unfocus() {
        if (isEnabled() && !isReadOnly()) {
            if (!isAttached()) {
                onAttached(mutationRecord -> buttonElement.asElement().blur());
            } else {
                buttonElement.asElement().focus();
            }
        }
        return this;
    }

    private void doFocus() {
        if (isEnabled() && !isReadOnly()) {
            floatLabel();
            if (valid) {
                labelElement.style().add(focusColor.getStyle());
                formControl.style().add("fc-" + focusColor.getStyle());
                setLeftAddonColor(focusColor);
                buttonElement.asElement().focus();
                this.focused = true;
            }
        }
    }

    private void doUnfocus() {
        unfloatLabel();
        labelElement.style().remove(focusColor.getStyle());
        formControl.style().remove("fc-" + focusColor.getStyle());
        removeLeftAddonColor(focusColor);
        buttonElement.asElement().blur();
        this.focused = false;
    }

    protected void floatLabel() {
        getSelectLabel().style().add(FOCUSED);
    }

    protected void unfloatLabel() {
        if (isEmpty()) {
            getSelectLabel().style().remove(FOCUSED);
        }
    }

    private void setLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.style().add(focusColor.getStyle());
    }

    private void removeLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.style().remove(focusColor.getStyle());
    }

    @Override
    public boolean isFocused() {
        return focused;
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
        options.clear();
        optionsMenu.clearActions();
        clear();
        return this;
    }

    @Override
    public Select<T> setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        if (readOnly) {
            formControl.style().add("readonly");
            iconContainer.hide();
            floatLabel();
        } else {
            formControl.style().remove("readonly");
            iconContainer.show();
            if (isEmpty()) {
                unfloatLabel();
            }
        }
        buttonElement.setReadOnly(readOnly);
        return this;
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }

    @FunctionalInterface
    public interface SelectionHandler<T> {
        void onSelection(SelectOption<T> option);
    }

    public DominoElement<HTMLButtonElement> getSelectButton() {
        return buttonElement;
    }

    public DominoElement<HTMLLabelElement> getSelectLabel() {
        return labelElement;
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

    public Select<T> setLeftAddon(HTMLElement leftAddon) {
        setAddon(leftAddonContainer, this.leftAddon, leftAddon);
        this.leftAddon = DominoElement.of(leftAddon);
        return this;
    }

    public Select<T> setRightAddon(IsElement rightAddon) {
        return setRightAddon(rightAddon.asElement());
    }

    public Select<T> setRightAddon(HTMLElement rightAddon) {
        setAddon(rightAddonContainer, this.rightAddon, rightAddon);
        this.rightAddon = DominoElement.of(rightAddon);
        return this;
    }

    public DominoElement<HTMLDivElement> getLeftAddonContainer() {
        return leftAddonContainer;
    }

    public DominoElement<HTMLDivElement> getRightAddonContainer() {
        return rightAddonContainer;
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

    private void setAddon(DominoElement<HTMLDivElement> container, DominoElement oldAddon, Element addon) {
        if (nonNull(oldAddon)) {
            oldAddon.remove();
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

    public List<T> getValues() {
        return options.stream().map(SelectOption::getValue).collect(Collectors.toList());
    }

    public List<String> getKeys() {
        return options.stream().map(SelectOption::getKey).collect(Collectors.toList());
    }

    public boolean containsKey(String key) {
        return getKeys().contains(key);
    }

    public boolean containsValue(T value) {
        return getValues().contains(value);
    }

    public Select<T> setSearchable(boolean searchable) {
        optionsMenu.setSearchable(searchable);
        this.searchable = searchable;
        return this;
    }

    public boolean isSearchable() {
        return searchable;
    }

    @Override
    public DominoElement<HTMLDivElement> getInputElement() {
        return formLine;
    }

    @Override
    protected DominoElement<HTMLLabelElement> getLabelElement() {
        return labelElement;
    }

    @Override
    protected DominoElement<HTMLDivElement> getFieldContainer() {
        return formLine;
    }


    @Override
    public HTMLElement asElement() {
        return container.asElement();
    }

    @Override
    public String getStringValue() {
        SelectOption<T> selectedOption = getSelectedOption();
        if (nonNull(selectedOption)) {
            return selectedOption.getDisplayValue();
        }
        return null;
    }

    public int getSelectedIndex() {
        return options.indexOf(getSelectedOption());
    }

    public static void closeAllSelects() {
        DropDownMenu.closeAllMenus();
    }

    public Select<T> selectByKey(String key) {
        return selectByKey(key, false);
    }

    public Select<T> selectByKey(String key, boolean silent) {
        for (SelectOption<T> option : getOptions()) {
            if (option.getKey().equals(key)) {
                select(option, silent);
            }
        }
        return this;
    }

    public DropDownMenu getOptionsMenu() {
        return this.optionsMenu;
    }
}
