package org.dominokit.domino.ui.style;

/**
 * An interface provides waves effects
 *
 * @param <T> the type of the component implementing this
 */
public interface HasWaveEffect<T> {
    /**
     * Initializes the waves functionality
     *
     * @return same instance
     */
    T initWaves();

    /**
     * Sets the color of the waves
     *
     * @param waveColor the {@link WaveColor}
     * @return same instance
     */
    T setWaveColor(WaveColor waveColor);

    /**
     * Applies the waves style
     *
     * @param type the {@link WaveStyle}
     * @return same instance
     */
    T applyWaveStyle(WaveStyle type);

    /**
     * Removes the waves support
     *
     * @return same instance
     */
    T removeWaves();
}
