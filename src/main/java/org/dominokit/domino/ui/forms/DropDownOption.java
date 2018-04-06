package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasValue;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class DropDownOption implements IsElement<HTMLLIElement>, HasValue<String>,
        HasBackground<DropDownOption>, Selectable<DropDownOption> {

    private static final String SELECTED = "selected";
    private String displayValue;
    private String value;
    private HTMLLIElement li;
    private HTMLAnchorElement aElement;
    private HTMLElement valueContainer;
    private HTMLElement checkMark;

    public DropDownOption(String value, String displayValue) {
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

    public DropDownOption(String value) {
        this(value, value);
    }

    public static DropDownOption create(String value, String displayValue) {
        return new DropDownOption(value, displayValue);
    }

    public static DropDownOption create(String value) {
        return new DropDownOption(value);
    }

    @Override
    public HTMLLIElement asElement() {
        return li;
    }

    public DropDownOption appendContent(Node node) {
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

    public DropDownOption setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
        valueContainer.textContent = displayValue;
        return this;
    }

    @Override
    public DropDownOption select() {
        asElement().classList.add(SELECTED);
        aElement.appendChild(checkMark);
        return this;
    }

    @Override
    public DropDownOption deselect() {
        asElement().classList.remove(SELECTED);
        aElement.removeChild(checkMark);
        return this;
    }

    @Override
    public boolean isSelected() {
        return asElement().classList.contains(SELECTED);
    }

    @Override
    public DropDownOption setBackground(Background background) {
        asElement().classList.add(background.getStyle());
        return this;
    }

    public HTMLElement getCheckMark() {
        return checkMark;
    }

    public HTMLElement getValueContainer() {
        return valueContainer;
    }
}
