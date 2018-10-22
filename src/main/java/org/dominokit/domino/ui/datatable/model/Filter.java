package org.dominokit.domino.ui.datatable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filter {

    private final String fieldName;
    private final Types type;
    private final Operator operator;
    private final List<String> values;
    private final Category category;

    public static Filter create(String field, String value, Category category) {
        List<String> values = new ArrayList<>();
        values.add(value);
        return new Filter(field, Types.STRING, Operator.like, values, category);
    }

    public static List<Filter> initListWith(Filter filter) {
        List<Filter> filters = new ArrayList<>();
        filters.add(filter);
        return filters;
    }

    public Filter(String fieldName, Types type, Operator operator, List<String> values, Category category) {
        this.fieldName = fieldName;
        this.type = type;
        this.operator = operator;
        this.values = values;
        this.category = category;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Types getType() {
        return type;
    }


    public Operator getOperator() {
        return operator;
    }

    public List<String> getValues() {
        return values;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filter)) return false;
        Filter filter = (Filter) o;
        return Objects.equals(getFieldName(), filter.getFieldName()) &&
                getCategory() == filter.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFieldName(), getCategory());
    }
}
