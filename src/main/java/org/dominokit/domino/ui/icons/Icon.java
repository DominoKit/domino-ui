package org.dominokit.domino.ui.icons;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.i;

public class Icon extends BaseDominoElement<HTMLElement, Icon> {

    private final DominoElement<HTMLElement> icon;
    private String name;
    private Color color;
    private String originalName;
    private String toggleName;
    private boolean toggleOnClick = false;

    private Icon(HTMLElement icon) {
        this.icon = DominoElement.of(icon);
        init(this);
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
            icon.style().remove(this.color.getStyle());

        icon.style().add(color.getStyle());
        this.color = color;
        return this;
    }

    public Icon copy() {
        return Icon.create(this.getName())
                .setColor(this.color);
    }

    public Icon addClickListener(EventListener listener) {
        this.icon.addEventListener(EventType.click.getName(), listener);
        return this;
    }

    public Icon setToggleIcon(Icon icon) {
        this.originalName = this.getName();
        this.toggleName = icon.getName();
        addClickListener(evt -> {
            if (toggleOnClick) {
                evt.stopPropagation();
                handleEvent(evt);
            }
        });

        return this;
    }

    public Icon toggleOnClick(boolean toggleOnClick) {
        this.toggleOnClick = toggleOnClick;
        return this;
    }

    public void toggleIcon() {
        if (nonNull(toggleName)) {
            if (this.getTextContent().equals(originalName)) {
                this.setTextContent(toggleName);
            } else {
                this.setTextContent(originalName);
            }
        }
    }

    @Override
    public HTMLElement asElement() {
        return icon.asElement();
    }

    private void handleEvent(Event evt) {
        toggleIcon();
    }
}
