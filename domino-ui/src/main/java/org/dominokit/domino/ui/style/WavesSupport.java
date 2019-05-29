package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasWavesElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class WavesSupport {

    private static final String WAVES_EFFECT = "waves-effect";
    private DominoElement<HTMLElement> element;

    private String waveColor;
    private Waves wavesElement;

    private WavesSupport(HasWavesElement targetElement) {
        this(targetElement.getWavesElement());
    }

    private WavesSupport(HTMLElement targetElement) {
        this.element = DominoElement.of(targetElement);
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
            element.style().add(WAVES_EFFECT);

        wavesElement.initWaves();
        return this;
    }

    private boolean hasWavesEffect() {
        return element.style().contains(WAVES_EFFECT);
    }

    public WavesSupport setWavesColor(WaveColor waveColor) {
        if (!hasWavesEffect())
            initWaves();
        if (isNull(this.waveColor))
            element.style().add(waveColor.getStyle());
        else {
            element.style().remove(this.waveColor);
            element.style().add(waveColor.getStyle());
        }
        this.waveColor = waveColor.getStyle();
        return this;
    }

    public WavesSupport applyWaveStyle(WaveStyle waveStyle) {
        if (!hasWavesEffect())
            initWaves();
        if (!element.style().contains(waveStyle.getStyle()))
            element.style().add(waveStyle.getStyle());
        return this;
    }

    public WavesSupport removeWaves() {
        if (hasWavesEffect())
            element.style().remove(WAVES_EFFECT);
        if (nonNull(waveColor))
            element.style().remove(waveColor);
        removeWaveStyles();
        wavesElement.removeWaves();
        return this;
    }

    private void removeWaveStyles() {
        for (int i = 0; i < element.style().length(); ++i) {
            String style = element.style().item(i);
            if (style.contains("waves-"))
                element.style().remove(style);
        }
    }

}
