package org.dominokit.domino.ui.stepper;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.grid.flex.FlexWrap;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.stepper.StepperStyles.*;
import static org.jboss.elemento.Elements.span;

public class Stepper extends BaseDominoElement<HTMLDivElement, Stepper> {

    private final FlexItem content;
    private final FlexItem stepContentFlexItem;
    private final FlexItem stepFooter;
    private FlexLayout root = FlexLayout.create();
    private int activeStepNumber = 1;
    private StepperDirection direction = StepperDirection.HORIZONTAL;
    private List<Step> steps = new ArrayList<>();
    private Step activeStep;
    private Color barColor;

    private Transition activateStepTransition;
    private Transition deactivateStepTransition;
    private int activateStepTransitionDuration;
    private int deactivateStepTransitionDuration;

    private boolean forceVertical = false;
    private StepperDirection originalDirection = StepperDirection.HORIZONTAL;

    private StepStateColors stepStateColors;

    private final List<StepStateChangeListener> stepStateChangeListeners = new ArrayList<>();
    private final List<StepperCompleteListener> completeListeners = new ArrayList<>();

    private StepNumberRenderer stepNumberRenderer = new StepNumberRenderer() {
        @Override
        public Node inactiveElement(Step step, StepStateColors stepStateColors) {
            return DominoElement.of(span())
                    .css(stepStateColors.inactive().getBackground())
                    .setTextContent(step.getStepNumber() + "").element();
        }

        @Override
        public Node activeElement(Step step, StepStateColors stepStateColors) {
            return DominoElement.of(span())
                    .css(stepStateColors.active().getBackground())
                    .setTextContent(step.getStepNumber() + "").element();
        }

        @Override
        public Node errorElement(Step step, StepStateColors stepStateColors) {
            return DominoElement.of(span())
                    .css(stepStateColors.error().getBackground())
                    .setTextContent(step.getStepNumber() + "").element();
        }

        @Override
        public Node completedElement(Step step, StepStateColors stepStateColors) {
            return DominoElement.of(span())
                    .appendChild(Icons.ALL.check_mdi().size18())
                    .css(stepStateColors.completed().getBackground())
                    .element();
        }

        @Override
        public Node disabledElement(Step step, StepStateColors stepStateColors) {
            return DominoElement.of(span())
                    .appendChild(Icons.ALL.block_helper_mdi().size18())
                    .css(stepStateColors.disabled().getBackground()).element();
        }
    };

    public static Stepper create(){
        return new Stepper();
    }

    public Stepper() {
        init(this);
        stepStateColors = new StepStateColorsImpl(Color.GREY, Color.THEME, Color.RED, Color.GREEN, Color.GREY_LIGHTEN_2);
        barColor = Color.GREY;

        this.activateStepTransition = Transition.FADE_IN;
        this.deactivateStepTransition = Transition.FADE_OUT;
        this.activateStepTransitionDuration = 200;
        this.deactivateStepTransitionDuration = 200;

        root
                .css(direction.style, D_STEPPER)
                .setWrap(FlexWrap.WRAP_TOP_TO_BOTTOM);

        stepContentFlexItem = FlexItem.create();
        stepFooter = FlexItem.create();
        content = FlexItem.create()
                .appendChild(FlexLayout.create()
                        .setDirection(FlexDirection.TOP_TO_BOTTOM)
                        .appendChild(stepContentFlexItem)
                        .appendChild(stepFooter)
                );
        root
                .appendChild(content
                        .setOrder(Integer.MAX_VALUE)
                        .css(STEP_CONTENT)
                );

        setStepFooter(FlexLayout.create()
                .appendChild(FlexItem.create()
                        .appendChild(Button.createPrimary(Icons.ALL.arrow_left_bold_mdi())
                                .setTextContent("Back")
                                .addClickListener(evt -> previouse())
                        )
                )
                .appendChild(FlexItem.create()
                        .appendChild(FlexItem.create()
                                .appendChild(Button.createPrimary(Icons.ALL.arrow_right_bold_mdi())
                                        .setTextContent("Next")
                                        .addClickListener(evt -> next())
                                )
                        )
                )
                .appendChild(FlexItem.create()
                        .appendChild(FlexItem.create()
                                .appendChild(Button.createPrimary(Icons.ALL.arrow_left_bold_mdi())
                                        .setTextContent("Complete")
                                        .addClickListener(evt -> completeActiveStep())
                                )
                        )
                )
        );

        setBarColor(barColor);

        MediaQuery.addOnSmallAndDownListener(() -> {
            forceVertical = true;
            originalDirection = this.direction;
            setDirection(this.direction);
        });
        MediaQuery.addOnMediumAndUpListener(() -> {
            forceVertical = false;
            setDirection(this.originalDirection);
        });
    }

    public Stepper setStepNumberRenderer(StepNumberRenderer stepNumberRenderer) {
        if (nonNull(stepNumberRenderer)) {
            this.stepNumberRenderer = stepNumberRenderer;
            steps.forEach(Step::renderNumber);
        }
        return this;
    }

