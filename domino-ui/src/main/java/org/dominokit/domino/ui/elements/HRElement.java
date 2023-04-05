package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHRElement;

public class HRElement extends BaseElement<HTMLHRElement, HRElement> {
    public static HRElement of(HTMLHRElement e) {
        return new HRElement(e);
    }

    public HRElement(HTMLHRElement element) {
        super(element);
    }
}
