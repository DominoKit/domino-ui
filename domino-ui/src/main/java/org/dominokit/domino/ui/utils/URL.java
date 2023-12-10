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

import elemental2.dom.Blob;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The {@code URL} class provides utility methods for working with URLs in the browser. This class
 * is based on the JavaScript URL API.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/URL">MDN Web API Reference -
 *     URL</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class URL {

  /**
   * Creates a URL for a given {@link Blob} object.
   *
   * @param blob The {@link Blob} object for which a URL is created.
   * @return A string representing the URL of the {@link Blob}.
   */
  public static native String createObjectURL(Blob blob);

  /**
   * Revokes a previously created object URL.
   *
   * @param url The URL to be revoked.
   */
  public static native void revokeObjectURL(String url);
}
