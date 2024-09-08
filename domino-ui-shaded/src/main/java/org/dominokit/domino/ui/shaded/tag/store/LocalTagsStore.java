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
package org.dominokit.domino.ui.shaded.tag.store;

/**
 * @deprecated use {@link OrderedLocalTagsStore} A store implementation that accepts a list of items
 * @param <V> the type of the value
 */
@Deprecated
public class LocalTagsStore<V> extends OrderedLocalTagsStore<V> {

  /**
   * @param <V> the type of the object
   * @return new instance
   */
  public static <V> LocalTagsStore<V> create() {
    return new LocalTagsStore<>();
  }
}
