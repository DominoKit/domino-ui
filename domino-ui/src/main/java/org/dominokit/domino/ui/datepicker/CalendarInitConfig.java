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
package org.dominokit.domino.ui.datepicker;

import static java.util.Objects.nonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * CalendarInitConfig class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class CalendarInitConfig {

  private final Set<CalendarPlugin> plugins = new HashSet<>();

  /** Constructor for CalendarInitConfig. */
  public CalendarInitConfig() {}

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public static CalendarInitConfig create() {
    return new CalendarInitConfig();
  }

  /**
   * addPlugin.
   *
   * @param plugin a {@link org.dominokit.domino.ui.datepicker.CalendarPlugin} object
   * @return a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public CalendarInitConfig addPlugin(CalendarPlugin plugin) {
    if (nonNull(plugin)) {
      this.plugins.add(plugin);
    }
    return this;
  }

  /**
   * removePlugin.
   *
   * @param plugin a {@link org.dominokit.domino.ui.datepicker.CalendarPlugin} object
   * @return a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public CalendarInitConfig removePlugin(CalendarPlugin plugin) {
    if (nonNull(plugin)) {
      this.plugins.remove(plugin);
    }
    return this;
  }

  /**
   * Getter for the field <code>plugins</code>.
   *
   * @return a {@link java.util.Set} object
   */
  public Set<CalendarPlugin> getPlugins() {
    return plugins;
  }
}
