package com.progressoft.brix.domino.ui.style;

public interface HasWaveEffect<T> {
    T initWaves();
    T initWaves(WaveColor waveColor);
    T applyWaveStyle(WaveStyle type);
}
