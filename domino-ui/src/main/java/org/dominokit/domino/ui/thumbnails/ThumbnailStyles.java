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
package org.dominokit.domino.ui.thumbnails;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS styles for {@link org.dominokit.domino.ui.thumbnails.Thumbnail} */
public interface ThumbnailStyles {
  /** Constant <code>dui_thumbnail</code> */
  CssClass dui_thumbnail = () -> "dui-thumbnail";
  /** Constant <code>dui_thumbnail_title</code> */
  CssClass dui_thumbnail_title = () -> "dui-thumbnail-title";
  /** Constant <code>dui_thumbnail_body</code> */
  CssClass dui_thumbnail_body = () -> "dui-thumbnail-body";
  /** Constant <code>dui_thumbnail_head</code> */
  CssClass dui_thumbnail_head = () -> "dui-thumbnail-head";
  /** Constant <code>dui_thumbnail_tail</code> */
  CssClass dui_thumbnail_tail = () -> "dui-thumbnail-tail";
  /** Constant <code>dui_thumbnail_footer</code> */
  CssClass dui_thumbnail_footer = () -> "dui-thumbnail-footer";
  /** Constant <code>dui_thumbnail_img</code> */
  CssClass dui_thumbnail_img = () -> "dui-thumbnail-img";
}
