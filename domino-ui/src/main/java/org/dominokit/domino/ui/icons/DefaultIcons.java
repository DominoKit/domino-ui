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

import static org.dominokit.domino.ui.utils.DominoUIConfig.CONFIG;

/** Factories for icons created by the configured default icon pack. */
public final class DefaultIcons {

  private DefaultIcons() {}

  public static IsIcon<?> icon(IconName name) {
    return CONFIG.getUIConfig().getDefaultIconProvider().icon(name);
  }

  /** Creates a core element wrapper for use with APIs that still require {@link Icon}. */
  public static IconWrapper coreIcon(IconName name) {
    return IconWrapper.of(icon(name));
  }

  public static DefaultToggleIcon toggle(IconName primary, IconName alternate) {
    return DefaultToggleIcon.of(icon(primary), icon(alternate));
  }

  public static DefaultStateChangeIcon state(IconName defaultIcon) {
    return DefaultStateChangeIcon.of(icon(defaultIcon));
  }
}
