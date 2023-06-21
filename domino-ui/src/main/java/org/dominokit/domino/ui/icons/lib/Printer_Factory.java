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

/**
 * This is a generated class, please don't modify
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Printer_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Printer tagIcons = new Printer() {};

  static {
    icons.add(() -> tagIcons.cloud_print_printer());
    icons.add(() -> tagIcons.cloud_print_outline_printer());
    icons.add(() -> tagIcons.fax_printer());
    icons.add(() -> tagIcons.paper_roll_printer());
    icons.add(() -> tagIcons.paper_roll_outline_printer());
    icons.add(() -> tagIcons.printer_printer());
    icons.add(() -> tagIcons.printer_3d_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_alert_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_alert_outline_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_heat_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_heat_outline_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_off_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_off_outline_printer());
    icons.add(() -> tagIcons.printer_3d_nozzle_outline_printer());
    icons.add(() -> tagIcons.printer_3d_off_printer());
    icons.add(() -> tagIcons.printer_alert_printer());
    icons.add(() -> tagIcons.printer_check_printer());
    icons.add(() -> tagIcons.printer_eye_printer());
    icons.add(() -> tagIcons.printer_off_printer());
    icons.add(() -> tagIcons.printer_off_outline_printer());
    icons.add(() -> tagIcons.printer_outline_printer());
    icons.add(() -> tagIcons.printer_pos_printer());
    icons.add(() -> tagIcons.printer_pos_alert_printer());
    icons.add(() -> tagIcons.printer_pos_alert_outline_printer());
    icons.add(() -> tagIcons.printer_pos_cancel_printer());
    icons.add(() -> tagIcons.printer_pos_cancel_outline_printer());
    icons.add(() -> tagIcons.printer_pos_check_printer());
    icons.add(() -> tagIcons.printer_pos_check_outline_printer());
    icons.add(() -> tagIcons.printer_pos_cog_printer());
    icons.add(() -> tagIcons.printer_pos_cog_outline_printer());
    icons.add(() -> tagIcons.printer_pos_edit_printer());
    icons.add(() -> tagIcons.printer_pos_edit_outline_printer());
    icons.add(() -> tagIcons.printer_pos_minus_printer());
    icons.add(() -> tagIcons.printer_pos_minus_outline_printer());
    icons.add(() -> tagIcons.printer_pos_network_printer());
    icons.add(() -> tagIcons.printer_pos_network_outline_printer());
    icons.add(() -> tagIcons.printer_pos_off_printer());
    icons.add(() -> tagIcons.printer_pos_off_outline_printer());
    icons.add(() -> tagIcons.printer_pos_outline_printer());
    icons.add(() -> tagIcons.printer_pos_pause_printer());
    icons.add(() -> tagIcons.printer_pos_pause_outline_printer());
    icons.add(() -> tagIcons.printer_pos_play_printer());
    icons.add(() -> tagIcons.printer_pos_play_outline_printer());
    icons.add(() -> tagIcons.printer_pos_plus_printer());
    icons.add(() -> tagIcons.printer_pos_plus_outline_printer());
    icons.add(() -> tagIcons.printer_pos_refresh_printer());
    icons.add(() -> tagIcons.printer_pos_refresh_outline_printer());
    icons.add(() -> tagIcons.printer_pos_remove_printer());
    icons.add(() -> tagIcons.printer_pos_remove_outline_printer());
    icons.add(() -> tagIcons.printer_pos_star_printer());
    icons.add(() -> tagIcons.printer_pos_star_outline_printer());
    icons.add(() -> tagIcons.printer_pos_stop_printer());
    icons.add(() -> tagIcons.printer_pos_stop_outline_printer());
    icons.add(() -> tagIcons.printer_pos_sync_printer());
    icons.add(() -> tagIcons.printer_pos_sync_outline_printer());
    icons.add(() -> tagIcons.printer_pos_wrench_printer());
    icons.add(() -> tagIcons.printer_pos_wrench_outline_printer());
    icons.add(() -> tagIcons.printer_search_printer());
    icons.add(() -> tagIcons.printer_settings_printer());
    icons.add(() -> tagIcons.printer_wireless_printer());
  }

  /** {@inheritDoc} */
  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
