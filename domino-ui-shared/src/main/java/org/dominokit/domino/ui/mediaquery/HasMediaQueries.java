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

/** HasMediaQueries interface. */
public interface HasMediaQueries<T> {

  /**
   * onXSmall.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXSmall(MediaQueryHandler<T> handler);

  /**
   * onXSmallAndDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXSmallAndDown(MediaQueryHandler<T> handler);

  /**
   * onXSmallAndUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXSmallAndUp(MediaQueryHandler<T> handler);

  /**
   * onSmall.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onSmall(MediaQueryHandler<T> handler);

  /**
   * onSmallAndDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onSmallAndDown(MediaQueryHandler<T> handler);

  /**
   * onSmallAndUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onSmallAndUp(MediaQueryHandler<T> handler);

  /**
   * onMedium.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onMedium(MediaQueryHandler<T> handler);

  /**
   * onMediumAndDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onMediumAndDown(MediaQueryHandler<T> handler);

  /**
   * onMediumAndUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onMediumAndUp(MediaQueryHandler<T> handler);

  /**
   * onLarge.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onLarge(MediaQueryHandler<T> handler);

  /**
   * onLargeAndDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onLargeAndDown(MediaQueryHandler<T> handler);

  /**
   * onLargeAndUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onLargeAndUp(MediaQueryHandler<T> handler);

  /**
   * onXLarge.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXLarge(MediaQueryHandler<T> handler);

  /**
   * onXLargeAndDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXLargeAndDown(MediaQueryHandler<T> handler);

  /**
   * onXLargeAndUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.mediaquery.MediaQueryHandler} object.
   * @return a T object.
   */
  T onXLargeAndUp(MediaQueryHandler<T> handler);
}
