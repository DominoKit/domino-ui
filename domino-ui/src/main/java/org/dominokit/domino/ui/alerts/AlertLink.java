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
package org.dominokit.domino.ui.alerts;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Wrapper element for {@link HTMLAnchorElement} that adds {@link AlertStyles#ALERT_LINK} by default
 *
 * @see Alert
 * @see BaseDominoElement
 */
@Deprecated
public class AlertLink extends BaseDominoElement<HTMLAnchorElement, AlertLink> {

  private final HTMLAnchorElement element;

  public AlertLink(HTMLAnchorElement element) {
    this.element = element;
    init(this);
    addCss(AlertStyles.ALERT_LINK);
  }

  /**
   * Creates wrapper for the original anchor element
   *
   * @param element the original anchor element
   * @return new link instance
   */
  public static AlertLink create(HTMLAnchorElement element) {
    return new AlertLink(element);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement element() {
    return element;
  }
}
