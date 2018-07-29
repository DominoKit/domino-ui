package org.dominokit.domino.ui.masking.definitions;

import org.dominokit.domino.ui.masking.PatternDefinition;

import static org.dominokit.domino.ui.masking.Regex.ALPHABETICAL_ONLY_REGEX;

public class AlphabeticalDefinition implements PatternDefinition {
    @Override
    public char keyChar() {
        return 'a';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches(ALPHABETICAL_ONLY_REGEX);
    }
}
