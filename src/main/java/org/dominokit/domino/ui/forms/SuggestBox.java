package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.utils.DelayedTextInput;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class SuggestBox extends AbstractValueBox<SuggestBox, HTMLInputElement, String> implements HasSelectionHandler<SuggestBox, SuggestItem> {

    private static final String TEXT = "text";
    private DropDownMenu suggestionsMenu;
    private List<SelectionHandler<SuggestItem>> selectionHandlers = new ArrayList<>();
    private SuggestBoxStore store;
    private HTMLDivElement loaderContainer = div().css("suggest-box-loader").asElement();
    private Loader loader;

    public SuggestBox() {
        this("");
    }

    public SuggestBox(String label) {
        this(label, null);
    }

    public SuggestBox(SuggestBoxStore store) {
        this("", store);
    }

    public SuggestBox(String label, SuggestBoxStore store) {
        this(TEXT, label, store);
    }

    public SuggestBox(String type, String label, SuggestBoxStore store) {
        super(type, label);
        this.store = store;
        suggestionsMenu = DropDownMenu.create(getInputElement());
        suggestionsMenu.addCloseHandler(this::focus);
        Element element = DomGlobal.document.querySelector(".content");
        element.addEventListener("transitionend", evt -> {
            suggestionsMenu.style().setWidth(asElement().offsetWidth + "px");
        });
        onAttached(mutationRecord -> {
            suggestionsMenu.style().setWidth(asElement().offsetWidth + "px");
        });
        getFieldContainer().insertFirst(loaderContainer);
        setLoaderEffect(LoaderEffect.IOS);

        DelayedTextInput.create(getInputElement(), 200)
                .setDelayedAction(() -> {
                    if (isEmpty()) {
                        suggestionsMenu.close();
                    } else {
                        search();
                    }
                });
    }

    private void search() {
        loader.start();
        suggestionsMenu.clearActions();
        suggestionsMenu.close();
        if (store != null) {
            store.filter(getValue(), suggestions -> {
                suggestionsMenu.clearActions();
                suggestions.forEach(suggestion -> {
                    suggestion.highlight(SuggestBox.this.getValue());
                    suggestionsMenu.appendChild(SuggestBox.this.dropdownAction(suggestion));
                });
                suggestionsMenu.open();
                loader.stop();
            });
        }
    }

    public static SuggestBox create(SuggestBoxStore store) {
        return new SuggestBox(store);
    }

    public static SuggestBox create(String label, SuggestBoxStore store) {
        return new SuggestBox(label, store);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        value("");
    }

    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().asElement().value = value;
        } else {
            getInputElement().asElement().value = "";
        }
    }

    @Override
    public String getValue() {
        return getInputElement().asElement().value;
    }

    public void setSuggestBoxStore(SuggestBoxStore store) {
        this.store = store;
    }

    public SuggestBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return getValue();
    }

    private DropdownAction dropdownAction(SuggestItem suggestItem) {
        DropdownAction<String> suggestionAction = DropdownAction.create(suggestItem.getValue(), suggestItem.asElement());
        suggestionAction.addSelectionHandler(value -> {
            setValue(value);
            selectionHandlers.forEach(handler -> handler.onSelection(suggestItem));
            suggestionsMenu.close();
        });
        return suggestionAction;
    }

    @Override
    public SuggestBox addSelectionHandler(SelectionHandler<SuggestItem> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public SuggestBox removeSelectionHandler(SelectionHandler<SuggestItem> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public SuggestBox setLoaderEffect(LoaderEffect loaderEffect) {
        loader = Loader.create(loaderContainer, loaderEffect)
                .setSize("20px", "20px")
                .setRemoveLoadingText(true);
        return this;
    }

    public Loader getLoader() {
        return loader;
    }
}
