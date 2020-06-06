package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.dropdown.DropdownActionsGroup;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.button;
import static org.jboss.elemento.Elements.span;

public abstract class AbstractSelect<T, V, S extends AbstractSelect<T, V, S>> extends AbstractValueBox<S, HTMLElement, T> {
    private static final String CLICK_EVENT = "click";

    private SelectOption<V> noneOption = SelectOption.create(null, "none", "None");

    private DominoElement<HTMLButtonElement> buttonElement;
    protected DominoElement<HTMLElement> buttonValueContainer = DominoElement.of(span().css("select-value", Styles.ellipsis_text));
    protected LinkedList<SelectOption<V>> options = new LinkedList<>();
    private DropDownMenu optionsMenu;
    private List<SelectionHandler<V>> selectionHandlers = new ArrayList<>();
    private Supplier<BaseIcon<?>> arrowIconSupplier = Icons.ALL::menu_down_mdi;
    private BaseIcon<?> arrowIcon;

    private boolean searchable;
    private boolean clearable;
    private FlexItem arrowIconContainer;
    private int popupWidth = 0;
    private String dropDirection = "auto";
    private boolean closePopOverOnOpen = false;
    private boolean autoCloseOnSelect = true;

    public AbstractSelect() {
        super("button", "");
        optionsMenu = DropDownMenu.create(fieldContainer).styler(style1 -> style1.add("select-option-menu"));
        optionsMenu.setAppendTarget(DomGlobal.document.body);
        optionsMenu.setAppendStrategy(DropDownMenu.AppendStrategy.FIRST);
        optionsMenu.setPosition(new PopupPositionTopDown<>(this));
        optionsMenu.addOpenHandler(this::resumeFocusValidation);
        buttonElement.appendChild(buttonValueContainer);
        initListeners();
        dropdown();
        setSearchable(true);
        addChangeHandler(value -> {
            if (isNull(value)) {
                clear();
            }
        });
        css("d-select");
    }

    public AbstractSelect(String label) {
        this();
        setLabel(label);
    }

    public AbstractSelect(List<SelectOption<V>> options) {
        this("", options);
    }

    public AbstractSelect(String label, List<SelectOption<V>> options) {
        this(label);
        options.forEach(this::appendChild);
    }

