package org.dominokit.domino.ui.forms;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DelayedTextInput;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class SuggestBox<T> extends AbstractValueBox<SuggestBox<T>, HTMLInputElement, T> implements HasSelectionHandler<SuggestBox<T>, SuggestItem<T>> {

    private static final String TEXT = "text";
    private DropDownMenu suggestionsMenu;
    private List<SelectionHandler<SuggestItem<T>>> selectionHandlers = new ArrayList<>();
    private SuggestBoxStore<T> store;
    private HTMLDivElement loaderContainer = div().css("suggest-box-loader").asElement();
    private Loader loader;
    private boolean emptyAsNull;
    private Color highlightColor;
    private T value;
    private int typeAheadDelay = 200;

    public SuggestBox() {
        this("");
    }

    public SuggestBox(String label) {
        this(label, null);
    }

    public SuggestBox(SuggestBoxStore<T> store) {
        this("", store);
    }

    public SuggestBox(String label, SuggestBoxStore<T> store) {
        this(TEXT, label, store);
    }

    public SuggestBox(String type, String label, SuggestBoxStore<T> store) {
        super(type, label);
        this.store = store;
        suggestionsMenu = DropDownMenu.create(asElement());
        suggestionsMenu.addCloseHandler(this::focus);
        Element element = document.querySelector(".content");
        if (nonNull(element)) {
            element.addEventListener("transitionend", evt -> {
                suggestionsMenu.style().setWidth(asElement().offsetWidth + "px");
            });
        }
        onAttached(mutationRecord -> {
            suggestionsMenu.style().setWidth(asElement().offsetWidth + "px");
        });
        getFieldContainer().insertFirst(loaderContainer);
        setLoaderEffect(LoaderEffect.IOS);

        DelayedTextInput.create(getInputElement(), typeAheadDelay)
                .setDelayedAction(() -> {
                    if (isEmpty()) {
                        suggestionsMenu.close();
                    } else {
                        search();
                    }
                });
    }

    public static <T> SuggestBox<T> create(SuggestBoxStore<T> store) {
        return new SuggestBox<>(store);
    }

    public static <T> SuggestBox<T> create(String label, SuggestBoxStore<T> store) {
        return new SuggestBox<T>(label, store);
    }

    private void search() {
        if (store != null) {
            loader.start();
            suggestionsMenu.clearActions();
            suggestionsMenu.close();
            store.filter(getStringValue(), suggestions -> {
                suggestionsMenu.clearActions();
                suggestions.forEach(suggestion -> {
                    suggestion.highlight(SuggestBox.this.getStringValue(), highlightColor);
                    suggestionsMenu.appendChild(dropdownAction(suggestion));
                });
                suggestionsMenu.open();
                loader.stop();
            });
        }
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    public int getTypeAheadDelay() {
        return typeAheadDelay;
    }

    public SuggestBox<T> setTypeAheadDelay(int delayMilliseconds) {
        this.typeAheadDelay = delayMilliseconds;
        return this;
    }

    @Override
    protected void clearValue() {
        value(null);
    }

    @Override
    protected void doSetValue(T value) {
        if (nonNull(store)) {
            store.find(value, suggestItem -> {
                if (nonNull(suggestItem)) {
                    this.value = value;
                    getInputElement().asElement().value = suggestItem.getDisplayValue();
                } else {
                    getInputElement().asElement().value = "";
                }
            });
        }
    }

    @Override
    public T getValue() {
        return this.value;
    }

    public SuggestBox<T> setSuggestBoxStore(SuggestBoxStore<T> store) {
        this.store = store;
        return this;
    }

    public SuggestBox<T> setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        String stringValue = getInputElement().asElement().value;
        if (stringValue.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return stringValue;
    }

    private DropdownAction<T> dropdownAction(SuggestItem<T> suggestItem) {
        DropdownAction<T> dropdownAction = suggestItem.asDropDownAction();
        dropdownAction.addSelectionHandler(value -> {
            setValue(value);
            selectionHandlers.forEach(handler -> handler.onSelection(suggestItem));
            suggestionsMenu.close();
        });
        return dropdownAction;
    }

    @Override
    public SuggestBox<T> addSelectionHandler(SelectionHandler<SuggestItem<T>> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public SuggestBox<T> removeSelectionHandler(SelectionHandler<SuggestItem<T>> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public SuggestBox<T> setLoaderEffect(LoaderEffect loaderEffect) {
        loader = Loader.create(loaderContainer, loaderEffect)
                .setSize("20px", "20px")
                .setRemoveLoadingText(true);
        return this;
    }

    public Loader getLoader() {
        return loader;
    }

    public SuggestBox<T> setEmptyAsNull(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
        return this;
    }

    public boolean isEmptyAsNull() {
        return emptyAsNull;
    }

    public DropDownMenu getSuggestionsMenu() {
        return suggestionsMenu;
    }

    public SuggestBox<T> setHighlightColor(Color highlightColor) {
        this.highlightColor = highlightColor;
        return this;
    }
}
