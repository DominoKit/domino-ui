package org.dominokit.domino.ui.masking;

public interface PatternDefinition {

    char keyChar();

    boolean isMatch(char c);

    PatternDefinition ALPHABETICAL = new PatternDefinition() {
        @Override
        public char keyChar() {
            return 'a';
        }

        @Override
        public boolean isMatch(char c) {
            return String.valueOf(c).matches("^[A-Za-z]+$");
        }
    };

    PatternDefinition ALPHANUMERIC = new PatternDefinition() {
        @Override
        public char keyChar() {
            return '*';
        }

        @Override
        public boolean isMatch(char c) {
            return String.valueOf(c).matches("^[a-z0-9]+$");
        }
    };

    PatternDefinition NUMERICAL = new PatternDefinition() {
        @Override
        public char keyChar() {
            return '0';
        }

        @Override
        public boolean isMatch(char c) {
            return String.valueOf(c).matches("^\\d+$");
        }
    };
}
