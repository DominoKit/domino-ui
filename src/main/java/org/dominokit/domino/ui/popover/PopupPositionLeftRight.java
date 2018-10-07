package org.dominokit.domino.ui.popover;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

public class PopupPositionLeftRight implements PopupPosition {

    private String positionClass;

    @Override
    public void position(HTMLElement popup, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect tooltipRect = popup.getBoundingClientRect();

        double distanceToCenter = targetRect.left - (tooltipRect.width / 2);
        double windowCenter = DomGlobal.window.innerWidth / 2;

        if (distanceToCenter >= windowCenter) {
            PopupPosition.LEFT.position(popup, target);
            this.positionClass = PopupPosition.LEFT.getDirectionClass();
        } else {
            PopupPosition.RIGHT.position(popup, target);
            this.positionClass = PopupPosition.RIGHT.getDirectionClass();
        }
    }

    @Override
    public String getDirectionClass() {
        return positionClass;
    }
}
