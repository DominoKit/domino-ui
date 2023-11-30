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
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.events.EventType;
import org.gwtproject.timer.client.Timer;

/**
 * The {@code DelayedTextInput} class provides a utility for capturing text input events in an HTML
 * input element and triggering actions with a specified delay.
 *
 * <p>Example Usage:
 *
 * <pre>
 * HTMLInputElement inputElement = // Get the input element from the DOM
 * DelayedTextInput delayedTextInput = DelayedTextInput.create(inputElement, 1000, () -> {
 *   // Perform an action after a delay of 1000 milliseconds (1 second) when text input changes.
 *   // This action is specified using a lambda expression.
 *   // You can replace this with your custom action.
 * });
 * </pre>
 */
public class DelayedTextInput {

  private int delay;
  private final HTMLInputElement inputElement;
  private Timer autoActionTimer;
  private DelayedAction delayedAction = () -> {};
  private DelayedAction onEnterAction = () -> delayedAction.doAction();

  /**
   * Creates a {@code DelayedTextInput} instance for the given HTML input element with a specified
   * delay and an action to execute on text input changes.
   *
   * @param inputElement The HTML input element to monitor for text input changes.
   * @param delay The delay in milliseconds before triggering the action.
   * @param delayedAction The action to execute when text input changes after the specified delay.
   * @return A {@code DelayedTextInput} instance.
   */
  public static DelayedTextInput create(
      HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
    return new DelayedTextInput(inputElement, delay, delayedAction);
  }

  /**
   * Creates a {@code DelayedTextInput} instance for the given HTML input element with a specified
   * delay.
   *
   * @param inputElement The HTML input element to monitor for text input changes.
   * @param delay The delay in milliseconds before triggering the action.
   * @return A {@code DelayedTextInput} instance.
   */
  public static DelayedTextInput create(HTMLInputElement inputElement, int delay) {
    return new DelayedTextInput(inputElement, delay);
  }

  /**
   * Creates a {@code DelayedTextInput} instance for the given DominoElement with a specified delay.
   *
   * @param inputElement The DominoElement wrapping the HTML input element to monitor for text input
   *     changes.
   * @param delay The delay in milliseconds before triggering the action.
   * @return A {@code DelayedTextInput} instance.
   */
  public static DelayedTextInput create(DominoElement<HTMLInputElement> inputElement, int delay) {
    return create(inputElement.element(), delay);
  }

  /**
   * Creates a {@code DelayedTextInput} instance for the given InputElement with a specified delay.
   *
   * @param inputElement The DominoElement wrapping the HTML input element to monitor for text input
   *     changes.
   * @param delay The delay in milliseconds before triggering the action.
   * @return A {@code DelayedTextInput} instance.
   */
  public static DelayedTextInput create(InputElement inputElement, int delay) {
    return create(inputElement.element(), delay);
  }

  /**
   * Constructs a {@code DelayedTextInput} instance for the given HTML input element with a
   * specified delay.
   *
   * @param inputElement The HTML input element to monitor for text input changes.
   * @param delay The delay in milliseconds before triggering the action.
   */
  public DelayedTextInput(HTMLInputElement inputElement, int delay) {
    this.inputElement = inputElement;
    this.delay = delay;
    prepare();
  }

  /**
   * Constructs a {@code DelayedTextInput} instance for the given HTML input element with a
   * specified delay and an action to execute on text input changes.
   *
   * @param inputElement The HTML input element to monitor for text input changes.
   * @param delay The delay in milliseconds before triggering the action.
   * @param delayedAction The action to execute when text input changes after the specified delay.
   */
  public DelayedTextInput(HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
    this.inputElement = inputElement;
    this.delay = delay;
    this.delayedAction = delayedAction;

    prepare();
  }

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
            autoActionTimer.cancel();
            DelayedTextInput.this.onEnterAction.doAction();
          }
        });
  }

  /**
   * Sets the action to be executed after the specified delay when text input changes.
   *
   * @param delayedAction The action to execute when text input changes after the specified delay.
   * @return This {@code DelayedTextInput} instance.
   */
  public DelayedTextInput setDelayedAction(DelayedAction delayedAction) {
    this.delayedAction = delayedAction;
    return this;
  }

  /**
   * Gets the action to be executed when the Enter key is pressed after the specified delay.
   *
   * @return The action to execute when Enter key is pressed.
   */
  public DelayedAction getOnEnterAction() {
    return onEnterAction;
  }

  /**
   * Sets the action to be executed when the Enter key is pressed after the specified delay.
   *
   * @param onEnterAction The action to execute when Enter key is pressed.
   * @return This {@code DelayedTextInput} instance.
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
   * Gets the current delay in milliseconds before triggering the action.
   *
   * @return The delay in milliseconds.
   */
  public int getDelay() {
    return delay;
  }

  /**
   * Sets the delay in milliseconds before triggering the action.
   *
   * @param delay The delay in milliseconds.
   */
  public void setDelay(int delay) {
    this.delay = delay;
  }

  /** A functional interface representing an action to be executed after a delay. */
  @FunctionalInterface
  public interface DelayedAction {
    /** Performs the action that should be executed after the delay. */
    void doAction();
  }
}
