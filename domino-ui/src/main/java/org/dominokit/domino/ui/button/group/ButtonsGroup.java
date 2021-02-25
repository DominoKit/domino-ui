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
import static org.jboss.elemento.Elements.div;

/**
 * a component to group a set of buttons.
 * <p>
 *     This component wraps a set of different Buttons into one group
 *     the grouped buttons can be aligned horizontally or vertically
 *     and the group can apply some properties to all grouped button
 *
 *     <pre>
 *         ButtonsGroup.create()
 *            .appendChild(Button.createDefault("LEFT"))
 *            .appendChild(Button.createDefault("MIDDLE"))
 *            .appendChild(Button.createDefault("RIGHT"))
 *            .setSize(ButtonSize.LARGE);
 *     </pre>
 * </p>
 */
public class ButtonsGroup extends WavesElement<HTMLElement, ButtonsGroup> implements IsGroup<ButtonsGroup>, Sizable<ButtonsGroup> {

    private DominoElement<HTMLDivElement> groupElement = DominoElement.of(div()
            .css(ButtonStyles.BTN_GROUP)
            .attr("role", "group"));
    private ButtonSize size;

    /**
     * default constructor
     */
    public ButtonsGroup() {
        init(this);
        initWaves();
    }

    /**
     *
     * @return a new ButtonsGroup instance
     */
    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    /**
     * adds a Button to the ButtonsGroup
     * @param button {@link Button}
     * @return same ButtonsGroup instance
     */
    @Override
    public ButtonsGroup appendChild(Button button) {
        appendChild(button.element());
        return this;
    }


    /**
     * adds a DropdownButton to the ButtonsGroup
     * @param dropDown {@link DropdownButton}
     * @return same ButtonsGroup instance
     */
    @Override
    public ButtonsGroup appendChild(DropdownButton dropDown) {
        appendChild(dropDown.element());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return groupElement.element();
    }

    /**
     * Apply a size to all buttons in the ButtonsGroup
     * @param size {@link ButtonSize}
     * @return same ButtonsGroup instance
     */
    public ButtonsGroup setSize(ButtonSize size) {
        if (nonNull(this.size))
            groupElement.style().remove(this.size.getStyle());
        groupElement.style().add(size.getStyle());
        this.size = size;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonsGroup verticalAlign() {
        return switchClasses(ButtonStyles.BTN_GROUP, ButtonStyles.BTN_GROUP_VERTICAL);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonsGroup large() {
        return setSize(ButtonSize.LARGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonsGroup medium() {
        return setSize(ButtonSize.MEDIUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonsGroup small() {
        return setSize(ButtonSize.SMALL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonsGroup xSmall() {
        return setSize(ButtonSize.XSMALL);
    }

}
