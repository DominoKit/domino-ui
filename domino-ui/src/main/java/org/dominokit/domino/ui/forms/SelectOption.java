package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

public class SelectOption<T> extends BaseDominoElement<HTMLDivElement, SelectOption<T>> implements HasValue<SelectOption, T>,
        HasBackground<SelectOption>, Selectable<SelectOption>, TakesValue<T> {

    private static final String SELECTED = "select-option-selected";
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("select-option"));
    private DominoElement<HTMLElement> valueContainer = DominoElement.of(span().css(Styles.ellipsis_text));
    private Supplier<CheckBox> checkMarkSupplier = CheckBox::create;
    private CheckBox checkMark;
    private String displayValue;
    private String key;
    private T value;
    private List<Selectable.SelectionHandler<SelectOption>> selectionHandlers = new ArrayList<>();
    private FlexItem checkMarkFlexItem;
    private boolean excludeFromSearchResults = false;
    private FlexLayout optionLayoutElement;

    public SelectOption(T value, String key, String displayValue) {
        setKey(key);
        setValue(value);
        setDisplayValue(displayValue);
        checkMarkFlexItem = FlexItem.create();
        checkMark = checkMarkSupplier.get();
        checkMarkFlexItem.appendChild(checkMark);
        optionLayoutElement = FlexLayout.create();
        element
                .appendChild(optionLayoutElement
                        .appendChild(checkMarkFlexItem)
                        .appendChild(FlexItem.create()
                                .css(Styles.ellipsis_text)
                                .setFlexGrow(1)
                                .appendChild(valueContainer))
                );
        init(this);
    }

    public SelectOption(T value, String key) {
        this(value, key, key);
    }

    public static <T> SelectOption<T> create(T value, String key, String displayValue) {
        return new SelectOption<>(value, key, displayValue);
    }

    public static <T> SelectOption<T> create(T value, String key) {
        return new SelectOption<>(value, key);
    }

    public SelectOption<T> appendChild(Node node) {
        element.appendChild(node);
        return this;
    }

    public SelectOption<T> appendChild(IsElement<?> node) {
        element.appendChild(node.element());
        return this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void addSelectionHandler(Selectable.SelectionHandler<SelectOption> selectionHandler) {
        selectionHandlers.add(selectionHandler);
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public SelectOption<T> setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
        valueContainer.setTextContent(displayValue);
        return this;
    }

    @Override
    public SelectOption<T> select() {
        return select(false);
    }

    @Override
    public SelectOption<T> deselect() {
        return deselect(false);
    }

    @Override
    public SelectOption<T> select(boolean silent) {
        style().add(SELECTED);
        checkMark.check(silent);
        if (!silent) {
            selectionHandlers.forEach(handler -> handler.onSelectionChanged(this));
        }
        return this;
    }

    @Override
    public SelectOption<T> deselect(boolean silent) {
        style().remove(SELECTED);
        checkMark.uncheck(silent);
        return this;
    }

    @Override
    public boolean isSelected() {
        return style().contains(SELECTED);
    }

    @Override
    public SelectOption<T> setBackground(Color background) {
        style().add(background.getBackground());
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public CheckBox getCheckMark() {
        return checkMark;
    }

    public DominoElement<HTMLElement> getValueContainer() {
        return valueContainer;
    }

    @Override
    public SelectOption<T> value(T value) {
        setValue(value);
        return this;
    }

    public boolean isExcludeFromSearchResults() {
        return excludeFromSearchResults;
    }

    public SelectOption<T> setExcludeFromSearchResults(boolean excludeFromSearchResults) {
        this.excludeFromSearchResults = excludeFromSearchResults;
        return this;
    }

    public FlexLayout getOptionLayoutElement() {
        return optionLayoutElement;
    }
}
