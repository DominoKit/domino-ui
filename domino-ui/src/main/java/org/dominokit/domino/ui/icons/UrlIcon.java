package org.dominokit.domino.ui.icons;

import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.img;

public class UrlIcon extends BaseIcon<UrlIcon> {

    private final String url;

    private UrlIcon(String url, String name) {
        this.url = url;
        this.name = name;
        this.icon = DominoElement.of(img(url).element());
        init(this);
    }

    public static UrlIcon create(String url, String name) {
        return new UrlIcon(url, name);
    }

    @Override
    public UrlIcon copy() {
        return new UrlIcon(url, name);
    }

    @Override
    protected UrlIcon doToggle() {
        if (nonNull(toggleName)) {
            if (this.style.contains(originalName)) {
                this.style.remove(originalName);
                this.style.add(toggleName);
            } else {
                this.style.add(originalName);
                this.style.remove(toggleName);
            }
        }
        return this;
    }

    @Override
    public UrlIcon changeTo(BaseIcon icon) {
        style.remove(getName());
        style.add(icon.getName());
        return null;
    }
}