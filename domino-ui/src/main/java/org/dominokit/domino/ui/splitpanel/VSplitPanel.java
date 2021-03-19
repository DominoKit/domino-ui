package org.dominokit.domino.ui.splitpanel;

/**
 * A vertical split panel implementation
 *
 * <p>For example: </p>
 * <pre>
 *     VSplitPanel.create()
 *                     .setColorScheme(ColorScheme.TEAL)
 *                     .appendChild(
 *                         SplitPanel.create()
 *                             .appendChild(
 *                                 div().css("demo-split-div", Color.GREEN_LIGHTEN_5.getBackground())))
 *                     .appendChild(
 *                         SplitPanel.create()
 *                             .appendChild(
 *                                 div().css("demo-split-div", Color.GREEN_LIGHTEN_4.getBackground())))
 *                     .setHeight("400px")
 * </pre>
 *
 * @see BaseSplitPanel
 * @see HasSize
 */
public class VSplitPanel extends BaseSplitPanel<VSplitPanel, VSplitter> implements HasSize {

    public VSplitPanel() {
        super(SplitStyles.VERTICAL);
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

    /**
     * @return new instance
     */
    public static VSplitPanel create() {
        return new VSplitPanel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getSize() {
        return getBoundingClientRect().height;
    }
}
