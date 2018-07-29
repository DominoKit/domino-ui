package org.dominokit.domino.ui.masking.definitions;

import org.dominokit.domino.ui.masking.PatternDefinition;

import static org.dominokit.domino.ui.masking.Regex.ALPHANUMERIC_ONLY_REGEX;

public class AlphanumericDefinition implements PatternDefinition {
    @Override
    public char keyChar() {
        return '*';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches(ALPHANUMERIC_ONLY_REGEX);
    }
}
