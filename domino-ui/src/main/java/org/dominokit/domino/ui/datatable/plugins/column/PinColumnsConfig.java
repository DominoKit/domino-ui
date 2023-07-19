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
package org.dominokit.domino.ui.datatable.plugins.column;

import org.dominokit.domino.ui.datatable.plugins.PluginConfig;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.SpacingCss;

/**
 * PinColumnsConfig class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class PinColumnsConfig implements PluginConfig {
  private boolean showPinIcon = false;
  private boolean showPinMenu = false;

  private Icon<?> pinLeftIcon = Icons.pin().addCss(SpacingCss.dui_font_size_4);
  private Icon<?> pinRightIcon = Icons.pin().addCss(SpacingCss.dui_font_size_4);

  private String pinLeftText = "Pin left";
  private String pinRightText = "Pin right";
  private String unpinText = "Unpin";

  /** Constructor for PinColumnsConfig. */
  public PinColumnsConfig() {}

  /**
   * Constructor for PinColumnsConfig.
   *
   * @param showPinIcon a boolean
   * @param showPinMenu a boolean
   */
  public PinColumnsConfig(boolean showPinIcon, boolean showPinMenu) {
    this.showPinIcon = showPinIcon;
    this.showPinMenu = showPinMenu;
  }

  /**
   * of.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public static PinColumnsConfig of() {
    return new PinColumnsConfig();
  }

  /**
   * of.
   *
   * @param showPinIcon a boolean
   * @param showPinMenu a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public static PinColumnsConfig of(boolean showPinIcon, boolean showPinMenu) {
    return new PinColumnsConfig(showPinIcon, showPinMenu);
  }

  /**
   * isShowPinIcon.
   *
   * @return a boolean
   */
  public boolean isShowPinIcon() {
    return showPinIcon;
  }

  /**
   * Setter for the field <code>showPinIcon</code>.
   *
   * @param showPinIcon a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public PinColumnsConfig setShowPinIcon(boolean showPinIcon) {
    this.showPinIcon = showPinIcon;
    return this;
  }

  /**
   * isShowPinMenu.
   *
   * @return a boolean
   */
  public boolean isShowPinMenu() {
    return showPinMenu;
  }

  /**
   * Setter for the field <code>showPinMenu</code>.
   *
   * @param showPinMenu a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public PinColumnsConfig setShowPinMenu(boolean showPinMenu) {
    this.showPinMenu = showPinMenu;
    return this;
  }

  /**
   * Getter for the field <code>pinLeftText</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getPinLeftText() {
    return pinLeftText;
  }

  /**
   * Setter for the field <code>pinLeftText</code>.
   *
   * @param pinLeftText a {@link java.lang.String} object
   */
  public void setPinLeftText(String pinLeftText) {
    this.pinLeftText = pinLeftText;
  }

  /**
   * Getter for the field <code>pinRightText</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getPinRightText() {
    return pinRightText;
  }

  /**
   * Setter for the field <code>pinRightText</code>.
   *
   * @param pinRightText a {@link java.lang.String} object
   */
  public void setPinRightText(String pinRightText) {
    this.pinRightText = pinRightText;
  }

  /**
   * Getter for the field <code>unpinText</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getUnpinText() {
    return unpinText;
  }

  /**
   * Setter for the field <code>unpinText</code>.
   *
   * @param unpinText a {@link java.lang.String} object
   */
  public void setUnpinText(String unpinText) {
    this.unpinText = unpinText;
  }

  /**
   * Getter for the field <code>pinLeftIcon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getPinLeftIcon() {
    return pinLeftIcon;
  }

  /**
   * Setter for the field <code>pinLeftIcon</code>.
   *
   * @param pinLeftIcon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public PinColumnsConfig setPinLeftIcon(Icon<?> pinLeftIcon) {
    this.pinLeftIcon = pinLeftIcon;
    return this;
  }

  /**
   * Getter for the field <code>pinRightIcon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getPinRightIcon() {
    return pinRightIcon;
  }

  /**
   * Setter for the field <code>pinRightIcon</code>.
   *
   * @param pinRightIcon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnsConfig} object
   */
  public PinColumnsConfig setPinRightIcon(Icon<?> pinRightIcon) {
    this.pinRightIcon = pinRightIcon;
    return this;
  }
}
