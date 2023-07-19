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
package org.dominokit.domino.ui.collapsible;

import elemental2.dom.Element;

/**
 * CollapseStrategy interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface CollapseStrategy {

  /**
   * Implement this method to provide any initialization required for the collapse strategy
   *
   * @param element The collapsible {@link elemental2.dom.Element}
   * @param handlers a {@link org.dominokit.domino.ui.collapsible.CollapsibleHandlers} object
   */
  default void init(Element element, CollapsibleHandlers handlers) {}
  /**
   * Implement this method to show a collapsible element
   *
   * @param element The collapsible {@link elemental2.dom.Element}
   */
  void expand(Element element);

  /**
   * Implement this method to hide a collapsible element
   *
   * @param element The collapsible {@link elemental2.dom.Element}
   */
  void collapse(Element element);

  /**
   * Implement this method to clean up any attributes or styles added the strategy when we switch to
   * a different one.
   *
   * @param element The collapsible {@link elemental2.dom.Element}
   */
  default void cleanup(Element element) {};
}
