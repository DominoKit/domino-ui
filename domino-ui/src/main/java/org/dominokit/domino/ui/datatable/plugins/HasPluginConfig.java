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

package org.dominokit.domino.ui.datatable.plugins;

import java.util.function.Consumer;

/**
 * The {@code HasPluginConfig} interface is implemented by classes that allow configuring a
 * DataTablePlugin with a specific configuration. It provides methods to set, get, and configure the
 * plugin's configuration.
 *
 * @param <R> The type of data table records.
 * @param <T> The type of DataTablePlugin to configure.
 * @param <C> The type of configuration for the DataTablePlugin.
 */
public interface HasPluginConfig<R, T extends DataTablePlugin<R>, C extends PluginConfig> {

  /**
   * Sets the configuration for the DataTablePlugin.
   *
   * @param config The configuration to set.
   * @return The DataTablePlugin with the updated configuration.
   */
  T setConfig(C config);

  /**
   * Gets the configuration for the DataTablePlugin.
   *
   * @return The configuration for the DataTablePlugin.
   */
  C getConfig();

  /**
   * Configures the DataTablePlugin using the provided handler.
   *
   * @param handler The consumer function to configure the DataTablePlugin's configuration.
   * @return The DataTablePlugin with the updated configuration.
   */
  default T configure(Consumer<C> handler) {
    handler.accept(getConfig());
    return (T) this;
  }
}
