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

import static org.dominokit.domino.ui.utils.Domino.dui_clickable;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementHandler;

/**
 * The {@code Icon} class provides a base for creating icons in a UI component.
 *
 * <p>This class allows creating and customizing icons for use in UI components. It provides methods
 * to set the icon's name, make it clickable, and add click listeners.
 *
 * <p>Usage Example:
 *
 * <pre>
 * Icon icon = Icon.create("fas fa-star");
 * icon.setClickable(true);
 * icon.addClickListener(evt -> {
 *     // Handle icon click event
 * });
 * </pre>
 *
 * @param <T> The type of the concrete icon class.
 * @see BaseDominoElement
 */
public abstract class Icon<T extends Icon<T>> extends BaseDominoElement<HTMLElement, T>
    implements CanApplyOnChildren<T, Icon<?>> {

  protected DominoElement<HTMLElement> icon;
  protected SwapCssClass name = SwapCssClass.of();

  /**
   * Gets the name of the icon.
   *
   * @return The name of the icon.
   */
  public String getName() {
    return name.getCssClass();
  }

  /**
   * Creates a copy of the icon.
   *
   * @return A new icon instance with the same properties.
   */
  public abstract T copy();

  /**
   * Adds a click listener to the icon element.
   *
   * @param listener The event listener to be added.
   * @return The icon instance with the click listener added.
   */
  @Override
  public T addClickListener(EventListener listener) {
    this.icon.addEventListener(EventType.click.getName(), listener);
    return (T) this;
  }

  /**
   * Makes the icon clickable, allowing it to receive click events.
   *
   * @return The icon instance with clickability enabled.
   */
  public T clickable() {
    return clickable(true);
  }

  /**
   * Makes the icon clickable, allowing it to receive click events.
   *
   * @param withWaves Whether to add waves effect to the click.
   * @return The icon instance with clickability enabled.
   */
  public T clickable(boolean withWaves) {
    addCss(dui_clickable);
    if (withWaves) {
      withWaves();
    }
    setAttribute("tabindex", "0");
    setAttribute("aria-expanded", "true");
    return (T) this;
  }

  /**
   * Sets the clickability of the icon.
   *
   * @param clickable {@code true} to make the icon clickable, {@code false} otherwise.
   * @return The icon instance with the clickability set.
   */
  public T setClickable(boolean clickable) {
    if (clickable) {
      clickable();
    } else {
      GenericCss.dui_clickable.remove(this);
      removeAttribute("tabindex");
      removeAttribute("aria-expanded");
      removeWaves();
    }
    return (T) this;
  }

  /**
   * Iterates through the child elements and applies a handler to each icon.
   *
   * @param handler The handler to apply to each child icon.
   * @return The icon instance with the handler applied.
   */
  @Override
  public T forEachChild(ElementHandler<Icon<?>> handler) {
    handler.handleElement(this);
    return (T) this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }
}
