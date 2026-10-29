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

import java.util.List;
import java.util.function.Supplier;

/**
 * An interface for a factory that provides Material Design Icons (MDI) icons based on tags. This
 * factory allows you to obtain a list of suppliers, each of which can provide an instance of an MDI
 * icon.
 *
 * <p>Usage Example:
 *
 * <pre>
 * MdiIconsByTagFactory factory = MyMdiIconsFactory.getInstance();
 * List<Supplier<MdiIcon>> iconSuppliers = factory.icons();
 * </pre>
 *
 * In the above example, you can obtain a list of MDI icon suppliers using the factory.
 */
public interface MdiIconsByTagFactory {

  /**
   * Returns a list of suppliers, each of which can provide an instance of an MDI icon based on a
   * tag.
   *
   * @return A list of {@link Supplier} objects, each supplying an {@link MdiIcon} instance.
   */
  List<Supplier<MdiIcon>> icons();
}
