package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class SplitPanel extends BaseDominoElement<HTMLDivElement, SplitPanel> {

    private HTMLDivElement element = div().element();

    private int minSize = 0;
    private int maxSize = -1;

    private double minPercent = 0;
    private double maxPercent = 100;
    private final List<ResizeListener> resizeListeners = new ArrayList<>();

    public SplitPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public static SplitPanel create() {
        return new SplitPanel();
    }

    public int getMinSize() {
        return minSize;
    }

    public SplitPanel setMinSize(int minSize) {
        this.minSize = minSize;
        return this;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public SplitPanel setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public double getMinPercent() {
        return minPercent;
    }

    public SplitPanel setMinPercent(double minPercent) {
        if (minPercent <= 0) {
            this.minPercent = 0;
        } else if (minPercent <= 1) {
            this.minPercent = minPercent * 100;
        } else if (minPercent >= 100) {
            this.minPercent = 100;
        } else {
            this.minPercent = minPercent;
        }
        return this;
    }

    public double getMaxPercent() {
        return maxPercent;
    }

    public SplitPanel setMaxPercent(double maxPercent) {
        if (maxPercent <= 0) {
            this.maxPercent = 0;
        } else if (maxPercent <= 1) {
            this.maxPercent = maxPercent * 100;
        } else if (maxPercent >= 100) {
            this.maxPercent = 100;
        } else {
            this.maxPercent = maxPercent;
        }
        return this;
    }

    public SplitPanel addResizeListener(ResizeListener resizeListener){
        if(nonNull(resizeListener)){
            resizeListeners.add(resizeListener);
        }
        return this;
    }

    public SplitPanel removeResizeListener(ResizeListener resizeListener){
        if(nonNull(resizeListener)){
            resizeListeners.remove(resizeListener);
        }
        return this;
    }


    void onResize(double pixels, double percent) {
        resizeListeners.forEach(resizeListener -> resizeListener.onResize(SplitPanel.this, pixels, percent));
    }

    @FunctionalInterface
    public interface ResizeListener {
        void onResize(SplitPanel panel, double pixels, double percent);
    }

}
