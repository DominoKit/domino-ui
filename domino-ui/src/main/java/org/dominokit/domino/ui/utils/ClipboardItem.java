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

import elemental2.core.JsArray;
import elemental2.dom.Blob;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Represents an item that can be added to the clipboard. This class is a native JavaScript class
 * used for clipboard operations.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/ClipboardItem">MDN
 *     Documentation</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ClipboardItem {
  public ClipboardItem(JsArray<String> mimeTypes, Blob blob) {};
}
