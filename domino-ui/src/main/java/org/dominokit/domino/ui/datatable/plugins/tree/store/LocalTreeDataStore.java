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

import static java.util.Objects.nonNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.plugins.tree.SubItemsProvider;
import org.dominokit.domino.ui.datatable.plugins.tree.TreeNodeChildrenAware;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;

@Deprecated
public class LocalTreeDataStore<T> extends LocalListDataStore<T> implements TreeNodeStore<T> {
  private Map<T, LocalListDataStore<T>> childrenStore = new HashMap<>();
  private final SubItemsProvider<T> subItemsProvider;
  private final TreeNodeChildrenAware<T> treeNodeChildrenAware;

  public LocalTreeDataStore(SubItemsProvider<T> subItemsProvider) {
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = record -> true;
  }

  public LocalTreeDataStore(
      SubItemsProvider<T> subItemsProvider, TreeNodeChildrenAware<T> treeNodeChildrenAware) {
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = treeNodeChildrenAware;
  }

  public LocalTreeDataStore(List<T> records, SubItemsProvider<T> subItemsProvider) {
    super(records);
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = record -> true;
  }

  public LocalTreeDataStore(
      List<T> records,
      SubItemsProvider<T> subItemsProvider,
      TreeNodeChildrenAware<T> treeNodeChildrenAware) {
    super(records);
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = treeNodeChildrenAware;
  }

  @Override
  public void onSearchChanged(SearchEvent event) {
    if (nonNull(getSearchFilter())) {
      setLastSearch(event);
      filtered =
          original.stream()
              .filter(record -> getSearchFilter().filterRecord(event, record))
              .collect(Collectors.toList());
      if (nonNull(getLastSort())) {
        sort(getLastSort());
      }
      loadFirstPage();
    }
  }

  @Override
  public void setData(List<T> data) {
    super.setData(data);
    this.childrenStore.clear();
  }

  @Override
  public void getNodeChildren(
      TreeNodeStoreContext<T> context, Consumer<Optional<Collection<T>>> itemsConsumer) {
    if (!childrenStore.containsKey(context.getParent())) {
      subItemsProvider.getSubItems(
          context.getParent(),
          children -> {
            children.ifPresent(
                childRecords -> {
                  LocalListDataStore<T> subStore =
                      new SubItemsStore<>(new ArrayList<>(childRecords), this);

                  if (nonNull(context.getLastSearch())) {
                    subStore.onSearchChanged(context.getLastSearch());
                  } else if (nonNull(context.getLastSort())) {
                    subStore.sort(context.getLastSort());
                  }
                  childrenStore.put(context.getParent(), subStore);
                  List<T> filtered = childrenStore.get(context.getParent()).getFilteredRecords();
                  itemsConsumer.accept(Optional.ofNullable(filtered));
                });
          });
    } else {
      if (nonNull(getLastSort())) {
        childrenStore.get(context.getParent()).sort(context.getLastSort());
      }
      itemsConsumer.accept(
          Optional.ofNullable(childrenStore.get(context.getParent()).getFilteredRecords()));
    }
  }

  @Override
  public boolean hasChildren(T record) {
    return this.treeNodeChildrenAware.hasChildren(record);
  }
}
