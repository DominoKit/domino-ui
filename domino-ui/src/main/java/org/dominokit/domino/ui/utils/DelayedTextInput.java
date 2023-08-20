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

import static java.util.Objects.isNull;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.events.EventType;
import org.gwtproject.timer.client.Timer;

/**
 * A component that wraps an {@link elemental2.dom.HTMLInputElement} and performs an action when the
 * user stops typing in the input after a configurable delay </pre>
 */
public class DelayedTextInput {

  private int delay;
  private final HTMLInputElement inputElement;
  private Timer autoActionTimer;
  private DelayedAction delayedAction = () -> {};
  private DelayedAction onEnterAction = () -> delayedAction.doAction();

  /**
   * create.
   *
   * @param inputElement {@link elemental2.dom.HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @param delayedAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
   * @return new instance
   */
  public static DelayedTextInput create(
      HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
    return new DelayedTextInput(inputElement, delay, delayedAction);
  }

  /**
   * create.
   *
   * @param inputElement {@link elemental2.dom.HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @return new instance
   */
  public static DelayedTextInput create(HTMLInputElement inputElement, int delay) {
    return new DelayedTextInput(inputElement, delay);
  }

  /**
   * create.
   *
   * @param inputElement {@link elemental2.dom.HTMLInputElement} wrapped as {@link
   *     org.dominokit.domino.ui.utils.DominoElement}
   * @param delay int delay in milli-seconds
   * @return new instance
   */
  public static DelayedTextInput create(DominoElement<HTMLInputElement> inputElement, int delay) {
    return create(inputElement.element(), delay);
  }

  /**
   * Constructor for DelayedTextInput.
   *
   * @param inputElement {@link elemental2.dom.HTMLInputElement}
   * @param delay int delay in milli-seconds
   */
  public DelayedTextInput(HTMLInputElement inputElement, int delay) {
    this.inputElement = inputElement;
    this.delay = delay;
    prepare();
  }

  /**
   * Constructor for DelayedTextInput.
   *
   * @param inputElement {@link elemental2.dom.HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @param delayedAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
   */
  public DelayedTextInput(HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
    this.inputElement = inputElement;
    this.delay = delay;
    this.delayedAction = delayedAction;

    prepare();
  }

  /** Initialize the component and the delay timer */
  protected void prepare() {
    autoActionTimer =
        new Timer() {
          @Override
          public void run() {
            DelayedTextInput.this.delayedAction.doAction();
          }
        };

    inputElement.addEventListener(
        "input",
        evt -> {
          autoActionTimer.cancel();
          autoActionTimer.schedule(this.delay);
        });

    inputElement.addEventListener(
        EventType.keypress.getName(),
        evt -> {
          if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
            DelayedTextInput.this.onEnterAction.doAction();
          }
        });
  }

  /**
   * Setter for the field <code>delayedAction</code>.
   *
   * @param delayedAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} that
   *     will be executed when the user stop typing
   * @return same instance
   */
  public DelayedTextInput setDelayedAction(DelayedAction delayedAction) {
    this.delayedAction = delayedAction;
    return this;
  }
  /** @return the {@link DelayedAction} that will be executed when the user press Enter key */
  /**
   * Getter for the field <code>onEnterAction</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} object
   */
  public DelayedAction getOnEnterAction() {
    return onEnterAction;
  }

  /**
   * Setter for the field <code>onEnterAction</code>.
   *
   * @param onEnterAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} that
   *     will be executed when the user press Enter key
   * @return same instance
   */
  public DelayedTextInput setOnEnterAction(DelayedAction onEnterAction) {
    if (isNull(onEnterAction)) {
      this.onEnterAction = delayedAction;
    } else {
      this.onEnterAction = onEnterAction;
    }

    return this;
  }

  /**
   * Getter for the field <code>delay</code>.
   *
   * @return int delay in milli-seconds before executing the {@link
   *     org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} after the user stops typing
   */
  public int getDelay() {
    return delay;
  }

  /**
   * Setter for the field <code>delay</code>.
   *
   * @param delay int delay in milli-seconds before executing the {@link
   *     org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} after the user stops typing
   */
  public void setDelay(int delay) {
    this.delay = delay;
  }

  /** A function to implement the action to be taken for {@link DelayedTextInput} */
  @FunctionalInterface
  public interface DelayedAction {
    /** */
    void doAction();
  }
}
