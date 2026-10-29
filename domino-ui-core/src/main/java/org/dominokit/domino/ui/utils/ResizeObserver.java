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

package org.dominokit.domino.ui.utils;

import elemental2.core.JsArray;
import elemental2.dom.Element;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * The {@code ResizeObserver} class is used to observe changes to the dimensions of DOM elements. It
 * allows you to track and respond to changes in the size of an element, such as when it is resized
 * by the user or when its content changes dynamically.
 *
 * <p>This class is designed to work with the Resize Observer API, which is used for observing
 * changes to the dimensions of elements.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserver {

  /**
   * Disconnects the {@code ResizeObserver} instance, stopping it from tracking changes in element
   * sizes.
   */
  public native void disconnect();

  /**
   * Begins observing the specified {@link Element} for size changes with optional configuration
   * options.
   *
   * @param target The DOM element to observe for size changes.
   * @param options Optional configuration options for the observation.
   */
  public native void observe(Element target, ResizeObserverOptions options);

  /**
   * Stops observing the specified {@link Element} for size changes.
   *
   * @param target The DOM element to stop observing.
   */
  public native void unobserve(Element target);

  /**
   * Begins observing the specified {@link Element} for size changes with default options.
   *
   * @param target The DOM element to observe for size changes.
   */
  @JsOverlay
  public final void observe(Element target) {
    ResizeObserverOptions options = ResizeObserverOptions.create();
    options.box = ResizeObserverOptions.BoxUnionType.borderBox();
    observe(target, options);
  }

  /**
   * A functional interface representing a callback function to be invoked when size changes are
   * observed.
   */
  @JsFunction
  public interface ResizeObserverCallbackFn {
    /**
     * Invoked when size changes are observed on the observed elements.
     *
     * @param entries An array of {@link ResizeObserverEntry} objects describing the observed size
     *     changes.
     */
    void onInvoke(JsArray<ResizeObserverEntry> entries);

    /**
     * Invoked when size changes are observed on the observed elements.
     *
     * @param entries An array of {@link ResizeObserverEntry} objects describing the observed size
     *     changes.
     */
    @JsOverlay
    default void onInvoke(ResizeObserverEntry[] entries) {
      onInvoke(Js.<JsArray<ResizeObserverEntry>>uncheckedCast(entries));
    }
  }

  /**
   * Constructs a {@code ResizeObserver} instance with the specified callback function.
   *
   * @param callback The callback function to be invoked when size changes are observed.
   */
  public ResizeObserver(ResizeObserver.ResizeObserverCallbackFn callback) {}
}
