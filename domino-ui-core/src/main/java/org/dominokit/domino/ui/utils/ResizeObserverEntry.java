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
import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The {@code ResizeObserverEntry} class represents an entry for the {@link ResizeObserver}. It
 * contains information about the observed element's dimensions and properties after a resize or
 * change event.
 *
 * <p>This class is part of the Resize Observer API, which is used for observing changes to the
 * dimensions of elements. For more information about the Resize Observer API, refer to the <a
 * href="https://developer.mozilla.org/en-US/docs/Web/API/ResizeObserverEntry" target="_blank">MDN
 * documentation</a>.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ResizeObserverEntry {

  /**
   * An array of {@link ResizeObserverSize} objects representing the size of the observed element's
   * border box after the resize event.
   */
  public JsArray<ResizeObserverSize> borderBoxSize;

  /**
   * An array of {@link ResizeObserverSize} objects representing the size of the observed element's
   * content box after the resize event.
   */
  public JsArray<ResizeObserverSize> contentBoxSize;

  /**
   * A {@link DOMRect} object representing the size and position of the observed element's content
   * box after the resize event.
   */
  public DOMRect contentRect;

  /** The DOM {@link Element} that was observed and triggered the resize event. */
  public Element target;
}
