package org.dominokit.domino.ui.button.group;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Sizable;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ButtonsGroup extends WavesElement<HTMLElement, ButtonsGroup> implements IsGroup<ButtonsGroup>, Sizable<ButtonsGroup> {

    private DominoElement<HTMLDivElement> groupElement = DominoElement.of(div()
            .css(ButtonStyles.BTN_GROUP)
            .attr("role", "group"));
    private ButtonSize size;

    public ButtonsGroup() {
        init(this);
        initWaves();
    }

    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    @Override
    public ButtonsGroup appendChild(Button button) {
        appendChild(button.element());
        return this;
    }

    @Override
    public ButtonsGroup appendChild(DropdownButton dropDown) {
        appendChild(dropDown.element());
        return this;
    }

    @Override
    public HTMLElement element() {
        return groupElement.element();
    }

    public ButtonsGroup setSize(ButtonSize size) {
        if (nonNull(this.size))
            groupElement.style().remove(this.size.getStyle());
        groupElement.style().add(size.getStyle());
        this.size = size;
        return this;
    }

    @Override
    public ButtonsGroup verticalAlign() {
        return switchClasses(ButtonStyles.BTN_GROUP, ButtonStyles.BTN_GROUP_VERTICAL);
    }

    @Override
    public ButtonsGroup horizontalAlign() {
        return switchClasses(ButtonStyles.BTN_GROUP_VERTICAL, ButtonStyles.BTN_GROUP);
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
    public ButtonsGroup medium() {
        return setSize(ButtonSize.MEDIUM);
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
