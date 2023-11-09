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

import java.util.Objects;

/**
 * The {@code Operator} class represents different filter operators that can be used for filtering
 * data in a DataTable.
 *
 * <p>Operators define how the filtering operation should be performed, such as equality,
 * comparison, and pattern matching. Each operator has a name associated with it, which is used to
 * identify the type of operation.
 *
 * @see org.dominokit.domino.ui.datatable.model.Filter
 */
public class Operator {
  /** Represents the "equals" operator, used for equality comparison. */
  public static final Operator isEqualTo = new Operator("equals");

  /** Represents the "notEquals" operator, used for inequality comparison. */
  public static final Operator notEquals = new Operator("notEquals");

  /** Represents the "startsWith" operator, used for prefix matching. */
  public static final Operator startsWith = new Operator("startsWith");

  /** Represents the "endsWith" operator, used for suffix matching. */
  public static final Operator endsWith = new Operator("endsWith");

  /** Represents the "lessThan" operator, used for less than comparison. */
  public static final Operator lessThan = new Operator("lessThan");

  /** Represents the "lessThanOrEquals" operator, used for less than or equal to comparison. */
  public static final Operator lessThanOrEquals = new Operator("lessThanOrEquals");

  /** Represents the "greaterThan" operator, used for greater than comparison. */
  public static final Operator greaterThan = new Operator("greaterThan");

  /**
   * Represents the "greaterThanOrEquals" operator, used for greater than or equal to comparison.
   */
  public static final Operator greaterThanOrEquals = new Operator("greaterThanOrEquals");

  /** Represents the "between" operator, used for range comparison. */
  public static final Operator between = new Operator("between");

  /** Represents the "isNull" operator, used for checking if a value is null. */
  public static final Operator is_Null = new Operator("isNull");

  /** Represents the "isNotNull" operator, used for checking if a value is not null. */
  public static final Operator isNotNull = new Operator("isNotNull");

  /** Represents the "isRankedFirst" operator, used for checking if a value is ranked first. */
  public static final Operator isRankedFirst = new Operator("isRankedFirst");

  /** Represents the "isRankedLast" operator, used for checking if a value is ranked last. */
  public static final Operator isRankedLast = new Operator("isRankedLast");

  /** Represents the "isInTop" operator, used for checking if a value is in the top. */
  public static final Operator isInTop = new Operator("isInTop");

  /** Represents the "isInBottom" operator, used for checking if a value is in the bottom. */
  public static final Operator isInBottom = new Operator("isInBottom");

  /** Represents the "contains" operator, used for checking if a value contains another value. */
  public static final Operator isContains = new Operator("contains");

  /**
   * Represents the "containsAll" operator, used for checking if a value contains all specified
   * values.
   */
  public static final Operator containsAll = new Operator("containsAll");

  /**
   * Represents the "notContains" operator, used for checking if a value does not contain another
   * value.
   */
  public static final Operator notContains = new Operator("notContains");

  /**
   * Represents the "containsAny" operator, used for checking if a value contains any of the
   * specified values.
   */
  public static final Operator containsAny = new Operator("containsAny");

  /** Represents the "like" operator, used for pattern matching using wildcard characters. */
  public static final Operator like = new Operator("like");

  /**
   * Represents the "notLike" operator, used for pattern matching using wildcard characters with
   * negation.
   */
  public static final Operator notLike = new Operator("notLike");

  private final String name;

  /**
   * Constructs a new {@code Operator} with the given name.
   *
   * @param name the name of the operator
   */
  public Operator(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the operator.
   *
   * @return the name of the operator
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Operator)) return false;
    Operator operator = (Operator) o;
    return Objects.equals(getName(), operator.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
