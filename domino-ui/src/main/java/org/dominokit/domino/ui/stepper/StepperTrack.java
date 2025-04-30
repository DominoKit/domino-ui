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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.StepperConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a visual track within a stepper component.
 *
 * <p>Usage:
 *
 * <pre>
 * StepperTrack track = StepperTrack.create();
 * </pre>
 *
 * @see BaseDominoElement
 */
public class StepperTrack extends BaseDominoElement<HTMLDivElement, StepperTrack>
    implements StepperStyles, HasComponentConfig<StepperConfig> {
  private final DivElement root;
  private final List<StepTracker> trackers = new ArrayList<>();
  public BooleanCssClass textPosition = BooleanCssClass.of(dui_reversed);
  private StepTracker activeTracker;
  private int currentTrackerIndex;
  private boolean started = false;

  /** Constructor to create a new StepperTrack. */
  public StepperTrack() {
    root = div().addCss(dui_stepper_track);
    init(this);
  }

  /**
   * Creates a new instance of {@link StepperTrack}.
   *
   * @return new instance of {@link StepperTrack}
   */
  public static StepperTrack create() {
    return new StepperTrack();
  }

  /**
   * Appends a {@link StepTracker} to the stepper track.
   *
   * @param stepTracker the {@link StepTracker} to be appended
   * @return this {@link StepperTrack}
   */
  public StepperTrack appendChild(StepTracker stepTracker) {
    root.appendChild(stepTracker);
    trackers.add(stepTracker);
    return this;
  }

  public StepperTrack appendChild(StepTracker... stepTrackers) {
    Arrays.stream(stepTrackers).forEach(this::appendChild);
    return this;
  }

  /**
   * Removes a given {@link StepTracker} from the stepper track.
   *
   * @param stepTracker the {@link StepTracker} to be removed
   * @return this {@link StepperTrack}
   */
  public StepperTrack removeTracker(StepTracker stepTracker) {
    if (trackers.contains(stepTracker)) {
      stepTracker.remove();
    }
    return this;
  }

  /**
   * Moves to the next {@link StepTracker} without skipping any steps.
   *
   * @return this {@link StepperTrack}
   */
  public StepperTrack next() {
    return next(0);
  }

  /**
   * Moves to the next {@link StepTracker} by skipping a specified number of steps.
   *
   * @param skip the number of steps to skip
   * @return this {@link StepperTrack}
   */
  public StepperTrack next(int skip) {
    return next(skip, (deactivated, activated) -> {});
  }

  /**
   * Moves to the next {@link StepTracker} without skipping any steps and provides a custom
   * callback.
   *
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   */
  public StepperTrack next(StepTrackersConsumer consumer) {
    return next(0, consumer);
  }

  /**
   * Moves to the next {@link StepTracker} by skipping a specified number of steps and provides a
   * custom callback.
   *
   * @param skip the number of steps to skip
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   */
  public StepperTrack next(int skip, StepTrackersConsumer consumer) {
    if (!started) {
      throw new IllegalStateException(
          "Stepper should be started before calling next, previous, or finish.");
    }

    int i = this.trackers.indexOf(this.activeTracker);
    int i1 = this.trackers.size() - 1;
    if (nonNull(this.activeTracker) && i == i1) {
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

  /**
   * Initiates the {@link StepperTrack} with the default step state defined in the configuration.
   *
   * @return this {@link StepperTrack}
   * @see #getConfig()
   */
  public StepperTrack start() {
    return start(getConfig().getDefaultStepState(), (deactivated, activated) -> {});
  }

  /**
   * Initiates the {@link StepperTrack} with a given step state.
   *
   * @param startState the initial state for the starting step
   * @return this {@link StepperTrack}
   */
  public StepperTrack start(StepState startState) {
    return start(startState, (deactivated, activated) -> {});
  }

  /**
   * Initiates the {@link StepperTrack} with a given step state and provides a custom callback.
   *
   * @param startState the initial state for the starting step
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   */
  public StepperTrack start(StepState startState, StepTrackersConsumer consumer) {
    this.started = true;
    trackers.stream()
        .filter(
            tracker -> {
              boolean enabled = tracker.isEnabled();
              boolean visible = tracker.isVisible();
              return enabled && visible;
            })
        .findFirst()
        .ifPresent(
            tracker -> {
              activateTracker(tracker, consumer);
              tracker.setState(startState);
            });
    return this;
  }

  /**
   * Finishes the {@link StepperTrack} and sets the active tracker to a given final state, then
   * invokes a custom callback.
   *
   * @param finishState the final state to set for the active tracker
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
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

  /**
   * Finishes the {@link StepperTrack} and sets the active tracker to a given final state.
   *
   * @param finishState the final state to set for the active tracker
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
  public StepperTrack finish(StepState finishState) {
    return finish(finishState, (deactivated, activated) -> {});
  }

  /**
   * Activates the given {@link StepTracker}, deactivating the currently active tracker if any, and
   * notifies the provided consumer of the change.
   *
   * @param stepTracker the {@link StepTracker} to activate
   * @param consumer callback to handle active step changes
   */
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

  /**
   * Deactivates the provided {@link StepTracker}.
   *
   * @param tracker the {@link StepTracker} to deactivate
   */
  private void deactivateTracker(StepTracker tracker) {
    if (nonNull(tracker)) {
      tracker.deactivate();
    }
  }

  /**
   * Moves to the previous step in the {@link StepperTrack}.
   *
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
  public StepperTrack prev() {
    return prev(0);
  }

  /**
   * Moves to the previous step in the {@link StepperTrack} and notifies the provided consumer of
   * the change.
   *
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
  public StepperTrack prev(StepTrackersConsumer consumer) {
    return prev(0, consumer);
  }

  /**
   * Moves to the previous step in the {@link StepperTrack}, skipping a given number of steps.
   *
   * @param skip the number of steps to skip
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
  public StepperTrack prev(int skip) {
    return prev(skip, (deactivated, activated) -> {});
  }

  /**
   * Moves to the previous step in the {@link StepperTrack}, skipping a given number of steps, and
   * notifies the provided consumer of the change.
   *
   * @param skip the number of steps to skip
   * @param consumer callback to handle active step changes
   * @return this {@link StepperTrack}
   * @throws IllegalStateException if the {@link StepperTrack} was not started
   */
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

  /**
   * Resets the stepper track and starts with the given state.
   *
   * @param startState state to start with
   * @param trackersConsumer consumer accepting the list of trackers
   * @return this {@link StepperTrack}
   */
  public StepperTrack reset(StepState startState, Consumer<List<StepTracker>> trackersConsumer) {
    trackersConsumer.accept(this.trackers);
    start(startState);
    return this;
  }

  /**
   * Retrieves the next {@link StepTracker} in the {@link StepperTrack}.
   *
   * @return an {@link Optional} containing the next {@link StepTracker} if available, or an empty
   *     {@link Optional} if there are no more steps or if the {@link StepperTrack} is empty
   */
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

  /**
   * Retrieves the previous {@link StepTracker} in the {@link StepperTrack}.
   *
   * @return an {@link Optional} containing the previous {@link StepTracker} if available, or an
   *     empty {@link Optional} if there are no previous steps or if the {@link StepperTrack} is
   *     empty
   */
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

  /**
   * Retrieves the currently active {@link StepTracker} in the {@link StepperTrack}.
   *
   * @return an {@link Optional} containing the active {@link StepTracker} if available, or an empty
   *     {@link Optional} if there is no active step
   */
  public Optional<StepTracker> getActiveTracker() {
    return Optional.ofNullable(activeTracker);
  }

  /**
   * Sets the text position within the {@link StepperTrack} to be reversed or not.
   *
   * @param reversed {@code true} to reverse the text position, {@code false} otherwise
   * @return this {@link StepperTrack}
   */
  public StepperTrack setTextPositionReversed(boolean reversed) {
    textPosition.apply(this, reversed);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** Functional interface to consume changes in active steps. */
  @FunctionalInterface
  public interface StepTrackersConsumer {

    /**
     * Callback to notify when the active step has changed.
     *
     * @param deactivated previously active {@link StepTracker}
     * @param activated newly active {@link StepTracker}
     */
    @SuppressWarnings("all")
    void onActiveStepChanged(Optional<StepTracker> deactivated, Optional<StepTracker> activated);
  }
}
