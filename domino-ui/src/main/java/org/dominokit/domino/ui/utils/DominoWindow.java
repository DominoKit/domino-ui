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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.Element;
import elemental2.dom.Window;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Extending {@link elemental2.dom.Window} to add functionality missing from elemental2 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public class DominoWindow extends Window {
  /**
   * getComputedStyle.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/getComputedStyle">MDN
   *     getComputedStyle</a>
   * @param element {@link elemental2.dom.Element}
   * @return the {@link elemental2.dom.CSSStyleDeclaration}
   */
  public native CSSStyleDeclaration getComputedStyle(Element element);
}
