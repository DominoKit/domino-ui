/*
 * Copyright © 2026 Dominokit
 * Licensed under the Apache License, Version 2.0.
 */
package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.CssClass;

public final class DynamicColorScheme implements ColorScheme {
  private final DynamicColor l5, l4, l3, l2, l1, color, d1, d2, d3, d4;

  DynamicColorScheme(String id, String name) {
    l5 = new DynamicColor(id, "-l-5", name);
    l4 = new DynamicColor(id, "-l-4", name);
    l3 = new DynamicColor(id, "-l-3", name);
    l2 = new DynamicColor(id, "-l-2", name);
    l1 = new DynamicColor(id, "-l-1", name);
    color = new DynamicColor(id, "", name);
    d1 = new DynamicColor(id, "-d-1", name);
    d2 = new DynamicColor(id, "-d-2", name);
    d3 = new DynamicColor(id, "-d-3", name);
    d4 = new DynamicColor(id, "-d-4", name);
  }

  @Override
  public Color lighten_5() {
    return l5;
  }

  @Override
  public Color lighten_4() {
    return l4;
  }

  @Override
  public Color lighten_3() {
    return l3;
  }

  @Override
  public Color lighten_2() {
    return l2;
  }

  @Override
  public Color lighten_1() {
    return l1;
  }

  @Override
  public DynamicColor color() {
    return color;
  }

  @Override
  public Color darker_1() {
    return d1;
  }

  @Override
  public Color darker_2() {
    return d2;
  }

  @Override
  public Color darker_3() {
    return d3;
  }

  @Override
  public Color darker_4() {
    return d4;
  }

  public CssClass getBackground() {
    return color.getBackground();
  }

  public CssClass getForeground() {
    return color.getForeground();
  }

  public CssClass getBorderColor() {
    return color.getBorderColor();
  }

  public CssClass getAccentColor() {
    return color.getAccentColor();
  }

  public CssClass getContextColor() {
    return color.getContextColor();
  }
}
