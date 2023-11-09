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

import elemental2.dom.HTMLAudioElement;

/**
 * Represents an audio HTML element (`<audio>`) wrapper.
 *
 * <p>The class provides a convenient way to create, manipulate, and control the behavior of audio
 * HTML elements. Example usage:
 *
 * <pre>{@code
 * HTMLAudioElement htmlElement = ...;  // Obtain an audio element from somewhere
 * AudioElement audioElement = AudioElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio">MDN Web Docs
 *     (audio element)</a>
 */
public class AudioElement extends BaseElement<HTMLAudioElement, AudioElement> {

  /**
   * Creates a new {@link AudioElement} by wrapping the provided audio HTML element.
   *
   * @param e The audio HTML element.
   * @return A new {@link AudioElement} that wraps the provided element.
   */
  public static AudioElement of(HTMLAudioElement e) {
    return new AudioElement(e);
  }

  /**
   * Constructs an {@link AudioElement} by wrapping the provided audio HTML element.
   *
   * @param element The audio HTML element to wrap.
   */
  public AudioElement(HTMLAudioElement element) {
    super(element);
  }
}
