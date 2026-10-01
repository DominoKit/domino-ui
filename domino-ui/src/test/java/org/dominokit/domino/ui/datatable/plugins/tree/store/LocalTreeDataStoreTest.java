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
package org.dominokit.domino.ui.datatable.plugins.tree.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class LocalTreeDataStoreTest {

  @Test
  public void cachesAndReportsEmptyChildren() {
    AtomicInteger providerCalls = new AtomicInteger();
    LocalTreeDataStore<String> store =
        new LocalTreeDataStore<>(
            (parent, consumer) -> {
              providerCalls.incrementAndGet();
              consumer.accept(Optional.empty());
            });
    TreeNodeStoreContext<String> context = new TreeNodeStoreContext<>("parent", null, null);
    List<Optional<Collection<String>>> results = new ArrayList<>();

    store.getNodeChildren(context, results::add);
    store.getNodeChildren(context, results::add);

    assertEquals(1, providerCalls.get());
    assertEquals(2, results.size());
    assertFalse(results.get(0).isPresent());
    assertFalse(results.get(1).isPresent());
  }
}
