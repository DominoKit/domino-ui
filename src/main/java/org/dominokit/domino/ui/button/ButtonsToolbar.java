package org.dominokit.domino.ui.button;

import org.dominokit.domino.ui.button.group.ButtonsGroup;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class ButtonsToolbar implements IsElement<HTMLElement> {

    private HTMLElement toolbarElement = Elements.div().css("btn-toolbar").attr("role", "toolbar").asElement();

    public static ButtonsToolbar create() {
        return new ButtonsToolbar();
    }

    public ButtonsToolbar addGroup(ButtonsGroup group) {
        toolbarElement.appendChild(group.asElement());
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return toolbarElement;
    }
}
