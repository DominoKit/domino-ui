package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.dominokit.domino.ui.chips.ChipStyles.*;

public class Chip extends BaseDominoElement<HTMLDivElement, Chip>
        implements HasSelectionListeners<Chip, Chip, Chip>,
        Selectable<Chip>,
        AcceptDisable<Chip> {

    private DominoElement<HTMLDivElement> root;
    private DominoElement<HTMLElement> textElement;
    private LazyChild<DominoElement<HTMLDivElement>> addon;
    private LazyChild<RemoveButton> removeButton;
    private Set<SelectionListener<? super Chip, ? super Chip>> selectionListeners = new HashSet<>();
    private Set<SelectionListener<? super Chip, ? super Chip>> deselectionListeners = new HashSet<>();
    private boolean selectionListenersPaused = false;
    private boolean selected = false;
    private boolean selectable = true;
    private boolean removable = false;

    public static Chip create(String text) {
        return new Chip(text);
    }

    public Chip(String text) {
        root = DominoElement.div()
                .addCss(dui_chip)
                .setAttribute("tabindex", "0")
                .appendChild(textElement = DominoElement.span().addCss(dui_chip_value).setTextContent(text));
        init(this);

        removeButton = LazyChild.of(RemoveButton.create().addCss(dui_chip_remove) , root)
                .whenInitialized(() -> removeButton.element()
                        .addClickListener(evt -> {
                            evt.stopPropagation();
                            evt.preventDefault();
                            remove();
                        }));

        addon = LazyChild.of(DominoElement.div().addCss(dui_chip_addon), root)
                .whenInitialized(() -> root.addCss(dui_chip_has_addon))
                .onReset(() -> root.removeCss(dui_chip_has_addon));

        KeyboardEvents.listenOnKeyDown(root)
                .onEnter(
                        evt -> {
                            evt.stopPropagation();
                            if (isSelectable()) {
                                toggleSelect();
                            }
                        })
                .onDelete(
                        evt -> {
                            evt.stopPropagation();
                            if (isRemovable()) {
                                remove();
                            }
                        });
        root.addClickListener(
                evt -> {
                    evt.stopPropagation();
                    if (isSelectable()) {
                        toggleSelect();
                    }
                });
    }

    @Override
    public Chip pauseSelectionListeners() {
        this.selectionListenersPaused = true;
        return this;
    }

    @Override
    public Chip resumeSelectionListeners() {
        this.selectionListenersPaused = false;
        return this;
    }

    @Override
    public Chip togglePauseSelectionListeners(boolean toggle) {
        this.selectionListenersPaused = toggle;
        return this;
    }

    @Override
    public Set<SelectionListener<? super Chip, ? super Chip>> getSelectionListeners() {
        return selectionListeners;
    }

    @Override
    public Set<SelectionListener<? super Chip, ? super Chip>> getDeselectionListeners() {
        return deselectionListeners;
    }

    @Override
    public boolean isSelectionListenersPaused() {
        return this.selectionListenersPaused;
    }

    @Override
    public Chip triggerSelectionListeners(Chip source, Chip selection) {
        selectionListeners.forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        return this;
    }

    @Override
    public Chip triggerDeselectionListeners(Chip source, Chip selection) {
        deselectionListeners.forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        return this;
    }

    @Override
    public Chip getSelection() {
        if (isSelected()) {
            return this;
        }
        return null;
    }

    @Override
    public Chip select() {
        return select(isSelectionListenersPaused());
    }

    @Override
    public Chip deselect() {
        return deselect(isSelectionListenersPaused());
    }

    @Override
    public Chip select(boolean silent) {
        if (!isDisabled() && isSelectable()) {
            doSetSelected(true);
            if (!silent) {
                triggerSelectionListeners(this, this);
            }
        }
        return this;
    }

    @Override
    public Chip deselect(boolean silent) {
        if (!isDisabled() && isSelectable()) {
            doSetSelected(false);
            if (!silent) {
                triggerDeselectionListeners(this, this);
            }
        }
        return this;
    }

    public Chip setSelected(boolean selected) {
        return setSelected(selected, isSelectionListenersPaused());
    }

    @Override
    public Chip setSelected(boolean selected, boolean silent) {
        if (selected) {
            select(silent);
        } else {
            deselect(silent);
        }
        return this;
    }

    private void doSetSelected(boolean selected) {
        addCss(BooleanCssClass.of(dui_chip_selected, selected));
        this.selected = selected;
    }

    @Override
    public boolean isSelected() {
        return selected && isSelectable();
    }

    @Override
    public boolean isSelectable() {
        return selectable;
    }

    @Override
    public Chip setSelectable(boolean selectable) {
        this.selectable = selectable;
        return this;
    }

    public boolean isRemovable() {
        return removable;
    }

    public Chip setRemovable(boolean removable) {
        this.removable = removable;
        if (isRemovable()) {
            removeButton.get();
        } else {
            removeButton.remove();
        }
        return this;
    }

    public Chip setText(String text) {
        textElement.setTextContent(text);
        return this;
    }

    public Chip withTextElement(ChildHandler<Chip, DominoElement<HTMLElement>> handler) {
        handler.apply(this, textElement);
        return this;
    }

    public DominoElement<HTMLElement> getTextElement() {
        return textElement;
    }

    public Chip setAddOn(IsElement<?> addOn) {
        this.addon.get()
                .clearElement()
                .appendChild(addOn);
        return this;
    }

    public Chip setLetters(String text) {
        return setAddOn(DominoElement.span().textContent(text));
    }

    public Chip setImage(HTMLImageElement img) {
        return setAddOn(DominoElement.of(img));
    }

    public Chip withAddon(ChildHandler<Chip, DominoElement<HTMLDivElement>> handler) {
        handler.apply(this, addon.get());
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
