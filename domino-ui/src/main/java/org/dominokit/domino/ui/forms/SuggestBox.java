package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.forms.SuggestBoxStore.MissingEntryProvider;
import org.dominokit.domino.ui.forms.SuggestBoxStore.MissingSuggestProvider;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DelayedTextInput;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.jboss.elemento.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.div;

/**
 * A component that dynamically loads suggestions from a {@link SuggestBoxStore} while the user is typing
 * @param <T> the type of the SuggestBox value
 */
public class SuggestBox<T> extends AbstractValueBox<SuggestBox<T>, HTMLInputElement, T> implements HasSelectionHandler<SuggestBox<T>, SuggestItem<T>> {

    private static final String TEXT = "text";
    private DropDownMenu suggestionsMenu;
    private List<SelectionHandler<SuggestItem<T>>> selectionHandlers = new ArrayList<>();
    private SuggestBoxStore<T> store;
    private HTMLDivElement loaderContainer = div().css("suggest-box-loader").element();
    private Loader loader;
    private boolean emptyAsNull;
    private Color highlightColor;
    private T value;
    private int typeAheadDelay = 200;
    private SuggestItem<T> selectedItem;
    private DelayedTextInput delayedTextInput;
    private boolean focusOnClose = true;
    private DelayedTextInput.DelayedAction delayedAction = () -> {
        if (isEmpty()) {
            suggestionsMenu.close();
            clearValue();
        } else {
            search();
        }
    };
    private boolean autoSelect = true;

    /**
     * Creates an instance without a label and a null store
     */
    public SuggestBox() {
        this("");
    }

    /**
     * Creates an instance with a label and a null store
     * @param label String label
     */
    public SuggestBox(String label) {
        this(label, null);
    }

    /**
     * Creates an instance without a label and initialized with a store
     * @param store {@link SuggestBoxStore}
     */
    public SuggestBox(SuggestBoxStore<T> store) {
        this("", store);
    }

    /**
     * Creates an instance with a label and initialized with a store
     * @param label String
     * @param store {@link SuggestBoxStore}
     */
    public SuggestBox(String label, SuggestBoxStore<T> store) {
        this(TEXT, label, store);
    }

    /**
     * Creates an instance with a label and initialized with the input type and a store
     * @param type String input element type
     * @param label String
     * @param store {@link SuggestBoxStore}
     */
    public SuggestBox(String type, String label, SuggestBoxStore<T> store) {
        super(type, label);
        this.store = store;
        suggestionsMenu = DropDownMenu.create(fieldContainer);
        suggestionsMenu.setAppendTarget(document.body);
        suggestionsMenu.setAppendStrategy(DropDownMenu.AppendStrategy.FIRST);
        suggestionsMenu.setPosition(new PopupPositionTopDown());
        suggestionsMenu.addCloseHandler(() -> {
            if(focusOnClose){
                focus();
            }
        });
        Element element = document.querySelector(".content");
        if (nonNull(element)) {
            EventListener eventListener = evt -> {
                suggestionsMenu.style().setWidth(element().offsetWidth + "px");
            };
            element.addEventListener("transitionend", eventListener);
            onDetached(mutationRecord -> element.removeEventListener("transitionend", eventListener));
        }
        onAttached(mutationRecord -> {
            suggestionsMenu.style().setWidth(element().offsetWidth + "px");
        });
        getFieldInputContainer().insertFirst(loaderContainer);
        setLoaderEffect(LoaderEffect.IOS);

        delayedTextInput = DelayedTextInput.create(getInputElement(), typeAheadDelay)
                .setDelayedAction(delayedAction);
        KeyboardEvents.listenOn(getInputElement())
                .onArrowDown(evt -> {
                    suggestionsMenu.focus();
                    evt.preventDefault();
                })
                .onArrowUp(evt -> {
                    suggestionsMenu.focus();
                    evt.preventDefault();
                })
                .onEscape(evt -> {
                    focus();
                    evt.preventDefault();
                })
                .onEnter(evt -> {
                    if (suggestionsMenu.isOpened() && !suggestionsMenu.getFilteredAction().isEmpty()) {
                        evt.stopPropagation();
                        evt.preventDefault();
                        if(isAutoSelect()) {
                            List<DropdownAction<?>> filteredActions = suggestionsMenu.getFilteredAction();
                            suggestionsMenu.selectAt(suggestionsMenu.getActions().indexOf(filteredActions.get(0)));
                            filteredActions.get(0).select();
                            suggestionsMenu.close();
                        }else{
                            suggestionsMenu.focus();
                        }
                    }
                })
                .onTab(evt -> {
                    if (suggestionsMenu.isOpened()) {
                        evt.stopPropagation();
                        evt.preventDefault();
                        suggestionsMenu.focus();
                    }
                });
    }

    /**
     *
     * Creates an instance without a label and initialized with a store
     * @param store {@link SuggestBoxStore}
     * @param <T> the type of the SuggestBox value
     * @return new SuggestBox instance
     */
    public static <T> SuggestBox<T> create(SuggestBoxStore<T> store) {
        return new SuggestBox<>(store);
    }

