package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;

public class SuggestItem {

    private DropdownAction element;

    public SuggestItem(String value) {
        this(value, Icons.ALL.text_fields());
    }

    public SuggestItem(String value, BaseIcon<?> icon) {
        element = DropdownAction.create(value, icon, value);
    }

    public static SuggestItem create(String value) {
        return new SuggestItem(value);
    }

    public static SuggestItem create(String value, BaseIcon<?> icon) {
        return new SuggestItem(value, icon);
    }

    public void highlight(String value, Color highlightColor) {
        element.highlight(value, highlightColor);
    }

    public DropdownAction asDropDownAction() {
        return element;
    }

    public String getValue() {
        return element.getValue();
    }
}
