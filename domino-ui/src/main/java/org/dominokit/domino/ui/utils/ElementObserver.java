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

/**
 * Obeserving an element Attach/Detach cycle should return an implementation of this interface that
 * holds information about the element being observed
 */
public interface ElementObserver {
  /** @return String unique attach/detach id assigned to the element */
  String attachId();

  /** @return the {@link HTMLElement} being observed */
  HTMLElement observedElement();

  /** @return the {@link AttachDetachCallback} to be called when the element is attached/detached */
  AttachDetachCallback callback();

  /** Clean-up and remove the observe listeners for this element */
  void remove();
}
