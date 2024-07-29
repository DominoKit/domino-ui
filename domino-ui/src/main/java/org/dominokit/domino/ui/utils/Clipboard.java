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
import elemental2.dom.DomGlobal;
import elemental2.promise.Promise;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;

/**
 * A class for interacting with the clipboard to read and write data.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Clipboard_API" target="_blank">MDN
 *     Documentation</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Clipboard {

  /**
   * Reads data from the clipboard.
   *
   * @return A promise that resolves to a list of ClipboardItem objects.
   */
  public native Promise<JsArray<ClipboardItem>> read();

  /**
   * Reads text data from the clipboard.
   *
   * @return A promise that resolves to the text data from the clipboard.
   */
  public native Promise<String> readText();

  /**
   * Writes data to the clipboard.
   *
   * @param item The ClipboardItem to write to the clipboard.
   * @return A promise that resolves when the data is successfully written to the clipboard.
   */
  public native Promise<Any> write(ClipboardItem item);

  /**
   * Writes text data to the clipboard.
   *
   * @param text The text data to write to the clipboard.
   * @return A promise that resolves when the text data is successfully written to the clipboard.
   */
  public native Promise<Any> writeText(String text);

  @JsOverlay
  public static Promise<JsArray<ClipboardItem>> get() {
    return Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.read();
  }

  @JsOverlay
  public static Promise<String> getText() {
    return Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.readText();
  }

  @JsOverlay
  public static Promise<Any> put(ClipboardItem item) {
    return Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.write(item);
  }

  @JsOverlay
  public static Promise<Any> put(String text) {
    return Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.writeText(text);
  }
}
