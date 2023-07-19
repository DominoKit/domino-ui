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
public class View_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final View tagIcons = new View() {};

  static {
    icons.add(() -> tagIcons.apps_view());
    icons.add(() -> tagIcons.view_agenda_view());
    icons.add(() -> tagIcons.view_agenda_outline_view());
    icons.add(() -> tagIcons.view_array_view());
    icons.add(() -> tagIcons.view_array_outline_view());
    icons.add(() -> tagIcons.view_carousel_view());
    icons.add(() -> tagIcons.view_carousel_outline_view());
    icons.add(() -> tagIcons.view_column_view());
    icons.add(() -> tagIcons.view_column_outline_view());
    icons.add(() -> tagIcons.view_comfy_view());
    icons.add(() -> tagIcons.view_comfy_outline_view());
    icons.add(() -> tagIcons.view_compact_view());
    icons.add(() -> tagIcons.view_compact_outline_view());
    icons.add(() -> tagIcons.view_dashboard_view());
    icons.add(() -> tagIcons.view_dashboard_edit_view());
    icons.add(() -> tagIcons.view_dashboard_edit_outline_view());
    icons.add(() -> tagIcons.view_dashboard_outline_view());
    icons.add(() -> tagIcons.view_dashboard_variant_view());
    icons.add(() -> tagIcons.view_dashboard_variant_outline_view());
    icons.add(() -> tagIcons.view_day_view());
    icons.add(() -> tagIcons.view_day_outline_view());
    icons.add(() -> tagIcons.view_gallery_view());
    icons.add(() -> tagIcons.view_gallery_outline_view());
    icons.add(() -> tagIcons.view_grid_view());
    icons.add(() -> tagIcons.view_grid_outline_view());
    icons.add(() -> tagIcons.view_grid_plus_view());
    icons.add(() -> tagIcons.view_grid_plus_outline_view());
    icons.add(() -> tagIcons.view_headline_view());
    icons.add(() -> tagIcons.view_list_view());
    icons.add(() -> tagIcons.view_list_outline_view());
    icons.add(() -> tagIcons.view_module_view());
    icons.add(() -> tagIcons.view_module_outline_view());
    icons.add(() -> tagIcons.view_parallel_view());
    icons.add(() -> tagIcons.view_parallel_outline_view());
    icons.add(() -> tagIcons.view_quilt_view());
    icons.add(() -> tagIcons.view_quilt_outline_view());
    icons.add(() -> tagIcons.view_sequential_view());
    icons.add(() -> tagIcons.view_sequential_outline_view());
    icons.add(() -> tagIcons.view_split_horizontal_view());
    icons.add(() -> tagIcons.view_split_vertical_view());
    icons.add(() -> tagIcons.view_stream_view());
    icons.add(() -> tagIcons.view_stream_outline_view());
    icons.add(() -> tagIcons.view_week_view());
    icons.add(() -> tagIcons.view_week_outline_view());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
