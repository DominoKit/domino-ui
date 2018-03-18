package com.progressoft.brix.domino.ui.button.group;

import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.button.DropdownButton;

public interface IsGroup<T> {

    T addButton(Button button);

    T addDropDown(DropdownButton dropDown);

    IsGroup<T> verticalAlign();

    IsGroup<T> horizontalAlign();
}
