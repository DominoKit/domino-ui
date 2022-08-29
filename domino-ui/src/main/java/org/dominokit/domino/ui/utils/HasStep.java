package org.dominokit.domino.ui.utils;

public interface HasStep<T,V>{

    V getStep();
    T setStep(V step);
}
