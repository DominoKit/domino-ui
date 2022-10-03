package org.dominokit.domino.ui.forms;

import elemental2.dom.Element;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasCounter;
import org.dominokit.domino.ui.utils.HasMinMaxLength;

import java.util.List;

import static org.dominokit.domino.ui.forms.FormsStyles.FORM_FIELD;
import static org.dominokit.domino.ui.keyboard.KeyboardEvents.listenOnKeyPress;

public class InputFieldInitializer<T extends FormElement<T, V> , V> {

    private final T formElement;
    private V oldValue;

    public static <T extends FormElement<T, V> , V> InputFieldInitializer<T, V> create(T formElement){
        return new InputFieldInitializer<>(formElement);
    }

    public InputFieldInitializer(T formElement) {
        this.formElement = formElement;
        this.oldValue = formElement.getValue();
    }

    public InputFieldInitializer<T,V> init(HasInputElement<T> hasInput){
        DominoElement<HTMLInputElement> inputElement = hasInput.getInputElement();
        inputElement.addEventListener("change", evt -> {
            if(hasInput.onChange().isPresent()){
                hasInput.onChange().get().accept(evt);
            }else {
                if(formElement.isEnabled() && !formElement.isReadOnly()) {
                    formElement.triggerChangeListeners(oldValue, formElement.getValue());
                    this.oldValue = formElement.getValue();
                }
            }
        });
        inputElement.addEventListener("focusout", evt -> {
            if (formElement.isAutoValidation() && !formElement.isFocusValidationsPaused()) {
                formElement.validate();
            }
        });
        if(formElement instanceof HasCounter && formElement instanceof HasMinMaxLength){
            HasCounter<T> countableElement = (HasCounter<T>) formElement;
            HasMinMaxLength<T> hasLength = (HasMinMaxLength<T>) formElement;
            inputElement.addEventListener("input", evt -> countableElement.updateCounter(hasLength.getLength(), countableElement.getMaxCount()));
        }
        listenOnKeyPress(inputElement)
                .onEnter(
                        evt -> {
                            if (DominoUIConfig.CONFIG.isFocusNextFieldOnEnter()) {
                                inputElement.blur();
                                List<Element> elements =
                                        DominoElement.body()
                                                .element()
                                                .querySelectorAll("." + FORM_FIELD.getCssClass())
                                                .asList();
                                int i = elements.indexOf(formElement);
                                if (i < elements.size() - 1) {
                                    Element element = elements.get(i + 1);
                                    Element input = element.querySelector(".dui-field-input");
                                    Js.<HTMLInputElement>uncheckedCast(input).focus();
                                }
                            }
                        });

        return this;
    }
}
