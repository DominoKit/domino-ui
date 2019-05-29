package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.LinkedList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

abstract class BaseSplitPanel<T extends BaseSplitPanel<T,S>, S extends BaseSplitter> extends BaseDominoElement<HTMLDivElement, T> implements HasSize {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("split-panel"));

    private List<SplitPanel> panels = new LinkedList<>();
    private List<S> splitters = new LinkedList<>();
    private ColorScheme colorScheme = ColorScheme.INDIGO;
    private int splitterSize = 10;

    public BaseSplitPanel(String splitterStyle) {
        element.style().add(splitterStyle);
        element.onAttached(mutationRecord -> updatePanelsSize());
    }

    private void updatePanelsSize() {
        double mainPanelSize = getSize();

        double splittersSize = calculateSplittersSize();
        double maxAllowed = mainPanelSize - splittersSize;
        double totalSizePercent = splittersSize / mainPanelSize;

        double totalSize = splittersSize;
        for (SplitPanel panel : panels) {
            double panelSize = getPanelSize(panel);
            int sizePercent = new Double((panelSize / mainPanelSize) * 100).intValue();

            setPanelSize(panel, sizePercent + "%");
            panelSize = getPanelSize(panel);

            if (totalSize + panelSize >= maxAllowed) {
                if (totalSize < maxAllowed) {
                    double newSizehPercent = 100 - totalSizePercent;
                    setPanelSize(panel, "calc(" + newSizehPercent + "% - " + splittersSize + "px)");
                } else {
                    setPanelSize(panel,0 + "%");
                }
                totalSize = maxAllowed;
            } else {
                totalSize += panelSize;
            }
            totalSizePercent += sizePercent;
        }
    }

    protected abstract double getPanelSize(SplitPanel panel);
    protected abstract void setPanelSize(SplitPanel panel, String size);

    private double calculateSplittersSize() {
        double totalSize = 0;
        for (S splitter : splitters) {
            totalSize += splitter.getSize();
        }
        return totalSize;
    }

    public T appendChild(SplitPanel panel) {
        panels.add(panel);
        if (panels.size() > 1) {
            S splitter = createSplitter(panels.get(panels.size() - 2), panel, this);
            splitter.setColorScheme(colorScheme);
            splitter.setSize(splitterSize);
            splitters.add(splitter);
            element.appendChild(splitter);
            element.appendChild(panel);
        } else {
            element.appendChild(panel);
        }
        return (T) this;
    }

    protected abstract S createSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel);

    public ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public T setColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        splitters.forEach(hSplitter -> hSplitter.setColorScheme(colorScheme));
        return (T) this;
    }

    public T setSplitterSize(int size) {
        this.splitterSize = size;
        splitters.forEach(hSplitter -> hSplitter.setSize(size));
        return (T) this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    @Override
    public double getSize() {
        return getBoundingClientRect().width;
    }
}
