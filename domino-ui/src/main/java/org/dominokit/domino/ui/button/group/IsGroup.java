package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;

/**
 * this interface provide contract to implement different types of button groups
 *
 * @param <T> this is the same type that is implementing this interface for fluent API.
 */
public interface IsGroup<T> {

    /**
     * Appends a button to the buttons group
     * @param button {@link Button}
     * @return same instance
     */
    T appendChild(Button button);

    /**
     * Appends a dropdown button to the buttons group
     * @param dropDown {@link DropdownButton}
     * @return same instabce
     */
    T appendChild(DropdownButton dropDown);

    /**
     * sets the buttons group as a vertical buttons group aligning the buttons vertically
     * @return same instance
     */
    T verticalAlign();

    /**
     * sets the buttons group as a horizontal buttons group aligning the buttons horizontally
     * @return same instance
     */
    T horizontalAlign();
}
