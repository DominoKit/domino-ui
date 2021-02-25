package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Button component with an action button and a split dropdown menu.
 *
 * <p>
 *     This class is works like a button group but it will be always initialized with a default simple button.
 *     and only allow appending DropdownButton(s)
 * </p>
 */
public class SplitButton extends BaseDominoElement<HTMLElement, SplitButton> {

    private HTMLElement groupElement = ButtonsGroup.create().element();

    private SplitButton(String content, StyleType type) {
        addButton(Button.create(content).setButtonType(type));
        init(this);
    }

    private SplitButton(String content, Color background) {
        addButton(Button.create(content).setBackground(background));
        init(this);
    }

    private SplitButton(String content) {
        addButton(Button.create(content));
        init(this);
    }

    private void addButton(Button button) {
        groupElement.appendChild(button.element());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return groupElement;
    }

    /**
     * Creates a SplitButton with text
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton create(String text) {
        return new SplitButton(text);
    }


    /**
     * Creates a SplitButton with text with background
     * @param text String - the button text
     * @param background the background {@link Color}
     * @return new SplitButton instance
     */
    public static SplitButton create(String text, Color background) {
        return new SplitButton(text, background);
    }

    /**
     * Creates a SplitButton with text and apply a {@link StyleType}
     * @param text String - the button text
     * @param type {@link StyleType}
     * @return new SplitButton instance
     */
    public static SplitButton create(String text, StyleType type) {
        return new SplitButton(text, type);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#DEFAULT}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createDefault(String text) {
        return create(text, StyleType.DEFAULT);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#PRIMARY}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createPrimary(String text) {
        return create(text, StyleType.PRIMARY);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#SUCCESS}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createSuccess(String text) {
        return create(text, StyleType.SUCCESS);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#INFO}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createInfo(String text) {
        return create(text, StyleType.INFO);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#WARNING}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createWarning(String text) {
        return create(text, StyleType.WARNING);
    }

    /**
     * Creates a SplitButton with text and apply {@link StyleType#DANGER}
     * @param text String - the button text
     * @return new SplitButton instance
     */
    public static SplitButton createDanger(String text) {
        return create(text, StyleType.DANGER);
    }

    /**
     * appends a dropdown button the SplitButton group.
     * @return same SplitButton instance
     */
    public SplitButton addDropdown(DropdownButton dropdownButton) {
        groupElement.appendChild(dropdownButton.element());
        return this;
    }
}
