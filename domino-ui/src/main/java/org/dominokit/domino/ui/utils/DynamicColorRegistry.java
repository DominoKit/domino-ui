/*
 * Copyright © 2026 Dominokit
 * Licensed under the Apache License, Version 2.0.
 */
package org.dominokit.domino.ui.utils;

import java.util.HashMap;
import java.util.Map;

final class DynamicColorRegistry {
  static final String STYLE_ELEMENT_ID = "dui-dynamic-colors";
  private static final String LIGHT = "body.dui.dui-colors-light";
  private static final String DARK = "body.dui.dui-colors-dark";
  private static DynamicColorRegistry instance;
  private final DynamicColorStyleSheet sheet;
  private final Map<String, DynamicColorScheme> schemes = new HashMap<>();
  private final Map<String, String> ids = new HashMap<>();

  private DynamicColorRegistry() {
    this(new CssomDynamicColorStyleSheet());
  }

  DynamicColorRegistry(DynamicColorStyleSheet sheet) {
    this.sheet = sheet;
  }

  static DynamicColorRegistry get() {
    return instance == null ? instance = new DynamicColorRegistry() : instance;
  }

  static void reset() {
    instance = null;
  }

  DynamicColorScheme colorScheme(String source) {
    DynamicColorScheme existing = schemes.get(source);
    if (existing != null) return existing;
    String ref = referenceName(source);
    String id = ref == null ? literalId(source) : ref;
    String name = "DYNAMIC_" + id.toUpperCase().replace('-', '_');
    DynamicColorScheme scheme = new DynamicColorScheme(id, name);
    Palette palette = ref == null ? literalPalette(id, source, LIGHT) : referencePalette(id);
    if (ref == null) {
      emitPalette(LIGHT, palette);
      emitPalette(DARK, literalPalette(id, "color-mix(in srgb, " + source + " 70%, black)", DARK));
    }
    emitUtilities(id, palette);
    schemes.put(source, scheme);
    return scheme;
  }

  private String referenceName(String source) {
    String prefix = "var(--dui-clr-";
    return source != null && source.startsWith(prefix) && source.endsWith(")")
        ? source.substring(prefix.length(), source.length() - 1)
        : null;
  }

  private String literalId(String source) {
    String base =
        "dyn-" + Integer.toString(String.valueOf(source).hashCode(), 36).replace('-', 'n');
    String id = base;
    int suffix = 2;
    while (ids.containsKey(id) && !String.valueOf(source).equals(ids.get(id)))
      id = base + "-" + suffix++;
    ids.put(id, String.valueOf(source));
    return id;
  }

  private Palette literalPalette(String id, String base, String selector) {
    return new Palette(
        id,
        mix(base, 10, "white"),
        mix(base, 25, "white"),
        mix(base, 40, "white"),
        mix(base, 60, "white"),
        mix(base, 80, "white"),
        base,
        mix(base, 88, "black"),
        mix(base, 76, "black"),
        mix(base, 64, "black"),
        mix(base, 52, "black"),
        "var(--dui-color)");
  }

  private Palette referencePalette(String id) {
    String root = "--dui-clr-" + id;
    return new Palette(
        id,
        "var(" + root + "-l-5)",
        "var(" + root + "-l-4)",
        "var(" + root + "-l-3)",
        "var(" + root + "-l-2)",
        "var(" + root + "-l-1)",
        "var(" + root + ")",
        "var(" + root + "-d-1)",
        "var(" + root + "-d-2)",
        "var(" + root + "-d-3)",
        "var(" + root + "-d-4)",
        "var(--dui-" + id + "-fg-clr)");
  }

  private String mix(String base, int percent, String other) {
    return "color-mix(in srgb, " + base + " " + percent + "%, " + other + ")";
  }

  private void emitPalette(String selector, Palette p) {
    String root = "--dui-clr-" + p.id;
    String[] suffixes = {
      "-l-5", "-l-4", "-l-3", "-l-2", "-l-1", "", "-d-1", "-d-2", "-d-3", "-d-4"
    };
    String[] values = {p.l5, p.l4, p.l3, p.l2, p.l1, p.base, p.d1, p.d2, p.d3, p.d4};
    for (int i = 0; i < suffixes.length; i++)
      sheet.setProperty(selector, root + suffixes[i], values[i]);
    sheet.setProperty(selector, "--dui-" + p.id + "-fg-clr", p.fg);
  }

