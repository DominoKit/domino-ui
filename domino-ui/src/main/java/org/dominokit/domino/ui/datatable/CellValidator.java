package org.dominokit.domino.ui.datatable;

import org.dominokit.domino.ui.forms.validations.ValidationResult;

@FunctionalInterface
public interface CellValidator {
    ValidationResult onValidate();
}
