package org.dominokit.domino.ui.elements;

import elemental2.svg.SVGElement;

public class SvgElement extends BaseElement<SVGElement, SvgElement> {
    public static SvgElement of(SVGElement e){
        return new SvgElement(e);
    }

    public SvgElement(SVGElement element) {
        super(element);
    }
}
