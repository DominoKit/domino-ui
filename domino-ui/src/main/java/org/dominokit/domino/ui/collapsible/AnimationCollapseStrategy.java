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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * An implementation of {@link CollapseStrategy} that uses the css display property to hide/show the
 * collapsible element
 */
public class AnimationCollapseStrategy implements CollapseStrategy {

  private final Transition showTransition;
  private final Transition hideTransition;
  private final CollapseDuration duration;

  public AnimationCollapseStrategy(
      Transition showTransition, Transition hideTransition, CollapseDuration duration) {
    this.showTransition = showTransition;
    this.hideTransition = hideTransition;
    this.duration = duration;
  }

  public AnimationCollapseStrategy(Transition transition, CollapseDuration duration) {
    this.showTransition = transition;
    this.hideTransition = transition;
    this.duration = duration;
  }

  /** {@inheritDoc} */
  @Override
  public void show(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement.of(element).removeCss(duration.getStyle());
    Animation.create(element)
        .duration(duration.getDuration())
        .transition(showTransition)
        .beforeStart(
            theElement -> {
              style.removeProperty("display");
              DominoElement.of(element).removeAttribute("d-collapsed");
            })
        .animate();
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement.of(element).removeCss(duration.getStyle());
    Animation.create(element)
        .duration(duration.getDuration())
        .transition(hideTransition)
        .callback(
            theElement -> {
              style.setDisplay("none");
              DominoElement.of(element).setAttribute("d-collapsed", "true");
            })
        .animate();
  }
}
