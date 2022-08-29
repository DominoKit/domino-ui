package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.Function;

/**
 * A class to wrap an {@link ValueBox.AutoValidate} and provide the ability to attach/remove it from a
 * component
 */
public abstract class AutoValidator {
    protected Function autoValidate;

    /**
     * @param autoValidate {@link Function}
     */
    public AutoValidator(Function autoValidate) {
        this.autoValidate = autoValidate;
    }

    /**
     * Attach the {@link Function} to the component
     */
    public abstract void attach();

    /**
     * Remove the {@link Function} from the component
     */
    public abstract void remove();
}
