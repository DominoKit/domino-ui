package org.dominokit.domino.ui.utils;

/**
 * this interface is used to implement custom meta-object for components with a unique key then later
 * these meta-objects can be added to the component and can be used for any kind of logic.
 */
public interface ComponentMeta {
    /** @return String, a unique key for the meta-object */
    String getKey();
}
