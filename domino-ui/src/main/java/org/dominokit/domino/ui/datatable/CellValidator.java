package org.dominokit.domino.ui.datatable;

import org.dominokit.domino.ui.forms.validations.ValidationResult;

/**
 * Implementations of this interface will validate an editable cell
 */
@FunctionalInterface
public interface CellValidator {
    /**
     *
     * @return the {@link ValidationResult}
     */
    ValidationResult onValidate();
}
