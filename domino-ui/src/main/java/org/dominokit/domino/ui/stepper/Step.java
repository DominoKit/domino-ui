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
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_active;

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

/**
 * Represents an individual step within a Stepper.
 *
 * <p>Usage example:
 *
 * <pre>
 * Step step = Step.create("Step 1")
 *              .withHeader((step, header) -> ...)
 *              .withContent((step, content) -> ...);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Step extends BaseDominoElement<HTMLDivElement, Step>
    implements StepperStyles, HasComponentConfig<StepperConfig> {

  private final DivElement root;
  private final NavBar stepHeader;
  private final DivElement stepContent;
  private final StepTracker stepTracker;
  private LazyChild<DivElement> stepFooter;
  private StepState state;
  private Stepper stepper;

  /**
   * Constructs a new step with the provided title.
   *
   * @param title the title for the step
   */
  public Step(String title) {
    this.state = getConfig().getDefaultStepState();
    root =
        div()
            .addCss(dui_stepper_step)
            .appendChild(stepHeader = NavBar.create(title).addCss(dui_step_header))
            .appendChild(stepContent = div().addCss(dui_step_content));
    stepFooter = LazyChild.of(div().addCss(dui_step_footer), root);
    stepTracker =
        StepTracker.create()
            .applyMeta(StepMeta.of(this))
            .addStateListener((tracker, trackerState) -> setStepState(tracker));
    init(this);
  }

  /**
   * Factory method to create a new step.
   *
   * @return a new Step instance
   */
  public static Step create() {
    return create("");
  }

  /**
   * Factory method to create a new step.
   *
   * @param title the title for the step
   * @return a new Step instance
   */
  public static Step create(String title) {
    return new Step(title);
  }

  /**
   * Updates the state of this step based on the given tracker.
   *
   * <p>This method is primarily for internal use to keep the state of the step in sync with the
   * associated tracker.
   *
   * @param tracker the step tracker
   */
  private void setStepState(StepTracker tracker) {
    this.state = tracker.getState();
    addCss(BooleanCssClass.of(dui_active, tracker.isActive()));
  }

  /**
   * Configures the header of this step using the given handler.
   *
   * @param handler the handler to customize the header
   * @return the current step instance for chaining
   */
  public Step withHeader(ChildHandler<Step, NavBar> handler) {
    handler.apply(this, stepHeader);
    return this;
  }

  /**
   * Configures the footer of this step using the given handler.
   *
   * @param handler the handler to customize the footer
   * @return the current step instance for chaining
   */
  public Step withFooter(ChildHandler<Step, DivElement> handler) {
    handler.apply(this, stepFooter.get());
    return this;
  }

  /**
   * Configures the content of this step using the given handler.
   *
   * @param handler the handler to customize the content
   * @return the current step instance for chaining
   */
  public Step withContent(ChildHandler<Step, DivElement> handler) {
    handler.apply(this, stepContent);
    return this;
  }

  /**
   * Configures the step tracker of this step using the given handler.
   *
   * @param handler the handler to customize the step tracker
   * @return the current step instance for chaining
   */
  public Step withTracker(ChildHandler<Step, StepTracker> handler) {
    handler.apply(this, stepTracker);
    return this;
  }

  /**
   * Returns the tracker associated with this step.
   *
   * @return the associated step tracker
   */
  public StepTracker getStepTracker() {
    return stepTracker;
  }

  /**
   * Binds this step to a specific {@link Stepper}.
   *
   * <p>This method associates the step with a stepper, allowing it to be managed and controlled by
   * that stepper.
   *
   * @param stepper the stepper to bind this step to
   */
  void bindToStepper(Stepper stepper) {
    this.stepper = stepper;
    setState(this.state);
  }

  /**
   * Sets the current state of this step.
   *
   * <p>This method updates the state of the step and reflects any associated changes on the step
   * tracker.
   *
   * @param state the new state for the step
   * @return the current step instance for chaining
   */
  public Step setState(StepState state) {
    this.stepTracker.setState(state);
    return this;
  }

  /**
   * Unbinds this step from its associated {@link Stepper}.
   *
   * <p>After calling this method, the step is no longer controlled by any stepper.
   */
  void unbindStepper() {
    this.stepper = null;
  }

  /**
   * Advances to the next step.
   *
   * @return the updated step
   */
  public Step next() {
    return next(0);
  }

  /**
   * Navigates to the next step with a specific number of steps to skip.
   *
   * <p>This method delegates the navigation to the associated {@link Stepper}.
   *
   * @param skip the number of steps to skip
   * @return the current step instance for chaining
   */
  public Step next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  /**
   * Navigates to the next step with a provided consumer for managing step trackers.
   *
   * @param consumer the consumer that gets notified about deactivated and activated trackers
   * @return the current step instance for chaining
   */
  public Step next(StepperTrack.StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  /**
   * Navigates to the next step with a specific number of steps to skip and a consumer.
   *
   * @param skip the number of steps to skip
   * @param consumer the consumer for the step trackers
   * @return the current step instance for chaining
   */
  public Step next(int skip, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.next(skip, consumer);
    }
    return this;
  }

  /**
   * Navigates to the previous step.
   *
   * @return the current step instance for chaining
   */
  public Step prev() {
    return prev(0);
  }

  /**
   * Navigates to the previous step with a provided consumer for managing step trackers.
   *
   * @param consumer the consumer for the step trackers
   * @return the current step instance for chaining
   */
  public Step prev(StepperTrack.StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  /**
   * Navigates to the previous step with a specific number of steps to skip.
   *
   * @param skip the number of steps to skip
   * @return the current step instance for chaining
   */
  public Step prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  /**
   * Navigates to the previous step with a specific number of steps to skip and a consumer.
   *
   * @param skip the number of steps to skip
   * @param consumer the consumer for the step trackers
   * @return the current step instance for chaining
   */
  public Step prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.prev(skip, consumer);
    }
    return this;
  }

  /**
   * Completes the step and triggers any finish-related actions using the provided state and
   * consumer.
   *
   * @param finishState the state to set upon finishing
   * @param consumer the consumer for the step trackers
   * @return the current step instance for chaining
   */
  public Step finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.finish(finishState, consumer);
    }
    return this;
  }

  /**
   * Completes the step using the provided state.
   *
   * @param finishState the state to set upon finishing
   * @return the current step instance for chaining
   */
  public Step finish(StepState finishState) {
    finish(finishState, (deactivated, activated) -> {});
    return this;
  }

  /**
   * Retrieves the underlying element representation of the step.
   *
   * @return the step's element
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Returns the element to which new children will be appended.
   *
   * @return the append target element
   */
  @Override
  public Element getAppendTarget() {
    return stepContent.element();
  }
}
