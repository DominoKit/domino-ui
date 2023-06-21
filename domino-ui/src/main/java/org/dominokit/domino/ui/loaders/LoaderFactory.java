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
 * A factory for creating loaders based on their type
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class LoaderFactory {

  /**
   * make.
   *
   * @param type a {@link org.dominokit.domino.ui.loaders.LoaderEffect} object
   * @return a {@link org.dominokit.domino.ui.loaders.IsLoader} object
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
