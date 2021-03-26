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

  public static final Operator isEqualTo = new Operator("equals");
  public static final Operator notEquals = new Operator("notEquals");
  public static final Operator startsWith = new Operator("startsWith");
  public static final Operator endsWith = new Operator("endsWith");
  public static final Operator lessThan = new Operator("lessThan");
  public static final Operator lessThanOrEquals = new Operator("lessThanOrEquals");
  public static final Operator greaterThan = new Operator("greaterThan");
  public static final Operator greaterThanOrEquals = new Operator("greaterThanOrEquals");
  public static final Operator between = new Operator("between");
  public static final Operator is_Null = new Operator("isNull");
  public static final Operator isNotNull = new Operator("isNotNull");
  public static final Operator isRankedFirst = new Operator("isRankedFirst");
  public static final Operator isRankedLast = new Operator("isRankedLast");
  public static final Operator isInTop = new Operator("isInTop");
  public static final Operator isInBottom = new Operator("isInBottom");
  public static final Operator isContains = new Operator("contains");
  public static final Operator containsAll = new Operator("containsAll");
  public static final Operator notContains = new Operator("notContains");
  public static final Operator containsAny = new Operator("containsAny");
  public static final Operator like = new Operator("like");
  public static final Operator notLike = new Operator("notLike");

  private final String name;

  /** @param name String, the operator name */
  public Operator(String name) {
    this.name = name;
  }

  /** @return String, the operator name */
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
