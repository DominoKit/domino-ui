package org.dominokit.domino.ui.utils;

public interface HasMinMaxValue<T, V> {
     String MAX_VALUE ="max";
     String MIN_VALUE ="min";
     V getMaxValue();
     T setMaxValue(V maxValue);
     V getMinValue();
     T setMinValue(V minLength);
}
