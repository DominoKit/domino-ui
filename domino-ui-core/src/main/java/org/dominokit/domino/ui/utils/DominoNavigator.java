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

import elemental2.dom.Navigator;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** A custom wrapper for the {@link Navigator} class with additional functionality. */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Navigator")
public class DominoNavigator extends Navigator {

  /** The Clipboard object for working with the system clipboard. */
  public Clipboard clipboard;

  /**
   * Gets the Clipboard object for working with the system clipboard.
   *
   * @return The Clipboard object.
   */
  public native Clipboard getClipboard();
}
