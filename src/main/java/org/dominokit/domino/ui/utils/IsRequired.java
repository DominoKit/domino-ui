package org.dominokit.domino.ui.utils;

public interface IsRequired<T> {

    T setRequired(boolean required);

    T setRequired(boolean required, String message);

    boolean isRequired();
}
