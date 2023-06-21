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
 * A utility class that allow execution of logic after a specific delay
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DelayedExecution {

  /**
   * execute.
   *
   * @param delayedAction a {@link org.dominokit.domino.ui.utils.DelayedExecution.DelayedAction}
   *     object
   * @param delay a int
   */
  public static void execute(DelayedAction delayedAction, int delay) {
    new Timer() {
      @Override
      public void run() {
        delayedAction.doAction();
      }
    }.schedule(delay);
  }

  /** A function to implement the action to be taken for {@link DelayedTextInput} */
  @FunctionalInterface
  public interface DelayedAction {
    /** */
    void doAction();
  }
}
