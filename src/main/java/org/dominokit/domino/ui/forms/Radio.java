package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.IsEditor;
import org.gwtproject.editor.client.LeafValueEditor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Radio extends BaseDominoElement<HTMLDivElement, Radio> implements HasName<Radio>, HasValue<Radio, String>, HasLabel<Radio>,
        Switchable<Radio>, Checkable<Radio>, LeafValueEditor<String>, IsEditor<LeafValueEditor<String>> {

    private HTMLDivElement container = div().css("form-group").asElement();
    private HTMLLabelElement labelElement = label().asElement();
    private HTMLInputElement inputElement = input("radio").asElement();
    private List<ChangeHandler<? super Boolean>> changeHandlers;
    private Color color;
    private boolean checked = false;
    private RadioGroup radioGroup;

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
        if(nonNull(radioGroup)){
            radioGroup.getRadios().forEach(radio -> radio.setChecked(false));
        }
        setChecked(true);
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio uncheck(boolean silent) {
        setChecked(false);
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    private void setChecked(boolean value){
        inputElement.checked = value;
        this.checked = value;
    }

    @Override
    public Radio removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    private void onCheck() {
        for (ChangeHandler<? super Boolean> checkHandler : changeHandlers)
            checkHandler.onValueChanged(isChecked());
    }

    @Override
    public boolean isChecked() {
        return this.checked;
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

    void setGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    @Override
    public LeafValueEditor<String> asEditor() {
        return this;
    }
}
