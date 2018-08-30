package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;

public interface IsGroup<T> {

    /**
     * @deprecated use {@link #appendChild(Button)}
     * @param button
     * @return
     */
    @Deprecated
    T addButton(Button button);


    T appendChild(Button button);

    /**
     * @deprecated use {@link #appendChild(DropdownButton)}
     * @param dropDown
     * @return
     */
    @Deprecated
    T addDropDown(DropdownButton dropDown);

    T appendChild(DropdownButton dropDown);

    IsGroup<T> verticalAlign();

    IsGroup<T> horizontalAlign();
}
