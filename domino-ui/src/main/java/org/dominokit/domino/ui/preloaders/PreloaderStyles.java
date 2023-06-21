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
package org.dominokit.domino.ui.preloaders;

import org.dominokit.domino.ui.style.CssClass;

/**
 * A constants class for different preloader sizes
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface PreloaderStyles {
  /** Constant <code>dui_preloader</code> */
  CssClass dui_preloader = () -> "dui-preloader";
  /** Constant <code>dui_pl_spinner_layer</code> */
  CssClass dui_pl_spinner_layer = () -> "dui-pl-spinner-layer";
  /** Constant <code>dui_pl_circle_clipper</code> */
  CssClass dui_pl_circle_clipper = () -> "dui-pl-circle-clipper";
  /** Constant <code>dui_pl_circle_left</code> */
  CssClass dui_pl_circle_left = () -> "dui-pl-circle-left";
  /** Constant <code>dui_pl_circle_right</code> */
  CssClass dui_pl_circle_right = () -> "dui-pl-circle-right";
  /** Constant <code>dui_pl_right</code> */
  CssClass dui_pl_right = () -> "dui-pl-right";
}
