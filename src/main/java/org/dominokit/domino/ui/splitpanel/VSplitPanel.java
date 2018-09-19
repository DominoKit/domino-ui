package org.dominokit.domino.ui.splitpanel;

public class VSplitPanel extends BaseSplitPanel<VSplitPanel, VSplitter> implements HasSize {

    public VSplitPanel() {
        super("vertical");
        init(this);
    }

    @Override
    protected VSplitter createSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel) {
        return VSplitter.create(first, second, this);
    }

    @Override
    protected double getPanelSize(SplitPanel panel) {
        return panel.getBoundingClientRect().height;
    }

    @Override
    protected void setPanelSize(SplitPanel panel, String size) {
        panel.style().setHeight(size);
    }

    public static VSplitPanel create() {
        return new VSplitPanel();
    }

    @Override
    public double getSize() {
        return getBoundingClientRect().height;
    }
}
