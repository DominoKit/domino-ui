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
package org.dominokit.domino.ui.menu.base;

import org.dominokit.domino.ui.utils.Selectable;

/** Receives a notification when an item is added to a menu. */
@FunctionalInterface
public interface OnAddItemHandler<
    V, C extends IsMenuBase<V, C, I, S>, I extends IsMenuItem<V, I, S>, S extends Selectable<S>> {

  void onAdded(C menu, I menuItem);
}
