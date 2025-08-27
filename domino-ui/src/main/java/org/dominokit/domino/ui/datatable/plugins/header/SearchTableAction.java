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
package org.dominokit.domino.ui.datatable.plugins.header;

import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_search_box;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.DominoEventListener;

/**
 * An implementation of the {@link HeaderActionElement} that provides search functionality for a
 * DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class SearchTableAction<T> extends BaseDominoElement<HTMLElement, SearchTableAction<T>>
    implements DominoEventListener {

  private final DataTable<T> dataTable;
  private final SearchBox searchBox;

  public static <T> SearchTableAction<T> create(DataTable<T> dataTable) {
    return new SearchTableAction<>(dataTable);
  }

  /**
   * Creates a new instance of the {@code SearchTableAction}. Initializes a search box with
   * automatic search and adds a search listener to trigger searches.
   */
  public SearchTableAction(DataTable<T> dataTable) {
    this.dataTable = dataTable;
    this.searchBox = SearchBox.create().addCss(dui_datatable_search_box);
    searchBox.setAutoSearch(true);
    searchBox.addSearchListener(
        token -> {
          search();
        });

    this.dataTable
        .addTableEventListener(SearchClearedEvent.SEARCH_EVENT_CLEARED, this)
        .getSearchContext()
        .addBeforeSearchHandler(
            context -> {
              context.removeByCategory(Category.SEARCH);
              context.add(Filter.create("*", searchBox.getTextBox().getValue(), Category.SEARCH));
            });

    init(this);
  }

  private void search() {
    this.dataTable.getSearchContext().fireSearchEvent();
  }

  /** Clears the search box. */
  public void clear() {
    searchBox.clearSearch();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Handles events related to search, particularly clearing the search box when the search is
   * cleared.
   *
   * @param event The table event to handle.
   */
  @Override
  public void handleEvent(DominoEvent event) {
    if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
      searchBox.clearSearch(true);
    }
  }

  /**
   * Configures the search box with a custom handler using method chaining.
   *
   * @param handler The custom handler to apply to the search box.
   * @return This {@code SearchTableAction} instance for method chaining.
   */
  public SearchTableAction<T> withSearchBox(ChildHandler<SearchTableAction<T>, SearchBox> handler) {
    handler.apply(this, searchBox);
    return this;
  }

  @Override
  public HTMLElement element() {
    return searchBox.element();
  }
}
