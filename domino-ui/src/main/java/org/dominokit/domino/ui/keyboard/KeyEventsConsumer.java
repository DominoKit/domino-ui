package org.dominokit.domino.ui.keyboard;

@FunctionalInterface
public interface KeyEventsConsumer {

    void accept(AcceptKeyEvents keyEvents);
}
