package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.AutoSwapCssClass;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.ElementHandler;

import java.util.function.Consumer;

public abstract class ToggleIcon<I extends Icon<I>, T extends ToggleIcon<I, T>> extends Icon<T> {
    protected final I primary;
    protected final I toggle;
    protected boolean toggleOnClick = false;

    protected AutoSwapCssClass swapCss;
    private Consumer<T> onToggleHandler = icon -> {};

    public ToggleIcon(I primary, I toggle) {
        this.primary = primary;
        this.toggle = toggle;
        this.icon = elementOf(this.primary);
        swapCss = AutoSwapCssClass.of(CompositeCssClass.of(primary), CompositeCssClass.of(toggle));
        this.primary.addClickListener(evt -> {
            evt.stopPropagation();
            if(toggleOnClick){
                toggle();
            }
        });
        init((T) this);
    }

    /** @return True if the icon is toggled, false otherwise */
    public boolean isToggled() {
        return primary.containsCss(toggle.name.getCssClass());
    }

    /**
     * Sets if the icon should toggle on click
     *
     * @param toggleOnClick true to toggle on click, false otherwise
     * @return same instance
     */
    public T toggleOnClick(boolean toggleOnClick) {
        this.toggleOnClick = toggleOnClick;
        return (T) this;
    }

    /**
     * Sets a handler to be called when the icon is toggled
     *
     * @param toggleConsumer the {@link Consumer} handler
     * @return same instance
     */
    public T onToggle(Consumer<T> toggleConsumer) {
        this.onToggleHandler = toggleConsumer;
        return (T) this;
    }

    public T toggle() {
        primary.addCss(swapCss);
        this.onToggleHandler.accept((T) this);
        return (T) this;
    }

    public T applyToAll(ElementHandler<I> elementHandler){
        elementHandler.handleElement(primary);
        elementHandler.handleElement(toggle);
        return (T) this;
    }

    @Override
    protected HTMLElement getStyleTarget() {
        return primary.element();
    }

    @Override
    public T forEachChild(ElementHandler<Icon<?>> handler) {
        handler.handleElement(primary);
        handler.handleElement(toggle);
        return (T) this;
    }

    @Override
    public HTMLElement getClickableElement() {
        return primary.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return primary.element();
    }
}
