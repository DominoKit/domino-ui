package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class CheckBox implements IsElement<HTMLElement> {

    private HTMLDivElement container = Elements.div().asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private CheckHandler checkHandler = checked -> {
    };
    private Color color;

    public CheckBox(String id, String title) {
        inputElement.id = id;
        labelElement.setAttribute("for", id);
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        setTitle(title);
        inputElement.addEventListener("change", evt -> {
            checkHandler.onChecked(isChecked());
        });
    }

    public static CheckBox create(String id, String title) {
        return new CheckBox(id, title);
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }

    public CheckBox check() {
        inputElement.checked = true;
        return this;
    }

    public CheckBox uncheck() {
        inputElement.checked = false;
        return this;
    }

    public boolean isChecked() {
        return inputElement.checked;
    }

    public CheckBox setTitle(String title) {
        labelElement.textContent = title;
        return this;
    }

    public CheckBox setCheckHandler(CheckHandler handler) {
        this.checkHandler = handler;
        return this;
    }

    public CheckBox filledIn() {
        inputElement.classList.add("filled-in");
        return this;
    }

    public CheckBox filledOut() {
        inputElement.classList.remove("filled-in");
        return this;
    }

    public CheckBox enable() {
        inputElement.disabled = false;
        return this;
    }

    public CheckBox disable() {
        inputElement.disabled = true;
        return this;
    }

    public CheckBox setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("chk-" + this.color.getStyle());
        inputElement.classList.add("chk-" + color.getStyle());
        this.color = color;
        return this;
    }

    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }

    @FunctionalInterface
    public interface CheckHandler {
        void onChecked(boolean checked);
    }
}
