package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Switchable;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ChipsGroup extends DominoElement<HTMLDivElement, ChipsGroup> implements IsElement<HTMLDivElement>, Switchable<ChipsGroup>, HasSelectionHandler<ChipsGroup> {

    private HTMLDivElement element = div().asElement();
    private List<Chip> chips = new ArrayList<>();
    private Chip selectedChip;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();

    public ChipsGroup() {
        init(this);
    }

    public static ChipsGroup create() {
        return new ChipsGroup();
    }

    /**
     * @deprecated use {@link #appendChild(Chip)}
     * @param chip
     * @return
     */
    @Deprecated
    public ChipsGroup addChip(Chip chip) {
        return appendChild(chip);
    }


    public ChipsGroup appendChild(Chip chip) {
        chip.setSelectable(true);
        chip.addSelectionHandler(() -> {
            for (Chip c : chips) {
                if (!c.equals(chip)) {
                    c.deselect();
                }
            }
            this.selectedChip = chip;
            selectionHandlers.forEach(SelectionHandler::onSelection);
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
    public ChipsGroup addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
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
