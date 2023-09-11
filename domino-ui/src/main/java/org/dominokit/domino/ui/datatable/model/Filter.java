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

  private String fieldName;
  private FilterTypes type;
  private Operator operator;
  private List<String> values;
  private Category category;

  /**
   * Creates a Filter of {@link org.dominokit.domino.ui.datatable.model.FilterTypes#STRING} and
   * {@link org.dominokit.domino.ui.datatable.model.Operator#like}
   *
   * @param field String, the name if field
   * @param value String, the value of the filter
   * @param category the {@link org.dominokit.domino.ui.datatable.model.Category} of the filter
   * @return new Filter instance
   */
  public static Filter create(String field, String value, Category category) {
    List<String> values = new ArrayList<>();
    values.add(value);
    return new Filter(field, FilterTypes.STRING, Operator.like, values, category);
  }

  /**
   * Creates a Filter with {@link org.dominokit.domino.ui.datatable.model.Operator#like}
   *
   * @param field String, the name if field
   * @param value String, the value of the filter
   * @param category the {@link org.dominokit.domino.ui.datatable.model.Category} of the filter
   * @param type the {@link org.dominokit.domino.ui.datatable.model.FilterTypes}
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
   * @param filter {@link org.dominokit.domino.ui.datatable.model.Filter}
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
   * @param type the {@link org.dominokit.domino.ui.datatable.model.FilterTypes}
   * @param operator the {@link org.dominokit.domino.ui.datatable.model.Operator}
   * @param values List of values
   * @param category the {@link org.dominokit.domino.ui.datatable.model.Category} of the filter
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
  /**
   * Getter for the field <code>fieldName</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getFieldName() {
    return fieldName;
  }

  /** @return {@link FilterTypes} */
  /**
   * Getter for the field <code>type</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.model.FilterTypes} object
   */
  public FilterTypes getType() {
    return type;
  }

  /** @return the {@link Operator} */
  /**
   * Getter for the field <code>operator</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.model.Operator} object
   */
  public Operator getOperator() {
    return operator;
  }

  /** @return List of String values of the filter */
  /**
   * Getter for the field <code>values</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<String> getValues() {
    return values;
  }

  /** @return the {@link Category} */
  /**
   * Getter for the field <code>category</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.model.Category} object
   */
  public Category getCategory() {
    return category;
  }

  /** @param fieldName the field name to be set */
  /**
   * Setter for the field <code>fieldName</code>.
   *
   * @param fieldName a {@link java.lang.String} object
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /** @param type the type to be set */
  /**
   * Setter for the field <code>type</code>.
   *
   * @param type a {@link org.dominokit.domino.ui.datatable.model.FilterTypes} object
   */
  public void setType(FilterTypes type) {
    this.type = type;
  }

  /** @param operator the operator to be set */
  /**
   * Setter for the field <code>operator</code>.
   *
   * @param operator a {@link org.dominokit.domino.ui.datatable.model.Operator} object
   */
  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  /** @param values the values to be set */
  /**
   * Setter for the field <code>values</code>.
   *
   * @param values a {@link java.util.List} object
   */
  public void setValues(List<String> values) {
    this.values = values;
  }

  /** @param category the category to be set */
  /**
   * Setter for the field <code>category</code>.
   *
   * @param category a {@link org.dominokit.domino.ui.datatable.model.Category} object
   */
  public void setCategory(Category category) {
    this.category = category;
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
