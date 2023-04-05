package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLProgressElement;

public class ProgressElement extends BaseElement<HTMLProgressElement, ProgressElement> {
    public static ProgressElement of(HTMLProgressElement e) {
        return new ProgressElement(e);
    }

    public ProgressElement(HTMLProgressElement element) {
        super(element);
    }
}