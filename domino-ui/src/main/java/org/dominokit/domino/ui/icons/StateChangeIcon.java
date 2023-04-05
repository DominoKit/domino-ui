package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.ElementHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;

public abstract class StateChangeIcon<I extends Icon<I>, T extends StateChangeIcon<I, T>> extends Icon<T> {
    protected final I defaultIcon;
    protected String currentState = "default";

    protected final Map<String , I> statesMap = new HashMap<>();
    private Consumer<T> onStateChanged = icon -> {};

    public StateChangeIcon(I defaultIcon) {
        this.defaultIcon = defaultIcon;
        this.icon = elementOf(this.defaultIcon);
        init((T) this);
    }

    public T withState(String state, I icon){
        if(nonNull(state) && !state.isEmpty() && nonNull(icon)){
            statesMap.put(state, icon);
        }
        return (T) this;
    }

    public T removeState(String state){
        statesMap.remove(state);
        return (T) this;
    }

    /**
     * Sets a handler to be called when the icon state is changed
     *
     * @param stateConsumer the {@link Consumer} handler
     * @return same instance
     */
    public T onStateChanged(Consumer<T> stateConsumer) {
        this.onStateChanged = stateConsumer;
        return (T) this;
    }

    public T setState(String state){
        if(statesMap.containsKey(state)){
            this.defaultIcon.addCss(SwapCssClass.of(CompositeCssClass.of(this.defaultIcon))
                    .replaceWith(CompositeCssClass.of(this.statesMap.get(state)))
            );
            this.currentState = state;
            this.onStateChanged.accept((T) this);
        }
        return (T) this;
    }

    @Override
    public T forEachChild(ElementHandler<Icon<?>> handler) {
        handler.handleElement(defaultIcon);
        statesMap.values().forEach(handler::handleElement);
        return (T) this;
    }

    @Override
    protected HTMLElement getStyleTarget() {
        return defaultIcon.element();
    }

    @Override
    public HTMLElement getClickableElement() {
        return defaultIcon.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return defaultIcon.element();
    }
}
