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

import elemental2.dom.HTMLElement;

/** An interface for observing changes in an HTML element. */
public interface ElementObserver {

  /**
   * Gets the unique attachment ID associated with this element observer.
   *
   * @return The attachment ID.
   */
  String attachId();

  /**
   * Gets the HTML element that is being observed.
   *
   * @return The observed HTML element.
   */
  HTMLElement observedElement();

  /**
   * Gets the callback that should be executed when changes are detected in the observed element.
   *
   * @return The callback to execute.
   */
  AttachDetachCallback callback();

  /** Removes the element observer, detaching it from the observed element. */
  void remove();
}
