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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.Domino.*;
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
  private EventListener startListener;
  private EventListener cancelListener;
  private EventListener endListener;
  private Set<TransitionListener<? super T>> startListeners;
  private Set<TransitionListener<? super T>> cancelListeners;
  private Set<TransitionListener<? super T>> endListeners;

  private LazyInitializer eventsLazyInitializer;

  public static <E extends Element, T extends IsElement<E>> TransitionListeners<E, T> of(T target) {
    return new TransitionListeners<>(target);
  }

  public TransitionListeners(T target) {
    this.target = target;
  }

  private LazyInitializer getEventsLazyInitializer() {
    if (isNull(this.eventsLazyInitializer)) {
      this.eventsLazyInitializer =
          new LazyInitializer(
              () -> {
                elements
                    .elementOf(target)
                    .addEventListener(
                        "webkitTransitionStart",
                        getStartListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "oTransitionStart",
                        getStartListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "transitionstart",
                        getStartListener(target),
                        EventOptions.of().setCapture(false));

                elements
                    .elementOf(target)
                    .addEventListener(
                        "webkitTransitionCancel",
                        getCancelListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "oTransitionCancel",
                        getCancelListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "transitioncancel",
                        getCancelListener(target),
                        EventOptions.of().setCapture(false));

                elements
                    .elementOf(target)
                    .addEventListener(
                        "webkitTransitionEnd",
                        getEndListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "oTransitionEnd",
                        getEndListener(target),
                        EventOptions.of().setCapture(false));
                elements
                    .elementOf(target)
                    .addEventListener(
                        "transitionend",
                        getEndListener(target),
                        EventOptions.of().setCapture(false));
              });
    }
    return this.eventsLazyInitializer;
  }

  private EventListener getEndListener(T target) {
    if (isNull(this.endListener)) {
      this.endListener =
          evt -> {
            if (evt.target.equals(this.target.element())) {
              getEndListeners().forEach(listener -> listener.onTransitionEvent(target));
            }
          };
    }
    return this.endListener;
  }

  private EventListener getStartListener(T target) {
    if (isNull(startListener)) {
      startListener =
          evt -> {
            getStartListeners()
                .forEach(
                    listener -> {
                      if (evt.target.equals(this.target.element())) {
                        listener.onTransitionEvent(target);
                      }
                    });
          };
    }
    return startListener;
  }

  private EventListener getCancelListener(T target) {
    if (isNull(cancelListener)) {
      this.cancelListener =
          evt -> {
            if (evt.target.equals(this.target.element())) {
              getCancelListeners().forEach(listener -> listener.onTransitionEvent(target));
            }
          };
    }
    return this.cancelListener;
  }

  private Set<TransitionListener<? super T>> getEndListeners() {
    if (isNull(endListeners)) {
      this.endListeners = new HashSet<>();
    }
    return endListeners;
  }

  private Set<TransitionListener<? super T>> getCancelListeners() {
    if (isNull(cancelListeners)) {
      this.cancelListeners = new HashSet<>();
    }
    return cancelListeners;
  }

  private Set<TransitionListener<? super T>> getStartListeners() {
    if (isNull(this.startListeners)) {
      this.startListeners = new HashSet<>();
    }
    return startListeners;
  }

  public TransitionListeners<E, T> onTransitionStart(TransitionListener<? super T> listener) {
    getEventsLazyInitializer().apply();
    getStartListeners().add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionStartListener(
      TransitionListener<? super T> listener) {
    getStartListeners().remove(listener);
    return this;
  }

  public TransitionListeners<E, T> onTransitionCancel(TransitionListener<? super T> listener) {
    getEventsLazyInitializer().apply();
    getCancelListeners().add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionCancelListener(
      TransitionListener<? super T> listener) {
    getCancelListeners().remove(listener);
    return this;
  }

  public TransitionListeners<E, T> onTransitionEnd(TransitionListener<? super T> listener) {
    getEventsLazyInitializer().apply();
    getEndListeners().add(listener);
    return this;
  }

  public TransitionListeners<E, T> removeTransitionEndListener(
      TransitionListener<? super T> listener) {
    getEndListeners().remove(listener);
    return this;
  }
}
