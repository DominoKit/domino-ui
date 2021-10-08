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
package org.dominokit.domino.ui.steppers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.steppers.StepperStyles.horizontal;
import static org.dominokit.domino.ui.steppers.StepperStyles.stepper;
import static org.jboss.elemento.Elements.ul;

import elemental2.dom.HTMLUListElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** @deprecated use {@link org.dominokit.domino.ui.stepper.Stepper} */
@Deprecated
public class Stepper extends BaseDominoElement<HTMLUListElement, Stepper> {

  private static Transition HORIZONTAL_NEXT_STEP_TRANSITION = Transition.SLIDE_IN_RIGHT;
  private static Transition HORIZONTAL_PREV_STEP_TRANSITION = Transition.SLIDE_IN_LEFT;
  private final HTMLUListElement element = ul().css(stepper).element();
  private Step activeStep;
  private Color color;
  private List<Step> steps = new ArrayList<>();
  private StepperCompletionHandler stepperCompletionHandler = () -> {};

  private List<StepActivationHandler> stepActivationHandlers = new ArrayList<>();
  private List<StepDeActivationHandler> stepDeActivationHandlers = new ArrayList<>();
  private StepperChangeHandler stepperChangeHandler =
      (stepper, activatedStep, deactivatedStep) -> {};

  public Stepper() {

    MediaQuery.addOnSmallAndDownListener(
        () -> {
          HORIZONTAL_NEXT_STEP_TRANSITION = Transition.FADE_IN;
          HORIZONTAL_PREV_STEP_TRANSITION = Transition.FADE_IN;
        });

    MediaQuery.addOnMediumAndUpListener(
        () -> {
          HORIZONTAL_NEXT_STEP_TRANSITION = Transition.SLIDE_IN_RIGHT;
          HORIZONTAL_PREV_STEP_TRANSITION = Transition.SLIDE_IN_LEFT;
        });

    init(this);
  }

  public static Stepper create() {
    return new Stepper();
  }

  public Stepper appendChild(Step step) {
    element.appendChild(step.element());
    steps.add(step);
    step.setStepper(this);
    if (isNull(activeStep)) {
      activateStep(step);
    }
    step.setAttribute("data-step-number", steps.size() + "");
    step.getStepHeader().addEventListener("click", evt -> onStepHeaderClicked(step));

    return this;
  }

  private void onStepHeaderClicked(Step step) {
    if (step.isAllowStepClickActivation()) {
      int activeStepIndex = steps.indexOf(this.activeStep);
      int stepIndex = steps.indexOf(step);
      if (this.activeStep.isValid() && (activeStepIndex == stepIndex - 1)) {
        next();
      } else if (stepIndex < activeStepIndex) {
        activateStep(step);
      } else {
        if (!this.activeStep.isValid() && activeStepIndex != stepIndex) {
          this.activeStep.invalidate();
        }
      }
    }
  }

  @Override
  public HTMLUListElement element() {
    return element;
  }

  public Stepper activateStep(Step step) {
    if (steps.contains(step)) {

      Step currentActive = this.activeStep;
      Step targetStep = step;

      if (nonNull(this.activeStep)) {
        this.activeStep.deActivate();
        stepDeActivationHandlers.forEach(h -> h.onStepDeActivated(this.activeStep));
      }

      step.activate(getTransition(step));
      step.setDone(false);
      this.activeStep = step;
      stepperChangeHandler.onStepperChange(
          this, Optional.ofNullable(targetStep), Optional.ofNullable(currentActive));
      stepActivationHandlers.forEach(h -> h.onStepActivated(step));
    }

    return this;
  }

  private Transition getTransition(Step step) {
    int activeStepIndex = steps.indexOf(this.activeStep);
    int stepIndex = steps.indexOf(step);
    if (isHorizontal()) {
      if (stepIndex > activeStepIndex) {
        return HORIZONTAL_NEXT_STEP_TRANSITION;
      } else {
        return HORIZONTAL_PREV_STEP_TRANSITION;
      }
    } else {
      return Transition.FADE_IN;
    }
  }

  private boolean isHorizontal() {
    return Style.of(this).containsCss(horizontal);
  }

  public Stepper invalidate() {
    if (nonNull(activeStep)) {
      activeStep.invalidate();
    }
    return this;
  }

  public Stepper next() {
    int activeStepIndex = steps.indexOf(activeStep);
    if (steps.size() > 1 && activeStepIndex < steps.size() - 1) {
      if (this.activeStep.isValid()) {
        this.activeStep.setDone(true);
        activateStep(steps.get(activeStepIndex + 1));
      } else {
        this.activeStep.invalidate();
      }
    }
    return this;
  }

  public Stepper back() {
    int activeStepIndex = steps.indexOf(activeStep);
    if (steps.size() > 1 && activeStepIndex <= steps.size() - 1 && activeStepIndex > 0) {
      this.activeStep.setDone(false);
      activateStep(steps.get(activeStepIndex - 1));
    }
    return this;
  }

  public Stepper finish() {
    if (this.activeStep.isValid()) {
      this.activeStep.clearInvalid();
      this.activeStep.setDone(true);
      stepperCompletionHandler.onFinish();
      stepperChangeHandler.onStepperChange(
          this, Optional.empty(), Optional.ofNullable(this.activeStep));
    } else {
      this.activeStep.invalidate();
    }

    return this;
  }

  public Stepper setCompletionHandler(StepperCompletionHandler completionHandler) {
    if (nonNull(completionHandler)) {
      this.stepperCompletionHandler = completionHandler;
    }

    return this;
  }

  public Stepper setHorizontal(boolean horizontal) {
    removeCss(StepperStyles.horizontal);
    if (horizontal) {
      addCss(StepperStyles.horizontal);
    }

    return this;
  }

  public Stepper setMinHeight(String minHeight) {
    style().setMinHeight(minHeight);
    return this;
  }

  public Stepper setColor(Color color) {
    if (nonNull(this.color)) {
      removeCss("stepper-" + this.color.getStyle());
    }
    addCss("stepper-" + color.getStyle());
    this.color = color;

    return this;
  }

  public Stepper addStepActivationHandler(StepActivationHandler handler) {
    this.stepActivationHandlers.add(handler);
    return this;
  }

  public Stepper removeStepActivationHandler(StepActivationHandler handler) {
    this.stepActivationHandlers.remove(handler);
    return this;
  }

  public Stepper addStepDeActivationHandler(StepDeActivationHandler handler) {
    this.stepDeActivationHandlers.add(handler);
    return this;
  }

  public Stepper removeStepDeActivationHandler(StepDeActivationHandler handler) {
    this.stepDeActivationHandlers.remove(handler);
    return this;
  }

  public Stepper setStepperChangeHandler(StepperChangeHandler stepperChangeHandler) {
    this.stepperChangeHandler = stepperChangeHandler;
    return this;
  }

  public Step getActiveStep() {
    return activeStep;
  }

  public List<Step> getSteps() {
    return steps;
  }

  @FunctionalInterface
  public interface StepperCompletionHandler {
    void onFinish();
  }

  @FunctionalInterface
  public interface StepActivationHandler {
    void onStepActivated(Step step);
  }

  @FunctionalInterface
  public interface StepDeActivationHandler {
    void onStepDeActivated(Step step);
  }

  @FunctionalInterface
  public interface StepperChangeHandler {
    void onStepperChange(
        Stepper stepper, Optional<Step> activatedStep, Optional<Step> deactivatedStep);
  }
}
