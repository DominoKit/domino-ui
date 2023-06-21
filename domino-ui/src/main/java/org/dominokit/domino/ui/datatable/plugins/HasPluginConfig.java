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
 * HasPluginConfig interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasPluginConfig<R, T extends DataTablePlugin<R>, C extends PluginConfig> {

  /**
   * setConfig.
   *
   * @param config a C object
   * @return a T object
   */
  T setConfig(C config);

  /**
   * getConfig.
   *
   * @return a C object
   */
  C getConfig();

  /**
   * Use to update the configuration in the current plugin configuration
   *
   * @param handler {@link java.util.function.Consumer} of {@link C}
   * @return same plugin instance.
   */
  default T configure(Consumer<C> handler) {
    handler.accept(getConfig());
    return (T) this;
  }
}
