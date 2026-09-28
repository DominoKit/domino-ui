/*
 * Copyright © 2026 Dominokit
 * Licensed under the Apache License, Version 2.0.
 */
package org.dominokit.domino.ui.utils;

interface DynamicColorStyleSheet {
  boolean hasRule(String selector);

  String getPropertyValue(String selector, String property);

  void setProperty(String selector, String property, String value);
}
