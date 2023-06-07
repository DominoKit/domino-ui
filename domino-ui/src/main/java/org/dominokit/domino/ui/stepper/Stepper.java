package org.dominokit.domino.ui.stepper;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.config.TabsConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Stepper extends BaseDominoElement<HTMLDivElement, Stepper> implements StepperStyles, HasComponentConfig<StepperConfig> {
    private final DivElement root;
    private final StepperTrack stepperTrack;
    private final DivElement stepperContent;
    private final List<Step> steps = new ArrayList<>();

    private DivElement finishContent = div();

    public Stepper() {
        root = div()
                .addCss(dui_stepper)
                .appendChild(stepperTrack = StepperTrack.create())
                .appendChild(stepperContent = div().addCss(dui_stepper_content));
        init(this);
    }

    public static Stepper create() {
        return new Stepper();
    }

    public Stepper appendChild(Step step) {
        stepperContent.appendChild(step);
        stepperTrack.appendChild(step.getStepTracker());
        step.bindToStepper(this);
        steps.add(step);
        return this;
    }

    public Stepper removeStep(Step step) {
        step.remove();
        stepperTrack.removeTracker(step.getStepTracker());
        step.unbindStepper();
        steps.remove(step);
        return this;
    }

    public Stepper next() {
        return next(0);
    }

    public Stepper next(int skip) {
        return next(skip, (deactivated, activated) -> {
        });
    }

    public Stepper next(StepperTrack.StepTrackersConsumer consumer) {
        return next(0, consumer);
    }

    public Stepper next(int skip, StepperTrack.StepTrackersConsumer consumer) {
        this.stepperTrack.next(skip, consumer);
        return this;
    }

    public Stepper prev() {
        return prev(0);
    }

    public Stepper prev(StepperTrack.StepTrackersConsumer consumer) {
        return prev(0, consumer);
    }

    public Stepper prev(int skip) {
        return prev(skip, (deactivated, activated) -> {
        });
    }

    public Stepper prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
        this.stepperTrack.prev(skip, consumer);
        return this;
    }

    public Stepper start() {
        return start(getConfig().getDefaultStepState(), (deactivated, activated) -> {});
    }

    public Stepper start(StepState startState) {
        return start(startState, (deactivated, activated) -> {});
    }

    public Stepper start(StepState startState, StepperTrack.StepTrackersConsumer consumer) {
        elementOf(this.finishContent).remove();
        this.stepperTrack.start(startState, consumer);
        return this;
    }

    public Stepper withStepperTrack(ChildHandler<Stepper, StepperTrack> handler) {
        handler.apply(this, stepperTrack);
        return this;
    }

    public Stepper withStepperContent(ChildHandler<Stepper, DivElement> handler) {
        handler.apply(this, stepperContent);
        return this;
    }

    public Stepper withSteps(ChildHandler<Stepper, List<Step>> handler) {
        handler.apply(this, steps);
        return this;
    }
    public Stepper finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer){
        this.stepperTrack.finish(finishState, consumer);
        this.stepperContent.appendChild(finishContent);
        return this;
    }

    public Stepper finish(StepState finishState){
        finish(finishState, (deactivated, activated) -> {});
        return this;
    }

    public Stepper withFinishContent(ChildHandler<Stepper, DivElement> handler){
        handler.apply(this, finishContent);
        return this;
    }

    public Stepper reset(StepState startState, Consumer<List<Step>> stepsConsumer){
        stepsConsumer.accept(this.steps);
        start(startState);
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
