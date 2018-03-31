package org.dominokit.domino.ui.style;

public interface HasWaveEffect<T> {
    T initWaves();
    T setWaveColor(WaveColor waveColor);
    T applyWaveStyle(WaveStyle type);
}
