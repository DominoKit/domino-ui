package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.i;

public class Icon extends BaseIcon<Icon> {

    private Icon(HTMLElement icon) {
        this.icon = DominoElement.of(icon);
        init(this);
    }

    public static Icon create(String icon) {
        Icon iconElement = new Icon(i().css(IconsStyles.MATERIAL_ICONS).textContent(icon).asElement());
        iconElement.name = icon;
        return iconElement;
    }

    @Override
    public Icon copy() {
        return Icon.create(this.getName())
                .setColor(this.color);
    }

    @Override
    protected Icon doToggle() {
        if (nonNull(toggleName)) {
            if (this.getTextContent().equals(originalName)) {
                this.setTextContent(toggleName);
            } else {
                this.setTextContent(originalName);
            }
        }

        return this;
    }

    public Icon small(){
        style.add(IconsStyles.SMALL_ICON);
        return this;
    }

    @Override
    public Icon changeTo(BaseIcon icon) {
        asElement().textContent = icon.getName();
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return icon.asElement();
    }

}
