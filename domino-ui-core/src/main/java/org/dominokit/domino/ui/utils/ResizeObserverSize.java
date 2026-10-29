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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The {@code ResizeObserverSize} class represents the size of an element in the context of a {@link
 * ResizeObserver} observation. It provides information about both the block size (height) and the
 * inline size (width) of the observed element.
 *
 * <p>This class is part of the Resize Observer API, which is used for observing changes to the
 * dimensions of elements. For more information about the Resize Observer API, refer to the <a
 * href="https://developer.mozilla.org/en-US/docs/Web/API/ResizeObserver" target="_blank">MDN
 * documentation</a>.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserverSize {

  /** The block size (height) of the observed element. */
  public double blockSize;

  /** The inline size (width) of the observed element. */
  public double inlineSize;
}
