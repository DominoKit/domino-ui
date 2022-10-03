package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.Spacing;
import org.dominokit.domino.ui.utils.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;
import static org.dominokit.domino.ui.style.Styles.CLEARABLE;

public abstract class AbstractSuggestionBox<T, V, C extends AbstractSuggestionBox<T, V, C>> extends AbstractFormElement<AbstractSuggestionBox<T, V, C>, V>
        implements HasInputElement<AbstractSuggestionBox<T, V, C>>,
        HasPlaceHolder<AbstractSuggestionBox<T, V, C>> {

    protected Menu<T> optionsMenu;
    private DominoElement<HTMLDivElement> fieldInput;
    private DominoElement<HTMLInputElement> inputElement;

    protected final SuggestBoxStore<T> store;

    private SuggestValueRenderer<T, V, C> suggestValueRenderer = (select, option) -> DominoElement.span().setTextContent(String.valueOf(option.getValue())).element();
    private final DominoElement<HTMLDivElement> loaderElement;
    private Loader loader;


    private DelayedTextInput delayedTextInput;

    private final DelayedTextInput.DelayedAction delayedAction = () ->{
      if(isEmptyInputText()){
          optionsMenu.close();
      }else {
          search();
      }
    };
    private boolean autoSelect = true;
    private int typeAheadDelay = 1000;

    public AbstractSuggestionBox(SuggestBoxStore<T> store) {
        this.store = store;
        addCss(FORM_SELECT);
        wrapperElement
                .appendChild(fieldInput = DominoElement.div()
                        .addCss(FIELD_INPUT)
                        .appendChild(inputElement = DominoElement.input(getType()).addCss(FIELD_INPUT))
                );

        delayedTextInput = DelayedTextInput.create(inputElement.element(), getTypeAheadDelay(), delayedAction);

        optionsMenu = Menu.<T>create()
                .setAppendTarget(getWrapperElement().element())
                .setTargetElement(getWrapperElement())
                .setAutoOpen(false)
                .setFitToTargetWidth(true)
                .addCloseHandler(this::focus)
                .addSelectionListener((source, selection) -> {
                    source.ifPresent(suggestion -> {
                        onOptionSelected((SelectOption<T>) suggestion);
                        getInputElement().element().value = null;
                    });
                });


        addPrimaryAddOn(loaderElement = DominoElement.div().addCss(Spacing.W_12, Spacing.H_6));
        loader = Loader.create(loaderElement, LoaderEffect.FACEBOOK)
                .setLoadingTextPosition(Loader.LoadingTextPosition.TOP)
                .setRemoveLoadingText(true);

        addPrimaryAddOn(Icons.ALL.delete_mdi()
                .addCss(FORM_SELECT_CLEAR)
                .clickable()
                .addClickListener(evt -> {
                            evt.stopPropagation();
                            clearValue(false);
                        }
                )
        );

        KeyboardEvents.listenOnKeyDown(getInputElement())
                .onArrowDown(
                        evt -> {
                            optionsMenu.focus();
                            evt.preventDefault();
                        })
                .onArrowUp(
                        evt -> {
                            optionsMenu.focus();
                            evt.preventDefault();
                        })
                .onEscape(
                        evt -> {
                            focus();
                            evt.preventDefault();
                        })
                .onEnter(
                        evt -> {
                            if (optionsMenu.isOpened() && !optionsMenu.getMenuItems().isEmpty()) {
                                evt.stopPropagation();
                                evt.preventDefault();
                                if (isAutoSelect()) {
                                    optionsMenu.getMenuItems().get(0).select();
                                    optionsMenu.close();
                                } else {
                                    optionsMenu.focus();
                                }
                            }
                        })
                .onTab(
                        evt -> {
                            if (optionsMenu.isOpened()) {
                                evt.stopPropagation();
                                evt.preventDefault();
                                optionsMenu.focus();
                            }
                        })
                .onBackspace(evt -> {
                    boolean a = isNull(getInputStringValue());
                    boolean empty = getInputStringValue().isEmpty();
                    if(a || empty) {
                        evt.stopPropagation();
                        evt.preventDefault();
                        onBackspace();
                    }
                });
    }

    protected abstract void onBackspace();

    protected abstract void onOptionSelected(SelectOption<T> suggestion);

    public boolean isAutoSelect() {
        return this.autoSelect;
    }

    public C setAutoSelect(boolean autoSelect) {
        this.autoSelect = autoSelect;
        return (C) this;
    }

    public int getTypeAheadDelay() {
        return typeAheadDelay;
    }

    public void setTypeAheadDelay(int typeAheadDelayInMillis) {
        this.typeAheadDelay = typeAheadDelayInMillis;
        this.delayedTextInput.setDelay(typeAheadDelayInMillis);
    }

    private void search(){
        if (store != null) {
            loader.start();
            optionsMenu.removeAll();
            optionsMenu.close();
            store.filter(
                    getInputStringValue(),
                    suggestions -> {
                        optionsMenu.removeAll();

                        if (suggestions.isEmpty()) {
                            applyMissingEntry(getInputStringValue());
                        }

                        suggestions.forEach(
                                suggestion -> {
                                    optionsMenu.clearSelection(true);
                                    suggestion.highlight(getInputStringValue());
                                    suggestion.setValueElement(LazyChild.of(DominoElement.of(suggestValueRenderer.element((C) this, suggestion)), fieldInput));
                                    optionsMenu.appendChild(suggestion);
                                });
                        if(!suggestions.isEmpty()) {
                            optionsMenu.open(false);
                        }
                        loader.stop();
                    });
        }
    }

    private boolean applyMissingEntry(String value) {
        SuggestBoxStore.MissingEntryProvider<T> messingEntryProvider = store.getMessingEntryProvider();
        Optional<SelectOption<T>> messingSuggestion = messingEntryProvider.getMessingSuggestion(value);
        return applyMissing(messingSuggestion);
    }

    private boolean applyMissing(Optional<SelectOption<T>> missingOption) {
        if (missingOption.isPresent()) {
            SelectOption<T> option = missingOption.get();
            applyOptionValue(option);
            return true;
        }
        return false;
    }

    protected void applyOptionValue(SelectOption<T> option) {
        option.setValueElement(LazyChild.of(DominoElement.of(suggestValueRenderer.element((C) this, option)), fieldInput));
        onApplyMissingOption(option);
        option.select();
        getInputElement().element().value = null;
    }

    public abstract void onApplyMissingOption(SelectOption<T> option);


    protected abstract C clearValue(boolean silent);

    @Override
    public String getPlaceholder() {
        return getInputElement().getAttribute("placeholder");
    }

    @Override
    public C setPlaceholder(String placeholder) {
        getInputElement().setAttribute("placeholder", placeholder);
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

    private String getInputStringValue(){
        return getInputElement().element().value;
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

    private boolean isEmptyInputText(){
        String value = getInputElement().element().value;
        return isNull(value) || value.trim().isEmpty();
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
        return new SuggestAutoValidator<>((C)this, autoValidate);
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

    public C setOptionValueRenderer(SuggestValueRenderer<T, V, C> suggestValueRenderer) {
        if (nonNull(suggestValueRenderer)) {
            this.suggestValueRenderer = suggestValueRenderer;
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

    public Menu<T> getOptionsMenu() {
        return optionsMenu;
    }

    public C withOptionsMenu(ChildHandler<C, Menu<T>> handler){
        handler.apply((C) this, optionsMenu);
        return (C) this;
    }
    
    public interface SuggestValueRenderer<T,V, C extends AbstractSuggestionBox<T, V, C>> {
        HTMLElement element(C select, SelectOption<T> option);
    }

    private static class SuggestAutoValidator<T, V, C extends AbstractSuggestionBox<T, V, C>>
            extends AutoValidator {

        private C select;
        private HasSelectionListeners.SelectionListener<AbstractMenuItem<T, ?>, List<AbstractMenuItem<T, ?>>> listener;


        public SuggestAutoValidator(C select, ApplyFunction autoValidate) {
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
