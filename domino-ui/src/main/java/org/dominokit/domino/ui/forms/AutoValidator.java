package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ApplyFunction;

/**
 * A class to wrap an {@link ApplyFunction} and provide the ability to attach/remove it from a
 * component
 */
public abstract class AutoValidator {
    protected ApplyFunction autoValidate;

    /**
     * @param autoValidate {@link ApplyFunction}
     */
    public AutoValidator(ApplyFunction autoValidate) {
        this.autoValidate = autoValidate;
    }

    /**
     * Attach the {@link ApplyFunction} to the component
     */
    public void attach(){}

    /**
     * Remove the {@link ApplyFunction} from the component
     */
    public void remove(){}
}
