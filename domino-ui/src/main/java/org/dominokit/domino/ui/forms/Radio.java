package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.TakesValue;
import elemental2.dom.*;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class Radio<T> extends BaseDominoElement<HTMLDivElement, Radio<T>> implements HasName<Radio<T>>, HasValue<Radio<T>, T>, HasLabel<Radio<T>>,
        Switchable<Radio<T>>, Checkable<Radio<T>>, TakesValue<T> {

    private FlexItem container = FlexItem.create().addCss("radio-option");
    private HTMLLabelElement labelElement = label().element();
    private HTMLInputElement inputElement = input("radio").element();
    private DominoElement<HTMLParagraphElement> helperTextElement = DominoElement.of(p());
    private List<ChangeHandler<? super Boolean>> changeHandlers;
    private Color color;
    private boolean checked = false;
    private RadioGroup<? super T> radioGroup;
    private T value;

    public Radio(T value, String label) {
        changeHandlers = new ArrayList<>();
        linkLabelToField();
        container.appendChild(labelElement);
        container.appendChild(inputElement);
        setLabel(label);
        value(value);
        container.addEventListener("click", evt -> {
            if (isEnabled() && !isChecked())
                check();
        });
        inputElement.addEventListener("change", evt -> onCheck());
        init(this);
    }

    public Radio(T value) {
        this(value, String.valueOf(value));
    }

    public static <E> Radio<E> create(E value, String label) {
        return new Radio<>(value, label);
    }

    public static <E> Radio<E> create(E value) {
        return new Radio<>(value);
    }

    private void linkLabelToField() {
        DominoElement<HTMLInputElement> asDominoElement = DominoElement.of(inputElement);
        if(!asDominoElement.hasAttribute("id")){
            inputElement.setAttribute("id", asDominoElement.getAttribute(BaseDominoElement.DOMINO_UUID));
        }
        labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
    }

    @Override
    public Radio<T> check() {
        return check(false);
    }

    public Radio<T> uncheck() {
        return uncheck(false);
    }

    @Override
    public Radio<T> check(boolean silent) {
        if (nonNull(radioGroup)) {
            radioGroup.getRadios().forEach(radio -> radio.setChecked(false));
        }
        setChecked(true);
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio<T> uncheck(boolean silent) {
        setChecked(false);
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio<T> addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    private void setChecked(boolean value) {
        inputElement.checked = value;
        this.checked = value;
        if(this.checked){
            element.css("checked");
        }else{
            element.removeCss("checked");
        }
    }

    @Override
    public Radio<T> removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
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

    public Radio<T> withGap() {
        Style.of(inputElement).add("with-gap");
        element.css("with-gap");
        return this;
    }

    public Radio<T> withoutGap() {
        Style.of(inputElement).remove("with-gap");
        element.removeCss("with-gap");
        return this;
    }

    public Radio<T> setColor(Color color) {
        if (this.color != null) {
            element.removeCss(this.color.getStyle());
        }
        element.css(color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return container.element();
    }

    @Override
    public String getName() {
        return inputElement.name;
    }

    @Override
    public Radio<T> setName(String name) {
        inputElement.name = name;
        return this;
    }

    @Override
    public Radio<T> value(T value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public Radio<T> setLabel(String label) {
        labelElement.textContent = label;
        return this;
    }

    public Radio<T> setLabel(SafeHtml safeHtml) {
        labelElement.innerHTML = safeHtml.asString();
        return this;
    }

    public Radio<T> setLabel(Node node) {
        DominoElement.of(labelElement)
                .clearElement()
                .appendChild(node);
        return this;
    }

    public Radio<T> setLabel(IsElement<?> element) {
       return setLabel(element.element());
    }

    @Override
    public String getLabel() {
        return labelElement.textContent;
    }

    @Override
    public Radio<T> enable() {
        inputElement.disabled = false;
        element.removeCss("disabled");
        return this;
    }

    @Override
    public Radio<T> disable() {
        inputElement.disabled = true;
        element.css("disabled");
        return this;
    }

    public Radio<T> setHelperText(String text) {
        helperTextElement.setTextContent(text);
        if (!DominoElement.of(labelElement).contains(helperTextElement.element())) {
            labelElement.appendChild(helperTextElement.element());
        }
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !inputElement.disabled;
    }

    void setGroup(RadioGroup<? super T> radioGroup) {
        this.radioGroup = radioGroup;
    }
}
