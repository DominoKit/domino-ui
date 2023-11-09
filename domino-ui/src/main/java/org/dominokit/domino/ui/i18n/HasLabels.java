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
package org.dominokit.domino.ui.i18n;

import org.dominokit.domino.ui.utils.DominoUIConfig;

/**
 * The {@code HasLabels} interface is designed to provide access to labels and messages defined in a
 * specific implementation of the {@link Labels} interface. It allows classes to retrieve labels
 * without hardcoding them, promoting flexibility and localization.
 *
 * @param <T> The type of {@code Labels} interface to retrieve.
 */
public interface HasLabels<T extends Labels> {

  /**
   * Gets the instance of the {@link Labels} interface associated with this class.
   *
   * @return An instance of the {@code Labels} interface providing labels and messages.
   */
  default T getLabels() {
    return (T) DominoUIConfig.CONFIG.getDominoUILabels();
  }
}
