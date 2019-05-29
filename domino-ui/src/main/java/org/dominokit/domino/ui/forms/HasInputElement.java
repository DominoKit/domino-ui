package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

public interface HasInputElement {
    <E extends HTMLElement> DominoElement<E> getInputElement();
    String getStringValue();
}
