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
package org.dominokit.domino.ui.forms.suggest;

import com.google.gwt.junit.client.GWTTestCase;
import java.util.Arrays;

public class MultiSelectTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testSelectByValueSelectsTheMatchingOption() {
    MultiSelect<String> multiSelect =
        MultiSelect.<String>create()
            .appendChild(SelectOption.create("Item1"))
            .appendChild(SelectOption.create("Item2"))
            .appendChild(SelectOption.create("Item3"));

    multiSelect.selectByValue("Item2");

    assertEquals(Arrays.asList("Item2"), multiSelect.getValue());
  }
}
