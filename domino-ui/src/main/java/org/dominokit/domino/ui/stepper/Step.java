package org.dominokit.domino.ui.stepper;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasValidation;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.stepper.StepperStyles.*;
import static org.jboss.elemento.Elements.span;

public class Step extends BaseDominoElement<HTMLDivElement, Step> implements HasValidation<Step> {

    private final DominoElement<HTMLElement> titleSpan;
    private final DominoElement<HTMLElement> descriptionSpan;
    private final DominoElement<HTMLElement> horizontalBarSpan;
    private final DominoElement<HTMLElement> verticalBarSpan;
    private final FlexItem errorMessagesFlexItem;
    private final FlexLayout header;
    private final DominoElement<HTMLDivElement> content;
    private Stepper stepper;
    private final FlexItem root = FlexItem.create()
            .css(STEP_HEADER);

    private int stepNumber;
    private Color barColor = Color.GREY;

    private final List<Stepper.StepStateChangeListener> stepStateChangeListeners;
    private final List<Validator> validators = new ArrayList<>();
    private final List<String> errors = new ArrayList<>();

    private Stepper.StepState state;
    private Stepper.StepState nonErrorState;
    private FlexItem stepNumberFlexItem;

    public static Step create(String title) {
        return new Step(title);
    }

    public static Step create(String title, String description) {
        return new Step(title, description);
    }

    public Step(String title, String description) {
        this(title);
        setDescription(description);
    }

    public Step(String title) {
        init(this);
        state = Stepper.StepState.INACTIVE;
        nonErrorState = Stepper.StepState.INACTIVE;
        this.stepStateChangeListeners = new ArrayList<>();
        this.titleSpan = DominoElement.of(span());
        this.descriptionSpan = DominoElement.of(span()).hide();
        this.horizontalBarSpan = DominoElement.of(span().css(barColor.getBackground()));
        this.verticalBarSpan = DominoElement.of(span().css(barColor.getBackground()));
        this.header = FlexLayout.create();
        this.content = DominoElement.div();

        errorMessagesFlexItem = FlexItem.create();
        stepNumberFlexItem = FlexItem.create();
        root.appendChild(header
                .appendChild(FlexItem.create()
                        .appendChild(FlexLayout.create()
                                .css(STEP_NUMBER_CNTR)
                                .setDirection(FlexDirection.TOP_TO_BOTTOM)
                                .appendChild(stepNumberFlexItem
                                        .css(STEP_NUMBER)
                                )
                                .appendChild(FlexItem.create()
                                        .setFlexGrow(1)
                                        .css(STEP_VERTICAL_BAR)
                                        .appendChild(verticalBarSpan)
                                )
                        )
                )
                .appendChild(FlexItem.create()
                        .css(STEP_TITLE_CNTR)
                        .setFlexGrow(1)
                        .appendChild(FlexLayout.create()
                                .css(STEP_MAIN_TITLE_CNTR)
                                .setDirection(FlexDirection.TOP_TO_BOTTOM)
                                .appendChild(FlexItem.create()
                                        .appendChild(FlexLayout.create()
                                                .appendChild(FlexItem.create()
                                                        .css(STEP_TITLE)
                                                        .appendChild(titleSpan.setTextContent(title))
                                                )
                                                .appendChild(FlexItem.create()
                                                        .css(STEP_HORIZONTAL_BAR)
                                                        .setFlexGrow(1)
                                                        .appendChild(horizontalBarSpan)
                                                )
                                        )
                                )
                                .appendChild(FlexItem.create()
                                        .setFlexGrow(1)
                                        .css(STEP_DESCRIPTION)
                                        .appendChild(descriptionSpan)
                                )
                                .appendChild(errorMessagesFlexItem
                                        .setFlexGrow(1)
                                        .css(STEP_ERRORS)
                                )
                        )
                )
        );

        root.appendChild(header);
    }

    public Step setTitle(String title) {
        this.titleSpan.setTextContent(title);
        return this;
    }

    public String getTitle() {
        return titleSpan.element().textContent;
    }

    public Step setDescription(String description) {
        if (nonNull(description) && !description.isEmpty()) {
            this.descriptionSpan.setTextContent(description);
            this.descriptionSpan.show();
        } else {
            this.descriptionSpan.setTextContent("");
            this.descriptionSpan.hide();
        }
        return this;
    }

    public Step appendChild(IsElement<?> element) {
        this.content.appendChild(element);
        return this;
    }

    public Step appendChild(Node node) {
        this.content.appendChild(node);
        return this;
    }

    public String getDescription() {
        return this.descriptionSpan.getTextContent();
    }

