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
 * The {@code CanActivate} interface represents an entity that can be activated. Classes or
 * components implementing this interface should provide an implementation for the {@link
 * #activate()} method to define the activation behavior.
 */
public interface CanActivate {

  /**
   * Activates the entity, performing necessary actions or operations. The specific behavior of
   * activation is defined by the implementing class.
   */
  void activate();
}
