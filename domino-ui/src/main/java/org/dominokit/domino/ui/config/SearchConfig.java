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
package org.dominokit.domino.ui.config;

/**
 * Implementations of this interface can be used to configure defaults for {@link
 * org.dominokit.domino.ui.search.SearchBox} component
 */
public interface SearchConfig extends DelayedActionConfig {

  /**
   * Use this method to define the default auto search delay for SearchBox in milliseconds
   *
   * <p>Defaults to : <b>200ms</b>>
   *
   * @return an integer delay in milliseconds
   */
  default int getAutoSearchDelay() {
    return getDelayedExecutionDefaultDelay();
  }

  /**
   * Use this method to define the default auto search delay for datatable DelayedHeaderFilter in
   * milliseconds
   *
   * <p>Defaults to : <b>{@link #getAutoSearchDelay()}</b>>
   *
   * @return an integer delay in milliseconds
   */
  default int getTableTextHeaderFilterSearchDelay() {
    return getAutoSearchDelay();
  }
}
