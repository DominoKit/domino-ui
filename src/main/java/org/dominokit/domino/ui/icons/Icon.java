package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.i;

public class Icon implements IsElement<HTMLElement> {

    private final HTMLElement icon;
    private String name;
    private Color color;

    private Icon(HTMLElement icon) {
        this.icon = icon;
    }

    public static Icon create(String icon) {
        Icon iconElement = new Icon(i().css("material-icons").textContent(icon).asElement());
        iconElement.name = icon;
        return iconElement;
    }

    public String getName() {
        return name;
    }

    public Icon setColor(Color color) {
        if (isNull(color))
            return this;
        if (nonNull(this.color))
            icon.classList.remove(this.color.getStyle());

        icon.classList.add(color.getStyle());
        this.color = color;
        return this;
    }

    public Icon copy() {
        return Icon.create(this.getName())
                .setColor(this.color);
    }

    @Override
    public HTMLElement asElement() {
        return icon;
    }
}
