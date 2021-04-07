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
package org.dominokit.domino.ui.stepper;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.stepper.StepperStyles.*;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
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

/** A component that is a single step inside a {@link Stepper} */
public class Step extends BaseDominoElement<HTMLDivElement, Step> implements HasValidation<Step> {

  private final DominoElement<HTMLElement> titleSpan;
  private final DominoElement<HTMLElement> descriptionSpan;
  private final DominoElement<HTMLElement> horizontalBarSpan;
  private final DominoElement<HTMLElement> verticalBarSpan;
  private final FlexItem<HTMLDivElement> errorMessagesFlexItem;
  private final FlexLayout header;
  private final DominoElement<HTMLDivElement> content;
  private Stepper stepper;
  private final FlexItem<HTMLDivElement> root = FlexItem.create().css(STEP_HEADER);

  private int stepNumber;
  private Color barColor = Color.GREY;

  private final List<Stepper.StepStateChangeListener> stepStateChangeListeners;
  private final List<Validator> validators = new ArrayList<>();
  private final List<String> errors = new ArrayList<>();

  private Stepper.StepState state;
  private Stepper.StepState nonErrorState;
  private FlexItem<HTMLDivElement> stepNumberFlexItem;
  private Stepper.StepState initialState;

  /**
   * @param title String title of the step
   * @return new Step instance
   */
  public static Step create(String title) {
    return new Step(title);
  }

  /**
   * @param title String title of the step
   * @param description String to describe the step that show up under the title
   * @return new Step instance
   */
  public static Step create(String title, String description) {
    return new Step(title, description);
  }

  /**
   * @param title String title of the step
   * @param description String to describe the step that show up under the title
   * @param initialState {@link Stepper.StepState} to be used by default as the step state
   * @return new Step instance
   */
  public static Step create(String title, String description, Stepper.StepState initialState) {
    return new Step(title, description, initialState);
  }

  /**
   * @param title String title of the step
   * @param description String to describe the step that show up under the title
   * @param initialState {@link Stepper.StepState} to be used by default as the step state
   */
  public Step(String title, String description, Stepper.StepState initialState) {
    init(this);
    this.initialState = initialState;
    this.state = Stepper.StepState.INACTIVE;
    this.nonErrorState = Stepper.StepState.INACTIVE;
    this.stepStateChangeListeners = new ArrayList<>();
    this.titleSpan = DominoElement.of(span());
    this.descriptionSpan = DominoElement.of(span()).hide();
    this.setDescription(description);
    this.horizontalBarSpan = DominoElement.of(span().css(barColor.getBackground()));
    this.verticalBarSpan = DominoElement.of(span().css(barColor.getBackground()));
    this.header = FlexLayout.create();
    this.content = DominoElement.div();

    this.errorMessagesFlexItem = FlexItem.create();
    this.stepNumberFlexItem = FlexItem.create();
    this.root.appendChild(
        header
            .appendChild(
                FlexItem.create()
                    .appendChild(
                        FlexLayout.create()
                            .css(STEP_NUMBER_CNTR)
                            .setDirection(FlexDirection.TOP_TO_BOTTOM)
                            .appendChild(stepNumberFlexItem.css(STEP_NUMBER))
                            .appendChild(
                                FlexItem.create()
                                    .setFlexGrow(1)
                                    .css(STEP_VERTICAL_BAR)
                                    .appendChild(verticalBarSpan))))
            .appendChild(
                FlexItem.create()
                    .css(STEP_TITLE_CNTR)
                    .setFlexGrow(1)
                    .appendChild(
                        FlexLayout.create()
                            .css(STEP_MAIN_TITLE_CNTR)
                            .setDirection(FlexDirection.TOP_TO_BOTTOM)
                            .appendChild(
                                FlexItem.create()
                                    .appendChild(
                                        FlexLayout.create()
                                            .appendChild(
                                                FlexItem.create()
                                                    .css(STEP_TITLE)
                                                    .appendChild(titleSpan.setTextContent(title)))
                                            .appendChild(
                                                FlexItem.create()
                                                    .css(STEP_HORIZONTAL_BAR)
                                                    .setFlexGrow(1)
                                                    .appendChild(horizontalBarSpan))))
                            .appendChild(
                                FlexItem.create()
                                    .setFlexGrow(1)
                                    .css(STEP_DESCRIPTION)
                                    .appendChild(descriptionSpan))
                            .appendChild(errorMessagesFlexItem.setFlexGrow(1).css(STEP_ERRORS)))));

    this.root.appendChild(header);
  }

  /**
   * @param title String title of the step
   * @param description String to describe the step that show up under the title
   */
  public Step(String title, String description) {
    this(title, description, Stepper.StepState.INACTIVE);
  }

  /** @param title String title of the step */
  public Step(String title) {
    this(title, null);
  }

  /**
   * @param title String new title for the step
   * @return same Step instance
   */
  public Step setTitle(String title) {
    this.titleSpan.setTextContent(title);
    return this;
  }

