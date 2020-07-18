package org.dominokit.domino.ui.upload;

public enum DropEffect {
    COPY("copy"), MOVE("move"), LINK("link"), NONE("none");

    private String effect;

    DropEffect(String effect) {
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }
}
