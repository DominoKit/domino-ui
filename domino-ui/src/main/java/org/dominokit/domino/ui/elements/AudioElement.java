package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLAudioElement;

public class AudioElement extends BaseElement<HTMLAudioElement, AudioElement> {
    public static AudioElement of(HTMLAudioElement e) {
        return new AudioElement(e);
    }

    public AudioElement(HTMLAudioElement element) {
        super(element);
    }
}