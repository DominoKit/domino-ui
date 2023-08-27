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

/**
 * This class provides global configuration for form fields
 *
 * <p>These configurations should be set before creating the form fields
 */
public class DominoUIConfig {

  /** The DominoFields single INSTANCE for global access. */
  public static final DominoUIConfig CONFIG = new DominoUIConfig();

  private DominoUILabels dominoUILabels = new DefaultDominoUILabels();
  private UIConfig uiConfig = new DefaultUIConfig();
  private ElementsFactoryDelegate elementsFactoryDelegate = new ElementsFactoryDelegate() {};

  /** Constructor for DominoUIConfig. */
  protected DominoUIConfig() {}

  /**
   * Getter for the field <code>dominoUILabels</code>.
   *
   * @return a {@link org.dominokit.domino.ui.i18n.DominoUILabels} object
   */
  public DominoUILabels getDominoUILabels() {
    return dominoUILabels;
  }

  /**
   * Setter for the field <code>dominoUILabels</code>.
   *
   * @param dominoUILabels a {@link org.dominokit.domino.ui.i18n.DominoUILabels} object
   * @return a {@link org.dominokit.domino.ui.utils.DominoUIConfig} object
   */
  public DominoUIConfig setDominoUILabels(DominoUILabels dominoUILabels) {
    if (nonNull(dominoUILabels)) {
      this.dominoUILabels = dominoUILabels;
    }
    return this;
  }

  /**
   * getUIConfig.
   *
   * @return a {@link org.dominokit.domino.ui.config.UIConfig} object
   */
  public UIConfig getUIConfig() {
    return uiConfig;
  }

  /**
   * setUIConfig.
   *
   * @param uiConfig a {@link org.dominokit.domino.ui.config.UIConfig} object
   * @return a {@link org.dominokit.domino.ui.utils.DominoUIConfig} object
   */
  public DominoUIConfig setUIConfig(UIConfig uiConfig) {
    if (nonNull(uiConfig)) {
      this.uiConfig = uiConfig;
    }
    return this;
  }

  public ElementsFactoryDelegate getElementsFactory() {
    return this.elementsFactoryDelegate;
  }

  public void setElementsFactory(ElementsFactoryDelegate elementsFactoryDelegate) {
    this.elementsFactoryDelegate = elementsFactoryDelegate;
  }
}
