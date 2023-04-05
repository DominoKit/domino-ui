package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLMapElement;

public class MapElement extends BaseElement<HTMLMapElement, MapElement> {
    public static MapElement of(HTMLMapElement e) {
        return new MapElement(e);
    }

    public MapElement(HTMLMapElement element) {
        super(element);
    }
}