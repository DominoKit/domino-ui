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

import elemental2.dom.HTMLTrackElement;

/**
 * Represents an HTML <track> element wrapper.
 *
 * <p>The HTML <track> element is used as a child of the <audio> and <video> elements to specify
 * text tracks for media elements. Text tracks can be used for subtitles, captions, chapter titles,
 * and other types of text-based information to be displayed along with the media content. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <track>
 * elements in web applications. Example usage:
 *
 * <pre>
 * HTMLTrackElement trackElement = ...;  // Obtain a <track> element from somewhere
 * TrackElement track = TrackElement.of(trackElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/track">MDN Web Docs
 *     (track)</a>
 */
public class TrackElement extends BaseElement<HTMLTrackElement, TrackElement> {

  /**
   * Creates a new {@link TrackElement} instance by wrapping the provided HTML <track> element.
   *
   * @param e The HTML <track> element to wrap.
   * @return A new {@link TrackElement} instance wrapping the provided element.
   */
  public static TrackElement of(HTMLTrackElement e) {
    return new TrackElement(e);
  }

  /**
   * Constructs a {@link TrackElement} instance by wrapping the provided HTML <track> element.
   *
   * @param element The HTML <track> element to wrap.
   */
  public TrackElement(HTMLTrackElement element) {
    super(element);
  }
}
