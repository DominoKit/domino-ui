package org.dominokit.domino.ui.menu;

public interface MenuSearchFilter {
    boolean onSearch(String token, boolean caseSensitive);
}
