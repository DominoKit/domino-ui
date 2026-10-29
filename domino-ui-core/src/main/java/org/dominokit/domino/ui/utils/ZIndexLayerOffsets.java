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

/** Core configuration for the z-index layer offsets. */
public final class ZIndexLayerOffsets {

  private static Provider provider = new Provider() {};

  private ZIndexLayerOffsets() {}

  public static int getZIndexLayerOffset_1() {
    return provider.getZIndexLayerOffset_1();
  }

  public static int getZIndexLayerOffset_2() {
    return provider.getZIndexLayerOffset_2();
  }

  public static int getZIndexLayerOffset_3() {
    return provider.getZIndexLayerOffset_3();
  }

  public static int getZIndexLayerOffset_4() {
    return provider.getZIndexLayerOffset_4();
  }

  public static void setProvider(Provider provider) {
    if (provider != null) {
      ZIndexLayerOffsets.provider = provider;
    }
  }

  /** Supplies the configured layer offsets. */
  public interface Provider {

    default int getZIndexLayerOffset_1() {
      return 110;
    }

    default int getZIndexLayerOffset_2() {
      return 5001000;
    }

    default int getZIndexLayerOffset_3() {
      return 10000000;
    }

    default int getZIndexLayerOffset_4() {
      return 20000000;
    }
  }
}