  private void emitUtilities(String id, Palette p) {
    emitBaseColor(id, p);
    String[] suffixes = {
      "-l-5", "-l-4", "-l-3", "-l-2", "-l-1", "", "-d-1", "-d-2", "-d-3", "-d-4"
    };
    String[] values = {p.l5, p.l4, p.l3, p.l2, p.l1, p.base, p.d1, p.d2, p.d3, p.d4};
    for (int i = 0; i < suffixes.length; i++) emitUtility(id, suffixes[i], values[i], p);
  }

  private void emitBaseColor(String id, Palette p) {
    String base = ".dui.dui-" + id;
    set(base, "--dui-context-color", p.base);
    set(base, "--dui-bg-l-5", p.l5);
    set(base, "--dui-bg-l-4", p.l4);
    set(base, "--dui-bg-l-3", p.l3);
    set(base, "--dui-bg-l-2", p.l2);
    set(base, "--dui-bg-l-1", p.l1);
    set(base, "--dui-bg", p.base);
    set(base, "--dui-bg-d-1", p.d1);
    set(base, "--dui-bg-d-2", p.d2);
    set(base, "--dui-bg-d-3", p.d3);
    set(base, "--dui-bg-d-4", p.d4);
    set(base, "--dui-text-color", p.fg);
    set(base + ":not(.dui-ignore-bg)", "background-color", p.base);
    set(base + ":not(.dui-ignore-fg)", "color", "var(--dui-" + id + "-fg-clr)");
  }

  private void emitUtility(String id, String suffix, String color, Palette p) {
    String tail = id + suffix;
    set(".dui.dui-fg-" + tail, "--dui-fg-clr", color);
    set(".dui.dui-fg-" + tail, "--dui-text-color", "var(--dui-fg-clr)");
    set(".dui.dui-fg-" + tail, "color", color);
    set(".dui.dui-bg-" + tail, "--dui-bg-clr", color);
    set(".dui.dui-bg-" + tail, "--dui-text-color", p.fg);
    set(".dui.dui-bg-" + tail, "background-color", color);
    set(".dui.dui-border-" + tail, "--dui-border-clr", color);
    set(".dui.dui-border-" + tail, "border-color", color);
    set(".dui.dui-accent-" + tail, "--dui-accent-clr", color);
    set(".dui.dui-accent-" + tail, "--dui-accent-text-color", p.fg);
    set(".dui.dui-accent-" + tail, "accent-color", color);
    set(".dui.dui-shadow-" + tail, "--dui-shadow-clr", color);
    set(".dui.dui-text-decoration-" + tail, "text-decoration-color", color);
    for (String side : new String[] {"x", "y", "t", "r", "b", "l"})
      set(".dui.dui-border-" + side + "-" + tail, "border-color", color);
    set(".dui.dui-divide-" + tail + " > * + *", "border-color", color);
    set(".dui.dui-outline-" + tail, "outline-color", color);
    String context = ".dui.dui-context-" + tail;
    set(context, "--dui-context-color", color);
    set(context, "--dui-context-fg-color", p.fg);
    if (suffix.isEmpty()) {
      String[] ss = {"-l-5", "-l-4", "-l-3", "-l-2", "-l-1", "-d-1", "-d-2", "-d-3", "-d-4"};
      String[] vv = {p.l5, p.l4, p.l3, p.l2, p.l1, p.d1, p.d2, p.d3, p.d4};
      for (int i = 0; i < ss.length; i++) set(context, "--dui-context-color" + ss[i], vv[i]);
    }
    String accent = ".dui.dui-accent-" + tail;
    String[] ss = {"-l-5", "-l-4", "-l-3", "-l-2", "-l-1", "", "-d-1", "-d-2", "-d-3", "-d-4"};
    String[] vv = {p.l5, p.l4, p.l3, p.l2, p.l1, p.base, p.d1, p.d2, p.d3, p.d4};
    for (int i = 0; i < ss.length; i++) set(accent, "--dui-accent-source" + ss[i], vv[i]);
  }

  private void set(String selector, String property, String value) {
    sheet.setProperty(selector, property, value);
  }

  private static final class Palette {
    final String id, l5, l4, l3, l2, l1, base, d1, d2, d3, d4, fg;

    Palette(
        String id,
        String l5,
        String l4,
        String l3,
        String l2,
        String l1,
        String base,
        String d1,
        String d2,
        String d3,
        String d4,
        String fg) {
      this.id = id;
      this.l5 = l5;
      this.l4 = l4;
      this.l3 = l3;
      this.l2 = l2;
      this.l1 = l1;
      this.base = base;
      this.d1 = d1;
      this.d2 = d2;
      this.d3 = d3;
      this.d4 = d4;
      this.fg = fg;
    }
  }
}
