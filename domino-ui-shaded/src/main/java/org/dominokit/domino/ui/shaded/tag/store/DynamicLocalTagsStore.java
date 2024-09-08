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
package org.dominokit.domino.ui.shaded.tag.store;

import java.util.Collections;
import java.util.Map;

/**
 * A dynamic store implementation that accepts any string value and add it to the store dynamically
 */
@Deprecated
public class DynamicLocalTagsStore extends LocalTagsStore<String> {

  /** {@inheritDoc} */
  @Override
  public String getItemByDisplayValue(String displayValue) {
    return displayValue;
  }

  /** {@inheritDoc} */
  @Override
  public String getDisplayValue(String value) {
    return value;
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, String> filter(String searchValue) {
    return Collections.emptyMap();
  }
}
