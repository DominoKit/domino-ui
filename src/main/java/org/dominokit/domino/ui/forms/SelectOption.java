package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.LeafValueEditor;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class SelectOption<T> extends BaseDominoElement<HTMLLIElement, SelectOption<T>> implements HasValue<SelectOption, T>,
        HasBackground<SelectOption>, Selectable<SelectOption>, LeafValueEditor<T> {

    private static final String SELECTED = "selected";
    private String displayValue;
    private String key;
    private T value;
    private HTMLLIElement li;
    private HTMLAnchorElement aElement;
    private HTMLElement valueContainer;
    private HTMLElement checkMark;
    private List<SelectionHandler<SelectOption>> selectionHandlers = new ArrayList<>();


    public SelectOption(T value, String key, String displayValue) {
        li = Elements.li().asElement();
        aElement = Elements.a().attr("data-tokens", "null")
                .attr("tabindex", "0").asElement();
        valueContainer = Elements.span().css("text", "ellipsis").asElement();
        aElement.appendChild(valueContainer);
        li.appendChild(aElement);
        checkMark = Elements.span().css("glyphicon glyphicon-ok check-mark").asElement();
        setKey(key);
        value(value);
        setDisplayValue(displayValue);
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
        aElement.appendChild(node);
        return this;
    }

    public SelectOption<T> appendChild(IsElement node) {
        aElement.appendChild(node.asElement());
        return this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public SelectOption<T> value(T value) {
        setValue(value);
        return this;
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
    public void addSelectionHandler(SelectionHandler<SelectOption> selectionHandler) {
        selectionHandlers.add(selectionHandler);
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public SelectOption<T> setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
        valueContainer.textContent = displayValue;
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
        aElement.appendChild(checkMark);
        if (!silent) {
            selectionHandlers.forEach(handler -> handler.onSelectionChanged(this));
        }
        return this;
    }

    @Override
    public SelectOption<T> deselect(boolean silent) {
        style().remove(SELECTED);
        if (aElement.contains(checkMark))
            aElement.removeChild(checkMark);
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
    public HTMLLIElement asElement() {
        return li;
    }

    public DominoElement<HTMLElement> getCheckMark() {
        return DominoElement.of(checkMark);
    }

    public DominoElement<HTMLElement> getValueContainer() {
        return DominoElement.of(valueContainer);
    }

    public DominoElement<HTMLAnchorElement> getLinkElement() {
        return DominoElement.of(aElement);
    }

    public void focus() {
        aElement.focus();
    }
}
