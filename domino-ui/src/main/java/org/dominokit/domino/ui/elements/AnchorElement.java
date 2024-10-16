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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLAnchorElement;

/**
 * Represents an anchor HTML element (`<a>`) wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of anchor
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLAnchorElement htmlElement = ...;  // Obtain an anchor element from somewhere
 * AnchorElement anchorElement = AnchorElement.of(htmlElement).setHref("https://example.com");
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">MDN Web Docs (anchor
 *     element)</a>
 */
public class AnchorElement extends BaseElement<HTMLAnchorElement, AnchorElement> {

  /**
   * Creates a new {@link AnchorElement} by wrapping the provided anchor HTML element.
   *
   * @param e The anchor HTML element.
   * @return A new {@link AnchorElement} that wraps the provided element.
   */
  public static AnchorElement of(HTMLAnchorElement e) {
    return new AnchorElement(e);
  }

  /**
   * Constructs an {@link AnchorElement} by wrapping the provided anchor HTML element.
   *
   * @param element The anchor HTML element to wrap.
   */
  public AnchorElement(HTMLAnchorElement element) {
    super(element);
  }

  /**
   * Sets the "href" attribute for the anchor element. If the provided href is null or empty, it
   * will remove the "href" attribute.
   *
   * @param href The URL the anchor element should link to.
   * @return The current {@link AnchorElement} instance.
   */
  public AnchorElement setHref(String href) {
    if (isNull(href) || href.trim().isEmpty()) {
      removeAttribute("href");
    } else {
      setAttribute("href", href);
    }
    return this;
  }

  /**
   * Removes the "href" attribute from the anchor element.
   *
   * @return The current {@link AnchorElement} instance.
   */
  public AnchorElement removeHref() {
    removeAttribute("href");
    return this;
  }

  /**
   * Sets the target for this href, if null or empty, remove the target attribute.
   *
   * @param target one of {@code _self}, {@code _blank}, {@code _parent}, {@code _top}, {@code
   *     _unfencedTop},
   * @return The current {@link AnchorElement} instance.
   */
  public AnchorElement setTarget(String target) {
    if (isNull(target) || target.trim().isEmpty()) {
      removeAttribute("target");
    } else {
      setAttribute("target", target);
    }
    return this;
  }

  /**
   * Sets the target for this href, if null or empty, remove the target attribute.
   *
   * @param target {@link AnchorTarget}
   * @return The current {@link AnchorElement} instance.
   */
  public AnchorElement setTarget(AnchorTarget target) {
    if (isNull(target)) {
      removeAttribute("target");
    } else {
      setAttribute("target", target.name());
    }
    return this;
  }

  public enum AnchorTarget {
    _self,
    _blank,
    _parent,
    _top,
    _unfencedTop;
  }
}
