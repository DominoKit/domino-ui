///*
// * Copyright © 2019 Dominokit
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.dominokit.domino.ui.datatable.plugins.filter.header;
//
//import elemental2.dom.HTMLElement;
//import org.dominokit.domino.ui.datatable.ColumnConfig;
//import org.dominokit.domino.ui.datatable.model.Category;
//import org.dominokit.domino.ui.datatable.model.Filter;
//import org.dominokit.domino.ui.datatable.model.FilterTypes;
//import org.dominokit.domino.ui.datatable.model.SearchContext;
//import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
//import org.dominokit.domino.ui.forms.Select;
//import org.dominokit.domino.ui.forms.SelectOption;
//
///**
// * Boolean column header filter component that is rendered as a {@link Select} component
// *
// * @param <T> type of data table records
// */
//public class BooleanHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {
//
//  private final Select<String> select;
//
//  /**
//   * Creates an instance with default labels <b>ALL</b>,</b><b>Yes</b>,<b>No</b>
//   *
//   * @param <T> the data table records type
//   * @return new instance
//   */
//  public static <T> BooleanHeaderFilter<T> create() {
//    return new BooleanHeaderFilter<>();
//  }
//  /**
//   * Creates an instance with specified labels
//   *
//   * @param trueLabel String, the label for the Yes option
//   * @param falseLabel String, the label for the No option
//   * @param bothLabel String, the label for the ALL option
//   * @param <T> the data table records type
//   * @return new instance
//   */
//  public static <T> BooleanHeaderFilter<T> create(
//      String trueLabel, String falseLabel, String bothLabel) {
//    return new BooleanHeaderFilter<>(trueLabel, falseLabel, bothLabel);
//  }
//
//  /** @see BooleanHeaderFilter#create() */
//  public BooleanHeaderFilter() {
//    this("Yes", "No", "ALL");
//  }
//
//  /**
//   * @see BooleanHeaderFilter#create(String, String, String)
//   * @param trueLabel String, the label for the Yes option
//   * @param falseLabel String, the label for the No option
//   * @param bothLabel String, the label for the ALL option
//   */
//  public BooleanHeaderFilter(String trueLabel, String falseLabel, String bothLabel) {
//    select =
//        Select.<String>create()
//            .appendChild(SelectOption.create("", bothLabel))
//            .appendChild(SelectOption.create(Boolean.TRUE.toString(), trueLabel))
//            .appendChild(SelectOption.create(Boolean.FALSE.toString(), falseLabel))
//            .setSearchable(false)
//            .selectAt(0);
//
//    select.styler(style -> style.setMarginBottom("0px"));
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
//    searchContext.addBeforeSearchHandler(
//        context -> {
//          if (select.getSelectedIndex() > 0) {
//            searchContext.add(
//                Filter.create(
//                    columnConfig.getName(),
//                    select.getValue(),
//                    Category.HEADER_FILTER,
//                    FilterTypes.BOOLEAN));
//          } else {
//            searchContext.remove(columnConfig.getName(), Category.HEADER_FILTER);
//          }
//        });
//    select.addSelectionHandler(option -> searchContext.fireSearchEvent());
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public void clear() {
//    select.selectAt(0, true);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public HTMLElement element() {
//    return select.element();
//  }
//
//  /** @return the {@link Select} component wrapped in this filter */
//  public Select<String> getSelect() {
//    return select;
//  }
//}
