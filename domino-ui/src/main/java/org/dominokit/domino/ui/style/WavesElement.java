package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

/**
 * An abstract element that provides waves support
 *
 * @param <E> the type of the root element
 * @param <T> the type of the waves element
 */
public abstract class WavesElement<E extends HTMLElement, T extends IsElement<E>> extends BaseDominoElement<E, T> implements HasWaveEffect<T> {

    protected WavesSupport wavesSupport;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(T element) {
        super.init(element);
        wavesSupport = WavesSupport.addFor(this.getWavesElement());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T initWaves() {
        wavesSupport.initWaves();
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T setWaveColor(WaveColor waveColor) {
        wavesSupport.setWaveColor(waveColor);
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T applyWaveStyle(WaveStyle waveStyle) {
        wavesSupport.applyWaveStyle(waveStyle);
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeWaves() {
        wavesSupport.removeWaves();
        return element;
    }
}
