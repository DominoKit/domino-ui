package org.dominokit.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.div;

public class ProgressBar extends BaseDominoElement<HTMLDivElement, ProgressBar> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(ProgressStyles.progress_bar).attr("role", "progressbar"));
    private double maxValue;
    private double value = 0;
    private String textExpression;
    private boolean showText = false;
    private String style = ProgressStyles.progress_bar_success;

    public ProgressBar(int maxValue) {
        this(maxValue, "{percent}%");
    }

    public ProgressBar(int maxValue, String textExpression) {
        this.maxValue = maxValue;
        this.textExpression = textExpression;
        this.setValue(0);
        init(this);
    }

    public static ProgressBar create(int maxValue) {
        return new ProgressBar(maxValue);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public double getValue() {
        return value;
    }

    public ProgressBar showText() {
        this.showText = true;
        updateText();
        return this;
    }

    public ProgressBar setValue(double value) {
        if (value >= 0 && value <= maxValue) {
            this.value = value;
            int percent = new Double((value / maxValue) * 100).intValue();
            element.style().setWidth(percent + "%");
            updateText();
        }
        return this;
    }

    private void updateText() {
        if (showText) {
            int percent = new Double((value / maxValue) * 100).intValue();
            element.setTextContent(textExpression.replace("{percent}", percent + "")
                    .replace("{value}", value + "")
                    .replace("{maxValue}", maxValue + ""));
        }
    }

    public ProgressBar animate() {
        striped();
        element.style().add(ProgressStyles.active);
        return this;
    }

    public ProgressBar striped() {
        element.style().remove(ProgressStyles.progress_bar_striped);
        element.style().add(ProgressStyles.progress_bar_striped);
        return this;
    }

    public ProgressBar success() {
        return setStyle(ProgressStyles.progress_bar_success);
    }

    public ProgressBar warning() {
        return setStyle(ProgressStyles.progress_bar_warning);
    }

    public ProgressBar info() {
        return setStyle(ProgressStyles.progress_bar_info);
    }

    public ProgressBar danger() {
        return setStyle(ProgressStyles.progress_bar_danger);
    }

    private ProgressBar setStyle(String style) {
        element.style().remove(this.style);
        element.style().add(style);
        this.style = style;
        return this;
    }

    public ProgressBar setBackground(Color background) {
        setStyle(background.getBackground());
        return this;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public ProgressBar setMaxValue(double maxValue) {
        this.maxValue = maxValue;
        setValue(this.value);
        return this;
    }
    
    public ProgressBar textExpression(String expression) {
        this.textExpression = expression;
        updateText();
        return this;
    }
}
