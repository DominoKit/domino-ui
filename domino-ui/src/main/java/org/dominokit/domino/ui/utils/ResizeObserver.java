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
 * This class allows us to listen to the elements size changes
 *
 * <p>the class will register a {@link
 * org.dominokit.domino.ui.utils.ResizeObserver.ResizeObserverCallbackFn} on the element to be
 * called when its size is changed
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/ResizeObserver">MDN
 *     ResizeObserver</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserver {
  /** disconnect. */
  public native void disconnect();

  /**
   * observe.
   *
   * @param target a {@link elemental2.dom.Element} object
   * @param options a {@link org.dominokit.domino.ui.utils.ResizeObserverOptions} object
   */
  public native void observe(Element target, ResizeObserverOptions options);

  /**
   * unobserve.
   *
   * @param target a {@link elemental2.dom.Element} object
   */
  public native void unobserve(Element target);

  /**
   * observe.
   *
   * @param target a {@link elemental2.dom.Element} object
   */
  @JsOverlay
  public final void observe(Element target) {
    ResizeObserverOptions options = ResizeObserverOptions.create();
    options.box = ResizeObserverOptions.BoxUnionType.borderBox();
    observe(target, options);
  }

  @JsFunction
  public interface ResizeObserverCallbackFn {
    void onInvoke(JsArray<ResizeObserverEntry> entries);

    @JsOverlay
    default void onInvoke(ResizeObserverEntry[] entries) {
      onInvoke(Js.<JsArray<ResizeObserverEntry>>uncheckedCast(entries));
    }
  }

  /**
   * Constructor for ResizeObserver.
   *
   * @param callback a {@link org.dominokit.domino.ui.utils.ResizeObserver.ResizeObserverCallbackFn}
   *     object
   */
  public ResizeObserver(ResizeObserver.ResizeObserverCallbackFn callback) {}
}
