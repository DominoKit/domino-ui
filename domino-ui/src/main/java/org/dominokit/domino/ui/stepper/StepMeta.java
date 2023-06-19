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

import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

public class StepMeta implements ComponentMeta {
  public static final String DUI_STEP_META = "dui-step-meta";

  private final Step step;

  public StepMeta(Step step) {
    this.step = step;
  }

  public static StepMeta of(Step step) {
    return new StepMeta(step);
  }

  public static Optional<StepMeta> get(HasMeta<?> component) {
    return component.getMeta(DUI_STEP_META);
  }

  public Step getStep() {
    return step;
  }

  @Override
  public String getKey() {
    return DUI_STEP_META;
  }
}
