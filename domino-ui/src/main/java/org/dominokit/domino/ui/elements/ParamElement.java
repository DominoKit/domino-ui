package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLParamElement;

public class ParamElement extends BaseElement<HTMLParamElement, ParamElement> {
    public static ParamElement of(HTMLParamElement e) {
        return new ParamElement(e);
    }

    public ParamElement(HTMLParamElement element) {
        super(element);
    }
}