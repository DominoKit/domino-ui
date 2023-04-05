package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTrackElement;

public class TrackElement extends BaseElement<HTMLTrackElement, TrackElement> {
    public static TrackElement of(HTMLTrackElement e) {
        return new TrackElement(e);
    }

    public TrackElement(HTMLTrackElement element) {
        super(element);
    }
}