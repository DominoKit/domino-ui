package org.dominokit.domino.ui.stepper;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

import static java.util.Objects.nonNull;

public class Step extends BaseDominoElement<HTMLDivElement, Step> implements StepperStyles, HasComponentConfig<StepperConfig> {

    private final DivElement root;
    private final NavBar stepHeader;
    private final DivElement stepContent;
    private final StepTracker stepTracker;
    private LazyChild<DivElement> stepFooter;
    private StepState state;
    private Stepper stepper;

    public Step(String title) {
        this.state = getConfig().getDefaultStepState();
        root = div()
                .addCss(dui_stepper_step)
                .appendChild(stepHeader = NavBar.create(title).addCss(dui_step_header))
                .appendChild(stepContent = div().addCss(dui_step_content))
        ;
        stepFooter = LazyChild.of(div().addCss(dui_step_footer), root);
        stepTracker = StepTracker.create()
                .applyMeta(StepMeta.of(this))
                .addStateListener((tracker, trackerState) -> setStepState(tracker));
        init(this);
    }

    public static Step create(String title) {
        return new Step(title);
    }

    private void setStepState(StepTracker tracker) {
        this.state = tracker.getState();
        addCss(BooleanCssClass.of(dui_active, tracker.isActive()));
    }

    public Step withHeader(ChildHandler<Step, NavBar> handler) {
        handler.apply(this, stepHeader);
        return this;
    }

    public Step withFooter(ChildHandler<Step, DivElement> handler) {
        handler.apply(this, stepFooter.get());
        return this;
    }

    public Step withContent(ChildHandler<Step, DivElement> handler) {
        handler.apply(this, stepContent);
        return this;
    }

    public Step withTracker(ChildHandler<Step, StepTracker> handler) {
        handler.apply(this, stepTracker);
        return this;
    }

    public StepTracker getStepTracker() {
        return stepTracker;
    }

    void bindToStepper(Stepper stepper) {
        this.stepper = stepper;
        setState(this.state);
    }

    public Step setState(StepState state) {
        this.stepTracker.setState(state);
        return this;
    }

    void unbindStepper() {
        this.stepper = null;
    }

    public Step next() {
        return next(0);
    }

    public Step next(int skip) {
        return next(skip, (deactivated, activated) -> {
        });
    }

    public Step next(StepperTrack.StepTrackersConsumer consumer) {
        return next(0, consumer);
    }

    public Step next(int skip, StepperTrack.StepTrackersConsumer consumer) {
        if (nonNull(this.stepper)) {
            this.stepper.next(skip, consumer);
        }
        return this;
    }

    public Step prev() {
        return prev(0);
    }

    public Step prev(StepperTrack.StepTrackersConsumer consumer) {
        return prev(0, consumer);
    }

    public Step prev(int skip) {
        return prev(skip, (deactivated, activated) -> {
        });
    }

    public Step prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
        if (nonNull(this.stepper)) {
            this.stepper.prev(skip, consumer);
        }
        return this;
    }

    public Step finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer){
        if(nonNull(this.stepper)) {
            this.stepper.finish(finishState, consumer);
        }
        return this;
    }

    public Step finish(StepState finishState){
        finish(finishState, (deactivated, activated) -> {});
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    @Override
    protected Element getAppendTarget() {
        return stepContent.element();
    }

}
