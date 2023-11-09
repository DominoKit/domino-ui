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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * The {@code ResizeObserverOptions} class represents the options for configuring a {@link
 * ResizeObserver}. It allows you to specify the box model to be used for measuring the size of the
 * observed element.
 *
 * <p>This class is part of the Resize Observer API, which is used for observing changes to the
 * dimensions of elements. For more information about the Resize Observer API, refer to the <a
 * href="https://developer.mozilla.org/en-US/docs/Web/API/ResizeObserver" target="_blank">MDN
 * documentation</a>.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserverOptions {

  /**
   * Creates a new instance of {@code ResizeObserverOptions} with default settings.
   *
   * @return A {@code ResizeObserverOptions} instance with default settings.
   */
  @JsOverlay
  static ResizeObserverOptions create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  /**
   * The {@code BoxUnionType} interface represents the box model to be used for measuring the size
   * of the observed element. It is used as a property in {@link ResizeObserverOptions}.
   */
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface BoxUnionType {
    /**
     * Specifies that the "border-box" box model should be used for measurement.
     *
     * @return A {@code BoxUnionType} representing the "border-box" box model.
     */
    @JsOverlay
    static ResizeObserverOptions.BoxUnionType borderBox() {
      return Js.cast("border-box");
    }

    /**
     * Specifies that the "content-box" box model should be used for measurement.
     *
     * @return A {@code BoxUnionType} representing the "content-box" box model.
     */
    @JsOverlay
    static ResizeObserverOptions.BoxUnionType contentBox() {
      return Js.cast("content-box");
    }

    /**
     * Specifies that the "device-pixel-content-box" box model should be used for measurement.
     *
     * @return A {@code BoxUnionType} representing the "device-pixel-content-box" box model.
     */
    @JsOverlay
    static ResizeObserverOptions.BoxUnionType devicePixelContentBox() {
      return Js.cast("device-pixel-content-box");
    }
  }

  /**
   * The box model to be used for measuring the size of the observed element. It can be one of the
   * values defined in the {@link BoxUnionType} interface.
   */
  public ResizeObserverOptions.BoxUnionType box;
}
