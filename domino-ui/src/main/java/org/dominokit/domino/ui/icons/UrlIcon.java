package org.dominokit.domino.ui.icons;

import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.img;

/**
 * Url icon implementation
 */
public class UrlIcon extends BaseIcon<UrlIcon> {

    private final String url;

    private UrlIcon(String url, String name) {
        this.url = url;
        this.name = name;
        this.icon = DominoElement.of(img(url).element());
        init(this);
    }

    /**
     * Creates an icon with a specific {@code url} and a name
     *
     * @param url  the url of the icon to load from
     * @param name the name of the icon
     * @return new instance
     */
    public static UrlIcon create(String url, String name) {
        return new UrlIcon(url, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UrlIcon copy() {
        return new UrlIcon(url, name);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public UrlIcon changeTo(BaseIcon<UrlIcon> icon) {
        style.remove(getName());
        style.add(icon.getName());
        return null;
    }
}