  /** @return String */
  public String getTitle() {
    return titleSpan.element().textContent;
  }

  /**
   * @param description String new description
   * @return same Step instance
   */
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

  /** @return String */
  public String getDescription() {
    return this.descriptionSpan.getTextContent();
  }

  /** this will append the element to the step content element {@inheritDoc} */
  public Step appendChild(IsElement<?> element) {
    this.content.appendChild(element);
    return this;
  }

  /** this will append the element to the step content element {@inheritDoc} */
  public Step appendChild(Node node) {
    this.content.appendChild(node);
    return this;
  }

  /**
   * Change the order of the step in the stepper
   *
   * @param stepNumber int
   * @return same Step instance
   */
  public Step setStepNumber(int stepNumber) {
    this.stepNumber = stepNumber;
    renderNumber();
    this.root.setOrder(stepNumber + stepNumber - 1);
    return this;
  }

  /** @return int step number in the stepper */
  public int getStepNumber() {
    return this.stepNumber;
  }

  /**
   * Make the step the current active step in the stepper, this show the step content and hide other
   * steps content, this will put the step in {@link Stepper.StepState#ACTIVE}
   *
   * @return same Step instance
   */
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
          .callback(
              element -> {
                setState(Stepper.StepState.ACTIVE);
              })
          .animate();
    }
    return this;
  }

  private void setState(Stepper.StepState state, boolean forceState) {
    if ((this.state != Stepper.StepState.DISABLED || forceState)
        && (getErrors().isEmpty() || forceState)) {
      Stepper.StepState oldState = this.state;
      this.removeCss(this.state.getStyle());
      this.state = state;
      this.css(this.state.getStyle());
      if (Stepper.StepState.ERROR != state) {
        this.nonErrorState = state;
      }
      if (nonNull(stepper)) {
        renderNumber();
        stepStateChangeListeners.forEach(
            listener -> listener.onStateChanged(oldState, this, this.stepper));
        stepper
            .getStepStateChangeListeners()
            .forEach(listener -> listener.onStateChanged(oldState, this, this.stepper));
      }
    }
  }

  private void setState(Stepper.StepState state) {
    setState(state, false);
  }

  /** renders the step number based on the step state */
  void renderNumber() {
    if (nonNull(stepper)) {
      this.stepNumberFlexItem.setContent(
          this.state.render(this, stepper.getStepStateColors(), stepper.getStepNumberRenderer()));
    }
  }

  /**
   * deactivate the step and call the provided handler, this will put the step in {@link
   * Stepper.StepState#INACTIVE}
   *
   * @param handler Consumer of Step
   * @return same Step instance
   */
  Step deactivate(Consumer<Step> handler) {
    Animation.create(this.content)
        .duration(stepper.getDeactivateStepTransitionDuration())
        .transition(stepper.getDeactivateStepTransition())
        .callback(
            element -> {
              if (Stepper.StepState.COMPLETED != state) {
                setState(Stepper.StepState.INACTIVE);
              }
              handler.accept(this);
            })
        .animate();

    return this;
  }

  /**
   * Mark the step as completed
   *
   * @return same Step instance
   */
  public Step complete() {
    this.clearInvalid();
    int stepIndex = stepper.getSteps().indexOf(this);
    if (stepIndex < (stepper.getSteps().size() - 1)
        && stepIndex <= stepper.getSteps().indexOf(stepper.getActiveStep())) {
      stepper.next();
    }
    setState(Stepper.StepState.COMPLETED);
    return this;
  }

  /**
   * Revert the Step to its initial state, if initial state is not specified in the construction,
   * this will be active state for first step and inactive for other steps
   */
  void reset() {
    setState(this.initialState, true);
  }

  /** This will put the step in {@link Stepper.StepState#DISABLED} {@inheritDoc} */
  @Override
  public Step disable() {
    return setDisabled();
  }

  /**
   * This will not make the step active but will enable the step so it is clickable and can be
   * stepped into with the stepper and by default will put the step in the {@link
   * Stepper.StepState#INACTIVE} {@inheritDoc}
   */
  @Override
  public Step enable() {
    return setEnabled(Stepper.StepState.INACTIVE);
  }

  /**
   * This will put the step in {@link Stepper.StepState#DISABLED}
   *
   * @return the same Step instance
   */
  public Step setDisabled() {
    setState(Stepper.StepState.DISABLED);
    return this;
  }

  /**
   * This will put the step in {@link Stepper.StepState#ACTIVE}
   *
   * @return the same Step instance
   */
  public Step setActive() {
    if (nonNull(this.stepper)) {
      this.stepper.activateStep(this);
    }
    return this;
  }

  /**
   * This will not make the step active unless specified,but will enable the step so it is clickable
   * and can be stepped into with the stepper and will put the step in the provided state
   *
   * @param targetState {@link Stepper.StepState}
   * @return the same Step instance
   */
  public Step setEnabled(Stepper.StepState targetState) {
    setState(targetState, true);
    return this;
  }

  /** @param stepper {@link Stepper} the step belongs to */
  void setStepper(Stepper stepper) {
    this.stepper = stepper;
    renderNumber();
  }

  /** @param barColor {@link Color} of the bar connecting the step with the next step */
  void setBarColor(Color barColor) {
    this.horizontalBarSpan.removeCss(this.barColor.getBackground());
    this.verticalBarSpan.removeCss(this.barColor.getBackground());
    this.barColor = barColor;
    this.horizontalBarSpan.css(this.barColor.getBackground());
    this.verticalBarSpan.css(this.barColor.getBackground());
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** if the step is invalid it will be put in the {@link Stepper.StepState#ERROR} {@inheritDoc} */
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

  /** if the step is invalid it will be put in the {@link Stepper.StepState#ERROR} {@inheritDoc} */
  @Override
  public List<ValidationResult> validateAll() {
    clearInvalid();
    List<ValidationResult> validationResults =
        validators.stream().map(Validator::isValid).collect(Collectors.toList());
    List<String> errorMessages =
        validationResults.stream()
            .filter(validationResult -> !validationResult.isValid())
            .map(ValidationResult::getErrorMessage)
            .collect(Collectors.toList());

    if (!errorMessages.isEmpty()) {
      invalidate(errorMessages);
    }
    return validationResults;
  }

  /** {@inheritDoc} */
  @Override
  public Step addValidator(Validator validator) {
    if (nonNull(validator)) {
      validators.add(validator);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Step removeValidator(Validator validator) {
    if (nonNull(validator)) {
      validators.remove(validator);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasValidator(Validator validator) {
    return validators.contains(validator);
  }

  /** this will be put the step in the {@link Stepper.StepState#ERROR} {@inheritDoc} */
  @Override
  public Step invalidate(String errorMessage) {
    return invalidate(Collections.singletonList(errorMessage));
  }

  /** this will be put the step in the {@link Stepper.StepState#ERROR} {@inheritDoc} */
  @Override
  public Step invalidate(List<String> errorMessages) {
    clearInvalid();
    if (nonNull(errorMessages) && !errorMessages.isEmpty()) {
      setState(Stepper.StepState.ERROR, true);
      errorMessagesFlexItem
          .css(STEP_INVALID)
          .apply(
              self ->
                  errorMessages.forEach(
                      errorMessage -> self.appendChild(span().textContent(errorMessage))));
      this.errors.addAll(errorMessages);
    } else {
      setState(this.nonErrorState);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public List<String> getErrors() {
    return new ArrayList<>(errors);
  }

  /**
   * This will clear the step error and change it back to the state it had before it was
   * invalidation {@inheritDoc}
   */
  @Override
  public Step clearInvalid() {
    if (!errors.isEmpty()) {
      setState(nonErrorState);
      this.errors.clear();
      this.errorMessagesFlexItem.clearElement();
      this.removeCss(STEP_INVALID);
    }
    return this;
  }

  /** @return the {@link Stepper} this step belongs to */
  public Stepper getStepper() {
    return stepper;
  }

  /**
   * @param listener {@link Stepper.StepStateChangeListener}
   * @return same Step instance
   */
  public Step addStateChangeListener(Stepper.StepStateChangeListener listener) {
    if (nonNull(listener)) {
      this.stepStateChangeListeners.add(listener);
    }
    return this;
  }

  /**
   * @param listener {@link Stepper.StepStateChangeListener}
   * @return same Step instance
   */
  public Step removeStateChangeListener(Stepper.StepStateChangeListener listener) {
    if (nonNull(listener)) {
      this.stepStateChangeListeners.remove(listener);
    }
    return this;
  }

  /**
   * @param flexGrow int Flex grow of the flex item that is used as the root element for this step
   */
  void setFlexGrow(int flexGrow) {
    root.setFlexGrow(flexGrow);
  }

  /** @return List of all {@link Stepper.StepStateChangeListener} added to this step */
  public List<Stepper.StepStateChangeListener> getStepStateChangeListeners() {
    return stepStateChangeListeners;
  }

  /** @return int index of the step within the stepper */
  public int getIndex() {
    return this.stepper.getSteps().indexOf(this);
  }

  /** @return boolean, true if the step index is 0 */
  public boolean isFirstStep() {
    return getIndex() == 0;
  }

  /** @return boolean, true if the step is last step in the stepper */
  public boolean isLastStep() {
    return getIndex() == stepper.getSteps().size() - 1;
  }

  /** @return the current {@link Stepper.StepState} of the step */
  public Stepper.StepState getState() {
    return this.state;
  }

  /** @return boolean, true if the step state is {@link Stepper.StepState#ACTIVE} */
  public boolean isActive() {
    return Stepper.StepState.ACTIVE == this.state;
  }

  /** @return the {@link Stepper.StepState} this step was initially constructed with */
  public Stepper.StepState getInitialState() {
    return initialState;
  }

  /**
   * @param initialState {@link Stepper.StepState} to be used as default initial state for the step
   */
  public void setInitialState(Stepper.StepState initialState) {
    this.initialState = initialState;
  }
}
