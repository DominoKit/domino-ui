package org.dominokit.ui.tools.processor;

public enum ColorShade {

    NONE("",""),
    L1("l-1-", " LIGHTEN 1"),
    L2("l-2-", " LIGHTEN 2"),
    L3("l-3-", " LIGHTEN 3"),
    L4("l-4-", " LIGHTEN 4"),
    L5("l-5-", " LIGHTEN 5"),
    D1("d-1-", " DARKEN 1"),
    D2("d-2-", " DARKEN 2"),
    D3("d-3-", " DARKEN 3"),
    D4("d-4-", " DARKEN 4");

    private final String styleExtension;
    private final String nameExtension;

    ColorShade(String styleExtension, String nameExtension) {

        this.styleExtension = styleExtension;
        this.nameExtension = nameExtension;
    }

    public String getStyleExtension() {
        return styleExtension;
    }

    public String getNameExtension() {
        return nameExtension;
    }

    public String asFieldNameExtension(){
        return nameExtension
                .replaceAll(" ","_");
    }
}
