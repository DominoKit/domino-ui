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

/**
 * An implementation of the {@link TreeNodeStore} that uses local data to populate tree structured
 * records.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * SubItemsProvider provider = ...; // Implement or get an instance of SubItemsProvider
 * LocalTreeDataStore store = new LocalTreeDataStore(provider);
 * </pre>
 *
 * @param <T> the type of data record
 */
public class LocalTreeDataStore<T> extends LocalListDataStore<T> implements TreeNodeStore<T> {
  private Map<T, LocalListDataStore<T>> childrenStore = new HashMap<>();
  private final SubItemsProvider<T> subItemsProvider;
  private final TreeNodeChildrenAware<T> treeNodeChildrenAware;

  /**
   * Constructs a {@link LocalTreeDataStore} with a sub-items provider.
   *
   * @param subItemsProvider the provider of sub-items
   */
  public LocalTreeDataStore(SubItemsProvider<T> subItemsProvider) {
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = record -> true;
  }

  /**
   * Constructs a {@link LocalTreeDataStore} with a sub-items provider and a node children checker.
   *
   * @param subItemsProvider the provider of sub-items
   * @param treeNodeChildrenAware checker to determine if a node has children
   */
  public LocalTreeDataStore(
      SubItemsProvider<T> subItemsProvider, TreeNodeChildrenAware<T> treeNodeChildrenAware) {
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = treeNodeChildrenAware;
  }

  /**
   * Constructs a {@link LocalTreeDataStore} with initial records and a sub-items provider.
   *
   * @param records the initial records
   * @param subItemsProvider the provider of sub-items
   */
  public LocalTreeDataStore(List<T> records, SubItemsProvider<T> subItemsProvider) {
    super(records);
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = record -> true;
  }

  /**
   * Constructs a {@link LocalTreeDataStore} with initial records, a sub-items provider, and a node
   * children checker.
   *
   * @param records the initial records
   * @param subItemsProvider the provider of sub-items
   * @param treeNodeChildrenAware checker to determine if a node has children
   */
  public LocalTreeDataStore(
      List<T> records,
      SubItemsProvider<T> subItemsProvider,
      TreeNodeChildrenAware<T> treeNodeChildrenAware) {
    super(records);
    this.subItemsProvider = subItemsProvider;
    this.treeNodeChildrenAware = treeNodeChildrenAware;
  }

  /**
   * Handles changes in search criteria. It filters the records based on the search event and
   * updates the store with the filtered results. If there was a previous sorting operation, it will
   * re-sort the filtered results.
   *
   * @param event the search event containing search details
   */
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

  /**
   * Sets the data for the tree store. This will replace the current data and clear the children
   * store.
   *
   * @param data the new list of data to be set
   */
  @Override
  public void setData(List<T> data) {
    super.setData(data);
    this.childrenStore.clear();
  }

  /**
   * Retrieves the children of a given parent node. If the children for the specified parent node
   * are not yet loaded, it fetches them using the sub-items provider and stores them in a local
   * cache. The children are then passed to the provided consumer.
   *
   * @param context the context providing details about the parent node and any previous operations
   * @param itemsConsumer a consumer to accept the children once they are retrieved
   */
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

  /**
   * Determines if the specified record has children. This determination is made based on the
   * treeNodeChildrenAware provided during instantiation.
   *
   * @param record the data record to check for children
   * @return true if the record has children, false otherwise
   */
  @Override
  public boolean hasChildren(T record) {
    return this.treeNodeChildrenAware.hasChildren(record);
  }
}
