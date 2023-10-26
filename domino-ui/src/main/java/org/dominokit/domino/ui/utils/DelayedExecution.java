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

  /**
   * Executes the specified {@code delayedAction} after the specified {@code delay} in milliseconds.
   *
   * @param delayedAction The action to be executed after the delay.
   * @param delay The delay in milliseconds before executing the action.
   */
  public static void execute(DelayedAction delayedAction, int delay) {
    new Timer() {
      @Override
      public void run() {
        delayedAction.doAction();
      }
    }.schedule(delay);
  }

  /** A functional interface representing an action to be executed after a delay. */
  @FunctionalInterface
  public interface DelayedAction {
    /** Performs the action that should be executed after the delay. */
    void doAction();
  }
}
