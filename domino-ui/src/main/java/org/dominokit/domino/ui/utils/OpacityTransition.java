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
import org.jboss.elemento.IsElement;

/** Utility which handles {@code opacity} transition */
public class OpacityTransition {

  private static final String TRANSITIONEND = "transitionend";

  private final DominoElement<? extends HTMLElement> target;
  private final EventListener onHide;

  public OpacityTransition(HTMLElement target, EventListener onHide) {
    this.target = DominoElement.of(target);
    this.target.addCss(FADE);
    this.onHide = onHide;
  }

  public OpacityTransition(IsElement<? extends HTMLElement> target, EventListener onHide) {
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
    setTimeout(p0 -> target.addCss(IN), 0);
  }

  /**
   * Removes {@code fade-in} css class which sets the {@code opacity} to 0 and after transition
   * ends, call {@code onHide} callback
   */
  public void hide() {
    addHideListener(
        onHide, eventListener -> target.removeEventListener(TRANSITIONEND, eventListener));
    target.removeCss(IN);
  }

  private void addHideListener(EventListener targetListener, Consumer<EventListener> consumer) {
    EventListener eventListener =
        new EventListener() {
          @Override
          public void handleEvent(Event evt) {
            targetListener.handleEvent(evt);
            consumer.accept(this);
          }
        };
    target.addEventListener(TRANSITIONEND, eventListener);
  }
}
