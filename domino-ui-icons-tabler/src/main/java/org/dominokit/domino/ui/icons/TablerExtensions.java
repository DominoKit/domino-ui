/*
 * Copyright © 2026 Dominokit
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

/** Tabler Extensions catalog category. */
public interface TablerExtensions {
  enum OutlineIcon implements TablerIconDefinition {
    BMP(
        "bmp",
        "<path d=\"M18 16v-8h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M6 14a2 2 0 0 1 -2 2h-2v-8h2a2 2 0 1 1 0 4h-2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M9 16v-8l3 6l3 -6v8\" />"),
    CSV(
        "csv",
        "<path d=\"M10 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1\" />\n  <path d=\"M17 8l2 8l2 -8\" />\n  <path d=\"M7 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />"),
    GIF(
        "gif",
        "<path d=\"M8 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M16 12h3\" />\n  <path d=\"M20 8h-4v8\" />"),
    HTML(
        "html",
        "<path d=\"M13 16v-8l2 5l2 -5v8\" />\n  <path d=\"M1 16v-8\" />\n  <path d=\"M5 8v8\" />\n  <path d=\"M1 12h4\" />\n  <path d=\"M7 8h4\" />\n  <path d=\"M9 8v8\" />\n  <path d=\"M20 8v8h3\" />"),
    JPG(
        "jpg",
        "<path d=\"M21 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M10 16v-8h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M3 8h4v6a2 2 0 0 1 -2 2h-1.5a.5 .5 0 0 1 -.5 -.5v-.5\" />"),
    JSON(
        "json",
        "<path d=\"M20 16v-8l3 8v-8\" />\n  <path d=\"M15 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M1 8h3v6.5a1.5 1.5 0 0 1 -3 0v-.5\" />\n  <path d=\"M7 15a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1\" />"),
    PDF(
        "pdf",
        "<path d=\"M10 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M17 12h3\" />\n  <path d=\"M21 8h-4v8\" />"),
    PNG(
        "png",
        "<path d=\"M21 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M3 16v-8h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M10 16v-8l4 8v-8\" />"),
    SQL(
        "sql",
        "<path d=\"M12 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 8v8h4\" />\n  <path d=\"M13 15l1 1\" />\n  <path d=\"M3 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1\" />"),
    SVG(
        "svg",
        "<path d=\"M21 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M7 8h-3a1 1 0 0 0 -1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-3\" />\n  <path d=\"M10 8l1.5 8h1l1.5 -8\" />"),
    TOML(
        "toml",
        "<path d=\"M1.499 8h3\" />\n  <path d=\"M2.999 8v8\" />\n  <path d=\"M8.5 8a1.5 1.5 0 0 1 1.5 1.5v5a1.5 1.5 0 0 1 -3 0v-5a1.5 1.5 0 0 1 1.5 -1.5\" />\n  <path d=\"M13 16v-8l2 5l2 -5v8\" />\n  <path d=\"M20 8v8h2.5\" />"),
    TXT(
        "txt",
        "<path d=\"M3 8h4\" />\n  <path d=\"M5 8v8\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />\n  <path d=\"M10 8l4 8\" />\n  <path d=\"M10 16l4 -8\" />"),
    ZIP(
        "zip",
        "<path d=\"M16 16v-8h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M4 8h4l-4 8h4\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  enum FilledIcon implements TablerIconDefinition {
    ;

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "filled";
    }
  }

  default TablerIcon bmp() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.BMP);
  }

  default TablerIcon csv() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.CSV);
  }

  default TablerIcon gif() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.GIF);
  }

  default TablerIcon html() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.HTML);
  }

  default TablerIcon jpg() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.JPG);
  }

  default TablerIcon json() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.JSON);
  }

  default TablerIcon pdf() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.PDF);
  }

  default TablerIcon png() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.PNG);
  }

  default TablerIcon sql() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.SQL);
  }

  default TablerIcon svg() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.SVG);
  }

  default TablerIcon toml() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.TOML);
  }

  default TablerIcon txt() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.TXT);
  }

  default TablerIcon zip() {
    return TablerIcon.create(TablerExtensions.OutlineIcon.ZIP);
  }
}
