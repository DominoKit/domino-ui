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
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.MenuItemsGroup;

/**
 * A component that can group a set of {@link SelectOption}
 *
 * @param <T> The type of the SelectOption value
 */
public class SelectOptionGroup<T> extends MenuItemsGroup<T, SelectOption<T>, SelectOptionGroup<T>> {

  private CanInitSelectOption<T> initializer;

  void bindTo(CanInitSelectOption<T> initializer) {
    this.initializer = initializer;
  }

  @Override
  public SelectOptionGroup<T> appendChild(SelectOption<T> option) {
    initializer.initOption(option);
    return super.appendChild(option);
  }
}
