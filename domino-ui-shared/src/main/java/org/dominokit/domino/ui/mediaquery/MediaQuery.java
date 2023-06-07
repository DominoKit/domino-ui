/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.mediaquery;

import static elemental2.dom.DomGlobal.window;

import elemental2.dom.EventTarget;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import java.util.HashMap;
import java.util.Map;
import jsinterop.base.Js;

/**
 * A utility class to add media query listeners
 *
 * <p>This component provides APIs for adding listeners for multiple media queries defined, each
 * listener will be called when media query is changed.
 *
 * <p>For example:
 *
 * <pre>
 *     MediaQuery.addOnXLargeListener(() -> {});
 *     MediaQuery.addOnLargeListener(() -> {});
 *     MediaQuery.addOnMediumListener(() -> {});
 *     MediaQuery.addOnSmallListener(() -> {});
 *     MediaQuery.addOnXSmallListener(() -> {});
 * </pre>
 *
 * <p>Media query sizes defined as follows:
 *
 * <ul>
 *   <li>{@code min-width} is larger than 1800px, the size is X large
 *   <li>{@code min-width} is between 1200px and 1800px, the size is large
 *   <li>{@code min-width} is between 992px and 1200px, the size is medium
 *   <li>{@code min-width} is between 768px and 992px, the size is small
 *   <li>{@code min-width} is less than 768px, the size is X small
 * </ul>
 */
public class MediaQuery {

  private static final String X_LARGE_MEDIA_QUERY = "(min-width: 1800px)";
  private static final String LARGE_MEDIA_QUERY = "(min-width: 1200px) and (max-width: 1800px)";
  private static final String MEDIUM_MEDIA_QUERY = "(min-width: 992px) and (max-width: 1200px)";
  private static final String SMALL_MEDIA_QUERY = "(min-width: 768px) and (max-width: 992px)";
  private static final String X_SMALL_MEDIA_QUERY = "(max-width: 768px)";

  private static final String X_LARGE_AND_UP_MEDIA_QUERY = "(min-width: 1800px)";
  private static final String LARGE_AND_UP_MEDIA_QUERY = "(min-width: 1200px)";
  private static final String MEDIUM_AND_UP_MEDIA_QUERY = "(min-width: 992px)";
  private static final String SMALL_AND_UP_MEDIA_QUERY = "(min-width: 768px)";
  private static final String X_SMALL_AND_UP_MEDIA_QUERY = "(min-width: 0px)";

  private static final String X_LARGE_AND_DOWN_MEDIA_QUERY = "(max-width: 1800px)";
  private static final String LARGE_AND_DOWN_MEDIA_QUERY = "(max-width: 1800px)";
  private static final String MEDIUM_AND_DOWN_MEDIA_QUERY = "(max-width: 1200px)";
  private static final String SMALL_AND_DOWN_MEDIA_QUERY = "(max-width: 992px)";
  private static final String X_SMALL_AND_DOWN_MEDIA_QUERY = "(max-width: 768px)";

  private static final MediaQueryList xLargeMediaQueryList = window.matchMedia(X_LARGE_MEDIA_QUERY);
  private static final MediaQueryList largeMediaQueryList = window.matchMedia(LARGE_MEDIA_QUERY);
  private static final MediaQueryList mediumMediaQueryList = window.matchMedia(MEDIUM_MEDIA_QUERY);
  private static final MediaQueryList smallMediaQueryList = window.matchMedia(SMALL_MEDIA_QUERY);
  private static final MediaQueryList xSmallMediaQueryList = window.matchMedia(X_SMALL_MEDIA_QUERY);

  private static final MediaQueryList xLargeAndUpMediaQueryList =
      window.matchMedia(X_LARGE_AND_UP_MEDIA_QUERY);
  private static final MediaQueryList largeAndUpMediaQueryList =
      window.matchMedia(LARGE_AND_UP_MEDIA_QUERY);
  private static final MediaQueryList mediumAndUpMediaQueryList =
      window.matchMedia(MEDIUM_AND_UP_MEDIA_QUERY);
  private static final MediaQueryList smallAndUpMediaQueryList =
      window.matchMedia(SMALL_AND_UP_MEDIA_QUERY);
  private static final MediaQueryList xSmallAndUpMediaQueryList =
      window.matchMedia(X_SMALL_AND_UP_MEDIA_QUERY);

