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

public abstract class BaseIcon<T extends BaseIcon<T>> extends BaseDominoElement<HTMLElement, T> {

    protected DominoElement<HTMLElement> icon;
    protected String name;
    protected Color color;
    protected String originalName;
    protected String toggleName;
    protected boolean toggleOnClick = false;

    public String getName() {
        return name;
    }

    public T setColor(Color color) {
        if (isNull(color))
            return (T) this;
        if (nonNull(this.color))
            icon.style().remove(this.color.getStyle());

        icon.style().add(color.getStyle());
        this.color = color;
        return (T) this;
    }

    public abstract T copy();

    public T addClickListener(EventListener listener) {
        this.icon.addEventListener(EventType.click.getName(), listener);
        return (T) this;
    }

    public T setToggleIcon(BaseIcon<?> icon) {
        this.originalName = this.getName();
        this.toggleName = icon.getName();
        addClickListener(evt -> {
            if (toggleOnClick) {
                evt.stopPropagation();
                onToggleIcon(evt);
            }
        });

        return (T) this;
    }

    public T toggleOnClick(boolean toggleOnClick) {
        this.toggleOnClick = toggleOnClick;
        return (T) this;
    }

    public abstract T toggleIcon();

    public T clickable() {
        style.add("clickable-icon");
        withWaves();
        return (T) this;
    }

    public abstract T changeTo(BaseIcon icon);

    @Override
    public HTMLElement asElement() {
        return icon.asElement();
    }

    private void onToggleIcon(Event evt) {
        toggleIcon();
    }
}
