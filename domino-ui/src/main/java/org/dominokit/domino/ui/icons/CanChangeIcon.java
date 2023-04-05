package org.dominokit.domino.ui.icons;

public interface CanChangeIcon<T extends Icon<T>> {

    /**
     * Change the icon to another icon
     *
     * @param replacement the new {@link Icon}
     * @return same instance
     */
    T changeTo(T replacement);
}
