package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class DefaultColumnShowHideListener implements ColumnShowHideListener {

    private HTMLElement element;
    private boolean permanent = false;

    public static DefaultColumnShowHideListener of(HTMLElement element){
        return new DefaultColumnShowHideListener(element);
    }

    public static DefaultColumnShowHideListener of(HTMLElement element, boolean permanent){
        return new DefaultColumnShowHideListener(element, permanent);
    }

    public DefaultColumnShowHideListener(HTMLElement element) {
        this.element = element;
    }

    public DefaultColumnShowHideListener(HTMLElement element, boolean permanent) {
        this.element = element;
        this.permanent = permanent;
    }

    @Override
    public void onShowHide(boolean visible) {
        DominoElement.of(element).toggleDisplay(visible);
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }
}
