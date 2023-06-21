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
public class Religion_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Religion tagIcons = new Religion() {};

  static {
    icons.add(() -> tagIcons.book_cross_religion());
    icons.add(() -> tagIcons.church_religion());
    icons.add(() -> tagIcons.church_outline_religion());
    icons.add(() -> tagIcons.cross_religion());
    icons.add(() -> tagIcons.cross_bolnisi_religion());
    icons.add(() -> tagIcons.cross_celtic_religion());
    icons.add(() -> tagIcons.cross_outline_religion());
    icons.add(() -> tagIcons.dharmachakra_religion());
    icons.add(() -> tagIcons.khanda_religion());
    icons.add(() -> tagIcons.menorah_religion());
    icons.add(() -> tagIcons.menorah_fire_religion());
    icons.add(() -> tagIcons.mosque_religion());
    icons.add(() -> tagIcons.mosque_outline_religion());
    icons.add(() -> tagIcons.om_religion());
    icons.add(() -> tagIcons.shield_cross_religion());
    icons.add(() -> tagIcons.shield_cross_outline_religion());
    icons.add(() -> tagIcons.star_crescent_religion());
    icons.add(() -> tagIcons.star_david_religion());
    icons.add(() -> tagIcons.synagogue_religion());
    icons.add(() -> tagIcons.synagogue_outline_religion());
    icons.add(() -> tagIcons.temple_buddhist_religion());
    icons.add(() -> tagIcons.temple_buddhist_outline_religion());
    icons.add(() -> tagIcons.temple_hindu_religion());
    icons.add(() -> tagIcons.temple_hindu_outline_religion());
  }

  /** {@inheritDoc} */
  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
