package org.dominokit.domino.ui.masking;

public class AlphanumericDefinition implements PatternDefinition {
    @Override
    public char keyChar() {
        return '*';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches("^[a-z0-9]+$");
    }
}
