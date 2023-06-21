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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.MdiIconsByTagFactory;

/** This is a generated class, please don't modify */
public class Color_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Color tagIcons = new Color() {};

  static {
    icons.add(() -> tagIcons.border_color_color());
    icons.add(() -> tagIcons.color_helper_color());
    icons.add(() -> tagIcons.eyedropper_color());
    icons.add(() -> tagIcons.eyedropper_variant_color());
    icons.add(() -> tagIcons.format_color_fill_color());
    icons.add(() -> tagIcons.format_color_highlight_color());
    icons.add(() -> tagIcons.format_color_marker_cancel_color());
    icons.add(() -> tagIcons.format_color_text_color());
    icons.add(() -> tagIcons.format_paint_color());
    icons.add(() -> tagIcons.invert_colors_color());
    icons.add(() -> tagIcons.invert_colors_off_color());
    icons.add(() -> tagIcons.looks_color());
    icons.add(() -> tagIcons.palette_color());
    icons.add(() -> tagIcons.palette_advanced_color());
    icons.add(() -> tagIcons.palette_outline_color());
    icons.add(() -> tagIcons.palette_swatch_color());
    icons.add(() -> tagIcons.palette_swatch_outline_color());
    icons.add(() -> tagIcons.palette_swatch_variant_color());
    icons.add(() -> tagIcons.select_color_color());
    icons.add(() -> tagIcons.spray_color());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
