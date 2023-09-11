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
package org.dominokit.domino.ui.stepper;

/** StepState interface. */
public interface StepState extends StepperStyles {
  /** Constant <code>ACTIVE</code> */
  StepState ACTIVE = new ActiveStep();
  /** Constant <code>INACTIVE</code> */
  StepState INACTIVE = new InactiveStep();
  /** Constant <code>COMPLETED</code> */
  StepState COMPLETED = new CompletedStep();
  /** Constant <code>DISABLED</code> */
  StepState DISABLED = new DisabledStep();
  /** Constant <code>ERROR</code> */
  StepState ERROR = new ErrorStep();
  /** Constant <code>WARNING</code> */
  StepState WARNING = new WarningStep();
  /** Constant <code>SKIPPED</code> */
  StepState SKIPPED = new SkippedStep();

  /**
   * apply.
   *
   * @param tracker a {@link org.dominokit.domino.ui.stepper.StepTracker} object
   */
  void apply(StepTracker tracker);

  /**
   * cleanUp.
   *
   * @param tracker a {@link org.dominokit.domino.ui.stepper.StepTracker} object
   */
  void cleanUp(StepTracker tracker);

  /**
   * getKey.
   *
   * @return a {@link java.lang.String} object
   */
  String getKey();
}
