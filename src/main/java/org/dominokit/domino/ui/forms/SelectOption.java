package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasValue;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class SelectOption implements IsElement<HTMLLIElement>, HasValue<String>,
        HasBackground<SelectOption>, Selectable<SelectOption> {

    private static final String SELECTED = "selected";
    private String displayValue;
    private String value;
    private HTMLLIElement li;
    private HTMLAnchorElement aElement;
    private HTMLElement valueContainer;
    private HTMLElement checkMark;

    public SelectOption(String value, String displayValue) {
        li = Elements.li().asElement();
        aElement = Elements.a().attr("tabindex", "0")
                .attr("data-tokens", "null").asElement();
        valueContainer = Elements.span().css("text").asElement();
        aElement.appendChild(valueContainer);
        li.appendChild(aElement);
        checkMark = Elements.span().css("glyphicon glyphicon-ok check-mark").asElement();
        setValue(value);
        setDisplayValue(displayValue);
    }

    public SelectOption(String value) {
        this(value, value);
    }

    public static SelectOption create(String value, String displayValue) {
        return new SelectOption(value, displayValue);
    }

    public static SelectOption create(String value) {
        return new SelectOption(value);
    }

    public SelectOption appendContent(Node node) {
        aElement.appendChild(node);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public SelectOption setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
        valueContainer.textContent = displayValue;
        return this;
    }

    @Override
    public SelectOption select() {
        return select(false);
    }

    @Override
    public SelectOption deselect() {
        return deselect(false);
    }

    @Override
    public SelectOption select(boolean silent) {
        asElement().classList.add(SELECTED);
        aElement.appendChild(checkMark);
        return this;
    }

    @Override
    public SelectOption deselect(boolean silent) {
        asElement().classList.remove(SELECTED);
        aElement.removeChild(checkMark);
        return this;
    }

    @Override
    public boolean isSelected() {
        return asElement().classList.contains(SELECTED);
    }

    @Override
    public SelectOption setBackground(Color background) {
        asElement().classList.add(background.getBackground());
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return li;
    }

    public HTMLElement getCheckMark() {
        return checkMark;
    }

    public HTMLElement getValueContainer() {
        return valueContainer;
    }
}