    public Stepper setStepStateColors(StepStateColors stepStateColors) {
        if (nonNull(stepStateColors)) {
            this.stepStateColors = stepStateColors;
            steps.forEach(Step::renderNumber);
        }
        return this;
    }

    public Stepper setStepFooter(IsElement<?> footerElement) {
        return setStepFooter(footerElement.element());
    }

    public Stepper setStepFooter(Node footerElement) {
        stepFooter.setContent(footerElement);
        return this;
    }

    public Stepper complete() {
        completeListeners.forEach(listener -> listener.onComplete(this));
        return this;
    }

    public Stepper complete(IsElement<?> completeContent) {
        return complete(completeContent.element());
    }

    public Stepper complete(Node completeContent) {
        complete();
        content.setContent(completeContent);
        getActiveStep().css("complete-content");
        return this;
    }

    public Step getCurrentStep() {
        return activeStep;
    }

    public Stepper completeActiveStep() {
        this.activeStep.complete();
        return this;
    }

    public Stepper appendChild(Step step) {
        if (!steps.contains(step)) {
            step.setStepper(this);
        }
        if (!steps.isEmpty()) {
            steps.get(steps.size() - 1).removeCss(LAST_STEP);
            steps.get(steps.size() - 1).setFlexGrow(1);
        } else {
            this.activeStep = step;
            step.activate();
            step.setFlexGrow(1);
        }
        steps.add(step);
        step.setStepNumber(steps.indexOf(step) + 1);
        root.appendChild(step);
        step.css(LAST_STEP);

        return this;
    }

    public Stepper setDirection(StepperDirection direction) {

        if (forceVertical && StepperDirection.VERTICAL != direction) {
            this.originalDirection = this.direction;
            setDirection(StepperDirection.VERTICAL);
        } else {
            if (direction != this.direction) {
                root.removeCss(this.direction.style);
                root.css(direction.style);
            }
            root.setDirection(direction.flexDirection);
            this.direction = direction;
            if (StepperDirection.VERTICAL == direction) {
                this.content.setOrder(this.activeStepNumber + 1);
            } else {
                this.content.setOrder(Integer.MAX_VALUE);
            }
        }
        return this;
    }

    public Stepper next() {
        int activeStepIndex = this.steps.indexOf(activeStep);
        if (activeStepIndex < (this.steps.size() - 1)) {
            Step nextActiveStep = getNextActiveStep();
            if (!nextActiveStep.equals(activeStep)) {
                this.activeStepNumber = (steps.indexOf(nextActiveStep) * 2) + 1;
                this.activeStep.deactivate(step -> {
                    this.activeStep = nextActiveStep;
                    this.activeStep.activate();
                    if (StepperDirection.VERTICAL == this.direction) {
                        this.content.setOrder(this.activeStepNumber + 1);
                    }
                });
            }
        }
        return this;
    }

    private Step getNextActiveStep() {
        int currentStepIndex = this.steps.indexOf(activeStep);
        for (int i = currentStepIndex + 1; i < this.steps.size(); i++) {
            Step nextStep = steps.get(i);
            if (StepState.DISABLED != nextStep.getState()) {
                return nextStep;
            }
        }
        return activeStep;
    }

    public Stepper previouse() {
        int activeStepIndex = this.steps.indexOf(activeStep);
        if (activeStepIndex > 0) {
            Step prevActiveStep = getPrevActiveStep();
            if (!prevActiveStep.equals(activeStep)) {
                this.activeStep.deactivate(step -> {
                    this.activeStep = prevActiveStep;
                    this.activeStep.activate();
                    this.activeStepNumber = (steps.indexOf(prevActiveStep) * 2) + 1;
                    if (StepperDirection.VERTICAL == this.direction) {
                        this.content.setOrder(this.activeStepNumber + 1);
                    }
                });
            }
        }
        return this;
    }

    private Step getPrevActiveStep() {
        int currentStepIndex = this.steps.indexOf(activeStep);
        for (int i = currentStepIndex - 1; i >= 0; i--) {
            Step prevStep = steps.get(i);
            if (StepState.DISABLED != prevStep.getState()) {
                return prevStep;
            }
        }
        return activeStep;
    }

    public Stepper setBarColor(Color color) {
        steps.forEach(step -> step.setBarColor(color));
        this.content.styler(style -> style.setBorderColor(color.getHex()));
        this.barColor = color;
        return this;
    }

    public Stepper addStateChangeListener(StepStateChangeListener listener) {
        if (nonNull(listener)) {
            this.stepStateChangeListeners.add(listener);
        }
        return this;
    }

    public Stepper removeStateChangeListener(StepStateChangeListener listener) {
        if (nonNull(listener)) {
            this.stepStateChangeListeners.remove(listener);
        }
        return this;
    }

    public List<StepStateChangeListener> getStepStateChangeListeners() {
        return stepStateChangeListeners;
    }

    public Stepper addCompleteListener(StepperCompleteListener listener) {
        if (nonNull(listener)) {
            this.completeListeners.add(listener);
        }
        return this;
    }

