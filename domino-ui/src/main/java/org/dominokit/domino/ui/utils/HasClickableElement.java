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
 * Component that can be clicked or has a child element that can be clicked should implement this
 * interface
 */
@FunctionalInterface
public interface HasClickableElement {
  /** @return the {@link HTMLElement} that should receive and click listeners */
  /**
   * getClickableElement.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  HTMLElement getClickableElement();
}
