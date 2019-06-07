package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Loader {

    private boolean started = false;
    private DominoElement<HTMLElement> target;
    private IsLoader loaderElement;
    private String width;
    private String height;
    private boolean removeLoadingText = false;

    public static Loader create(HTMLElement target, LoaderEffect effect) {
        return new Loader(target, effect);
    }

    public static Loader create(IsElement target, LoaderEffect effect) {
        return new Loader(target.asElement(), effect);
    }

    private Loader(HTMLElement target, LoaderEffect type) {
        this.target = DominoElement.of(target);
        this.loaderElement = LoaderFactory.make(type);
    }

    public Loader start() {
        stop();
        if (nonNull(width) && nonNull(height)) {
            loaderElement.setSize(width, height);
        }
        if (removeLoadingText) {
            loaderElement.removeLoadingText();
        }
        target.appendChild(loaderElement.getElement());
        target.style().add("waitMe_container");
        started = true;

        return this;
    }

    public Loader stop() {
        if (started) {
            loaderElement.getElement().remove();
            target.style().remove("waitMe_container");
            started = false;
        }

        return this;
    }

    public Loader setLoadingText(String text) {
        loaderElement.setLoadingText(text);
        return this;
    }

    public Loader setSize(String width, String height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public Loader setRemoveLoadingText(boolean removeLoadingText) {
        this.removeLoadingText = removeLoadingText;
        return this;
    }

    public boolean isStarted() {
        return started;
    }
}
