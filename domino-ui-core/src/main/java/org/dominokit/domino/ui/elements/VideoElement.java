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

import elemental2.dom.HTMLVideoElement;

/**
 * Represents an HTML <video> element wrapper.
 *
 * <p>The HTML <video> element is used to embed video content in a document, such as a movie clip or
 * other video streams. It is a container for one or more video tracks, which may include audio,
 * video, or other text content. Example usage:
 *
 * <pre>
 * HTMLVideoElement videoElement = ...;  // Obtain a <video> element from somewhere
 * VideoElement video = VideoElement.of(videoElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/video">MDN Web Docs
 *     (video)</a>
 */
public class VideoElement extends BaseElement<HTMLVideoElement, VideoElement> {

  /**
   * Creates a new {@link VideoElement} instance by wrapping the provided HTML <video> element.
   *
   * @param e The HTML <video> element to wrap.
   * @return A new {@link VideoElement} instance wrapping the provided element.
   */
  public static VideoElement of(HTMLVideoElement e) {
    return new VideoElement(e);
  }

  /**
   * Constructs a {@link VideoElement} instance by wrapping the provided HTML <video> element.
   *
   * @param element The HTML <video> element to wrap.
   */
  public VideoElement(HTMLVideoElement element) {
    super(element);
  }
}
