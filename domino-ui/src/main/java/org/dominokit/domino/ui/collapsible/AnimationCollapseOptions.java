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

/**
 * AnimationCollapseOptions class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class AnimationCollapseOptions {

  private Transition showTransition;
  private Transition hideTransition;
  private CollapseDuration showDuration;
  private CollapseDuration hideDuration;
  private int showDelay = 0;

  /**
   * Getter for the field <code>showTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getShowTransition() {
    return showTransition;
  }

  /**
   * Setter for the field <code>showTransition</code>.
   *
   * @param showTransition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a {@link org.dominokit.domino.ui.collapsible.AnimationCollapseOptions} object
   */
  public AnimationCollapseOptions setShowTransition(Transition showTransition) {
    this.showTransition = showTransition;
    return this;
  }

  /**
   * Getter for the field <code>hideTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getHideTransition() {
    return hideTransition;
  }

  /**
   * Setter for the field <code>hideTransition</code>.
   *
   * @param hideTransition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a {@link org.dominokit.domino.ui.collapsible.AnimationCollapseOptions} object
   */
  public AnimationCollapseOptions setHideTransition(Transition hideTransition) {
    this.hideTransition = hideTransition;
    return this;
  }

  /**
   * Getter for the field <code>showDuration</code>.
   *
   * @return a {@link org.dominokit.domino.ui.collapsible.CollapseDuration} object
   */
  public CollapseDuration getShowDuration() {
    return showDuration;
  }

  /**
   * Setter for the field <code>showDuration</code>.
   *
   * @param showDuration a {@link org.dominokit.domino.ui.collapsible.CollapseDuration} object
   * @return a {@link org.dominokit.domino.ui.collapsible.AnimationCollapseOptions} object
   */
  public AnimationCollapseOptions setShowDuration(CollapseDuration showDuration) {
    this.showDuration = showDuration;
    return this;
  }

  /**
   * Getter for the field <code>hideDuration</code>.
   *
   * @return a {@link org.dominokit.domino.ui.collapsible.CollapseDuration} object
   */
  public CollapseDuration getHideDuration() {
    return hideDuration;
  }

  /**
   * Setter for the field <code>hideDuration</code>.
   *
   * @param hideDuration a {@link org.dominokit.domino.ui.collapsible.CollapseDuration} object
   * @return a {@link org.dominokit.domino.ui.collapsible.AnimationCollapseOptions} object
   */
  public AnimationCollapseOptions setHideDuration(CollapseDuration hideDuration) {
    this.hideDuration = hideDuration;
    return this;
  }

  /**
   * Getter for the field <code>showDelay</code>.
   *
   * @return a int
   */
  public int getShowDelay() {
    return showDelay;
  }

  /**
   * Setter for the field <code>showDelay</code>.
   *
   * @param showDelay a int
   * @return a {@link org.dominokit.domino.ui.collapsible.AnimationCollapseOptions} object
   */
  public AnimationCollapseOptions setShowDelay(int showDelay) {
    this.showDelay = showDelay;
    return this;
  }
}
