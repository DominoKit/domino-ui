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

import org.dominokit.domino.ui.dialogs.DefaultZIndexManager;
import org.dominokit.domino.ui.dialogs.ZIndexManager;

/**
 * Implementations of this interface can be used to configure defaults for z-index configuration
 * used with pop-ups and modals
 */
public interface ZIndexConfig extends ComponentConfig {

  /**
   * Use this method to define the default initial start z-index
   *
   * <p>Defaults to : {@code 10}
   *
   * @return integer z-index
   */
  default int getInitialZIndex() {
    return 10;
  }

  /**
   * Use this method to define the default the increment applied every time a z-index is requested
   *
   * <p>Defaults to : {@code 1}
   *
   * @return integer increment
   */
  default int getzIndexIncrement() {
    return 1;
  }

  /**
   * Use this method to define the default implementation of the {@link ZIndexManager}
   *
   * <p>Defaults to : {@code DefaultZIndexManager}
   *
   * @return a ZIndexManager instance
   */
  default ZIndexManager getZindexManager() {
    return DefaultZIndexManager.INSTANCE;
  }
}
