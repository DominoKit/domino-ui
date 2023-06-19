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
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;

public interface CardConfig extends ComponentConfig {

  default Supplier<CollapseStrategy> getDefaultCardCollapseStrategySupplier() {
    return HeightCollapseStrategy::new;
  }

  default Supplier<ToggleIcon<?, ?>> getCardCollapseExpandIcon() {
    return () -> ToggleMdiIcon.create(Icons.chevron_up(), Icons.chevron_down());
  }
}
