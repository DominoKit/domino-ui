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
 * Factory class responsible for creating instances of different types of loaders.
 *
 * <p>The {@link LoaderFactory} provides a unified method to create loader instances based on the
 * desired visual effect as defined in the {@link LoaderEffect} enum.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * LoaderEffect effect = LoaderEffect.BOUNCE;
 * IsLoader loader = LoaderFactory.make(effect);
 * </pre>
 *
 * @author [Your Name]
 */
public class LoaderFactory {

  /**
   * Creates a new loader instance based on the specified loader effect.
   *
   * @param type The desired {@link LoaderEffect}.
   * @return An instance of the loader corresponding to the specified effect. Returns an instance of
   *     {@code NoneLoader} if an unrecognized effect is provided.
   */
  public static IsLoader make(LoaderEffect type) {
    switch (type) {
      case BOUNCE:
        return BounceLoader.create();
      case ROTATE_PLANE:
        return RotatePlaneLoader.create();
      case STRETCH:
        return StretchLoader.create();
      case ORBIT:
        return OrbitLoader.create();
      case ROUND_BOUNCE:
        return RoundBounceLoader.create();
      case WIN8:
        return Win8Loader.create();
      case WIN8_LINEAR:
        return Win8LinearLoader.create();
      case IOS:
        return IosLoader.create();
      case FACEBOOK:
        return FacebookLoader.create();
      case ROTATION:
        return RotationLoader.create();
      case TIMER:
        return TimerLoader.create();
      case PULSE:
        return PulseLoader.create();
      case PROGRESS_BAR:
        return ProgressBarLoader.create();
      case BOUNCE_PULSE:
        return BouncePulseLoader.create();
      default:
        return NoneLoader.create();
    }
  }
}
