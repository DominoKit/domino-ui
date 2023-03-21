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
package org.dominokit.domino.ui.collapsible;

import org.dominokit.domino.ui.animations.Transition;

public class AnimationCollapseOptions {

  private Transition showTransition;
  private Transition hideTransition;
  private CollapseDuration showDuration;
  private CollapseDuration hideDuration;
  private int showDelay = 0;

  public Transition getShowTransition() {
    return showTransition;
  }

  public AnimationCollapseOptions setShowTransition(Transition showTransition) {
    this.showTransition = showTransition;
    return this;
  }

  public Transition getHideTransition() {
    return hideTransition;
  }

  public AnimationCollapseOptions setHideTransition(Transition hideTransition) {
    this.hideTransition = hideTransition;
    return this;
  }

  public CollapseDuration getShowDuration() {
    return showDuration;
  }

  public AnimationCollapseOptions setShowDuration(CollapseDuration showDuration) {
    this.showDuration = showDuration;
    return this;
  }

  public CollapseDuration getHideDuration() {
    return hideDuration;
  }

  public AnimationCollapseOptions setHideDuration(CollapseDuration hideDuration) {
    this.hideDuration = hideDuration;
    return this;
  }

  public int getShowDelay() {
    return showDelay;
  }

  public AnimationCollapseOptions setShowDelay(int showDelay) {
    this.showDelay = showDelay;
    return this;
  }
}
