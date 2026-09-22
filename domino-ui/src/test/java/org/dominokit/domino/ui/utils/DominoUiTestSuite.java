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

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.dominokit.domino.ui.accessibility.AccessibilityTest;
import org.dominokit.domino.ui.accessibility.AnnouncementsAccessibilityTest;
import org.dominokit.domino.ui.accessibility.CalendarAccessibilityTest;
import org.dominokit.domino.ui.accessibility.CompositeWidgetsAccessibilityTest;
import org.dominokit.domino.ui.accessibility.FormAccessibilityTest;
import org.dominokit.domino.ui.accessibility.InteractiveControlsAccessibilityTest;
import org.dominokit.domino.ui.accessibility.NavigationAccessibilityTest;
import org.dominokit.domino.ui.button.FabTest;
import org.dominokit.domino.ui.cards.CardTest;
import org.dominokit.domino.ui.dialogs.StandardDialogLayoutTest;
import org.dominokit.domino.ui.forms.DateBoxTypingModeTest;
import org.dominokit.domino.ui.forms.TimeBoxTypingModeTest;
import org.dominokit.domino.ui.forms.suggest.MultiSelectTest;
import org.dominokit.domino.ui.icons.IconTest;
import org.dominokit.domino.ui.layout.AppLayoutTest;
import org.dominokit.domino.ui.layout.NavBarTest;
import org.dominokit.domino.ui.layout.PageHeaderTest;
import org.dominokit.domino.ui.popover.TooltipTest;
import org.dominokit.domino.ui.style.FontThemingTest;
import org.dominokit.domino.ui.themes.DominoCssThemeTest;
import org.dominokit.domino.ui.themes.DominoThemeManagerTest;
import org.dominokit.domino.ui.themes.ElementThemeManagerTest;
import org.dominokit.domino.ui.themes.LegacyThemeCompatibilityTest;
import org.dominokit.domino.ui.themes.ThemeCatalogTest;
import org.dominokit.domino.ui.unitvalue.UnitValueTest;

public class DominoUiTestSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for client domino-ui");
    suite.addTestSuite(MatchHighlighterTest.class);
    suite.addTestSuite(DynamicCssDefinitionTest.class);
    suite.addTestSuite(DynamicCssRegistryTest.class);
    suite.addTestSuite(DynamicCssCssomTest.class);
    suite.addTestSuite(DominoDynamicColorTest.class);
    suite.addTestSuite(DynamicLayoutCssTest.class);
    suite.addTestSuite(DynamicAdvancedCssTest.class);
    suite.addTestSuite(DominoDynamicCssTest.class);
    suite.addTestSuite(CardTest.class);
    suite.addTestSuite(StandardDialogLayoutTest.class);
    suite.addTestSuite(FabTest.class);
    suite.addTestSuite(DateBoxTypingModeTest.class);
    suite.addTestSuite(TimeBoxTypingModeTest.class);
    suite.addTestSuite(MultiSelectTest.class);
    suite.addTestSuite(IconTest.class);
    suite.addTestSuite(AppLayoutTest.class);
    suite.addTestSuite(NavBarTest.class);
    suite.addTestSuite(PageHeaderTest.class);
    suite.addTestSuite(FontThemingTest.class);
    suite.addTestSuite(DominoThemeManagerTest.class);
    suite.addTestSuite(ElementThemeManagerTest.class);
    suite.addTestSuite(ThemeCatalogTest.class);
    suite.addTestSuite(DominoCssThemeTest.class);
    suite.addTestSuite(LegacyThemeCompatibilityTest.class);
    suite.addTestSuite(TooltipTest.class);
    suite.addTestSuite(AccessibilityTest.class);
    suite.addTestSuite(InteractiveControlsAccessibilityTest.class);
    suite.addTestSuite(CompositeWidgetsAccessibilityTest.class);
    suite.addTestSuite(FormAccessibilityTest.class);
    suite.addTestSuite(AnnouncementsAccessibilityTest.class);
    suite.addTestSuite(NavigationAccessibilityTest.class);
    suite.addTestSuite(CalendarAccessibilityTest.class);
    suite.addTestSuite(UnitValueTest.class);

    return suite;
  }
}
