package org.dominokit.domino.ui.button.group;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Sizable;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class ButtonsGroup extends BaseDominoElement<HTMLElement, ButtonsGroup> implements IsGroup<ButtonsGroup>, Sizable<ButtonsGroup> {

    static final String BTN_GROUP = "btn-group";
    private static final String BTN_GROUP_VERTICAL = "btn-group-vertical";
    private HTMLElement groupElement = Elements.div().css(BTN_GROUP).attr("role", "group").asElement();
    private ButtonSize size;

    public ButtonsGroup() {
        init(this);
    }

    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    /**
     * @deprecated use {@link #appendChild(Button)}
     * @param button
     * @return
     */
    @Deprecated
    @Override
    public ButtonsGroup addButton(Button button) {
        return appendChild(button);
    }

    /**
     * @deprecated {@link #appendChild(DropdownButton)}
     * @param nestedDropDown
     * @return
     */
    @Deprecated
    @Override
    public ButtonsGroup addDropDown(DropdownButton nestedDropDown) {
        return appendChild(nestedDropDown);
    }

    @Override
    public ButtonsGroup appendChild(Button button) {
        appendChild(button.asElement());
        return this;
    }

    @Override
    public ButtonsGroup appendChild(DropdownButton dropDown) {
        appendChild(dropDown.asElement());
        return this;
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
