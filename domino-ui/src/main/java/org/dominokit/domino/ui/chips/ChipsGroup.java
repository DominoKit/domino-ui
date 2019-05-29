package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Switchable;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ChipsGroup extends BaseDominoElement<HTMLDivElement, ChipsGroup> implements Switchable<ChipsGroup>, HasSelectionHandler<ChipsGroup, Chip> {

    private HTMLDivElement element = div().asElement();
    private List<Chip> chips = new ArrayList<>();
    private Chip selectedChip;
    private List<SelectionHandler<Chip>> selectionHandlers = new ArrayList<>();

    public ChipsGroup() {
        init(this);
    }

    public static ChipsGroup create() {
        return new ChipsGroup();
    }

    /**
     * @deprecated use {@link #appendChild(Chip)}
     */
    @Deprecated
    public ChipsGroup addChip(Chip chip) {
        return appendChild(chip);
    }


    public ChipsGroup appendChild(Chip chip) {
        chip.setSelectable(true);
        chip.addSelectionHandler(value -> {
            for (Chip c : chips) {
                if (!c.equals(chip)) {
                    c.deselect();
                }
            }
            this.selectedChip = chip;
            selectionHandlers.forEach(handler -> handler.onSelection(chip));
        });
        chips.add(chip);
        element.appendChild(chip.asElement());
        return this;
    }

    @Override
    public ChipsGroup enable() {
        chips.forEach(Chip::enable);
        return this;
    }

    @Override
    public ChipsGroup disable() {
        chips.forEach(Chip::disable);
        return this;
    }

    @Override
    public boolean isEnabled() {
        return chips.stream().allMatch(Chip::isEnabled);
    }

    public Chip getSelectedChip() {
        return selectedChip;
    }

    @Override
    public ChipsGroup addSelectionHandler(SelectionHandler<Chip> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public ChipsGroup removeSelectionHandler(SelectionHandler<Chip> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public ChipsGroup setColorScheme(ColorScheme colorScheme) {
        chips.forEach(chip -> chip.setColorScheme(colorScheme));
        return this;
    }

    public ChipsGroup selectAt(int index) {
        if (index >= 0 && index < chips.size()) {
            chips.get(index).select();
        }
        return this;
    }

    public List<Chip> getChips() {
        return chips;
    }


}
