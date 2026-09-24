/*
 * Copyright © 2026 Dominokit
 * Licensed under the Apache License, Version 2.0.
 */
package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.LimitOneOfPrefixedCssClass;

public final class DynamicColor implements Color {
  private final String id;
  private final String suffix;
  private final String name;

  DynamicColor(String id, String suffix, String name) {
    this.id = id;
    this.suffix = suffix;
    this.name = name;
  }

  private String value() {
    return id + suffix;
  }

  @Override
  public CssClass getCss() {
    return () -> "dui-" + value();
  }

  @Override
  public String getName() {
    return name + suffix.toUpperCase().replace('-', '_');
  }

  @Override
  public CssClass getBackground() {
    return limited("dui-bg-");
  }

  @Override
  public CssClass getForeground() {
    return limited("dui-fg-");
  }

  @Override
  public CssClass getBorderColor() {
    return limited("dui-border-");
  }

  @Override
  public CssClass getAccentColor() {
    return limited("dui-accent-");
  }

  @Override
  public CssClass getContextColor() {
    return limited("dui-context-");
  }

  private CssClass limited(String prefix) {
    return LimitOneOfPrefixedCssClass.of(prefix, () -> prefix + value());
  }
}
