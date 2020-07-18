package org.dominokit.domino.ui.sliders;

import elemental2.dom.*;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.input;
import static org.jboss.elemento.Elements.*;
import static org.jboss.elemento.EventType.input;
import static org.jboss.elemento.EventType.*;

public class Slider extends BaseDominoElement<HTMLParagraphElement, Slider> implements HasChangeHandlers<Slider, Double> {

    private DominoElement<HTMLParagraphElement> sliderContainer = DominoElement.of(p().css(SliderStyles.slide_container));
    private DominoElement<HTMLInputElement> slider = DominoElement.of(input("range").css(SliderStyles.slider));
    private DominoElement<HTMLElement> thumb = DominoElement.of(span().css(SliderStyles.thumb));
    private FlexItem leftAddonContainer = FlexItem.create();
    private FlexItem rightAddonContainer = FlexItem.create();
    private DominoElement<HTMLElement> thumbValue = DominoElement.of(span().css("value"));
    private List<ChangeHandler<? super Double>> changeHandlers = new ArrayList<>();
    private List<SlideHandler> slideHandlers = new ArrayList<>();
    private boolean mouseDown;
    private boolean withThumb;
    private Color backgroundColor;
    private Color thumbColor;
    private Element leftAddon;
    private Element rightAddon;

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
        sliderContainer.appendChild(FlexLayout.create()
                .appendChild(leftAddonContainer
                        .hide()
                        .setHeight("100%")
                        .styler(style1 -> style1.setWidth("28px")
                                .setTextAlign("center")
                                .setMarginLeft("5px")
                                .setMarginRight("5px"))
                )
                .appendChild(FlexItem.create()
                        .setFlexGrow(1)
                        .appendChild(slider)
                        .appendChild(thumb)
                )
                .appendChild(rightAddonContainer
                        .hide()
                        .styler(style1 -> style1.setWidth("28px")
                                .setTextAlign("center")
                                .setMarginLeft("5px")
                                .setMarginRight("5px"))
                        .setHeight("100%")
                )
        );
        thumb.appendChild(thumbValue);
        setMaxValue(max);
        setMinValue(min);
        setValue(value);
        EventListener downEvent = mouseDownEvent -> {
            slider.style().add(SliderStyles.active);
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
            slider.style().remove(SliderStyles.active);
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
        int width = slider.element().offsetWidth - 15;
        double percent = (getValue() - getMin()) / (getMax() - getMin());
        double rangeOffset = percent * width;
        if (!leftAddonContainer.isHidden()) {
            rangeOffset += leftAddonContainer.element().offsetWidth + 9;
        }
        return rangeOffset;
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
        thumb.style().add(SliderStyles.active);
        updateThumbValue();
    }

    private void hideThumb() {
        thumb.style().remove(SliderStyles.active);
    }

    private void evaluateThumbPosition() {
        if (mouseDown) {
            thumb.style().setLeft(calculateRangeOffset() + "px");
        }
    }

    public Slider setMaxValue(double max) {
        slider.element().max = max + "";
        return this;
    }

    public Slider setMinValue(double min) {
        slider.element().min = min + "";
        return this;
    }

    public Slider setValue(double newValue, boolean silent) {
        slider.element().value = newValue + "";
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
        slider.element().step = step + "";
        return this;
    }

    public Slider anyStep() {
        slider.element().step = "any";
        return this;
    }

    public double getMax() {
        return Double.parseDouble(slider.element().max);
    }

    public double getMin() {
        return Double.parseDouble(slider.element().min);
    }

    public double getValue() {
        return slider.element().valueAsNumber;
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
    public HTMLParagraphElement element() {
        return sliderContainer.element();
    }

    @Override
    public Slider addChangeHandler(ChangeHandler<? super Double> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public Slider removeChangeHandler(ChangeHandler<? super Double> changeHandler) {
        changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super Double> changeHandler) {
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

    public <E extends HTMLElement> Slider setLeftAddon(IsElement<E> leftAddon) {
        return setLeftAddon(leftAddon.element());
    }

    public Slider setLeftAddon(HTMLElement leftAddon) {
        leftAddonContainer.show();
        setAddon(leftAddonContainer.element(), this.leftAddon, leftAddon);
        this.leftAddon = leftAddon;
        return this;
    }

    public <E extends HTMLElement> Slider setRightAddon(IsElement<E> rightAddon) {
        return setRightAddon(rightAddon.element());
    }

    public Slider setRightAddon(HTMLElement rightAddon) {
        rightAddonContainer.show();
        setAddon(rightAddonContainer.element(), this.rightAddon, rightAddon);
        this.rightAddon = rightAddon;
        return this;
    }

    public Slider removeRightAddon() {
        if (nonNull(rightAddon)) {
            rightAddon.remove();
            rightAddonContainer.hide();
        }
        return this;
    }

    public Slider removeLeftAddon() {
        if (nonNull(leftAddon)) {
            leftAddon.remove();
            leftAddonContainer.hide();
        }
        return this;
    }

    private void setAddon(HTMLElement container, Element oldAddon, Element addon) {
        if (nonNull(oldAddon)) {
            oldAddon.remove();
        }
        if (nonNull(addon)) {
            List<String> oldClasses = new ArrayList<>(addon.classList.asList());
            for (String oldClass : oldClasses) {
                addon.classList.remove(oldClass);
            }
            for (String oldClass : oldClasses) {
                addon.classList.add(oldClass);
            }
            container.appendChild(addon);
        }
    }

    @FunctionalInterface
    public interface SlideHandler {
        void onSlide(double value);
    }
}
