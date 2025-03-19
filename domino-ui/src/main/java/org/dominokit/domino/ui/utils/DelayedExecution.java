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

import org.dominokit.domino.ui.config.DelayedActionConfig;
import org.gwtproject.timer.client.Timer;

/**
 * The {@code DelayedExecution} class provides a simple utility for executing actions with a
 * specified delay using GWT Timer.
 *
 * <p>Example Usage:
 *
 * <pre>
 * DelayedExecution.execute(() -> {
 *   // Perform some action after a delay of 1000 milliseconds (1 second).
 *   // This action is specified using a lambda expression.
 *   // You can replace this with your custom action.
 * }, 1000);
 * </pre>
 */
public class DelayedExecution {

  private final Timer timer;
  private final int delay;

  private DelayedExecution(DelayedAction delayedAction, int delay) {
    this.timer =
        new Timer() {
          @Override
          public void run() {
            delayedAction.doAction();
          }
        };
    this.delay = delay;
    this.timer.schedule(delay);
  }

  public DelayedExecution cancel() {
    this.timer.cancel();
    return this;
  }

  public DelayedExecution reschedule() {
    this.timer.schedule(delay);
    return this;
  }

  public DelayedExecution reschedule(int delay) {
    this.timer.schedule(delay);
    return this;
  }

  /**
   * Executes the specified {@code delayedAction} after the specified delay defined in {@link
   * DelayedActionConfig#getDelayedExecutionDefaultDelay()}.
   *
   * @param delayedAction The action to be executed after the delay.
   */
  public static DelayedExecution execute(DelayedAction delayedAction) {
    return execute(
        delayedAction, DominoUIConfig.CONFIG.getUIConfig().getDelayedExecutionDefaultDelay());
  }

  /**
   * Executes the specified {@code delayedAction} after the specified {@code delay} in milliseconds.
   *
   * @param delayedAction The action to be executed after the delay.
   * @param delay The delay in milliseconds before executing the action.
   */
  public static DelayedExecution execute(DelayedAction delayedAction, int delay) {
    return new DelayedExecution(delayedAction, delay);
  }

  /** A functional interface representing an action to be executed after a delay. */
  @FunctionalInterface
  public interface DelayedAction {
    /** Performs the action that should be executed after the delay. */
    void doAction();
  }
}
