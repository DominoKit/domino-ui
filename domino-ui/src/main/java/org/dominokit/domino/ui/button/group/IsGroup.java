package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;

public interface IsGroup<T> {

    T appendChild(Button button);

    T appendChild(DropdownButton dropDown);

    IsGroup<T> verticalAlign();

    IsGroup<T> horizontalAlign();
}
