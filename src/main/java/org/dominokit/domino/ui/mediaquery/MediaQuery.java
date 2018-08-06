package org.dominokit.domino.ui.mediaquery;

import elemental2.dom.EventTarget;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import jsinterop.base.Js;

import java.util.HashMap;
import java.util.Map;

import static elemental2.dom.DomGlobal.window;

public class MediaQuery {

    private static final String XLARGE_MEDIA_QUERY = "(min-width: 1800px)";
    private static final String LARGE_MEDIA_QUERY = "(min-width: 1200px) and (max-width: 1800px)";
    private static final String MEDIUM_MEDIA_QUERY = "(min-width: 992px) and (max-width: 1200px)";
    private static final String SMALL_MEDIA_QUERY = "(min-width: 768px) and (max-width: 992px)";
    private static final String XSMALL_MEDIA_QUERY = "(max-width: 768px)";

    private static final String XLARGE_AND_UP_MEDIA_QUERY = "(min-width: 1800px)";
    private static final String LARGE_AND_UP_MEDIA_QUERY = "(min-width: 1200px)";
    private static final String MEDIUM_AND_UP_MEDIA_QUERY = "(min-width: 992px)";
    private static final String SMALL_AND_UP_MEDIA_QUERY = "(min-width: 768px)";
    private static final String XSMALL_AND_UP_MEDIA_QUERY = "(min-width: 0x)";

    private static final String XLARGE_AND_DOWN_MEDIA_QUERY = "(max-width: 1800px)";
    private static final String LARGE_AND_DOWN_MEDIA_QUERY = "(max-width: 1800px)";
    private static final String MEDIUM_AND_DPOWN_MEDIA_QUERY = "(max-width: 1200px)";
    private static final String SMALL_AND_DOWN_MEDIA_QUERY = "(max-width: 992px)";
    private static final String XSMALL_AND_DOWN_MEDIA_QUERY = "(max-width: 768px)";

    private static MediaQueryList xlargeMediaQueryList = window.matchMedia(XLARGE_MEDIA_QUERY);
    private static MediaQueryList largeMediaQueryList = window.matchMedia(LARGE_MEDIA_QUERY);
    private static MediaQueryList mediumMediaQueryList = window.matchMedia(MEDIUM_MEDIA_QUERY);
    private static MediaQueryList smallMediaQueryList = window.matchMedia(SMALL_MEDIA_QUERY);
    private static MediaQueryList xsmallMediaQueryList = window.matchMedia(XSMALL_MEDIA_QUERY);

    private static MediaQueryList xlargeAndUpMediaQueryList = window.matchMedia(XLARGE_AND_UP_MEDIA_QUERY);
    private static MediaQueryList largeAndUpMediaQueryList = window.matchMedia(LARGE_AND_UP_MEDIA_QUERY);
    private static MediaQueryList mediumAndUpMediaQueryList = window.matchMedia(MEDIUM_AND_UP_MEDIA_QUERY);
    private static MediaQueryList smallAndUpMediaQueryList = window.matchMedia(SMALL_AND_UP_MEDIA_QUERY);
    private static MediaQueryList xsmallAndUpMediaQueryList = window.matchMedia(XSMALL_AND_UP_MEDIA_QUERY);

    private static MediaQueryList xlargeAndDownMediaQueryList = window.matchMedia(XLARGE_AND_DOWN_MEDIA_QUERY);
    private static MediaQueryList largeAndDownMediaQueryList = window.matchMedia(LARGE_AND_DOWN_MEDIA_QUERY);
    private static MediaQueryList mediumAndDownMediaQueryList = window.matchMedia(MEDIUM_AND_DPOWN_MEDIA_QUERY);
    private static MediaQueryList smallAndDownMediaQueryList = window.matchMedia(SMALL_AND_DOWN_MEDIA_QUERY);
    private static MediaQueryList xsmallAndDownMediaQueryList = window.matchMedia(XSMALL_AND_DOWN_MEDIA_QUERY);


    private static Map<MediaQueryListener, MediaQueryListListener> listenersMap = new HashMap<>();
    private static Map<String, MediaQueryList> mediaQueries = new HashMap<>();

    public static void addOnXLargeListener(MediaQueryListener listener) {
        addListener(listener, xlargeMediaQueryList);
    }

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

    public static void addOnXLargeAndUpListener(MediaQueryListener listener) {
        addListener(listener, xlargeAndUpMediaQueryList);
    }

    public static void addOnLargeAndUpListener(MediaQueryListener listener) {
        addListener(listener, largeAndUpMediaQueryList);
    }

    public static void addOnMediumAndUpListener(MediaQueryListener listener) {
        addListener(listener, mediumAndUpMediaQueryList);
    }

    public static void addOnSmallAndUpListener(MediaQueryListener listener) {
        addListener(listener, smallAndUpMediaQueryList);
    }

    public static void addOnXSmallAndUpListener(MediaQueryListener listener) {
        addListener(listener, xsmallAndUpMediaQueryList);
    }

    public static void addPortraitOrientationListener(MediaQueryListener listener) {
        addCustomQueryListener("(orientation : portrait)", listener);
    }

    public static void addLandscapeOrientationListener(MediaQueryListener listener) {
        addCustomQueryListener("(orientation : landscape)", listener);
    }

    public static void addOnXLargeAndDownListener(MediaQueryListener listener) {
        addListener(listener, xlargeAndDownMediaQueryList);
    }

    public static void addOnLargeAndDownListener(MediaQueryListener listener) {
        addListener(listener, largeAndDownMediaQueryList);
    }

    public static void addOnMediumAndDownListener(MediaQueryListener listener) {
        addListener(listener, mediumAndDownMediaQueryList);
    }

    public static void addOnSmallAndDownListener(MediaQueryListener listener) {
        addListener(listener, smallAndDownMediaQueryList);
    }

    public static void addOnXSmallAndDownListener(MediaQueryListener listener) {
        addListener(listener, xsmallAndDownMediaQueryList);
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

    public static void removeOnXLargeListener(MediaQueryListener listener) {
        removeListener(listener, xlargeMediaQueryList);
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

    public static void removeOnXLargeAndUpListener(MediaQueryListener listener) {
        removeListener(listener, xlargeAndUpMediaQueryList);
    }

    public static void removeOnLargeAndUpListener(MediaQueryListener listener) {
        removeListener(listener, largeAndUpMediaQueryList);
    }

    public static void removeOnMediumAndUpListener(MediaQueryListener listener) {
        removeListener(listener, mediumAndUpMediaQueryList);
    }

    public static void removeOnSmallAndUpListener(MediaQueryListener listener) {
        removeListener(listener, smallAndUpMediaQueryList);
    }

    public static void removeOnXSmallAndUpListener(MediaQueryListener listener) {
        removeListener(listener, xsmallMediaQueryList);
    }


    public static void removeOnXLargeAndDownListener(MediaQueryListener listener) {
        removeListener(listener, xlargeAndDownMediaQueryList);
    }

    public static void removeOnLargeAndDownListener(MediaQueryListener listener) {
        removeListener(listener, largeAndDownMediaQueryList);
    }

    public static void removeOnMediumAndDownListener(MediaQueryListener listener) {
        removeListener(listener, mediumAndDownMediaQueryList);
    }

    public static void removeOnSmallAndDownListener(MediaQueryListener listener) {
        removeListener(listener, smallAndDownMediaQueryList);
    }

    public static void removeOnXSmallAndDownListener(MediaQueryListener listener) {
        removeListener(listener, xsmallAndDownMediaQueryList);
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
