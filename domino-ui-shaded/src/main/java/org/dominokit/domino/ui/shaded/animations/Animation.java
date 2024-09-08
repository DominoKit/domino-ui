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
package org.dominokit.domino.ui.shaded.animations;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.IsElement;

/**
 * Animates an {@link HTMLElement}
 *
 * <p>This class is used to animate an HTMLElement and provide a set of method to configure the
 * animation, also provide some method to add some callback during different animation phases
 *
 * <p>For example:
 *
 * <pre>
 *
 *  Animation.create(htmlElement)
 *           .duration(1000)
 *           .transition(Transition.BOUNCE)
 *           .animate();
 *
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/animation">Animation on MDN</a>
 */
@Deprecated
public class Animation {

  private final CompleteCallback DEFAULT_CALLBACK = element -> {};
  private final StartHandler DEFAULT_START_HANDLER = element -> {};

  private int duration = 800;
  private int delay = 0;
  private boolean infinite = false;
  private final DominoElement<HTMLElement> element;
  private Transition transition = Transition.BOUNCE;
  private CompleteCallback callback = DEFAULT_CALLBACK;
  private StartHandler startHandler = DEFAULT_START_HANDLER;
  private EventListener stopListener;
  private double repeatCount = 1;
  private Timer delayTimer;

  /** @param element an {@link HTMLElement} to be animated */
  public Animation(HTMLElement element) {
    this.element = DominoElement.of(element);
    delayTimer =
        new Timer() {
          @Override
          public void run() {
            animateElement();
          }
        };
  }

  /**
   * @param element an {@link HTMLElement} to be animated
   * @param duration int duration of animation in milliseconds
   * @param delay int delay in millisecond before the animation starts
   * @param infinite boolean repeat this animation infinitely or until {@link Animation#stop()} is
   *     called
   */
  public Animation(HTMLElement element, int duration, int delay, boolean infinite) {
    this(element);
    this.duration = duration;
    this.delay = delay;
    this.infinite = infinite;
  }

  /**
   * static factory method to create an animation for an {@link HTMLElement}
   *
   * @param element an {@link HTMLElement} to be animated
   * @return an {@link Animation} instance
   */
  public static Animation create(HTMLElement element) {
    return new Animation(element);
  }

  /**
   * static factory method to create an animation for an {@link IsElement} this method will create
   * an animation for the {@link HTMLElement} wrapped in the {@link IsElement}
   *
   * @param element an {@link IsElement} to be animated
   * @return an {@link Animation} instance
   */
  public static Animation create(IsElement<?> element) {
    return new Animation(element.element());
  }

  /**
   * sets the duration for this animation
   *
   * @param duration int duration in milliseconds
   * @return same instance
   */
  public Animation duration(int duration) {
    this.duration = duration;
    return this;
  }

  /**
   * sets the time the animation should wait before actually animate the element after {@link
   * Animation#animate()} is called
   *
   * @param delay in delay in milliseconds
   * @return same instance
   */
  public Animation delay(int delay) {
    this.delay = delay;
    return this;
  }

  /**
   * sets the animation as infinite so once the animation starts it will repeat infinitely or until
   * {@link Animation#stop()} is called
   *
   * @return same instance
   */
  public Animation infinite() {
    this.infinite = true;
    return this;
  }

  /**
   * sets the transition type for this animation.
   *
   * @param transition a {@link Transition} value
   * @return same instance
   */
  public Animation transition(Transition transition) {
    this.transition = transition;
    return this;
  }

  /**
   * sets the animation to repeat for a specific number of times or until {@link Animation#stop()}
   * is called.
   *
   * @param repeatCount double the number of times the animation to be repeated e.g
   *     <pre>2.5</pre>
   *     repeats the animation 2 times and a half
   * @return same instance
   */
  public Animation repeat(double repeatCount) {
    this.repeatCount = repeatCount;
    return this;
  }

  /**
   * sets some logic to be executed when the animation is completed
   *
   * @param callback a {@link CompleteCallback} to be executed
   * @return same instance
   */
  public Animation callback(CompleteCallback callback) {
    this.callback = callback;
    return this;
  }

  /**
   * sets some logic to be executed before the animation starts
   *
   * @param startHandler {@link StartHandler} to be executed
   * @return same instance
   */
  public Animation beforeStart(StartHandler startHandler) {
    this.startHandler = startHandler;
    return this;
  }

  /**
   * starts animating the element, if there is a delay the animation will start after the delay
   *
   * @return same instance
   */
  public Animation animate() {
    if (delay > 0) {
      delayTimer.schedule(delay);
    } else {
      animateElement();
    }

    return this;
  }

  private void animateElement() {
    this.startHandler.beforeStart(element.element());
    this.stopListener = evt -> stop();

    element.addEventListener("webkitAnimationEnd", stopListener);
    element.addEventListener("MSAnimationEnd", stopListener);
    element.addEventListener("mozAnimationEnd", stopListener);
    element.addEventListener("oanimationend", stopListener);
    element.addEventListener("animationend", stopListener);

    element.setTransitionDuration(duration + "ms");
    element.setCssProperty("animation-duration", duration + "ms");
    element.setCssProperty("-webkit-animation-duration", duration + "ms");
    if (infinite) {
      element.addCss("infinite");
    }

    if (repeatCount != 1) {
      element.setCssProperty("animation-iteration-count", repeatCount + "");
    }

    element.addCss("animated");
    element.addCss("ease-in-out");
    element.addCss(transition.getStyle());
  }

  /** stops the animation and calls the {@link CompleteCallback} if it is set. */
  public void stop() {
    stop(false);
  }

  /** stops the animation and calls the {@link CompleteCallback} if it is set. */
  public void stop(boolean silent) {
    delayTimer.cancel();
    element.removeCss(transition.getStyle());
    element.removeCss("animated");
    element.removeCss("infinite");
    element.removeCss("ease-in-out");
    element.removeCssProperty("animation-duration");
    element.removeCssProperty("-webkit-animation-duration");
    element.removeEventListener("webkitAnimationEnd", stopListener);
    element.removeEventListener("MSAnimationEnd", stopListener);
    element.removeEventListener("mozAnimationEnd", stopListener);
    element.removeEventListener("oanimationend", stopListener);
    element.removeEventListener("animationend", stopListener);
    if (!silent) {
      callback.onComplete(element.element());
    }
  }

  /**
   * An implementation of this interface will provide some logic to be executed right after the
   * animation is completed
   */
  @FunctionalInterface
  @Deprecated
  public interface CompleteCallback {
    /** @param element an {@link HTMLElement} that is being animated */
    void onComplete(HTMLElement element);
  }

  /**
   * An implementation of this interface will provide some logic to be executed right before the
   * animation starts
   */
  @FunctionalInterface
  @Deprecated
  public interface StartHandler {
    /** @param element an {@link HTMLElement} that is being animated */
    void beforeStart(HTMLElement element);
  }
}
