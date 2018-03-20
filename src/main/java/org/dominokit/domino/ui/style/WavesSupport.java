package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;

import static java.util.Objects.isNull;

public class WavesSupport<E extends HTMLElement> {

    private static final String WAVES_EFFECT = "waves-effect";
    private E element;

    private String waveEffect;
    private String waveColor;

    private WavesSupport(E element) {
        this.element = element;
    }

    public static <E extends HTMLElement> WavesSupport<E> addFor(E element){
        WavesSupport<E> wavesSupport=new WavesSupport<>(element);
        wavesSupport.initWaves();
        return wavesSupport;
    }

    public WavesSupport<E> initWaves() {
        if (isNull(waveEffect))
            element.classList.add(WAVES_EFFECT);
        this.waveEffect = WAVES_EFFECT;
        Waves.init();
        return this;
    }

    public WavesSupport<E> initWaves(WaveColor waveColor) {
        if (isNull(waveEffect))
            initWaves();
        if (isNull(this.waveColor))
            element.classList.add(waveColor.getStyle());
        else {
            element.classList.remove(this.waveColor);
            element.classList.add(waveColor.getStyle());
        }
        this.waveColor = waveColor.getStyle();
        Waves.init();
        return this;
    }

    public WavesSupport<E> applyWaveStyle(WaveStyle waveStyle) {
        if (isNull(waveEffect))
            initWaves();
        if(!element.classList.contains(waveStyle.getStyle()))
            element.classList.add(waveStyle.getStyle());

        Waves.init();
        return this;
    }

    public E element(){
        return element;
    }
}
