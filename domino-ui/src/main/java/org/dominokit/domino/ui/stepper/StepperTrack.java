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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class StepperTrack extends BaseDominoElement<HTMLDivElement, StepperTrack>
    implements StepperStyles, HasComponentConfig<StepperConfig> {
  private final DivElement root;
  private final List<StepTracker> trackers = new ArrayList<>();
  public BooleanCssClass textPosition = BooleanCssClass.of(dui_reversed);
  private StepTracker activeTracker;
  private int currentTrackerIndex;
  private boolean started = false;

  public StepperTrack() {
    root = div().addCss(dui_stepper_track);
    init(this);
  }

  public static StepperTrack create() {
    return new StepperTrack();
  }

  public StepperTrack appendChild(StepTracker stepTracker) {
    root.appendChild(stepTracker);
    trackers.add(stepTracker);
    stepTracker.onDetached(mutationRecord -> trackers.remove(stepTracker));
    return this;
  }

  public StepperTrack removeTracker(StepTracker stepTracker) {
    if (trackers.contains(stepTracker)) {
      stepTracker.remove();
    }
    return this;
  }

  public StepperTrack next() {
    return next(0);
  }

  public StepperTrack next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  public StepperTrack next(StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  public StepperTrack next(int skip, StepTrackersConsumer consumer) {
    if (!started) {
      throw new IllegalStateException(
          "Stepper should be started before calling next, previous, or finish.");
    }

    if (nonNull(this.activeTracker)
        && this.trackers.indexOf(this.activeTracker) == this.trackers.size() - 1) {
      this.deactivateTracker(this.activeTracker);
      consumer.onActiveStepChanged(Optional.of(this.activeTracker), Optional.empty());
      this.activeTracker = null;
      return this;
    }

    if (isNull(this.activeTracker)) {
      return this;
    }

    trackers.stream()
        .filter(
            tracker ->
                tracker.isEnabled()
                    && tracker.isVisible()
                    && trackers.indexOf(tracker) > (trackers.indexOf(this.activeTracker) + skip))
        .findFirst()
        .ifPresent(stepTracker -> activateTracker(stepTracker, consumer));

    return this;
  }

  public StepperTrack start() {
    return start(getConfig().getDefaultStepState(), (deactivated, activated) -> {});
  }

  public StepperTrack start(StepState startState) {
    return start(startState, (deactivated, activated) -> {});
  }

  public StepperTrack start(StepState startState, StepTrackersConsumer consumer) {
    this.started = true;
    trackers.stream()
        .filter(tracker -> tracker.isEnabled() && tracker.isVisible())
        .findFirst()
        .ifPresent(
            tracker -> {
              activateTracker(tracker, consumer);
              tracker.setState(startState);
            });
    return this;
  }

  public StepperTrack finish(StepState finishState, StepTrackersConsumer consumer) {
    if (!started) {
      throw new IllegalStateException(
          "Stepper should be started before calling next, previous, or finish.");
    }
    deactivateTracker(this.activeTracker);
    this.activeTracker.setState(finishState);
    consumer.onActiveStepChanged(Optional.of(this.activeTracker), Optional.empty());
    this.activeTracker = null;
    this.started = false;
    return this;
  }

  public StepperTrack finish(StepState finishState) {
    return finish(finishState, (deactivated, activated) -> {});
  }

  private void activateTracker(StepTracker stepTracker, StepTrackersConsumer consumer) {
    if (nonNull(stepTracker)) {
      StepTracker deactivated = this.activeTracker;
      if (nonNull(this.activeTracker)) {
        deactivateTracker(this.activeTracker);
      }
      stepTracker.activate();
      this.activeTracker = stepTracker;
      if (isNull(deactivated) && this.currentTrackerIndex > 0 && !this.trackers.isEmpty()) {
        deactivated = trackers.get(this.currentTrackerIndex);
      }
      this.currentTrackerIndex = trackers.indexOf(this.activeTracker);
      consumer.onActiveStepChanged(
          Optional.ofNullable(deactivated), Optional.of(this.activeTracker));
    }
  }

  private void deactivateTracker(StepTracker tracker) {
    if (nonNull(tracker)) {
      tracker.deactivate();
    }
  }

  public StepperTrack prev() {
    return prev(0);
  }

  public StepperTrack prev(StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  public StepperTrack prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  public StepperTrack prev(int skip, StepTrackersConsumer consumer) {
    if (!started) {
      throw new IllegalStateException(
          "Stepper should be started before calling next, previous, or finish.");
    }
    if (isNull(this.activeTracker)) {
      if (this.currentTrackerIndex > 0 && !this.trackers.isEmpty()) {
        activateTracker(this.trackers.get(currentTrackerIndex - 1), consumer);
      }
      return this;
    }

    for (int i = trackers.size() - 1; i >= 0; i--) {
      StepTracker tracker = trackers.get(i);
      if (tracker.isEnabled()
          && tracker.isVisible()
          && trackers.indexOf(tracker) < (trackers.indexOf(this.activeTracker) - skip)) {
        activateTracker(tracker, consumer);
        return this;
      }
    }

    return this;
  }

  public StepperTrack reset(StepState startState, Consumer<List<StepTracker>> trackersConsumer) {
    trackersConsumer.accept(this.trackers);
    start(startState);
    return this;
  }

  public Optional<StepTracker> getNextTracker() {
    if (this.trackers.isEmpty()) {
      return Optional.empty();
    }
    if (nonNull(this.activeTracker)) {
      int currentTrackerIndex = this.trackers.indexOf(this.activeTracker);
      if (currentTrackerIndex < (this.trackers.size() - 1)) {
        return Optional.of(this.trackers.get(currentTrackerIndex + 1));
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.of(this.trackers.get(0));
    }
  }

  public Optional<StepTracker> getPreviousTracker() {
    if (this.trackers.isEmpty()) {
      return Optional.empty();
    }
    if (nonNull(this.activeTracker)) {
      int currentTrackerIndex = this.trackers.indexOf(this.activeTracker);
      if (currentTrackerIndex > 0) {
        return Optional.of(this.trackers.get(currentTrackerIndex - 1));
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.of(this.trackers.get(0));
    }
  }

  public Optional<StepTracker> getActiveTracker() {
    return Optional.ofNullable(activeTracker);
  }

  public StepperTrack setTextPositionReversed(boolean reversed) {
    textPosition.apply(this, reversed);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  @FunctionalInterface
  public interface StepTrackersConsumer {
    @SuppressWarnings("all")
    void onActiveStepChanged(Optional<StepTracker> deactivated, Optional<StepTracker> activated);
  }
}
