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
package org.dominokit.domino.ui.shaded.stepper;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.shaded.stepper.StepperStyles.*;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.shaded.animations.Transition;
import org.dominokit.domino.ui.shaded.button.Button;
import org.dominokit.domino.ui.shaded.grid.flex.FlexDirection;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;
import org.dominokit.domino.ui.shaded.grid.flex.FlexLayout;
import org.dominokit.domino.ui.shaded.grid.flex.FlexWrap;
import org.dominokit.domino.ui.shaded.icons.Icons;
import org.dominokit.domino.ui.shaded.mediaquery.MediaQuery;
import org.dominokit.domino.ui.shaded.style.Color;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A Wizard like component that can have multiple {@link Step}s while only one step can be activated
 * at a time
 *
 * @see <a href="https://demo.dominokit.org/forms/steppers">Steppers sample</a>
 */
@Deprecated
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

  private StepNumberRenderer stepNumberRenderer =
      new StepNumberRenderer() {
        @Override
        public Node inactiveElement(Step step, StepStateColors stepStateColors) {
          return DominoElement.of(span())
              .css(stepStateColors.inactive().getBackground())
              .setTextContent(step.getStepNumber() + "")
              .element();
        }

        @Override
        public Node activeElement(Step step, StepStateColors stepStateColors) {
          return DominoElement.of(span())
              .css(stepStateColors.active().getBackground())
              .setTextContent(step.getStepNumber() + "")
              .element();
        }

        @Override
        public Node errorElement(Step step, StepStateColors stepStateColors) {
          return DominoElement.of(span())
              .css(stepStateColors.error().getBackground())
              .setTextContent(step.getStepNumber() + "")
              .element();
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
              .css(stepStateColors.disabled().getBackground())
              .element();
        }
      };

  public static Stepper create() {
    return new Stepper();
  }

  public Stepper() {
    init(this);
    stepStateColors =
        new StepStateColorsImpl(
            Color.GREY, Color.THEME, Color.RED, Color.GREEN, Color.GREY_LIGHTEN_2);
    barColor = Color.GREY;

    this.activateStepTransition = Transition.FADE_IN;
    this.deactivateStepTransition = Transition.FADE_OUT;
    this.activateStepTransitionDuration = 200;
    this.deactivateStepTransitionDuration = 200;

    root.css(direction.style, D_STEPPER).setWrap(FlexWrap.WRAP_TOP_TO_BOTTOM);

    stepContentFlexItem = FlexItem.create();
    stepFooter = FlexItem.create();
    content =
        FlexItem.create()
            .appendChild(
                FlexLayout.create()
                    .setDirection(FlexDirection.TOP_TO_BOTTOM)
                    .appendChild(stepContentFlexItem)
                    .appendChild(stepFooter));
    root.appendChild(content.setOrder(Integer.MAX_VALUE).css(STEP_CONTENT));

    setStepFooter(
        FlexLayout.create()
            .appendChild(
                FlexItem.create()
                    .appendChild(
                        Button.createPrimary(Icons.ALL.arrow_left_bold_mdi())
                            .setTextContent("Back")
                            .addClickListener(evt -> previous())))
            .appendChild(
                FlexItem.create()
                    .appendChild(
                        FlexItem.create()
                            .appendChild(
                                Button.createPrimary(Icons.ALL.arrow_right_bold_mdi())
                                    .setTextContent("Next")
                                    .addClickListener(evt -> next()))))
            .appendChild(
                FlexItem.create()
                    .appendChild(
                        FlexItem.create()
                            .appendChild(
                                Button.createPrimary(Icons.ALL.arrow_left_bold_mdi())
                                    .setTextContent("Complete")
                                    .addClickListener(evt -> completeActiveStep())))));

    setBarColor(barColor);

    MediaQuery.addOnSmallAndDownListener(
        () -> {
          forceVertical = true;
          originalDirection = this.direction;
          setDirection(this.direction);
        });
    MediaQuery.addOnMediumAndUpListener(
        () -> {
          forceVertical = false;
          setDirection(this.originalDirection);
        });
  }

  /**
   * @param stepNumberRenderer {@link StepNumberRenderer} to override the default one
   * @return same Stepper instance
   */
  public Stepper setStepNumberRenderer(StepNumberRenderer stepNumberRenderer) {
    if (nonNull(stepNumberRenderer)) {
      this.stepNumberRenderer = stepNumberRenderer;
      steps.forEach(Step::renderNumber);
    }
    return this;
  }

  /**
   * @param stepStateColors {@link StepStateColors} to override the default one
   * @return same Stepper instance
   */
  public Stepper setStepStateColors(StepStateColors stepStateColors) {
    if (nonNull(stepStateColors)) {
      this.stepStateColors = stepStateColors;
      steps.forEach(Step::renderNumber);
    }
    return this;
  }

  /**
   * @param footerElement {@link IsElement} that will be used a footer for all steps
   * @return same Stepper instance
   */
  public Stepper setStepFooter(IsElement<?> footerElement) {
    return setStepFooter(footerElement.element());
  }

  /**
   * @param footerElement {@link Node} that will be used a footer for all steps
   * @return same Stepper instance
   */
  public Stepper setStepFooter(Node footerElement) {
    stepFooter.setContent(footerElement);
    return this;
  }

  /**
   * Marks the Stepper as completed and call the stepper complete handlers
   *
   * @return same Stepper instance
   */
  public Stepper complete() {
    completeListeners.forEach(listener -> listener.onComplete(this));
    return this;
  }

  /**
   * Marks the Stepper as completed and call the stepper complete handlers
   *
   * @param completeContent {@link IsElement} to show up in the stepper as a completed indicator of
   *     to finalize the stepper process
   * @return same Stepper instance
   */
  public Stepper complete(IsElement<?> completeContent) {
    return complete(completeContent.element());
  }

  /**
   * Marks the Stepper as completed and call the stepper complete handlers
   *
   * @param completeContent {@link Node} to show up in the stepper as a completed indicator of to
   *     finalize the stepper process
   * @return same Stepper instance
   */
  public Stepper complete(Node completeContent) {
    complete();
    content.setContent(completeContent);
    getActiveStep().css("complete-content");
    return this;
  }

  /** @return the current active {@link Step} */
  public Step getCurrentStep() {
    return activeStep;
  }

  /**
   * Complete the current active step, if there is more steps this will also move the stepper to the
   * next enabled non-completed step
   *
   * @return same Stepper instance
   */
  public Stepper completeActiveStep() {
    this.activeStep.complete();
    return this;
  }

  /**
   * @param step {@link Step} to be added to this Stepper instance
   * @return same Stepper instance
   */
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

  /**
   * @param direction {@link StepperDirection}
   * @return same Stepper instance
   */
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

  /**
   * Move the stepper to the next enabled non-completed step
   *
   * @return same Stepper instance
   */
  public Stepper next() {
    int activeStepIndex = this.steps.indexOf(activeStep);
    if (activeStepIndex < (this.steps.size() - 1)) {
      activateStep(getNextActiveStep());
    }
    return this;
  }

  /**
   * @param stepToActivate {@link Step} to be activated, the step should not disabled
   * @return same Stepper instance
   */
  public Stepper activateStep(Step stepToActivate) {
    if (StepState.DISABLED != stepToActivate.getState()) {
      if (!stepToActivate.equals(activeStep)) {
        this.activeStepNumber = (steps.indexOf(stepToActivate) * 2) + 1;
        this.activeStep.deactivate(
            step -> {
              this.activeStep = stepToActivate;
              this.activeStep.activate();
              if (StepperDirection.VERTICAL == this.direction) {
                this.content.setOrder(this.activeStepNumber + 1);
              }
            });
      }
    }

    return this;
  }

  /**
   * @param index int index of the step to be activated, the step should not disabled
   * @return same Stepper instance
   */
  public Stepper activateStep(int index) {
    if (index >= 0 && index < steps.size()) {
      activateStep(steps.get(index));
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

  /**
   * Move the stepper back tp the previous step that is not disabled
   *
   * @return same Stepper instance
   */
  public Stepper previous() {
    int activeStepIndex = this.steps.indexOf(activeStep);
    if (activeStepIndex > 0) {
      Step prevActiveStep = getPrevActiveStep();
      if (!prevActiveStep.equals(activeStep)) {
        this.activeStep.deactivate(
            step -> {
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

  /**
   * @param color {@link Color} the color of the bar connecting a step with the next step
   * @return same Stepper instance
   */
  public Stepper setBarColor(Color color) {
    steps.forEach(step -> step.setBarColor(color));
    this.content.styler(style -> style.setBorderColor(color.getHex()));
    this.barColor = color;
    return this;
  }

  /**
   * Adds a listener that listen to state changes of Stepper steps
   *
   * @param listener {@link StepStateChangeListener}
   * @return same Stepper instance
   */
  public Stepper addStateChangeListener(StepStateChangeListener listener) {
    if (nonNull(listener)) {
      this.stepStateChangeListeners.add(listener);
    }
    return this;
  }

  /**
   * @param listener {@link StepStateChangeListener}
   * @return same Stepper instance
   */
  public Stepper removeStateChangeListener(StepStateChangeListener listener) {
    if (nonNull(listener)) {
      this.stepStateChangeListeners.remove(listener);
    }
    return this;
  }

  /** @return List of all {@link StepStateChangeListener}s of this Stepper */
  public List<StepStateChangeListener> getStepStateChangeListeners() {
    return stepStateChangeListeners;
  }

  /**
   * @param listener {@link StepperCompleteListener}
   * @return same Stepper instance
   */
  public Stepper addCompleteListener(StepperCompleteListener listener) {
    if (nonNull(listener)) {
      this.completeListeners.add(listener);
    }
    return this;
  }

  /**
   * @param listener {@link StepperCompleteListener}
   * @return same Stepper instance
   */
  public Stepper removeCompleteListener(StepperCompleteListener listener) {
    if (nonNull(listener)) {
      this.completeListeners.remove(listener);
    }
    return this;
  }

  /** @return a List of {@link StepperCompleteListener}s */
  public List<StepperCompleteListener> getCompleteListeners() {
    return completeListeners;
  }

  /** @return the animation {@link Transition} currently used for activating a step */
  public Transition getActivateStepTransition() {
    return activateStepTransition;
  }

  /**
   * @param activateStepTransition {@link Transition} for the animation of activating a step
   * @return same Stepper instance
   */
  public Stepper setActivateStepTransition(Transition activateStepTransition) {
    if (nonNull(activateStepTransition)) {
      this.activateStepTransition = activateStepTransition;
    }
    return this;
  }

  /** @return the animation {@link Transition} currently used for deactivating a step */
  public Transition getDeactivateStepTransition() {
    return deactivateStepTransition;
  }

  /**
   * @param deactivateStepTransition {@link Transition} for the animation of deactivating a step
   * @return same Stepper instance
   */
  public Stepper setDeactivateStepTransition(Transition deactivateStepTransition) {
    if (nonNull(deactivateStepTransition)) {
      this.deactivateStepTransition = deactivateStepTransition;
    }
    return this;
  }

  /** @return int duration in milli-seconds for activating a step animation */
  public int getActivateStepTransitionDuration() {
    return activateStepTransitionDuration;
  }

  /**
   * @param activateStepTransitionDuration int duration in milli-seconds for activating a step
   *     animation
   * @return same Stepper instance
   */
  public Stepper setActivateStepTransitionDuration(int activateStepTransitionDuration) {
    this.activateStepTransitionDuration = activateStepTransitionDuration;
    return this;
  }

  /** @return int duration in milli-seconds for deactivating a step animation */
  public int getDeactivateStepTransitionDuration() {
    return deactivateStepTransitionDuration;
  }

  /**
   * @param deactivateStepTransitionDuration int duration in milli-seconds for deactivating a step
   *     animation
   * @return same Stepper instance
   */
  public Stepper setDeactivateStepTransitionDuration(int deactivateStepTransitionDuration) {
    this.deactivateStepTransitionDuration = deactivateStepTransitionDuration;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** @return List of all {@link Step}s */
  public List<Step> getSteps() {
    return steps;
  }

  /** @return the {@link FlexItem} that wraps the active step content */
  public FlexItem getStepContentFlexItem() {
    return stepContentFlexItem;
  }

  /** @return the {@link StepStateColors} */
  public StepStateColors getStepStateColors() {
    return this.stepStateColors;
  }

  /** @return the {@link StepNumberRenderer} */
  public StepNumberRenderer getStepNumberRenderer() {
    return this.stepNumberRenderer;
  }

  /** @return the current active {@link Step} */
  public Step getActiveStep() {
    return this.activeStep;
  }

  /**
   * Activates he first step and reset all steps to the initial state
   *
   * @return
   */
  public Stepper reset() {
    steps.forEach(Step::reset);
    activateStep(0);
    return this;
  }

  /** An enum of possible Stepper directions */
  public enum StepperDirection {
    /** The steps in the Stepper header will be aligned Horizontally */
    HORIZONTAL(FlexDirection.LEFT_TO_RIGHT, HORIZONTAL_STEPPER),
    /** The steps in the Stepper header will be aligned Veritically */
    VERTICAL(FlexDirection.TOP_TO_BOTTOM, VERTICAL_STEPPER);

    private FlexDirection flexDirection;
    private String style;

    /**
     * @param flexDirection {@link FlexDirection} of the Stepper Flex layout
     * @param style String css class name for the direction
     */
    StepperDirection(FlexDirection flexDirection, String style) {
      this.flexDirection = flexDirection;
      this.style = style;
    }

    /** @return the FlexDirection */
    public FlexDirection getFlexDirection() {
      return flexDirection;
    }

    /** @return String css class name */
    public String getStyle() {
      return style;
    }
  }

  /** A function to implement listeners to be called whenever the step state is changed */
  @Deprecated
  public interface StepStateChangeListener {
    /**
     * @param oldState {@link StepState}
     * @param step {@link Step} new state can be obtained from the this step instance
     * @param stepper {@link Stepper} the step belongs to
     */
    void onStateChanged(StepState oldState, Step step, Stepper stepper);
  }

  /**
   * An interface that can implemented to provide different colors for different {@link Step} states
   * other than the default colors
   */
  @Deprecated
  public interface StepStateColors {
    /** @return the {@link Color} for inactive steps */
    Color inactive();

    /** @return the {@link Color} for active steps */
    Color active();

    /** @return the {@link Color} for steps that has validation errors */
    Color error();

    /** @return the {@link Color} for completed steps */
    Color completed();

    /** @return the {@link Color} for disabled steps */
    Color disabled();
  }

  private static final class StepStateColorsImpl implements StepStateColors {
    private Color inactive;
    private Color active;
    private Color error;
    private Color completed;
    private Color disabled;

    public StepStateColorsImpl(
        Color inactive, Color active, Color error, Color completed, Color disabled) {
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

  /** An interface to provide a different implementation for rendering steps numbers */
  @Deprecated
  public interface StepNumberRenderer {
    /**
     * Renders the number for inactive steps
     *
     * @param step {@link Step} we are rendering the number for
     * @param stepStateColors {@link StepStateColors}
     * @return the {@link Node} to be used as the step number element
     */
    Node inactiveElement(Step step, StepStateColors stepStateColors);

    /**
     * Renders the number for active steps
     *
     * @param step {@link Step} we are rendering the number for
     * @param stepStateColors {@link StepStateColors}
     * @return the {@link Node} to be used as the step number element
     */
    Node activeElement(Step step, StepStateColors stepStateColors);

    /**
     * Renders the number for steps with errors
     *
     * @param step {@link Step} we are rendering the number for
     * @param stepStateColors {@link StepStateColors}
     * @return the {@link Node} to be used as the step number element
     */
    Node errorElement(Step step, StepStateColors stepStateColors);

    /**
     * Renders the number for completed steps
     *
     * @param step {@link Step} we are rendering the number for
     * @param stepStateColors {@link StepStateColors}
     * @return the {@link Node} to be used as the step number element
     */
    Node completedElement(Step step, StepStateColors stepStateColors);

    /**
     * Renders the number for disabled steps
     *
     * @param step {@link Step} we are rendering the number for
     * @param stepStateColors {@link StepStateColors}
     * @return the {@link Node} to be used as the step number element
     */
    Node disabledElement(Step step, StepStateColors stepStateColors);
  }

  /** An enum to list the {@link Step} possible states */
  public enum StepState {
    ACTIVE(STEP_ACTIVE),
    INACTIVE(STEP_INACTIVE),
    ERROR(STEP_ERROR),
    COMPLETED(STEP_COMPLETED),
    DISABLED(STEP_DISABLED);

    private String style;

    /**
     * @param style String css class name for the state, the css class name will be applied to the
     *     step when it is in the state
     */
    StepState(String style) {
      this.style = style;
    }

    /**
     * This method will be called whenever the Step state is changed, the method will use the {@link
     * StepNumberRenderer} to render the step number based on the new step state
     *
     * @param step {@link Step} that has it is state changed
     * @param colors {@link StepStateColors}
     * @param stepNumberRenderer {@link StepNumberRenderer}
     * @return the {@link Node} to be used as the step number element
     */
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

    /** @return String css class name */
    public String getStyle() {
      return style;
    }
  }

  /** A function to implement logic that will be called when a step is marked as completed */
  @Deprecated
  public interface StepperCompleteListener {
    /** @param stepper {@link Stepper} that the completed step belongs to */
    void onComplete(Stepper stepper);
  }
}
