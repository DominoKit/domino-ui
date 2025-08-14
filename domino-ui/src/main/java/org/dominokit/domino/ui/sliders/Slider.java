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

import static org.dominokit.domino.ui.events.EventType.blur;
import static org.dominokit.domino.ui.events.EventType.change;
import static org.dominokit.domino.ui.events.EventType.mousedown;
import static org.dominokit.domino.ui.events.EventType.mousemove;
import static org.dominokit.domino.ui.events.EventType.mouseout;
import static org.dominokit.domino.ui.events.EventType.mouseup;
import static org.dominokit.domino.ui.events.EventType.touchend;
import static org.dominokit.domino.ui.events.EventType.touchmove;
import static org.dominokit.domino.ui.events.EventType.touchstart;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SlidersConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.events.EventOptions;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.Handler;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * Represents a UI slider component.
 *
 * <p>The slider allows users to select a value from a range by moving the slider thumb.
 *
 * <pre>
 * Usage example:
 *
 * Slider slider = Slider.create(100, 0, 50); // max: 100, min: 0, initial value: 50
 * slider.addChangeListener(value -> {
 *     System.out.println("New value: " + value);
 * });
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Slider extends BaseDominoElement<HTMLDivElement, Slider>
    implements HasChangeListeners<Slider, Double>, SliderStyles, HasComponentConfig<SlidersConfig> {
  private final DivElement root;
  private final InputElement input;
  private final SpanElement thumb;
  private final SpanElement valueElement;
  private double oldValue;
  private Set<ChangeListener<? super Double>> changeListeners = new HashSet<>();
  private Set<Handler<Slider>> sliderMoveListeners = new HashSet<>();
  private boolean mouseDown;
  private boolean withThumb;
  private boolean changeListenersPaused;
  private SwapCssClass dui_thumb_style = SwapCssClass.of(getConfig().getDefaultSliderThumbStyle());
  private boolean autoHideThumb = getConfig().autoHideThumb();
  private SlidersConfig config;

  /**
   * Creates a slider with a specified maximum value.
   *
   * @param max the maximum value for the slider
   * @return a new slider instance
   */
  public static Slider create(double max) {
    return create(max, 0, 0);
  }

  /**
   * Creates a slider with a specified maximum and minimum value.
   *
   * @param max the maximum value for the slider
   * @param min the minimum value for the slider
   * @return a new slider instance
   */
  public static Slider create(double max, double min) {
    return create(max, min, 0);
  }

  /**
   * Creates a slider with specified maximum, minimum, and initial value.
   *
   * @param max the maximum value for the slider
   * @param min the minimum value for the slider
   * @param value the initial value for the slider
   * @return a new slider instance
   */
  public static Slider create(double max, double min, double value) {
    return new Slider(max, min, value);
  }

  /**
   * Main constructor to create a Slider.
   *
   * @param max the maximum value
   * @param min the minimum value
   * @param value the initial value
   */
  public Slider(double max, double min, double value) {
    root =
        div()
            .addCss(dui_slider, dui_thumb_style)
            .appendChild(
                input = input("range").addCss(dui_slider_input).setAttribute("step", "any"))
            .appendChild(
                thumb =
                    span()
                        .addCss(dui_slider_thumb)
                        .collapse()
                        .appendChild(valueElement = span().addCss(dui_slider_value)));
    setMaxValue(max);
    setMinValue(min);
    setValue(value);
    EventListener downEvent =
        mouseDownEvent -> {
          this.mouseDown = true;
          startSliding();
        };
    EventListener moveMouseListener =
        mouseMoveEvent -> {
          if (mouseDown) {
            updateThumb();
            sliderMoveListeners.forEach(
                handler -> {
                  handler.apply(this);
                });
          }
        };
    EventListener leaveMouseListener =
        evt -> {
          if (isAutoHideThumb()) {
            hideThumb();
          }
        };

    EventListener upEvent =
        mouseUpEvent -> {
          mouseDown = false;
          input.removeCss(dui_active);
          if (isAutoHideThumb()) {
            hideThumb();
          }
        };
    input.addEventListener(change.getName(), evt -> triggerChangeListeners(oldValue, getValue()));

    input.addEventListener(mousedown.getName(), downEvent);
    input.addEventListener(touchstart.getName(), downEvent, EventOptions.of().setPassive(true));

    input.addEventListener(mousemove.getName(), moveMouseListener);
    input.addEventListener(
        touchmove.getName(), moveMouseListener, EventOptions.of().setPassive(true));
    input.addEventListener(EventType.input.getName(), moveMouseListener);

    input.addEventListener(mouseup.getName(), upEvent);
    input.addEventListener(touchend.getName(), upEvent, EventOptions.of().setPassive(true));

    input.addEventListener(mouseout.getName(), leaveMouseListener);
    input.addEventListener(blur.getName(), leaveMouseListener);

    init(this);
    onAttached(
        mutationRecord -> {
          if (!autoHideThumb) {
            startSliding();
            DomGlobal.setTimeout(
                p0 -> {
                  evaluateThumbPosition();
                },
                400);
          }
        });
  }

  public final void updateThumb() {
    if (withThumb) {
      showThumb();
      evaluateThumbPosition();
      updateThumbValue();
    }
  }

  private boolean isVertical() {
    return dui_vertical.isAppliedTo(this);
  }

  private void startSliding() {
    this.oldValue = getValue();
    input.addCss(dui_active);
    if (withThumb) {
      showThumb();
      if (mouseDown) {
        evaluateThumbPosition();
      }
    }
  }

  /**
   * Calculates the range offset of the slider's thumb based on its current value.
   *
   * @return the calculated range offset in pixels
   */
  private void calculateRangeOffset() {
    nowOrWhenAttached(
        () -> {
          if (isVertical()) {
            int height = input.element().offsetHeight - 15;
            double percent = (getValue() - getMin()) / (getMax() - getMin());
            double top = input.element().offsetHeight - (percent * height);
            thumb.style().setTop(top + "px");
          } else {
            int width = input.element().offsetWidth - 15;
            double percent = (getValue() - getMin()) / (getMax() - getMin());
            double left = percent * width + input.element().offsetLeft;
            thumb.style().setLeft(left + "px");
          }
        });
  }

  /**
   * Pauses the change listeners so they won't get triggered on value changes.
   *
   * @return the current slider instance
   */
  @Override
  public Slider pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /**
   * Resumes the change listeners so they get triggered on value changes.
   *
   * @return the current slider instance
   */
  @Override
  public Slider resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of the change listeners.
   *
   * @param toggle if true, pause the listeners, otherwise resume them
   * @return the current slider instance
   */
  @Override
  public Slider togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /**
   * Gets the set of change listeners attached to the slider.
   *
   * @return the set of change listeners
   */
  @Override
  public Set<ChangeListener<? super Double>> getChangeListeners() {
    return changeListeners;
  }

  /**
   * Checks if the change listeners are currently paused.
   *
   * @return true if listeners are paused, false otherwise
   */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /**
   * Triggers the change listeners manually with given old and new values.
   *
   * @param oldValue the previous value
   * @param newValue the current value
   * @return the current slider instance
   */
  @Override
  public Slider triggerChangeListeners(Double oldValue, Double newValue) {
    if (!isChangeListenersPaused()) {
      changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  public Slider addSliderMoveListener(Handler<Slider> handler) {
    this.sliderMoveListeners.add(handler);
    return this;
  }

  public Slider removeSliderMoveListener(Handler<Slider> handler) {
    this.sliderMoveListeners.remove(handler);
    return this;
  }

  /** Updates the display value of the slider's thumb based on its current value. */
  private void updateThumbValue() {
    if (withThumb) {
      valueElement.setTextContent(getConfig().formatSliderThumbValue(getValue()));
      evaluateThumbPosition();
    }
  }

  /** Shows the slider's thumb and updates its value display. */
  private void showThumb() {
    thumb.expand();
    updateThumbValue();
  }

  /** Hides the slider's thumb. */
  private void hideThumb() {
    thumb.collapse();
  }

  /**
   * Configures the slider to show its thumb and applies additional customizations using the
   * provided handler.
   *
   * @param handler a handler that allows customizations of the slider's thumb
   * @return the current slider instance
   */
  public Slider withThumb(ChildHandler<Slider, SpanElement> handler) {
    setShowThumb(true);
    handler.apply(this, thumb);
    return this;
  }

  /**
   * Configures the slider to show its thumb without any additional customizations.
   *
   * @return the current slider instance
   */
  public Slider withThumb() {
    setShowThumb(true);
    return this;
  }

  /** Evaluates the position of the slider's thumb based on the current value of the slider. */
  private void evaluateThumbPosition() {
    calculateRangeOffset();
  }

  /**
   * Sets the maximum value of the slider.
   *
   * @param max the maximum value to be set
   * @return the current slider instance
   */
  public Slider setMaxValue(double max) {
    input.element().max = String.valueOf(max);
    return this;
  }

  /**
   * Sets the minimum value of the slider.
   *
   * @param min the minimum value to be set
   * @return the current slider instance
   */
  public Slider setMinValue(double min) {
    input.element().min = String.valueOf(min);
    return this;
  }

  /**
   * Sets the value of the slider and optionally triggers change listeners.
   *
   * @param newValue the new value to be set
   * @param silent if true, change listeners won't be triggered
   * @return the current slider instance
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
   * Sets the value of the slider and triggers change listeners.
   *
   * @param newValue the new value to be set
   * @return the current slider instance
   */
  public Slider setValue(double newValue) {
    return setValue(newValue, false);
  }

  /**
   * Sets the stepping value of the slider.
   *
   * @param step the stepping value to be set
   * @return the current slider instance
   */
  public Slider setStep(double step) {
    input.element().step = String.valueOf(step);
    return this;
  }

  /**
   * Configures the slider to accept any step value.
   *
   * @return the current slider instance
   */
  public Slider anyStep() {
    input.element().step = "any";
    return this;
  }

  /**
   * Gets the maximum value of the slider.
   *
   * @return the maximum value
   */
  public double getMax() {
    return Double.parseDouble(input.element().max);
  }

  /**
   * Gets the minimum value of the slider.
   *
   * @return the minimum value
   */
  public double getMin() {
    return Double.parseDouble(input.element().min);
  }

  /**
   * Gets the current value of the slider.
   *
   * @return the current value
   */
  public double getValue() {
    return input.element().valueAsNumber;
  }

  /**
   * Sets whether the slider should show its thumb.
   *
   * @param withThumb if true, the thumb will be shown
   * @return the current slider instance
   */
  public Slider setShowThumb(boolean withThumb) {
    this.withThumb = withThumb;
    return this;
  }

  public Slider setAutoHideThumb(boolean autoHideThumb) {
    this.autoHideThumb = autoHideThumb;
    return this;
  }

  public boolean isAutoHideThumb() {
    return this.autoHideThumb;
  }

  /**
   * Returns the root HTML div element of the slider.
   *
   * @return the root HTML div element
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Adds a change listener to the slider. This listener will be notified of value changes.
   *
   * @param changeListener the listener to be added
   * @return the current slider instance
   */
  @Override
  public Slider addChangeListener(ChangeListener<? super Double> changeListener) {
    changeListeners.add(changeListener);
    return this;
  }

  /**
   * Removes a specific change listener from the slider.
   *
   * @param changeListener the listener to be removed
   * @return the current slider instance
   */
  @Override
  public Slider removeChangeListener(ChangeListener<? super Double> changeListener) {
    changeListeners.remove(changeListener);
    return this;
  }

  /**
   * Checks if the slider has the specified change listener.
   *
   * @param changeListener the listener to check for
   * @return true if the listener is present, false otherwise
   */
  @Override
  public boolean hasChangeListener(ChangeListener<? super Double> changeListener) {
    return changeListeners.contains(changeListener);
  }

  /**
   * Changes the thumb style for this slider
   *
   * @param thumbStyle {@link ThumbStyle}
   * @return same slider instance
   */
  public Slider setThumbStyle(ThumbStyle thumbStyle) {
    this.addCss(dui_thumb_style.replaceWith(thumbStyle.getThumbStyle()));
    return this;
  }

  public InputElement getInput() {
    return input;
  }

  public Slider withInputElement(ChildHandler<Slider, InputElement> handler) {
    handler.apply(this, input);
    return this;
  }

  @Override
  public SlidersConfig getOwnConfig() {
    return config;
  }

  public Slider setConfig(SlidersConfig config) {
    this.config = config;
    return this;
  }

  /**
   * A functional interface to handle slider slide events.
   *
   * @author ChatGPT
   */
  @FunctionalInterface
  public interface SlideHandler {

    /**
     * Called when the slider value changes.
     *
     * @param value the new value of the slider
     */
    void onSlide(double value);
  }
}
