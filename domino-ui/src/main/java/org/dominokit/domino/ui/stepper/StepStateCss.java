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

import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.ReplaceCssClass;

public interface StepStateCss {

  CssClass dui_step_state_completed =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(() -> "dui-step-state-completed");
  CssClass dui_step_state_disabled =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(() -> "dui-step-state-disabled");
  CssClass dui_step_state_error =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(() -> "dui-step-state-error");
  CssClass dui_step_state_skipped =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(() -> "dui-step-state-skipped");
  CssClass dui_step_state_warning =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(() -> "dui-step-state-warning");
  CssClass dui_step_state_none =
      ReplaceCssClass.of(AggregatedCss.step_state).replaceWith(CssClass.NONE);

  class AggregatedCss {
    static CssClass dui_step_completed = () -> "dui-step-state-completed";
    static CssClass dui_step_disabled = () -> "dui-step-state-disabled";
    static CssClass dui_step_error = () -> "dui-step-state-error";
    static CssClass dui_step_skipped = () -> "dui-step-state-skipped";
    static CssClass dui_step_warning = () -> "dui-step-state-warning";
    static CssClass dui_step_none = CssClass.NONE;

    static CompositeCssClass step_state =
        CompositeCssClass.of(
            dui_step_completed,
            dui_step_disabled,
            dui_step_error,
            dui_step_skipped,
            dui_step_warning,
            dui_step_none);
  }
}
