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
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

import java.util.function.Consumer;

/**
 * A base implementation for Icon
 *
 * @param <T> the type of the icon
 */
public abstract class BaseIcon<T extends BaseIcon<T>> extends BaseDominoElement<HTMLElement, T> {

  protected DominoElement<HTMLElement> icon;
  protected CssClass name = CssClass.NONE;
  protected BaseIcon<?> toggleIcon;
  protected SwapCssClass toggleName = SwapCssClass.of(name);
  protected boolean toggleOnClick = false;
  private boolean toggled = false;

  private Consumer<T> onToggleHandler = icon -> {};

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
   * Sets the opposite icon for this one, this is helpful if the icon is toggleable
   *
   * @param icon the opposite {@link BaseIcon}
   * @return same instance
   */
  public T setToggleIcon(BaseIcon<?> icon) {
    this.toggleIcon = icon;
    addClickListener(
        evt -> {
          if (toggleOnClick) {
            evt.stopPropagation();
            toggleIcon();
          }
        });
    return (T) this;
  }

  /** @return True if the icon is toggled, false otherwise */
  public boolean isToggled() {
    return toggled;
  }

  /**
   * Sets if the icon should toggle on click
   *
   * @param toggleOnClick true to toggle on click, false otherwise
   * @return same instance
   */
  public T toggleOnClick(boolean toggleOnClick) {
    this.toggleOnClick = toggleOnClick;
    return (T) this;
  }

  /**
   * Sets a handler to be called when the icon is toggled
   *
   * @param toggleConsumer the {@link Consumer} handler
   * @return same instance
   */
  public T onToggle(Consumer<T> toggleConsumer) {
    this.onToggleHandler = toggleConsumer;
    return (T) this;
  }

  /**
   * Toggle the icon, this should change the icon to the opposite one defined in {@link
   * BaseIcon#setToggleIcon(BaseIcon)}
   *
   * @return same instance
   */
  public T toggleIcon() {
    doToggle();
    this.toggled = !this.toggled;
    this.onToggleHandler.accept((T) this);
    return (T) this;
  }

  protected abstract T doToggle();

  /**
   * Adds a clickable style to the icon
   *
   * @return same instance
   */
  public T clickable() {
    addCss(dui_clickable);
    withWaves();
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

  /**
   * Change the icon to another icon
   *
   * @param icon the new {@link BaseIcon}
   * @return same instance
   */
  public abstract T changeTo(BaseIcon<?> icon);

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }
}
