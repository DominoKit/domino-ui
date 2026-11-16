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

import static elemental2.dom.DomGlobal.requestAnimationFrame;
import static elemental2.dom.DomGlobal.setTimeout;

/** Schedules incremental dynamic CSS work at a browser frame boundary. */
interface DynamicCssFrameScheduler {

  void scheduleFrame(Runnable callback);

  static DynamicCssFrameScheduler browser() {
    return callback -> {
      try {
        requestAnimationFrame(timestamp -> callback.run());
      } catch (Throwable ignored) {
        timerFallback().scheduleFrame(callback);
      }
    };
  }

  static DynamicCssFrameScheduler timerFallback() {
    return callback -> setTimeout(timeoutId -> callback.run(), 0);
  }
}
