package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasDeselectionHandler;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Switchable;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.elemento.Elements.div;

/**
 * This component provides a group of {@link Chip} which handles the selection behaviour between them.
 * <p>
 * This component will handle the switching between all the chips configured, so that one chip will be select at one time
 *
 * <p>For example: </p>
 * <pre>
 *     ChipsGroup.create()
 *             .appendChild(Chip.create("Extra small"))
 *             .appendChild(Chip.create("Small"))
 *             .appendChild(Chip.create("Medium"))
 *             .appendChild(Chip.create("Large"))
 *             .appendChild(Chip.create("Extra large"))
 *             .setColorScheme(ColorScheme.TEAL)
 *             .addSelectionHandler(value -> Notification.createInfo("Chip [ " + chipsGroup.getSelectedChip().getValue() + " ] is selected").show())
 * </pre>
 *
 * @see BaseDominoElement
 * @see Chip
 * @see HasSelectionHandler
 * @see HasDeselectionHandler
 * @see Switchable
 */
public class ChipsGroup extends BaseDominoElement<HTMLDivElement, ChipsGroup> implements Switchable<ChipsGroup>,
        HasSelectionHandler<ChipsGroup, Chip>, HasDeselectionHandler<ChipsGroup> {

    private final HTMLDivElement element = div().element();
    private final List<Chip> chips = new ArrayList<>();
    private Chip selectedChip;
    private final List<SelectionHandler<Chip>> selectionHandlers = new ArrayList<>();
    private final List<DeselectionHandler> deSelectionHandlers = new ArrayList<>();

    public ChipsGroup() {
        init(this);
    }

    /**
     * @return new instance
     */
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


    /**
     * Adds new {@link Chip}
     * <p>
     * This will set the chip as selectable and adds selection/deselection handler to handle the switching between all the chips.
     *
     * @param chip the new {@link Chip} to add
     * @return same instance
     */
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
        chip.addDeselectionHandler(() -> {
            this.selectedChip = null;
            deSelectionHandlers.forEach(DeselectionHandler::onDeselection);
        });
        chips.add(chip);
        element.appendChild(chip.element());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChipsGroup enable() {
        chips.forEach(Chip::enable);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChipsGroup disable() {
        chips.forEach(Chip::disable);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return chips.stream().allMatch(Chip::isEnabled);
    }

    /**
     * @return The current selected chip
     */
    public Chip getSelectedChip() {
        return selectedChip;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChipsGroup addSelectionHandler(SelectionHandler<Chip> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChipsGroup removeSelectionHandler(SelectionHandler<Chip> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChipsGroup addDeselectionHandler(DeselectionHandler deselectionHandler) {
        deSelectionHandlers.add(deselectionHandler);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }

    /**
     * Sets {@link ColorScheme} for all the chips configured in this group
     *
     * @param colorScheme the new {@link ColorScheme}
     * @return same instance
     */
    public ChipsGroup setColorScheme(ColorScheme colorScheme) {
        chips.forEach(chip -> chip.setColorScheme(colorScheme));
        return this;
    }

    /**
     * Selects a chip at an {@code index}
     *
     * @param index the index of the chip to select
     * @return same instance
     */
    public ChipsGroup selectAt(int index) {
        if (index >= 0 && index < chips.size()) {
            chips.get(index).select();
        }
        return this;
    }

    /**
     * @return All the chips added to this group
     */
    public List<Chip> getChips() {
        return chips;
    }
}
