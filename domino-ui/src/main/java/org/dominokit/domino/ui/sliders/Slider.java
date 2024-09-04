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

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;
import static org.jboss.elemento.Elements.input;
import static org.jboss.elemento.EventType.*;
import static org.jboss.elemento.EventType.input;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.EventOptions;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.elemento.IsElement;

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
@Deprecated
public class Slider extends BaseDominoElement<HTMLParagraphElement, Slider>
    implements HasChangeHandlers<Slider, Double> {

  private DominoElement<HTMLParagraphElement> sliderContainer =
      DominoElement.of(p()).css(SliderStyles.slide_container);
  private DominoElement<HTMLInputElement> slider =
      DominoElement.of(input("range")).css(SliderStyles.slider);
  private DominoElement<HTMLElement> thumb = DominoElement.of(span()).css(SliderStyles.thumb);
  private FlexItem<HTMLDivElement> leftAddonContainer = FlexItem.create();
  private FlexItem<HTMLDivElement> rightAddonContainer = FlexItem.create();
  private DominoElement<HTMLElement> thumbValue = DominoElement.of(span()).css("value");
  private List<ChangeHandler<? super Double>> changeHandlers = new ArrayList<>();
  private List<SlideHandler> slideHandlers = new ArrayList<>();
  private boolean mouseDown;
  private boolean withThumb;
  private Color backgroundColor;
  private Color thumbColor;
  private Element leftAddon;
  private Element rightAddon;

  /**
   * @param max double value
   * @return new Slider instance initialized with the max value and its value is 0, also its min
   *     value is 0
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
   * @param max double
   * @param min double
   * @param value double
   * @return new Slider instance initialized with the max and min values and sets its initial value
   */
  public static Slider create(double max, double min, double value) {
    return new Slider(max, min, value);
  }

  /**
   * initialize the slider with the max and min values and sets its initial value
   *
   * @param max double
   * @param min double
   * @param value double
   */
  public Slider(double max, double min, double value) {
    sliderContainer.appendChild(
        FlexLayout.create()
            .appendChild(
                leftAddonContainer
                    .hide()
                    .setHeight("100%")
                    .styler(
                        style1 ->
                            style1
                                .setWidth("28px")
                                .setTextAlign("center")
                                .setMarginLeft("5px")
                                .setMarginRight("5px")))
            .appendChild(FlexItem.create().setFlexGrow(1).appendChild(slider).appendChild(thumb))
            .appendChild(
                rightAddonContainer
                    .hide()
                    .styler(
                        style1 ->
                            style1
                                .setWidth("28px")
                                .setTextAlign("center")
                                .setMarginLeft("5px")
                                .setMarginRight("5px"))
                    .setHeight("100%")));
    thumb.appendChild(thumbValue);
    setMaxValue(max);
    setMinValue(min);
    setValue(value);
    EventListener downEvent =
        mouseDownEvent -> {
          if (slider.isReadOnly()) {
            onReadOnly(mouseDownEvent);
            return;
          }
          slider.addCss(SliderStyles.active);
          this.mouseDown = true;
          if (withThumb) {
            showThumb();
            evaluateThumbPosition();
          }
        };
    EventListener moveMouseListener =
        mouseMoveEvent -> {
          if (slider.isReadOnly()) {
            onReadOnly(mouseMoveEvent);
            return;
          }
          if (mouseDown) {
            if (withThumb) {
              evaluateThumbPosition();
              updateThumbValue();
            }
            slideHandlers.forEach(slideHandler -> slideHandler.onSlide(getValue()));
          }
        };
    EventListener leaveMouseListener = evt -> hideThumb();

    EventListener upEvent =
        mouseUpEvent -> {
          if (slider.isReadOnly()) {
            onReadOnly(mouseUpEvent);
            return;
          }
          mouseDown = false;
          slider.removeCss(SliderStyles.active);
          hideThumb();
        };
    slider.addEventListener(change.getName(), evt -> callChangeHandlers());

    slider.addEventListener(mousedown.getName(), downEvent, EventOptions.of().setPassive(true));
    slider.addEventListener(touchstart.getName(), downEvent, EventOptions.of().setPassive(true));

    slider.addEventListener(mousemove.getName(), moveMouseListener);
    slider.addEventListener(
        touchmove.getName(), moveMouseListener, EventOptions.of().setPassive(true));
    slider.addEventListener(input.getName(), moveMouseListener);

    slider.addEventListener(mouseup.getName(), upEvent);
    slider.addEventListener(touchend.getName(), upEvent, EventOptions.of().setPassive(true));

    slider.addEventListener(mouseout.getName(), leaveMouseListener);
    slider.addEventListener(blur.getName(), leaveMouseListener);

    setThumbColor(Theme.currentTheme.getScheme().color());

    init(this);
  }

  private void onReadOnly(Event mouseUpEvent) {
    mouseUpEvent.preventDefault();
    if (withThumb) {
      moveThumb();
      showThumb();
      updateThumbValue();
    }
  }

  private double calculateRangeOffset() {
    int width = slider.element().offsetWidth - 15;
    double percent = (getValue() - getMin()) / (getMax() - getMin());
    double rangeOffset = percent * width;
    if (leftAddonContainer.isExpanded()) {
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
    thumb.addCss(SliderStyles.active);
    updateThumbValue();
  }

  private void hideThumb() {
    thumb.removeCss(SliderStyles.active);
  }

  private void evaluateThumbPosition() {
    if (mouseDown) {
      moveThumb();
    }
  }

  private void moveThumb() {
    thumb.style().setLeft(calculateRangeOffset() + "px");
  }

  /**
   * @param max double max value
   * @return same Slider instance
   */
  public Slider setMaxValue(double max) {
    slider.element().max = max + "";
    return this;
  }

  /**
   * @param min double min value
   * @return same Slider instance
   */
  public Slider setMinValue(double min) {
    slider.element().min = min + "";
    return this;
  }

  /**
   * @param newValue double value
   * @param silent boolean, if true change handler wont be triggered
   * @return same Slider instance
   */
  public Slider setValue(double newValue, boolean silent) {
    slider.element().value = newValue + "";
    updateThumbValue();
    if (!silent) {
      callChangeHandlers();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Slider setReadOnly(boolean readOnly) {
    slider.setReadOnly(readOnly);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isReadOnly() {
    return slider.isReadOnly();
  }

  /** {@inheritDoc} */
  @Override
  public Slider setDisabled(boolean disabled) {
    slider.setDisabled(disabled);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isDisabled() {
    return slider.isDisabled();
  }

  /** {@inheritDoc} */
  @Override
  public Slider disable() {
    slider.disable();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Slider enable() {
    slider.enable();
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
    slider.element().step = step + "";
    return this;
  }

  /**
   * The slider will allow any value between min and max values without specific increment
   *
   * @return same Slider instance
   */
  public Slider anyStep() {
    slider.element().step = "any";
    return this;
  }

  /** @return double max value of this Slider */
  public double getMax() {
    return Double.parseDouble(slider.element().max);
  }

  /** @return double min value of this Slider */
  public double getMin() {
    return Double.parseDouble(slider.element().min);
  }

  /** @return double value of the Slider */
  public double getValue() {
    return slider.element().valueAsNumber;
  }

  /**
   * Show a thumb over the slider pointer that show the value while dragging
   *
   * @return same Slider instance
   */
  public Slider withThumb() {
    setWithThumb(true);
    return this;
  }

  /**
   * Wont show a thumb over the slider pointer that show the value while dragging
   *
   * @return same Slider instance
   */
  public Slider withoutThumb() {
    setWithThumb(false);
    return this;
  }

  /**
   * @param withThumb boolean, if true the slider will show a thumb over the pointer that shows the
   *     slider value while dragging
   * @return same Slider instance
   */
  public Slider setWithThumb(boolean withThumb) {
    this.withThumb = withThumb;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLParagraphElement element() {
    return sliderContainer.element();
  }

  /** {@inheritDoc} */
  @Override
  public Slider addChangeHandler(ChangeHandler<? super Double> changeHandler) {
    changeHandlers.add(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Slider removeChangeHandler(ChangeHandler<? super Double> changeHandler) {
    changeHandlers.remove(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super Double> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  /**
   * @param slideHandler {@link SlideHandler}
   * @return same Slider instance
   */
  public Slider addSlideHandler(SlideHandler slideHandler) {
    slideHandlers.add(slideHandler);
    return this;
  }

  /**
   * @param slideHandler {@link SlideHandler}
   * @return same Slider instance
   */
  public Slider removeSlideHandler(SlideHandler slideHandler) {
    slideHandlers.remove(slideHandler);
    return this;
  }

  /**
   * @param backgroundColor {@link Color} of the Slider
   * @return same Slider instance
   */
  public Slider setBackgroundColor(Color backgroundColor) {
    if (nonNull(this.backgroundColor)) {
      slider.removeCss("slider-" + this.backgroundColor.getBackground());
    }
    slider.addCss("slider-" + backgroundColor.getBackground());
    this.backgroundColor = backgroundColor;
    return this;
  }

  /**
   * @param thumbColor {@link Color} of the thumb
   * @return same Slider instance
   */
  public Slider setThumbColor(Color thumbColor) {
    if (nonNull(this.thumbColor)) {
      slider.removeCss("thumb-" + this.thumbColor.getBackground());
      thumb.removeCss(this.thumbColor.getBackground());
    }
    slider.addCss("thumb-" + thumbColor.getBackground());
    thumb.addCss(thumbColor.getBackground());
    this.thumbColor = thumbColor;
    return this;
  }

  /**
   * @param leftAddon {@link IsElement} to be added as an addon to the left of the slider
   * @return same Slider instance
   */
  public Slider setLeftAddon(IsElement<?> leftAddon) {
    return setLeftAddon(leftAddon.element());
  }

  /**
   * @param leftAddon {@link HTMLElement} to be added as an addon to the left of the slider
   * @return same Slider instance
   */
  public Slider setLeftAddon(HTMLElement leftAddon) {
    leftAddonContainer.show();
    setAddon(leftAddonContainer.element(), this.leftAddon, leftAddon);
    this.leftAddon = leftAddon;
    return this;
  }

  /**
   * @param rightAddon {@link IsElement} to be added as an addon to the right of the slider
   * @return same Slider instance
   */
  public Slider setRightAddon(IsElement<?> rightAddon) {
    return setRightAddon(rightAddon.element());
  }

  /**
   * @param rightAddon {@link HTMLElement} to be added as an addon to the right of the slider
   * @return same Slider instance
   */
  public Slider setRightAddon(HTMLElement rightAddon) {
    rightAddonContainer.show();
    setAddon(rightAddonContainer.element(), this.rightAddon, rightAddon);
    this.rightAddon = rightAddon;
    return this;
  }

  /** @return same Slider instance */
  public Slider removeRightAddon() {
    if (nonNull(rightAddon)) {
      rightAddon.remove();
      rightAddonContainer.hide();
    }
    return this;
  }

  /** @return same Slider instance */
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

  /**
   * @return the {@link HTMLInputElement} that wrapped by this slider as a {@link DominoElement} .
   */
  public DominoElement<HTMLInputElement> getSlider() {
    return slider;
  }

  /** A function to implement logic that will be called while dragging the slider pointer */
  @FunctionalInterface
  public interface SlideHandler {
    /** @param value double value for the current position of the slider pointer */
    void onSlide(double value);
  }
}
