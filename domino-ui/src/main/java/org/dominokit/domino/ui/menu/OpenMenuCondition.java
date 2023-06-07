package org.dominokit.domino.ui.menu;

public interface OpenMenuCondition<V> {
    boolean check(Menu<V> menu);
}
