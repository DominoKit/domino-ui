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
 * A functional interface to supply record children
 *
 * @param <T> Type of table records.
 */
@FunctionalInterface
public interface SubItemsProvider<T> {
  /**
   * getSubItems.
   *
   * @param parent a T object
   * @param itemsConsumer a {@link java.util.function.Consumer} object
   */
  void getSubItems(T parent, Consumer<Optional<Collection<T>>> itemsConsumer);
}
