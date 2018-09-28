package org.dominokit.domino.ui.forms;

import com.google.gwt.user.client.TakesValue;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.*;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Radio extends BaseDominoElement<HTMLDivElement, Radio> implements HasName<Radio>, HasValue<Radio, String>, HasLabel<Radio>,
        Switchable<Radio>, Checkable<Radio>, TakesValue<String> {

    private HTMLDivElement container = div().css("form-group").asElement();
    private HTMLLabelElement labelElement = label().asElement();
    private HTMLInputElement inputElement = input("radio").asElement();
    private List<ChangeHandler<Boolean>> changeHandlers;
    private Color color;

    public Radio(String value, String label) {
        changeHandlers = new ArrayList<>();
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        setLabel(label);
        value(value);
        container.addEventListener("click", evt -> {
            if (isEnabled() && !isChecked())
                check();
        });
        inputElement.addEventListener("change", evt -> onCheck());
        init(this);
    }

    public Radio(String value) {
        this(value, value);
    }

    public static Radio create(String value, String label) {
        return new Radio(value, label);
    }

    public static Radio create(String value) {
        return new Radio(value);
    }

    @Override
    public Radio check() {
        return check(false);
    }

    public Radio uncheck() {
        return uncheck(false);
    }

    @Override
    public Radio check(boolean silent) {
        inputElement.checked = true;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio uncheck(boolean silent) {
        inputElement.checked = false;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio addChangeHandler(ChangeHandler<Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public Radio removeChangeHandler(ChangeHandler<Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
        return this;
    }

    private void onCheck() {
        for (ChangeHandler<Boolean> checkHandler : changeHandlers)
            checkHandler.onValueChanged(isChecked());
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
    }

    public Radio withGap() {
        Style.of(inputElement).add("with-gap");
        return this;
    }

    public Radio withoutGap() {
        Style.of(inputElement).remove("with-gap");
        return this;
    }

    public Radio setColor(Color color) {
        if (this.color != null)
            Style.of(inputElement).remove(this.color.getStyle());
        Style.of(inputElement).add(color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    @Override
    public String getName() {
        return inputElement.name;
    }

    @Override
    public Radio setName(String name) {
        inputElement.name = name;
        return this;
    }

    @Override
    public Radio value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(String value) {
        inputElement.value = value;
    }

    @Override
    public String getValue() {
        return inputElement.value;
    }

    @Override
    public Radio setLabel(String label) {
        labelElement.textContent = label;
        return this;
    }

    @Override
    public String getLabel() {
        return labelElement.textContent;
    }

    @Override
    public Radio enable() {
        inputElement.disabled = false;
        return this;
    }

    @Override
    public Radio disable() {
        inputElement.disabled = true;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !inputElement.disabled;
    }
}
