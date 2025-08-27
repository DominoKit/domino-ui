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

/**
 * The {@code FilterTypes} enum represents different filter types that can be used in a DataTable
 * filter.
 *
 * <p>Each filter type corresponds to a specific data type and defines how data should be filtered
 * based on that type. For example, the {@code STRING} filter type is used for text-based filtering,
 * while {@code INTEGER} is used for integer-based filtering.
 *
 * @see org.dominokit.domino.ui.datatable.model.Filter
 */
public enum FilterTypes implements FilterType {
  /** Represents a string-based filter type, used for text-based filtering. */
  STRING,

  /** Represents an integer-based filter type, used for integer-based filtering. */
  INTEGER,

  /** Represents a long-based filter type, used for long-based filtering. */
  LONG,

  /** Represents a double-based filter type, used for double-based filtering. */
  DOUBLE,

  /** Represents a short-based filter type, used for short-based filtering. */
  SHORT,

  /** Represents a float-based filter type, used for float-based filtering. */
  FLOAT,

  /** Represents a decimal-based filter type, used for decimal-based filtering. */
  DECIMAL,

  /** Represents a boolean-based filter type, used for boolean-based filtering. */
  BOOLEAN,

  /** Represents a date-based filter type, used for date-based filtering. */
  DATE,

  /** Represents a time-based filter type, used for time-based filtering. */
  TIME,

  /** Represents an enum-based filter type, used for enum-based filtering. */
  ENUM;

  @Override
  public String getTypeName() {
    return this.name();
  }
}
