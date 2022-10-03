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
import static org.dominokit.domino.ui.style.Styles.CLEARABLE;

public abstract class AbstractSelect<T, S, V, C extends AbstractSelect<T, S, V, C>> extends AbstractFormElement<AbstractSelect<T, S, V, C>, V>
        implements HasInputElement<AbstractSelect<T, S, V, C>>, HasPlaceHolder<AbstractSelect<T, S, V, C>> {

    protected Menu<T> optionsMenu;
    private DominoElement<HTMLDivElement> fieldInput;
    private DominoElement<HTMLElement> placeHolderElement = DominoElement.span();
    private DominoElement<HTMLInputElement> inputElement;

    private Function<S, Optional<SelectOption<T>>> optionMapper;

    private SelectValueRenderer<T, S, V, C> selectValueRenderer = (select, option) -> DominoElement.span().setTextContent(String.valueOf(option.getValue())).element();

    public AbstractSelect(Function<S, Optional<SelectOption<T>>> optionMapper) {
        addCss(FORM_SELECT);
        this.optionMapper = optionMapper;
        wrapperElement
                .appendChild(fieldInput = DominoElement.div()
                        .addCss(FIELD_INPUT)
                        .appendChild(placeHolderElement.addCss(FIELD_PLACEHOLDER))
                )
                .appendChild(inputElement = DominoElement.input(getType()).addCss(HIDDEN_INPUT));
        labelForId(inputElement.getDominoId());

        optionsMenu = Menu.<T>create()
                .setAppendTarget(getWrapperElement().element())
                .setTargetElement(getWrapperElement())
                .setFitToTargetWidth(true)
                .addSelectionListener((source, selection) -> updateTextValue())
                .addCloseHandler(this::focus);

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
        getInputElement().element().value= getStringValue();
    }

    protected C clearValue(boolean silent) {
        if (!optionsMenu.getSelected().isEmpty()) {
            V oldValue = getValue();
            optionsMenu.withPauseSelectionListenersToggle(true, (field, handler) -> {
                List<AbstractMenuItem<T, ?>> selected = optionsMenu.getSelected();
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

    public C addItem(S item) {
        optionMapper.apply(item).ifPresent(this::appendOption);
        return (C) this;
    }

    public C appendOption(SelectOption<T> option) {
        if(nonNull(option)) {
            option.setValueElement(LazyChild.of(DominoElement.of(selectValueRenderer.element((C) this, option)), fieldInput));
            optionsMenu.appendChild(option);
        }
        return (C) this;
    }

    public C appendOption(Collection<SelectOption<T>> options) {
        if(nonNull(options)) {
            options.forEach(this::appendOption);
        }
        return (C) this;
    }

    public C appendOption(SelectOption<T>... options) {
        if(nonNull(options)) {
           appendOption(Arrays.asList(options));
        }
        return (C) this;
    }

    public C addItems(Collection<S> items) {
        items.forEach(this::addItem);
        return (C) this;
    }

    public C addItems(S... items) {
        return addItems(Arrays.asList(items));
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
        return optionsMenu.getSelected()
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
        return optionsMenu.getSelected().isEmpty();
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
        return new SelectAutoValidator<>((C)this, autoValidate);
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

    public C addOptionsGroup(List<S> items, Menu.MenuItemsGroupHandler<T, SelectOption<T>> groupHandler) {
        MenuItemsGroup<T, SelectOption<T>> optionsGroup = new MenuItemsGroup<>(optionsMenu);
        optionsMenu.appendGroup(optionsGroup, groupHandler);
        items.forEach(item -> addItemToGroup(optionsGroup, item));
        return (C) this;

    }

    private void addItemToGroup(MenuItemsGroup<T, SelectOption<T>> optionsGroup, S item) {
        optionMapper.apply(item).ifPresent(option -> {
            option.setValueElement(LazyChild.of(DominoElement.of(selectValueRenderer.element((C) this, option)), fieldInput));
            optionsGroup.appendChild(option);
        });
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

    public C selectOption(SelectOption<T> option) {
        findOption(option)
                .ifPresent(menuItem -> menuItem.select(isChangeListenersPaused()));

        return (C) this;
    }

    public Optional<SelectOption<T>> findOption(SelectOption<T> option) {
        return Optional.ofNullable(option)
                .flatMap(vSelectionOption -> optionsMenu.getMenuItems()
                        .stream()
                        .filter(menuItem -> Objects.equals(option.getKey(), menuItem.getKey()))
                        .map(menuItem -> (SelectOption<T>)menuItem)
                        .findFirst()
                );
    }

    public Optional<SelectOption<T>> findOptionByKey(String key) {
        return optionsMenu.getMenuItems()
                        .stream()
                        .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
                        .map(menuItem -> (SelectOption<T>)menuItem)
                        .findFirst();
    }

    public Optional<SelectOption<T>> findOptionByValue(T value) {
        return optionsMenu.getMenuItems()
                        .stream()
                        .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
                        .map(menuItem -> (SelectOption<T>)menuItem)
                        .findFirst();
    }

    public Optional<SelectOption<T>> findOptionByIndex(int index) {
        if (index < optionsMenu.getMenuItems().size() && index >= 0){
            return Optional.of((SelectOption<T>)optionsMenu.getMenuItems().get(index));
        }
        return Optional.empty();
    }

    public C selectAt(int index){
        findOptionByIndex(index).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public C selectByKey(String key){
        findOptionByKey(key).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public C selectByValue(T value){
        findOptionByValue(value).ifPresent(option -> option.select(isChangeListenersPaused()));
        return (C) this;
    }

    public boolean containsKey(String key){
        return findOptionByKey(key).isPresent();
    }

    public boolean containsValue(T value){
        return findOptionByValue(value).isPresent();
    }

    public C setOptionValueRenderer(SelectValueRenderer<T, S, V, C> selectValueRenderer) {
        if (nonNull(selectValueRenderer)) {
            this.selectValueRenderer = selectValueRenderer;
        }
        return (C) this;
    }

    public C setClearable(boolean clearable) {
        addCss(BooleanCssClass.of(CLEARABLE, clearable));
        return (C) this;
    }

    public boolean isClearable(){
        return containsCss(CLEARABLE.getCssClass());
    }

    public C setAutoCloseOnSelect(boolean autoClose){
        optionsMenu.setAutoCloseOnSelect(autoClose);
        return (C) this;
    }

    public boolean isAutoCloseOnSelect(){
        return optionsMenu.isAutoCloseOnSelect();
    }
    public C setSearchable(boolean searchable) {
        optionsMenu.setSearchable(searchable);
        return (C) this;
    }

    public boolean isSearchable(){
        return optionsMenu.isSearchable();
    }

    public C setSearchFilter(){

        return (C) this;
    }

    public boolean isAllowCreateMissing(){
        return optionsMenu.isAllowCreateMissing();
    }

    public Menu<T> getOptionsMenu() {
        return optionsMenu;
    }

    public C withOptionsMenu(ChildHandler<C, Menu<T>> handler){
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

    public C removeOption(SelectOption<T> option){
        findOption(option).ifPresent(found -> optionsMenu.removeItem(found));
        return (C) this;
    }

    public C removeOptions(Collection<SelectOption<T>> options){
        options.forEach(this::removeOption);
        return (C) this;
    }

    public C removeOptions(SelectOption<T>... options){
        Arrays.asList(options).forEach(this::removeOption);
        return (C) this;
    }

    public C removeAllOptions(){
        optionsMenu.getMenuItems().forEach(menuItem -> removeOption((SelectOption<T>) menuItem));
        return (C) this;
    }
    
    public interface SelectValueRenderer<T, S, V, C extends AbstractSelect<T, S, V, C>> {
        HTMLElement element(C select, SelectOption<T> option);
    }

    public interface MissingOptionHandler<V> {
        SelectOption<V> onMissingItem(String token);
    }

    private static class SelectAutoValidator<T, S, V, C extends AbstractSelect<T, S, V, C>>
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
