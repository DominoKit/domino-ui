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

import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The IntersectionObserverEntry interface of the Intersection Observer API describes the
 * intersection between the target element and its root container at a specific moment of
 * transition.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/IntersectionObserverEntry">MDN Web
 *     Docs (IntersectionObserverEntry)</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public interface IntersectionObserverEntry {

  @JsProperty
  DOMRect getBoundingClientRect();

  @JsProperty
  double getIntersectionRatio();

  @JsProperty
  DOMRect getIntersectionRect();

  @JsProperty
  boolean getIsIntersecting();

  @JsProperty
  boolean getIsVisible();

  @JsProperty
  DOMRect getRootBounds();

  @JsProperty
  Element getTarget();

  @JsProperty
  double getTime();
}
