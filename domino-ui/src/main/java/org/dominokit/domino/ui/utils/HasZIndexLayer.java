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

public interface HasZIndexLayer<T> {

  String DUI_Z_INDEX_LAYER = "dui-z-index-layer";

  ZIndexLayer getZIndexLayer();

  T setZIndexLayer(ZIndexLayer layer);

  void resetZIndexLayer();

  enum ZIndexLayer {
    Z_LAYER_1(110),
    Z_LAYER_2(5001000),
    Z_LAYER_3(10000000),
    Z_LAYER_4(20000000),
    ;

    private final int zIndexOffset;

    ZIndexLayer(int zIndexOffset) {
      this.zIndexOffset = zIndexOffset;
    }

    public int getzIndexOffset() {
      return zIndexOffset;
    }
  }
}
