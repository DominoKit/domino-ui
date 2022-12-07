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
package org.dominokit.domino.ui.utils;

import static elemental2.dom.DomGlobal.setTimeout;
import static org.dominokit.domino.ui.popover.PopoverStyles.FADE;
import static org.dominokit.domino.ui.popover.PopoverStyles.IN;

import elemental2.dom.DomGlobal;
import elemental2.dom.DomGlobal.SetTimeoutCallbackFn;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.jboss.elemento.IsElement;

/** Utility which handles {@code opacity} transition */
public class OpacityTransition {

  private static final String TRANSITIONEND = "transitionend";

  private final DominoElement<? extends HTMLElement> target;

  private Animation inAnimation;
  private Animation outAnimation;

  public OpacityTransition(HTMLElement target, Animation.CompleteCallback onHide) {
    this(target, 300, onHide);
  }

  public OpacityTransition(HTMLElement target, int duration, Animation.CompleteCallback onHide) {
    inAnimation = Animation.create(target).transition(Transition.FADE_IN).duration(duration);
    outAnimation =
        Animation.create(target)
            .transition(Transition.FADE_OUT)
            .duration(duration)
            .callback(onHide);

    this.target = DominoElement.of(target);
  }

  public OpacityTransition(
      IsElement<? extends HTMLElement> target, Animation.CompleteCallback onHide) {
    this(target.element(), onHide);
  }

  /**
   * Applies {@code fade-in} css class which sets the {@code opacity} to 1
   *
   * <p>
   *
   * <p>{@link DomGlobal#setTimeout(SetTimeoutCallbackFn callback, double delay, Object...
   * callbackParams)} was used based on <a
   * href="https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Transitions/Using_CSS_transitions#javascript_examples">MDN
   * recommendations</a>
   */
  public void show() {
    show(() -> {});
  }

  /**
   * Applies {@code fade-in} css class which sets the {@code opacity} to 1
   *
   * <p>
   *
   * <p>{@link DomGlobal#setTimeout(SetTimeoutCallbackFn callback, double delay, Object...
   * callbackParams)} was used based on <a
   * href="https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Transitions/Using_CSS_transitions#javascript_examples">MDN
   * recommendations</a>
   */
  public void show(Runnable onBeforeShow) {
    inAnimation
        .beforeStart(
            element -> {
              DominoElement.of(target).addCss(FADE);
              onBeforeShow.run();
            })
        .animate();
    setTimeout(
        p0 -> {
          target.addCss(IN);
        },
        0);
  }

  /**
   * Removes {@code fade-in} css class which sets the {@code opacity} to 0 and after transition
   * ends, call {@code onHide} callback
   */
  public void hide() {
    outAnimation.animate();
  }

  private void addHideListener(EventListener targetListener, Consumer<EventListener> consumer) {
    EventListener eventListener =
        new EventListener() {
          @Override
          public void handleEvent(Event evt) {
            DomGlobal.console.info("Closing tooltip with ID " + target.getDominoId());
            targetListener.handleEvent(evt);
            consumer.accept(this);
          }
        };
    target.addEventListener("webkitAnimationEnd", eventListener);
    target.addEventListener("MSAnimationEnd", eventListener);
    target.addEventListener("mozAnimationEnd", eventListener);
    target.addEventListener("oanimationend", eventListener);
    target.addEventListener("animationend", eventListener);
    target.addEventListener("transitioncancel", eventListener);
  }
}
