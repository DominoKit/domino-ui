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
 * Configuration class for the PinColumnsPlugin in a DataTable. This class allows you to customize
 * the behavior and appearance of pinned columns.
 *
 * @see org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin
 * @see org.dominokit.domino.ui.datatable.plugins.PluginConfig
 */
public class PinColumnsConfig implements PluginConfig {
  private boolean showPinIcon = false;
  private boolean showPinMenu = false;

  /** Icon used for pinning columns to the left side of the DataTable. */
  private Icon<?> pinLeftIcon = Icons.pin().addCss(SpacingCss.dui_font_size_4);

  /** Icon used for pinning columns to the right side of the DataTable. */
  private Icon<?> pinRightIcon = Icons.pin().addCss(SpacingCss.dui_font_size_4);

  /** Text label for the "Pin Left" action in the column menu. */
  private String pinLeftText = "Pin left";

  /** Text label for the "Pin Right" action in the column menu. */
  private String pinRightText = "Pin right";

  /** Text label for the "Unpin" action in the column menu. */
  private String unpinText = "Unpin";

  /** Default constructor for PinColumnsConfig. */
  public PinColumnsConfig() {}

  /**
   * Constructor for PinColumnsConfig with options to show pin icon and pin menu.
   *
   * @param showPinIcon True to show pin icons, false otherwise.
   * @param showPinMenu True to show the pin menu, false otherwise.
   */
  public PinColumnsConfig(boolean showPinIcon, boolean showPinMenu) {
    this.showPinIcon = showPinIcon;
    this.showPinMenu = showPinMenu;
  }

  /**
   * Creates a new PinColumnsConfig instance with default settings.
   *
   * @return A new PinColumnsConfig instance.
   */
  public static PinColumnsConfig of() {
    return new PinColumnsConfig();
  }

  /**
   * Creates a new PinColumnsConfig instance with the specified settings.
   *
   * @param showPinIcon True to show pin icons, false otherwise.
   * @param showPinMenu True to show the pin menu, false otherwise.
   * @return A new PinColumnsConfig instance with the specified settings.
   */
  public static PinColumnsConfig of(boolean showPinIcon, boolean showPinMenu) {
    return new PinColumnsConfig(showPinIcon, showPinMenu);
  }

  /**
   * Checks if pin icons are shown.
   *
   * @return True if pin icons are shown, false otherwise.
   */
  public boolean isShowPinIcon() {
    return showPinIcon;
  }

  /**
   * Sets whether to show pin icons.
   *
   * @param showPinIcon True to show pin icons, false otherwise.
   * @return The PinColumnsConfig instance for method chaining.
   */
  public PinColumnsConfig setShowPinIcon(boolean showPinIcon) {
    this.showPinIcon = showPinIcon;
    return this;
  }

  /**
   * Checks if the pin menu is shown.
   *
   * @return True if the pin menu is shown, false otherwise.
   */
  public boolean isShowPinMenu() {
    return showPinMenu;
  }

  /**
   * Sets whether to show the pin menu.
   *
   * @param showPinMenu True to show the pin menu, false otherwise.
   * @return The PinColumnsConfig instance for method chaining.
   */
  public PinColumnsConfig setShowPinMenu(boolean showPinMenu) {
    this.showPinMenu = showPinMenu;
    return this;
  }

  /**
   * Gets the text label for the "Pin Left" action in the column menu.
   *
   * @return The text label for "Pin Left."
   */
  public String getPinLeftText() {
    return pinLeftText;
  }

  /**
   * Sets the text label for the "Pin Left" action in the column menu.
   *
   * @param pinLeftText The text label for "Pin Left."
   */
  public void setPinLeftText(String pinLeftText) {
    this.pinLeftText = pinLeftText;
  }

  /**
   * Gets the text label for the "Pin Right" action in the column menu.
   *
   * @return The text label for "Pin Right."
   */
  public String getPinRightText() {
    return pinRightText;
  }

  /**
   * Sets the text label for the "Pin Right" action in the column menu.
   *
   * @param pinRightText The text label for "Pin Right."
   */
  public void setPinRightText(String pinRightText) {
    this.pinRightText = pinRightText;
  }

  /**
   * Gets the text label for the "Unpin" action in the column menu.
   *
   * @return The text label for "Unpin."
   */
  public String getUnpinText() {
    return unpinText;
  }

  /**
   * Sets the text label for the "Unpin" action in the column menu.
   *
   * @param unpinText The text label for "Unpin."
   */
  public void setUnpinText(String unpinText) {
    this.unpinText = unpinText;
  }

  /**
   * Gets the icon used for pinning columns to the left side of the DataTable.
   *
   * @return The pin left icon.
   */
  public Icon<?> getPinLeftIcon() {
    return pinLeftIcon;
  }

  /**
   * Sets the icon used for pinning columns to the left side of the DataTable.
   *
   * @param pinLeftIcon The pin left icon.
   * @return The PinColumnsConfig instance for method chaining.
   */
  public PinColumnsConfig setPinLeftIcon(Icon<?> pinLeftIcon) {
    this.pinLeftIcon = pinLeftIcon;
    return this;
  }

  /**
   * Gets the icon used for pinning columns to the right side of the DataTable.
   *
   * @return The pin right icon.
   */
  public Icon<?> getPinRightIcon() {
    return pinRightIcon;
  }

  /**
   * Sets the icon used for pinning columns to the right side of the DataTable.
   *
   * @param pinRightIcon The pin right icon.
   * @return The PinColumnsConfig instance for method chaining.
   */
  public PinColumnsConfig setPinRightIcon(Icon<?> pinRightIcon) {
    this.pinRightIcon = pinRightIcon;
    return this;
  }
}
