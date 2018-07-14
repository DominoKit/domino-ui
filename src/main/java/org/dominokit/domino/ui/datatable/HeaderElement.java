package org.dominokit.domino.ui.datatable;

import elemental2.dom.Node;

@FunctionalInterface
public interface HeaderElement{
    Node asElement(String columnTitle);
}
