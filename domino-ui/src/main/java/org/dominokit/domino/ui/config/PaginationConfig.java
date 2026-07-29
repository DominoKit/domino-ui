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
 * Provides configuration for pagination components.
 *
 * <p>This interface extends {@link ComponentConfig} and allows defining settings specific to
 * pagination, such as layout and display behavior. Framework users can implement this interface to
 * customize pagination components while leveraging default behaviors.
 */
public interface PaginationConfig extends ComponentConfig {

  /**
   * Determines if the pagination component should use compact mode by default.
   *
   * @return {@code true} if compact mode is enabled by default, otherwise {@code false}.
   */
  default boolean defaultCompactMode() {
    return false;
  }
}