    public Step setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
        renderNumber();
        this.root.setOrder(stepNumber + stepNumber - 1);
        return this;
    }

    public int getStepNumber() {
        return this.stepNumber;
    }

    Step activate() {
        if (stepper.getSteps().isEmpty()) {
            this.stepper.getStepContentFlexItem().setContent(this.content);
            setState(Stepper.StepState.ACTIVE);
        } else {
            this.content.hide();
            this.stepper.getStepContentFlexItem().setContent(this.content);
            Animation.create(this.content)
                    .duration(stepper.getActivateStepTransitionDuration())
                    .transition(stepper.getActivateStepTransition())
                    .beforeStart(element -> this.content.show())
                    .callback(element -> {
                        setState(Stepper.StepState.ACTIVE);
                    })
                    .animate();
        }
        return this;
    }

    private void setState(Stepper.StepState state, boolean forceState) {
        if ((this.state != Stepper.StepState.DISABLED || forceState) && (getErrors().isEmpty() || forceState)) {
            Stepper.StepState oldState = this.state;
            this.removeCss(this.state.getStyle());
            this.state = state;
            this.css(this.state.getStyle());
            if (Stepper.StepState.ERROR != state) {
                this.nonErrorState = state;
            }
            if (nonNull(stepper)) {
                renderNumber();
                stepStateChangeListeners.forEach(listener -> listener.onStateChanged(oldState, this, this.stepper));
                stepper.getStepStateChangeListeners().forEach(listener -> listener.onStateChanged(oldState, this, this.stepper));
            }
        }
    }

    private void setState(Stepper.StepState state) {
        setState(state, false);
    }

    void renderNumber() {
        if (nonNull(stepper)) {
            this.stepNumberFlexItem.setContent(this.state.render(this, stepper.getStepStateColors(), stepper.getStepNumberRenderer()));
        }
    }

    Step deactivate(Consumer<Step> handler) {
        Animation.create(this.content)
                .duration(stepper.getDeactivateStepTransitionDuration())
                .transition(stepper.getDeactivateStepTransition())
                .callback(element -> {
                    if (Stepper.StepState.COMPLETED != state) {
                        setState(Stepper.StepState.INACTIVE);
                    }
                    handler.accept(this);
                })
                .animate();

        return this;
    }

    public Step complete() {
        this.clearInvalid();
        int stepIndex = stepper.getSteps().indexOf(this);
        if (stepIndex < (stepper.getSteps().size() - 1) && stepIndex <= stepper.getSteps().indexOf(stepper.getActiveStep())) {
            stepper.next();
        }
        setState(Stepper.StepState.COMPLETED);
        return this;
    }

    @Override
    public Step disable() {
        return setDisabled();
    }

    @Override
    public Step enable() {
        return setEnabled(Stepper.StepState.INACTIVE);
    }

    public Step setDisabled() {
        setState(Stepper.StepState.DISABLED);
        return this;
    }

    public Step setEnabled(Stepper.StepState targetState) {
        setState(targetState, true);
        return this;
    }

    void setStepper(Stepper stepper) {
        this.stepper = stepper;
        renderNumber();
    }

    void setBarColor(Color barColor) {
        this.horizontalBarSpan.removeCss(this.barColor.getBackground());
        this.verticalBarSpan.removeCss(this.barColor.getBackground());
        this.barColor = barColor;
        this.horizontalBarSpan.css(this.barColor.getBackground());
        this.verticalBarSpan.css(this.barColor.getBackground());
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    @Override
    public ValidationResult validate() {
        clearInvalid();
        for (Validator validator : validators) {
            ValidationResult result = validator.isValid();
            if (!result.isValid()) {
                invalidate(result.getErrorMessage());
                return result;
            }
        }
        return ValidationResult.valid();
    }

    @Override
    public List<ValidationResult> validateAll() {
        clearInvalid();
        List<ValidationResult> validationResults = validators.stream()
                .map(Validator::isValid)
                .collect(Collectors.toList());
        List<String> errorMessages = validationResults.stream()
                .filter(validationResult -> !validationResult.isValid())
                .map(ValidationResult::getErrorMessage)
                .collect(Collectors.toList());

        if (!errorMessages.isEmpty()) {
            invalidate(errorMessages);
        }
        return validationResults;
    }

    @Override
    public Step addValidator(Validator validator) {
        if (nonNull(validator)) {
            validators.add(validator);
        }
        return this;
    }

    @Override
    public Step removeValidator(Validator validator) {
        if (nonNull(validator)) {
            validators.remove(validator);
        }
        return this;
    }

    @Override
    public boolean hasValidator(Validator validator) {
        return validators.contains(validator);
    }

    @Override
    public Step invalidate(String errorMessage) {
        return invalidate(Collections.singletonList(errorMessage));
    }

    @Override
    public Step invalidate(List<String> errorMessages) {
        clearInvalid();
        if (nonNull(errorMessages) && !errorMessages.isEmpty()) {
            setState(Stepper.StepState.ERROR, true);
            errorMessagesFlexItem
                    .css(STEP_INVALID)
                    .apply(self -> errorMessages.forEach(errorMessage -> self.appendChild(span().textContent(errorMessage))));
            this.errors.addAll(errorMessages);
        } else {
            setState(this.nonErrorState);
        }
        return this;
    }

    @Override
    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    @Override
    public Step clearInvalid() {
        setState(nonErrorState);
        this.errors.clear();
        this.errorMessagesFlexItem.clearElement();
        this.removeCss(STEP_INVALID);
        return this;
    }

    public Stepper getStepper() {
        return stepper;
    }

    public Step addStateChangeListener(Stepper.StepStateChangeListener listener) {
        if (nonNull(listener)) {
            this.stepStateChangeListeners.add(listener);
        }
        return this;
    }

    public Step removeStateChangeListener(Stepper.StepStateChangeListener listener) {
        if (nonNull(listener)) {
            this.stepStateChangeListeners.remove(listener);
        }
        return this;
    }

    void setFlexGrow(int flexGrow) {
        root.setFlexGrow(flexGrow);
    }

    public List<Stepper.StepStateChangeListener> getStepStateChangeListeners() {
        return stepStateChangeListeners;
    }

    public int getIndex() {
        return this.stepper.getSteps().indexOf(this);
    }

    public boolean isFirstStep() {
        return getIndex() == 0;
    }

    public boolean isLastStep() {
        return getIndex() == stepper.getSteps().size() - 1;
    }

    public Stepper.StepState getState() {
        return this.state;
    }

    public boolean isActive() {
        return Stepper.StepState.ACTIVE == this.state;
    }
}
