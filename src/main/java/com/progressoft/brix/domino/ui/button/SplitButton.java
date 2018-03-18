package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.button.group.ButtonsGroup;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.StyleType;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class SplitButton implements IsElement<HTMLElement> {

    private HTMLElement groupElement = ButtonsGroup.create().asElement();

    private SplitButton(String content, StyleType type) {
        addButton(Button.create(content).setButtonType(type));
    }

    private SplitButton(String content, Background background) {
        addButton(Button.create(content).setBackground(background));
    }

    private SplitButton(String content) {
        addButton(Button.create(content));
    }

    private void addButton(Button button) {
        groupElement.appendChild(button.asElement());
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public static SplitButton create(String content) {
        return new SplitButton(content);
    }

    public static SplitButton create(String content, Background background) {
        return new SplitButton(content, background);
    }

    public static SplitButton create(String content, StyleType type) {
        return new SplitButton(content, type);
    }

    public static SplitButton createDefault(String content) {
        return create(content, StyleType.DEFAULT);
    }

    public static SplitButton createPrimary(String content) {
        return create(content, StyleType.PRIMARY);
    }

    public static SplitButton createSuccess(String content) {
        return create(content, StyleType.SUCCESS);
    }

    public static SplitButton createInfo(String content) {
        return create(content, StyleType.INFO);
    }

    public static SplitButton createWarning(String content) {
        return create(content, StyleType.WARNING);
    }

    public static SplitButton createDanger(String content) {
        return create(content, StyleType.DANGER);
    }

    public SplitButton addDropdown(DropdownButton dropdownButton) {
        HTMLElement dropdownElement = dropdownButton.justify();
        String content = dropdownElement.firstChild.textContent;
        dropdownElement.firstChild.removeChild(dropdownElement.firstChild.firstChild);
        dropdownElement.firstChild.appendChild(Elements.span().css("sr-only").textContent(content).asElement());
        groupElement.appendChild(dropdownElement);
        return this;
    }
}
