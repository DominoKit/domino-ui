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

import org.dominokit.domino.ui.style.CssClass;

/**
 * CSS classes used by Domino UI loaders.
 *
 * <p>The {@code dui_waitme_*} classes map to the Domino UI-owned loader stylesheet.
 */
public interface LoaderStyles {

  CssClass dui_loader = () -> "dui-loader";
  CssClass dui_waitme_text = () -> "dui-waitme-text";
  CssClass dui_waitme_progress_element_1 = () -> "dui-waitme-progress-element-1";
  CssClass dui_waitme_progress_element_2 = () -> "dui-waitme-progress-element-2";
  CssClass dui_waitme_progress_element_3 = () -> "dui-waitme-progress-element-3";
  CssClass dui_waitme_progress_element_4 = () -> "dui-waitme-progress-element-4";
  CssClass dui_waitme_progress_element_5 = () -> "dui-waitme-progress-element-5";
  CssClass dui_waitme_progress_element_6 = () -> "dui-waitme-progress-element-6";
  CssClass dui_waitme_progress_element_7 = () -> "dui-waitme-progress-element-7";
  CssClass dui_waitme_progress_element_8 = () -> "dui-waitme-progress-element-8";
  CssClass dui_waitme_progress_element_9 = () -> "dui-waitme-progress-element-9";
  CssClass dui_waitme_progress_element_10 = () -> "dui-waitme-progress-element-10";
  CssClass dui_waitme_progress_element_11 = () -> "dui-waitme-progress-element-11";
  CssClass dui_waitme_progress_element_12 = () -> "dui-waitme-progress-element-12";
  CssClass dui_waitme = () -> "dui-waitme";
  CssClass dui_waitme_content = () -> "dui-waitme-content";
  CssClass dui_waitme_progress = () -> "dui-waitme-progress";
  CssClass dui_waitme_bounce = () -> "dui-waitme-bounce";
  CssClass dui_waitme_facebook = () -> "dui-waitme-facebook";
  CssClass dui_waitme_ios = () -> "dui-waitme-ios";
  CssClass dui_waitme_orbit = () -> "dui-waitme-orbit";
  CssClass dui_waitme_rotate_plane = () -> "dui-waitme-rotate-plane";
  CssClass dui_waitme_rotation = () -> "dui-waitme-rotation";
  CssClass dui_waitme_round_bounce = () -> "dui-waitme-round-bounce";
  CssClass dui_waitme_stretch = () -> "dui-waitme-stretch";
  CssClass dui_waitme_timer = () -> "dui-waitme-timer";
  CssClass dui_waitme_win_8_linear = () -> "dui-waitme-win-8-linear";
  CssClass dui_waitme_win_8 = () -> "dui-waitme-win-8";
  CssClass limit_viewport = () -> "limit-viewport";

  CssClass dui_waitme_pulse = () -> "dui-waitme-pulse";
  CssClass dui_waitme_vertical = () -> "dui-waitme-vertical";
  CssClass dui_waitme_progress_bar = () -> "dui-waitme-progress-bar";
  CssClass dui_waitme_bounce_pulse = () -> "dui-waitme-bounce-pulse";

  CssClass dui_waitme_container = () -> "dui-waitme-container";
  CssClass loading_top = () -> "loading-top";
  CssClass loading_middle = () -> "loading-middle";
  CssClass loading_bottom = () -> "loading-bottom";

  CssClass dui_loader_dark = () -> "dui-loader-dark";
  CssClass dui_loader_darker = () -> "dui-loader-darker";
  CssClass dui_loader_darkest = () -> "dui-loader-darkest";

  CssClass dui_loader_border_dark = () -> "dui-loader-border-dark";
  CssClass dui_loader_border_darker = () -> "dui-loader-border-darker";
  CssClass dui_loader_border_darkest = () -> "dui-loader-border-darkest";
}
