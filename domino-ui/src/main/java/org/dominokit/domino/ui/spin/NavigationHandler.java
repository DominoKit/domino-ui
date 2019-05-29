package org.dominokit.domino.ui.spin;

@FunctionalInterface
public interface NavigationHandler {
    void onNavigate(Direction direction);
}
