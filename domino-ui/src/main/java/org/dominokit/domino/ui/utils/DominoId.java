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
package org.dominokit.domino.ui.utils;

import elemental2.core.JsDate;

public class DominoId {

  private static final String DEFAULT_PREFIX = "dui-";
  private static int counter = 0;
  private static String SEED;
  private static LazyInitializer seedInit =
      new LazyInitializer(
          () -> {
            SEED = new JsDate().getTime() + "-";
          });

  public static String unique() {
    return unique(DEFAULT_PREFIX);
  }

  public static String unique(String prefix) {
    String id = prefix + getSeed() + counter;
    counter++;
    return id;
  }

  private static String getSeed() {
    seedInit.apply();
    return SEED;
  }
}
