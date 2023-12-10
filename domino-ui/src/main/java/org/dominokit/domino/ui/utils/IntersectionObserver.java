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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * provides a way to asynchronously observe changes in the intersection of a target element with an
 * ancestor element or with a top-level document's viewport.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/IntersectionObserver">MDN Web Docs
 *     (IntersectionObserver)</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class IntersectionObserver {

  /**
   * Disconnects the {@code IntersectionObserver} instance, stopping it from tracking changes in
   * element intersection.
   */
  public native void disconnect();

  /**
   * Begins observing the specified {@link Element} for intersection changes.
   *
   * @param target The DOM element to observe for intersection changes.
   */
  public native void observe(Element target);

  /**
   * Stops observing the specified {@link Element} for intersection changes.
   *
   * @param target The DOM element to stop observing.
   */
  public native void unobserve(Element target);

  public native JsArray<IntersectionObserverEntry> takeRecords();

  /**
   * A functional interface representing a callback function to be invoked when intersection changes
   * are observed.
   */
  @JsFunction
  public interface IntersectionObserverCallbackFn {
    /**
     * Invoked when element intersection with viewport is observed.
     *
     * @param entries An array of {@link IntersectionObserverEntry} objects describing the observed
     *     intersection changes.
     */
    void onInvoke(JsArray<IntersectionObserverEntry> entries);
  }

  /**
   * Constructs a {@code IntersectionObserver} instance with the specified callback function.
   *
   * @param callback The callback function to be invoked when size changes are observed.
   * @param options The {@link IntersectionObserverOptions} to configure the IntersectionObserver
   */
  public IntersectionObserver(
      IntersectionObserver.IntersectionObserverCallbackFn callback,
      IntersectionObserverOptions options) {}
}
