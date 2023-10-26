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

package org.dominokit.domino.ui.datatable.plugins.tree;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A functional interface for providing sub-items for a given parent item.
 *
 * @param <T> The type of items in the hierarchy.
 */
@FunctionalInterface
public interface SubItemsProvider<T> {

  /**
   * Provides sub-items for a given parent item and passes them to the specified items consumer.
   *
   * @param parent The parent item for which sub-items are requested.
   * @param itemsConsumer A consumer that receives the sub-items as an optional collection. If there
   *     are sub-items, the collection should be wrapped in an Optional and passed to the consumer.
   *     If there are no sub-items, an empty Optional should be passed.
   */
  void getSubItems(T parent, Consumer<Optional<Collection<T>>> itemsConsumer);
}
