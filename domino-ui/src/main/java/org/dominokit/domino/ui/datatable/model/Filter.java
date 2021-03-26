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
package org.dominokit.domino.ui.datatable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represent a data table data filter which can be used to apply queries and filters on
 * data by the data store
 */
public class Filter {

  private final String fieldName;
  private final FilterTypes type;
  private final Operator operator;
  private final List<String> values;
  private final Category category;

  /**
   * Creates a Filter of {@link FilterTypes#STRING} and {@link Operator#like}
   *
   * @param field String, the name if field
   * @param value String, the value of the filter
   * @param category the {@link Category} of the filter
   * @return new Filter instance
   */
  public static Filter create(String field, String value, Category category) {
    List<String> values = new ArrayList<>();
    values.add(value);
    return new Filter(field, FilterTypes.STRING, Operator.like, values, category);
  }

  /**
   * Creates a Filter with {@link Operator#like}
   *
   * @param field String, the name if field
   * @param value String, the value of the filter
   * @param category the {@link Category} of the filter
   * @param type the {@link FilterTypes}
   * @return new Filter instance
   */
  public static Filter create(String field, String value, Category category, FilterTypes type) {
    List<String> values = new ArrayList<>();
    values.add(value);
    return new Filter(field, type, Operator.like, values, category);
  }

  /**
   * Creates a List of Filters initialized with a single filter
   *
   * @param filter {@link Filter}
   * @return new Filters list that contains the filters
   */
  public static List<Filter> initListWith(Filter filter) {
    List<Filter> filters = new ArrayList<>();
    filters.add(filter);
    return filters;
  }

  /**
   * creates a new filter
   *
   * @param fieldName String, the name if field
   * @param type the {@link FilterTypes}
   * @param operator the {@link Operator}
   * @param values List of values
   * @param category the {@link Category} of the filter
   */
  public Filter(
      String fieldName,
      FilterTypes type,
      Operator operator,
      List<String> values,
      Category category) {
    this.fieldName = fieldName;
    this.type = type;
    this.operator = operator;
    this.values = values;
    this.category = category;
  }

  /** @return String, the field name */
  public String getFieldName() {
    return fieldName;
  }

  /** @return {@link FilterTypes} */
  public FilterTypes getType() {
    return type;
  }

  /** @return the {@link Operator} */
  public Operator getOperator() {
    return operator;
  }

  /** @return List of String values of the filter */
  public List<String> getValues() {
    return values;
  }

  /** @return the {@link Category} */
  public Category getCategory() {
    return category;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Filter)) return false;
    Filter filter = (Filter) o;
    return Objects.equals(getFieldName(), filter.getFieldName())
        && getCategory() == filter.getCategory();
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(getFieldName(), getCategory());
  }
}
