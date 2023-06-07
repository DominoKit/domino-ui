package org.dominokit.domino.ui.style;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

public interface IsCssProperty {
    void apply(Element element);
    default void apply(IsElement<?> element){
        apply(element.element());
    }
    void remove(Element element);
    default void remove(IsElement<?> element){
        remove(element.element());
    }
}
