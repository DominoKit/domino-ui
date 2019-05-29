package org.dominokit.domino.ui.datatable.model;

import java.util.Objects;

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

    public Operator(String name) {
        this.name = name;
    }

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
