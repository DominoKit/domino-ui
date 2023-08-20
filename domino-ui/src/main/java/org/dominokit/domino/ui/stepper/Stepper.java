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

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/** Stepper class. */
public class Stepper extends BaseDominoElement<HTMLDivElement, Stepper>
    implements StepperStyles, HasComponentConfig<StepperConfig> {
  private final DivElement root;
  private final StepperTrack stepperTrack;
  private final DivElement stepperContent;
  private final List<Step> steps = new ArrayList<>();

  private DivElement finishContent = div();

  /** Constructor for Stepper. */
  public Stepper() {
    root =
        div()
            .addCss(dui_stepper)
            .appendChild(stepperTrack = StepperTrack.create())
            .appendChild(stepperContent = div().addCss(dui_stepper_content));
    init(this);
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public static Stepper create() {
    return new Stepper();
  }

  /**
   * appendChild.
   *
   * @param step a {@link org.dominokit.domino.ui.stepper.Step} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper appendChild(Step step) {
    stepperContent.appendChild(step);
    stepperTrack.appendChild(step.getStepTracker());
    step.bindToStepper(this);
    steps.add(step);
    return this;
  }

  /**
   * removeStep.
   *
   * @param step a {@link org.dominokit.domino.ui.stepper.Step} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper removeStep(Step step) {
    step.remove();
    stepperTrack.removeTracker(step.getStepTracker());
    step.unbindStepper();
    steps.remove(step);
    return this;
  }

  /**
   * next.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper next() {
    return next(0);
  }

  /**
   * next.
   *
   * @param skip a int
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  /**
   * next.
   *
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper next(StepperTrack.StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  /**
   * next.
   *
   * @param skip a int
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper next(int skip, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.next(skip, consumer);
    return this;
  }

  /**
   * prev.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper prev() {
    return prev(0);
  }

  /**
   * prev.
   *
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper prev(StepperTrack.StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  /**
   * prev.
   *
   * @param skip a int
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  /**
   * prev.
   *
   * @param skip a int
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.prev(skip, consumer);
    return this;
  }

  /**
   * start.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper start() {
    return start(getConfig().getDefaultStepState(), (deactivated, activated) -> {});
  }

  /**
   * start.
   *
   * @param startState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper start(StepState startState) {
    return start(startState, (deactivated, activated) -> {});
  }

  /**
   * start.
   *
   * @param startState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper start(StepState startState, StepperTrack.StepTrackersConsumer consumer) {
    elementOf(this.finishContent).remove();
    this.stepperTrack.start(startState, consumer);
    return this;
  }

  /**
   * withStepperTrack.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper withStepperTrack(ChildHandler<Stepper, StepperTrack> handler) {
    handler.apply(this, stepperTrack);
    return this;
  }

  /**
   * withStepperContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper withStepperContent(ChildHandler<Stepper, DivElement> handler) {
    handler.apply(this, stepperContent);
    return this;
  }

  /**
   * withSteps.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper withSteps(ChildHandler<Stepper, List<Step>> handler) {
    handler.apply(this, steps);
    return this;
  }

  /**
   * finish.
   *
   * @param finishState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer) {
    this.stepperTrack.finish(finishState, consumer);
    this.stepperContent.appendChild(finishContent);
    return this;
  }

  /**
   * finish.
   *
   * @param finishState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper finish(StepState finishState) {
    finish(finishState, (deactivated, activated) -> {});
    return this;
  }

  /**
   * withFinishContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper withFinishContent(ChildHandler<Stepper, DivElement> handler) {
    handler.apply(this, finishContent);
    return this;
  }

  /**
   * reset.
   *
   * @param startState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @param stepsConsumer a {@link java.util.function.Consumer} object
   * @return a {@link org.dominokit.domino.ui.stepper.Stepper} object
   */
  public Stepper reset(StepState startState, Consumer<List<Step>> stepsConsumer) {
    stepsConsumer.accept(this.steps);
    start(startState);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
