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

package org.dominokit.domino.ui.mediaquery;

/**
 * An interface representing an object capable of responding to various media query breakpoints. It
 * allows the attachment of specific handlers for each breakpoint, ensuring responsive behavior
 * across different device sizes.
 *
 * @param <T> The type of the implementing class.
 */
public interface HasMediaQueries<T> {

  /**
   * Attaches a handler for the "extra small" media query breakpoint.
   *
   * @param handler The handler to be invoked at this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXSmall(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "extra small and down" media query
   * breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXSmallAndDown(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "extra small and up" media query
   * breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXSmallAndUp(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for the "small" media query breakpoint.
   *
   * @param handler The handler to be invoked at this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onSmall(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "small and down" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onSmallAndDown(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "small and up" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onSmallAndUp(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for the "medium" media query breakpoint.
   *
   * @param handler The handler to be invoked at this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onMedium(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "medium and down" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onMediumAndDown(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "medium and up" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onMediumAndUp(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for the "large" media query breakpoint.
   *
   * @param handler The handler to be invoked at this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onLarge(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "large and down" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onLargeAndDown(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "large and up" media query breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onLargeAndUp(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for the "extra large" media query breakpoint.
   *
   * @param handler The handler to be invoked at this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXLarge(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "extra large and down" media query
   * breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXLargeAndDown(MediaQueryHandler<T> handler);

  /**
   * Attaches a handler for devices that fall within the "extra large and up" media query
   * breakpoint.
   *
   * @param handler The handler to be invoked for this breakpoint.
   * @return The instance of the object implementing this interface.
   */
  T onXLargeAndUp(MediaQueryHandler<T> handler);
}
