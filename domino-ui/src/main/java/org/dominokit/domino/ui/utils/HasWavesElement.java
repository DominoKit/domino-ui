package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;

/**
 * A component that can have Waves effect should implement this interface
 */
@FunctionalInterface
public interface HasWavesElement {
    /**
     *
     * @return the {@link HTMLElement} that has the wave effect
     */
    HTMLElement getWavesElement();
}
