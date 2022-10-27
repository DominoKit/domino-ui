package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLButtonElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class RemoveButton extends BaseDominoElement<HTMLButtonElement, RemoveButton> {

    private DominoElement<HTMLButtonElement> button;

    public static RemoveButton create(){
        return new RemoveButton();
    }

    public RemoveButton() {
        button= DominoElement.button()
            .addCss(GenericCss.dui_close)
            .appendChild(DominoElement.span().textContent("×"));
            init(this);
    }

    @Override
    public HTMLButtonElement element() {
        return button.element();
    }
}