    /**
     *
     * Creates an instance with a label and initialized with a store
     * @param label String
     * @param store {@link SuggestBoxStore}
     * @param <T> the type of the SuggestBox value
     * @return new SuggestBox instance
     */
    public static <T> SuggestBox<T> create(String label, SuggestBoxStore<T> store) {
        return new SuggestBox<T>(label, store);
    }

    /**
     * Filter the items based on the currently typed text in the SuggestBox
     */
    public final void search() {
        if (store != null) {
            loader.start();
            suggestionsMenu.clearActions();
            suggestionsMenu.close();
            store.filter(getStringValue(), suggestions -> {
                selectedItem = null;
                suggestionsMenu.clearActions();

                if (suggestions.isEmpty()) {
                    applyMissingEntry(getStringValue());
                }

                suggestions.forEach(suggestion -> {
                    suggestion.highlight(SuggestBox.this.getStringValue(), highlightColor);
                    suggestionsMenu.appendChild(dropdownAction(suggestion));
                });
                suggestionsMenu.open(false);
                loader.stop();
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).element();
    }

    /**
     *
     * @return int delay in milliseconds before triggering the search after the user stops typing
     */
    public int getTypeAheadDelay() {
        return typeAheadDelay;
    }

    /**
     *
     * @param delayMilliseconds int delay in milliseconds before triggering the search after the user stops typing
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setTypeAheadDelay(int delayMilliseconds) {
        this.typeAheadDelay = delayMilliseconds;
        this.delayedTextInput.setDelay(delayMilliseconds);
        return this;
    }

    /**
     *
     * @return the {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
     */
    public DelayedTextInput.DelayedAction getDelayedAction() {
        return delayedAction;
    }

    /**
     * Set a custom action to be executed after the user stops typing that override the default search action
     * @param delayedAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setDelayedAction(DelayedTextInput.DelayedAction delayedAction) {
        this.delayedAction = delayedAction;
        this.delayedTextInput.setDelayedAction(delayedAction);
        return this;
    }

    /**
     * Sets the action to be executed when the user press Enter to override the default search action
     * @param onEnterAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setOnEnterAction(DelayedTextInput.DelayedAction onEnterAction) {
        this.delayedTextInput.setOnEnterAction(onEnterAction);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(T value) {
        if (nonNull(store)) {
            store.find(value, suggestItem -> {
                if (nonNull(suggestItem)) {
                    this.value = value;
                    getInputElement().element().value = suggestItem.getDisplayValue();
                } else {
                    if (!applyMissingValue(value)) {
                        this.value = null;
                        getInputElement().element().value = "";
                    }
                }
            });
        }
    }

    private boolean applyMissingValue(T value) {
        MissingSuggestProvider<T> messingSuggestionProvider = store.getMessingSuggestionProvider();
        Optional<SuggestItem<T>> messingSuggestion = messingSuggestionProvider.getMessingSuggestion(value);
        return applyMissing(messingSuggestion);
    }

    private boolean applyMissingEntry(String value) {
        MissingEntryProvider<T> messingEntryProvider = store.getMessingEntryProvider();
        Optional<SuggestItem<T>> messingSuggestion = messingEntryProvider.getMessingSuggestion(value);
        return applyMissing(messingSuggestion);
    }

    private boolean applyMissing(Optional<SuggestItem<T>> messingSuggestion) {
        if (messingSuggestion.isPresent()) {
            SuggestItem<T> messingSuggestItem = messingSuggestion.get();
            this.value = messingSuggestItem.getValue();
            getInputElement().element().value = messingSuggestItem.getDisplayValue();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getValue() {
        if (isNull(selectedItem)) {
            applyMissingEntry(getStringValue());
        }

        return this.value;
    }

    /**
     *
     * @param store {@link SuggestBoxStore}
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setSuggestBoxStore(SuggestBoxStore<T> store) {
        this.store = store;
        return this;
    }

    /**
     *
     * @param type String type of the htmml input element
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setType(String type) {
        getInputElement().element().type = type;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        String stringValue = getInputElement().element().value;
        if (stringValue.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return stringValue;
    }

    private DropdownAction<T> dropdownAction(SuggestItem<T> suggestItem) {
        DropdownAction<T> dropdownAction = suggestItem.asDropDownAction();
        dropdownAction.addSelectionHandler(value -> {
            selectedItem = suggestItem;
            setValue(value);
            selectionHandlers.forEach(handler -> handler.onSelection(suggestItem));
            suggestionsMenu.close();
        });
        return dropdownAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SuggestBox<T> addSelectionHandler(SelectionHandler<SuggestItem<T>> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SuggestBox<T> removeSelectionHandler(SelectionHandler<SuggestItem<T>> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    /**
     * Sets a custom loader effect to be visible while the store is retrieving the suggestions
     * @param loaderEffect {@link LoaderEffect}
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setLoaderEffect(LoaderEffect loaderEffect) {
        loader = Loader.create(loaderContainer, loaderEffect)
                .setSize("20px", "20px")
                .setRemoveLoadingText(true);
        return this;
    }

    /**
     *
     * @return the {@link Loader} used by the SuggestBox
     */
    public Loader getLoader() {
        return loader;
    }

    /**
     *
     * @param emptyAsNull boolean, if ture empty value will be considered null otherwise it is an empty String
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setEmptyAsNull(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
        return this;
    }

    /**
     *
     * @return boolean, true if empty value will be considered null otherwise false
     */
    public boolean isEmptyAsNull() {
        return emptyAsNull;
    }

    /**
     *
     * @return the {@link SuggestBoxStore} of this SuggestBox
     */
    public SuggestBoxStore<T> getStore() {
        return store;
    }

    /**
     *
     * @return the {@link DelayedTextInput} of this SuggestBox
     */
    public DelayedTextInput getDelayedTextInput() {
        return delayedTextInput;
    }

    /**
     *
     * @return the {@link DropDownMenu} of the SuggestBox
     */
    public DropDownMenu getSuggestionsMenu() {
        return suggestionsMenu;
    }

    /**
     * Set the color to be used to highlight parts of the SuggestItems that matches the typed String in the text input
     * @param highlightColor {@link Color}
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setHighlightColor(Color highlightColor) {
        this.highlightColor = highlightColor;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new SuggestAutoValidator<>(this, autoValidate);
    }

    /**
     *
     * @return boolean, true if autoSelect is enabled
     */
    public boolean isAutoSelect() {
        return autoSelect;
    }

    /**
     *
     * @param autoSelect boolean, if true pressing enter will automatically select the first entry from the Suggestions menu
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setAutoSelect(boolean autoSelect) {
        this.autoSelect = autoSelect;
        return this;
    }

    /**
     *
     * @return boolean, true if the focusOnClose is enabled
     */
    public boolean isFocusOnClose() {
        return focusOnClose;
    }

    /**
     *
     * @param focusOnClose boolean, if true after closing the suggestions menu the focus will go back to the suggest box input
     * @return same SuggestBox instance
     */
    public SuggestBox<T> setFocusOnClose(boolean focusOnClose) {
        this.focusOnClose = focusOnClose;
        return this;
    }

    /**
     * A {@link DropDownPosition} that opens the suggestion dropdown menu up or down based on the largest space available, the menu will show where the is more space
     */
    public static class PopupPositionTopDown implements DropDownPosition {

        private DropDownPositionUp up = new DropDownPositionUp();
        private DropDownPositionDown down = new DropDownPositionDown();

        /**
         * {@inheritDoc}
         */
        @Override
        public void position(HTMLElement popup, HTMLElement target) {
            DOMRect targetRect = target.getBoundingClientRect();

            double distanceToMiddle = ((targetRect.top) - (targetRect.height / 2));
            double windowMiddle = window.innerHeight;
            double popupHeight = popup.getBoundingClientRect().height;
            double distanceToBottom = window.innerHeight - targetRect.top;
            double distanceToTop = (targetRect.top + targetRect.height);

            boolean hasSpaceBelow = distanceToBottom > popupHeight;
            boolean hasSpaceUp = distanceToTop > popupHeight;

            if (hasSpaceUp || ((distanceToMiddle >= windowMiddle) && !hasSpaceBelow)) {
                up.position(popup, target);
                popup.setAttribute("popup-direction", "top");
            } else {
                down.position(popup, target);
                popup.setAttribute("popup-direction", "down");
            }

            popup.style.setProperty("width", targetRect.width + "px");
        }
    }

    /**
     * A {@link DropDownPosition} that opens the suggestion dropdown menu up
     */
    public static class DropDownPositionUp implements DropDownPosition {
        /**
         * {@inheritDoc}
         */
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {

            DOMRect targetRect = target.getBoundingClientRect();

            actionsMenu.style.setProperty("bottom", px.of(((window.innerHeight - targetRect.bottom + targetRect.height) - window.pageYOffset)));
            actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
            actionsMenu.style.removeProperty("top");
        }
    }

    /**
     * A {@link DropDownPosition} that opens the suggestion dropdown menu down
     */
    public static class DropDownPositionDown implements DropDownPosition {

        /**
         * {@inheritDoc}
         */
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {

            DOMRect targetRect = target.getBoundingClientRect();

            actionsMenu.style.setProperty("top", px.of((targetRect.top + targetRect.height + window.pageYOffset)));
            actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
            actionsMenu.style.removeProperty("bottom");
        }
    }

    private static class SuggestAutoValidator<T> extends AutoValidator {

        private SuggestBox<T> suggestBox;
        private SelectionHandler<SuggestItem<T>> selectionHandler;

        public SuggestAutoValidator(SuggestBox<T> suggestBox, AutoValidate autoValidate) {
            super(autoValidate);
            this.suggestBox = suggestBox;
        }

        @Override
        public void attach() {
            selectionHandler = option -> autoValidate.apply();
            suggestBox.addSelectionHandler(selectionHandler);
        }

        @Override
        public void remove() {
            suggestBox.removeSelectionHandler(selectionHandler);
        }
    }
}
