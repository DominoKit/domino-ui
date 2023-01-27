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

import static java.util.Objects.nonNull;

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
  private Animation hideAnimation;
  private boolean showing = false;
  private boolean hiding = false;
  private CollapsibleHandlers handlers;

  @Override
  public void init(
      HTMLElement element,
      Style<HTMLElement, IsElement<HTMLElement>> style,
      CollapsibleHandlers handlers) {
    this.handlers = handlers;
  }

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
    if (!showing) {
      DominoElement.of(element).removeCss(duration.getStyle());
      Animation.create(element)
          .duration(duration.getDuration())
          .transition(showTransition)
          .beforeStart(
              theElement -> {
                showing = true;
                if (nonNull(hideAnimation)) {
                  hideAnimation.stop(true);
                  hideAnimation = null;
                  hiding = false;
                }
                style.removeCssProperty("display");
                DominoElement.of(element).removeAttribute("d-collapsed");
                this.handlers.onBeforeShow().run();
              })
          .callback(
              e -> {
                showing = false;
                this.handlers.onShowCompleted().run();
              })
          .animate();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    if (!hiding) {
      DominoElement.of(element).removeCss(duration.getStyle());
      hideAnimation =
          Animation.create(element)
              .duration(duration.getDuration())
              .transition(hideTransition)
              .beforeStart(
                  element1 -> {
                    hiding = true;
                    this.handlers.onBeforeHide().run();
                  })
              .callback(
                  theElement -> {
                    style.setDisplay("none");
                    DominoElement.of(element).setAttribute("d-collapsed", "true");
                    hiding = false;
                    this.handlers.onHideCompleted().run();
                  })
              .animate();
    }
  }
}
