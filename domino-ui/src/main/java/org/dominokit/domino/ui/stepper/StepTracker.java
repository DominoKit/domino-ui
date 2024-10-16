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
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;

/**
 * Represents a tracker within a step in a stepper component. This tracker displays the state of the
 * step. It can be customized with additional content and styles.
 *
 * @see BaseDominoElement
 */
public class StepTracker extends BaseDominoElement<HTMLDivElement, StepTracker>
    implements StepperStyles {

  private final DivElement root;
  private final DivElement trackerChain;
  private final DivElement trackerContent;
  private final DivElement trackerNode;
  private final DivElement trackerLine;
  private final Set<TrackerListener> listeners = new HashSet<>();
  private StepState state;
  private String key;
  private StepperTrack parent;

  /** Creates a new {@link StepTracker} with default settings. */
  public StepTracker() {
    root =
        div()
            .addCss(dui_step_track)
            .appendChild(
                trackerChain =
                    div()
                        .addCss(dui_tracker_chain)
                        .appendChild(trackerNode = div().addCss(dui_tracker_node))
                        .appendChild(trackerLine = div().addCss(dui_tracker_line)))
            .appendChild(trackerContent = div().addCss(dui_tracker_content));
    init(this);
    setState(uiconfig().getDefaultStepState());
  }

  void bind(StepperTrack parent) {
    this.parent = parent;
  }

  @Override
  public StepTracker remove() {
    this.parent.removeTracker(this);
    return super.remove();
  }

  /**
   * Creates a new {@link StepTracker} with a custom key.
   *
   * @param key The custom key for the tracker.
   */
  public StepTracker(String key) {
    this();
    setKey(key);
  }

  /**
   * Factory method to create a new instance of {@link StepTracker} with default settings.
   *
   * @return A new instance of {@link StepTracker}.
   */
  public static StepTracker create() {
    return new StepTracker();
  }

  /**
   * Factory method to create a new instance of {@link StepTracker} with a custom key.
   *
   * @param key The custom key for the tracker.
   * @return A new instance of {@link StepTracker} with the specified key.
   */
  public static StepTracker create(String key) {
    return new StepTracker(key);
  }

  /**
   * Configures the tracker node using a child handler.
   *
   * @param handler The handler to configure the tracker node.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker withTrackerNode(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerNode);
    return this;
  }

  /**
   * Configures the tracker line using a child handler.
   *
   * @param handler The handler to configure the tracker line.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker withTrackerLine(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerLine);
    return this;
  }

  /**
   * Retrieves the tracker node element.
   *
   * @return The tracker node element.
   */
  public DivElement getTrackerNode() {
    return trackerNode;
  }

  /**
   * Retrieves the tracker line element.
   *
   * @return The tracker line element.
   */
  public DivElement getTrackerLine() {
    return trackerLine;
  }

  /**
   * Activates the step tracker, indicating that the step is active. This method adds the active CSS
   * class.
   */
  void activate() {
    this.addCss(dui_active);
  }

  /**
   * Deactivates the step tracker, indicating that the step is not active. This method removes the
   * active CSS class.
   */
  void deactivate() {
    this.removeCss(dui_active);
  }

  /**
   * Adds a state listener to this step tracker. The listener will be notified when the state
   * changes.
   *
   * @param listener The state listener to add.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker addStateListener(TrackerListener listener) {
    if (nonNull(listener)) {
      listeners.add(listener);
    }
    return this;
  }

  /**
   * Removes a state listener from this step tracker.
   *
   * @param listener The state listener to remove.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker removeStateListener(TrackerListener listener) {
    if (nonNull(listener)) {
      listeners.remove(listener);
    }
    return this;
  }

  /**
   * Retrieves the current state of the step tracker.
   *
   * @return The current state of the step tracker.
   */
  public StepState getState() {
    return state;
  }

  /**
   * Sets the state of the step tracker to the specified state.
   *
   * @param state The state to set.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker setState(StepState state) {
    if (nonNull(this.state)) {
      this.state.cleanUp(this);
    }
    this.state = state;
    this.state.apply(this);
    triggerListeners();
    return this;
  }

  private void triggerListeners() {
    listeners.forEach(listener -> listener.onStateChanged(this, state));
  }

  /**
   * Configures the content of the step tracker using a child handler.
   *
   * @param handler The handler to configure the content.
   * @return This {@link StepTracker} instance.
   */
  public StepTracker withContent(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerContent);
    return this;
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(this.trackerChain);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(this.trackerChain);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return trackerContent.element();
  }

  /**
   * Retrieves the custom key associated with this step tracker.
   *
   * @return The custom key.
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets a custom key for this step tracker.
   *
   * @param key The custom key to set.
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Checks if this step tracker is active.
   *
   * @return {@code true} if the step tracker is active, {@code false} otherwise.
   */
  public boolean isActive() {
    return dui_active.isAppliedTo(this);
  }

  /** Listener interface to handle state changes in a step tracker. */
  public interface TrackerListener {
    /**
     * Called when the state of the step tracker changes.
     *
     * @param tracker The step tracker whose state has changed.
     * @param state The new state of the step tracker.
     */
    void onStateChanged(StepTracker tracker, StepState state);
  }
}
