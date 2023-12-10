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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.style.AutoSwapCssClass;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.ElementHandler;

/**
 * A base class for creating icons that can be toggled between two states.
 *
 * @param <I> The type of Icon that this ToggleIcon uses.
 * @param <T> The type of ToggleIcon itself.
 */
public abstract class ToggleIcon<I extends Icon<I>, T extends ToggleIcon<I, T>> extends Icon<T> {
  protected final I primary;
  protected final I toggle;
  protected boolean toggleOnClick = false;

  protected AutoSwapCssClass swapCss;
  private Consumer<T> onToggleHandler = icon -> {};

  /**
   * Creates a new ToggleIcon with the given primary and toggle icons.
   *
   * @param primary The primary icon.
   * @param toggle The toggle icon.
   */
  public ToggleIcon(I primary, I toggle) {
    this.primary = primary;
    this.toggle = toggle;
    this.icon = elementOf(this.primary);
    swapCss = AutoSwapCssClass.of(CompositeCssClass.of(primary), CompositeCssClass.of(toggle));
    this.primary.addClickListener(
        evt -> {
          evt.stopPropagation();
          if (toggleOnClick) {
            toggle();
          }
        });
    init((T) this);
  }

  /**
   * Checks if the ToggleIcon is currently toggled.
   *
   * @return {@code true} if the ToggleIcon is toggled, {@code false} otherwise.
   */
  public boolean isToggled() {
    return primary.containsCss(toggle.name.getCssClass());
  }

  /**
   * Sets whether clicking on the icon should toggle it.
   *
   * @param toggleOnClick {@code true} to enable click toggling, {@code false} otherwise.
   * @return The ToggleIcon instance for method chaining.
   */
  public T toggleOnClick(boolean toggleOnClick) {
    this.toggleOnClick = toggleOnClick;
    return (T) this;
  }

  /**
   * Sets a consumer to be called when the ToggleIcon is toggled.
   *
   * @param toggleConsumer The consumer to be called when the icon is toggled.
   * @return The ToggleIcon instance for method chaining.
   */
  public T onToggle(Consumer<T> toggleConsumer) {
    this.onToggleHandler = toggleConsumer;
    return (T) this;
  }

  /**
   * Toggles the icon to its alternate state.
   *
   * @return The ToggleIcon instance for method chaining.
   */
  public T toggle() {
    return toggle(false);
  }

  /**
   * Toggles the icon to its alternate state.
   *
   * @param silent {@code true} to toggle silently without invoking the toggle handler, {@code
   *     false} otherwise.
   * @return The ToggleIcon instance for method chaining.
   */
  public T toggle(boolean silent) {
    primary.addCss(swapCss);
    if (!silent) {
      this.onToggleHandler.accept((T) this);
    }
    return (T) this;
  }

  /**
   * Applies an element handler to both the primary and toggle icons.
   *
   * @param elementHandler The element handler to apply.
   * @return The ToggleIcon instance for method chaining.
   */
  public T applyToAll(ElementHandler<I> elementHandler) {
    elementHandler.handleElement(primary);
    elementHandler.handleElement(toggle);
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the primary icon element's HTML element as the style target.
   *
   * @return The HTML element of the primary icon.
   */
  @Override
  protected HTMLElement getStyleTarget() {
    return primary.element();
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method allows handling child elements (primary and toggle icons) using the provided
   * handler. It iterates through both primary and toggle icons and applies the handler to each.
   *
   * @param handler An element handler for child icons.
   * @return The instance of the ToggleIcon.
   */
  @Override
  public T forEachChild(ElementHandler<Icon<?>> handler) {
    handler.handleElement(primary);
    handler.handleElement(toggle);
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the primary icon element's HTML element as the clickable element.
   *
   * @return The HTML element of the primary icon.
   */
  @Override
  public HTMLElement getClickableElement() {
    return primary.element();
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>This method returns the primary icon element's HTML element.
   * @return The HTML element of the primary icon.
   */
  @Override
  public HTMLElement element() {
    return primary.element();
  }
}
