package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class TextBox implements IsElement<HTMLDivElement> {

    private static final String TEXT = "text";

    private HTMLDivElement formGroup = Elements.div().css("form-group").asElement();
    private HTMLInputElement inputElement;
    private HTMLDivElement inputContainer;
    private TextBoxSize size;
    private boolean floating;
    private String placeholder;
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
        setPlaceholder(placeholder);
        inputElement = Elements.input(type).css("form-control")
                .attr("placeholder", placeholder).asElement();
        inputContainer = Elements.div().css("form-line").asElement();
        inputContainer.appendChild(inputElement);
        formGroup.appendChild(inputContainer);

        addFocusListeners();
    }

    private void addFocusListeners() {
        formGroup.addEventListener("focusin", evt -> focus());
        formGroup.addEventListener("focusout", evt -> unfocus());
    }

    public TextBox unfocus() {
        if (!floating || inputElement.value.isEmpty())
            inputContainer.classList.remove("focused");
        return this;
    }

    public TextBox focus() {
        inputContainer.classList.add("focused");
        return this;
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
    public HTMLDivElement asElement() {
        return formGroup;
    }

    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    public HTMLDivElement getInputContainer() {
        return inputContainer;
    }

    public TextBox placeholder(String placeholder) {
        setPlaceholder(placeholder);
        inputElement.placeholder = placeholder;
        return this;
    }

    private void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public TextBox type(String type) {
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
            inputContainer.removeChild(label);
            inputElement.placeholder = placeholder;
            formGroup.classList.remove("form-float");
        }
        floating = false;
        return this;
    }

    public TextBox disable() {
        inputElement.setAttribute("disabled", "disabled");
        inputContainer.classList.add("disabled");
        return this;
    }

    public TextBox enable() {
        inputElement.removeAttribute("disabled");
        inputContainer.classList.remove("disabled");
        return this;
    }
}
