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

import elemental2.dom.Element;
import elemental2.dom.HTMLDocument;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Extending {@link HTMLDocument} to add functionality missing from elemental2 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class DominoDocument extends HTMLDocument {
  /**
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/activeElement">MDN
   *     activeElement</a>
   */
  public Element activeElement;

  /**
   * @deprecated this is deprecated in MDN
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/execCommand">MDN
   *     execCommand</a>
   * @param aCommandName String
   * @param aShowDefaultUI boolean
   * @param aValueArgument String
   */
  @Deprecated
  public native void execCommand(
      String aCommandName, boolean aShowDefaultUI, String aValueArgument);

  /**
   * @deprecated this is deprecated in MDN
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/execCommand">MDN
   *     execCommand</a>
   * @param aCommandName String
   */
  @Deprecated
  public native void execCommand(String aCommandName);
}