  private static final MediaQueryList xLargeAndDownMediaQueryList =
      window.matchMedia(X_LARGE_AND_DOWN_MEDIA_QUERY);
  private static final MediaQueryList largeAndDownMediaQueryList =
      window.matchMedia(LARGE_AND_DOWN_MEDIA_QUERY);
  private static final MediaQueryList mediumAndDownMediaQueryList =
      window.matchMedia(MEDIUM_AND_DOWN_MEDIA_QUERY);
  private static final MediaQueryList smallAndDownMediaQueryList =
      window.matchMedia(SMALL_AND_DOWN_MEDIA_QUERY);
  private static final MediaQueryList xSmallAndDownMediaQueryList =
      window.matchMedia(X_SMALL_AND_DOWN_MEDIA_QUERY);

  private static final Map<MediaQueryListener, MediaQueryListListener> LISTENERS = new HashMap<>();
  private static final Map<String, MediaQueryList> MEDIA_QUERIES = new HashMap<>();

  /**
   * Adds listener when media query is X large
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXLargeListener(MediaQueryListener listener) {
    return addListener(listener, xLargeMediaQueryList);
  }

  /**
   * Adds listener when media query is large
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnLargeListener(MediaQueryListener listener) {
    return addListener(listener, largeMediaQueryList);
  }

  /**
   * Adds listener when media query is medium
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnMediumListener(MediaQueryListener listener) {
    return addListener(listener, mediumMediaQueryList);
  }

  /**
   * Adds listener when media query is small
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnSmallListener(MediaQueryListener listener) {
    return addListener(listener, smallMediaQueryList);
  }

  /**
   * Adds listener when media query is X small
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXSmallListener(MediaQueryListener listener) {
    return addListener(listener, xSmallMediaQueryList);
  }

  /**
   * Adds listener when media query is X large and more
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXLargeAndUpListener(MediaQueryListener listener) {
    return addListener(listener, xLargeAndUpMediaQueryList);
  }

  /**
   * Adds listener when media query is large and more
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnLargeAndUpListener(MediaQueryListener listener) {
    return addListener(listener, largeAndUpMediaQueryList);
  }

  /**
   * Adds listener when media query is medium and more
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnMediumAndUpListener(MediaQueryListener listener) {
    return addListener(listener, mediumAndUpMediaQueryList);
  }

  /**
   * Adds listener when media query is small and more
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnSmallAndUpListener(MediaQueryListener listener) {
    return addListener(listener, smallAndUpMediaQueryList);
  }

  /**
   * Adds listener when media query is X small and more
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXSmallAndUpListener(MediaQueryListener listener) {
    return addListener(listener, xSmallAndUpMediaQueryList);
  }

  /**
   * Adds listener when media query orientation is portrait
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addPortraitOrientationListener(MediaQueryListener listener) {
    return addCustomQueryListener("(orientation : portrait)", listener);
  }

  /**
   * Adds listener when media query orientation is landscape
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addLandscapeOrientationListener(MediaQueryListener listener) {
    return addCustomQueryListener("(orientation : landscape)", listener);
  }

  /**
   * Adds listener when media query is X large and less
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXLargeAndDownListener(MediaQueryListener listener) {
    return addListener(listener, xLargeAndDownMediaQueryList);
  }

  /**
   * Adds listener when media query is large and less
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnLargeAndDownListener(MediaQueryListener listener) {
    return addListener(listener, largeAndDownMediaQueryList);
  }

  /**
   * Adds listener when media query is medium and less
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnMediumAndDownListener(MediaQueryListener listener) {
    return addListener(listener, mediumAndDownMediaQueryList);
  }

  /**
   * Adds listener when media query is small and less
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnSmallAndDownListener(MediaQueryListener listener) {
    return addListener(listener, smallAndDownMediaQueryList);
  }

  /**
   * Adds listener when media query is X small and less
   *
   * @param listener A {@link MediaQueryListener}
   */
  public static MediaQueryListenerRecord addOnXSmallAndDownListener(MediaQueryListener listener) {
    return addListener(listener, xSmallAndDownMediaQueryList);
  }

  private static MediaQueryListenerRecord addListener(MediaQueryListener listener, MediaQueryList mediaQueryList) {
    MediaQueryListListener mediaQueryListListener =
        p0 -> {
          if (p0.matches) {
            listener.onMatch();
          }
        };
    mediaQueryList.addListener(mediaQueryListListener);
    LISTENERS.put(listener, mediaQueryListListener);
    mediaQueryListListener.onInvoke(mediaQueryList);
    return () -> removeListener(listener, mediaQueryList);
  }

