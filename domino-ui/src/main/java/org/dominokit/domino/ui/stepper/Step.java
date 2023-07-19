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
 * Step class.
 *
 * @author vegegoku
 * @version $Id: $Id
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
   * Constructor for Step.
   *
   * @param title a {@link java.lang.String} object
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
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public static Step create(String title) {
    return new Step(title);
  }

  private void setStepState(StepTracker tracker) {
    this.state = tracker.getState();
    addCss(BooleanCssClass.of(dui_active, tracker.isActive()));
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step withHeader(ChildHandler<Step, NavBar> handler) {
    handler.apply(this, stepHeader);
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step withFooter(ChildHandler<Step, DivElement> handler) {
    handler.apply(this, stepFooter.get());
    return this;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step withContent(ChildHandler<Step, DivElement> handler) {
    handler.apply(this, stepContent);
    return this;
  }

  /**
   * withTracker.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step withTracker(ChildHandler<Step, StepTracker> handler) {
    handler.apply(this, stepTracker);
    return this;
  }

  /**
   * Getter for the field <code>stepTracker</code>.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.StepTracker} object
   */
  public StepTracker getStepTracker() {
    return stepTracker;
  }

  void bindToStepper(Stepper stepper) {
    this.stepper = stepper;
    setState(this.state);
  }

  /**
   * Setter for the field <code>state</code>.
   *
   * @param state a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step setState(StepState state) {
    this.stepTracker.setState(state);
    return this;
  }

  void unbindStepper() {
    this.stepper = null;
  }

  /**
   * next.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step next() {
    return next(0);
  }

  /**
   * next.
   *
   * @param skip a int
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  /**
   * next.
   *
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step next(StepperTrack.StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  /**
   * next.
   *
   * @param skip a int
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step next(int skip, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.next(skip, consumer);
    }
    return this;
  }

  /**
   * prev.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step prev() {
    return prev(0);
  }

  /**
   * prev.
   *
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step prev(StepperTrack.StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  /**
   * prev.
   *
   * @param skip a int
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  /**
   * prev.
   *
   * @param skip a int
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step prev(int skip, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.prev(skip, consumer);
    }
    return this;
  }

  /**
   * finish.
   *
   * @param finishState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @param consumer a {@link org.dominokit.domino.ui.stepper.StepperTrack.StepTrackersConsumer}
   *     object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step finish(StepState finishState, StepperTrack.StepTrackersConsumer consumer) {
    if (nonNull(this.stepper)) {
      this.stepper.finish(finishState, consumer);
    }
    return this;
  }

  /**
   * finish.
   *
   * @param finishState a {@link org.dominokit.domino.ui.stepper.StepState} object
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step finish(StepState finishState) {
    finish(finishState, (deactivated, activated) -> {});
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return stepContent.element();
  }
}
