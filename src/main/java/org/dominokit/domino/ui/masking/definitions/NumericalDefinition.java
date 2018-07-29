package org.dominokit.domino.ui.masking.definitions;

import org.dominokit.domino.ui.masking.PatternDefinition;

import static org.dominokit.domino.ui.masking.Regex.NUMBERS_ONLY_REGEX;

public class NumericalDefinition implements PatternDefinition {

    @Override
    public char keyChar() {
        return '0';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches(NUMBERS_ONLY_REGEX);
    }
}
