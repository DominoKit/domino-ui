package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

public abstract class WavesElement<E extends HTMLElement, T extends IsElement<E>> extends BaseDominoElement<E,T> implements HasWaveEffect<T> {

    protected WavesSupport wavesSupport;

    @Override
    public void init(T element) {
        super.init(element);
        wavesSupport = WavesSupport.addFor(this.getWavesElement());
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
