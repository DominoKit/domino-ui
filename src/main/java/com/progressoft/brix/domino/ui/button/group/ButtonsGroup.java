package com.progressoft.brix.domino.ui.button.group;

import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.button.ButtonSize;
import com.progressoft.brix.domino.ui.button.DropdownButton;
import com.progressoft.brix.domino.ui.utils.Sizable;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class ButtonsGroup implements IsElement<HTMLElement>, IsGroup<ButtonsGroup>, Sizable<ButtonsGroup> {

    static final String BTN_GROUP = "btn-group";
    private static final String BTN_GROUP_VERTICAL = "btn-group-vertical";
    private HTMLElement groupElement = Elements.div().css(BTN_GROUP).attr("role", "group").asElement();
    private ButtonSize size;

    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    @Override
    public ButtonsGroup addButton(Button button) {
        appendChild(button.asElement());
        return this;
    }

    @Override
    public ButtonsGroup addDropDown(DropdownButton nestedDropDown) {
        appendChild(nestedDropDown.asElement());
        return this;
    }

    private void appendChild(HTMLElement element) {
        groupElement.appendChild(element);
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public ButtonsGroup setSize(ButtonSize size) {
        if (nonNull(this.size))
            groupElement.classList.remove("btn-group-" + this.size.getStyle());
        groupElement.classList.add("btn-group-" + size.getStyle());
        this.size = size;
        return this;
    }

    @Override
    public ButtonsGroup verticalAlign() {
        return switchClasses(BTN_GROUP, BTN_GROUP_VERTICAL);
    }

    @Override
    public ButtonsGroup horizontalAlign() {
        return switchClasses(BTN_GROUP_VERTICAL, BTN_GROUP);
    }

    private ButtonsGroup switchClasses(String toRemove, String toAdd) {
        groupElement.classList.remove(toRemove);
        groupElement.classList.add(toAdd);
        return this;
    }

    @Override
    public ButtonsGroup large() {
        return setSize(ButtonSize.LARGE);
    }

    @Override
    public ButtonsGroup small() {
        return setSize(ButtonSize.SMALL);
    }

    @Override
    public ButtonsGroup xSmall() {
        return setSize(ButtonSize.XSMALL);
    }
}
