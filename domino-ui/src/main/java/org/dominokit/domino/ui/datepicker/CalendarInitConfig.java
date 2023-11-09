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
 * Represents the initialization configuration for a calendar.
 *
 * <p>It supports adding and removing plugins that can modify the behavior and appearance of the
 * calendar.
 *
 * <p>Usage example:
 *
 * <pre>
 * CalendarInitConfig config = CalendarInitConfig.create()
 *     .addPlugin(new SamplePlugin())
 *     .removePlugin(anotherPlugin);
 * </pre>
 */
public class CalendarInitConfig {

  private final Set<CalendarPlugin> plugins = new HashSet<>();

  /** Constructs an empty calendar initialization configuration. */
  public CalendarInitConfig() {}

  /**
   * Factory method to create a new instance of CalendarInitConfig.
   *
   * @return a new instance of CalendarInitConfig
   */
  public static CalendarInitConfig create() {
    return new CalendarInitConfig();
  }

  /**
   * Adds a plugin to the calendar configuration.
   *
   * @param plugin the plugin to be added
   * @return the current instance of CalendarInitConfig, for chaining method calls
   */
  public CalendarInitConfig addPlugin(CalendarPlugin plugin) {
    if (nonNull(plugin)) {
      this.plugins.add(plugin);
    }
    return this;
  }

  /**
   * Removes a plugin from the calendar configuration.
   *
   * @param plugin the plugin to be removed
   * @return the current instance of CalendarInitConfig, for chaining method calls
   */
  public CalendarInitConfig removePlugin(CalendarPlugin plugin) {
    if (nonNull(plugin)) {
      this.plugins.remove(plugin);
    }
    return this;
  }

  /**
   * Retrieves the set of plugins associated with the calendar configuration.
   *
   * @return a set of CalendarPlugin objects
   */
  public Set<CalendarPlugin> getPlugins() {
    return plugins;
  }
}
