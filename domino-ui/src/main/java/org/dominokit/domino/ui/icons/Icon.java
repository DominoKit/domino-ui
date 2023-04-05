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
package org.dominokit.domino.ui.icons;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementHandler;
import org.dominokit.domino.ui.events.EventType;

/**
 * A base implementation for Icon
 *
 * @param <T> the type of the icon
 */
public abstract class Icon<T extends Icon<T>> extends BaseDominoElement<HTMLElement, T> implements CanApplyOnChildren<T, Icon<?>> {

  protected DominoElement<HTMLElement> icon;
  protected SwapCssClass name = SwapCssClass.of();

  /** @return The name of the icon */
  public String getName() {
    return name.getCssClass();
  }

  /**
   * Copy the same icon and return a new instance
   *
   * @return the new copied instance
   */
  public abstract T copy();

  /** {@inheritDoc} */
  @Override
  public T addClickListener(EventListener listener) {
    this.icon.addEventListener(EventType.click.getName(), listener);
    return (T) this;
  }

  /**
   * Adds a clickable style to the icon
   *
   * @return same instance
   */
  public T clickable() {
    return clickable(true);
  }
  /**
   * Adds a clickable style to the icon
   *
   * @return same instance
   */
  public T clickable(boolean withWaves) {
    addCss(dui_clickable);
    if (withWaves) {
      withWaves();
    }
    setAttribute("tabindex", "0");
    setAttribute("aria-expanded", "true");
    setAttribute("href", "#");
    return (T) this;
  }

  /**
   * Sets if the icon should have clickable style or not
   *
   * @param clickable true to set it as clickable, false otherwise
   * @return same instance
   */
  public T setClickable(boolean clickable) {
    if (clickable) {
      clickable();
    } else {
      GenericCss.dui_clickable.remove(this);
      removeAttribute("tabindex");
      removeAttribute("aria-expanded");
      removeAttribute("href");
      removeWaves();
    }
    return (T) this;
  }

  @Override
  public T forEachChild(ElementHandler<Icon<?>> handler) {
    handler.handleElement(this);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }
}