    public Stepper removeCompleteListener(StepperCompleteListener listener) {
        if (nonNull(listener)) {
            this.completeListeners.remove(listener);
        }
        return this;
    }

    public List<StepperCompleteListener> getCompleteListeners() {
        return completeListeners;
    }

    public Transition getActivateStepTransition() {
        return activateStepTransition;
    }

    public Stepper setActivateStepTransition(Transition activateStepTransition) {
        if (nonNull(activateStepTransition)) {
            this.activateStepTransition = activateStepTransition;
        }
        return this;
    }

    public Transition getDeactivateStepTransition() {
        return deactivateStepTransition;
    }

    public Stepper setDeactivateStepTransition(Transition deactivateStepTransition) {
        if (nonNull(deactivateStepTransition)) {
            this.deactivateStepTransition = deactivateStepTransition;
        }
        return this;
    }

    public int getActivateStepTransitionDuration() {
        return activateStepTransitionDuration;
    }

    public Stepper setActivateStepTransitionDuration(int activateStepTransitionDuration) {
        this.activateStepTransitionDuration = activateStepTransitionDuration;
        return this;
    }

    public int getDeactivateStepTransitionDuration() {
        return deactivateStepTransitionDuration;
    }

    public Stepper setDeactivateStepTransitionDuration(int deactivateStepTransitionDuration) {
        this.deactivateStepTransitionDuration = deactivateStepTransitionDuration;
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    public List<Step> getSteps() {
        return steps;
    }

    public FlexItem getStepContentFlexItem() {
        return stepContentFlexItem;
    }

    public StepStateColors getStepStateColors() {
        return this.stepStateColors;
    }

    public StepNumberRenderer getStepNumberRenderer() {
        return this.stepNumberRenderer;
    }

    public Step getActiveStep() {
        return this.activeStep;
    }

    public enum StepperDirection {
        HORIZONTAL(FlexDirection.LEFT_TO_RIGHT, HORIZONTAL_STEPPER), VERTICAL(FlexDirection.TOP_TO_BOTTOM, VERTICAL_STEPPER);

        private FlexDirection flexDirection;
        private String style;

        StepperDirection(FlexDirection flexDirection, String style) {
            this.flexDirection = flexDirection;
            this.style = style;
        }

        public FlexDirection getFlexDirection() {
            return flexDirection;
        }

        public String getStyle() {
            return style;
        }
    }

    public interface StepStateChangeListener {
        void onStateChanged(StepState oldState, Step step, Stepper stepper);
    }

    public interface StepStateColors {
        Color inactive();

        Color active();

        Color error();

        Color completed();

        Color disabled();
    }

    private static final class StepStateColorsImpl implements StepStateColors {
        private Color inactive;
        private Color active;
        private Color error;
        private Color completed;
        private Color disabled;

        public StepStateColorsImpl(Color inactive, Color active, Color error, Color completed, Color disabled) {
            this.inactive = inactive;
            this.active = active;
            this.error = error;
            this.completed = completed;
            this.disabled = disabled;
        }

        public void setInactive(Color inactive) {
            this.inactive = inactive;
        }

        public void setActive(Color active) {
            this.active = active;
        }

        public void setError(Color error) {
            this.error = error;
        }

        public void setCompleted(Color completed) {
            this.completed = completed;
        }

        public void setDisabled(Color disabled) {
            this.disabled = disabled;
        }

        @Override
        public Color inactive() {
            return inactive;
        }

        @Override
        public Color active() {
            return active;
        }

        @Override
        public Color error() {
            return error;
        }

        @Override
        public Color completed() {
            return completed;
        }

        @Override
        public Color disabled() {
            return disabled;
        }
    }

    public interface StepNumberRenderer {
        Node inactiveElement(Step step, StepStateColors stepStateColors);

        Node activeElement(Step step, StepStateColors stepStateColors);

        Node errorElement(Step step, StepStateColors stepStateColors);

        Node completedElement(Step step, StepStateColors stepStateColors);

        Node disabledElement(Step step, StepStateColors stepStateColors);
    }

    public enum StepState {
        ACTIVE(STEP_ACTIVE), INACTIVE(STEP_INACTIVE), ERROR(STEP_ERROR), COMPLETED(STEP_COMPLETED), DISABLED(STEP_DISABLED);

        private String style;

        StepState(String style) {
            this.style = style;
        }

        public Node render(Step step, StepStateColors colors, StepNumberRenderer stepNumberRenderer) {
            switch (step.getState()) {
                case ACTIVE:
                    return stepNumberRenderer.activeElement(step, colors);
                case ERROR:
                    return stepNumberRenderer.errorElement(step, colors);
                case COMPLETED:
                    return stepNumberRenderer.completedElement(step, colors);
                case DISABLED:
                    return stepNumberRenderer.disabledElement(step, colors);
                case INACTIVE:
                default:
                    return stepNumberRenderer.inactiveElement(step, colors);
            }
        }

        public String getStyle() {
            return style;
        }
    }

    public interface StepperCompleteListener {
        void onComplete(Stepper stepper);
    }

}
