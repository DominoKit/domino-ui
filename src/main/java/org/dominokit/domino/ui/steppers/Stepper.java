package org.dominokit.domino.ui.steppers;

import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class Stepper implements IsElement<HTMLUListElement> {

    public static Transition HORIZONTAL_NEXT_STEP_TRANSITION = Transition.SLIDE_IN_RIGHT;
    public static Transition HORIZONTAL_PREV_STEP_TRANSITION = Transition.SLIDE_IN_LEFT;
    private final HTMLUListElement element = ul().css("stepper").asElement();
    private Step activeStep;
    private Color color;
    private List<Step> steps = new ArrayList<>();
    private StepperCompletionHandler stepperCompletionHandler = () -> {
    };

    public Stepper() {

        MediaQuery.addOnSmallAndDownListener(() -> {
            HORIZONTAL_NEXT_STEP_TRANSITION = Transition.FADE_IN;
            HORIZONTAL_PREV_STEP_TRANSITION = Transition.FADE_IN;
        });

        MediaQuery.addOnMediumAndUpListener(() -> {
            HORIZONTAL_NEXT_STEP_TRANSITION = Transition.SLIDE_IN_RIGHT;
            HORIZONTAL_PREV_STEP_TRANSITION = Transition.SLIDE_IN_LEFT;
        });
    }

    public static Stepper create() {
        return new Stepper();
    }

    public Stepper addStep(Step step) {
        element.appendChild(step.asElement());
        if (isNull(activeStep)) {
            step.activate(getTransition(step));
            this.activeStep = step;
        }
        steps.add(step);
        step.asElement().setAttribute("data-step-number", steps.size()+"");

        step.getStepHeader().addEventListener("click", evt -> onStepHeaderClicked(step));

        return this;
    }

    private void onStepHeaderClicked(Step step) {
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

    @Override
    public HTMLUListElement asElement() {
        return element;
    }

    public Stepper activateStep(Step step) {
        if (steps.contains(step)) {
            this.activeStep.deActivate();
            step.activate(getTransition(step));
            step.setDone(false);
            this.activeStep = step;
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
        return Style.of(this).hasClass("horizontal");
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
        Style.of(element).removeClass("horizontal");
        if (horizontal) {
            Style.of(element).css("horizontal");
        }

        return this;
    }

    public Stepper setMinHeight(String minHeight) {
        Style.of(this).setMinHeight(minHeight);
        return this;
    }

    public Stepper setColor(Color color) {
        if (nonNull(this.color)) {
            Style.of(this).removeClass("stepper-" + this.color.getStyle());
        }
        Style.of(this).css("stepper-" + color.getStyle());
        this.color = color;

        return this;
    }

    @FunctionalInterface
    public interface StepperCompletionHandler {
        void onFinish();
    }
}
