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
package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLMapElement;

/**
 * Represents an HTML <map> element wrapper.
 *
 * <p>The HTML <map> element is used with <area> elements to define an image map. This class
 * provides a convenient way to create, manipulate, and control the behavior of <map> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLMapElement mapElement = ...;  // Obtain a <map> element from somewhere
 * MapElement map = MapElement.of(mapElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/map">MDN Web Docs
 *     (map)</a>
 */
public class MapElement extends BaseElement<HTMLMapElement, MapElement> {

  /**
   * Creates a new {@link MapElement} instance by wrapping the provided HTML <map> element.
   *
   * @param e The HTML <map> element to wrap.
   * @return A new {@link MapElement} instance wrapping the provided element.
   */
  public static MapElement of(HTMLMapElement e) {
    return new MapElement(e);
  }

  /**
   * Constructs a {@link MapElement} instance by wrapping the provided HTML <map> element.
   *
   * @param element The HTML <map> element to wrap.
   */
  public MapElement(HTMLMapElement element) {
    super(element);
  }
}
