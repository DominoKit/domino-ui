package org.dominokit.domino.ui.utils;

import elemental2.dom.Event;

import java.util.Optional;
import java.util.function.Consumer;

public interface CanChange {
    default Optional<Consumer<Event>> onChange(){
        return Optional.empty();
    }
}
