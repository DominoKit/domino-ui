package org.dominokit.domino.ui.upload;

/**
 * An enum representing the drop effect
 * <p>
 * More information can be found in <a href="https://developer.mozilla.org/en-US/docs/Web/API/DataTransfer/dropEffect">MDN official documentation</a>
 */
public enum DropEffect {
    COPY("copy"), MOVE("move"), LINK("link"), NONE("none");

    private final String effect;

    DropEffect(String effect) {
        this.effect = effect;
    }

    /**
     * @return the effect
     */
    public String getEffect() {
        return effect;
    }
}
