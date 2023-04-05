package org.dominokit.domino.ui.elements;

import elemental2.svg.SVGLineElement;

public class LineElement extends BaseElement<SVGLineElement, LineElement> {
    public static LineElement of(SVGLineElement e){
        return new LineElement(e);
    }

    public LineElement(SVGLineElement element) {
        super(element);
    }
}
