/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.dominokit.domino.ui.accessibility;

import static org.dominokit.domino.ui.utils.Domino.body;
import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Tooltip;

public class AnnouncementsAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testAlertsAndNotificationsAreAnnounced() {
    Alert alert = Alert.info();
    Notification notification = Notification.create("Saved");

    assertEquals("alert", alert.getAttribute("role"));
    assertEquals("status", notification.getAttribute("role"));
    assertEquals("polite", notification.getAttribute("aria-live"));
  }

  public void testTooltipHasTooltipRoleAndDescribesTarget() {
    DivElement target = div();
    Tooltip tooltip = Tooltip.create(target, "More information");

    assertEquals("tooltip", tooltip.getAttribute("role"));
    assertEquals(tooltip.getDominoId(), target.getAttribute("aria-describedby"));
    assertEquals("true", tooltip.getAttribute("aria-hidden"));
  }

  public void testTooltipOpensWhenTargetReceivesFocus() {
    DivElement target = div().setTabIndex(0);
    body().appendChild(target);
    Tooltip tooltip = Tooltip.create(target, "More information");

    target.element().focus();

    assertTrue(tooltip.element().parentNode != null);
    target.remove();
  }
}
