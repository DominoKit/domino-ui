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
 * Represents a handler for media query events. This is designed to respond to different media query
 * breakpoints and take appropriate actions on the provided element based on the active breakpoint.
 *
 * <p>This interface is intended to be used alongside the {@code HasMediaQueries} interface to
 * ensure responsive behavior across various device sizes.
 *
 * @param <T> The type of the element on which the media query is being applied.
 * @see HasMediaQueries
 */
@FunctionalInterface
public interface MediaQueryHandler<T> {

  /**
   * Invoked when the specified media query breakpoint is active. The method should contain the
   * logic for updating or manipulating the provided element based on the active breakpoint.
   *
   * @param element The element on which the media query is being applied.
   * @return A {@link MediaQuery.MediaQueryListener} instance which listens to changes in the media
   *     query.
   */
  MediaQuery.MediaQueryListener onMedia(T element);
}
