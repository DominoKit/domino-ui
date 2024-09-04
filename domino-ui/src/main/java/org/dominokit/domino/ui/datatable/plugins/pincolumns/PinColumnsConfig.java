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
package org.dominokit.domino.ui.datatable.plugins.pincolumns;

import org.dominokit.domino.ui.datatable.plugins.PluginConfig;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;

@Deprecated
public class PinColumnsConfig implements PluginConfig {
  private boolean showPinIcon = false;
  private boolean showPinMenu = false;

  private BaseIcon<?> pinLeftIcon = Icons.ALL.pin_mdi().size18();
  private BaseIcon<?> pinRightIcon = Icons.ALL.pin_mdi().size18();

  private String pinLeftText = "Pin left";
  private String pinRightText = "Pin right";
  private String unpinText = "Unpin";

  public PinColumnsConfig() {}

  public PinColumnsConfig(boolean showPinIcon, boolean showPinMenu) {
    this.showPinIcon = showPinIcon;
    this.showPinMenu = showPinMenu;
  }

  public static PinColumnsConfig of() {
    return new PinColumnsConfig();
  }

  public static PinColumnsConfig of(boolean showPinIcon, boolean showPinMenu) {
    return new PinColumnsConfig(showPinIcon, showPinMenu);
  }

  public boolean isShowPinIcon() {
    return showPinIcon;
  }

  public PinColumnsConfig setShowPinIcon(boolean showPinIcon) {
    this.showPinIcon = showPinIcon;
    return this;
  }

  public boolean isShowPinMenu() {
    return showPinMenu;
  }

  public PinColumnsConfig setShowPinMenu(boolean showPinMenu) {
    this.showPinMenu = showPinMenu;
    return this;
  }

  public String getPinLeftText() {
    return pinLeftText;
  }

  public void setPinLeftText(String pinLeftText) {
    this.pinLeftText = pinLeftText;
  }

  public String getPinRightText() {
    return pinRightText;
  }

  public void setPinRightText(String pinRightText) {
    this.pinRightText = pinRightText;
  }

  public String getUnpinText() {
    return unpinText;
  }

  public void setUnpinText(String unpinText) {
    this.unpinText = unpinText;
  }

  public BaseIcon<?> getPinLeftIcon() {
    return pinLeftIcon;
  }

  public PinColumnsConfig setPinLeftIcon(BaseIcon<?> pinLeftIcon) {
    this.pinLeftIcon = pinLeftIcon;
    return this;
  }

  public BaseIcon<?> getPinRightIcon() {
    return pinRightIcon;
  }

  public PinColumnsConfig setPinRightIcon(BaseIcon<?> pinRightIcon) {
    this.pinRightIcon = pinRightIcon;
    return this;
  }
}
