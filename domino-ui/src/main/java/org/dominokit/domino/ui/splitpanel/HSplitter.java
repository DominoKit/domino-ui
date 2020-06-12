package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Unit;

class HSplitter extends BaseSplitter<HSplitter> {

    HSplitter(SplitPanel left, SplitPanel right, HasSize hSplitPanel) {
        super(left, right, hSplitPanel);
        init(this);
    }

    static HSplitter create(SplitPanel left, SplitPanel right, HSplitPanel hSplitPanel) {
        return new HSplitter(left, right, hSplitPanel);
    }

    @Override
    protected double getPanelSize(SplitPanel panel) {
        return panel.getBoundingClientRect().width;
    }

    @Override
    protected void setNewSizes(SplitPanel first, SplitPanel second, double firstPercent, double secondPercent, HasSize mainPanel) {
        first.style().setWidth(Calc.sub(Unit.percent.of(firstPercent), Unit.px.of(mainPanel.getSplitterSize() / 2 * (mainPanel.numberOfPanels() - 1))));
        second.style().setWidth(Calc.sub(Unit.percent.of(secondPercent), Unit.px.of(mainPanel.getSplitterSize() / 2 * (mainPanel.numberOfPanels() - 1))));
    }

    @Override
    protected double touchPosition(TouchEvent event) {
        return event.touches.getAt(0).clientX;
    }

    @Override
    protected double mousePosition(MouseEvent event) {
        return event.clientX;
    }

    @Override
    public double getSize() {
        return element.getBoundingClientRect().width;
    }

    public void setSize(int size) {
        setWidth(size + "px");
    }
}