    private void initListeners() {
        EventListener clickListener = evt -> {
            pauseFocusValidation();
            if (closePopOverOnOpen) {
                ModalBackDrop.closePopovers();
            }
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
        optionsMenu.addCloseHandler(() -> {
            this.focus();
            validate();
        });
    }

    public void setArrowIconSupplier(Supplier<BaseIcon<?>> arrowIconSupplier) {
        if (nonNull(arrowIconSupplier)) {
            this.arrowIconSupplier = arrowIconSupplier;
        }
    }

    @Override
    public S clear() {
        unfloatLabel();
        getOptions().forEach(selectOption -> selectOption.deselect(true));
        buttonValueContainer.setTextContent("");
        if (isAutoValidation())
            validate();
        return (S) this;
    }

    public S open() {
        if (isEnabled() && !isReadOnly()) {
            DropDownMenu.closeAllMenus();
            doOpen();
        }
        return (S) this;
    }

    private void doOpen() {
        optionsMenu.open();
        optionsMenu.styler(style -> style.setWidth(getFieldInputContainer().getBoundingClientRect().width + "px"));
    }

    public void close() {
        optionsMenu.close();
    }

    public S divider() {
        optionsMenu.separator();
        return (S) this;
    }

    public S addGroup(SelectOptionGroup<V> group) {
        DropdownActionsGroup<SelectOption<V>> dropdownActionsGroup = DropdownActionsGroup.create(group.getTitleElement());
        for (SelectOption<V> option : group.getOptions()) {
            addOptionToGroup(dropdownActionsGroup, option);
        }
        group.setAddOptionConsumer(selectOption -> {
            addOptionToGroup(dropdownActionsGroup, selectOption);
        });

        optionsMenu.addGroup(dropdownActionsGroup);
        return (S) this;
    }

    private void addOptionToGroup(DropdownActionsGroup<SelectOption<V>> dropdownActionsGroup, SelectOption<V> option) {
        dropdownActionsGroup.appendChild(asDropDownAction(option));
        options.add(option);
    }

    public S addOptions(List<SelectOption<V>> options) {
        options.forEach(this::appendChild);
        return (S) this;
    }

    public S setPopupWidth(int width) {
        this.popupWidth = width;
        return (S) this;
    }

    public S appendChild(SelectOption<V> option) {
        options.add(option);
        appendOptionValue(option);
        return (S) this;
    }

    public S insertFirst(SelectOption<V> option) {
        options.add(0, option);
        insertFirstOptionValue(option);
        return (S) this;
    }

    private void doSelectOption(SelectOption<V> option) {
        if (isEnabled()) {
            select(option);
            if(this.autoCloseOnSelect) {
                close();
            }
        }
    }

    private void appendOptionValue(SelectOption<V> option) {
        optionsMenu.appendChild(asDropDownAction(option));
    }

    private void insertFirstOptionValue(SelectOption<V> option) {
        optionsMenu.insertFirst(asDropDownAction(option));
    }

    private DropdownAction<SelectOption<V>> asDropDownAction(SelectOption<V> option) {
        return DropdownAction.create(option, option.element())
                .setAutoClose(this.autoCloseOnSelect)
                .setExcludeFromSearchResults(option.isExcludeFromSearchResults())
                .addSelectionHandler(value -> doSelectOption(option));
    }

    public S selectAt(int index) {
        return selectAt(index, false);
    }

    public S selectAt(int index, boolean silent) {
        if (index < options.size() && index >= 0)
            select(options.get(index), silent);
        return (S) this;
    }

    public SelectOption<V> getOptionAt(int index) {
        if (index < options.size() && index >= 0)
            return options.get(index);
        return null;
    }

    public List<SelectOption<V>> getOptions() {
        return options;
    }

    public S select(SelectOption<V> option) {
        return select(option, false);
    }

    public abstract S select(SelectOption<V> option, boolean silent);

    public boolean isSelected() {
        return !isEmpty();
    }

    protected void onSelection(SelectOption<V> option) {
        for (SelectionHandler<V> handler : selectionHandlers) {
            handler.onSelection(option);
        }
        for (ChangeHandler<? super T> c : changeHandlers) {
            c.onValueChanged(getValue());
        }
    }

    public S addSelectionHandler(SelectionHandler<V> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return (S) this;
    }

    @Override
    public S enable() {
        super.enable();
        buttonElement.enable();
        getLabelElement().enable();
        return (S) this;
    }

    @Override
    public S disable() {
        super.disable();
        buttonElement.disable();
        getLabelElement().disable();
        return (S) this;
    }

    @Override
    public boolean isEnabled() {
        return !buttonElement.hasAttribute("disabled");
    }

    public S dropup() {
        this.dropDirection = "up";
        return (S) this;
    }

    private void onDropup() {
        if (searchable) {
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
        }
    }

    public S dropdown() {
        this.dropDirection = "down";
        return (S) this;
    }

    private void onDropdown() {
        if (searchable) {
            optionsMenu.insertFirst(optionsMenu.getSearchContainer());
            optionsMenu.getSearchContainer()
                    .style()
                    .remove("pos-bottom")
                    .add("pos-top");
            optionsMenu
                    .style()
                    .remove("pos-bottom")
                    .add("pos-top");
        }
    }

    private MdiIcon getDropdownIcon() {
        return Icons.ALL.menu_down_mdi();
    }

    private MdiIcon getDropupIcon() {
        return Icons.ALL.menu_up_mdi();
    }

    @Override
    public S value(T value) {
        return setValue(value, false);
    }

    public abstract S setValue(T value, boolean silent);

    public S removeSelectionHandler(SelectionHandler selectionHandler) {
        if (nonNull(selectionHandler))
            selectionHandlers.remove(selectionHandler);
        return (S) this;
    }

    public S removeOption(SelectOption<V> option) {
        if (nonNull(option) && getOptions().contains(option)) {
            option.deselect(true);
            option.element().remove();
        }
        return (S) this;
    }

    public S removeOptions(Collection<SelectOption<V>> options) {
        if (nonNull(options) && !options.isEmpty() && !this.options.isEmpty()) {
            options.forEach(this::removeOption);
        }
        return (S) this;
    }

    public S removeAllOptions() {
        options.clear();
        optionsMenu.clearActions();
        clear();
        if (isClearable()) {
            setClearable(true);
        }
        return (S) this;
    }

    @Override
    public S setReadOnly(boolean readOnly) {
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
        return (S) this;
    }

    @FunctionalInterface
    public interface SelectionHandler<V> {
        void onSelection(SelectOption<V> option);
    }

    public DominoElement<HTMLButtonElement> getSelectButton() {
        return buttonElement;
    }

    public DominoElement<HTMLLabelElement> getSelectLabel() {
        return getLabelElement();
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new SelectAutoValidator<>(this, autoValidate);
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

    public List<V> getValues() {
        return options.stream().map(SelectOption::getValue).collect(Collectors.toList());
    }

    public List<String> getKeys() {
        return options.stream().map(SelectOption::getKey).collect(Collectors.toList());
    }

    public boolean containsKey(String key) {
        return getKeys().contains(key);
    }

    public boolean containsValue(V value) {
        return getValues().contains(value);
    }

    public S setSearchable(boolean searchable) {
        optionsMenu.setSearchable(searchable);
        this.searchable = searchable;
        return (S) this;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public static void closeAllSelects() {
        DropDownMenu.closeAllMenus();
    }

    public S selectByKey(String key) {
        return selectByKey(key, false);
    }

    public S selectByKey(String key, boolean silent) {
        for (SelectOption<V> option : getOptions()) {
            if (option.getKey().equals(key)) {
                select(option, silent);
            }
        }
        return (S) this;
    }

    public S setClearable(boolean clearable) {
        this.clearable = clearable;
        if (clearable && !options.contains(noneOption)) {
            insertFirst(noneOption);
        } else {
            removeOption(noneOption);
        }
        return (S) this;
    }

    public boolean isClearable() {
        return clearable;
    }

    public S setClearableText(String clearableText) {
        noneOption.setDisplayValue(clearableText);
        return (S) this;
    }

    public String getClearableText() {
        return noneOption.getDisplayValue();
    }

    public String getDropDirection() {
        return dropDirection;
    }

    public DominoElement<HTMLElement> getButtonValueContainer() {
        return buttonValueContainer;
    }

    public S setDropPosition(DropDownPosition dropPosition) {
        optionsMenu.setPosition(dropPosition);
        return (S) this;
    }

    @Override
    protected HTMLElement createInputElement(String type) {
        buttonElement = DominoElement.of(button().attr("type", "button").css("select-button"));
        return buttonElement.element();
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

    public S setSearchFilter(DropDownMenu.SearchFilter searchFilter) {
        this.optionsMenu.setSearchFilter(searchFilter);
        return (S) this;
    }

    public DropDownMenu getOptionsMenu() {
        return optionsMenu;
    }

    public boolean isClosePopOverOnOpen() {
        return closePopOverOnOpen;
    }

    public S setClosePopOverOnOpen(boolean closePopOverOnOpen) {
        this.closePopOverOnOpen = closePopOverOnOpen;
        return (S) this;
    }

    public boolean isAutoCloseOnSelect() {
        return autoCloseOnSelect;
    }

    public S setAutoCloseOnSelect(boolean autoCloseOnSelect) {
        this.autoCloseOnSelect = autoCloseOnSelect;
        optionsMenu.getActions()
                .forEach(dropdownAction -> dropdownAction.setAutoClose(autoCloseOnSelect));
        return (S) this;
    }

    public static class PopupPositionTopDown<T, V, S extends AbstractSelect<T, V, S>> implements DropDownPosition {

        private DropDownPositionUp up = new DropDownPositionUp();
        private DropDownPositionDown down = new DropDownPositionDown();

        private final AbstractSelect<T, V, S> select;

        public PopupPositionTopDown(AbstractSelect<T, V, S> select) {
            this.select = select;
        }

        @Override
        public void position(HTMLElement popup, HTMLElement target) {
            ClientRect targetRect = target.getBoundingClientRect();

            double distanceToMiddle = ((targetRect.top) - (targetRect.height / 2));
            double windowMiddle = DomGlobal.window.innerHeight / 2;
            double popupHeight = popup.getBoundingClientRect().height;
            double distanceToBottom = window.innerHeight - targetRect.top;
            double distanceToTop = (targetRect.top + targetRect.height);

            boolean hasSpaceBelow = distanceToBottom > popupHeight;
            boolean hasSpaceUp = distanceToTop > popupHeight;

            if (("up".equalsIgnoreCase(select.dropDirection) && hasSpaceUp) || ((distanceToMiddle >= windowMiddle) && !hasSpaceBelow)) {
                up.position(popup, target);
                select.onDropup();
                popup.setAttribute("popup-direction", "top");
            } else {
                down.position(popup, target);
                select.onDropdown();
                popup.setAttribute("popup-direction", "down");
            }

            popup.style.setProperty("width", select.popupWidth > 0 ? (select.popupWidth + "px") : (targetRect.width + "px"));
        }
    }

    public static class DropDownPositionUp implements DropDownPosition {
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {

            ClientRect targetRect = target.getBoundingClientRect();

            actionsMenu.style.setProperty("bottom", px.of(((window.innerHeight - targetRect.bottom) - window.pageYOffset)));
            actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
            actionsMenu.style.removeProperty("top");
        }
    }

    public static class DropDownPositionDown implements DropDownPosition {
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {

            ClientRect targetRect = target.getBoundingClientRect();

            actionsMenu.style.setProperty("top", px.of((targetRect.top + window.pageYOffset)));
            actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
            actionsMenu.style.removeProperty("bottom");
        }
    }

    private static class SelectAutoValidator<T, V, S extends AbstractSelect<T, V, S>> extends AutoValidator {

        private AbstractSelect<T, V, S> select;
        private SelectionHandler<V> selectionHandler;

        public SelectAutoValidator(AbstractSelect<T, V, S> select, AutoValidate autoValidate) {
            super(autoValidate);
            this.select = select;
        }

        @Override
        public void attach() {
            selectionHandler = option -> autoValidate.apply();
            select.addSelectionHandler(selectionHandler);
        }

        @Override
        public void remove() {
            select.removeSelectionHandler(selectionHandler);
        }
    }
}
