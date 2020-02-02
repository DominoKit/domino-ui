package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.Elements;

public class ButtonsToolbar extends BaseDominoElement<HTMLElement, ButtonsToolbar> {

    private HTMLElement toolbarElement = Elements.div().css(ButtonStyles.BUTTON_TOOLBAR)
            .attr("role", "toolbar")
            .element();

    public ButtonsToolbar() {
        init(this);
    }

    public static ButtonsToolbar create() {
        return new ButtonsToolbar();
    }

    public ButtonsToolbar addGroup(ButtonsGroup group) {
        toolbarElement.appendChild(group.element());
        return this;
    }

    @Override
    public HTMLElement element() {
        return toolbarElement;
    }

}
