package org.dominokit.domino.ui.progress;

import org.dominokit.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ProgressBar implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().css("progress-bar").attr("role", "progressbar").asElement();
    private double maxValue = 100;
    private double value = 0;
    private String textExpression = "{percent}%";
    private boolean showText = false;
    private String style = "progress-bar-success";

    public ProgressBar(int maxValue) {
        this(maxValue, "{percent}%");
    }

    public ProgressBar(int maxValue, String textExpression) {
        this.maxValue = maxValue;
        this.textExpression = textExpression;
        this.setValue(0);
    }

    public static ProgressBar create(int maxValue) {
        return new ProgressBar(maxValue);
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
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
            element.style.setProperty("width", percent + "%");
            updateText();
        }
        return this;
    }

    private void updateText() {
        if (showText) {
            int percent = new Double((value / maxValue) * 100).intValue();
            element.textContent = textExpression.replace("{percent}", percent + "")
                    .replace("{value}", value + "")
                    .replace("{maxValue}", maxValue + "");
        }
    }

    public ProgressBar animate(){
        striped();
        element.classList.add("active");
        return this;
    }

    public ProgressBar striped(){
        element.classList.remove("progress-bar-striped");
        element.classList.add("progress-bar-striped");
        return this;
    }

    public ProgressBar success() {
        return setStyle("progress-bar-success");
    }

    public ProgressBar warning() {
        return setStyle("progress-bar-warning");
    }

    public ProgressBar info() {
        return setStyle("progress-bar-info");
    }

    public ProgressBar danger() {
        return setStyle("progress-bar-danger");
    }

    private ProgressBar setStyle(String style) {
        element.classList.remove(this.style);
        element.classList.add(style);
        this.style = style;
        return this;
    }

    public ProgressBar setBackground(Background background){
        setStyle(background.getStyle());
        return this;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public ProgressBar textExpression(String expression) {
        this.textExpression = expression;
        updateText();
        return this;
    }
}
