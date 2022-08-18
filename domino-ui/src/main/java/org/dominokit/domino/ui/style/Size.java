package org.dominokit.domino.ui.style;

import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

public class ElementSize {
    static <T extends IsElement<?>> BaseDominoElement.ElementHandler<T> large(){
        return (Size<T>) () -> "css-large";
    }

    static <T extends IsElement<?>> BaseDominoElement.ElementHandler<T> medium(){
        return (Size<T>) () -> "css-medium";
    }

    static <T extends IsElement<?>> BaseDominoElement.ElementHandler<T> small(){
        return (Size<T>) () -> "css-small";
    }
}
