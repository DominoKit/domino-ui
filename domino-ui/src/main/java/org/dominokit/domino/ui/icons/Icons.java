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

/** A factory class for all icons supported */
public class Icons implements MdiIcons {

  private Icons() {}

  public static final Icons ALL = new Icons();

  public static final MdiIcons MDI_ICONS = ALL;

  /**
   * A factory method which creates icon based on the {@code name}
   *
   * @param name the name of the icon
   * @return new instance
   */
  public static BaseIcon<?> of(String name) {
    return MdiIcon.create(name);
  }
}
