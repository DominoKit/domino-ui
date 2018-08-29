package org.dominokit.domino.ui.grid;

public enum SectionSpan {
    _1(1), _2(2), _3(3), _4(4), _5(5), _6(6);

    private int value;

    SectionSpan(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
