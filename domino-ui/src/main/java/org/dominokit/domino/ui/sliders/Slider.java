/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.sliders;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.events.EventOptions;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.dominokit.domino.ui.events.EventType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.dominokit.domino.ui.events.EventType.blur;
import static org.dominokit.domino.ui.events.EventType.change;
import static org.dominokit.domino.ui.events.EventType.mousedown;
import static org.dominokit.domino.ui.events.EventType.mousemove;
import static org.dominokit.domino.ui.events.EventType.mouseout;
import static org.dominokit.domino.ui.events.EventType.mouseup;
import static org.dominokit.domino.ui.events.EventType.touchend;
import static org.dominokit.domino.ui.events.EventType.touchmove;
import static org.dominokit.domino.ui.events.EventType.touchstart;

/**
 * A component with min/max value and its value can be changed by sliding a pointer through the
 * component
 *
 * <pre>
 *     Slider.create(100, 0)
 *         .setStep(1)
 *         .setWithThumb(true);
 * </pre>
 */
public class Slider extends BaseDominoElement<HTMLDivElement, Slider>
        implements HasChangeListeners<Slider, Double>,
        SliderStyles{
    private final DivElement root;
    private final InputElement input;
    private final SpanElement thumb;
    private final SpanElement valueElement;
    private double oldValue;
    private Set<ChangeListener<? super Double>> changeListeners = new HashSet<>();
    private boolean mouseDown;
    private boolean withThumb;
    private boolean changeListenersPaused;

    /**
     * @param max double value
     * @return new Slider instance initialized with the max value and its value is 0, also its min
     * value is 0
     */
    public static Slider create(double max) {
        return create(max, 0, 0);
    }

    /**
     * @param max double
     * @param min double
     * @return new Slider instance initialized with the max and min values and its value is 0
     */
    public static Slider create(double max, double min) {
        return create(max, min, 0);
    }

    /**
     * @param max   double
     * @param min   double
     * @param value double
     * @return new Slider instance initialized with the max and min values and sets its initial
     * value
     */
    public static Slider create(double max, double min, double value) {
        return new Slider(max, min, value);
    }

    /**
     * initialize the slider with the max and min values and sets its initial value
     *
     * @param max   double
     * @param min   double
     * @param value double
     */
    public Slider(double max, double min, double value) {
        root = div()
                .addCss(dui_slider)
                .appendChild(input = input("range")
                        .addCss(dui_slider_input)
                        .setAttribute("step", "any")
                )
                .appendChild(thumb = span()
                        .addCss(dui_slider_thumb)
                        .collapse()
                        .appendChild(valueElement = span().addCss(dui_slider_value))
                );
        setMaxValue(max);
        setMinValue(min);
        setValue(value);
        EventListener downEvent =
                mouseDownEvent -> {
                    this.oldValue = getValue();
                    input.addCss(dui_active);
                    this.mouseDown = true;
                    if (withThumb) {
                        showThumb();
                        evaluateThumbPosition();
                    }
                };
        EventListener moveMouseListener =
                mouseMoveEvent -> {
                    if (mouseDown) {
                        if (withThumb) {
                            evaluateThumbPosition();
                            updateThumbValue();
                        }
                    }
                };
        EventListener leaveMouseListener = evt -> hideThumb();

        EventListener upEvent =
                mouseUpEvent -> {
                    mouseDown = false;
                    input.removeCss(dui_active);
                    hideThumb();
                };
        input.addEventListener(change.getName(), evt -> triggerChangeListeners(oldValue, getValue()));

        input.addEventListener(mousedown.getName(), downEvent);
        input.addEventListener(touchstart.getName(), downEvent, EventOptions.of().setPassive(true));

        input.addEventListener(mousemove.getName(), moveMouseListener);
        input.addEventListener(touchmove.getName(), moveMouseListener, EventOptions.of().setPassive(true));
        input.addEventListener(EventType.input.getName(), moveMouseListener);

        input.addEventListener(mouseup.getName(), upEvent);
        input.addEventListener(touchend.getName(), upEvent, EventOptions.of().setPassive(true));

        input.addEventListener(mouseout.getName(), leaveMouseListener);
        input.addEventListener(blur.getName(), leaveMouseListener);

        init(this);
    }

    private double calculateRangeOffset() {
        int width = input.element().offsetWidth - 15;
        double percent = (getValue() - getMin()) / (getMax() - getMin());
        return percent * width + input.element().offsetLeft;
    }

    @Override
    public Slider pauseChangeListeners() {
        this.changeListenersPaused = true;
        return this;
    }

    @Override
    public Slider resumeChangeListeners() {
        this.changeListenersPaused = false;
        return this;
    }

    @Override
    public Slider togglePauseChangeListeners(boolean toggle) {
        this.changeListenersPaused = toggle;
        return this;
    }

    @Override
    public Set<ChangeListener<? super Double>> getChangeListeners() {
        return changeListeners;
    }

    @Override
    public boolean isChangeListenersPaused() {
        return this.changeListenersPaused;
    }

    @Override
    public Slider triggerChangeListeners(Double oldValue, Double newValue) {
        if(!isChangeListenersPaused()){
            changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
        }
        return this;
    }

    private void updateThumbValue() {
        if (withThumb) {
            valueElement.setTextContent(String.valueOf(Double.valueOf(getValue()).intValue()));
        }
    }

    private void showThumb() {
        thumb.expand();
        updateThumbValue();
    }

    private void hideThumb() {
        thumb.collapse();
    }

    public Slider withThumb(ChildHandler<Slider, SpanElement> handler){
        setShowThumb(true);
        handler.apply(this, thumb);
        return this;
    }

    public Slider withThumb(){
        setShowThumb(true);
        return this;
    }

    private void evaluateThumbPosition() {
        if (mouseDown) {
            thumb.style().setLeft(calculateRangeOffset() + "px");
        }
    }

    /**
     * @param max double max value
     * @return same Slider instance
     */
    public Slider setMaxValue(double max) {
        input.element().max = String.valueOf(max);
        return this;
    }

    /**
     * @param min double min value
     * @return same Slider instance
     */
    public Slider setMinValue(double min) {
        input.element().min = String.valueOf(min);
        return this;
    }

    /**
     * @param newValue double value
     * @param silent   boolean, if true change handler wont be triggered
     * @return same Slider instance
     */
    public Slider setValue(double newValue, boolean silent) {
        double oldValue = getValue();
        input.element().value = String.valueOf(newValue);
        updateThumbValue();
        if (!silent) {
            triggerChangeListeners(oldValue, newValue);
        }
        return this;
    }

    /**
     * @param newValue double value
     * @return same Slider instance
     */
    public Slider setValue(double newValue) {
        return setValue(newValue, false);
    }

    /**
     * @param step double value increment while dragging the pointer
     * @return same Slider instance
     */
    public Slider setStep(double step) {
        input.element().step = String.valueOf(step);
        return this;
    }

    /**
     * The slider will allow any value between min and max values without specific increment
     *
     * @return same Slider instance
     */
    public Slider anyStep() {
        input.element().step = "any";
        return this;
    }

    /**
     * @return double max value of this Slider
     */
    public double getMax() {
        return Double.parseDouble(input.element().max);
    }

    /**
     * @return double min value of this Slider
     */
    public double getMin() {
        return Double.parseDouble(input.element().min);
    }

    /**
     * @return double value of the Slider
     */
    public double getValue() {
        return input.element().valueAsNumber;
    }

    /**
     * @param withThumb boolean, if true the slider will show a thumb over the pointer that shows
     *                  the
     *                  slider value while dragging
     * @return same Slider instance
     */
    public Slider setShowThumb(boolean withThumb) {
        this.withThumb = withThumb;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Slider addChangeListener(ChangeListener<? super Double> changeListener) {
        changeListeners.add(changeListener);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Slider removeChangeListener(ChangeListener<? super Double> changeListener) {
        changeListeners.remove(changeListener);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasChangeListener(ChangeListener<? super Double> changeListener) {
        return changeListeners.contains(changeListener);
    }

    /**
     * A function to implement logic that will be called while dragging the slider pointer
     */
    @FunctionalInterface
    public interface SlideHandler {
        /**
         * @param value double value for the current position of the slider pointer
         */
        void onSlide(double value);
    }
}