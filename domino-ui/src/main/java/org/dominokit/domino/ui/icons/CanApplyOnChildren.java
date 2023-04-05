package org.dominokit.domino.ui.icons;

import org.dominokit.domino.ui.utils.ElementHandler;

public interface CanApplyOnChildren<T, C> {
    T forEachChild(ElementHandler<C> handler);
}
