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

package org.dominokit.domino.ui.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * The {@code HasMeta} interface defines methods for managing metadata associated with a component.
 *
 * @param <T> The type of the component that can have metadata.
 */
public interface HasMeta<T> {

  /**
   * Gets a map of metadata objects associated with the component, where each metadata object is
   * identified by a unique key.
   *
   * @return A map of metadata objects associated with the component.
   */
  Map<String, ComponentMeta> getMetaObjects();

  /**
   * Applies a single metadata object to the component.
   *
   * @param meta The metadata object to apply.
   * @return The component with the applied metadata object.
   */
  default T applyMeta(ComponentMeta meta) {
    getMetaObjects().put(meta.getKey(), meta);
    return (T) this;
  }

  /**
   * Applies multiple metadata objects to the component.
   *
   * @param metas An array of metadata objects to apply.
   * @return The component with the applied metadata objects.
   */
  default T applyMeta(ComponentMeta... metas) {
    Arrays.asList(metas).forEach(meta -> getMetaObjects().put(meta.getKey(), meta));
    return (T) this;
  }

  /**
   * Gets a metadata object associated with the component by its unique key.
   *
   * @param <E> The type of the metadata object.
   * @param key The unique key of the metadata object to retrieve.
   * @return An {@code Optional} containing the metadata object, or an empty {@code Optional} if not
   *     found.
   */
  @SuppressWarnings("all")
  default <E extends ComponentMeta> Optional<E> getMeta(String key) {
    return Optional.ofNullable((E) getMetaObjects().get(key));
  }

  /**
   * Removes a metadata object associated with the component by its unique key.
   *
   * @param key The unique key of the metadata object to remove.
   * @return The component with the specified metadata object removed.
   */
  default T removeMeta(String key) {
    getMetaObjects().remove(key);
    return (T) this;
  }
}
