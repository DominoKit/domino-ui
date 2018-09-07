package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;

/**
 * @deprecated use {@link #Button}
 */
@Deprecated
public class IconButton extends BaseButton<IconButton> {

    @Override
    public HTMLElement asElement() {
        return buttonElement;
    }
}
