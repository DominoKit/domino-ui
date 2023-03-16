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

/** A constants class for different preloader sizes */
public interface PreloaderStyles {
  CssClass dui_preloader = ()->"dui-preloader";
  CssClass dui_pl_spinner_layer = ()->"dui-pl-spinner-layer";
  CssClass dui_pl_circle_clipper = ()->"dui-pl-circle-clipper";
  CssClass dui_pl_circle_left = ()->"dui-pl-circle-left";
  CssClass dui_pl_circle_right = ()->"dui-pl-circle-right";
  CssClass dui_pl_right = ()->"dui-pl-right";
}
