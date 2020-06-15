package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.LinkedList;
import java.util.List;

import static org.jboss.elemento.Elements.div;

abstract class BaseSplitPanel<T extends BaseSplitPanel<T,S>, S extends BaseSplitter> extends BaseDominoElement<HTMLDivElement, T> implements HasSize {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(SplitStyles.split_panel));

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
        for (SplitPanel panel : panels) {
            double panelSize = getPanelSize(panel);
            double sizePercent = (panelSize / mainPanelSize) * 100;
            setPanelSize(panel, Calc.sub(Unit.percent.of(sizePercent), Unit.px.of(panel.isFirst() || panel.isLast() ? splitterSize / 2 : splitterSize)));
        }
    }

    protected abstract double getPanelSize(SplitPanel panel);
    protected abstract void setPanelSize(SplitPanel panel, String size);

    public T appendChild(SplitPanel panel) {
        panels.add(panel);
        if (panels.size() > 1) {
            S splitter = createSplitter(panels.get(panels.size() - 2), panel, this);
            splitter.setColorScheme(colorScheme);
            splitter.setSize(splitterSize);
            splitters.add(splitter);
            element.appendChild(splitter);
            element.appendChild(panel);

            SplitPanel secondLast = panels.get(panels.size() - 1);
            secondLast.setLast(false);
            panel.setLast(true);

        } else {
            panel.setFirst(true);
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
    public int getSplitterSize() {
        return splitterSize;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    @Override
    public double getSize() {
        return getBoundingClientRect().width;
    }
}
