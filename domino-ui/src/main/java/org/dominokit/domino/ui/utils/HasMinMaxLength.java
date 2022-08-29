package org.dominokit.domino.ui.utils;

import static java.util.Objects.isNull;

public interface HasMinMaxLength<T> {
     String MAX_LENGTH ="maxlength";
     String MIN_LENGTH ="minlength";
     int getMaxLength();
     T setMaxLength(int maxLength);
     int getMinLength();
     T setMinLength(int minLength);

     int getLength();
}