  /**
   * Removes X large listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXLargeListener(MediaQueryListener listener) {
    removeListener(listener, xLargeMediaQueryList);
  }

  /**
   * Removes large listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnLargeListener(MediaQueryListener listener) {
    removeListener(listener, largeMediaQueryList);
  }

  /**
   * Removes medium listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnMediumListener(MediaQueryListener listener) {
    removeListener(listener, mediumMediaQueryList);
  }

  /**
   * Removes small listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnSmallListener(MediaQueryListener listener) {
    removeListener(listener, smallMediaQueryList);
  }

  /**
   * Removes X small listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXSmallListener(MediaQueryListener listener) {
    removeListener(listener, xSmallMediaQueryList);
  }

  /**
   * Removes X large and more listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXLargeAndUpListener(MediaQueryListener listener) {
    removeListener(listener, xLargeAndUpMediaQueryList);
  }

  /**
   * Removes large and more listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnLargeAndUpListener(MediaQueryListener listener) {
    removeListener(listener, largeAndUpMediaQueryList);
  }

  /**
   * Removes medium and more listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnMediumAndUpListener(MediaQueryListener listener) {
    removeListener(listener, mediumAndUpMediaQueryList);
  }

  /**
   * Removes small and more listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnSmallAndUpListener(MediaQueryListener listener) {
    removeListener(listener, smallAndUpMediaQueryList);
  }

  /**
   * Removes X small and more listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXSmallAndUpListener(MediaQueryListener listener) {
    removeListener(listener, xSmallMediaQueryList);
  }

  /**
   * Removes X large and less listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXLargeAndDownListener(MediaQueryListener listener) {
    removeListener(listener, xLargeAndDownMediaQueryList);
  }

  /**
   * Removes large and less listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnLargeAndDownListener(MediaQueryListener listener) {
    removeListener(listener, largeAndDownMediaQueryList);
  }

  /**
   * Removes medium and less listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnMediumAndDownListener(MediaQueryListener listener) {
    removeListener(listener, mediumAndDownMediaQueryList);
  }

  /**
   * Removes small and less listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnSmallAndDownListener(MediaQueryListener listener) {
    removeListener(listener, smallAndDownMediaQueryList);
  }

  /**
   * Removes X small and less listener
   *
   * @param listener the {@link MediaQueryListener} to remove
   */
  public static void removeOnXSmallAndDownListener(MediaQueryListener listener) {
    removeListener(listener, xSmallAndDownMediaQueryList);
  }

  private static void removeListener(MediaQueryListener listener, MediaQueryList mediaQueryList) {
    if (LISTENERS.containsKey(listener)) {
      mediaQueryList.removeListener(LISTENERS.get(listener));
      LISTENERS.remove(listener);
    }
  }

  /**
   * Adds media query listener with custom size based on the CSS conventions
   *
   * @param mediaQuery A text representing the custom query
   * @param listener A {@link MediaQueryListener} to add
   */
  public static MediaQueryListenerRecord addCustomQueryListener(String mediaQuery, MediaQueryListener listener) {
    if (!MEDIA_QUERIES.containsKey(mediaQuery)) {
      MediaQueryList mediaQueryList = window.matchMedia(mediaQuery);
      MEDIA_QUERIES.put(mediaQuery, mediaQueryList);
    }
    MediaQueryList mediaQueryList = Js.uncheckedCast(MEDIA_QUERIES.get(mediaQuery));
    addListener(listener, mediaQueryList);
    return () -> removeListener(listener, mediaQueryList);
  }

  /**
   * Removes custom media query listener
   *
   * @param mediaQuery A text representing the custom query
   * @param listener A {@link MediaQueryListener} to add
   */
  public static void removeCustomQueryListener(String mediaQuery, MediaQueryListener listener) {
    if (MEDIA_QUERIES.containsKey(mediaQuery)) {
      removeListener(listener, MEDIA_QUERIES.get(mediaQuery));
    }
  }

  /** A listener that will be called when media query matches */
  @FunctionalInterface
  public interface MediaQueryListener {
    /** on match the query */
    void onMatch();
  }
  /** A listener that will be called when media query matches */
  @FunctionalInterface
  public interface MediaQueryListenerRecord {
    /** on match the query */
    void remove();
  }
}
