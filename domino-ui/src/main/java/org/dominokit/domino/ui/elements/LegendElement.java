package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLLegendElement;

public class LegendElement extends BaseElement<HTMLLegendElement, LegendElement> {
    public static LegendElement of(HTMLLegendElement e) {
        return new LegendElement(e);
    }

    public LegendElement(HTMLLegendElement element) {
        super(element);
    }
}