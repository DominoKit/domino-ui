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
package org.dominokit.domino.ui.events;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;

/**
 * CustomEvents class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class CustomEvents {

  /**
   * create.
   *
   * @param name a {@link java.lang.String} object
   * @param <T> a T class
   * @return a {@link elemental2.dom.CustomEvent} object
   */
  public static <T> CustomEvent<T> create(String name) {
    return new CustomEvent<>(name);
  }

  /**
   * create.
   *
   * @param name a {@link java.lang.String} object
   * @param details a T object
   * @param <T> a T class
   * @return a {@link elemental2.dom.CustomEvent} object
   */
  public static <T> CustomEvent<T> create(String name, T details) {
    CustomEventInit<T> initOptions = Js.uncheckedCast(CustomEventInit.create());
    initOptions.setDetail(details);
    return new CustomEvent<>(name, initOptions);
  }
}
