package com.progressoft.brix.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public class WavesElement<T extends IsElement, E extends HTMLElement> implements HasWaveEffect<T> {

    private T type;
    private WavesSupport<E> wavesSupport;

    protected void init(T type, E element) {
        this.type=type;
        wavesSupport=WavesSupport.addFor(element);
    }

    @Override
    public T initWaves() {
        wavesSupport.initWaves();
        return type;
    }

    @Override
    public T initWaves(WaveColor waveColor) {
        wavesSupport.initWaves(waveColor);
        return type;
    }

    @Override
    public T applyWaveStyle(WaveStyle waveStyle) {
        wavesSupport.applyWaveStyle(waveStyle);
        return type;
    }
}
