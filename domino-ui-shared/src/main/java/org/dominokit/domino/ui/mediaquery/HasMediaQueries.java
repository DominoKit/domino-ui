package org.dominokit.domino.ui.mediaquery;

public interface HasMediaQueries<T> {

    T onXSmall(MediaQueryHandler<T> handler);
    T onXSmallAndDown(MediaQueryHandler<T> handler);
    T onXSmallAndUp(MediaQueryHandler<T> handler);

    T onSmall(MediaQueryHandler<T> handler);
    T onSmallAndDown(MediaQueryHandler<T> handler);
    T onSmallAndUp(MediaQueryHandler<T> handler);

    T onMedium(MediaQueryHandler<T> handler);
    T onMediumAndDown(MediaQueryHandler<T> handler);
    T onMediumAndUp(MediaQueryHandler<T> handler);

    T onLarge(MediaQueryHandler<T> handler);
    T onLargeAndDown(MediaQueryHandler<T> handler);
    T onLargeAndUp(MediaQueryHandler<T> handler);


    T onXLarge(MediaQueryHandler<T> handler);
    T onXLargeAndDown(MediaQueryHandler<T> handler);
    T onXLargeAndUp(MediaQueryHandler<T> handler);
}
