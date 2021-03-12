package org.dominokit.domino.ui.grid;

/**
 * An enum representing the size of a section in {@link GridLayout}
 */
public enum SectionSpan {
    _1(1), _2(2), _3(3), _4(4), _5(5), _6(6);

    private final int value;

    SectionSpan(int value) {
        this.value = value;
    }

    /**
     * @return the size integer value
     */
    public int getValue() {
        return value;
    }
}
