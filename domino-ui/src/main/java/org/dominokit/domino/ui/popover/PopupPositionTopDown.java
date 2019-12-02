package org.dominokit.domino.ui.popover;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

public class PopupPositionTopDown implements PopupPosition {

    private String positionClass;

    @Override
    public void position(HTMLElement popup, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        double bottom = targetRect.bottom + popup.getBoundingClientRect().height;
        int innerHeight = DomGlobal.window.innerHeight;
        if (bottom > innerHeight) {
            PopupPosition.TOP.position(popup, target);
            this.positionClass = PopupPosition.TOP.getDirectionClass();
        } else {
            PopupPosition.BOTTOM.position(popup, target);
            this.positionClass = PopupPosition.BOTTOM.getDirectionClass();
        }
    }

    @Override
    public String getDirectionClass() {
        return positionClass;
    }
}
