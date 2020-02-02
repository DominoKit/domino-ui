package org.dominokit.domino.ui.splitpanel;

public class HSplitPanel extends BaseSplitPanel<HSplitPanel, HSplitter> implements HasSize {

    public HSplitPanel() {
        super(SplitStyles.horizontal);
        init(this);
    }

    @Override
    protected HSplitter createSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel) {
        return HSplitter.create(first, second, this);
    }

    @Override
    protected double getPanelSize(SplitPanel panel) {
        return panel.getBoundingClientRect().width;
    }

    @Override
    protected void setPanelSize(SplitPanel panel, String size) {
        panel.style().setWidth(size);
    }

    public static HSplitPanel create() {
        return new HSplitPanel();
    }

    @Override
    public double getSize() {
        return getBoundingClientRect().width;
    }
}
