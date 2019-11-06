package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.*;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.dropdown.DropdownActionsGroup;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
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
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Select<T> extends AbstractValueBox<Select<T>, HTMLElement, T> {

    private static final String CLICK_EVENT = "click";
    private static final String FOCUSED = "focused";

    private SelectOption<T> noneOption = SelectOption.create(null, "none", "None");

    private DominoElement<HTMLButtonElement> buttonElement;
    private DominoElement<HTMLElement> buttonValueContainer = DominoElement.of(span().css("select-value", Styles.ellipsis_text));
    private DropDownMenu optionsMenu;

    private LinkedList<SelectOption<T>> options = new LinkedList<>();
    private SelectOption<T> selectedOption;
    private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();
    private SelectionHandler<T> autoValidationHandler;
    private Supplier<BaseIcon<?>> arrowIconSupplier = Icons.ALL::menu_down_mdi;
    private BaseIcon<?> arrowIcon;

    private List<ChangeHandler<? super T>> changeHandlers = new ArrayList<>();

    private boolean searchable;
    private boolean valid = true;
    private boolean clearable;
    private FlexItem arrowIconContainer;

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
        super("button", "");
        optionsMenu = DropDownMenu.create(fieldContainer).styler(style1 -> style1.add("select-option-menu"));
        optionsMenu.setAppendTarget(fieldContainer.asElement());
        optionsMenu.setAppendStrategy(DropDownMenu.AppendStrategy.FIRST);
        optionsMenu.setPosition(new PopupPositionTopDown(this));
        buttonElement.appendChild(buttonValueContainer);
        initListeners();
        dropdown();
        setSearchable(true);
        addChangeHandler(value -> {
            if (isNull(value)) {
                clear();
            }
        });
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
        if (nonNull(arrowIcon)) {
            arrowIcon.addClickListener(clickListener);
        }

        buttonElement.addEventListener(CLICK_EVENT, clickListener);
        getLabelElement().addEventListener(CLICK_EVENT, clickListener);
        buttonElement.addEventListener("focus", evt -> focus());
        buttonElement.addEventListener("blur", evt -> unfocus());
        optionsMenu.addCloseHandler(this::doFocus);
    }

    public void setArrowIconSupplier(Supplier<BaseIcon<?>> arrowIconSupplier) {
        if (nonNull(arrowIconSupplier)) {
            this.arrowIconSupplier = arrowIconSupplier;
        }
    }

    public Select<T> open() {
        if (isEnabled() && !isReadOnly()) {
            DropDownMenu.closeAllMenus();
            doOpen();
        }
        return this;
    }

    private void doOpen() {
        optionsMenu.open();
        optionsMenu.styler(style -> style.setWidth(getFieldContainer().getBoundingClientRect().width + "px"));
    }

    public void close() {
        optionsMenu.close();
    }

    public Select<T> divider() {
        optionsMenu.separator();
        return this;
    }

    public Select<T> addGroup(SelectOptionGroup<T> group) {
        DropdownActionsGroup<T> dropdownActionsGroup = DropdownActionsGroup.create(group.getTitleElement());
        for (SelectOption<T> option : group.getOptions()) {
            addOptionToGroup(dropdownActionsGroup, option);
        }
        group.setAddOptionConsumer(selectOption -> {
            addOptionToGroup(dropdownActionsGroup, selectOption);
        });

        optionsMenu.addGroup(dropdownActionsGroup);
        return this;
    }

    private void addOptionToGroup(DropdownActionsGroup<T> dropdownActionsGroup, SelectOption<T> option) {
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

    public Select<T> insertFirst(SelectOption<T> option) {
        options.add(0, option);
        insertFirstOptionValue(option);
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

    private void insertFirstOptionValue(SelectOption<T> option) {
        optionsMenu.insertFirst(asDropDownAction(option));
    }

    private DropdownAction<T> asDropDownAction(SelectOption<T> option) {
        return DropdownAction.create(option.getValue(), option.asElement())
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
        floatLabel();
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
        getLabelElement().enable();
        return this;
    }

    @Override
    public Select<T> disable() {
        super.disable();
        buttonElement.disable();
        getLabelElement().disable();
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !buttonElement.hasAttribute("disabled");
    }

    public Select<T> dropup() {
        optionsMenu.appendChild(optionsMenu.getSearchContainer());
        optionsMenu
                .getSearchContainer()
                .style()
                .remove("pos-top")
                .add("pos-bottom");
        optionsMenu
                .style()
                .remove("pos-top")
                .add("pos-bottom");
        return this;
    }

    public Select<T> dropdown() {
        optionsMenu.insertFirst(optionsMenu.getSearchContainer());
        optionsMenu.getSearchContainer()
                .style()
                .remove("pos-bottom")
                .add("pos-top");
        optionsMenu
                .style()
                .remove("pos-bottom")
                .add("pos-top");
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

    /**
     * @deprecated use {@link #selectByKey(String)}
     */
    @Deprecated
    public Select<T> setKey(String key) {
        return selectByKey(key);
    }

    /**
     * @deprecated use {@link #selectByKey(String, boolean)}
     */
    @Deprecated
    public Select<T> setKey(String key, boolean silent) {
        return selectByKey(key, silent);
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
        unfloatLabel();
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        selectedOption = null;
        buttonValueContainer.setTextContent("");
        if (isAutoValidation())
            validate();
        return this;
    }


    public Select<T> removeSelectionHandler(SelectionHandler selectionHandler) {
        if (nonNull(selectionHandler))
            selectionHandlers.remove(selectionHandler);
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
        if (isClearable()) {
            setClearable(true);
        }
        return this;
    }

    @Override
    public Select<T> setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        if (readOnly) {
            arrowIconContainer.hide();
            floatLabel();
        } else {
            arrowIconContainer.show();
            if (isEmpty()) {
                unfloatLabel();
            }
        }
        buttonElement.setReadOnly(readOnly);
        return this;
    }

    @FunctionalInterface
    public interface SelectionHandler<T> {
        void onSelection(SelectOption<T> option);
    }

    public DominoElement<HTMLButtonElement> getSelectButton() {
        return buttonElement;
    }

    public DominoElement<HTMLLabelElement> getSelectLabel() {
        return getLabelElement();
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

    public Select<T> setClearable(boolean clearable) {
        this.clearable = clearable;
        if (clearable && !options.contains(noneOption)) {
            insertFirst(noneOption);
        } else {
            removeOption(noneOption);
        }
        return this;
    }

    public boolean isClearable() {
        return clearable;
    }

    public Select<T> setClearableText(String clearableText) {
        noneOption.setDisplayValue(clearableText);
        return this;
    }

    public String getClearableText() {
        return noneOption.getDisplayValue();
    }

    @Override
    protected DominoElement<HTMLElement> getHelperContainer() {
        //TODO implement this
        return null;
    }

    @Override
    protected HTMLElement createInputElement(String type) {
        buttonElement = DominoElement.of(button().attr("type", "button").css("select-button"));
        return buttonElement.asElement();
    }

    @Override
    protected FlexItem createMandatoryAddOn() {
        if (isNull(arrowIconSupplier)) {
            arrowIcon = Icons.ALL.menu_down_mdi()
                    .clickable();
        } else {
            arrowIcon = arrowIconSupplier.get()
                    .clickable();
        }
        arrowIconContainer = FlexItem.create().appendChild(arrowIcon);
        return arrowIconContainer;
    }

    @Override
    protected void clearValue() {

    }

    @Override
    protected void doSetValue(T value) {

    }

    public static class PopupPositionTopDown implements DropDownPosition {

        private DropDownPositionUp up = new DropDownPositionUp();
        private DropDownPositionDown down = new DropDownPositionDown();

        private final Select<?> select;

        public PopupPositionTopDown(Select<?> select) {
            this.select = select;
        }

        @Override
        public void position(HTMLElement popup, HTMLElement target) {
            ClientRect targetRect = target.getBoundingClientRect();

            double distanceToMiddle = ((targetRect.top) - (targetRect.height / 2));
            double windowMiddle = DomGlobal.window.innerHeight / 2;

            if (distanceToMiddle >= windowMiddle) {
                up.position(popup, target);
                select.dropup();
                popup.setAttribute("popup-direction", "top");
            } else {
                down.position(popup, target);
                select.dropdown();
                popup.setAttribute("popup-direction", "down");
            }

            popup.style.setProperty("width", targetRect.width + "px");
            popup.style.setProperty("left", px.of(0));
        }
    }

    public static class DropDownPositionUp implements DropDownPosition {
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {
            actionsMenu.style.setProperty("bottom", px.of(-1));
            actionsMenu.style.removeProperty("top");
        }
    }

    public static class DropDownPositionDown implements DropDownPosition {
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {
            actionsMenu.style.removeProperty("bottom");
            actionsMenu.style.setProperty("top", px.of(0));
        }
    }
}
