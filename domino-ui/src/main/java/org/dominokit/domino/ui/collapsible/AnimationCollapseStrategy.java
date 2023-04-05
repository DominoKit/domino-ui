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
import static org.dominokit.domino.ui.style.DisplayCss.dui_hidden;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import java.util.Optional;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;

/**
 * An implementation of {@link CollapseStrategy} that uses the css display property to hide/show the
 * collapsible element
 */
public class AnimationCollapseStrategy implements CollapseStrategy {

  private final AnimationCollapseOptions options;
  private Animation hideAnimation;
  private boolean showing = false;
  private boolean hiding = false;
    private CollapsibleHandlers handlers;
    private Animation showAnimation;

    @Override
    public void init(Element element, CollapsibleHandlers handlers) {
        this.handlers = handlers;
    }

    public AnimationCollapseStrategy(
      Transition showTransition, Transition hideTransition, CollapseDuration duration) {
        this.options =
                new AnimationCollapseOptions()
                        .setShowTransition(showTransition)
                        .setHideTransition(hideTransition)
                        .setShowDuration(duration)
                        .setHideDuration(duration);

  }

  public AnimationCollapseStrategy(Transition transition, CollapseDuration duration) {
      this.options =
              new AnimationCollapseOptions()
                      .setShowTransition(transition)
                      .setHideTransition(transition)
                      .setShowDuration(duration)
                      .setHideDuration(duration);
  }

  public AnimationCollapseStrategy(AnimationCollapseOptions options) {
    this.options = options;
  }

  /** {@inheritDoc} */
  @Override
  public void expand(Element element) {
      if (!showing) {
          elements.elementOf(element).removeCss(this.options.getShowDuration().getStyle());
          elements.elementOf(element).removeCss(this.options.getHideDuration().getStyle());
          showAnimation =
                  Animation.create(element)
                          .duration(this.options.getShowDuration().getDuration())
                          .transition(this.options.getShowTransition())
                          .delay(this.options.getShowDelay())
                          .beforeStart(
                                  theElement -> {
                                      showing = true;
                                      if (nonNull(hideAnimation)) {
                                          hideAnimation.stop(true);
                                          hideAnimation = null;
                                          hiding = false;
                                      }
                                      elements.elementOf(element)
                                              .removeCss(dui_hidden)
                                              .removeAttribute(Collapsible.DUI_COLLAPSED);
                                  })
                          .callback(
                                  e -> {
                                      showing = false;
                                      this.handlers.onExpandCompleted().run();
                                  })
                          .animate();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void collapse(Element element) {
      Optional.ofNullable(showAnimation).ifPresent(animation -> animation.stop(false));
      if (!hiding) {
          elements.elementOf(element).removeCss(this.options.getShowDuration().getStyle());
          elements.elementOf(element).removeCss(this.options.getHideDuration().getStyle());
          hideAnimation =
                  Animation.create(element)
                          .duration(this.options.getHideDuration().getDuration())
                          .transition(this.options.getHideTransition())
                          .beforeStart(
                                  element1 -> {
                                      hiding = true;
                                      this.handlers.onBeforeCollapse().run();
                                  })
                          .callback(
                                  theElement -> {
                                      elements.elementOf(element)
                                              .addCss(dui_hidden)
                                              .setAttribute(Collapsible.DUI_COLLAPSED, "true");
                                      hiding = false;
                                      this.handlers.onCollapseCompleted().run();
                                  })
                          .animate();
    }
  }
}
