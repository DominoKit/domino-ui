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

/** Abstraction over the document stylesheet used by {@link DynamicCssRegistry}. */
interface DynamicCssStyleSheet {

  /** Returns whether a CSS rule with the selector already exists. */
  boolean hasRule(String selector);

  /** Returns a property value from an existing selector rule, or an empty string when absent. */
  String getPropertyValue(String selector, String property);

  /** Returns whether the property is declared by an accessible stylesheet rule. */
  boolean hasProperty(String property);

  /** Creates the selector rule when necessary and sets one of its properties. */
  void setProperty(String selector, String property, String value);
}
