package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;

public interface IsGroup<T> {

    T addButton(Button button);

    T addDropDown(DropdownButton dropDown);

    IsGroup<T> verticalAlign();

    IsGroup<T> horizontalAlign();
}
