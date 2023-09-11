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

/** A class to define filter operators, each operator is a simple name string */
public class Operator {

  /** Constant <code>isEqualTo</code> */
  public static final Operator isEqualTo = new Operator("equals");
  /** Constant <code>notEquals</code> */
  public static final Operator notEquals = new Operator("notEquals");
  /** Constant <code>startsWith</code> */
  public static final Operator startsWith = new Operator("startsWith");
  /** Constant <code>endsWith</code> */
  public static final Operator endsWith = new Operator("endsWith");
  /** Constant <code>lessThan</code> */
  public static final Operator lessThan = new Operator("lessThan");
  /** Constant <code>lessThanOrEquals</code> */
  public static final Operator lessThanOrEquals = new Operator("lessThanOrEquals");
  /** Constant <code>greaterThan</code> */
  public static final Operator greaterThan = new Operator("greaterThan");
  /** Constant <code>greaterThanOrEquals</code> */
  public static final Operator greaterThanOrEquals = new Operator("greaterThanOrEquals");
  /** Constant <code>between</code> */
  public static final Operator between = new Operator("between");
  /** Constant <code>is_Null</code> */
  public static final Operator is_Null = new Operator("isNull");
  /** Constant <code>isNotNull</code> */
  public static final Operator isNotNull = new Operator("isNotNull");
  /** Constant <code>isRankedFirst</code> */
  public static final Operator isRankedFirst = new Operator("isRankedFirst");
  /** Constant <code>isRankedLast</code> */
  public static final Operator isRankedLast = new Operator("isRankedLast");
  /** Constant <code>isInTop</code> */
  public static final Operator isInTop = new Operator("isInTop");
  /** Constant <code>isInBottom</code> */
  public static final Operator isInBottom = new Operator("isInBottom");
  /** Constant <code>isContains</code> */
  public static final Operator isContains = new Operator("contains");
  /** Constant <code>containsAll</code> */
  public static final Operator containsAll = new Operator("containsAll");
  /** Constant <code>notContains</code> */
  public static final Operator notContains = new Operator("notContains");
  /** Constant <code>containsAny</code> */
  public static final Operator containsAny = new Operator("containsAny");
  /** Constant <code>like</code> */
  public static final Operator like = new Operator("like");
  /** Constant <code>notLike</code> */
  public static final Operator notLike = new Operator("notLike");

  private final String name;

  /** @param name String, the operator name */
  /**
   * Constructor for Operator.
   *
   * @param name a {@link java.lang.String} object
   */
  public Operator(String name) {
    this.name = name;
  }

  /** @return String, the operator name */
  /**
   * Getter for the field <code>name</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getName() {
    return name;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Operator)) return false;
    Operator operator = (Operator) o;
    return Objects.equals(getName(), operator.getName());
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
