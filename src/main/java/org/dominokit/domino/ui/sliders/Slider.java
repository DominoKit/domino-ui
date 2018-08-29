package org.dominokit.domino.ui.sliders;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.EventType.*;
import static org.jboss.gwt.elemento.core.EventType.input;

public class Slider extends DominoElement<Slider> implements IsElement<HTMLParagraphElement>, HasChangeHandlers<Slider, Double> {

    private HTMLParagraphElement sliderContainer = p().css("slide-container").asElement();
    private HTMLInputElement slider = input("range").css("slider").asElement();
    private HTMLElement thumb = span().css("thumb").asElement();
    private HTMLElement thumbValue = span().css("value").asElement();
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
            slider.classList.add("active");
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
            slider.classList.remove("active");
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
    }

    private double calculateRangeOffset() {
        int width = slider.offsetWidth - 15;
        double percent = (getValue() - getMin()) / (getMax() - getMin());
        return percent * width;
    }

    private void callChangeHandlers() {
        changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(getValue()));
    }

    private void updateThumbValue() {
        if (withThumb) {
            thumbValue.textContent = getValue() + "";
        }
    }

    private void showThumb() {
        thumb.classList.add("active");
        updateThumbValue();
    }

    private void hideThumb() {
        thumb.classList.remove("active");
    }

    private void evaluateThumbPosition() {
        if (mouseDown) {
            thumb.style.left = calculateRangeOffset() + "px";
        }
    }

    public Slider setMaxValue(double max) {
        slider.max = max + "";
        return this;
    }

    public Slider setMinValue(double min) {
        slider.min = min + "";
        return this;
    }


    public Slider setValue(double newValue) {
        slider.value = newValue + "";
        updateThumbValue();
        callChangeHandlers();
        return this;
    }

    public Slider setStep(double step) {
        slider.step = step + "";
        return this;
    }

    public Slider anyStep() {
        slider.step = "any";
        return this;
    }

    public double getMax() {
        return Double.parseDouble(slider.max);
    }

    public double getMin() {
        return Double.parseDouble(slider.min);
    }

    public double getValue() {
        return slider.valueAsNumber;
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
        return sliderContainer;
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
            slider.classList.remove(this.backgroundColor.getBackground());
        }
        slider.classList.add(backgroundColor.getBackground());
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Slider setThumbColor(Color thumbColor) {
        if (nonNull(this.thumbColor)) {
            slider.classList.remove("thumb-" + this.thumbColor.getBackground());
            thumb.classList.remove(this.thumbColor.getBackground());
        }
        slider.classList.add("thumb-" + thumbColor.getBackground());
        thumb.classList.add(thumbColor.getBackground());
        this.thumbColor = thumbColor;
        return this;
    }

    public Style<HTMLParagraphElement, Slider> style(){
        return Style.of(this);
    }

    @FunctionalInterface
    public interface SlideHandler {
        void onSlide(double value);
    }
}
