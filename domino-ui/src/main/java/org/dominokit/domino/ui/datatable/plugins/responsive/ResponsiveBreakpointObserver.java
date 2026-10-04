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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import java.util.function.Consumer;

/** Internal media-query seam used to keep responsive table behavior deterministic in tests. */
interface ResponsiveBreakpointObserver {

  /** Observes a query, immediately reports its current state, and returns a removable handle. */
  Registration observe(String query, Consumer<Boolean> onChange);

  @FunctionalInterface
  interface Registration {
    void remove();
  }
}
