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

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserverOptions {

  @JsOverlay
  static ResizeObserverOptions create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface BoxUnionType {
    @JsOverlay
    static ResizeObserverOptions.BoxUnionType borderBox() {
      return Js.cast("border-box");
    }

    @JsOverlay
    static ResizeObserverOptions.BoxUnionType contentBox() {
      return Js.cast("content-box");
    }

    @JsOverlay
    static ResizeObserverOptions.BoxUnionType devicePixelContentBox() {
      return Js.cast("device-pixel-content-box");
    }
  }

  public ResizeObserverOptions.BoxUnionType box;
}
