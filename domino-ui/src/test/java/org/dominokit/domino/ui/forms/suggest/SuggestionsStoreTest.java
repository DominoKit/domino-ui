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

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class SuggestionsStoreTest {

  @Test
  @SuppressWarnings({"rawtypes", "unchecked"})
  public void findingNullCompletesExactlyOnce() {
    LocalSuggestionsStore store = LocalSuggestionsStore.create();
    AtomicInteger callbackCount = new AtomicInteger();

    store.find(null, option -> callbackCount.incrementAndGet());

    assertEquals(1, callbackCount.get());
  }
}
