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

import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;
import static org.dominokit.domino.ui.style.DisplayCss.dui_hidden;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.DominoCss;

/**
 * An implementation of {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} that uses the
 * css display property to hide/show the collapsible element
 */
public class DisplayCollapseStrategy implements CollapseStrategy, CollapsibleStyles, DominoCss {

  private CollapsibleHandlers handlers;

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public void init(Element element, CollapsibleHandlers handlers) {
    this.handlers = handlers;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public void expand(Element element) {
    this.handlers.onBeforeExpand().run();
    dui_hidden.remove(element);
    element.removeAttribute(DUI_COLLAPSED);
    this.handlers.onExpandCompleted().run();
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public void collapse(Element element) {
    this.handlers.onBeforeCollapse().run();
    dui_hidden.apply(element);
    element.setAttribute(DUI_COLLAPSED, "true");
    this.handlers.onCollapseCompleted().run();
  }
}
