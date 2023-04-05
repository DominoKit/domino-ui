/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.spin;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SpinConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeListeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.nonNull;

/**
 * Abstract implementation for spin
 *
 * @param <T> the type of the object inside the spin
 * @param <S> the type of the spin
 */
abstract class SpinSelect<T, S extends SpinSelect<T, S>>
        extends BaseDominoElement<HTMLDivElement, S>
        implements SpinStyles,
        HasChangeListeners<S, T>,
        HasComponentConfig<SpinConfig> {

    private final Icon<?> backIcon;
    private final Icon<?> forwardIcon;

    protected DivElement root;
    private final AnchorElement prevAnchor;
    private final AnchorElement nextAnchor;
    protected DivElement contentPanel;
    protected List<SpinItem<T>> items = new ArrayList<>();
    private SpinItem<T> activeItem;
    private T oldValue;
    private boolean changeListenersPaused;
    private final Set<ChangeListener<? super T>> changeListeners = new HashSet<>();
    private SwapCssClass exitCss = SwapCssClass.of();
    private EventListener clearAnimation;

    SpinSelect(Icon<?> backIcon, Icon<?> forwardIcon) {
        this.backIcon = backIcon;
        this.forwardIcon = forwardIcon;
        root = div()
                .addCss(dui_spin)
                .appendChild(prevAnchor = a().addCss(dui_spin_prev, dui_disabled)
                        .appendChild(backIcon.addCss(dui_clickable)
                                .addClickListener(evt -> moveBack())
                        )
                )
                .appendChild(contentPanel = div().addCss(dui_spin_content))
                .appendChild(nextAnchor = a().addCss(dui_spin_next)
                        .appendChild(forwardIcon.addCss(dui_clickable)
                                .addClickListener(evt -> moveForward())
                        )
                );

        init((S) this);
        addCss(()->"dui-spin-exit-right");
        clearAnimation = evt -> {
                removeCss("dui-spin-animate");
        };
    }

    /**
     * Move to the next item
     *
     * @return same instance
     */
    public S moveForward() {
        moveToIndex(items.indexOf(this.activeItem) + 1);
        return (S) this;
    }

    /**
     * Move back to the previous item
     *
     * @return same instance
     */
    public S moveBack() {
        moveToIndex(items.indexOf(this.activeItem) - 1);
        return (S) this;
    }

    /**
     * Move to item at a specific index
     *
     * @param targetIndex the index of the item
     * @return same instance
     */
    public S moveToIndex(int targetIndex) {
        this.oldValue = getValue();
        if (targetIndex < items.size() && targetIndex >= 0) {
            int activeIndex = items.indexOf(activeItem);
            if (targetIndex != activeIndex) {
                SpinItem<T> next = items.get(targetIndex);
                if(items.indexOf(next)> indexOf(this.activeItem)){
                    addCss(exitCss.replaceWith(dui_spin_exit_forward));
                }else {
                    addCss(exitCss.replaceWith(dui_spin_exit_backward));
                }
                this.activeItem.addCss(spinExiting);
                next.addCss(spinActivating);
                DomGlobal.setTimeout(p0 -> {
                    addCss(dui_spin_animate);
                    this.activeItem.removeCss(dui_active);
                    next.addCss(dui_active);
                    this.activeItem = next;
                    updateArrowsVisibility();
                    triggerChangeListeners(oldValue, getValue());
                }, 0);
            }
        }
        return (S) this;
    }

    /**
     * Move to a specific item
     *
     * @param item the {@link SpinItem}
     * @return same instance
     */
    public S moveToItem(SpinItem<T> item) {
        if (items.contains(item)) {
            return moveToIndex(items.indexOf(item));
        }
        return (S) this;
    }

    private void updateArrowsVisibility() {
        if (items.indexOf(this.activeItem) == items.size() - 1) {
            nextAnchor.addCss(dui_disabled);
            nextAnchor.disable();
        } else {
            nextAnchor.removeCss(dui_disabled);
            nextAnchor.enable();
        }

        if (items.indexOf(this.activeItem) < 1) {
            prevAnchor.addCss(dui_disabled);
            prevAnchor.disable();
        } else {
            prevAnchor.removeCss(dui_disabled);
            prevAnchor.enable();
        }
    }

    @Override
    public S pauseChangeListeners() {
        this.changeListenersPaused = true;
        return (S) this;
    }

    @Override
    public S resumeChangeListeners() {
        this.changeListenersPaused = false;
        return (S) this;
    }

    @Override
    public S togglePauseChangeListeners(boolean toggle) {
        this.changeListenersPaused = toggle;
        return (S) this;
    }

    @Override
    public Set<ChangeListener<? super T>> getChangeListeners() {
        return this.changeListeners;
    }

    @Override
    public boolean isChangeListenersPaused() {
        return this.changeListenersPaused;
    }

    @Override
    public S triggerChangeListeners(T oldValue, T newValue) {
        if(!isChangeListenersPaused()){
            changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, Optional.ofNullable(getActiveItem())
                    .map(SpinItem::getValue).orElse(null)));
        }
        return (S) this;
    }

    /**
     * Adds a new item
     *
     * @param spinItem A {@link SpinItem} to add
     * @return same instance
     */
    public S appendChild(SpinItem<T> spinItem) {
        if(nonNull(spinItem)) {
            if (items.isEmpty()) {
                this.activeItem = spinItem;
                this.activeItem.addCss(dui_active);
            }
            items.add(spinItem);
            spinItem.addEventListener("transitionend", clearAnimation);
            contentPanel.appendChild(spinItem);
            updateArrowsVisibility();
        }
        return (S) this;
    }

    /**
     * @return the current active item
     */
    public SpinItem<T> getActiveItem() {
        return activeItem;
    }

    /**
     * @return All the items
     */
    public List<SpinItem<T>> getItems() {
        return items;
    }

    /**
     * @param item the {@link SpinItem}
     * @return the index of the item inside the spin
     */
    public int indexOf(SpinItem<T> item) {
        if (items.contains(item)) {
            return items.indexOf(item);
        } else {
            return -1;
        }
    }

    /**
     * @return the total number of items inside the spin
     */
    public int itemsCount() {
        return items.size();
    }

    /**
     * @param item the {@link SpinItem}
     * @return true if the item is the last item, false otherwise
     */
    public boolean isLastItem(SpinItem<T> item) {
        return items.contains(item) && indexOf(item) == (itemsCount() - 1);
    }

    /**
     * @param item the {@link SpinItem}
     * @return true if the item is the first item, false otherwise
     */
    public boolean isFirstItem(SpinItem<T> item) {
        return items.contains(item) && indexOf(item) == 0;
    }

    /**
     * Move to the first item
     *
     * @return same instance
     */
    public S gotoFirst() {
        moveToIndex(0);
        return (S) this;
    }

    /**
     * Move to the last item
     *
     * @return same instance
     */
    public S gotoLast() {
        moveToIndex(itemsCount() - 1);
        return (S) this;
    }

    /**
     * @return the previous element
     */
    public AnchorElement getPrevAnchor() {
        return prevAnchor;
    }

    /**
     * @return the next element
     */
    public AnchorElement getNextAnchor() {
        return nextAnchor;
    }

    /**
     * @return the content panel
     */
    public DivElement getContentPanel() {
        return contentPanel;
    }

    public T getValue(){
        return Optional.ofNullable(activeItem).map(SpinItem::getValue).orElse(null);
    }

    public S withBackAnchor(ChildHandler<S, AnchorElement> handler){
        handler.apply((S) this, prevAnchor);
        return (S) this;
    }

    public S withForwardAnchor(ChildHandler<S, AnchorElement> handler){
        handler.apply((S) this, nextAnchor);
        return (S) this;
    }

    public S withBackIcon(ChildHandler<S, Icon<?>> handler){
        handler.apply((S) this, backIcon);
        return (S) this;
    }

    public S withForwardIcon(ChildHandler<S, Icon<?>> handler){
        handler.apply((S) this, forwardIcon);
        return (S) this;
    }

    public S withContentContainer(ChildHandler<S, DivElement> handler){
        handler.apply((S) this, contentPanel);
        return (S) this;
    }

    protected abstract void fixElementsWidth();

    protected abstract void setTransformProperty(double offset);

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
