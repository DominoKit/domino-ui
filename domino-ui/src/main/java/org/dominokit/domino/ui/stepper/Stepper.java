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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.elementOf;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Represents a UI component that offers a visual representation of a sequence of steps, allowing
 * users to navigate through them.
 *
 * <p>Usage:
 *
 * <pre>
 * Stepper stepper = Stepper.create();
 * stepper.appendChild(step1).appendChild(step2).start();
 * </pre>
 *
 * @see Step
 * @see StepperConfig
 * @see BaseDominoElement
 */
public class Stepper extends BaseDominoElement<HTMLDivElement, Stepper>
    implements StepperStyles, HasComponentConfig<StepperConfig> {
  private final DivElement root;
  private final StepperTrack stepperTrack;
  private final DivElement stepperContent;
  private final List<Step> steps = new ArrayList<>();

  private DivElement finishContent = div();

  /** Creates a new instance of {@link Stepper}. */
  public Stepper() {
    root =
        div()
            .addCss(dui_stepper)
            .appendChild(stepperTrack = StepperTrack.create())
            .appendChild(stepperContent = div().addCss(dui_stepper_content));
    init(this);
  }

  /**
   * Static factory method for creating a new instance of {@link Stepper}.
   *
   * @return a new instance of {@link Stepper}
   */
  public static Stepper create() {
    return new Stepper();
  }

  /**
   * Appends the provided step to this stepper.
   *
   * @param step the step to be appended
   * @return this stepper
   */
  public Stepper appendChild(Step step) {
    stepperContent.appendChild(step);
    stepperTrack.appendChild(step.getStepTracker());
    step.bindToStepper(this);
    steps.add(step);
    return this;
  }

  public Stepper appendChild(Step... steps) {
    Arrays.stream(steps).forEach(this::appendChild);
    return this;
  }

  /**
   * Removes the provided step from this stepper.
   *
   * @param step the step to be removed
   * @return this stepper
   */
  public Stepper removeStep(Step step) {
    step.remove();
    stepperTrack.removeTracker(step.getStepTracker());
    step.unbindStepper();
    steps.remove(step);
    return this;
  }

  /**
   * Navigates to the next step in this stepper.
   *
   * @return this stepper
   */
  public Stepper next() {
    return next(0);
  }

  /**
   * Navigates to the next step in the stepper by skipping the specified number of steps.
   *
   * @param skip the number of steps to skip before moving to the next one
   * @return this stepper
   */
  public Stepper next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  /**
   * Navigates to the next step in the stepper and accepts a {@link
   * StepperTrack.StepTrackersConsumer} to consume step trackers during the navigation.
   *
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper next(StepperTrack.StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  /**
   * Navigates to the next step in the stepper by skipping the specified number of steps and accepts
   * a {@link StepperTrack.StepTrackersConsumer} to consume step trackers during the navigation.
   *
   * @param skip the number of steps to skip before moving to the next one
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper next(int skip, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.next(skip, consumer);
    return this;
  }

  /**
   * Navigates to the previous step in the stepper.
   *
   * @return this stepper
   */
  public Stepper prev() {
    return prev(0);
  }

  /**
   * Navigates to the previous step in the stepper and accepts a {@link
   * StepperTrack.StepTrackersConsumer} to consume step trackers during the navigation.
   *
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper prev(StepperTrack.StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  /**
   * Navigates to the previous step in the stepper by skipping the specified number of steps.
   *
   * @param skip the number of steps to skip before moving to the previous one
   * @return this stepper
   */
  public Stepper prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  /**
   * Navigates to the previous step in the stepper by skipping the specified number of steps and
   * accepts a {@link StepperTrack.StepTrackersConsumer} to consume step trackers during the
   * navigation.
   *
   * @param skip the number of steps to skip before moving to the previous one
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.prev(skip, consumer);
    return this;
  }

  /**
   * Starts the stepper with the default step state defined in the configuration.
   *
   * @return this stepper
   */
  public Stepper start() {
    return start(getConfig().getDefaultStepState(), (deactivated, activated) -> {});
  }

  /**
   * Starts the stepper with the specified start state.
   *
   * @param startState the state to start the stepper with
   * @return this stepper
   */
  public Stepper start(StepState startState) {
    return start(startState, (deactivated, activated) -> {});
  }

  /**
   * Starts the stepper with the specified start state and accepts a {@link
   * StepperTrack.StepTrackersConsumer} to consume step trackers during the start process.
   *
   * @param startState the state to start the stepper with
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper start(StepState startState, StepperTrack.StepTrackersConsumer consumer) {
    elementOf(this.finishContent).remove();
    this.stepperTrack.start(startState, consumer);
    return this;
  }

  /**
   * Allows customization of the stepper's track using the provided handler.
   *
   * @param handler a handler to customize the stepper's track
   * @return this stepper
   */
  public Stepper withStepperTrack(ChildHandler<Stepper, StepperTrack> handler) {
    handler.apply(this, stepperTrack);
    return this;
  }

  /**
   * Allows customization of the stepper's content using the provided handler.
   *
   * @param handler a handler to customize the stepper's content
   * @return this stepper
   */
  public Stepper withStepperContent(ChildHandler<Stepper, DivElement> handler) {
    handler.apply(this, stepperContent);
    return this;
  }

  /**
   * Allows customization of the stepper's steps using the provided handler.
   *
   * @param handler a handler to customize the steps in the stepper
   * @return this stepper
   */
  public Stepper withSteps(ChildHandler<Stepper, List<Step>> handler) {
    handler.apply(this, steps);
    return this;
  }

  /**
   * Finishes the stepper with the specified finish state and accepts a {@link
   * StepperTrack.StepTrackersConsumer} to consume step trackers during the finish process.
   *
   * @param finishState the final state of the stepper
   * @param consumer the consumer to handle step trackers
   * @return this stepper
   */
  public Stepper finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.finish(finishState, consumer);
    this.stepperContent.appendChild(finishContent);
    return this;
  }

  /**
   * Finishes the stepper with the specified finish state.
   *
   * @param finishState the final state of the stepper
   * @return this stepper
   */
  public Stepper finish(StepState finishState) {
    finish(finishState, (deactivated, activated) -> {});
    return this;
  }

  /**
   * Allows customization of the stepper's finish content using the provided handler.
   *
   * @param handler a handler to customize the finish content of the stepper
   * @return this stepper
   */
  public Stepper withFinishContent(ChildHandler<Stepper, DivElement> handler) {
    handler.apply(this, finishContent);
    return this;
  }

  /**
   * Resets the stepper to the specified start state and accepts a {@link Consumer} to consume steps
   * during the reset process.
   *
   * @param startState the state to reset the stepper to
   * @param stepsConsumer the consumer to handle steps during the reset
   * @return this stepper
   */
  public Stepper reset(StepState startState, Consumer<List<Step>> stepsConsumer) {
    stepsConsumer.accept(this.steps);
    start(startState);
    return this;
  }

  /**
   * Hide/Show the last step tail
   *
   * @param hide boolean to hide/show the last step tail
   * @return same StepperTrack instance
   */
  public Stepper setHideStepperTail(boolean hide) {
    stepperTrack.setHideStepperTail(hide);
    return this;
  }

  /** @return true if the stepper last step tail is hidden. */
  public boolean isStepperTailHidden() {
    return stepperTrack.isStepperTailHidden();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
