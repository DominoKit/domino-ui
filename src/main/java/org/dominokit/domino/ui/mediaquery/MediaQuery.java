package org.dominokit.domino.ui.mediaquery;

import elemental2.dom.EventTarget;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import jsinterop.base.Js;

import java.util.HashMap;
import java.util.Map;

import static elemental2.dom.DomGlobal.window;

public class MediaQuery {

    private static final String LARGE_MEDIA_QUERY = "(min-width: 1200px)";
    private static final String MEDIUM_MEDIA_QUERY = "(min-width: 992px) and (max-width: 1200px)";
    private static final String SMALL_MEDIA_QUERY = "(min-width: 768px) and (max-width: 992px)";
    private static final String XSMALL_MEDIA_QUERY = "(max-width: 768px)";

    private static MediaQueryList largeMediaQueryList = window.matchMedia(LARGE_MEDIA_QUERY);
    private static MediaQueryList mediumMediaQueryList = window.matchMedia(MEDIUM_MEDIA_QUERY);
    private static MediaQueryList smallMediaQueryList = window.matchMedia(SMALL_MEDIA_QUERY);
    private static MediaQueryList xsmallMediaQueryList = window.matchMedia(XSMALL_MEDIA_QUERY);

    private static Map<MediaQueryListener, MediaQueryListListener> listenersMap = new HashMap<>();
    private static Map<String, MediaQueryList> mediaQueries = new HashMap<>();

    public static void addOnLargeListener(MediaQueryListener listener) {
        addListener(listener, largeMediaQueryList);
    }

    public static void addOnMediumListener(MediaQueryListener listener) {
        addListener(listener, mediumMediaQueryList);
    }

    public static void addOnSmallListener(MediaQueryListener listener) {
        addListener(listener, smallMediaQueryList);
    }

    public static void addOnXSmallListener(MediaQueryListener listener) {
        addListener(listener, xsmallMediaQueryList);
    }

    public static void addPortraitOrientationListener(MediaQueryListener listener) {
        addCustomQueryListener("(orientation : portrait)", listener);
    }

    public static void addLandscapeOrientationListener(MediaQueryListener listener) {
        addCustomQueryListener("(orientation : landscape)", listener);
    }

    private static void addListener(MediaQueryListener listener, MediaQueryList mediaQueryList) {
        MediaQueryListListener mediaQueryListListener = p0 -> {
            if (p0.matches) {
                listener.onMatch();
            }
        };
        mediaQueryList.addListener(mediaQueryListListener);
        listenersMap.put(listener, mediaQueryListListener);
        mediaQueryListListener.onInvoke(mediaQueryList);
    }

    public static void removeOnLargeListener(MediaQueryListener listener) {
        removeListener(listener, largeMediaQueryList);
    }

    public static void removeOnMediumListener(MediaQueryListener listener) {
        removeListener(listener, mediumMediaQueryList);
    }

    public static void removeOnSmallListener(MediaQueryListener listener) {
        removeListener(listener, smallMediaQueryList);
    }

    public static void removeOnXSmallListener(MediaQueryListener listener) {
        removeListener(listener, xsmallMediaQueryList);
    }

    private static void removeListener(MediaQueryListener listener, MediaQueryList mediaQueryList) {
        if (listenersMap.containsKey(listener)) {
            mediaQueryList.removeListener(listenersMap.get(listener));
            listenersMap.remove(listener);
        }
    }

    public static void addCustomQueryListener(String mediaQuery, MediaQueryListener listener) {
        if (!mediaQueries.containsKey(mediaQuery)) {
            MediaQueryList mediaQueryList = window.matchMedia(mediaQuery);
            mediaQueries.put(mediaQuery, mediaQueryList);
        }
        EventTarget mediaQueryList = mediaQueries.get(mediaQuery);
        addListener(listener, Js.uncheckedCast(mediaQueryList));
    }

    public static void removeCustomQueryListener(String mediaQuery, MediaQueryListener listener) {
        if (mediaQueries.containsKey(mediaQuery)) {
            removeListener(listener, mediaQueries.get(mediaQuery));
        }
    }

    @FunctionalInterface
    public interface MediaQueryListener {
        void onMatch();
    }
}
