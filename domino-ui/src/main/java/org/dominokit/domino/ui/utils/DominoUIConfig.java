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

import static java.util.Objects.nonNull;

import org.dominokit.domino.ui.config.DefaultUIConfig;
import org.dominokit.domino.ui.config.UIConfig;
import org.dominokit.domino.ui.i18n.DefaultDominoUILabels;
import org.dominokit.domino.ui.i18n.DominoUILabels;

/** Provides configuration options for the Domino UI framework. */
public class DominoUIConfig {

  /** The singleton instance of {@code DominoUIConfig}. */
  public static final DominoUIConfig CONFIG = new DominoUIConfig();

  private DominoUILabels dominoUILabels = new DefaultDominoUILabels();
  private UIConfig uiConfig = new DefaultUIConfig();
  private ElementsFactoryDelegate elementsFactoryDelegate = new ElementsFactoryDelegate() {};
  private boolean closePopupOnBlur;

  /**
   * Protected constructor to prevent external instantiation. Use the {@code CONFIG} singleton
   * instance.
   */
  protected DominoUIConfig() {}

  /**
   * Gets the {@link DominoUILabels} instance used for internationalization and localization.
   *
   * @return The {@code DominoUILabels} instance.
   */
  public DominoUILabels getDominoUILabels() {
    return dominoUILabels;
  }

  /**
   * Sets the {@link DominoUILabels} instance for internationalization and localization.
   *
   * @param dominoUILabels The {@code DominoUILabels} instance to set.
   * @return This {@code DominoUIConfig} instance for method chaining.
   */
  public DominoUIConfig setDominoUILabels(DominoUILabels dominoUILabels) {
    if (nonNull(dominoUILabels)) {
      this.dominoUILabels = dominoUILabels;
    }
    return this;
  }

  /**
   * Gets the {@link UIConfig} instance containing various UI-related configurations.
   *
   * @return The {@code UIConfig} instance.
   */
  public UIConfig getUIConfig() {
    return uiConfig;
  }

  /**
   * Sets the {@link UIConfig} instance with UI-related configurations.
   *
   * @param uiConfig The {@code UIConfig} instance to set.
   * @return This {@code DominoUIConfig} instance for method chaining.
   */
  public DominoUIConfig setUIConfig(UIConfig uiConfig) {
    if (nonNull(uiConfig)) {
      this.uiConfig = uiConfig;
    }
    return this;
  }

  /**
   * Gets the delegate for creating UI elements.
   *
   * @return The {@code ElementsFactoryDelegate} instance.
   */
  public ElementsFactoryDelegate getElementsFactory() {
    return this.elementsFactoryDelegate;
  }

  /**
   * Sets the delegate for creating UI elements.
   *
   * @param elementsFactoryDelegate The {@code ElementsFactoryDelegate} instance to set.
   */
  public void setElementsFactory(ElementsFactoryDelegate elementsFactoryDelegate) {
    this.elementsFactoryDelegate = elementsFactoryDelegate;
  }

  /**
   * Sets whether popups should be closed when clicking outside of them.
   *
   * @param closePopupOnBlur {@code true} to close popups on blur, {@code false} otherwise.
   */
  public void setClosePopupOnBlur(boolean closePopupOnBlur) {
    this.closePopupOnBlur = closePopupOnBlur;
  }

  /**
   * Checks if popups should be closed when clicking outside of them.
   *
   * @return {@code true} if popups should be closed on blur, {@code false} otherwise.
   */
  public boolean isClosePopupOnBlur() {
    return this.closePopupOnBlur;
  }
}
