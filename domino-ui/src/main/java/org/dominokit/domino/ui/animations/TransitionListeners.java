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
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.events.EventOptions;
import org.dominokit.domino.ui.utils.LazyInitializer;

public class TransitionListeners<E extends Element, T extends IsElement<E>> {

  private final T target;
  private final Set<TransitionListener<? super T>> startListeners = new HashSet<>();
  private final Set<TransitionListener<? super T>> cancelListeners = new HashSet<>();
  private final Set<TransitionListener<? super T>> endListeners = new HashSet<>();

  private final LazyInitializer eventsLazyInitializer;

  public static <E extends Element, T extends IsElement<E>> TransitionListeners<E, T> of(T target) {
    return new TransitionListeners<>(target);
  }

  public TransitionListeners(T target) {
    this.target = target;
    EventListener startListener =
        evt -> {
          startListeners.forEach(
              listener -> {
                if (evt.target.equals(this.target.element())) {
                  listener.onTransitionEvent(target);
                }
              });
        };
    EventListener cancelListener =
        evt -> {
          if (evt.target.equals(this.target.element())) {
            cancelListeners.forEach(listener -> listener.onTransitionEvent(target));
          }
        };
    EventListener endListener =
        evt -> {
          if (evt.target.equals(this.target.element())) {
            endListeners.forEach(listener -> listener.onTransitionEvent(target));
          }
        };
    this.eventsLazyInitializer =
        new LazyInitializer(
            () -> {
              elements
                  .elementOf(target)
                  .addEventListener(
                      "webkitTransitionStart", startListener, EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "oTransitionStart", startListener, EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "transitionstart", startListener, EventOptions.of().setCapture(false));

              elements
                  .elementOf(target)
                  .addEventListener(
                      "webkitTransitionCancel",
                      cancelListener,
                      EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "oTransitionCancel", cancelListener, EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "transitioncancel", cancelListener, EventOptions.of().setCapture(false));

              elements
                  .elementOf(target)
                  .addEventListener(
                      "webkitTransitionEnd", endListener, EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "oTransitionEnd", endListener, EventOptions.of().setCapture(false));
              elements
                  .elementOf(target)
                  .addEventListener(
                      "transitionend", endListener, EventOptions.of().setCapture(false));
            });
  }

  public TransitionListeners<E, T> onTransitionStart(TransitionListener<? super T> listener) {
    eventsLazyInitializer.apply();
    startListeners.add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionStartListener(
      TransitionListener<? super T> listener) {
    startListeners.remove(listener);
    return this;
  }

  public TransitionListeners<E, T> onTransitionCancel(TransitionListener<? super T> listener) {
    eventsLazyInitializer.apply();
    cancelListeners.add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionCancelListener(
      TransitionListener<? super T> listener) {
    cancelListeners.remove(listener);
    return this;
  }

  public TransitionListeners<E, T> onTransitionEnd(TransitionListener<? super T> listener) {
    eventsLazyInitializer.apply();
    endListeners.add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionEndListener(
      TransitionListener<? super T> listener) {
    endListeners.remove(listener);
    return this;
  }
}
