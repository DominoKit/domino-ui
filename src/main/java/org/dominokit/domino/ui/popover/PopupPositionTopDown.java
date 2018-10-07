package org.dominokit.domino.ui.popover;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

public class PopupPositionTopDown implements PopupPosition {

    private String positionClass;

    @Override
    public void position(HTMLElement popup, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect tooltipRect = popup.getBoundingClientRect();

        double distanceToMiddle =((targetRect.top)-(tooltipRect.height/2));
        double windowMiddle = DomGlobal.window.innerHeight/2;

        if(distanceToMiddle>=windowMiddle){
            PopupPosition.TOP.position(popup, target);
            this.positionClass = PopupPosition.TOP.getDirectionClass();
        }else{
            PopupPosition.BOTTOM.position(popup, target);
            this.positionClass = PopupPosition.BOTTOM.getDirectionClass();
        }

    }

    @Override
    public String getDirectionClass() {
        return positionClass;
    }
}
