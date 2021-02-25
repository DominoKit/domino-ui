package org.dominokit.domino.ui.utils;

/**
 * An interface for a component that can have different sizes
 * @param <T> the type of component implementing this interface
 */
public interface Sizable<T> {
    /**
     * set the size to large
     * @return same component instance
     */
    T large();
    /**
     * set the size to medium
     * @return same component instance
     */
    T medium();
    /**
     * set the size to small
     * @return same component instance
     */
    T small();
    /**
     * set the size to xSmall
     * @return same component instance
     */
    T xSmall();
}
