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

public interface HasMediaQueries<T> {

  T onXSmall(MediaQueryHandler<T> handler);

  T onXSmallAndDown(MediaQueryHandler<T> handler);

  T onXSmallAndUp(MediaQueryHandler<T> handler);

  T onSmall(MediaQueryHandler<T> handler);

  T onSmallAndDown(MediaQueryHandler<T> handler);

  T onSmallAndUp(MediaQueryHandler<T> handler);

  T onMedium(MediaQueryHandler<T> handler);

  T onMediumAndDown(MediaQueryHandler<T> handler);

  T onMediumAndUp(MediaQueryHandler<T> handler);

  T onLarge(MediaQueryHandler<T> handler);

  T onLargeAndDown(MediaQueryHandler<T> handler);

  T onLargeAndUp(MediaQueryHandler<T> handler);

  T onXLarge(MediaQueryHandler<T> handler);

  T onXLargeAndDown(MediaQueryHandler<T> handler);

  T onXLargeAndUp(MediaQueryHandler<T> handler);
}
