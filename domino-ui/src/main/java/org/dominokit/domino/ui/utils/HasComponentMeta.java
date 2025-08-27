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

import java.util.Map;
import java.util.Optional;

public interface HasComponentMeta<T> {
  Map<String, ComponentMeta> getMetaObjects();

  default T setMetaObject(ComponentMeta componentMeta) {
    getMetaObjects().put(componentMeta.getKey(), componentMeta);
    onMetaObjectUpdated(componentMeta);
    return (T) this;
  }

  default T onMetaObjectUpdated(ComponentMeta componentMeta) {
    return (T) this;
  }

  default <C> Optional<C> getMetaObject(String key) {
    if (getMetaObjects().containsKey(key)) {
      return Optional.of((C) getMetaObjects().get(key));
    }
    return Optional.empty();
  }
}
