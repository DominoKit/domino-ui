package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;

public class SuggestItem<T> {

    private DropdownAction<T> element;
    private T value;
    private final String displayValue;

    public SuggestItem(T value, String displayValue) {
        this(value, displayValue, Icons.ALL.text_fields());
    }

    public SuggestItem(T value, String displayValue, BaseIcon<?> icon) {
        element = DropdownAction.create(value, displayValue, icon);
        this.value = value;
        this.displayValue = displayValue;
    }

    public static SuggestItem<String> create(String value) {
        return new SuggestItem<>(value, value);
    }

    public static <T> SuggestItem<T> create(T value, String displayValue) {
        return new SuggestItem<>(value, displayValue);
    }

    public static <T> SuggestItem<T> create(T value, String displayValue, BaseIcon<?> icon) {
        return new SuggestItem<>(value, displayValue, icon);
    }

    public void highlight(String value, Color highlightColor) {
        element.highlight(value, highlightColor);
    }

    public DropdownAction<T> asDropDownAction() {
        return element;
    }

    public T getValue() {
        return element.getValue();
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
