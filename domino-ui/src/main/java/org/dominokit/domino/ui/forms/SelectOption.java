package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.TakesValue;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.span;

public class SelectOption<T> extends BaseDominoElement<HTMLDivElement, SelectOption<T>> implements HasValue<SelectOption, T>,
        HasBackground<SelectOption>, Selectable<SelectOption>, TakesValue<T> {

    private static final String SELECTED = "select-option-selected";
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("select-option"));
    private DominoElement<HTMLElement> valueContainer = DominoElement.of(span().css(Styles.ellipsis_text));
    private Icon checkMark = Icons.ALL.check().styler(style1 -> style1.add(Styles.pull_right)
            .add("select-option-check-mark"));
    private String displayValue;
    private String key;
    private T value;
    private List<Selectable.SelectionHandler<SelectOption>> selectionHandlers = new ArrayList<>();
    private FlexItem checkMarkFlexItem;
    private boolean excludeFromSearchResults = false;

    public SelectOption(T value, String key, String displayValue) {
        setKey(key);
        setValue(value);
        setDisplayValue(displayValue);
        checkMarkFlexItem = FlexItem.create();
        element
                .appendChild(FlexLayout.create()
                        .appendChild(FlexItem.create()
                                .css(Styles.ellipsis_text)
                                .setFlexGrow(1)
                                .appendChild(valueContainer))
                        .appendChild(checkMarkFlexItem)
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

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public SelectOption<T> appendContent(Node node) {
        return appendChild(node);
    }

    public SelectOption<T> appendChild(Node node) {
        element.appendChild(node);
        return this;
    }

    public SelectOption<T> appendChild(IsElement node) {
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
        checkMarkFlexItem.appendChild(checkMark);
        if (!silent) {
            selectionHandlers.forEach(handler -> handler.onSelectionChanged(this));
        }
        return this;
    }

    @Override
    public SelectOption<T> deselect(boolean silent) {
        style().remove(SELECTED);
        if (element.contains(checkMark.element()))
            checkMark.remove();
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

    public Icon getCheckMark() {
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
}
