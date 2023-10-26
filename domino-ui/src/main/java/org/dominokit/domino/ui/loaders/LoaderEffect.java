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
package org.dominokit.domino.ui.loaders;

/**
 * Represents different visual effects that can be used with a loader.
 *
 * <p>Each enum constant corresponds to a unique loading effect. The specific visual appearance and
 * behavior of each effect is determined by the implementation in the respective loader.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * LoaderEffect effect = LoaderEffect.BOUNCE;
 * Loader loader = Loader.create(someElement, effect);
 * </pre>
 *
 * @author [Your Name]
 */
public enum LoaderEffect {

  /** Represents a bouncing effect. */
  BOUNCE,

  /** Represents a rotating plane effect. */
  ROTATE_PLANE,

  /** Represents a stretching effect. */
  STRETCH,

  /** Represents an orbit effect. */
  ORBIT,

  /** Represents a round bounce effect. */
  ROUND_BOUNCE,

  /** Represents the Windows 8 loader effect. */
  WIN8,

  /** Represents the linear Windows 8 loader effect. */
  WIN8_LINEAR,

  /** Represents an iOS-style loader effect. */
  IOS,

  /** Represents a Facebook-style loader effect. */
  FACEBOOK,

  /** Represents a continuous rotation effect. */
  ROTATION,

  /** Represents a timer effect. */
  TIMER,

  /** Represents a pulsing effect. */
  PULSE,

  /** Represents a progress bar effect. */
  PROGRESS_BAR,

  /** Represents a bouncing pulse effect. */
  BOUNCE_PULSE,

  /** Represents no effect. */
  NONE;
}
