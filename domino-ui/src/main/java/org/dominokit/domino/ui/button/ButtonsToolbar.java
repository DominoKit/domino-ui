package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.Elements;

/**
 * a component for a toolbar that has many buttons
 *
 *<p>
 *     This class is used to group buttons in a set of groups to form a toolbar
 *     <pre>
 *         ButtonsToolbar.create()
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("1"))
 *                      .appendChild(Button.createDefault("2"))
 *                      .appendChild(Button.createDefault("3")))
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("4"))
 *                      .appendChild(Button.createDefault("5"))
 *                      .appendChild(Button.createDefault("6")))
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("7"))
 *                    );
 *     </pre>
 *</p>
 */
public class ButtonsToolbar extends BaseDominoElement<HTMLElement, ButtonsToolbar> {

    private HTMLElement toolbarElement = Elements.div().css(ButtonStyles.BUTTON_TOOLBAR)
            .attr("role", "toolbar")
            .element();

    /**
     * default constructor
     */
    public ButtonsToolbar() {
        init(this);
    }

    /**
     *
     * @return a new ButtonsToolbar instance
     */
    public static ButtonsToolbar create() {
        return new ButtonsToolbar();
    }

    /**
     * Adds a a ButtonsGroup to the toolbar
     * @param group {@link ButtonsGroup}
     * @return new ButtonsToolbar instance
     */
    public ButtonsToolbar addGroup(ButtonsGroup group) {
        toolbarElement.appendChild(group.element());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return toolbarElement;
    }

}
