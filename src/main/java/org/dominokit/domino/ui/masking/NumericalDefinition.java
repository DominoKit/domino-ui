package org.dominokit.domino.ui.masking;

public class NumericalDefinition implements PatternDefinition {

    @Override
    public char keyChar() {
        return '0';
    }

    @Override
    public boolean isMatch(char c) {
        return String.valueOf(c).matches("^\\d+$");
    }
}
