/*
 * Copyright © 2026 Dominokit
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
package org.dominokit.domino.ui.icons;

import static org.dominokit.domino.ui.utils.Domino.span;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.DominoElement;

/** Shared core implementation for icon packs that use Domino UI element factories. */
public abstract class AbstractIcon<T extends AbstractIcon<T>> extends Icon<T> {

  protected final HTMLElement root;
  private final String catalogName;

  protected AbstractIcon(String pack, String catalogName) {
    this(span().element(), pack, catalogName);
  }

  protected AbstractIcon(HTMLElement rootElement, String pack, String catalogName) {
    this.icon = elements.elementOf(rootElement);
    DominoElement<HTMLElement> root = this.icon;
    this.root = root.element();
    this.catalogName = catalogName;
    this.name = SwapCssClass.of(() -> catalogName);
    init((T) this);
    addCss("dui-icon-" + pack);
  }

  @Override
  public String getName() {
    return catalogName;
  }

  /** Copies the common DOM presentation state to another icon instance. */
  protected T copyPresentationTo(T copy) {
    HTMLElement target = copy.element();
    target.className = root.className;
    target.style.cssText = root.style.cssText;
    copyAttribute(target, "aria-label");
    copyAttribute(target, "role");
    copyAttribute(target, "tabindex");
    return copy;
  }

  private void copyAttribute(HTMLElement target, String attribute) {
    String value = root.getAttribute(attribute);
    if (value != null) target.setAttribute(attribute, value);
  }
}
