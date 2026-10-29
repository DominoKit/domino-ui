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
package org.dominokit.domino.ui.icons;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.icons.lib.Icons;

public class IconTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testIconAppearanceModifiersCanBeEnabledAndDisabled() {
    MdiIcon icon = Icons.close();

    icon.setSquare(true).setBordered(true).setSurface(true);

    assertHasClass(icon, "dui-icon");
    assertHasClass(icon, "dui-icon-square");
    assertHasClass(icon, "dui-icon-bordered");
    assertHasClass(icon, "dui-icon-surface");

    icon.setSquare(false).setBordered(false).setSurface(false);

    assertDoesNotHaveClass(icon, "dui-icon-square");
    assertDoesNotHaveClass(icon, "dui-icon-bordered");
    assertDoesNotHaveClass(icon, "dui-icon-surface");
  }

  private void assertHasClass(MdiIcon icon, String className) {
    assertTrue(hasClass(icon, className));
  }

  private void assertDoesNotHaveClass(MdiIcon icon, String className) {
    assertFalse(hasClass(icon, className));
  }

  private boolean hasClass(MdiIcon icon, String className) {
    String classes = " " + icon.element().className + " ";
    return classes.indexOf(" " + className + " ") >= 0;
  }
}
