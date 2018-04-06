package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.utils.HasPlaceHolder;
import org.dominokit.domino.ui.utils.HasValue;
import org.jboss.gwt.elemento.core.Elements;

public class TextBox extends TextFormElement<TextBox> {

    private static final String TEXT = "text";

    private HTMLInputElement inputElement;
    private TextBoxSize size;
    private boolean floating;
    private HTMLLabelElement label;

    public enum TextBoxSize {
        LARGE("form-group-lg"),
        SMALL("form-group-sm"),
        DEFAULT("form-group");

        private String style;

        TextBoxSize(String style) {
            this.style = style;
        }

    }

    public TextBox() {
        this(TEXT, "");
    }

    public TextBox(String placeholder) {
        this(TEXT, placeholder);
    }

    public TextBox(String type, String placeholder) {
        inputElement = Elements.input(type).css("form-control")
                .attr("placeholder", placeholder).asElement();
        inputContainer.appendChild(inputElement);
    }

    public static TextBox create() {
        return new TextBox();
    }

    public static TextBox create(String placeholder) {
        return new TextBox(placeholder);
    }

    public static TextBox password(String placeholder) {
        return new TextBox("password", placeholder);
    }

    @Override
    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    @Override
    public String getPlaceholder() {
        return inputElement.placeholder;
    }

    @Override
    public TextBox setPlaceholder(String placeholder) {
        inputElement.placeholder = placeholder;
        return this;
    }

    public TextBox setType(String type) {
        inputElement.type = type;
        return this;
    }

    public TextBox large() {
        return setSize(TextBoxSize.LARGE);
    }

    public TextBox small() {
        return setSize(TextBoxSize.SMALL);
    }

    public TextBox setSize(TextBoxSize size) {
        if (this.size != null)
            formGroup.classList.remove(size.style);
        formGroup.classList.add(size.style);
        this.size = size;
        return this;
    }

    public TextBox floating() {
        if (!floating) {
            label = Elements.label().css("form-label").textContent(inputElement.placeholder).asElement();
            label.addEventListener("click", evt -> {
                focus();
                inputElement.focus();
            });
            inputContainer.appendChild(label);
            inputElement.removeAttribute("placeholder");
            formGroup.classList.add("form-float");
        }
        this.floating = true;
        return this;
    }

    public TextBox nonfloating() {
        if (floating) {
            inputElement.placeholder = label.textContent;
            inputContainer.removeChild(label);
            formGroup.classList.remove("form-float");
        }
        floating = false;
        return this;
    }

    @Override
    public TextBox unfocus() {
        if (!floating || getValue().isEmpty())
            super.unfocus();
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
}
