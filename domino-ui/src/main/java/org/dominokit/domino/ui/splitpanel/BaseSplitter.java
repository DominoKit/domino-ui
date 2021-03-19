package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.elemento.Elements.div;

abstract class BaseSplitter<T extends BaseSplitter<?>> extends BaseDominoElement<HTMLDivElement, T> {

    private static final int LEFT_BUTTON = 1;

    protected DominoElement<HTMLDivElement> element = DominoElement.of(div().css(SplitStyles.SPLITTER));
    private final DominoElement<HTMLDivElement> handleElement = DominoElement.of(div().css(SplitStyles.SPLIT_HANDLE));

    private double fullSize = 0;
    private double initialStartPosition = 0;
    private double firstSize = 0;
    private double secondSize = 0;

    private ColorScheme colorScheme = ColorScheme.INDIGO;

    BaseSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel) {
        element.appendChild(handleElement);


        EventListener resizeListener = evt -> {
            MouseEvent mouseEvent = Js.uncheckedCast(evt);

            if (LEFT_BUTTON == mouseEvent.buttons) {
                double currentPosition = mousePosition(mouseEvent);
                resize(first, second, currentPosition, mainPanel);
            }
        };

        EventListener touchResizeListener = evt -> {
            evt.preventDefault();
            evt.stopPropagation();
            TouchEvent touchEvent = Js.uncheckedCast(evt);
            double currentPosition = touchPosition(touchEvent);
            resize(first, second, currentPosition, mainPanel);
        };

        element.addEventListener(EventType.mousedown.getName(), evt -> {
            MouseEvent mouseEvent = Js.uncheckedCast(evt);
            initialStartPosition = mousePosition(mouseEvent);
            startResize(first, second, mainPanel);
            document.body.addEventListener(EventType.mousemove.getName(), resizeListener);
        });

        element.addEventListener(EventType.touchstart.getName(), evt -> {
            evt.preventDefault();
            evt.stopPropagation();
            TouchEvent touchEvent = Js.uncheckedCast(evt);
            initialStartPosition = touchPosition(touchEvent);
            startResize(first, second, mainPanel);
            document.body.addEventListener(EventType.touchmove.getName(), touchResizeListener);

        });

        element.addEventListener(EventType.mouseup.getName(), evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
        element.addEventListener(EventType.touchend.getName(), evt -> document.body.removeEventListener(EventType.touchmove.getName(), touchResizeListener));

        document.body.addEventListener(EventType.mouseup.getName(), evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
        document.body.addEventListener(EventType.touchend.getName(), evt -> document.body.removeEventListener(EventType.touchmove.getName(), touchResizeListener));
    }

    private void resize(SplitPanel first, SplitPanel second, double currentPosition, HasSize mainPanel) {
        double diff = currentPosition - initialStartPosition;

        double firstSizeDiff = first.isFirst() ? this.firstSize + diff + (double) mainPanel.getSplitterSize() / 2 : this.firstSize + diff + mainPanel.getSplitterSize();
        double secondSizeDiff = second.isLast() ? this.secondSize - diff + (double) mainPanel.getSplitterSize() / 2 : this.secondSize - diff + mainPanel.getSplitterSize();

        double firstPercent = (firstSizeDiff / fullSize * 100);
        double secondPercent = (secondSizeDiff / fullSize * 100);

        if (withinPanelLimits(first, firstSize, firstPercent) && withinPanelLimits(second, secondSize, secondPercent)) {
            setNewSizes(first, second, firstPercent, secondPercent, mainPanel);
            first.onResize(firstSize, firstPercent);
            second.onResize(secondSize, secondPercent);
        }
    }

    private void startResize(SplitPanel first, SplitPanel second, HasSize mainPanel) {
        firstSize = getPanelSize(first);
        secondSize = getPanelSize(second);
        fullSize = getFullSize(mainPanel);
    }

    private double getFullSize(HasSize mainPanel) {
        return mainPanel.getSize();
    }

    protected abstract double getPanelSize(SplitPanel panel);

    protected abstract void setNewSizes(SplitPanel first, SplitPanel second, double firstPercent, double secondPercent, HasSize mainPanel);

    protected abstract double mousePosition(MouseEvent event);

    protected abstract double touchPosition(TouchEvent event);

    private boolean withinPanelLimits(SplitPanel panel, double topSize, double topPercent) {
        return withinPanelSize(panel, topSize) && withinPanelPercent(panel, topPercent);
    }

    private boolean withinPanelSize(SplitPanel panel, double newSize) {
        return newSize > panel.getMinSize() && (((panel.getMaxSize() > -1) && newSize < panel.getMaxSize()) || panel.getMaxSize() < 0);
    }

    private boolean withinPanelPercent(SplitPanel panel, double percent) {
        return percent > panel.getMinPercent() && (((panel.getMaxPercent() > -1) && percent < panel.getMaxPercent()) || panel.getMaxPercent() < 0);
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    public T setColorScheme(ColorScheme colorScheme) {
        element.style()
                .remove(this.colorScheme.lighten_4().getBackground())
                .add(colorScheme.lighten_4().getBackground());
        handleElement.style()
                .remove(this.colorScheme.color().getBackground())
                .add(colorScheme.color().getBackground());

        this.colorScheme = colorScheme;
        return (T) this;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public double getSize() {
        return element.getBoundingClientRect().height;
    }

    protected abstract void setSize(int size);
}
