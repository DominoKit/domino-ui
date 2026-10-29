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
package org.dominokit.domino.ui.animations;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.Arrays;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;

/**
 * Animates components and elements.
 *
 * <p>This class is used to animate an HTMLElement and provide a set of method to configure the
 * animation and register callbacks like, onBeforeStart and onComplete
 *
 * <p>Example:
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
public class Animation {

  private final CompleteCallback DEFAULT_CALLBACK = element -> {};
  private final StartHandler DEFAULT_START_HANDLER = element -> {};

  private int duration = 800;
  private int delay = 0;
  private boolean infinite = false;
  private final DominoElement<Element> element;
  private Transition transition = Transition.FADE_IN;
  private CompleteCallback callback = DEFAULT_CALLBACK;
  private StartHandler startHandler = DEFAULT_START_HANDLER;
  private EventListener stopListener;
  private double repeatCount = 1;
  private boolean completed = false;

  /**
   * Creates a new Animation instance for the provided element.
   *
   * @param element an {@link Element} to be animated
   */
  public Animation(Element element) {
    this.element = elements.elementOf(element);
  }

  /**
   * Creates a new Animation instance for the provided element and specify the duration, delay and
   * the if it will be an infinite animation or not.
   *
   * @param element an {@link elemental2.dom.Element} to be animated
   * @param duration int duration of animation in milliseconds
   * @param delay int delay in millisecond before the animation starts
   * @param infinite boolean repeat this animation infinitely or until {@link
   *     org.dominokit.domino.ui.animations.Animation#stop()} is called
   */
  public Animation(HTMLElement element, int duration, int delay, boolean infinite) {
    this(element);
    this.duration = duration;
    this.delay = delay;
    this.infinite = infinite;
  }

  /**
   * Factory method to create an animation for an {@link elemental2.dom.Element}
   *
   * @param element an {@link elemental2.dom.Element} to be animated
   * @return an {@link org.dominokit.domino.ui.animations.Animation} instance
   */
  public static Animation create(Element element) {
    return new Animation(element);
  }

  /**
   * static factory method to create an animation for an {@link org.dominokit.domino.ui.IsElement}
   * this method will create an animation for the {@link elemental2.dom.HTMLElement} wrapped in the
   * {@link org.dominokit.domino.ui.IsElement}
   *
   * @param element an {@link org.dominokit.domino.ui.IsElement} to be animated
   * @return an {@link org.dominokit.domino.ui.animations.Animation} instance
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
   * Sets the time the animation should wait before actually animate the element after {@link
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
   * Sets the animation as infinite so once the animation starts it will repeat infinitely or until
   * {@link org.dominokit.domino.ui.animations.Animation#stop()} is called
   *
   * @return same instance
   */
  public Animation infinite() {
    this.infinite = true;
    return this;
  }

  /**
   * Checks whether the animation is set to repeat infinitely.
   *
   * @return true if the animation repeats infinitely, false otherwise
   */
  public boolean isInfinite() {
    return infinite;
  }

  /**
   * Sets whether the animation should repeat infinitely or not.
   *
   * @param infinite boolean value indicating if the animation should repeat infinitely. Pass <code>
   *     true</code> to make the animation repeat indefinitely, or <code>false</code> to disable
   *     infinite repetition.
   * @return the current instance of the {@link Animation} class for method chaining.
   */
  public Animation setInfinite(boolean infinite) {
    this.infinite = infinite;
    return this;
  }

  /**
   * Sets the transition type for this animation.
   *
   * @param transition a {@link org.dominokit.domino.ui.animations.Transition} value
   * @return same instance
   */
  public Animation transition(Transition transition) {
    this.transition = transition;
    return this;
  }

  /**
   * Sets the animation to repeat for a specific number of times or until {@link
   * org.dominokit.domino.ui.animations.Animation#stop()} is called.
   *
   * @param repeatCount double, The number of times the animation to be repeated, Example <b>2.5</b>
   *     repeats the animation 2 times and a half
   * @return same instance
   */
  public Animation repeat(double repeatCount) {
    this.repeatCount = repeatCount;
    return this;
  }

  /**
   * Register a callback be executed when the animation is completed
   *
   * @param callback a {@link org.dominokit.domino.ui.animations.Animation.CompleteCallback} to be
   *     executed
   * @return same instance
   */
  public Animation callback(CompleteCallback callback) {
    this.callback = callback;
    return this;
  }

  /**
   * Register a callback be executed before the animation starts
   *
   * @param startHandler {@link org.dominokit.domino.ui.animations.Animation.StartHandler} to be
   *     executed
   * @return same instance
   */
  public Animation beforeStart(StartHandler startHandler) {
    this.startHandler = startHandler;
    return this;
  }

  /**
   * Starts animating the element, if there is a delay the animation will start after the delay
   *
   * @return same instance
   */
  public Animation animate() {
    this.completed = false;
    if (delay > 0) {
      new Timer() {
        @Override
        public void run() {
          animateElement();
        }
      }.schedule(delay);
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
    Arrays.asList(transition).forEach(t -> element.addCss(t.getStyle()));
    ;
  }

  /**
   * stops the animation and calls the {@link
   * org.dominokit.domino.ui.animations.Animation.CompleteCallback} if registered.
   */
  public void stop() {
    stop(false);
  }

  /**
   * Stops the animation and calls the registered {@link
   * org.dominokit.domino.ui.animations.Animation.CompleteCallback} only if silent is set to false.
   *
   * @param silent boolean, <b>true</b> to ignore the callback when animation completed,
   *     <b>false</b> to execute the callback.
   */
  public void stop(boolean silent) {
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
    this.completed = true;
  }

  public boolean isCompleted() {
    return completed;
  }

  /**
   * An implementation of this interface will provide some logic to be executed right after the
   * animation is completed
   */
  @FunctionalInterface
  public interface CompleteCallback {
    /**
     * @param element an {@link Element} that is being animated
     */
    void onComplete(Element element);
  }

  /**
   * An implementation of this interface will provide some logic to be executed right before the
   * animation starts
   */
  @FunctionalInterface
  public interface StartHandler {
    /**
     * @param element an {@link Element} that is being animated
     */
    void beforeStart(Element element);
  }
}
