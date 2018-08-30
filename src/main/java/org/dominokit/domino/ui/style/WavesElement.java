package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

public class WavesElement<E extends HTMLElement, T extends IsElement<E>> extends DominoElement<E,T> implements HasWaveEffect<T> {

    private WavesSupport<E> wavesSupport;

    @Override
    public void init(T element) {
        super.init(element);
        wavesSupport = WavesSupport.addFor(element.asElement());
    }

    @Override
    public T initWaves() {
        wavesSupport.initWaves();
        return element;
    }

    @Override
    public T setWaveColor(WaveColor waveColor) {
        wavesSupport.setWavesColor(waveColor);
        return element;
    }

    @Override
    public T applyWaveStyle(WaveStyle waveStyle) {
        wavesSupport.applyWaveStyle(waveStyle);
        return element;
    }

    @Override
    public T removeWaves() {
        wavesSupport.removeWaves();
        return element;
    }
}
