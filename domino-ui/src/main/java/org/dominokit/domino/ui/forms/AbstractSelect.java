package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItemsGroup;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;

public abstract class AbstractSelect<T, V, S extends Option<T>, C extends AbstractSelect<T, V, S, C>> extends AbstractFormElement<AbstractSelect<T, V,S, C>, V>
        implements HasInputElement<AbstractSelect<T, V, S, C>, HTMLInputElement>, HasPlaceHolder<AbstractSelect<T, V, S, C>> {

    protected Menu<T> optionsMenu;
    private DominoElement<HTMLDivElement> fieldInput;
    private DominoElement<HTMLElement> placeHolderElement = DominoElement.span();
    private DominoElement<HTMLInputElement> inputElement;

    public AbstractSelect() {
        addCss(FORM_SELECT);
        wrapperElement
                .appendChild(fieldInput = DominoElement.div()
                        .addCss(FIELD_INPUT)
                        .appendChild(placeHolderElement.addCss(FIELD_PLACEHOLDER))
                )
                .appendChild(inputElement = DominoElement.input(getType()).addCss(HIDDEN_INPUT));
        labelForId(inputElement.getDominoId());

        optionsMenu = Menu.<T>create()
                .setMenuAppendTarget(getWrapperElement().element())
                .setTargetElement(getWrapperElement())
                .setFitToTargetWidth(true)
                .addSelectionListener((source, selection) -> updateTextValue())
                .addCloseHandler(() -> focus())
                .addOnAddItemHandler((menu, menuItem) -> ((S)menuItem).bindValueTarget(fieldInput));

        KeyboardEvents.listenOnKeyDown(getInputElement().element())
                .onEnter(evt -> optionsMenu.open(true))
                .onSpace(evt -> optionsMenu.open(true));

        addPrimaryAddOn(Icons.ALL.chevron_down_mdi()
                .addCss(FORM_SELECT_DROP_ARROW)
                .clickable()
                .addClickListener(evt -> optionsMenu.open(true))
        );

        addPrimaryAddOn(Icons.ALL.delete_mdi()
                .addCss(FORM_SELECT_CLEAR)
                .clickable()
                .addClickListener(evt -> {
                            evt.stopPropagation();
                            clearValue(false);
                        }
                )
        );
    }

    private void updateTextValue() {
        getInputElement().element().value = getStringValue();
    }

    protected C clearValue(boolean silent) {
        if (!optionsMenu.getSelection().isEmpty()) {
            V oldValue = getValue();
            optionsMenu.withPauseSelectionListenersToggle(true, field -> {
                List<AbstractMenuItem<T, ?>> selected = optionsMenu.getSelection();
                new ArrayList<>(selected)
                        .forEach(AbstractMenuItem::deselect);
            });

            if (!silent) {
                optionsMenu.triggerDeselectionListeners(null, new ArrayList<>());
                triggerClearListeners(oldValue);
            }

            if (isAutoValidation()) {
                autoValidate();
            }
        }

        return (C) this;
    }


    public C appendChild(S option) {
        if (nonNull(option)) {
            optionsMenu.appendChild(option);
        }
        return (C) this;
    }

    public C appendOptions(Collection<S> options) {
        if (nonNull(options)) {
            options.forEach(this::appendChild);
        }
        return (C) this;
    }

    public C appendOptions(S... options) {
        if (nonNull(options)) {
            appendOptions(Arrays.asList(options));
        }
        return (C) this;
    }

    public <I> C appendItem(Function<I, S> mapper, I item){
        return appendChild(mapper.apply(item));
    }

    public <I> C appendItems(Function<I, S> mapper, Collection<I> items){
        items.forEach(item -> appendItem(mapper, item));
        return (C) this;
    }

    public <I> C appendItems(Function<I, S> mapper, I... items){
        appendItems(mapper, Arrays.asList(items));
        return (C) this;
    }

    @Override
    public String getPlaceholder() {
        return placeHolderElement.getTextContent();
    }

    @Override
    public C setPlaceholder(String placeholder) {
        placeHolderElement.setTextContent(placeholder);
        return (C) this;
    }

    @Override
    public DominoElement<HTMLInputElement> getInputElement() {
        return inputElement;
    }

    @Override
    public String getStringValue() {
        return optionsMenu.getSelection()
                .stream()
                .map(option -> String.valueOf(option.getValue()))
                .collect(Collectors.joining(","));
    }

    @Override
    public C focus() {
        inputElement.element().focus();
        return (C) this;
    }

    @Override
    public C unfocus() {
        inputElement.element().blur();
        return (C) this;
    }

    @Override
    public boolean isFocused() {
        if (nonNull(DomGlobal.document.activeElement)) {
            String dominoId =
                    DominoElement.of(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement))
                            .getDominoId();
            return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return optionsMenu.getSelection().isEmpty();
    }

    @Override
    public boolean isEmptyIgnoreSpaces() {
        return isEmpty();
    }

    @Override
    public boolean isEnabled() {
        return !getInputElement().isDisabled() && super.isEnabled();
    }

    @Override
    public C clear() {
        return clear(false);
    }

    @Override
    public C clear(boolean silent) {
        return clearValue(silent);
    }

    @Override
    public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
        return new SelectAutoValidator<>((C) this, autoValidate);
    }

    @Override
    public C triggerChangeListeners(V oldValue, V newValue) {
        getChangeListeners()
                .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
        return (C) this;
    }

    @Override
    public C triggerClearListeners(V oldValue) {
        getClearListeners()
                .forEach(clearListener -> clearListener.onValueCleared(oldValue));
        return (C) this;
    }

    @Override
    public String getName() {
        return getInputElement().element().name;
    }

    @Override
    public C setName(String name) {
        getInputElement().element().name = name;
        return (C) this;
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public C withValue(V value) {
        return withValue(value, isChangeListenersPaused());
    }

    public C addOptionsGroup(List<Option<T>> options, Menu.MenuItemsGroupHandler<T, Option<T>> groupHandler) {
        MenuItemsGroup<T, Option<T>> optionsGroup = new MenuItemsGroup<>(optionsMenu);
        optionsMenu.appendGroup(optionsGroup, groupHandler);
        options.forEach(option -> addItemToGroup(optionsGroup, option));
        return (C) this;

    }

    private void addItemToGroup(MenuItemsGroup<T, Option<T>> optionsGroup, Option<T> option) {
        optionsGroup.appendChild(option);
    }

    @Override
    public C withValue(V value, boolean silent) {
        V oldValue = getValue();
        if (!Objects.equals(value, oldValue)) {
            doSetValue(value);
            if (!silent) {
                triggerChangeListeners(oldValue, getValue());
            }
        }
        autoValidate();
        return (C) this;
    }

    //Should be abstract
    protected abstract void doSetValue(V value);

    @Override
    public void setValue(V value) {
        withValue(value);
    }

    public C selectOption(S option) {
        findOption(option)
                .ifPresent(menuItem -> menuItem.select(isChangeListenersPaused()));

        return (C) this;
    }

    public Optional<S> findOption(S option) {
        return Optional.ofNullable(option)
                .flatMap(vSelectionOption -> optionsMenu.getMenuItems()
                        .stream()
                        .filter(menuItem -> Objects.equals(option.getKey(), menuItem.getKey()))
                        .map(menuItem -> (S) menuItem)
                        .findFirst()
                );
    }

    public Optional<S> findOptionByKey(String key) {
        return optionsMenu.getMenuItems()
                .stream()
                .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
                .map(menuItem -> (S) menuItem)
                .findFirst();
    }

    public Optional<S> findOptionByValue(T value) {
        return optionsMenu.getMenuItems()
                .stream()
                .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
                .map(menuItem -> (S) menuItem)
                .findFirst();
    }

    public Optional<S> findOptionByIndex(int index) {
        if (index < optionsMenu.getMenuItems().size() && index >= 0) {
            return Optional.of((S) optionsMenu.getMenuItems().get(index));
        }
        return Optional.empty();
    }

    public C selectAt(int index) {
        findOptionByIndex(index).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public C selectByKey(String key) {
        findOptionByKey(key).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public C selectByValue(T value) {
        findOptionByValue(value).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public boolean containsKey(String key) {
        return findOptionByKey(key).isPresent();
    }

    public boolean containsValue(T value) {
        return findOptionByValue(value).isPresent();
    }

    public C setClearable(boolean clearable) {
        addCss(BooleanCssClass.of(dui_clearable, clearable));
        return (C) this;
    }

    public boolean isClearable() {
        return containsCss(dui_clearable.getCssClass());
    }

    public C setAutoCloseOnSelect(boolean autoClose) {
        optionsMenu.setAutoCloseOnSelect(autoClose);
        return (C) this;
    }

    public boolean isAutoCloseOnSelect() {
        return optionsMenu.isAutoCloseOnSelect();
    }

    public C setSearchable(boolean searchable) {
        optionsMenu.setSearchable(searchable);
        return (C) this;
    }

    public boolean isSearchable() {
        return optionsMenu.isSearchable();
    }

    public C setSearchFilter() {

        return (C) this;
    }

    public boolean isAllowCreateMissing() {
        return optionsMenu.isAllowCreateMissing();
    }

    public Menu<T> getOptionsMenu() {
        return optionsMenu;
    }

    public C withOptionsMenu(ChildHandler<C, Menu<T>> handler) {
        handler.apply((C) this, optionsMenu);
        return (C) this;
    }

    public C setMissingItemHandler(MissingOptionHandler<T> missingOptionHandler) {
        if (nonNull(missingOptionHandler)) {
            optionsMenu.setMissingItemHandler((token, menu) -> {
                menu.appendChild(missingOptionHandler.onMissingItem(token));
            });
        } else {
            optionsMenu.setMissingItemHandler(null);
        }
        return (C) this;
    }

    public C removeOption(S option) {
        findOption(option).ifPresent(found -> optionsMenu.removeItem(found));
        return (C) this;
    }

    public C removeOptions(Collection<S> options) {
        options.forEach(this::removeOption);
        return (C) this;
    }

    public C removeOptions(S... options) {
        Arrays.asList(options).forEach(this::removeOption);
        return (C) this;
    }

    public C removeAllOptions() {
        optionsMenu.getMenuItems().forEach(menuItem -> removeOption((S) menuItem));
        return (C) this;
    }

    public interface MissingOptionHandler<V> {
        Option<V> onMissingItem(String token);
    }

    private static class SelectAutoValidator<T, V, S extends Option<T>, C extends AbstractSelect<T, V, S, C>>
            extends AutoValidator {

        private C select;
        private HasSelectionListeners.SelectionListener<AbstractMenuItem<T, ?>, List<AbstractMenuItem<T, ?>>> listener;


        public SelectAutoValidator(C select, ApplyFunction autoValidate) {
            super(autoValidate);
            this.select = select;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void attach() {
            listener = (source, selection) -> autoValidate.apply();
            select.getOptionsMenu().addSelectionListener(listener);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            select.getOptionsMenu().removeSelectionListener(listener);
        }
    }

}
