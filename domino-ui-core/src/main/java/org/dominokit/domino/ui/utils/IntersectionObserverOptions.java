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
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * An optional object which customizes the observer. If options isn't specified, the observer uses
 * the document's viewport as the root, with no margin, and a 0% threshold (meaning that even a
 * one-pixel change is enough to trigger a callback). You can provide any combination of the
 * following options:
 *
 * @see <a
 *     href="https://developer.mozilla.org/en-US/docs/Web/API/IntersectionObserver/IntersectionObserver">MDN
 *     Web Docs (IntersectionObserver)</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class IntersectionObserverOptions {

  /**
   * Creates a new instance of {@code ResizeObserverOptions} with default settings.
   *
   * @return A {@code ResizeObserverOptions} instance with default settings.
   */
  @JsOverlay
  public static IntersectionObserverOptions create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  public Element root;
  public String rootMargin;
  public JsArray<Double> threshold;
}
