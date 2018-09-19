package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;

class VSplitter extends BaseSplitter<VSplitter> {

    VSplitter(SplitPanel top, SplitPanel bottom, HasSize vSplitPanel) {
        super(top, bottom, vSplitPanel);
        init(this);
    }

    static VSplitter create(SplitPanel top, SplitPanel right, HasSize vSplitPanel) {
        return new VSplitter(top, right, vSplitPanel);
    }

    protected void setNewSizes(SplitPanel top, SplitPanel bottom, double topPercent, double bottomPercent) {
        top.style().setHeight(topPercent + "%");
        bottom.style().setHeight(bottomPercent + "%");
    }

    public double mousePosition(MouseEvent event) {
        return event.clientY;
    }

    @Override
    protected double getPanelSize(SplitPanel panel) {
        return panel.getBoundingClientRect().height;
    }

    @Override
    protected double touchPosition(TouchEvent event) {
        return event.touches.getAt(0).clientY;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }


    @Override
    public double getSize() {
        return element.getBoundingClientRect().height;
    }

    public void setSize(int size) {
        setHeight(size + "px");
    }
}
