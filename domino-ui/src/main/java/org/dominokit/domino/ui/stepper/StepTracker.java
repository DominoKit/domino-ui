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
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

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

  public StepTracker(String key) {
    this();
    setKey(key);
  }

  public static StepTracker create() {
    return new StepTracker();
  }

  public static StepTracker create(String key) {
    return new StepTracker(key);
  }

  public StepTracker withTrackerNode(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerNode);
    return this;
  }

  public StepTracker withTrackerLine(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerLine);
    return this;
  }

  public DivElement getTrackerNode() {
    return trackerNode;
  }

  public DivElement getTrackerLine() {
    return trackerLine;
  }

  void activate() {
    this.addCss(dui_active);
  }

  void deactivate() {
    this.removeCss(dui_active);
  }

  public StepTracker addStateListener(TrackerListener listener) {
    if (nonNull(listener)) {
      listeners.add(listener);
    }
    return this;
  }

  public StepTracker removeStateListener(TrackerListener listener) {
    if (nonNull(listener)) {
      listeners.remove(listener);
    }
    return this;
  }

  public StepState getState() {
    return state;
  }

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

  public StepTracker withContent(ChildHandler<StepTracker, DivElement> handler) {
    handler.apply(this, trackerContent);
    return this;
  }

  public StepTracker appendChild(PostfixAddOn<?> postfixAddOn) {
    this.trackerChain.appendChild(postfixAddOn);
    return this;
  }

  public StepTracker appendChild(PrefixAddOn<?> prefixAddOn) {
    this.trackerChain.appendChild(prefixAddOn);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  @Override
  protected Element getAppendTarget() {
    return trackerContent.element();
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public boolean isActive() {
    return dui_active.isAppliedTo(this);
  }

  public interface TrackerListener {
    void onStateChanged(StepTracker tracker, StepState state);
  }
}
