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

/**
 * The {@code LazyInitializer} class is used to lazily initialize an object using a lambda function.
 * This can help improve performance by deferring the initialization process until the object is
 * actually needed.
 */
public class LazyInitializer extends BaseLazyInitializer<LazyInitializer> {

  /**
   * Constructs a new {@code LazyInitializer} instance with the specified lambda function.
   *
   * @param function The lambda function that performs the lazy initialization when needed.
   */
  public LazyInitializer(LambdaFunction function) {
    super(function);
  }
}
