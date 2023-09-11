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

/** HasMeta interface. */
public interface HasMeta<T> {

  /**
   * getMetaObjects.
   *
   * @return a {@link java.util.Map} object
   */
  Map<String, ComponentMeta> getMetaObjects();

  /**
   * applyMeta.
   *
   * @param meta a {@link org.dominokit.domino.ui.utils.ComponentMeta} object
   * @return a T object
   */
  default T applyMeta(ComponentMeta meta) {
    getMetaObjects().put(meta.getKey(), meta);
    return (T) this;
  }

  /**
   * applyMeta.
   *
   * @param metas a {@link org.dominokit.domino.ui.utils.ComponentMeta} object
   * @return a T object
   */
  default T applyMeta(ComponentMeta... metas) {
    Arrays.asList(metas).forEach(meta -> getMetaObjects().put(meta.getKey(), meta));
    return (T) this;
  }

  /**
   * getMeta.
   *
   * @param key a {@link java.lang.String} object
   * @param <E> a E class
   * @return a {@link java.util.Optional} object
   */
  @SuppressWarnings("all")
  default <E extends ComponentMeta> Optional<E> getMeta(String key) {
    return Optional.ofNullable((E) getMetaObjects().get(key));
  }

  /**
   * removeMeta.
   *
   * @param key a {@link java.lang.String} object
   * @return a T object
   */
  default T removeMeta(String key) {
    getMetaObjects().remove(key);
    return (T) this;
  }
}
