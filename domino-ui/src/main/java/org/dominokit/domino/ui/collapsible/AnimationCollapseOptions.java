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

/** A class to provide animation collapse/expand animation configuration options */
public class AnimationCollapseOptions {

  private Transition showTransition;
  private Transition hideTransition;
  private CollapsibleDuration showDuration;
  private CollapsibleDuration hideDuration;
  private int showDelay = 0;

  /**
   * @return The {@link org.dominokit.domino.ui.animations.Transition} used to animation the element
   *     when it is being shown/expanded
   */
  public Transition getShowTransition() {
    return showTransition;
  }

  /**
   * The {@link org.dominokit.domino.ui.animations.Transition} to be used to animation the element
   * when it is being shown/expanded
   *
   * @param showTransition a {@link org.dominokit.domino.ui.animations.Transition}
   * @return Same AnimationCollapseOptions instance
   */
  public AnimationCollapseOptions setShowTransition(Transition showTransition) {
    this.showTransition = showTransition;
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.animations.Transition} used to animation the element
   *     when it is being hidden/collapsed
   */
  public Transition getHideTransition() {
    return hideTransition;
  }

  /**
   * The {@link org.dominokit.domino.ui.animations.Transition} to be used to animation the element
   * when it is being hidden/collapsed
   *
   * @param hideTransition a {@link org.dominokit.domino.ui.animations.Transition}
   * @return Same AnimationCollapseOptions instance
   */
  public AnimationCollapseOptions setHideTransition(Transition hideTransition) {
    this.hideTransition = hideTransition;
    return this;
  }

  /** @return The show/expand animation duration, {@link CollapsibleDuration} */
  public CollapsibleDuration getShowDuration() {
    return showDuration;
  }

  /**
   * Sets the show/expand animation duration
   *
   * @param showDuration The duration, one of enums provided byt {@link CollapsibleDuration}
   * @return Same AnimationCollapseOptions instance
   */
  public AnimationCollapseOptions setShowDuration(CollapsibleDuration showDuration) {
    this.showDuration = showDuration;
    return this;
  }

  /** @return The hide/collapse animation duration, {@link CollapsibleDuration} */
  public CollapsibleDuration getHideDuration() {
    return hideDuration;
  }

  /**
   * Sets the hide/collapse animation duration
   *
   * @param hideDuration The duration, one of enums provided byt {@link CollapsibleDuration}
   * @return Same AnimationCollapseOptions instance
   */
  public AnimationCollapseOptions setHideDuration(CollapsibleDuration hideDuration) {
    this.hideDuration = hideDuration;
    return this;
  }

  /**
   * @return An int number representing the delay in milliseconds to wait before show/expand
   *     animation is started after we show/expand the element.
   */
  public int getShowDelay() {
    return showDelay;
  }

  /**
   * Sets the delay in milliseconds to wait before show/expand animation is started after we
   * show/expand the element.
   *
   * @param showDelay The delay in milliseconds
   * @return Same AnimationCollapseOptions instance
   */
  public AnimationCollapseOptions setShowDelay(int showDelay) {
    this.showDelay = showDelay;
    return this;
  }
}
