package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasValue;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class SelectOption<T> extends DominoElement<HTMLLIElement, SelectOption<T>> implements IsElement<HTMLLIElement>, HasValue<SelectOption, T>,
        HasBackground<SelectOption>, Selectable<SelectOption> {

    private static final String SELECTED = "selected";
    private String displayValue;
    private String key;
    private T value;
    private HTMLLIElement li;
    private HTMLAnchorElement aElement;
    private HTMLElement valueContainer;
    private HTMLElement checkMark;

    public SelectOption(T value, String key, String displayValue) {
        li = Elements.li().asElement();
        aElement = Elements.a().attr("data-tokens", "null")
                .attr("tabindex", "0").asElement();
        valueContainer = Elements.span().css("text").asElement();
        aElement.appendChild(valueContainer);
        li.appendChild(aElement);
        checkMark = Elements.span().css("glyphicon glyphicon-ok check-mark").asElement();
        setKey(key);
        setValue(value);
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
     * @param node
     * @return
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
    public SelectOption<T> setValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public T getValue() {
        return this.value;
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

    public DominoElement<HTMLElement, IsElement<HTMLElement>> getCheckMark() {
        return DominoElement.of(checkMark);
    }

    public DominoElement<HTMLElement, IsElement<HTMLElement>> getValueContainer() {
        return DominoElement.of(valueContainer);
    }

    public DominoElement<HTMLAnchorElement, IsElement<HTMLAnchorElement>> getLinkElement() {
        return DominoElement.of(aElement);
    }

    public void focus() {
        aElement.focus();
    }
}
