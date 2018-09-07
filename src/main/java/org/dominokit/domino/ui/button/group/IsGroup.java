package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;

public interface IsGroup<T> {

    /**
     * @deprecated use {@link #appendChild(Button)}
     */
    @Deprecated
    T addButton(Button button);


    T appendChild(Button button);

    /**
     * @deprecated use {@link #appendChild(DropdownButton)}
     */
    @Deprecated
    T addDropDown(DropdownButton dropDown);

    T appendChild(DropdownButton dropDown);

    IsGroup<T> verticalAlign();

    IsGroup<T> horizontalAlign();
}
