package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.HasWavesElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class WavesSupport {

    private static final String WAVES_EFFECT = "waves-effect";
    private HTMLElement element;

    private String waveColor;
    private Waves wavesElement;

    private WavesSupport(HasWavesElement targetElement) {
        this.element = targetElement.getWavesElement();
        wavesElement = Waves.create(this.element);
    }

    private WavesSupport(HTMLElement targetElement) {
        this.element = targetElement;
        wavesElement = Waves.create(this.element);
    }

    public static WavesSupport addFor(HasWavesElement element) {
        return new WavesSupport(element).initWaves();
    }

    public static WavesSupport addFor(HTMLElement element) {
        return new WavesSupport(element).initWaves();
    }

    public WavesSupport initWaves() {
        if (!hasWavesEffect())
            element.classList.add(WAVES_EFFECT);

        wavesElement.initWaves();
        return this;
    }

    private boolean hasWavesEffect() {
        return element.classList.contains(WAVES_EFFECT);
    }

    public WavesSupport setWavesColor(WaveColor waveColor) {
        if (!hasWavesEffect())
            initWaves();
        if (isNull(this.waveColor))
            element.classList.add(waveColor.getStyle());
        else {
            element.classList.remove(this.waveColor);
            element.classList.add(waveColor.getStyle());
        }
        this.waveColor = waveColor.getStyle();
        return this;
    }

    public WavesSupport applyWaveStyle(WaveStyle waveStyle) {
        if (!hasWavesEffect())
            initWaves();
        if (!element.classList.contains(waveStyle.getStyle()))
            element.classList.add(waveStyle.getStyle());
        return this;
    }

    public WavesSupport removeWaves() {
        if (hasWavesEffect())
            element.classList.remove(WAVES_EFFECT);
        if (nonNull(waveColor))
            element.classList.remove(waveColor);
        removeWaveStyles();
        wavesElement.removeWaves();
        return this;
    }

    private void removeWaveStyles() {
        for (int i = 0; i < element.classList.length; ++i) {
            String style = element.classList.item(i);
            if (style.contains("waves-"))
                element.classList.remove(style);
        }
    }

}
