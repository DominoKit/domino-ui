package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLMeterElement;

public class MeterElement extends BaseElement<HTMLMeterElement, MeterElement> {
    public static MeterElement of(HTMLMeterElement e) {
        return new MeterElement(e);
    }

    public MeterElement(HTMLMeterElement element) {
        super(element);
    }
}