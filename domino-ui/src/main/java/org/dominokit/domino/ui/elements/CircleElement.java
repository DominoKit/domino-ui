package org.dominokit.domino.ui.elements;

import elemental2.svg.SVGCircleElement;

public class CircleElement extends BaseElement<SVGCircleElement, CircleElement> {
    public static CircleElement of(SVGCircleElement e){
        return new CircleElement(e);
    }

    public CircleElement(SVGCircleElement element) {
        super(element);
    }
}
