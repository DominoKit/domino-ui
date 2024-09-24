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
package org.dominokit.domino.ui.config;

import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.TabsOverflow;

/**
 * Implementations of this interface can be used to configure defaults for {@link
 * org.dominokit.domino.ui.tabs.TabsPanel} component
 */
public interface TabsConfig extends ComponentConfig {

  /**
   * Use this method to define the default tab close icon
   *
   * <p>Defaults to : {@code close}
   *
   * @return a {@code Supplier<Icon<?>>}
   */
  default Supplier<Icon<?>> getDefaultTabCloseIcon() {
    return Icons::close;
  }

  /**
   * Use this method to implement the default Tabs overflow behavior. check {@link TabsOverflow} to
   * see available behaviors, default to {@link TabsOverflow#WRAP}
   *
   * @return TabsOverflow behavior.
   */
  default TabsOverflow getTabsDefaultOverflowHandler() {
    return TabsOverflow.WRAP;
  }
}
