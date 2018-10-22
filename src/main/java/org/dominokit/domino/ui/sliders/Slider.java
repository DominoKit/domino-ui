package org.dominokit.domino.ui.sliders;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.EventType.*;
import static org.jboss.gwt.elemento.core.EventType.input;

public class Slider extends BaseDominoElement<HTMLParagraphElement, Slider> implements HasChangeHandlers<Slider, Double> {

    private DominoElement<HTMLParagraphElement> sliderContainer = DominoElement.of(p().css("slide-container"));
    private DominoElement<HTMLInputElement> slider = DominoElement.of(input("range").css("slider"));
    private DominoElement<HTMLElement> thumb = DominoElement.of(span().css("thumb"));
    private DominoElement<HTMLElement> thumbValue = DominoElement.of(span().css("value"));
    private List<ChangeHandler<Double>> changeHandlers = new ArrayList<>();
    private List<SlideHandler> slideHandlers = new ArrayList<>();
    private boolean mouseDown;
    private boolean withThumb;
    private Color backgroundColor;
    private Color thumbColor;

    public static Slider create(double max) {
        return create(max, 0, 0);
    }

    public static Slider create(double max, double min) {
        return create(max, min, 0);
    }

    public static Slider create(double max, double min, double value) {
        return new Slider(max, min, value);
    }

    public Slider(double max, double min, double value) {
        sliderContainer.appendChild(slider);
        thumb.appendChild(thumbValue);
        sliderContainer.appendChild(thumb);
        setMaxValue(max);
        setMinValue(min);
        setValue(value);
        EventListener downEvent = mouseDownEvent -> {
            slider.style().add("active");
            this.mouseDown = true;
            if (withThumb) {
                showThumb();
                evaluateThumbPosition();
            }
        };
        EventListener moveMouseListener = mouseMoveEvent -> {
            if (mouseDown) {
                if (withThumb) {
                    evaluateThumbPosition();
                    updateThumbValue();
                }
                slideHandlers.forEach(slideHandler -> slideHandler.onSlide(getValue()));
            }
        };
        EventListener leaveMouseListener = evt -> hideThumb();

        EventListener upEvent = mouseUpEvent -> {
            mouseDown = false;
            slider.style().remove("active");
            hideThumb();
        };
        slider.addEventListener(change.getName(), evt -> callChangeHandlers());

        slider.addEventListener(mousedown.getName(), downEvent);
        slider.addEventListener(touchstart.getName(), downEvent);

        slider.addEventListener(mousemove.getName(), moveMouseListener);
        slider.addEventListener(touchmove.getName(), moveMouseListener);
        slider.addEventListener(input.getName(), moveMouseListener);

        slider.addEventListener(mouseup.getName(), upEvent);
        slider.addEventListener(touchend.getName(), upEvent);

        slider.addEventListener(mouseout.getName(), leaveMouseListener);
        slider.addEventListener(blur.getName(), leaveMouseListener);

        setThumbColor(Theme.currentTheme.getScheme().color());

        init(this);
    }

    private double calculateRangeOffset() {
        int width = slider.asElement().offsetWidth - 15;
        double percent = (getValue() - getMin()) / (getMax() - getMin());
        return percent * width;
    }

    private void callChangeHandlers() {
        changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(getValue()));
    }

    private void updateThumbValue() {
        if (withThumb) {
            thumbValue.setTextContent(getValue() + "");
        }
    }

    private void showThumb() {
        thumb.style().add("active");
        updateThumbValue();
    }

    private void hideThumb() {
        thumb.style().remove("active");
    }

    private void evaluateThumbPosition() {
        if (mouseDown) {
            thumb.style().setLeft(calculateRangeOffset() + "px");
        }
    }

    public Slider setMaxValue(double max) {
        slider.asElement().max = max + "";
        return this;
    }

    public Slider setMinValue(double min) {
        slider.asElement().min = min + "";
        return this;
    }

    public Slider setValue(double newValue, boolean silent) {
        slider.asElement().value = newValue + "";
        updateThumbValue();
        if (!silent) {
            callChangeHandlers();
        }
        return this;
    }

    public Slider setValue(double newValue) {
        return setValue(newValue, false);
    }

    public Slider setStep(double step) {
        slider.asElement().step = step + "";
        return this;
    }

    public Slider anyStep() {
        slider.asElement().step = "any";
        return this;
    }

    public double getMax() {
        return Double.parseDouble(slider.asElement().max);
    }

    public double getMin() {
        return Double.parseDouble(slider.asElement().min);
    }

    public double getValue() {
        return slider.asElement().valueAsNumber;
    }

    public Slider withThumb() {
        setWithThumb(true);
        return this;
    }

    public Slider withoutThumb() {
        setWithThumb(false);
        return this;
    }

    public Slider setWithThumb(boolean withThumb) {
        this.withThumb = withThumb;
        return this;
    }

    @Override
    public HTMLParagraphElement asElement() {
        return sliderContainer.asElement();
    }

    @Override
    public Slider addChangeHandler(ChangeHandler<Double> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public Slider removeChangeHandler(ChangeHandler<Double> changeHandler) {
        changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<Double> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    public Slider addSlideHandler(SlideHandler slideHandler) {
        slideHandlers.add(slideHandler);
        return this;
    }

    public Slider removeSlideHandler(SlideHandler slideHandler) {
        slideHandlers.remove(slideHandler);
        return this;
    }

    public Slider setBackgroundColor(Color backgroundColor) {
        if (nonNull(this.backgroundColor)) {
            slider.style().remove("slider-" + this.backgroundColor.getBackground());
        }
        slider.style().add("slider-" + backgroundColor.getBackground());
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Slider setThumbColor(Color thumbColor) {
        if (nonNull(this.thumbColor)) {
            slider.style().remove("thumb-" + this.thumbColor.getBackground());
            thumb.style().remove(this.thumbColor.getBackground());
        }
        slider.style().add("thumb-" + thumbColor.getBackground());
        thumb.style().add(thumbColor.getBackground());
        this.thumbColor = thumbColor;
        return this;
    }

    @FunctionalInterface
    public interface SlideHandler {
        void onSlide(double value);
    }
}
