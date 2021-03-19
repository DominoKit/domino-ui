package org.dominokit.domino.ui.spin;

/**
 * A handler which will be called when navigating between items in a {@link SpinSelect}
 */
@FunctionalInterface
public interface NavigationHandler {
    /**
     * @param direction the direction of the spin
     */
    void onNavigate(Direction direction);
}
