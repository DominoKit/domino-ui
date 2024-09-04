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
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.EventType;

/**
 * A component that wraps an {@link HTMLInputElement} and performs an action when the user stops
 * typing in the input after a configurable delay
 *
 * <pre>
 * TextBox search = TextBox.create("Search");
 * DelayedTextInput.create(search.getInputElement(), 300)
 *         .setDelayedAction(() -> Notification.create(search.getValue()).show());
 * </pre>
 */
public class DelayedTextInput {

  private int delay;
  private final HTMLInputElement inputElement;
  private Timer autoActionTimer;
  private DelayedAction delayedAction = () -> {};
  private DelayedAction onEnterAction = () -> delayedAction.doAction();

  /**
   * @param inputElement {@link HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @param delayedAction {@link DelayedAction}
   * @return new instance
   */
  public static DelayedTextInput create(
      HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
    return new DelayedTextInput(inputElement, delay, delayedAction);
  }

  /**
   * @param inputElement {@link HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @return new instance
   */
  public static DelayedTextInput create(HTMLInputElement inputElement, int delay) {
    return new DelayedTextInput(inputElement, delay);
  }

  /**
   * @param inputElement {@link HTMLInputElement} wrapped as {@link DominoElement}
   * @param delay int delay in milli-seconds
   * @return new instance
   */
  public static DelayedTextInput create(DominoElement<HTMLInputElement> inputElement, int delay) {
    return create(inputElement.element(), delay);
  }

  /**
   * @param inputElement {@link HTMLInputElement}
   * @param delay int delay in milli-seconds
   */
  public DelayedTextInput(HTMLInputElement inputElement, int delay) {
    this.inputElement = inputElement;
    this.delay = delay;
    prepare();
  }

  /**
   * @param inputElement {@link HTMLInputElement}
   * @param delay int delay in milli-seconds
   * @param delayedAction {@link DelayedAction}
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
   * @param delayedAction {@link DelayedAction} that will be executed when the user stop typing
   * @return same instance
   */
  public DelayedTextInput setDelayedAction(DelayedAction delayedAction) {
    this.delayedAction = delayedAction;
    return this;
  }
  /** @return the {@link DelayedAction} that will be executed when the user press Enter key */
  public DelayedAction getOnEnterAction() {
    return onEnterAction;
  }

  /**
   * @param onEnterAction {@link DelayedAction} that will be executed when the user press Enter key
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
   * @return int delay in milli-seconds before executing the {@link DelayedAction} after the user
   *     stops typing
   */
  public int getDelay() {
    return delay;
  }

  /**
   * @param delay int delay in milli-seconds before executing the {@link DelayedAction} after the
   *     user stops typing
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
