package org.dominokit.domino.ui.masking;

public class AlphabeticalDefinition implements PatternDefinition {
    @Override
    public char keyChar() {
        return 'a';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches("^[A-Za-z]+$");
    }
}
