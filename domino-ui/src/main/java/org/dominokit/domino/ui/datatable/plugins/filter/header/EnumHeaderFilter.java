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
/// *
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
// package org.dominokit.domino.ui.datatable.plugins.filter.header;
//
// import elemental2.dom.HTMLElement;
// import java.util.Arrays;
// import org.dominokit.domino.ui.datatable.ColumnConfig;
// import org.dominokit.domino.ui.datatable.model.Category;
// import org.dominokit.domino.ui.datatable.model.Filter;
// import org.dominokit.domino.ui.datatable.model.FilterTypes;
// import org.dominokit.domino.ui.datatable.model.SearchContext;
// import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
// import org.dominokit.domino.ui.forms.Select;
// import org.dominokit.domino.ui.forms.SelectOption;
//
/// **
// * Enum column header filter component that is rendered as a {@link Select} component
// *
// * @param <T> type of data table records
// * @param <E> the enum type
// */
// public class EnumHeaderFilter<T, E extends Enum>
//    implements ColumnHeaderFilterPlugin.HeaderFilter<T> {
//
//  private final Select<String> select;
//
//  /**
//   * Creates a filter from an array of enum values and default label <b>ALL</b> for all option
//   *
//   * @param values Array of enum values
//   * @param <T> type of data table records
//   * @param <E> the enum type
//   * @return new instance
//   */
//  public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values) {
//    return new EnumHeaderFilter<>(values, "ALL");
//  }
//
//  /**
//   * Creates a filter from an array of enum values and a custom label for all option
//   *
//   * @param values Array of enum values
//   * @param <T> type of data table records
//   * @param <E> the enum type
//   * @return new instance
//   */
//  public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values, String allLabel) {
//    return new EnumHeaderFilter<>(values, allLabel);
//  }
//
//  /**
//   * Creates a filter from an array of enum values and a custom label for all option
//   *
//   * @param values Array of enum values
//   */
//  public EnumHeaderFilter(E[] values, String allLabel) {
//    select =
//        Select.<String>create()
//            .appendChild(SelectOption.create("", allLabel))
//            .apply(
//                element ->
//                    Arrays.stream(values)
//                        .forEach(
//                            value ->
//                                element.appendChild(
//                                    SelectOption.create(value.toString(), value.toString()))))
//            .selectAt(0);
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
//                    FilterTypes.ENUM));
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
//  /** @return the {@link Select} wrapped in this component */
//  public Select<String> getSelect() {
//    return select;
//  }
// }
