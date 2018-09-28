package org.dominokit.domino.ui.button.group;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Sizable;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ButtonsGroup extends BaseDominoElement<HTMLElement, ButtonsGroup> implements IsGroup<ButtonsGroup>, Sizable<ButtonsGroup> {

    static final String BTN_GROUP = "btn-group";
    private static final String BTN_GROUP_VERTICAL = "btn-group-vertical";
    private DominoElement<HTMLDivElement> groupElement = DominoElement.of(div().css(BTN_GROUP).attr("role", "group"));
    private ButtonSize size;

    public ButtonsGroup() {
        init(this);
    }

    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    /**
     * @deprecated use {@link #appendChild(Button)}
     */
    @Deprecated
    @Override
    public ButtonsGroup addButton(Button button) {
        return appendChild(button);
    }

    /**
     * @deprecated {@link #appendChild(DropdownButton)}
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
        return groupElement.asElement();
    }

    public ButtonsGroup setSize(ButtonSize size) {
        if (nonNull(this.size))
            groupElement.style().remove("btn-group-" + this.size.getStyle());
        groupElement.style().add("btn-group-" + size.getStyle());
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
        groupElement.style()
                .remove(toRemove)
                .add(toAdd);
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
