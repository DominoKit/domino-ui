package org.dominokit.domino.ui.datatable;

import elemental2.dom.Node;

/**
 * An interface to provide different implementations for a column header content
 */
@FunctionalInterface
public interface HeaderElement{
    /**
     *
     * @param columnTitle String column title
     * @return the {@link Node} representing the column header content
     */
    Node asElement(String columnTitle);
}
