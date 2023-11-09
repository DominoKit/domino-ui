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
 * The {@code Filter} class represents a filter that can be applied to a DataTable.
 *
 * <p>A filter consists of several properties including the field name, filter type, operator,
 * values, and category. These properties are used to define and configure the filter's behavior.
 *
 * <p>{@code Filter} objects are typically used to filter data in a DataTable based on certain
 * criteria.
 *
 * @see org.dominokit.domino.ui.datatable.DataTable
 */
public class Filter {

  private String fieldName;
  private FilterTypes type;
  private Operator operator;
  private List<String> values;
  private Category category;

  /**
   * Creates a new filter with the specified field name, value, and category.
   *
   * @param field The name of the field to filter on.
   * @param value The filter value.
   * @param category The category of the filter.
   * @return A new {@code Filter} instance.
   */
  public static Filter create(String field, String value, Category category) {
    List<String> values = new ArrayList<>();
    values.add(value);
    return new Filter(field, FilterTypes.STRING, Operator.like, values, category);
  }

  /**
   * Creates a new filter with the specified field name, value, category, and filter type.
   *
   * @param field The name of the field to filter on.
   * @param value The filter value.
   * @param category The category of the filter.
   * @param type The filter type.
   * @return A new {@code Filter} instance.
   */
  public static Filter create(String field, String value, Category category, FilterTypes type) {
    List<String> values = new ArrayList<>();
    values.add(value);
    return new Filter(field, type, Operator.like, values, category);
  }

  /**
   * Initializes a list of filters with the provided filter.
   *
   * @param filter The filter to initialize the list with.
   * @return A list of filters containing the specified filter.
   */
  public static List<Filter> initListWith(Filter filter) {
    List<Filter> filters = new ArrayList<>();
    filters.add(filter);
    return filters;
  }

  /**
   * Creates a new {@code Filter} instance with the specified field name, filter type, operator,
   * values, and category.
   *
   * @param fieldName The name of the field to filter on.
   * @param type The filter type.
   * @param operator The filter operator.
   * @param values The filter values.
   * @param category The category of the filter.
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

  /**
   * Gets the name of the field to filter on.
   *
   * @return The field name.
   */
  public String getFieldName() {
    return fieldName;
  }

  /**
   * Gets the filter type.
   *
   * @return The filter type.
   */
  public FilterTypes getType() {
    return type;
  }

  /**
   * Gets the filter operator.
   *
   * @return The filter operator.
   */
  public Operator getOperator() {
    return operator;
  }

  /**
   * Gets the filter values.
   *
   * @return The filter values.
   */
  public List<String> getValues() {
    return values;
  }

  /**
   * Gets the category of the filter.
   *
   * @return The filter category.
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Sets the name of the field to filter on.
   *
   * @param fieldName The field name.
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   * Sets the filter type.
   *
   * @param type The filter type.
   */
  public void setType(FilterTypes type) {
    this.type = type;
  }

  /**
   * Sets the filter operator.
   *
   * @param operator The filter operator.
   */
  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  /**
   * Sets the filter values.
   *
   * @param values The filter values.
   */
  public void setValues(List<String> values) {
    this.values = values;
  }

  /**
   * Sets the category of the filter.
   *
   * @param category The filter category.
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * Compares this filter to the specified object. The result is {@code true} if and only if the
   * argument is not {@code null} and is a {@code Filter} object with the same field name and
   * category as this filter.
   *
   * @param o The object to compare this filter against.
   * @return {@code true} if the given object is equal to this filter; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Filter)) return false;
    Filter filter = (Filter) o;
    return Objects.equals(getFieldName(), filter.getFieldName())
        && getCategory() == filter.getCategory();
  }

  /**
   * Computes a hash code for this filter based on its field name and category.
   *
   * @return A hash code for this filter.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFieldName(), getCategory());
  }
}
