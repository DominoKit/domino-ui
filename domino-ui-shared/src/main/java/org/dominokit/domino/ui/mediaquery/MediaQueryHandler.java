package org.dominokit.domino.ui.mediaquery;
@FunctionalInterface
public interface MediaQueryHandler<T> {
    MediaQuery.MediaQueryListener onMedia(T element);
}
