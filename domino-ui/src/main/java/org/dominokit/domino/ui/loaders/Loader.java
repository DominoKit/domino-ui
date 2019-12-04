package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Styles;
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

    private LoadingTextPosition loadingTextPosition = LoadingTextPosition.MIDDLE;

    public static Loader create(HTMLElement target, LoaderEffect effect) {
        return new Loader(target, effect);
    }

    public static Loader create(IsElement target, LoaderEffect effect) {
        return new Loader(target.element(), effect);
    }

    private Loader(HTMLElement target, LoaderEffect type) {
        this.target = DominoElement.of(target);
        this.loaderElement = LoaderFactory.make(type);
        this.loaderElement.getContentElement().css(loadingTextPosition.getStyle());
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

    public LoadingTextPosition getLoadingTextPosition() {
        return loadingTextPosition;
    }

    public Loader setLoadingTextPosition(LoadingTextPosition loadingTextPosition) {
        this.loaderElement.getContentElement().removeCss(this.loadingTextPosition.getStyle());
        this.loadingTextPosition = loadingTextPosition;
        if (LoadingTextPosition.MIDDLE.equals(loadingTextPosition)) {
            this.loaderElement.getContentElement().css(Styles.vertical_center);
        } else {
            this.loaderElement.getContentElement().removeCss(Styles.vertical_center);
        }
        this.loaderElement.getContentElement().css(this.loadingTextPosition.getStyle());
        return this;
    }

    public IsLoader getLoaderElement() {
        return loaderElement;
    }

    public enum LoadingTextPosition {
        TOP(LoaderStyles.LOADING_TOP), MIDDLE(LoaderStyles.LOADING_MIDDLE), BOTTOM(LoaderStyles.LOADING_BOTTOM);

        private String style;

        LoadingTextPosition(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }
}
